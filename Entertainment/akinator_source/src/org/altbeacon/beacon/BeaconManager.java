// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.logging.Loggers;
import org.altbeacon.beacon.service.BeaconService;
import org.altbeacon.beacon.service.StartRMData;
import org.altbeacon.beacon.simulator.BeaconSimulator;

// Referenced classes of package org.altbeacon.beacon:
//            AltBeaconParser, BeaconConsumer, BleNotAvailableException, Region, 
//            RangeNotifier, MonitorNotifier

public class BeaconManager
{

    public static final long DEFAULT_BACKGROUND_BETWEEN_SCAN_PERIOD = 0x493e0L;
    public static final long DEFAULT_BACKGROUND_SCAN_PERIOD = 10000L;
    public static final long DEFAULT_FOREGROUND_BETWEEN_SCAN_PERIOD = 0L;
    public static final long DEFAULT_FOREGROUND_SCAN_PERIOD = 1100L;
    private static final String TAG = "BeaconManager";
    protected static BeaconSimulator beaconSimulator;
    protected static BeaconManager client = null;
    protected static String distanceModelUpdateUrl = "http://data.altbeacon.org/android-distance.json";
    private static boolean sAndroidLScanningDisabled = false;
    private static boolean sManifestCheckingDisabled = false;
    private long backgroundBetweenScanPeriod;
    private long backgroundScanPeriod;
    private final ArrayList beaconParsers = new ArrayList();
    private ServiceConnection beaconServiceConnection;
    private final ConcurrentMap consumers = new ConcurrentHashMap();
    protected RangeNotifier dataRequestNotifier;
    private long foregroundBetweenScanPeriod;
    private long foregroundScanPeriod;
    private boolean mBackgroundMode;
    private boolean mBackgroundModeUninitialized;
    private Context mContext;
    protected MonitorNotifier monitorNotifier;
    private final ArrayList monitoredRegions = new ArrayList();
    protected RangeNotifier rangeNotifier;
    private final ArrayList rangedRegions = new ArrayList();
    private Messenger serviceMessenger;

    protected BeaconManager(Context context)
    {
        serviceMessenger = null;
        rangeNotifier = null;
        dataRequestNotifier = null;
        monitorNotifier = null;
        mBackgroundMode = false;
        mBackgroundModeUninitialized = true;
        foregroundScanPeriod = 1100L;
        foregroundBetweenScanPeriod = 0L;
        backgroundScanPeriod = 10000L;
        backgroundBetweenScanPeriod = 0x493e0L;
        beaconServiceConnection = new _cls1();
        mContext = context;
        if (!sManifestCheckingDisabled)
        {
            verifyServiceDeclaration();
        }
        beaconParsers.add(new AltBeaconParser());
    }

    private String callbackPackageName()
    {
        String s = mContext.getPackageName();
        LogManager.d("BeaconManager", "callback packageName: %s", new Object[] {
            s
        });
        return s;
    }

    public static BeaconSimulator getBeaconSimulator()
    {
        return beaconSimulator;
    }

    private long getBetweenScanPeriod()
    {
        if (mBackgroundMode)
        {
            return backgroundBetweenScanPeriod;
        } else
        {
            return foregroundBetweenScanPeriod;
        }
    }

    public static String getDistanceModelUpdateUrl()
    {
        return distanceModelUpdateUrl;
    }

    public static BeaconManager getInstanceForApplication(Context context)
    {
        if (client == null)
        {
            LogManager.d("BeaconManager", "BeaconManager instance creation", new Object[0]);
            client = new BeaconManager(context);
        }
        return client;
    }

    private long getScanPeriod()
    {
        if (mBackgroundMode)
        {
            return backgroundScanPeriod;
        } else
        {
            return foregroundScanPeriod;
        }
    }

    public static boolean isAndroidLScanningDisabled()
    {
        return sAndroidLScanningDisabled;
    }

