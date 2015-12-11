// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public final class XMLParserHelpers
{

    public static Element getFirstElementWithTag(Element element, String s)
    {
        if (element != null)
        {
            if ((element = element.getElementsByTagName(s)).getLength() != 0)
            {
                return (Element)element.item(0);
            }
        }
        return null;
    }

    public static String getFirstTextElementValue(Element element)
    {
        if (element != null)
        {
            element = element.getChildNodes();
            int i = 0;
            while (i < element.getLength()) 
            {
                Node node = element.item(i);
                if (node.getNodeType() == 3)
                {
                    return ((Text)node).getNodeValue();
                }
                i++;
            }
        }
        return null;
    }

    public static Element getNextChildElementWithTag(Element element, String s)
    {
        if (element != null) goto _L2; else goto _L1
_L1:
        element = null;
_L6:
        return element;
_L2:
        NodeList nodelist;
        int i;
        nodelist = element.getChildNodes();
        i = 0;
_L7:
        if (i >= nodelist.getLength()) goto _L4; else goto _L3
_L3:
        Element element1;
        element = nodelist.item(i);
        if (element.getNodeType() != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        element1 = (Element)element;
        element = element1;
        if (s.equalsIgnoreCase(element1.getTagName())) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L4:
        return null;
    }

    public static String getTextContent(Element element)
    {
        if (element == null)
        {
            return null;
        } else
        {
            return element.getTextContent();
        }
    }

    public static boolean hasElementWithTag(Element element, String s)
    {
        return element != null && element.getElementsByTagName(s).getLength() > 0;
    }
}
