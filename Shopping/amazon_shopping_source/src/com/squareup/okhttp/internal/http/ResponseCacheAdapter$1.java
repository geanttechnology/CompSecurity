// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.MediaType;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            ResponseCacheAdapter, OkHeaders, Headers

static final class val.body extends val.body
{

    final InputStream val$body;
    final Headers val$okHeaders;

    public InputStream byteStream()
    {
        return val$body;
    }

    public long contentLength()
    {
        return OkHeaders.contentLength(val$okHeaders);
    }

    public MediaType contentType()
    {
        String s = val$okHeaders.get("Content-Type");
        if (s == null)
        {
            return null;
        } else
        {
            return MediaType.parse(s);
        }
    }

    public boolean ready()
        throws IOException
    {
        return true;
    }

    (Headers headers, InputStream inputstream)
    {
        val$okHeaders = headers;
        val$body = inputstream;
        super();
    }
}
