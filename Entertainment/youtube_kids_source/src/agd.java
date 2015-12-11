// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class agd
    implements bn
{

    private final ViewGroup a;
    private final TextView b;
    private final byc c;
    private final byc d;
    private blo e;

    agd(TextView textview, byc byc1, ViewGroup viewgroup)
    {
        this(textview, byc1, ((byc) (null)), viewgroup);
    }

    agd(TextView textview, byc byc1, ViewGroup viewgroup, blo blo)
    {
        this(textview, byc1, ((byc) (null)), viewgroup);
        e = blo;
    }

    agd(TextView textview, byc byc1, byc byc2, ViewGroup viewgroup)
    {
        b = (TextView)b.a(textview);
        c = (byc)b.a(byc1);
        a = (ViewGroup)b.a(viewgroup);
        d = byc2;
        e = new agf(this);
    }

    public final View a(age age1)
    {
        b.setText(age1.a);
        if (age1.c != null)
        {
            int i = b.getContext().getResources().getDimensionPixelSize(0x7f0a00fb);
            if (age1.c.a(-1) != null)
            {
                if (age1.c.a(-1).b > i * 2 && age1.b != null)
                {
                    c.a(age1.b, e);
                } else
                {
                    c.a(age1.c, e);
                }
            }
        }
        if (age1.b != null && d != null)
        {
            d.a(age1.b, null);
        }
        return a;
    }
}
