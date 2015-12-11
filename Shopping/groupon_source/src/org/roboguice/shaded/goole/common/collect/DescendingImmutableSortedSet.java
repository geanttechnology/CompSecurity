// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Iterator;
import java.util.NavigableSet;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            ImmutableSortedSet, Ordering, UnmodifiableIterator

class DescendingImmutableSortedSet extends ImmutableSortedSet
{

    private final ImmutableSortedSet forward;

    DescendingImmutableSortedSet(ImmutableSortedSet immutablesortedset)
    {
        super(Ordering.from(immutablesortedset.comparator()).reverse());
        forward = immutablesortedset;
    }

    public Object ceiling(Object obj)
    {
        return forward.floor(obj);
    }

    ImmutableSortedSet createDescendingSet()
    {
        throw new AssertionError("should never be called");
    }

    public volatile Iterator descendingIterator()
    {
        return descendingIterator();
    }

    public UnmodifiableIterator descendingIterator()
    {
        return forward.iterator();
    }

    public volatile NavigableSet descendingSet()
    {
        return descendingSet();
    }

    public ImmutableSortedSet descendingSet()
    {
        return forward;
    }

    public Object floor(Object obj)
    {
        return forward.ceiling(obj);
    }

    ImmutableSortedSet headSetImpl(Object obj, boolean flag)
    {
        return forward.tailSet(obj, flag).descendingSet();
    }

    public Object higher(Object obj)
    {
        return forward.lower(obj);
    }

    boolean isPartialView()
    {
        return forward.isPartialView();
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public UnmodifiableIterator iterator()
    {
        return forward.descendingIterator();
    }

    public Object lower(Object obj)
    {
        return forward.higher(obj);
    }

    public int size()
    {
        return forward.size();
    }

    ImmutableSortedSet subSetImpl(Object obj, boolean flag, Object obj1, boolean flag1)
    {
        return forward.subSet(obj1, flag1, obj, flag).descendingSet();
    }

    ImmutableSortedSet tailSetImpl(Object obj, boolean flag)
    {
        return forward.headSet(obj, flag).descendingSet();
    }
}
