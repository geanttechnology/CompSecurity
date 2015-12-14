// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.apache.commons.httpclient:
//            Header

public class HeaderGroup
{

    private List headers;

    public HeaderGroup()
    {
        headers = new ArrayList();
    }

    public void addHeader(Header header)
    {
        headers.add(header);
    }

    public void clear()
    {
        headers.clear();
    }

    public boolean containsHeader(String s)
    {
        for (Iterator iterator = headers.iterator(); iterator.hasNext();)
        {
            if (((Header)iterator.next()).getName().equalsIgnoreCase(s))
            {
                return true;
            }
        }

        return false;
    }

    public Header[] getAllHeaders()
    {
        return (Header[])(Header[])headers.toArray(new Header[headers.size()]);
    }

    public Header getCondensedHeader(String s)
    {
        Header aheader[] = getHeaders(s);
        if (aheader.length == 0)
        {
            return null;
        }
        if (aheader.length == 1)
        {
            return new Header(aheader[0].getName(), aheader[0].getValue());
        }
        StringBuffer stringbuffer = new StringBuffer(aheader[0].getValue());
        for (int i = 1; i < aheader.length; i++)
        {
            stringbuffer.append(", ");
            stringbuffer.append(aheader[i].getValue());
        }

        return new Header(s.toLowerCase(), stringbuffer.toString());
    }

    public Header getFirstHeader(String s)
    {
        for (Iterator iterator = headers.iterator(); iterator.hasNext();)
        {
            Header header = (Header)iterator.next();
            if (header.getName().equalsIgnoreCase(s))
            {
                return header;
            }
        }

        return null;
    }

    public Header[] getHeaders(String s)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = headers.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Header header = (Header)iterator.next();
            if (header.getName().equalsIgnoreCase(s))
            {
                arraylist.add(header);
            }
        } while (true);
        return (Header[])(Header[])arraylist.toArray(new Header[arraylist.size()]);
    }

    public Iterator getIterator()
    {
        return headers.iterator();
    }

    public Header getLastHeader(String s)
    {
        for (int i = headers.size() - 1; i >= 0; i--)
        {
            Header header = (Header)headers.get(i);
            if (header.getName().equalsIgnoreCase(s))
            {
                return header;
            }
        }

        return null;
    }

    public void removeHeader(Header header)
    {
        headers.remove(header);
    }

    public void setHeaders(Header aheader[])
    {
        clear();
        for (int i = 0; i < aheader.length; i++)
        {
            addHeader(aheader[i]);
        }

    }
}
