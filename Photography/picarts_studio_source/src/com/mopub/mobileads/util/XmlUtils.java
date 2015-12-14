// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtils
{

    private XmlUtils()
    {
    }

    public static String getAttributeValue(Node node, String s)
    {
        if (node != null && s != null)
        {
            if ((node = node.getAttributes().getNamedItem(s)) != null)
            {
                return node.getNodeValue();
            }
        }
        return null;
    }

    public static Integer getAttributeValueAsInt(Node node, String s)
    {
        if (node == null || s == null)
        {
            return null;
        }
        int i;
        try
        {
            i = Integer.parseInt(getAttributeValue(node, s));
        }
        // Misplaced declaration of an exception variable
        catch (Node node)
        {
            return null;
        }
        return Integer.valueOf(i);
    }

    public static Object getFirstMatchFromDocument(Document document, String s, String s1, String s2, NodeProcessor nodeprocessor)
    {
        int i = 0;
        if (document != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((s = document.getElementsByTagName(s)) != null)
        {
            if (s2 == null)
            {
                document = null;
            } else
            {
                document = Arrays.asList(new String[] {
                    s2
                });
            }
            while (i < s.getLength()) 
            {
                s2 = s.item(i);
                if (s2 != null && nodeMatchesAttributeFilter(s2, s1, document))
                {
                    s2 = ((String) (nodeprocessor.process(s2)));
                    if (s2 != null)
                    {
                        return s2;
                    }
                }
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static Node getFirstMatchingChildNode(Node node, String s)
    {
        return getFirstMatchingChildNode(node, s, null, null);
    }

    public static Node getFirstMatchingChildNode(Node node, String s, String s1, List list)
    {
        if (node != null && s != null)
        {
            if ((node = getMatchingChildNodes(node, s, s1, list)) != null && !node.isEmpty())
            {
                return (Node)node.get(0);
            }
        }
        return null;
    }

    public static String getFirstMatchingStringData(Document document, String s)
    {
        return getFirstMatchingStringData(document, s, null, null);
    }

    public static String getFirstMatchingStringData(Document document, String s, String s1, String s2)
    {
        return (String)getFirstMatchFromDocument(document, s, s1, s2, new NodeProcessor() {

            public final volatile Object process(Node node)
            {
                return process(node);
            }

            public final String process(Node node)
            {
                return XmlUtils.getNodeValue(node);
            }

        });
    }

    public static List getListFromDocument(Document document, String s, String s1, String s2, NodeProcessor nodeprocessor)
    {
        int i = 0;
        ArrayList arraylist = new ArrayList();
        if (document == null)
        {
            return arraylist;
        }
        s = document.getElementsByTagName(s);
        if (s == null)
        {
            return arraylist;
        }
        if (s2 == null)
        {
            document = null;
        } else
        {
            document = Arrays.asList(new String[] {
                s2
            });
        }
        for (; i < s.getLength(); i++)
        {
            s2 = s.item(i);
            if (s2 == null || !nodeMatchesAttributeFilter(s2, s1, document))
            {
                continue;
            }
            s2 = ((String) (nodeprocessor.process(s2)));
            if (s2 != null)
            {
                arraylist.add(s2);
            }
        }

        return arraylist;
    }

    public static List getMatchingChildNodes(Node node, String s)
    {
        return getMatchingChildNodes(node, s, null, null);
    }

    public static List getMatchingChildNodes(Node node, String s, String s1, List list)
    {
        if (node == null || s == null)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        node = node.getChildNodes();
        for (int i = 0; i < node.getLength(); i++)
        {
            Node node1 = node.item(i);
            if (node1.getNodeName().equals(s) && nodeMatchesAttributeFilter(node1, s1, list))
            {
                arraylist.add(node1);
            }
        }

        return arraylist;
    }

    public static String getNodeValue(Node node)
    {
        if (node != null && node.getFirstChild() != null && node.getFirstChild().getNodeValue() != null)
        {
            return node.getFirstChild().getNodeValue().trim();
        } else
        {
            return null;
        }
    }

    public static List getNodesWithElementAndAttribute(Document document, String s, String s1, String s2)
    {
        return getListFromDocument(document, s, s1, s2, new NodeProcessor() {

            public final volatile Object process(Node node)
            {
                return process(node);
            }

            public final Node process(Node node)
            {
                return node;
            }

        });
    }

    public static List getStringDataAsList(Document document, String s)
    {
        return getStringDataAsList(document, s, null, null);
    }

    public static List getStringDataAsList(Document document, String s, String s1, String s2)
    {
        return getListFromDocument(document, s, s1, s2, new NodeProcessor() {

            public final volatile Object process(Node node)
            {
                return process(node);
            }

            public final String process(Node node)
            {
                return XmlUtils.getNodeValue(node);
            }

        });
    }

    public static boolean nodeMatchesAttributeFilter(Node node, String s, List list)
    {
        if (s != null && list != null) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        node = node.getAttributes();
        if (node == null)
        {
            break; /* Loop/switch isn't completed */
        }
        node = node.getNamedItem(s);
        if (node != null && list.contains(node.getNodeValue())) goto _L1; else goto _L3
_L3:
        return false;
    }

    private class NodeProcessor
    {

        public abstract Object process(Node node);
    }

}