    public static void logDebug(String s, String s1)
    {
        LogManager.d(s, s1, new Object[0]);
    }

    public static void logDebug(String s, String s1, Throwable throwable)
    {
        LogManager.d(throwable, s, s1, new Object[0]);
    }

    public static void setAndroidLScanningDisabled(boolean flag)
    {
        sAndroidLScanningDisabled = flag;
    }

    public static void setBeaconSimulator(BeaconSimulator beaconsimulator)
    {
        beaconSimulator = beaconsimulator;
    }

    public static void setDebug(boolean flag)
    {
        if (flag)
        {
            LogManager.setLogger(Loggers.verboseLogger());
            LogManager.setVerboseLoggingEnabled(true);
            return;
        } else
        {
            LogManager.setLogger(Loggers.empty());
            LogManager.setVerboseLoggingEnabled(false);
            return;
        }
    }

    public static void setDistanceModelUpdateUrl(String s)
    {
        distanceModelUpdateUrl = s;
    }

    public static void setsManifestCheckingDisabled(boolean flag)
    {
        sManifestCheckingDisabled = flag;
    }

    private void verifyServiceDeclaration()
    {
    /* block-local class not found */
    class ServiceNotDeclaredException {}

        if (mContext.getPackageManager().queryIntentServices(new Intent(mContext, org/altbeacon/beacon/service/BeaconService), 0x10000).size() == 0)
        {
            throw new ServiceNotDeclaredException();
        } else
        {
            return;
        }
    }

