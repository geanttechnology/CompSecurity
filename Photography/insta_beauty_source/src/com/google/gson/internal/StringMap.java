// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.Set;

public final class StringMap extends AbstractMap
{

    private static final java.util.Map.Entry EMPTY_TABLE[] = new LinkedEntry[2];
    private static final int MAXIMUM_CAPACITY = 0x40000000;
    private static final int MINIMUM_CAPACITY = 4;
    private static final int seed = (new Random()).nextInt();
    private Set entrySet;
    private LinkedEntry header;
    private Set keySet;
    private int size;
    private LinkedEntry table[];
    private int threshold;
    private Collection values;

    public StringMap()
    {
        table = (LinkedEntry[])(LinkedEntry[])EMPTY_TABLE;
        threshold = -1;
        header = new LinkedEntry();
    }

    private void addNewEntry(String s, Object obj, int i, int j)
    {
        LinkedEntry linkedentry = header;
        LinkedEntry linkedentry1 = linkedentry.prv;
        s = new LinkedEntry(s, obj, i, table[j], linkedentry, linkedentry1);
        obj = table;
        linkedentry.prv = s;
        linkedentry1.nxt = s;
        obj[j] = s;
    }

    private LinkedEntry[] doubleCapacity()
    {
        LinkedEntry alinkedentry[] = table;
        int l = alinkedentry.length;
        if (l == 0x40000000)
        {
            return alinkedentry;
        }
        LinkedEntry alinkedentry1[] = makeTable(l * 2);
        if (size == 0)
        {
            return alinkedentry1;
        }
        int j = 0;
        while (j < l) 
        {
            LinkedEntry linkedentry1 = alinkedentry[j];
            if (linkedentry1 != null)
            {
                int i = linkedentry1.hash & l;
                alinkedentry1[j | i] = linkedentry1;
                LinkedEntry linkedentry = linkedentry1.next;
                LinkedEntry linkedentry2 = null;
                while (linkedentry != null) 
                {
                    int k = linkedentry.hash & l;
                    if (k != i)
                    {
                        LinkedEntry linkedentry3;
                        if (linkedentry2 == null)
                        {
                            alinkedentry1[j | k] = linkedentry;
                        } else
                        {
                            linkedentry2.next = linkedentry;
                        }
                        i = k;
                    } else
                    {
                        linkedentry1 = linkedentry2;
                    }
                    linkedentry3 = linkedentry.next;
                    linkedentry2 = linkedentry1;
                    linkedentry1 = linkedentry;
                    linkedentry = linkedentry3;
                }
                if (linkedentry2 != null)
                {
                    linkedentry2.next = null;
                }
            }
            j++;
        }
        return alinkedentry1;
    }

    private LinkedEntry getEntry(String s)
    {
        if (s != null)
        {
            int i = hash(s);
            LinkedEntry alinkedentry[] = table;
            LinkedEntry linkedentry = alinkedentry[alinkedentry.length - 1 & i];
            while (linkedentry != null) 
            {
                String s1 = linkedentry.key;
                if (s1 == s || linkedentry.hash == i && s.equals(s1))
                {
                    return linkedentry;
                }
                linkedentry = linkedentry.next;
            }
        }
        return null;
    }

    private static int hash(String s)
    {
        int k = seed;
        for (int i = 0; i < s.length(); i++)
        {
            k += s.charAt(i);
            k = k + k << 10;
            k ^= k >>> 6;
        }

        int j = k >>> 20 ^ k >>> 12 ^ k;
        return j >>> 4 ^ (j >>> 7 ^ j);
    }

    private LinkedEntry[] makeTable(int i)
    {
        LinkedEntry alinkedentry[] = (LinkedEntry[])new LinkedEntry[i];
        table = alinkedentry;
        threshold = (i >> 1) + (i >> 2);
        return alinkedentry;
    }

    private boolean removeMapping(Object obj, Object obj1)
    {
        if (obj == null || !(obj instanceof String))
        {
            return false;
        }
        int i = hash((String)obj);
        LinkedEntry alinkedentry[] = table;
        int j = i & alinkedentry.length - 1;
        LinkedEntry linkedentry = alinkedentry[j];
        LinkedEntry linkedentry1 = null;
        LinkedEntry linkedentry2;
        for (; linkedentry != null; linkedentry = linkedentry2)
        {
            if (linkedentry.hash == i && obj.equals(linkedentry.key))
            {
                if (obj1 != null ? !obj1.equals(linkedentry.value) : linkedentry.value != null)
                {
                    return false;
                }
                if (linkedentry1 == null)
                {
                    alinkedentry[j] = linkedentry.next;
                } else
                {
                    linkedentry1.next = linkedentry.next;
                }
                size = size - 1;
                unlink(linkedentry);
                return true;
            }
            linkedentry2 = linkedentry.next;
            linkedentry1 = linkedentry;
        }

        return false;
    }

