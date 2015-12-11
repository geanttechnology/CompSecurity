// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            ir, jv, jx, jy, 
//            jz

final class  extends ir
{

    public Boolean a(jx jx1)
    {
        if (jx1.f() == jy.i)
        {
            jx1.j();
            return null;
        }
        if (jx1.f() == jy.f)
        {
            return Boolean.valueOf(Boolean.parseBoolean(jx1.h()));
        } else
        {
            return Boolean.valueOf(jx1.i());
        }
    }

    public void a(jz jz1, Boolean boolean1)
    {
        if (boolean1 == null)
        {
            jz1.f();
            return;
        } else
        {
            jz1.a(boolean1.booleanValue());
            return;
        }
    }

    public volatile void a(jz jz1, Object obj)
    {
        a(jz1, (Boolean)obj);
    }

    public Object b(jx jx1)
    {
        return a(jx1);
    }

    ()
    {
    }
}
