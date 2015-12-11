// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.support.v7.apw;
import com.newrelic.agent.android.instrumentation.okhttp2.OkHttp2Instrumentation;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.parse:
//            ParseHttpClient, ParseHttpRequest, ParseByteArrayHttpBody, ParseHttpResponse, 
//            ParseHttpBody

class ParseOkHttpClient extends ParseHttpClient
{
    private static class CountingOkHttpRequestBody extends RequestBody
    {

        private ParseHttpBody parseBody;

        public long contentLength()
            throws IOException
        {
            return (long)parseBody.getContentLength();
        }

        public MediaType contentType()
        {
            if (parseBody.getContentType() == null)
            {
                return null;
            } else
            {
                return MediaType.parse(parseBody.getContentType());
            }
        }

        public void writeTo(apw apw1)
            throws IOException
        {
            parseBody.writeTo(apw1.c());
        }

        public CountingOkHttpRequestBody(ParseHttpBody parsehttpbody)
        {
            parseBody = parsehttpbody;
        }
    }


    private OkHttpClient okHttpClient;

    public ParseOkHttpClient(int i, SSLSessionCache sslsessioncache)
    {
        okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(i, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(i, TimeUnit.MILLISECONDS);
        okHttpClient.setFollowRedirects(false);
        okHttpClient.setSslSocketFactory(SSLCertificateSocketFactory.getDefault(i, sslsessioncache));
    }

    private static void setParseRequestCancelRunnable(ParseHttpRequest parsehttprequest, Call call)
    {
        parsehttprequest.setCancelRunnable(new Runnable(call) {

            final Call val$okHttpCall;

            public void run()
            {
                okHttpCall.cancel();
            }

            
            {
                okHttpCall = call;
                super();
            }
        });
    }

    ParseHttpResponse executeInternal(ParseHttpRequest parsehttprequest)
        throws IOException
    {
        Object obj = getRequest(parsehttprequest);
        OkHttpClient okhttpclient = okHttpClient;
        if (!(okhttpclient instanceof OkHttpClient))
        {
            obj = okhttpclient.newCall(((Request) (obj)));
        } else
        {
            obj = OkHttp2Instrumentation.newCall((OkHttpClient)okhttpclient, ((Request) (obj)));
        }
        setParseRequestCancelRunnable(parsehttprequest, ((Call) (obj)));
        return getResponse(((Call) (obj)).execute());
    }

    Request getRequest(ParseHttpRequest parsehttprequest)
        throws IOException
    {
        com.squareup.okhttp.Request.Builder builder;
        ParseRequest.Method method;
        builder = new com.squareup.okhttp.Request.Builder();
        method = parsehttprequest.getMethod();
        static class _cls2
        {

            static final int $SwitchMap$com$parse$ParseRequest$Method[];

            static 
            {
                $SwitchMap$com$parse$ParseRequest$Method = new int[ParseRequest.Method.values().length];
                try
                {
                    $SwitchMap$com$parse$ParseRequest$Method[ParseRequest.Method.GET.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$parse$ParseRequest$Method[ParseRequest.Method.DELETE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$parse$ParseRequest$Method[ParseRequest.Method.POST.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$parse$ParseRequest$Method[ParseRequest.Method.PUT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.com.parse.ParseRequest.Method[method.ordinal()];
        JVM INSTR tableswitch 1 4: default 52
    //                   1 82
    //                   2 172
    //                   3 87
    //                   4 87;
           goto _L1 _L2 _L3 _L4 _L4
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalStateException((new StringBuilder()).append("Unsupported http method ").append(method.toString()).toString());
_L2:
        builder.get();
_L6:
        Object obj;
        builder.url(parsehttprequest.getUrl());
        obj = new com.squareup.okhttp.Headers.Builder();
        java.util.Map.Entry entry;
        for (Iterator iterator = parsehttprequest.getAllHeaders().entrySet().iterator(); iterator.hasNext(); ((com.squareup.okhttp.Headers.Builder) (obj)).add((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        break; /* Loop/switch isn't completed */
_L3:
        builder.delete();
        if (true) goto _L6; else goto _L5
_L5:
        builder.headers(((com.squareup.okhttp.Headers.Builder) (obj)).build());
        obj = parsehttprequest.getBody();
        parsehttprequest = null;
        if (obj instanceof ParseByteArrayHttpBody)
        {
            parsehttprequest = new CountingOkHttpRequestBody(((ParseHttpBody) (obj)));
        }
        _cls2..SwitchMap.com.parse.ParseRequest.Method[method.ordinal()];
        JVM INSTR tableswitch 3 4: default 248
    //                   3 269
    //                   4 260;
           goto _L7 _L8 _L9
_L7:
        break; /* Loop/switch isn't completed */
_L8:
        break MISSING_BLOCK_LABEL_269;
_L10:
        if (!(builder instanceof com.squareup.okhttp.Request.Builder))
        {
            return builder.build();
        } else
        {
            return OkHttp2Instrumentation.build((com.squareup.okhttp.Request.Builder)builder);
        }
_L9:
        builder.put(parsehttprequest);
          goto _L10
        builder.post(parsehttprequest);
          goto _L10
    }

    volatile Object getRequest(ParseHttpRequest parsehttprequest)
        throws IOException
    {
        return getRequest(parsehttprequest);
    }

    ParseHttpResponse getResponse(Response response)
        throws IOException
    {
        int i = response.code();
        java.io.InputStream inputstream = response.body().byteStream();
        int j = (int)response.body().contentLength();
        String s = response.message();
        HashMap hashmap = new HashMap();
        String s1;
        for (Iterator iterator = response.headers().names().iterator(); iterator.hasNext(); hashmap.put(s1, response.header(s1)))
        {
            s1 = (String)iterator.next();
        }

        response = response.body();
        if (response != null && response.contentType() != null)
        {
            response = response.contentType().toString();
        } else
        {
            response = null;
        }
        return ((ParseHttpResponse.Builder)((ParseHttpResponse.Builder)((ParseHttpResponse.Builder)((ParseHttpResponse.Builder)((ParseHttpResponse.Builder)((ParseHttpResponse.Builder)(new ParseHttpResponse.Builder()).setStatusCode(i)).setContent(inputstream)).setTotalSize(j)).setReasonPhase(s)).setHeaders(hashmap)).setContentType(response)).build();
    }

    volatile ParseHttpResponse getResponse(Object obj)
        throws IOException
    {
        return getResponse((Response)obj);
    }
}
