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
import com.appnexus.opensdk.b.k;
import com.google.android.gms.ads.a.c;
import com.google.android.gms.ads.a.d;
import com.google.android.gms.ads.c.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.appnexus.opensdk.mediatedviews:
//            GooglePlayAdListener

public class GooglePlayDFPBanner
    implements MediatedBannerAdView
{
    class DFBBannerSSParameters
    {

        public boolean a;
        public String b;
        public boolean c;
        final GooglePlayDFPBanner d;

        private static boolean a(JSONObject jsonobject, String s)
        {
            boolean flag = false;
            boolean flag1 = jsonobject.getBoolean(s);
            flag = flag1;
_L2:
            return flag;
            JSONException jsonexception;
            jsonexception;
            int i;
            try
            {
                i = jsonobject.getInt(s);
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                return false;
            }
            switch (i)
            {
            default:
                return false;

            case 1: // '\001'
                return true;

            case 0: // '\0'
                break;
            }
            if (true) goto _L2; else goto _L1
_L1:
        }

        public DFBBannerSSParameters(String s)
        {
            d = GooglePlayDFPBanner.this;
            super();
            a = false;
            c = false;
            if (k.a(s))
            {
                break MISSING_BLOCK_LABEL_55;
            }
            googleplaydfpbanner = new JSONObject(s);
            c = a(GooglePlayDFPBanner.this, "smartbanner");
            a = a(GooglePlayDFPBanner.this, "swipeable");
            return;
            googleplaydfpbanner;
        }
    }


    private android.app.Application.ActivityLifecycleCallbacks activityListener;
    private GooglePlayAdListener adListener;
    private d adView;
    private Activity adViewActivity;

    public GooglePlayDFPBanner()
    {
    }

    private c buildRequest(DFBBannerSSParameters dfbbannerssparameters, at at1)
    {
        com.google.android.gms.ads.a.c.a a1;
        a1 = new com.google.android.gms.ads.a.c.a();
        if (dfbbannerssparameters.b != null && dfbbannerssparameters.b.length() > 0)
        {
            adListener.a((new StringBuilder("test device ")).append(dfbbannerssparameters.b).toString());
            a1.a(dfbbannerssparameters.b);
        }
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
        JVM INSTR tableswitch 1 3: default 96
    //                   1 188
    //                   2 197
    //                   3 206;
           goto _L1 _L2 _L3 _L4
_L1:
        dfbbannerssparameters = new Bundle();
        if (at1.a != null)
        {
            dfbbannerssparameters.putString("Age", at1.a);
        }
        if (at1.d != null)
        {
            a1.a(at1.d);
        }
        Pair pair;
        for (at1 = at1.b.iterator(); at1.hasNext(); dfbbannerssparameters.putString((String)pair.first, (String)pair.second))
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
        a1.a(new a(dfbbannerssparameters));
        return a1.a();
    }

    private void registerActivityCallbacks()
    {
        if (android.os.Build.VERSION.SDK_INT > 13)
        {
            activityListener = new android.app.Application.ActivityLifecycleCallbacks() {

                final GooglePlayDFPBanner a;

                public void onActivityCreated(Activity activity, Bundle bundle)
                {
                }

                public void onActivityDestroyed(Activity activity)
                {
                    if (a.adViewActivity == activity)
                    {
                        b.b(b.c, "GooglePlayDFPBanner - onActivityDestroyed");
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
                        b.b(b.c, "GooglePlayDFPBanner - onActivityPaused");
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
                        b.b(b.c, "GooglePlayDFPBanner - onActivityResumed");
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
                a = GooglePlayDFPBanner.this;
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
        s = new DFBBannerSSParameters(s);
        if (((DFBBannerSSParameters) (s)).c)
        {
            ad = com.google.android.gms.ads.d.g;
        } else
        {
            ad = new com.google.android.gms.ads.d(i, j);
        }
        adView = new d(activity);
        adView.setAdUnitId(s1);
        adView.setAdSizes(new com.google.android.gms.ads.d[] {
            ad
        });
        adView.setAdListener(adListener);
        adView.a(buildRequest(s, at1));
        adViewActivity = activity;
        registerActivityCallbacks();
        return adView;
    }


}
