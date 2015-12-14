// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.disk;


// Referenced classes of package com.facebook.cache.disk:
//            DiskStorageCache

static class mCount
{

    private long mCount;
    private boolean mInitialized;
    private long mSize;

    public long getCount()
    {
        this;
        JVM INSTR monitorenter ;
        long l = mCount;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public long getSize()
    {
        this;
        JVM INSTR monitorenter ;
        long l = mSize;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public void increment(long l, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        if (mInitialized)
        {
            mSize = mSize + l;
            mCount = mCount + l1;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isInitialized()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mInitialized;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void reset()
    {
        this;
        JVM INSTR monitorenter ;
        mInitialized = false;
        mCount = -1L;
        mSize = -1L;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void set(long l, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        mCount = l1;
        mSize = l;
        mInitialized = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    _cls9()
    {
        mInitialized = false;
        mSize = -1L;
        mCount = -1L;
    }
}
