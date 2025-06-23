package com.rnmapbox.rnmbx.components.styles.sources

import com.facebook.react.bridge.Dynamic
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNMBXRasterSourceManagerInterface
import com.rnmapbox.rnmbx.events.constants.EventKeys
import com.rnmapbox.rnmbx.events.constants.eventMapOf
import javax.annotation.Nonnull

class RNMBXRasterSourceManager(reactApplicationContext: ReactApplicationContext) :
    RNMBXTileSourceManager<RNMBXRasterSource>(reactApplicationContext),
    RNMBXRasterSourceManagerInterface<RNMBXRasterSource> {
    @Nonnull
    fun getName(): String {
        return REACT_CLASS
    }

    @Nonnull
    fun createViewInstance(@Nonnull reactContext: ThemedReactContext): RNMBXRasterSource {
        return RNMBXRasterSource(reactContext)
    }

    @ReactProp(name = "tileSize")
    fun setTileSize(source: RNMBXRasterSource, tileSize: Dynamic) {
        source.setTileSize(tileSize.asInt())
    }

    fun customEvents(): Map<String, String>? {
        return eventMapOf(
            EventKeys.RASTER_SOURCE_LAYER_CLICK to "onMapboxRasterSourcePress",
            EventKeys.MAP_ANDROID_CALLBACK to "onAndroidCallback"
        )
    }

    companion object {
        const val REACT_CLASS = "RNMBXRasterSource"
    }

    @ReactProp(name = "existing")
    fun setExisting(source: RNMBXRasterSource, value: Dynamic) {
        source.mExisting = value.asBoolean()
    }
}