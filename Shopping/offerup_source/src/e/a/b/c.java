// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.a.b;

import android.os.Handler;
import e.a.a.a;
import e.d.c.g;
import e.h;
import e.h.b;
import e.h.e;
import e.k;
import java.util.concurrent.TimeUnit;

// Referenced classes of package e.a.b:
//            d

final class c extends h
{

    private final Handler a;
    private final b b = new b();

    c(Handler handler)
    {
        a = handler;
    }

    static Handler a(c c1)
    {
        return c1.a;
    }

    public final k a(e.c.a a1)
    {
        return a(a1, 0L, TimeUnit.MILLISECONDS);
    }

    public final k a(e.c.a a1, long l, TimeUnit timeunit)
    {
        if (b.c())
        {
            return e.b();
        } else
        {
            e.a.a.a.a().b();
            a1 = new g(e.a.a.b.a(a1));
            a1.a(b);
            b.a(a1);
            a.postDelayed(a1, timeunit.toMillis(l));
            a1.a(e.a(new d(this, a1)));
            return a1;
        }
    }

    public final void b()
    {
        b.b();
    }

    public final boolean c()
    {
        return b.c();
    }
}
