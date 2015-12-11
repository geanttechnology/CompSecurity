// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.altbeacon.beacon.logging.LogManager;

public class BluetoothCrashResolver
{

    private static final int BLUEDROID_MAX_BLUETOOTH_MAC_COUNT = 1990;
    private static final int BLUEDROID_POST_DISCOVERY_ESTIMATED_BLUETOOTH_MAC_COUNT = 400;
    private static final String DISTINCT_BLUETOOTH_ADDRESSES_FILE = "BluetoothCrashResolverState.txt";
    private static final long MIN_TIME_BETWEEN_STATE_SAVES_MILLIS = 60000L;
    private static final boolean PREEMPTIVE_ACTION_ENABLED = true;
    private static final long SUSPICIOUSLY_SHORT_BLUETOOTH_OFF_INTERVAL_MILLIS = 600L;
    private static final String TAG = "BluetoothCrashResolver";
    private static final int TIME_TO_LET_DISCOVERY_RUN_MILLIS = 5000;
    private Context context;
    private int detectedCrashCount;
    private boolean discoveryStartConfirmed;
    private final Set distinctBluetoothAddresses = new HashSet();
    private long lastBluetoothCrashDetectionTime;
    private long lastBluetoothOffTime;
    private long lastBluetoothTurningOnTime;
    private boolean lastRecoverySucceeded;
    private long lastStateSaveTime;
    private final BroadcastReceiver receiver = new _cls1();
    private int recoveryAttemptCount;
    private boolean recoveryInProgress;
    private UpdateNotifier updateNotifier;

    public BluetoothCrashResolver(Context context1)
    {
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
        context = context1.getApplicationContext();
        LogManager.d("BluetoothCrashResolver", "constructed", new Object[0]);
        loadState();
    }

