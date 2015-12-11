// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class ParseHttpResponse
{
    public static class Builder extends Init
    {

        public ParseHttpResponse build()
        {
            return new ParseHttpResponse(this);
        }

        Builder self()
        {
            return this;
        }

        volatile Init self()
        {
            return self();
        }

        public Builder()
        {
        }
    }

    static abstract class Init
    {

        private InputStream content;
        private String contentType;
        private Map headers;
        private String reasonPhrase;
        private int statusCode;
        private int totalSize;

        abstract Init self();

        public Init setContent(InputStream inputstream)
        {
            content = inputstream;
            return self();
        }

        public Init setContentType(String s)
        {
            contentType = s;
            return self();
        }

        public Init setHeaders(Map map)
        {
            headers = Collections.unmodifiableMap(new HashMap(map));
            return self();
        }

        public Init setReasonPhase(String s)
        {
            reasonPhrase = s;
            return self();
        }

        public Init setStatusCode(int i)
        {
            statusCode = i;
            return self();
        }

        public Init setTotalSize(int i)
        {
            totalSize = i;
            return self();
        }







        Init()
        {
        }
    }


    InputStream content;
    String contentType;
    Map headers;
    String reasonPhrase;
    int statusCode;
    int totalSize;

    ParseHttpResponse(Init init)
    {
        statusCode = init.statusCode;
        content = init.content;
        totalSize = init.totalSize;
        reasonPhrase = init.reasonPhrase;
        headers = init.headers;
        contentType = init.contentType;
    }

    public Map getAllHeaders()
    {
        return headers;
    }

    public InputStream getContent()
    {
        return content;
    }

    public String getContentType()
    {
        return contentType;
    }

    public String getHeader(String s)
    {
        if (headers == null)
        {
            return null;
        } else
        {
            return (String)headers.get(s);
        }
    }

    public String getReasonPhrase()
    {
        return reasonPhrase;
    }

    public int getStatusCode()
    {
        return statusCode;
    }

    public int getTotalSize()
    {
        return totalSize;
    }
}
