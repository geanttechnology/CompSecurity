// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.FlurryAds;
import com.google.a.a.b.a;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.ads:
//            d

public class c extends RelativeLayout
{

    private static final String a = com/smule/pianoandroid/ads/c.getName();
    private long b;
    private String c;

    public c(Context context, String s)
    {
        super(context);
        c = s;
    }

    static String a()
    {
        return a;
    }

    static String a(c c1)
    {
        return c1.c;
    }

    static long b(c c1)
    {
        return c1.b;
    }

    public void a(long l, a a1, ViewGroup viewgroup)
    {
        aa.a(a, (new StringBuilder()).append("Starting ad request ").append(c).toString());
        b = l;
        FlurryAds.setAdListener(new d(this, a1, viewgroup));
        FlurryAds.fetchAd(getContext(), c, viewgroup, FlurryAdSize.BANNER_TOP);
    }

    public void setVisibility(int i)
    {
        super.setVisibility(i);
        if (i != 0)
        {
            FlurryAds.removeAd(getContext(), c, this);
        }
    }

}