    public void bind(BeaconConsumer beaconconsumer)
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            LogManager.w("BeaconManager", "Not supported prior to SDK 18.  Method invocation will be ignored", new Object[0]);
            return;
        }
        ConcurrentMap concurrentmap = consumers;
        concurrentmap;
        JVM INSTR monitorenter ;
    /* block-local class not found */
    class ConsumerInfo {}

        if ((ConsumerInfo)consumers.putIfAbsent(beaconconsumer, new ConsumerInfo(null)) == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        LogManager.d("BeaconManager", "This consumer is already bound", new Object[0]);
_L1:
        return;
        beaconconsumer;
        concurrentmap;
        JVM INSTR monitorexit ;
        throw beaconconsumer;
        LogManager.d("BeaconManager", "This consumer is not bound.  binding: %s", new Object[] {
            beaconconsumer
        });
        beaconconsumer.bindService(new Intent(beaconconsumer.getApplicationContext(), org/altbeacon/beacon/service/BeaconService), beaconServiceConnection, 1);
        LogManager.d("BeaconManager", "consumer count is now: %s", new Object[] {
            Integer.valueOf(consumers.size())
        });
          goto _L1
    }

    public boolean checkAvailability()
        throws BleNotAvailableException
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            throw new BleNotAvailableException("Bluetooth LE not supported by this device");
        }
        if (!mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))
        {
            throw new BleNotAvailableException("Bluetooth LE not supported by this device");
        }
        return ((BluetoothManager)mContext.getSystemService("bluetooth")).getAdapter().isEnabled();
    }

    public List getBeaconParsers()
    {
        if (isAnyConsumerBound())
        {
            return Collections.unmodifiableList(beaconParsers);
        } else
        {
            return beaconParsers;
        }
    }

    protected RangeNotifier getDataRequestNotifier()
    {
        return dataRequestNotifier;
    }

    public Collection getMonitoredRegions()
    {
        ArrayList arraylist1;
        synchronized (monitoredRegions)
        {
            arraylist1 = new ArrayList(monitoredRegions);
        }
        return arraylist1;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public MonitorNotifier getMonitoringNotifier()
    {
        return monitorNotifier;
    }

    public Collection getRangedRegions()
    {
        ArrayList arraylist1;
        synchronized (rangedRegions)
        {
            arraylist1 = new ArrayList(rangedRegions);
        }
        return arraylist1;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public RangeNotifier getRangingNotifier()
    {
        return rangeNotifier;
    }

    public boolean isAnyConsumerBound()
    {
        ConcurrentMap concurrentmap = consumers;
        concurrentmap;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (consumers.size() > 0 && serviceMessenger != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        concurrentmap;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        concurrentmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isBackgroundModeUninitialized()
    {
        return mBackgroundModeUninitialized;
    }

    public boolean isBound(BeaconConsumer beaconconsumer)
    {
        ConcurrentMap concurrentmap = consumers;
        concurrentmap;
        JVM INSTR monitorenter ;
        if (beaconconsumer == null) goto _L2; else goto _L1
_L1:
        if (consumers.get(beaconconsumer) == null || serviceMessenger == null) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L5:
        concurrentmap;
        JVM INSTR monitorexit ;
        return flag;
        beaconconsumer;
        concurrentmap;
        JVM INSTR monitorexit ;
        throw beaconconsumer;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void setBackgroundBetweenScanPeriod(long l)
    {
        backgroundBetweenScanPeriod = l;
    }

    public void setBackgroundMode(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            LogManager.w("BeaconManager", "Not supported prior to SDK 18.  Method invocation will be ignored", new Object[0]);
        }
        mBackgroundModeUninitialized = false;
        if (flag == mBackgroundMode)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        mBackgroundMode = flag;
        updateScanPeriods();
        return;
        RemoteException remoteexception;
        remoteexception;
        LogManager.e("BeaconManager", "Cannot contact service to set scan periods", new Object[0]);
        return;
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

    public void startMonitoringBeaconsInRegion(Region region)
        throws RemoteException
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            LogManager.w("BeaconManager", "Not supported prior to API 18.  Method invocation will be ignored", new Object[0]);
            return;
        }
        if (serviceMessenger == null)
        {
            throw new RemoteException("The BeaconManager is not bound to the service.  Call beaconManager.bind(BeaconConsumer consumer) and wait for a callback to onBeaconServiceConnect()");
        }
        Message message = Message.obtain(null, 4, 0, 0);
        message.obj = new StartRMData(region, callbackPackageName(), getScanPeriod(), getBetweenScanPeriod(), mBackgroundMode);
        serviceMessenger.send(message);
        synchronized (monitoredRegions)
        {
            monitoredRegions.add(region);
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
            LogManager.w("BeaconManager", "Not supported prior to SDK 18.  Method invocation will be ignored", new Object[0]);
            return;
        }
        if (serviceMessenger == null)
        {
            throw new RemoteException("The BeaconManager is not bound to the service.  Call beaconManager.bind(BeaconConsumer consumer) and wait for a callback to onBeaconServiceConnect()");
        }
        Message message = Message.obtain(null, 2, 0, 0);
        message.obj = new StartRMData(region, callbackPackageName(), getScanPeriod(), getBetweenScanPeriod(), mBackgroundMode);
        serviceMessenger.send(message);
        synchronized (rangedRegions)
        {
            rangedRegions.add(region);
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
            LogManager.w("BeaconManager", "Not supported prior to API 18.  Method invocation will be ignored", new Object[0]);
            return;
        }
        if (serviceMessenger == null)
        {
            throw new RemoteException("The BeaconManager is not bound to the service.  Call beaconManager.bind(BeaconConsumer consumer) and wait for a callback to onBeaconServiceConnect()");
        }
        Message message = Message.obtain(null, 5, 0, 0);
        message.obj = new StartRMData(region, callbackPackageName(), getScanPeriod(), getBetweenScanPeriod(), mBackgroundMode);
        serviceMessenger.send(message);
        ArrayList arraylist = monitoredRegions;
        arraylist;
        JVM INSTR monitorenter ;
        Region region1 = null;
        Iterator iterator = monitoredRegions.iterator();
_L1:
        Region region2;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_143;
        }
        region2 = (Region)iterator.next();
        if (region.getUniqueId().equals(region2.getUniqueId()))
        {
            region1 = region2;
        }
          goto _L1
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
            LogManager.w("BeaconManager", "Not supported prior to SDK 18.  Method invocation will be ignored", new Object[0]);
            return;
        }
        if (serviceMessenger == null)
        {
            throw new RemoteException("The BeaconManager is not bound to the service.  Call beaconManager.bind(BeaconConsumer consumer) and wait for a callback to onBeaconServiceConnect()");
        }
        Message message = Message.obtain(null, 3, 0, 0);
        message.obj = new StartRMData(region, callbackPackageName(), getScanPeriod(), getBetweenScanPeriod(), mBackgroundMode);
        serviceMessenger.send(message);
        ArrayList arraylist = rangedRegions;
        arraylist;
        JVM INSTR monitorenter ;
        Region region1 = null;
        Iterator iterator = rangedRegions.iterator();
_L1:
        Region region2;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_142;
        }
        region2 = (Region)iterator.next();
        if (region.getUniqueId().equals(region2.getUniqueId()))
        {
            region1 = region2;
        }
          goto _L1
        rangedRegions.remove(region1);
        arraylist;
        JVM INSTR monitorexit ;
        return;
        region;
        arraylist;
        JVM INSTR monitorexit ;
        throw region;
    }

    public void unbind(BeaconConsumer beaconconsumer)
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            LogManager.w("BeaconManager", "Not supported prior to SDK 18.  Method invocation will be ignored", new Object[0]);
            return;
        }
        ConcurrentMap concurrentmap = consumers;
        concurrentmap;
        JVM INSTR monitorenter ;
        if (!consumers.containsKey(beaconconsumer))
        {
            break MISSING_BLOCK_LABEL_98;
        }
        LogManager.d("BeaconManager", "Unbinding", new Object[0]);
        beaconconsumer.unbindService(beaconServiceConnection);
        consumers.remove(beaconconsumer);
        if (consumers.size() == 0)
        {
            serviceMessenger = null;
        }
