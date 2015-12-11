// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finding;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.ebay.common.net.api.finding:
//            PagedList

private static final class currentPosition
    implements ListIterator
{

    private int currentPosition;
    private final List parent;

    public void add(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public boolean hasNext()
    {
        return currentPosition < parent.size();
    }

    public boolean hasPrevious()
    {
        return currentPosition > 0;
    }

    public Object next()
    {
        if (currentPosition >= parent.size())
        {
            throw new NoSuchElementException();
        } else
        {
            List list = parent;
            int i = currentPosition;
            currentPosition = i + 1;
            return list.get(i);
        }
    }

    public int nextIndex()
    {
        return currentPosition;
    }

    public Object previous()
    {
        if (currentPosition == 0)
        {
            throw new NoSuchElementException();
        } else
        {
            List list = parent;
            int i = currentPosition - 1;
            currentPosition = i;
            return list.get(i);
        }
    }

    public int previousIndex()
    {
        return currentPosition - 1;
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    public void set(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public (List list, int i)
    {
        parent = list;
        currentPosition = i;
    }
}
