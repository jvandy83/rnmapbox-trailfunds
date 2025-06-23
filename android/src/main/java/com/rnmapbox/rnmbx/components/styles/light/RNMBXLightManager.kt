package com.rnmapbox.rnmbx.components.styles.light

import com.facebook.react.bridge.Dynamic
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNMBXLightManagerInterface

class RNMBXLightManager : ViewGroupManager<RNMBXLight>(),
    RNMBXLightManagerInterface<RNMBXLight> {
    fun getName(): String {
        return REACT_CLASS
    }

    fun createViewInstance(reactContext: ThemedReactContext): RNMBXLight {
        return RNMBXLight(reactContext)
    }

    @ReactProp(name = "reactStyle")
    fun setReactStyle(light: RNMBXLight, reactStyle: Dynamic) {
        light.setReactStyle(reactStyle.asMap())
    }

    companion object {
        const val REACT_CLASS = "RNMBXLight"
    }
}