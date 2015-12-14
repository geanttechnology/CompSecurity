// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.SoftReference;

// Referenced classes of package com.applovin.impl.sdk:
//            AppLovinSdkImpl, AppLovinAdServiceImpl, aa, AppLovinAdImpl, 
//            y, bw, aq, de, 
//            cr, cq, ab, ao, 
//            ae

public class z
{

    private static String k = null;
    private final AppLovinSdkImpl a;
    private final AppLovinAdServiceImpl b;
    private AppLovinAdImpl c;
    private SoftReference d;
    private final Handler e = new Handler(Looper.getMainLooper());
    private final Object f = new Object();
    private volatile String g;
    private de h;
    private volatile boolean i;
    private SoftReference j;

    public z(AppLovinSdk applovinsdk)
    {
        i = false;
        a = (AppLovinSdkImpl)applovinsdk;
        b = (AppLovinAdServiceImpl)applovinsdk.getAdService();
    }

    static AppLovinAdImpl a(z z1, AppLovinAdImpl applovinadimpl)
    {
        z1.c = applovinadimpl;
        return applovinadimpl;
    }

    public static void a(String s)
    {
        k = s;
    }

    static boolean a(z z1)
    {
        return z1.i;
    }

    static boolean a(z z1, boolean flag)
    {
        z1.i = flag;
        return flag;
    }

    static de b(z z1)
    {
        return z1.h;
    }

    public static String b()
    {
        return k;
    }

    static Handler c(z z1)
    {
        return z1.e;
    }

    static AppLovinSdkImpl d(z z1)
    {
        return z1.a;
    }

    private void e()
    {
        if (d != null)
        {
            AppLovinAdLoadListener applovinadloadlistener = (AppLovinAdLoadListener)d.get();
            if (applovinadloadlistener != null)
            {
                applovinadloadlistener.failedToReceiveAd(-300);
            }
        }
    }

    private AppLovinAdRewardListener f()
    {
        return new aa(this);
    }

    public void a(Activity activity, AppLovinAdRewardListener applovinadrewardlistener, AppLovinAdVideoPlaybackListener applovinadvideoplaybacklistener, AppLovinAdDisplayListener applovinaddisplaylistener, AppLovinAdClickListener applovinadclicklistener)
    {
        if (applovinadrewardlistener == null)
        {
            applovinadrewardlistener = f();
        }
        if (a())
        {
            if (AppLovinSdkUtils.isValidString(c.getVideoFilename()) && !a.getFileManager().a(c.getVideoFilename(), activity))
            {
                return;
            }
            if (((Boolean)a.a(bw.ah)).booleanValue())
            {
                aq aq1 = new aq(a, this);
                aq1.a(activity);
                aq1.a(applovinaddisplaylistener);
                aq1.a(applovinadclicklistener);
                aq1.a(applovinadvideoplaybacklistener);
                aq1.a(applovinadrewardlistener);
                aq1.a();
                return;
            } else
            {
                b(activity, applovinadrewardlistener, applovinadvideoplaybacklistener, applovinaddisplaylistener, applovinadclicklistener);
                return;
            }
        } else
        {
            a.getLogger().userError("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
            e();
            return;
        }
    }

    void a(AppLovinAd applovinad, AppLovinAdRewardListener applovinadrewardlistener)
    {
        h = new de(a, applovinad, applovinadrewardlistener);
        a.a().a(h, cr.b);
    }

    public void a(AppLovinAdLoadListener applovinadloadlistener)
    {
        d = new SoftReference(applovinadloadlistener);
        if (a())
        {
            a.getLogger().userError("IncentivizedAdController", "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
            if (applovinadloadlistener != null)
            {
                applovinadloadlistener.adReceived(c);
            }
            return;
        } else
        {
            b.loadNextAd(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, new ab(this, applovinadloadlistener));
            return;
        }
    }

    void a(AppLovinAdRewardListener applovinadrewardlistener)
    {
        applovinadrewardlistener.userDeclinedToViewAd(c);
    }

    void a(String s, Activity activity)
    {
        if (s != null && ((Boolean)a.a(bw.ai)).booleanValue())
        {
            (new ao(a, activity, s)).a();
        }
    }

    public boolean a()
    {
        return c != null;
    }

    void b(Activity activity, AppLovinAdRewardListener applovinadrewardlistener, AppLovinAdVideoPlaybackListener applovinadvideoplaybacklistener, AppLovinAdDisplayListener applovinaddisplaylistener, AppLovinAdClickListener applovinadclicklistener)
    {
        if (a())
        {
            AppLovinAdImpl applovinadimpl = c;
            if (applovinadimpl.getType().equals(AppLovinAdType.INCENTIVIZED))
            {
                AppLovinInterstitialAdDialog applovininterstitialaddialog = AppLovinInterstitialAd.create(a, activity);
                activity = new ae(this, activity, applovinadrewardlistener, applovinadvideoplaybacklistener, applovinaddisplaylistener, applovinadclicklistener, null);
                applovininterstitialaddialog.setAdDisplayListener(activity);
                applovininterstitialaddialog.setAdVideoPlaybackListener(activity);
                applovininterstitialaddialog.setAdClickListener(activity);
                applovininterstitialaddialog.showAndRender(applovinadimpl);
                j = new SoftReference(applovininterstitialaddialog);
                a(applovinadimpl, activity);
                return;
            } else
            {
                a.getLogger().e("IncentivizedAdController", (new StringBuilder()).append("Attempted to render an ad of type ").append(c.getType()).append(" in an Incentivized Ad interstitial.").toString());
                applovinadvideoplaybacklistener.videoPlaybackEnded(c, 0.0D, false);
                return;
            }
        } else
        {
            a.getLogger().userError("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
            e();
            return;
        }
    }

    void b(String s)
    {
        synchronized (f)
        {
            g = s;
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    String c()
    {
        String s;
        synchronized (f)
        {
            s = g;
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void d()
    {
        if (j != null)
        {
            AppLovinInterstitialAdDialog applovininterstitialaddialog = (AppLovinInterstitialAdDialog)j.get();
            if (applovininterstitialaddialog != null)
            {
                applovininterstitialaddialog.dismiss();
            }
        }
    }

}
