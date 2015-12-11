// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.ad:
//            ParametersHolder, CreativeRendition, AdContext

public class Creative extends ParametersHolder
{

    public String baseUnit;
    public int creativeId;
    public ArrayList creativeRenditions;
    public double duration;

    public Creative(AdContext adcontext)
    {
        super(adcontext);
        creativeRenditions = new ArrayList();
    }

    public Creative cloneForTranslation()
    {
        Creative creative = new Creative(context);
        creative.creativeId = creativeId;
        creative.duration = duration;
        creative.baseUnit = baseUnit;
        creative.parameters.clear();
        creative.parameters.putAll(parameters);
        return creative;
    }

    public CreativeRendition createCreativeRendition()
    {
        CreativeRendition creativerendition = new CreativeRendition(this);
        creativeRenditions.add(creativerendition);
        return creativerendition;
    }

    public CreativeRendition getRendition(int i, int j)
    {
        CreativeRendition creativerendition = null;
        Iterator iterator = creativeRenditions.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            CreativeRendition creativerendition1 = (CreativeRendition)iterator.next();
            if (creativerendition1.creativeRenditionId == i)
            {
                if (creativerendition1.replicaId == j)
                {
                    return creativerendition1;
                }
                if (creativerendition == null || creativerendition1.replicaId < creativerendition.replicaId)
                {
                    creativerendition = creativerendition1;
                }
            }
        } while (true);
        return creativerendition;
    }

    public void parse(Element element)
    {
        creativeId = tryParseInt(element.getAttribute("creativeId"));
        duration = tryParseDouble(element.getAttribute("duration"));
        baseUnit = element.getAttribute("baseUnit");
        logger.verbose((new StringBuilder()).append("parse(), creative: ").append(creativeId).append(", parsed duration: ").append(duration).toString());
        element = element.getChildNodes();
        int i = 0;
        while (i < element.getLength()) 
        {
            Node node = element.item(i);
            if (node.getNodeType() == 1)
            {
                String s = node.getNodeName();
                logger.verbose((new StringBuilder()).append("parse(), name: ").append(s).toString());
                if (s.equals("creativeRenditions"))
                {
                    parseCreativeRenditions((Element)node);
                } else
                if (s.equals("parameters"))
                {
                    parameters = parseParameters((Element)node);
                } else
                {
                    logger.warn((new StringBuilder()).append("ignore node: ").append(s).toString());
                }
            }
            i++;
        }
    }

    public void parseCreativeRenditions(Element element)
    {
        element = element.getChildNodes();
        int i = 0;
        while (i < element.getLength()) 
        {
            Node node = element.item(i);
            if (node.getNodeType() == 1)
            {
                Object obj = node.getNodeName();
                logger.verbose((new StringBuilder()).append("parse(), name: ").append(((String) (obj))).toString());
                if (((String) (obj)).equals("creativeRendition"))
                {
                    obj = new CreativeRendition(this);
                    ((CreativeRendition) (obj)).parse((Element)node);
                    ((CreativeRendition) (obj)).setDuration(duration);
                    creativeRenditions.add(obj);
                } else
                {
                    logger.warn((new StringBuilder()).append("ignore node: ").append(((String) (obj))).toString());
                }
            }
            i++;
        }
    }
}
