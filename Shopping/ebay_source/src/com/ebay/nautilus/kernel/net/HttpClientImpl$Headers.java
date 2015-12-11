// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import java.util.Iterator;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpMessage;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            IHeaders, HttpClientImpl, IHeader

private static final class message
    implements IHeaders
{
    static final class Header
        implements IHeader
    {

        private final org.apache.http.Header h;

        public String getName()
        {
            return h.getName();
        }

        public String getValue()
        {
            return h.getValue();
        }

        public Header(org.apache.http.Header header)
        {
            h = header;
        }
    }

    private static final class HeaderIterator
        implements Iterator
    {

        private final int count;
        private final org.apache.http.Header headers[];
        private int index;

        public boolean hasNext()
        {
            return index < count;
        }

        public IHeader next()
        {
            org.apache.http.Header aheader[] = headers;
            int i = index;
            index = i + 1;
            return new Header(aheader[i]);
        }

        public volatile Object next()
        {
            return next();
        }

        public void remove()
        {
            throw new RuntimeException("Not allowed");
        }

        public HeaderIterator(org.apache.http.Header aheader[])
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


    private final HttpMessage message;

    public Map getAllHeaders()
    {
        return HttpClientImpl.getHeaderMap(message.getAllHeaders());
    }

    public String getFirstHeader(String s)
    {
        s = message.getFirstHeader(s);
        if (s != null)
        {
            return s.getValue();
        } else
        {
            return null;
        }
    }

    public String getLastHeader(String s)
    {
        s = message.getLastHeader(s);
        if (s != null)
        {
            return s.getValue();
        } else
        {
            return null;
        }
    }

    public Iterator iterator()
    {
        return new HeaderIterator(message.getAllHeaders());
    }

    public void setHeader(String s, String s1)
    {
        message.setHeader(s, s1);
    }

    public HeaderIterator.count(HttpMessage httpmessage)
    {
        message = httpmessage;
    }
}
