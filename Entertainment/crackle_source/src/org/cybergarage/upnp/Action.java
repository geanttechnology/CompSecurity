// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp;

import java.io.PrintStream;
import java.util.Iterator;
import org.cybergarage.upnp.control.ActionListener;
import org.cybergarage.upnp.control.ActionRequest;
import org.cybergarage.upnp.control.ActionResponse;
import org.cybergarage.upnp.control.ControlResponse;
import org.cybergarage.upnp.xml.ActionData;
import org.cybergarage.util.Debug;
import org.cybergarage.util.Mutex;
import org.cybergarage.xml.Node;

// Referenced classes of package org.cybergarage.upnp:
//            UPnPStatus, ArgumentList, Argument, Service

public class Action
{

    public static final String ELEM_NAME = "action";
    private static final String NAME = "name";
    private Node actionNode;
    private Mutex mutex;
    private Node serviceNode;
    private UPnPStatus upnpStatus;
    private Object userData;

    public Action(Action action)
    {
        mutex = new Mutex();
        upnpStatus = new UPnPStatus();
        userData = null;
        serviceNode = action.getServiceNode();
        actionNode = action.getActionNode();
    }

    public Action(Node node)
    {
        mutex = new Mutex();
        upnpStatus = new UPnPStatus();
        userData = null;
        serviceNode = node;
        actionNode = new Node("action");
    }

    public Action(Node node, Node node1)
    {
        mutex = new Mutex();
        upnpStatus = new UPnPStatus();
        userData = null;
        serviceNode = node;
        actionNode = node1;
    }

