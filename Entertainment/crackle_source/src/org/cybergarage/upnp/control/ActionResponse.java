// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.control;

import org.cybergarage.soap.SOAPResponse;
import org.cybergarage.upnp.Action;
import org.cybergarage.upnp.Argument;
import org.cybergarage.upnp.ArgumentList;
import org.cybergarage.upnp.Service;
import org.cybergarage.xml.Node;

// Referenced classes of package org.cybergarage.upnp.control:
//            ControlResponse

public class ActionResponse extends ControlResponse
{

    public ActionResponse()
    {
        setHeader("EXT", "");
    }

    public ActionResponse(SOAPResponse soapresponse)
    {
        super(soapresponse);
        setHeader("EXT", "");
    }

    private Node createResponseNode(Action action)
    {
        Object obj = action.getName();
        obj = new Node((new StringBuilder("u:")).append(((String) (obj))).append("Response").toString());
        Service service = action.getService();
        if (service != null)
        {
            ((Node) (obj)).setAttribute("xmlns:u", service.getServiceType());
        }
        action = action.getArgumentList();
        int j = action.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return ((Node) (obj));
            }
            Argument argument = action.getArgument(i);
            if (argument.isOutDirection())
            {
                Node node = new Node();
                node.setName(argument.getName());
                node.setValue(argument.getValue());
                ((Node) (obj)).addNode(node);
            }
            i++;
        } while (true);
    }

    private Node getActionResponseNode()
    {
        Node node = getBodyNode();
        if (node == null || !node.hasNodes())
        {
            return null;
        } else
        {
            return node.getNode(0);
        }
    }

    public ArgumentList getResponse()
    {
        ArgumentList argumentlist = new ArgumentList();
        Node node = getActionResponseNode();
        if (node != null)
        {
            int j = node.getNNodes();
            int i = 0;
            while (i < j) 
            {
                Node node1 = node.getNode(i);
                argumentlist.add(new Argument(node1.getName(), node1.getValue()));
                i++;
            }
        }
        return argumentlist;
    }

    public void setResponse(Action action)
    {
        setStatusCode(200);
        getBodyNode().addNode(createResponseNode(action));
        setContent(getEnvelopeNode());
    }
}
