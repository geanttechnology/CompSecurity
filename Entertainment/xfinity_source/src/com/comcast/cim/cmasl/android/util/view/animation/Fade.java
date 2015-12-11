// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.animation;


public class Fade
{

    private long mDuration;
    private boolean mDurationSet;

    public Fade()
    {
        mDurationSet = false;
        mDuration = 300L;
    }

    public void setDuration(long l)
    {
        if (l >= 0L)
        {
            mDurationSet = true;
            mDuration = l;
        }
    }
}
