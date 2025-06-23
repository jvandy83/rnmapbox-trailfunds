package com.rnmapbox.rnmbx.components.styles.layers

import com.facebook.react.bridge.Dynamic
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNMBXLineLayerManagerInterface

class RNMBXLineLayerManager : ViewGroupManager<RNMBXLineLayer>(),
    RNMBXLineLayerManagerInterface<RNMBXLineLayer> {
    fun getName(): String {
        return REACT_CLASS
    }

    fun createViewInstance(reactContext: ThemedReactContext): RNMBXLineLayer {
        return RNMBXLineLayer(reactContext)
    }

    // @{codepart-replace-start(LayerManagerCommonProps.codepart-kt.ejs,{layerType:"RNMBXLineLayer"})}
    @ReactProp(name = "id")
    fun setId(layer: RNMBXLineLayer, id: Dynamic) {
        layer.iD = id.asString()
    }

    @ReactProp(name = "existing")
    fun setExisting(layer: RNMBXLineLayer, existing: Dynamic) {
        layer.setExisting(existing.asBoolean())
    }

    @ReactProp(name = "sourceID")
    fun setSourceID(layer: RNMBXLineLayer, sourceID: Dynamic) {
        layer.setSourceID(sourceID.asString())
    }

    @ReactProp(name = "aboveLayerID")
    fun setAboveLayerID(layer: RNMBXLineLayer, aboveLayerID: Dynamic) {
        layer.setAboveLayerID(aboveLayerID.asString())
    }

    @ReactProp(name = "belowLayerID")
    fun setBelowLayerID(layer: RNMBXLineLayer, belowLayerID: Dynamic) {
        layer.setBelowLayerID(belowLayerID.asString())
    }

    @ReactProp(name = "layerIndex")
    fun setLayerIndex(layer: RNMBXLineLayer, layerIndex: Dynamic) {
        layer.setLayerIndex(layerIndex.asInt())
    }

    @ReactProp(name = "minZoomLevel")
    fun setMinZoomLevel(layer: RNMBXLineLayer, minZoomLevel: Dynamic) {
        layer.setMinZoomLevel(minZoomLevel.asDouble())
    }

    @ReactProp(name = "maxZoomLevel")
    fun setMaxZoomLevel(layer: RNMBXLineLayer, maxZoomLevel: Dynamic) {
        layer.setMaxZoomLevel(maxZoomLevel.asDouble())
    }

    @ReactProp(name = "reactStyle")
    fun setReactStyle(layer: RNMBXLineLayer, style: Dynamic) {
        layer.setReactStyle(style.asMap())
    }

    @ReactProp(name = "sourceLayerID")
    fun setSourceLayerID(layer: RNMBXLineLayer, sourceLayerID: Dynamic) {
        layer.setSourceLayerID(sourceLayerID.asString())
    }

    @ReactProp(name = "filter")
    fun setFilter(layer: RNMBXLineLayer, filterList: Dynamic) {
        layer.setFilter(filterList.asArray())
    }

    @ReactProp(name = "slot")
    fun setSlot(layer: RNMBXLineLayer, slot: Dynamic) {
        layer.setSlot(slot.asString())
    }
    // @{codepart-replace-end}

    companion object {
        const val REACT_CLASS = "RNMBXLineLayer"
    }
}