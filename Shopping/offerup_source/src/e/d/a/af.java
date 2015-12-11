// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import e.b.f;
import e.d.d.e;
import e.j;

// Referenced classes of package e.d.a:
//            a, ae

final class af extends j
{

    final e a = e.d();
    private ae b;

    af(ae ae1)
    {
        b = ae1;
        super();
    }

    public final void a()
    {
        e e1 = a;
        if (e1.a == null)
        {
            e1.a = e.d.a.a.b();
        }
        b.a();
    }

    public final void a(Object obj)
    {
        try
        {
            a.a(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a(((Throwable) (obj)));
        }
        b.a();
    }

    public final void a(Throwable throwable)
    {
        ae.a(b).a(throwable);
    }

    public final void b(long l)
    {
        a(l);
    }

    public final void d()
    {
        a(e.b);
    }
}
