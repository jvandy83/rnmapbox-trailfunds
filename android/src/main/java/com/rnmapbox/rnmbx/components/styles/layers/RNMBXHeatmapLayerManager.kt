package com.rnmapbox.rnmbx.components.styles.layers

import com.facebook.react.bridge.Dynamic
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNMBXHeatmapLayerManagerInterface

class RNMBXHeatmapLayerManager : ViewGroupManager<RNMBXHeatmapLayer>(),
    RNMBXHeatmapLayerManagerInterface<RNMBXHeatmapLayer> {
    fun getName(): String {
        return REACT_CLASS
    }

    fun createViewInstance(reactContext: ThemedReactContext): RNMBXHeatmapLayer {
        return RNMBXHeatmapLayer(reactContext)
    }

    // @{codepart-replace-start(LayerManagerCommonProps.codepart-kt.ejs,{layerType:"RNMBXHeatmapLayer"})}
    @ReactProp(name = "id")
    fun setId(layer: RNMBXHeatmapLayer, id: Dynamic) {
        layer.iD = id.asString()
    }

    @ReactProp(name = "existing")
    fun setExisting(layer: RNMBXHeatmapLayer, existing: Dynamic) {
        layer.setExisting(existing.asBoolean())
    }

    @ReactProp(name = "sourceID")
    fun setSourceID(layer: RNMBXHeatmapLayer, sourceID: Dynamic) {
        layer.setSourceID(sourceID.asString())
    }

    @ReactProp(name = "aboveLayerID")
    fun setAboveLayerID(layer: RNMBXHeatmapLayer, aboveLayerID: Dynamic) {
        layer.setAboveLayerID(aboveLayerID.asString())
    }

    @ReactProp(name = "belowLayerID")
    fun setBelowLayerID(layer: RNMBXHeatmapLayer, belowLayerID: Dynamic) {
        layer.setBelowLayerID(belowLayerID.asString())
    }

    @ReactProp(name = "layerIndex")
    fun setLayerIndex(layer: RNMBXHeatmapLayer, layerIndex: Dynamic) {
        layer.setLayerIndex(layerIndex.asInt())
    }

    @ReactProp(name = "minZoomLevel")
    fun setMinZoomLevel(layer: RNMBXHeatmapLayer, minZoomLevel: Dynamic) {
        layer.setMinZoomLevel(minZoomLevel.asDouble())
    }

    @ReactProp(name = "maxZoomLevel")
    fun setMaxZoomLevel(layer: RNMBXHeatmapLayer, maxZoomLevel: Dynamic) {
        layer.setMaxZoomLevel(maxZoomLevel.asDouble())
    }

    @ReactProp(name = "reactStyle")
    fun setReactStyle(layer: RNMBXHeatmapLayer, style: Dynamic) {
        layer.setReactStyle(style.asMap())
    }

    @ReactProp(name = "sourceLayerID")
    fun setSourceLayerID(layer: RNMBXHeatmapLayer, sourceLayerID: Dynamic) {
        layer.setSourceLayerID(sourceLayerID.asString())
    }

    @ReactProp(name = "filter")
    fun setFilter(layer: RNMBXHeatmapLayer, filterList: Dynamic) {
        layer.setFilter(filterList.asArray())
    }

    @ReactProp(name = "slot")
    fun setSlot(layer: RNMBXHeatmapLayer, slot: Dynamic) {
        layer.setSlot(slot.asString())
    }
    // @{codepart-replace-end}

    companion object {
        const val REACT_CLASS = "RNMBXHeatmapLayer"
    }
}