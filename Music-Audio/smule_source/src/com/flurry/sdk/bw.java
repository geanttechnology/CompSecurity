// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.flurry.android.AdCreative;
import com.flurry.android.AdNetworkView;
import com.inmobi.commons.InMobi;
import com.inmobi.monetization.IMBanner;
import com.inmobi.monetization.IMBannerListener;

// Referenced classes of package com.flurry.sdk:
//            gd, hn, bx, r

public final class bw extends AdNetworkView
{

    private static final String a = com/flurry/sdk/bw.getSimpleName();
    private final String b;
    private IMBanner c;
    private IMBannerListener d;

    bw(Context context, r r, AdCreative adcreative, Bundle bundle)
    {
        super(context, r, adcreative);
        b = bundle.getString("com.flurry.inmobi.MY_APP_ID");
        InMobi.initialize((Activity)getContext(), b);
        setFocusable(true);
    }

    static String a()
    {
        return a;
    }

    IMBannerListener getAdListener()
    {
        return d;
    }

    IMBanner getAdView()
    {
        return c;
    }

    public void initLayout()
    {
        gd.a(3, a, "InMobi initLayout");
        int k = getAdCreative().getWidth();
        int l = getAdCreative().getHeight();
        int i1 = hn.i();
        int j = hn.h();
        int i = j;
        if (k > 0)
        {
            if (k > j)
            {
                i = j;
            } else
            {
                i = k;
            }
        }
        j = i1;
        if (l > 0)
        {
            if (l > i1)
            {
                j = i1;
            } else
            {
                j = l;
            }
        }
        i1 = bx.a(new Point(i, j));
        if (-1 != i1)
        {
            c = new IMBanner((Activity)getContext(), b, i1);
            j = 320;
            i = 50;
            Point point = bx.a(i1);
            if (point != null)
            {
                j = point.x;
                i = point.y;
            }
            gd.a(3, a, (new StringBuilder()).append("Determined InMobi AdSize as ").append(j).append("x").append(i).toString());
            float f = hn.d().density;
            j = (int)((float)j * f + 0.5F);
            i = (int)((float)i * f + 0.5F);
            c.setLayoutParams(new android.widget.LinearLayout.LayoutParams(j, i));
            d = new a();
            c.setIMBannerListener(d);
            setGravity(17);
            addView(c);
            c.setRefreshInterval(-1);
            c.loadBanner();
            return;
        } else
        {
            gd.a(3, a, (new StringBuilder()).append("Could not find InMobi AdSize that matches size ").append(k).append("x").append(l).toString());
            gd.a(3, a, "Could not load InMobi Ad");
            return;
        }
    }

    public void onActivityDestroy()
    {
        gd.a(3, a, "InMobi onDestroy");
        if (c != null)
        {
            c.destroy();
            c = null;
        }
        super.onActivityDestroy();
    }


    private class a
        implements IMBannerListener
    {

        final bw a;

        public void onBannerInteraction(IMBanner imbanner, Map map)
        {
            a.onAdClicked(Collections.emptyMap());
            gd.a(3, bw.a(), "InMobi onBannerInteraction");
        }

        public void onBannerRequestFailed(IMBanner imbanner, IMErrorCode imerrorcode)
        {
            a.onRenderFailed(Collections.emptyMap());
            gd.a(3, bw.a(), (new StringBuilder()).append("InMobi imAdView ad request failed. ").append(imerrorcode.toString()).toString());
        }

        public void onBannerRequestSucceeded(IMBanner imbanner)
        {
            a.onAdShown(Collections.emptyMap());
            gd.a(3, bw.a(), "InMobi imAdView ad request completed.");
        }

        public void onDismissBannerScreen(IMBanner imbanner)
        {
            a.onAdClosed(Collections.emptyMap());
            gd.a(3, bw.a(), "InMobi imAdView dismiss ad.");
        }

        public void onLeaveApplication(IMBanner imbanner)
        {
            gd.a(3, bw.a(), "InMobi onLeaveApplication");
        }

        public void onShowBannerScreen(IMBanner imbanner)
        {
            a.onAdClicked(Collections.emptyMap());
            gd.a(3, bw.a(), "InMobi imAdView ad shown.");
        }

        private a()
        {
            a = bw.this;
            super();
        }

    }

}
