// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.response;

import java.util.Map;

// Referenced classes of package com.comcast.cim.cmasl.http.response:
//            ResponseHeadersHandler, ResponseId, DetailedRequestStatus

public class IdentifyResponseHandler
    implements ResponseHeadersHandler
{

    private ResponseId responseId;

    public IdentifyResponseHandler()
    {
    }

    private String getLastModifiedHeaderValueFrom(Map map)
    {
        return (String)map.get("Last-Modified");
    }

    public ResponseId getResponseId()
    {
        return responseId;
    }

    public void handleResponseHeaders(String s, DetailedRequestStatus detailedrequeststatus, Map map)
    {
        s = getLastModifiedHeaderValueFrom(map);
        if (s != null)
        {
            responseId = new ResponseId(s);
        }
    }
}
