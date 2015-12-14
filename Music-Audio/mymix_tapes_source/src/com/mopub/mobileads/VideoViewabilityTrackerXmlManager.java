// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

public class VideoViewabilityTrackerXmlManager
{

    public static final String PERCENT_VIEWABLE = "percentViewable";
    public static final String VIEWABLE_PLAYTIME = "viewablePlaytime";
    private final Node mVideoViewabilityNode;

    VideoViewabilityTrackerXmlManager(Node node)
    {
        Preconditions.checkNotNull(node);
        mVideoViewabilityNode = node;
    }

    Integer getPercentViewable()
    {
        Object obj = XmlUtils.getAttributeValue(mVideoViewabilityNode, "percentViewable");
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((Integer) (obj));
_L2:
        Integer integer = null;
        int i = (int)Float.parseFloat(((String) (obj)).replace("%", ""));
        integer = Integer.valueOf(i);
_L5:
        if (integer == null || integer.intValue() < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = integer;
        if (integer.intValue() <= 100) goto _L4; else goto _L3
_L3:
        return null;
        NumberFormatException numberformatexception;
        numberformatexception;
        MoPubLog.d(String.format("Invalid VAST percentViewable format for \"d{1,3}%%\": %s:", new Object[] {
            obj
        }));
          goto _L5
    }

    String getVideoViewabilityTrackerUrl()
    {
        return XmlUtils.getNodeValue(mVideoViewabilityNode);
    }

    Integer getViewablePlaytimeMS()
    {
        String s = XmlUtils.getAttributeValue(mVideoViewabilityNode, "viewablePlaytime");
        if (s != null) goto _L2; else goto _L1
_L1:
        Integer integer1 = null;
_L6:
        return integer1;
_L2:
        Integer integer = null;
        if (!Strings.isAbsoluteTracker(s)) goto _L4; else goto _L3
_L3:
        integer1 = Strings.parseAbsoluteOffset(s);
        integer = integer1;
_L7:
        if (integer == null)
        {
            break; /* Loop/switch isn't completed */
        }
        integer1 = integer;
        if (integer.intValue() >= 0) goto _L6; else goto _L5
_L5:
        return null;
        NumberFormatException numberformatexception;
        numberformatexception;
        MoPubLog.d(String.format("Invalid VAST viewablePlaytime format for \"HH:MM:SS[.mmm]\": %s:", new Object[] {
            s
        }));
          goto _L7
_L4:
        int i = (int)(Float.parseFloat(s) * 1000F);
        integer = Integer.valueOf(i);
          goto _L7
        numberformatexception;
        MoPubLog.d(String.format("Invalid VAST viewablePlaytime format for \"SS[.mmm]\": %s:", new Object[] {
            s
        }));
          goto _L7
    }
}
