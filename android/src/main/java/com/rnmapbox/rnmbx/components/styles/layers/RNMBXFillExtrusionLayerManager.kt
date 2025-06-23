package com.rnmapbox.rnmbx.components.styles.layers

import com.facebook.react.bridge.Dynamic
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNMBXFillExtrusionLayerManagerInterface

class RNMBXFillExtrusionLayerManager : ViewGroupManager<RNMBXFillExtrusionLayer>(),
    RNMBXFillExtrusionLayerManagerInterface<RNMBXFillExtrusionLayer> {
    override override fun getName(): String {
        return REACT_CLASS
    }

    override override fun createViewInstance(reactContext: ThemedReactContext): RNMBXFillExtrusionLayer {
        return RNMBXFillExtrusionLayer(reactContext)
    }

    @ReactProp(name = "id")
    override override fun setId(layer: RNMBXFillExtrusionLayer, id: Dynamic) {
        layer.iD = id.asString()
    }

    @ReactProp(name = "existing")
    override override fun setExisting(layer: RNMBXFillExtrusionLayer, existing: Dynamic) {
        layer.setExisting(existing.asBoolean())
    }

    @ReactProp(name = "sourceID")
    override override fun setSourceID(layer: RNMBXFillExtrusionLayer, sourceID: Dynamic) {
        layer.setSourceID(sourceID.asString())
    }

    @ReactProp(name = "aboveLayerID")
    override override fun setAboveLayerID(layer: RNMBXFillExtrusionLayer, aboveLayerID: Dynamic) {
        layer.setAboveLayerID(aboveLayerID.asString())
    }

    @ReactProp(name = "belowLayerID")
    override override fun setBelowLayerID(layer: RNMBXFillExtrusionLayer, belowLayerID: Dynamic) {
        layer.setBelowLayerID(belowLayerID.asString())
    }

    @ReactProp(name = "layerIndex")
    override override fun setLayerIndex(layer: RNMBXFillExtrusionLayer, layerIndex: Dynamic) {
        layer.setLayerIndex(layerIndex.asInt())
    }

    @ReactProp(name = "minZoomLevel")
    override override fun setMinZoomLevel(layer: RNMBXFillExtrusionLayer, minZoomLevel: Dynamic) {
        layer.setMinZoomLevel(minZoomLevel.asDouble())
    }

    @ReactProp(name = "maxZoomLevel")
    override override fun setMaxZoomLevel(layer: RNMBXFillExtrusionLayer, maxZoomLevel: Dynamic) {
        layer.setMaxZoomLevel(maxZoomLevel.asDouble())
    }

    @ReactProp(name = "reactStyle")
    override override fun setReactStyle(layer: RNMBXFillExtrusionLayer, style: Dynamic) {
        layer.setReactStyle(style.asMap())
    }

    @ReactProp(name = "sourceLayerID")
    override override fun setSourceLayerID(layer: RNMBXFillExtrusionLayer, sourceLayerID: Dynamic) {
        layer.setSourceLayerID(sourceLayerID.asString())
    }

    @ReactProp(name = "filter")
    override override fun setFilter(layer: RNMBXFillExtrusionLayer, filterList: Dynamic) {
        layer.setFilter(filterList.asArray())
    }

    companion object {
        const val REACT_CLASS = "RNMBXFillExtrusionLayer"
    }
}