// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ak;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package myobfuscated.ak:
//            c, e, b

public final class a
{

    private static final e a = new e() {

        public final void a(Object obj)
        {
        }

    };

    public static android.support.v4.util.Pools.Pool a()
    {
        return a(((android.support.v4.util.Pools.Pool) (new android.support.v4.util.Pools.SynchronizedPool(20))), new b() {

            public final Object a()
            {
                return new ArrayList();
            }

        }, new e() {

            public final void a(Object obj)
            {
                ((List)obj).clear();
            }

        });
    }

    private static android.support.v4.util.Pools.Pool a(android.support.v4.util.Pools.Pool pool, b b1)
    {
        return a(pool, b1, a);
    }

    private static android.support.v4.util.Pools.Pool a(android.support.v4.util.Pools.Pool pool, b b1, e e)
    {
        return new c(pool, b1, e);
    }

    public static android.support.v4.util.Pools.Pool a(b b1)
    {
        return a(((android.support.v4.util.Pools.Pool) (new android.support.v4.util.Pools.SimplePool(150))), b1);
    }

    public static android.support.v4.util.Pools.Pool b(b b1)
    {
        return a(new android.support.v4.util.Pools.SynchronizedPool(20), b1);
    }

}
