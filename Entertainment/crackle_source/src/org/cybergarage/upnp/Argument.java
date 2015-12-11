// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp;

import org.cybergarage.upnp.xml.ArgumentData;
import org.cybergarage.xml.Node;

// Referenced classes of package org.cybergarage.upnp:
//            Action, Service, StateVariable

public class Argument
{

    private static final String DIRECTION = "direction";
    public static final String ELEM_NAME = "argument";
    public static final String IN = "in";
    private static final String NAME = "name";
    public static final String OUT = "out";
    private static final String RELATED_STATE_VARIABLE = "relatedStateVariable";
    private Node argumentNode;
    private Node serviceNode;
    private Object userData;

    public Argument()
    {
        userData = null;
        argumentNode = new Node("argument");
        serviceNode = null;
    }

    public Argument(String s, String s1)
    {
        this();
        setName(s);
        setValue(s1);
    }

    public Argument(Node node)
    {
        userData = null;
        argumentNode = new Node("argument");
        serviceNode = node;
    }

    public Argument(Node node, Node node1)
    {
        userData = null;
        serviceNode = node;
        argumentNode = node1;
    }

    private ArgumentData getArgumentData()
    {
        Node node = getArgumentNode();
        ArgumentData argumentdata1 = (ArgumentData)node.getUserData();
        ArgumentData argumentdata = argumentdata1;
        if (argumentdata1 == null)
        {
            argumentdata = new ArgumentData();
            node.setUserData(argumentdata);
            argumentdata.setNode(node);
        }
        return argumentdata;
    }

    private Node getServiceNode()
    {
        return serviceNode;
    }

    public static boolean isArgumentNode(Node node)
    {
        return "argument".equals(node.getName());
    }

    public Action getAction()
    {
        return new Action(getServiceNode(), getActionNode());
    }

    public Node getActionNode()
    {
        Node node = getArgumentNode().getParentNode();
        if (node == null)
        {
            node = null;
        } else
        {
            Node node1 = node.getParentNode();
            if (node1 == null)
            {
                return null;
            }
            node = node1;
            if (!Action.isActionNode(node1))
            {
                return null;
            }
        }
        return node;
    }

    public Node getArgumentNode()
    {
        return argumentNode;
    }

    public String getDirection()
    {
        return getArgumentNode().getNodeValue("direction");
    }

    public int getIntegerValue()
    {
        String s = getValue();
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        catch (Exception exception)
        {
            return 0;
        }
        return i;
    }

    public String getName()
    {
        return getArgumentNode().getNodeValue("name");
    }

    public StateVariable getRelatedStateVariable()
    {
        Service service = getService();
        if (service == null)
        {
            return null;
        } else
        {
            return service.getStateVariable(getRelatedStateVariableName());
        }
    }

    public String getRelatedStateVariableName()
    {
        return getArgumentNode().getNodeValue("relatedStateVariable");
    }

    public Service getService()
    {
        return new Service(getServiceNode());
    }

    public Object getUserData()
    {
        return userData;
    }

    public String getValue()
    {
        return getArgumentData().getValue();
    }

    public boolean isInDirection()
    {
        String s = getDirection();
        if (s == null)
        {
            return false;
        } else
        {
            return s.equalsIgnoreCase("in");
        }
    }

    public boolean isOutDirection()
    {
        return !isInDirection();
    }

    public void setDirection(String s)
    {
        getArgumentNode().setNode("direction", s);
    }

    public void setName(String s)
    {
        getArgumentNode().setNode("name", s);
    }

    public void setRelatedStateVariableName(String s)
    {
        getArgumentNode().setNode("relatedStateVariable", s);
    }

    void setService(Service service)
    {
        service.getServiceNode();
    }

    public void setUserData(Object obj)
    {
        userData = obj;
    }

    public void setValue(int i)
    {
        setValue(Integer.toString(i));
    }

    public void setValue(String s)
    {
        getArgumentData().setValue(s);
    }
}
