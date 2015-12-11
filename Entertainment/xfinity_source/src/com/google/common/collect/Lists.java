// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.google.common.collect:
//            Iterators, Collections2

public final class Lists
{

    static int computeArrayListCapacity(int i)
    {
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        return Ints.saturatedCast(5L + (long)i + (long)(i / 10));
    }

    static boolean equalsImpl(List list, Object obj)
    {
        if (obj != Preconditions.checkNotNull(list))
        {
            if (!(obj instanceof List))
            {
                return false;
            }
            obj = (List)obj;
            if (list.size() != ((List) (obj)).size() || !Iterators.elementsEqual(list.iterator(), ((List) (obj)).iterator()))
            {
                return false;
            }
        }
        return true;
    }

    static int hashCodeImpl(List list)
    {
        int i = 1;
        list = list.iterator();
        while (list.hasNext()) 
        {
            Object obj = list.next();
            int j;
            if (obj == null)
            {
                j = 0;
            } else
            {
                j = obj.hashCode();
            }
            i = i * 31 + j;
        }
        return i;
    }

    public static ArrayList newArrayList()
    {
        return new ArrayList();
    }

    public static ArrayList newArrayList(Iterable iterable)
    {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection)
        {
            return new ArrayList(Collections2.cast(iterable));
        } else
        {
            return newArrayList(iterable.iterator());
        }
    }

    public static ArrayList newArrayList(Iterator iterator)
    {
        Preconditions.checkNotNull(iterator);
        ArrayList arraylist = newArrayList();
        for (; iterator.hasNext(); arraylist.add(iterator.next())) { }
        return arraylist;
    }

    public static transient ArrayList newArrayList(Object aobj[])
    {
        Preconditions.checkNotNull(((Object) (aobj)));
        ArrayList arraylist = new ArrayList(computeArrayListCapacity(aobj.length));
        Collections.addAll(arraylist, aobj);
        return arraylist;
    }

    public static LinkedList newLinkedList()
    {
        return new LinkedList();
    }
}
