package com.rnmapbox.rnmbx.components.styles.layers

import com.facebook.react.bridge.Dynamic
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNMBXRasterLayerManagerInterface

class RNMBXRasterLayerManager : ViewGroupManager<RNMBXRasterLayer>(),
    RNMBXRasterLayerManagerInterface<RNMBXRasterLayer> {
    fun getName(): String {
        return REACT_CLASS
    }

    fun createViewInstance(reactContext: ThemedReactContext): RNMBXRasterLayer {
        return RNMBXRasterLayer(reactContext)
    }

    // @{codepart-replace-start(LayerManagerCommonProps.codepart-kt.ejs,{layerType:"RNMBXRasterLayer"})}
    @ReactProp(name = "id")
    fun setId(layer: RNMBXRasterLayer, id: Dynamic) {
        layer.iD = id.asString()
    }

    @ReactProp(name = "existing")
    fun setExisting(layer: RNMBXRasterLayer, existing: Dynamic) {
        layer.setExisting(existing.asBoolean())
    }

    @ReactProp(name = "sourceID")
    fun setSourceID(layer: RNMBXRasterLayer, sourceID: Dynamic) {
        layer.setSourceID(sourceID.asString())
    }

    @ReactProp(name = "aboveLayerID")
    fun setAboveLayerID(layer: RNMBXRasterLayer, aboveLayerID: Dynamic) {
        layer.setAboveLayerID(aboveLayerID.asString())
    }

    @ReactProp(name = "belowLayerID")
    fun setBelowLayerID(layer: RNMBXRasterLayer, belowLayerID: Dynamic) {
        layer.setBelowLayerID(belowLayerID.asString())
    }

    @ReactProp(name = "layerIndex")
    fun setLayerIndex(layer: RNMBXRasterLayer, layerIndex: Dynamic) {
        layer.setLayerIndex(layerIndex.asInt())
    }

    @ReactProp(name = "minZoomLevel")
    fun setMinZoomLevel(layer: RNMBXRasterLayer, minZoomLevel: Dynamic) {
        layer.setMinZoomLevel(minZoomLevel.asDouble())
    }

    @ReactProp(name = "maxZoomLevel")
    fun setMaxZoomLevel(layer: RNMBXRasterLayer, maxZoomLevel: Dynamic) {
        layer.setMaxZoomLevel(maxZoomLevel.asDouble())
    }

    @ReactProp(name = "reactStyle")
    fun setReactStyle(layer: RNMBXRasterLayer, style: Dynamic) {
        layer.setReactStyle(style.asMap())
    }

    @ReactProp(name = "sourceLayerID")
    fun setSourceLayerID(layer: RNMBXRasterLayer, sourceLayerID: Dynamic) {
        layer.setSourceLayerID(sourceLayerID.asString())
    }

    @ReactProp(name = "filter")
    fun setFilter(layer: RNMBXRasterLayer, filterList: Dynamic) {
        layer.setFilter(filterList.asArray())
    }

    @ReactProp(name = "slot")
    fun setSlot(layer: RNMBXRasterLayer, slot: Dynamic) {
        layer.setSlot(slot.asString())
    }
    // @{codepart-replace-end}

    companion object {
        const val REACT_CLASS = "RNMBXRasterLayer"
    }
}