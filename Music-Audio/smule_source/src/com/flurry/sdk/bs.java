// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.flurry.android.AdCreative;
import com.flurry.android.AdNetworkView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

// Referenced classes of package com.flurry.sdk:
//            gd, hn, r

public final class bs extends AdNetworkView
{

    private static final String a = com/flurry/sdk/bs.getSimpleName();
    private final String b;
    private final String c;
    private final boolean d;
    private AdView e;
    private AdListener f;

    public bs(Context context, r r, AdCreative adcreative, Bundle bundle)
    {
        super(context, r, adcreative);
        b = bundle.getString("com.flurry.gms.ads.MY_AD_UNIT_ID");
        c = bundle.getString("com.flurry.gms.ads.MYTEST_AD_DEVICE_ID");
        d = bundle.getBoolean("com.flurry.gms.ads.test");
        setFocusable(true);
    }

    private AdSize a(int i, int j)
    {
        if (i >= 728 && j >= 90)
        {
            return AdSize.LEADERBOARD;
        }
        if (i >= 468 && j >= 60)
        {
            return AdSize.FULL_BANNER;
        }
        if (i >= 320 && j >= 50)
        {
            return AdSize.BANNER;
        }
        if (i >= 300 && j >= 250)
        {
            return AdSize.MEDIUM_RECTANGLE;
        } else
        {
            gd.a(3, a, "Could not find GMS AdSize that matches size");
            return null;
        }
    }

    private AdSize a(Context context, int i, int j)
    {
        int k;
        int l;
label0:
        {
            l = hn.i();
            int i1 = hn.h();
            if (i > 0)
            {
                k = i;
                if (i <= i1)
                {
                    break label0;
                }
            }
            k = i1;
        }
label1:
        {
            if (j > 0)
            {
                i = j;
                if (j <= l)
                {
                    break label1;
                }
            }
            i = l;
        }
        return a(k, i);
    }

    static String a()
    {
        return a;
    }

    AdListener getAdListener()
    {
        return f;
    }

    AdView getAdView()
    {
        return e;
    }

    public void initLayout()
    {
        gd.a(4, a, "GMS AdView initLayout.");
        Object obj = getContext();
        int i = getAdCreative().getWidth();
        int j = getAdCreative().getHeight();
        AdSize adsize = a(((Context) (obj)), i, j);
        if (adsize == null)
        {
            gd.a(6, a, (new StringBuilder()).append("Could not find GMS AdSize that matches {width = ").append(i).append(", height ").append(j).append("}").toString());
            return;
        }
        gd.a(3, a, (new StringBuilder()).append("Determined GMS AdSize as ").append(adsize).append(" that best matches {width = ").append(i).append(", height = ").append(j).append("}").toString());
        f = new a();
        e = new AdView(((Context) (obj)));
        e.setAdSize(adsize);
        e.setAdUnitId(b);
        e.setAdListener(f);
        setGravity(17);
        addView(e, new android.widget.RelativeLayout.LayoutParams(adsize.getWidthInPixels(((Context) (obj))), adsize.getHeightInPixels(((Context) (obj)))));
        obj = new com.google.android.gms.ads.AdRequest.Builder();
        if (d)
        {
            gd.a(3, a, "GMS AdView set to Test Mode.");
            ((com.google.android.gms.ads.AdRequest.Builder) (obj)).addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
            if (!TextUtils.isEmpty(c))
            {
                ((com.google.android.gms.ads.AdRequest.Builder) (obj)).addTestDevice(c);
            }
        }
        e.loadAd(((com.google.android.gms.ads.AdRequest.Builder) (obj)).build());
    }

    public void onActivityDestroy()
    {
        gd.a(4, a, "GMS AdView onDestroy.");
        if (e != null)
        {
            e.destroy();
            e = null;
        }
        super.onActivityDestroy();
    }


    private class a extends AdListener
    {

        final bs a;

        public void onAdClosed()
        {
            a.onAdClosed(Collections.emptyMap());
            gd.a(4, bs.a(), "GMS AdView onAdClosed.");
        }

        public void onAdFailedToLoad(int i)
        {
            a.onRenderFailed(Collections.emptyMap());
            gd.a(5, bs.a(), (new StringBuilder()).append("GMS AdView onAdFailedToLoad: ").append(i).append(".").toString());
        }

        public void onAdLeftApplication()
        {
            a.onAdClicked(Collections.emptyMap());
            gd.a(4, bs.a(), "GMS AdView onAdLeftApplication.");
        }

        public void onAdLoaded()
        {
            a.onAdShown(Collections.emptyMap());
            gd.a(4, bs.a(), "GMS AdView onAdLoaded.");
        }

        public void onAdOpened()
        {
            gd.a(4, bs.a(), "GMS AdView onAdOpened.");
        }

        private a()
        {
            a = bs.this;
            super();
        }

    }

}
