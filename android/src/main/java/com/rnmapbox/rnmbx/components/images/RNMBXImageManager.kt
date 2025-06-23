package com.rnmapbox.rnmbx.components.images

import com.facebook.react.bridge.Dynamic
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNMBXImageManagerInterface
import com.rnmapbox.rnmbx.components.AbstractEventEmitter
import com.rnmapbox.rnmbx.components.styles.sources.RNMBXShapeSource
import com.rnmapbox.rnmbx.utils.ViewTagResolver

class RNMBXImageManager(private val mContext: ReactApplicationContext, val viewTagResolver: ViewTagResolver) : AbstractEventEmitter<RNMBXImage>(
mContext
), RNMBXImageManagerInterface<RNMBXImage> {
    fun getName(): String {
        return "RNMBXImage"
    }

    fun createViewInstance(p0: ThemedReactContext): RNMBXImage {
        return RNMBXImage(mContext, this)
    }

    fun customEvents(): MutableMap<String, String>? {
        return mutableMapOf();
    }

    fun onDropViewInstance(view: RNMBXImage) {
        val reactTag = view.id

        viewTagResolver.viewRemoved(reactTag)
        super.onDropViewInstance(view)
    }

    fun tagAssigned(reactTag: Int) {
        return viewTagResolver.tagAssigned(reactTag)
    }

    // region React properties
    @ReactProp(name="name")
    fun setName(image: RNMBXImage, value: Dynamic) {
        image.name = value.asString()
    }

    @ReactProp(name="sdf")
    fun setSdf(image: RNMBXImage, value: Dynamic) {
        image.sdf = value.asBoolean()
    }

    @ReactProp(name="stretchX")
    fun setStretchX(image: RNMBXImage, value: Dynamic) {
        image.stretchX = RNMBXImagesManager.convertStretch(value) ?: listOf()
    }

    @ReactProp(name="stretchY")
    fun setStretchY(image: RNMBXImage, value: Dynamic) {
        image.stretchY = RNMBXImagesManager.convertStretch(value) ?: listOf()
    }

    @ReactProp(name="content")
    fun setContent(image: RNMBXImage, value: Dynamic) {
        image.content = RNMBXImagesManager.convertContent(value)
    }

    @ReactProp(name="scale")
    fun setScale(image: RNMBXImage, value: Dynamic) {
        image.scale = value.asDouble()
    }
    // endregion
}