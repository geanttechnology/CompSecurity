// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import e.a;
import e.h;
import e.j;

// Referenced classes of package e.d.a:
//            w, u

final class v extends j
{

    final j a;
    final h b;

    v(u u, j j1, j j2, h h1)
    {
        a = j2;
        b = h1;
        super(j1);
    }

    public final void a()
    {
    }

    public final void a(Object obj)
    {
        obj = (a)obj;
        b.a(new w(this, ((a) (obj))));
    }

    public final void a(Throwable throwable)
    {
        a.a(throwable);
    }
}
