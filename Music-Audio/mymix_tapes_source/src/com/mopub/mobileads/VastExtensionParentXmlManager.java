// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;

// Referenced classes of package com.mopub.mobileads:
//            VastExtensionXmlManager

public class VastExtensionParentXmlManager
{

    private static final String EXTENSION = "Extension";
    private final Node mVastExtensionParentNode;

    VastExtensionParentXmlManager(Node node)
    {
        Preconditions.checkNotNull(node);
        mVastExtensionParentNode = node;
    }

    List getVastExtensionXmlManagers()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = XmlUtils.getMatchingChildNodes(mVastExtensionParentNode, "Extension");
        if (obj != null)
        {
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                arraylist.add(new VastExtensionXmlManager((Node)((Iterator) (obj)).next()));
            }
        }
        return arraylist;
    }
}
