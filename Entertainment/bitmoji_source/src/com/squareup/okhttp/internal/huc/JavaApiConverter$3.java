// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.huc;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.http.OkHeaders;
import okio.BufferedSource;

// Referenced classes of package com.squareup.okhttp.internal.huc:
//            JavaApiConverter

static final class val.source extends ResponseBody
{

    final Headers val$okHeaders;
    final BufferedSource val$source;

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

    public BufferedSource source()
    {
        return val$source;
    }

    _cls9(Headers headers, BufferedSource bufferedsource)
    {
        val$okHeaders = headers;
        val$source = bufferedsource;
        super();
    }
}
