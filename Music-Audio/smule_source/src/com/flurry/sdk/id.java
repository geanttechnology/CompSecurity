// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            ig, ii

public final class id extends ig
    implements Iterable
{

    private final List a = new ArrayList();

    public id()
    {
    }

    public Number a()
    {
        if (a.size() == 1)
        {
            return ((ig)a.get(0)).a();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public void a(ig ig1)
    {
        Object obj = ig1;
        if (ig1 == null)
        {
            obj = ii.a;
        }
        a.add(obj);
    }

    public String b()
    {
        if (a.size() == 1)
        {
            return ((ig)a.get(0)).b();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public double c()
    {
        if (a.size() == 1)
        {
            return ((ig)a.get(0)).c();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public long d()
    {
        if (a.size() == 1)
        {
            return ((ig)a.get(0)).d();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public int e()
    {
        if (a.size() == 1)
        {
            return ((ig)a.get(0)).e();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof id) && ((id)obj).a.equals(a);
    }

    public boolean f()
    {
        if (a.size() == 1)
        {
            return ((ig)a.get(0)).f();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public int hashCode()
    {
        return a.hashCode();
    }

    public Iterator iterator()
    {
        return a.iterator();
    }
}
