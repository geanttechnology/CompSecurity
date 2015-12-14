// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.http;

import java.util.Map;

public interface HttpClient
{
    public static final class HttpMethod extends Enum
    {

        private static final HttpMethod $VALUES[];
        public static final HttpMethod GET;
        public static final HttpMethod POST;

        public static HttpMethod valueOf(String s)
        {
            return (HttpMethod)Enum.valueOf(com/amazon/insights/core/http/HttpClient$HttpMethod, s);
        }

        public static HttpMethod[] values()
        {
            return (HttpMethod[])$VALUES.clone();
        }

        static 
        {
            GET = new HttpMethod("GET", 0);
            POST = new HttpMethod("POST", 1);
            $VALUES = (new HttpMethod[] {
                GET, POST
            });
        }

        private HttpMethod(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface Interceptor
    {

        public abstract void after(Response response);

        public abstract void before(Request request);
    }

    public static interface Request
    {

        public abstract Request addHeader(String s, String s1);

        public abstract Map getHeaders();

        public abstract HttpMethod getMethod();

        public abstract Map getParams();

        public abstract byte[] getPostBodyBytes();

        public abstract String getUrl();

        public abstract Request setMethod(HttpMethod httpmethod);

        public abstract Request setPostBody(String s);

        public abstract Request setPostBody(byte abyte0[]);

        public abstract Request setUrl(String s);
    }

    public static interface Response
    {

        public abstract Response addHeader(String s, String s1);

        public abstract int getCode();

        public abstract String getHeader(String s);

        public abstract String getMessage();

        public abstract Request getOriginatingRequest();

        public abstract long getRequestSize();

        public abstract String getResponse();

        public abstract long getResponseSize();

        public abstract Response setCode(int i);

        public abstract Response setMessage(String s);

        public abstract Response setOriginatingRequest(Request request);

        public abstract Response setRequestSize(long l);

        public abstract Response setResponse(String s);

        public abstract Response setResponseSize(long l);
    }


    public abstract void addInterceptor(Interceptor interceptor);

    public abstract Response execute(Request request, Integer integer);

    public abstract Request newRequest();
}
