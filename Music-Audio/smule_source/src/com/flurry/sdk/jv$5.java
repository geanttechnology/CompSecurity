// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            ir, jv, jx, jy, 
//            jz

final class  extends ir
{

    public String a(jx jx1)
    {
        jy jy1 = jx1.f();
        if (jy1 == jy.i)
        {
            jx1.j();
            return null;
        }
        if (jy1 == jy.h)
        {
            return Boolean.toString(jx1.i());
        } else
        {
            return jx1.h();
        }
    }

    public volatile void a(jz jz1, Object obj)
    {
        a(jz1, (String)obj);
    }

    public void a(jz jz1, String s)
    {
        jz1.b(s);
    }

    public Object b(jx jx1)
    {
        return a(jx1);
    }

    ()
    {
    }
}
