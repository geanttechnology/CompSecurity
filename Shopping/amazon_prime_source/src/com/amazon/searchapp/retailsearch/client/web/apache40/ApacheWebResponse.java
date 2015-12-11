// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web.apache40;

import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.WebResponse;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public class ApacheWebResponse
    implements WebResponse
{

    private final HttpResponse response;

    ApacheWebResponse(HttpResponse httpresponse)
    {
        response = httpresponse;
    }

    public InputStream getContent()
        throws IOException
    {
        if (response.getEntity() != null)
        {
            return response.getEntity().getContent();
        } else
        {
            return null;
        }
    }

    public long getContentLength()
    {
        if (response.getEntity() != null)
        {
            return response.getEntity().getContentLength();
        } else
        {
            return -1L;
        }
    }

    public String getContentType()
    {
        if (response.getEntity() == null || response.getEntity().getContentType() == null)
        {
            return null;
        } else
        {
            return response.getEntity().getContentType().getValue();
        }
    }

    public CollectionMap getHeaders()
    {
        CollectionMap collectionmap = null;
        Header aheader[] = response.getAllHeaders();
        if (aheader != null)
        {
            CollectionMap collectionmap1 = new CollectionMap(aheader.length);
            int i = 0;
            do
            {
                collectionmap = collectionmap1;
                if (i >= aheader.length)
                {
                    break;
                }
                collectionmap1.add(aheader[i].getName(), aheader[i].getValue());
                i++;
            } while (true);
        }
        return collectionmap;
    }

    public int getStatusCode()
    {
        if (response.getStatusLine() != null)
        {
            return response.getStatusLine().getStatusCode();
        } else
        {
            return -1;
        }
    }

    public String getStatusLine()
    {
        if (response.getStatusLine() != null)
        {
            return response.getStatusLine().toString();
        } else
        {
            return null;
        }
    }
}
