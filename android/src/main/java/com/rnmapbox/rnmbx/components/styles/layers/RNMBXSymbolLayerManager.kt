package com.rnmapbox.rnmbx.components.styles.layers

import com.facebook.react.bridge.Dynamic
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNMBXSymbolLayerManagerInterface

class RNMBXSymbolLayerManager : ViewGroupManager<RNMBXSymbolLayer>(),
    RNMBXSymbolLayerManagerInterface<RNMBXSymbolLayer> {
    override override fun getName(): String {
        return REACT_CLASS
    }

    override override fun createViewInstance(reactContext: ThemedReactContext): RNMBXSymbolLayer {
        return RNMBXSymbolLayer(reactContext)
    }

    // @{codepart-replace-start(LayerManagerCommonProps.codepart-kt.ejs,{layerType:"RNMBXSymbolLayer"})}
    @ReactProp(name = "id")
    override override fun setId(layer: RNMBXSymbolLayer, id: Dynamic) {
        layer.iD = id.asString()
    }

    @ReactProp(name = "existing")
    override override fun setExisting(layer: RNMBXSymbolLayer, existing: Dynamic) {
        layer.setExisting(existing.asBoolean())
    }

    @ReactProp(name = "sourceID")
    override override fun setSourceID(layer: RNMBXSymbolLayer, sourceID: Dynamic) {
        layer.setSourceID(sourceID.asString())
    }

    @ReactProp(name = "aboveLayerID")
    override override fun setAboveLayerID(layer: RNMBXSymbolLayer, aboveLayerID: Dynamic) {
        layer.setAboveLayerID(aboveLayerID.asString())
    }

    @ReactProp(name = "belowLayerID")
    override override fun setBelowLayerID(layer: RNMBXSymbolLayer, belowLayerID: Dynamic) {
        layer.setBelowLayerID(belowLayerID.asString())
    }

    @ReactProp(name = "layerIndex")
    override override fun setLayerIndex(layer: RNMBXSymbolLayer, layerIndex: Dynamic) {
        layer.setLayerIndex(layerIndex.asInt())
    }

    @ReactProp(name = "minZoomLevel")
    override override fun setMinZoomLevel(layer: RNMBXSymbolLayer, minZoomLevel: Dynamic) {
        layer.setMinZoomLevel(minZoomLevel.asDouble())
    }

    @ReactProp(name = "maxZoomLevel")
    override override fun setMaxZoomLevel(layer: RNMBXSymbolLayer, maxZoomLevel: Dynamic) {
        layer.setMaxZoomLevel(maxZoomLevel.asDouble())
    }

    @ReactProp(name = "reactStyle")
    override override fun setReactStyle(layer: RNMBXSymbolLayer, style: Dynamic) {
        layer.setReactStyle(style.asMap())
    }

    @ReactProp(name = "sourceLayerID")
    override override fun setSourceLayerID(layer: RNMBXSymbolLayer, sourceLayerID: Dynamic) {
        layer.setSourceLayerID(sourceLayerID.asString())
    }

    @ReactProp(name = "filter")
    override override fun setFilter(layer: RNMBXSymbolLayer, filterList: Dynamic) {
        layer.setFilter(filterList.asArray())
    }

    @ReactProp(name = "slot")
    override override fun setSlot(layer: RNMBXSymbolLayer, slot: Dynamic) {
        layer.setSlot(slot.asString())
    }

    // @{codepart-replace-end}

    companion object {
        const val REACT_CLASS = "RNMBXSymbolLayer"
    }
}