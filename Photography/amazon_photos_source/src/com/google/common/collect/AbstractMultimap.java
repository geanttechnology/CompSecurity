// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
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

// Referenced classes of package com.google.common.collect:
//            Multimap, Iterators, Maps, Collections2, 
//            Sets

abstract class AbstractMultimap
    implements Multimap, Serializable
{
    private class AsMap extends AbstractMap
    {

        transient Set entrySet;
        final transient Map submap;
        final AbstractMultimap this$0;

        public void clear()
        {
            if (submap == map)
            {
                AbstractMultimap.this.clear();
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

        public Set entrySet()
        {
            Set set = entrySet;
            Object obj = set;
            if (set == null)
            {
                obj = new AsMapEntries();
                entrySet = ((Set) (obj));
            }
            return ((Set) (obj));
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
            return AbstractMultimap.this.keySet();
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
                obj = ((remove) (this)).remove - obj;
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

        AsMap(Map map1)
        {
            this$0 = AbstractMultimap.this;
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
            Object obj = entry.getKey();
            collection = (Collection)entry.getValue();
            return Maps.immutableEntry(obj, wrapCollection(obj, collection));
        }

        public void remove()
        {
            delegateIterator.remove();
            <returnValue> = ((Collection) (this)).size - <returnValue>;
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

        final AbstractMultimap this$0;

        RandomAccessWrappedList(Object obj, List list, WrappedCollection wrappedcollection)
        {
            this$0 = AbstractMultimap.this;
            super(obj, list, wrappedcollection);
        }
    }

    private class SortedAsMap extends AsMap
        implements SortedMap
    {

        SortedSet sortedKeySet;
        final AbstractMultimap this$0;

        public Comparator comparator()
        {
            return sortedMap().comparator();
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
            SortedSet sortedset = sortedKeySet;
            Object obj = sortedset;
            if (sortedset == null)
            {
                obj = new SortedKeySet(sortedMap());
                sortedKeySet = ((SortedSet) (obj));
            }
            return ((SortedSet) (obj));
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
            this$0 = AbstractMultimap.this;
            super(sortedmap);
        }
    }

    private class SortedKeySet extends KeySet
        implements SortedSet
    {

        final AbstractMultimap this$0;

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
            return (SortedMap)subMap;
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
            this$0 = AbstractMultimap.this;
            super(sortedmap);
        }
    }

    private class WrappedCollection extends AbstractCollection
    {

        final WrappedCollection ancestor;
        final Collection ancestorDelegate;
        Collection _flddelegate;
        final Object key;
        final AbstractMultimap this$0;

        public boolean add(Object obj)
        {
            refreshIfEmpty();
            boolean flag = _flddelegate.isEmpty();
            boolean flag1 = _flddelegate.add(obj);
            if (flag1)
            {
                int i = ((Collection) (this)).clear;
                if (flag)
                {
                    addToMap();
                }
            }
            return flag1;
        }

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
                    collection = ((Collection) (this)).clear + collection;
                    flag = flag1;
                    if (i == 0)
                    {
                        addToMap();
                        return flag1;
                    }
                }
            }
            return flag;
        }

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
                i = ((Collection) (this)).clear - i;
                removeIfEmpty();
                return;
            }
        }

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
                int i = ((Collection) (this)).clear;
                removeIfEmpty();
            }
            return flag;
        }

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
                    collection = ((Collection) (this)).clear + collection;
                    removeIfEmpty();
                    return flag1;
                }
            }
            return flag;
        }

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
                collection = ((Collection) (this)).clear + collection;
                removeIfEmpty();
            }
            return flag;
        }

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
            this$0 = AbstractMultimap.this;
            super();
            key = obj;
            _flddelegate = collection;
            ancestor = wrappedcollection;
            if (wrappedcollection == null)
            {
                abstractmultimap = null;
            } else
            {
                abstractmultimap = wrappedcollection.getDelegate();
            }
            ancestorDelegate = AbstractMultimap.this;
        }
    }

    private class WrappedList extends WrappedCollection
        implements List
    {

        final AbstractMultimap this$0;

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
            AbstractMultimap abstractmultimap = AbstractMultimap.this;
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
            return abstractmultimap.wrapList(obj1, list, ((WrappedCollection) (obj)));
        }

        WrappedList(Object obj, List list, WrappedCollection wrappedcollection)
        {
            this$0 = AbstractMultimap.this;
            super(obj, list, wrappedcollection);
        }
    }

    private class WrappedSortedSet extends WrappedCollection
        implements SortedSet
    {

        final AbstractMultimap this$0;

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
            AbstractMultimap abstractmultimap = AbstractMultimap.this;
            Object obj1 = getKey();
            SortedSet sortedset = getSortedSetDelegate().headSet(obj);
            if (getAncestor() == null)
            {
                obj = this;
            } else
            {
                obj = getAncestor();
            }
            return abstractmultimap. new WrappedSortedSet(obj1, sortedset, ((WrappedCollection) (obj)));
        }

        public Object last()
        {
            refreshIfEmpty();
            return getSortedSetDelegate().last();
        }

        public SortedSet subSet(Object obj, Object obj1)
        {
            refreshIfEmpty();
            AbstractMultimap abstractmultimap = AbstractMultimap.this;
            Object obj2 = getKey();
            obj1 = getSortedSetDelegate().subSet(obj, obj1);
            if (getAncestor() == null)
            {
                obj = this;
            } else
            {
                obj = getAncestor();
            }
            return abstractmultimap. new WrappedSortedSet(obj2, ((SortedSet) (obj1)), ((WrappedCollection) (obj)));
        }

        public SortedSet tailSet(Object obj)
        {
            refreshIfEmpty();
            AbstractMultimap abstractmultimap = AbstractMultimap.this;
            Object obj1 = getKey();
            SortedSet sortedset = getSortedSetDelegate().tailSet(obj);
            if (getAncestor() == null)
            {
                obj = this;
            } else
            {
                obj = getAncestor();
            }
            return abstractmultimap. new WrappedSortedSet(obj1, sortedset, ((WrappedCollection) (obj)));
        }

        WrappedSortedSet(Object obj, SortedSet sortedset, WrappedCollection wrappedcollection)
        {
            this$0 = AbstractMultimap.this;
            super(obj, sortedset, wrappedcollection);
        }
    }


    private transient Map asMap;
    private transient Set keySet;
    private transient Map map;
    private transient int totalSize;

    protected AbstractMultimap(Map map1)
    {
        Preconditions.checkArgument(map1.isEmpty());
        map = map1;
    }

    private Map createAsMap()
    {
        if (map instanceof SortedMap)
        {
            return new SortedAsMap((SortedMap)map);
        } else
        {
            return new AsMap(map);
        }
    }

    private Set createKeySet()
    {
        if (map instanceof SortedMap)
        {
            return new SortedKeySet((SortedMap)map);
        } else
        {
            return new KeySet(map);
        }
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
        int i;
        try
        {
            obj = (Collection)map.remove(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return 0;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return 0;
        }
        i = 0;
        if (obj != null)
        {
            i = ((Collection) (obj)).size();
            ((Collection) (obj)).clear();
            totalSize = totalSize - i;
        }
        return i;
    }

    private Collection wrapCollection(Object obj, Collection collection)
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

    public Map asMap()
    {
        Map map2 = asMap;
        Map map1 = map2;
        if (map2 == null)
        {
            map1 = createAsMap();
            asMap = map1;
        }
        return map1;
    }

    public void clear()
    {
        for (Iterator iterator = map.values().iterator(); iterator.hasNext(); ((Collection)iterator.next()).clear()) { }
        map.clear();
        totalSize = 0;
    }

    public boolean containsKey(Object obj)
    {
        return map.containsKey(obj);
    }

    abstract Collection createCollection();

    Collection createCollection(Object obj)
    {
        return createCollection();
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof Multimap)
        {
            obj = (Multimap)obj;
            return map.equals(((Multimap) (obj)).asMap());
        } else
        {
            return false;
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

    public int hashCode()
    {
        return map.hashCode();
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

    public String toString()
    {
        return map.toString();
    }




/*
    static int access$208(AbstractMultimap abstractmultimap)
    {
        int i = abstractmultimap.totalSize;
        abstractmultimap.totalSize = i + 1;
        return i;
    }

*/


/*
    static int access$210(AbstractMultimap abstractmultimap)
    {
        int i = abstractmultimap.totalSize;
        abstractmultimap.totalSize = i - 1;
        return i;
    }

*/


/*
    static int access$212(AbstractMultimap abstractmultimap, int i)
    {
        i = abstractmultimap.totalSize + i;
        abstractmultimap.totalSize = i;
        return i;
    }

*/


/*
    static int access$220(AbstractMultimap abstractmultimap, int i)
    {
        i = abstractmultimap.totalSize - i;
        abstractmultimap.totalSize = i;
        return i;
    }

*/



}
