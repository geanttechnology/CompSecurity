// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            ir, jb, ia, jz, 
//            jx, jw

class nit> extends ir
{

    final boolean a;
    final boolean b;
    final ia c;
    final jw d;
    final jb e;
    private ir f;

    private ir a()
    {
        ir ir1 = f;
        if (ir1 != null)
        {
            return ir1;
        } else
        {
            ir ir2 = c.a(e, d);
            f = ir2;
            return ir2;
        }
    }

    public void a(jz jz1, Object obj)
    {
        if (b)
        {
            jz1.f();
            return;
        } else
        {
            a().a(jz1, obj);
            return;
        }
    }

    public Object b(jx jx1)
    {
        if (a)
        {
            jx1.n();
            return null;
        } else
        {
            return a().b(jx1);
        }
    }

    (jb jb1, boolean flag, boolean flag1, ia ia1, jw jw)
    {
        e = jb1;
        a = flag;
        b = flag1;
        c = ia1;
        d = jw;
        super();
    }
}
