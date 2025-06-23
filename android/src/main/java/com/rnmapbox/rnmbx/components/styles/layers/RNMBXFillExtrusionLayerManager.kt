package com.rnmapbox.rnmbx.components.styles.layers

import com.facebook.react.bridge.Dynamic
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNMBXFillExtrusionLayerManagerInterface

class RNMBXFillExtrusionLayerManager : ViewGroupManager<RNMBXFillExtrusionLayer>(),
    RNMBXFillExtrusionLayerManagerInterface<RNMBXFillExtrusionLayer> {
    fun getName(): String {
        return REACT_CLASS
    }

    fun createViewInstance(reactContext: ThemedReactContext): RNMBXFillExtrusionLayer {
        return RNMBXFillExtrusionLayer(reactContext)
    }

    @ReactProp(name = "id")
    fun setId(layer: RNMBXFillExtrusionLayer, id: Dynamic) {
        layer.iD = id.asString()
    }

    @ReactProp(name = "existing")
    fun setExisting(layer: RNMBXFillExtrusionLayer, existing: Dynamic) {
        layer.setExisting(existing.asBoolean())
    }

    @ReactProp(name = "sourceID")
    fun setSourceID(layer: RNMBXFillExtrusionLayer, sourceID: Dynamic) {
        layer.setSourceID(sourceID.asString())
    }

    @ReactProp(name = "aboveLayerID")
    fun setAboveLayerID(layer: RNMBXFillExtrusionLayer, aboveLayerID: Dynamic) {
        layer.setAboveLayerID(aboveLayerID.asString())
    }

    @ReactProp(name = "belowLayerID")
    fun setBelowLayerID(layer: RNMBXFillExtrusionLayer, belowLayerID: Dynamic) {
        layer.setBelowLayerID(belowLayerID.asString())
    }

    @ReactProp(name = "layerIndex")
    fun setLayerIndex(layer: RNMBXFillExtrusionLayer, layerIndex: Dynamic) {
        layer.setLayerIndex(layerIndex.asInt())
    }

    @ReactProp(name = "minZoomLevel")
    fun setMinZoomLevel(layer: RNMBXFillExtrusionLayer, minZoomLevel: Dynamic) {
        layer.setMinZoomLevel(minZoomLevel.asDouble())
    }

    @ReactProp(name = "maxZoomLevel")
    fun setMaxZoomLevel(layer: RNMBXFillExtrusionLayer, maxZoomLevel: Dynamic) {
        layer.setMaxZoomLevel(maxZoomLevel.asDouble())
    }

    @ReactProp(name = "reactStyle")
    fun setReactStyle(layer: RNMBXFillExtrusionLayer, style: Dynamic) {
        layer.setReactStyle(style.asMap())
    }

    @ReactProp(name = "sourceLayerID")
    fun setSourceLayerID(layer: RNMBXFillExtrusionLayer, sourceLayerID: Dynamic) {
        layer.setSourceLayerID(sourceLayerID.asString())
    }

    @ReactProp(name = "filter")
    fun setFilter(layer: RNMBXFillExtrusionLayer, filterList: Dynamic) {
        layer.setFilter(filterList.asArray())
    }

    companion object {
        const val REACT_CLASS = "RNMBXFillExtrusionLayer"
    }
}