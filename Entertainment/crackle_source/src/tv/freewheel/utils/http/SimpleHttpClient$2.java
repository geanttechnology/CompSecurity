// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.utils.http;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package tv.freewheel.utils.http:
//            SimpleHttpClient

class r extends DefaultHttpClient
{

    final SimpleHttpClient this$0;

    protected HttpContext createHttpContext()
    {
        BasicHttpContext basichttpcontext = new BasicHttpContext();
        basichttpcontext.setAttribute("http.authscheme-registry", getAuthSchemes());
        basichttpcontext.setAttribute("http.cookiespec-registry", getCookieSpecs());
        basichttpcontext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
        return basichttpcontext;
    }

    protected BasicHttpProcessor createHttpProcessor()
    {
        BasicHttpProcessor basichttpprocessor = super.createHttpProcessor();
        basichttpprocessor.addRequestInterceptor(SimpleHttpClient.access$100());
        return basichttpprocessor;
    }

    r(ClientConnectionManager clientconnectionmanager, HttpParams httpparams)
    {
        this$0 = SimpleHttpClient.this;
        super(clientconnectionmanager, httpparams);
    }
}
