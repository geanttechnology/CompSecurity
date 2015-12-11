// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// Referenced classes of package com.tapjoy.internal:
//            bd, bc

public final class bb
    implements bd
{

    private final List a;

    public bb(List list)
    {
        a = list;
    }

    public final Object a(int i)
    {
        return a.get(i);
    }

    public final boolean add(Object obj)
    {
        return a.add(obj);
    }

    public final boolean addAll(Collection collection)
    {
        return a.addAll(collection);
    }

    public final void b(int i)
    {
        bc.a(a, i);
    }

    public final void clear()
    {
        a.clear();
    }

    public final boolean contains(Object obj)
    {
        return a.contains(obj);
    }

    public final boolean containsAll(Collection collection)
    {
        return a.containsAll(collection);
    }

    public final Object element()
    {
        Object obj = peek();
        if (obj != null)
        {
            return obj;
        } else
        {
            throw new NoSuchElementException();
        }
    }

    public final boolean equals(Object obj)
    {
        return a.equals(obj);
    }

    public final int hashCode()
    {
        return a.hashCode();
    }

    public final boolean isEmpty()
    {
        return a.isEmpty();
    }

    public final Iterator iterator()
    {
        return a.iterator();
    }

    public final boolean offer(Object obj)
    {
        return a.add(obj);
    }

    public final Object peek()
    {
        if (a.isEmpty())
        {
            return null;
        } else
        {
            return a.get(0);
        }
    }

    public final Object poll()
    {
        if (a.isEmpty())
        {
            return null;
        } else
        {
            return a.remove(0);
        }
    }

    public final Object remove()
    {
        Object obj = poll();
        if (obj != null)
        {
            return obj;
        } else
        {
            throw new NoSuchElementException();
        }
    }

    public final boolean remove(Object obj)
    {
        return a.remove(obj);
    }

    public final boolean removeAll(Collection collection)
    {
        return a.removeAll(collection);
    }

    public final boolean retainAll(Collection collection)
    {
        return a.retainAll(collection);
    }

    public final int size()
    {
        return a.size();
    }

    public final Object[] toArray()
    {
        return a.toArray();
    }

    public final Object[] toArray(Object aobj[])
    {
        return a.toArray(aobj);
    }
}
