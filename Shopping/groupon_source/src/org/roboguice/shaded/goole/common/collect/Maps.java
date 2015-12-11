// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import org.roboguice.shaded.goole.common.base.Function;
import org.roboguice.shaded.goole.common.base.Joiner;
import org.roboguice.shaded.goole.common.base.Objects;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            Collections2, CollectPreconditions, ImmutableEntry, Iterators, 
//            Platform, UnmodifiableIterator, Sets, AbstractMapEntry

public final class Maps
{
    private static abstract class EntryFunction extends Enum
        implements Function
    {

        private static final EntryFunction $VALUES[];
        public static final EntryFunction KEY;
        public static final EntryFunction VALUE;

        public static EntryFunction valueOf(String s)
        {
            return (EntryFunction)Enum.valueOf(org/roboguice/shaded/goole/common/collect/Maps$EntryFunction, s);
        }

        public static EntryFunction[] values()
        {
            return (EntryFunction[])$VALUES.clone();
        }

        static 
        {
            KEY = new EntryFunction("KEY", 0) {

                public volatile Object apply(Object obj)
                {
                    return apply((java.util.Map.Entry)obj);
                }

                public Object apply(java.util.Map.Entry entry)
                {
                    return entry.getKey();
                }

            };
            VALUE = new EntryFunction("VALUE", 1) {

                public volatile Object apply(Object obj)
                {
                    return apply((java.util.Map.Entry)obj);
                }

                public Object apply(java.util.Map.Entry entry)
                {
                    return entry.getValue();
                }

            };
            $VALUES = (new EntryFunction[] {
                KEY, VALUE
            });
        }

        private EntryFunction(String s, int i)
        {
            super(s, i);
        }

    }

    static abstract class EntrySet extends Sets.ImprovedAbstractSet
    {

        public void clear()
        {
            map().clear();
        }

        public boolean contains(Object obj)
        {
            boolean flag;
label0:
            {
                boolean flag1 = false;
                flag = flag1;
                if (!(obj instanceof java.util.Map.Entry))
                {
                    break label0;
                }
                obj = (java.util.Map.Entry)obj;
                Object obj1 = ((java.util.Map.Entry) (obj)).getKey();
                Object obj2 = Maps.safeGet(map(), obj1);
                flag = flag1;
                if (!Objects.equal(obj2, ((java.util.Map.Entry) (obj)).getValue()))
                {
                    break label0;
                }
                if (obj2 == null)
                {
                    flag = flag1;
                    if (!map().containsKey(obj1))
                    {
                        break label0;
                    }
                }
                flag = true;
            }
            return flag;
        }

        public boolean isEmpty()
        {
            return map().isEmpty();
        }

        abstract Map map();

        public boolean remove(Object obj)
        {
            if (contains(obj))
            {
                obj = (java.util.Map.Entry)obj;
                return map().keySet().remove(((java.util.Map.Entry) (obj)).getKey());
            } else
            {
                return false;
            }
        }

        public boolean removeAll(Collection collection)
        {
            boolean flag;
            try
            {
                flag = super.removeAll((Collection)Preconditions.checkNotNull(collection));
            }
            catch (UnsupportedOperationException unsupportedoperationexception)
            {
                return Sets.removeAllImpl(this, collection.iterator());
            }
            return flag;
        }

        public boolean retainAll(Collection collection)
        {
            boolean flag;
            try
            {
                flag = super.retainAll((Collection)Preconditions.checkNotNull(collection));
            }
            catch (UnsupportedOperationException unsupportedoperationexception)
            {
                java.util.HashSet hashset = Sets.newHashSetWithExpectedSize(collection.size());
                collection = collection.iterator();
                do
                {
                    if (!collection.hasNext())
                    {
                        break;
                    }
                    Object obj = collection.next();
                    if (contains(obj))
                    {
                        hashset.add(((java.util.Map.Entry)obj).getKey());
                    }
                } while (true);
                return map().keySet().retainAll(hashset);
            }
            return flag;
        }

