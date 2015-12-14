// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdUpdateListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.applovin.impl.sdk:
//            AppLovinSdkImpl, i, c, b, 
//            cm, cr, cq, bw, 
//            j, AppLovinAdImpl, h, bm, 
//            e, PostbackServiceImpl

public class AppLovinAdServiceImpl
    implements AppLovinAdService
{

    public static String URI_NO_OP = "/adservice/no_op";
    public static String URI_TRACK_CLICK_IMMEDIATELY = "/adservice/track_click_now";
    private final AppLovinSdkImpl a;
    private final AppLovinLogger b;
    private Handler c;
    private final Map d = new HashMap(2);

    AppLovinAdServiceImpl(AppLovinSdkImpl applovinsdkimpl)
    {
        if (applovinsdkimpl == null)
        {
            throw new IllegalArgumentException("No sdk specified");
        }
        a = applovinsdkimpl;
        b = applovinsdkimpl.getLogger();
        c = new Handler(Looper.getMainLooper());
        AppLovinAdType applovinadtype;
        for (applovinsdkimpl = AppLovinAdType.allTypes().iterator(); applovinsdkimpl.hasNext(); d.put(applovinadtype, new HashMap()))
        {
            applovinadtype = (AppLovinAdType)applovinsdkimpl.next();
        }

        ((Map)d.get(AppLovinAdType.REGULAR)).put(AppLovinAdSize.BANNER, new i(AppLovinAdSize.BANNER, null));
        ((Map)d.get(AppLovinAdType.REGULAR)).put(AppLovinAdSize.MREC, new i(AppLovinAdSize.MREC, null));
        ((Map)d.get(AppLovinAdType.REGULAR)).put(AppLovinAdSize.INTERSTITIAL, new i(AppLovinAdSize.INTERSTITIAL, null));
        ((Map)d.get(AppLovinAdType.REGULAR)).put(AppLovinAdSize.LEADER, new i(AppLovinAdSize.LEADER, null));
        ((Map)d.get(AppLovinAdType.INCENTIVIZED)).put(AppLovinAdSize.INTERSTITIAL, new i(AppLovinAdSize.INTERSTITIAL, null));
    }

    static Handler a(AppLovinAdServiceImpl applovinadserviceimpl)
    {
        return applovinadserviceimpl.c;
    }

    private void a(Uri uri, AppLovinAdImpl applovinadimpl, AppLovinAdView applovinadview, AdViewControllerImpl adviewcontrollerimpl)
    {
        adviewcontrollerimpl.removeClickTrackingOverlay();
        expireAdLoadState(applovinadimpl);
        AppLovinSdkUtils.openUri(applovinadview.getContext(), uri, a);
        adviewcontrollerimpl.dismissInterstitialIfRequired();
    }

    static void a(AppLovinAdServiceImpl applovinadserviceimpl, Uri uri, AppLovinAdImpl applovinadimpl, AppLovinAdView applovinadview, AdViewControllerImpl adviewcontrollerimpl)
    {
        applovinadserviceimpl.a(uri, applovinadimpl, applovinadview, adviewcontrollerimpl);
    }

    static void a(AppLovinAdServiceImpl applovinadserviceimpl, AppLovinAdSize applovinadsize, AppLovinAdType applovinadtype, AppLovinAdLoadListener applovinadloadlistener)
    {
        applovinadserviceimpl.a(applovinadsize, applovinadtype, applovinadloadlistener);
    }

    private void a(AppLovinAdSize applovinadsize, AppLovinAdType applovinadtype, AppLovinAdLoadListener applovinadloadlistener)
    {
        c c1 = new c(applovinadsize, applovinadtype);
        AppLovinAd applovinad = (AppLovinAd)a.c().b(c1);
        if (applovinad != null)
        {
            b.d("AppLovinAdService", (new StringBuilder()).append("Using pre-loaded ad: ").append(applovinad).append(" for size ").append(applovinadsize).append(" and type ").append(applovinadtype).toString());
            applovinadloadlistener.adReceived(applovinad);
        } else
        {
            applovinadsize = new cm(applovinadsize, applovinadtype, applovinadloadlistener, a);
            a.a().a(applovinadsize, cr.a);
        }
        a.c().f(c1);
    }

    private boolean a()
    {
        return ((PowerManager)a.getApplicationContext().getSystemService("power")).isScreenOn();
    }

    static boolean a(AppLovinAdServiceImpl applovinadserviceimpl, AppLovinAdSize applovinadsize)
    {
        return applovinadserviceimpl.a(applovinadsize);
    }

    private boolean a(AppLovinAdSize applovinadsize)
    {
        if (applovinadsize == AppLovinAdSize.BANNER)
        {
            return ((Boolean)a.a(bw.z)).booleanValue();
        }
        if (applovinadsize == AppLovinAdSize.MREC)
        {
            return ((Boolean)a.a(bw.B)).booleanValue();
        }
        if (applovinadsize == AppLovinAdSize.LEADER)
        {
            return ((Boolean)a.a(bw.D)).booleanValue();
        } else
        {
            return false;
        }
    }

    private boolean a(AppLovinAdSize applovinadsize, AppLovinAdType applovinadtype)
    {
        boolean flag = true;
        if (((Boolean)a.a(bw.G)).booleanValue())
        {
            if (applovinadtype.equals(AppLovinAdType.INCENTIVIZED))
            {
                if (((Boolean)a.a(bw.aD)).booleanValue() && ((Boolean)a.a(bw.K)).booleanValue())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return flag;
            }
            if (applovinadsize.equals(AppLovinAdSize.INTERSTITIAL))
            {
                if (!((Boolean)a.a(bw.aE)).booleanValue() || !((String)a.a(bw.J)).contains(AppLovinAdSize.INTERSTITIAL.getLabel()))
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }

    static long b(AppLovinAdServiceImpl applovinadserviceimpl, AppLovinAdSize applovinadsize)
    {
        return applovinadserviceimpl.b(applovinadsize);
    }

    private long b(AppLovinAdSize applovinadsize)
    {
        if (applovinadsize == AppLovinAdSize.BANNER)
        {
            return ((Long)a.a(bw.A)).longValue();
        }
        if (applovinadsize == AppLovinAdSize.MREC)
        {
            return ((Long)a.a(bw.C)).longValue();
        }
        if (applovinadsize == AppLovinAdSize.LEADER)
        {
            return ((Long)a.a(bw.E)).longValue();
        } else
        {
            return 0L;
        }
    }

    static AppLovinLogger b(AppLovinAdServiceImpl applovinadserviceimpl)
    {
        return applovinadserviceimpl.b;
    }

    static AppLovinSdkImpl c(AppLovinAdServiceImpl applovinadserviceimpl)
    {
        return applovinadserviceimpl.a;
    }

    static void c(AppLovinAdServiceImpl applovinadserviceimpl, AppLovinAdSize applovinadsize)
    {
        applovinadserviceimpl.c(applovinadsize);
    }

    private void c(AppLovinAdSize applovinadsize)
    {
        long l = b(applovinadsize);
        if (l > 0L)
        {
            applovinadsize = new j(this, applovinadsize);
            a.a().a(applovinadsize, cr.a, (l + 2L) * 1000L);
        }
    }

    static Map d(AppLovinAdServiceImpl applovinadserviceimpl)
    {
        return applovinadserviceimpl.d;
    }

    static boolean e(AppLovinAdServiceImpl applovinadserviceimpl)
    {
        return applovinadserviceimpl.a();
    }

    public void addAdUpdateListener(AppLovinAdUpdateListener applovinadupdatelistener)
    {
        addAdUpdateListener(applovinadupdatelistener, AppLovinAdSize.BANNER);
    }

    public void addAdUpdateListener(AppLovinAdUpdateListener applovinadupdatelistener, AppLovinAdSize applovinadsize)
    {
        i k;
        if (applovinadupdatelistener == null)
        {
            throw new IllegalArgumentException("No ad listener specified");
        }
        k = (i)((Map)d.get(AppLovinAdType.REGULAR)).get(applovinadsize);
        Object obj = k.b;
        obj;
        JVM INSTR monitorenter ;
        if (i.b(k).contains(applovinadupdatelistener))
        {
            break MISSING_BLOCK_LABEL_146;
        }
        i.b(k).add(applovinadupdatelistener);
        boolean flag = true;
        b.d("AppLovinAdService", (new StringBuilder()).append("Added update listener: ").append(applovinadupdatelistener).toString());
_L1:
        obj;
        JVM INSTR monitorexit ;
        if (flag)
        {
            applovinadupdatelistener = new j(this, applovinadsize);
            a.a().a(applovinadupdatelistener, cr.a);
        }
        return;
        applovinadupdatelistener;
        obj;
        JVM INSTR monitorexit ;
        throw applovinadupdatelistener;
        flag = false;
          goto _L1
    }

    public void expireAdLoadState(AppLovinAd applovinad)
    {
        if (applovinad == null)
        {
            throw new IllegalArgumentException("No ad specified");
        }
        applovinad = (AppLovinAdImpl)applovinad;
        i k = (i)((Map)d.get(applovinad.getType())).get(applovinad.getSize());
        synchronized (k.b)
        {
            k.c = null;
            k.d = 0L;
        }
        return;
        exception;
        applovinad;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean hasPreloadedAd(AppLovinAdSize applovinadsize)
    {
        return a.c().e(new c(applovinadsize, AppLovinAdType.REGULAR));
    }

    public void loadNextAd(AppLovinAdSize applovinadsize, AppLovinAdLoadListener applovinadloadlistener)
    {
        loadNextAd(applovinadsize, AppLovinAdType.REGULAR, applovinadloadlistener);
    }

    public void loadNextAd(AppLovinAdSize applovinadsize, AppLovinAdType applovinadtype, AppLovinAdLoadListener applovinadloadlistener)
    {
        Object obj1;
        boolean flag;
        flag = true;
        if (applovinadsize == null)
        {
            throw new IllegalArgumentException("No ad size specified");
        }
        if (applovinadloadlistener == null)
        {
            throw new IllegalArgumentException("No callback specified");
        }
        if (applovinadtype == null)
        {
            throw new IllegalArgumentException("No ad type specificed");
        }
        if (applovinadsize.equals(AppLovinAdSize.BANNER) || applovinadsize.equals(AppLovinAdSize.MREC) || applovinadsize.equals(AppLovinAdSize.LEADER))
        {
            a.getLogger().userError("AppLovinAdService", "Banners, MRecs and Leaderboards are deprecated and will be removed in a future SDK version!");
        }
        obj1 = (i)((Map)d.get(applovinadtype)).get(applovinadsize);
        Object obj = ((i) (obj1)).b;
        obj;
        JVM INSTR monitorenter ;
        if (System.currentTimeMillis() <= ((i) (obj1)).d)
        {
            flag = false;
        }
        if (((i) (obj1)).c == null || flag) goto _L2; else goto _L1
_L1:
        applovinadsize = ((i) (obj1)).c;
_L3:
        obj;
        JVM INSTR monitorexit ;
        if (applovinadsize != null)
        {
            applovinadloadlistener.adReceived(applovinadsize);
        }
        return;
_L2:
        b.d("AppLovinAdService", "Loading next ad...");
        i.a(((i) (obj1))).add(applovinadloadlistener);
        if (((i) (obj1)).e)
        {
            break MISSING_BLOCK_LABEL_364;
        }
        obj1.e = true;
        obj1 = new h(this, (i)((Map)d.get(applovinadtype)).get(applovinadsize), null);
        if (!a(applovinadsize, applovinadtype))
        {
            break MISSING_BLOCK_LABEL_333;
        }
        if (!a.c().a(new c(applovinadsize, applovinadtype), obj1))
        {
            break MISSING_BLOCK_LABEL_306;
        }
        b.d("AppLovinAdService", "Attaching load listener to initial preload task...");
        applovinadsize = null;
          goto _L3
        b.d("AppLovinAdService", "Skipped attach of initial preload callback.");
        a(applovinadsize, applovinadtype, ((AppLovinAdLoadListener) (obj1)));
        applovinadsize = null;
          goto _L3
        b.d("AppLovinAdService", "Task merge not necessary.");
        a(applovinadsize, applovinadtype, ((AppLovinAdLoadListener) (obj1)));
        break MISSING_BLOCK_LABEL_364;
        applovinadsize;
        obj;
        JVM INSTR monitorexit ;
        throw applovinadsize;
        applovinadsize = null;
          goto _L3
    }

    public void preloadAd(AppLovinAdSize applovinadsize)
    {
        a.c().f(new c(applovinadsize, AppLovinAdType.REGULAR));
    }

    public void removeAdUpdateListener(AppLovinAdUpdateListener applovinadupdatelistener, AppLovinAdSize applovinadsize)
    {
        if (applovinadupdatelistener == null)
        {
            return;
        }
        i k = (i)((Map)d.get(AppLovinAdType.REGULAR)).get(applovinadsize);
        synchronized (k.b)
        {
            i.b(k).remove(applovinadupdatelistener);
        }
        b.d("AppLovinAdService", (new StringBuilder()).append("Removed update listener: ").append(applovinadupdatelistener).toString());
        return;
        applovinadupdatelistener;
        applovinadsize;
        JVM INSTR monitorexit ;
        throw applovinadupdatelistener;
    }

    public void trackClickOn(AppLovinAd applovinad, AppLovinAdView applovinadview, AdViewControllerImpl adviewcontrollerimpl, Uri uri)
    {
        applovinad = (AppLovinAdImpl)applovinad;
        String s = applovinad.getSupplementalClickTrackingUrl();
        if (AppLovinSdkUtils.isValidString(s))
        {
            a.getPersistentPostbackManager().a(s, null);
        }
        a(uri, applovinad, applovinadview, adviewcontrollerimpl);
    }

    public void trackForegroundClick(AppLovinAd applovinad, AppLovinAdView applovinadview, AdViewControllerImpl adviewcontrollerimpl, Uri uri)
    {
        if (applovinad == null)
        {
            throw new IllegalArgumentException("No ad specified");
        } else
        {
            AppLovinAdImpl applovinadimpl = (AppLovinAdImpl)applovinad;
            b.d("AppLovinAdService", "Tracking foreground click on an ad...");
            int k = ((Integer)a.a(bw.bp)).intValue();
            int l = ((Integer)a.a(bw.bq)).intValue();
            int i1 = ((Integer)a.a(bw.br)).intValue();
            a.getPostbackService().dispatchPostbackAsync(((AppLovinAdImpl)applovinad).getSupplementalClickTrackingUrl(), null, k, l, i1, new e(this, adviewcontrollerimpl, uri, applovinadimpl, applovinadview));
            return;
        }
    }

}
