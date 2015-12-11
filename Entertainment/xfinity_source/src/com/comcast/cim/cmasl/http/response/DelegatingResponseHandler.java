// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.response;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

// Referenced classes of package com.comcast.cim.cmasl.http.response:
//            ResponseHandler, DefaultHttpStatusCodeHandler, ResponseHeadersHandler, DetailedRequestStatus

public abstract class DelegatingResponseHandler
    implements ResponseHandler
{

    private final LinkedHashSet delegateHeadersHandlers = new LinkedHashSet();

    public DelegatingResponseHandler()
    {
    }

    protected void addDefaultHeaderHandlers()
    {
        addDelegateHeadersHandler(new DefaultHttpStatusCodeHandler());
    }

    protected void addDelegateHeadersHandler(ResponseHeadersHandler responseheadershandler)
    {
        delegateHeadersHandlers.add(responseheadershandler);
    }

    public void handleResponseHeaders(String s, DetailedRequestStatus detailedrequeststatus, Map map)
    {
        for (Iterator iterator = delegateHeadersHandlers.iterator(); iterator.hasNext(); ((ResponseHeadersHandler)iterator.next()).handleResponseHeaders(s, detailedrequeststatus, map)) { }
    }
}
