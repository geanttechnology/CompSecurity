// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseSource;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            StatusLine, Response, Request, Headers, 
//            HttpDate, HeaderParser, OkHeaders

public final class CacheStrategy
{
    public static class Factory
    {

        private int ageSeconds;
        final Response cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        final long nowMillis;
        private long receivedResponseMillis;
        final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        private long cacheResponseAge()
        {
            long l = 0L;
            if (servedDate != null)
            {
                l = Math.max(0L, receivedResponseMillis - servedDate.getTime());
            }
            if (ageSeconds != -1)
            {
                l = Math.max(l, TimeUnit.SECONDS.toMillis(ageSeconds));
            }
            return l + (receivedResponseMillis - sentRequestMillis) + (nowMillis - receivedResponseMillis);
        }

        private long computeFreshnessLifetime()
        {
            long l1 = 0L;
            CacheControl cachecontrol = cacheResponse.cacheControl();
            long l;
            if (cachecontrol.maxAgeSeconds() != -1)
            {
                l = TimeUnit.SECONDS.toMillis(cachecontrol.maxAgeSeconds());
            } else
            {
                if (expires != null)
                {
                    if (servedDate != null)
                    {
                        l = servedDate.getTime();
                    } else
                    {
                        l = receivedResponseMillis;
                    }
                    l = expires.getTime() - l;
                    if (l <= 0L)
                    {
                        l = 0L;
                    }
                    return l;
                }
                l = l1;
                if (lastModified != null)
                {
                    l = l1;
                    if (cacheResponse.request().url().getQuery() == null)
                    {
                        long l2;
                        if (servedDate != null)
                        {
                            l = servedDate.getTime();
                        } else
                        {
                            l = sentRequestMillis;
                        }
                        l2 = l - lastModified.getTime();
                        l = l1;
                        if (l2 > 0L)
                        {
                            return l2 / 10L;
                        }
                    }
                }
            }
            return l;
        }

        private CacheStrategy getCandidate()
        {
            if (cacheResponse == null)
            {
                return new CacheStrategy(request, cacheResponse, ResponseSource.NETWORK);
            }
            if (request.isHttps() && cacheResponse.handshake() == null)
            {
                return new CacheStrategy(request, cacheResponse, ResponseSource.NETWORK);
            }
            if (!CacheStrategy.isCacheable(cacheResponse, request))
            {
                return new CacheStrategy(request, cacheResponse, ResponseSource.NETWORK);
            }
            Object obj = request.cacheControl();
            if (((CacheControl) (obj)).noCache() || hasConditions(request))
            {
                return new CacheStrategy(request, cacheResponse, ResponseSource.NETWORK);
            }
            long l4 = cacheResponseAge();
            long l1 = computeFreshnessLifetime();
            long l = l1;
            if (((CacheControl) (obj)).maxAgeSeconds() != -1)
            {
                l = Math.min(l1, TimeUnit.SECONDS.toMillis(((CacheControl) (obj)).maxAgeSeconds()));
            }
            l1 = 0L;
            if (((CacheControl) (obj)).minFreshSeconds() != -1)
            {
                l1 = TimeUnit.SECONDS.toMillis(((CacheControl) (obj)).minFreshSeconds());
            }
            long l3 = 0L;
            Object obj1 = cacheResponse.cacheControl();
            long l2 = l3;
            if (!((CacheControl) (obj1)).mustRevalidate())
            {
                l2 = l3;
                if (((CacheControl) (obj)).maxStaleSeconds() != -1)
                {
                    l2 = TimeUnit.SECONDS.toMillis(((CacheControl) (obj)).maxStaleSeconds());
                }
            }
            if (!((CacheControl) (obj1)).noCache() && l4 + l1 < l + l2)
            {
                obj = cacheResponse.newBuilder().setResponseSource(ResponseSource.CACHE);
                if (l4 + l1 >= l)
                {
                    ((Response.Builder) (obj)).addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                }
                if (l4 > 0x5265c00L && isFreshnessLifetimeHeuristic())
                {
                    ((Response.Builder) (obj)).addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                }
                return new CacheStrategy(request, ((Response.Builder) (obj)).build(), ResponseSource.CACHE);
            }
            obj = request.newBuilder();
            if (lastModified != null)
            {
                ((Request.Builder) (obj)).header("If-Modified-Since", lastModifiedString);
            } else
            if (servedDate != null)
            {
                ((Request.Builder) (obj)).header("If-Modified-Since", servedDateString);
            }
            if (etag != null)
            {
                ((Request.Builder) (obj)).header("If-None-Match", etag);
            }
            obj1 = ((Request.Builder) (obj)).build();
            if (hasConditions(((Request) (obj1))))
            {
                obj = ResponseSource.CONDITIONAL_CACHE;
            } else
            {
                obj = ResponseSource.NETWORK;
            }
            return new CacheStrategy(((Request) (obj1)), cacheResponse, ((ResponseSource) (obj)));
        }

