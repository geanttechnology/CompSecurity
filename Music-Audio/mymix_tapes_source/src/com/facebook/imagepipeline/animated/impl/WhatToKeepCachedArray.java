// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.impl;

import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;

class WhatToKeepCachedArray
{

    private final boolean mData[];

    WhatToKeepCachedArray(int i)
    {
        mData = new boolean[i];
    }

    boolean get(int i)
    {
        return mData[i];
    }

    void removeOutsideRange(int i, int j)
    {
        for (int k = 0; k < mData.length; k++)
        {
            if (AnimatedDrawableUtil.isOutsideRange(i, j, k))
            {
                mData[k] = false;
            }
        }

    }

    void set(int i, boolean flag)
    {
        mData[i] = flag;
    }

    void setAll(boolean flag)
    {
        for (int i = 0; i < mData.length; i++)
        {
            mData[i] = flag;
        }

    }
}
