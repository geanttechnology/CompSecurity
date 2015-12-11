// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class DeepLinking extends MobileFunnelEvent
{

    public String attributionId;
    public String attributionType;
    public String cid;
    public String extraInfo;
    public String fullUrl;

    public DeepLinking()
    {
        fullUrl = "";
        cid = "";
        attributionId = "";
        attributionType = "";
        extraInfo = "";
        eventType = "GRP9";
    }

    public DeepLinking(String s, String s1, String s2, String s3, String s4, String s5)
    {
        super("GRP9", s);
        fullUrl = "";
        cid = "";
        attributionId = "";
        attributionType = "";
        extraInfo = "";
        fullUrl = s1;
        cid = s2;
        attributionId = s3;
        attributionType = s4;
        extraInfo = s5;
    }

    public void pack(int i, Packer packer)
        throws IOException
    {
        int j = i;
        if (i == -1)
        {
            j = 11;
        }
        super.pack(j, packer);
        packer.pack(fullUrl);
        packer.pack(cid);
        packer.pack(attributionId);
        packer.pack(attributionType);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        fullUrl = "";
        cid = "";
        attributionId = "";
        attributionType = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("DeepLinking")).append("[").append(fullUrl).append(",").append(cid).append(",").append(attributionId).append(",").append(attributionType).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
