// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

// Referenced classes of package com.google.common.collect:
//            ImmutableSortedMapFauxverideShim, Ordering, EmptyImmutableSortedMap, Maps, 
//            ImmutableSortedSet, ImmutableCollection, ImmutableSet, ImmutableList

public abstract class ImmutableSortedMap extends ImmutableSortedMapFauxverideShim
    implements NavigableMap
{

    private static final ImmutableSortedMap NATURAL_EMPTY_MAP;
    private static final Comparator NATURAL_ORDER;
    private transient ImmutableSortedMap descendingMap;

    ImmutableSortedMap()
    {
    }

    ImmutableSortedMap(ImmutableSortedMap immutablesortedmap)
    {
        descendingMap = immutablesortedmap;
    }

    public java.util.Map.Entry ceilingEntry(Object obj)
    {
        return tailMap(obj, true).firstEntry();
    }

    public Object ceilingKey(Object obj)
    {
        return Maps.keyOrNull(ceilingEntry(obj));
    }

    public Comparator comparator()
    {
        return keySet().comparator();
    }

    public boolean containsValue(Object obj)
    {
        return values().contains(obj);
    }

    abstract ImmutableSortedMap createDescendingMap();

    public ImmutableSortedSet descendingKeySet()
    {
        return keySet().descendingSet();
    }

    public volatile NavigableSet descendingKeySet()
    {
        return descendingKeySet();
    }

    public ImmutableSortedMap descendingMap()
    {
        ImmutableSortedMap immutablesortedmap1 = descendingMap;
        ImmutableSortedMap immutablesortedmap = immutablesortedmap1;
        if (immutablesortedmap1 == null)
        {
            immutablesortedmap = createDescendingMap();
            descendingMap = immutablesortedmap;
        }
        return immutablesortedmap;
    }

    public volatile NavigableMap descendingMap()
    {
        return descendingMap();
    }

    public ImmutableSet entrySet()
    {
        return super.entrySet();
    }

    public volatile Set entrySet()
    {
        return entrySet();
    }

    public java.util.Map.Entry firstEntry()
    {
        if (isEmpty())
        {
            return null;
        } else
        {
            return (java.util.Map.Entry)entrySet().asList().get(0);
        }
    }

    public Object firstKey()
    {
        return keySet().first();
    }

    public java.util.Map.Entry floorEntry(Object obj)
    {
        return headMap(obj, true).lastEntry();
    }

    public Object floorKey(Object obj)
    {
        return Maps.keyOrNull(floorEntry(obj));
    }

    public ImmutableSortedMap headMap(Object obj)
    {
        return headMap(obj, false);
    }

    public abstract ImmutableSortedMap headMap(Object obj, boolean flag);

    public volatile NavigableMap headMap(Object obj, boolean flag)
    {
        return headMap(obj, flag);
    }

    public volatile SortedMap headMap(Object obj)
    {
        return headMap(obj);
    }

    public java.util.Map.Entry higherEntry(Object obj)
    {
        return tailMap(obj, false).firstEntry();
    }

    public Object higherKey(Object obj)
    {
        return Maps.keyOrNull(higherEntry(obj));
    }

    boolean isPartialView()
    {
        return keySet().isPartialView() || values().isPartialView();
    }

    public volatile ImmutableSet keySet()
    {
        return keySet();
    }

    public abstract ImmutableSortedSet keySet();

    public volatile Set keySet()
    {
        return keySet();
    }

    public java.util.Map.Entry lastEntry()
    {
        if (isEmpty())
        {
            return null;
        } else
        {
            return (java.util.Map.Entry)entrySet().asList().get(size() - 1);
        }
    }

    public Object lastKey()
    {
        return keySet().last();
    }

    public java.util.Map.Entry lowerEntry(Object obj)
    {
        return headMap(obj, false).lastEntry();
    }

    public Object lowerKey(Object obj)
    {
        return Maps.keyOrNull(lowerEntry(obj));
    }

    public ImmutableSortedSet navigableKeySet()
    {
        return keySet();
    }

    public volatile NavigableSet navigableKeySet()
    {
        return navigableKeySet();
    }

    public final java.util.Map.Entry pollFirstEntry()
    {
        throw new UnsupportedOperationException();
    }

    public final java.util.Map.Entry pollLastEntry()
    {
        throw new UnsupportedOperationException();
    }

    public int size()
    {
        return values().size();
    }

    public ImmutableSortedMap subMap(Object obj, Object obj1)
    {
        return subMap(obj, true, obj1, false);
    }

    public ImmutableSortedMap subMap(Object obj, boolean flag, Object obj1, boolean flag1)
    {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj1);
        boolean flag2;
        if (comparator().compare(obj, obj1) <= 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        Preconditions.checkArgument(flag2, "expected fromKey <= toKey but %s > %s", new Object[] {
            obj, obj1
        });
        return headMap(obj1, flag1).tailMap(obj, flag);
    }

    public volatile NavigableMap subMap(Object obj, boolean flag, Object obj1, boolean flag1)
    {
        return subMap(obj, flag, obj1, flag1);
    }

    public volatile SortedMap subMap(Object obj, Object obj1)
    {
        return subMap(obj, obj1);
    }

    public ImmutableSortedMap tailMap(Object obj)
    {
        return tailMap(obj, true);
    }

    public abstract ImmutableSortedMap tailMap(Object obj, boolean flag);

    public volatile NavigableMap tailMap(Object obj, boolean flag)
    {
        return tailMap(obj, flag);
    }

    public volatile SortedMap tailMap(Object obj)
    {
        return tailMap(obj);
    }

    public abstract ImmutableCollection values();

    public volatile Collection values()
    {
        return values();
    }

    static 
    {
        NATURAL_ORDER = Ordering.natural();
        NATURAL_EMPTY_MAP = new EmptyImmutableSortedMap(NATURAL_ORDER);
    }
}
