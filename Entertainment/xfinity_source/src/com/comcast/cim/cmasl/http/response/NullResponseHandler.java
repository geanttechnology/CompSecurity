// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.response;

import java.io.InputStream;
import java.util.Map;

// Referenced classes of package com.comcast.cim.cmasl.http.response:
//            ResponseHandler, DetailedRequestStatus

public class NullResponseHandler
    implements ResponseHandler
{

    public NullResponseHandler()
    {
    }

    public void handleResponseBody(InputStream inputstream)
    {
    }

    public void handleResponseHeaders(String s, DetailedRequestStatus detailedrequeststatus, Map map)
    {
    }
}
