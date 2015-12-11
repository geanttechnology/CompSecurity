// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.b.a;

import org.b.b;

// Referenced classes of package org.b.a:
//            d

public final class g
    implements b
{

    public volatile b a;
    private final String b;

    public g(String s)
    {
        b = s;
    }

    private b c()
    {
        if (a != null)
        {
            return a;
        } else
        {
            return d.a;
        }
    }

    public final String a()
    {
        return b;
    }

    public final void a(String s)
    {
        c().a(s);
    }

    public final void a(String s, Object obj)
    {
        c().a(s, obj);
    }

    public final void a(String s, Object obj, Object obj1)
    {
        c().a(s, obj, obj1);
    }

    public final void a(String s, Throwable throwable)
    {
        c().a(s, throwable);
    }

    public final transient void a(String s, Object aobj[])
    {
        c().a(s, aobj);
    }

    public final void b(String s)
    {
        c().b(s);
    }

    public final void b(String s, Throwable throwable)
    {
        c().b(s, throwable);
    }

    public final transient void b(String s, Object aobj[])
    {
        c().b(s, aobj);
    }

    public final boolean b()
    {
        return c().b();
    }

    public final transient void c(String s, Object aobj[])
    {
        c().c(s, aobj);
    }

    public final transient void d(String s, Object aobj[])
    {
        c().d(s, aobj);
    }

    public final transient void e(String s, Object aobj[])
    {
        c().e(s, aobj);
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (g)obj;
            if (!b.equals(((g) (obj)).b))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return b.hashCode();
    }
}