        public int size()
        {
            return map().size();
        }

        EntrySet()
        {
        }
    }

    public static interface EntryTransformer
    {

        public abstract Object transformEntry(Object obj, Object obj1);
    }

    static abstract class ImprovedAbstractMap extends AbstractMap
    {

        private transient Set entrySet;
        private transient Set keySet;
        private transient Collection values;

        abstract Set createEntrySet();

        Set createKeySet()
        {
            return new KeySet(this);
        }

        Collection createValues()
        {
            return new Values(this);
        }

        public Set entrySet()
        {
            Set set1 = entrySet;
            Set set = set1;
            if (set1 == null)
            {
                set = createEntrySet();
                entrySet = set;
            }
            return set;
        }

        public Set keySet()
        {
            Set set1 = keySet;
            Set set = set1;
            if (set1 == null)
            {
                set = createKeySet();
                keySet = set;
            }
            return set;
        }

        public Collection values()
        {
            Collection collection1 = values;
            Collection collection = collection1;
            if (collection1 == null)
            {
                collection = createValues();
                values = collection;
            }
            return collection;
        }

        ImprovedAbstractMap()
        {
        }
    }

    static class KeySet extends Sets.ImprovedAbstractSet
    {

        final Map map;

        public void clear()
        {
            map().clear();
        }

        public boolean contains(Object obj)
        {
            return map().containsKey(obj);
        }

        public boolean isEmpty()
        {
            return map().isEmpty();
        }

        public Iterator iterator()
        {
            return Maps.keyIterator(map().entrySet().iterator());
        }

        Map map()
        {
            return map;
        }

        public boolean remove(Object obj)
        {
            if (contains(obj))
            {
                map().remove(obj);
                return true;
            } else
            {
                return false;
            }
        }

        public int size()
        {
            return map().size();
        }

        KeySet(Map map1)
        {
            map = (Map)Preconditions.checkNotNull(map1);
        }
    }

    static class TransformedEntriesMap extends ImprovedAbstractMap
    {

        final Map fromMap;
        final EntryTransformer transformer;

        public void clear()
        {
            fromMap.clear();
        }

        public boolean containsKey(Object obj)
        {
            return fromMap.containsKey(obj);
        }

        protected Set createEntrySet()
        {
            return new EntrySet() {

                final TransformedEntriesMap this$0;

                public Iterator iterator()
                {
                    return Iterators.transform(fromMap.entrySet().iterator(), Maps.asEntryToEntryFunction(transformer));
                }

                Map map()
                {
                    return TransformedEntriesMap.this;
                }

            
            {
                this$0 = TransformedEntriesMap.this;
                super();
            }
            };
        }

        public Object get(Object obj)
        {
            Object obj1 = fromMap.get(obj);
            if (obj1 != null || fromMap.containsKey(obj))
            {
                return transformer.transformEntry(obj, obj1);
            } else
            {
                return null;
            }
        }

        public Set keySet()
        {
            return fromMap.keySet();
        }

        public Object remove(Object obj)
        {
            if (fromMap.containsKey(obj))
            {
                return transformer.transformEntry(obj, fromMap.remove(obj));
            } else
            {
                return null;
            }
        }

        public int size()
        {
            return fromMap.size();
        }

        TransformedEntriesMap(Map map, EntryTransformer entrytransformer)
        {
            fromMap = (Map)Preconditions.checkNotNull(map);
            transformer = (EntryTransformer)Preconditions.checkNotNull(entrytransformer);
        }
    }

