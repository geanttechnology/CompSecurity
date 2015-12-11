// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e;

import e.b.h;
import e.d.a.ad;
import e.d.a.j;
import e.d.a.o;
import e.d.a.u;
import e.d.d.i;
import e.d.d.r;
import e.f.b;
import e.f.d;
import e.h.e;
import java.util.Arrays;

// Referenced classes of package e:
//            c, j, b, k, 
//            g

public class a
{

    private static final b b = d.a().c();
    final e.c.b a;

    protected a(e.c.b b1)
    {
        a = b1;
    }

    public static final a a(a a1, a a2, e.c.e e1)
    {
        return i.b(new a[] {
            a1, a2
        }).a(((e.c.d) (new ad(e1))));
    }

    public static final a a(e.c.b b1)
    {
        return new a(e.f.b.a(b1));
    }

    public static final a a(Iterable iterable)
    {
        return a(((e.c.b) (new e.d.a.d(iterable))));
    }

    public static final a a(Object obj)
    {
        return i.b(obj);
    }

    public static final a a(Throwable throwable)
    {
        return new c(throwable);
    }

    public static final a a(Object aobj[])
    {
        return a(((Iterable) (Arrays.asList(aobj))));
    }

    static b a()
    {
        return b;
    }

    private static k a(e.j j1, a a1)
    {
        if (j1 == null)
        {
            throw new IllegalArgumentException("observer can not be null");
        }
        if (a1.a == null)
        {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        j1.d();
        Object obj = j1;
        if (!(j1 instanceof e.e.a))
        {
            obj = new e.e.a(j1);
        }
        try
        {
            e.f.b.b(a1.a).call(obj);
            j1 = e.f.b.a(((k) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (e.j j1)
        {
            android.support.v4.e.a.a(j1);
            try
            {
                ((e.j) (obj)).a(e.f.b.a(j1));
            }
            // Misplaced declaration of an exception variable
            catch (e.j j1)
            {
                throw j1;
            }
            // Misplaced declaration of an exception variable
            catch (a a1)
            {
                throw new RuntimeException((new StringBuilder("Error occurred attempting to subscribe [")).append(j1.getMessage()).append("] and then again while trying to pass to onError.").toString(), a1);
            }
            return e.b();
        }
        return j1;
    }

    public final a a(e.c.d d1)
    {
        return new a(new e.b(this, d1));
    }

    public final a a(g g)
    {
        if (this instanceof i)
        {
            return ((i)this).c(g);
        } else
        {
            return a(((e.c.d) (new o(g))));
        }
    }

    public final k a(e.j j1)
    {
        k k;
        try
        {
            j1.d();
            e.f.b.b(a).call(j1);
            k = e.f.b.a(j1);
        }
        catch (Throwable throwable)
        {
            android.support.v4.e.a.a(throwable);
            try
            {
                j1.a(e.f.b.a(throwable));
            }
            // Misplaced declaration of an exception variable
            catch (e.j j1)
            {
                throw j1;
            }
            // Misplaced declaration of an exception variable
            catch (e.j j1)
            {
                throw new RuntimeException((new StringBuilder("Error occurred attempting to subscribe [")).append(throwable.getMessage()).append("] and then again while trying to pass to onError.").toString(), j1);
            }
            return e.b();
        }
        return k;
    }

    public final a b(e.c.d d1)
    {
        if (getClass() == e/d/d/i)
        {
            return ((i)this).c(d1);
        }
        d1 = a(new e.d.a.h(d1));
        if (d1.getClass() == e/d/d/i)
        {
            return ((i)d1).c(r.a());
        } else
        {
            return d1.a(j.a(false));
        }
    }

    public final a b(g g)
    {
        if (this instanceof i)
        {
            return ((i)this).c(g);
        } else
        {
            return i.b(this).a(new u(g));
        }
    }

    public final k b(e.j j1)
    {
        return a(j1, this);
    }

}
