// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public class LongSparseArray extends android.support.v4.util.LongSparseArray
    implements Iterable, Serializable
{
    public class SparseKeyIterator
        implements Iterator
    {

        public int index;
        final LongSparseArray this$0;

        public boolean hasNext()
        {
            return index < size();
        }

        public Long next()
        {
            index = index + 1;
            return Long.valueOf(keyAt(index - 1));
        }

        public volatile Object next()
        {
            return next();
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public SparseKeyIterator()
        {
            this$0 = LongSparseArray.this;
            super();
        }
    }

    public class SparseValueIterator
        implements Iterator
    {

        public int index;
        final LongSparseArray this$0;

        public boolean hasNext()
        {
            return index < size();
        }

        public Object next()
        {
            index = index + 1;
            return valueAt(index - 1);
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public SparseValueIterator()
        {
            this$0 = LongSparseArray.this;
            super();
        }
    }


    public LongSparseArray()
    {
    }

    public LongSparseArray(int i)
    {
        super(i);
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public Iterator iterator()
    {
        return new SparseKeyIterator();
    }

    public void removeAll(Collection collection)
    {
        for (collection = collection.iterator(); collection.hasNext(); delete(((Long)collection.next()).longValue())) { }
    }

    public Object removeKey(long l)
    {
        Object obj = get(l);
        if (obj != null)
        {
            super.remove(l);
        }
        return obj;
    }

    public Iterator valueIterator()
    {
        return new SparseValueIterator();
    }
}
