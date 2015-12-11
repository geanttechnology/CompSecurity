// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.kcpsdk.common.IWebResponseParser;
import com.amazon.identity.kcpsdk.common.ParseError;
import com.amazon.identity.kcpsdk.common.WebResponseHeaders;

public class HttpHeaderWebResponseParser
    implements IWebResponseParser
{

    private ParseError mParseError;

    public HttpHeaderWebResponseParser()
    {
        mParseError = ParseError.ParseErrorNoError;
    }

    public void beginParse(WebResponseHeaders webresponseheaders)
    {
        long l = webresponseheaders.getStatusCode();
        if (l < 200L || l >= 300L)
        {
            mParseError = ParseError.ParseErrorHttpError;
        }
    }

    public ParseError endParse()
    {
        return mParseError;
    }

    public ParseError getParseError()
    {
        return mParseError;
    }

    public Object getParsedResponse()
    {
        return null;
    }

    public ParseError parseBodyChunk(byte abyte0[], int i)
    {
        return mParseError;
    }

    public boolean shouldParseBody()
    {
        return false;
    }
}
