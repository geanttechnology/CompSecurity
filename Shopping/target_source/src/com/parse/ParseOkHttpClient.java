// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.h;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import c.d;
import c.l;
import com.h.b.e;
import com.h.b.p;
import com.h.b.q;
import com.h.b.r;
import com.h.b.s;
import com.h.b.u;
import com.h.b.v;
import com.h.b.w;
import com.h.b.x;
import com.parse.http.ParseHttpBody;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import com.parse.http.ParseNetworkInterceptor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.parse:
//            ParseHttpClient, ParseByteArrayHttpBody

class ParseOkHttpClient extends ParseHttpClient
{
    private static class ParseOkHttpRequestBody extends v
    {

        private ParseHttpBody parseBody;

        public long contentLength()
            throws IOException
        {
            return parseBody.getContentLength();
        }

        public r contentType()
        {
            if (parseBody.getContentType() == null)
            {
                return null;
            } else
            {
                return r.a(parseBody.getContentType());
            }
        }

        public ParseHttpBody getParseHttpBody()
        {
            return parseBody;
        }

        public void writeTo(d d1)
            throws IOException
        {
            parseBody.writeTo(d1.d());
        }

        public ParseOkHttpRequestBody(ParseHttpBody parsehttpbody)
        {
            parseBody = parsehttpbody;
        }
    }


    private static final String OKHTTP_DELETE = "DELETE";
    private static final String OKHTTP_GET = "GET";
    private static final String OKHTTP_POST = "POST";
    private static final String OKHTTP_PUT = "PUT";
    private s okHttpClient;

    public ParseOkHttpClient(int i, SSLSessionCache sslsessioncache)
    {
        okHttpClient = new s();
        okHttpClient.a(i, TimeUnit.MILLISECONDS);
        okHttpClient.b(i, TimeUnit.MILLISECONDS);
        okHttpClient.a(false);
        okHttpClient.a(SSLCertificateSocketFactory.getDefault(i, sslsessioncache));
    }

    private ParseHttpRequest getParseHttpRequest(u u1)
    {
        com.parse.http.ParseHttpRequest.Builder builder;
        String s1;
        byte byte0;
        builder = new com.parse.http.ParseHttpRequest.Builder();
        s1 = u1.d();
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 4: default 64
    //                   70454: 126
    //                   79599: 171
    //                   2461856: 156
    //                   2012838315: 141;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        byte0;
        JVM INSTR tableswitch 0 3: default 96
    //                   0 186
    //                   1 278
    //                   2 289
    //                   3 300;
           goto _L6 _L7 _L8 _L9 _L10
_L6:
        throw new IllegalArgumentException((new StringBuilder()).append("Invalid http method ").append(u1.d()).toString());
_L2:
        if (s1.equals("GET"))
        {
            byte0 = 0;
        }
          goto _L1
_L5:
        if (s1.equals("DELETE"))
        {
            byte0 = 1;
        }
          goto _L1
_L4:
        if (s1.equals("POST"))
        {
            byte0 = 2;
        }
          goto _L1
_L3:
        if (s1.equals("PUT"))
        {
            byte0 = 3;
        }
          goto _L1
_L7:
        builder.setMethod(com.parse.http.ParseHttpRequest.Method.GET);
_L12:
        builder.setUrl(u1.c());
        java.util.Map.Entry entry;
        for (Iterator iterator = u1.e().toMultimap().entrySet().iterator(); iterator.hasNext(); builder.addHeader((String)entry.getKey(), (String)((List)entry.getValue()).get(0)))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        break; /* Loop/switch isn't completed */
_L8:
        builder.setMethod(com.parse.http.ParseHttpRequest.Method.DELETE);
        continue; /* Loop/switch isn't completed */
_L9:
        builder.setMethod(com.parse.http.ParseHttpRequest.Method.POST);
        continue; /* Loop/switch isn't completed */
_L10:
        builder.setMethod(com.parse.http.ParseHttpRequest.Method.PUT);
        if (true) goto _L12; else goto _L11
_L11:
        u1 = (ParseOkHttpRequestBody)u1.f();
        if (u1 != null)
        {
            builder.setBody(u1.getParseHttpBody());
        }
        return builder.build();
    }

