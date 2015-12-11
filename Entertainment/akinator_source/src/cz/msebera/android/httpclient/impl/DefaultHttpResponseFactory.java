// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.ReasonPhraseCatalog;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.message.BasicHttpResponse;
import cz.msebera.android.httpclient.message.BasicStatusLine;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.util.Locale;

// Referenced classes of package cz.msebera.android.httpclient.impl:
//            EnglishReasonPhraseCatalog

public class DefaultHttpResponseFactory
    implements HttpResponseFactory
{

    public static final DefaultHttpResponseFactory INSTANCE = new DefaultHttpResponseFactory();
    protected final ReasonPhraseCatalog reasonCatalog;

    public DefaultHttpResponseFactory()
    {
        this(((ReasonPhraseCatalog) (EnglishReasonPhraseCatalog.INSTANCE)));
    }

    public DefaultHttpResponseFactory(ReasonPhraseCatalog reasonphrasecatalog)
    {
        reasonCatalog = (ReasonPhraseCatalog)Args.notNull(reasonphrasecatalog, "Reason phrase catalog");
    }

    protected Locale determineLocale(HttpContext httpcontext)
    {
        return Locale.getDefault();
    }

    public HttpResponse newHttpResponse(ProtocolVersion protocolversion, int i, HttpContext httpcontext)
    {
        Args.notNull(protocolversion, "HTTP version");
        httpcontext = determineLocale(httpcontext);
        return new BasicHttpResponse(new BasicStatusLine(protocolversion, i, reasonCatalog.getReason(i, httpcontext)), reasonCatalog, httpcontext);
    }

    public HttpResponse newHttpResponse(StatusLine statusline, HttpContext httpcontext)
    {
        Args.notNull(statusline, "Status line");
        return new BasicHttpResponse(statusline, reasonCatalog, determineLocale(httpcontext));
    }

}
