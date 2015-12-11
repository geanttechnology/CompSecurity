// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.util;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package com.wishabi.flipp.util:
//            m, o

public final class l
    implements Iterable
{

    public final ArrayList a = new ArrayList();
    private final HashMap b = new HashMap();
    private final HashMap c = new HashMap();
    private final SparseArray d = new SparseArray();

    public l()
    {
    }

    public final m a(long l1)
    {
        return (m)b.get(Long.valueOf(l1));
    }

    public final o a(int i)
    {
        return (o)d.get(i);
    }

    public final void a()
    {
        b.clear();
        d.clear();
        c.clear();
        a.clear();
    }

    public final void a(o o1)
    {
        int j = c();
        a.add(o1);
        d.put(o1.b, o1);
        o1.c = j;
        if (o1.e != null)
        {
            c.put(o1.e, o1);
        }
        for (int i = 0; i < o1.a();)
        {
            m m1 = o1.b(i);
            int k = j;
            if (m1 != null)
            {
                m1.c = j;
                b.put(Long.valueOf(m1.a), m1);
                k = j + 1;
            }
            i++;
            j = k;
        }

    }

    public final int b()
    {
        Iterator iterator1 = a.iterator();
        int i;
        for (i = 0; iterator1.hasNext(); i = ((o)iterator1.next()).b() + i) { }
        return i;
    }

    public final o b(int i)
    {
        return (o)a.get(i);
    }

    public final Object b(long l1)
    {
        if (a(l1) == null)
        {
            return null;
        } else
        {
            return a(l1).e;
        }
    }

    public final int c()
    {
        Iterator iterator1 = a.iterator();
        int i;
        for (i = 0; iterator1.hasNext(); i = ((o)iterator1.next()).a() + i) { }
        return i;
    }

    public final int c(long l1)
    {
        if (a(l1) == null)
        {
            return -1;
        } else
        {
            return a(l1).c;
        }
    }

    public final o c(int i)
    {
        Iterator iterator1 = a.iterator();
        o o1;
        for (int j = 0; iterator1.hasNext(); j = o1.a() + j)
        {
            o1 = (o)iterator1.next();
            if (i < o1.a() + j)
            {
                return o1;
            }
        }

        return null;
    }

    public final m d(int i)
    {
        Iterator iterator1 = a.iterator();
        o o1;
        for (int j = 0; iterator1.hasNext(); j = o1.a() + j)
        {
            o1 = (o)iterator1.next();
            if (i < o1.a() + j)
            {
                return o1.b(i - j);
            }
        }

        return null;
    }

    public final Iterator iterator()
    {
        return a.iterator();
    }
}
