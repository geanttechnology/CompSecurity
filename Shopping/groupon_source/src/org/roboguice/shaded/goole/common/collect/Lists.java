// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.roboguice.shaded.goole.common.base.Objects;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            Iterators, Collections2

public final class Lists
{
    private static class OnePlusArrayList extends AbstractList
        implements Serializable, RandomAccess
    {

        final Object first;
        final Object rest[];

        public Object get(int i)
        {
            Preconditions.checkElementIndex(i, size());
            if (i == 0)
            {
                return first;
            } else
            {
                return rest[i - 1];
            }
        }

        public int size()
        {
            return rest.length + 1;
        }

        OnePlusArrayList(Object obj, Object aobj[])
        {
            first = obj;
            rest = (Object[])Preconditions.checkNotNull(((Object) (aobj)));
        }
    }


    public static List asList(Object obj, Object aobj[])
    {
        return new OnePlusArrayList(obj, aobj);
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

    static int indexOfImpl(List list, Object obj)
    {
        for (list = list.listIterator(); list.hasNext();)
        {
            if (Objects.equal(obj, list.next()))
            {
                return list.previousIndex();
            }
        }

        return -1;
    }

    static int lastIndexOfImpl(List list, Object obj)
    {
        for (list = list.listIterator(list.size()); list.hasPrevious();)
        {
            if (Objects.equal(obj, list.previous()))
            {
                return list.nextIndex();
            }
        }

        return -1;
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
        ArrayList arraylist = newArrayList();
        Iterators.addAll(arraylist, iterator);
        return arraylist;
    }
}
