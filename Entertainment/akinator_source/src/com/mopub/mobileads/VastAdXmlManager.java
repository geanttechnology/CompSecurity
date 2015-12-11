// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

// Referenced classes of package com.mopub.mobileads:
//            VastInLineXmlManager, VastWrapperXmlManager

class VastAdXmlManager
{

    private static final String INLINE = "InLine";
    private static final String SEQUENCE = "sequence";
    private static final String WRAPPER = "Wrapper";
    private final Node mAdNode;

    VastAdXmlManager(Node node)
    {
        Preconditions.checkNotNull(node);
        mAdNode = node;
    }

    VastInLineXmlManager getInLineXmlManager()
    {
        Node node = XmlUtils.getFirstMatchingChildNode(mAdNode, "InLine");
        VastInLineXmlManager vastinlinexmlmanager = null;
        if (node != null)
        {
            vastinlinexmlmanager = new VastInLineXmlManager(node);
        }
        return vastinlinexmlmanager;
    }

    String getSequence()
    {
        return XmlUtils.getAttributeValue(mAdNode, "sequence");
    }

    VastWrapperXmlManager getWrapperXmlManager()
    {
        Node node = XmlUtils.getFirstMatchingChildNode(mAdNode, "Wrapper");
        VastWrapperXmlManager vastwrapperxmlmanager = null;
        if (node != null)
        {
            vastwrapperxmlmanager = new VastWrapperXmlManager(node);
        }
        return vastwrapperxmlmanager;
    }
}
