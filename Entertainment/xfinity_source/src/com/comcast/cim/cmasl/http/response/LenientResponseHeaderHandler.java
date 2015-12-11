// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.response;

import com.comcast.cim.cmasl.http.exceptions.CimHttpException;
import java.util.Map;

// Referenced classes of package com.comcast.cim.cmasl.http.response:
//            ResponseHeadersHandler, DetailedRequestStatus

public class LenientResponseHeaderHandler
    implements ResponseHeadersHandler
{

    public LenientResponseHeaderHandler()
    {
    }

    public void handleResponseHeaders(String s, DetailedRequestStatus detailedrequeststatus, Map map)
    {
        int i = detailedrequeststatus.getStatusCode().intValue();
        if (i < 200 || i >= 300)
        {
            throw new CimHttpException(detailedrequeststatus);
        } else
        {
            return;
        }
    }
}
