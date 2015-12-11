// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.util.Args;
import java.util.Map;

// Referenced classes of package cz.msebera.android.httpclient.protocol:
//            HttpRequestHandlerResolver, UriPatternMatcher, HttpRequestHandler

public class HttpRequestHandlerRegistry
    implements HttpRequestHandlerResolver
{

    private final UriPatternMatcher matcher = new UriPatternMatcher();

    public HttpRequestHandlerRegistry()
    {
    }

    public Map getHandlers()
    {
        return matcher.getObjects();
    }

    public HttpRequestHandler lookup(String s)
    {
        return (HttpRequestHandler)matcher.lookup(s);
    }

    public void register(String s, HttpRequestHandler httprequesthandler)
    {
        Args.notNull(s, "URI request pattern");
        Args.notNull(httprequesthandler, "Request handler");
        matcher.register(s, httprequesthandler);
    }

    public void setHandlers(Map map)
    {
        matcher.setObjects(map);
    }

    public void unregister(String s)
    {
        matcher.unregister(s);
    }
}
