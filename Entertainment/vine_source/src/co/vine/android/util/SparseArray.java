// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public class SparseArray extends android.util.SparseArray
    implements Iterable, Serializable
{
    public class SparseKeyIterator
        implements Iterator
    {

        public int index;
        final SparseArray this$0;

        public boolean hasNext()
        {
            return index < size();
        }

        public Integer next()
        {
            index = index + 1;
            return Integer.valueOf(keyAt(index - 1));
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
            this$0 = SparseArray.this;
            super();
        }
    }

    public class SparseValueIterator
        implements Iterator
    {

        public int index;
        final SparseArray this$0;

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
            this$0 = SparseArray.this;
            super();
        }
    }


    public SparseArray()
    {
    }

    public Iterator iterator()
    {
        return new SparseKeyIterator();
    }

    public void removeAll(Collection collection)
    {
        for (collection = collection.iterator(); collection.hasNext(); delete(((Integer)collection.next()).intValue())) { }
    }

    public Iterator valueIterator()
    {
        return new SparseValueIterator();
    }
}
