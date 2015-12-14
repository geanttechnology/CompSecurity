// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.base;


// Referenced classes of package com.facebook.imagepipeline.animated.base:
//            AnimatedDrawableOptionsBuilder

public class AnimatedDrawableOptions
{

    public static AnimatedDrawableOptions DEFAULTS = newBuilder().build();
    public final boolean allowPrefetching;
    public final boolean enableDebugging;
    public final boolean forceKeepAllFramesInMemory;
    public final int maximumBytes;

    public AnimatedDrawableOptions(AnimatedDrawableOptionsBuilder animateddrawableoptionsbuilder)
    {
        forceKeepAllFramesInMemory = animateddrawableoptionsbuilder.getForceKeepAllFramesInMemory();
        allowPrefetching = animateddrawableoptionsbuilder.getAllowPrefetching();
        maximumBytes = animateddrawableoptionsbuilder.getMaximumBytes();
        enableDebugging = animateddrawableoptionsbuilder.getEnableDebugging();
    }

    public static AnimatedDrawableOptionsBuilder newBuilder()
    {
        return new AnimatedDrawableOptionsBuilder();
    }

}
