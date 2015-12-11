// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.smarttv;

import android.os.Handler;
import android.os.Message;
import com.gotv.crackle.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.cybergarage.upnp.ControlPoint;
import org.cybergarage.upnp.Device;
import org.cybergarage.upnp.DeviceList;
import org.cybergarage.upnp.device.DeviceChangeListener;
import org.cybergarage.upnp.device.SearchResponseListener;
import org.cybergarage.upnp.ssdp.SSDPPacket;
import org.cybergarage.xml.Node;

// Referenced classes of package com.gotv.crackle.smarttv:
//            SmartTVListener

public class SmartTVDiscovery
    implements DeviceChangeListener, SearchResponseListener
{
    private class InternalHandler extends Handler
    {

        final SmartTVDiscovery this$0;

        public void handleMessage(Message message)
        {
            updateDeviceList();
        }

        private InternalHandler()
        {
            this$0 = SmartTVDiscovery.this;
            super();
        }

    }


    private static String SERVICE_ID_FILTER = "urn:samsung.com:device:RemoteControlReceiver:1";
    private static final String TAG = "SmartTVDiscovery";
    private ControlPoint mControlPoint;
    private List mDeviceList;
    private final InternalHandler mHandler = new InternalHandler();
    private List mListeners;

    public SmartTVDiscovery()
    {
        mDeviceList = new ArrayList();
        mControlPoint = null;
        mListeners = null;
    }

    private boolean hasDevice(Device device)
    {
        boolean flag = false;
        Iterator iterator = mDeviceList.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((Device)iterator.next()).getLocation().equalsIgnoreCase(device.getLocation()))
            {
                flag = true;
            }
        } while (true);
        return flag;
    }

    public void deviceAdded(Device device)
    {
        Log.d("SmartTVDiscovery", "Received device added event");
        if (device != null)
        {
            mHandler.sendMessage(new Message());
        }
    }

    public void deviceRemoved(Device device)
    {
        Log.d("SmartTVDiscovery", "Received device removed event");
        if (device != null)
        {
            device.byebye();
        }
        if (device != null)
        {
            mHandler.sendMessage(new Message());
        }
    }

    public void deviceSearchResponseReceived(SSDPPacket ssdppacket)
    {
        Log.d("SmartTVDiscovery", ssdppacket.getLocation());
        mHandler.sendMessage(new Message());
    }

    public Device getDevice(int i)
    {
        if (mDeviceList != null && i < mDeviceList.size())
        {
            return (Device)mDeviceList.get(i);
        } else
        {
            return null;
        }
    }

    public List getDeviceList()
    {
        return mDeviceList;
    }

    public void init()
    {
        initializeControlPoint();
    }

    public void initializeControlPoint()
    {
        Log.d("SmartTVDiscovery", "Upnp control point initialization.");
        mControlPoint = new ControlPoint();
        mControlPoint.addDeviceChangeListener(this);
        mControlPoint.addSearchResponseListener(this);
        mControlPoint.start();
        Log.d("SmartTVDiscovery", "Upnp control point initialization successfull.");
    }

    public void search()
    {
        mControlPoint.search("upnp:rootdevice");
    }

    void setListeners(List list)
    {
        mListeners = list;
    }

    public void stopControlPoint()
    {
        mControlPoint.stop();
        Log.d("SmartTVDiscovery", "Upnp control point stop successfull.");
    }

    public void updateDeviceList()
    {
        DeviceList devicelist;
        int i;
        Log.d("SmartTVDiscovery", "updateDeviceList: Entered.");
        if (mDeviceList == null)
        {
            mDeviceList = new ArrayList();
        }
        mDeviceList.clear();
        devicelist = mControlPoint.getDeviceList();
        i = 0;
_L18:
        if (devicelist == null || i >= devicelist.size()) goto _L2; else goto _L1
_L1:
        Device device = devicelist.getDevice(i);
        if (!device.getDeviceType().equalsIgnoreCase(SERVICE_ID_FILTER)) goto _L4; else goto _L3
_L3:
        Object obj = device.getRootNode();
        if (obj == null) goto _L6; else goto _L5
_L5:
        obj = ((Node) (obj)).getNode("device");
_L19:
        if (obj == null) goto _L8; else goto _L7
_L7:
        obj = ((Node) (obj)).getNode("serviceList");
_L20:
        if (obj == null) goto _L10; else goto _L9
_L9:
        obj = ((Node) (obj)).getNode("service");
_L21:
        if (obj == null) goto _L12; else goto _L11
_L11:
        obj = ((Node) (obj)).getNode("serviceType");
_L22:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_372;
        }
        obj = ((Node) (obj)).getValue();
_L23:
        if (obj == null) goto _L14; else goto _L13
_L13:
        if (!((String) (obj)).contains("MultiScreenService")) goto _L14; else goto _L15
_L15:
        if (!hasDevice(device))
        {
            mDeviceList.add(device);
        }
          goto _L4
_L14:
        if (!device.getFriendlyName().equalsIgnoreCase("Samsung TV Apps SDK")) goto _L17; else goto _L16
_L16:
        if (!hasDevice(device))
        {
            mDeviceList.add(device);
        }
          goto _L4
_L17:
        try
        {
            Log.d("SmartTVDiscovery", (new StringBuilder()).append("Text 'ConvergenceApp' never found inside a tag 'sec:ProductCap' in XML ").append(device.getRootNode().toString()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.d("SmartTVDiscovery", (new StringBuilder()).append("Edded add device to List = ").append(((Exception) (obj)).getMessage()).toString());
        }
          goto _L4
_L2:
        Log.d("SmartTVDiscovery", "Calling listeners' onDeviceListUpdate() method");
        if (mListeners != null && mListeners.size() > 0)
        {
            for (obj = mListeners.iterator(); ((Iterator) (obj)).hasNext(); ((SmartTVListener)((Iterator) (obj)).next()).onSmartTVDeviceListUpdate(mDeviceList)) { }
        }
        Log.d("SmartTVDiscovery", "updateDeviceList: Exit.");
        return;
_L4:
        i++;
          goto _L18
_L6:
        obj = null;
          goto _L19
_L8:
        obj = null;
          goto _L20
_L10:
        obj = null;
          goto _L21
_L12:
        obj = null;
          goto _L22
        obj = "";
          goto _L23
    }

}
