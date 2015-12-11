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
//            AbstractCreativeRenditionCollection, Companion

class CompanionAds extends AbstractCreativeRenditionCollection
{

    ArrayList companions;

    public CompanionAds()
    {
        companions = new ArrayList();
    }

    public boolean isValid(ISlot islot, IConstants iconstants)
    {
        return validate(companions, islot, iconstants);
    }

    public void parse(Element element)
    {
        element = element.getChildNodes();
        for (int i = 0; i < element.getLength(); i++)
        {
            Node node = element.item(i);
            if (node.getNodeType() == 1 && node.getNodeName().equals("Companion"))
            {
                Companion companion = new Companion();
                companion.parse((Element)node);
                companions.add(companion);
            }
        }

    }

    public ArrayList search(ISlot islot, IConstants iconstants)
    {
        return searchAll(companions, islot, iconstants);
    }
}
