// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactory;
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook.drawee.backends.pipeline:
//            PipelineDraweeController

public class PipelineDraweeControllerFactory
{

    private AnimatedDrawableFactory mAnimatedDrawableFactory;
    private DeferredReleaser mDeferredReleaser;
    private Resources mResources;
    private Executor mUiThreadExecutor;

    public PipelineDraweeControllerFactory(Resources resources, DeferredReleaser deferredreleaser, AnimatedDrawableFactory animateddrawablefactory, Executor executor)
    {
        mResources = resources;
        mDeferredReleaser = deferredreleaser;
        mAnimatedDrawableFactory = animateddrawablefactory;
        mUiThreadExecutor = executor;
    }

    public PipelineDraweeController newController(Supplier supplier, String s, Object obj)
    {
        return new PipelineDraweeController(mResources, mDeferredReleaser, mAnimatedDrawableFactory, mUiThreadExecutor, supplier, s, obj);
    }
}
