// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.h;

import e.c.a;
import e.k;
import java.util.concurrent.Future;

// Referenced classes of package e.h:
//            g, a, f

public final class e
{

    private static final g a = new g((byte)0);

    public static k a()
    {
        return e.h.a.a();
    }

    public static k a(a a1)
    {
        return e.h.a.a(a1);
    }

    public static k a(Future future)
    {
        return new f(future);
    }

    public static k b()
    {
        return a;
    }

}
