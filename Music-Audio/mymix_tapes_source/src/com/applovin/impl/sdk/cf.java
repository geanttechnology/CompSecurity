// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinLogger;
import java.util.List;

// Referenced classes of package com.applovin.impl.sdk:
//            cg, AppLovinSdkImpl, NativeAdImpl, y

public class cf extends cg
{

    public cf(AppLovinSdkImpl applovinsdkimpl, List list, AppLovinNativeAdLoadListener applovinnativeadloadlistener)
    {
        super("TaskCacheNativeAdImages", applovinsdkimpl, list, applovinnativeadloadlistener);
    }

    public cf(AppLovinSdkImpl applovinsdkimpl, List list, AppLovinNativeAdPrecacheListener applovinnativeadprecachelistener)
    {
        super("TaskCacheNativeAdImages", applovinsdkimpl, list, applovinnativeadprecachelistener);
    }

    private boolean b(NativeAdImpl nativeadimpl)
    {
        a(nativeadimpl, -201);
        return false;
    }

    protected void a(NativeAdImpl nativeadimpl)
    {
        if (b != null)
        {
            b.onNativeAdImagesPrecached(nativeadimpl);
        }
    }

    protected void a(NativeAdImpl nativeadimpl, int i)
    {
        if (b != null)
        {
            b.onNativeAdImagePrecachingFailed(nativeadimpl, i);
        }
    }

    protected boolean a(NativeAdImpl nativeadimpl, y y)
    {
        f.getLogger().d("TaskCacheNativeAdImages", (new StringBuilder()).append("Beginning slot image caching for ad ").append(nativeadimpl.getAdId()).toString());
        String s = a(nativeadimpl.getSourceIconUrl(), y);
        if (s != null)
        {
            nativeadimpl.setIconUrl(s);
            y = a(nativeadimpl.getSourceImageUrl(), y);
            if (y != null)
            {
                nativeadimpl.setImageUrl(y);
                return true;
            } else
            {
                return b(nativeadimpl);
            }
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
