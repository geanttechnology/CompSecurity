// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.List;

// Referenced classes of package com.applovin.impl.sdk:
//            cg, NativeAdImpl, AppLovinSdkImpl, y

public class ch extends cg
{

    public ch(AppLovinSdkImpl applovinsdkimpl, List list, AppLovinNativeAdLoadListener applovinnativeadloadlistener)
    {
        super("TaskCacheNativeAdVideos", applovinsdkimpl, list, applovinnativeadloadlistener);
    }

    public ch(AppLovinSdkImpl applovinsdkimpl, List list, AppLovinNativeAdPrecacheListener applovinnativeadprecachelistener)
    {
        super("TaskCacheNativeAdVideos", applovinsdkimpl, list, applovinnativeadprecachelistener);
    }

    private boolean b(NativeAdImpl nativeadimpl)
    {
        g.w("TaskCacheNativeAdVideos", (new StringBuilder()).append("Unable to cache video resource ").append(nativeadimpl.getSourceVideoUrl()).toString());
        a(nativeadimpl, -202);
        return false;
    }

    protected void a(NativeAdImpl nativeadimpl)
    {
        if (b != null)
        {
            b.onNativeAdVideoPreceached(nativeadimpl);
        }
    }

    protected void a(NativeAdImpl nativeadimpl, int i)
    {
        if (b != null)
        {
            b.onNativeAdVideoPrecachingFailed(nativeadimpl, i);
        }
    }

    protected boolean a(NativeAdImpl nativeadimpl, y y)
    {
        if (!AppLovinSdkUtils.isValidString(nativeadimpl.getSourceVideoUrl()))
        {
            f.getLogger().d("TaskCacheNativeAdVideos", "No video attached to ad, nothing to cache...");
        }
        f.getLogger().d("TaskCacheNativeAdVideos", (new StringBuilder()).append("Beginning slot video caching for ad ").append(nativeadimpl.getAdId()).toString());
        y = a(nativeadimpl.getSourceVideoUrl(), y);
        if (y != null)
        {
            nativeadimpl.setVideoUrl(y);
            return true;
        } else
        {
            return b(nativeadimpl);
        }
    }

    public volatile void run()
    {
        super.run();
    }
}
