// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Collection;
import java.util.Iterator;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            Collections2, Iterators, ImmutableList, Lists, 
//            FluentIterable, TransformedIterator

public final class Iterables
{

    public static boolean addAll(Collection collection, Iterable iterable)
    {
        if (iterable instanceof Collection)
        {
            return collection.addAll(Collections2.cast(iterable));
        } else
        {
            return Iterators.addAll(collection, ((Iterable)Preconditions.checkNotNull(iterable)).iterator());
        }
    }

    public static Iterable concat(Iterable iterable)
    {
        Preconditions.checkNotNull(iterable);
        return new FluentIterable(iterable) {

            final Iterable val$inputs;

            public Iterator iterator()
            {
                return Iterators.concat(Iterables.iterators(inputs));
            }

            
            {
                inputs = iterable;
                super();
            }
        };
    }

    public static Iterable concat(Iterable iterable, Iterable iterable1)
    {
        return concat(((Iterable) (ImmutableList.of(iterable, iterable1))));
    }

    public static Object getFirst(Iterable iterable, Object obj)
    {
        return Iterators.getNext(iterable.iterator(), obj);
    }

    public static Object getOnlyElement(Iterable iterable)
    {
        return Iterators.getOnlyElement(iterable.iterator());
    }

    private static Iterator iterators(Iterable iterable)
    {
        return new TransformedIterator(iterable.iterator()) {

            volatile Object transform(Object obj)
            {
                return transform((Iterable)obj);
            }

            Iterator transform(Iterable iterable1)
            {
                return iterable1.iterator();
            }

        };
    }

    static Object[] toArray(Iterable iterable)
    {
        return toCollection(iterable).toArray();
    }

    private static Collection toCollection(Iterable iterable)
    {
        if (iterable instanceof Collection)
        {
            return (Collection)iterable;
        } else
        {
            return Lists.newArrayList(iterable.iterator());
        }
    }

    public static String toString(Iterable iterable)
    {
        return Iterators.toString(iterable.iterator());
    }

}
