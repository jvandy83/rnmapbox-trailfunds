const fs = require('fs');
const path = require('path');

const androidDir = path.join(__dirname, 'android/src/main/java');
const oldArchDir = path.join(__dirname, 'android/src/main/old-arch');

// Find all Kotlin files
function findKotlinFiles(dir) {
  const files = [];
  const items = fs.readdirSync(dir);

  for (const item of items) {
    const fullPath = path.join(dir, item);
    const stat = fs.statSync(fullPath);

    if (stat.isDirectory()) {
      files.push(...findKotlinFiles(fullPath));
    } else if (item.endsWith('.kt')) {
      files.push(fullPath);
    }
  }

  return files;
}

// Parse interface file to get method names
function parseInterfaceFile(interfacePath) {
  if (!fs.existsSync(interfacePath)) {
    return new Set();
  }

  const content = fs.readFileSync(interfacePath, 'utf8');
  const methods = new Set();
  
  // Extract method names from interface
  const methodMatches = content.match(/void\s+(\w+)\s*\(/g);
  if (methodMatches) {
    methodMatches.forEach(match => {
      const methodName = match.replace(/void\s+(\w+)\s*\(/, '$1');
      methods.add(methodName);
    });
  }
  
  return methods;
}

// Get interface methods for a manager class
function getInterfaceMethods(managerClassName) {
  // Remove "Manager" suffix and add "Interface" suffix
  const interfaceName = managerClassName.replace(/Manager$/, 'ManagerInterface');
  const interfacePath = path.join(oldArchDir, 'com/facebook/react/viewmanagers', `${interfaceName}.java`);
  
  return parseInterfaceFile(interfacePath);
}

// Check if method needs override keyword
function needsOverride(methodName, className, content) {
  // Methods that are always overridden from ViewGroupManager
  const viewGroupManagerMethods = new Set([
    'getName',
    'createViewInstance',
    'onDropViewInstance',
    'getDelegate',
    'customEvents'
  ]);

  // Check if it's a ViewGroupManager method
  if (viewGroupManagerMethods.has(methodName)) {
    return true;
  }

  // Check if it's an interface method
  if (className.endsWith('Manager')) {
    const interfaceMethods = getInterfaceMethods(className);
    if (interfaceMethods.has(methodName)) {
      return true;
    }
  }

  return false;
}

// Add override keywords intelligently
function addOverrideKeywords(filePath) {
  if (!fs.existsSync(filePath)) {
    return false;
  }

  let content = fs.readFileSync(filePath, 'utf8');
  let modified = false;

  // Extract class name
  const classMatch = content.match(/class\s+(\w+)/);
  if (!classMatch) {
    return false;
  }
  const className = classMatch[1];

  // Find methods that need override
  const methodRegex = /fun\s+(\w+)\s*\(/g;
  let match;
  const methodsToOverride = [];

  while ((match = methodRegex.exec(content)) !== null) {
    const methodName = match[1];
    const methodStart = match.index;
    
    // Check if method already has override
    const beforeMethod = content.substring(0, methodStart);
    const hasOverride = beforeMethod.includes('override');
    
    if (!hasOverride && needsOverride(methodName, className, content)) {
      methodsToOverride.push({
        methodName,
        start: methodStart,
        match: match[0]
      });
    }
  }

  // Add override keywords (in reverse order to maintain positions)
  methodsToOverride.reverse().forEach(({ methodName, start, match }) => {
    const replacement = match.replace('fun ', 'override fun ');
    content = content.substring(0, start) + replacement + content.substring(start + match.length);
    modified = true;
  });

  if (modified) {
    fs.writeFileSync(filePath, content);
    const relativePath = path.relative(androidDir, filePath);
    console.log(`✓ Patched: ${relativePath}`);
    return true;
  }

  return false;
}

console.log('--- Adding missing override keywords to Android files (smart approach) ---');

const allKotlinFiles = findKotlinFiles(androidDir);
console.log(`Found ${allKotlinFiles.length} Kotlin files to check`);

let totalPatched = 0;
allKotlinFiles.forEach((filePath) => {
  if (addOverrideKeywords(filePath)) {
    totalPatched++;
  }
});

console.log(`\n--- Android override patching complete: ${totalPatched} files modified ---`); 