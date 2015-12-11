// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.xml.parser;

import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.cybergarage.xml.Parser;
import org.cybergarage.xml.ParserException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class JaxpParser extends Parser
{

    public JaxpParser()
    {
    }

    public org.cybergarage.xml.Node parse(InputStream inputstream)
        throws ParserException
    {
        Object obj = null;
        org.w3c.dom.Element element;
        try
        {
            element = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(inputstream)).getDocumentElement();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new ParserException(inputstream);
        }
        inputstream = obj;
        if (element == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        inputstream = parse(null, ((Node) (element)));
        return inputstream;
    }

    public org.cybergarage.xml.Node parse(org.cybergarage.xml.Node node, Node node1)
    {
        return parse(node, node1, 0);
    }

    public org.cybergarage.xml.Node parse(org.cybergarage.xml.Node node, Node node1, int i)
    {
        String s;
        String s1;
        int j;
        j = node1.getNodeType();
        s = node1.getNodeName();
        s1 = node1.getNodeValue();
        NamedNodeMap namednodemap = node1.getAttributes();
        if (namednodemap != null)
        {
            namednodemap.getLength();
        }
        if (j != 3) goto _L2; else goto _L1
_L1:
        node.addValue(s1);
_L4:
        return node;
_L2:
        if (j != 1) goto _L4; else goto _L3
_L3:
        org.cybergarage.xml.Node node2;
        node2 = new org.cybergarage.xml.Node();
        node2.setName(s);
        node2.setValue(s1);
        if (node != null)
        {
            node.addNode(node2);
        }
        node = node1.getAttributes();
        if (node == null) goto _L6; else goto _L5
_L5:
        int k;
        k = node.getLength();
        j = 0;
_L9:
        if (j < k) goto _L7; else goto _L6
_L6:
        node1 = node1.getFirstChild();
        node = node1;
        if (node1 == null)
        {
            node2.setValue("");
            return node2;
        }
        break; /* Loop/switch isn't completed */
_L7:
        Node node3 = node.item(j);
        node2.setAttribute(node3.getNodeName(), node3.getNodeValue());
        j++;
        if (true) goto _L9; else goto _L8
_L8:
        do
        {
            parse(node2, ((Node) (node)), i + 1);
            node1 = node.getNextSibling();
            node = node1;
        } while (node1 != null);
        return node2;
    }
}
