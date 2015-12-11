// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;

// Referenced classes of package com.mopub.mobileads:
//            VastResourceXmlManager, VastTracker

class VastCompanionAdXmlManager
{

    private static final String COMPANION_CLICK_THROUGH = "CompanionClickThrough";
    private static final String COMPANION_CLICK_TRACKING = "CompanionClickTracking";
    private static final String CREATIVE_VIEW = "creativeView";
    private static final String EVENT = "event";
    private static final String HEIGHT = "height";
    private static final String TRACKING_EVENTS = "TrackingEvents";
    private static final String VIDEO_TRACKER = "Tracking";
    private static final String WIDTH = "width";
    private final Node mCompanionNode;
    private final VastResourceXmlManager mResourceXmlManager;

    VastCompanionAdXmlManager(Node node)
    {
        Preconditions.checkNotNull(node, "companionNode cannot be null");
        mCompanionNode = node;
        mResourceXmlManager = new VastResourceXmlManager(node);
    }

    String getClickThroughUrl()
    {
        return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(mCompanionNode, "CompanionClickThrough"));
    }

    List getClickTrackers()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = XmlUtils.getMatchingChildNodes(mCompanionNode, "CompanionClickTracking");
        if (obj != null)
        {
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                String s = XmlUtils.getNodeValue((Node)((Iterator) (obj)).next());
                if (!TextUtils.isEmpty(s))
                {
                    arraylist.add(new VastTracker(s));
                }
            }
        }
        return arraylist;
    }

    List getCompanionCreativeViewTrackers()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = XmlUtils.getFirstMatchingChildNode(mCompanionNode, "TrackingEvents");
        if (obj != null)
        {
            obj = XmlUtils.getMatchingChildNodes(((Node) (obj)), "Tracking", "event", Collections.singletonList("creativeView")).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                arraylist.add(new VastTracker(XmlUtils.getNodeValue((Node)((Iterator) (obj)).next())));
            }
        }
        return arraylist;
    }

    Integer getHeight()
    {
        return XmlUtils.getAttributeValueAsInt(mCompanionNode, "height");
    }

    VastResourceXmlManager getResourceXmlManager()
    {
        return mResourceXmlManager;
    }

    Integer getWidth()
    {
        return XmlUtils.getAttributeValueAsInt(mCompanionNode, "width");
    }

    boolean hasResources()
    {
        return !TextUtils.isEmpty(mResourceXmlManager.getStaticResource()) || !TextUtils.isEmpty(mResourceXmlManager.getHTMLResource()) || !TextUtils.isEmpty(mResourceXmlManager.getIFrameResource());
    }
}
