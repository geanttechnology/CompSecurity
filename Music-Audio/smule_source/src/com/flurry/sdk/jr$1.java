// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.lang.reflect.Field;

// Referenced classes of package com.flurry.sdk:
//            jr, ir, ju, jw, 
//            ia, jx, jz

class d extends d
{

    final ir a;
    final ia b;
    final Field c;
    final jw d;
    final boolean e;
    final jr f;

    void a(jx jx, Object obj)
    {
        jx = ((jx) (a.b(jx)));
        if (jx != null || !e)
        {
            c.set(obj, jx);
        }
    }

    void a(jz jz, Object obj)
    {
        obj = c.get(obj);
        (new ju(b, a, d.b())).a(jz, obj);
    }

    eld(jr jr1, String s, boolean flag, boolean flag1, ia ia, Field field, jw jw1, 
            boolean flag2)
    {
        f = jr1;
        b = ia;
        c = field;
        d = jw1;
        e = flag2;
        super(s, flag, flag1);
        a = jr.a(f, b, c, d);
    }
}
