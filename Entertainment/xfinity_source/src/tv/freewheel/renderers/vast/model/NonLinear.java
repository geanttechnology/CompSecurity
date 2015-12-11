// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast.model;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.ad.interfaces.IAdInstance;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ICreativeRendition;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.renderers.vast.util.StringUtils;
import tv.freewheel.utils.XMLHandler;

// Referenced classes of package tv.freewheel.renderers.vast.model:
//            AbstractNonMediaFile

public class NonLinear extends AbstractNonMediaFile
{

    Boolean maintainAspectRatio;
    String minSuggestionDuration;
    String nonLinearClickThrough;
    Boolean scalable;

    public NonLinear()
    {
    }

    String getClickThroughURL()
    {
        return nonLinearClickThrough;
    }

    public boolean isValid(ISlot islot, IConstants iconstants)
    {
        if (islot.getTimePositionClass() == iconstants.TIME_POSITION_CLASS_OVERLAY())
        {
            return super.isValid(islot, iconstants);
        } else
        {
            return false;
        }
    }

    public void parse(Element element)
    {
        super.parse(element);
        scalable = StringUtils.parseBoolean(element.getAttribute("scalable"));
        maintainAspectRatio = StringUtils.parseBoolean(element.getAttribute("maintainAspectRatio"));
        minSuggestionDuration = element.getAttribute("minSuggestionDuration");
        for (int i = 0; i < element.getChildNodes().getLength(); i++)
        {
            Node node = element.getChildNodes().item(i);
            if (node.getNodeType() == 1 && node.getNodeName().equals("NonLinearClickThrough"))
            {
                nonLinearClickThrough = XMLHandler.getTextNodeValue(node);
            }
        }

    }

    public String toString()
    {
        return String.format("[NonLinear  %s minSuggestionDuration=%s nonLinearClickThrough=%s scalable=%b maintainAspectRatio=%b ]", new Object[] {
            super.toString(), minSuggestionDuration, nonLinearClickThrough, scalable, maintainAspectRatio
        });
    }

    public void translateToFWCreativeRendition(ICreativeRendition icreativerendition, IAdInstance iadinstance, IAdInstance iadinstance1, IConstants iconstants)
    {
        if (iadinstance1.getActiveCreativeRendition() != null)
        {
            icreativerendition.setDuration(iadinstance1.getActiveCreativeRendition().getDuration());
        }
        super.translateToFWCreativeRendition(icreativerendition, iadinstance, iadinstance1, iconstants);
    }
}
