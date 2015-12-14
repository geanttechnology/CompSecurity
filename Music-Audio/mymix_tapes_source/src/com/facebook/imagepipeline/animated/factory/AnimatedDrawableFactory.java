// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.factory;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.SystemClock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawable;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImplProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableDiagnosticsImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableDiagnosticsNoop;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import java.util.concurrent.ScheduledExecutorService;

public class AnimatedDrawableFactory
{

    private final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    private final AnimatedDrawableCachingBackendImplProvider mAnimatedDrawableCachingBackendProvider;
    private final AnimatedDrawableUtil mAnimatedDrawableUtil;
    private final MonotonicClock mMonotonicClock = new MonotonicClock() {

        final AnimatedDrawableFactory this$0;

        public long now()
        {
            return SystemClock.uptimeMillis();
        }

            
            {
                this$0 = AnimatedDrawableFactory.this;
                super();
            }
    };
    private final Resources mResources;
    private final ScheduledExecutorService mScheduledExecutorServiceForUiThread;

    public AnimatedDrawableFactory(AnimatedDrawableBackendProvider animateddrawablebackendprovider, AnimatedDrawableCachingBackendImplProvider animateddrawablecachingbackendimplprovider, AnimatedDrawableUtil animateddrawableutil, ScheduledExecutorService scheduledexecutorservice, Resources resources)
    {
        mAnimatedDrawableBackendProvider = animateddrawablebackendprovider;
        mAnimatedDrawableCachingBackendProvider = animateddrawablecachingbackendimplprovider;
        mAnimatedDrawableUtil = animateddrawableutil;
        mScheduledExecutorServiceForUiThread = scheduledexecutorservice;
        mResources = resources;
    }

    private AnimatedDrawable createAnimatedDrawable(AnimatedDrawableOptions animateddrawableoptions, AnimatedDrawableBackend animateddrawablebackend)
    {
        android.util.DisplayMetrics displaymetrics = mResources.getDisplayMetrics();
        animateddrawablebackend = mAnimatedDrawableCachingBackendProvider.get(animateddrawablebackend, animateddrawableoptions);
        if (animateddrawableoptions.enableDebugging)
        {
            animateddrawableoptions = new AnimatedDrawableDiagnosticsImpl(mAnimatedDrawableUtil, displaymetrics);
        } else
        {
            animateddrawableoptions = AnimatedDrawableDiagnosticsNoop.getInstance();
        }
        return new AnimatedDrawable(mScheduledExecutorServiceForUiThread, animateddrawablebackend, animateddrawableoptions, mMonotonicClock);
    }

    public AnimatedDrawable create(AnimatedImageResult animatedimageresult)
    {
        return create(animatedimageresult, AnimatedDrawableOptions.DEFAULTS);
    }

    public AnimatedDrawable create(AnimatedImageResult animatedimageresult, AnimatedDrawableOptions animateddrawableoptions)
    {
        Object obj = animatedimageresult.getImage();
        obj = new Rect(0, 0, ((AnimatedImage) (obj)).getWidth(), ((AnimatedImage) (obj)).getHeight());
        return createAnimatedDrawable(animateddrawableoptions, mAnimatedDrawableBackendProvider.get(animatedimageresult, ((Rect) (obj))));
    }
}
