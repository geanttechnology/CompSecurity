// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;

// Referenced classes of package com.applovin.impl.adview:
//            af, x

class aa
    implements AppLovinAdVideoPlaybackListener
{

    final af a;
    final x b;

    aa(x x, af af1)
    {
        b = x;
        a = af1;
        super();
    }

    public void videoPlaybackBegan(AppLovinAd applovinad)
    {
        AppLovinAdVideoPlaybackListener applovinadvideoplaybacklistener = a.c();
        if (applovinadvideoplaybacklistener != null)
        {
            applovinadvideoplaybacklistener.videoPlaybackBegan(applovinad);
        }
    }

    public void videoPlaybackEnded(AppLovinAd applovinad, double d, boolean flag)
    {
        AppLovinAdVideoPlaybackListener applovinadvideoplaybacklistener = a.c();
        if (applovinadvideoplaybacklistener != null)
        {
            applovinadvideoplaybacklistener.videoPlaybackEnded(applovinad, d, flag);
        }
    }
}
