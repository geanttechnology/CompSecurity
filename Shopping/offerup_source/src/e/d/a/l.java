// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import e.d.d.e;
import e.j;
import java.util.Queue;

// Referenced classes of package e.d.a:
//            n

final class l extends j
{

    private static int f;
    final long a;
    volatile boolean b;
    volatile e c;
    private n d;
    private int e;

    public l(n n1, long l1)
    {
        d = n1;
        a = l1;
    }

    public final void a()
    {
        b = true;
        d.f();
    }

    public final void a(Object obj)
    {
        d.a(this, obj);
    }

    public final void a(Throwable throwable)
    {
        b = true;
        d.e().offer(throwable);
        d.f();
    }

    public final void b(long l1)
    {
        int i = e - (int)l1;
        if (i > f)
        {
            e = i;
        } else
        {
            e = e.b;
            i = e.b - i;
            if (i > 0)
            {
                a(i);
                return;
            }
        }
    }

    public final void d()
    {
        e = e.b;
        a(e.b);
    }

    static 
    {
        f = e.b / 4;
    }
}
