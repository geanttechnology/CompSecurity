// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import android.text.TextUtils;
import java.net.ProtocolException;
import java.util.HashMap;
import java.util.Locale;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpTrace;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            Connector

private static class _cls7
{
    private static interface HttpRequestTypeFactory
    {

        public abstract HttpRequestBase create(String s);
    }


    private static final HashMap entityEnclosingRequestBase;
    private static final HashMap requestBase;

    public static HttpEntityEnclosingRequestBase createEntityEnclosingRequest(String s, String s1)
        throws ProtocolException
    {
        Object obj = s1;
        s1 = ((String) (obj));
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            s1 = "POST";
        }
        obj = (HttpRequestTypeFactory)entityEnclosingRequestBase.get(s1.toUpperCase(Locale.US));
        if (obj == null)
        {
            throw new ProtocolException((new StringBuilder()).append("The request body is only supported by POST and PUT. Here a body was included for ").append(s1).toString());
        } else
        {
            return (HttpEntityEnclosingRequestBase)((HttpRequestTypeFactory) (obj)).create(s);
        }
    }

    public static HttpRequestBase createRequest(String s, String s1)
        throws ProtocolException
    {
        Object obj = s1;
        s1 = ((String) (obj));
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            s1 = "GET";
        }
        obj = (HttpRequestTypeFactory)requestBase.get(s1.toUpperCase(Locale.US));
        if (obj == null)
        {
            throw new ProtocolException((new StringBuilder()).append("Unexpected http method: ").append(s1).toString());
        } else
        {
            return ((HttpRequestTypeFactory) (obj)).create(s);
        }
    }

    static 
    {
        requestBase = new HashMap();
        entityEnclosingRequestBase = new HashMap();
        HttpRequestTypeFactory httprequesttypefactory = new HttpRequestTypeFactory() {

            public HttpGet create(String s)
            {
                return new HttpGet(s);
            }

            public volatile HttpRequestBase create(String s)
            {
                return create(s);
            }

        };
        HttpRequestTypeFactory httprequesttypefactory1 = new HttpRequestTypeFactory() {

            public HttpHead create(String s)
            {
                return new HttpHead(s);
            }

            public volatile HttpRequestBase create(String s)
            {
                return create(s);
            }

        };
        HttpRequestTypeFactory httprequesttypefactory2 = new HttpRequestTypeFactory() {

            public HttpOptions create(String s)
            {
                return new HttpOptions(s);
            }

            public volatile HttpRequestBase create(String s)
            {
                return create(s);
            }

        };
        HttpRequestTypeFactory httprequesttypefactory3 = new HttpRequestTypeFactory() {

            public volatile HttpRequestBase create(String s)
            {
                return create(s);
            }

            public HttpTrace create(String s)
            {
                return new HttpTrace(s);
            }

        };
        HttpRequestTypeFactory httprequesttypefactory4 = new HttpRequestTypeFactory() {

            public HttpDelete create(String s)
            {
                return new HttpDelete(s);
            }

            public volatile HttpRequestBase create(String s)
            {
                return create(s);
            }

        };
        HttpRequestTypeFactory httprequesttypefactory5 = new HttpRequestTypeFactory() {

            public HttpPost create(String s)
            {
                return new HttpPost(s);
            }

            public volatile HttpRequestBase create(String s)
            {
                return create(s);
            }

        };
        HttpRequestTypeFactory httprequesttypefactory6 = new HttpRequestTypeFactory() {

            public HttpPut create(String s)
            {
                return new HttpPut(s);
            }

            public volatile HttpRequestBase create(String s)
            {
                return create(s);
            }

        };
        requestBase.put("GET", httprequesttypefactory);
        requestBase.put("HEAD", httprequesttypefactory1);
        requestBase.put("OPTIONS", httprequesttypefactory2);
        requestBase.put("TRACE", httprequesttypefactory3);
        requestBase.put("DELETE", httprequesttypefactory4);
        requestBase.put("POST", httprequesttypefactory5);
        requestBase.put("PUT", httprequesttypefactory6);
        entityEnclosingRequestBase.put("POST", httprequesttypefactory5);
        entityEnclosingRequestBase.put("PUT", httprequesttypefactory6);
    }

    private _cls7()
    {
    }
}
