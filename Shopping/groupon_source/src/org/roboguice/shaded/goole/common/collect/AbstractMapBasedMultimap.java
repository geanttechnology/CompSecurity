// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            AbstractMultimap, Maps, Iterators, Collections2, 
//            CollectPreconditions, Sets

abstract class AbstractMapBasedMultimap extends AbstractMultimap
    implements Serializable
{
    private class AsMap extends Maps.ImprovedAbstractMap
    {

        final transient Map submap;
        final AbstractMapBasedMultimap this$0;

        public void clear()
        {
            if (submap == map)
            {
                AbstractMapBasedMultimap.this.clear();
                return;
            } else
            {
                Iterators.clear(new AsMapIterator());
                return;
            }
        }

        public boolean containsKey(Object obj)
        {
            return Maps.safeContainsKey(submap, obj);
        }

        protected Set createEntrySet()
        {
            return new AsMapEntries();
        }

        public boolean equals(Object obj)
        {
            return this == obj || submap.equals(obj);
        }

        public volatile Object get(Object obj)
        {
            return get(obj);
        }

        public Collection get(Object obj)
        {
            Collection collection = (Collection)Maps.safeGet(submap, obj);
            if (collection == null)
            {
                return null;
            } else
            {
                return wrapCollection(obj, collection);
            }
        }

        public int hashCode()
        {
            return submap.hashCode();
        }

        public Set keySet()
        {
            return AbstractMapBasedMultimap.this.keySet();
        }

        public volatile Object remove(Object obj)
        {
            return remove(obj);
        }

        public Collection remove(Object obj)
        {
            obj = (Collection)submap.remove(obj);
            if (obj == null)
            {
                return null;
            } else
            {
                Collection collection = createCollection();
                collection.addAll(((Collection) (obj)));
                obj = ((keySet) (this)).keySet - obj;
                ((Collection) (obj)).clear();
                return collection;
            }
        }

        public int size()
        {
            return submap.size();
        }

        public String toString()
        {
            return submap.toString();
        }

        java.util.Map.Entry wrapEntry(java.util.Map.Entry entry)
        {
            Object obj = entry.getKey();
            return Maps.immutableEntry(obj, wrapCollection(obj, (Collection)entry.getValue()));
        }

        AsMap(Map map1)
        {
            this$0 = AbstractMapBasedMultimap.this;
            super();
            submap = map1;
        }
    }

    class AsMap.AsMapEntries extends Maps.EntrySet
    {

        final AsMap this$1;

        public boolean contains(Object obj)
        {
            return Collections2.safeContains(submap.entrySet(), obj);
        }

        public Iterator iterator()
        {
            return new AsMap.AsMapIterator();
        }

        Map map()
        {
            return AsMap.this;
        }

        public boolean remove(Object obj)
        {
            if (!contains(obj))
            {
                return false;
            } else
            {
                obj = (java.util.Map.Entry)obj;
                removeValuesForKey(((java.util.Map.Entry) (obj)).getKey());
                return true;
            }
        }

        AsMap.AsMapEntries()
        {
            this$1 = AsMap.this;
            super();
        }
    }

    class AsMap.AsMapIterator
        implements Iterator
    {

        Collection collection;
        final Iterator delegateIterator;
        final AsMap this$1;

        public boolean hasNext()
        {
            return delegateIterator.hasNext();
        }

        public volatile Object next()
        {
            return next();
        }

        public java.util.Map.Entry next()
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)delegateIterator.next();
            collection = (Collection)entry.getValue();
            return wrapEntry(entry);
        }

        public void remove()
        {
            delegateIterator.remove();
            <returnValue> = ((access._cls220) (this)).access$220 - <returnValue>;
            collection.clear();
        }

        AsMap.AsMapIterator()
        {
            this$1 = AsMap.this;
            super();
            delegateIterator = submap.entrySet().iterator();
        }
    }

    private class RandomAccessWrappedList extends WrappedList
        implements RandomAccess
    {

        final AbstractMapBasedMultimap this$0;

        RandomAccessWrappedList(Object obj, List list, WrappedCollection wrappedcollection)
        {
            this$0 = AbstractMapBasedMultimap.this;
            super(obj, list, wrappedcollection);
        }
    }

    private class SortedAsMap extends AsMap
        implements SortedMap
    {

        SortedSet sortedKeySet;
        final AbstractMapBasedMultimap this$0;

        public Comparator comparator()
        {
            return sortedMap().comparator();
        }

        volatile Set createKeySet()
        {
            return createKeySet();
        }

        SortedSet createKeySet()
        {
            return new SortedKeySet(sortedMap());
        }

        public Object firstKey()
        {
            return sortedMap().firstKey();
        }

        public SortedMap headMap(Object obj)
        {
            return new SortedAsMap(sortedMap().headMap(obj));
        }

        public volatile Set keySet()
        {
            return keySet();
        }

        public SortedSet keySet()
        {
            SortedSet sortedset1 = sortedKeySet;
            SortedSet sortedset = sortedset1;
            if (sortedset1 == null)
            {
                sortedset = createKeySet();
                sortedKeySet = sortedset;
            }
            return sortedset;
        }

        public Object lastKey()
        {
            return sortedMap().lastKey();
        }

        SortedMap sortedMap()
        {
            return (SortedMap)submap;
        }

        public SortedMap subMap(Object obj, Object obj1)
        {
            return new SortedAsMap(sortedMap().subMap(obj, obj1));
        }

        public SortedMap tailMap(Object obj)
        {
            return new SortedAsMap(sortedMap().tailMap(obj));
        }

        SortedAsMap(SortedMap sortedmap)
        {
            this$0 = AbstractMapBasedMultimap.this;
            super(sortedmap);
        }
    }

    private class SortedKeySet extends KeySet
        implements SortedSet
    {

        final AbstractMapBasedMultimap this$0;

        public Comparator comparator()
        {
            return sortedMap().comparator();
        }

        public Object first()
        {
            return sortedMap().firstKey();
        }

        public SortedSet headSet(Object obj)
        {
            return new SortedKeySet(sortedMap().headMap(obj));
        }

        public Object last()
        {
            return sortedMap().lastKey();
        }

        SortedMap sortedMap()
        {
            return (SortedMap)map();
        }

        public SortedSet subSet(Object obj, Object obj1)
        {
            return new SortedKeySet(sortedMap().subMap(obj, obj1));
        }

        public SortedSet tailSet(Object obj)
        {
            return new SortedKeySet(sortedMap().tailMap(obj));
        }

        SortedKeySet(SortedMap sortedmap)
        {
            this$0 = AbstractMapBasedMultimap.this;
            super(sortedmap);
        }
    }

    private class WrappedCollection extends AbstractCollection
    {

        final WrappedCollection ancestor;
        final Collection ancestorDelegate;
        Collection _flddelegate;
        final Object key;
        final AbstractMapBasedMultimap this$0;

        public boolean add(Object obj)
        {
            refreshIfEmpty();
            boolean flag = _flddelegate.isEmpty();
            boolean flag1 = _flddelegate.add(obj);
            if (flag1)
            {
                int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        public boolean addAll(Collection collection)
        {
            boolean flag;
            if (collection.isEmpty())
            {
                flag = false;
            } else
            {
                int i = size();
                boolean flag1 = _flddelegate.addAll(collection);
                flag = flag1;
                if (flag1)
                {
                    int j = _flddelegate.size();
                    collection = 
// JavaClassFileOutputException: get_constant: invalid tag

        void addToMap()
        {
            if (ancestor != null)
            {
                ancestor.addToMap();
                return;
            } else
            {
                map.put(key, _flddelegate);
                return;
            }
        }

        public void clear()
        {
            int i = size();
            if (i == 0)
            {
                return;
            } else
            {
                _flddelegate.clear();
                i = 
// JavaClassFileOutputException: get_constant: invalid tag

        public boolean contains(Object obj)
        {
            refreshIfEmpty();
            return _flddelegate.contains(obj);
        }

        public boolean containsAll(Collection collection)
        {
            refreshIfEmpty();
            return _flddelegate.containsAll(collection);
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            } else
            {
                refreshIfEmpty();
                return _flddelegate.equals(obj);
            }
        }

        WrappedCollection getAncestor()
        {
            return ancestor;
        }

        Collection getDelegate()
        {
            return _flddelegate;
        }

        Object getKey()
        {
            return key;
        }

        public int hashCode()
        {
            refreshIfEmpty();
            return _flddelegate.hashCode();
        }

        public Iterator iterator()
        {
            refreshIfEmpty();
            return new WrappedIterator();
        }

        void refreshIfEmpty()
        {
            if (ancestor != null)
            {
                ancestor.refreshIfEmpty();
                if (ancestor.getDelegate() != ancestorDelegate)
                {
                    throw new ConcurrentModificationException();
                }
            } else
            if (_flddelegate.isEmpty())
            {
                Collection collection = (Collection)map.get(key);
                if (collection != null)
                {
                    _flddelegate = collection;
                }
            }
        }

        public boolean remove(Object obj)
        {
            refreshIfEmpty();
            boolean flag = _flddelegate.remove(obj);
            if (flag)
            {
                int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        public boolean removeAll(Collection collection)
        {
            boolean flag;
            if (collection.isEmpty())
            {
                flag = false;
            } else
            {
                int i = size();
                boolean flag1 = _flddelegate.removeAll(collection);
                flag = flag1;
                if (flag1)
                {
                    int j = _flddelegate.size();
                    collection = 
// JavaClassFileOutputException: get_constant: invalid tag

        void removeIfEmpty()
        {
            if (ancestor != null)
            {
                ancestor.removeIfEmpty();
            } else
            if (_flddelegate.isEmpty())
            {
                map.remove(key);
                return;
            }
        }

        public boolean retainAll(Collection collection)
        {
            Preconditions.checkNotNull(collection);
            int i = size();
            boolean flag = _flddelegate.retainAll(collection);
            if (flag)
            {
                int j = _flddelegate.size();
                collection = 
// JavaClassFileOutputException: get_constant: invalid tag

        public int size()
        {
            refreshIfEmpty();
            return _flddelegate.size();
        }

        public String toString()
        {
            refreshIfEmpty();
            return _flddelegate.toString();
        }

        WrappedCollection(Object obj, Collection collection, WrappedCollection wrappedcollection)
        {
            this$0 = AbstractMapBasedMultimap.this;
            super();
            key = obj;
            _flddelegate = collection;
            ancestor = wrappedcollection;
            if (wrappedcollection == null)
            {
                abstractmapbasedmultimap = null;
            } else
            {
                abstractmapbasedmultimap = wrappedcollection.getDelegate();
            }
            ancestorDelegate = AbstractMapBasedMultimap.this;
        }
    }

    private class WrappedList extends WrappedCollection
        implements List
    {

        final AbstractMapBasedMultimap this$0;

        public void add(int i, Object obj)
        {
            refreshIfEmpty();
            boolean flag = getDelegate().isEmpty();
            getListDelegate().add(i, obj);
            int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        public boolean addAll(int i, Collection collection)
        {
            boolean flag;
            if (collection.isEmpty())
            {
                flag = false;
            } else
            {
                int j = size();
                boolean flag1 = getListDelegate().addAll(i, collection);
                flag = flag1;
                if (flag1)
                {
                    i = getDelegate().size();
                    i = 
// JavaClassFileOutputException: get_constant: invalid tag

        public Object get(int i)
        {
            refreshIfEmpty();
            return getListDelegate().get(i);
        }

        List getListDelegate()
        {
            return (List)getDelegate();
        }

        public int indexOf(Object obj)
        {
            refreshIfEmpty();
            return getListDelegate().indexOf(obj);
        }

        public int lastIndexOf(Object obj)
        {
            refreshIfEmpty();
            return getListDelegate().lastIndexOf(obj);
        }

        public ListIterator listIterator()
        {
            refreshIfEmpty();
            return new WrappedListIterator();
        }

        public ListIterator listIterator(int i)
        {
            refreshIfEmpty();
            return new WrappedListIterator(i);
        }

        public Object remove(int i)
        {
            refreshIfEmpty();
            Object obj = getListDelegate().remove(i);
            int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        public Object set(int i, Object obj)
        {
            refreshIfEmpty();
            return getListDelegate().set(i, obj);
        }

        public List subList(int i, int j)
        {
            refreshIfEmpty();
            AbstractMapBasedMultimap abstractmapbasedmultimap = AbstractMapBasedMultimap.this;
            Object obj1 = getKey();
            List list = getListDelegate().subList(i, j);
            Object obj;
            if (getAncestor() == null)
            {
                obj = this;
            } else
            {
                obj = getAncestor();
            }
            return abstractmapbasedmultimap.wrapList(obj1, list, ((WrappedCollection) (obj)));
        }

        WrappedList(Object obj, List list, WrappedCollection wrappedcollection)
        {
            this$0 = AbstractMapBasedMultimap.this;
            super(obj, list, wrappedcollection);
        }
    }

    private class WrappedList.WrappedListIterator extends WrappedCollection.WrappedIterator
        implements ListIterator
    {

        final WrappedList this$1;

        private ListIterator getDelegateListIterator()
        {
            return (ListIterator)getDelegateIterator();
        }

        public void add(Object obj)
        {
            boolean flag = isEmpty();
            getDelegateListIterator().add(obj);
            int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        public boolean hasPrevious()
        {
            return getDelegateListIterator().hasPrevious();
        }

        public int nextIndex()
        {
            return getDelegateListIterator().nextIndex();
        }

        public Object previous()
        {
            return getDelegateListIterator().previous();
        }

        public int previousIndex()
        {
            return getDelegateListIterator().previousIndex();
        }

        public void set(Object obj)
        {
            getDelegateListIterator().set(obj);
        }

        WrappedList.WrappedListIterator()
        {
            this$1 = WrappedList.this;
            super();
        }

        public WrappedList.WrappedListIterator(int i)
        {
            this$1 = WrappedList.this;
            super(getListDelegate().listIterator(i));
        }
    }

    private class WrappedSortedSet extends WrappedCollection
        implements SortedSet
    {

        final AbstractMapBasedMultimap this$0;

        public Comparator comparator()
        {
            return getSortedSetDelegate().comparator();
        }

        public Object first()
        {
            refreshIfEmpty();
            return getSortedSetDelegate().first();
        }

        SortedSet getSortedSetDelegate()
        {
            return (SortedSet)getDelegate();
        }

        public SortedSet headSet(Object obj)
        {
            refreshIfEmpty();
            AbstractMapBasedMultimap abstractmapbasedmultimap = AbstractMapBasedMultimap.this;
            Object obj1 = getKey();
            SortedSet sortedset = getSortedSetDelegate().headSet(obj);
            if (getAncestor() == null)
            {
                obj = this;
            } else
            {
                obj = getAncestor();
            }
            return abstractmapbasedmultimap. new WrappedSortedSet(obj1, sortedset, ((WrappedCollection) (obj)));
        }

        public Object last()
        {
            refreshIfEmpty();
            return getSortedSetDelegate().last();
        }

        public SortedSet subSet(Object obj, Object obj1)
        {
            refreshIfEmpty();
            AbstractMapBasedMultimap abstractmapbasedmultimap = AbstractMapBasedMultimap.this;
            Object obj2 = getKey();
            obj1 = getSortedSetDelegate().subSet(obj, obj1);
            if (getAncestor() == null)
            {
                obj = this;
            } else
            {
                obj = getAncestor();
            }
            return abstractmapbasedmultimap. new WrappedSortedSet(obj2, ((SortedSet) (obj1)), ((WrappedCollection) (obj)));
        }

        public SortedSet tailSet(Object obj)
        {
            refreshIfEmpty();
            AbstractMapBasedMultimap abstractmapbasedmultimap = AbstractMapBasedMultimap.this;
            Object obj1 = getKey();
            SortedSet sortedset = getSortedSetDelegate().tailSet(obj);
            if (getAncestor() == null)
            {
                obj = this;
            } else
            {
                obj = getAncestor();
            }
            return abstractmapbasedmultimap. new WrappedSortedSet(obj1, sortedset, ((WrappedCollection) (obj)));
        }

        WrappedSortedSet(Object obj, SortedSet sortedset, WrappedCollection wrappedcollection)
        {
            this$0 = AbstractMapBasedMultimap.this;
            super(obj, sortedset, wrappedcollection);
        }
    }


    private transient Map map;
    private transient int totalSize;

    protected AbstractMapBasedMultimap(Map map1)
    {
        Preconditions.checkArgument(map1.isEmpty());
        map = map1;
    }

    private Iterator iteratorOrListIterator(Collection collection)
    {
        if (collection instanceof List)
        {
            return ((List)collection).listIterator();
        } else
        {
            return collection.iterator();
        }
    }

    private int removeValuesForKey(Object obj)
    {
        obj = (Collection)Maps.safeRemove(map, obj);
        int i = 0;
        if (obj != null)
        {
            i = ((Collection) (obj)).size();
            ((Collection) (obj)).clear();
            totalSize = totalSize - i;
        }
        return i;
    }

    private List wrapList(Object obj, List list, WrappedCollection wrappedcollection)
    {
        if (list instanceof RandomAccess)
        {
            return new RandomAccessWrappedList(obj, list, wrappedcollection);
        } else
        {
            return new WrappedList(obj, list, wrappedcollection);
        }
    }

    public void clear()
    {
        for (Iterator iterator = map.values().iterator(); iterator.hasNext(); ((Collection)iterator.next()).clear()) { }
        map.clear();
        totalSize = 0;
    }

    Map createAsMap()
    {
        if (map instanceof SortedMap)
        {
            return new SortedAsMap((SortedMap)map);
        } else
        {
            return new AsMap(map);
        }
    }

    abstract Collection createCollection();

    Collection createCollection(Object obj)
    {
        return createCollection();
    }

    Set createKeySet()
    {
        if (map instanceof SortedMap)
        {
            return new SortedKeySet((SortedMap)map);
        } else
        {
            return new KeySet(map);
        }
    }

    public Collection get(Object obj)
    {
        Collection collection1 = (Collection)map.get(obj);
        Collection collection = collection1;
        if (collection1 == null)
        {
            collection = createCollection(obj);
        }
        return wrapCollection(obj, collection);
    }

    public boolean put(Object obj, Object obj1)
    {
        Collection collection = (Collection)map.get(obj);
        if (collection == null)
        {
            collection = createCollection(obj);
            if (collection.add(obj1))
            {
                totalSize = totalSize + 1;
                map.put(obj, collection);
                return true;
            } else
            {
                throw new AssertionError("New Collection violated the Collection spec");
            }
        }
        if (collection.add(obj1))
        {
            totalSize = totalSize + 1;
            return true;
        } else
        {
            return false;
        }
    }

    Collection wrapCollection(Object obj, Collection collection)
    {
        if (collection instanceof SortedSet)
        {
            return new WrappedSortedSet(obj, (SortedSet)collection, null);
        }
        if (collection instanceof Set)
        {
            return new WrappedSet(obj, (Set)collection);
        }
        if (collection instanceof List)
        {
            return wrapList(obj, (List)collection, null);
        } else
        {
            return new WrappedCollection(obj, collection, null);
        }
    }




/*
    static int access$208(AbstractMapBasedMultimap abstractmapbasedmultimap)
    {
        int i = abstractmapbasedmultimap.totalSize;
        abstractmapbasedmultimap.totalSize = i + 1;
        return i;
    }

*/


/*
    static int access$210(AbstractMapBasedMultimap abstractmapbasedmultimap)
    {
        int i = abstractmapbasedmultimap.totalSize;
        abstractmapbasedmultimap.totalSize = i - 1;
        return i;
    }

*/


/*
    static int access$212(AbstractMapBasedMultimap abstractmapbasedmultimap, int i)
    {
        i = abstractmapbasedmultimap.totalSize + i;
        abstractmapbasedmultimap.totalSize = i;
        return i;
    }

*/


/*
    static int access$220(AbstractMapBasedMultimap abstractmapbasedmultimap, int i)
    {
        i = abstractmapbasedmultimap.totalSize - i;
        abstractmapbasedmultimap.totalSize = i;
        return i;
    }

*/


}
