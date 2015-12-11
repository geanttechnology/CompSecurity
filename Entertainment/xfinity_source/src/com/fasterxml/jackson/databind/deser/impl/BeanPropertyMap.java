// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class BeanPropertyMap
    implements Serializable, Iterable
{
    private static final class Bucket
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public final int index;
        public final String key;
        public final Bucket next;
        public final SettableBeanProperty value;

        public Bucket(Bucket bucket, String s, SettableBeanProperty settablebeanproperty, int i)
        {
            next = bucket;
            key = s;
            value = settablebeanproperty;
            index = i;
        }
    }

    private static final class IteratorImpl
        implements Iterator
    {

        private final Bucket _buckets[];
        private Bucket _currentBucket;
        private int _nextBucketIndex;

        public boolean hasNext()
        {
            return _currentBucket != null;
        }

        public SettableBeanProperty next()
        {
            Bucket bucket = _currentBucket;
            if (bucket == null)
            {
                throw new NoSuchElementException();
            }
            Object obj;
            int i;
            for (obj = bucket.next; obj == null && _nextBucketIndex < _buckets.length; obj = obj[i])
            {
                obj = _buckets;
                i = _nextBucketIndex;
                _nextBucketIndex = i + 1;
            }

            _currentBucket = ((Bucket) (obj));
            return bucket.value;
        }

        public volatile Object next()
        {
            return next();
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public IteratorImpl(Bucket abucket[])
        {
            int i;
            int k;
            _buckets = abucket;
            k = _buckets.length;
            i = 0;
_L3:
            int j;
            if (i >= k)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            abucket = _buckets;
            j = i + 1;
            abucket = abucket[i];
            if (abucket == null) goto _L2; else goto _L1
_L1:
            _currentBucket = abucket;
_L4:
            _nextBucketIndex = j;
            return;
_L2:
            i = j;
              goto _L3
            j = i;
              goto _L4
        }
    }


    private static final long serialVersionUID = 1L;
    private final Bucket _buckets[];
    private final int _hashMask;
    private int _nextBucketIndex;
    private final int _size;

    public BeanPropertyMap(Collection collection)
    {
        _nextBucketIndex = 0;
        _size = collection.size();
        int i = findSize(_size);
        _hashMask = i - 1;
        Bucket abucket[] = new Bucket[i];
        for (collection = collection.iterator(); collection.hasNext();)
        {
            SettableBeanProperty settablebeanproperty = (SettableBeanProperty)collection.next();
            String s = settablebeanproperty.getName();
            int j = s.hashCode() & _hashMask;
            Bucket bucket = abucket[j];
            int k = _nextBucketIndex;
            _nextBucketIndex = k + 1;
            abucket[j] = new Bucket(bucket, s, settablebeanproperty, k);
        }

        _buckets = abucket;
    }

    private BeanPropertyMap(Bucket abucket[], int i, int j)
    {
        _nextBucketIndex = 0;
        _buckets = abucket;
        _size = i;
        _hashMask = abucket.length - 1;
        _nextBucketIndex = j;
    }

    private SettableBeanProperty _findWithEquals(String s, int i)
    {
        for (Bucket bucket = _buckets[i]; bucket != null; bucket = bucket.next)
        {
            if (s.equals(bucket.key))
            {
                return bucket.value;
            }
        }

        return null;
    }

    private static final int findSize(int i)
    {
        int j;
        if (i <= 32)
        {
            i += i;
        } else
        {
            i += i >> 2;
        }
        for (j = 2; j < i; j += j) { }
        return j;
    }

    public BeanPropertyMap assignIndexes()
    {
        int i = 0;
        Bucket abucket[] = _buckets;
        int k = abucket.length;
        for (int j = 0; j < k; j++)
        {
            for (Bucket bucket = abucket[j]; bucket != null;)
            {
                bucket.value.assignIndex(i);
                bucket = bucket.next;
                i++;
            }

        }

        return this;
    }

    public SettableBeanProperty find(String s)
    {
        int i = s.hashCode() & _hashMask;
        Bucket bucket1 = _buckets[i];
        if (bucket1 == null)
        {
            return null;
        }
        Bucket bucket = bucket1;
        if (bucket1.key == s)
        {
            return bucket1.value;
        }
        do
        {
            Bucket bucket2 = bucket.next;
            if (bucket2 != null)
            {
                bucket = bucket2;
                if (bucket2.key == s)
                {
                    return bucket2.value;
                }
            } else
            {
                return _findWithEquals(s, i);
            }
        } while (true);
    }

    public SettableBeanProperty[] getPropertiesInInsertionOrder()
    {
        SettableBeanProperty asettablebeanproperty[] = new SettableBeanProperty[_nextBucketIndex];
        Bucket abucket[] = _buckets;
        int j = abucket.length;
        for (int i = 0; i < j; i++)
        {
            for (Bucket bucket = abucket[i]; bucket != null; bucket = bucket.next)
            {
                asettablebeanproperty[bucket.index] = bucket.value;
            }

        }

        return asettablebeanproperty;
    }

    public Iterator iterator()
    {
        return new IteratorImpl(_buckets);
    }

    public void remove(SettableBeanProperty settablebeanproperty)
    {
        String s = settablebeanproperty.getName();
        int i = s.hashCode() & _buckets.length - 1;
        boolean flag = false;
        Bucket bucket1 = _buckets[i];
        Bucket bucket = null;
        while (bucket1 != null) 
        {
            if (!flag && bucket1.key.equals(s))
            {
                flag = true;
            } else
            {
                bucket = new Bucket(bucket, bucket1.key, bucket1.value, bucket1.index);
            }
            bucket1 = bucket1.next;
        }
        if (!flag)
        {
            throw new NoSuchElementException((new StringBuilder()).append("No entry '").append(settablebeanproperty).append("' found, can't remove").toString());
        } else
        {
            _buckets[i] = bucket;
            return;
        }
    }

    public BeanPropertyMap renameAll(NameTransformer nametransformer)
    {
        if (nametransformer == null || nametransformer == NameTransformer.NOP)
        {
            return this;
        }
        Iterator iterator1 = iterator();
        ArrayList arraylist = new ArrayList();
        SettableBeanProperty settablebeanproperty;
        for (; iterator1.hasNext(); arraylist.add(settablebeanproperty))
        {
            settablebeanproperty = (SettableBeanProperty)iterator1.next();
            SettableBeanProperty settablebeanproperty1 = settablebeanproperty.withName(nametransformer.transform(settablebeanproperty.getName()));
            JsonDeserializer jsondeserializer = settablebeanproperty1.getValueDeserializer();
            settablebeanproperty = settablebeanproperty1;
            if (jsondeserializer == null)
            {
                continue;
            }
            JsonDeserializer jsondeserializer1 = jsondeserializer.unwrappingDeserializer(nametransformer);
            settablebeanproperty = settablebeanproperty1;
            if (jsondeserializer1 != jsondeserializer)
            {
                settablebeanproperty = settablebeanproperty1.withValueDeserializer(jsondeserializer1);
            }
        }

        return new BeanPropertyMap(arraylist);
    }

    public void replace(SettableBeanProperty settablebeanproperty)
    {
        String s = settablebeanproperty.getName();
        int j = s.hashCode() & _buckets.length - 1;
        int i = -1;
        Bucket bucket1 = _buckets[j];
        Bucket bucket = null;
        while (bucket1 != null) 
        {
            if (i < 0 && bucket1.key.equals(s))
            {
                i = bucket1.index;
            } else
            {
                bucket = new Bucket(bucket, bucket1.key, bucket1.value, bucket1.index);
            }
            bucket1 = bucket1.next;
        }
        if (i < 0)
        {
            throw new NoSuchElementException((new StringBuilder()).append("No entry '").append(settablebeanproperty).append("' found, can't replace").toString());
        } else
        {
            _buckets[j] = new Bucket(bucket, s, settablebeanproperty, i);
            return;
        }
    }

    public int size()
    {
        return _size;
    }

    public BeanPropertyMap withProperty(SettableBeanProperty settablebeanproperty)
    {
        int i = _buckets.length;
        Bucket abucket[] = new Bucket[i];
        System.arraycopy(_buckets, 0, abucket, 0, i);
        String s = settablebeanproperty.getName();
        if (find(settablebeanproperty.getName()) == null)
        {
            i = s.hashCode() & _hashMask;
            Bucket bucket = abucket[i];
            int j = _nextBucketIndex;
            _nextBucketIndex = j + 1;
            abucket[i] = new Bucket(bucket, s, settablebeanproperty, j);
            return new BeanPropertyMap(abucket, _size + 1, _nextBucketIndex);
        } else
        {
            BeanPropertyMap beanpropertymap = new BeanPropertyMap(abucket, i, _nextBucketIndex);
            beanpropertymap.replace(settablebeanproperty);
            return beanpropertymap;
        }
    }
}