        private static boolean hasConditions(Request request1)
        {
            return request1.header("If-Modified-Since") != null || request1.header("If-None-Match") != null;
        }

        private boolean isFreshnessLifetimeHeuristic()
        {
            return cacheResponse.cacheControl().maxAgeSeconds() == -1 && expires == null;
        }

        public CacheStrategy get()
        {
            CacheStrategy cachestrategy = getCandidate();
            Object obj = cachestrategy;
            if (cachestrategy.source != ResponseSource.CACHE)
            {
                obj = cachestrategy;
                if (request.cacheControl().onlyIfCached())
                {
                    obj = (new Response.Builder()).request(cachestrategy.request).statusLine(CacheStrategy.GATEWAY_TIMEOUT_STATUS_LINE).setResponseSource(ResponseSource.NONE).body(CacheStrategy.EMPTY_BODY).build();
                    obj = new CacheStrategy(cachestrategy.request, ((Response) (obj)), ResponseSource.NONE);
                }
            }
            return ((CacheStrategy) (obj));
        }

        public Factory(long l, Request request1, Response response1)
        {
            ageSeconds = -1;
            nowMillis = l;
            request = request1;
            cacheResponse = response1;
            if (response1 != null)
            {
                int i = 0;
                while (i < response1.headers().size()) 
                {
                    request1 = response1.headers().name(i);
                    String s = response1.headers().value(i);
                    if ("Date".equalsIgnoreCase(request1))
                    {
                        servedDate = HttpDate.parse(s);
                        servedDateString = s;
                    } else
                    if ("Expires".equalsIgnoreCase(request1))
                    {
                        expires = HttpDate.parse(s);
                    } else
                    if ("Last-Modified".equalsIgnoreCase(request1))
                    {
                        lastModified = HttpDate.parse(s);
                        lastModifiedString = s;
                    } else
                    if ("ETag".equalsIgnoreCase(request1))
                    {
                        etag = s;
                    } else
                    if ("Age".equalsIgnoreCase(request1))
                    {
                        ageSeconds = HeaderParser.parseSeconds(s);
                    } else
                    if (OkHeaders.SENT_MILLIS.equalsIgnoreCase(request1))
                    {
                        sentRequestMillis = Long.parseLong(s);
                    } else
                    if (OkHeaders.RECEIVED_MILLIS.equalsIgnoreCase(request1))
                    {
                        receivedResponseMillis = Long.parseLong(s);
                    }
                    i++;
                }
            }
        }
    }


    private static final Response.Body EMPTY_BODY = new Response.Body() {

        public InputStream byteStream()
        {
            return Util.EMPTY_INPUT_STREAM;
        }

        public long contentLength()
        {
            return 0L;
        }

        public MediaType contentType()
        {
            return null;
        }

        public boolean ready()
            throws IOException
        {
            return true;
        }

    };
    private static final StatusLine GATEWAY_TIMEOUT_STATUS_LINE;
    public final Request request;
    public final Response response;
    public final ResponseSource source;

    private CacheStrategy(Request request1, Response response1, ResponseSource responsesource)
    {
        request = request1;
        response = response1;
        source = responsesource;
    }


    public static boolean isCacheable(Response response1, Request request1)
    {
        int i = response1.code();
        if (i == 200 || i == 203 || i == 300 || i == 301 || i == 410)
        {
            response1 = response1.cacheControl();
            if ((request1.header("Authorization") == null || response1.isPublic() || response1.mustRevalidate() || response1.sMaxAgeSeconds() != -1) && !response1.noStore())
            {
                return true;
            }
        }
        return false;
    }

    static 
    {
        try
        {
            GATEWAY_TIMEOUT_STATUS_LINE = new StatusLine("HTTP/1.1 504 Gateway Timeout");
        }
        catch (IOException ioexception)
        {
            throw new AssertionError();
        }
    }


}
