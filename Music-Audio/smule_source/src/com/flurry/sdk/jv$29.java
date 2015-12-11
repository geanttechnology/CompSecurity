// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            ir, jv, jx, jy, 
//            io, jz

final class tException extends ir
{

    public Number a(jx jx1)
    {
        if (jx1.f() == jy.i)
        {
            jx1.j();
            return null;
        }
        int i;
        try
        {
            i = jx1.m();
        }
        // Misplaced declaration of an exception variable
        catch (jx jx1)
        {
            throw new io(jx1);
        }
        return Integer.valueOf(i);
    }

    public void a(jz jz1, Number number)
    {
        jz1.a(number);
    }

    public volatile void a(jz jz1, Object obj)
    {
        a(jz1, (Number)obj);
    }

    public Object b(jx jx1)
    {
        return a(jx1);
    }

    tException()
    {
    }
}
