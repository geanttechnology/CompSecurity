// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileEvent

public class APITransaction extends MobileEvent
{

    public String activeNetworkType;
    public String extraInfo;
    public String httpMethod;
    public String parameters;
    public long requestEndTime;
    public long requestStartTime;
    public int responseCode;
    public int responseDuration;
    public String url;

    public APITransaction()
    {
        httpMethod = "";
        url = "";
        parameters = "";
        activeNetworkType = "";
        extraInfo = "";
        eventType = "GRP7";
    }

    public APITransaction(String s, String s1, String s2, int i, long l, long l1, int j, String s3, EncodedNSTField encodednstfield)
    {
        super("GRP7");
        httpMethod = "";
        url = "";
        parameters = "";
        activeNetworkType = "";
        extraInfo = "";
        httpMethod = s;
        url = s1;
        parameters = s2;
        responseCode = i;
        requestStartTime = l;
        requestEndTime = l1;
        responseDuration = j;
        activeNetworkType = s3;
        if (encodednstfield != null)
        {
            extraInfo = encodednstfield.toEncodedString();
        }
    }

    public void pack(int i, Packer packer)
        throws IOException
    {
        int j = i;
        if (i == -1)
        {
            j = 12;
        }
        super.pack(j, packer);
        packer.pack(httpMethod);
        packer.pack(url);
        packer.pack(parameters);
        packer.pack(responseCode);
        packer.pack(requestStartTime);
        packer.pack(requestEndTime);
        packer.pack(responseDuration);
        packer.pack(activeNetworkType);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        httpMethod = "";
        url = "";
        parameters = "";
        responseCode = 0;
        requestStartTime = 0L;
        requestEndTime = 0L;
        responseDuration = 0;
        activeNetworkType = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("APITransaction")).append("[").append(httpMethod).append(",").append(url).append(",").append(parameters).append(",").append(responseCode).append(",").append(requestStartTime).append(",").append(requestEndTime).append(",").append(responseDuration).append(",").append(activeNetworkType).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