_L1:
        return;
        beaconconsumer;
        concurrentmap;
        JVM INSTR monitorexit ;
        throw beaconconsumer;
        LogManager.d("BeaconManager", "This consumer is not bound to: %s", new Object[] {
            beaconconsumer
        });
        LogManager.d("BeaconManager", "Bound consumers: ", new Object[0]);
        beaconconsumer = consumers.entrySet().iterator();
        while (beaconconsumer.hasNext()) 
        {
            LogManager.d("BeaconManager", String.valueOf(((java.util.Map.Entry)beaconconsumer.next()).getValue()), new Object[0]);
        }
          goto _L1
    }

    public void updateScanPeriods()
        throws RemoteException
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            LogManager.w("BeaconManager", "Not supported prior to API 18.  Method invocation will be ignored", new Object[0]);
            return;
        }
        if (serviceMessenger == null)
        {
            throw new RemoteException("The BeaconManager is not bound to the service.  Call beaconManager.bind(BeaconConsumer consumer) and wait for a callback to onBeaconServiceConnect()");
        } else
        {
            Message message = Message.obtain(null, 6, 0, 0);
            LogManager.d("BeaconManager", "updating background flag to %s", new Object[] {
                Boolean.valueOf(mBackgroundMode)
            });
            LogManager.d("BeaconManager", "updating scan period to %s, %s", new Object[] {
                Long.valueOf(getScanPeriod()), Long.valueOf(getBetweenScanPeriod())
            });
            message.obj = new StartRMData(getScanPeriod(), getBetweenScanPeriod(), mBackgroundMode);
            serviceMessenger.send(message);
            return;
        }
    }



/*
    static Messenger access$102(BeaconManager beaconmanager, Messenger messenger)
    {
        beaconmanager.serviceMessenger = messenger;
        return messenger;
    }

*/


    /* member class not found */
    class _cls1 {}

}
