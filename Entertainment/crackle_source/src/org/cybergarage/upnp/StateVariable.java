// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp;

import java.util.Iterator;
import org.cybergarage.upnp.control.QueryListener;
import org.cybergarage.upnp.control.QueryRequest;
import org.cybergarage.upnp.control.QueryResponse;
import org.cybergarage.upnp.xml.NodeData;
import org.cybergarage.upnp.xml.StateVariableData;
import org.cybergarage.util.Debug;
import org.cybergarage.xml.Node;

// Referenced classes of package org.cybergarage.upnp:
//            UPnPStatus, AllowedValueList, AllowedValue, AllowedValueRange, 
//            Service

public class StateVariable extends NodeData
{

    private static final String DATATYPE = "dataType";
    private static final String DEFAULT_VALUE = "defaultValue";
    public static final String ELEM_NAME = "stateVariable";
    private static final String NAME = "name";
    private static final String SENDEVENTS = "sendEvents";
    private static final String SENDEVENTS_NO = "no";
    private static final String SENDEVENTS_YES = "yes";
    private Node serviceNode;
    private Node stateVariableNode;
    private UPnPStatus upnpStatus;
    private Object userData;

    public StateVariable()
    {
        upnpStatus = new UPnPStatus();
        userData = null;
        serviceNode = null;
        stateVariableNode = new Node("stateVariable");
    }

    public StateVariable(Node node, Node node1)
    {
        upnpStatus = new UPnPStatus();
        userData = null;
        serviceNode = node;
        stateVariableNode = node1;
    }

    public static boolean isStateVariableNode(Node node)
    {
        return "stateVariable".equals(node.getName());
    }

    private void setQueryResponse(QueryResponse queryresponse)
    {
        getStateVariableData().setQueryResponse(queryresponse);
    }

