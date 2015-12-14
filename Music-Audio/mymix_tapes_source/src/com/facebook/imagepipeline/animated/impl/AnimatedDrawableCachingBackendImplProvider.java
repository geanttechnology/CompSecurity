// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.impl;

import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;

// Referenced classes of package com.facebook.imagepipeline.animated.impl:
//            AnimatedDrawableCachingBackendImpl

public interface AnimatedDrawableCachingBackendImplProvider
{

    public abstract AnimatedDrawableCachingBackendImpl get(AnimatedDrawableBackend animateddrawablebackend, AnimatedDrawableOptions animateddrawableoptions);
}
