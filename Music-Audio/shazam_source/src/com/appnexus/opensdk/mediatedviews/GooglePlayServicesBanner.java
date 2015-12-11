// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import com.appnexus.opensdk.MediatedBannerAdView;
import com.appnexus.opensdk.ad;
import com.appnexus.opensdk.at;
import com.appnexus.opensdk.b.b;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.c.a.a;
import com.google.android.gms.ads.d;
import com.google.android.gms.ads.e;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.appnexus.opensdk.mediatedviews:
//            GooglePlayAdListener

public class GooglePlayServicesBanner
    implements MediatedBannerAdView
{

    private android.app.Application.ActivityLifecycleCallbacks activityListener;
    private GooglePlayAdListener adListener;
    private e adView;
    private Activity adViewActivity;

    public GooglePlayServicesBanner()
    {
    }

    private c buildRequest(at at1)
    {
        com.google.android.gms.ads.c.a a1 = new com.google.android.gms.ads.c.a();
        static class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[com.appnexus.opensdk.k.c.values().length];
                try
                {
                    a[com.appnexus.opensdk.k.c.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.appnexus.opensdk.k.c.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.appnexus.opensdk.k.c.b.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.appnexus.opensdk.mediatedviews._cls2.a[at1.c.ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 136
    //                   2 145
    //                   3 154;
           goto _L1 _L2 _L3 _L4
_L1:
        Bundle bundle;
        bundle = new Bundle();
        if (at1.a != null)
        {
            bundle.putString("Age", at1.a);
        }
        if (at1.d != null)
        {
            a1.a(at1.d);
        }
        Pair pair;
        for (at1 = at1.b.iterator(); at1.hasNext(); bundle.putString((String)pair.first, (String)pair.second))
        {
            pair = (Pair)at1.next();
        }

        break; /* Loop/switch isn't completed */
_L2:
        a1.a(0);
        continue; /* Loop/switch isn't completed */
_L3:
        a1.a(2);
        continue; /* Loop/switch isn't completed */
_L4:
        a1.a(1);
        if (true) goto _L1; else goto _L5
_L5:
        a1.a(new a(bundle));
        return a1.a();
    }

    private void registerActivityCallbacks()
    {
        if (android.os.Build.VERSION.SDK_INT > 13)
        {
            activityListener = new android.app.Application.ActivityLifecycleCallbacks() {

                final GooglePlayServicesBanner a;

                public void onActivityCreated(Activity activity, Bundle bundle)
                {
                }

                public void onActivityDestroyed(Activity activity)
                {
                    if (a.adViewActivity == activity)
                    {
                        b.b(b.c, "GooglePlayServicesBanner - onActivityDestroyed");
                        if (a.adView != null)
                        {
                            a.adView.a();
                        }
                    }
                    activity.getApplication().unregisterActivityLifecycleCallbacks(this);
                }

                public void onActivityPaused(Activity activity)
                {
                    if (a.adViewActivity == activity)
                    {
                        b.b(b.c, "GooglePlayServicesBanner - onActivityPaused");
                        if (a.adView != null)
                        {
                            a.adView.b();
                        }
                    }
                }

                public void onActivityResumed(Activity activity)
                {
                    if (a.adViewActivity == activity)
                    {
                        b.b(b.c, "GooglePlayServicesBanner - onActivityResumed");
                        if (a.adView != null)
                        {
                            a.adView.c();
                        }
                    }
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
                {
                }

                public void onActivityStarted(Activity activity)
                {
                }

                public void onActivityStopped(Activity activity)
                {
                }

            
            {
                a = GooglePlayServicesBanner.this;
                super();
            }
            };
            adViewActivity.getApplication().registerActivityLifecycleCallbacks(activityListener);
        }
    }

    public void destroy()
    {
        if (adView != null)
        {
            adView.a();
            adView.setAdListener(null);
        }
        if (adViewActivity != null && activityListener != null && android.os.Build.VERSION.SDK_INT > 13)
        {
            adViewActivity.getApplication().unregisterActivityLifecycleCallbacks(activityListener);
        }
        adListener = null;
        adView = null;
    }

    public void onDestroy()
    {
        destroy();
    }

    public void onPause()
    {
        if (adView != null)
        {
            adView.b();
        }
    }

    public void onResume()
    {
        if (adView != null)
        {
            adView.c();
        }
    }

    public View requestAd(ad ad, Activity activity, String s, String s1, int i, int j, at at1)
    {
        adListener = new GooglePlayAdListener(ad, super.getClass().getSimpleName());
        adListener.a(String.format(" - requesting an ad: [%s, %s, %dx%d]", new Object[] {
            s, s1, Integer.valueOf(i), Integer.valueOf(j)
        }));
        adView = new e(activity);
        adView.setAdUnitId(s1);
        adView.setAdSize(new d(i, j));
        adView.setAdListener(adListener);
        try
        {
            adView.a(buildRequest(at1));
        }
        // Misplaced declaration of an exception variable
        catch (ad ad)
        {
            adListener.onAdFailedToLoad(3);
        }
        adViewActivity = activity;
        registerActivityCallbacks();
        return adView;
    }


}
