// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            ImmutableSortedMap, RegularImmutableMap, CollectPreconditions, ImmutableEnumMap, 
//            ImmutableBiMap, ImmutableCollection, ImmutableMapKeySet, Maps, 
//            ImmutableSet, ImmutableMapValues, ObjectArrays

public abstract class ImmutableMap
    implements Serializable, Map
{
    public static class Builder
    {

        ImmutableMapEntry.TerminalEntry entries[];
        int size;

        private void ensureCapacity(int i)
        {
            if (i > entries.length)
            {
                entries = (ImmutableMapEntry.TerminalEntry[])ObjectArrays.arraysCopyOf(entries, ImmutableCollection.Builder.expandedCapacity(entries.length, i));
            }
        }

        public ImmutableMap build()
        {
            switch (size)
            {
            default:
                return new RegularImmutableMap(size, entries);

            case 0: // '\0'
                return ImmutableMap.of();

            case 1: // '\001'
                return ImmutableMap.of(entries[0].getKey(), entries[0].getValue());
            }
        }

        public Builder put(Object obj, Object obj1)
        {
            ensureCapacity(size + 1);
            obj = ImmutableMap.entryOf(obj, obj1);
            obj1 = entries;
            int i = size;
            size = i + 1;
            obj1[i] = obj;
            return this;
        }

        public Builder()
        {
            this(4);
        }

        Builder(int i)
        {
            entries = new ImmutableMapEntry.TerminalEntry[i];
            size = 0;
        }
    }


    private static final java.util.Map.Entry EMPTY_ENTRY_ARRAY[] = new java.util.Map.Entry[0];
    private transient ImmutableSet entrySet;
    private transient ImmutableSet keySet;
    private transient ImmutableCollection values;

    ImmutableMap()
    {
    }

    public static Builder builder()
    {
        return new Builder();
    }

    static void checkNoConflict(boolean flag, String s, java.util.Map.Entry entry, java.util.Map.Entry entry1)
    {
        if (!flag)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Multiple entries with same ").append(s).append(": ").append(entry).append(" and ").append(entry1).toString());
        } else
        {
            return;
        }
    }

    public static ImmutableMap copyOf(Map map)
    {
        if ((map instanceof ImmutableMap) && !(map instanceof ImmutableSortedMap))
        {
            ImmutableMap immutablemap = (ImmutableMap)map;
            if (!immutablemap.isPartialView())
            {
                return immutablemap;
            }
        } else
        if (map instanceof EnumMap)
        {
            return copyOfEnumMapUnsafe(map);
        }
        map = (java.util.Map.Entry[])map.entrySet().toArray(EMPTY_ENTRY_ARRAY);
        switch (map.length)
        {
        default:
            return new RegularImmutableMap(map);

        case 0: // '\0'
            return of();

        case 1: // '\001'
            map = map[0];
            break;
        }
        return of(map.getKey(), map.getValue());
    }

    private static ImmutableMap copyOfEnumMap(Map map)
    {
        map = new EnumMap(map);
        java.util.Map.Entry entry;
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); CollectPreconditions.checkEntryNotNull(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return ImmutableEnumMap.asImmutable(map);
    }

    private static ImmutableMap copyOfEnumMapUnsafe(Map map)
    {
        return copyOfEnumMap((EnumMap)map);
    }

    static ImmutableMapEntry.TerminalEntry entryOf(Object obj, Object obj1)
    {
        CollectPreconditions.checkEntryNotNull(obj, obj1);
        return new ImmutableMapEntry.TerminalEntry(obj, obj1);
    }

    public static ImmutableMap of()
    {
        return ImmutableBiMap.of();
    }

    public static ImmutableMap of(Object obj, Object obj1)
    {
        return ImmutableBiMap.of(obj, obj1);
    }

    public final void clear()
    {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(Object obj)
    {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj)
    {
        return values().contains(obj);
    }

    abstract ImmutableSet createEntrySet();

    ImmutableSet createKeySet()
    {
        return new ImmutableMapKeySet(this);
    }

    public ImmutableSet entrySet()
    {
        ImmutableSet immutableset1 = entrySet;
        ImmutableSet immutableset = immutableset1;
        if (immutableset1 == null)
        {
            immutableset = createEntrySet();
            entrySet = immutableset;
        }
        return immutableset;
    }

    public volatile Set entrySet()
    {
        return entrySet();
    }

    public boolean equals(Object obj)
    {
        return Maps.equalsImpl(this, obj);
    }

    public abstract Object get(Object obj);

    public int hashCode()
    {
        return entrySet().hashCode();
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    abstract boolean isPartialView();

    public ImmutableSet keySet()
    {
        ImmutableSet immutableset1 = keySet;
        ImmutableSet immutableset = immutableset1;
        if (immutableset1 == null)
        {
            immutableset = createKeySet();
            keySet = immutableset;
        }
        return immutableset;
    }

    public volatile Set keySet()
    {
        return keySet();
    }

    public final Object put(Object obj, Object obj1)
    {
        throw new UnsupportedOperationException();
    }

    public final void putAll(Map map)
    {
        throw new UnsupportedOperationException();
    }

    public final Object remove(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public String toString()
    {
        return Maps.toStringImpl(this);
    }

    public ImmutableCollection values()
    {
        ImmutableCollection immutablecollection = values;
        Object obj = immutablecollection;
        if (immutablecollection == null)
        {
            obj = new ImmutableMapValues(this);
            values = ((ImmutableCollection) (obj));
        }
        return ((ImmutableCollection) (obj));
    }

    public volatile Collection values()
    {
        return values();
    }

}
