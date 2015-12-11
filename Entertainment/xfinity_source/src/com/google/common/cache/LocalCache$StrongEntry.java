// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.cache;


// Referenced classes of package com.google.common.cache:
//            LocalCache

static class next
    implements ry
{

    final int hash;
    final Object key;
    final ry next;
    volatile ce valueReference;

    public long getAccessTime()
    {
        throw new UnsupportedOperationException();
    }

    public int getHash()
    {
        return hash;
    }

    public Object getKey()
    {
        return key;
    }

    public ry getNext()
    {
        return next;
    }

    public ry getNextInAccessQueue()
    {
        throw new UnsupportedOperationException();
    }

    public ry getNextInWriteQueue()
    {
        throw new UnsupportedOperationException();
    }

    public ry getPreviousInAccessQueue()
    {
        throw new UnsupportedOperationException();
    }

    public ry getPreviousInWriteQueue()
    {
        throw new UnsupportedOperationException();
    }

    public ce getValueReference()
    {
        return valueReference;
    }

    public long getWriteTime()
    {
        throw new UnsupportedOperationException();
    }

    public void setAccessTime(long l)
    {
        throw new UnsupportedOperationException();
    }

    public void setNextInAccessQueue(ry ry)
    {
        throw new UnsupportedOperationException();
    }

    public void setNextInWriteQueue(ry ry)
    {
        throw new UnsupportedOperationException();
    }

    public void setPreviousInAccessQueue(ry ry)
    {
        throw new UnsupportedOperationException();
    }

    public void setPreviousInWriteQueue(ry ry)
    {
        throw new UnsupportedOperationException();
    }

    public void setValueReference(ce ce)
    {
        valueReference = ce;
    }

    public void setWriteTime(long l)
    {
        throw new UnsupportedOperationException();
    }

    ry(Object obj, int i, ry ry)
    {
        valueReference = LocalCache.unset();
        key = obj;
        hash = i;
        next = ry;
    }
}
