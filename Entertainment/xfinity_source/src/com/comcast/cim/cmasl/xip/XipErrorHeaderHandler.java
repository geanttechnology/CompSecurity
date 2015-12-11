// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.xip;

import com.comcast.cim.cmasl.http.response.DetailedRequestStatus;
import com.comcast.cim.cmasl.http.response.ResponseHeadersHandler;
import java.util.Map;

// Referenced classes of package com.comcast.cim.cmasl.xip:
//            XipHttpErrorException

public class XipErrorHeaderHandler
    implements ResponseHeadersHandler
{

    public XipErrorHeaderHandler()
    {
    }

    public void handleResponseHeaders(String s, DetailedRequestStatus detailedrequeststatus, Map map)
    {
        s = XipHttpErrorException.fromHttpResponse(detailedrequeststatus, map);
        if (s != null)
        {
            throw s;
        } else
        {
            return;
        }
    }
}
