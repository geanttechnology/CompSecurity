// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.protocol;

import java.util.Map;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.protocol:
//            HttpRequestHandlerResolver, UriPatternMatcher

public class HttpRequestHandlerRegistry
    implements HttpRequestHandlerResolver
{

    private final UriPatternMatcher matcher = new UriPatternMatcher();

    public HttpRequestHandlerRegistry()
    {
    }

    public void setHandlers(Map map)
    {
        matcher.setObjects(map);
    }
}
