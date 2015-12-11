// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.support.v4.view.co;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.offerup.android.activities:
//            PrePostingHelpActivity

final class gd
    implements co
{

    private PrePostingHelpActivity a;

    private gd(PrePostingHelpActivity prepostinghelpactivity)
    {
        a = prepostinghelpactivity;
        super();
    }

    gd(PrePostingHelpActivity prepostinghelpactivity, byte byte0)
    {
        this(prepostinghelpactivity);
    }

    public final void a(int i)
    {
        if (i == 0)
        {
            a.c.setVisibility(8);
            a.d.setVisibility(0);
            a.f.setText("skip");
            a.e.setImageResource(0x7f02019b);
            return;
        }
        if (i > 0 && i < 2)
        {
            a.c.setVisibility(0);
            a.d.setVisibility(0);
            a.f.setText("skip");
            a.e.setImageResource(0x7f02019d);
            return;
        } else
        {
            a.c.setVisibility(0);
            a.d.setVisibility(4);
            a.f.setText("done");
            a.e.setImageResource(0x7f02019e);
            return;
        }
    }

    public final void a(int i, float f, int j)
    {
    }

    public final void b(int i)
    {
    }
}
