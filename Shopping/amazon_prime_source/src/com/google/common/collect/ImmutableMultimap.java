// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            AbstractMultimap, ImmutableListMultimap, ImmutableCollection, ImmutableMap, 
//            Multimap, UnmodifiableIterator, ImmutableSet, Lists, 
//            Ordering, CollectPreconditions, AbstractMapBasedMultimap, Iterators, 
//            Maps

public abstract class ImmutableMultimap extends AbstractMultimap
    implements Serializable
{
    public static class Builder
    {

        Multimap builderMultimap;
        Comparator keyComparator;
        Comparator valueComparator;

        public ImmutableMultimap build()
        {
            if (valueComparator != null)
            {
                for (Iterator iterator = builderMultimap.asMap().values().iterator(); iterator.hasNext(); Collections.sort((List)(Collection)iterator.next(), valueComparator)) { }
            }
            if (keyComparator != null)
            {
                BuilderMultimap buildermultimap = new BuilderMultimap();
                Object obj = Lists.newArrayList(builderMultimap.asMap().entrySet());
                Collections.sort(((List) (obj)), Ordering.from(keyComparator).onKeys());
                java.util.Map.Entry entry;
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); buildermultimap.putAll(entry.getKey(), (Iterable)entry.getValue()))
                {
                    entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                }

                builderMultimap = buildermultimap;
            }
            return ImmutableMultimap.copyOf(builderMultimap);
        }

        public Builder put(Object obj, Object obj1)
        {
            CollectPreconditions.checkEntryNotNull(obj, obj1);
            builderMultimap.put(obj, obj1);
            return this;
        }

        public Builder()
        {
            builderMultimap = new BuilderMultimap();
        }
    }

    private static class BuilderMultimap extends AbstractMapBasedMultimap
    {

        Collection createCollection()
        {
            return Lists.newArrayList();
        }

        BuilderMultimap()
        {
            super(new LinkedHashMap());
        }
    }

    private static class EntryCollection extends ImmutableCollection
    {

        final ImmutableMultimap multimap;

        public boolean contains(Object obj)
        {
            if (obj instanceof java.util.Map.Entry)
            {
                obj = (java.util.Map.Entry)obj;
                return multimap.containsEntry(((java.util.Map.Entry) (obj)).getKey(), ((java.util.Map.Entry) (obj)).getValue());
            } else
            {
                return false;
            }
        }

        boolean isPartialView()
        {
            return multimap.isPartialView();
        }

        public UnmodifiableIterator iterator()
        {
            return multimap.entryIterator();
        }

        public volatile Iterator iterator()
        {
            return iterator();
        }

        public int size()
        {
            return multimap.size();
        }

        EntryCollection(ImmutableMultimap immutablemultimap)
        {
            multimap = immutablemultimap;
        }
    }

    private abstract class Itr extends UnmodifiableIterator
    {

        Object key;
        final Iterator mapIterator;
        final ImmutableMultimap this$0;
        Iterator valueIterator;

        public boolean hasNext()
        {
            return mapIterator.hasNext() || valueIterator.hasNext();
        }

        public Object next()
        {
            if (!valueIterator.hasNext())
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)mapIterator.next();
                key = entry.getKey();
                valueIterator = ((Collection)entry.getValue()).iterator();
            }
            return output(key, valueIterator.next());
        }

        abstract Object output(Object obj, Object obj1);

        private Itr()
        {
            this$0 = ImmutableMultimap.this;
            super();
            mapIterator = asMap().entrySet().iterator();
            key = null;
            valueIterator = Iterators.emptyIterator();
        }

    }


    final transient ImmutableMap map;
    final transient int size;

    ImmutableMultimap(ImmutableMap immutablemap, int i)
    {
        map = immutablemap;
        size = i;
    }

    public static ImmutableMultimap copyOf(Multimap multimap)
    {
        if (multimap instanceof ImmutableMultimap)
        {
            ImmutableMultimap immutablemultimap = (ImmutableMultimap)multimap;
            if (!immutablemultimap.isPartialView())
            {
                return immutablemultimap;
            }
        }
        return ImmutableListMultimap.copyOf(multimap);
    }

    public ImmutableMap asMap()
    {
        return map;
    }

    public volatile Map asMap()
    {
        return asMap();
    }

    public void clear()
    {
        throw new UnsupportedOperationException();
    }

    public volatile boolean containsEntry(Object obj, Object obj1)
    {
        return super.containsEntry(obj, obj1);
    }

    Map createAsMap()
    {
        throw new AssertionError("should never be called");
    }

    ImmutableCollection createEntries()
    {
        return new EntryCollection(this);
    }

    volatile Collection createEntries()
    {
        return createEntries();
    }

    public ImmutableCollection entries()
    {
        return (ImmutableCollection)super.entries();
    }

    public volatile Collection entries()
    {
        return entries();
    }

    UnmodifiableIterator entryIterator()
    {
        return new Itr() {

            final ImmutableMultimap this$0;

            volatile Object output(Object obj, Object obj1)
            {
                return output(obj, obj1);
            }

            java.util.Map.Entry output(Object obj, Object obj1)
            {
                return Maps.immutableEntry(obj, obj1);
            }

            
            {
                this$0 = ImmutableMultimap.this;
                super();
            }
        };
    }

    volatile Iterator entryIterator()
    {
        return entryIterator();
    }

    public volatile boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    public abstract ImmutableCollection get(Object obj);

    public volatile Collection get(Object obj)
    {
        return get(obj);
    }

    public volatile int hashCode()
    {
        return super.hashCode();
    }

    public volatile boolean isEmpty()
    {
        return super.isEmpty();
    }

    boolean isPartialView()
    {
        return map.isPartialView();
    }

    public ImmutableSet keySet()
    {
        return map.keySet();
    }

    public volatile Set keySet()
    {
        return keySet();
    }

    public boolean put(Object obj, Object obj1)
    {
        throw new UnsupportedOperationException();
    }

    public boolean putAll(Object obj, Iterable iterable)
    {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj, Object obj1)
    {
        throw new UnsupportedOperationException();
    }

    public int size()
    {
        return size;
    }

    public volatile String toString()
    {
        return super.toString();
    }
}
