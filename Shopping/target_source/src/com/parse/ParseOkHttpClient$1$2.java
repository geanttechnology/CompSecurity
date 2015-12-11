// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.h;
import c.e;
import c.l;
import com.h.b.q;
import com.h.b.r;
import com.h.b.w;
import com.h.b.x;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import com.parse.http.ParseNetworkInterceptor;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.parse:
//            ParseOkHttpClient

class  extends x
{

    final .getContent this$1;
    final ParseHttpResponse val$parseResponse;

    public long contentLength()
        throws IOException
    {
        return val$parseResponse.getTotalSize();
    }

    public r contentType()
    {
        if (val$parseResponse.getContentType() == null)
        {
            return null;
        } else
        {
            return r.a(val$parseResponse.getContentType());
        }
    }

    public e source()
        throws IOException
    {
        if (val$parseResponse.getContent() == null)
        {
            return null;
        } else
        {
            return l.a(l.a(val$parseResponse.getContent()));
        }
    }

    ()
    {
        this$1 = final_;
        val$parseResponse = ParseHttpResponse.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseOkHttpClient$1

/* anonymous class */
    class ParseOkHttpClient._cls1
        implements q
    {

        final ParseOkHttpClient this$0;
        final ParseNetworkInterceptor val$parseNetworkInterceptor;

        public w intercept(final com.h.b.q.a okHttpChain)
            throws IOException
        {
            final h okHttpResponseCapture = okHttpChain.a();
            final ParseHttpRequest parseRequest = ParseOkHttpClient.access$000(ParseOkHttpClient.this, okHttpResponseCapture);
            okHttpResponseCapture = new h();
            okHttpChain = parseNetworkInterceptor.intercept(new ParseOkHttpClient._cls1._cls1());
            okHttpResponseCapture = ((w)okHttpResponseCapture.a()).h();
            okHttpResponseCapture.code(okHttpChain.getStatusCode()).message(okHttpChain.getReasonPhrase());
            if (okHttpChain.getAllHeaders() != null)
            {
                java.util.Map.Entry entry;
                for (Iterator iterator = okHttpChain.getAllHeaders().entrySet().iterator(); iterator.hasNext(); okHttpResponseCapture.header((String)entry.getKey(), (String)entry.getValue()))
                {
                    entry = (java.util.Map.Entry)iterator.next();
                }

            }
            okHttpResponseCapture.body(okHttpChain. new ParseOkHttpClient._cls1._cls2());
            return okHttpResponseCapture.build();
        }

            
            {
                this$0 = final_parseokhttpclient;
                parseNetworkInterceptor = ParseNetworkInterceptor.this;
                super();
            }

        // Unreferenced inner class com/parse/ParseOkHttpClient$1$1

/* anonymous class */
        class ParseOkHttpClient._cls1._cls1
            implements com.parse.http.ParseNetworkInterceptor.Chain
        {

            final ParseOkHttpClient._cls1 this$1;
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
                        this$1 = ParseOkHttpClient._cls1.this;
                        parseRequest = parsehttprequest;
                        okHttpChain = a;
                        okHttpResponseCapture = h1;
                        super();
                    }
        }

    }

}
