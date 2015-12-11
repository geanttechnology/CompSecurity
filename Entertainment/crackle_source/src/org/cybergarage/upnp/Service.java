// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import org.cybergarage.http.HTTP;
import org.cybergarage.http.HTTPResponse;
import org.cybergarage.upnp.control.ActionListener;
import org.cybergarage.upnp.control.QueryListener;
import org.cybergarage.upnp.device.InvalidDescriptionException;
import org.cybergarage.upnp.device.ST;
import org.cybergarage.upnp.event.NotifyRequest;
import org.cybergarage.upnp.event.Subscriber;
import org.cybergarage.upnp.event.SubscriberList;
import org.cybergarage.upnp.ssdp.SSDPNotifyRequest;
import org.cybergarage.upnp.ssdp.SSDPNotifySocket;
import org.cybergarage.upnp.ssdp.SSDPPacket;
import org.cybergarage.upnp.xml.ServiceData;
import org.cybergarage.util.Debug;
import org.cybergarage.util.Mutex;
import org.cybergarage.util.StringUtil;
import org.cybergarage.xml.Node;
import org.cybergarage.xml.Parser;
import org.cybergarage.xml.ParserException;

// Referenced classes of package org.cybergarage.upnp:
//            Device, UPnP, StateVariable, Action, 
//            ArgumentList, Argument, ActionList, ServiceStateTable

public class Service
{

    private static final String CONTROL_URL = "controlURL";
    public static final String ELEM_NAME = "service";
    private static final String EVENT_SUB_URL = "eventSubURL";
    public static final String MAJOR = "major";
    public static final String MAJOR_VALUE = "1";
    public static final String MINOR = "minor";
    public static final String MINOR_VALUE = "0";
    private static final String SCPDURL = "SCPDURL";
    public static final String SCPD_ROOTNODE = "scpd";
    public static final String SCPD_ROOTNODE_NS = "urn:schemas-upnp-org:service-1-0";
    private static final String SERVICE_ID = "serviceId";
    private static final String SERVICE_TYPE = "serviceType";
    public static final String SPEC_VERSION = "specVersion";
    private Mutex mutex;
    private Node serviceNode;
    private Object userData;

    public Service()
    {
        this(new Node("service"));
        Node node = new Node("specVersion");
        Node node1 = new Node("major");
        node1.setValue("1");
        node.addNode(node1);
        node1 = new Node("minor");
        node1.setValue("0");
        node.addNode(node1);
        node1 = new Node("scpd");
        node1.addAttribute("xmlns", "urn:schemas-upnp-org:service-1-0");
        node1.addNode(node);
        getServiceData().setSCPDNode(node1);
    }

    public Service(Node node)
    {
        mutex = new Mutex();
        userData = null;
        serviceNode = node;
    }

    private Node getDeviceNode()
    {
        Node node = getServiceNode().getParentNode();
        if (node == null)
        {
            return null;
        } else
        {
            return node.getParentNode();
        }
    }

    private String getNotifyServiceTypeNT()
    {
        return getServiceType();
    }

    private String getNotifyServiceTypeUSN()
    {
        return (new StringBuilder(String.valueOf(getDevice().getUDN()))).append("::").append(getServiceType()).toString();
    }

    private Node getRootNode()
    {
        return getServiceNode().getRootNode();
    }

