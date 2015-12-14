// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.millennialmedia.google.gson:
//            e, f

public final class d extends e
    implements Iterable
{

    private final List a = new ArrayList();

    public d()
    {
    }

    public final Number a()
    {
        if (a.size() == 1)
        {
            return ((e)a.get(0)).a();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final void a(e e1)
    {
        Object obj = e1;
        if (e1 == null)
        {
            obj = f.a;
        }
        a.add(obj);
    }

    public final String b()
    {
        if (a.size() == 1)
        {
            return ((e)a.get(0)).b();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final double c()
    {
        if (a.size() == 1)
        {
            return ((e)a.get(0)).c();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final long d()
    {
        if (a.size() == 1)
        {
            return ((e)a.get(0)).d();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final int e()
    {
        if (a.size() == 1)
        {
            return ((e)a.get(0)).e();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final boolean equals(Object obj)
    {
        return obj == this || (obj instanceof d) && ((d)obj).a.equals(a);
    }

    public final boolean f()
    {
        if (a.size() == 1)
        {
            return ((e)a.get(0)).f();
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
