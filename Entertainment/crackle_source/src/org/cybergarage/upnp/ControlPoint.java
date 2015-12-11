// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import org.cybergarage.http.HTTPRequest;
import org.cybergarage.http.HTTPRequestListener;
import org.cybergarage.http.HTTPServerList;
import org.cybergarage.net.HostInterface;
import org.cybergarage.upnp.control.RenewSubscriber;
import org.cybergarage.upnp.device.DeviceChangeListener;
import org.cybergarage.upnp.device.Disposer;
import org.cybergarage.upnp.device.NotifyListener;
import org.cybergarage.upnp.device.SearchResponseListener;
import org.cybergarage.upnp.device.USN;
import org.cybergarage.upnp.event.EventListener;
import org.cybergarage.upnp.event.NotifyRequest;
import org.cybergarage.upnp.event.Property;
import org.cybergarage.upnp.event.PropertyList;
import org.cybergarage.upnp.event.SubscriptionRequest;
import org.cybergarage.upnp.event.SubscriptionResponse;
import org.cybergarage.upnp.ssdp.SSDPNotifySocketList;
import org.cybergarage.upnp.ssdp.SSDPPacket;
import org.cybergarage.upnp.ssdp.SSDPSearchRequest;
import org.cybergarage.upnp.ssdp.SSDPSearchResponseSocketList;
import org.cybergarage.util.Debug;
import org.cybergarage.util.ListenerList;
import org.cybergarage.util.Mutex;
import org.cybergarage.xml.Node;
import org.cybergarage.xml.NodeList;
import org.cybergarage.xml.Parser;
import org.cybergarage.xml.ParserException;

// Referenced classes of package org.cybergarage.upnp:
//            UPnP, Device, DeviceList, Service, 
//            ServiceList

