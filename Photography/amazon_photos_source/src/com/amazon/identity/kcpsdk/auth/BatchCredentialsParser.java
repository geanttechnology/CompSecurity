// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.kcpsdk.common.XMLParserHelpers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class BatchCredentialsParser
{
    private static final class ReferenceInfo
    {

        private final String mCredType;
        private final String mDeviceType;
        private final String mRefDeviceType;

        public String getCredentialType()
        {
            return mCredType;
        }

        public String getDeviceType()
        {
            return mDeviceType;
        }

        public String getReferenceDeviceType()
        {
            return mRefDeviceType;
        }

        public ReferenceInfo(String s, String s1, String s2)
        {
            mDeviceType = s;
            mCredType = s1;
            mRefDeviceType = s2;
        }
    }


    public static Map parseBatchCredentialsResponse(Element element)
    {
        HashMap hashmap = new HashMap();
        LinkedList linkedlist = new LinkedList();
        if (element != null)
        {
            NodeList nodelist = element.getChildNodes();
label0:
            for (int i = 0; i < nodelist.getLength(); i++)
            {
                Object obj = nodelist.item(i);
                if (((Node) (obj)).getNodeType() != 1)
                {
                    continue;
                }
                element = (Element)obj;
                if (!element.hasAttribute("deviceType"))
                {
                    continue;
                }
                String s = element.getAttribute("deviceType");
                int j;
                if (!hashmap.containsKey(s))
                {
                    element = new HashMap();
                    hashmap.put(s, element);
                } else
                {
                    element = (Map)hashmap.get(s);
                }
                obj = ((Node) (obj)).getChildNodes();
                j = 0;
                do
                {
                    if (j >= ((NodeList) (obj)).getLength())
                    {
                        continue label0;
                    }
                    Node node = ((NodeList) (obj)).item(j);
                    if (node.getNodeType() == 1)
                    {
                        Object obj1 = (Element)node;
                        if (((Element) (obj1)).hasAttribute("refDeviceType"))
                        {
                            obj1 = ((Element) (obj1)).getAttribute("refDeviceType");
                            linkedlist.add(new ReferenceInfo(s, node.getNodeName(), ((String) (obj1))));
                        } else
                        {
                            String s1 = XMLParserHelpers.getTextContent((Element)node);
                            element.put(node.getNodeName(), s1);
                        }
                    }
                    j++;
                } while (true);
            }

            element = linkedlist.iterator();
            while (element.hasNext()) 
            {
                ReferenceInfo referenceinfo = (ReferenceInfo)element.next();
                ((Map)hashmap.get(referenceinfo.getDeviceType())).put(referenceinfo.getCredentialType(), ((Map)hashmap.get(referenceinfo.getReferenceDeviceType())).get(referenceinfo.getCredentialType()));
            }
        }
        return hashmap;
    }
}
