// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.ca;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

// Referenced classes of package com.applovin.impl.adview:
//            w, ae, AdViewControllerImpl, u, 
//            ac, ad, y, z, 
//            aa, af, ab, v

class x extends Dialog
    implements w
{

    private final Activity a;
    private final AppLovinSdk b;
    private final AppLovinLogger c;
    private RelativeLayout d;
    private AppLovinAdView e;
    private Runnable f;
    private af g;
    private volatile boolean h;
    private volatile boolean i;

    x(AppLovinSdk applovinsdk, Activity activity)
    {
        super(activity, 0x1030010);
        g = null;
        h = false;
        i = false;
        if (applovinsdk == null)
        {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (activity == null)
        {
            throw new IllegalArgumentException("No activity specified");
        }
        b = applovinsdk;
        c = applovinsdk.getLogger();
        a = activity;
        f = new ae(this, null);
        e = new AppLovinAdView(applovinsdk, AppLovinAdSize.INTERSTITIAL, activity);
        e.setAutoDestroy(false);
        ((AdViewControllerImpl)e.getAdViewController()).setParentDialog(new WeakReference(this));
        requestWindowFeature(1);
        try
        {
            getWindow().setFlags(activity.getWindow().getAttributes().flags, activity.getWindow().getAttributes().flags);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AppLovinSdk applovinsdk)
        {
            c.e("InterstitialAdDialog", "Set window flags failed.", applovinsdk);
        }
    }

    private int a(int j)
    {
        return AppLovinSdkUtils.dpToPx(a, j);
    }

    static Runnable a(x x1)
    {
        return x1.f;
    }

    private void a()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        e.setLayoutParams(layoutparams);
        d = new RelativeLayout(a);
        d.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        d.setBackgroundColor(0xbb000000);
        d.addView(e);
        setContentView(d);
    }

    private void a(v v)
    {
        byte byte0 = 9;
        v = u.a(b, getContext(), v);
        v.setOnClickListener(new ac(this));
        ca ca1 = new ca(b);
        int k = a(ca1.l());
        Object obj = new android.widget.RelativeLayout.LayoutParams(k, k);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
        android.widget.RelativeLayout.LayoutParams layoutparams;
        int j;
        int l;
        int i1;
        if (ca1.y())
        {
            j = 9;
        } else
        {
            j = 11;
        }
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(j);
        v.a(k);
        l = a(ca1.n());
        i1 = a(ca1.p());
        ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(i1, l, i1, l);
        e.addView(v, ((android.view.ViewGroup.LayoutParams) (obj)));
        v.bringToFront();
        j = a((new ca(b)).r());
        obj = new View(a);
        ((View) (obj)).setBackgroundColor(0);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(k + j, k + j);
        layoutparams.addRule(10);
        if (ca1.x())
        {
            j = byte0;
        } else
        {
            j = 11;
        }
        layoutparams.addRule(j);
        layoutparams.setMargins(0, l - a(5), i1 - a(5), 0);
        ((View) (obj)).setOnClickListener(new ad(this, v));
        e.addView(((View) (obj)), layoutparams);
        ((View) (obj)).bringToFront();
    }

    static void a(x x1, v v)
    {
        x1.a(v);
    }

    static boolean a(x x1, boolean flag)
    {
        x1.i = flag;
        return flag;
    }

    static Activity b(x x1)
    {
        return x1.a;
    }

    static boolean b(x x1, boolean flag)
    {
        x1.h = flag;
        return flag;
    }

    static boolean c(x x1)
    {
        return x1.i;
    }

    static void d(x x1)
    {
        x1.Dialog.show();
    }

    static boolean e(x x1)
    {
        return x1.h;
    }

    static AppLovinAdView f(x x1)
    {
        return x1.e;
    }

    static AppLovinLogger g(x x1)
    {
        return x1.c;
    }

    public void a(af af1)
    {
        e.setAdDisplayListener(new y(this, af1));
        e.setAdClickListener(new z(this, af1));
        e.setAdVideoPlaybackListener(new aa(this, af1));
        g = af1;
        af1.a(true);
    }

    public void a(AppLovinAd applovinad)
    {
        a.runOnUiThread(new ab(this, applovinad));
    }

    public void dismiss()
    {
        if (g != null)
        {
            g.g();
        }
        if (e != null)
        {
            e.destroy();
        }
        g = null;
        e = null;
        super.dismiss();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a();
    }
}
