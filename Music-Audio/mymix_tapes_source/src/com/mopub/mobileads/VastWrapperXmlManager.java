// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

// Referenced classes of package com.mopub.mobileads:
//            VastBaseInLineWrapperXmlManager

class VastWrapperXmlManager extends VastBaseInLineWrapperXmlManager
{

    private static final String VAST_AD_TAG = "VASTAdTagURI";

    VastWrapperXmlManager(Node node)
    {
        super(node);
        Preconditions.checkNotNull(node);
    }

    String getVastAdTagURI()
    {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(mNode, "VASTAdTagURI"));
    }
}
