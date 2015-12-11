// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class DealPurchaseConfirmation extends MobileFunnelEvent
{

    public String attributionDownloadId;
    public String attributionId;
    public long attributionTimeOverlap;
    public String attributionType;
    public String cartUUID;
    public String channel;
    public String cid;
    public String dealID;
    public String dealOptionId;
    public String dealUUID;
    public String downloadCid;
    public int errorCode;
    public String errorString;
    public String extraInfo;
    public String orderDetails;
    public String orderId;

    public DealPurchaseConfirmation()
    {
        channel = "";
        dealID = "";
        errorString = "";
        dealOptionId = "";
        cid = "";
        attributionId = "";
        attributionType = "";
        attributionDownloadId = "";
        downloadCid = "";
        orderId = "";
        cartUUID = "";
        dealUUID = "";
        orderDetails = "";
        extraInfo = "";
        eventType = "GRP5";
    }

    public DealPurchaseConfirmation(String s, String s1, String s2, int i, String s3, String s4, String s5, 
            String s6, String s7, long l, String s8, String s9, String s10, 
            String s11, String s12, String s13, EncodedNSTField encodednstfield)
    {
        super("GRP5", s);
        channel = "";
        dealID = "";
        errorString = "";
        dealOptionId = "";
        cid = "";
        attributionId = "";
        attributionType = "";
        attributionDownloadId = "";
        downloadCid = "";
        orderId = "";
        cartUUID = "";
        dealUUID = "";
        orderDetails = "";
        extraInfo = "";
        channel = s1;
        dealID = s2;
        errorCode = i;
        errorString = s3;
        dealOptionId = s4;
        cid = s5;
        attributionId = s6;
        attributionType = s7;
        attributionTimeOverlap = l;
        attributionDownloadId = s8;
        downloadCid = s9;
        orderId = s10;
        cartUUID = s11;
        dealUUID = s12;
        orderDetails = s13;
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
            j = 22;
        }
        super.pack(j, packer);
        packer.pack(channel);
        packer.pack(dealID);
        packer.pack(errorCode);
        packer.pack(errorString);
        packer.pack(dealOptionId);
        packer.pack(cid);
        packer.pack(attributionId);
        packer.pack(attributionType);
        packer.pack(attributionTimeOverlap);
        packer.pack(attributionDownloadId);
        packer.pack(downloadCid);
        packer.pack(orderId);
        packer.pack(cartUUID);
        packer.pack(dealUUID);
        packer.pack(orderDetails);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        channel = "";
        dealID = "";
        errorCode = 0;
        errorString = "";
        dealOptionId = "";
        cid = "";
        attributionId = "";
        attributionType = "";
        attributionTimeOverlap = 0L;
        attributionDownloadId = "";
        downloadCid = "";
        orderId = "";
        cartUUID = "";
        dealUUID = "";
        orderDetails = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("DealPurchaseConfirmation")).append("[").append(channel).append(",").append(dealID).append(",").append(errorCode).append(",").append(errorString).append(",").append(dealOptionId).append(",").append(cid).append(",").append(attributionId).append(",").append(attributionType).append(",").append(attributionTimeOverlap).append(",").append(attributionDownloadId).append(",").append(downloadCid).append(",").append(orderId).append(",").append(cartUUID).append(",").append(dealUUID).append(",").append(orderDetails).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
