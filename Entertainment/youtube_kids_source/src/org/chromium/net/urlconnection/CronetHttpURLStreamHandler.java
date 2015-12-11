// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net.urlconnection;

import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import org.chromium.net.UrlRequestContext;

// Referenced classes of package org.chromium.net.urlconnection:
//            CronetHttpURLConnection

public class CronetHttpURLStreamHandler extends URLStreamHandler
{

    private final UrlRequestContext a;

    public CronetHttpURLStreamHandler(UrlRequestContext urlrequestcontext)
    {
        a = urlrequestcontext;
    }

    protected URLConnection openConnection(URL url)
    {
        String s = url.getProtocol();
        if ("http".equals(s) || "https".equals(s))
        {
            return new CronetHttpURLConnection(url, a);
        } else
        {
            throw new UnsupportedOperationException((new StringBuilder("Unexpected protocol:")).append(s).toString());
        }
    }

    protected URLConnection openConnection(URL url, Proxy proxy)
    {
        throw new UnsupportedOperationException();
    }
}
