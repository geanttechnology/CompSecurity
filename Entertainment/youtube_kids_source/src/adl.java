// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

final class adl
    implements android.view.View.OnClickListener
{

    private alu a;
    private boolean b;
    private adk c;

    adl(adk adk1, alu alu, boolean flag)
    {
        c = adk1;
        a = alu;
        b = flag;
        super();
    }

    public final void onClick(View view)
    {
        if (c.a.i() != amj.f || a != c.a.j())
        {
            return;
        }
        if (b)
        {
            c.a.a();
            return;
        } else
        {
            c.a.a(true);
            return;
        }
    }
}
