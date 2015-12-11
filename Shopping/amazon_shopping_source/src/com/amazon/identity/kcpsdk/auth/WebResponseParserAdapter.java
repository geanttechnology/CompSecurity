// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.kcpsdk.common.IWebResponseParser;
import com.amazon.identity.kcpsdk.common.ParseError;
import com.amazon.identity.kcpsdk.common.WebResponseHeaders;
import com.amazon.identity.kcpsdk.common.WebResponseParser;

public class WebResponseParserAdapter
    implements IWebResponseParser
{

    protected WebResponseParser mParser;

    public WebResponseParserAdapter(WebResponseParser webresponseparser)
    {
        mParser = webresponseparser;
    }

    public void beginParse(WebResponseHeaders webresponseheaders)
    {
        if (mParser != null)
        {
            mParser.beginParse(webresponseheaders);
        }
    }

    public ParseError endParse()
    {
        if (mParser != null)
        {
            return mParser.endParse();
        } else
        {
            return null;
        }
    }

    public ParseError getParseError()
    {
        if (mParser != null)
        {
            return mParser.getParseError();
        } else
        {
            return null;
        }
    }

    public Object getParsedResponse()
    {
        if (mParser != null)
        {
            return mParser.getParsedResponse();
        } else
        {
            return null;
        }
    }

    public ParseError parseBodyChunk(byte abyte0[], int i)
    {
        if (mParser != null)
        {
            return mParser.parseBodyChunk(abyte0, i);
        } else
        {
            return null;
        }
    }

    public boolean shouldParseBody()
    {
        if (mParser != null)
        {
            return mParser.shouldParseBody();
        } else
        {
            return false;
        }
    }
}