    public AllowedValueList getAllowedValueList()
    {
        AllowedValueList allowedvaluelist;
        Node node;
        allowedvaluelist = new AllowedValueList();
        node = getStateVariableNode().getNode("allowedValueList");
        if (node != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((AllowedValueList) (obj));
_L2:
        int j = node.getNNodes();
        int i = 0;
        do
        {
            obj = allowedvaluelist;
            if (i >= j)
            {
                continue;
            }
            obj = node.getNode(i);
            if (AllowedValue.isAllowedValueNode(((Node) (obj))))
            {
                allowedvaluelist.add(new AllowedValue(((Node) (obj))));
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public AllowedValueRange getAllowedValueRange()
    {
        Node node = getStateVariableNode().getNode("allowedValueRange");
        if (node == null)
        {
            return null;
        } else
        {
            return new AllowedValueRange(node);
        }
    }

    public String getDataType()
    {
        return getStateVariableNode().getNodeValue("dataType");
    }

    public String getDefaultValue()
    {
        return getStateVariableNode().getNodeValue("defaultValue");
    }

    public String getName()
    {
        return getStateVariableNode().getNodeValue("name");
    }

    public QueryListener getQueryListener()
    {
        return getStateVariableData().getQueryListener();
    }

    public QueryResponse getQueryResponse()
    {
        return getStateVariableData().getQueryResponse();
    }

    public UPnPStatus getQueryStatus()
    {
        return getQueryResponse().getUPnPError();
    }

    public Service getService()
    {
        Node node = getServiceNode();
        if (node == null)
        {
            return null;
        } else
        {
            return new Service(node);
        }
    }

    public Node getServiceNode()
    {
        return serviceNode;
    }

    public StateVariableData getStateVariableData()
    {
        Node node = getStateVariableNode();
        StateVariableData statevariabledata1 = (StateVariableData)node.getUserData();
        StateVariableData statevariabledata = statevariabledata1;
        if (statevariabledata1 == null)
        {
            statevariabledata = new StateVariableData();
            node.setUserData(statevariabledata);
            statevariabledata.setNode(node);
        }
        return statevariabledata;
    }

    public Node getStateVariableNode()
    {
        return stateVariableNode;
    }

    public UPnPStatus getStatus()
    {
        return upnpStatus;
    }

    public Object getUserData()
    {
        return userData;
    }

    public String getValue()
    {
        return getStateVariableData().getValue();
    }

    public boolean hasAllowedValueList()
    {
        return getAllowedValueList() != null;
    }

    public boolean hasAllowedValueRange()
    {
        return getAllowedValueRange() != null;
    }

    public boolean isSendEvents()
    {
        for (String s = getStateVariableNode().getAttributeValue("sendEvents"); s == null || !s.equalsIgnoreCase("yes");)
        {
            return false;
        }

        return true;
    }

    public boolean performQueryListener(QueryRequest queryrequest)
    {
        QueryListener querylistener = getQueryListener();
        if (querylistener == null)
        {
            return false;
        }
        QueryResponse queryresponse = new QueryResponse();
        StateVariable statevariable = new StateVariable();
        statevariable.set(this);
        statevariable.setValue("");
        statevariable.setStatus(404);
        if (querylistener.queryControlReceived(statevariable))
        {
            queryresponse.setResponse(statevariable);
        } else
        {
            UPnPStatus upnpstatus = statevariable.getStatus();
            queryresponse.setFaultResponse(upnpstatus.getCode(), upnpstatus.getDescription());
        }
        queryrequest.post(queryresponse);
        return true;
    }

    public boolean postQuerylAction()
    {
        Object obj = new QueryRequest();
        ((QueryRequest) (obj)).setRequest(this);
        if (Debug.isOn())
        {
            ((QueryRequest) (obj)).print();
        }
        obj = ((QueryRequest) (obj)).post();
        if (Debug.isOn())
        {
            ((QueryResponse) (obj)).print();
        }
        setQueryResponse(((QueryResponse) (obj)));
        if (!((QueryResponse) (obj)).isSuccessful())
        {
            setValue(((QueryResponse) (obj)).getReturnValue());
            return false;
        } else
        {
            setValue(((QueryResponse) (obj)).getReturnValue());
            return true;
        }
    }

    public void set(StateVariable statevariable)
    {
        setName(statevariable.getName());
        setValue(statevariable.getValue());
        setDataType(statevariable.getDataType());
        setSendEvents(statevariable.isSendEvents());
    }

    public void setAllowedValueList(AllowedValueList allowedvaluelist)
    {
        getStateVariableNode().removeNode("allowedValueList");
        getStateVariableNode().removeNode("allowedValueRange");
        Node node = new Node("allowedValueList");
        allowedvaluelist = allowedvaluelist.iterator();
        do
        {
            if (!allowedvaluelist.hasNext())
            {
                getStateVariableNode().addNode(node);
                return;
            }
            node.addNode(((AllowedValue)allowedvaluelist.next()).getAllowedValueNode());
        } while (true);
    }

    public void setAllowedValueRange(AllowedValueRange allowedvaluerange)
    {
        getStateVariableNode().removeNode("allowedValueList");
        getStateVariableNode().removeNode("allowedValueRange");
        getStateVariableNode().addNode(allowedvaluerange.getAllowedValueRangeNode());
    }

    public void setDataType(String s)
    {
        getStateVariableNode().setNode("dataType", s);
    }

    public void setDefaultValue(String s)
    {
        getStateVariableNode().setNode("defaultValue", s);
    }

    public void setName(String s)
    {
        getStateVariableNode().setNode("name", s);
    }

    public void setQueryListener(QueryListener querylistener)
    {
        getStateVariableData().setQueryListener(querylistener);
    }

    public void setSendEvents(boolean flag)
    {
        Node node = getStateVariableNode();
        String s;
        if (flag)
        {
            s = "yes";
        } else
        {
            s = "no";
        }
        node.setAttribute("sendEvents", s);
    }

    void setServiceNode(Node node)
    {
        serviceNode = node;
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

    public void setValue(int i)
    {
        setValue(Integer.toString(i));
    }

    public void setValue(long l)
    {
        setValue(Long.toString(l));
    }

    public void setValue(String s)
    {
        String s1 = getStateVariableData().getValue();
        if (s1 == null || !s1.equals(s))
        {
            getStateVariableData().setValue(s);
            s = getService();
            if (s != null && isSendEvents())
            {
                s.notify(this);
                return;
            }
        }
    }
}
