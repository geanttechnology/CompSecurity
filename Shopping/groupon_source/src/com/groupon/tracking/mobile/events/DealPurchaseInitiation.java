// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class DealPurchaseInitiation extends MobileFunnelEvent
{

    public String attributionDownloadId;
    public String attributionId;
    public long attributionTimeOverlap;
    public String attributionType;
    public String cartUUID;
    public String channel;
    public String cid;
    public String currencyCode;
    public String dealID;
    public String dealOptionId;
    public String dealUUID;
    public String downloadCid;
    public String extraInfo;
    public String orderDetails;
    public float price;
    public int quantity;

    public DealPurchaseInitiation()
    {
        channel = "";
        dealID = "";
        dealOptionId = "";
        currencyCode = "";
        cid = "";
        attributionId = "";
        attributionType = "";
        attributionDownloadId = "";
        downloadCid = "";
        cartUUID = "";
        dealUUID = "";
        orderDetails = "";
        extraInfo = "";
        eventType = "GRP4";
    }

    public DealPurchaseInitiation(String s, String s1, String s2, int i, float f, String s3, String s4, 
            String s5, String s6, String s7, long l, String s8, String s9, 
            String s10, String s11, String s12, EncodedNSTField encodednstfield)
    {
        super("GRP4", s);
        channel = "";
        dealID = "";
        dealOptionId = "";
        currencyCode = "";
        cid = "";
        attributionId = "";
        attributionType = "";
        attributionDownloadId = "";
        downloadCid = "";
        cartUUID = "";
        dealUUID = "";
        orderDetails = "";
        extraInfo = "";
        channel = s1;
        dealID = s2;
        quantity = i;
        price = f;
        dealOptionId = s3;
        currencyCode = s4;
        cid = s5;
        attributionId = s6;
        attributionType = s7;
        attributionTimeOverlap = l;
        attributionDownloadId = s8;
        downloadCid = s9;
        cartUUID = s10;
        dealUUID = s11;
        orderDetails = s12;
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
        packer.pack(quantity);
        packer.pack(price);
        packer.pack(dealOptionId);
        packer.pack(currencyCode);
        packer.pack(cid);
        packer.pack(attributionId);
        packer.pack(attributionType);
        packer.pack(attributionTimeOverlap);
        packer.pack(attributionDownloadId);
        packer.pack(downloadCid);
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
        quantity = 0;
        price = 0.0F;
        dealOptionId = "";
        currencyCode = "";
        cid = "";
        attributionId = "";
        attributionType = "";
        attributionTimeOverlap = 0L;
        attributionDownloadId = "";
        downloadCid = "";
        cartUUID = "";
        dealUUID = "";
        orderDetails = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("DealPurchaseInitiation")).append("[").append(channel).append(",").append(dealID).append(",").append(quantity).append(",").append(price).append(",").append(dealOptionId).append(",").append(currencyCode).append(",").append(cid).append(",").append(attributionId).append(",").append(attributionType).append(",").append(attributionTimeOverlap).append(",").append(attributionDownloadId).append(",").append(downloadCid).append(",").append(cartUUID).append(",").append(dealUUID).append(",").append(orderDetails).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
