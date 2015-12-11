// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import e.f;
import e.j;

// Referenced classes of package e.d.a:
//            w, v, y

final class x extends j
{

    final Thread a;
    final w b;

    x(w w1, j j1, Thread thread)
    {
        b = w1;
        a = thread;
        super(j1);
    }

    public final void a()
    {
        b.a.a.a();
    }

    public final void a(f f)
    {
        b.a.a.a(new y(this, f));
    }

    public final void a(Object obj)
    {
        b.a.a.a(obj);
    }

    public final void a(Throwable throwable)
    {
        b.a.a.a(throwable);
    }
}
