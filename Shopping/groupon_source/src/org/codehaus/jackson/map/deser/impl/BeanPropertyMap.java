// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.deser.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.codehaus.jackson.map.deser.SettableBeanProperty;

public final class BeanPropertyMap
{
    private static final class Bucket
    {

        public final String key;
        public final Bucket next;
        public final SettableBeanProperty value;

        public Bucket(Bucket bucket, String s, SettableBeanProperty settablebeanproperty)
        {
            next = bucket;
            key = s;
            value = settablebeanproperty;
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

        public volatile Object next()
        {
            return next();
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


    private final Bucket _buckets[];
    private final int _hashMask;
    private final int _size;

    public BeanPropertyMap(Collection collection)
    {
        _size = collection.size();
        int i = findSize(_size);
        _hashMask = i - 1;
        Bucket abucket[] = new Bucket[i];
        for (collection = collection.iterator(); collection.hasNext();)
        {
            SettableBeanProperty settablebeanproperty = (SettableBeanProperty)collection.next();
            String s = settablebeanproperty.getName();
            int j = s.hashCode() & _hashMask;
            abucket[j] = new Bucket(abucket[j], s, settablebeanproperty);
        }

        _buckets = abucket;
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

    public Iterator allProperties()
    {
        return new IteratorImpl(_buckets);
    }

    public void assignIndexes()
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
                bucket = new Bucket(bucket, bucket1.key, bucket1.value);
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

    public void replace(SettableBeanProperty settablebeanproperty)
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
                bucket = new Bucket(bucket, bucket1.key, bucket1.value);
            }
            bucket1 = bucket1.next;
        }
        if (!flag)
        {
            throw new NoSuchElementException((new StringBuilder()).append("No entry '").append(settablebeanproperty).append("' found, can't replace").toString());
        } else
        {
            _buckets[i] = new Bucket(bucket, s, settablebeanproperty);
            return;
        }
    }

    public int size()
    {
        return _size;
    }
}
