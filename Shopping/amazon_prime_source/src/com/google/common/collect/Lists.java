// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

// Referenced classes of package com.google.common.collect:
//            Iterators, Collections2, TransformedListIterator

public final class Lists
{
    private static class TransformingRandomAccessList extends AbstractList
        implements Serializable, RandomAccess
    {

        final List fromList;
        final Function function;

        public void clear()
        {
            fromList.clear();
        }

        public Object get(int i)
        {
            return function.apply(fromList.get(i));
        }

        public boolean isEmpty()
        {
            return fromList.isEmpty();
        }

        public Iterator iterator()
        {
            return listIterator();
        }

        public ListIterator listIterator(int i)
        {
            return new TransformedListIterator(fromList.listIterator(i)) {

                final TransformingRandomAccessList this$0;

                Object transform(Object obj)
                {
                    return function.apply(obj);
                }

            
            {
                this$0 = TransformingRandomAccessList.this;
                super(listiterator);
            }
            };
        }

        public Object remove(int i)
        {
            return function.apply(fromList.remove(i));
        }

        public int size()
        {
            return fromList.size();
        }

        TransformingRandomAccessList(List list, Function function1)
        {
            fromList = (List)Preconditions.checkNotNull(list);
            function = (Function)Preconditions.checkNotNull(function1);
        }
    }

    private static class TransformingSequentialList extends AbstractSequentialList
        implements Serializable
    {

        final List fromList;
        final Function function;

        public void clear()
        {
            fromList.clear();
        }

        public ListIterator listIterator(int i)
        {
            return new TransformedListIterator(fromList.listIterator(i)) {

                final TransformingSequentialList this$0;

                Object transform(Object obj)
                {
                    return function.apply(obj);
                }

            
            {
                this$0 = TransformingSequentialList.this;
                super(listiterator);
            }
            };
        }

        public int size()
        {
            return fromList.size();
        }

        TransformingSequentialList(List list, Function function1)
        {
            fromList = (List)Preconditions.checkNotNull(list);
            function = (Function)Preconditions.checkNotNull(function1);
        }
    }


    private Lists()
    {
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

    public static LinkedList newLinkedList()
    {
        return new LinkedList();
    }

    public static List transform(List list, Function function)
    {
        if (list instanceof RandomAccess)
        {
            return new TransformingRandomAccessList(list, function);
        } else
        {
            return new TransformingSequentialList(list, function);
        }
    }
}
