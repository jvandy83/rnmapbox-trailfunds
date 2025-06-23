package com.rnmapbox.rnmbx.components.styles.layers

import com.facebook.react.bridge.Dynamic
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNMBXSkyLayerManagerInterface

class RNMBXSkyLayerManager : ViewGroupManager<RNMBXSkyLayer>(),
    RNMBXSkyLayerManagerInterface<RNMBXSkyLayer> {
    override override fun getName(): String {
        return REACT_CLASS
    }

    override override fun createViewInstance(reactContext: ThemedReactContext): RNMBXSkyLayer {
        return RNMBXSkyLayer(reactContext)
    }

    @ReactProp(name = "id")
    override override fun setId(layer: RNMBXSkyLayer, id: Dynamic) {
        layer.iD = id.asString()
    }

    @ReactProp(name = "existing")
    override override fun setExisting(layer: RNMBXSkyLayer, existing: Dynamic) {
        layer.setExisting(existing.asBoolean())
    }

    @ReactProp(name = "sourceID")
    override override fun setSourceID(layer: RNMBXSkyLayer, sourceID: Dynamic) {
        layer.setSourceID(sourceID.asString())
    }

    @ReactProp(name = "aboveLayerID")
    override override fun setAboveLayerID(layer: RNMBXSkyLayer, aboveLayerID: Dynamic) {
        layer.setAboveLayerID(aboveLayerID.asString())
    }

    @ReactProp(name = "belowLayerID")
    override override fun setBelowLayerID(layer: RNMBXSkyLayer, belowLayerID: Dynamic) {
        layer.setBelowLayerID(belowLayerID.asString())
    }

    @ReactProp(name = "layerIndex")
    override override fun setLayerIndex(layer: RNMBXSkyLayer, layerIndex: Dynamic) {
        layer.setLayerIndex(layerIndex.asInt())
    }

    @ReactProp(name = "minZoomLevel")
    override override fun setMinZoomLevel(layer: RNMBXSkyLayer, minZoomLevel: Dynamic) {
        layer.setMinZoomLevel(minZoomLevel.asDouble())
    }

    @ReactProp(name = "maxZoomLevel")
    override override fun setMaxZoomLevel(layer: RNMBXSkyLayer, maxZoomLevel: Dynamic) {
        layer.setMaxZoomLevel(maxZoomLevel.asDouble())
    }

    @ReactProp(name = "reactStyle")
    override override fun setReactStyle(layer: RNMBXSkyLayer, style: Dynamic) {
        layer.setReactStyle(style.asMap())
    }

    @ReactProp(name = "filter")
    override override fun setFilter(layer: RNMBXSkyLayer, filterList: Dynamic) {
        layer.setFilter(filterList.asArray())
    }

    companion object {
        const val REACT_CLASS = "RNMBXSkyLayer"
    }
}