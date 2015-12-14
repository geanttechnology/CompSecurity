// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.apache;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import java.io.IOException;
import okio.BufferedSink;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

final class HttpEntityBody extends RequestBody
{

    private static final MediaType DEFAULT_MEDIA_TYPE = MediaType.parse("application/octet-stream");
    private final HttpEntity entity;
    private final MediaType mediaType;

    HttpEntityBody(HttpEntity httpentity, String s)
    {
        entity = httpentity;
        if (s != null)
        {
            mediaType = MediaType.parse(s);
            return;
        }
        if (httpentity.getContentType() != null)
        {
            mediaType = MediaType.parse(httpentity.getContentType().getValue());
            return;
        } else
        {
            mediaType = DEFAULT_MEDIA_TYPE;
            return;
        }
    }

    public long contentLength()
    {
        return entity.getContentLength();
    }

    public MediaType contentType()
    {
        return mediaType;
    }

    public void writeTo(BufferedSink bufferedsink)
        throws IOException
    {
        entity.writeTo(bufferedsink.outputStream());
    }

}
