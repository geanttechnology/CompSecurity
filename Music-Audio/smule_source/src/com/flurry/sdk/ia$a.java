// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            ir, jz, jx

class teException extends ir
{

    private ir a;

    public void a(ir ir1)
    {
        if (a != null)
        {
            throw new AssertionError();
        } else
        {
            a = ir1;
            return;
        }
    }

    public void a(jz jz, Object obj)
    {
        if (a == null)
        {
            throw new IllegalStateException();
        } else
        {
            a.a(jz, obj);
            return;
        }
    }

    public Object b(jx jx)
    {
        if (a == null)
        {
            throw new IllegalStateException();
        } else
        {
            return a.b(jx);
        }
    }

    teException()
    {
    }
}
