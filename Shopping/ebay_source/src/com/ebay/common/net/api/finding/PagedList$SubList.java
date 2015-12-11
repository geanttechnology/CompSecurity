// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finding;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package com.ebay.common.net.api.finding:
//            PagedList

private static final class count
    implements List
{

    private final int count;
    private final List parent;
    private final int start;

    public void add(int i, Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public boolean add(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int i, Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public void clear()
    {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public Object get(int i)
    {
        if (i < 0 || i >= count)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return parent.get(i - start);
        }
    }

    public int indexOf(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    public Iterator iterator()
    {
        return listIterator();
    }

    public int lastIndexOf(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public ListIterator listIterator()
    {
        return listIterator(0);
    }

    public ListIterator listIterator(int i)
    {
        return new Impl(this, i);
    }

    public Object remove(int i)
    {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public Object set(int i, Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public int size()
    {
        return count;
    }

    public List subList(int i, int j)
    {
        if (i < 0 || i > j || j > count)
        {
            throw new IndexOutOfBoundsException();
        }
        if (i == 0 && j == count)
        {
            return this;
        } else
        {
            return new <init>(this, i, j);
        }
    }

    public Object[] toArray()
    {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray(Object aobj[])
    {
        throw new UnsupportedOperationException();
    }

    public Impl(List list, int i, int j)
    {
        parent = list;
        start = i;
        count = j - i;
    }
}
