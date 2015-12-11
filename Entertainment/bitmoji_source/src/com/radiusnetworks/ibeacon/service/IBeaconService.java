// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.radiusnetworks.bluetooth.BluetoothCrashResolver;
import com.radiusnetworks.ibeacon.IBeacon;
import com.radiusnetworks.ibeacon.IBeaconManager;
import com.radiusnetworks.ibeacon.Region;
import com.radiusnetworks.ibeacon.simulator.BeaconSimulator;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.radiusnetworks.ibeacon.service:
//            MonitorState, MonitoringData, Callback, RangeState, 
//            RangingData, StartRMData

public class IBeaconService extends Service
{
    public class IBeaconBinder extends Binder
    {

        final IBeaconService this$0;

        public IBeaconService getService()
        {
            Log.i("IBeaconService", "getService of IBeaconBinder called");
            return IBeaconService.this;
        }

        public IBeaconBinder()
        {
            this$0 = IBeaconService.this;
            super();
        }
    }

    static class IncomingHandler extends Handler
    {

        private final WeakReference mService;

        public void handleMessage(Message message)
        {
            IBeaconService ibeaconservice;
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
                                ibeaconservice = (IBeaconService)mService.get();
                                startrmdata = (StartRMData)message.obj;
                                if (ibeaconservice != null)
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
                            Log.i("IBeaconService", "start ranging received");
                            ibeaconservice.startRangingBeaconsInRegion(startrmdata.getRegionData(), new Callback(startrmdata.getCallbackPackageName()));
                            ibeaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod());
                            return;
                        }
                        Log.i("IBeaconService", "stop ranging received");
                        ibeaconservice.stopRangingBeaconsInRegion(startrmdata.getRegionData());
                        ibeaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod());
                        return;
                    }
                    Log.i("IBeaconService", "start monitoring received");
                    ibeaconservice.startMonitoringBeaconsInRegion(startrmdata.getRegionData(), new Callback(startrmdata.getCallbackPackageName()));
                    ibeaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod());
                    return;
                }
                Log.i("IBeaconService", "stop monitoring received");
                ibeaconservice.stopMonitoringBeaconsInRegion(startrmdata.getRegionData());
                ibeaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod());
                return;
            }
            Log.i("IBeaconService", "set scan intervals received");
            ibeaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod());
        }

        IncomingHandler(IBeaconService ibeaconservice)
        {
            mService = new WeakReference(ibeaconservice);
        }
    }

    private class ScanData
    {

        public BluetoothDevice device;
        public int rssi;
        public byte scanRecord[];
        final IBeaconService this$0;

        public ScanData(BluetoothDevice bluetoothdevice, int i, byte abyte0[])
        {
            this$0 = IBeaconService.this;
            super();
            device = bluetoothdevice;
            rssi = i;
            scanRecord = abyte0;
        }
    }

    private class ScanProcessor extends AsyncTask
    {

        final IBeaconService this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((ScanData[])aobj);
        }

        protected transient Void doInBackground(ScanData ascandata[])
        {
            ascandata = ascandata[0];
            IBeacon ibeacon = IBeacon.fromScanData(((ScanData) (ascandata)).scanRecord, ((ScanData) (ascandata)).rssi, ((ScanData) (ascandata)).device);
            if (ibeacon != null)
            {
                processIBeaconFromScan(ibeacon);
            }
            bluetoothCrashResolver.notifyScannedDevice(((ScanData) (ascandata)).device, (android.bluetooth.BluetoothAdapter.LeScanCallback)getLeScanCallback());
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
            this$0 = IBeaconService.this;
            super();
        }

    }


    public static final int MSG_SET_SCAN_PERIODS = 6;
    public static final int MSG_START_MONITORING = 4;
    public static final int MSG_START_RANGING = 2;
    public static final int MSG_STOP_MONITORING = 5;
    public static final int MSG_STOP_RANGING = 3;
    public static final String TAG = "IBeaconService";
    private long betweenScanPeriod;
    private int bindCount;
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothCrashResolver bluetoothCrashResolver;
    private Handler handler;
    private Date lastIBeaconDetectionTime;
    private long lastScanEndTime;
    private long lastScanStartTime;
    private Object leScanCallback;
    final Messenger mMessenger = new Messenger(new IncomingHandler(this));
    private Map monitoredRegionState;
    private long nextScanStartTime;
    private int ongoing_notification_id;
    private Map rangedRegionState;
    private boolean scanCyclerStarted;
    private long scanPeriod;
    private long scanStopTime;
    private boolean scanning;
    private boolean scanningEnabled;
    private boolean scanningPaused;
    private List simulatedScanData;
    private HashSet trackedBeacons;
    int trackedBeaconsPacketCount;

    public IBeaconService()
    {
        rangedRegionState = new HashMap();
        monitoredRegionState = new HashMap();
        lastIBeaconDetectionTime = new Date();
        handler = new Handler();
        bindCount = 0;
        scanCyclerStarted = false;
        scanningEnabled = false;
        scanPeriod = 1100L;
        betweenScanPeriod = 0L;
        simulatedScanData = null;
        ongoing_notification_id = 1;
        lastScanStartTime = 0L;
        lastScanEndTime = 0L;
        nextScanStartTime = 0L;
        scanStopTime = 0L;
    }

    private boolean anyRangingOrMonitoringRegionsActive()
    {
        return rangedRegionState.size() + monitoredRegionState.size() > 0;
    }

    private void finishScanCycle()
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            Log.w("IBeaconService", "Not supported prior to API 18.");
        } else
        {
            if (IBeaconManager.debug)
            {
                Log.d("IBeaconService", "Done with scan cycle");
            }
            processExpiredMonitors();
            if (scanning)
            {
                processRangeData();
                if (simulatedScanData != null)
                {
                    Log.w("IBeaconService", "Simulated scan data is deprecated and will be removed in a future release. Please use the new BeaconSimulator interface instead.");
                    ApplicationInfo applicationinfo = getApplicationInfo();
                    int i = applicationinfo.flags & 2;
                    applicationinfo.flags = i;
                    if (i != 0)
                    {
                        for (Iterator iterator = simulatedScanData.iterator(); iterator.hasNext(); processIBeaconFromScan((IBeacon)iterator.next())) { }
                    } else
                    {
                        Log.w("IBeaconService", "Simulated scan data provided, but ignored because we are not running in debug mode.  Please remove simulated scan data for production.");
                    }
                }
                if (IBeaconManager.getBeaconSimulator() != null)
                {
                    if (IBeaconManager.getBeaconSimulator().getBeacons() != null)
                    {
                        ApplicationInfo applicationinfo1 = getApplicationInfo();
                        int j = applicationinfo1.flags & 2;
                        applicationinfo1.flags = j;
                        if (j != 0)
                        {
                            for (Iterator iterator1 = IBeaconManager.getBeaconSimulator().getBeacons().iterator(); iterator1.hasNext(); processIBeaconFromScan((IBeacon)iterator1.next())) { }
                        } else
                        {
                            Log.w("IBeaconService", "Beacon simulations provided, but ignored because we are not running in debug mode.  Please remove beacon simulations for production.");
                        }
                    } else
                    {
                        Log.w("IBeaconService", "getBeacons is returning null. No simulated beacons to report.");
                    }
                }
                if (getBluetoothAdapter() != null)
                {
                    if (getBluetoothAdapter().isEnabled())
                    {
                        getBluetoothAdapter().stopLeScan((android.bluetooth.BluetoothAdapter.LeScanCallback)getLeScanCallback());
                        lastScanEndTime = (new Date()).getTime();
                    } else
                    {
                        Log.w("IBeaconService", "Bluetooth is disabled.  Cannot scan for iBeacons.");
                    }
                }
                if (!anyRangingOrMonitoringRegionsActive())
                {
                    if (IBeaconManager.debug)
                    {
                        Log.d("IBeaconService", "Not starting scan because no monitoring or ranging regions are defined.");
                    }
                    scanCyclerStarted = false;
                    return;
                }
                if (IBeaconManager.debug)
                {
                    Log.d("IBeaconService", (new StringBuilder()).append("Restarting scan.  Unique beacons seen last cycle: ").append(trackedBeacons.size()).append(" Total iBeacon advertisement packets seen: ").append(trackedBeaconsPacketCount).toString());
                }
                scanningPaused = true;
                nextScanStartTime = (new Date()).getTime() + betweenScanPeriod;
                if (scanningEnabled)
                {
                    scanLeDevice(Boolean.valueOf(true));
                    return;
                }
                if (IBeaconManager.debug)
                {
                    Log.d("IBeaconService", "Scanning disabled.  No ranging or monitoring regions are active.");
                }
                scanCyclerStarted = false;
                return;
            }
        }
    }

    private BluetoothAdapter getBluetoothAdapter()
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            Log.w("IBeaconService", "Not supported prior to API 18.");
            return null;
        }
        if (bluetoothAdapter == null)
        {
            bluetoothAdapter = ((BluetoothManager)getApplicationContext().getSystemService("bluetooth")).getAdapter();
        }
        return bluetoothAdapter;
    }

    private Object getLeScanCallback()
    {
        if (leScanCallback == null)
        {
            leScanCallback = new android.bluetooth.BluetoothAdapter.LeScanCallback() {

                final IBeaconService this$0;

                public void onLeScan(BluetoothDevice bluetoothdevice, int i, byte abyte0[])
                {
                    if (IBeaconManager.debug)
                    {
                        Log.d("IBeaconService", "got record");
                    }
                    (new ScanProcessor()).execute(new ScanData[] {
                        new ScanData(bluetoothdevice, i, abyte0)
                    });
                }

            
            {
                this$0 = IBeaconService.this;
                super();
            }
            };
        }
        return leScanCallback;
    }

    private boolean isInBackground()
    {
        if (IBeaconManager.debug)
        {
            Log.d("IBeaconService", (new StringBuilder()).append("bound client count:").append(bindCount).toString());
        }
        return bindCount == 0;
    }

    private List matchingRegions(IBeacon ibeacon, Collection collection)
    {
        ArrayList arraylist = new ArrayList();
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            Region region = (Region)collection.next();
            if (region.matchesIBeacon(ibeacon))
            {
                arraylist.add(region);
            } else
            if (IBeaconManager.debug)
            {
                Log.d("IBeaconService", (new StringBuilder()).append("This region does not match: ").append(region).toString());
            }
        } while (true);
        return arraylist;
    }

    private void processExpiredMonitors()
    {
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
                if (IBeaconManager.debug)
                {
                    Log.d("IBeaconService", (new StringBuilder()).append("found a monitor that expired: ").append(region).toString());
                }
                monitorstate.getCallback().call(this, "monitoringData", new MonitoringData(monitorstate.isInside(), region));
            }
        } while (true);
    }

    private void processIBeaconFromScan(IBeacon ibeacon)
    {
        lastIBeaconDetectionTime = new Date();
        trackedBeaconsPacketCount = trackedBeaconsPacketCount + 1;
        if (trackedBeacons.contains(ibeacon) && IBeaconManager.debug)
        {
            Log.d("IBeaconService", (new StringBuilder()).append("iBeacon detected multiple times in scan cycle :").append(ibeacon.getProximityUuid()).append(" ").append(ibeacon.getMajor()).append(" ").append(ibeacon.getMinor()).toString());
        }
        trackedBeacons.add(ibeacon);
        if (IBeaconManager.debug)
        {
            Log.d("IBeaconService", (new StringBuilder()).append("iBeacon detected :").append(ibeacon.getProximityUuid()).append(" ").append(ibeacon.getMajor()).append(" ").append(ibeacon.getMinor()).toString());
        }
        List list;
        synchronized (monitoredRegionState)
        {
            list = matchingRegions(ibeacon, monitoredRegionState.keySet());
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
        break MISSING_BLOCK_LABEL_270;
        ibeacon;
        obj;
        JVM INSTR monitorexit ;
        throw ibeacon;
        if (IBeaconManager.debug)
        {
            Log.d("IBeaconService", "looking for ranging region matches for this ibeacon");
        }
        List list1;
        synchronized (rangedRegionState)
        {
            list1 = matchingRegions(ibeacon, rangedRegionState.keySet());
        }
        for (obj1 = list1.iterator(); ((Iterator) (obj1)).hasNext();)
        {
            Region region1 = (Region)((Iterator) (obj1)).next();
            if (IBeaconManager.debug)
            {
                Log.d("IBeaconService", (new StringBuilder()).append("matches ranging region: ").append(region1).toString());
            }
            synchronized ((RangeState)rangedRegionState.get(region1))
            {
                rangestate.addIBeacon(ibeacon);
            }
        }

        break MISSING_BLOCK_LABEL_403;
        ibeacon;
        rangestate;
        JVM INSTR monitorexit ;
        throw ibeacon;
        ibeacon;
        obj1;
        JVM INSTR monitorexit ;
        throw ibeacon;
    }

    private void processRangeData()
    {
        Region region;
        RangeState rangestate;
        for (Iterator iterator = rangedRegionState.keySet().iterator(); iterator.hasNext(); rangestate.getCallback().call(this, "rangingData", new RangingData(rangestate.finalizeIBeacons(), region)))
        {
            region = (Region)iterator.next();
            rangestate = (RangeState)rangedRegionState.get(region);
            if (IBeaconManager.debug)
            {
                Log.d("IBeaconService", "Calling ranging callback");
            }
        }

    }

    private void scanLeDevice(Boolean boolean1)
    {
        long l;
        l = 1000L;
        scanCyclerStarted = true;
        if (android.os.Build.VERSION.SDK_INT >= 18) goto _L2; else goto _L1
_L1:
        Log.w("IBeaconService", "Not supported prior to API 18.");
_L14:
        return;
_L2:
        if (getBluetoothAdapter() == null)
        {
            Log.e("IBeaconService", "No bluetooth adapter.  iBeaconService cannot scan.");
            if (simulatedScanData == null && IBeaconManager.getBeaconSimulator() == null)
            {
                Log.w("IBeaconService", "exiting");
                return;
            }
            Log.w("IBeaconService", "proceeding with simulated scan data");
        }
        if (!boolean1.booleanValue())
        {
            break MISSING_BLOCK_LABEL_398;
        }
        long l1 = nextScanStartTime - (new Date()).getTime();
        if (l1 > 0L)
        {
            if (IBeaconManager.debug)
            {
                Log.d("IBeaconService", (new StringBuilder()).append("Waiting to start next bluetooth scan for another ").append(l1).append(" milliseconds").toString());
            }
            boolean1 = handler;
            Runnable runnable = new Runnable() {

                final IBeaconService this$0;

                public void run()
                {
                    scanLeDevice(Boolean.valueOf(true));
                }

            
            {
                this$0 = IBeaconService.this;
                super();
            }
            };
            if (l1 <= 1000L)
            {
                l = l1;
            }
            boolean1.postDelayed(runnable, l);
            return;
        }
        trackedBeacons = new HashSet();
        trackedBeaconsPacketCount = 0;
        if (scanning && !scanningPaused)
        {
            break MISSING_BLOCK_LABEL_380;
        }
        scanning = true;
        scanningPaused = false;
        if (getBluetoothAdapter() == null) goto _L4; else goto _L3
_L3:
        if (!getBluetoothAdapter().isEnabled()) goto _L6; else goto _L5
_L5:
        if (!bluetoothCrashResolver.isRecoveryInProgress()) goto _L8; else goto _L7
_L7:
        Log.w("IBeaconService", "Skipping scan because crash recovery is in progress.");
_L11:
        lastScanStartTime = (new Date()).getTime();
_L4:
        scanStopTime = (new Date()).getTime() + scanPeriod;
        scheduleScanStop();
        if (IBeaconManager.debug)
        {
            Log.d("IBeaconService", "Scan started");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (!scanningEnabled) goto _L10; else goto _L9
_L9:
        getBluetoothAdapter().startLeScan((android.bluetooth.BluetoothAdapter.LeScanCallback)getLeScanCallback());
          goto _L11
_L10:
        if (!IBeaconManager.debug) goto _L11; else goto _L12
_L12:
        Log.d("IBeaconService", "Scanning unnecessary - no monitoring or ranging active.");
          goto _L11
_L6:
        try
        {
            Log.w("IBeaconService", "Bluetooth is disabled.  Cannot scan for iBeacons.");
        }
        // Misplaced declaration of an exception variable
        catch (Boolean boolean1)
        {
            Log.e("TAG", "Exception starting bluetooth scan.  Perhaps bluetooth is disabled or unavailable?");
        }
          goto _L4
        if (IBeaconManager.debug)
        {
            Log.d("IBeaconService", "We are already scanning");
        }
          goto _L4
        if (IBeaconManager.debug)
        {
            Log.d("IBeaconService", "disabling scan");
        }
        scanning = false;
        if (getBluetoothAdapter() != null)
        {
            getBluetoothAdapter().stopLeScan((android.bluetooth.BluetoothAdapter.LeScanCallback)getLeScanCallback());
            lastScanEndTime = (new Date()).getTime();
            return;
        }
        if (true) goto _L14; else goto _L13
_L13:
    }

    private void scheduleScanStop()
    {
        long l = 1000L;
        long l1 = scanStopTime - (new Date()).getTime();
        if (l1 > 0L)
        {
            if (IBeaconManager.debug)
            {
                Log.d("IBeaconService", (new StringBuilder()).append("Waiting to stop scan for another ").append(l1).append(" milliseconds").toString());
            }
            Handler handler1 = handler;
            Runnable runnable = new Runnable() {

                final IBeaconService this$0;

                public void run()
                {
                    scheduleScanStop();
                }

            
            {
                this$0 = IBeaconService.this;
                super();
            }
            };
            if (l1 <= 1000L)
            {
                l = l1;
            }
            handler1.postDelayed(runnable, l);
            return;
        } else
        {
            finishScanCycle();
            return;
        }
    }

    public void disableScanning()
    {
        scanningEnabled = false;
    }

    public void enableScanning()
    {
        scanningEnabled = true;
        if (!scanCyclerStarted)
        {
            scanLeDevice(Boolean.valueOf(true));
        }
    }

    public IBinder onBind(Intent intent)
    {
        Log.i("IBeaconService", "binding");
        bindCount = bindCount + 1;
        return mMessenger.getBinder();
    }

    public void onCreate()
    {
        getBluetoothAdapter();
        bluetoothCrashResolver = new BluetoothCrashResolver(this);
        bluetoothCrashResolver.start();
        simulatedScanData = (List)Class.forName("com.radiusnetworks.ibeacon.SimulatedScanData").getField("iBeacons").get(null);
_L1:
        return;
        Object obj;
        obj;
        if (IBeaconManager.debug)
        {
            Log.d("IBeaconService", "No com.radiusnetworks.ibeacon.SimulatedScanData class exists.");
            return;
        }
          goto _L1
        obj;
        Log.e("IBeaconService", "Cannot get simulated Scan data.  Make sure your com.radiusnetworks.ibeacon.SimulatedScanData class defines a field with the signature 'public static List<IBeacon> iBeacons'", ((Throwable) (obj)));
        return;
    }

    public void onDestroy()
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            Log.w("IBeaconService", "Not supported prior to API 18.");
        } else
        {
            bluetoothCrashResolver.stop();
            Log.i("IBeaconService", "onDestroy called.  stopping scanning");
            handler.removeCallbacksAndMessages(null);
            scanLeDevice(Boolean.valueOf(false));
            if (bluetoothAdapter != null)
            {
                bluetoothAdapter.stopLeScan((android.bluetooth.BluetoothAdapter.LeScanCallback)getLeScanCallback());
                lastScanEndTime = (new Date()).getTime();
                return;
            }
        }
    }

    public boolean onUnbind(Intent intent)
    {
        Log.i("IBeaconService", "unbinding");
        bindCount = bindCount - 1;
        return false;
    }

    public void setScanPeriods(long l, long l1)
    {
        scanPeriod = l;
        betweenScanPeriod = l1;
        long l2 = (new Date()).getTime();
        if (nextScanStartTime > l2)
        {
            l1 = lastScanEndTime + l1;
            if (l1 < nextScanStartTime)
            {
                nextScanStartTime = l1;
                Log.i("IBeaconService", (new StringBuilder()).append("Adjusted nextScanStartTime to be ").append(new Date(nextScanStartTime)).toString());
            }
        }
        if (scanStopTime > l2)
        {
            l = lastScanStartTime + l;
            if (l < scanStopTime)
            {
                scanStopTime = l;
                Log.i("IBeaconService", (new StringBuilder()).append("Adjusted scanStopTime to be ").append(new Date(scanStopTime)).toString());
            }
        }
    }

    public void startMonitoringBeaconsInRegion(Region region, Callback callback)
    {
        if (IBeaconManager.debug)
        {
            Log.d("IBeaconService", "startMonitoring called");
        }
        synchronized (monitoredRegionState)
        {
            if (monitoredRegionState.containsKey(region))
            {
                Log.i("IBeaconService", "Already monitoring that region -- will replace existing region monitor.");
                monitoredRegionState.remove(region);
            }
            monitoredRegionState.put(region, new MonitorState(callback));
        }
        if (IBeaconManager.debug)
        {
            Log.d("IBeaconService", (new StringBuilder()).append("Currently monitoring ").append(monitoredRegionState.size()).append(" regions.").toString());
        }
        if (!scanningEnabled)
        {
            enableScanning();
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
                Log.i("IBeaconService", "Already ranging that region -- will replace existing region.");
                rangedRegionState.remove(region);
            }
            rangedRegionState.put(region, new RangeState(callback));
        }
        if (IBeaconManager.debug)
        {
            Log.d("IBeaconService", (new StringBuilder()).append("Currently ranging ").append(rangedRegionState.size()).append(" regions.").toString());
        }
        if (!scanningEnabled)
        {
            enableScanning();
        }
        return;
        region;
        map;
        JVM INSTR monitorexit ;
        throw region;
    }

    public void stopMonitoringBeaconsInRegion(Region region)
    {
        if (IBeaconManager.debug)
        {
            Log.d("IBeaconService", "stopMonitoring called");
        }
        synchronized (monitoredRegionState)
        {
            monitoredRegionState.remove(region);
        }
        if (IBeaconManager.debug)
        {
            Log.d("IBeaconService", (new StringBuilder()).append("Currently monitoring ").append(monitoredRegionState.size()).append(" regions.").toString());
        }
        if (scanningEnabled && rangedRegionState.size() == 0 && monitoredRegionState.size() == 0)
        {
            disableScanning();
        }
        return;
        region;
        map;
        JVM INSTR monitorexit ;
        throw region;
    }

    public void stopRangingBeaconsInRegion(Region region)
    {
        synchronized (rangedRegionState)
        {
            rangedRegionState.remove(region);
        }
        if (IBeaconManager.debug)
        {
            Log.d("IBeaconService", (new StringBuilder()).append("Currently ranging ").append(rangedRegionState.size()).append(" regions.").toString());
        }
        if (scanningEnabled && rangedRegionState.size() == 0 && monitoredRegionState.size() == 0)
        {
            disableScanning();
        }
        return;
        region;
        map;
        JVM INSTR monitorexit ;
        throw region;
    }





}