public class ControlPoint
    implements HTTPRequestListener
{

    private static final int DEFAULT_EVENTSUB_PORT = 8058;
    private static final String DEFAULT_EVENTSUB_URI = "/evetSub";
    private static final int DEFAULT_EXPIRED_DEVICE_MONITORING_INTERVAL = 60;
    private static final int DEFAULT_SSDP_PORT = 8008;
    private NodeList devNodeList;
    ListenerList deviceChangeListenerList;
    private Disposer deviceDisposer;
    private ListenerList deviceNotifyListenerList;
    private ListenerList deviceSearchResponseListenerList;
    private ListenerList eventListenerList;
    private String eventSubURI;
    private long expiredDeviceMonitoringInterval;
    private int httpPort;
    private HTTPServerList httpServerList;
    private Mutex mutex;
    private boolean nmprMode;
    private RenewSubscriber renewSubscriber;
    private int searchMx;
    private SSDPNotifySocketList ssdpNotifySocketList;
    private int ssdpPort;
    private SSDPSearchResponseSocketList ssdpSearchResponseSocketList;
    private Object userData;

    public ControlPoint()
    {
        this(8008, 8058);
    }

    public ControlPoint(int i, int j)
    {
        this(i, j, null);
    }

    public ControlPoint(int i, int j, InetAddress ainetaddress[])
    {
        mutex = new Mutex();
        ssdpPort = 0;
        httpPort = 0;
        devNodeList = new NodeList();
        deviceNotifyListenerList = new ListenerList();
        deviceSearchResponseListenerList = new ListenerList();
        deviceChangeListenerList = new ListenerList();
        searchMx = 3;
        httpServerList = new HTTPServerList();
        eventListenerList = new ListenerList();
        eventSubURI = "/evetSub";
        userData = null;
        ssdpNotifySocketList = new SSDPNotifySocketList(ainetaddress);
        ssdpSearchResponseSocketList = new SSDPSearchResponseSocketList(ainetaddress);
        setSSDPPort(i);
        setHTTPPort(j);
        setDeviceDisposer(null);
        setExpiredDeviceMonitoringInterval(60L);
        setRenewSubscriber(null);
        setNMPRMode(false);
        setRenewSubscriber(null);
    }

    private void addDevice(SSDPPacket ssdppacket)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = ssdppacket.isRootDevice();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj = getDevice(USN.getUDN(ssdppacket.getUSN()));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        ((Device) (obj)).setSSDPPacket(ssdppacket);
          goto _L1
        ssdppacket;
        throw ssdppacket;
        obj = ssdppacket.getLocation();
        Device device;
        obj = new URL(((String) (obj)));
        obj = UPnP.getXMLParser().parse(((URL) (obj)));
        device = getDevice(((Node) (obj)));
        if (device == null) goto _L1; else goto _L3
_L3:
        device.setSSDPPacket(ssdppacket);
        addDevice(((Node) (obj)));
        performAddDeviceListener(device);
          goto _L1
        Object obj1;
        obj1;
        Debug.warning(ssdppacket.toString());
        Debug.warning(((Exception) (obj1)));
          goto _L1
        obj1;
        Debug.warning(ssdppacket.toString());
        Debug.warning(((Exception) (obj1)));
          goto _L1
    }

    private void addDevice(Node node)
    {
        devNodeList.add(node);
    }

    private Device getDevice(Node node)
    {
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

    private String getEventSubCallbackURL(String s)
    {
        return HostInterface.getHostURL(s, getHTTPPort(), getEventSubURI());
    }

    private HTTPServerList getHTTPServerList()
    {
        return httpServerList;
    }

    private SSDPNotifySocketList getSSDPNotifySocketList()
    {
        return ssdpNotifySocketList;
    }

    private SSDPSearchResponseSocketList getSSDPSearchResponseSocketList()
    {
        return ssdpSearchResponseSocketList;
    }

    private void removeDevice(SSDPPacket ssdppacket)
    {
        if (!ssdppacket.isByeBye())
        {
            return;
        } else
        {
            removeDevice(USN.getUDN(ssdppacket.getUSN()));
            return;
        }
    }

    private void removeDevice(Node node)
    {
        Device device = getDevice(node);
        if (device != null && device.isRootDevice())
        {
            performRemoveDeviceListener(device);
        }
        devNodeList.remove(node);
    }

    public void addDeviceChangeListener(DeviceChangeListener devicechangelistener)
    {
        deviceChangeListenerList.add(devicechangelistener);
    }

    public void addEventListener(EventListener eventlistener)
    {
        eventListenerList.add(eventlistener);
    }

    public void addNotifyListener(NotifyListener notifylistener)
    {
        deviceNotifyListenerList.add(notifylistener);
    }

    public void addSearchResponseListener(SearchResponseListener searchresponselistener)
    {
        deviceSearchResponseListenerList.add(searchresponselistener);
    }

    public void finalize()
    {
        stop();
    }

    public Device getDevice(String s)
    {
        int i;
        int j;
        j = devNodeList.size();
        i = 0;
_L9:
        if (i < j) goto _L2; else goto _L1
_L1:
        Device device = null;
_L6:
        return device;
_L2:
        Device device1 = getDevice(devNodeList.getNode(i));
        if (device1 != null) goto _L4; else goto _L3
_L3:
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        device = device1;
        if (device1.isDevice(s)) goto _L6; else goto _L5
_L5:
        device = device1.getDevice(s);
        if (device == null) goto _L3; else goto _L7
_L7:
        return device;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public Disposer getDeviceDisposer()
    {
        return deviceDisposer;
    }

    public DeviceList getDeviceList()
    {
        DeviceList devicelist = new DeviceList();
        int i = 0;
        do
        {
            if (i >= devNodeList.size())
            {
                return devicelist;
            }
            Device device = getDevice(devNodeList.getNode(i));
            if (device != null)
            {
                devicelist.add(device);
            }
            i++;
        } while (true);
    }

    public String getEventSubURI()
    {
        return eventSubURI;
    }

    public long getExpiredDeviceMonitoringInterval()
    {
        return expiredDeviceMonitoringInterval;
    }

    public int getHTTPPort()
    {
        return httpPort;
    }

    public RenewSubscriber getRenewSubscriber()
    {
        return renewSubscriber;
    }

    public int getSSDPPort()
    {
        return ssdpPort;
    }

    public int getSearchMx()
    {
        return searchMx;
    }

    public Service getSubscriberService(String s)
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
        Service service = null;
_L4:
        return service;
_L2:
        Service service1;
        service1 = devicelist.getDevice(i).getSubscriberService(s);
        service = service1;
        if (service1 != null) goto _L4; else goto _L3
_L3:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public Object getUserData()
    {
        return userData;
    }

    public boolean hasDevice(String s)
    {
        return getDevice(s) != null;
    }

    public void httpRequestRecieved(HTTPRequest httprequest)
    {
        if (Debug.isOn())
        {
            httprequest.print();
        }
        if (httprequest.isNotifyRequest())
        {
            Object obj = new NotifyRequest(httprequest);
            String s = ((NotifyRequest) (obj)).getSID();
            long l = ((NotifyRequest) (obj)).getSEQ();
            obj = ((NotifyRequest) (obj)).getPropertyList();
            int j = ((PropertyList) (obj)).size();
            int i = 0;
            do
            {
                if (i >= j)
                {
                    httprequest.returnOK();
                    return;
                }
                Property property = ((PropertyList) (obj)).getProperty(i);
                performEventListener(s, l, property.getName(), property.getValue());
                i++;
            } while (true);
        } else
        {
            httprequest.returnBadRequest();
            return;
        }
    }

    public boolean isNMPRMode()
    {
        return nmprMode;
    }

    public boolean isSubscribed(Service service)
    {
        if (service == null)
        {
            return false;
        } else
        {
            return service.isSubscribed();
        }
    }

    public void lock()
    {
        mutex.lock();
    }

    public void notifyReceived(SSDPPacket ssdppacket)
    {
        if (!ssdppacket.isRootDevice()) goto _L2; else goto _L1
_L1:
        if (!ssdppacket.isAlive()) goto _L4; else goto _L3
_L3:
        addDevice(ssdppacket);
_L2:
        performNotifyListener(ssdppacket);
        return;
_L4:
        if (ssdppacket.isByeBye())
        {
            removeDevice(ssdppacket);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void performAddDeviceListener(Device device)
    {
        int j = deviceChangeListenerList.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            ((DeviceChangeListener)deviceChangeListenerList.get(i)).deviceAdded(device);
            i++;
        } while (true);
    }

    public void performEventListener(String s, long l, String s1, String s2)
    {
        int j = eventListenerList.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            ((EventListener)eventListenerList.get(i)).eventNotifyReceived(s, l, s1, s2);
            i++;
        } while (true);
    }

    public void performNotifyListener(SSDPPacket ssdppacket)
    {
        int j = deviceNotifyListenerList.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            NotifyListener notifylistener = (NotifyListener)deviceNotifyListenerList.get(i);
            try
            {
                notifylistener.deviceNotifyReceived(ssdppacket);
            }
            catch (Exception exception)
            {
                Debug.warning("NotifyListener returned an error:", exception);
            }
            i++;
        } while (true);
    }

    public void performRemoveDeviceListener(Device device)
    {
        int j = deviceChangeListenerList.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            ((DeviceChangeListener)deviceChangeListenerList.get(i)).deviceRemoved(device);
            i++;
        } while (true);
    }

    public void performSearchResponseListener(SSDPPacket ssdppacket)
    {
        int j = deviceSearchResponseListenerList.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            SearchResponseListener searchresponselistener = (SearchResponseListener)deviceSearchResponseListenerList.get(i);
            try
            {
                searchresponselistener.deviceSearchResponseReceived(ssdppacket);
            }
            catch (Exception exception)
            {
                Debug.warning("SearchResponseListener returned an error:", exception);
            }
            i++;
        } while (true);
    }

    public void print()
    {
        DeviceList devicelist = getDeviceList();
        int j = devicelist.size();
        Debug.message((new StringBuilder("Device Num = ")).append(j).toString());
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            Device device = devicelist.getDevice(i);
            Debug.message((new StringBuilder("[")).append(i).append("] ").append(device.getFriendlyName()).append(", ").append(device.getLeaseTime()).append(", ").append(device.getElapsedTime()).toString());
            i++;
        } while (true);
    }

    protected void removeDevice(String s)
    {
        removeDevice(getDevice(s));
    }

    protected void removeDevice(Device device)
    {
        if (device == null)
        {
            return;
        } else
        {
            removeDevice(device.getRootNode());
            return;
        }
    }

    public void removeDeviceChangeListener(DeviceChangeListener devicechangelistener)
    {
        deviceChangeListenerList.remove(devicechangelistener);
    }

    public void removeEventListener(EventListener eventlistener)
    {
        eventListenerList.remove(eventlistener);
    }

    public void removeExpiredDevices()
    {
        DeviceList devicelist;
        Device adevice[];
        int i;
        int j;
        devicelist = getDeviceList();
        j = devicelist.size();
        adevice = new Device[j];
        i = 0;
_L3:
        if (i < j) goto _L2; else goto _L1
_L1:
        i = 0;
_L4:
        if (i >= j)
        {
            return;
        }
        break MISSING_BLOCK_LABEL_49;
_L2:
        adevice[i] = devicelist.getDevice(i);
        i++;
          goto _L3
        if (adevice[i].isExpired())
        {
            Debug.message((new StringBuilder("Expired device = ")).append(adevice[i].getFriendlyName()).toString());
            removeDevice(adevice[i]);
        }
        i++;
          goto _L4
    }

    public void removeNotifyListener(NotifyListener notifylistener)
    {
        deviceNotifyListenerList.remove(notifylistener);
    }

    public void removeSearchResponseListener(SearchResponseListener searchresponselistener)
    {
        deviceSearchResponseListenerList.remove(searchresponselistener);
    }

    public void renewSubscriberService()
    {
        renewSubscriberService(-1L);
    }

    public void renewSubscriberService(long l)
    {
        DeviceList devicelist = getDeviceList();
        int j = devicelist.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            renewSubscriberService(devicelist.getDevice(i), l);
            i++;
        } while (true);
    }

    public void renewSubscriberService(Device device, long l)
    {
        ServiceList servicelist;
        int i;
        int j;
        servicelist = device.getServiceList();
        j = servicelist.size();
        i = 0;
_L3:
        if (i < j) goto _L2; else goto _L1
_L1:
        device = device.getDeviceList();
        j = device.size();
        i = 0;
_L4:
        if (i >= j)
        {
            return;
        }
        break MISSING_BLOCK_LABEL_97;
_L2:
        Service service = servicelist.getService(i);
        if (service.isSubscribed() && !subscribe(service, service.getSID(), l))
        {
            subscribe(service, l);
        }
        i++;
          goto _L3
        renewSubscriberService(device.getDevice(i), l);
        i++;
          goto _L4
    }

    public void search()
    {
        search("upnp:rootdevice", 3);
    }

    public void search(String s)
    {
        search(s, 3);
    }

    public void search(String s, int i)
    {
        s = new SSDPSearchRequest(s, i);
        getSSDPSearchResponseSocketList().post(s);
    }

    public void searchResponseReceived(SSDPPacket ssdppacket)
    {
        if (ssdppacket.isRootDevice())
        {
            addDevice(ssdppacket);
        }
        performSearchResponseListener(ssdppacket);
    }

    public void setDeviceDisposer(Disposer disposer)
    {
        deviceDisposer = disposer;
    }

    public void setEventSubURI(String s)
    {
        eventSubURI = s;
    }

    public void setExpiredDeviceMonitoringInterval(long l)
    {
        expiredDeviceMonitoringInterval = l;
    }

    public void setHTTPPort(int i)
    {
        httpPort = i;
    }

    public void setNMPRMode(boolean flag)
    {
        nmprMode = flag;
    }

    public void setRenewSubscriber(RenewSubscriber renewsubscriber)
    {
        renewSubscriber = renewsubscriber;
    }

    public void setSSDPPort(int i)
    {
        ssdpPort = i;
    }

    public void setSearchMx(int i)
    {
        searchMx = i;
    }

    public void setUserData(Object obj)
    {
        userData = obj;
    }

    public boolean start()
    {
        return start("upnp:rootdevice", 3);
    }

    public boolean start(String s)
    {
        return start(s, 3);
    }

    public boolean start(String s, int i)
    {
        Object obj;
        int j;
        int k;
        stop();
        k = 0;
        j = getHTTPPort();
        obj = getHTTPServerList();
_L6:
        if (!((HTTPServerList) (obj)).open(j)) goto _L2; else goto _L1
_L1:
        ((HTTPServerList) (obj)).addRequestListener(this);
        ((HTTPServerList) (obj)).start();
        obj = getSSDPNotifySocketList();
        if (((SSDPNotifySocketList) (obj)).open()) goto _L4; else goto _L3
_L3:
        return false;
_L2:
        k++;
        if (100 < k) goto _L3; else goto _L5
_L5:
        setHTTPPort(j + 1);
        j = getHTTPPort();
          goto _L6
_L4:
        ((SSDPNotifySocketList) (obj)).setControlPoint(this);
        ((SSDPNotifySocketList) (obj)).start();
        j = getSSDPPort();
        k = 0;
        obj = getSSDPSearchResponseSocketList();
_L8:
        if (((SSDPSearchResponseSocketList) (obj)).open(j))
        {
            ((SSDPSearchResponseSocketList) (obj)).setControlPoint(this);
            ((SSDPSearchResponseSocketList) (obj)).start();
            search(s, i);
            s = new Disposer(this);
            setDeviceDisposer(s);
            s.start();
            if (isNMPRMode())
            {
                s = new RenewSubscriber(this);
                setRenewSubscriber(s);
                s.start();
            }
            return true;
        }
        k++;
        if (100 < k) goto _L3; else goto _L7
_L7:
        setSSDPPort(j + 1);
        j = getSSDPPort();
          goto _L8
    }

    public boolean stop()
    {
        unsubscribe();
        Object obj = getSSDPNotifySocketList();
        ((SSDPNotifySocketList) (obj)).stop();
        ((SSDPNotifySocketList) (obj)).close();
        ((SSDPNotifySocketList) (obj)).clear();
        obj = getSSDPSearchResponseSocketList();
        ((SSDPSearchResponseSocketList) (obj)).stop();
        ((SSDPSearchResponseSocketList) (obj)).close();
        ((SSDPSearchResponseSocketList) (obj)).clear();
        obj = getHTTPServerList();
        ((HTTPServerList) (obj)).stop();
        ((HTTPServerList) (obj)).close();
        ((HTTPServerList) (obj)).clear();
        obj = getDeviceDisposer();
        if (obj != null)
        {
            ((Disposer) (obj)).stop();
            setDeviceDisposer(null);
        }
        obj = getRenewSubscriber();
        if (obj != null)
        {
            ((RenewSubscriber) (obj)).stop();
            setRenewSubscriber(null);
        }
        return true;
    }

    public boolean subscribe(Service service)
    {
        return subscribe(service, -1L);
    }

    public boolean subscribe(Service service, long l)
    {
        boolean flag = false;
        if (service.isSubscribed())
        {
            flag = subscribe(service, service.getSID(), l);
        } else
        {
            Object obj = service.getRootDevice();
            if (obj != null)
            {
                obj = ((Device) (obj)).getInterfaceAddress();
                SubscriptionRequest subscriptionrequest = new SubscriptionRequest();
                subscriptionrequest.setSubscribeRequest(service, getEventSubCallbackURL(((String) (obj))), l);
                obj = subscriptionrequest.post();
                if (((SubscriptionResponse) (obj)).isSuccessful())
                {
                    service.setSID(((SubscriptionResponse) (obj)).getSID());
                    service.setTimeout(((SubscriptionResponse) (obj)).getTimeout());
                    return true;
                } else
                {
                    service.clearSID();
                    return false;
                }
            }
        }
        return flag;
    }

    public boolean subscribe(Service service, String s)
    {
        return subscribe(service, s, -1L);
    }

    public boolean subscribe(Service service, String s, long l)
    {
        SubscriptionRequest subscriptionrequest = new SubscriptionRequest();
        subscriptionrequest.setRenewRequest(service, s, l);
        if (Debug.isOn())
        {
            subscriptionrequest.print();
        }
        s = subscriptionrequest.post();
        if (Debug.isOn())
        {
            s.print();
        }
        if (s.isSuccessful())
        {
            service.setSID(s.getSID());
            service.setTimeout(s.getTimeout());
            return true;
        } else
        {
            service.clearSID();
            return false;
        }
    }

    public void unlock()
    {
        mutex.unlock();
    }

    public void unsubscribe()
    {
        DeviceList devicelist = getDeviceList();
        int j = devicelist.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            unsubscribe(devicelist.getDevice(i));
            i++;
        } while (true);
    }

    public void unsubscribe(Device device)
    {
        ServiceList servicelist;
        int i;
        int j;
        servicelist = device.getServiceList();
        j = servicelist.size();
        i = 0;
_L3:
        if (i < j) goto _L2; else goto _L1
_L1:
        device = device.getDeviceList();
        j = device.size();
        i = 0;
_L4:
        if (i >= j)
        {
            return;
        }
        break MISSING_BLOCK_LABEL_72;
_L2:
        Service service = servicelist.getService(i);
        if (service.hasSID())
        {
            unsubscribe(service);
        }
        i++;
          goto _L3
        unsubscribe(device.getDevice(i));
        i++;
          goto _L4
    }

    public boolean unsubscribe(Service service)
    {
        SubscriptionRequest subscriptionrequest = new SubscriptionRequest();
        subscriptionrequest.setUnsubscribeRequest(service);
        if (subscriptionrequest.post().isSuccessful())
        {
            service.clearSID();
            return true;
        } else
        {
            return false;
        }
    }

    static 
    {
        UPnP.initialize();
    }
}
