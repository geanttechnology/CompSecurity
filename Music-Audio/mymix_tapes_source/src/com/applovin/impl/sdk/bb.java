// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdService;
import com.applovin.sdk.AppLovinAd;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.applovin.impl.sdk:
//            bq, co, NativeAdImpl, br, 
//            bw, AppLovinSdkImpl, bc, c, 
//            bv, ay

public class bb extends bq
{

    public bb(AppLovinSdkImpl applovinsdkimpl)
    {
        super(applovinsdkimpl);
    }

    bv a(c c1)
    {
        c1 = new co(a, 1, this);
        c1.a(true);
        return c1;
    }

    c a(ay ay)
    {
        return NativeAdImpl.SPEC_NATIVE;
    }

    Map a()
    {
        HashMap hashmap = new HashMap(1);
        br br1 = new br(((Integer)a.a(bw.aR)).intValue());
        hashmap.put(NativeAdImpl.SPEC_NATIVE, br1);
        return hashmap;
    }

    public void a(c c1, int i)
    {
    }

    void a(Object obj, ay ay)
    {
        ay = Arrays.asList(new AppLovinNativeAd[] {
            (AppLovinNativeAd)ay
        });
        ((AppLovinNativeAdLoadListener)obj).onNativeAdsLoaded(ay);
    }

    void a(Object obj, c c1, int i)
    {
        ((AppLovinNativeAdLoadListener)obj).onNativeAdsFailedToLoad(i);
    }

    public volatile boolean a(c c1, Object obj)
    {
        return super.a(c1, obj);
    }

    public void adReceived(AppLovinAd applovinad)
    {
    }

    public volatile ay b(c c1)
    {
        return super.b(c1);
    }

    public volatile void b(c c1, Object obj)
    {
        super.b(c1, obj);
    }

    public volatile boolean c(c c1)
    {
        return super.c(c1);
    }

    public volatile void d(c c1)
    {
        super.d(c1);
    }

    public volatile boolean e(c c1)
    {
        return super.e(c1);
    }

    public volatile void f(c c1)
    {
        super.f(c1);
    }

    public void failedToReceiveAd(int i)
    {
    }

    public void onNativeAdsFailedToLoad(int i)
    {
        b(NativeAdImpl.SPEC_NATIVE, i);
    }

    public void onNativeAdsLoaded(List list)
    {
        list = (AppLovinNativeAd)list.get(0);
        a.getNativeAdService().precacheResources(list, new bc(this));
    }
}
