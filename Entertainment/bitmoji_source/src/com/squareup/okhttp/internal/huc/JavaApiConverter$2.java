// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.huc;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.StatusLine;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheResponse;
import java.util.Map;

// Referenced classes of package com.squareup.okhttp.internal.huc:
//            JavaApiConverter

static final class val.body extends CacheResponse
{

    final ResponseBody val$body;
    final Headers val$headers;
    final Response val$response;

    public InputStream getBody()
        throws IOException
    {
        if (val$body == null)
        {
            return null;
        } else
        {
            return val$body.byteStream();
        }
    }

    public Map getHeaders()
        throws IOException
    {
        return OkHeaders.toMultimap(val$headers, StatusLine.get(val$response).toString());
    }

    _cls9(Headers headers1, Response response1, ResponseBody responsebody)
    {
        val$headers = headers1;
        val$response = response1;
        val$body = responsebody;
        super();
    }
}
