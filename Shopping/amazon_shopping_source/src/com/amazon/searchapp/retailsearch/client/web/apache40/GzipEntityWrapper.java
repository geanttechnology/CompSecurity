// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web.apache40;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

public class GzipEntityWrapper extends HttpEntityWrapper
{

    public GzipEntityWrapper(HttpEntity httpentity)
    {
        super(httpentity);
    }

    public InputStream getContent()
        throws IOException
    {
        return new GZIPInputStream(wrappedEntity.getContent());
    }

    public long getContentLength()
    {
        return -1L;
    }
}
