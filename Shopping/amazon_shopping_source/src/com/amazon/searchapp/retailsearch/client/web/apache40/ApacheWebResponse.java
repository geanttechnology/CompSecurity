// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web.apache40;

import com.amazon.searchapp.retailsearch.client.web.WebResponse;
import java.io.IOException;
import java.io.InputStream;
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
