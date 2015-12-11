// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.control;

import org.cybergarage.http.HTTPRequest;
import org.cybergarage.soap.SOAP;
import org.cybergarage.upnp.Action;
import org.cybergarage.upnp.Argument;
import org.cybergarage.upnp.ArgumentList;
import org.cybergarage.upnp.Service;
import org.cybergarage.xml.Node;

// Referenced classes of package org.cybergarage.upnp.control:
//            ControlRequest, ActionResponse

public class ActionRequest extends ControlRequest
{

    public ActionRequest()
    {
    }

    public ActionRequest(HTTPRequest httprequest)
    {
        set(httprequest);
    }

    private Node createContentNode(Service service, Action action, ArgumentList argumentlist)
    {
        action = action.getName();
        String s = service.getServiceType();
        service = new Node();
        service.setName("u", action);
        service.setNameSpace("u", s);
        int j = argumentlist.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return service;
            }
            action = argumentlist.getArgument(i);
            Node node = new Node();
            node.setName(action.getName());
            node.setValue(action.getValue());
            service.addNode(node);
            i++;
        } while (true);
    }

    public String getActionName()
    {
        Object obj = getActionNode();
        if (obj == null)
        {
            return "";
        }
        obj = ((Node) (obj)).getName();
        if (obj == null)
        {
            return "";
        }
        int i = ((String) (obj)).indexOf(":") + 1;
        if (i < 0)
        {
            return "";
        } else
        {
            return ((String) (obj)).substring(i, ((String) (obj)).length());
        }
    }

    public Node getActionNode()
    {
        Node node;
        for (node = getBodyNode(); node == null || !node.hasNodes();)
        {
            return null;
        }

        return node.getNode(0);
    }

    public ArgumentList getArgumentList()
    {
        Node node = getActionNode();
        int j = node.getNNodes();
        ArgumentList argumentlist = new ArgumentList();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return argumentlist;
            }
            Argument argument = new Argument();
            Node node1 = node.getNode(i);
            argument.setName(node1.getName());
            argument.setValue(node1.getValue());
            argumentlist.add(argument);
            i++;
        } while (true);
    }

    public ActionResponse post()
    {
        return new ActionResponse(postMessage(getRequestHost(), getRequestPort()));
    }

    public void setRequest(Action action, ArgumentList argumentlist)
    {
        Service service = action.getService();
        setRequestHost(service);
        setEnvelopeNode(SOAP.createEnvelopeBodyNode());
        Node node = getEnvelopeNode();
        getBodyNode().addNode(createContentNode(service, action, argumentlist));
        setContent(node);
        argumentlist = service.getServiceType();
        action = action.getName();
        setSOAPAction((new StringBuilder("\"")).append(argumentlist).append("#").append(action).append("\"").toString());
    }
}
