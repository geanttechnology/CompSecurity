// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.xip;

import com.comcast.cim.cmasl.http.response.DelegatingResponseHandler;
import java.io.InputStream;

// Referenced classes of package com.comcast.cim.cmasl.xip:
//            XipErrorHeaderHandler

public class XipResponseHandler extends DelegatingResponseHandler
{

    public XipResponseHandler()
    {
        addDelegateHeadersHandler(new XipErrorHeaderHandler());
        addDefaultHeaderHandlers();
    }

    public void handleResponseBody(InputStream inputstream)
    {
    }
}
