// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;

// Referenced classes of package com.mopub.mobileads:
//            VastFractionalProgressTracker, VastTracker, VastAbsoluteProgressTracker, VastIconXmlManager, 
//            VastMediaXmlManager

class VastLinearXmlManager
{

    private static final String CLICK_THROUGH = "ClickThrough";
    private static final String CLICK_TRACKER = "ClickTracking";
    private static final String CLOSE = "close";
    private static final String CLOSE_LINEAR = "closeLinear";
    private static final String COMPLETE = "complete";
    private static final String CREATIVE_VIEW = "creativeView";
    private static final int CREATIVE_VIEW_TRACKER_THRESHOLD = 0;
    private static final String EVENT = "event";
    private static final float FIRST_QUARTER_MARKER = 0.25F;
    private static final String FIRST_QUARTILE = "firstQuartile";
    public static final String ICON = "Icon";
    public static final String ICONS = "Icons";
    private static final String MEDIA_FILE = "MediaFile";
    private static final String MEDIA_FILES = "MediaFiles";
    private static final String MIDPOINT = "midpoint";
    private static final float MID_POINT_MARKER = 0.5F;
    private static final String OFFSET = "offset";
    private static final String PAUSE = "pause";
    private static final String PROGRESS = "progress";
    private static final String RESUME = "resume";
    private static final String SKIP = "skip";
    private static final String SKIP_OFFSET = "skipoffset";
    private static final String START = "start";
    private static final int START_TRACKER_THRESHOLD = 2000;
    private static final float THIRD_QUARTER_MARKER = 0.75F;
    private static final String THIRD_QUARTILE = "thirdQuartile";
    private static final String TRACKING_EVENTS = "TrackingEvents";
    private static final String VIDEO_CLICKS = "VideoClicks";
    private static final String VIDEO_TRACKER = "Tracking";
    private final Node mLinearNode;

    VastLinearXmlManager(Node node)
    {
        Preconditions.checkNotNull(node);
        mLinearNode = node;
    }

    private void addQuartileTrackerWithFraction(List list, List list1, float f)
    {
        Preconditions.checkNotNull(list, "trackers cannot be null");
        Preconditions.checkNotNull(list1, "urls cannot be null");
        for (list1 = list1.iterator(); list1.hasNext(); list.add(new VastFractionalProgressTracker((String)list1.next(), f))) { }
    }

    private List getVideoTrackersByAttribute(String s)
    {
        Preconditions.checkNotNull(s);
        ArrayList arraylist = new ArrayList();
        Node node = XmlUtils.getFirstMatchingChildNode(mLinearNode, "TrackingEvents");
        if (node != null)
        {
            s = XmlUtils.getMatchingChildNodes(node, "Tracking", "event", Collections.singletonList(s)).iterator();
            while (s.hasNext()) 
            {
                String s1 = XmlUtils.getNodeValue((Node)s.next());
                if (s1 != null)
                {
                    arraylist.add(s1);
                }
            }
        }
        return arraylist;
    }

