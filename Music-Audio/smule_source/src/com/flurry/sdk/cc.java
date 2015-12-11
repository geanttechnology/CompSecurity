// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.millennialmedia.android.MMInterstitial;
import com.millennialmedia.android.RequestListener;

// Referenced classes of package com.flurry.sdk:
//            bd, gd, r

public final class cc extends bd
{

    private static final String b = com/flurry/sdk/cc.getSimpleName();
    private boolean c;
    private final String d;
    private MMInterstitial e;
    private RequestListener f;

    public cc(Context context, r r, Bundle bundle)
    {
        super(context, r);
        d = bundle.getString("com.flurry.millennial.MYAPIDINTERSTITIAL");
    }

    static boolean a(cc cc1)
    {
        return cc1.c;
    }

    static MMInterstitial b(cc cc1)
    {
        return cc1.e;
    }

    static String b()
    {
        return b;
    }

    public void a()
    {
        e = new MMInterstitial((Activity)c());
        e.setApid(d);
        f = new a();
        e.setListener(f);
        e.fetch();
        c = e.display();
        if (c)
        {
            gd.a(3, b, (new StringBuilder()).append("Millennial MMAdView Interstitial ad displayed immediately:").append(System.currentTimeMillis()).append(" ").append(c).toString());
            return;
        } else
        {
            gd.a(3, b, (new StringBuilder()).append("Millennial MMAdView Interstitial ad did not display immediately:").append(System.currentTimeMillis()).append(" ").append(c).toString());
            return;
        }
    }


    private class a
        implements RequestListener
    {

        final cc a;

        public void MMAdOverlayClosed(MMAd mmad)
        {
            a.c(Collections.emptyMap());
            gd.a(3, cc.b(), "Millennial MMAdView Interstitial overlay closed.");
        }

        public void MMAdOverlayLaunched(MMAd mmad)
        {
            a.a(Collections.emptyMap());
            gd.a(3, cc.b(), (new StringBuilder()).append("Millennial MMAdView Interstitial overlay launched.").append(System.currentTimeMillis()).toString());
        }

        public void MMAdRequestIsCaching(MMAd mmad)
        {
            gd.a(3, cc.b(), "Millennial MMAdView Interstitial request is caching.");
        }

        public void onSingleTap(MMAd mmad)
        {
            a.b(Collections.emptyMap());
            gd.a(3, cc.b(), "Millennial MMAdView Interstitial tapped.");
        }

        public void requestCompleted(MMAd mmad)
        {
            gd.a(3, cc.b(), (new StringBuilder()).append("Millennial MMAdView returned interstitial ad: ").append(System.currentTimeMillis()).toString());
            if (!cc.a(a))
            {
                cc.b(a).display();
            }
        }

        public void requestFailed(MMAd mmad, MMException mmexception)
        {
            a.d(Collections.emptyMap());
            gd.a(3, cc.b(), "Millennial MMAdView Interstitial failed to load ad.");
        }

        private a()
        {
            a = cc.this;
            super();
        }

    }

}
