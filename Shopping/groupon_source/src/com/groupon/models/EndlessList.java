// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class EndlessList
    implements List
{

    private Object attr;
    private int currentOffset;
    private List _flddelegate;
    private int totalSize;

    public EndlessList(List list, int i, int j, Object obj)
    {
        totalSize = 0;
        currentOffset = 0;
        _flddelegate = list;
        totalSize = i;
        currentOffset = j;
        attr = obj;
    }

    public void add(int i, Object obj)
    {
        _flddelegate.add(i, obj);
    }

    public boolean add(Object obj)
    {
        return _flddelegate.add(obj);
    }

    public boolean addAll(int i, Collection collection)
    {
        return _flddelegate.addAll(i, collection);
    }

    public boolean addAll(Collection collection)
    {
        return _flddelegate.addAll(collection);
    }

    public void clear()
    {
        _flddelegate.clear();
    }

    public boolean contains(Object obj)
    {
        return _flddelegate.contains(obj);
    }

    public boolean containsAll(Collection collection)
    {
        return _flddelegate.containsAll(collection);
    }

    public boolean equals(Object obj)
    {
        return _flddelegate.equals(obj);
    }

    public Object get(int i)
    {
        return _flddelegate.get(i);
    }

    public Object getAttr()
    {
        return attr;
    }

    public int getCurrentOffset()
    {
        return currentOffset;
    }

    public List getDelegate()
    {
        return _flddelegate;
    }

    public int getTotalSize()
    {
        return totalSize;
    }

    public int hashCode()
    {
        return _flddelegate.hashCode();
    }

    public int indexOf(Object obj)
    {
        return _flddelegate.indexOf(obj);
    }

    public boolean isEmpty()
    {
        return _flddelegate.isEmpty();
    }

    public Iterator iterator()
    {
        return _flddelegate.iterator();
    }

    public int lastIndexOf(Object obj)
    {
        return _flddelegate.lastIndexOf(obj);
    }

    public ListIterator listIterator()
    {
        return _flddelegate.listIterator();
    }

    public ListIterator listIterator(int i)
    {
        return _flddelegate.listIterator(i);
    }

    public Object remove(int i)
    {
        return _flddelegate.remove(i);
    }

    public boolean remove(Object obj)
    {
        return _flddelegate.remove(obj);
    }

    public boolean removeAll(Collection collection)
    {
        return _flddelegate.removeAll(collection);
    }

    public boolean retainAll(Collection collection)
    {
        return _flddelegate.retainAll(collection);
    }

    public Object set(int i, Object obj)
    {
        return _flddelegate.set(i, obj);
    }

    public void setAttr(Object obj)
    {
        attr = obj;
    }

    public void setCurrentOffset(int i)
    {
        currentOffset = i;
    }

    public void setTotalSize(int i)
    {
        totalSize = i;
    }

    public int size()
    {
        return _flddelegate.size();
    }

    public List subList(int i, int j)
    {
        return _flddelegate.subList(i, j);
    }

    public Object[] toArray()
    {
        return _flddelegate.toArray();
    }

    public Object[] toArray(Object aobj[])
    {
        return _flddelegate.toArray(aobj);
    }
}
