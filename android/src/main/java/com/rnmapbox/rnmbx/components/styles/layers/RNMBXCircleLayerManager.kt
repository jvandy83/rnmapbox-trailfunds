package com.rnmapbox.rnmbx.components.styles.layers

import com.facebook.react.bridge.Dynamic
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNMBXCircleLayerManagerInterface

class RNMBXCircleLayerManager : ViewGroupManager<RNMBXCircleLayer>(),
    RNMBXCircleLayerManagerInterface<RNMBXCircleLayer> {

    fun getName(): String {
        return REACT_CLASS
    }

    fun createViewInstance(reactContext: ThemedReactContext): RNMBXCircleLayer {
        return RNMBXCircleLayer(reactContext)
    }

    // @{codepart-replace-start(LayerManagerCommonProps.codepart-kt.ejs,{layerType:"RNMBXCircleLayer"})}
    @ReactProp(name = "id")
    fun setId(layer: RNMBXCircleLayer, id: Dynamic) {
        layer.iD = id.asString()
    }

    @ReactProp(name = "existing")
    fun setExisting(layer: RNMBXCircleLayer, existing: Dynamic) {
        layer.setExisting(existing.asBoolean())
    }

    @ReactProp(name = "sourceID")
    fun setSourceID(layer: RNMBXCircleLayer, sourceID: Dynamic) {
        layer.setSourceID(sourceID.asString())
    }

    @ReactProp(name = "aboveLayerID")
    fun setAboveLayerID(layer: RNMBXCircleLayer, aboveLayerID: Dynamic) {
        layer.setAboveLayerID(aboveLayerID.asString())
    }

    @ReactProp(name = "belowLayerID")
    fun setBelowLayerID(layer: RNMBXCircleLayer, belowLayerID: Dynamic) {
        layer.setBelowLayerID(belowLayerID.asString())
    }

    @ReactProp(name = "layerIndex")
    fun setLayerIndex(layer: RNMBXCircleLayer, layerIndex: Dynamic) {
        layer.setLayerIndex(layerIndex.asInt())
    }

    @ReactProp(name = "minZoomLevel")
    fun setMinZoomLevel(layer: RNMBXCircleLayer, minZoomLevel: Dynamic) {
        layer.setMinZoomLevel(minZoomLevel.asDouble())
    }

    @ReactProp(name = "maxZoomLevel")
    fun setMaxZoomLevel(layer: RNMBXCircleLayer, maxZoomLevel: Dynamic) {
        layer.setMaxZoomLevel(maxZoomLevel.asDouble())
    }

    @ReactProp(name = "reactStyle")
    fun setReactStyle(layer: RNMBXCircleLayer, style: Dynamic) {
        layer.setReactStyle(style.asMap())
    }

    @ReactProp(name = "sourceLayerID")
    fun setSourceLayerID(layer: RNMBXCircleLayer, sourceLayerID: Dynamic) {
        layer.setSourceLayerID(sourceLayerID.asString())
    }

    @ReactProp(name = "filter")
    fun setFilter(layer: RNMBXCircleLayer, filterList: Dynamic) {
        layer.setFilter(filterList.asArray())
    }

    @ReactProp(name = "slot")
    fun setSlot(layer: RNMBXCircleLayer, slot: Dynamic) {
        layer.setSlot(slot.asString())
    }
    // @{codepart-replace-end}

    companion object {
        const val REACT_CLASS = "RNMBXCircleLayer"
    }
}