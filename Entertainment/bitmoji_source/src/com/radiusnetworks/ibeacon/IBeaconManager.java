// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.radiusnetworks.ibeacon.service.IBeaconService;
import com.radiusnetworks.ibeacon.service.RegionData;
import com.radiusnetworks.ibeacon.service.StartRMData;
import com.radiusnetworks.ibeacon.simulator.BeaconSimulator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.radiusnetworks.ibeacon:
//            IBeaconConsumer, BleNotAvailableException, Region, RangeNotifier, 
//            MonitorNotifier

public class IBeaconManager
{
    private class ConsumerInfo
    {

        public boolean isConnected;
        public boolean isInBackground;
        final IBeaconManager this$0;

        private ConsumerInfo()
        {
            this$0 = IBeaconManager.this;
            super();
            isConnected = false;
            isInBackground = false;
        }

    }


    public static final long DEFAULT_BACKGROUND_BETWEEN_SCAN_PERIOD = 0x493e0L;
    public static final long DEFAULT_BACKGROUND_SCAN_PERIOD = 10000L;
    public static final long DEFAULT_FOREGROUND_BETWEEN_SCAN_PERIOD = 0L;
    public static final long DEFAULT_FOREGROUND_SCAN_PERIOD = 1100L;
    private static final String TAG = "IBeaconManager";
    protected static BeaconSimulator beaconSimulator;
    protected static IBeaconManager client = null;
    public static boolean debug = false;
    private long backgroundBetweenScanPeriod;
    private long backgroundScanPeriod;
    private Map consumers;
    private Context context;
    protected RangeNotifier dataRequestNotifier;
    private long foregroundBetweenScanPeriod;
    private long foregroundScanPeriod;
    private ServiceConnection iBeaconServiceConnection;
    protected MonitorNotifier monitorNotifier;
    private ArrayList monitoredRegions;
    protected RangeNotifier rangeNotifier;
    private ArrayList rangedRegions;
    private Messenger serviceMessenger;

    protected IBeaconManager(Context context1)
    {
        consumers = new HashMap();
        serviceMessenger = null;
        rangeNotifier = null;
        dataRequestNotifier = null;
        monitorNotifier = null;
        monitoredRegions = new ArrayList();
        rangedRegions = new ArrayList();
        foregroundScanPeriod = 1100L;
        foregroundBetweenScanPeriod = 0L;
        backgroundScanPeriod = 10000L;
        backgroundBetweenScanPeriod = 0x493e0L;
        iBeaconServiceConnection = new ServiceConnection() {

            final IBeaconManager this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                if (IBeaconManager.debug)
                {
                    Log.d("IBeaconManager", "we have a connection to the service now");
                }
                serviceMessenger = new Messenger(ibinder);
                componentname = consumers;
                componentname;
                JVM INSTR monitorenter ;
                ibinder = consumers.keySet().iterator();
                do
                {
                    if (!ibinder.hasNext())
                    {
                        break;
                    }
                    IBeaconConsumer ibeaconconsumer = (IBeaconConsumer)ibinder.next();
                    if (!Boolean.valueOf(((ConsumerInfo)consumers.get(ibeaconconsumer)).isConnected).booleanValue())
                    {
                        ibeaconconsumer.onIBeaconServiceConnect();
                        ConsumerInfo consumerinfo = (ConsumerInfo)consumers.get(ibeaconconsumer);
                        consumerinfo.isConnected = true;
                        consumers.put(ibeaconconsumer, consumerinfo);
                    }
                } while (true);
                break MISSING_BLOCK_LABEL_159;
                ibinder;
                componentname;
                JVM INSTR monitorexit ;
                throw ibinder;
                componentname;
                JVM INSTR monitorexit ;
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                Log.e("IBeaconManager", "onServiceDisconnected");
            }

            
            {
                this$0 = IBeaconManager.this;
                super();
            }
        };
        context = context1;
    }

    private String callbackPackageName()
    {
        String s = context.getPackageName();
        if (debug)
        {
            Log.d("IBeaconManager", (new StringBuilder()).append("callback packageName: ").append(s).toString());
        }
        return s;
    }

    public static BeaconSimulator getBeaconSimulator()
    {
        return beaconSimulator;
    }

    private long getBetweenScanPeriod()
    {
        if (isInBackground())
        {
            return backgroundBetweenScanPeriod;
        } else
        {
            return foregroundBetweenScanPeriod;
        }
    }

    public static IBeaconManager getInstanceForApplication(Context context1)
    {
        if (client == null)
        {
            if (debug)
            {
                Log.d("IBeaconManager", "IBeaconManager instance creation");
            }
            client = new IBeaconManager(context1);
        }
        return client;
    }

    private long getScanPeriod()
    {
        if (isInBackground())
        {
            return backgroundScanPeriod;
        } else
        {
            return foregroundScanPeriod;
        }
    }

    private boolean isInBackground()
    {
        boolean flag = true;
        Map map = consumers;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator = consumers.keySet().iterator();
_L2:
        IBeaconConsumer ibeaconconsumer;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_124;
        }
        ibeaconconsumer = (IBeaconConsumer)iterator.next();
        if (!((ConsumerInfo)consumers.get(ibeaconconsumer)).isInBackground)
        {
            flag = false;
        }
        if (!debug) goto _L2; else goto _L1
