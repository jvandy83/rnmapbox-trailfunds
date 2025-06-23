const fs = require('fs');
const path = require('path');

const androidDir = path.join(__dirname, 'android/src/main/java');

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

// Comprehensive list of methods that commonly need override keywords
const methodPatterns = [
  // ViewGroupManager methods
  { pattern: /fun getName\(/g, replacement: 'override fun getName(' },
  { pattern: /fun createViewInstance\(/g, replacement: 'override fun createViewInstance(' },
  { pattern: /fun onDropViewInstance\(/g, replacement: 'override fun onDropViewInstance(' },
  { pattern: /fun getDelegate\(/g, replacement: 'override fun getDelegate(' },
  { pattern: /fun getCommandsMap\(/g, replacement: 'override fun getCommandsMap(' },
  { pattern: /fun createShadowNodeInstance\(/g, replacement: 'override fun createShadowNodeInstance(' },
  { pattern: /fun getShadowNodeClass\(/g, replacement: 'override fun getShadowNodeClass(' },
  { pattern: /fun onAfterUpdateTransaction\(/g, replacement: 'override fun onAfterUpdateTransaction(' },
  { pattern: /fun addView\(/g, replacement: 'override fun addView(' },
  { pattern: /fun getChildCount\(/g, replacement: 'override fun getChildCount(' },
  { pattern: /fun getChildAt\(/g, replacement: 'override fun getChildAt(' },
  { pattern: /fun removeViewAt\(/g, replacement: 'override fun removeViewAt(' },
  { pattern: /fun removeView\(/g, replacement: 'override fun removeView(' },
  { pattern: /fun removeAllViews\(/g, replacement: 'override fun removeAllViews(' },
  { pattern: /fun dispose\(/g, replacement: 'override fun dispose(' },
  { pattern: /fun customEvents\(/g, replacement: 'override fun customEvents(' },

  // Interface methods (setters)
  { pattern: /fun setId\(/g, replacement: 'override fun setId(' },
  { pattern: /fun setUrl\(/g, replacement: 'override fun setUrl(' },
  { pattern: /fun setShape\(/g, replacement: 'override fun setShape(' },
  { pattern: /fun setCluster\(/g, replacement: 'override fun setCluster(' },
  { pattern: /fun setClusterRadius\(/g, replacement: 'override fun setClusterRadius(' },
  { pattern: /fun setClusterMaxZoomLevel\(/g, replacement: 'override fun setClusterMaxZoomLevel(' },
  { pattern: /fun setClusterProperties\(/g, replacement: 'override fun setClusterProperties(' },
  { pattern: /fun setMaxZoomLevel\(/g, replacement: 'override fun setMaxZoomLevel(' },
  { pattern: /fun setMinZoomLevel\(/g, replacement: 'override fun setMinZoomLevel(' },
  { pattern: /fun setBuffer\(/g, replacement: 'override fun setBuffer(' },
  { pattern: /fun setTolerance\(/g, replacement: 'override fun setTolerance(' },
  { pattern: /fun setLineMetrics\(/g, replacement: 'override fun setLineMetrics(' },
  { pattern: /fun setHasPressListener\(/g, replacement: 'override fun setHasPressListener(' },
  { pattern: /fun setHitbox\(/g, replacement: 'override fun setHitbox(' },
  { pattern: /fun setExisting\(/g, replacement: 'override fun setExisting(' },
  { pattern: /fun setSourceID\(/g, replacement: 'override fun setSourceID(' },
  { pattern: /fun setReactStyle\(/g, replacement: 'override fun setReactStyle(' },
  { pattern: /fun setCoordinates\(/g, replacement: 'override fun setCoordinates(' },
  { pattern: /fun setTileSize\(/g, replacement: 'override fun setTileSize(' },
  { pattern: /fun setCoordinate\(/g, replacement: 'override fun setCoordinate(' },
  { pattern: /fun setAnchor\(/g, replacement: 'override fun setAnchor(' },
  { pattern: /fun setDraggable\(/g, replacement: 'override fun setDraggable(' },
  { pattern: /fun setStop\(/g, replacement: 'override fun setStop(' },
  { pattern: /fun setDefaultStop\(/g, replacement: 'override fun setDefaultStop(' },
  { pattern: /fun setUserTrackingMode\(/g, replacement: 'override fun setUserTrackingMode(' },
  { pattern: /fun setZoomLevel\(/g, replacement: 'override fun setZoomLevel(' },
  { pattern: /fun setFollowUserLocation\(/g, replacement: 'override fun setFollowUserLocation(' },
  { pattern: /fun setFollowUserMode\(/g, replacement: 'override fun setFollowUserMode(' },
  { pattern: /fun setFollowZoomLevel\(/g, replacement: 'override fun setFollowZoomLevel(' },
  { pattern: /fun setFollowPitch\(/g, replacement: 'override fun setFollowPitch(' },
  { pattern: /fun setFollowHeading\(/g, replacement: 'override fun setFollowHeading(' },
  { pattern: /fun setFollowPadding\(/g, replacement: 'override fun setFollowPadding(' },
  { pattern: /fun setMaxBounds\(/g, replacement: 'override fun setMaxBounds(' },
  { pattern: /fun setAnimationDuration\(/g, replacement: 'override fun setAnimationDuration(' },
  { pattern: /fun setAnimationMode\(/g, replacement: 'override fun setAnimationMode(' },
  { pattern: /fun setTransitionsToIdleUponUserInteraction\(/g, replacement: 'override fun setTransitionsToIdleUponUserInteraction(' },
  { pattern: /fun setHasStatusChanged\(/g, replacement: 'override fun setHasStatusChanged(' },
  { pattern: /fun setName\(/g, replacement: 'override fun setName(' },
  { pattern: /fun setSdf\(/g, replacement: 'override fun setSdf(' },
  { pattern: /fun setStretchX\(/g, replacement: 'override fun setStretchX(' },
  { pattern: /fun setStretchY\(/g, replacement: 'override fun setStretchY(' },
  { pattern: /fun setContent\(/g, replacement: 'override fun setContent(' },
  { pattern: /fun setScale\(/g, replacement: 'override fun setScale(' },
  { pattern: /fun setImages\(/g, replacement: 'override fun setImages(' },
  { pattern: /fun setHasOnImageMissing\(/g, replacement: 'override fun setHasOnImageMissing(' },
  { pattern: /fun setNativeImages\(/g, replacement: 'override fun setNativeImages(' },
  { pattern: /fun setAndroidRenderMode\(/g, replacement: 'override fun setAndroidRenderMode(' },
  { pattern: /fun setPuckBearing\(/g, replacement: 'override fun setPuckBearing(' },
  { pattern: /fun setPuckBearingEnabled\(/g, replacement: 'override fun setPuckBearingEnabled(' },
  { pattern: /fun setTopImage\(/g, replacement: 'override fun setTopImage(' },
  { pattern: /fun setBearingImage\(/g, replacement: 'override fun setBearingImage(' },
  { pattern: /fun setShadowImage\(/g, replacement: 'override fun setShadowImage(' },
  { pattern: /fun setVisible\(/g, replacement: 'override fun setVisible(' },
  { pattern: /fun setPulsing\(/g, replacement: 'override fun setPulsing(' },
  { pattern: /fun setProjection\(/g, replacement: 'override fun setProjection(' },
  { pattern: /fun setLocalizeLabels\(/g, replacement: 'override fun setLocalizeLabels(' },
  { pattern: /fun setSurfaceView\(/g, replacement: 'override fun setSurfaceView(' },
  { pattern: /fun setGestureSettings\(/g, replacement: 'override fun setGestureSettings(' },
  { pattern: /fun setStyleURL\(/g, replacement: 'override fun setStyleURL(' },
  { pattern: /fun setZoomEnabled\(/g, replacement: 'override fun setZoomEnabled(' },
  { pattern: /fun setScrollEnabled\(/g, replacement: 'override fun setScrollEnabled(' },
  { pattern: /fun setPitchEnabled\(/g, replacement: 'override fun setPitchEnabled(' },
  { pattern: /fun setRotateEnabled\(/g, replacement: 'override fun setRotateEnabled(' },
  { pattern: /fun setAttributionEnabled\(/g, replacement: 'override fun setAttributionEnabled(' },
  { pattern: /fun setAttributionPosition\(/g, replacement: 'override fun setAttributionPosition(' },
  { pattern: /fun setAttributionViewMargins\(/g, replacement: 'override fun setAttributionViewMargins(' },
  { pattern: /fun setAttributionViewPosition\(/g, replacement: 'override fun setAttributionViewPosition(' },
  { pattern: /fun setLogoEnabled\(/g, replacement: 'override fun setLogoEnabled(' },
  { pattern: /fun setLogoPosition\(/g, replacement: 'override fun setLogoPosition(' },
  { pattern: /fun setScaleBarEnabled\(/g, replacement: 'override fun setScaleBarEnabled(' },
  { pattern: /fun setScaleBarViewMargins\(/g, replacement: 'override fun setScaleBarViewMargins(' },
  { pattern: /fun setScaleBarPosition\(/g, replacement: 'override fun setScaleBarPosition(' },
  { pattern: /fun setCompassEnabled\(/g, replacement: 'override fun setCompassEnabled(' },
  { pattern: /fun setCompassFadeWhenNorth\(/g, replacement: 'override fun setCompassFadeWhenNorth(' },
  { pattern: /fun setCompassViewMargins\(/g, replacement: 'override fun setCompassViewMargins(' },
  { pattern: /fun setCompassViewPosition\(/g, replacement: 'override fun setCompassViewPosition(' },
  { pattern: /fun setCompassPosition\(/g, replacement: 'override fun setCompassPosition(' },
  { pattern: /fun setRequestDisallowInterceptTouchEvent\(/g, replacement: 'override fun setRequestDisallowInterceptTouchEvent(' },
  { pattern: /fun setDeselectAnnotationOnTap\(/g, replacement: 'override fun setDeselectAnnotationOnTap(' },
  { pattern: /fun setMapViewImpl\(/g, replacement: 'override fun setMapViewImpl(' },
  { pattern: /fun setCompassImage\(/g, replacement: 'override fun setCompassImage(' },
  { pattern: /fun setConfig\(/g, replacement: 'override fun setConfig(' },
  { pattern: /fun setAboveLayerID\(/g, replacement: 'override fun setAboveLayerID(' },
  { pattern: /fun setBelowLayerID\(/g, replacement: 'override fun setBelowLayerID(' },
  { pattern: /fun setLayerIndex\(/g, replacement: 'override fun setLayerIndex(' },
  { pattern: /fun setSourceLayerID\(/g, replacement: 'override fun setSourceLayerID(' },
  { pattern: /fun setFilter\(/g, replacement: 'override fun setFilter(' },
  { pattern: /fun setSlot\(/g, replacement: 'override fun setSlot(' },
  { pattern: /fun setModels\(/g, replacement: 'override fun setModels(' },
  { pattern: /fun setHeading\(/g, replacement: 'override fun setHeading(' },

  // Location methods
  { pattern: /fun registerLocationConsumer\(/g, replacement: 'override fun registerLocationConsumer(' },
  { pattern: /fun unRegisterLocationConsumer\(/g, replacement: 'override fun unRegisterLocationConsumer(' },
  { pattern: /fun onSuccess\(/g, replacement: 'override fun onSuccess(' },
  { pattern: /fun onFailure\(/g, replacement: 'override fun onFailure(' },
  { pattern: /fun cancel\(/g, replacement: 'override fun cancel(' },
  { pattern: /fun onViewAnnotationVisibilityUpdated\(/g, replacement: 'override fun onViewAnnotationVisibilityUpdated(' },

  // Additional methods that might hide members
  { pattern: /fun setAllowOverlap\(/g, replacement: 'override fun setAllowOverlap(' },
  { pattern: /fun setAllowOverlapWithPuck\(/g, replacement: 'override fun setAllowOverlapWithPuck(' },
  { pattern: /fun setIsSelected\(/g, replacement: 'override fun setIsSelected(' },
];

function addOverrideKeywords(filePath) {
  if (!fs.existsSync(filePath)) {
    return false;
  }

  let content = fs.readFileSync(filePath, 'utf8');
  let modified = false;

  methodPatterns.forEach(({ pattern, replacement }) => {
    if (pattern.test(content)) {
      content = content.replace(pattern, replacement);
      modified = true;
    }
  });

  if (modified) {
    fs.writeFileSync(filePath, content);
    const relativePath = path.relative(androidDir, filePath);
    console.log(`✓ Patched: ${relativePath}`);
    return true;
  }

  return false;
}

console.log('--- Adding missing override keywords to Android files (comprehensive approach) ---');

const allKotlinFiles = findKotlinFiles(androidDir);
console.log(`Found ${allKotlinFiles.length} Kotlin files to check`);

let totalPatched = 0;
allKotlinFiles.forEach((filePath) => {
  if (addOverrideKeywords(filePath)) {
    totalPatched++;
  }
});

console.log(`\n--- Android override patching complete: ${totalPatched} files modified ---`); 