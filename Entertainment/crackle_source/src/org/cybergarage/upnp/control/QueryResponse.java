// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.control;

import org.cybergarage.soap.SOAPResponse;
import org.cybergarage.upnp.StateVariable;
import org.cybergarage.xml.Node;

// Referenced classes of package org.cybergarage.upnp.control:
//            ControlResponse

public class QueryResponse extends ControlResponse
{

    public QueryResponse()
    {
    }

    public QueryResponse(SOAPResponse soapresponse)
    {
        super(soapresponse);
    }

    private Node createResponseNode(String s)
    {
        Node node = new Node();
        node.setName("u", "QueryStateVariableResponse");
        node.setNameSpace("u", "urn:schemas-upnp-org:control-1-0");
        Node node1 = new Node();
        node1.setName("return");
        node1.setValue(s);
        node.addNode(node1);
        return node;
    }

    private Node getReturnNode()
    {
        Node node;
        node = getBodyNode();
        break MISSING_BLOCK_LABEL_5;
        if (node != null && node.hasNodes())
        {
            node = node.getNode(0);
            if (node != null && node.hasNodes())
            {
                return node.getNode(0);
            }
        }
        return null;
    }

    public String getReturnValue()
    {
        Node node = getReturnNode();
        if (node == null)
        {
            return "";
        } else
        {
            return node.getValue();
        }
    }

    public void setResponse(StateVariable statevariable)
    {
        statevariable = statevariable.getValue();
        setStatusCode(200);
        getBodyNode().addNode(createResponseNode(statevariable));
        setContent(getEnvelopeNode());
    }
}
