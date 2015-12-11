// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BluetoothCrashResolver
{
    private class DiscoveryCanceller extends AsyncTask
    {

        final BluetoothCrashResolver this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
label0:
            {
                Thread.sleep(5000L);
                if (!discoveryStartConfirmed)
                {
                    Log.w("BluetoothCrashResolver", "BluetoothAdapter.ACTION_DISCOVERY_STARTED never received.  Recovery may fail.");
                }
                avoid = BluetoothAdapter.getDefaultAdapter();
                if (avoid.isDiscovering())
                {
                    if (isDebugEnabled())
                    {
                        Log.d("BluetoothCrashResolver", "Cancelling discovery");
                    }
                    avoid.cancelDiscovery();
                    break label0;
                }
                try
                {
                    if (isDebugEnabled())
                    {
                        Log.d("BluetoothCrashResolver", "Discovery not running.  Won't cancel it");
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    if (isDebugEnabled())
                    {
                        Log.d("BluetoothCrashResolver", "DiscoveryCanceller sleep interrupted.");
                    }
                }
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

        private DiscoveryCanceller()
        {
            this$0 = BluetoothCrashResolver.this;
            super();
        }

    }

    public static interface UpdateNotifier
    {

        public abstract void dataUpdated();
    }


    private static final int BLUEDROID_MAX_BLUETOOTH_MAC_COUNT = 1990;
    private static final int BLUEDROID_POST_DISCOVERY_ESTIMATED_BLUETOOTH_MAC_COUNT = 400;
    private static final String DISTINCT_BLUETOOTH_ADDRESSES_FILE = "BluetoothCrashResolverState.txt";
    private static final long MIN_TIME_BETWEEN_STATE_SAVES_MILLIS = 60000L;
    private static final boolean PREEMPTIVE_ACTION_ENABLED = true;
    private static final long SUSPICIOUSLY_SHORT_BLUETOOTH_OFF_INTERVAL_MILLIS = 600L;
    private static final String TAG = "BluetoothCrashResolver";
    private static final int TIME_TO_LET_DISCOVERY_RUN_MILLIS = 5000;
    private Context context;
    private boolean debugEnabled;
    private int detectedCrashCount;
    private DiscoveryCanceller discoveryCanceller;
    private boolean discoveryStartConfirmed;
    private Set distinctBluetoothAddresses;
    private long lastBluetoothCrashDetectionTime;
    private long lastBluetoothOffTime;
    private long lastBluetoothTurningOnTime;
    private boolean lastRecoverySucceeded;
    private long lastStateSaveTime;
    private final BroadcastReceiver receiver = new BroadcastReceiver() {

        final BluetoothCrashResolver this$0;

        public void onReceive(Context context2, Intent intent)
        {
            context2 = intent.getAction();
            if (!context2.equals("android.bluetooth.adapter.action.DISCOVERY_FINISHED")) goto _L2; else goto _L1
_L1:
            if (!recoveryInProgress) goto _L4; else goto _L3
_L3:
            if (isDebugEnabled())
            {
                Log.d("BluetoothCrashResolver", "Bluetooth discovery finished");
            }
            finishRecovery();
_L2:
            if (context2.equals("android.bluetooth.adapter.action.DISCOVERY_STARTED"))
            {
                if (recoveryInProgress)
                {
                    discoveryStartConfirmed = true;
                    if (isDebugEnabled())
                    {
                        Log.d("BluetoothCrashResolver", "Bluetooth discovery started");
                    }
                } else
                if (isDebugEnabled())
                {
                    Log.d("BluetoothCrashResolver", "Bluetooth discovery started (external)");
                }
            }
            if (!context2.equals("android.bluetooth.adapter.action.STATE_CHANGED")) goto _L6; else goto _L5
_L5:
            intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0x80000000);
            JVM INSTR lookupswitch 5: default 164
        //                       -2147483648: 207
        //                       10: 226
        //                       11: 365
        //                       12: 263
        //                       13: 164;
               goto _L6 _L7 _L8 _L9 _L10 _L6
_L6:
            return;
_L4:
            if (isDebugEnabled())
            {
                Log.d("BluetoothCrashResolver", "Bluetooth discovery finished (external)");
            }
            continue; /* Loop/switch isn't completed */
_L7:
            if (isDebugEnabled())
            {
                Log.d("BluetoothCrashResolver", "Bluetooth state is ERROR");
                return;
            }
            if (true)
            {
                continue; /* Loop/switch isn't completed */
            }
_L8:
            if (isDebugEnabled())
            {
                Log.d("BluetoothCrashResolver", "Bluetooth state is OFF");
            }
            lastBluetoothOffTime = (new Date()).getTime();
            return;
_L10:
            if (isDebugEnabled())
            {
                Log.d("BluetoothCrashResolver", "Bluetooth state is ON");
            }
            if (isDebugEnabled())
            {
                Log.d("BluetoothCrashResolver", (new StringBuilder()).append("Bluetooth was turned off for ").append(lastBluetoothTurningOnTime - lastBluetoothOffTime).append(" milliseconds").toString());
            }
            if (lastBluetoothTurningOnTime - lastBluetoothOffTime < 600L)
            {
                crashDetected();
                return;
            }
            if (true) goto _L6; else goto _L9
_L9:
            lastBluetoothTurningOnTime = (new Date()).getTime();
            if (!isDebugEnabled()) goto _L6; else goto _L11
_L11:
            Log.d("BluetoothCrashResolver", "Bluetooth state is TURNING_ON");
            return;
            if (true) goto _L2; else goto _L12
_L12:
        }

            
            {
                this$0 = BluetoothCrashResolver.this;
                super();
            }
    };
    private int recoveryAttemptCount;
    private boolean recoveryInProgress;
    private UpdateNotifier updateNotifier;

    public BluetoothCrashResolver(Context context1)
    {
        debugEnabled = false;
        recoveryInProgress = false;
        discoveryStartConfirmed = false;
        lastBluetoothOffTime = 0L;
        lastBluetoothTurningOnTime = 0L;
        lastBluetoothCrashDetectionTime = 0L;
        detectedCrashCount = 0;
        recoveryAttemptCount = 0;
        lastRecoverySucceeded = false;
        lastStateSaveTime = 0L;
        context = null;
        distinctBluetoothAddresses = new HashSet();
        discoveryCanceller = new DiscoveryCanceller();
        context = context1.getApplicationContext();
        if (isDebugEnabled())
        {
            Log.d("BluetoothCrashResolver", "constructed");
        }
        loadState();
    }

    private void finishRecovery()
    {
        Log.w("BluetoothCrashResolver", "Recovery attempt finished");
        synchronized (distinctBluetoothAddresses)
        {
            distinctBluetoothAddresses.clear();
        }
        recoveryInProgress = false;
        return;
        exception;
        set;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private int getCrashRiskDeviceCount()
    {
        return 1590;
    }

    private boolean isDebugEnabled()
    {
        return debugEnabled;
    }

    private void loadState()
    {
        Object obj = null;
        Object obj2 = new BufferedReader(new InputStreamReader(context.openFileInput("BluetoothCrashResolverState.txt")));
        obj = obj2;
        String s = ((BufferedReader) (obj2)).readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        obj = obj2;
        lastBluetoothCrashDetectionTime = Long.parseLong(s);
        obj = obj2;
        s = ((BufferedReader) (obj2)).readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        obj = obj2;
        detectedCrashCount = Integer.parseInt(s);
        obj = obj2;
        s = ((BufferedReader) (obj2)).readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        obj = obj2;
        recoveryAttemptCount = Integer.parseInt(s);
        obj = obj2;
        s = ((BufferedReader) (obj2)).readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        obj = obj2;
        lastRecoverySucceeded = false;
        obj = obj2;
        if (!s.equals("1"))
        {
            break MISSING_BLOCK_LABEL_125;
        }
        obj = obj2;
        lastRecoverySucceeded = true;
_L2:
        obj = obj2;
        s = ((BufferedReader) (obj2)).readLine();
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj2;
        distinctBluetoothAddresses.add(s);
        if (true) goto _L2; else goto _L1
        obj;
_L8:
        obj = obj2;
        Log.w("BluetoothCrashResolver", "Can't read macs from BluetoothCrashResolverState.txt");
        Exception exception;
        if (obj2 != null)
        {
            try
            {
                ((BufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (isDebugEnabled())
        {
            Log.d("BluetoothCrashResolver", (new StringBuilder()).append("Read ").append(distinctBluetoothAddresses.size()).append(" bluetooth addresses").toString());
        }
        return;
_L1:
        if (obj2 != null)
        {
            try
            {
                ((BufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        break MISSING_BLOCK_LABEL_171;
        obj;
        obj2 = null;
_L6:
        obj = obj2;
        Log.w("BluetoothCrashResolver", "Can't parse file BluetoothCrashResolverState.txt");
        if (obj2 != null)
        {
            try
            {
                ((BufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        break MISSING_BLOCK_LABEL_171;
        exception;
        obj2 = obj;
        obj = exception;
_L4:
        if (obj2 != null)
        {
            try
            {
                ((BufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj2) { }
        }
        throw obj;
        exception;
        obj2 = obj;
        obj = exception;
        if (true) goto _L4; else goto _L3
_L3:
        Object obj1;
        obj1;
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        obj2 = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void processStateChange()
    {
        if (updateNotifier != null)
        {
            updateNotifier.dataUpdated();
        }
        if ((new Date()).getTime() - lastStateSaveTime > 60000L)
        {
            saveState();
        }
    }

    private void saveState()
    {
        Object obj;
        obj = null;
        lastStateSaveTime = (new Date()).getTime();
        Object obj1 = new OutputStreamWriter(context.openFileOutput("BluetoothCrashResolverState.txt", 0));
        ((OutputStreamWriter) (obj1)).write((new StringBuilder()).append(lastBluetoothCrashDetectionTime).append("\n").toString());
        ((OutputStreamWriter) (obj1)).write((new StringBuilder()).append(detectedCrashCount).append("\n").toString());
        ((OutputStreamWriter) (obj1)).write((new StringBuilder()).append(recoveryAttemptCount).append("\n").toString());
        Exception exception;
        if (lastRecoverySucceeded)
        {
            obj = "1\n";
        } else
        {
            obj = "0\n";
        }
        ((OutputStreamWriter) (obj1)).write(((String) (obj)));
        obj = distinctBluetoothAddresses;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = distinctBluetoothAddresses.iterator(); iterator.hasNext(); ((OutputStreamWriter) (obj1)).write("\n"))
        {
            ((OutputStreamWriter) (obj1)).write((String)iterator.next());
        }

          goto _L1
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = obj1;
        }
        finally { }
_L5:
        Log.w("BluetoothCrashResolver", "Can't write macs to BluetoothCrashResolverState.txt");
        if (obj != null)
        {
            try
            {
                ((OutputStreamWriter) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (isDebugEnabled())
        {
            Log.d("BluetoothCrashResolver", (new StringBuilder()).append("Wrote ").append(distinctBluetoothAddresses.size()).append(" bluetooth addresses").toString());
        }
        return;
_L1:
        obj;
        JVM INSTR monitorexit ;
        if (obj1 != null)
        {
            try
            {
                ((OutputStreamWriter) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_201;
        }
        obj;
        obj1 = null;
_L3:
        if (obj1 != null)
        {
            try
            {
                ((OutputStreamWriter) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        throw obj;
        exception;
        obj1 = obj;
        obj = exception;
        if (true) goto _L3; else goto _L2
_L2:
        IOException ioexception;
        ioexception;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void startRecovery()
    {
        recoveryAttemptCount = recoveryAttemptCount + 1;
        BluetoothAdapter bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        if (isDebugEnabled())
        {
            Log.d("BluetoothCrashResolver", "about to check if discovery is active");
        }
        if (!bluetoothadapter.isDiscovering())
        {
            Log.w("BluetoothCrashResolver", "Recovery attempt started");
            recoveryInProgress = true;
            discoveryStartConfirmed = false;
            if (isDebugEnabled())
            {
                Log.d("BluetoothCrashResolver", "about to command discovery");
            }
            if (!bluetoothadapter.startDiscovery())
            {
                Log.w("BluetoothCrashResolver", "Can't start discovery.  Is bluetooth turned on?");
            }
            if (isDebugEnabled())
            {
                Log.d("BluetoothCrashResolver", (new StringBuilder()).append("startDiscovery commanded.  isDiscovering()=").append(bluetoothadapter.isDiscovering()).toString());
            }
            if (isDebugEnabled())
            {
                Log.d("BluetoothCrashResolver", "We will be cancelling this discovery in 5000 milliseconds.");
            }
            discoveryCanceller.doInBackground(new Void[0]);
            return;
        } else
        {
            Log.w("BluetoothCrashResolver", "Already discovering.  Recovery attempt abandoned.");
            return;
        }
    }

    public void crashDetected()
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            if (isDebugEnabled())
            {
                Log.d("BluetoothCrashResolver", "Ignoring crashes before SDK 18, because BLE is unsupported.");
            }
            return;
        }
        Log.w("BluetoothCrashResolver", "BluetoothService crash detected");
        if (distinctBluetoothAddresses.size() > 0 && isDebugEnabled())
        {
            Log.d("BluetoothCrashResolver", (new StringBuilder()).append("Distinct bluetooth devices seen at crash: ").append(distinctBluetoothAddresses.size()).toString());
        }
        lastBluetoothCrashDetectionTime = (new Date()).getTime();
        detectedCrashCount = detectedCrashCount + 1;
        if (recoveryInProgress)
        {
            if (isDebugEnabled())
            {
                Log.d("BluetoothCrashResolver", "Ignoring bluetooth crash because recovery is already in progress.");
            }
        } else
        {
            startRecovery();
        }
        processStateChange();
    }

    public void disableDebug()
    {
        debugEnabled = false;
    }

    public void enableDebug()
    {
        debugEnabled = true;
    }

    public void forceFlush()
    {
        startRecovery();
        processStateChange();
    }

    public int getDetectedCrashCount()
    {
        return detectedCrashCount;
    }

    public long getLastBluetoothCrashDetectionTime()
    {
        return lastBluetoothCrashDetectionTime;
    }

    public int getRecoveryAttemptCount()
    {
        return recoveryAttemptCount;
    }

    public boolean isLastRecoverySucceeded()
    {
        return lastRecoverySucceeded;
    }

    public boolean isRecoveryInProgress()
    {
        return recoveryInProgress;
    }

    public void notifyScannedDevice(BluetoothDevice bluetoothdevice, android.bluetooth.BluetoothAdapter.LeScanCallback lescancallback)
    {
        int i = 0;
        if (isDebugEnabled())
        {
            i = distinctBluetoothAddresses.size();
        }
        synchronized (distinctBluetoothAddresses)
        {
            distinctBluetoothAddresses.add(bluetoothdevice.getAddress());
        }
        if (isDebugEnabled())
        {
            int j = distinctBluetoothAddresses.size();
            if (i != j && j % 100 == 0 && isDebugEnabled())
            {
                Log.d("BluetoothCrashResolver", (new StringBuilder()).append("Distinct bluetooth devices seen: ").append(distinctBluetoothAddresses.size()).toString());
            }
        }
        if (distinctBluetoothAddresses.size() > getCrashRiskDeviceCount() && !recoveryInProgress)
        {
            Log.w("BluetoothCrashResolver", (new StringBuilder()).append("Large number of bluetooth devices detected: ").append(distinctBluetoothAddresses.size()).append(" Proactively attempting to clear out address list to prevent a crash").toString());
            Log.w("BluetoothCrashResolver", "Stopping LE Scan");
            BluetoothAdapter.getDefaultAdapter().stopLeScan(lescancallback);
            startRecovery();
            processStateChange();
        }
        return;
        bluetoothdevice;
        set;
        JVM INSTR monitorexit ;
        throw bluetoothdevice;
    }

    public void setUpdateNotifier(UpdateNotifier updatenotifier)
    {
        updateNotifier = updatenotifier;
    }

    public void start()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentfilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        intentfilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        context.registerReceiver(receiver, intentfilter);
        if (isDebugEnabled())
        {
            Log.d("BluetoothCrashResolver", "started listening for BluetoothAdapter events");
        }
    }

    public void stop()
    {
        context.unregisterReceiver(receiver);
        if (isDebugEnabled())
        {
            Log.d("BluetoothCrashResolver", "stopped listening for BluetoothAdapter events");
        }
        saveState();
    }






/*
    static boolean access$402(BluetoothCrashResolver bluetoothcrashresolver, boolean flag)
    {
        bluetoothcrashresolver.discoveryStartConfirmed = flag;
        return flag;
    }

*/



/*
    static long access$502(BluetoothCrashResolver bluetoothcrashresolver, long l)
    {
        bluetoothcrashresolver.lastBluetoothOffTime = l;
        return l;
    }

*/



/*
    static long access$602(BluetoothCrashResolver bluetoothcrashresolver, long l)
    {
        bluetoothcrashresolver.lastBluetoothTurningOnTime = l;
        return l;
    }

*/
}
