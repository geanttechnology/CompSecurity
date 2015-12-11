// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.vast.model;

import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.ad.interfaces.ISlot;

// Referenced classes of package tv.freewheel.hybrid.renderers.vast.model:
//            AbstractCreativeRenditionCollection, Tracking, NonLinear

public class NonLinearAds extends AbstractCreativeRenditionCollection
{

    ArrayList nonLinears;
    ArrayList trackingEvents;

    public NonLinearAds()
    {
        trackingEvents = new ArrayList();
        nonLinears = new ArrayList();
    }

    public boolean isValid(ISlot islot, IConstants iconstants)
    {
        return validate(nonLinears, islot, iconstants);
    }

    public void parse(Element element)
    {
        for (int i = 0; i < element.getChildNodes().getLength(); i++)
        {
            Object obj = element.getChildNodes().item(i);
            if (((Node) (obj)).getNodeType() != 1)
            {
                continue;
            }
            Object obj1 = ((Node) (obj)).getNodeName();
            if (((String) (obj1)).equals("TrackingEvents"))
            {
                obj = ((Element)obj).getElementsByTagName("Tracking");
                for (int j = 0; j < ((NodeList) (obj)).getLength(); j++)
                {
                    obj1 = new Tracking();
                    ((Tracking) (obj1)).parse((Element)((NodeList) (obj)).item(j));
                    trackingEvents.add(obj1);
                }

                continue;
            }
            if (((String) (obj1)).equals("NonLinear"))
            {
                NonLinear nonlinear = new NonLinear();
                nonlinear.parse((Element)obj);
                nonLinears.add(nonlinear);
            }
        }

    }

    public ArrayList search(ISlot islot, IConstants iconstants)
    {
        return searchAll(nonLinears, islot, iconstants);
    }
}
