// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            ImmutableSortedSetFauxverideShim, SortedIterable, Ordering, EmptyImmutableSortedSet, 
//            Iterables, DescendingImmutableSortedSet, UnmodifiableIterator, Iterators

public abstract class ImmutableSortedSet extends ImmutableSortedSetFauxverideShim
    implements NavigableSet, SortedIterable
{

    private static final ImmutableSortedSet NATURAL_EMPTY_SET;
    private static final Comparator NATURAL_ORDER;
    final transient Comparator comparator;
    transient ImmutableSortedSet descendingSet;

    ImmutableSortedSet(Comparator comparator1)
    {
        comparator = comparator1;
    }

    private static ImmutableSortedSet emptySet()
    {
        return NATURAL_EMPTY_SET;
    }

    static ImmutableSortedSet emptySet(Comparator comparator1)
    {
        if (NATURAL_ORDER.equals(comparator1))
        {
            return emptySet();
        } else
        {
            return new EmptyImmutableSortedSet(comparator1);
        }
    }

    public Object ceiling(Object obj)
    {
        return Iterables.getFirst(tailSet(obj, true), null);
    }

    public Comparator comparator()
    {
        return comparator;
    }

    ImmutableSortedSet createDescendingSet()
    {
        return new DescendingImmutableSortedSet(this);
    }

    public volatile Iterator descendingIterator()
    {
        return descendingIterator();
    }

    public abstract UnmodifiableIterator descendingIterator();

    public volatile NavigableSet descendingSet()
    {
        return descendingSet();
    }

    public ImmutableSortedSet descendingSet()
    {
        ImmutableSortedSet immutablesortedset1 = descendingSet;
        ImmutableSortedSet immutablesortedset = immutablesortedset1;
        if (immutablesortedset1 == null)
        {
            immutablesortedset = createDescendingSet();
            descendingSet = immutablesortedset;
            immutablesortedset.descendingSet = this;
        }
        return immutablesortedset;
    }

    public Object first()
    {
        return iterator().next();
    }

    public Object floor(Object obj)
    {
        return Iterators.getNext(headSet(obj, true).descendingIterator(), null);
    }

    public volatile NavigableSet headSet(Object obj, boolean flag)
    {
        return headSet(obj, flag);
    }

    public volatile SortedSet headSet(Object obj)
    {
        return headSet(obj);
    }

    public ImmutableSortedSet headSet(Object obj)
    {
        return headSet(obj, false);
    }

    public ImmutableSortedSet headSet(Object obj, boolean flag)
    {
        return headSetImpl(Preconditions.checkNotNull(obj), flag);
    }

    abstract ImmutableSortedSet headSetImpl(Object obj, boolean flag);

    public Object higher(Object obj)
    {
        return Iterables.getFirst(tailSet(obj, false), null);
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public abstract UnmodifiableIterator iterator();

    public Object last()
    {
        return descendingIterator().next();
    }

    public Object lower(Object obj)
    {
        return Iterators.getNext(headSet(obj, false).descendingIterator(), null);
    }

    public final Object pollFirst()
    {
        throw new UnsupportedOperationException();
    }

    public final Object pollLast()
    {
        throw new UnsupportedOperationException();
    }

    public volatile NavigableSet subSet(Object obj, boolean flag, Object obj1, boolean flag1)
    {
        return subSet(obj, flag, obj1, flag1);
    }

    public volatile SortedSet subSet(Object obj, Object obj1)
    {
        return subSet(obj, obj1);
    }

    public ImmutableSortedSet subSet(Object obj, Object obj1)
    {
        return subSet(obj, true, obj1, false);
    }

    public ImmutableSortedSet subSet(Object obj, boolean flag, Object obj1, boolean flag1)
    {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj1);
        boolean flag2;
        if (comparator.compare(obj, obj1) <= 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        Preconditions.checkArgument(flag2);
        return subSetImpl(obj, flag, obj1, flag1);
    }

    abstract ImmutableSortedSet subSetImpl(Object obj, boolean flag, Object obj1, boolean flag1);

    public volatile NavigableSet tailSet(Object obj, boolean flag)
    {
        return tailSet(obj, flag);
    }

    public volatile SortedSet tailSet(Object obj)
    {
        return tailSet(obj);
    }

    public ImmutableSortedSet tailSet(Object obj)
    {
        return tailSet(obj, true);
    }

    public ImmutableSortedSet tailSet(Object obj, boolean flag)
    {
        return tailSetImpl(Preconditions.checkNotNull(obj), flag);
    }

    abstract ImmutableSortedSet tailSetImpl(Object obj, boolean flag);

    static 
    {
        NATURAL_ORDER = Ordering.natural();
        NATURAL_EMPTY_SET = new EmptyImmutableSortedSet(NATURAL_ORDER);
    }
}
