// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.http;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ParseHttpResponse
{
    public static final class Builder
    {

        private InputStream content;
        private String contentType;
        private Map headers;
        private String reasonPhrase;
        private int statusCode;
        private long totalSize;

        public Builder addHeader(String s, String s1)
        {
            headers.put(s, s1);
            return this;
        }

        public Builder addHeaders(Map map)
        {
            headers.putAll(map);
            return this;
        }

        public ParseHttpResponse build()
        {
            return new ParseHttpResponse(this);
        }

        public Builder setContent(InputStream inputstream)
        {
            content = inputstream;
            return this;
        }

        public Builder setContentType(String s)
        {
            contentType = s;
            return this;
        }

        public Builder setHeaders(Map map)
        {
            headers = new HashMap(map);
            return this;
        }

        public Builder setReasonPhrase(String s)
        {
            reasonPhrase = s;
            return this;
        }

        public Builder setStatusCode(int i)
        {
            statusCode = i;
            return this;
        }

        public Builder setTotalSize(long l)
        {
            totalSize = l;
            return this;
        }







        public Builder()
        {
            totalSize = -1L;
            headers = new HashMap();
        }

        public Builder(ParseHttpResponse parsehttpresponse)
        {
            setStatusCode(parsehttpresponse.getStatusCode());
            setContent(parsehttpresponse.getContent());
            setTotalSize(parsehttpresponse.getTotalSize());
            setContentType(parsehttpresponse.getContentType());
            setHeaders(parsehttpresponse.getAllHeaders());
            setReasonPhrase(parsehttpresponse.getReasonPhrase());
        }
    }


    private final InputStream content;
    private final String contentType;
    private final Map headers;
    private final String reasonPhrase;
    private final int statusCode;
    private final long totalSize;

    private ParseHttpResponse(Builder builder)
    {
        statusCode = builder.statusCode;
        content = builder.content;
        totalSize = builder.totalSize;
        reasonPhrase = builder.reasonPhrase;
        headers = Collections.unmodifiableMap(new HashMap(builder.headers));
        contentType = builder.contentType;
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
        return (String)headers.get(s);
    }

    public String getReasonPhrase()
    {
        return reasonPhrase;
    }

    public int getStatusCode()
    {
        return statusCode;
    }

    public long getTotalSize()
    {
        return totalSize;
    }
}
