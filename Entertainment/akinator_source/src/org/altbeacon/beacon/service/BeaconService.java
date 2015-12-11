// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.distance.DistanceCalculator;
import org.altbeacon.beacon.distance.ModelSpecificDistanceCalculator;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.scanner.CycledLeScanCallback;
import org.altbeacon.beacon.service.scanner.CycledLeScanner;
import org.altbeacon.beacon.simulator.BeaconSimulator;
import org.altbeacon.bluetooth.BluetoothCrashResolver;

// Referenced classes of package org.altbeacon.beacon.service:
//            Stats, MonitorState, MonitoringData, Callback, 
//            RangeState, RangingData, StartRMData, DetectionTracker

public class BeaconService extends Service
{
    public class BeaconBinder extends Binder
    {

        final BeaconService this$0;

        public BeaconService getService()
        {
            LogManager.i("BeaconService", "getService of BeaconBinder called", new Object[0]);
            return BeaconService.this;
        }

        public BeaconBinder()
        {
            this$0 = BeaconService.this;
            super();
        }
    }

    static class IncomingHandler extends Handler
    {

        private final WeakReference mService;

        public void handleMessage(Message message)
        {
            BeaconService beaconservice;
            StartRMData startrmdata;
label0:
            {
label1:
                {
label2:
                    {
label3:
                        {
label4:
                            {
                                beaconservice = (BeaconService)mService.get();
                                startrmdata = (StartRMData)message.obj;
                                if (beaconservice != null)
                                {
                                    switch (message.what)
                                    {
                                    default:
                                        super.handleMessage(message);
                                        break;

                                    case 2: // '\002'
                                        break label4;

                                    case 3: // '\003'
                                        break label3;

                                    case 4: // '\004'
                                        break label2;

                                    case 5: // '\005'
                                        break label1;

                                    case 6: // '\006'
                                        break label0;
                                    }
                                }
                                return;
                            }
                            LogManager.i("BeaconService", "start ranging received", new Object[0]);
                            beaconservice.startRangingBeaconsInRegion(startrmdata.getRegionData(), new Callback(startrmdata.getCallbackPackageName()));
                            beaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod(), startrmdata.getBackgroundFlag());
                            return;
                        }
                        LogManager.i("BeaconService", "stop ranging received", new Object[0]);
                        beaconservice.stopRangingBeaconsInRegion(startrmdata.getRegionData());
                        beaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod(), startrmdata.getBackgroundFlag());
                        return;
                    }
                    LogManager.i("BeaconService", "start monitoring received", new Object[0]);
                    beaconservice.startMonitoringBeaconsInRegion(startrmdata.getRegionData(), new Callback(startrmdata.getCallbackPackageName()));
                    beaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod(), startrmdata.getBackgroundFlag());
                    return;
                }
                LogManager.i("BeaconService", "stop monitoring received", new Object[0]);
                beaconservice.stopMonitoringBeaconsInRegion(startrmdata.getRegionData());
                beaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod(), startrmdata.getBackgroundFlag());
                return;
            }
            LogManager.i("BeaconService", "set scan intervals received", new Object[0]);
            beaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod(), startrmdata.getBackgroundFlag());
        }

        IncomingHandler(BeaconService beaconservice)
        {
            mService = new WeakReference(beaconservice);
        }
    }

    private class ScanData
    {

        BluetoothDevice device;
        int rssi;
        byte scanRecord[];
        final BeaconService this$0;

        public ScanData(BluetoothDevice bluetoothdevice, int i, byte abyte0[])
        {
            this$0 = BeaconService.this;
            super();
            device = bluetoothdevice;
            rssi = i;
            scanRecord = abyte0;
        }
    }

    private class ScanProcessor extends AsyncTask
    {

        DetectionTracker mDetectionTracker;
        final BeaconService this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((ScanData[])aobj);
        }

        protected transient Void doInBackground(ScanData ascandata[])
        {
            ScanData scandata = ascandata[0];
            ascandata = null;
            Iterator iterator = beaconParsers.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Beacon beacon = ((BeaconParser)iterator.next()).fromScanData(scandata.scanRecord, scandata.rssi, scandata.device);
                ascandata = beacon;
                if (beacon == null)
                {
                    continue;
                }
                ascandata = beacon;
                break;
            } while (true);
            if (ascandata != null)
            {
                mDetectionTracker.recordDetection();
                processBeaconFromScan(ascandata);
            }
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
        }

        protected void onPreExecute()
        {
        }

        protected volatile void onProgressUpdate(Object aobj[])
        {
            onProgressUpdate((Void[])aobj);
        }

        protected transient void onProgressUpdate(Void avoid[])
        {
        }

        private ScanProcessor()
        {
            this$0 = BeaconService.this;
            super();
            mDetectionTracker = DetectionTracker.getInstance();
        }

    }


    public static final int MSG_SET_SCAN_PERIODS = 6;
    public static final int MSG_START_MONITORING = 4;
    public static final int MSG_START_RANGING = 2;
    public static final int MSG_STOP_MONITORING = 5;
    public static final int MSG_STOP_RANGING = 3;
    public static final String TAG = "BeaconService";
    private List beaconParsers;
    private int bindCount;
    private BluetoothCrashResolver bluetoothCrashResolver;
    private DistanceCalculator defaultDistanceCalculator;
    private Handler handler;
    private boolean mBackgroundFlag;
    private CycledLeScanCallback mCycledLeScanCallback;
    private CycledLeScanner mCycledScanner;
    final Messenger mMessenger = new Messenger(new IncomingHandler(this));
    private Map monitoredRegionState;
    private Map rangedRegionState;
    private boolean scanningEnabled;
    private List simulatedScanData;
    private HashSet trackedBeacons;
    int trackedBeaconsPacketCount;

    public BeaconService()
    {
        rangedRegionState = new HashMap();
        monitoredRegionState = new HashMap();
        handler = new Handler();
        bindCount = 0;
        scanningEnabled = false;
        defaultDistanceCalculator = null;
        mBackgroundFlag = false;
        simulatedScanData = null;
        mCycledLeScanCallback = new CycledLeScanCallback() {

            final BeaconService this$0;

            public void onCycleEnd()
            {
label0:
                {
                    processExpiredMonitors();
                    processRangeData();
                    if (simulatedScanData != null)
                    {
                        LogManager.w("BeaconService", "Simulated scan data is deprecated and will be removed in a future release. Please use the new BeaconSimulator interface instead.", new Object[0]);
                        ApplicationInfo applicationinfo = getApplicationInfo();
                        int i = applicationinfo.flags & 2;
                        applicationinfo.flags = i;
                        if (i != 0)
                        {
                            Beacon beacon;
                            for (Iterator iterator = simulatedScanData.iterator(); iterator.hasNext(); processBeaconFromScan(beacon))
                            {
                                beacon = (Beacon)iterator.next();
                            }

                        } else
                        {
                            LogManager.w("BeaconService", "Simulated scan data provided, but ignored because we are not running in debug mode.  Please remove simulated scan data for production.", new Object[0]);
                        }
                    }
                    if (BeaconManager.getBeaconSimulator() != null)
                    {
                        if (BeaconManager.getBeaconSimulator().getBeacons() == null)
                        {
                            break label0;
                        }
                        ApplicationInfo applicationinfo1 = getApplicationInfo();
                        int j = applicationinfo1.flags & 2;
                        applicationinfo1.flags = j;
                        if (j != 0)
                        {
                            Beacon beacon1;
                            for (Iterator iterator1 = BeaconManager.getBeaconSimulator().getBeacons().iterator(); iterator1.hasNext(); processBeaconFromScan(beacon1))
                            {
                                beacon1 = (Beacon)iterator1.next();
                            }

                        } else
                        {
                            LogManager.w("BeaconService", "Beacon simulations provided, but ignored because we are not running in debug mode.  Please remove beacon simulations for production.", new Object[0]);
                        }
                    }
                    return;
                }
                LogManager.w("BeaconService", "getBeacons is returning null. No simulated beacons to report.", new Object[0]);
            }

            public void onLeScan(BluetoothDevice bluetoothdevice, int i, byte abyte0[])
            {
                (new ScanProcessor()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ScanData[] {
                    new ScanData(bluetoothdevice, i, abyte0)
                });
            }

            
            {
                this$0 = BeaconService.this;
                super();
            }
        };
    }

    private List matchingRegions(Beacon beacon, Collection collection)
    {
        ArrayList arraylist = new ArrayList();
        for (collection = collection.iterator(); collection.hasNext();)
        {
            Region region = (Region)collection.next();
            if (region.matchesBeacon(beacon))
            {
                arraylist.add(region);
            } else
            {
                LogManager.d("BeaconService", "This region (%s) does not match beacon: %s", new Object[] {
                    region, beacon
                });
            }
        }

        return arraylist;
    }

    private void processBeaconFromScan(Beacon beacon)
    {
        if (trackedBeacons == null)
        {
            trackedBeacons = new HashSet();
        }
        if (Stats.getInstance().isEnabled())
        {
            Stats.getInstance().log(beacon);
        }
        trackedBeaconsPacketCount = trackedBeaconsPacketCount + 1;
        if (trackedBeacons.contains(beacon))
        {
            LogManager.d("BeaconService", "beacon detected multiple times in scan cycle : %s", new Object[] {
                beacon.toString()
            });
        }
        trackedBeacons.add(beacon);
        LogManager.d("BeaconService", "beacon detected : %s", new Object[] {
            beacon.toString()
        });
        List list;
        synchronized (monitoredRegionState)
        {
            list = matchingRegions(beacon, monitoredRegionState.keySet());
        }
        obj = list.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Region region = (Region)((Iterator) (obj)).next();
            MonitorState monitorstate = (MonitorState)monitoredRegionState.get(region);
            if (monitorstate.markInside())
            {
                monitorstate.getCallback().call(this, "monitoringData", new MonitoringData(monitorstate.isInside(), region));
            }
        } while (true);
        break MISSING_BLOCK_LABEL_206;
        beacon;
        obj;
        JVM INSTR monitorexit ;
        throw beacon;
        LogManager.d("BeaconService", "looking for ranging region matches for this beacon", new Object[0]);
        Map map = rangedRegionState;
        map;
        JVM INSTR monitorenter ;
        Region region1;
        for (Iterator iterator = matchingRegions(beacon, rangedRegionState.keySet()).iterator(); iterator.hasNext(); ((RangeState)rangedRegionState.get(region1)).addBeacon(beacon))
        {
            region1 = (Region)iterator.next();
            LogManager.d("BeaconService", "matches ranging region: %s", new Object[] {
                region1
            });
        }

        break MISSING_BLOCK_LABEL_306;
        beacon;
        map;
        JVM INSTR monitorexit ;
        throw beacon;
        map;
        JVM INSTR monitorexit ;
    }

    private void processExpiredMonitors()
    {
        Map map = monitoredRegionState;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator = monitoredRegionState.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Region region = (Region)iterator.next();
            MonitorState monitorstate = (MonitorState)monitoredRegionState.get(region);
            if (monitorstate.isNewlyOutside())
            {
                LogManager.d("BeaconService", "found a monitor that expired: %s", new Object[] {
                    region
                });
                monitorstate.getCallback().call(this, "monitoringData", new MonitoringData(monitorstate.isInside(), region));
            }
        } while (true);
        break MISSING_BLOCK_LABEL_113;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        map;
        JVM INSTR monitorexit ;
    }

    private void processRangeData()
    {
        Map map = rangedRegionState;
        map;
        JVM INSTR monitorenter ;
        Region region;
        RangeState rangestate;
        for (Iterator iterator = rangedRegionState.keySet().iterator(); iterator.hasNext(); rangestate.getCallback().call(this, "rangingData", new RangingData(rangestate.finalizeBeacons(), region)))
        {
            region = (Region)iterator.next();
            rangestate = (RangeState)rangedRegionState.get(region);
            LogManager.d("BeaconService", "Calling ranging callback", new Object[0]);
        }

        break MISSING_BLOCK_LABEL_102;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        map;
        JVM INSTR monitorexit ;
    }

    public IBinder onBind(Intent intent)
    {
        LogManager.i("BeaconService", "binding", new Object[0]);
        bindCount = bindCount + 1;
        return mMessenger.getBinder();
    }

    public void onCreate()
    {
        LogManager.i("BeaconService", "beaconService version %s is starting up", new Object[] {
            "2.1.4"
        });
        bluetoothCrashResolver = new BluetoothCrashResolver(this);
        bluetoothCrashResolver.start();
        mCycledScanner = CycledLeScanner.createScanner(this, 1100L, 0L, mBackgroundFlag, mCycledLeScanCallback, bluetoothCrashResolver);
        beaconParsers = BeaconManager.getInstanceForApplication(getApplicationContext()).getBeaconParsers();
        defaultDistanceCalculator = new ModelSpecificDistanceCalculator(this, BeaconManager.getDistanceModelUpdateUrl());
        Beacon.setDistanceCalculator(defaultDistanceCalculator);
        try
        {
            simulatedScanData = (List)Class.forName("org.altbeacon.beacon.SimulatedScanData").getField("beacons").get(null);
            return;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            LogManager.d("BeaconService", "No org.altbeacon.beacon.SimulatedScanData class exists.", new Object[0]);
            return;
        }
        catch (Exception exception)
        {
            LogManager.e(exception, "BeaconService", "Cannot get simulated Scan data.  Make sure your org.altbeacon.beacon.SimulatedScanData class defines a field with the signature 'public static List<Beacon> beacons'", new Object[0]);
        }
    }

    public void onDestroy()
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            LogManager.w("BeaconService", "Not supported prior to API 18.", new Object[0]);
            return;
        } else
        {
            bluetoothCrashResolver.stop();
            LogManager.i("BeaconService", "onDestroy called.  stopping scanning", new Object[0]);
            handler.removeCallbacksAndMessages(null);
            mCycledScanner.stop();
            return;
        }
    }

    public boolean onUnbind(Intent intent)
    {
        LogManager.i("BeaconService", "unbinding", new Object[0]);
        bindCount = bindCount - 1;
        return false;
    }

    public void setScanPeriods(long l, long l1, boolean flag)
    {
        mCycledScanner.setScanPeriods(l, l1, flag);
    }

    public void startMonitoringBeaconsInRegion(Region region, Callback callback)
    {
        LogManager.d("BeaconService", "startMonitoring called", new Object[0]);
        synchronized (monitoredRegionState)
        {
            if (monitoredRegionState.containsKey(region))
            {
                LogManager.i("BeaconService", "Already monitoring that region -- will replace existing region monitor.", new Object[0]);
                monitoredRegionState.remove(region);
            }
            monitoredRegionState.put(region, new MonitorState(callback));
        }
        LogManager.d("BeaconService", "Currently monitoring %s regions.", new Object[] {
            Integer.valueOf(monitoredRegionState.size())
        });
        if (!scanningEnabled)
        {
            mCycledScanner.start();
        }
        return;
        region;
        map;
        JVM INSTR monitorexit ;
        throw region;
    }

    public void startRangingBeaconsInRegion(Region region, Callback callback)
    {
        synchronized (rangedRegionState)
        {
            if (rangedRegionState.containsKey(region))
            {
                LogManager.i("BeaconService", "Already ranging that region -- will replace existing region.", new Object[0]);
                rangedRegionState.remove(region);
            }
            rangedRegionState.put(region, new RangeState(callback));
            LogManager.d("BeaconService", "Currently ranging %s regions.", new Object[] {
                Integer.valueOf(rangedRegionState.size())
            });
        }
        if (!scanningEnabled)
        {
            mCycledScanner.start();
        }
        return;
        region;
        map;
        JVM INSTR monitorexit ;
        throw region;
    }

    public void stopMonitoringBeaconsInRegion(Region region)
    {
        LogManager.d("BeaconService", "stopMonitoring called", new Object[0]);
        int i;
        synchronized (monitoredRegionState)
        {
            monitoredRegionState.remove(region);
            i = monitoredRegionState.size();
        }
        LogManager.d("BeaconService", "Currently monitoring %s regions.", new Object[] {
            Integer.valueOf(monitoredRegionState.size())
        });
        if (scanningEnabled && i == 0 && monitoredRegionState.size() == 0)
        {
            mCycledScanner.stop();
        }
        return;
        region;
        map;
        JVM INSTR monitorexit ;
        throw region;
    }

    public void stopRangingBeaconsInRegion(Region region)
    {
        int i;
        synchronized (rangedRegionState)
        {
            rangedRegionState.remove(region);
            i = rangedRegionState.size();
            LogManager.d("BeaconService", "Currently ranging %s regions.", new Object[] {
                Integer.valueOf(rangedRegionState.size())
            });
        }
        if (scanningEnabled && i == 0 && monitoredRegionState.size() == 0)
        {
            mCycledScanner.stop();
        }
        return;
        region;
        map;
        JVM INSTR monitorexit ;
        throw region;
    }





}
