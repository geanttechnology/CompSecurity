// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.control;

import org.cybergarage.soap.SOAPResponse;
import org.cybergarage.upnp.UPnP;
import org.cybergarage.upnp.UPnPStatus;
import org.cybergarage.xml.Node;

public class ControlResponse extends SOAPResponse
{

    public static final String FAULT_CODE = "Client";
    public static final String FAULT_STRING = "UPnPError";
    private UPnPStatus upnpErr;

    public ControlResponse()
    {
        upnpErr = new UPnPStatus();
        setServer(UPnP.getServerName());
    }

    public ControlResponse(SOAPResponse soapresponse)
    {
        super(soapresponse);
        upnpErr = new UPnPStatus();
    }

    private Node createFaultResponseNode(int i)
    {
        return createFaultResponseNode(i, UPnPStatus.code2String(i));
    }

    private Node createFaultResponseNode(int i, String s)
    {
        Node node = new Node("s:Fault");
        Node node1 = new Node("faultcode");
        node1.setValue("s:Client");
        node.addNode(node1);
        node1 = new Node("faultstring");
        node1.setValue("UPnPError");
        node.addNode(node1);
        Node node2 = new Node("detail");
        node.addNode(node2);
        node1 = new Node("UPnPError");
        node1.setAttribute("xmlns", "urn:schemas-upnp-org:control-1-0");
        node2.addNode(node1);
        node2 = new Node("errorCode");
        node2.setValue(i);
        node1.addNode(node2);
        node2 = new Node("errorDescription");
        node2.setValue(s);
        node1.addNode(node2);
        return node;
    }

    private Node getUPnPErrorCodeNode()
    {
        Node node = getUPnPErrorNode();
        if (node == null)
        {
            return null;
        } else
        {
            return node.getNodeEndsWith("errorCode");
        }
    }

    private Node getUPnPErrorDescriptionNode()
    {
        Node node = getUPnPErrorNode();
        if (node == null)
        {
            return null;
        } else
        {
            return node.getNodeEndsWith("errorDescription");
        }
    }

    private Node getUPnPErrorNode()
    {
        Node node = getFaultDetailNode();
        if (node == null)
        {
            return null;
        } else
        {
            return node.getNodeEndsWith("UPnPError");
        }
    }

    public UPnPStatus getUPnPError()
    {
        int i = getUPnPErrorCode();
        String s = getUPnPErrorDescription();
        upnpErr.setCode(i);
        upnpErr.setDescription(s);
        return upnpErr;
    }

    public int getUPnPErrorCode()
    {
        Object obj = getUPnPErrorCodeNode();
        if (obj == null)
        {
            return -1;
        }
        obj = ((Node) (obj)).getValue();
        int i;
        try
        {
            i = Integer.parseInt(((String) (obj)));
        }
        catch (Exception exception)
        {
            return -1;
        }
        return i;
    }

    public String getUPnPErrorDescription()
    {
        Node node = getUPnPErrorDescriptionNode();
        if (node == null)
        {
            return "";
        } else
        {
            return node.getValue();
        }
    }

    public void setFaultResponse(int i)
    {
        setFaultResponse(i, UPnPStatus.code2String(i));
    }

    public void setFaultResponse(int i, String s)
    {
        setStatusCode(500);
        getBodyNode().addNode(createFaultResponseNode(i, s));
        setContent(getEnvelopeNode());
    }
}
