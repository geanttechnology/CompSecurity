// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.soap;

import org.cybergarage.http.HTTPResponse;
import org.cybergarage.util.Debug;
import org.cybergarage.xml.Node;

// Referenced classes of package org.cybergarage.soap:
//            SOAP

public class SOAPResponse extends HTTPResponse
{

    private Node rootNode;

    public SOAPResponse()
    {
        setRootNode(SOAP.createEnvelopeBodyNode());
        setContentType("text/xml; charset=\"utf-8\"");
    }

    public SOAPResponse(HTTPResponse httpresponse)
    {
        super(httpresponse);
        setRootNode(SOAP.createEnvelopeBodyNode());
        setContentType("text/xml; charset=\"utf-8\"");
    }

    public SOAPResponse(SOAPResponse soapresponse)
    {
        super(soapresponse);
        setEnvelopeNode(soapresponse.getEnvelopeNode());
        setContentType("text/xml; charset=\"utf-8\"");
    }

    private Node getRootNode()
    {
        return rootNode;
    }

    private void setRootNode(Node node)
    {
        rootNode = node;
    }

    public Node getBodyNode()
    {
        Node node = getEnvelopeNode();
        if (node == null)
        {
            return null;
        } else
        {
            return node.getNodeEndsWith("Body");
        }
    }

    public Node getEnvelopeNode()
    {
        return getRootNode();
    }

    public String getFaultActor()
    {
        Node node = getFaultActorNode();
        if (node == null)
        {
            return "";
        } else
        {
            return node.getValue();
        }
    }

    public Node getFaultActorNode()
    {
        Node node = getFaultNode();
        if (node == null)
        {
            return null;
        } else
        {
            return node.getNodeEndsWith("faultactor");
        }
    }

    public String getFaultCode()
    {
        Node node = getFaultCodeNode();
        if (node == null)
        {
            return "";
        } else
        {
            return node.getValue();
        }
    }

    public Node getFaultCodeNode()
    {
        Node node = getFaultNode();
        if (node == null)
        {
            return null;
        } else
        {
            return node.getNodeEndsWith("faultcode");
        }
    }

    public Node getFaultDetailNode()
    {
        Node node = getFaultNode();
        if (node == null)
        {
            return null;
        } else
        {
            return node.getNodeEndsWith("detail");
        }
    }

    public Node getFaultNode()
    {
        Node node = getBodyNode();
        if (node == null)
        {
            return null;
        } else
        {
            return node.getNodeEndsWith("Fault");
        }
    }

    public String getFaultString()
    {
        Node node = getFaultStringNode();
        if (node == null)
        {
            return "";
        } else
        {
            return node.getValue();
        }
    }

    public Node getFaultStringNode()
    {
        Node node = getFaultNode();
        if (node == null)
        {
            return null;
        } else
        {
            return node.getNodeEndsWith("faultstring");
        }
    }

    public Node getMethodResponseNode(String s)
    {
        Node node = getBodyNode();
        if (node == null)
        {
            return null;
        } else
        {
            return node.getNodeEndsWith((new StringBuilder(String.valueOf(s))).append("Response").toString());
        }
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
}
