// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web.apache40;

import com.amazon.searchapp.retailsearch.client.web.RequestContent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.AbstractHttpEntity;

public class StreamableEntity extends AbstractHttpEntity
{

    private final RequestContent content;

    StreamableEntity(RequestContent requestcontent)
    {
        content = requestcontent;
    }

    public InputStream getContent()
    {
        throw new UnsupportedOperationException();
    }

    public long getContentLength()
    {
        return content.getLength();
    }

    public boolean isRepeatable()
    {
        return content.isRepeatable();
    }

    public boolean isStreaming()
    {
        return true;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        if (content != null)
        {
            content.writeTo(outputstream);
        }
    }
}
