// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.tag;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class PrependedFilteredList
    implements List
{

    private final List baseList;
    private final List prependedItems;
    private final NavigableMap shiftMap = new TreeMap();
    private final Set skipSet = new HashSet();

    public PrependedFilteredList(List list, List list1, Set set1)
    {
        baseList = list;
        prependedItems = list1;
        skipSet.addAll(set1);
        skipSet.addAll(list1);
        int i = list1.size();
        shiftMap.put(Integer.valueOf(i), Integer.valueOf(i));
        list = list.iterator();
        int j = list1.size();
        while (list.hasNext()) 
        {
            if (skipSet.contains(list.next()))
            {
                i--;
                shiftMap.put(Integer.valueOf(j), Integer.valueOf(i));
            } else
            {
                j++;
            }
        }
    }

    private int getBaseIndexOf(int i)
    {
        if (i < prependedItems.size())
        {
            return -1;
        } else
        {
            return i - ((Integer)shiftMap.floorEntry(Integer.valueOf(i)).getValue()).intValue();
        }
    }

    private int getListIndexOf(int i)
    {
        return (i - ((Integer)shiftMap.floorEntry(Integer.valueOf(i)).getValue()).intValue()) + prependedItems.size();
    }

    private boolean isInPrependList(int i)
    {
        return i < prependedItems.size();
    }

    public void add(int i, Object obj)
    {
        throw new UnsupportedOperationException("cannot modify items in filtered cursorlist");
    }

    public boolean add(Object obj)
    {
        throw new UnsupportedOperationException("cannot modify items in filtered cursorlist");
    }

    public boolean addAll(int i, Collection collection)
    {
        throw new UnsupportedOperationException("cannot modify items in filtered cursorlist");
    }

    public boolean addAll(Collection collection)
    {
        throw new UnsupportedOperationException("cannot modify items in filtered cursorlist");
    }

    public void clear()
    {
        throw new UnsupportedOperationException("cannot modify items in filtered cursorlist");
    }

    public boolean contains(Object obj)
    {
        return baseList.contains(obj) && !skipSet.contains(obj) || prependedItems.contains(obj);
    }

    public boolean containsAll(Collection collection)
    {
        for (collection = collection.iterator(); collection.hasNext();)
        {
            if (!contains(collection.next()))
            {
                return false;
            }
        }

        return true;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof PrependedFilteredList))
        {
            if (baseList.equals(((PrependedFilteredList) (obj = (PrependedFilteredList)obj)).baseList) && prependedItems.equals(((PrependedFilteredList) (obj)).prependedItems) && skipSet.equals(((PrependedFilteredList) (obj)).skipSet))
            {
                return true;
            }
        }
        return false;
    }

    public Object get(int i)
    {
        if (isInPrependList(i))
        {
            return prependedItems.get(i);
        } else
        {
            return baseList.get(getBaseIndexOf(i));
        }
    }

    public int hashCode()
    {
        return baseList.hashCode() + prependedItems.hashCode() + shiftMap.hashCode();
    }

    public int indexOf(Object obj)
    {
        int j = prependedItems.indexOf(obj);
        int i = j;
        if (j == -1)
        {
            i = getListIndexOf(baseList.indexOf(obj));
        }
        return i;
    }

    public boolean isEmpty()
    {
        return baseList.isEmpty() && prependedItems.isEmpty();
    }

    public Iterator iterator()
    {
        throw new RuntimeException("Operation is not supported");
    }

    public int lastIndexOf(Object obj)
    {
        throw new RuntimeException("Operation is not supported");
    }

    public ListIterator listIterator()
    {
        throw new RuntimeException("Operation is not supported");
    }

    public ListIterator listIterator(int i)
    {
        throw new RuntimeException("Operation is not supported");
    }

    public Object remove(int i)
    {
        throw new UnsupportedOperationException("cannot remove item from filtered cursorlist");
    }

    public boolean remove(Object obj)
    {
        throw new UnsupportedOperationException("cannot remove item from filtered cursorlist");
    }

    public boolean removeAll(Collection collection)
    {
        throw new UnsupportedOperationException("cannot remove from filtered cursorlist");
    }

    public boolean retainAll(Collection collection)
    {
        throw new UnsupportedOperationException("cannot modify items in filtered cursorlist");
    }

    public Object set(int i, Object obj)
    {
        throw new UnsupportedOperationException("cannot directly set items in filtered cursorlist");
    }

    public int size()
    {
        return (baseList.size() - skipSet.size()) + prependedItems.size();
    }

    public List subList(int i, int j)
    {
        throw new UnsupportedOperationException("cannot sublist filtered daolist");
    }

    public Object[] toArray()
    {
        throw new UnsupportedOperationException("cannot turn dao list into an array");
    }

    public Object[] toArray(Object aobj[])
    {
        throw new UnsupportedOperationException("cannot turn dao list into an array");
    }
}
