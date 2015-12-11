// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            Multimap, Maps, ListMultimap, Lists, 
//            AbstractMultimap, Iterators, Collections2

public final class Multimaps
{
    static abstract class Entries extends AbstractCollection
    {

        public void clear()
        {
            multimap().clear();
        }

        public boolean contains(Object obj)
        {
            if (obj instanceof java.util.Map.Entry)
            {
                obj = (java.util.Map.Entry)obj;
                return multimap().containsEntry(((java.util.Map.Entry) (obj)).getKey(), ((java.util.Map.Entry) (obj)).getValue());
            } else
            {
                return false;
            }
        }

        abstract Multimap multimap();

        public boolean remove(Object obj)
        {
            if (obj instanceof java.util.Map.Entry)
            {
                obj = (java.util.Map.Entry)obj;
                return multimap().remove(((java.util.Map.Entry) (obj)).getKey(), ((java.util.Map.Entry) (obj)).getValue());
            } else
            {
                return false;
            }
        }

        public int size()
        {
            return multimap().size();
        }

        Entries()
        {
        }
    }

    private static final class TransformedEntriesListMultimap extends TransformedEntriesMultimap
        implements ListMultimap
    {

        public volatile Collection get(Object obj)
        {
            return get(obj);
        }

        public List get(Object obj)
        {
            return transform(obj, fromMultimap.get(obj));
        }

        volatile Collection transform(Object obj, Collection collection)
        {
            return transform(obj, collection);
        }

        List transform(Object obj, Collection collection)
        {
            return Lists.transform((List)collection, Maps.asValueToValueFunction(transformer, obj));
        }

        TransformedEntriesListMultimap(ListMultimap listmultimap, Maps.EntryTransformer entrytransformer)
        {
            super(listmultimap, entrytransformer);
        }
    }

    private static class TransformedEntriesMultimap extends AbstractMultimap
    {

        final Multimap fromMultimap;
        final Maps.EntryTransformer transformer;

        public void clear()
        {
            fromMultimap.clear();
        }

        Map createAsMap()
        {
            return Maps.transformEntries(fromMultimap.asMap(), new Maps.EntryTransformer() {

                final TransformedEntriesMultimap this$0;

                public volatile Object transformEntry(Object obj, Object obj1)
                {
                    return transformEntry(obj, (Collection)obj1);
                }

                public Collection transformEntry(Object obj, Collection collection)
                {
                    return transform(obj, collection);
                }

            
            {
                this$0 = TransformedEntriesMultimap.this;
                super();
            }
            });
        }

        Iterator entryIterator()
        {
            return Iterators.transform(fromMultimap.entries().iterator(), Maps.asEntryToEntryFunction(transformer));
        }

        public Collection get(Object obj)
        {
            return transform(obj, fromMultimap.get(obj));
        }

        public boolean isEmpty()
        {
            return fromMultimap.isEmpty();
        }

        public Set keySet()
        {
            return fromMultimap.keySet();
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
            return get(obj).remove(obj1);
        }

        public int size()
        {
            return fromMultimap.size();
        }

        Collection transform(Object obj, Collection collection)
        {
            obj = Maps.asValueToValueFunction(transformer, obj);
            if (collection instanceof List)
            {
                return Lists.transform((List)collection, ((Function) (obj)));
            } else
            {
                return Collections2.transform(collection, ((Function) (obj)));
            }
        }

        TransformedEntriesMultimap(Multimap multimap, Maps.EntryTransformer entrytransformer)
        {
            fromMultimap = (Multimap)Preconditions.checkNotNull(multimap);
            transformer = (Maps.EntryTransformer)Preconditions.checkNotNull(entrytransformer);
        }
    }


    private Multimaps()
    {
    }

    static boolean equalsImpl(Multimap multimap, Object obj)
    {
        if (obj == multimap)
        {
            return true;
        }
        if (obj instanceof Multimap)
        {
            obj = (Multimap)obj;
            return multimap.asMap().equals(((Multimap) (obj)).asMap());
        } else
        {
            return false;
        }
    }

    public static ListMultimap transformEntries(ListMultimap listmultimap, Maps.EntryTransformer entrytransformer)
    {
        return new TransformedEntriesListMultimap(listmultimap, entrytransformer);
    }

    public static ListMultimap transformValues(ListMultimap listmultimap, Function function)
    {
        Preconditions.checkNotNull(function);
        return transformEntries(listmultimap, Maps.asEntryTransformer(function));
    }
}