    private void unlink(LinkedEntry linkedentry)
    {
        linkedentry.prv.nxt = linkedentry.nxt;
        linkedentry.nxt.prv = linkedentry.prv;
        linkedentry.prv = null;
        linkedentry.nxt = null;
    }

    public void clear()
    {
        if (size != 0)
        {
            Arrays.fill(table, null);
            size = 0;
        }
        LinkedEntry linkedentry2 = header;
        LinkedEntry linkedentry1;
        for (LinkedEntry linkedentry = linkedentry2.nxt; linkedentry != linkedentry2; linkedentry = linkedentry1)
        {
            linkedentry1 = linkedentry.nxt;
            linkedentry.prv = null;
            linkedentry.nxt = null;
        }

        linkedentry2.prv = linkedentry2;
        linkedentry2.nxt = linkedentry2;
    }

    public boolean containsKey(Object obj)
    {
        return (obj instanceof String) && getEntry((String)obj) != null;
    }

    public Set entrySet()
    {
        Set set = entrySet;
        if (set != null)
        {
            return set;
        } else
        {
            EntrySet entryset = new EntrySet(null);
            entrySet = entryset;
            return entryset;
        }
    }

    public Object get(Object obj)
    {
        Object obj2 = null;
        Object obj1 = obj2;
        if (obj instanceof String)
        {
            obj = getEntry((String)obj);
            obj1 = obj2;
            if (obj != null)
            {
                obj1 = ((LinkedEntry) (obj)).value;
            }
        }
        return obj1;
    }

    public Set keySet()
    {
        Set set = keySet;
        if (set != null)
        {
            return set;
        } else
        {
            KeySet keyset = new KeySet(null);
            keySet = keyset;
            return keyset;
        }
    }

    public volatile Object put(Object obj, Object obj1)
    {
        return put((String)obj, obj1);
    }

    public Object put(String s, Object obj)
    {
        if (s == null)
        {
            throw new NullPointerException("key == null");
        }
        int j = hash(s);
        LinkedEntry alinkedentry[] = table;
        int i = alinkedentry.length - 1 & j;
        for (LinkedEntry linkedentry = alinkedentry[i]; linkedentry != null; linkedentry = linkedentry.next)
        {
            if (linkedentry.hash == j && s.equals(linkedentry.key))
            {
                s = ((String) (linkedentry.value));
                linkedentry.value = obj;
                return s;
            }
        }

        int k = size;
        size = k + 1;
        if (k > threshold)
        {
            i = doubleCapacity().length - 1 & j;
        }
        addNewEntry(s, obj, j, i);
        return null;
    }

    public Object remove(Object obj)
    {
        if (obj == null || !(obj instanceof String))
        {
            return null;
        }
        int i = hash((String)obj);
        LinkedEntry alinkedentry[] = table;
        int j = i & alinkedentry.length - 1;
        LinkedEntry linkedentry = alinkedentry[j];
        LinkedEntry linkedentry1 = null;
        LinkedEntry linkedentry2;
        for (; linkedentry != null; linkedentry = linkedentry2)
        {
            if (linkedentry.hash == i && obj.equals(linkedentry.key))
            {
                if (linkedentry1 == null)
                {
                    alinkedentry[j] = linkedentry.next;
                } else
                {
                    linkedentry1.next = linkedentry.next;
                }
                size = size - 1;
                unlink(linkedentry);
                return linkedentry.value;
            }
            linkedentry2 = linkedentry.next;
            linkedentry1 = linkedentry;
        }

        return null;
    }

    public int size()
    {
        return size;
    }

    public Collection values()
    {
        Collection collection = values;
        if (collection != null)
        {
            return collection;
        } else
        {
            Values values1 = new Values(null);
            values = values1;
            return values1;
        }
    }





    private class LinkedEntry
        implements java.util.Map.Entry
    {

        final int hash;
        final String key;
        LinkedEntry next;
        LinkedEntry nxt;
        LinkedEntry prv;
        Object value;

        public final boolean equals(Object obj)
        {
            if (obj instanceof java.util.Map.Entry)
            {
                obj = (java.util.Map.Entry)obj;
                Object obj1 = ((java.util.Map.Entry) (obj)).getValue();
                if (key.equals(((java.util.Map.Entry) (obj)).getKey()) && (value != null ? value.equals(obj1) : obj1 == null))
                {
                    return true;
                }
            }
            return false;
        }

        public volatile Object getKey()
        {
            return getKey();
        }

        public final String getKey()
        {
            return key;
        }

        public final Object getValue()
        {
            return value;
        }

        public final int hashCode()
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

        public final Object setValue(Object obj)
        {
            Object obj1 = value;
            value = obj;
            return obj1;
        }

        public final String toString()
        {
            return (new StringBuilder()).append(key).append("=").append(value).toString();
        }

        LinkedEntry()
        {
            this(null, null, 0, null, null, null);
            prv = this;
            nxt = this;
        }

        LinkedEntry(String s, Object obj, int i, LinkedEntry linkedentry, LinkedEntry linkedentry1, LinkedEntry linkedentry2)
        {
            key = s;
            value = obj;
            hash = i;
            next = linkedentry;
            nxt = linkedentry1;
            prv = linkedentry2;
        }
    }


