// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinLogger;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.applovin.impl.sdk:
//            bv, y, NativeAdImpl, AppLovinSdkImpl, 
//            bw

abstract class cg extends bv
{

    protected AppLovinNativeAdLoadListener a;
    protected AppLovinNativeAdPrecacheListener b;
    private List c;
    private int d;

    cg(String s, AppLovinSdkImpl applovinsdkimpl, List list, AppLovinNativeAdLoadListener applovinnativeadloadlistener)
    {
        super(s, applovinsdkimpl);
        d = 0;
        a = applovinnativeadloadlistener;
        c = list;
    }

    cg(String s, AppLovinSdkImpl applovinsdkimpl, List list, AppLovinNativeAdPrecacheListener applovinnativeadprecachelistener)
    {
        super(s, applovinsdkimpl);
        d = 0;
        if (list == null)
        {
            throw new IllegalArgumentException("Slots cannot be null");
        } else
        {
            c = list;
            b = applovinnativeadprecachelistener;
            return;
        }
    }

    private void a(int i)
    {
        if (a != null)
        {
            a.onNativeAdsFailedToLoad(i);
        }
    }

    private void a(List list)
    {
        if (a != null)
        {
            a.onNativeAdsLoaded(list);
        }
    }

    protected String a(String s, y y1)
    {
        try
        {
            y1 = y1.a(h, s, true);
        }
        // Misplaced declaration of an exception variable
        catch (y y1)
        {
            g.w(a(), (new StringBuilder()).append("Unable to cache icon resource ").append(s).toString(), y1);
            return null;
        }
        if (y1 != null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        g.w(a(), (new StringBuilder()).append("Unable to cache icon resource ").append(s).toString());
        return null;
        return y1;
    }

    protected abstract void a(NativeAdImpl nativeadimpl);

    protected abstract boolean a(NativeAdImpl nativeadimpl, y y1);

    public void run()
    {
        for (Iterator iterator = c.iterator(); iterator.hasNext();)
        {
            NativeAdImpl nativeadimpl = (NativeAdImpl)iterator.next();
            y y1 = f.getFileManager();
            f.getLogger().d(a(), "Beginning resource caching phase...");
            if (a(nativeadimpl, y1))
            {
                d = d + 1;
                a(nativeadimpl);
            } else
            {
                f.getLogger().e(a(), "Unable to cache resources");
            }
        }

        try
        {
            if (d == c.size())
            {
                a((List)c);
                return;
            }
        }
        catch (Throwable throwable)
        {
            f.getLogger().userError(a(), "Encountered exception while notifying publisher code", throwable);
            return;
        }
        if (((Boolean)f.a(bw.aN)).booleanValue())
        {
            f.getLogger().e(a(), "Mismatch between successful populations and requested size");
            a(-6);
            return;
        }
        a((List)c);
        return;
    }
}
