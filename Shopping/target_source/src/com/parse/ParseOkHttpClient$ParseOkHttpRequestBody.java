// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import c.d;
import com.h.b.r;
import com.h.b.v;
import com.parse.http.ParseHttpBody;
import java.io.IOException;

// Referenced classes of package com.parse:
//            ParseOkHttpClient

private static class parseBody extends v
{

    private ParseHttpBody parseBody;

    public long contentLength()
        throws IOException
    {
        return parseBody.getContentLength();
    }

    public r contentType()
    {
        if (parseBody.getContentType() == null)
        {
            return null;
        } else
        {
            return r.a(parseBody.getContentType());
        }
    }

    public ParseHttpBody getParseHttpBody()
    {
        return parseBody;
    }

    public void writeTo(d d1)
        throws IOException
    {
        parseBody.writeTo(d1.d());
    }

    public (ParseHttpBody parsehttpbody)
    {
        parseBody = parsehttpbody;
    }
}
