// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.parse.signpost.http.HttpRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseHttpRequest, ParseHttpBody

class ParseHttpRequestOAuthAdapter
    implements HttpRequest
{

    private ParseHttpRequest request;

    public ParseHttpRequestOAuthAdapter(ParseHttpRequest parsehttprequest)
    {
        request = parsehttprequest;
    }

    public Map getAllHeaders()
    {
        return request.getAllHeaders();
    }

    public String getContentType()
    {
        if (request.getBody() == null)
        {
            return null;
        } else
        {
            return request.getBody().getContentType();
        }
    }

    public String getHeader(String s)
    {
        return request.getHeader(s);
    }

    public InputStream getMessagePayload()
        throws IOException
    {
        if (request.getBody() == null)
        {
            return null;
        } else
        {
            return request.getBody().getContent();
        }
    }

    public String getMethod()
    {
        return request.getMethod().toString();
    }

    public String getRequestUrl()
    {
        return request.getUrl();
    }

    public void setHeader(String s, String s1)
    {
        request = (new ParseHttpRequest.Builder(request)).addHeader(s, s1).build();
    }

    public void setRequestUrl(String s)
    {
        request = (new ParseHttpRequest.Builder(request)).setUrl(s).build();
    }

    public Object unwrap()
    {
        return request;
    }
}
