// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package com.socialin.android.brushlib.util:
//            i

public final class j
    implements List
{

    private final List a;

    public j(List list)
    {
        a = list;
    }

    private int a(int k)
    {
        return a.size() - k - 1;
    }

    public final void add(int k, Object obj)
    {
        a.add(a(k), obj);
    }

    public final boolean add(Object obj)
    {
        a.add(0, obj);
        return true;
    }

    public final boolean addAll(int k, Collection collection)
    {
        return a.addAll(a(k), collection);
    }

    public final boolean addAll(Collection collection)
    {
        return a.addAll(0, collection);
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

    public final Object get(int k)
    {
        return a.get(a(k));
    }

    public final int indexOf(Object obj)
    {
        int k = -1;
        int l = a.indexOf(obj);
        if (l != -1)
        {
            k = a(l);
        }
        return k;
    }

    public final boolean isEmpty()
    {
        return a.isEmpty();
    }

    public final Iterator iterator()
    {
        return new i(a.listIterator());
    }

    public final int lastIndexOf(Object obj)
    {
        return a(a.lastIndexOf(obj));
    }

    public final ListIterator listIterator()
    {
        return new i(a.listIterator());
    }

    public final ListIterator listIterator(int k)
    {
        return new i(a.listIterator(a(k)));
    }

    public final Object remove(int k)
    {
        return a.remove(a(k));
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

    public final Object set(int k, Object obj)
    {
        return a.set(a(k), obj);
    }

    public final int size()
    {
        return a.size();
    }

    public final List subList(int k, int l)
    {
        return a.subList(a(k), a(l));
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
