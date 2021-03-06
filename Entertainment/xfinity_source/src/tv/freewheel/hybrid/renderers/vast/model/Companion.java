// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.vast.model;

import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.hybrid.ad.interfaces.IAdInstance;
import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.ad.interfaces.ICreativeRendition;
import tv.freewheel.hybrid.ad.interfaces.ISlot;
import tv.freewheel.hybrid.utils.XMLHandler;

// Referenced classes of package tv.freewheel.hybrid.renderers.vast.model:
//            AbstractNonMediaFile, Tracking

public class Companion extends AbstractNonMediaFile
{

    String altText;
    String companionClickThrough;
    ArrayList trackingEvents;

    public Companion()
    {
        trackingEvents = new ArrayList();
    }

    String getAltText()
    {
        return altText;
    }

    String getClickThroughURL()
    {
        return companionClickThrough;
    }

    public ArrayList getTrackingEvents()
    {
        return trackingEvents;
    }

    public boolean isValid(ISlot islot, IConstants iconstants)
    {
        return super.isValid(islot, iconstants);
    }

    public boolean isValidCompanion(ISlot islot, IConstants iconstants)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (islot.getType() != iconstants.SLOT_TYPE_TEMPORAL())
        {
            flag = flag1;
            if (super.isValid(islot, iconstants))
            {
                flag = flag1;
                if (width.intValue() <= islot.getWidth())
                {
                    flag = flag1;
                    if (height.intValue() <= islot.getHeight())
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public void parse(Element element)
    {
        super.parse(element);
        int i = 0;
        while (i < element.getChildNodes().getLength()) 
        {
            Object obj = element.getChildNodes().item(i);
            if (((Node) (obj)).getNodeType() == 1)
            {
                Object obj1 = ((Node) (obj)).getNodeName();
                if (((String) (obj1)).equals("CompanionClickThrough"))
                {
                    companionClickThrough = XMLHandler.getTextNodeValue(((Node) (obj)));
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
                if (((String) (obj1)).equals("AltText"))
                {
                    altText = XMLHandler.getTextNodeValue(((Node) (obj)));
                }
            }
            i++;
        }
    }

    public String toString()
    {
        return String.format("[Companion  %s companionClickThrough=%s trackingEvents=%s altText=%s  ]", new Object[] {
            super.toString(), companionClickThrough, trackingEvents, altText
        });
    }

    public volatile void translateToFWCreativeRendition(ICreativeRendition icreativerendition, IAdInstance iadinstance, IAdInstance iadinstance1, IConstants iconstants)
    {
        super.translateToFWCreativeRendition(icreativerendition, iadinstance, iadinstance1, iconstants);
    }
}
