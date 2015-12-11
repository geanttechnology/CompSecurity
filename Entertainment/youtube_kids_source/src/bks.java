// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.net.MalformedURLException;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;

public final class bks extends DefaultRedirectHandler
{

    public bks()
    {
    }

    public final URI getLocationURI(HttpResponse httpresponse, HttpContext httpcontext)
    {
        if (httpresponse != null && httpresponse.getFirstHeader("location") != null)
        {
            String s = httpresponse.getFirstHeader("location").getValue();
            try
            {
                s = a.r(s);
                a.s(s);
                httpresponse.setHeader("location", s);
            }
            // Misplaced declaration of an exception variable
            catch (HttpResponse httpresponse)
            {
                throw new ProtocolException(httpresponse.getMessage());
            }
        }
        return super.getLocationURI(httpresponse, httpcontext);
    }
}