    private class EntrySet extends AbstractSet
    {

        final StringMap this$0;

        public void clear()
        {
            StringMap.this.clear();
        }

        public boolean contains(Object obj)
        {
            if (obj instanceof java.util.Map.Entry)
            {
                obj = (java.util.Map.Entry)obj;
                Object obj1 = get(((java.util.Map.Entry) (obj)).getKey());
                if (obj1 != null && obj1.equals(((java.util.Map.Entry) (obj)).getValue()))
                {
                    return true;
                }
            }
            return false;
        }

        public Iterator iterator()
        {
            class _cls1 extends LinkedHashIterator
            {
                private class LinkedHashIterator
                    implements Iterator
                {

                    LinkedEntry lastReturned;
                    LinkedEntry next;
                    final StringMap this$0;

                    public final boolean hasNext()
                    {
                        return next != header;
                    }

                    final LinkedEntry nextEntry()
                    {
                        LinkedEntry linkedentry = next;
                        if (linkedentry == header)
                        {
                            throw new NoSuchElementException();
                        } else
                        {
                            next = linkedentry.nxt;
                            lastReturned = linkedentry;
                            return linkedentry;
                        }
                    }

                    public final void remove()
                    {
                        if (lastReturned == null)
                        {
                            throw new IllegalStateException();
                        } else
                        {
                            StringMap.this.remove(lastReturned.key);
                            lastReturned = null;
                            return;
                        }
                    }

                    private LinkedHashIterator()
                    {
                        this$0 = StringMap.this;
                        super();
                        next = header.nxt;
                        lastReturned = null;
                    }

                    LinkedHashIterator(_cls1 _pcls1)
                    {
                        this();
                    }
                }


                final EntrySet this$1;

                public volatile Object next()
                {
                    return next();
                }

                public final java.util.Map.Entry next()
                {
                    return nextEntry();
                }

                _cls1()
                {
                    this$1 = EntrySet.this;
                    super(null);
                }
            }

            return new _cls1();
        }

        public boolean remove(Object obj)
        {
            if (!(obj instanceof java.util.Map.Entry))
            {
                return false;
            } else
            {
                obj = (java.util.Map.Entry)obj;
                return removeMapping(((java.util.Map.Entry) (obj)).getKey(), ((java.util.Map.Entry) (obj)).getValue());
            }
        }

        public int size()
        {
            return StringMap.this.size;
        }

        private EntrySet()
        {
            this$0 = StringMap.this;
            super();
        }

        EntrySet(_cls1 _pcls1)
        {
            this();
        }
    }


    private class KeySet extends AbstractSet
    {

        final StringMap this$0;

        public void clear()
        {
            StringMap.this.clear();
        }

        public boolean contains(Object obj)
        {
            return containsKey(obj);
        }

        public Iterator iterator()
        {
            class _cls1 extends LinkedHashIterator
            {

                final KeySet this$1;

                public volatile Object next()
                {
                    return next();
                }

                public final String next()
                {
                    return nextEntry().key;
                }

                _cls1()
                {
                    this$1 = KeySet.this;
                    super(null);
                }
            }

            return new _cls1();
        }

        public boolean remove(Object obj)
        {
            int i = StringMap.this.size;
            StringMap.this.remove(obj);
            return StringMap.this.size != i;
        }

        public int size()
        {
            return StringMap.this.size;
        }

        private KeySet()
        {
            this$0 = StringMap.this;
            super();
        }

        KeySet(_cls1 _pcls1)
        {
            this();
        }
    }


    private class Values extends AbstractCollection
    {

        final StringMap this$0;

        public void clear()
        {
            StringMap.this.clear();
        }

        public boolean contains(Object obj)
        {
            return containsValue(obj);
        }

        public Iterator iterator()
        {
            class _cls1 extends LinkedHashIterator
            {

                final Values this$1;

                public final Object next()
                {
                    return nextEntry().value;
                }

                _cls1()
                {
                    this$1 = Values.this;
                    super(null);
                }
            }

            return new _cls1();
        }

        public int size()
        {
            return StringMap.this.size;
        }

        private Values()
        {
            this$0 = StringMap.this;
            super();
        }

        Values(_cls1 _pcls1)
        {
            this();
        }
    }

}
