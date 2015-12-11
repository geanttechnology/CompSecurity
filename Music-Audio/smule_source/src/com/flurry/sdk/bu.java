// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

// Referenced classes of package com.flurry.sdk:
//            bd, gd, r

public final class bu extends bd
{

    private static final String b = com/flurry/sdk/bu.getSimpleName();
    private final String c;
    private final String d;
    private final boolean e;
    private final InterstitialAd f = new InterstitialAd(c());
    private final AdListener g = new a();

    public bu(Context context, r r, Bundle bundle)
    {
        super(context, r);
        c = bundle.getString("com.flurry.gms.ads.MY_AD_UNIT_ID");
        d = bundle.getString("com.flurry.gms.ads.MYTEST_AD_DEVICE_ID");
        e = bundle.getBoolean("com.flurry.gms.ads.test");
        f.setAdUnitId(c);
        f.setAdListener(g);
    }

    static InterstitialAd a(bu bu1)
    {
        return bu1.f;
    }

    static String b()
    {
        return b;
    }

    public void a()
    {
        com.google.android.gms.ads.AdRequest.Builder builder = new com.google.android.gms.ads.AdRequest.Builder();
        if (e)
        {
            gd.a(3, b, "GMS AdView set to Test Mode.");
            builder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
            if (!TextUtils.isEmpty(d))
            {
                builder.addTestDevice(d);
            }
        }
        f.loadAd(builder.build());
    }


    private class a extends AdListener
    {

        final bu a;

        public void onAdClosed()
        {
            a.c(Collections.emptyMap());
            gd.a(4, bu.b(), "GMS AdView onAdClosed.");
        }

        public void onAdFailedToLoad(int i)
        {
            a.d(Collections.emptyMap());
            gd.a(5, bu.b(), (new StringBuilder()).append("GMS AdView onAdFailedToLoad: ").append(i).append(".").toString());
        }

        public void onAdLeftApplication()
        {
            a.b(Collections.emptyMap());
            gd.a(4, bu.b(), "GMS AdView onAdLeftApplication.");
        }

        public void onAdLoaded()
        {
            a.a(Collections.emptyMap());
            gd.a(4, bu.b(), "GMS AdView onAdLoaded.");
            bu.a(a).show();
        }

        public void onAdOpened()
        {
            gd.a(4, bu.b(), "GMS AdView onAdOpened.");
        }

        private a()
        {
            a = bu.this;
            super();
        }

    }

}
