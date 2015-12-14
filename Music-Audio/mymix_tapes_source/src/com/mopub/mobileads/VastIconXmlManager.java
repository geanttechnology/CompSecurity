// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;

// Referenced classes of package com.mopub.mobileads:
//            VastResourceXmlManager, VastTracker

public class VastIconXmlManager
{

    public static final String DURATION = "duration";
    public static final String HEIGHT = "height";
    public static final String ICON_CLICKS = "IconClicks";
    public static final String ICON_CLICK_THROUGH = "IconClickThrough";
    public static final String ICON_CLICK_TRACKING = "IconClickTracking";
    public static final String ICON_VIEW_TRACKING = "IconViewTracking";
    public static final String OFFSET = "offset";
    public static final String WIDTH = "width";
    private final Node mIconNode;
    private final VastResourceXmlManager mResourceXmlManager;

    VastIconXmlManager(Node node)
    {
        Preconditions.checkNotNull(node);
        mIconNode = node;
        mResourceXmlManager = new VastResourceXmlManager(node);
    }

    String getClickThroughUri()
    {
        Node node = XmlUtils.getFirstMatchingChildNode(mIconNode, "IconClicks");
        if (node == null)
        {
            return null;
        } else
        {
            return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(node, "IconClickThrough"));
        }
    }

    List getClickTrackingUris()
    {
        Object obj = XmlUtils.getFirstMatchingChildNode(mIconNode, "IconClicks");
        ArrayList arraylist = new ArrayList();
        if (obj != null)
        {
            obj = XmlUtils.getMatchingChildNodes(((Node) (obj)), "IconClickTracking").iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                String s = XmlUtils.getNodeValue((Node)((Iterator) (obj)).next());
                if (s != null)
                {
                    arraylist.add(new VastTracker(s));
                }
            }
        }
        return arraylist;
    }

    Integer getDurationMS()
    {
        String s = XmlUtils.getAttributeValue(mIconNode, "duration");
        Integer integer;
        try
        {
            integer = Strings.parseAbsoluteOffset(s);
        }
        catch (NumberFormatException numberformatexception)
        {
            MoPubLog.d(String.format("Invalid VAST icon duration format: %s:", new Object[] {
                s
            }));
            return null;
        }
        return integer;
    }

    Integer getHeight()
    {
        return XmlUtils.getAttributeValueAsInt(mIconNode, "height");
    }

    Integer getOffsetMS()
    {
        String s = XmlUtils.getAttributeValue(mIconNode, "offset");
        Integer integer;
        try
        {
            integer = Strings.parseAbsoluteOffset(s);
        }
        catch (NumberFormatException numberformatexception)
        {
            MoPubLog.d(String.format("Invalid VAST icon offset format: %s:", new Object[] {
                s
            }));
            return null;
        }
        return integer;
    }

    VastResourceXmlManager getResourceXmlManager()
    {
        return mResourceXmlManager;
    }

    List getViewTrackingUris()
    {
        Object obj = XmlUtils.getMatchingChildNodes(mIconNode, "IconViewTracking");
        ArrayList arraylist = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s = XmlUtils.getNodeValue((Node)((Iterator) (obj)).next());
            if (s != null)
            {
                arraylist.add(new VastTracker(s));
            }
        } while (true);
        return arraylist;
    }

    Integer getWidth()
    {
        return XmlUtils.getAttributeValueAsInt(mIconNode, "width");
    }
}
