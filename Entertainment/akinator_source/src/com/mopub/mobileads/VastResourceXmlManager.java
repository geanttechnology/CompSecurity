// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

public class VastResourceXmlManager
{

    public static final String CREATIVE_TYPE = "creativeType";
    public static final String HTML_RESOURCE = "HTMLResource";
    public static final String IFRAME_RESOURCE = "IFrameResource";
    public static final String STATIC_RESOURCE = "StaticResource";
    private final Node mResourceNode;

    VastResourceXmlManager(Node node)
    {
        Preconditions.checkNotNull(node);
        mResourceNode = node;
    }

    String getHTMLResource()
    {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(mResourceNode, "HTMLResource"));
    }

    String getIFrameResource()
    {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(mResourceNode, "IFrameResource"));
    }

    String getStaticResource()
    {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(mResourceNode, "StaticResource"));
    }

    String getStaticResourceType()
    {
        String s = XmlUtils.getAttributeValue(XmlUtils.getFirstMatchingChildNode(mResourceNode, "StaticResource"), "creativeType");
        if (s != null)
        {
            return s.toLowerCase();
        } else
        {
            return null;
        }
    }
}
