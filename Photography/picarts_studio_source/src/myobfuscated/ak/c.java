// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ak;

import android.util.Log;

// Referenced classes of package myobfuscated.ak:
//            b, d, f, e

final class c
    implements android.support.v4.util.Pools.Pool
{

    private final b a;
    private final e b;
    private final android.support.v4.util.Pools.Pool c;

    c(android.support.v4.util.Pools.Pool pool, b b1, e e1)
    {
        c = pool;
        a = b1;
        b = e1;
    }

    public final Object acquire()
    {
        Object obj1 = c.acquire();
        Object obj = obj1;
        if (obj1 == null)
        {
            Object obj2 = a.a();
            obj = obj2;
            if (Log.isLoggable("FactoryPools", 2))
            {
                (new StringBuilder("Created new ")).append(obj2.getClass());
                obj = obj2;
            }
        }
        if (obj instanceof d)
        {
            ((d)obj).e_().a(false);
        }
        return obj;
    }

    public final boolean release(Object obj)
    {
        if (obj instanceof d)
        {
            ((d)obj).e_().a(true);
        }
        b.a(obj);
        return c.release(obj);
    }
}
