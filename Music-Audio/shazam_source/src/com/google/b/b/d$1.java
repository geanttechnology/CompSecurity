// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b;

import com.google.b.d.a;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.x;

// Referenced classes of package com.google.b.b:
//            d

final class t> extends x
{

    final boolean a;
    final boolean b;
    final f c;
    final com.google.b.c.a d;
    final d e;
    private x f;

    private x a()
    {
        x x1 = f;
        if (x1 != null)
        {
            return x1;
        } else
        {
            x x2 = c.a(e, d);
            f = x2;
            return x2;
        }
    }

    public final Object a(a a1)
    {
        if (a)
        {
            a1.o();
            return null;
        } else
        {
            return a().a(a1);
        }
    }

    public final void a(c c1, Object obj)
    {
        if (b)
        {
            c1.f();
            return;
        } else
        {
            a().a(c1, obj);
            return;
        }
    }

    (d d1, boolean flag, boolean flag1, f f1, com.google.b.c.a a1)
    {
        e = d1;
        a = flag;
        b = flag1;
        c = f1;
        d = a1;
        super();
    }
}
