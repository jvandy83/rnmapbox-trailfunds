package com.rnmapbox.rnmbx.components.styles.layers

import com.facebook.react.bridge.Dynamic
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNMBXBackgroundLayerManagerInterface

class RNMBXBackgroundLayerManager : ViewGroupManager<RNMBXBackgroundLayer>(),
    RNMBXBackgroundLayerManagerInterface<RNMBXBackgroundLayer> {
    fun getName(): String {
        return REACT_CLASS
    }

    fun createViewInstance(reactContext: ThemedReactContext): RNMBXBackgroundLayer {
        return RNMBXBackgroundLayer(reactContext)
    }

    @ReactProp(name = "id")
    fun setId(layer: RNMBXBackgroundLayer, id: Dynamic) {
        layer.iD = id.asString()
    }

    @ReactProp(name = "existing")
    fun setExisting(layer: RNMBXBackgroundLayer, existing: Dynamic) {
        layer.setExisting(existing.asBoolean())
    }

    @ReactProp(name = "sourceID")
    fun setSourceID(layer: RNMBXBackgroundLayer, sourceID: Dynamic) {
        layer.setSourceID(sourceID.asString())
    }

    @ReactProp(name = "aboveLayerID")
    fun setAboveLayerID(layer: RNMBXBackgroundLayer, aboveLayerID: Dynamic) {
        layer.setAboveLayerID(aboveLayerID.asString())
    }

    @ReactProp(name = "belowLayerID")
    fun setBelowLayerID(layer: RNMBXBackgroundLayer, belowLayerID: Dynamic) {
        layer.setBelowLayerID(belowLayerID.asString())
    }

    @ReactProp(name = "layerIndex")
    fun setLayerIndex(layer: RNMBXBackgroundLayer, layerIndex: Dynamic) {
        layer.setLayerIndex(layerIndex.asInt())
    }

    @ReactProp(name = "minZoomLevel")
    fun setMinZoomLevel(layer: RNMBXBackgroundLayer, minZoomLevel: Dynamic) {
        layer.setMinZoomLevel(minZoomLevel.asDouble())
    }

    @ReactProp(name = "maxZoomLevel")
    fun setMaxZoomLevel(layer: RNMBXBackgroundLayer, maxZoomLevel: Dynamic) {
        layer.setMaxZoomLevel(maxZoomLevel.asDouble())
    }

    @ReactProp(name = "reactStyle")
    fun setReactStyle(layer: RNMBXBackgroundLayer, style: Dynamic) {
        layer.setReactStyle(style.asMap())
    }

    @ReactProp(name = "filter")
    fun setFilter(layer: RNMBXBackgroundLayer, filterList: Dynamic) {
        layer.setFilter(filterList.asArray())
    }

    companion object {
        const val REACT_CLASS = "RNMBXBackgroundLayer"
    }
}