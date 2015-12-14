// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.OkHeaders;
import okio.f;

// Referenced classes of package com.squareup.okhttp:
//            ResponseBody, Response, MediaType

class source extends ResponseBody
{

    private final Response response;
    private final f source;

    public long contentLength()
    {
        return OkHeaders.contentLength(response);
    }

    public MediaType contentType()
    {
        String s = response.header("Content-Type");
        if (s != null)
        {
            return MediaType.parse(s);
        } else
        {
            return null;
        }
    }

    public f source()
    {
        return source;
    }

    s(Response response1, f f)
    {
        response = response1;
        source = f;
    }
}
