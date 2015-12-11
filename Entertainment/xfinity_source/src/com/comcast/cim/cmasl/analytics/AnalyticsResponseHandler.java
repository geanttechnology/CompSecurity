// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.analytics;

import com.comcast.cim.cmasl.http.response.DelegatingResponseHandler;
import com.comcast.cim.cmasl.http.response.StrictHttpStatusCodeHandler;
import java.io.InputStream;

public class AnalyticsResponseHandler extends DelegatingResponseHandler
{

    public AnalyticsResponseHandler()
    {
        addDelegateHeadersHandler(new StrictHttpStatusCodeHandler());
    }

    public void handleResponseBody(InputStream inputstream)
    {
    }
}
