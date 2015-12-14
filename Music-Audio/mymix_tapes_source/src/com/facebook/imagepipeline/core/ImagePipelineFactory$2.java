// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.time.MonotonicClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImplProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;

// Referenced classes of package com.facebook.imagepipeline.core:
//            ImagePipelineFactory

class val.monotonicClock
    implements AnimatedDrawableCachingBackendImplProvider
{

    final ImagePipelineFactory this$0;
    final ActivityManager val$activityManager;
    final AnimatedDrawableUtil val$animatedDrawableUtil;
    final MonotonicClock val$monotonicClock;
    final SerialExecutorService val$serialExecutorService;

    public AnimatedDrawableCachingBackendImpl get(AnimatedDrawableBackend animateddrawablebackend, AnimatedDrawableOptions animateddrawableoptions)
    {
        return new AnimatedDrawableCachingBackendImpl(val$serialExecutorService, val$activityManager, val$animatedDrawableUtil, val$monotonicClock, animateddrawablebackend, animateddrawableoptions);
    }

    leUtil()
    {
        this$0 = final_imagepipelinefactory;
        val$serialExecutorService = serialexecutorservice;
        val$activityManager = activitymanager;
        val$animatedDrawableUtil = animateddrawableutil;
        val$monotonicClock = MonotonicClock.this;
        super();
    }
}
