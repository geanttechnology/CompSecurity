// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class SmallSortedMap extends AbstractMap
{
    private static class EmptySet
    {

        private static final Iterable ITERABLE = new Iterable() {

            public Iterator iterator()
            {
                return EmptySet.ITERATOR;
            }

        };
        private static final Iterator ITERATOR = new Iterator() {

            public boolean hasNext()
            {
                return false;
            }

            public Object next()
            {
                throw new NoSuchElementException();
            }

            public void remove()
            {
                throw new UnsupportedOperationException();
            }

        };

        static Iterable iterable()
        {
            return ITERABLE;
        }


    }

    private class Entry
        implements Comparable, java.util.Map.Entry
    {

        private final Comparable key;
        final SmallSortedMap this$0;
        private Object value;

        private boolean equals(Object obj, Object obj1)
        {
            if (obj == null)
            {
                return obj1 == null;
            } else
            {
                return obj.equals(obj1);
            }
        }

        public int compareTo(Entry entry)
        {
            return getKey().compareTo(entry.getKey());
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((Entry)obj);
        }

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (!(obj instanceof java.util.Map.Entry))
                {
                    return false;
                }
                obj = (java.util.Map.Entry)obj;
                if (!equals(key, ((java.util.Map.Entry) (obj)).getKey()) || !equals(value, ((java.util.Map.Entry) (obj)).getValue()))
                {
                    return false;
                }
            }
            return true;
        }

        public Comparable getKey()
        {
            return key;
        }

        public volatile Object getKey()
        {
            return getKey();
        }

        public Object getValue()
        {
            return value;
        }

        public int hashCode()
        {
            int j = 0;
            int i;
            if (key == null)
            {
                i = 0;
            } else
            {
                i = key.hashCode();
            }
            if (value != null)
            {
                j = value.hashCode();
            }
            return i ^ j;
        }

        public Object setValue(Object obj)
        {
            checkMutable();
            Object obj1 = value;
            value = obj;
            return obj1;
        }

        public String toString()
        {
            return (new StringBuilder()).append(key).append("=").append(value).toString();
        }

        Entry(Comparable comparable, Object obj)
        {
            this$0 = SmallSortedMap.this;
            super();
            key = comparable;
            value = obj;
        }

        Entry(java.util.Map.Entry entry)
        {
            this((Comparable)entry.getKey(), entry.getValue());
        }
    }

    private class EntryIterator
        implements Iterator
    {

        private Iterator lazyOverflowIterator;
        private boolean nextCalledBeforeRemove;
        private int pos;
        final SmallSortedMap this$0;

        private Iterator getOverflowIterator()
        {
            if (lazyOverflowIterator == null)
            {
                lazyOverflowIterator = overflowEntries.entrySet().iterator();
            }
            return lazyOverflowIterator;
        }

        public boolean hasNext()
        {
            return pos + 1 < entryList.size() || getOverflowIterator().hasNext();
        }

        public volatile Object next()
        {
            return next();
        }

        public java.util.Map.Entry next()
        {
            nextCalledBeforeRemove = true;
            int i = pos + 1;
            pos = i;
            if (i < entryList.size())
            {
                return (java.util.Map.Entry)entryList.get(pos);
            } else
            {
                return (java.util.Map.Entry)getOverflowIterator().next();
            }
        }

        public void remove()
        {
            if (!nextCalledBeforeRemove)
            {
                throw new IllegalStateException("remove() was called before next()");
            }
            nextCalledBeforeRemove = false;
            checkMutable();
            if (pos < entryList.size())
            {
                SmallSortedMap smallsortedmap = SmallSortedMap.this;
                int i = pos;
                pos = i - 1;
                smallsortedmap.removeArrayEntryAt(i);
                return;
            } else
            {
                getOverflowIterator().remove();
                return;
            }
        }

        private EntryIterator()
        {
            this$0 = SmallSortedMap.this;
            super();
            pos = -1;
        }

    }

    private class EntrySet extends AbstractSet
    {

        final SmallSortedMap this$0;

        public volatile boolean add(Object obj)
        {
            return add((java.util.Map.Entry)obj);
        }

        public boolean add(java.util.Map.Entry entry)
        {
            if (!contains(entry))
            {
                put((Comparable)entry.getKey(), entry.getValue());
                return true;
            } else
            {
                return false;
            }
        }

        public void clear()
        {
            SmallSortedMap.this.clear();
        }

        public boolean contains(Object obj)
        {
            Object obj1 = (java.util.Map.Entry)obj;
            obj = get(((java.util.Map.Entry) (obj1)).getKey());
            obj1 = ((java.util.Map.Entry) (obj1)).getValue();
            return obj == obj1 || obj != null && obj.equals(obj1);
        }

        public Iterator iterator()
        {
            return new EntryIterator();
        }

        public boolean remove(Object obj)
        {
            obj = (java.util.Map.Entry)obj;
            if (contains(obj))
            {
                SmallSortedMap.this.remove(((java.util.Map.Entry) (obj)).getKey());
                return true;
            } else
            {
                return false;
            }
        }

        public int size()
        {
            return SmallSortedMap.this.size();
        }

        private EntrySet()
        {
            this$0 = SmallSortedMap.this;
            super();
        }

    }


    private List entryList;
    private boolean isImmutable;
    private volatile EntrySet lazyEntrySet;
    private final int maxArraySize;
    private Map overflowEntries;

    private SmallSortedMap(int i)
    {
        maxArraySize = i;
        entryList = Collections.emptyList();
        overflowEntries = Collections.emptyMap();
    }


    private int binarySearchInArray(Comparable comparable)
    {
        boolean flag = false;
        int l = entryList.size() - 1;
        int i = l;
        int j = ((flag) ? 1 : 0);
        if (l >= 0)
        {
            int j1 = comparable.compareTo(((Entry)entryList.get(l)).getKey());
            if (j1 > 0)
            {
                return -(l + 2);
            }
            i = l;
            j = ((flag) ? 1 : 0);
            if (j1 == 0)
            {
                return l;
            }
        }
        while (j <= i) 
        {
            int k = (j + i) / 2;
            int i1 = comparable.compareTo(((Entry)entryList.get(k)).getKey());
            if (i1 < 0)
            {
                i = k - 1;
            } else
            if (i1 > 0)
            {
                j = k + 1;
            } else
            {
                return k;
            }
        }
        return -(j + 1);
    }

    private void checkMutable()
    {
        if (isImmutable)
        {
            throw new UnsupportedOperationException();
        } else
        {
            return;
        }
    }

    private void ensureEntryArrayMutable()
    {
        checkMutable();
        if (entryList.isEmpty() && !(entryList instanceof ArrayList))
        {
            entryList = new ArrayList(maxArraySize);
        }
    }

    private SortedMap getOverflowEntriesMutable()
    {
        checkMutable();
        if (overflowEntries.isEmpty() && !(overflowEntries instanceof TreeMap))
        {
            overflowEntries = new TreeMap();
        }
        return (SortedMap)overflowEntries;
    }

    static SmallSortedMap newFieldMap(int i)
    {
        return new SmallSortedMap(i) {

            public void makeImmutable()
            {
                if (!isImmutable())
                {
                    for (int j = 0; j < getNumArrayEntries(); j++)
                    {
                        java.util.Map.Entry entry = getArrayEntryAt(j);
                        if (((FieldSet.FieldDescriptorLite)entry.getKey()).isRepeated())
                        {
                            entry.setValue(Collections.unmodifiableList((List)entry.getValue()));
                        }
                    }

                    Iterator iterator = getOverflowEntries().iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator.next();
                        if (((FieldSet.FieldDescriptorLite)entry1.getKey()).isRepeated())
                        {
                            entry1.setValue(Collections.unmodifiableList((List)entry1.getValue()));
                        }
                    } while (true);
                }
                makeImmutable();
            }

            public volatile Object put(Object obj, Object obj1)
            {
                return put((FieldSet.FieldDescriptorLite)obj, obj1);
            }

        };
    }

    private Object removeArrayEntryAt(int i)
    {
        checkMutable();
        Object obj = ((Entry)entryList.remove(i)).getValue();
        if (!overflowEntries.isEmpty())
        {
            Iterator iterator = getOverflowEntriesMutable().entrySet().iterator();
            entryList.add(new Entry((java.util.Map.Entry)iterator.next()));
            iterator.remove();
        }
        return obj;
    }

    public void clear()
    {
        checkMutable();
        if (!entryList.isEmpty())
        {
            entryList.clear();
        }
        if (!overflowEntries.isEmpty())
        {
            overflowEntries.clear();
        }
    }

    public boolean containsKey(Object obj)
    {
        obj = (Comparable)obj;
        return binarySearchInArray(((Comparable) (obj))) >= 0 || overflowEntries.containsKey(obj);
    }

    public Set entrySet()
    {
        if (lazyEntrySet == null)
        {
            lazyEntrySet = new EntrySet();
        }
        return lazyEntrySet;
    }

    public Object get(Object obj)
    {
        obj = (Comparable)obj;
        int i = binarySearchInArray(((Comparable) (obj)));
        if (i >= 0)
        {
            return ((Entry)entryList.get(i)).getValue();
        } else
        {
            return overflowEntries.get(obj);
        }
    }

    public java.util.Map.Entry getArrayEntryAt(int i)
    {
        return (java.util.Map.Entry)entryList.get(i);
    }

    public int getNumArrayEntries()
    {
        return entryList.size();
    }

    public Iterable getOverflowEntries()
    {
        if (overflowEntries.isEmpty())
        {
            return EmptySet.iterable();
        } else
        {
            return overflowEntries.entrySet();
        }
    }

    public boolean isImmutable()
    {
        return isImmutable;
    }

    public void makeImmutable()
    {
        if (!isImmutable)
        {
            Map map;
            if (overflowEntries.isEmpty())
            {
                map = Collections.emptyMap();
            } else
            {
                map = Collections.unmodifiableMap(overflowEntries);
            }
            overflowEntries = map;
            isImmutable = true;
        }
    }

    public Object put(Comparable comparable, Object obj)
    {
        checkMutable();
        int i = binarySearchInArray(comparable);
        if (i >= 0)
        {
            return ((Entry)entryList.get(i)).setValue(obj);
        }
        ensureEntryArrayMutable();
        i = -(i + 1);
        if (i >= maxArraySize)
        {
            return getOverflowEntriesMutable().put(comparable, obj);
        }
        if (entryList.size() == maxArraySize)
        {
            Entry entry = (Entry)entryList.remove(maxArraySize - 1);
            getOverflowEntriesMutable().put(entry.getKey(), entry.getValue());
        }
        entryList.add(i, new Entry(comparable, obj));
        return null;
    }

    public volatile Object put(Object obj, Object obj1)
    {
        return put((Comparable)obj, obj1);
    }

    public Object remove(Object obj)
    {
        checkMutable();
        obj = (Comparable)obj;
        int i = binarySearchInArray(((Comparable) (obj)));
        if (i >= 0)
        {
            return removeArrayEntryAt(i);
        }
        if (overflowEntries.isEmpty())
        {
            return null;
        } else
        {
            return overflowEntries.remove(obj);
        }
    }

    public int size()
    {
        return entryList.size() + overflowEntries.size();
    }




}
