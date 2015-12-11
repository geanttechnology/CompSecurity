// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.kcpsdk.common.XMLParserHelpers;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            Cookie

public class CookieParser
{

    public CookieParser()
    {
    }

    public List parseStandardKindleCookieResponse(Element element)
    {
        ArrayList arraylist = new ArrayList();
        if (element != null)
        {
            element = element.getChildNodes();
            int i = 0;
            while (i < element.getLength()) 
            {
                Object obj = element.item(i);
                if (((Node) (obj)).getNodeType() == 1)
                {
                    Object obj1 = (Element)obj;
                    obj = XMLParserHelpers.getFirstElementWithTag(((Element) (obj1)), "url");
                    obj1 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj1)), "value");
                    obj = XMLParserHelpers.getTextContent(((Element) (obj)));
                    obj1 = XMLParserHelpers.getTextContent(((Element) (obj1)));
                    Cookie cookie = new Cookie();
                    cookie.setUrl(((String) (obj)));
                    cookie.setValue(((String) (obj1)));
                    arraylist.add(cookie);
                }
                i++;
            }
        }
        return arraylist;
    }
}