_L1:
        Log.d("IBeaconManager", (new StringBuilder()).append("Consumer ").append(ibeaconconsumer).append(" isInBackground=").append(((ConsumerInfo)consumers.get(ibeaconconsumer)).isInBackground).toString());
          goto _L2
        map;
        JVM INSTR monitorexit ;
        if (debug)
        {
            Log.d("IBeaconManager", (new StringBuilder()).append("Overall background mode is therefore ").append(flag).toString());
        }
        return flag;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void setBeaconSimulator(BeaconSimulator beaconsimulator)
    {
        beaconSimulator = beaconsimulator;
    }

    public static void setDebug(boolean flag)
    {
        debug = flag;
    }

    public void bind(IBeaconConsumer ibeaconconsumer)
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            Log.w("IBeaconManager", "Not supported prior to SDK 18.  Method invocation will be ignored");
            return;
        }
        Map map = consumers;
        map;
        JVM INSTR monitorenter ;
        if (!consumers.keySet().contains(ibeaconconsumer))
        {
            break MISSING_BLOCK_LABEL_64;
        }
        if (debug)
        {
            Log.d("IBeaconManager", "This consumer is already bound");
        }
_L1:
        return;
        ibeaconconsumer;
        map;
        JVM INSTR monitorexit ;
        throw ibeaconconsumer;
        if (debug)
        {
            Log.d("IBeaconManager", (new StringBuilder()).append("This consumer is not bound.  binding: ").append(ibeaconconsumer).toString());
        }
        consumers.put(ibeaconconsumer, new ConsumerInfo());
        ibeaconconsumer.bindService(new Intent(ibeaconconsumer.getApplicationContext(), com/radiusnetworks/ibeacon/service/IBeaconService), iBeaconServiceConnection, 1);
        if (debug)
        {
            Log.d("IBeaconManager", (new StringBuilder()).append("consumer count is now:").append(consumers.size()).toString());
        }
        if (serviceMessenger != null)
        {
            setBackgroundMode(ibeaconconsumer, false);
        }
          goto _L1
    }

    public boolean checkAvailability()
        throws BleNotAvailableException
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            throw new BleNotAvailableException("Bluetooth LE not supported by this device");
        }
        if (!context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))
        {
            throw new BleNotAvailableException("Bluetooth LE not supported by this device");
        }
        return ((BluetoothManager)context.getSystemService("bluetooth")).getAdapter().isEnabled();
    }

    protected RangeNotifier getDataRequestNotifier()
    {
        return dataRequestNotifier;
    }

    public Collection getMonitoredRegions()
    {
        Object obj = new ArrayList();
        ArrayList arraylist = monitoredRegions;
        arraylist;
        JVM INSTR monitorenter ;
        for (Iterator iterator = monitoredRegions.iterator(); iterator.hasNext(); ((ArrayList) (obj)).add((Region)((Region)iterator.next()).clone())) { }
        break MISSING_BLOCK_LABEL_60;
        obj;
        arraylist;
        JVM INSTR monitorexit ;
        throw obj;
        arraylist;
        JVM INSTR monitorexit ;
        return ((Collection) (obj));
    }

    public MonitorNotifier getMonitoringNotifier()
    {
        return monitorNotifier;
    }

    public Collection getRangedRegions()
    {
        Object obj = new ArrayList();
        ArrayList arraylist = rangedRegions;
        arraylist;
        JVM INSTR monitorenter ;
        for (Iterator iterator = rangedRegions.iterator(); iterator.hasNext(); ((ArrayList) (obj)).add((Region)((Region)iterator.next()).clone())) { }
        break MISSING_BLOCK_LABEL_60;
        obj;
        arraylist;
        JVM INSTR monitorexit ;
        throw obj;
        arraylist;
        JVM INSTR monitorexit ;
        return ((Collection) (obj));
    }

    public RangeNotifier getRangingNotifier()
    {
        return rangeNotifier;
    }

    public boolean isBound(IBeaconConsumer ibeaconconsumer)
    {
        Map map = consumers;
        map;
        JVM INSTR monitorenter ;
        boolean flag;
        if (consumers.keySet().contains(ibeaconconsumer) && serviceMessenger != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        map;
        JVM INSTR monitorexit ;
        return flag;
        ibeaconconsumer;
        map;
        JVM INSTR monitorexit ;
        throw ibeaconconsumer;
    }

    public void setBackgroundBetweenScanPeriod(long l)
    {
        backgroundBetweenScanPeriod = l;
    }

    public boolean setBackgroundMode(IBeaconConsumer ibeaconconsumer, boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            Log.w("IBeaconManager", "Not supported prior to SDK 18.  Method invocation will be ignored");
            return false;
        }
        Map map = consumers;
        map;
        JVM INSTR monitorenter ;
        boolean flag1;
        Log.i("IBeaconManager", (new StringBuilder()).append("setBackgroundMode for consumer").append(ibeaconconsumer).append(" to ").append(flag).toString());
        flag1 = consumers.keySet().contains(ibeaconconsumer);
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        ((ConsumerInfo)consumers.get(ibeaconconsumer)).isInBackground = flag;
        updateScanPeriods();
        map;
        JVM INSTR monitorexit ;
        return true;
        ibeaconconsumer;
        map;
        JVM INSTR monitorexit ;
        throw ibeaconconsumer;
        ibeaconconsumer;
        Log.e("IBeaconManager", "Failed to set background mode", ibeaconconsumer);
        map;
        JVM INSTR monitorexit ;
        return false;
        if (debug)
        {
            Log.d("IBeaconManager", (new StringBuilder()).append("This consumer is not bound to: ").append(ibeaconconsumer).toString());
        }
        map;
        JVM INSTR monitorexit ;
        return false;
    }

    public void setBackgroundScanPeriod(long l)
    {
        backgroundScanPeriod = l;
    }

    protected void setDataRequestNotifier(RangeNotifier rangenotifier)
    {
        dataRequestNotifier = rangenotifier;
    }

    public void setForegroundBetweenScanPeriod(long l)
    {
        foregroundBetweenScanPeriod = l;
    }

    public void setForegroundScanPeriod(long l)
    {
        foregroundScanPeriod = l;
    }

    public void setMonitorNotifier(MonitorNotifier monitornotifier)
    {
        monitorNotifier = monitornotifier;
    }

    public void setRangeNotifier(RangeNotifier rangenotifier)
    {
        rangeNotifier = rangenotifier;
    }

    public void setScanPeriods()
        throws RemoteException
    {
        updateScanPeriods();
    }

    public void startMonitoringBeaconsInRegion(Region region)
        throws RemoteException
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            Log.w("IBeaconManager", "Not supported prior to API 18.  Method invocation will be ignored");
            return;
        }
        if (serviceMessenger == null)
        {
            throw new RemoteException("The IBeaconManager is not bound to the service.  Call iBeaconManager.bind(IBeaconConsumer consumer) and wait for a callback to onIBeaconServiceConnect()");
        }
        Message message = Message.obtain(null, 4, 0, 0);
        message.obj = new StartRMData(new RegionData(region), callbackPackageName(), getScanPeriod(), getBetweenScanPeriod());
        serviceMessenger.send(message);
        synchronized (monitoredRegions)
        {
            monitoredRegions.add((Region)region.clone());
        }
        return;
        region;
        arraylist;
        JVM INSTR monitorexit ;
        throw region;
    }

    public void startRangingBeaconsInRegion(Region region)
        throws RemoteException
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            Log.w("IBeaconManager", "Not supported prior to SDK 18.  Method invocation will be ignored");
            return;
        }
        if (serviceMessenger == null)
        {
            throw new RemoteException("The IBeaconManager is not bound to the service.  Call iBeaconManager.bind(IBeaconConsumer consumer) and wait for a callback to onIBeaconServiceConnect()");
        }
        Message message = Message.obtain(null, 2, 0, 0);
        message.obj = new StartRMData(new RegionData(region), callbackPackageName(), getScanPeriod(), getBetweenScanPeriod());
        serviceMessenger.send(message);
        synchronized (rangedRegions)
        {
            rangedRegions.add((Region)region.clone());
        }
        return;
        region;
        arraylist;
        JVM INSTR monitorexit ;
        throw region;
    }

    public void stopMonitoringBeaconsInRegion(Region region)
        throws RemoteException
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            Log.w("IBeaconManager", "Not supported prior to API 18.  Method invocation will be ignored");
            return;
        }
        if (serviceMessenger == null)
        {
            throw new RemoteException("The IBeaconManager is not bound to the service.  Call iBeaconManager.bind(IBeaconConsumer consumer) and wait for a callback to onIBeaconServiceConnect()");
        }
        Message message = Message.obtain(null, 5, 0, 0);
        message.obj = new StartRMData(new RegionData(region), callbackPackageName(), getScanPeriod(), getBetweenScanPeriod());
        serviceMessenger.send(message);
        ArrayList arraylist = monitoredRegions;
        arraylist;
        JVM INSTR monitorenter ;
        Iterator iterator = monitoredRegions.iterator();
        Region region1 = null;
