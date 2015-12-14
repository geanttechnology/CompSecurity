// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.core;

import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;

// Referenced classes of package com.facebook.imagepipeline.core:
//            ImagePipelineFactory

static final class val.animatedDrawableUtil
    implements AnimatedDrawableBackendProvider
{

    final AnimatedDrawableUtil val$animatedDrawableUtil;

    public AnimatedDrawableBackend get(AnimatedImageResult animatedimageresult, Rect rect)
    {
        return new AnimatedDrawableBackendImpl(val$animatedDrawableUtil, animatedimageresult, rect);
    }

    leUtil(AnimatedDrawableUtil animateddrawableutil)
    {
        val$animatedDrawableUtil = animateddrawableutil;
        super();
    }
}
