// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            ir, ia, jx, jy, 
//            jz

class nit> extends ir
{

    final ia a;

    public Double a(jx jx1)
    {
        if (jx1.f() == jy.i)
        {
            jx1.j();
            return null;
        } else
        {
            return Double.valueOf(jx1.k());
        }
    }

    public void a(jz jz1, Number number)
    {
        if (number == null)
        {
            jz1.f();
            return;
        } else
        {
            double d = number.doubleValue();
            ia.a(a, d);
            jz1.a(number);
            return;
        }
    }

    public volatile void a(jz jz1, Object obj)
    {
        a(jz1, (Number)obj);
    }

    public Object b(jx jx1)
    {
        return a(jx1);
    }

    (ia ia1)
    {
        a = ia1;
        super();
    }
}
