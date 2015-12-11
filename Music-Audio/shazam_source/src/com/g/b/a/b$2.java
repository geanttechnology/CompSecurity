// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a;

import c.r;

// Referenced classes of package com.g.b.a:
//            c, b

final class nit> extends c
{

    static final boolean a;
    final b b;

    protected final void a()
    {
        if (!a && !Thread.holdsLock(b))
        {
            throw new AssertionError();
        } else
        {
            com.g.b.a.b.g(b);
            return;
        }
    }

    static 
    {
        boolean flag;
        if (!com/g/b/a/b.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }

    rtionError(b b1, r r)
    {
        b = b1;
        super(r);
    }
}
