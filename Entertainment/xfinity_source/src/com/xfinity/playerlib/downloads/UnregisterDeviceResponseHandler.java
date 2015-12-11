// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.downloads;

import com.comcast.cim.cmasl.http.response.DetailedRequestStatus;
import com.comcast.cim.cmasl.xip.ams.AMSResponseHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;

public class UnregisterDeviceResponseHandler extends AMSResponseHandler
{

    public UnregisterDeviceResponseHandler(ObjectMapper objectmapper)
    {
        super(objectmapper);
    }

    protected void handleAMSResponseBody(JsonNode jsonnode)
        throws IOException
    {
    }

    public void handleResponseHeaders(String s, DetailedRequestStatus detailedrequeststatus, Map map)
    {
        super.handleResponseHeaders(s, detailedrequeststatus, map);
    }
}
