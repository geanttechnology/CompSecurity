// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.apw;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import java.io.IOException;

// Referenced classes of package com.parse:
//            ParseOkHttpClient, ParseHttpBody

private static class parseBody extends RequestBody
{

    private ParseHttpBody parseBody;

    public long contentLength()
        throws IOException
    {
        return (long)parseBody.getContentLength();
    }

    public MediaType contentType()
    {
        if (parseBody.getContentType() == null)
        {
            return null;
        } else
        {
            return MediaType.parse(parseBody.getContentType());
        }
    }

    public void writeTo(apw apw1)
        throws IOException
    {
        parseBody.writeTo(apw1.c());
    }

    public (ParseHttpBody parsehttpbody)
    {
        parseBody = parsehttpbody;
    }
}
