// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import com.flurry.android.AdCreative;
import com.flurry.android.AdNetworkView;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.RequestListener;

// Referenced classes of package com.flurry.sdk:
//            gd, cb, r

public final class ca extends AdNetworkView
{

    private static final String a = com/flurry/sdk/ca.getSimpleName();
    private final String b;
    private final String c;
    private MMAdView d;
    private RequestListener e;

    public ca(Context context, r r, AdCreative adcreative, Bundle bundle)
    {
        super(context, r, adcreative);
        b = bundle.getString("com.flurry.millennial.MYAPID");
        c = bundle.getString("com.flurry.millennial.MYAPIDRECTANGLE");
        setFocusable(true);
    }

    static String a()
    {
        return a;
    }

    RequestListener getAdListener()
    {
        return e;
    }

    MMAdView getAdView()
    {
        return d;
    }

    public void initLayout()
    {
        gd.a(3, a, "Millennial initLayout");
        int j = getAdCreative().getWidth();
        int k = getAdCreative().getHeight();
        int i = cb.a(new Point(j, k));
        if (-1 == i)
        {
            gd.a(3, a, (new StringBuilder()).append("Could not find Millennial AdSize that matches size ").append(j).append("x").append(k).toString());
            gd.a(3, a, "Could not load Millennial Ad");
            return;
        }
        Point point = cb.a(i);
        if (point == null)
        {
            gd.a(3, a, (new StringBuilder()).append("Could not find Millennial AdSize that matches size ").append(j).append("x").append(k).toString());
            gd.a(3, a, "Could not load Millennial Ad");
            return;
        }
        j = point.x;
        k = point.y;
        gd.a(3, a, (new StringBuilder()).append("Determined Millennial AdSize as ").append(j).append("x").append(k).toString());
        d = new MMAdView((Activity)getContext());
        setId(MMSDK.getDefaultAdId());
        d.setApid(b);
        if (2 == i)
        {
            d.setApid(c);
        }
        d.setWidth(j);
        d.setHeight(k);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setGravity(17);
        e = new a();
        d.setListener(e);
        addView(d);
        d.getAd();
    }

    public void onActivityDestroy()
    {
        gd.a(3, a, "Millennial onDestroy");
        if (d != null)
        {
            d = null;
        }
        super.onActivityDestroy();
    }


    private class a
        implements RequestListener
    {

        final ca a;

        public void MMAdOverlayClosed(MMAd mmad)
        {
            gd.a(3, ca.a(), "Millennial MMAdView banner overlay closed.");
        }

        public void MMAdOverlayLaunched(MMAd mmad)
        {
            gd.a(3, ca.a(), "Millennial MMAdView banner overlay launched.");
        }

        public void MMAdRequestIsCaching(MMAd mmad)
        {
            gd.a(3, ca.a(), "Millennial MMAdView banner request is caching.");
        }

        public void onSingleTap(MMAd mmad)
        {
            a.onAdClicked(Collections.emptyMap());
            gd.a(3, ca.a(), "Millennial MMAdView banner tapped.");
        }

        public void requestCompleted(MMAd mmad)
        {
            a.onAdShown(Collections.emptyMap());
            gd.a(3, ca.a(), (new StringBuilder()).append("Millennial MMAdView returned ad.").append(System.currentTimeMillis()).toString());
        }

        public void requestFailed(MMAd mmad, MMException mmexception)
        {
            a.onRenderFailed(Collections.emptyMap());
            gd.a(3, ca.a(), (new StringBuilder()).append("Millennial MMAdView failed to load ad with error: ").append(mmexception).toString());
        }

        private a()
        {
            a = ca.this;
            super();
        }

    }

}
