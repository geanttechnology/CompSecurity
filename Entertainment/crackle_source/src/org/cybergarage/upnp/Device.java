// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp;

import java.io.File;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.Calendar;
import org.cybergarage.http.HTTP;
import org.cybergarage.http.HTTPRequest;
import org.cybergarage.http.HTTPRequestListener;
import org.cybergarage.http.HTTPResponse;
import org.cybergarage.http.HTTPServerList;
import org.cybergarage.net.HostInterface;
import org.cybergarage.soap.SOAPResponse;
import org.cybergarage.upnp.control.ActionListener;
import org.cybergarage.upnp.control.ActionRequest;
import org.cybergarage.upnp.control.ActionResponse;
import org.cybergarage.upnp.control.ControlRequest;
import org.cybergarage.upnp.control.ControlResponse;
import org.cybergarage.upnp.control.QueryListener;
import org.cybergarage.upnp.control.QueryRequest;
import org.cybergarage.upnp.device.Advertiser;
import org.cybergarage.upnp.device.InvalidDescriptionException;
import org.cybergarage.upnp.device.ST;
import org.cybergarage.upnp.device.SearchListener;
import org.cybergarage.upnp.event.Subscriber;
import org.cybergarage.upnp.event.Subscription;
import org.cybergarage.upnp.event.SubscriptionRequest;
import org.cybergarage.upnp.event.SubscriptionResponse;
import org.cybergarage.upnp.ssdp.SSDPNotifyRequest;
import org.cybergarage.upnp.ssdp.SSDPNotifySocket;
import org.cybergarage.upnp.ssdp.SSDPPacket;
import org.cybergarage.upnp.ssdp.SSDPSearchResponse;
import org.cybergarage.upnp.ssdp.SSDPSearchResponseSocket;
import org.cybergarage.upnp.ssdp.SSDPSearchSocketList;
import org.cybergarage.upnp.xml.DeviceData;
import org.cybergarage.util.Debug;
import org.cybergarage.util.FileUtil;
import org.cybergarage.util.Mutex;
import org.cybergarage.util.TimerUtil;
import org.cybergarage.xml.Node;
import org.cybergarage.xml.Parser;
import org.cybergarage.xml.ParserException;

// Referenced classes of package org.cybergarage.upnp:
//            UPnP, Service, Action, ArgumentList, 
//            StateVariable, ServiceList, DeviceList, ActionList, 
//            IconList, Icon

