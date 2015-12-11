// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.ResponseSource;
import com.squareup.okhttp.internal.okio.Okio;
import com.squareup.okhttp.internal.okio.Source;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            StatusLine, Headers, Request, OkHeaders, 
//            HttpDate

public final class Response
{
    public static abstract class Body
        implements Closeable
    {

        private Source source;

        public abstract InputStream byteStream();

        public void close()
            throws IOException
        {
            byteStream().close();
        }

        public Source source()
        {
            Source source1 = source;
            if (source1 != null)
            {
                return source1;
            } else
            {
                Source source2 = Okio.source(byteStream());
                source = source2;
                return source2;
            }
        }

        public Body()
        {
        }
    }

    public static class Builder
    {

        private Body body;
        private Handshake handshake;
        private Headers.Builder headers;
        private Response redirectedBy;
        private Request request;
        private StatusLine statusLine;

        public Builder addHeader(String s, String s1)
        {
            headers.add(s, s1);
            return this;
        }

        public Builder body(Body body1)
        {
            body = body1;
            return this;
        }

        public Response build()
        {
            if (request == null)
            {
                throw new IllegalStateException("request == null");
            }
            if (statusLine == null)
            {
                throw new IllegalStateException("statusLine == null");
            } else
            {
                return new Response(this);
            }
        }

        public Builder handshake(Handshake handshake1)
        {
            handshake = handshake1;
            return this;
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

        public Builder removeHeader(String s)
        {
            headers.removeAll(s);
            return this;
        }

        public Builder request(Request request1)
        {
            request = request1;
            return this;
        }

        public Builder setResponseSource(ResponseSource responsesource)
        {
            return header(OkHeaders.RESPONSE_SOURCE, (new StringBuilder()).append(responsesource).append(" ").append(statusLine.code()).toString());
        }

        public Builder statusLine(StatusLine statusline)
        {
            if (statusline == null)
            {
                throw new IllegalArgumentException("statusLine == null");
            } else
            {
                statusLine = statusline;
                return this;
            }
        }

        public Builder statusLine(String s)
        {
            try
            {
                s = statusLine(new StatusLine(s));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new IllegalArgumentException(s);
            }
            return s;
        }







        public Builder()
        {
            headers = new Headers.Builder();
        }

        private Builder(Response response)
        {
            request = response.request;
            statusLine = response.statusLine;
            handshake = response.handshake;
            headers = response.headers.newBuilder();
            body = response.body;
            redirectedBy = response.redirectedBy;
        }

    }

    private static class ParsedHeaders
    {

        Date lastModified;
        private Set varyFields;

        private ParsedHeaders(Headers headers1)
        {
            varyFields = Collections.emptySet();
            int i = 0;
            while (i < headers1.size()) 
            {
                String s = headers1.name(i);
                String s1 = headers1.value(i);
                if ("Last-Modified".equalsIgnoreCase(s))
                {
                    lastModified = HttpDate.parse(s1);
                } else
                if ("Vary".equalsIgnoreCase(s))
                {
                    if (varyFields.isEmpty())
                    {
                        varyFields = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                    }
                    String as[] = s1.split(",");
                    int k = as.length;
                    int j = 0;
                    while (j < k) 
                    {
                        String s2 = as[j];
                        varyFields.add(s2.trim());
                        j++;
                    }
                }
                i++;
            }
        }

    }


    private final Body body;
    private volatile CacheControl cacheControl;
    private final Handshake handshake;
    private final Headers headers;
    private volatile ParsedHeaders parsedHeaders;
    private final Response redirectedBy;
    private final Request request;
    private final StatusLine statusLine;

    private Response(Builder builder)
    {
        request = builder.request;
        statusLine = builder.statusLine;
        handshake = builder.handshake;
        headers = builder.headers.build();
        body = builder.body;
        redirectedBy = builder.redirectedBy;
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

    public int code()
    {
        return statusLine.code();
    }

    public Handshake handshake()
    {
        return handshake;
    }

    public String header(String s)
    {
        return header(s, null);
    }

    public String header(String s, String s1)
    {
        s = headers.get(s);
        if (s != null)
        {
            return s;
        } else
        {
            return s1;
        }
    }

    public Headers headers()
    {
        return headers;
    }

    public int httpMinorVersion()
    {
        return statusLine.httpMinorVersion();
    }

    public Builder newBuilder()
    {
        return new Builder(this);
    }

    public Request request()
    {
        return request;
    }

    public String statusLine()
    {
        return statusLine.getStatusLine();
    }

    public String statusMessage()
    {
        return statusLine.message();
    }

    public boolean validate(Response response)
    {
        if (response.code() != 304)
        {
            response = response.parsedHeaders();
            if (parsedHeaders().lastModified == null || ((ParsedHeaders) (response)).lastModified == null || ((ParsedHeaders) (response)).lastModified.getTime() >= parsedHeaders().lastModified.getTime())
            {
                return false;
            }
        }
        return true;
    }






}
