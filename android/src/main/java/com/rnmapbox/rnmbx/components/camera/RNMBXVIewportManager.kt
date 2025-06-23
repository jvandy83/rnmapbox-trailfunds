package com.rnmapbox.rnmbx.components.camera

import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.Dynamic
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.WritableArray
import com.facebook.react.bridge.WritableMap
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNMBXViewportManagerInterface
import com.rnmapbox.rnmbx.components.AbstractEventEmitter
import com.rnmapbox.rnmbx.events.constants.EventKeys
import com.rnmapbox.rnmbx.events.constants.eventMapOf
import com.rnmapbox.rnmbx.utils.ViewTagResolver

class RNMBXViewportManager(private val mContext: ReactApplicationContext, val viewTagResolver: ViewTagResolver) : AbstractEventEmitter<RNMBXViewport>(
        mContext
    ), RNMBXViewportManagerInterface<RNMBXViewport> {

    override override fun getName(): String {
        return REACT_CLASS
    }

    override override fun createViewInstance(reactContext: ThemedReactContext): RNMBXViewport {
        return RNMBXViewport(reactContext, this)
    }

    @ReactProp(name = "transitionsToIdleUponUserInteraction")
    override override fun setTransitionsToIdleUponUserInteraction(view: RNMBXViewport?, value: Dynamic?) {
        view?.transitionsToIdleUponUserInteraction = value?.asBoolean()
    }

    @ReactProp(name = "hasStatusChanged")
    override override fun setHasStatusChanged(view: RNMBXViewport?, value: Boolean) {
        view?.hasStatusChanged = value
    }

    //region Custom Events
    override override fun customEvents(): Map<String, String>? {
        return eventMapOf(
            EventKeys.VIEWPORT_STATUS_CHANGE to "onStatusChanged"
        )
    }

    override override fun getCommandsMap(): Map<String, Int>? {
        return mapOf(
            "_useCommandName" to 1
        );
    }
    //endregion

    companion object {
        const val REACT_CLASS = "RNMBXViewport"
    }
}
