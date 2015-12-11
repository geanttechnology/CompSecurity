// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            Iterables, RegularImmutableMap, ImmutableSortedMap, CollectPreconditions, 
//            ImmutableEnumMap, ImmutableMapEntry, ImmutableBiMap, ImmutableSetMultimap, 
//            ImmutableCollection, ImmutableSet, ImmutableMapKeySet, Maps, 
//            Sets, ImmutableMapValues, UnmodifiableIterator, ObjectArrays, 
//            Ordering, ImmutableMapEntrySet, AbstractMapEntry

public abstract class ImmutableMap
    implements Map, Serializable
{
    public static class Builder
    {

        ImmutableMapEntry entries[];
        boolean entriesUsed;
        int size;
        Comparator valueComparator;

        private void ensureCapacity(int i)
        {
            if (i > entries.length)
            {
                entries = (ImmutableMapEntry[])ObjectArrays.arraysCopyOf(entries, ImmutableCollection.Builder.expandedCapacity(entries.length, i));
                entriesUsed = false;
            }
        }

        public ImmutableMap build()
        {
            switch (size)
            {
            default:
                if (valueComparator != null)
                {
                    if (entriesUsed)
                    {
                        entries = (ImmutableMapEntry[])ObjectArrays.arraysCopyOf(entries, size);
                    }
                    Arrays.sort(entries, 0, size, Ordering.from(valueComparator).onResultOf(Maps.valueFunction()));
                }
                boolean flag;
                if (size == entries.length)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                entriesUsed = flag;
                return RegularImmutableMap.fromEntryArray(size, entries);

            case 0: // '\0'
                return ImmutableMap.of();

            case 1: // '\001'
                return ImmutableMap.of(entries[0].getKey(), entries[0].getValue());
            }
        }

        public Builder orderEntriesByValue(Comparator comparator)
        {
            boolean flag;
            if (valueComparator == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkState(flag, "valueComparator was already set");
            valueComparator = (Comparator)Preconditions.checkNotNull(comparator, "valueComparator");
            return this;
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

        public Builder put(java.util.Map.Entry entry)
        {
            return put(entry.getKey(), entry.getValue());
        }

        public Builder putAll(Iterable iterable)
        {
            if (iterable instanceof Collection)
            {
                int i = size;
                ensureCapacity(((Collection)iterable).size() + i);
            }
            for (iterable = iterable.iterator(); iterable.hasNext(); put((java.util.Map.Entry)iterable.next())) { }
            return this;
        }

        public Builder putAll(Map map)
        {
            return putAll(((Iterable) (map.entrySet())));
        }

        public Builder()
        {
            this(4);
        }

        Builder(int i)
        {
            entries = new ImmutableMapEntry[i];
            size = 0;
            entriesUsed = false;
        }
    }

    static abstract class IteratorBasedImmutableMap extends ImmutableMap
    {

        ImmutableSet createEntrySet()
        {
            return new _cls1EntrySetImpl();
        }

        abstract UnmodifiableIterator entryIterator();

        public volatile Set entrySet()
        {
            return entrySet();
        }

        public volatile Set keySet()
        {
            return keySet();
        }

        public volatile Collection values()
        {
            return values();
        }

        IteratorBasedImmutableMap()
        {
        }
    }

    class IteratorBasedImmutableMap._cls1EntrySetImpl extends ImmutableMapEntrySet
    {

        final IteratorBasedImmutableMap this$0;

        public UnmodifiableIterator iterator()
        {
            return entryIterator();
        }

        public volatile Iterator iterator()
        {
            return iterator();
        }

        ImmutableMap map()
        {
            return IteratorBasedImmutableMap.this;
        }

        IteratorBasedImmutableMap._cls1EntrySetImpl()
        {
            this$0 = IteratorBasedImmutableMap.this;
            super();
        }
    }

    private final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap
    {

        final ImmutableMap this$0;

        public boolean containsKey(Object obj)
        {
            return ImmutableMap.this.containsKey(obj);
        }

        UnmodifiableIterator entryIterator()
        {
            return entrySet().iterator(). new UnmodifiableIterator() {

                final MapViewOfValuesAsSingletonSets this$1;
                final Iterator val$backingIterator;

                public boolean hasNext()
                {
                    return backingIterator.hasNext();
                }

                public volatile Object next()
                {
                    return next();
                }

                public java.util.Map.Entry next()
                {
                    return ((java.util.Map.Entry)backingIterator.next()). new AbstractMapEntry() {

                        final MapViewOfValuesAsSingletonSets._cls1 this$2;
                        final java.util.Map.Entry val$backingEntry;

                        public Object getKey()
                        {
                            return backingEntry.getKey();
                        }

                        public ImmutableSet getValue()
                        {
                            return ImmutableSet.of(backingEntry.getValue());
                        }

                        public volatile Object getValue()
                        {
                            return getValue();
                        }

            
            {
                this$2 = final__pcls1;
                backingEntry = java.util.Map.Entry.this;
                super();
            }
                    };
                }

            
            {
                this$1 = final_mapviewofvaluesassingletonsets;
                backingIterator = Iterator.this;
                super();
            }
            };
        }

        public ImmutableSet get(Object obj)
        {
            obj = ImmutableMap.this.get(obj);
            if (obj == null)
            {
                return null;
            } else
            {
                return ImmutableSet.of(obj);
            }
        }

        public volatile Object get(Object obj)
        {
            return get(obj);
        }

        public int hashCode()
        {
            return ImmutableMap.this.hashCode();
        }

        boolean isHashCodeFast()
        {
            return ImmutableMap.this.isHashCodeFast();
        }

        boolean isPartialView()
        {
            return ImmutableMap.this.isPartialView();
        }

        public ImmutableSet keySet()
        {
            return ImmutableMap.this.keySet();
        }

        public volatile Set keySet()
        {
            return keySet();
        }

        public int size()
        {
            return ImmutableMap.this.size();
        }

        private MapViewOfValuesAsSingletonSets()
        {
            this$0 = ImmutableMap.this;
            super();
        }

    }

    static class SerializedForm
        implements Serializable
    {

        private static final long serialVersionUID = 0L;
        private final Object keys[];
        private final Object values[];

        Object createMap(Builder builder1)
        {
            for (int i = 0; i < keys.length; i++)
            {
                builder1.put(keys[i], values[i]);
            }

            return builder1.build();
        }

        Object readResolve()
        {
            return createMap(new Builder(keys.length));
        }

        SerializedForm(ImmutableMap immutablemap)
        {
            keys = new Object[immutablemap.size()];
            values = new Object[immutablemap.size()];
            int i = 0;
            for (immutablemap = immutablemap.entrySet().iterator(); immutablemap.hasNext();)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)immutablemap.next();
                keys[i] = entry.getKey();
                values[i] = entry.getValue();
                i++;
            }

        }
    }


    static final java.util.Map.Entry EMPTY_ENTRY_ARRAY[] = new java.util.Map.Entry[0];
    private transient ImmutableSet entrySet;
    private transient ImmutableSet keySet;
    private transient ImmutableSetMultimap multimapView;
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
            entry = String.valueOf(entry);
            entry1 = String.valueOf(entry1);
            throw new IllegalArgumentException((new StringBuilder(String.valueOf(s).length() + 34 + String.valueOf(entry).length() + String.valueOf(entry1).length())).append("Multiple entries with same ").append(s).append(": ").append(entry).append(" and ").append(entry1).toString());
        } else
        {
            return;
        }
    }

    public static ImmutableMap copyOf(Iterable iterable)
    {
        iterable = (java.util.Map.Entry[])(java.util.Map.Entry[])Iterables.toArray(iterable, EMPTY_ENTRY_ARRAY);
        switch (iterable.length)
        {
        default:
            return RegularImmutableMap.fromEntries(iterable);

        case 0: // '\0'
            return of();

        case 1: // '\001'
            iterable = iterable[0];
            break;
        }
        return of(iterable.getKey(), iterable.getValue());
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
            return copyOfEnumMap((EnumMap)map);
        }
        return copyOf(((Iterable) (map.entrySet())));
    }

    private static ImmutableMap copyOfEnumMap(EnumMap enummap)
    {
        enummap = new EnumMap(enummap);
        java.util.Map.Entry entry;
        for (Iterator iterator = enummap.entrySet().iterator(); iterator.hasNext(); CollectPreconditions.checkEntryNotNull(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return ImmutableEnumMap.asImmutable(enummap);
    }

    static ImmutableMapEntry entryOf(Object obj, Object obj1)
    {
        return new ImmutableMapEntry(obj, obj1);
    }

    public static ImmutableMap of()
    {
        return ImmutableBiMap.of();
    }

    public static ImmutableMap of(Object obj, Object obj1)
    {
        return ImmutableBiMap.of(obj, obj1);
    }

    public static ImmutableMap of(Object obj, Object obj1, Object obj2, Object obj3)
    {
        return RegularImmutableMap.fromEntries(new java.util.Map.Entry[] {
            entryOf(obj, obj1), entryOf(obj2, obj3)
        });
    }

    public static ImmutableMap of(Object obj, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5)
    {
        return RegularImmutableMap.fromEntries(new java.util.Map.Entry[] {
            entryOf(obj, obj1), entryOf(obj2, obj3), entryOf(obj4, obj5)
        });
    }

    public static ImmutableMap of(Object obj, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7)
    {
        return RegularImmutableMap.fromEntries(new java.util.Map.Entry[] {
            entryOf(obj, obj1), entryOf(obj2, obj3), entryOf(obj4, obj5), entryOf(obj6, obj7)
        });
    }

    public static ImmutableMap of(Object obj, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, 
            Object obj8, Object obj9)
    {
        return RegularImmutableMap.fromEntries(new java.util.Map.Entry[] {
            entryOf(obj, obj1), entryOf(obj2, obj3), entryOf(obj4, obj5), entryOf(obj6, obj7), entryOf(obj8, obj9)
        });
    }

    public ImmutableSetMultimap asMultimap()
    {
        ImmutableSetMultimap immutablesetmultimap;
        if (isEmpty())
        {
            immutablesetmultimap = ImmutableSetMultimap.of();
        } else
        {
            ImmutableSetMultimap immutablesetmultimap2 = multimapView;
            immutablesetmultimap = immutablesetmultimap2;
            if (immutablesetmultimap2 == null)
            {
                ImmutableSetMultimap immutablesetmultimap1 = new ImmutableSetMultimap(new MapViewOfValuesAsSingletonSets(), size(), null);
                multimapView = immutablesetmultimap1;
                return immutablesetmultimap1;
            }
        }
        return immutablesetmultimap;
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
        if (isEmpty())
        {
            return ImmutableSet.of();
        } else
        {
            return new ImmutableMapKeySet(this);
        }
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
        return Sets.hashCodeImpl(entrySet());
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    boolean isHashCodeFast()
    {
        return false;
    }

    abstract boolean isPartialView();

    UnmodifiableIterator keyIterator()
    {
        return new UnmodifiableIterator() {

            final ImmutableMap this$0;
            final UnmodifiableIterator val$entryIterator;

            public boolean hasNext()
            {
                return entryIterator.hasNext();
            }

            public Object next()
            {
                return ((java.util.Map.Entry)entryIterator.next()).getKey();
            }

            
            {
                this$0 = ImmutableMap.this;
                entryIterator = unmodifiableiterator;
                super();
            }
        };
    }

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

    Object writeReplace()
    {
        return new SerializedForm(this);
    }

}
