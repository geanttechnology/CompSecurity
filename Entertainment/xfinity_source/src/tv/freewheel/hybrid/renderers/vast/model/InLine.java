// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.vast.model;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.hybrid.utils.XMLHandler;

// Referenced classes of package tv.freewheel.hybrid.renderers.vast.model:
//            AbstractAd

public class InLine extends AbstractAd
{

    public String adTitle;
    public String description;
    public String survey;

    public InLine()
    {
    }

    public void parse(Element element)
    {
        super.parse(element);
        int i = 0;
        while (i < element.getChildNodes().getLength()) 
        {
            Node node = element.getChildNodes().item(i);
            if (node.getNodeType() == 1)
            {
                if (node.getNodeName().equals("AdTitle"))
                {
                    adTitle = XMLHandler.getTextNodeValue(node);
                }
            } else
            if (node.getNodeType() == 1)
            {
                if (node.getNodeName().equals("Description"))
                {
                    description = XMLHandler.getTextNodeValue(node);
                }
            } else
            if (node.getNodeType() == 1 && node.getNodeName().equals("Survey"))
            {
                survey = XMLHandler.getTextNodeValue(node);
            }
            i++;
        }
    }
}