    private List getVideoTrackersByAttributeAsVastTrackers(String s)
    {
        Object obj = getVideoTrackersByAttribute(s);
        s = new ArrayList(((List) (obj)).size());
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); s.add(new VastTracker((String)((Iterator) (obj)).next()))) { }
        return s;
    }

    List getAbsoluteProgressTrackers()
    {
        ArrayList arraylist;
        Object obj;
        Iterator iterator1;
        arraylist = new ArrayList();
        for (Iterator iterator = getVideoTrackersByAttribute("start").iterator(); iterator.hasNext(); arraylist.add(new VastAbsoluteProgressTracker((String)iterator.next(), 2000))) { }
        obj = XmlUtils.getFirstMatchingChildNode(mLinearNode, "TrackingEvents");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        iterator1 = XmlUtils.getMatchingChildNodes(((Node) (obj)), "Tracking", "event", Collections.singletonList("progress")).iterator();
_L2:
        String s;
        Object obj1;
        if (!iterator1.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (Node)iterator1.next();
        s = XmlUtils.getAttributeValue(((Node) (obj1)), "offset");
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s = s.trim();
        if (!Strings.isAbsoluteTracker(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = XmlUtils.getNodeValue(((Node) (obj1)));
        Integer integer = Strings.parseAbsoluteOffset(s);
        if (integer != null)
        {
            try
            {
                arraylist.add(new VastAbsoluteProgressTracker(((String) (obj1)), integer.intValue()));
            }
            catch (NumberFormatException numberformatexception)
            {
                MoPubLog.d(String.format("Failed to parse VAST progress tracker %s", new Object[] {
                    s
                }));
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
        for (obj = XmlUtils.getMatchingChildNodes(((Node) (obj)), "Tracking", "event", Collections.singletonList("creativeView")).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(new VastAbsoluteProgressTracker(XmlUtils.getNodeValue((Node)((Iterator) (obj)).next()), 0))) { }
        Collections.sort(arraylist);
        return arraylist;
    }

    String getClickThroughUrl()
    {
        Node node = XmlUtils.getFirstMatchingChildNode(mLinearNode, "VideoClicks");
        if (node == null)
        {
            return null;
        } else
        {
            return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(node, "ClickThrough"));
        }
    }

    List getClickTrackers()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = XmlUtils.getFirstMatchingChildNode(mLinearNode, "VideoClicks");
        if (obj != null)
        {
            obj = XmlUtils.getMatchingChildNodes(((Node) (obj)), "ClickTracking").iterator();
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

    List getFractionalProgressTrackers()
    {
        ArrayList arraylist = new ArrayList();
        addQuartileTrackerWithFraction(arraylist, getVideoTrackersByAttribute("firstQuartile"), 0.25F);
        addQuartileTrackerWithFraction(arraylist, getVideoTrackersByAttribute("midpoint"), 0.5F);
        addQuartileTrackerWithFraction(arraylist, getVideoTrackersByAttribute("thirdQuartile"), 0.75F);
        Object obj = XmlUtils.getFirstMatchingChildNode(mLinearNode, "TrackingEvents");
        if (obj != null)
        {
            obj = XmlUtils.getMatchingChildNodes(((Node) (obj)), "Tracking", "event", Collections.singletonList("progress")).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Object obj1 = (Node)((Iterator) (obj)).next();
                String s = XmlUtils.getAttributeValue(((Node) (obj1)), "offset");
                if (s != null)
                {
                    s = s.trim();
                    if (Strings.isPercentageTracker(s))
                    {
                        obj1 = XmlUtils.getNodeValue(((Node) (obj1)));
                        try
                        {
                            arraylist.add(new VastFractionalProgressTracker(((String) (obj1)), Float.parseFloat(s.replace("%", "")) / 100F));
                        }
                        catch (NumberFormatException numberformatexception)
                        {
                            MoPubLog.d(String.format("Failed to parse VAST progress tracker %s", new Object[] {
                                s
                            }));
                        }
                    }
                }
            } while (true);
        }
        Collections.sort(arraylist);
        return arraylist;
    }

    List getIconXmlManagers()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = XmlUtils.getFirstMatchingChildNode(mLinearNode, "Icons");
        if (obj != null)
        {
            obj = XmlUtils.getMatchingChildNodes(((Node) (obj)), "Icon").iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                arraylist.add(new VastIconXmlManager((Node)((Iterator) (obj)).next()));
            }
        }
        return arraylist;
    }

    List getMediaXmlManagers()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = XmlUtils.getFirstMatchingChildNode(mLinearNode, "MediaFiles");
        if (obj != null)
        {
            obj = XmlUtils.getMatchingChildNodes(((Node) (obj)), "MediaFile").iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                arraylist.add(new VastMediaXmlManager((Node)((Iterator) (obj)).next()));
            }
        }
        return arraylist;
    }

    List getPauseTrackers()
    {
        Object obj = getVideoTrackersByAttribute("pause");
        ArrayList arraylist = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(new VastTracker((String)((Iterator) (obj)).next(), true))) { }
        return arraylist;
    }

    List getResumeTrackers()
    {
        Object obj = getVideoTrackersByAttribute("resume");
        ArrayList arraylist = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(new VastTracker((String)((Iterator) (obj)).next(), true))) { }
        return arraylist;
    }

    String getSkipOffset()
    {
        String s;
        for (s = XmlUtils.getAttributeValue(mLinearNode, "skipoffset"); s == null || s.trim().isEmpty();)
        {
            return null;
        }

        return s.trim();
    }

    List getVideoCloseTrackers()
    {
        List list = getVideoTrackersByAttributeAsVastTrackers("close");
        list.addAll(getVideoTrackersByAttributeAsVastTrackers("closeLinear"));
        return list;
    }

    List getVideoCompleteTrackers()
    {
        return getVideoTrackersByAttributeAsVastTrackers("complete");
    }

    List getVideoSkipTrackers()
    {
        return getVideoTrackersByAttributeAsVastTrackers("skip");
    }
}