_L2:
        Region region2;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        region2 = (Region)iterator.next();
        if (region.getUniqueId().equals(region2.getUniqueId()))
        {
            region1 = region2;
        }
        if (true) goto _L2; else goto _L1
_L1:
        monitoredRegions.remove(region1);
        arraylist;
        JVM INSTR monitorexit ;
        return;
        region;
        arraylist;
        JVM INSTR monitorexit ;
        throw region;
    }

    public void stopRangingBeaconsInRegion(Region region)
        throws RemoteException
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            Log.w("IBeaconManager", "Not supported prior to SDK 18.  Method invocation will be ignored");
            return;
        }
        if (serviceMessenger == null)
        {
            throw new RemoteException("The IBeaconManager is not bound to the service.  Call iBeaconManager.bind(IBeaconConsumer consumer) and wait for a callback to onIBeaconServiceConnect()");
        }
        Message message = Message.obtain(null, 3, 0, 0);
        message.obj = new StartRMData(new RegionData(region), callbackPackageName(), getScanPeriod(), getBetweenScanPeriod());
        serviceMessenger.send(message);
        ArrayList arraylist = rangedRegions;
        arraylist;
        JVM INSTR monitorenter ;
        Iterator iterator = rangedRegions.iterator();
        Region region1 = null;
