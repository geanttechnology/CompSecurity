// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.message;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HeaderIterator;
import java.util.NoSuchElementException;

public class BasicHeaderIterator
    implements HeaderIterator
{

    protected final Header allHeaders[];
    protected int currentIndex;
    protected String headerName;

    protected boolean filterHeader(int i)
    {
        return headerName == null || headerName.equalsIgnoreCase(allHeaders[i].getName());
    }

    protected int findNext(int i)
    {
        if (i >= -1)
        {
            int j = allHeaders.length;
            boolean flag;
            for (flag = false; !flag && i < j - 1; flag = filterHeader(i))
            {
                i++;
            }

            if (flag)
            {
                return i;
            }
        }
        return -1;
    }

    public boolean hasNext()
    {
        return currentIndex >= 0;
    }

    public final Object next()
        throws NoSuchElementException
    {
        return nextHeader();
    }

    public Header nextHeader()
        throws NoSuchElementException
    {
        int i = currentIndex;
        if (i < 0)
        {
            throw new NoSuchElementException("Iteration already finished.");
        } else
        {
            currentIndex = findNext(i);
            return allHeaders[i];
        }
    }

    public void remove()
        throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException("Removing headers is not supported.");
    }
}