    private void cancelDiscovery()
    {
        Thread.sleep(5000L);
        if (!discoveryStartConfirmed)
        {
            LogManager.w("BluetoothCrashResolver", "BluetoothAdapter.ACTION_DISCOVERY_STARTED never received.  Recovery may fail.", new Object[0]);
        }
        BluetoothAdapter bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothadapter.isDiscovering())
        {
            LogManager.d("BluetoothCrashResolver", "Cancelling discovery", new Object[0]);
            bluetoothadapter.cancelDiscovery();
            return;
        }
        try
        {
            LogManager.d("BluetoothCrashResolver", "Discovery not running.  Won't cancel it", new Object[0]);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            LogManager.d("BluetoothCrashResolver", "DiscoveryCanceller sleep interrupted.", new Object[0]);
        }
        return;
    }

    private void finishRecovery()
    {
        LogManager.w("BluetoothCrashResolver", "Recovery attempt finished", new Object[0]);
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

    private void loadState()
    {
        Object obj;
        Exception exception;
        Object obj3;
        obj3 = null;
        obj = null;
        exception = null;
        Object obj2 = new BufferedReader(new InputStreamReader(context.openFileInput("BluetoothCrashResolverState.txt")));
        obj = ((BufferedReader) (obj2)).readLine();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        lastBluetoothCrashDetectionTime = Long.parseLong(((String) (obj)));
        obj = ((BufferedReader) (obj2)).readLine();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        detectedCrashCount = Integer.parseInt(((String) (obj)));
        obj = ((BufferedReader) (obj2)).readLine();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        recoveryAttemptCount = Integer.parseInt(((String) (obj)));
        obj = ((BufferedReader) (obj2)).readLine();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        lastRecoverySucceeded = false;
        if (((String) (obj)).equals("1"))
        {
            lastRecoverySucceeded = true;
        }
_L3:
        obj = ((BufferedReader) (obj2)).readLine();
        if (obj == null) goto _L2; else goto _L1
_L1:
        distinctBluetoothAddresses.add(obj);
          goto _L3
        obj;
_L9:
        obj = obj2;
        LogManager.w("BluetoothCrashResolver", "Can't read macs from %s", new Object[] {
            "BluetoothCrashResolverState.txt"
        });
        if (obj2 != null)
        {
            try
            {
                ((BufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        LogManager.d("BluetoothCrashResolver", "Read %s bluetooth addresses", new Object[] {
            Integer.valueOf(distinctBluetoothAddresses.size())
        });
        return;
_L2:
        if (obj2 != null)
        {
            try
            {
                ((BufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        break MISSING_BLOCK_LABEL_160;
        obj;
        obj2 = obj3;
_L7:
        obj = obj2;
        LogManager.w("BluetoothCrashResolver", "Can't parse file %s", new Object[] {
            "BluetoothCrashResolverState.txt"
        });
        if (obj2 != null)
        {
            try
            {
                ((BufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        break MISSING_BLOCK_LABEL_160;
        obj2;
_L5:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw obj2;
        exception;
        obj = obj2;
        obj2 = exception;
        if (true) goto _L5; else goto _L4
_L4:
        Object obj1;
        obj1;
        if (true) goto _L7; else goto _L6
_L6:
        obj1;
        obj2 = exception;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private void processStateChange()
    {
    /* block-local class not found */
    class UpdateNotifier {}

        if (updateNotifier != null)
        {
            updateNotifier.dataUpdated();
        }
        if (System.currentTimeMillis() - lastStateSaveTime > 60000L)
        {
            saveState();
        }
    }

    private void saveState()
    {
        Object obj;
        Object obj2;
        obj = null;
        obj2 = null;
        lastStateSaveTime = (new Date()).getTime();
        Object obj1 = new OutputStreamWriter(context.openFileOutput("BluetoothCrashResolverState.txt", 0));
        ((OutputStreamWriter) (obj1)).write((new StringBuilder()).append(lastBluetoothCrashDetectionTime).append("\n").toString());
        ((OutputStreamWriter) (obj1)).write((new StringBuilder()).append(detectedCrashCount).append("\n").toString());
        ((OutputStreamWriter) (obj1)).write((new StringBuilder()).append(recoveryAttemptCount).append("\n").toString());
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
        for (obj2 = distinctBluetoothAddresses.iterator(); ((Iterator) (obj2)).hasNext(); ((OutputStreamWriter) (obj1)).write("\n"))
        {
            ((OutputStreamWriter) (obj1)).write((String)((Iterator) (obj2)).next());
        }

          goto _L1
        obj2;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally
        {
            obj = obj1;
        }
_L5:
        obj = obj1;
        LogManager.w("BluetoothCrashResolver", "Can't write macs to %s", new Object[] {
            "BluetoothCrashResolverState.txt"
        });
        if (obj1 != null)
        {
            try
            {
                ((OutputStreamWriter) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        LogManager.d("BluetoothCrashResolver", "Wrote %s bluetooth addresses", new Object[] {
            Integer.valueOf(distinctBluetoothAddresses.size())
        });
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
            break MISSING_BLOCK_LABEL_215;
        }
        obj1;
_L3:
        if (obj != null)
        {
            try
            {
                ((OutputStreamWriter) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw obj1;
        if (true) goto _L3; else goto _L2
_L2:
        IOException ioexception;
        ioexception;
        obj1 = obj2;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void startRecovery()
    {
        recoveryAttemptCount = recoveryAttemptCount + 1;
        BluetoothAdapter bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        LogManager.d("BluetoothCrashResolver", "about to check if discovery is active", new Object[0]);
        if (!bluetoothadapter.isDiscovering())
        {
            LogManager.w("BluetoothCrashResolver", "Recovery attempt started", new Object[0]);
            recoveryInProgress = true;
            discoveryStartConfirmed = false;
            LogManager.d("BluetoothCrashResolver", "about to command discovery", new Object[0]);
            if (!bluetoothadapter.startDiscovery())
            {
                LogManager.w("BluetoothCrashResolver", "Can't start discovery.  Is bluetooth turned on?", new Object[0]);
            }
            LogManager.d("BluetoothCrashResolver", "startDiscovery commanded.  isDiscovering()=%s", new Object[] {
                Boolean.valueOf(bluetoothadapter.isDiscovering())
            });
            LogManager.d("BluetoothCrashResolver", "We will be cancelling this discovery in %s milliseconds.", new Object[] {
                Integer.valueOf(5000)
            });
            cancelDiscovery();
            return;
        } else
        {
            LogManager.w("BluetoothCrashResolver", "Already discovering.  Recovery attempt abandoned.", new Object[0]);
            return;
        }
    }

    public void crashDetected()
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            LogManager.d("BluetoothCrashResolver", "Ignoring crashes before SDK 18, because BLE is unsupported.", new Object[0]);
            return;
        }
        LogManager.w("BluetoothCrashResolver", "BluetoothService crash detected", new Object[0]);
        if (distinctBluetoothAddresses.size() > 0)
        {
            LogManager.d("BluetoothCrashResolver", "Distinct bluetooth devices seen at crash: %s", new Object[] {
                Integer.valueOf(distinctBluetoothAddresses.size())
            });
        }
        lastBluetoothCrashDetectionTime = (new Date()).getTime();
        detectedCrashCount = detectedCrashCount + 1;
        if (recoveryInProgress)
        {
            LogManager.d("BluetoothCrashResolver", "Ignoring bluetooth crash because recovery is already in progress.", new Object[0]);
        } else
        {
            startRecovery();
        }
        processStateChange();
    }

    public void disableDebug()
    {
    }

    public void enableDebug()
    {
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
        int i = distinctBluetoothAddresses.size();
        synchronized (distinctBluetoothAddresses)
        {
            distinctBluetoothAddresses.add(bluetoothdevice.getAddress());
        }
        int j = distinctBluetoothAddresses.size();
        if (i != j && j % 100 == 0)
        {
            LogManager.d("BluetoothCrashResolver", "Distinct bluetooth devices seen: %s", new Object[] {
                Integer.valueOf(distinctBluetoothAddresses.size())
            });
        }
        if (distinctBluetoothAddresses.size() > getCrashRiskDeviceCount() && !recoveryInProgress)
        {
            LogManager.w("BluetoothCrashResolver", "Large number of bluetooth devices detected: %s Proactively attempting to clear out address list to prevent a crash", new Object[] {
                Integer.valueOf(distinctBluetoothAddresses.size())
            });
            LogManager.w("BluetoothCrashResolver", "Stopping LE Scan", new Object[0]);
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
        LogManager.d("BluetoothCrashResolver", "started listening for BluetoothAdapter events", new Object[0]);
    }

    public void stop()
    {
        context.unregisterReceiver(receiver);
        LogManager.d("BluetoothCrashResolver", "stopped listening for BluetoothAdapter events", new Object[0]);
        saveState();
    }




/*
    static boolean access$202(BluetoothCrashResolver bluetoothcrashresolver, boolean flag)
    {
        bluetoothcrashresolver.discoveryStartConfirmed = flag;
        return flag;
    }

*/



/*
    static long access$302(BluetoothCrashResolver bluetoothcrashresolver, long l)
    {
        bluetoothcrashresolver.lastBluetoothOffTime = l;
        return l;
    }

*/



/*
    static long access$402(BluetoothCrashResolver bluetoothcrashresolver, long l)
    {
        bluetoothcrashresolver.lastBluetoothTurningOnTime = l;
        return l;
    }

*/

    /* member class not found */
    class _cls1 {}

}
