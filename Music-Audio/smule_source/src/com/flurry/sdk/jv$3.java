// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            ir, jv, jx, jy, 
//            io, jd, jz

final class der extends ir
{

    public Number a(jx jx1)
    {
        jy jy1 = jx1.f();
        switch (.a[jy1.ordinal()])
        {
        case 2: // '\002'
        case 3: // '\003'
        default:
            throw new io((new StringBuilder()).append("Expecting number, got: ").append(jy1).toString());

        case 4: // '\004'
            jx1.j();
            return null;

        case 1: // '\001'
            return new jd(jx1.h());
        }
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

    der()
    {
    }
}
