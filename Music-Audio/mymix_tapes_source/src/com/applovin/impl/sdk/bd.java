// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.nativeAds.AppLovinNativeAdService;
import com.applovin.sdk.AppLovinLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.applovin.impl.sdk:
//            NativeAdImpl, ch, bg, AppLovinSdkImpl, 
//            cr, cq, cf, bj, 
//            bk, bw, bh, bb, 
//            co, be, bf

class bd
    implements AppLovinNativeAdService
{

    private final AppLovinSdkImpl a;
    private final Object b = new Object();

    bd(AppLovinSdkImpl applovinsdkimpl)
    {
        a = applovinsdkimpl;
    }

    private List a(AppLovinNativeAd applovinnativead)
    {
        ArrayList arraylist = new ArrayList(1);
        arraylist.add((NativeAdImpl)applovinnativead);
        return arraylist;
    }

    static void a(bd bd1, AppLovinNativeAd applovinnativead, AppLovinNativeAdPrecacheListener applovinnativeadprecachelistener)
    {
        bd1.a(applovinnativead, applovinnativeadprecachelistener);
    }

    static void a(bd bd1, AppLovinNativeAdLoadListener applovinnativeadloadlistener, int i)
    {
        bd1.a(applovinnativeadloadlistener, i);
    }

    static void a(bd bd1, AppLovinNativeAdLoadListener applovinnativeadloadlistener, List list)
    {
        bd1.a(applovinnativeadloadlistener, list);
    }

    static void a(bd bd1, AppLovinNativeAdPrecacheListener applovinnativeadprecachelistener, AppLovinNativeAd applovinnativead, int i, boolean flag)
    {
        bd1.a(applovinnativeadprecachelistener, applovinnativead, i, flag);
    }

    static void a(bd bd1, AppLovinNativeAdPrecacheListener applovinnativeadprecachelistener, AppLovinNativeAd applovinnativead, boolean flag)
    {
        bd1.a(applovinnativeadprecachelistener, applovinnativead, flag);
    }

    static void a(bd bd1, List list, AppLovinNativeAdLoadListener applovinnativeadloadlistener)
    {
        bd1.c(list, applovinnativeadloadlistener);
    }

    private void a(AppLovinNativeAd applovinnativead, AppLovinNativeAdPrecacheListener applovinnativeadprecachelistener)
    {
        if (applovinnativead.isVideoPrecached())
        {
            applovinnativeadprecachelistener.onNativeAdVideoPreceached(applovinnativead);
            return;
        } else
        {
            applovinnativead = a(applovinnativead);
            applovinnativead = new ch(a, applovinnativead, new bg(this, applovinnativeadprecachelistener));
            a.a().a(applovinnativead, cr.a);
            return;
        }
    }

    private void a(AppLovinNativeAdLoadListener applovinnativeadloadlistener, int i)
    {
        if (applovinnativeadloadlistener == null)
        {
            break MISSING_BLOCK_LABEL_11;
        }
        applovinnativeadloadlistener.onNativeAdsFailedToLoad(i);
        return;
        applovinnativeadloadlistener;
        a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", applovinnativeadloadlistener);
        return;
    }

    private void a(AppLovinNativeAdLoadListener applovinnativeadloadlistener, List list)
    {
        if (applovinnativeadloadlistener == null)
        {
            break MISSING_BLOCK_LABEL_11;
        }
        applovinnativeadloadlistener.onNativeAdsLoaded(list);
        return;
        applovinnativeadloadlistener;
        a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", applovinnativeadloadlistener);
        return;
    }

    private void a(AppLovinNativeAdPrecacheListener applovinnativeadprecachelistener, AppLovinNativeAd applovinnativead, int i, boolean flag)
    {
        if (applovinnativeadprecachelistener == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        if (flag)
        {
            try
            {
                applovinnativeadprecachelistener.onNativeAdVideoPrecachingFailed(applovinnativead, i);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (AppLovinNativeAdPrecacheListener applovinnativeadprecachelistener)
            {
                a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", applovinnativeadprecachelistener);
            }
            break MISSING_BLOCK_LABEL_45;
        }
        applovinnativeadprecachelistener.onNativeAdImagePrecachingFailed(applovinnativead, i);
        return;
    }

    private void a(AppLovinNativeAdPrecacheListener applovinnativeadprecachelistener, AppLovinNativeAd applovinnativead, boolean flag)
    {
        if (applovinnativeadprecachelistener == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        if (flag)
        {
            try
            {
                applovinnativeadprecachelistener.onNativeAdVideoPreceached(applovinnativead);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (AppLovinNativeAdPrecacheListener applovinnativeadprecachelistener)
            {
                a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", applovinnativeadprecachelistener);
            }
            break MISSING_BLOCK_LABEL_42;
        }
        applovinnativeadprecachelistener.onNativeAdImagesPrecached(applovinnativead);
        return;
    }

    private void b(List list, AppLovinNativeAdLoadListener applovinnativeadloadlistener)
    {
        list = new cf(a, list, new bj(this, applovinnativeadloadlistener));
        a.a().a(list, cr.a);
    }

    private void c(List list, AppLovinNativeAdLoadListener applovinnativeadloadlistener)
    {
        list = new ch(a, list, new bk(this, applovinnativeadloadlistener));
        a.a().a(list, cr.a);
    }

    public void a(List list, AppLovinNativeAdLoadListener applovinnativeadloadlistener)
    {
        int j = ((Integer)a.a(bw.aY)).intValue();
        if (j <= 0)
        {
            if (applovinnativeadloadlistener != null)
            {
                applovinnativeadloadlistener.onNativeAdsLoaded(list);
            }
        } else
        {
            list = (List)list;
            int i = list.size();
            if (i == 0)
            {
                if (applovinnativeadloadlistener != null)
                {
                    applovinnativeadloadlistener.onNativeAdsFailedToLoad(-700);
                    return;
                }
            } else
            {
                j = Math.min(j, i);
                List list1 = list.subList(0, j);
                b(list1, new bh(this, list1, applovinnativeadloadlistener, list.subList(j, i)));
                return;
            }
        }
    }

    public void loadNativeAds(int i, AppLovinNativeAdLoadListener applovinnativeadloadlistener)
    {
        Object obj = null;
        Object obj1 = b;
        obj1;
        JVM INSTR monitorenter ;
        AppLovinNativeAd applovinnativead;
        applovinnativead = obj;
        if (i != 1)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        applovinnativead = obj;
        if (a.d().e(NativeAdImpl.SPEC_NATIVE))
        {
            applovinnativead = (AppLovinNativeAd)a.d().b(NativeAdImpl.SPEC_NATIVE);
        }
        obj1;
        JVM INSTR monitorexit ;
        if (applovinnativead != null)
        {
            a(applovinnativeadloadlistener, Arrays.asList(new AppLovinNativeAd[] {
                applovinnativead
            }));
            return;
        } else
        {
            applovinnativeadloadlistener = new co(a, i, new be(this, applovinnativeadloadlistener));
            a.a().a(applovinnativeadloadlistener, cr.a);
            return;
        }
        applovinnativeadloadlistener;
        obj1;
        JVM INSTR monitorexit ;
        throw applovinnativeadloadlistener;
    }

    public void precacheResources(AppLovinNativeAd applovinnativead, AppLovinNativeAdPrecacheListener applovinnativeadprecachelistener)
    {
        if (applovinnativead.isImagePrecached())
        {
            applovinnativeadprecachelistener.onNativeAdImagesPrecached(applovinnativead);
            a(applovinnativead, applovinnativeadprecachelistener);
            return;
        } else
        {
            applovinnativead = a(applovinnativead);
            applovinnativead = new cf(a, applovinnativead, new bf(this, applovinnativeadprecachelistener));
            a.a().a(applovinnativead, cr.a);
            return;
        }
    }
}
