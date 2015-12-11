// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class SubscriptionSignUp extends MobileFunnelEvent
{

    public String attributionDownloadId;
    public String attributionId;
    public long attributionTimeOverlap;
    public String attributionType;
    public String cid;
    public String divisionId;
    public String downloadCid;
    public String extraInfo;
    public String subscriptionType;

    public SubscriptionSignUp()
    {
        subscriptionType = "";
        divisionId = "";
        cid = "";
        attributionId = "";
        attributionType = "";
        attributionDownloadId = "";
        downloadCid = "";
        extraInfo = "";
        eventType = "GRP11";
    }

    public SubscriptionSignUp(String s, String s1, String s2, String s3, String s4, String s5, long l, String s6, String s7, EncodedNSTField encodednstfield)
    {
        super("GRP11", s);
        subscriptionType = "";
        divisionId = "";
        cid = "";
        attributionId = "";
        attributionType = "";
        attributionDownloadId = "";
        downloadCid = "";
        extraInfo = "";
        subscriptionType = s1;
        divisionId = s2;
        cid = s3;
        attributionId = s4;
        attributionType = s5;
        attributionTimeOverlap = l;
        attributionDownloadId = s6;
        downloadCid = s7;
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
            j = 15;
        }
        super.pack(j, packer);
        packer.pack(subscriptionType);
        packer.pack(divisionId);
        packer.pack(cid);
        packer.pack(attributionId);
        packer.pack(attributionType);
        packer.pack(attributionTimeOverlap);
        packer.pack(attributionDownloadId);
        packer.pack(downloadCid);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        subscriptionType = "";
        divisionId = "";
        cid = "";
        attributionId = "";
        attributionType = "";
        attributionTimeOverlap = 0L;
        attributionDownloadId = "";
        downloadCid = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("SubscriptionSignUp")).append("[").append(subscriptionType).append(",").append(divisionId).append(",").append(cid).append(",").append(attributionId).append(",").append(attributionType).append(",").append(attributionTimeOverlap).append(",").append(attributionDownloadId).append(",").append(downloadCid).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
