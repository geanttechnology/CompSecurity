// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.vast.model;

import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.ad.interfaces.ISlot;
import tv.freewheel.hybrid.renderers.vast.util.StringUtils;
import tv.freewheel.hybrid.utils.XMLHandler;

// Referenced classes of package tv.freewheel.hybrid.renderers.vast.model:
//            AbstractCreativeRenditionCollection, Tracking, VideoClick, MediaFile

public class Linear extends AbstractCreativeRenditionCollection
{

    public String adParameters;
    public Double duration;
    public ArrayList mediaFiles;
    public ArrayList trackingEvents;
    public ArrayList videoClicks;

    public Linear()
    {
        trackingEvents = new ArrayList();
        videoClicks = new ArrayList();
        mediaFiles = new ArrayList();
    }

    public boolean isValid(ISlot islot, IConstants iconstants)
    {
        return validate(mediaFiles, islot, iconstants);
    }

    public void parse(Element element)
    {
        int i;
        int i1;
        NodeList nodelist = element.getElementsByTagName("AdParameters");
        if (nodelist.getLength() > 0)
        {
            adParameters = XMLHandler.getTextNodeValue(nodelist.item(0));
        }
        element = element.getChildNodes();
        i1 = element.getLength();
        i = 0;
_L1:
        Object obj;
        Object obj1;
        if (i >= i1)
        {
            break MISSING_BLOCK_LABEL_403;
        }
        obj = element.item(i);
        if (((Node) (obj)).getNodeType() == 1)
        {
            obj1 = ((Node) (obj)).getNodeName();
            if (((String) (obj1)).equals("Duration"))
            {
                obj = XMLHandler.getTextNodeValue(((Node) (obj))).split(":");
                if (obj.length == 3)
                {
                    duration = new Double(StringUtils.parseInt(obj[2]) + StringUtils.parseInt(obj[1]) * 60 + StringUtils.parseInt(obj[0]) * 60 * 60);
                }
            } else
            if (((String) (obj1)).equals("TrackingEvents"))
            {
                obj = ((Element)obj).getElementsByTagName("Tracking");
                int j = 0;
                while (j < ((NodeList) (obj)).getLength()) 
                {
                    obj1 = new Tracking();
                    ((Tracking) (obj1)).parse((Element)((NodeList) (obj)).item(j));
                    trackingEvents.add(obj1);
                    j++;
                }
            } else
            {
                if (!((String) (obj1)).equals("VideoClicks"))
                {
                    continue; /* Loop/switch isn't completed */
                }
                obj = ((Node) (obj)).getChildNodes();
                int k = 0;
                while (k < ((NodeList) (obj)).getLength()) 
                {
                    obj1 = ((NodeList) (obj)).item(k);
                    if (((Node) (obj1)).getNodeType() == 1)
                    {
                        VideoClick videoclick = new VideoClick(((Node) (obj1)).getNodeName());
                        videoclick.parse((Element)obj1);
                        videoClicks.add(videoclick);
                    }
                    k++;
                }
            }
        }
_L3:
        i++;
          goto _L1
        if (!((String) (obj1)).equals("MediaFiles")) goto _L3; else goto _L2
_L2:
        obj = ((Element)obj).getElementsByTagName("MediaFile");
        int l = 0;
        while (l < ((NodeList) (obj)).getLength()) 
        {
            MediaFile mediafile = new MediaFile(this);
            mediafile.parse((Element)((NodeList) (obj)).item(l));
            mediaFiles.add(mediafile);
            l++;
        }
          goto _L3
    }

    public ArrayList search(ISlot islot, IConstants iconstants)
    {
        return searchAll(mediaFiles, islot, iconstants);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator iterator = trackingEvents.iterator(); iterator.hasNext(); stringbuilder.append("\n\t\t\t\t\t"))
        {
            stringbuilder.append((Tracking)iterator.next());
        }

        return String.format("[Linear\n\t\t\t\tDuration=%f\n\t\t\t\tAdParameters=%s\n\t\t\t\tTrackingEvents=%s\n\t\t\t\tVideoClicks=%s\n\t\t\t\tMediaFiles=%s\n\t\t\t]", new Object[] {
            duration, adParameters, stringbuilder.toString(), videoClicks, mediaFiles
        });
    }
}
