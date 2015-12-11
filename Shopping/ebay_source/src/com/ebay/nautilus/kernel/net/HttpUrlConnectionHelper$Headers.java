// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            IHeaders, HttpUrlConnectionHelper, IHeader

private static abstract class connection
    implements IHeaders
{
    private static final class HeaderIterator
        implements Iterator
    {

        private int count;
        private java.util.Map.Entry entry;
        private final Iterator headers;
        private int index;

        public boolean hasNext()
        {
            while (entry != null) 
            {
                if (index < count)
                {
                    return true;
                }
                if (headers.hasNext())
                {
                    entry = (java.util.Map.Entry)headers.next();
                    count = ((List)entry.getValue()).size();
                    index = 0;
                } else
                {
                    entry = null;
                }
            }
            return false;
        }

        public IHeader next()
        {
            java.util.Map.Entry entry1 = entry;
            int i = index;
            index = i + 1;
            return new HttpUrlConnectionHelper.Header(entry1, i);
        }

        public volatile Object next()
        {
            return next();
        }

        public void remove()
        {
            throw new RuntimeException("Not allowed");
        }

        public HeaderIterator(Map map)
        {
            headers = map.entrySet().iterator();
            if (headers.hasNext())
            {
                entry = (java.util.Map.Entry)headers.next();
                count = ((List)entry.getValue()).size();
            }
        }
    }


    protected final HttpURLConnection connection;

    public final String getFirstHeader(String s)
    {
        Map map = getAllHeaders();
        if (map != null && !map.isEmpty())
        {
            if ((s = (List)map.get(s)) != null && !s.isEmpty())
            {
                return (String)s.get(0);
            }
        }
        return null;
    }

    public Iterator iterator()
    {
        return new HeaderIterator(getAllHeaders());
    }

    public HeaderIterator.entry(HttpURLConnection httpurlconnection)
    {
        connection = httpurlconnection;
    }
}
