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
    override override fun getName(): String {
        return "RNMBXImage"
    }

    override override fun createViewInstance(p0: ThemedReactContext): RNMBXImage {
        return RNMBXImage(mContext, this)
    }

    override override fun customEvents(): MutableMap<String, String>? {
        return mutableMapOf();
    }

    override override fun onDropViewInstance(view: RNMBXImage) {
        val reactTag = view.id

        viewTagResolver.viewRemoved(reactTag)
        super.onDropViewInstance(view)
    }

    fun tagAssigned(reactTag: Int) {
        return viewTagResolver.tagAssigned(reactTag)
    }

    // region React properties
    @ReactProp(name="name")
    override override fun setName(image: RNMBXImage, value: Dynamic) {
        image.name = value.asString()
    }

    @ReactProp(name="sdf")
    override override fun setSdf(image: RNMBXImage, value: Dynamic) {
        image.sdf = value.asBoolean()
    }

    @ReactProp(name="stretchX")
    override override fun setStretchX(image: RNMBXImage, value: Dynamic) {
        image.stretchX = RNMBXImagesManager.convertStretch(value) ?: listOf()
    }

    @ReactProp(name="stretchY")
    override override fun setStretchY(image: RNMBXImage, value: Dynamic) {
        image.stretchY = RNMBXImagesManager.convertStretch(value) ?: listOf()
    }

    @ReactProp(name="content")
    override override fun setContent(image: RNMBXImage, value: Dynamic) {
        image.content = RNMBXImagesManager.convertContent(value)
    }

    @ReactProp(name="scale")
    override override fun setScale(image: RNMBXImage, value: Dynamic) {
        image.scale = value.asDouble()
    }
    // endregion
}