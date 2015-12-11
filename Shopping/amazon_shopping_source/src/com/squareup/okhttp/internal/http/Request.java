// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.okio.BufferedSink;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Headers

public final class Request
{
    public static abstract class Body
    {

        public static Body create(MediaType mediatype, File file)
        {
            if (mediatype == null)
            {
                throw new NullPointerException("contentType == null");
            }
            if (file == null)
            {
                throw new NullPointerException("content == null");
            } else
            {
                return new Body(mediatype, file) {

                    final MediaType val$contentType;
                    final File val$file;

                    public long contentLength()
                    {
                        return file.length();
                    }

                    public MediaType contentType()
                    {
                        return contentType;
                    }

                    public void writeTo(BufferedSink bufferedsink)
                        throws IOException
                    {
                        Object obj1;
                        long l;
                        l = contentLength();
                        if (l == 0L)
                        {
                            return;
                        }
                        obj1 = null;
                        Object obj = new FileInputStream(file);
                        obj1 = new byte[(int)Math.min(8192L, l)];
_L3:
                        int i = ((InputStream) (obj)).read(((byte []) (obj1)));
                        if (i == -1) goto _L2; else goto _L1
_L1:
                        bufferedsink.write(((byte []) (obj1)), 0, i);
                          goto _L3
                        obj1;
                        bufferedsink = ((BufferedSink) (obj));
                        obj = obj1;
_L5:
                        Util.closeQuietly(bufferedsink);
                        throw obj;
_L2:
                        Util.closeQuietly(((java.io.Closeable) (obj)));
                        return;
                        obj;
                        bufferedsink = ((BufferedSink) (obj1));
                        if (true) goto _L5; else goto _L4
_L4:
                    }

            
            {
                contentType = mediatype;
                file = file1;
                super();
            }
                };
            }
        }

        public static Body create(MediaType mediatype, String s)
        {
            if (mediatype.charset() == null)
            {
                mediatype = MediaType.parse((new StringBuilder()).append(mediatype).append("; charset=utf-8").toString());
            }
            try
            {
                mediatype = create(mediatype, s.getBytes(mediatype.charset().name()));
            }
            // Misplaced declaration of an exception variable
            catch (MediaType mediatype)
            {
                throw new AssertionError();
            }
            return mediatype;
        }

        public static Body create(MediaType mediatype, byte abyte0[])
        {
            if (mediatype == null)
            {
                throw new NullPointerException("contentType == null");
            }
            if (abyte0 == null)
            {
                throw new NullPointerException("content == null");
            } else
            {
                return new Body(mediatype, abyte0) {

                    final byte val$content[];
                    final MediaType val$contentType;

                    public long contentLength()
                    {
                        return (long)content.length;
                    }

                    public MediaType contentType()
                    {
                        return contentType;
                    }

                    public void writeTo(BufferedSink bufferedsink)
                        throws IOException
                    {
                        bufferedsink.write(content);
                    }

            
            {
                contentType = mediatype;
                content = abyte0;
                super();
            }
                };
            }
        }

        public long contentLength()
        {
            return -1L;
        }

        public abstract MediaType contentType();

        public abstract void writeTo(BufferedSink bufferedsink)
            throws IOException;

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

        public Builder get()
        {
            return method("GET", null);
        }

        public Builder head()
        {
            return method("HEAD", null);
        }

        public Builder header(String s, String s1)
        {
            headers.set(s, s1);
            return this;
        }

        public Builder headers(Headers headers1)
        {
            headers = headers1.newBuilder();
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

        public Builder post(Body body1)
        {
            return method("POST", body1);
        }

        public Builder put(Body body1)
        {
            return method("PUT", body1);
        }

        public Builder removeHeader(String s)
        {
            headers.removeAll(s);
            return this;
        }

        public Builder setUserAgent(String s)
        {
            return header("User-Agent", s);
        }

        public Builder tag(Object obj)
        {
            tag = obj;
            return this;
        }

        public Builder url(String s)
        {
            Builder builder;
            try
            {
                builder = url(new URL(s));
            }
            catch (MalformedURLException malformedurlexception)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Malformed URL: ").append(s).toString());
            }
            return builder;
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

    public List headers(String s)
    {
        return headers.values(s);
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

    public Object tag()
    {
        return tag;
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

    public String urlString()
    {
        return url.toString();
    }





}
