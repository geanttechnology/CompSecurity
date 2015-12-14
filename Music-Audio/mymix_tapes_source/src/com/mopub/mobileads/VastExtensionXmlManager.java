// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

// Referenced classes of package com.mopub.mobileads:
//            VideoViewabilityTrackerXmlManager, VideoViewabilityTracker

public class VastExtensionXmlManager
{

    public static final String TYPE = "type";
    public static final String VIDEO_VIEWABILITY_TRACKER = "MoPubViewabilityTracker";
    private final Node mExtensionNode;

    public VastExtensionXmlManager(Node node)
    {
        Preconditions.checkNotNull(node);
        mExtensionNode = node;
    }

    String getType()
    {
        return XmlUtils.getAttributeValue(mExtensionNode, "type");
    }

    VideoViewabilityTracker getVideoViewabilityTracker()
    {
        Object obj = XmlUtils.getFirstMatchingChildNode(mExtensionNode, "MoPubViewabilityTracker");
        if (obj != null)
        {
            Object obj1 = new VideoViewabilityTrackerXmlManager(((Node) (obj)));
            obj = ((VideoViewabilityTrackerXmlManager) (obj1)).getViewablePlaytimeMS();
            Integer integer = ((VideoViewabilityTrackerXmlManager) (obj1)).getPercentViewable();
            obj1 = ((VideoViewabilityTrackerXmlManager) (obj1)).getVideoViewabilityTrackerUrl();
            if (obj != null && integer != null && !TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                return new VideoViewabilityTracker(((Integer) (obj)).intValue(), integer.intValue(), ((String) (obj1)));
            }
        }
        return null;
    }
}
