// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

final class xk
    implements android.view.View.OnClickListener
{

    private xg a;

    xk(xg xg1)
    {
        a = xg1;
        super();
    }

    public final void onClick(View view)
    {
        boolean flag = xg.a(a, xg.a(a).l());
        btu btu;
        String s;
        if (flag)
        {
            xg.a(a).b();
        } else
        {
            xg.a(a).a();
        }
        view = a;
        btu = xg.b(a).a;
        s = xg.b(a).b;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        xg.a(view, btu, s, flag);
    }
}
