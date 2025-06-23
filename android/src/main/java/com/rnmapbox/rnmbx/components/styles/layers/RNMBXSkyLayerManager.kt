package com.rnmapbox.rnmbx.components.styles.layers

import com.facebook.react.bridge.Dynamic
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNMBXSkyLayerManagerInterface

class RNMBXSkyLayerManager : ViewGroupManager<RNMBXSkyLayer>(),
    RNMBXSkyLayerManagerInterface<RNMBXSkyLayer> {
    fun getName(): String {
        return REACT_CLASS
    }

    fun createViewInstance(reactContext: ThemedReactContext): RNMBXSkyLayer {
        return RNMBXSkyLayer(reactContext)
    }

    @ReactProp(name = "id")
    fun setId(layer: RNMBXSkyLayer, id: Dynamic) {
        layer.iD = id.asString()
    }

    @ReactProp(name = "existing")
    fun setExisting(layer: RNMBXSkyLayer, existing: Dynamic) {
        layer.setExisting(existing.asBoolean())
    }

    @ReactProp(name = "sourceID")
    fun setSourceID(layer: RNMBXSkyLayer, sourceID: Dynamic) {
        layer.setSourceID(sourceID.asString())
    }

    @ReactProp(name = "aboveLayerID")
    fun setAboveLayerID(layer: RNMBXSkyLayer, aboveLayerID: Dynamic) {
        layer.setAboveLayerID(aboveLayerID.asString())
    }

    @ReactProp(name = "belowLayerID")
    fun setBelowLayerID(layer: RNMBXSkyLayer, belowLayerID: Dynamic) {
        layer.setBelowLayerID(belowLayerID.asString())
    }

    @ReactProp(name = "layerIndex")
    fun setLayerIndex(layer: RNMBXSkyLayer, layerIndex: Dynamic) {
        layer.setLayerIndex(layerIndex.asInt())
    }

    @ReactProp(name = "minZoomLevel")
    fun setMinZoomLevel(layer: RNMBXSkyLayer, minZoomLevel: Dynamic) {
        layer.setMinZoomLevel(minZoomLevel.asDouble())
    }

    @ReactProp(name = "maxZoomLevel")
    fun setMaxZoomLevel(layer: RNMBXSkyLayer, maxZoomLevel: Dynamic) {
        layer.setMaxZoomLevel(maxZoomLevel.asDouble())
    }

    @ReactProp(name = "reactStyle")
    fun setReactStyle(layer: RNMBXSkyLayer, style: Dynamic) {
        layer.setReactStyle(style.asMap())
    }

    @ReactProp(name = "filter")
    fun setFilter(layer: RNMBXSkyLayer, filterList: Dynamic) {
        layer.setFilter(filterList.asArray())
    }

    companion object {
        const val REACT_CLASS = "RNMBXSkyLayer"
    }
}