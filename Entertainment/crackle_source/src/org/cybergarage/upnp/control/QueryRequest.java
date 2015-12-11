// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.control;

import org.cybergarage.http.HTTPRequest;
import org.cybergarage.soap.SOAP;
import org.cybergarage.upnp.Service;
import org.cybergarage.upnp.StateVariable;
import org.cybergarage.xml.Node;

// Referenced classes of package org.cybergarage.upnp.control:
//            ControlRequest, QueryResponse

public class QueryRequest extends ControlRequest
{

    public QueryRequest()
    {
    }

    public QueryRequest(HTTPRequest httprequest)
    {
        set(httprequest);
    }

    private Node createContentNode(StateVariable statevariable)
    {
        Node node = new Node();
        node.setName("u", "QueryStateVariable");
        node.setNameSpace("u", "urn:schemas-upnp-org:control-1-0");
        Node node1 = new Node();
        node1.setName("u", "varName");
        node1.setValue(statevariable.getName());
        node.addNode(node1);
        return node;
    }

    private Node getVarNameNode()
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

    public String getVarName()
    {
        Node node = getVarNameNode();
        if (node == null)
        {
            return "";
        } else
        {
            return node.getValue();
        }
    }

    public QueryResponse post()
    {
        return new QueryResponse(postMessage(getRequestHost(), getRequestPort()));
    }

    public void setRequest(StateVariable statevariable)
    {
        Object obj = statevariable.getService();
        ((Service) (obj)).getControlURL();
        setRequestHost(((Service) (obj)));
        setEnvelopeNode(SOAP.createEnvelopeBodyNode());
        obj = getEnvelopeNode();
        getBodyNode().addNode(createContentNode(statevariable));
        setContent(((Node) (obj)));
        setSOAPAction("urn:schemas-upnp-org:control-1-0#QueryStateVariable");
    }
}
