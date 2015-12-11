// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.support.v4.view.co;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.offerup.android.activities:
//            PostPostingHelpActivity

final class fy
    implements co
{

    private PostPostingHelpActivity a;

    private fy(PostPostingHelpActivity postpostinghelpactivity)
    {
        a = postpostinghelpactivity;
        super();
    }

    fy(PostPostingHelpActivity postpostinghelpactivity, byte byte0)
    {
        this(postpostinghelpactivity);
    }

    public final void a(int i)
    {
        if (i == 0)
        {
            a.c.setVisibility(8);
            a.d.setVisibility(0);
            a.f.setText("skip");
            a.e.setImageResource(0x7f02019a);
            return;
        } else
        {
            a.c.setVisibility(0);
            a.d.setVisibility(4);
            a.f.setText("done");
            a.e.setImageResource(0x7f02019c);
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
