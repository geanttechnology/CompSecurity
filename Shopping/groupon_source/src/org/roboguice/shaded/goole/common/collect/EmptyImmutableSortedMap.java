// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.Set;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            ImmutableSortedMap, ImmutableSortedSet, Ordering, ImmutableSet, 
//            ImmutableList, ImmutableCollection

final class EmptyImmutableSortedMap extends ImmutableSortedMap
{

    private final transient ImmutableSortedSet keySet;

    EmptyImmutableSortedMap(Comparator comparator)
    {
        keySet = ImmutableSortedSet.emptySet(comparator);
    }

    EmptyImmutableSortedMap(Comparator comparator, ImmutableSortedMap immutablesortedmap)
    {
        super(immutablesortedmap);
        keySet = ImmutableSortedSet.emptySet(comparator);
    }

    ImmutableSortedMap createDescendingMap()
    {
        return new EmptyImmutableSortedMap(Ordering.from(comparator()).reverse(), this);
    }

    ImmutableSet createEntrySet()
    {
        throw new AssertionError("should never be called");
    }

    public volatile Set entrySet()
    {
        return entrySet();
    }

    public ImmutableSet entrySet()
    {
        return ImmutableSet.of();
    }

    public Object get(Object obj)
    {
        return null;
    }

    public volatile NavigableMap headMap(Object obj, boolean flag)
    {
        return headMap(obj, flag);
    }

    public ImmutableSortedMap headMap(Object obj, boolean flag)
    {
        Preconditions.checkNotNull(obj);
        return this;
    }

    public boolean isEmpty()
    {
        return true;
    }

    boolean isPartialView()
    {
        return false;
    }

    public volatile Set keySet()
    {
        return keySet();
    }

    public volatile ImmutableSet keySet()
    {
        return keySet();
    }

    public ImmutableSortedSet keySet()
    {
        return keySet;
    }

    public int size()
    {
        return 0;
    }

    public volatile NavigableMap tailMap(Object obj, boolean flag)
    {
        return tailMap(obj, flag);
    }

    public ImmutableSortedMap tailMap(Object obj, boolean flag)
    {
        Preconditions.checkNotNull(obj);
        return this;
    }

    public String toString()
    {
        return "{}";
    }

    public volatile Collection values()
    {
        return values();
    }

    public ImmutableCollection values()
    {
        return ImmutableList.of();
    }
}
