// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

// Referenced classes of package com.google.common.collect:
//            ImmutableSortedMultiset, ImmutableSortedSet, RegularImmutableSortedSet, ImmutableList, 
//            Multisets, BoundType, SortedMultiset

final class RegularImmutableSortedMultiset extends ImmutableSortedMultiset
{

    private static final long ZERO_CUMULATIVE_COUNTS[] = {
        0L
    };
    private final transient long cumulativeCounts[];
    private final transient RegularImmutableSortedSet elementSet;
    private final transient int length;
    private final transient int offset;

    RegularImmutableSortedMultiset(RegularImmutableSortedSet regularimmutablesortedset, long al[], int i, int j)
    {
        elementSet = regularimmutablesortedset;
        cumulativeCounts = al;
        offset = i;
        length = j;
    }

    RegularImmutableSortedMultiset(Comparator comparator)
    {
        elementSet = ImmutableSortedSet.emptySet(comparator);
        cumulativeCounts = ZERO_CUMULATIVE_COUNTS;
        offset = 0;
        length = 0;
    }

    private int getCount(int i)
    {
        return (int)(cumulativeCounts[offset + i + 1] - cumulativeCounts[offset + i]);
    }

    public int count(Object obj)
    {
        int i = elementSet.indexOf(obj);
        if (i >= 0)
        {
            return getCount(i);
        } else
        {
            return 0;
        }
    }

    public ImmutableSortedSet elementSet()
    {
        return elementSet;
    }

    public volatile NavigableSet elementSet()
    {
        return elementSet();
    }

    public volatile Set elementSet()
    {
        return elementSet();
    }

    public volatile SortedSet elementSet()
    {
        return elementSet();
    }

    public Multiset.Entry firstEntry()
    {
        if (isEmpty())
        {
            return null;
        } else
        {
            return getEntry(0);
        }
    }

    Multiset.Entry getEntry(int i)
    {
        return Multisets.immutableEntry(elementSet.asList().get(i), getCount(i));
    }

    ImmutableSortedMultiset getSubMultiset(int i, int j)
    {
        Preconditions.checkPositionIndexes(i, j, length);
        if (i != j) goto _L2; else goto _L1
_L1:
        Object obj = emptyMultiset(comparator());
_L4:
        return ((ImmutableSortedMultiset) (obj));
_L2:
        if (i != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = this;
        if (j == length) goto _L4; else goto _L3
_L3:
        return new RegularImmutableSortedMultiset(elementSet.getSubSet(i, j), cumulativeCounts, offset + i, j - i);
    }

    public ImmutableSortedMultiset headMultiset(Object obj, BoundType boundtype)
    {
        RegularImmutableSortedSet regularimmutablesortedset = elementSet;
        boolean flag;
        if (Preconditions.checkNotNull(boundtype) == BoundType.CLOSED)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return getSubMultiset(0, regularimmutablesortedset.headIndex(obj, flag));
    }

    public volatile SortedMultiset headMultiset(Object obj, BoundType boundtype)
    {
        return headMultiset(obj, boundtype);
    }

    boolean isPartialView()
    {
        return offset > 0 || length < cumulativeCounts.length - 1;
    }

    public Multiset.Entry lastEntry()
    {
        if (isEmpty())
        {
            return null;
        } else
        {
            return getEntry(length - 1);
        }
    }

    public int size()
    {
        return Ints.saturatedCast(cumulativeCounts[offset + length] - cumulativeCounts[offset]);
    }

    public ImmutableSortedMultiset tailMultiset(Object obj, BoundType boundtype)
    {
        RegularImmutableSortedSet regularimmutablesortedset = elementSet;
        boolean flag;
        if (Preconditions.checkNotNull(boundtype) == BoundType.CLOSED)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return getSubMultiset(regularimmutablesortedset.tailIndex(obj, flag), length);
    }

    public volatile SortedMultiset tailMultiset(Object obj, BoundType boundtype)
    {
        return tailMultiset(obj, boundtype);
    }

}
