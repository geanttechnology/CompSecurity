// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services.for;

import android.content.Context;
import io.presage.Presage;
import io.presage.services.do.c;
import io.presage.services.e;

// Referenced classes of package io.presage.services.for:
//            d, j

public abstract class a extends d
    implements j
{

    protected c a;
    private io.presage.utils.do.a b;
    private Context c;
    private String d;
    private e e;

    public a(c c1, String s)
    {
        a = c1;
        d = s;
        e = io.presage.services.e.c();
        c = Presage.getInstance().getContext();
        b = Presage.getInstance().getWS();
    }

    public final c a()
    {
        return a;
    }

    public final void b()
    {
        if (a.c())
        {
            b.a(d, a.g());
            if (a.f())
            {
                e.a(true);
            } else
            {
                e.a(false);
            }
        }
        a.b();
    }

    public final boolean c()
    {
        boolean flag = true;
        if (Presage.getInstance().getId() == null)
        {
            e.g();
            e.a(true);
            flag = false;
        }
        return flag;
    }

    public final Context d()
    {
        if (c == null)
        {
            c = Presage.getInstance().getContext();
        }
        return c;
    }

    public void e()
    {
        a.h();
    }

    public final e f()
    {
        return e;
    }

    public int g()
    {
        return 0;
    }
}
