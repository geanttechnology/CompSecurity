// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import android.content.res.Resources;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import com.appnexus.opensdk.MediatedBannerAdView;
import com.appnexus.opensdk.at;
import com.millennialmedia.android.ad;
import com.millennialmedia.android.am;
import com.millennialmedia.android.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package com.appnexus.opensdk.mediatedviews:
//            MillennialMediaListener

public class MillennialMediaBanner
    implements MediatedBannerAdView
{

    ad adView;

    public MillennialMediaBanner()
    {
        adView = null;
    }

    public void destroy()
    {
        if (adView != null)
        {
            try
            {
                adView.setListener(null);
            }
            catch (NullPointerException nullpointerexception) { }
            adView = null;
        }
    }

    public void onDestroy()
    {
        destroy();
    }

    public void onPause()
    {
    }

    public void onResume()
    {
    }

    public View requestAd(com.appnexus.opensdk.ad ad1, Activity activity, String s, String s1, int i, int j, at at1)
    {
        ad1 = new MillennialMediaListener(ad1, super.getClass().getSimpleName());
        ad1.a(String.format("requesting an ad: [%s, %s, %dx%d]", new Object[] {
            s, s1, Integer.valueOf(i), Integer.valueOf(j)
        }));
        an.h(activity);
        adView = new ad(activity);
        adView.setApid(s1);
        adView.setWidth(i);
        adView.setHeight(j);
        activity = activity.getResources().getDisplayMetrics();
        activity = new android.view.ViewGroup.LayoutParams((int)TypedValue.applyDimension(1, i, activity), (int)TypedValue.applyDimension(1, j, activity));
        adView.setLayoutParams(activity);
        activity = new am();
        static class _cls1
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

        _cls1.a[at1.c.ordinal()];
        JVM INSTR tableswitch 1 3: default 184
    //                   1 259
    //                   2 268
    //                   3 277;
           goto _L1 _L2 _L3 _L4
_L1:
        if (at1.a != null)
        {
            activity.a = at1.a;
        }
        s = new HashMap();
        Pair pair;
        for (s1 = at1.b.iterator(); s1.hasNext(); s.put(pair.first, pair.second))
        {
            pair = (Pair)s1.next();
        }

        break; /* Loop/switch isn't completed */
_L2:
        activity.e = "other";
        continue; /* Loop/switch isn't completed */
_L3:
        activity.e = "female";
        continue; /* Loop/switch isn't completed */
_L4:
        activity.e = "male";
        if (true) goto _L1; else goto _L5
_L5:
        if (at1.d != null)
        {
            am.a(at1.d);
        }
        activity.a(s);
        adView.setMMRequest(activity);
        adView.setListener(ad1);
        adView.getAd();
        return adView;
    }
}
