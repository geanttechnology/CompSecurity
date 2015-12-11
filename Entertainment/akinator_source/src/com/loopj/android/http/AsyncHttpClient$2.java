// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.protocol.HttpContext;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpClient

class this._cls0
    implements HttpResponseInterceptor
{

    final AsyncHttpClient this$0;

    public void process(HttpResponse httpresponse, HttpContext httpcontext)
    {
        httpcontext = httpresponse.getEntity();
        if (httpcontext != null) goto _L2; else goto _L1
_L1:
        Header header;
        return;
_L2:
        if ((header = httpcontext.getContentEncoding()) != null)
        {
            HeaderElement aheaderelement[] = header.getElements();
            int j = aheaderelement.length;
            int i = 0;
            while (i < j) 
            {
                if (aheaderelement[i].getName().equalsIgnoreCase("gzip"))
                {
                    httpresponse.setEntity(new flatingEntity(httpcontext));
                    return;
                }
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    tpContext()
    {
        this$0 = AsyncHttpClient.this;
        super();
    }
}
