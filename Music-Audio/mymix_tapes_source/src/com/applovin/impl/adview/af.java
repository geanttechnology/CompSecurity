// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Intent;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.y;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package com.applovin.impl.adview:
//            aj, ai, x, ak, 
//            ag, ah, w

public class af
    implements AppLovinInterstitialAdDialog
{

    public static volatile boolean a = false;
    public static volatile boolean b = false;
    private static final Map c = Collections.synchronizedMap(new HashMap());
    private static volatile boolean n;
    private final String d;
    private final AppLovinSdkImpl e;
    private final Activity f;
    private volatile AppLovinAdLoadListener g;
    private volatile AppLovinAdDisplayListener h;
    private volatile AppLovinAdVideoPlaybackListener i;
    private volatile AppLovinAdClickListener j;
    private volatile AppLovinAdImpl k;
    private volatile com.applovin.impl.sdk.AppLovinAdImpl.AdTarget l;
    private volatile w m;

    af(AppLovinSdk applovinsdk, Activity activity)
    {
        if (applovinsdk == null)
        {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (activity == null)
        {
            throw new IllegalArgumentException("No activity specified");
        } else
        {
            e = (AppLovinSdkImpl)applovinsdk;
            d = UUID.randomUUID().toString();
            a = true;
            b = false;
            f = activity;
            c.put(d, this);
            return;
        }
    }

    public static af a(String s)
    {
        return (af)c.get(s);
    }

    private void a(int i1)
    {
        f.runOnUiThread(new aj(this, i1));
    }

    static void a(af af1)
    {
        af1.i();
    }

    static void a(af af1, int i1)
    {
        af1.a(i1);
    }

    static void a(af af1, AppLovinAd applovinad)
    {
        af1.a(applovinad);
    }

    private void a(AppLovinAd applovinad)
    {
        f.runOnUiThread(new ai(this, applovinad));
    }

    static void b(af af1)
    {
        af1.h();
    }

    static AppLovinAdLoadListener c(af af1)
    {
        return af1.g;
    }

    static w d(af af1)
    {
        return af1.m;
    }

    private void h()
    {
        x x1 = new x(e, f);
        x1.a(this);
        m = x1;
        x1.a(k);
    }

    private void i()
    {
        Intent intent = new Intent(f, com/applovin/adview/AppLovinInterstitialActivity);
        intent.putExtra("com.applovin.interstitial.wrapper_id", d);
        AppLovinInterstitialActivity.lastKnownWrapper = this;
        f.startActivity(intent);
        a(true);
    }

    public AppLovinSdk a()
    {
        return e;
    }

    public void a(w w)
    {
        m = w;
    }

    public void a(boolean flag)
    {
        n = flag;
    }

    public AppLovinAd b()
    {
        return k;
    }

    public AppLovinAdVideoPlaybackListener c()
    {
        return i;
    }

    public AppLovinAdDisplayListener d()
    {
        return h;
    }

    public void dismiss()
    {
        if (m != null)
        {
            f.runOnUiThread(new ak(this));
        }
    }

    public AppLovinAdClickListener e()
    {
        return j;
    }

    public com.applovin.impl.sdk.AppLovinAdImpl.AdTarget f()
    {
        return l;
    }

    public void g()
    {
        a = false;
        b = true;
        c.remove(d);
    }

    public boolean isAdReadyToDisplay()
    {
        return e.getAdService().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
    }

    public boolean isShowing()
    {
        return n;
    }

    public void setAdClickListener(AppLovinAdClickListener applovinadclicklistener)
    {
        j = applovinadclicklistener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener applovinaddisplaylistener)
    {
        h = applovinaddisplaylistener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener applovinadloadlistener)
    {
        g = applovinadloadlistener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener applovinadvideoplaybacklistener)
    {
        i = applovinadvideoplaybacklistener;
    }

    public void show()
    {
        e.getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, new ag(this));
    }

    public void showAndRender(AppLovinAd applovinad)
    {
        if (isShowing())
        {
            e.getLogger().userError("AppLovinInterstitialAdDialog", "Attempted to show an interstitial while one is already displayed; ignoring.");
        } else
        {
            k = (AppLovinAdImpl)applovinad;
            if (k != null)
            {
                applovinad = k.getTarget();
            } else
            {
                applovinad = com.applovin.impl.sdk.AppLovinAdImpl.AdTarget.DEFAULT;
            }
            l = applovinad;
            if (!AppLovinSdkUtils.isValidString(k.getVideoFilename()) || e.getFileManager().a(k.getVideoFilename(), f))
            {
                boolean flag1 = com.applovin.impl.sdk.n.a(com/applovin/adview/AppLovinInterstitialActivity, f);
                boolean flag;
                if (l == com.applovin.impl.sdk.AppLovinAdImpl.AdTarget.ACTIVITY_LANDSCAPE || l == com.applovin.impl.sdk.AppLovinAdImpl.AdTarget.ACTIVITY_PORTRAIT)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                f.runOnUiThread(new ah(this, flag1, flag));
                return;
            }
        }
    }

}
