// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class IntRangeSet
    implements Set
{

    private int a[];
    private Set b;

    public transient IntRangeSet(int ai[])
    {
        b = new HashSet();
        Arrays.sort(ai);
        ArrayList arraylist = new ArrayList();
        int i = ai[0];
        int i1 = ai[0];
        int k = 1;
        while (k < ai.length) 
        {
            b.add(Integer.valueOf(ai[k]));
            int l;
            if (ai[k] == i1 + 1)
            {
                i1 = ai[k];
                l = i;
                i = i1;
            } else
            {
                arraylist.add(Integer.valueOf(i));
                arraylist.add(Integer.valueOf(i1));
                l = ai[k];
                i = ai[k];
            }
            k++;
            i1 = i;
            i = l;
        }
        arraylist.add(Integer.valueOf(i));
        arraylist.add(Integer.valueOf(i1));
        a = new int[arraylist.size()];
        for (int j = 0; j < arraylist.size(); j++)
        {
            a[j] = ((Integer)arraylist.get(j)).intValue();
        }

    }

    public boolean add(Integer integer)
    {
        throw new UnsupportedOperationException();
    }

    public volatile boolean add(Object obj)
    {
        return add((Integer)obj);
    }

    public boolean addAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public void clear()
    {
        throw new UnsupportedOperationException();
    }

    public boolean contains(int i)
    {
        int j = 0;
        do
        {
            if (j >= a.length / 2 || i < a[j << 1])
            {
                return false;
            }
            if (i <= a[(j << 1) + 1])
            {
                return true;
            }
            j++;
        } while (true);
    }

    public boolean contains(Object obj)
    {
        return contains(((Integer)obj).intValue());
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

    public boolean isEmpty()
    {
        return b.isEmpty();
    }

    public Iterator iterator()
    {
        return b.iterator();
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

    public int size()
    {
        return b.size();
    }

    public Object[] toArray()
    {
        return b.toArray();
    }

    public Object[] toArray(Object aobj[])
    {
        return b.toArray(aobj);
    }

    public String toString()
    {
        String s = "";
        for (int i = 0; i < a.length / 2; i++)
        {
            String s1 = s;
            if (i != 0)
            {
                s1 = (new StringBuilder()).append(s).append(", ").toString();
            }
            s = (new StringBuilder()).append(s1).append("[").append(a[i << 1]).append(",").append(a[(i << 1) + 1]).append("]").toString();
        }

        return s;
    }
}
