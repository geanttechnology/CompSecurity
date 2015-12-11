// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.response;

import java.util.Map;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.cim.cmasl.http.response:
//            ResponseHeadersHandler, DetailedRequestStatus

public class LogErrorStatusHandler
    implements ResponseHeadersHandler
{

    private final Logger logger;

    public void handleResponseHeaders(String s, DetailedRequestStatus detailedrequeststatus, Map map)
    {
        if (detailedrequeststatus.getStatusCode().intValue() != 200)
        {
            logger.error((new StringBuilder()).append("Error Returned from Request: ").append(detailedrequeststatus.getStatusCode()).append(", ").append(detailedrequeststatus.getStatusMessage()).toString());
        }
    }
}
