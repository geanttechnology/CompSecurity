// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.internal.Platform;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Headers

public final class Request
{
    public static abstract class Body
    {

        public Body()
        {
        }
    }

    public static class Builder
    {

        private Body body;
        private Headers.Builder headers;
        private String method;
        private Object tag;
        private URL url;

        public Builder addHeader(String s, String s1)
        {
            headers.add(s, s1);
            return this;
        }

        public Request build()
        {
            if (url == null)
            {
                throw new IllegalStateException("url == null");
            } else
            {
                return new Request(this);
            }
        }

        public Builder header(String s, String s1)
        {
            headers.set(s, s1);
            return this;
        }

        public Builder method(String s, Body body1)
        {
            if (s == null || s.length() == 0)
            {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            } else
            {
                method = s;
                body = body1;
                return this;
            }
        }

        public Builder setUserAgent(String s)
        {
            return header("User-Agent", s);
        }

        public Builder url(URL url1)
        {
            if (url1 == null)
            {
                throw new IllegalArgumentException("url == null");
            } else
            {
                url = url1;
                return this;
            }
        }






        public Builder()
        {
            method = "GET";
            headers = new Headers.Builder();
        }

        private Builder(Request request)
        {
            url = request.url;
            method = request.method;
            body = request.body;
            tag = request.tag;
            headers = request.headers.newBuilder();
        }

    }

    private static class ParsedHeaders
    {

        private String proxyAuthorization;
        private String userAgent;



        public ParsedHeaders(Headers headers1)
        {
            int i = 0;
            while (i < headers1.size()) 
            {
                String s = headers1.name(i);
                String s1 = headers1.value(i);
                if ("User-Agent".equalsIgnoreCase(s))
                {
                    userAgent = s1;
                } else
                if ("Proxy-Authorization".equalsIgnoreCase(s))
                {
                    proxyAuthorization = s1;
                }
                i++;
            }
        }
    }


    private final Body body;
    private volatile CacheControl cacheControl;
    private final Headers headers;
    private final String method;
    private volatile ParsedHeaders parsedHeaders;
    private final Object tag;
    private volatile URI uri;
    private final URL url;

    private Request(Builder builder)
    {
        url = builder.url;
        method = builder.method;
        headers = builder.headers.build();
        body = builder.body;
        if (builder.tag != null)
        {
            builder = ((Builder) (builder.tag));
        } else
        {
            builder = this;
        }
        tag = builder;
    }


    private ParsedHeaders parsedHeaders()
    {
        ParsedHeaders parsedheaders = parsedHeaders;
        if (parsedheaders != null)
        {
            return parsedheaders;
        } else
        {
            ParsedHeaders parsedheaders1 = new ParsedHeaders(headers);
            parsedHeaders = parsedheaders1;
            return parsedheaders1;
        }
    }

    public Body body()
    {
        return body;
    }

    public CacheControl cacheControl()
    {
        CacheControl cachecontrol = cacheControl;
        if (cachecontrol != null)
        {
            return cachecontrol;
        } else
        {
            CacheControl cachecontrol1 = CacheControl.parse(headers);
            cacheControl = cachecontrol1;
            return cachecontrol1;
        }
    }

    public Headers getHeaders()
    {
        return headers;
    }

    public String getProxyAuthorization()
    {
        return parsedHeaders().proxyAuthorization;
    }

    public String getUserAgent()
    {
        return parsedHeaders().userAgent;
    }

    public String header(String s)
    {
        return headers.get(s);
    }

    public Headers headers()
    {
        return headers;
    }

    public boolean isHttps()
    {
        return url().getProtocol().equals("https");
    }

    public String method()
    {
        return method;
    }

    public Builder newBuilder()
    {
        return new Builder(this);
    }

    public URI uri()
        throws IOException
    {
        URI uri1;
        try
        {
            uri1 = uri;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            throw new IOException(urisyntaxexception.getMessage());
        }
        if (uri1 != null)
        {
            return uri1;
        }
        uri1 = Platform.get().toUriLenient(url);
        uri = uri1;
        return uri1;
    }

    public URL url()
    {
        return url;
    }





}
