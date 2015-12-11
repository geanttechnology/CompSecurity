// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

// Referenced classes of package com.google.common.collect:
//            ImmutableSortedMapFauxverideShim, Ordering, ImmutableSortedSet, ImmutableList, 
//            Iterables, CollectPreconditions, RegularImmutableSortedSet, RegularImmutableList, 
//            ImmutableMapEntry, Maps, ImmutableSet, ImmutableCollection, 
//            ImmutableMapEntrySet, UnmodifiableIterator, ImmutableMap, ImmutableAsList

public final class ImmutableSortedMap extends ImmutableSortedMapFauxverideShim
    implements NavigableMap
{
    class _cls1EntrySet extends ImmutableMapEntrySet
    {

        final ImmutableSortedMap this$0;

        ImmutableList createAsList()
        {
            return new ImmutableAsList() {

                final _cls1EntrySet this$1;

                ImmutableCollection delegateCollection()
                {
                    return _cls1EntrySet.this;
                }

                public volatile Object get(int i)
                {
                    return get(i);
                }

                public java.util.Map.Entry get(int i)
                {
                    return Maps.immutableEntry(keySet.asList().get(i), valueList.get(i));
                }

            
            {
                this$1 = _cls1EntrySet.this;
                super();
            }
            };
        }

        public UnmodifiableIterator iterator()
        {
            return asList().iterator();
        }

        public volatile Iterator iterator()
        {
            return iterator();
        }

        ImmutableMap map()
        {
            return ImmutableSortedMap.this;
        }

        _cls1EntrySet()
        {
            this$0 = ImmutableSortedMap.this;
            super();
        }
    }

    public static class Builder extends ImmutableMap.Builder
    {

        private final Comparator comparator;

        public volatile ImmutableMap build()
        {
            return build();
        }

        public ImmutableSortedMap build()
        {
            switch (size)
            {
            default:
                return ImmutableSortedMap.fromEntries(comparator, false, entries, size);

            case 0: // '\0'
                return ImmutableSortedMap.emptyMap(comparator);

            case 1: // '\001'
                return ImmutableSortedMap.of(comparator, entries[0].getKey(), entries[0].getValue());
            }
        }

        public volatile ImmutableMap.Builder orderEntriesByValue(Comparator comparator1)
        {
            return orderEntriesByValue(comparator1);
        }

        public Builder orderEntriesByValue(Comparator comparator1)
        {
            throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
        }

        public volatile ImmutableMap.Builder put(Object obj, Object obj1)
        {
            return put(obj, obj1);
        }

        public volatile ImmutableMap.Builder put(java.util.Map.Entry entry)
        {
            return put(entry);
        }

        public Builder put(Object obj, Object obj1)
        {
            super.put(obj, obj1);
            return this;
        }

        public Builder put(java.util.Map.Entry entry)
        {
            super.put(entry);
            return this;
        }

        public volatile ImmutableMap.Builder putAll(Iterable iterable)
        {
            return putAll(iterable);
        }

        public volatile ImmutableMap.Builder putAll(Map map)
        {
            return putAll(map);
        }

        public Builder putAll(Iterable iterable)
        {
            super.putAll(iterable);
            return this;
        }

        public Builder putAll(Map map)
        {
            super.putAll(map);
            return this;
        }

        public Builder(Comparator comparator1)
        {
            comparator = (Comparator)Preconditions.checkNotNull(comparator1);
        }
    }

    private static class SerializedForm extends ImmutableMap.SerializedForm
    {

        private static final long serialVersionUID = 0L;
        private final Comparator comparator;

        Object readResolve()
        {
            return createMap(new Builder(comparator));
        }

        SerializedForm(ImmutableSortedMap immutablesortedmap)
        {
            super(immutablesortedmap);
            comparator = immutablesortedmap.comparator();
        }
    }


    private static final ImmutableSortedMap NATURAL_EMPTY_MAP = new ImmutableSortedMap(ImmutableSortedSet.emptySet(Ordering.natural()), ImmutableList.of());
    private static final Comparator NATURAL_ORDER = Ordering.natural();
    private static final long serialVersionUID = 0L;
    private transient ImmutableSortedMap descendingMap;
    private final transient RegularImmutableSortedSet keySet;
    private final transient ImmutableList valueList;

    ImmutableSortedMap(RegularImmutableSortedSet regularimmutablesortedset, ImmutableList immutablelist)
    {
        this(regularimmutablesortedset, immutablelist, null);
    }

    ImmutableSortedMap(RegularImmutableSortedSet regularimmutablesortedset, ImmutableList immutablelist, ImmutableSortedMap immutablesortedmap)
    {
        keySet = regularimmutablesortedset;
        valueList = immutablelist;
        descendingMap = immutablesortedmap;
    }

    public static ImmutableSortedMap copyOf(Iterable iterable)
    {
        return copyOf(iterable, ((Comparator) ((Ordering)NATURAL_ORDER)));
    }

    public static ImmutableSortedMap copyOf(Iterable iterable, Comparator comparator1)
    {
        return fromEntries((Comparator)Preconditions.checkNotNull(comparator1), false, iterable);
    }

    public static ImmutableSortedMap copyOf(Map map)
    {
        return copyOfInternal(map, (Ordering)NATURAL_ORDER);
    }

    public static ImmutableSortedMap copyOf(Map map, Comparator comparator1)
    {
        return copyOfInternal(map, (Comparator)Preconditions.checkNotNull(comparator1));
    }

    private static ImmutableSortedMap copyOfInternal(Map map, Comparator comparator1)
    {
        boolean flag = false;
        if (map instanceof SortedMap)
        {
            Object obj = ((SortedMap)map).comparator();
            if (obj == null)
            {
                if (comparator1 == NATURAL_ORDER)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            {
                flag = comparator1.equals(obj);
            }
        }
        if (flag && (map instanceof ImmutableSortedMap))
        {
            obj = (ImmutableSortedMap)map;
            if (!((ImmutableSortedMap) (obj)).isPartialView())
            {
                return ((ImmutableSortedMap) (obj));
            }
        }
        return fromEntries(comparator1, flag, map.entrySet());
    }

    public static ImmutableSortedMap copyOfSorted(SortedMap sortedmap)
    {
        Comparator comparator2 = sortedmap.comparator();
        Comparator comparator1 = comparator2;
        if (comparator2 == null)
        {
            comparator1 = NATURAL_ORDER;
        }
        if (sortedmap instanceof ImmutableSortedMap)
        {
            ImmutableSortedMap immutablesortedmap = (ImmutableSortedMap)sortedmap;
            if (!immutablesortedmap.isPartialView())
            {
                return immutablesortedmap;
            }
        }
        return fromEntries(comparator1, true, sortedmap.entrySet());
    }

    static ImmutableSortedMap emptyMap(Comparator comparator1)
    {
        if (Ordering.natural().equals(comparator1))
        {
            return of();
        } else
        {
            return new ImmutableSortedMap(ImmutableSortedSet.emptySet(comparator1), ImmutableList.of());
        }
    }

    private static ImmutableSortedMap fromEntries(Comparator comparator1, boolean flag, Iterable iterable)
    {
        iterable = (java.util.Map.Entry[])(java.util.Map.Entry[])Iterables.toArray(iterable, EMPTY_ENTRY_ARRAY);
        return fromEntries(comparator1, flag, ((java.util.Map.Entry []) (iterable)), iterable.length);
    }

    private static ImmutableSortedMap fromEntries(Comparator comparator1, boolean flag, java.util.Map.Entry aentry[], int i)
    {
        Object aobj[];
        Object aobj1[];
        switch (i)
        {
        default:
            aobj = new Object[i];
            aobj1 = new Object[i];
            if (flag)
            {
                for (int j = 0; j < i; j++)
                {
                    Object obj = aentry[j].getKey();
                    Object obj2 = aentry[j].getValue();
                    CollectPreconditions.checkEntryNotNull(obj, obj2);
                    aobj[j] = obj;
                    aobj1[j] = obj2;
                }

            } else
            {
                Arrays.sort(aentry, 0, i, Ordering.from(comparator1).onKeys());
                Object obj1 = aentry[0].getKey();
                aobj[0] = obj1;
                aobj1[0] = aentry[0].getValue();
                int k = 1;
                while (k < i) 
                {
                    Object obj3 = aentry[k].getKey();
                    Object obj4 = aentry[k].getValue();
                    CollectPreconditions.checkEntryNotNull(obj3, obj4);
                    aobj[k] = obj3;
                    aobj1[k] = obj4;
                    if (comparator1.compare(obj1, obj3) != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    checkNoConflict(flag, "key", aentry[k - 1], aentry[k]);
                    obj1 = obj3;
                    k++;
                }
            }
            break;

        case 0: // '\0'
            return emptyMap(comparator1);

        case 1: // '\001'
            return of(comparator1, aentry[0].getKey(), aentry[0].getValue());
        }
        return new ImmutableSortedMap(new RegularImmutableSortedSet(new RegularImmutableList(aobj), comparator1), new RegularImmutableList(aobj1));
    }

    private ImmutableSortedMap getSubMap(int i, int j)
    {
        if (i == 0 && j == size())
        {
            return this;
        }
        if (i == j)
        {
            return emptyMap(comparator());
        } else
        {
            return new ImmutableSortedMap(keySet.getSubSet(i, j), valueList.subList(i, j));
        }
    }

    public static Builder naturalOrder()
    {
        return new Builder(Ordering.natural());
    }

    public static ImmutableSortedMap of()
    {
        return NATURAL_EMPTY_MAP;
    }

    public static ImmutableSortedMap of(Comparable comparable, Object obj)
    {
        return of(((Comparator) (Ordering.natural())), comparable, obj);
    }

    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable1, Object obj1)
    {
        return ofEntries(new ImmutableMapEntry[] {
            entryOf(comparable, obj), entryOf(comparable1, obj1)
        });
    }

    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable1, Object obj1, Comparable comparable2, Object obj2)
    {
        return ofEntries(new ImmutableMapEntry[] {
            entryOf(comparable, obj), entryOf(comparable1, obj1), entryOf(comparable2, obj2)
        });
    }

    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable1, Object obj1, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3)
    {
        return ofEntries(new ImmutableMapEntry[] {
            entryOf(comparable, obj), entryOf(comparable1, obj1), entryOf(comparable2, obj2), entryOf(comparable3, obj3)
        });
    }

    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable1, Object obj1, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, 
            Comparable comparable4, Object obj4)
    {
        return ofEntries(new ImmutableMapEntry[] {
            entryOf(comparable, obj), entryOf(comparable1, obj1), entryOf(comparable2, obj2), entryOf(comparable3, obj3), entryOf(comparable4, obj4)
        });
    }

    private static ImmutableSortedMap of(Comparator comparator1, Object obj, Object obj1)
    {
        return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.of(obj), (Comparator)Preconditions.checkNotNull(comparator1)), ImmutableList.of(obj1));
    }

    private static transient ImmutableSortedMap ofEntries(ImmutableMapEntry aimmutablemapentry[])
    {
        return fromEntries(Ordering.natural(), false, aimmutablemapentry, aimmutablemapentry.length);
    }

    public static Builder orderedBy(Comparator comparator1)
    {
        return new Builder(comparator1);
    }

    public static Builder reverseOrder()
    {
        return new Builder(Ordering.natural().reverse());
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

    ImmutableSet createEntrySet()
    {
        if (isEmpty())
        {
            return ImmutableSet.of();
        } else
        {
            return new _cls1EntrySet();
        }
    }

    public ImmutableSortedSet descendingKeySet()
    {
        return keySet.descendingSet();
    }

    public volatile NavigableSet descendingKeySet()
    {
        return descendingKeySet();
    }

    public ImmutableSortedMap descendingMap()
    {
        ImmutableSortedMap immutablesortedmap = descendingMap;
        if (immutablesortedmap == null)
        {
            if (isEmpty())
            {
                return emptyMap(Ordering.from(comparator()).reverse());
            } else
            {
                return new ImmutableSortedMap((RegularImmutableSortedSet)keySet.descendingSet(), valueList.reverse(), this);
            }
        } else
        {
            return immutablesortedmap;
        }
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

    public Object get(Object obj)
    {
        int i = keySet.indexOf(obj);
        if (i == -1)
        {
            return null;
        } else
        {
            return valueList.get(i);
        }
    }

    public ImmutableSortedMap headMap(Object obj)
    {
        return headMap(obj, false);
    }

    public ImmutableSortedMap headMap(Object obj, boolean flag)
    {
        return getSubMap(0, keySet.headIndex(Preconditions.checkNotNull(obj), flag));
    }

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
        return keySet.isPartialView() || valueList.isPartialView();
    }

    public volatile ImmutableSet keySet()
    {
        return keySet();
    }

    public ImmutableSortedSet keySet()
    {
        return keySet;
    }

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
        return keySet;
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
        return valueList.size();
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

    public ImmutableSortedMap tailMap(Object obj, boolean flag)
    {
        return getSubMap(keySet.tailIndex(Preconditions.checkNotNull(obj), flag), size());
    }

    public volatile NavigableMap tailMap(Object obj, boolean flag)
    {
        return tailMap(obj, flag);
    }

    public volatile SortedMap tailMap(Object obj)
    {
        return tailMap(obj);
    }

    public ImmutableCollection values()
    {
        return valueList;
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
