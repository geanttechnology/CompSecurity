// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdType;

public class i
    implements FlurryAdListener
{

    private Runnable a;

    public i(Runnable runnable)
    {
        a = runnable;
    }

    public void onAdClicked(String s)
    {
    }

    public void onAdClosed(String s)
    {
        if (a != null)
        {
            a.run();
        }
    }

    public void onAdOpened(String s)
    {
    }

    public void onApplicationExit(String s)
    {
    }

    public void onRenderFailed(String s)
    {
    }

    public void onRendered(String s)
    {
    }

    public void onVideoCompleted(String s)
    {
    }

    public boolean shouldDisplayAd(String s, FlurryAdType flurryadtype)
    {
        return false;
    }

    public void spaceDidFailToReceiveAd(String s)
    {
    }

    public void spaceDidReceiveAd(String s)
    {
    }
}
