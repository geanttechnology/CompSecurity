// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

public abstract class bxg extends bxf
    implements android.view.View.OnClickListener, bn
{

    private final bqe a;
    private s b;
    private dre c;

    public bxg(bqe bqe1, bov bov, bxe bxe)
    {
        super(bov, bxe);
        a = (bqe)b.a(bqe1);
        b = null;
    }

    public View a(bxh bxh, bsn bsn1)
    {
        super.a(bxh, (bvz)bsn1);
        c = bsn1.c();
        return null;
    }

    public volatile View a(bxh bxh, bvz bvz1)
    {
        return a(bxh, (bsn)bvz1);
    }

    public final void a()
    {
        if (c != null)
        {
            a.a(c);
        }
    }

    public void onClick(View view)
    {
        a();
    }
}