    void addExternalInterceptor(final ParseNetworkInterceptor parseNetworkInterceptor)
    {
        okHttpClient.v().add(new q() {

            final ParseOkHttpClient this$0;
            final ParseNetworkInterceptor val$parseNetworkInterceptor;

            public w intercept(final com.h.b.q.a okHttpChain)
                throws IOException
            {
                Object obj = okHttpChain.a();
                final ParseHttpRequest parseRequest = getParseHttpRequest(((u) (obj)));
                obj = new h();
                okHttpChain = parseNetworkInterceptor.intercept(((_cls1) (obj)). new com.parse.http.ParseNetworkInterceptor.Chain() {

                    final _cls1 this$1;
                    final com.h.b.q.a val$okHttpChain;
                    final h val$okHttpResponseCapture;
                    final ParseHttpRequest val$parseRequest;

                    public ParseHttpRequest getRequest()
                    {
                        return parseRequest;
                    }

                    public ParseHttpResponse proceed(ParseHttpRequest parsehttprequest)
                        throws IOException
                    {
                        parsehttprequest = ParseOkHttpClient.this.getRequest(parsehttprequest);
                        parsehttprequest = okHttpChain.a(parsehttprequest);
                        okHttpResponseCapture.a(parsehttprequest);
                        return getResponse(parsehttprequest);
                    }

            
            {
                this$1 = final__pcls1;
                parseRequest = parsehttprequest;
                okHttpChain = a;
                okHttpResponseCapture = h.this;
                super();
            }
                });
                obj = ((w)((h) (obj)).a()).h();
                ((com.h.b.w.a) (obj)).code(okHttpChain.getStatusCode()).message(okHttpChain.getReasonPhrase());
                if (okHttpChain.getAllHeaders() != null)
                {
                    java.util.Map.Entry entry;
                    for (Iterator iterator = okHttpChain.getAllHeaders().entrySet().iterator(); iterator.hasNext(); ((com.h.b.w.a) (obj)).header((String)entry.getKey(), (String)entry.getValue()))
                    {
                        entry = (java.util.Map.Entry)iterator.next();
                    }

                }
                ((com.h.b.w.a) (obj)).body(okHttpChain. new x() {

                    final _cls1 this$1;
                    final ParseHttpResponse val$parseResponse;

                    public long contentLength()
                        throws IOException
                    {
                        return parseResponse.getTotalSize();
                    }

                    public r contentType()
                    {
                        if (parseResponse.getContentType() == null)
                        {
                            return null;
                        } else
                        {
                            return r.a(parseResponse.getContentType());
                        }
                    }

                    public c.e source()
                        throws IOException
                    {
                        if (parseResponse.getContent() == null)
                        {
                            return null;
                        } else
                        {
                            return l.a(l.a(parseResponse.getContent()));
                        }
                    }

            
            {
                this$1 = final__pcls1;
                parseResponse = ParseHttpResponse.this;
                super();
            }
                });
                return ((com.h.b.w.a) (obj)).build();
            }

            
            {
                this$0 = ParseOkHttpClient.this;
                parseNetworkInterceptor = parsenetworkinterceptor;
                super();
            }
        });
    }

    ParseHttpResponse executeInternal(ParseHttpRequest parsehttprequest)
        throws IOException
    {
        parsehttprequest = getRequest(parsehttprequest);
        return getResponse(okHttpClient.a(parsehttprequest).execute());
    }

    u getRequest(ParseHttpRequest parsehttprequest)
        throws IOException
    {
        com.h.b.u.a a;
        com.parse.http.ParseHttpRequest.Method method;
        a = new com.h.b.u.a();
        method = parsehttprequest.getMethod();
        static class _cls2
        {

            static final int $SwitchMap$com$parse$http$ParseHttpRequest$Method[];

            static 
            {
                $SwitchMap$com$parse$http$ParseHttpRequest$Method = new int[com.parse.http.ParseHttpRequest.Method.values().length];
                try
                {
                    $SwitchMap$com$parse$http$ParseHttpRequest$Method[com.parse.http.ParseHttpRequest.Method.GET.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$parse$http$ParseHttpRequest$Method[com.parse.http.ParseHttpRequest.Method.DELETE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$parse$http$ParseHttpRequest$Method[com.parse.http.ParseHttpRequest.Method.POST.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$parse$http$ParseHttpRequest$Method[com.parse.http.ParseHttpRequest.Method.PUT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.com.parse.http.ParseHttpRequest.Method[method.ordinal()];
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
        a.get();
_L6:
        Object obj;
        a.url(parsehttprequest.getUrl());
        obj = new com.h.b.p.a();
        java.util.Map.Entry entry;
        for (Iterator iterator = parsehttprequest.getAllHeaders().entrySet().iterator(); iterator.hasNext(); ((com.h.b.p.a) (obj)).a((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        break; /* Loop/switch isn't completed */
_L3:
        a.delete();
        if (true) goto _L6; else goto _L5
_L5:
        a.headers(((com.h.b.p.a) (obj)).a());
        obj = parsehttprequest.getBody();
        parsehttprequest = null;
        if (obj instanceof ParseByteArrayHttpBody)
        {
            parsehttprequest = new ParseOkHttpRequestBody(((ParseHttpBody) (obj)));
        }
        _cls2..SwitchMap.com.parse.http.ParseHttpRequest.Method[method.ordinal()];
        JVM INSTR tableswitch 3 4: default 248
    //                   3 262
    //                   4 253;
           goto _L7 _L8 _L9
_L7:
        return a.build();
_L9:
        a.put(parsehttprequest);
        continue; /* Loop/switch isn't completed */
_L8:
        a.post(parsehttprequest);
        if (true) goto _L7; else goto _L10
_L10:
    }

    volatile Object getRequest(ParseHttpRequest parsehttprequest)
        throws IOException
    {
        return getRequest(parsehttprequest);
    }

    ParseHttpResponse getResponse(w w1)
        throws IOException
    {
        int i = w1.c();
        java.io.InputStream inputstream = w1.g().byteStream();
        int j = (int)w1.g().contentLength();
        String s1 = w1.d();
        HashMap hashmap = new HashMap();
        String s2;
        for (Iterator iterator = w1.f().b().iterator(); iterator.hasNext(); hashmap.put(s2, w1.a(s2)))
        {
            s2 = (String)iterator.next();
        }

        Object obj = null;
        x x1 = w1.g();
        w1 = obj;
        if (x1 != null)
        {
            w1 = obj;
            if (x1.contentType() != null)
            {
                w1 = x1.contentType().toString();
            }
        }
        return (new com.parse.http.ParseHttpResponse.Builder()).setStatusCode(i).setContent(inputstream).setTotalSize(j).setReasonPhrase(s1).setHeaders(hashmap).setContentType(w1).build();
    }

    volatile ParseHttpResponse getResponse(Object obj)
        throws IOException
    {
        return getResponse((w)obj);
    }

}
