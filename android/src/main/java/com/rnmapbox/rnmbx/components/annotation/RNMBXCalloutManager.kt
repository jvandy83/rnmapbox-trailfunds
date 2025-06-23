package com.rnmapbox.rnmbx.components.annotation

import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.viewmanagers.RNMBXCalloutManagerDelegate
import com.facebook.react.viewmanagers.RNMBXCalloutManagerInterface

class RNMBXCalloutManager : ViewGroupManager<RNMBXCallout>(),
    RNMBXCalloutManagerInterface<RNMBXCallout> {

    private val mDelegate: ViewManagerDelegate<RNMBXCallout>

    init {
        mDelegate = RNMBXCalloutManagerDelegate(this)
    }

    override override fun getDelegate(): ViewManagerDelegate<RNMBXCallout> {
        return mDelegate
    }

    override override fun getName(): String {
        return REACT_CLASS
    }

    override override fun createViewInstance(reactContext: ThemedReactContext): RNMBXCallout {
        return RNMBXCallout(reactContext)
    }

    companion object {
        const val REACT_CLASS = "RNMBXCallout"
    }
}