public class Device
    implements HTTPRequestListener, SearchListener
{

    public static final String DEFAULT_DESCRIPTION_URI = "/description.xml";
    public static final int DEFAULT_DISCOVERY_WAIT_TIME = 300;
    public static final int DEFAULT_LEASE_TIME = 1800;
    public static final int DEFAULT_STARTUP_WAIT_TIME = 1000;
    private static final String DEVICE_TYPE = "deviceType";
    public static final String ELEM_NAME = "device";
    private static final String FRIENDLY_NAME = "friendlyName";
    public static final int HTTP_DEFAULT_PORT = 4004;
    private static final String MANUFACTURE = "manufacturer";
    private static final String MANUFACTURE_URL = "manufacturerURL";
    private static final String MODEL_DESCRIPTION = "modelDescription";
    private static final String MODEL_NAME = "modelName";
    private static final String MODEL_NUMBER = "modelNumber";
    private static final String MODEL_URL = "modelURL";
    private static final String SERIAL_NUMBER = "serialNumber";
    private static final String UDN = "UDN";
    private static final String UPC = "UPC";
    public static final String UPNP_ROOTDEVICE = "upnp:rootdevice";
    private static final String URLBASE_NAME = "URLBase";
    private static Calendar cal = Calendar.getInstance();
    private static final String presentationURL = "presentationURL";
    private String devUUID;
    private Node deviceNode;
    private Mutex mutex;
    private Node rootNode;
    private Object userData;
    private boolean wirelessMode;

    public Device()
    {
        this(null, null);
    }

    public Device(File file)
        throws InvalidDescriptionException
    {
        this(null, null);
        loadDescription(file);
    }

    public Device(InputStream inputstream)
        throws InvalidDescriptionException
    {
        this(null, null);
        loadDescription(inputstream);
    }

    public Device(String s)
        throws InvalidDescriptionException
    {
        this(new File(s));
    }

    public Device(Node node)
    {
        this(null, node);
    }

    public Device(Node node, Node node1)
    {
        mutex = new Mutex();
        userData = null;
        rootNode = node;
        deviceNode = node1;
        setUUID(UPnP.createUUID());
        setWirelessMode(false);
    }

    private void deviceActionControlRecieved(ActionRequest actionrequest, Service service)
    {
        if (Debug.isOn())
        {
            actionrequest.print();
        }
        service = service.getAction(actionrequest.getActionName());
        if (service == null)
        {
            invalidActionControlRecieved(actionrequest);
        } else
        {
            ArgumentList argumentlist = service.getArgumentList();
            ArgumentList argumentlist1 = actionrequest.getArgumentList();
            try
            {
                argumentlist.setReqArgs(argumentlist1);
            }
            // Misplaced declaration of an exception variable
            catch (Service service)
            {
                invalidArgumentsControlRecieved(actionrequest);
                return;
            }
            if (!service.performActionListener(actionrequest))
            {
                invalidActionControlRecieved(actionrequest);
                return;
            }
        }
    }

    private void deviceControlRequestRecieved(ControlRequest controlrequest, Service service)
    {
        if (controlrequest.isQueryControl())
        {
            deviceQueryControlRecieved(new QueryRequest(controlrequest), service);
            return;
        } else
        {
            deviceActionControlRecieved(new ActionRequest(controlrequest), service);
            return;
        }
    }

    private void deviceEventNewSubscriptionRecieved(Service service, SubscriptionRequest subscriptionrequest)
    {
        Object obj = subscriptionrequest.getCallback();
        String s;
        Subscriber subscriber;
        long l;
        try
        {
            new URL(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Service service)
        {
            upnpBadSubscriptionRecieved(subscriptionrequest, 412);
            return;
        }
        l = subscriptionrequest.getTimeout();
        s = Subscription.createSID();
        subscriber = new Subscriber();
        subscriber.setDeliveryURL(((String) (obj)));
        subscriber.setTimeOut(l);
        subscriber.setSID(s);
        service.addSubscriber(subscriber);
        obj = new SubscriptionResponse();
        ((SubscriptionResponse) (obj)).setStatusCode(200);
        ((SubscriptionResponse) (obj)).setSID(s);
        ((SubscriptionResponse) (obj)).setTimeout(l);
        if (Debug.isOn())
        {
            ((SubscriptionResponse) (obj)).print();
        }
        subscriptionrequest.post(((SubscriptionResponse) (obj)));
        if (Debug.isOn())
        {
            ((SubscriptionResponse) (obj)).print();
        }
        service.notifyAllStateVariables();
    }

    private void deviceEventRenewSubscriptionRecieved(Service service, SubscriptionRequest subscriptionrequest)
    {
        String s = subscriptionrequest.getSID();
        service = service.getSubscriber(s);
        if (service == null)
        {
            upnpBadSubscriptionRecieved(subscriptionrequest, 412);
        } else
        {
            long l = subscriptionrequest.getTimeout();
            service.setTimeOut(l);
            service.renew();
            service = new SubscriptionResponse();
            service.setStatusCode(200);
            service.setSID(s);
            service.setTimeout(l);
            subscriptionrequest.post(service);
            if (Debug.isOn())
            {
                service.print();
                return;
            }
        }
    }

    private void deviceEventSubscriptionRecieved(SubscriptionRequest subscriptionrequest)
    {
        Service service = getServiceByEventSubURL(subscriptionrequest.getURI());
        if (service == null)
        {
            subscriptionrequest.returnBadRequest();
            return;
        }
        if (!subscriptionrequest.hasCallback() && !subscriptionrequest.hasSID())
        {
            upnpBadSubscriptionRecieved(subscriptionrequest, 412);
            return;
        }
        if (subscriptionrequest.isUnsubscribeRequest())
        {
            deviceEventUnsubscriptionRecieved(service, subscriptionrequest);
            return;
        }
        if (subscriptionrequest.hasCallback())
        {
            deviceEventNewSubscriptionRecieved(service, subscriptionrequest);
            return;
        }
        if (subscriptionrequest.hasSID())
        {
            deviceEventRenewSubscriptionRecieved(service, subscriptionrequest);
            return;
        } else
        {
            upnpBadSubscriptionRecieved(subscriptionrequest, 412);
            return;
        }
    }

    private void deviceEventUnsubscriptionRecieved(Service service, SubscriptionRequest subscriptionrequest)
    {
        Subscriber subscriber = service.getSubscriber(subscriptionrequest.getSID());
        if (subscriber == null)
        {
            upnpBadSubscriptionRecieved(subscriptionrequest, 412);
        } else
        {
            service.removeSubscriber(subscriber);
            service = new SubscriptionResponse();
            service.setStatusCode(200);
            subscriptionrequest.post(service);
            if (Debug.isOn())
            {
                service.print();
                return;
            }
        }
    }

    private void deviceQueryControlRecieved(QueryRequest queryrequest, Service service)
    {
        if (Debug.isOn())
        {
            queryrequest.print();
        }
        String s = queryrequest.getVarName();
        if (!service.hasStateVariable(s))
        {
            invalidActionControlRecieved(queryrequest);
        } else
        if (!getStateVariable(s).performQueryListener(queryrequest))
        {
            invalidActionControlRecieved(queryrequest);
            return;
        }
    }

    private Advertiser getAdvertiser()
    {
        return getDeviceData().getAdvertiser();
    }

    private byte[] getDescriptionData(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (!isNMPRMode())
        {
            updateURLBase(s);
        }
        s = getRootNode();
        if (s != null) goto _L2; else goto _L1
_L1:
        s = new byte[0];
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(new String()))).append("<?xml version=\"1.0\" encoding=\"utf-8\"?>").toString()))).append("\n").toString()))).append(s.toString()).toString().getBytes();
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    private String getDescriptionURI()
    {
        return getDeviceData().getDescriptionURI();
    }

    private DeviceData getDeviceData()
    {
        Node node = getDeviceNode();
        DeviceData devicedata1 = (DeviceData)node.getUserData();
        DeviceData devicedata = devicedata1;
        if (devicedata1 == null)
        {
            devicedata = new DeviceData();
            node.setUserData(devicedata);
            devicedata.setNode(node);
        }
        return devicedata;
    }

    private HTTPServerList getHTTPServerList()
    {
        return getDeviceData().getHTTPServerList();
    }

    private String getNotifyDeviceNT()
    {
        if (!isRootDevice())
        {
            return getUDN();
        } else
        {
            return "upnp:rootdevice";
        }
    }

    private String getNotifyDeviceTypeNT()
    {
        return getDeviceType();
    }

    private String getNotifyDeviceTypeUSN()
    {
        return (new StringBuilder(String.valueOf(getUDN()))).append("::").append(getDeviceType()).toString();
    }

    private String getNotifyDeviceUSN()
    {
        if (!isRootDevice())
        {
            return getUDN();
        } else
        {
            return (new StringBuilder(String.valueOf(getUDN()))).append("::").append("upnp:rootdevice").toString();
        }
    }

    private SSDPSearchSocketList getSSDPSearchSocketList()
    {
        return getDeviceData().getSSDPSearchSocketList();
    }

    private String getUUID()
    {
        return devUUID;
    }

    private void httpGetRequestRecieved(HTTPRequest httprequest)
    {
        String s = httprequest.getURI();
        Debug.message((new StringBuilder("httpGetRequestRecieved = ")).append(s).toString());
        if (s == null)
        {
            httprequest.returnBadRequest();
            return;
        }
        Object obj;
        HTTPResponse httpresponse;
        if (isDescriptionURI(s))
        {
            httprequest.getLocalAddress();
            obj = getDescriptionData(HostInterface.getInterface());
        } else
        {
            obj = getDeviceByDescriptionURI(s);
            if (obj != null)
            {
                obj = ((Device) (obj)).getDescriptionData(httprequest.getLocalAddress());
            } else
            {
                obj = getServiceBySCPDURL(s);
                if (obj != null)
                {
                    obj = ((Service) (obj)).getSCPDData();
                } else
                {
                    httprequest.returnBadRequest();
                    return;
                }
            }
        }
        httpresponse = new HTTPResponse();
        if (FileUtil.isXMLFileName(s))
        {
            httpresponse.setContentType("text/xml; charset=\"utf-8\"");
        }
        httpresponse.setStatusCode(200);
        httpresponse.setContent(((byte []) (obj)));
        httprequest.post(httpresponse);
    }

    private void httpPostRequestRecieved(HTTPRequest httprequest)
    {
        if (httprequest.isSOAPAction())
        {
            soapActionRecieved(httprequest);
            return;
        } else
        {
            httprequest.returnBadRequest();
            return;
        }
    }

    private boolean initializeLoadedDescription()
    {
        setDescriptionURI("/description.xml");
        setLeaseTime(1800);
        setHTTPPort(4004);
        if (!hasUDN())
        {
            updateUDN();
        }
        return true;
    }

    private void invalidActionControlRecieved(ControlRequest controlrequest)
    {
        ActionResponse actionresponse = new ActionResponse();
        actionresponse.setFaultResponse(401);
        controlrequest.post(actionresponse);
    }

    private void invalidArgumentsControlRecieved(ControlRequest controlrequest)
    {
        ActionResponse actionresponse = new ActionResponse();
        actionresponse.setFaultResponse(402);
        controlrequest.post(actionresponse);
    }

    private boolean isDescriptionURI(String s)
    {
        String s1 = getDescriptionURI();
        if (s == null || s1 == null)
        {
            return false;
        } else
        {
            return s1.equals(s);
        }
    }

    public static boolean isDeviceNode(Node node)
    {
        return "device".equals(node.getName());
    }

    public static final void notifyWait()
    {
        TimerUtil.waitRandom(300);
    }

    private void setAdvertiser(Advertiser advertiser)
    {
        getDeviceData().setAdvertiser(advertiser);
    }

    private void setDescriptionFile(File file)
    {
        getDeviceData().setDescriptionFile(file);
    }

    private void setDescriptionURI(String s)
    {
        getDeviceData().setDescriptionURI(s);
    }

    private void setURLBase(String s)
    {
label0:
        {
            if (isRootDevice())
            {
                Node node = getRootNode().getNode("URLBase");
                if (node == null)
                {
                    break label0;
                }
                node.setValue(s);
            }
            return;
        }
        Node node1 = new Node("URLBase");
        node1.setValue(s);
        if (getRootNode().hasNodes());
        getRootNode().insertNode(node1, 1);
    }

    private void setUUID(String s)
    {
        devUUID = s;
    }

    private void soapActionRecieved(HTTPRequest httprequest)
    {
        Service service = getServiceByControlURL(httprequest.getURI());
        if (service != null)
        {
            deviceControlRequestRecieved(new ActionRequest(httprequest), service);
            return;
        } else
        {
            soapBadActionRecieved(httprequest);
            return;
        }
    }

    private void soapBadActionRecieved(HTTPRequest httprequest)
    {
        SOAPResponse soapresponse = new SOAPResponse();
        soapresponse.setStatusCode(400);
        httprequest.post(soapresponse);
    }

    private boolean stop(boolean flag)
    {
        if (flag)
        {
            byebye();
        }
        Object obj = getHTTPServerList();
        ((HTTPServerList) (obj)).stop();
        ((HTTPServerList) (obj)).close();
        ((HTTPServerList) (obj)).clear();
        obj = getSSDPSearchSocketList();
        ((SSDPSearchSocketList) (obj)).stop();
        ((SSDPSearchSocketList) (obj)).close();
        ((SSDPSearchSocketList) (obj)).clear();
        obj = getAdvertiser();
        if (obj != null)
        {
            ((Advertiser) (obj)).stop();
            setAdvertiser(null);
        }
        return true;
    }

    private void updateUDN()
    {
        setUDN((new StringBuilder("uuid:")).append(getUUID()).toString());
    }

    private void updateURLBase(String s)
    {
        setURLBase(HostInterface.getHostURL(s, getHTTPPort(), ""));
    }

    private void upnpBadSubscriptionRecieved(SubscriptionRequest subscriptionrequest, int i)
    {
        SubscriptionResponse subscriptionresponse = new SubscriptionResponse();
        subscriptionresponse.setErrorResponse(i);
        subscriptionrequest.post(subscriptionresponse);
    }

    public void addDevice(Device device)
    {
        Node node2 = getDeviceNode().getNode("deviceList");
        Node node = node2;
        if (node2 == null)
        {
            node = new Node("deviceList");
            getDeviceNode().addNode(node);
        }
        node.addNode(device.getDeviceNode());
        device.setRootNode(null);
        if (getRootNode() == null)
        {
            device = new Node("root");
            device.setNameSpace("", "urn:schemas-upnp-org:device-1-0");
            Node node1 = new Node("specVersion");
            Node node3 = new Node("major");
            node3.setValue("1");
            Node node4 = new Node("minor");
            node4.setValue("0");
            node1.addNode(node3);
            node1.addNode(node4);
            device.addNode(node1);
            setRootNode(device);
        }
    }

    public void addService(Service service)
    {
        Node node1 = getDeviceNode().getNode("serviceList");
        Node node = node1;
        if (node1 == null)
        {
            node = new Node("serviceList");
            getDeviceNode().addNode(node);
        }
        node.addNode(service.getServiceNode());
    }

    public void announce()
    {
        Object aobj[];
        notifyWait();
        aobj = getDeviceData().getHTTPBindAddress();
        if (aobj == null) goto _L2; else goto _L1
_L1:
        String as[];
        int i;
        as = new String[aobj.length];
        i = 0;
_L5:
        if (i < aobj.length) goto _L4; else goto _L3
_L3:
        i = 0;
_L8:
        if (i >= as.length)
        {
            return;
        }
        break MISSING_BLOCK_LABEL_89;
_L4:
        as[i] = aobj[i].getHostAddress();
        i++;
          goto _L5
_L2:
        int j;
        j = HostInterface.getNHostAddresses();
        aobj = new String[j];
        i = 0;
_L7:
        as = ((String []) (aobj));
        if (i >= j) goto _L3; else goto _L6
_L6:
        aobj[i] = HostInterface.getHostAddress(i);
        i++;
          goto _L7
          goto _L3
        if (as[i] != null && as[i].length() != 0)
        {
            int l = getSSDPAnnounceCount();
            int k = 0;
            while (k < l) 
            {
                announce(as[i]);
                k++;
            }
        }
        i++;
          goto _L8
    }

    public void announce(String s)
    {
        Object obj;
        int i;
        int j;
        String s1 = getLocationURL(s);
        obj = new SSDPNotifySocket(s);
        SSDPNotifyRequest ssdpnotifyrequest = new SSDPNotifyRequest();
        ssdpnotifyrequest.setServer(UPnP.getServerName());
        ssdpnotifyrequest.setLeaseTime(getLeaseTime());
        ssdpnotifyrequest.setLocation(s1);
        ssdpnotifyrequest.setNTS("ssdp:alive");
        if (isRootDevice())
        {
            s1 = getNotifyDeviceNT();
            String s2 = getNotifyDeviceUSN();
            ssdpnotifyrequest.setNT(s1);
            ssdpnotifyrequest.setUSN(s2);
            ((SSDPNotifySocket) (obj)).post(ssdpnotifyrequest);
            s1 = getUDN();
            ssdpnotifyrequest.setNT(s1);
            ssdpnotifyrequest.setUSN(s1);
            ((SSDPNotifySocket) (obj)).post(ssdpnotifyrequest);
        }
        s1 = getNotifyDeviceTypeNT();
        String s3 = getNotifyDeviceTypeUSN();
        ssdpnotifyrequest.setNT(s1);
        ssdpnotifyrequest.setUSN(s3);
        ((SSDPNotifySocket) (obj)).post(ssdpnotifyrequest);
        ((SSDPNotifySocket) (obj)).close();
        obj = getServiceList();
        j = ((ServiceList) (obj)).size();
        i = 0;
_L3:
        if (i < j) goto _L2; else goto _L1
_L1:
        obj = getDeviceList();
        j = ((DeviceList) (obj)).size();
        i = 0;
_L4:
        if (i >= j)
        {
            return;
        }
        break MISSING_BLOCK_LABEL_210;
_L2:
        ((ServiceList) (obj)).getService(i).announce(s);
        i++;
          goto _L3
        ((DeviceList) (obj)).getDevice(i).announce(s);
        i++;
          goto _L4
    }

    public void byebye()
    {
        Object aobj[] = getDeviceData().getHTTPBindAddress();
        if (aobj == null) goto _L2; else goto _L1
_L1:
        String as[];
        int i;
        as = new String[aobj.length];
        i = 0;
_L5:
        if (i < aobj.length) goto _L4; else goto _L3
_L3:
        i = 0;
_L8:
        if (i >= as.length)
        {
            return;
        }
        break MISSING_BLOCK_LABEL_86;
_L4:
        as[i] = aobj[i].getHostAddress();
        i++;
          goto _L5
_L2:
        int j;
        j = HostInterface.getNHostAddresses();
        aobj = new String[j];
        i = 0;
_L7:
        as = ((String []) (aobj));
        if (i >= j) goto _L3; else goto _L6
_L6:
        aobj[i] = HostInterface.getHostAddress(i);
        i++;
          goto _L7
          goto _L3
        if (as[i] != null && as[i].length() > 0)
        {
            int l = getSSDPAnnounceCount();
            int k = 0;
            while (k < l) 
            {
                byebye(as[i]);
                k++;
            }
        }
        i++;
          goto _L8
    }

    public void byebye(String s)
    {
        Object obj;
        int i;
        int j;
        obj = new SSDPNotifySocket(s);
        SSDPNotifyRequest ssdpnotifyrequest = new SSDPNotifyRequest();
        ssdpnotifyrequest.setNTS("ssdp:byebye");
        if (isRootDevice())
        {
            String s1 = getNotifyDeviceNT();
            String s3 = getNotifyDeviceUSN();
            ssdpnotifyrequest.setNT(s1);
            ssdpnotifyrequest.setUSN(s3);
            ((SSDPNotifySocket) (obj)).post(ssdpnotifyrequest);
        }
        String s2 = getNotifyDeviceTypeNT();
        String s4 = getNotifyDeviceTypeUSN();
        ssdpnotifyrequest.setNT(s2);
        ssdpnotifyrequest.setUSN(s4);
        ((SSDPNotifySocket) (obj)).post(ssdpnotifyrequest);
        ((SSDPNotifySocket) (obj)).close();
        obj = getServiceList();
        j = ((ServiceList) (obj)).size();
        i = 0;
_L3:
        if (i < j) goto _L2; else goto _L1
_L1:
        obj = getDeviceList();
        j = ((DeviceList) (obj)).size();
        i = 0;
_L4:
        if (i >= j)
        {
            return;
        }
        break MISSING_BLOCK_LABEL_158;
_L2:
        ((ServiceList) (obj)).getService(i).byebye(s);
        i++;
          goto _L3
        ((DeviceList) (obj)).getDevice(i).byebye(s);
        i++;
          goto _L4
    }

    public void deviceSearchReceived(SSDPPacket ssdppacket)
    {
        deviceSearchResponse(ssdppacket);
    }

    public void deviceSearchResponse(SSDPPacket ssdppacket)
    {
        String s3 = ssdppacket.getST();
        if (s3 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        boolean flag;
        flag = isRootDevice();
        String s = getUDN();
        obj = s;
        if (flag)
        {
            obj = (new StringBuilder(String.valueOf(s))).append("::upnp:rootdevice").toString();
        }
        if (!ST.isAllDevice(s3)) goto _L4; else goto _L3
_L3:
        String s1;
        int i;
        int j;
        s1 = getNotifyDeviceNT();
        if (flag)
        {
            i = 3;
        } else
        {
            i = 2;
        }
        j = 0;
_L7:
        if (j < i) goto _L6; else goto _L5
_L5:
        obj = getServiceList();
        j = ((ServiceList) (obj)).size();
        i = 0;
_L8:
        if (i < j)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        obj = getDeviceList();
        j = ((DeviceList) (obj)).size();
        i = 0;
        while (i < j) 
        {
            ((DeviceList) (obj)).getDevice(i).deviceSearchResponse(ssdppacket);
            i++;
        }
          goto _L1
_L6:
        postSearchResponse(ssdppacket, s1, ((String) (obj)));
        j++;
          goto _L7
_L4:
        if (ST.isRootDevice(s3))
        {
            if (flag)
            {
                postSearchResponse(ssdppacket, "upnp:rootdevice", ((String) (obj)));
            }
        } else
        if (ST.isUUIDDevice(s3))
        {
            String s2 = getUDN();
            if (s3.equals(s2))
            {
                postSearchResponse(ssdppacket, s2, ((String) (obj)));
            }
        } else
        if (ST.isURNDevice(s3))
        {
            obj = getDeviceType();
            if (s3.equals(obj))
            {
                postSearchResponse(ssdppacket, ((String) (obj)), (new StringBuilder(String.valueOf(getUDN()))).append("::").append(((String) (obj))).toString());
            }
        }
          goto _L5
        ((ServiceList) (obj)).getService(i).serviceSearchResponse(ssdppacket);
        i++;
          goto _L8
    }

    public String getAbsoluteURL(String s)
    {
        String s1;
        try
        {
            s1 = (new URL(s)).toString();
        }
        catch (Exception exception)
        {
            String s2;
label0:
            {
                Device device = getRootDevice();
                String s3 = device.getURLBase();
                if (s3 != null)
                {
                    s2 = s3;
                    if (s3.length() > 0)
                    {
                        break label0;
                    }
                }
                s2 = device.getLocation();
                s2 = HTTP.getRequestHostURL(HTTP.getHost(s2), HTTP.getPort(s2));
            }
            s = HTTP.toRelativeURL(s);
            String s4 = (new StringBuilder(String.valueOf(s2))).append(s).toString();
            try
            {
                s4 = (new URL(s4)).toString();
            }
            catch (Exception exception1)
            {
                s = HTTP.getAbsoluteURL(s2, s);
                try
                {
                    s = (new URL(s)).toString();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return "";
                }
                return s;
            }
            return s4;
        }
        return s1;
    }

    public Action getAction(String s)
    {
        Object obj;
        int i;
        int k;
        obj = getServiceList();
        k = ((ServiceList) (obj)).size();
        i = 0;
_L5:
        if (i < k) goto _L2; else goto _L1
_L1:
        Object obj2;
        int j;
        obj2 = getDeviceList();
        j = ((DeviceList) (obj2)).size();
        i = 0;
_L9:
        if (i < j) goto _L4; else goto _L3
_L3:
        obj = null;
_L8:
        return ((Action) (obj));
_L2:
        Object obj1;
        int l;
        obj1 = ((ServiceList) (obj)).getService(i).getActionList();
        l = ((ActionList) (obj1)).size();
        j = 0;
_L6:
label0:
        {
            if (j < l)
            {
                break label0;
            }
            i++;
        }
          goto _L5
        obj2 = ((ActionList) (obj1)).getAction(j);
        String s1 = ((Action) (obj2)).getName();
        if (s1 == null || !s1.equals(s))
        {
            j++;
        } else
        {
            return ((Action) (obj2));
        }
          goto _L6
_L4:
        obj1 = ((DeviceList) (obj2)).getDevice(i).getAction(s);
        obj = obj1;
        if (obj1 != null) goto _L8; else goto _L7
_L7:
        i++;
          goto _L9
    }

    public File getDescriptionFile()
    {
        return getDeviceData().getDescriptionFile();
    }

    public String getDescriptionFilePath()
    {
        File file = getDescriptionFile();
        if (file == null)
        {
            return "";
        } else
        {
            return file.getAbsoluteFile().getParent();
        }
    }

    public Device getDevice(String s)
    {
        DeviceList devicelist;
        int i;
        int j;
        devicelist = getDeviceList();
        j = devicelist.size();
        i = 0;
_L6:
        if (i < j) goto _L2; else goto _L1
_L1:
        Device device = null;
_L4:
        return device;
_L2:
        Device device2;
        device2 = devicelist.getDevice(i);
        device = device2;
        if (device2.isDevice(s)) goto _L4; else goto _L3
_L3:
        Device device1 = device2.getDevice(s);
        if (device1 != null)
        {
            return device1;
        }
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public Device getDeviceByDescriptionURI(String s)
    {
        DeviceList devicelist;
        int i;
        int j;
        devicelist = getDeviceList();
        j = devicelist.size();
        i = 0;
_L6:
        if (i < j) goto _L2; else goto _L1
_L1:
        Device device = null;
_L4:
        return device;
_L2:
        Device device2;
        device2 = devicelist.getDevice(i);
        device = device2;
        if (device2.isDescriptionURI(s)) goto _L4; else goto _L3
_L3:
        Device device1 = device2.getDeviceByDescriptionURI(s);
        if (device1 != null)
        {
            return device1;
        }
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public DeviceList getDeviceList()
    {
        DeviceList devicelist = new DeviceList();
        Node node = getDeviceNode().getNode("deviceList");
        if (node != null)
        {
            int j = node.getNNodes();
            int i = 0;
            while (i < j) 
            {
                Node node1 = node.getNode(i);
                if (isDeviceNode(node1))
                {
                    devicelist.add(new Device(node1));
                }
                i++;
            }
        }
        return devicelist;
    }

    public Node getDeviceNode()
    {
        return deviceNode;
    }

    public String getDeviceType()
    {
        return getDeviceNode().getNodeValue("deviceType");
    }

    public long getElapsedTime()
    {
        return (System.currentTimeMillis() - getTimeStamp()) / 1000L;
    }

    public String getFriendlyName()
    {
        return getDeviceNode().getNodeValue("friendlyName");
    }

    public InetAddress[] getHTTPBindAddress()
    {
        return getDeviceData().getHTTPBindAddress();
    }

    public int getHTTPPort()
    {
        return getDeviceData().getHTTPPort();
    }

    public Icon getIcon(int i)
    {
        IconList iconlist = getIconList();
        if (i < 0 && iconlist.size() - 1 < i)
        {
            return null;
        } else
        {
            return iconlist.getIcon(i);
        }
    }

    public IconList getIconList()
    {
        IconList iconlist = new IconList();
        Node node = getDeviceNode().getNode("iconList");
        if (node != null)
        {
            int j = node.getNNodes();
            int i = 0;
            while (i < j) 
            {
                Node node1 = node.getNode(i);
                if (Icon.isIconNode(node1))
                {
                    iconlist.add(new Icon(node1));
                }
                i++;
            }
        }
        return iconlist;
    }

    public String getInterfaceAddress()
    {
        SSDPPacket ssdppacket = getSSDPPacket();
        if (ssdppacket == null)
        {
            return "";
        } else
        {
            return ssdppacket.getLocalAddress();
        }
    }

    public int getLeaseTime()
    {
        SSDPPacket ssdppacket = getSSDPPacket();
        if (ssdppacket != null)
        {
            return ssdppacket.getLeaseTime();
        } else
        {
            return getDeviceData().getLeaseTime();
        }
    }

    public String getLocation()
    {
        SSDPPacket ssdppacket = getSSDPPacket();
        if (ssdppacket != null)
        {
            return ssdppacket.getLocation();
        } else
        {
            return getDeviceData().getLocation();
        }
    }

    public String getLocationURL(String s)
    {
        return HostInterface.getHostURL(s, getHTTPPort(), getDescriptionURI());
    }

    public String getManufacture()
    {
        return getDeviceNode().getNodeValue("manufacturer");
    }

    public String getManufactureURL()
    {
        return getDeviceNode().getNodeValue("manufacturerURL");
    }

    public String getModelDescription()
    {
        return getDeviceNode().getNodeValue("modelDescription");
    }

    public String getModelName()
    {
        return getDeviceNode().getNodeValue("modelName");
    }

    public String getModelNumber()
    {
        return getDeviceNode().getNodeValue("modelNumber");
    }

    public String getModelURL()
    {
        return getDeviceNode().getNodeValue("modelURL");
    }

    public String getMulticastIPv4Address()
    {
        return getDeviceData().getMulticastIPv4Address();
    }

    public String getMulticastIPv6Address()
    {
        return getDeviceData().getMulticastIPv6Address();
    }

    public Device getParentDevice()
    {
        if (isRootDevice())
        {
            return null;
        } else
        {
            return new Device(getDeviceNode().getParentNode().getParentNode());
        }
    }

    public String getPresentationURL()
    {
        return getDeviceNode().getNodeValue("presentationURL");
    }

    public Device getRootDevice()
    {
        Node node = getRootNode();
        Node node1;
        if (node != null)
        {
            if ((node1 = node.getNode("device")) != null)
            {
                return new Device(node, node1);
            }
        }
        return null;
    }

    public Node getRootNode()
    {
        if (rootNode != null)
        {
            return rootNode;
        }
        if (deviceNode == null)
        {
            return null;
        } else
        {
            return deviceNode.getRootNode();
        }
    }

    public int getSSDPAnnounceCount()
    {
        return !isNMPRMode() || !isWirelessMode() ? 1 : 4;
    }

    public InetAddress[] getSSDPBindAddress()
    {
        return getDeviceData().getSSDPBindAddress();
    }

    public String getSSDPIPv4MulticastAddress()
    {
        return getDeviceData().getMulticastIPv4Address();
    }

    public void getSSDPIPv4MulticastAddress(String s)
    {
        getDeviceData().setMulticastIPv4Address(s);
    }

    public String getSSDPIPv6MulticastAddress()
    {
        return getDeviceData().getMulticastIPv6Address();
    }

    public void getSSDPIPv6MulticastAddress(String s)
    {
        getDeviceData().setMulticastIPv6Address(s);
    }

    public SSDPPacket getSSDPPacket()
    {
        if (!isRootDevice())
        {
            return null;
        } else
        {
            return getDeviceData().getSSDPPacket();
        }
    }

    public int getSSDPPort()
    {
        return getDeviceData().getSSDPPort();
    }

    public String getSerialNumber()
    {
        return getDeviceNode().getNodeValue("serialNumber");
    }

    public Service getService(String s)
    {
        Object obj;
        int i;
        int j;
        obj = getServiceList();
        j = ((ServiceList) (obj)).size();
        i = 0;
_L7:
        if (i < j) goto _L2; else goto _L1
_L1:
        obj = getDeviceList();
        j = ((DeviceList) (obj)).size();
        i = 0;
_L9:
        if (i < j) goto _L4; else goto _L3
_L3:
        Service service = null;
_L6:
        return service;
_L2:
        Service service1;
        service1 = ((ServiceList) (obj)).getService(i);
        service = service1;
        if (service1.isService(s)) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L4:
        service1 = ((DeviceList) (obj)).getDevice(i).getService(s);
        service = service1;
        if (service1 != null) goto _L6; else goto _L8
_L8:
        i++;
          goto _L9
    }

    public Service getServiceByControlURL(String s)
    {
        Object obj;
        int i;
        int j;
        obj = getServiceList();
        j = ((ServiceList) (obj)).size();
        i = 0;
_L7:
        if (i < j) goto _L2; else goto _L1
_L1:
        obj = getDeviceList();
        j = ((DeviceList) (obj)).size();
        i = 0;
_L9:
        if (i < j) goto _L4; else goto _L3
_L3:
        Service service = null;
_L6:
        return service;
_L2:
        Service service1;
        service1 = ((ServiceList) (obj)).getService(i);
        service = service1;
        if (service1.isControlURL(s)) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L4:
        service1 = ((DeviceList) (obj)).getDevice(i).getServiceByControlURL(s);
        service = service1;
        if (service1 != null) goto _L6; else goto _L8
_L8:
        i++;
          goto _L9
    }

    public Service getServiceByEventSubURL(String s)
    {
        Object obj;
        int i;
        int j;
        obj = getServiceList();
        j = ((ServiceList) (obj)).size();
        i = 0;
_L7:
        if (i < j) goto _L2; else goto _L1
_L1:
        obj = getDeviceList();
        j = ((DeviceList) (obj)).size();
        i = 0;
_L9:
        if (i < j) goto _L4; else goto _L3
_L3:
        Service service = null;
_L6:
        return service;
_L2:
        Service service1;
        service1 = ((ServiceList) (obj)).getService(i);
        service = service1;
        if (service1.isEventSubURL(s)) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L4:
        service1 = ((DeviceList) (obj)).getDevice(i).getServiceByEventSubURL(s);
        service = service1;
        if (service1 != null) goto _L6; else goto _L8
_L8:
        i++;
          goto _L9
    }

    public Service getServiceBySCPDURL(String s)
    {
        Object obj;
        int i;
        int j;
        obj = getServiceList();
        j = ((ServiceList) (obj)).size();
        i = 0;
_L7:
        if (i < j) goto _L2; else goto _L1
_L1:
        obj = getDeviceList();
        j = ((DeviceList) (obj)).size();
        i = 0;
_L9:
        if (i < j) goto _L4; else goto _L3
_L3:
        Service service = null;
_L6:
        return service;
_L2:
        Service service1;
        service1 = ((ServiceList) (obj)).getService(i);
        service = service1;
        if (service1.isSCPDURL(s)) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L4:
        service1 = ((DeviceList) (obj)).getDevice(i).getServiceBySCPDURL(s);
        service = service1;
        if (service1 != null) goto _L6; else goto _L8
_L8:
        i++;
          goto _L9
    }

    public ServiceList getServiceList()
    {
        ServiceList servicelist = new ServiceList();
        Node node = getDeviceNode().getNode("serviceList");
        if (node != null)
        {
            int j = node.getNNodes();
            int i = 0;
            while (i < j) 
            {
                Node node1 = node.getNode(i);
                if (Service.isServiceNode(node1))
                {
                    servicelist.add(new Service(node1));
                }
                i++;
            }
        }
        return servicelist;
    }

    public Icon getSmallestIcon()
    {
        Icon icon1;
        IconList iconlist;
        int i;
        int j;
        icon1 = null;
        iconlist = getIconList();
        j = iconlist.size();
        i = 0;
_L2:
        Icon icon;
        Icon icon2;
        if (i >= j)
        {
            return icon1;
        }
        icon2 = iconlist.getIcon(i);
        if (icon1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        icon = icon2;
_L3:
        i++;
        icon1 = icon;
        if (true) goto _L2; else goto _L1
_L1:
        icon = icon1;
        if (icon2.getWidth() < icon1.getWidth())
        {
            icon = icon2;
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    public StateVariable getStateVariable(String s)
    {
        return getStateVariable(null, s);
    }

    public StateVariable getStateVariable(String s, String s1)
    {
        if (s != null || s1 != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L11:
        return ((StateVariable) (obj));
_L2:
        int i;
        int j;
        obj = getServiceList();
        j = ((ServiceList) (obj)).size();
        i = 0;
_L8:
        if (i < j) goto _L4; else goto _L3
_L3:
        DeviceList devicelist;
        devicelist = getDeviceList();
        j = devicelist.size();
        i = 0;
_L12:
        Object obj1;
        if (i >= j)
        {
            return null;
        }
        obj1 = devicelist.getDevice(i).getStateVariable(s, s1);
        obj = obj1;
          goto _L5
_L4:
        obj1 = ((ServiceList) (obj)).getService(i);
        if (s == null || ((Service) (obj1)).getServiceType().equals(s)) goto _L7; else goto _L6
_L6:
        i++;
          goto _L8
_L7:
        if ((obj1 = ((Service) (obj1)).getStateVariable(s1)) == null) goto _L6; else goto _L9
_L9:
        return ((StateVariable) (obj1));
_L5:
        if (obj1 != null) goto _L11; else goto _L10
_L10:
        i++;
          goto _L12
    }

    public Service getSubscriberService(String s)
    {
        Object obj;
        int i;
        int j;
        obj = getServiceList();
        j = ((ServiceList) (obj)).size();
        i = 0;
_L7:
        if (i < j) goto _L2; else goto _L1
_L1:
        obj = getDeviceList();
        j = ((DeviceList) (obj)).size();
        i = 0;
_L9:
        if (i < j) goto _L4; else goto _L3
_L3:
        Service service = null;
_L6:
        return service;
_L2:
        Service service1;
        service1 = ((ServiceList) (obj)).getService(i);
        service = service1;
        if (s.equals(service1.getSID())) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L4:
        service1 = ((DeviceList) (obj)).getDevice(i).getSubscriberService(s);
        service = service1;
        if (service1 != null) goto _L6; else goto _L8
_L8:
        i++;
          goto _L9
    }

    public long getTimeStamp()
    {
        SSDPPacket ssdppacket = getSSDPPacket();
        if (ssdppacket != null)
        {
            return ssdppacket.getTimeStamp();
        } else
        {
            return 0L;
        }
    }

    public String getUDN()
    {
        return getDeviceNode().getNodeValue("UDN");
    }

    public String getUPC()
    {
        return getDeviceNode().getNodeValue("UPC");
    }

    public String getURLBase()
    {
        if (isRootDevice())
        {
            return getRootNode().getNodeValue("URLBase");
        } else
        {
            return "";
        }
    }

    public Object getUserData()
    {
        return userData;
    }

    public boolean hasUDN()
    {
        String s = getUDN();
        return s != null && s.length() > 0;
    }

    public void httpRequestRecieved(HTTPRequest httprequest)
    {
        if (Debug.isOn())
        {
            httprequest.print();
        }
        if (httprequest.isGetRequest() || httprequest.isHeadRequest())
        {
            httpGetRequestRecieved(httprequest);
            return;
        }
        if (httprequest.isPostRequest())
        {
            httpPostRequestRecieved(httprequest);
            return;
        }
        if (httprequest.isSubscribeRequest() || httprequest.isUnsubscribeRequest())
        {
            deviceEventSubscriptionRecieved(new SubscriptionRequest(httprequest));
            return;
        } else
        {
            httprequest.returnBadRequest();
            return;
        }
    }

    public boolean isDevice(String s)
    {
        if (s != null)
        {
            if (s.endsWith(getUDN()))
            {
                return true;
            }
            if (s.equals(getFriendlyName()))
            {
                return true;
            }
            if (s.endsWith(getDeviceType()))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isDeviceType(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return s.equals(getDeviceType());
        }
    }

    public boolean isExpired()
    {
        long l = getElapsedTime();
        return (long)(getLeaseTime() + 60) < l;
    }

    public boolean isNMPRMode()
    {
        for (Node node = getDeviceNode(); node == null || node.getNode("INMPR03") == null;)
        {
            return false;
        }

        return true;
    }

    public boolean isRootDevice()
    {
        return getRootNode().getNode("device").getNodeValue("UDN").equals(getUDN());
    }

    public boolean isRunning()
    {
        return getAdvertiser() != null;
    }

    public boolean isWirelessMode()
    {
        return wirelessMode;
    }

    public boolean loadDescription(File file)
        throws InvalidDescriptionException
    {
        try
        {
            rootNode = UPnP.getXMLParser().parse(file);
            if (rootNode == null)
            {
                throw new InvalidDescriptionException("Couldn't find a root node", file);
            }
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            throw new InvalidDescriptionException(file);
        }
        deviceNode = rootNode.getNode("device");
        if (deviceNode == null)
        {
            throw new InvalidDescriptionException("Couldn't find a root device node", file);
        }
        if (!initializeLoadedDescription())
        {
            return false;
        } else
        {
            setDescriptionFile(file);
            return true;
        }
    }

    public boolean loadDescription(InputStream inputstream)
        throws InvalidDescriptionException
    {
        try
        {
            rootNode = UPnP.getXMLParser().parse(inputstream);
            if (rootNode == null)
            {
                throw new InvalidDescriptionException("Couldn't find a root node");
            }
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new InvalidDescriptionException(inputstream);
        }
        deviceNode = rootNode.getNode("device");
        if (deviceNode == null)
        {
            throw new InvalidDescriptionException("Couldn't find a root device node");
        }
        if (!initializeLoadedDescription())
        {
            return false;
        } else
        {
            setDescriptionFile(null);
            return true;
        }
    }

    public boolean loadDescription(String s)
        throws InvalidDescriptionException
    {
        try
        {
            rootNode = UPnP.getXMLParser().parse(s);
            if (rootNode == null)
            {
                throw new InvalidDescriptionException("Couldn't find a root node");
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new InvalidDescriptionException(s);
        }
        deviceNode = rootNode.getNode("device");
        if (deviceNode == null)
        {
            throw new InvalidDescriptionException("Couldn't find a root device node");
        }
        if (!initializeLoadedDescription())
        {
            return false;
        } else
        {
            setDescriptionFile(null);
            return true;
        }
    }

    public void lock()
    {
        mutex.lock();
    }

    public boolean postSearchResponse(SSDPPacket ssdppacket, String s, String s1)
    {
        Object obj = ssdppacket.getLocalAddress();
        String s2 = getRootDevice().getLocationURL(((String) (obj)));
        obj = new SSDPSearchResponse();
        ((SSDPSearchResponse) (obj)).setLeaseTime(getLeaseTime());
        ((SSDPSearchResponse) (obj)).setDate(cal);
        ((SSDPSearchResponse) (obj)).setST(s);
        ((SSDPSearchResponse) (obj)).setUSN(s1);
        ((SSDPSearchResponse) (obj)).setLocation(s2);
        ((SSDPSearchResponse) (obj)).setMYNAME(getFriendlyName());
        TimerUtil.waitRandom(ssdppacket.getMX() * 1000);
        s = ssdppacket.getRemoteAddress();
        int j = ssdppacket.getRemotePort();
        ssdppacket = new SSDPSearchResponseSocket();
        if (Debug.isOn())
        {
            ((SSDPSearchResponse) (obj)).print();
        }
        int k = getSSDPAnnounceCount();
        int i = 0;
        do
        {
            if (i >= k)
            {
                return true;
            }
            ssdppacket.post(s, j, ((SSDPSearchResponse) (obj)));
            i++;
        } while (true);
    }

    public void setActionListener(ActionListener actionlistener)
    {
        ServiceList servicelist = getServiceList();
        int j = servicelist.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            servicelist.getService(i).setActionListener(actionlistener);
            i++;
        } while (true);
    }

    public void setActionListener(ActionListener actionlistener, boolean flag)
    {
        setActionListener(actionlistener);
        if (!flag) goto _L2; else goto _L1
_L1:
        DeviceList devicelist;
        int i;
        int j;
        devicelist = getDeviceList();
        j = devicelist.size();
        i = 0;
_L5:
        if (i < j) goto _L3; else goto _L2
_L2:
        return;
_L3:
        devicelist.getDevice(i).setActionListener(actionlistener, true);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void setDeviceNode(Node node)
    {
        deviceNode = node;
    }

    public void setDeviceType(String s)
    {
        getDeviceNode().setNode("deviceType", s);
    }

    public void setFriendlyName(String s)
    {
        getDeviceNode().setNode("friendlyName", s);
    }

    public void setHTTPBindAddress(InetAddress ainetaddress[])
    {
        getDeviceData().setHTTPBindAddress(ainetaddress);
    }

    public void setHTTPPort(int i)
    {
        getDeviceData().setHTTPPort(i);
    }

    public void setLeaseTime(int i)
    {
        getDeviceData().setLeaseTime(i);
        Advertiser advertiser = getAdvertiser();
        if (advertiser != null)
        {
            announce();
            advertiser.restart();
        }
    }

    public void setLocation(String s)
    {
        getDeviceData().setLocation(s);
    }

    public void setManufacture(String s)
    {
        getDeviceNode().setNode("manufacturer", s);
    }

    public void setManufactureURL(String s)
    {
        getDeviceNode().setNode("manufacturerURL", s);
    }

    public void setModelDescription(String s)
    {
        getDeviceNode().setNode("modelDescription", s);
    }

    public void setModelName(String s)
    {
        getDeviceNode().setNode("modelName", s);
    }

    public void setModelNumber(String s)
    {
        getDeviceNode().setNode("modelNumber", s);
    }

    public void setModelURL(String s)
    {
        getDeviceNode().setNode("modelURL", s);
    }

    public void setMulticastIPv4Address(String s)
    {
        getDeviceData().setMulticastIPv4Address(s);
    }

    public void setMulticastIPv6Address(String s)
    {
        getDeviceData().setMulticastIPv6Address(s);
    }

    public void setNMPRMode(boolean flag)
    {
        Node node = getDeviceNode();
        if (node == null)
        {
            return;
        }
        if (flag)
        {
            node.setNode("INMPR03", "1.0");
            node.removeNode("URLBase");
            return;
        } else
        {
            node.removeNode("INMPR03");
            return;
        }
    }

    public void setPresentationURL(String s)
    {
        getDeviceNode().setNode("presentationURL", s);
    }

    public void setQueryListener(QueryListener querylistener)
    {
        ServiceList servicelist = getServiceList();
        int j = servicelist.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            servicelist.getService(i).setQueryListener(querylistener);
            i++;
        } while (true);
    }

    public void setQueryListener(QueryListener querylistener, boolean flag)
    {
        setQueryListener(querylistener);
        if (!flag) goto _L2; else goto _L1
_L1:
        DeviceList devicelist;
        int i;
        int j;
        devicelist = getDeviceList();
        j = devicelist.size();
        i = 0;
_L5:
        if (i < j) goto _L3; else goto _L2
_L2:
        return;
_L3:
        devicelist.getDevice(i).setQueryListener(querylistener, true);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void setRootNode(Node node)
    {
        rootNode = node;
    }

    public void setSSDPBindAddress(InetAddress ainetaddress[])
    {
        getDeviceData().setSSDPBindAddress(ainetaddress);
    }

    public void setSSDPPacket(SSDPPacket ssdppacket)
    {
        getDeviceData().setSSDPPacket(ssdppacket);
    }

    public void setSSDPPort(int i)
    {
        getDeviceData().setSSDPPort(i);
    }

    public void setSerialNumber(String s)
    {
        getDeviceNode().setNode("serialNumber", s);
    }

    public void setUDN(String s)
    {
        getDeviceNode().setNode("UDN", s);
    }

    public void setUPC(String s)
    {
        getDeviceNode().setNode("UPC", s);
    }

    public void setUserData(Object obj)
    {
        userData = obj;
    }

    public void setWirelessMode(boolean flag)
    {
        wirelessMode = flag;
    }

    public boolean start()
    {
        Object obj;
        int i;
        int j;
        stop(true);
        j = 0;
        i = getHTTPPort();
        obj = getHTTPServerList();
_L6:
        if (!((HTTPServerList) (obj)).open(i)) goto _L2; else goto _L1
_L1:
        ((HTTPServerList) (obj)).addRequestListener(this);
        ((HTTPServerList) (obj)).start();
        obj = getSSDPSearchSocketList();
        if (((SSDPSearchSocketList) (obj)).open())
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        return false;
_L2:
        j++;
        if (100 < j) goto _L4; else goto _L3
_L3:
        setHTTPPort(i + 1);
        i = getHTTPPort();
        if (true) goto _L6; else goto _L5
_L5:
        ((SSDPSearchSocketList) (obj)).addSearchListener(this);
        ((SSDPSearchSocketList) (obj)).start();
        announce();
        obj = new Advertiser(this);
        setAdvertiser(((Advertiser) (obj)));
        ((Advertiser) (obj)).start();
        return true;
    }

    public boolean stop()
    {
        return stop(true);
    }

    public void unlock()
    {
        mutex.unlock();
    }

    static 
    {
        UPnP.initialize();
    }
}
