// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.order.tender;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class RewardZoneTender
{

    private String certNumber;
    private String memberNumber;

    public RewardZoneTender()
    {
    }

    public static RewardZoneTender loadData(Node node)
    {
        RewardZoneTender rewardzonetender = new RewardZoneTender();
        node = node.getAttributes();
        rewardzonetender.certNumber = node.getNamedItem("rwzcert-num").getTextContent();
        rewardzonetender.memberNumber = node.getNamedItem("rwz-member").getTextContent();
        return rewardzonetender;
    }

    public String getCertNumber()
    {
        return certNumber;
    }

    public String getMemberNumber()
    {
        return memberNumber;
    }

    public String getXML()
    {
        return (new StringBuilder()).append("<rwzcert rwzcert-num=\"").append(certNumber).append("\" rwz-member=\"").append(memberNumber).append("\"/>").toString();
    }
}