_L2:
        Region region2;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        region2 = (Region)iterator.next();
        if (region.getUniqueId().equals(region2.getUniqueId()))
        {
            region1 = region2;
        }
        if (true) goto _L2; else goto _L1
_L1:
        rangedRegions.remove(region1);
        arraylist;
        JVM INSTR monitorexit ;
        return;
        region;
        arraylist;
        JVM INSTR monitorexit ;
        throw region;
    }

    public void unBind(IBeaconConsumer ibeaconconsumer)
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            Log.w("IBeaconManager", "Not supported prior to SDK 18.  Method invocation will be ignored");
            return;
        }
        Map map = consumers;
        map;
        JVM INSTR monitorenter ;
        if (!consumers.keySet().contains(ibeaconconsumer)) goto _L2; else goto _L1
_L1:
        Log.d("IBeaconManager", "Unbinding");
        ibeaconconsumer.unbindService(iBeaconServiceConnection);
        consumers.remove(ibeaconconsumer);
_L7:
        return;
        ibeaconconsumer;
        map;
        JVM INSTR monitorexit ;
        throw ibeaconconsumer;
_L2:
        if (debug)
        {
            Log.d("IBeaconManager", (new StringBuilder()).append("This consumer is not bound to: ").append(ibeaconconsumer).toString());
        }
        if (debug)
        {
            Log.d("IBeaconManager", "Bound consumers: ");
        }
        break MISSING_BLOCK_LABEL_188;
_L4:
        int i;
        if (i >= consumers.size())
        {
            continue; /* Loop/switch isn't completed */
        }
        Log.i("IBeaconManager", (new StringBuilder()).append(" ").append(consumers.get(Integer.valueOf(i))).toString());
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        i = 0;
        if (true) goto _L4; else goto _L5
_L5:
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void updateScanPeriods()
        throws RemoteException
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            Log.w("IBeaconManager", "Not supported prior to API 18.  Method invocation will be ignored");
            return;
        }
        if (serviceMessenger == null)
        {
            throw new RemoteException("The IBeaconManager is not bound to the service.  Call iBeaconManager.bind(IBeaconConsumer consumer) and wait for a callback to onIBeaconServiceConnect()");
        } else
        {
            Message message = Message.obtain(null, 6, 0, 0);
            Log.d("IBeaconManager", (new StringBuilder()).append("updating scan period to ").append(getScanPeriod()).append(", ").append(getBetweenScanPeriod()).toString());
            message.obj = new StartRMData(getScanPeriod(), getBetweenScanPeriod());
            serviceMessenger.send(message);
            return;
        }
    }



/*
    static Messenger access$102(IBeaconManager ibeaconmanager, Messenger messenger)
    {
        ibeaconmanager.serviceMessenger = messenger;
        return messenger;
    }

*/

}
