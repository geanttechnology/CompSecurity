// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast.model;

import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ISlot;

// Referenced classes of package tv.freewheel.renderers.vast.model:
//            IVastValidation, Linear, NonLinearAds, CompanionAds

public class Creative
    implements IVastValidation
{

    String adId;
    public CompanionAds companionAds;
    public Linear linear;
    public NonLinearAds nonLinearAds;

    public Creative()
    {
    }

    public ArrayList getTrackingEvents(ISlot islot, IConstants iconstants)
    {
        if (linear != null && islot.getType() == iconstants.SLOT_TYPE_TEMPORAL() && islot.getTimePositionClass() != iconstants.TIME_POSITION_CLASS_OVERLAY())
        {
            return linear.trackingEvents;
        }
        if (nonLinearAds != null && islot.getTimePositionClass() == iconstants.TIME_POSITION_CLASS_OVERLAY())
        {
            return nonLinearAds.trackingEvents;
        } else
        {
            return new ArrayList();
        }
    }

    public boolean isValid(ISlot islot, IConstants iconstants)
    {
        return linear != null && linear.isValid(islot, iconstants) || nonLinearAds != null && nonLinearAds.isValid(islot, iconstants) || companionAds != null && companionAds.isValid(islot, iconstants);
    }

    public void parse(Element element)
    {
        adId = element.getAttribute("AdID");
        element = element.getChildNodes();
        int j = element.getLength();
        int i = 0;
        while (i < j) 
        {
            Node node = element.item(i);
            if (node.getNodeType() == 1)
            {
                String s = node.getNodeName();
                if (s.equals("Linear"))
                {
                    linear = new Linear();
                    linear.parse((Element)node);
                } else
                if (s.equals("NonLinearAds"))
                {
                    nonLinearAds = new NonLinearAds();
                    nonLinearAds.parse((Element)node);
                } else
                if (s.equals("CompanionAds"))
                {
                    companionAds = new CompanionAds();
                    companionAds.parse((Element)node);
                }
            }
            i++;
        }
    }

    public ArrayList searchInCompanionSlot(ISlot islot, IConstants iconstants)
    {
        if (companionAds != null && companionAds.isValid(islot, iconstants))
        {
            return companionAds.search(islot, iconstants);
        } else
        {
            return new ArrayList();
        }
    }

    public ArrayList searchInDrivingSlot(ISlot islot, IConstants iconstants)
    {
        if (linear != null && linear.isValid(islot, iconstants))
        {
            return linear.search(islot, iconstants);
        }
        if (nonLinearAds != null && nonLinearAds.isValid(islot, iconstants))
        {
            return nonLinearAds.search(islot, iconstants);
        } else
        {
            return new ArrayList();
        }
    }

    public String toString()
    {
        return String.format("[Creative\n\t\t\tadId=%s\n\t\t\tLinear=%s\n\t\t\tCompanions=%s\n\t\t\tNonLinearAds=%s\n\t\t]", new Object[] {
            adId, linear, companionAds, nonLinearAds
        });
    }
}
