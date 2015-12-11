// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.widget.ImageView;
import com.mopub.common.c.a;
import com.mopub.common.d.d;
import com.mopub.common.d.m;
import com.mopub.mobileads.b.c;

public final class ai extends ImageView
{

    c a;
    boolean b;
    boolean c;
    private final android.widget.RelativeLayout.LayoutParams d;
    private final android.widget.RelativeLayout.LayoutParams e;
    private boolean f;
    private boolean g;

    public ai(Context context, int i, boolean flag, boolean flag1)
    {
        super(context);
        f = flag;
        g = flag1;
        setId((int)m.a());
        int j = com.mopub.common.d.d.b(200F, context);
        int k = com.mopub.common.d.d.b(42F, context);
        int l = com.mopub.common.d.d.b(16F, context);
        a = new c(context);
        setImageDrawable(a);
        d = new android.widget.RelativeLayout.LayoutParams(j, k);
        d.setMargins(l, l, l, l);
        d.addRule(8, i);
        d.addRule(7, i);
        e = new android.widget.RelativeLayout.LayoutParams(j, k);
        e.setMargins(l, l, l, l);
        e.addRule(3, i);
        e.addRule(14);
        a();
    }

    final void a()
    {
        if (!g)
        {
            setVisibility(8);
            return;
        }
        if (!b)
        {
            setVisibility(4);
            return;
        }
        if (c && f)
        {
            setVisibility(8);
            return;
        }
        switch (getResources().getConfiguration().orientation)
        {
        default:
            com.mopub.common.c.a.b("Unrecognized screen orientation: CTA button widget defaulting to portrait layout");
            setVisibility(0);
            setLayoutParams(e);
            return;

        case 2: // '\002'
            setVisibility(0);
            setLayoutParams(d);
            return;

        case 1: // '\001'
            setVisibility(0);
            setLayoutParams(e);
            return;

        case 0: // '\0'
            com.mopub.common.c.a.b("Screen orientation undefined: CTA button widget defaulting to portrait layout");
            setVisibility(0);
            setLayoutParams(e);
            return;

        case 3: // '\003'
            com.mopub.common.c.a.b("Screen orientation is deprecated ORIENTATION_SQUARE: CTA button widget defaulting to portrait layout");
            break;
        }
        setVisibility(0);
        setLayoutParams(e);
    }

    final String getCtaText()
    {
        return a.a;
    }

    protected final void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        a();
    }
}
