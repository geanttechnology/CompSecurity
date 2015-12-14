// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.applovin.impl.sdk:
//            bq, bw, cm, c, 
//            br, AppLovinSdkImpl, w, ay, 
//            by, bv

public class b extends bq
{

    public b(AppLovinSdkImpl applovinsdkimpl)
    {
        super(applovinsdkimpl);
    }

    private by a(AppLovinAdType applovinadtype, AppLovinAdSize applovinadsize)
    {
        if (applovinadsize.equals(AppLovinAdSize.BANNER))
        {
            return bw.aj;
        }
        if (applovinadsize.equals(AppLovinAdSize.MREC))
        {
            return bw.ak;
        }
        if (applovinadsize.equals(AppLovinAdSize.INTERSTITIAL))
        {
            return bw.al;
        }
        if (applovinadsize.equals(AppLovinAdSize.LEADER))
        {
            return bw.am;
        } else
        {
            return bw.aj;
        }
    }

    bv a(c c1)
    {
        c1 = new cm(c1.a(), c1.b(), this, a);
        c1.a(true);
        return c1;
    }

    c a(ay ay1)
    {
        return new c((AppLovinAd)ay1);
    }

    Map a()
    {
        HashMap hashmap = new HashMap(5);
        AppLovinAdSize applovinadsize;
        Object obj;
        for (Iterator iterator = AppLovinAdSize.allSizes().iterator(); iterator.hasNext(); hashmap.put(new c(applovinadsize, AppLovinAdType.REGULAR), obj))
        {
            applovinadsize = (AppLovinAdSize)iterator.next();
            obj = a(AppLovinAdType.REGULAR, applovinadsize);
            obj = new br(((Integer)a.a(((by) (obj)))).intValue());
        }

        br br1 = new br(((Integer)a.a(bw.an)).intValue());
        hashmap.put(new c(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED), br1);
        return hashmap;
    }

    public void a(c c1, int i)
    {
        b(c1, i);
    }

    void a(Object obj, ay ay1)
    {
        ((AppLovinAdLoadListener)obj).adReceived((AppLovinAd)ay1);
    }

    void a(Object obj, c c1, int i)
    {
        if (obj instanceof w)
        {
            ((w)obj).a(c1, i);
        }
        if (obj instanceof AppLovinAdLoadListener)
        {
            ((AppLovinAdLoadListener)obj).failedToReceiveAd(i);
        }
    }

    public volatile boolean a(c c1, Object obj)
    {
        return super.a(c1, obj);
    }

    public void adReceived(AppLovinAd applovinad)
    {
        c((ay)applovinad);
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
    }

    public void onNativeAdsLoaded(List list)
    {
    }
}
