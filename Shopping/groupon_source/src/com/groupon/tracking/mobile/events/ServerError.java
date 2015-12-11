// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileEvent

public class ServerError extends MobileEvent
{

    public String additionalInfoJson;
    public String extraInfo;
    public String httpMethod;
    public String requestHeaders;
    public String requestPayload;
    public long requestStartTime;
    public int responseCode;
    public String responseHeaders;
    public String responsePayload;
    public String url;

    public ServerError()
    {
        httpMethod = "";
        url = "";
        eventType = "GRP40";
    }

    public ServerError(String s, String s1, long l, String s2, String s3, int i, 
            String s4, String s5, String s6, String s7)
    {
        super("GRP40");
        httpMethod = "";
        url = "";
        httpMethod = s;
        url = s1;
        requestStartTime = l;
        requestHeaders = s2;
        requestPayload = s3;
        responseCode = i;
        responseHeaders = s4;
        responsePayload = s5;
        additionalInfoJson = s6;
        extraInfo = s7;
    }

    public void pack(int i, Packer packer)
        throws IOException
    {
        int j = i;
        if (i == -1)
        {
            j = 13;
        }
        super.pack(j, packer);
        packer.pack(httpMethod);
        packer.pack(url);
        packer.pack(requestStartTime);
        packer.pack(requestHeaders);
        packer.pack(requestPayload);
        packer.pack(responseCode);
        packer.pack(responseHeaders);
        packer.pack(responsePayload);
        packer.pack(additionalInfoJson);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        httpMethod = "";
        url = "";
        requestStartTime = 0L;
        requestHeaders = "";
        requestPayload = "";
        responseCode = 0;
        responseHeaders = "";
        responsePayload = "";
        additionalInfoJson = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("ServerError")).append("[").append(httpMethod).append(",").append(url).append(",").append(requestStartTime).append(",").append(requestHeaders).append(",").append(requestPayload).append(",").append(responseCode).append(",").append(responseHeaders).append(",").append(responsePayload).append(",").append(additionalInfoJson).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