    private Node getSCPDNode()
    {
        Node node;
        Object obj;
        ServiceData servicedata;
        obj = null;
        servicedata = getServiceData();
        node = servicedata.getSCPDNode();
        if (node == null) goto _L2; else goto _L1
_L1:
        obj = node;
_L4:
        return ((Node) (obj));
_L2:
        Device device = getDevice();
        if (device == null) goto _L4; else goto _L3
_L3:
        String s1;
        s1 = getSCPDURL();
        obj = device.getDescriptionFilePath();
        if (obj == null) goto _L6; else goto _L5
_L5:
        obj = new File(((String) (obj)).concat(s1));
        if (!((File) (obj)).exists()) goto _L6; else goto _L7
_L7:
        obj = getSCPDNode(((File) (obj)));
        node = ((Node) (obj));
_L8:
        if (node != null)
        {
            servicedata.setSCPDNode(node);
            return node;
        }
        break; /* Loop/switch isn't completed */
        ParserException parserexception;
        parserexception;
        parserexception.printStackTrace();
        if (true) goto _L8; else goto _L6
_L6:
        node = getSCPDNode(new URL(device.getAbsoluteURL(s1)));
        if (node == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        servicedata.setSCPDNode(node);
        return node;
        Exception exception;
        exception;
        String s = (new StringBuilder(String.valueOf(device.getDescriptionFilePath()))).append(HTTP.toRelativeURL(s1)).toString();
        try
        {
            getSCPDNode(new File(s));
        }
        catch (Exception exception1)
        {
            Debug.warning(exception1);
            return null;
        }
        return null;
    }

    private Node getSCPDNode(File file)
        throws ParserException
    {
        return UPnP.getXMLParser().parse(file);
    }

    private Node getSCPDNode(URL url)
        throws ParserException
    {
        return UPnP.getXMLParser().parse(url);
    }

    private ServiceData getServiceData()
    {
        Node node = getServiceNode();
        ServiceData servicedata1 = (ServiceData)node.getUserData();
        ServiceData servicedata = servicedata1;
        if (servicedata1 == null)
        {
            servicedata = new ServiceData();
            node.setUserData(servicedata);
            servicedata.setNode(node);
        }
        return servicedata;
    }

    public static boolean isServiceNode(Node node)
    {
        return "service".equals(node.getName());
    }

    private boolean isURL(String s, String s1)
    {
        boolean flag1 = true;
        boolean flag;
        if (s == null || s1 == null)
        {
            flag = false;
        } else
        {
            flag = flag1;
            if (!s1.equals(s))
            {
                flag = flag1;
                if (!s1.equals(HTTP.toRelativeURL(s, false)))
                {
                    return false;
                }
            }
        }
        return flag;
    }

    private boolean notify(Subscriber subscriber, StateVariable statevariable)
    {
        String s = statevariable.getName();
        statevariable = statevariable.getValue();
        String s1 = subscriber.getDeliveryHost();
        int i = subscriber.getDeliveryPort();
        NotifyRequest notifyrequest = new NotifyRequest();
        notifyrequest.setRequest(subscriber, s, statevariable);
        if (!notifyrequest.post(s1, i).isSuccessful())
        {
            return false;
        } else
        {
            subscriber.incrementNotifyCount();
            return true;
        }
    }

    public void addAction(Action action)
    {
        Object obj = action.getArgumentList().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                Node node1 = getSCPDNode();
                Node node = node1.getNode("actionList");
                obj = node;
                if (node == null)
                {
                    obj = new Node("actionList");
                    node1.addNode(((Node) (obj)));
                }
                ((Node) (obj)).addNode(action.getActionNode());
                return;
            }
            ((Argument)((Iterator) (obj)).next()).setService(this);
        } while (true);
    }

    public void addStateVariable(StateVariable statevariable)
    {
        Node node1 = getSCPDNode().getNode("serviceStateTable");
        Node node = node1;
        if (node1 == null)
        {
            node = new Node("serviceStateTable");
            getSCPDNode().addNode(node);
        }
        statevariable.setServiceNode(getServiceNode());
        node.addNode(statevariable.getStateVariableNode());
    }

    public void addSubscriber(Subscriber subscriber)
    {
        getSubscriberList().add(subscriber);
    }

    public void announce(String s)
    {
        String s1 = getRootDevice().getLocationURL(s);
        String s2 = getNotifyServiceTypeNT();
        String s3 = getNotifyServiceTypeUSN();
        Device device = getDevice();
        SSDPNotifyRequest ssdpnotifyrequest = new SSDPNotifyRequest();
        ssdpnotifyrequest.setServer(UPnP.getServerName());
        ssdpnotifyrequest.setLeaseTime(device.getLeaseTime());
        ssdpnotifyrequest.setLocation(s1);
        ssdpnotifyrequest.setNTS("ssdp:alive");
        ssdpnotifyrequest.setNT(s2);
        ssdpnotifyrequest.setUSN(s3);
        s = new SSDPNotifySocket(s);
        Device.notifyWait();
        s.post(ssdpnotifyrequest);
    }

    public void byebye(String s)
    {
        String s1 = getNotifyServiceTypeNT();
        String s2 = getNotifyServiceTypeUSN();
        SSDPNotifyRequest ssdpnotifyrequest = new SSDPNotifyRequest();
        ssdpnotifyrequest.setNTS("ssdp:byebye");
        ssdpnotifyrequest.setNT(s1);
        ssdpnotifyrequest.setUSN(s2);
        s = new SSDPNotifySocket(s);
        Device.notifyWait();
        s.post(ssdpnotifyrequest);
    }

    public void clearSID()
    {
        setSID("");
        setTimeout(0L);
    }

    public Action getAction(String s)
    {
        ActionList actionlist;
        int i;
        int j;
        actionlist = getActionList();
        j = actionlist.size();
        i = 0;
_L2:
        Action action;
        String s1;
        if (i >= j)
        {
            return null;
        }
        action = actionlist.getAction(i);
        s1 = action.getName();
          goto _L1
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (s1 == null || !s1.equals(s)) goto _L4; else goto _L3
_L3:
        return action;
    }

    public ActionList getActionList()
    {
        ActionList actionlist;
        Node node;
        actionlist = new ActionList();
        node = getSCPDNode();
        if (node != null) goto _L2; else goto _L1
_L1:
        return actionlist;
_L2:
        if ((node = node.getNode("actionList")) != null)
        {
            int j = node.getNNodes();
            int i = 0;
            while (i < j) 
            {
                Node node1 = node.getNode(i);
                if (Action.isActionNode(node1))
                {
                    actionlist.add(new Action(serviceNode, node1));
                }
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public String getControlURL()
    {
        return getServiceNode().getNodeValue("controlURL");
    }

    public String getDescriptionURL()
    {
        return getServiceData().getDescriptionURL();
    }

    public Device getDevice()
    {
        return new Device(getRootNode(), getDeviceNode());
    }

    public String getEventSubURL()
    {
        return getServiceNode().getNodeValue("eventSubURL");
    }

    public Device getRootDevice()
    {
        return getDevice().getRootDevice();
    }

    public byte[] getSCPDData()
    {
        Node node = getSCPDNode();
        if (node == null)
        {
            return new byte[0];
        } else
        {
            return (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(new String()))).append("<?xml version=\"1.0\" encoding=\"utf-8\"?>").toString()))).append("\n").toString()))).append(node.toString()).toString().getBytes();
        }
    }

    public String getSCPDURL()
    {
        return getServiceNode().getNodeValue("SCPDURL");
    }

    public String getSID()
    {
        return getServiceData().getSID();
    }

    public String getServiceID()
    {
        return getServiceNode().getNodeValue("serviceId");
    }

    public Node getServiceNode()
    {
        return serviceNode;
    }

    public ServiceStateTable getServiceStateTable()
    {
        ServiceStateTable servicestatetable = new ServiceStateTable();
        Node node = getSCPDNode().getNode("serviceStateTable");
        if (node != null)
        {
            Node node1 = getServiceNode();
            int j = node.getNNodes();
            int i = 0;
            while (i < j) 
            {
                Node node2 = node.getNode(i);
                if (StateVariable.isStateVariableNode(node2))
                {
                    servicestatetable.add(new StateVariable(node1, node2));
                }
                i++;
            }
        }
        return servicestatetable;
    }

    public String getServiceType()
    {
        return getServiceNode().getNodeValue("serviceType");
    }

    public StateVariable getStateVariable(String s)
    {
        ServiceStateTable servicestatetable;
        int i;
        int j;
        servicestatetable = getServiceStateTable();
        j = servicestatetable.size();
        i = 0;
_L2:
        StateVariable statevariable;
        String s1;
        if (i >= j)
        {
            return null;
        }
        statevariable = servicestatetable.getStateVariable(i);
        s1 = statevariable.getName();
          goto _L1
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (s1 == null || !s1.equals(s)) goto _L4; else goto _L3
_L3:
        return statevariable;
    }

    public Subscriber getSubscriber(String s)
    {
        SubscriberList subscriberlist;
        int i;
        int j;
        subscriberlist = getSubscriberList();
        j = subscriberlist.size();
        i = 0;
_L2:
        Subscriber subscriber;
        if (i >= j)
        {
            return null;
        }
        subscriber = subscriberlist.getSubscriber(i);
        if (subscriber != null)
        {
            break; /* Loop/switch isn't completed */
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        String s1 = subscriber.getSID();
        if (s1 != null && s1.equals(s))
        {
            return subscriber;
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    public SubscriberList getSubscriberList()
    {
        return getServiceData().getSubscriberList();
    }

    public long getTimeout()
    {
        return getServiceData().getTimeout();
    }

    public Object getUserData()
    {
        return userData;
    }

    public boolean hasSID()
    {
        return StringUtil.hasData(getSID());
    }

    public boolean hasStateVariable(String s)
    {
        return getStateVariable(s) != null;
    }

    public boolean isControlURL(String s)
    {
        return isURL(getControlURL(), s);
    }

    public boolean isEventSubURL(String s)
    {
        return isURL(getEventSubURL(), s);
    }

    public boolean isSCPDURL(String s)
    {
        return isURL(getSCPDURL(), s);
    }

    public boolean isService(String s)
    {
        if (s != null)
        {
            if (s.endsWith(getServiceType()))
            {
                return true;
            }
            if (s.endsWith(getServiceID()))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isSubscribed()
    {
        return hasSID();
    }

    public boolean loadSCPD(File file)
        throws ParserException
    {
        file = UPnP.getXMLParser().parse(file);
        if (file == null)
        {
            return false;
        } else
        {
            getServiceData().setSCPDNode(file);
            return true;
        }
    }

    public boolean loadSCPD(InputStream inputstream)
        throws ParserException
    {
        inputstream = UPnP.getXMLParser().parse(inputstream);
        if (inputstream == null)
        {
            return false;
        } else
        {
            getServiceData().setSCPDNode(inputstream);
            return true;
        }
    }

    public boolean loadSCPD(String s)
        throws InvalidDescriptionException
    {
        try
        {
            s = UPnP.getXMLParser().parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new InvalidDescriptionException(s);
        }
        if (s == null)
        {
            return false;
        }
        getServiceData().setSCPDNode(s);
        return true;
    }

    public void lock()
    {
        mutex.lock();
    }

    public void notify(StateVariable statevariable)
    {
        SubscriberList subscriberlist;
        Subscriber asubscriber[];
        int i;
        int j;
        subscriberlist = getSubscriberList();
        j = subscriberlist.size();
        asubscriber = new Subscriber[j];
        i = 0;
_L7:
        if (i < j) goto _L2; else goto _L1
_L1:
        i = 0;
_L8:
        if (i < j) goto _L4; else goto _L3
_L3:
        j = subscriberlist.size();
        asubscriber = new Subscriber[j];
        i = 0;
_L9:
        if (i < j) goto _L6; else goto _L5
_L5:
        i = 0;
_L10:
        if (i >= j)
        {
            return;
        }
        break MISSING_BLOCK_LABEL_145;
_L2:
        asubscriber[i] = subscriberlist.getSubscriber(i);
        i++;
          goto _L7
_L4:
        Subscriber subscriber1 = asubscriber[i];
        if (subscriber1 != null && subscriber1.isExpired())
        {
            removeSubscriber(subscriber1);
        }
        i++;
          goto _L8
_L6:
        asubscriber[i] = subscriberlist.getSubscriber(i);
        i++;
          goto _L9
        Subscriber subscriber = asubscriber[i];
        if (subscriber != null)
        {
            notify(subscriber, statevariable);
        }
        i++;
          goto _L10
    }

    public void notifyAllStateVariables()
    {
        ServiceStateTable servicestatetable = getServiceStateTable();
        int j = servicestatetable.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            StateVariable statevariable = servicestatetable.getStateVariable(i);
            if (statevariable.isSendEvents())
            {
                notify(statevariable);
            }
            i++;
        } while (true);
    }

    public void removeSubscriber(Subscriber subscriber)
    {
        getSubscriberList().remove(subscriber);
    }

    public boolean serviceSearchResponse(SSDPPacket ssdppacket)
    {
        String s;
        Device device;
        String s1;
        String s2;
        s = ssdppacket.getST();
        if (s == null)
        {
            return false;
        }
        device = getDevice();
        s2 = getNotifyServiceTypeNT();
        s1 = getNotifyServiceTypeUSN();
        if (!ST.isAllDevice(s)) goto _L2; else goto _L1
_L1:
        device.postSearchResponse(ssdppacket, s2, s1);
_L4:
        return true;
_L2:
        if (ST.isURNService(s))
        {
            String s3 = getServiceType();
            if (s.equals(s3))
            {
                device.postSearchResponse(ssdppacket, s3, s1);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setActionListener(ActionListener actionlistener)
    {
        ActionList actionlist = getActionList();
        int j = actionlist.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            actionlist.getAction(i).setActionListener(actionlistener);
            i++;
        } while (true);
    }

    public void setControlURL(String s)
    {
        getServiceNode().setNode("controlURL", s);
    }

    public void setDescriptionURL(String s)
    {
        getServiceData().setDescriptionURL(s);
    }

    public void setEventSubURL(String s)
    {
        getServiceNode().setNode("eventSubURL", s);
    }

    public void setQueryListener(QueryListener querylistener)
    {
        ServiceStateTable servicestatetable = getServiceStateTable();
        int j = servicestatetable.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            servicestatetable.getStateVariable(i).setQueryListener(querylistener);
            i++;
        } while (true);
    }

    public void setSCPDURL(String s)
    {
        getServiceNode().setNode("SCPDURL", s);
    }

    public void setSID(String s)
    {
        getServiceData().setSID(s);
    }

    public void setServiceID(String s)
    {
        getServiceNode().setNode("serviceId", s);
    }

    public void setServiceType(String s)
    {
        getServiceNode().setNode("serviceType", s);
    }

    public void setTimeout(long l)
    {
        getServiceData().setTimeout(l);
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