    private static class TransformedEntriesNavigableMap extends TransformedEntriesSortedMap
        implements NavigableMap
    {

        private java.util.Map.Entry transformEntry(java.util.Map.Entry entry)
        {
            if (entry == null)
            {
                return null;
            } else
            {
                return Maps.transformEntry(transformer, entry);
            }
        }

        public java.util.Map.Entry ceilingEntry(Object obj)
        {
            return transformEntry(fromMap().ceilingEntry(obj));
        }

        public Object ceilingKey(Object obj)
        {
            return fromMap().ceilingKey(obj);
        }

        public NavigableSet descendingKeySet()
        {
            return fromMap().descendingKeySet();
        }

        public NavigableMap descendingMap()
        {
            return Maps.transformEntries(fromMap().descendingMap(), transformer);
        }

        public java.util.Map.Entry firstEntry()
        {
            return transformEntry(fromMap().firstEntry());
        }

        public java.util.Map.Entry floorEntry(Object obj)
        {
            return transformEntry(fromMap().floorEntry(obj));
        }

        public Object floorKey(Object obj)
        {
            return fromMap().floorKey(obj);
        }

        protected NavigableMap fromMap()
        {
            return (NavigableMap)super.fromMap();
        }

        protected volatile SortedMap fromMap()
        {
            return fromMap();
        }

        public NavigableMap headMap(Object obj)
        {
            return headMap(obj, false);
        }

        public NavigableMap headMap(Object obj, boolean flag)
        {
            return Maps.transformEntries(fromMap().headMap(obj, flag), transformer);
        }

        public volatile SortedMap headMap(Object obj)
        {
            return headMap(obj);
        }

        public java.util.Map.Entry higherEntry(Object obj)
        {
            return transformEntry(fromMap().higherEntry(obj));
        }

        public Object higherKey(Object obj)
        {
            return fromMap().higherKey(obj);
        }

        public java.util.Map.Entry lastEntry()
        {
            return transformEntry(fromMap().lastEntry());
        }

        public java.util.Map.Entry lowerEntry(Object obj)
        {
            return transformEntry(fromMap().lowerEntry(obj));
        }

        public Object lowerKey(Object obj)
        {
            return fromMap().lowerKey(obj);
        }

        public NavigableSet navigableKeySet()
        {
            return fromMap().navigableKeySet();
        }

        public java.util.Map.Entry pollFirstEntry()
        {
            return transformEntry(fromMap().pollFirstEntry());
        }

        public java.util.Map.Entry pollLastEntry()
        {
            return transformEntry(fromMap().pollLastEntry());
        }

        public NavigableMap subMap(Object obj, Object obj1)
        {
            return subMap(obj, true, obj1, false);
        }

        public NavigableMap subMap(Object obj, boolean flag, Object obj1, boolean flag1)
        {
            return Maps.transformEntries(fromMap().subMap(obj, flag, obj1, flag1), transformer);
        }

        public volatile SortedMap subMap(Object obj, Object obj1)
        {
            return subMap(obj, obj1);
        }

        public NavigableMap tailMap(Object obj)
        {
            return tailMap(obj, true);
        }

        public NavigableMap tailMap(Object obj, boolean flag)
        {
            return Maps.transformEntries(fromMap().tailMap(obj, flag), transformer);
        }

        public volatile SortedMap tailMap(Object obj)
        {
            return tailMap(obj);
        }

        TransformedEntriesNavigableMap(NavigableMap navigablemap, EntryTransformer entrytransformer)
        {
            super(navigablemap, entrytransformer);
        }
    }

    static class TransformedEntriesSortedMap extends TransformedEntriesMap
        implements SortedMap
    {

        public Comparator comparator()
        {
            return fromMap().comparator();
        }

        public Object firstKey()
        {
            return fromMap().firstKey();
        }

        protected SortedMap fromMap()
        {
            return (SortedMap)fromMap;
        }

        public SortedMap headMap(Object obj)
        {
            return Maps.transformEntries(fromMap().headMap(obj), transformer);
        }

        public Object lastKey()
        {
            return fromMap().lastKey();
        }

        public SortedMap subMap(Object obj, Object obj1)
        {
            return Maps.transformEntries(fromMap().subMap(obj, obj1), transformer);
        }

        public SortedMap tailMap(Object obj)
        {
            return Maps.transformEntries(fromMap().tailMap(obj), transformer);
        }

        TransformedEntriesSortedMap(SortedMap sortedmap, EntryTransformer entrytransformer)
        {
            super(sortedmap, entrytransformer);
        }
    }

