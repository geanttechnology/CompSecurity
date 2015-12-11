// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import java.util.Iterator;
import org.apache.http.Header;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            HttpClientImpl, IHeader

private static final class count
    implements Iterator
{

    private final int count;
    private final Header headers[];
    private int index;

    public boolean hasNext()
    {
        return index < count;
    }

    public IHeader next()
    {
        Header aheader[] = headers;
        int i = index;
        index = i + 1;
        return new index(aheader[i]);
    }

    public volatile Object next()
    {
        return next();
    }

    public void remove()
    {
        throw new RuntimeException("Not allowed");
    }

    public (Header aheader[])
    {
        headers = aheader;
        int i;
        if (aheader == null)
        {
            i = 0;
        } else
        {
            i = aheader.length;
        }
        count = i;
    }
}
