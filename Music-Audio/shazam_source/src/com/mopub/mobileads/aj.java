// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import com.mopub.common.c.a;
import com.mopub.common.d.d;

public final class aj extends ImageView
{

    com.mopub.common.d.c.a a;
    private int b;
    private boolean c;
    private boolean d;

    public aj(Context context, android.graphics.drawable.GradientDrawable.Orientation orientation, com.mopub.common.d.c.a a1, boolean flag, int i, int j, int k)
    {
        super(context);
        a = a1;
        b = i;
        c = flag;
        setImageDrawable(new GradientDrawable(orientation, new int[] {
            com.mopub.mobileads.b.d.c.a, com.mopub.mobileads.b.d.c.b
        }));
        context = new android.widget.RelativeLayout.LayoutParams(-1, com.mopub.common.d.d.b(72F, context));
        context.addRule(j, k);
        setLayoutParams(context);
        b();
    }

    private void b()
    {
        if (d)
        {
            if (c)
            {
                setVisibility(b);
                return;
            } else
            {
                setVisibility(8);
                return;
            }
        }
        if (a == com.mopub.common.d.c.a.a)
        {
            setVisibility(4);
            return;
        }
        if (a == com.mopub.common.d.c.a.b)
        {
            setVisibility(0);
            return;
        }
        switch (getResources().getConfiguration().orientation)
        {
        default:
            com.mopub.common.c.a.b("Unrecognized screen orientation: do not show gradient strip widget");
            setVisibility(4);
            return;

        case 2: // '\002'
            setVisibility(0);
            return;

        case 1: // '\001'
            setVisibility(4);
            return;

        case 0: // '\0'
            com.mopub.common.c.a.b("Screen orientation undefined: do not show gradient strip widget");
            setVisibility(4);
            return;

        case 3: // '\003'
            com.mopub.common.c.a.b("Screen orientation is deprecated ORIENTATION_SQUARE: do not show gradient strip widget");
            break;
        }
        setVisibility(4);
    }

    final void a()
    {
        d = true;
        b();
    }

    protected final void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        b();
    }
}
