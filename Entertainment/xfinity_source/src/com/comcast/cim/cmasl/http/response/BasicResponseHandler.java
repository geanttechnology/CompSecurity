// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.response;

import java.io.InputStream;

// Referenced classes of package com.comcast.cim.cmasl.http.response:
//            DelegatingResponseHandler, StrictHttpStatusCodeHandler

public class BasicResponseHandler extends DelegatingResponseHandler
{

    public BasicResponseHandler()
    {
        addDelegateHeadersHandler(new StrictHttpStatusCodeHandler());
    }

    public void handleResponseBody(InputStream inputstream)
    {
    }
}
