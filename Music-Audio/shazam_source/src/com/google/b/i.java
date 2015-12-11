// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.b:
//            l, n

public final class i extends l
    implements Iterable
{

    private final List a = new ArrayList();

    public i()
    {
    }

    public final Number a()
    {
        if (a.size() == 1)
        {
            return ((l)a.get(0)).a();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final void a(l l1)
    {
        Object obj = l1;
        if (l1 == null)
        {
            obj = n.a;
        }
        a.add(obj);
    }

    public final String b()
    {
        if (a.size() == 1)
        {
            return ((l)a.get(0)).b();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final double c()
    {
        if (a.size() == 1)
        {
            return ((l)a.get(0)).c();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final long d()
    {
        if (a.size() == 1)
        {
            return ((l)a.get(0)).d();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final int e()
    {
        if (a.size() == 1)
        {
            return ((l)a.get(0)).e();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final boolean equals(Object obj)
    {
        return obj == this || (obj instanceof i) && ((i)obj).a.equals(a);
    }

    public final boolean f()
    {
        if (a.size() == 1)
        {
            return ((l)a.get(0)).f();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final int hashCode()
    {
        return a.hashCode();
    }

    public final Iterator iterator()
    {
        return a.iterator();
    }
}
