// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

class VastMediaXmlManager
{

    private static final String DELIVERY = "delivery";
    private static final String HEIGHT = "height";
    private static final String VIDEO_TYPE = "type";
    private static final String WIDTH = "width";
    private final Node mMediaNode;

    VastMediaXmlManager(Node node)
    {
        Preconditions.checkNotNull(node, "mediaNode cannot be null");
        mMediaNode = node;
    }

    String getDelivery()
    {
        return XmlUtils.getAttributeValue(mMediaNode, "delivery");
    }

    Integer getHeight()
    {
        return XmlUtils.getAttributeValueAsInt(mMediaNode, "height");
    }

    String getMediaUrl()
    {
        return XmlUtils.getNodeValue(mMediaNode);
    }

    String getType()
    {
        return XmlUtils.getAttributeValue(mMediaNode, "type");
    }

    Integer getWidth()
    {
        return XmlUtils.getAttributeValueAsInt(mMediaNode, "width");
    }
}
