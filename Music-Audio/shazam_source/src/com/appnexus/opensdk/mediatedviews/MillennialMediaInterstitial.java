// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import android.util.Pair;
import com.appnexus.opensdk.MediatedInterstitialAdView;
import com.appnexus.opensdk.af;
import com.appnexus.opensdk.at;
import com.appnexus.opensdk.b.b;
import com.millennialmedia.android.ab;
import com.millennialmedia.android.ah;
import com.millennialmedia.android.am;
import com.millennialmedia.android.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package com.appnexus.opensdk.mediatedviews:
//            MillennialMediaListener

public class MillennialMediaInterstitial
    implements MediatedInterstitialAdView
{

    private ah iad;
    private MillennialMediaListener mmListener;

    public MillennialMediaInterstitial()
    {
    }

    public void destroy()
    {
        try
        {
            iad.a(null);
        }
        catch (NullPointerException nullpointerexception) { }
        iad = null;
        mmListener = null;
    }

    public boolean isReady()
    {
        return iad != null && iad.c();
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

    public void requestAd(af af1, Activity activity, String s, String s1, at at1)
    {
        mmListener = new MillennialMediaListener(af1, super.getClass().getSimpleName());
        mmListener.a(String.format("requesting an interstitial ad: [%s, %s]", new Object[] {
            s, s1
        }));
        an.h(activity);
        iad = new ah(activity);
        iad.a(s1);
        iad.a(new MillennialMediaListener(af1, super.getClass().getSimpleName()));
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
        JVM INSTR tableswitch 1 3: default 136
    //                   1 211
    //                   2 220
    //                   3 229;
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
        activity.a(s);
        if (at1.d != null)
        {
            am.a(at1.d);
        }
        if (!iad.c())
        {
            af1 = iad;
            if (((ah) (af1)).a != null && ((ah) (af1)).a.c != null)
            {
                af1.a(activity, ((ah) (af1)).a.c);
                return;
            } else
            {
                af1.b();
                return;
            }
        } else
        {
            activity = mmListener;
            b.d(b.c, (new StringBuilder()).append(((MillennialMediaListener) (activity)).a).append(" - ").append("ad was available from cache. show it instead of fetching").toString());
            af1.c();
            return;
        }
    }

    public void show()
    {
        mmListener.a("show called");
        if (iad == null)
        {
            mmListener.b("show called while interstitial ad view was null");
            return;
        }
        if (!iad.c())
        {
            mmListener.b("show called while interstitial ad view was unavailable");
            return;
        }
        if (iad.d())
        {
            mmListener.a("display called successfully");
            return;
        } else
        {
            mmListener.b("display call failed");
            return;
        }
    }
}
