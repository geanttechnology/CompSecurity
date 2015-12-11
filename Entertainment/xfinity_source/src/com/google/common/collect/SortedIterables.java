// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

// Referenced classes of package com.google.common.collect:
//            Ordering, SortedIterable, Sets, Iterators

final class SortedIterables
{

    public static boolean hasSameComparator(Comparator comparator, Iterable iterable)
    {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof SortedSet)
        {
            Comparator comparator1 = ((SortedSet)iterable).comparator();
            iterable = comparator1;
            if (comparator1 == null)
            {
                iterable = Ordering.natural();
            }
        } else
        if (iterable instanceof SortedIterable)
        {
            iterable = ((SortedIterable)iterable).comparator();
        } else
        {
            iterable = null;
        }
        return comparator.equals(iterable);
    }

    public static Collection sortedUnique(Comparator comparator, Iterator iterator)
    {
        comparator = Sets.newTreeSet(comparator);
        Iterators.addAll(comparator, iterator);
        return comparator;
    }
}
