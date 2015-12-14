// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            cm, NativeAdImpl, cw, db, 
//            dd, q, AppLovinSdkImpl, bv

class co extends cm
{

    private int a;
    private final AppLovinNativeAdLoadListener b;

    public co(AppLovinSdkImpl applovinsdkimpl, int i, AppLovinNativeAdLoadListener applovinnativeadloadlistener)
    {
        super(NativeAdImpl.SIZE_NATIVE, NativeAdImpl.TYPE_NATIVE, null, applovinsdkimpl);
        b = applovinnativeadloadlistener;
        a = i;
    }

    protected bv a(JSONObject jsonobject)
    {
        return new cw(jsonobject, f, b);
    }

    protected void a(int i)
    {
        if (b != null)
        {
            b.onNativeAdsFailedToLoad(i);
        }
    }

    protected void b(Map map)
    {
        map.put("slot_count", Integer.toString(a));
    }

    protected void c(Map map)
    {
        dd dd1 = db.a().a("tFNW");
        if (dd1 != null)
        {
            map.put("etfw", Long.toString(dd1.b()));
            map.put("ntfw", dd1.a());
        }
    }

    protected String d()
    {
        return q.b("nad", f);
    }

    public String e()
    {
        return "tFNW";
    }
}
