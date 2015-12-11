// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.i;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.facebook.ads.a;
import com.facebook.ads.a.b.u;
import com.facebook.ads.c;
import com.facebook.ads.j;
import com.facebook.ads.k;
import com.shazam.android.advert.ShazamAdView;
import com.shazam.android.advert.l;
import com.shazam.android.util.h.b;
import com.shazam.android.widget.image.UrlCachingImageView;
import com.shazam.model.advert.AdvertSiteIdKey;
import java.util.Arrays;
import java.util.Map;

// Referenced classes of package com.shazam.android.advert.i:
//            a, d, c

public final class e extends LinearLayout
    implements c, com.shazam.android.advert.i.a
{

    private final TextView a;
    private final TextView b;
    private final UrlCachingImageView c;
    private final j d;
    private final TextView e;
    private final RatingBar f;
    private final LinearLayout g;
    private l h;
    private k i;

    public e(Context context)
    {
        super(context);
        h = l.b;
        setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        View view = LayoutInflater.from(context).inflate(0x7f03008c, this, true);
        a = (TextView)view.findViewById(0x7f1101fc);
        b = (TextView)view.findViewById(0x7f1101fe);
        e = (TextView)view.findViewById(0x7f1101ff);
        c = (UrlCachingImageView)view.findViewById(0x7f1101fb);
        f = (RatingBar)view.findViewById(0x7f1101fd);
        g = (LinearLayout)view.findViewById(0x7f1101fa);
        d = new j(context, (byte)0);
        d.setId(0x7f11000f);
        addView(d);
        setVisibility(8);
        setOrientation(1);
        setBackgroundResource(0x106000b);
    }

    private ShazamAdView getShazamAdView()
    {
        return (ShazamAdView)getParent();
    }

    private void setRating(com.facebook.ads.k.c c1)
    {
        if (c1 != null && c1.b > 0.0D)
        {
            f.setVisibility(0);
            int i1 = (int)Math.round(c1.b);
            f.setNumStars(i1);
            f.setRating(Math.round(c1.a));
            f.setStepSize(0.5F);
            return;
        } else
        {
            f.setVisibility(8);
            return;
        }
    }

    public final void a(a a1)
    {
        setVisibility(0);
        a.setText(i.e());
        b.setText(i.g());
        e.setText(i.f());
        a1 = i;
        com.facebook.ads.k.a a2;
        if (!a1.b())
        {
            a1 = null;
        } else
        {
            a1 = ((k) (a1)).b.n();
        }
        setRating(a1);
        a1 = c;
        a2 = i.c();
        if (a2 != null)
        {
            a1.a(a2.a).c();
        }
        d.setNativeAd(i);
        i.a(this, Arrays.asList(new View[] {
            d, b
        }));
    }

    public final void a(a a1, com.facebook.ads.b b1)
    {
    }

    public final void a(String s, AdvertSiteIdKey advertsiteidkey, Map map)
    {
        i = new k(getContext(), s);
        i.a = new d(new c[] {
            this, new com.shazam.android.advert.i.c(getShazamAdView(), s, h)
        });
        h.a();
        i.a();
    }

    public final void b()
    {
    }

    public final void b(a a1)
    {
    }

    public final void d()
    {
        h = l.b;
    }

    public final void h_()
    {
    }

    public final void i_()
    {
    }

    protected final void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (i != null)
        {
            i.i();
        }
    }

    protected final void onMeasure(int i1, int j1)
    {
        i1 = Math.min(getDefaultSize(getResources().getDisplayMetrics().widthPixels, i1), com.shazam.android.util.h.b.a(300));
        g.measure(android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000), j1);
        e.measure(android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000), j1);
        j1 = (int)((double)i1 * 0.5625D);
        d.measure(android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(j1, 0x40000000));
        setMeasuredDimension(android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(j1 + (g.getMeasuredHeight() + e.getMeasuredHeight()), 0x40000000));
    }

    public final void setListener(l l1)
    {
        h = l1;
    }
}
