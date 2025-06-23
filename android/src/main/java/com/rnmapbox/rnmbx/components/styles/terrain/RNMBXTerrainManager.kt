package com.rnmapbox.rnmbx.components.styles.terrain

import com.facebook.react.bridge.Dynamic
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNMBXTerrainManagerInterface

class RNMBXTerrainManager : ViewGroupManager<RNMBXTerrain>(),
    RNMBXTerrainManagerInterface<RNMBXTerrain> {
    fun getName(): String {
        return REACT_CLASS
    }

    fun createViewInstance(reactContext: ThemedReactContext): RNMBXTerrain {
        return RNMBXTerrain(reactContext)
    }

    @ReactProp(name = "sourceID")
    fun setSourceID(layer: RNMBXTerrain, sourceID: Dynamic) {
        layer.setSourceID(sourceID.asString())
    }

    @ReactProp(name = "reactStyle")
    fun setReactStyle(terrain: RNMBXTerrain, reactStyle: Dynamic) {
        terrain.setReactStyle(reactStyle.asMap())
    }

    companion object {
        const val REACT_CLASS = "RNMBXTerrain"
    }
}