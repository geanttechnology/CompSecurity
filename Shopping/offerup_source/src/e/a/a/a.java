// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.a.a;

import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package e.a.a:
//            b

public final class a
{

    private static final a a = new a();
    private final AtomicReference b = new AtomicReference();

    a()
    {
    }

    public static a a()
    {
        return a;
    }

    public final b b()
    {
        if (b.get() == null)
        {
            b.compareAndSet(null, e.a.a.b.a());
        }
        return (b)b.get();
    }

}