    static class Values extends AbstractCollection
    {

        final Map map;

        public void clear()
        {
            map().clear();
        }

        public boolean contains(Object obj)
        {
            return map().containsValue(obj);
        }

        public boolean isEmpty()
        {
            return map().isEmpty();
        }

        public Iterator iterator()
        {
            return Maps.valueIterator(map().entrySet().iterator());
        }

        final Map map()
        {
            return map;
        }

        public boolean remove(Object obj)
        {
            boolean flag;
            try
            {
                flag = super.remove(obj);
            }
            catch (UnsupportedOperationException unsupportedoperationexception)
            {
                for (Iterator iterator1 = map().entrySet().iterator(); iterator1.hasNext();)
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                    if (Objects.equal(obj, entry.getValue()))
                    {
                        map().remove(entry.getKey());
                        return true;
                    }
                }

                return false;
            }
            return flag;
        }

        public boolean removeAll(Collection collection)
        {
            boolean flag;
            try
            {
                flag = super.removeAll((Collection)Preconditions.checkNotNull(collection));
            }
            catch (UnsupportedOperationException unsupportedoperationexception)
            {
                java.util.HashSet hashset = Sets.newHashSet();
                Iterator iterator1 = map().entrySet().iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                    if (collection.contains(entry.getValue()))
                    {
                        hashset.add(entry.getKey());
                    }
                } while (true);
                return map().keySet().removeAll(hashset);
            }
            return flag;
        }

        public boolean retainAll(Collection collection)
        {
            boolean flag;
            try
            {
                flag = super.retainAll((Collection)Preconditions.checkNotNull(collection));
            }
            catch (UnsupportedOperationException unsupportedoperationexception)
            {
                java.util.HashSet hashset = Sets.newHashSet();
                Iterator iterator1 = map().entrySet().iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                    if (collection.contains(entry.getValue()))
                    {
                        hashset.add(entry.getKey());
                    }
                } while (true);
                return map().keySet().retainAll(hashset);
            }
            return flag;
        }

        public int size()
        {
            return map().size();
        }

        Values(Map map1)
        {
            map = (Map)Preconditions.checkNotNull(map1);
        }
    }


    static final org.roboguice.shaded.goole.common.base.Joiner.MapJoiner STANDARD_JOINER;

    static Function asEntryToEntryFunction(EntryTransformer entrytransformer)
    {
        Preconditions.checkNotNull(entrytransformer);
        return new Function(entrytransformer) {

            final EntryTransformer val$transformer;

            public volatile Object apply(Object obj)
            {
                return apply((java.util.Map.Entry)obj);
            }

            public java.util.Map.Entry apply(java.util.Map.Entry entry)
            {
                return Maps.transformEntry(transformer, entry);
            }

            
            {
                transformer = entrytransformer;
                super();
            }
        };
    }

    static EntryTransformer asEntryTransformer(Function function)
    {
        Preconditions.checkNotNull(function);
        return new EntryTransformer(function) {

            final Function val$function;

            public Object transformEntry(Object obj, Object obj1)
            {
                return function.apply(obj1);
            }

            
            {
                function = function1;
                super();
            }
        };
    }

    static int capacity(int i)
    {
        if (i < 3)
        {
            CollectPreconditions.checkNonnegative(i, "expectedSize");
            return i + 1;
        }
        if (i < 0x40000000)
        {
            return i / 3 + i;
        } else
        {
            return 0x7fffffff;
        }
    }

    static boolean equalsImpl(Map map, Object obj)
    {
        if (map == obj)
        {
            return true;
        }
        if (obj instanceof Map)
        {
            obj = (Map)obj;
            return map.entrySet().equals(((Map) (obj)).entrySet());
        } else
        {
            return false;
        }
    }

    public static java.util.Map.Entry immutableEntry(Object obj, Object obj1)
    {
        return new ImmutableEntry(obj, obj1);
    }

    static Function keyFunction()
    {
        return EntryFunction.KEY;
    }

    static Iterator keyIterator(Iterator iterator)
    {
        return Iterators.transform(iterator, keyFunction());
    }

    static Object keyOrNull(java.util.Map.Entry entry)
    {
        if (entry == null)
        {
            return null;
        } else
        {
            return entry.getKey();
        }
    }

    public static HashMap newHashMap()
    {
        return new HashMap();
    }

    public static IdentityHashMap newIdentityHashMap()
    {
        return new IdentityHashMap();
    }

    public static LinkedHashMap newLinkedHashMap()
    {
        return new LinkedHashMap();
    }

    static boolean safeContainsKey(Map map, Object obj)
    {
        Preconditions.checkNotNull(map);
        boolean flag;
        try
        {
            flag = map.containsKey(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return false;
        }
        return flag;
    }

    static Object safeGet(Map map, Object obj)
    {
        Preconditions.checkNotNull(map);
        try
        {
            map = ((Map) (map.get(obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return null;
        }
        return map;
    }

    static Object safeRemove(Map map, Object obj)
    {
        Preconditions.checkNotNull(map);
        try
        {
            map = ((Map) (map.remove(obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return null;
        }
        return map;
    }

    static String toStringImpl(Map map)
    {
        StringBuilder stringbuilder = Collections2.newStringBuilderForCollection(map.size()).append('{');
        STANDARD_JOINER.appendTo(stringbuilder, map);
        return stringbuilder.append('}').toString();
    }

    public static Map transformEntries(Map map, EntryTransformer entrytransformer)
    {
        if (map instanceof SortedMap)
        {
            return transformEntries((SortedMap)map, entrytransformer);
        } else
        {
            return new TransformedEntriesMap(map, entrytransformer);
        }
    }

    public static NavigableMap transformEntries(NavigableMap navigablemap, EntryTransformer entrytransformer)
    {
        return new TransformedEntriesNavigableMap(navigablemap, entrytransformer);
    }

    public static SortedMap transformEntries(SortedMap sortedmap, EntryTransformer entrytransformer)
    {
        return Platform.mapsTransformEntriesSortedMap(sortedmap, entrytransformer);
    }

    static SortedMap transformEntriesIgnoreNavigable(SortedMap sortedmap, EntryTransformer entrytransformer)
    {
        return new TransformedEntriesSortedMap(sortedmap, entrytransformer);
    }

    static java.util.Map.Entry transformEntry(EntryTransformer entrytransformer, java.util.Map.Entry entry)
    {
        Preconditions.checkNotNull(entrytransformer);
        Preconditions.checkNotNull(entry);
        return new AbstractMapEntry(entry, entrytransformer) {

            final java.util.Map.Entry val$entry;
            final EntryTransformer val$transformer;

            public Object getKey()
            {
                return entry.getKey();
            }

            public Object getValue()
            {
                return transformer.transformEntry(entry.getKey(), entry.getValue());
            }

            
            {
                entry = entry1;
                transformer = entrytransformer;
                super();
            }
        };
    }

    public static Map transformValues(Map map, Function function)
    {
        return transformEntries(map, asEntryTransformer(function));
    }

    static Function valueFunction()
    {
        return EntryFunction.VALUE;
    }

    static Iterator valueIterator(Iterator iterator)
    {
        return Iterators.transform(iterator, valueFunction());
    }

    static UnmodifiableIterator valueIterator(UnmodifiableIterator unmodifiableiterator)
    {
        return new UnmodifiableIterator(unmodifiableiterator) {

            final UnmodifiableIterator val$entryIterator;

            public boolean hasNext()
            {
                return entryIterator.hasNext();
            }

            public Object next()
            {
                return ((java.util.Map.Entry)entryIterator.next()).getValue();
            }

            
            {
                entryIterator = unmodifiableiterator;
                super();
            }
        };
    }

    static 
    {
        STANDARD_JOINER = Collections2.STANDARD_JOINER.withKeyValueSeparator("=");
    }
}
