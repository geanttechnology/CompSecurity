// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad;

import java.util.HashMap;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.ad:
//            AdContextScoped, AdContext

public class ParametersHolder extends AdContextScoped
{

    public HashMap parameters;

    public ParametersHolder(AdContext adcontext)
    {
        super(adcontext);
        parameters = new HashMap();
    }

    public static HashMap parseParameters(Element element)
    {
        HashMap hashmap = new HashMap();
        NodeList nodelist = element.getChildNodes();
        for (int i = 0; i < nodelist.getLength(); i++)
        {
            element = nodelist.item(i);
            if (element.getNodeType() != 1 || !element.getNodeName().equals("parameter"))
            {
                continue;
            }
            element = (Element)element;
            String s1 = element.getAttribute("name");
            String s = getTextNodeValue(element);
            element = s;
            if (s == null)
            {
                element = "";
            }
            if (s1 != null)
            {
                hashmap.put(s1, element);
                Logger.getLogger("ParametersHolder").debug((new StringBuilder()).append("profile parameter name:").append(s1).append(" value:").append(element).toString());
            }
        }

        return hashmap;
    }

    protected void parseRendererParameters(Element element)
    {
        NodeList nodelist = element.getChildNodes();
        int i = 0;
        while (i < nodelist.getLength()) 
        {
            element = nodelist.item(i);
            if (element.getNodeType() == 1)
            {
                String s = element.getNodeName();
                logger.verbose((new StringBuilder()).append("parse(), name: ").append(s).toString());
                if (s.equals("parameter"))
                {
                    element = (Element)element;
                    String s1 = element.getAttribute("name");
                    s = element.getAttribute("value");
                    element = s;
                    if (s == null)
                    {
                        element = "";
                    }
                    if (s1 != null)
                    {
                        parameters.put(s1, element);
                    }
                } else
                {
                    logger.warn((new StringBuilder()).append("ignore node: ").append(s).toString());
                }
            }
            i++;
        }
    }
}
