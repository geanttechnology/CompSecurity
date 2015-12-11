// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.g;

import e.h.a;
import e.h.e;
import e.k;
import java.util.concurrent.TimeUnit;

// Referenced classes of package e.g:
//            g, f

final class h extends e.h
    implements k
{

    private a a;
    private f b;

    private h(f f)
    {
        b = f;
        super();
        a = new a();
    }

    h(f f, byte byte0)
    {
        this(f);
    }

    public final k a(e.c.a a1)
    {
        a1.a();
        return e.b();
    }

    public final k a(e.c.a a1, long l, TimeUnit timeunit)
    {
        return a(((e.c.a) (new g(a1, this, System.currentTimeMillis() + timeunit.toMillis(l)))));
    }

    public final void b()
    {
        a.b();
    }

    public final boolean c()
    {
        return a.c();
    }
}
