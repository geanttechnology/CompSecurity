// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

// Referenced classes of package android.support.v7:
//            ct, cu, cp, cs

class e
    implements ct
{

    final cp a;
    final Callable b;
    final ct c;
    final Executor d;
    final cs e;
    final cu f;

    public cu a(cu cu1)
        throws Exception
    {
        if (a != null && a.a())
        {
            return cu.h();
        }
        if (((Boolean)b.call()).booleanValue())
        {
            return cu.a(null).d(c, d).d((ct)e.a(), d);
        } else
        {
            return cu.a(null);
        }
    }

    public Object then(cu cu1)
        throws Exception
    {
        return a(cu1);
    }

    utor(cu cu1, cp cp1, Callable callable, ct ct1, Executor executor, cs cs1)
    {
        f = cu1;
        a = cp1;
        b = callable;
        c = ct1;
        d = executor;
        e = cs1;
        super();
    }
}
