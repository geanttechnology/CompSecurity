// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.common.io;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.google.userfeedback.android.api.common.io:
//            AndroidHttpClient

class <init>
    implements HttpRequestInterceptor
{

    final AndroidHttpClient this$0;

    public void process(HttpRequest httprequest, HttpContext httpcontext)
    {
        httpcontext = AndroidHttpClient.access$400(AndroidHttpClient.this);
        if (httpcontext != null && iguration.access._mth500(httpcontext) && (httprequest instanceof HttpUriRequest))
        {
            iguration.access._mth700(httpcontext, AndroidHttpClient.access$600((HttpUriRequest)httprequest));
        }
    }

    private iguration()
    {
        this$0 = AndroidHttpClient.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
