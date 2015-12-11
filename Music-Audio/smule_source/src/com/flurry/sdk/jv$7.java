// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.math.BigInteger;

// Referenced classes of package com.flurry.sdk:
//            ir, jv, jx, jy, 
//            io, jz

final class  extends ir
{

    public BigInteger a(jx jx1)
    {
        if (jx1.f() == jy.i)
        {
            jx1.j();
            return null;
        }
        try
        {
            jx1 = new BigInteger(jx1.h());
        }
        // Misplaced declaration of an exception variable
        catch (jx jx1)
        {
            throw new io(jx1);
        }
        return jx1;
    }

    public volatile void a(jz jz1, Object obj)
    {
        a(jz1, (BigInteger)obj);
    }

    public void a(jz jz1, BigInteger biginteger)
    {
        jz1.a(biginteger);
    }

    public Object b(jx jx1)
    {
        return a(jx1);
    }

    ()
    {
    }
}
