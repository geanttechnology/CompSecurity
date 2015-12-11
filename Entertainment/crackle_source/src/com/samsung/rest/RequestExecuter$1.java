// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.samsung.rest;

import android.util.Log;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.samsung.rest:
//            RequestExecuter

class RedirectHandler extends DefaultRedirectHandler
{

    final RequestExecuter this$0;

    public URI getLocationURI(HttpResponse httpresponse, HttpContext httpcontext)
        throws ProtocolException
    {
        httpcontext = super.getLocationURI(httpresponse, httpcontext);
        Log.d("RequestExecuter", (new StringBuilder("Redirect response status: ")).append(httpresponse.getStatusLine()).toString());
        Log.d("RequestExecuter", (new StringBuilder("Redirect: ")).append(httpcontext).toString());
        return httpcontext;
    }

    t()
    {
        this$0 = RequestExecuter.this;
        super();
    }
}
