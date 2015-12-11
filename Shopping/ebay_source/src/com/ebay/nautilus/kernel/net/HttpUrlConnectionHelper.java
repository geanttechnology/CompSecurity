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
//            IHeaders, IHeader

final class HttpUrlConnectionHelper
{
    static final class Header
        implements IHeader
    {

        private final java.util.Map.Entry entry;
        private final int index;

        public String getName()
        {
            return (String)entry.getKey();
        }

        public String getValue()
        {
            return (String)((List)entry.getValue()).get(index);
        }

        public Header(java.util.Map.Entry entry1, int i)
        {
            entry = entry1;
            index = i;
        }
    }

    private static abstract class Headers
        implements IHeaders
    {

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

        public Headers(HttpURLConnection httpurlconnection)
        {
            connection = httpurlconnection;
        }
    }

    private static final class Headers.HeaderIterator
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
            return new Header(entry1, i);
        }

        public volatile Object next()
        {
            return next();
        }

        public void remove()
        {
            throw new RuntimeException("Not allowed");
        }

        public Headers.HeaderIterator(Map map)
        {
            headers = map.entrySet().iterator();
            if (headers.hasNext())
            {
                entry = (java.util.Map.Entry)headers.next();
                count = ((List)entry.getValue()).size();
            }
        }
    }

    private static final class RequestHeaders extends Headers
    {

        public Map getAllHeaders()
        {
            return connection.getRequestProperties();
        }

        public String getLastHeader(String s)
        {
            return connection.getRequestProperty(s);
        }

        public void setHeader(String s, String s1)
        {
            connection.addRequestProperty(s, s1);
        }

        public RequestHeaders(HttpURLConnection httpurlconnection)
        {
            super(httpurlconnection);
        }
    }

    private static final class ResponseHeaders extends Headers
    {

        public Map getAllHeaders()
        {
            return connection.getHeaderFields();
        }

        public String getLastHeader(String s)
        {
            return connection.getHeaderField(s);
        }

        public void setHeader(String s, String s1)
        {
            throw new RuntimeException("Cannot set response headers!");
        }

        public ResponseHeaders(HttpURLConnection httpurlconnection)
        {
            super(httpurlconnection);
        }
    }


    HttpUrlConnectionHelper()
    {
    }

    static IHeaders getRequestHeaders(HttpURLConnection httpurlconnection)
    {
        return new RequestHeaders(httpurlconnection);
    }

    static IHeaders getResponseHeaders(HttpURLConnection httpurlconnection)
    {
        return new ResponseHeaders(httpurlconnection);
    }
}
