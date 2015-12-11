// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl;

import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.HttpResponseFactory;
import com.comcast.cim.httpcomponentsandroid.ReasonPhraseCatalog;
import com.comcast.cim.httpcomponentsandroid.StatusLine;
import com.comcast.cim.httpcomponentsandroid.message.BasicHttpResponse;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.util.Locale;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl:
//            EnglishReasonPhraseCatalog

public class DefaultHttpResponseFactory
    implements HttpResponseFactory
{

    protected final ReasonPhraseCatalog reasonCatalog;

    public DefaultHttpResponseFactory()
    {
        this(((ReasonPhraseCatalog) (EnglishReasonPhraseCatalog.INSTANCE)));
    }

    public DefaultHttpResponseFactory(ReasonPhraseCatalog reasonphrasecatalog)
    {
        if (reasonphrasecatalog == null)
        {
            throw new IllegalArgumentException("Reason phrase catalog must not be null.");
        } else
        {
            reasonCatalog = reasonphrasecatalog;
            return;
        }
    }

    protected Locale determineLocale(HttpContext httpcontext)
    {
        return Locale.getDefault();
    }

    public HttpResponse newHttpResponse(StatusLine statusline, HttpContext httpcontext)
    {
        if (statusline == null)
        {
            throw new IllegalArgumentException("Status line may not be null");
        } else
        {
            httpcontext = determineLocale(httpcontext);
            return new BasicHttpResponse(statusline, reasonCatalog, httpcontext);
        }
    }
}
