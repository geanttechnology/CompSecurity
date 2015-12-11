// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.soap;

import java.io.ByteArrayInputStream;
import org.cybergarage.http.HTTPRequest;
import org.cybergarage.util.Debug;
import org.cybergarage.xml.Node;
import org.cybergarage.xml.Parser;
import org.cybergarage.xml.ParserException;

// Referenced classes of package org.cybergarage.soap:
//            SOAP, SOAPResponse

public class SOAPRequest extends HTTPRequest
{

    private static final String SOAPACTION = "SOAPACTION";
    private Node rootNode;

    public SOAPRequest()
    {
        setContentType("text/xml; charset=\"utf-8\"");
        setMethod("POST");
    }

    public SOAPRequest(HTTPRequest httprequest)
    {
        set(httprequest);
    }

    private Node getRootNode()
    {
        this;
        JVM INSTR monitorenter ;
        if (rootNode == null) goto _L2; else goto _L1
_L1:
        Object obj = rootNode;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((Node) (obj));
_L2:
        obj = new ByteArrayInputStream(getContent());
        rootNode = SOAP.getXMLParser().parse(((java.io.InputStream) (obj)));
_L5:
        obj = rootNode;
        if (true) goto _L4; else goto _L3
_L3:
        Object obj1;
        obj1;
        Debug.warning(((Exception) (obj1)));
          goto _L5
        obj1;
        throw obj1;
    }

    private void setRootNode(Node node)
    {
        rootNode = node;
    }

    public Node getBodyNode()
    {
        Node node;
        for (node = getEnvelopeNode(); node == null || !node.hasNodes();)
        {
            return null;
        }

        return node.getNode(0);
    }

    public Node getEnvelopeNode()
    {
        return getRootNode();
    }

    public String getSOAPAction()
    {
        return getStringHeaderValue("SOAPACTION");
    }

    public boolean isSOAPAction(String s)
    {
        String s1 = getHeaderValue("SOAPACTION");
        if (s1 != null)
        {
            if (s1.equals(s))
            {
                return true;
            }
            s1 = getSOAPAction();
            if (s1 != null)
            {
                return s1.equals(s);
            }
        }
        return false;
    }

    public SOAPResponse postMessage(String s, int i)
    {
        s = new SOAPResponse(post(s, i));
        byte abyte0[] = s.getContent();
        if (abyte0.length <= 0)
        {
            return s;
        }
        try
        {
            ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte0);
            s.setEnvelopeNode(SOAP.getXMLParser().parse(bytearrayinputstream));
        }
        catch (Exception exception)
        {
            Debug.warning(exception);
            return s;
        }
        return s;
    }

    public void print()
    {
        Debug.message(toString());
        Node node;
        if (!hasContent())
        {
            if ((node = getRootNode()) != null)
            {
                Debug.message(node.toString());
                return;
            }
        }
    }

    public void setContent(Node node)
    {
        setContent((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(""))).append("<?xml version=\"1.0\" encoding=\"utf-8\"?>").toString()))).append("\n").toString()))).append(node.toString()).toString());
    }

    public void setEnvelopeNode(Node node)
    {
        setRootNode(node);
    }

    public void setSOAPAction(String s)
    {
        setStringHeader("SOAPACTION", s);
    }
}
