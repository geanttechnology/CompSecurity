// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.c.a;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.x;
import java.lang.reflect.Field;

// Referenced classes of package com.google.b.b.a:
//            i, l

final class d extends d
{

    final x a;
    final f b;
    final Field c;
    final a d;
    final boolean e;
    final i f;

    final void a(com.google.b.d.a a1, Object obj)
    {
        a1 = ((com.google.b.d.a) (a.a(a1)));
        if (a1 != null || !e)
        {
            c.set(obj, a1);
        }
    }

    final void a(c c1, Object obj)
    {
        obj = c.get(obj);
        (new l(b, a, d.b)).a(c1, obj);
    }

    public final boolean a(Object obj)
    {
        while (!h || c.get(obj) == obj) 
        {
            return false;
        }
        return true;
    }

    ld(i j, String s, boolean flag, boolean flag1, f f1, Field field, a a1, 
            boolean flag2)
    {
        f = j;
        b = f1;
        c = field;
        d = a1;
        e = flag2;
        super(s, flag, flag1);
        a = com.google.b.b.a.i.a(f, b, c, d);
    }
}
