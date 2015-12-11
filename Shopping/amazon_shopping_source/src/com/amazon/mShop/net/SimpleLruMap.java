// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import java.util.LinkedHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SimpleLruMap extends LinkedHashMap
{
    public static interface DataProcessor
    {

        public abstract int evict(Object obj);

        public abstract int getSize(Object obj);

        public abstract void setAccessTime(Object obj, long l);
    }


    private int mCurrentSize;
    private int mMaxItemSize;
    private int mMaxTotalCount;
    private int mMaxTotalSize;
    private DataProcessor mProcessor;
    private final Lock mReadLock;
    private final ReadWriteLock mReadWriteLock;
    private final Lock mWriteLock;

    private SimpleLruMap(int i, int j, int k, DataProcessor dataprocessor)
    {
        super(0, 0.75F, true);
        mReadWriteLock = new ReentrantReadWriteLock();
        mReadLock = mReadWriteLock.readLock();
        mWriteLock = mReadWriteLock.writeLock();
        mMaxTotalSize = i;
        mMaxItemSize = j;
        mMaxTotalCount = k;
        mProcessor = dataprocessor;
        mCurrentSize = 0;
    }

    public SimpleLruMap(int i, int j, DataProcessor dataprocessor)
    {
        this(i, j, 0x7fffffff, dataprocessor);
    }

    public SimpleLruMap(int i, DataProcessor dataprocessor)
    {
        this(0x7fffffff, 0x7fffffff, i, dataprocessor);
    }

    public boolean addItem(Object obj, Object obj1)
    {
        boolean flag;
        flag = false;
        mWriteLock.lock();
        int k;
        k = mProcessor.getSize(obj1);
        if (k > mMaxItemSize)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        int j = k;
        if (size() != 0)
        {
            j = mCurrentSize / size();
        }
        int i;
        i = 1;
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        i = (k / j) * 2;
        j = 0;
        mCurrentSize = mCurrentSize + k;
_L2:
        Object obj2 = remove(obj);
        if (obj2 == null || j != 0)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        k = mProcessor.evict(obj2);
        mCurrentSize = mCurrentSize - k;
        put(obj, obj1);
        k = j + 1;
        int l;
        j = mCurrentSize;
        l = mMaxTotalSize;
        if (j <= l)
        {
            break; /* Loop/switch isn't completed */
        }
        j = k;
        if (k < i) goto _L2; else goto _L1
_L1:
        flag = true;
        mWriteLock.unlock();
        return flag;
        obj;
        mWriteLock.unlock();
        throw obj;
    }

    public Object getItem(Object obj)
    {
        mReadLock.lock();
        obj = get(obj);
        mReadLock.unlock();
        if (obj != null)
        {
            mProcessor.setAccessTime(obj, System.currentTimeMillis());
        }
        return obj;
        obj;
        mReadLock.unlock();
        throw obj;
    }

    protected boolean removeEldestEntry(java.util.Map.Entry entry)
    {
        boolean flag;
        flag = false;
        mWriteLock.lock();
        if (mCurrentSize <= mMaxTotalSize && size() <= mMaxTotalCount)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        int i = mProcessor.evict(entry.getValue());
        mCurrentSize = mCurrentSize - i;
        flag = true;
        mWriteLock.unlock();
        return flag;
        entry;
        mWriteLock.unlock();
        throw entry;
    }
}
