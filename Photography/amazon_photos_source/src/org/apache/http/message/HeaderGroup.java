// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.message;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;

// Referenced classes of package org.apache.http.message:
//            BasicListHeaderIterator

public class HeaderGroup
    implements Cloneable
{

    private List headers;

    public HeaderGroup()
    {
        headers = new ArrayList(16);
    }

    public void addHeader(Header header)
    {
        if (header == null)
        {
            return;
        } else
        {
            headers.add(header);
            return;
        }
    }

    public void clear()
    {
        headers.clear();
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        HeaderGroup headergroup = (HeaderGroup)super.clone();
        headergroup.headers = new ArrayList(headers);
        return headergroup;
    }

    public boolean containsHeader(String s)
    {
        for (int i = 0; i < headers.size(); i++)
        {
            if (((Header)headers.get(i)).getName().equalsIgnoreCase(s))
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

    public Header getFirstHeader(String s)
    {
        for (int i = 0; i < headers.size(); i++)
        {
            Header header = (Header)headers.get(i);
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
        for (int i = 0; i < headers.size(); i++)
        {
            Header header = (Header)headers.get(i);
            if (header.getName().equalsIgnoreCase(s))
            {
                arraylist.add(header);
            }
        }

        return (Header[])(Header[])arraylist.toArray(new Header[arraylist.size()]);
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

    public HeaderIterator iterator()
    {
        return new BasicListHeaderIterator(headers, null);
    }

    public HeaderIterator iterator(String s)
    {
        return new BasicListHeaderIterator(headers, s);
    }

    public void removeHeader(Header header)
    {
        if (header == null)
        {
            return;
        } else
        {
            headers.remove(header);
            return;
        }
    }

    public void setHeaders(Header aheader[])
    {
        clear();
        if (aheader != null)
        {
            int i = 0;
            while (i < aheader.length) 
            {
                headers.add(aheader[i]);
                i++;
            }
        }
    }

    public void updateHeader(Header header)
    {
        if (header == null)
        {
            return;
        }
        for (int i = 0; i < headers.size(); i++)
        {
            if (((Header)headers.get(i)).getName().equalsIgnoreCase(header.getName()))
            {
                headers.set(i, header);
                return;
            }
        }

        headers.add(header);
    }
}
