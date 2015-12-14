// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.base;


// Referenced classes of package com.facebook.imagepipeline.animated.base:
//            AnimatedDrawableOptions

public class AnimatedDrawableOptionsBuilder
{

    private boolean mAllowPrefetching;
    private boolean mEnableDebugging;
    private boolean mForceKeepAllFramesInMemory;
    private int mMaximumBytes;

    public AnimatedDrawableOptionsBuilder()
    {
        mAllowPrefetching = true;
        mMaximumBytes = -1;
    }

    public AnimatedDrawableOptions build()
    {
        return new AnimatedDrawableOptions(this);
    }

    public boolean getAllowPrefetching()
    {
        return mAllowPrefetching;
    }

    public boolean getEnableDebugging()
    {
        return mEnableDebugging;
    }

    public boolean getForceKeepAllFramesInMemory()
    {
        return mForceKeepAllFramesInMemory;
    }

    public int getMaximumBytes()
    {
        return mMaximumBytes;
    }

    public AnimatedDrawableOptionsBuilder setAllowPrefetching(boolean flag)
    {
        mAllowPrefetching = flag;
        return this;
    }

    public AnimatedDrawableOptionsBuilder setEnableDebugging(boolean flag)
    {
        mEnableDebugging = flag;
        return this;
    }

    public AnimatedDrawableOptionsBuilder setForceKeepAllFramesInMemory(boolean flag)
    {
        mForceKeepAllFramesInMemory = flag;
        return this;
    }

    public AnimatedDrawableOptionsBuilder setMaximumBytes(int i)
    {
        mMaximumBytes = i;
        return this;
    }
}
