// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.utils.http;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;
import tv.freewheel.hybrid.utils.Logger;
import tv.freewheel.hybrid.utils.URIUtil;

// Referenced classes of package tv.freewheel.hybrid.utils.http:
//            SimpleHttpClient

class  extends DefaultRedirectHandler
{

    final SimpleHttpClient this$0;

    public URI getLocationURI(HttpResponse httpresponse, HttpContext httpcontext)
        throws ProtocolException
    {
        URI uri;
        try
        {
            uri = super.getLocationURI(httpresponse, httpcontext);
        }
        catch (ProtocolException protocolexception)
        {
            Object obj = protocolexception.getCause();
            if (!(obj instanceof URISyntaxException))
            {
                throw protocolexception;
            }
            obj = URIUtil.getFixedString(((URISyntaxException)obj).getInput());
            if (obj == null)
            {
                throw protocolexception;
            } else
            {
                SimpleHttpClient.access$200(SimpleHttpClient.this).debug((new StringBuilder()).append("Try fixed redirect location ").append(((String) (obj))).toString());
                httpresponse.setHeader("location", ((String) (obj)));
                return super.getLocationURI(httpresponse, httpcontext);
            }
        }
        return uri;
    }

    ()
    {
        this$0 = SimpleHttpClient.this;
        super();
    }
}