    private void clearOutputAgumentValues()
    {
        ArgumentList argumentlist = getArgumentList();
        int j = argumentlist.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            Argument argument = argumentlist.getArgument(i);
            if (argument.isOutDirection())
            {
                argument.setValue("");
            }
            i++;
        } while (true);
    }

    private ActionData getActionData()
    {
        Node node = getActionNode();
        ActionData actiondata1 = (ActionData)node.getUserData();
        ActionData actiondata = actiondata1;
        if (actiondata1 == null)
        {
            actiondata = new ActionData();
            node.setUserData(actiondata);
            actiondata.setNode(node);
        }
        return actiondata;
    }

    private ControlResponse getControlResponse()
    {
        return getActionData().getControlResponse();
    }

    private Node getServiceNode()
    {
        return serviceNode;
    }

    public static boolean isActionNode(Node node)
    {
        return "action".equals(node.getName());
    }

    private void setControlResponse(ControlResponse controlresponse)
    {
        getActionData().setControlResponse(controlresponse);
    }

    public ActionListener getActionListener()
    {
        return getActionData().getActionListener();
    }

    public Node getActionNode()
    {
        return actionNode;
    }

    public Argument getArgument(String s)
    {
        ArgumentList argumentlist;
        int i;
        int j;
        argumentlist = getArgumentList();
        j = argumentlist.size();
        i = 0;
_L2:
        Argument argument;
        String s1;
        if (i >= j)
        {
            return null;
        }
        argument = argumentlist.getArgument(i);
        s1 = argument.getName();
          goto _L1
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (s1 == null || !s.equals(s1)) goto _L4; else goto _L3
_L3:
        return argument;
    }

    public int getArgumentIntegerValue(String s)
    {
        s = getArgument(s);
        if (s == null)
        {
            return 0;
        } else
        {
            return s.getIntegerValue();
        }
    }

    public ArgumentList getArgumentList()
    {
        ArgumentList argumentlist = new ArgumentList();
        Node node = getActionNode().getNode("argumentList");
        if (node != null)
        {
            int j = node.getNNodes();
            int i = 0;
            while (i < j) 
            {
                Node node1 = node.getNode(i);
                if (Argument.isArgumentNode(node1))
                {
                    argumentlist.add(new Argument(getServiceNode(), node1));
                }
                i++;
            }
        }
        return argumentlist;
    }

    public String getArgumentValue(String s)
    {
        s = getArgument(s);
        if (s == null)
        {
            return "";
        } else
        {
            return s.getValue();
        }
    }

    public UPnPStatus getControlStatus()
    {
        return getControlResponse().getUPnPError();
    }

    public ArgumentList getInputArgumentList()
    {
        ArgumentList argumentlist = getArgumentList();
        int j = argumentlist.size();
        ArgumentList argumentlist1 = new ArgumentList();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return argumentlist1;
            }
            Argument argument = argumentlist.getArgument(i);
            if (argument.isInDirection())
            {
                argumentlist1.add(argument);
            }
            i++;
        } while (true);
    }

    public String getName()
    {
        return getActionNode().getNodeValue("name");
    }

    public ArgumentList getOutputArgumentList()
    {
        ArgumentList argumentlist = getArgumentList();
        int j = argumentlist.size();
        ArgumentList argumentlist1 = new ArgumentList();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return argumentlist1;
            }
            Argument argument = argumentlist.getArgument(i);
            if (argument.isOutDirection())
            {
                argumentlist1.add(argument);
            }
            i++;
        } while (true);
    }

    public Service getService()
    {
        return new Service(getServiceNode());
    }

    public UPnPStatus getStatus()
    {
        return upnpStatus;
    }

    public Object getUserData()
    {
        return userData;
    }

    public void lock()
    {
        mutex.lock();
    }

    public boolean performActionListener(ActionRequest actionrequest)
    {
        ActionListener actionlistener = getActionListener();
        if (actionlistener == null)
        {
            return false;
        }
        ActionResponse actionresponse = new ActionResponse();
        setStatus(401);
        clearOutputAgumentValues();
        if (actionlistener.actionControlReceived(this))
        {
            actionresponse.setResponse(this);
        } else
        {
            UPnPStatus upnpstatus = getStatus();
            actionresponse.setFaultResponse(upnpstatus.getCode(), upnpstatus.getDescription());
        }
        if (Debug.isOn())
        {
            actionresponse.print();
        }
        actionrequest.post(actionresponse);
        return true;
    }

    public boolean postControlAction()
    {
        ArgumentList argumentlist = getArgumentList();
        Object obj = getInputArgumentList();
        ActionRequest actionrequest = new ActionRequest();
        actionrequest.setRequest(this, ((ArgumentList) (obj)));
        if (Debug.isOn())
        {
            actionrequest.print();
        }
        obj = actionrequest.post();
        if (Debug.isOn())
        {
            ((ActionResponse) (obj)).print();
        }
        setControlResponse(((ControlResponse) (obj)));
        setStatus(((ActionResponse) (obj)).getStatusCode());
        if (!((ActionResponse) (obj)).isSuccessful())
        {
            return false;
        }
        obj = ((ActionResponse) (obj)).getResponse();
        try
        {
            argumentlist.setResArgs(((ArgumentList) (obj)));
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            setStatus(402, "Action succesfully delivered but invalid arguments returned.");
            return false;
        }
        return true;
    }

    public void print()
    {
        System.out.println((new StringBuilder("Action : ")).append(getName()).toString());
        ArgumentList argumentlist = getArgumentList();
        int j = argumentlist.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            Object obj = argumentlist.getArgument(i);
            String s = ((Argument) (obj)).getName();
            String s1 = ((Argument) (obj)).getValue();
            obj = ((Argument) (obj)).getDirection();
            System.out.println((new StringBuilder(" [")).append(i).append("] = ").append(((String) (obj))).append(", ").append(s).append(", ").append(s1).toString());
            i++;
        } while (true);
    }

    public void setActionListener(ActionListener actionlistener)
    {
        getActionData().setActionListener(actionlistener);
    }

    public void setArgumentList(ArgumentList argumentlist)
    {
        Node node = getActionNode().getNode("argumentList");
        if (node == null)
        {
            node = new Node("argumentList");
            getActionNode().addNode(node);
        } else
        {
            node.removeAllNodes();
        }
        argumentlist = argumentlist.iterator();
        do
        {
            if (!argumentlist.hasNext())
            {
                return;
            }
            Argument argument = (Argument)argumentlist.next();
            argument.setService(getService());
            node.addNode(argument.getArgumentNode());
        } while (true);
    }

    public void setArgumentValue(String s, int i)
    {
        setArgumentValue(s, Integer.toString(i));
    }

    public void setArgumentValue(String s, String s1)
    {
        s = getArgument(s);
        if (s == null)
        {
            return;
        } else
        {
            s.setValue(s1);
            return;
        }
    }

    public void setArgumentValues(ArgumentList argumentlist)
    {
        getArgumentList().set(argumentlist);
    }

    public void setInArgumentValues(ArgumentList argumentlist)
    {
        getArgumentList().setReqArgs(argumentlist);
    }

    public void setName(String s)
    {
        getActionNode().setNode("name", s);
    }

    public void setOutArgumentValues(ArgumentList argumentlist)
    {
        getArgumentList().setResArgs(argumentlist);
    }

    void setService(Service service)
    {
        serviceNode = service.getServiceNode();
        Iterator iterator = getArgumentList().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            ((Argument)iterator.next()).setService(service);
        } while (true);
    }

    public void setStatus(int i)
    {
        setStatus(i, UPnPStatus.code2String(i));
    }

    public void setStatus(int i, String s)
    {
        upnpStatus.setCode(i);
        upnpStatus.setDescription(s);
    }

    public void setUserData(Object obj)
    {
        userData = obj;
    }

    public void unlock()
    {
        mutex.unlock();
    }
}
