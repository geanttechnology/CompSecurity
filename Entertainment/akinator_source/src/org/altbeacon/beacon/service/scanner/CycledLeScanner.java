// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service.scanner;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import java.util.Date;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.startup.StartupBroadcastReceiver;
import org.altbeacon.bluetooth.BluetoothCrashResolver;

// Referenced classes of package org.altbeacon.beacon.service.scanner:
//            CycledLeScannerForLollipop, CycledLeScannerForJellyBeanMr2, CycledLeScanCallback

public abstract class CycledLeScanner
{

    private static final String TAG = "CycledLeScanner";
    protected boolean mBackgroundFlag;
    protected long mBetweenScanPeriod;
    private BluetoothAdapter mBluetoothAdapter;
    protected final BluetoothCrashResolver mBluetoothCrashResolver;
    protected final Context mContext;
    protected final CycledLeScanCallback mCycledLeScanCallback;
    protected final Handler mHandler = new Handler();
    private long mLastScanCycleEndTime;
    private long mLastScanCycleStartTime;
    protected long mNextScanCycleStartTime;
    protected boolean mRestartNeeded;
    private long mScanCycleStopTime;
    private boolean mScanCyclerStarted;
    private long mScanPeriod;
    private boolean mScanning;
    private boolean mScanningEnabled;
    protected boolean mScanningPaused;
    private PendingIntent mWakeUpOperation;

    protected CycledLeScanner(Context context, long l, long l1, boolean flag, CycledLeScanCallback cycledlescancallback, 
            BluetoothCrashResolver bluetoothcrashresolver)
    {
        mLastScanCycleStartTime = 0L;
        mLastScanCycleEndTime = 0L;
        mNextScanCycleStartTime = 0L;
        mScanCycleStopTime = 0L;
        mScanCyclerStarted = false;
        mScanningEnabled = false;
        mBackgroundFlag = false;
        mRestartNeeded = false;
        mWakeUpOperation = null;
        mScanPeriod = l;
        mBetweenScanPeriod = l1;
        mContext = context;
        mCycledLeScanCallback = cycledlescancallback;
        mBluetoothCrashResolver = bluetoothcrashresolver;
        mBackgroundFlag = flag;
    }

    public static CycledLeScanner createScanner(Context context, long l, long l1, boolean flag, CycledLeScanCallback cycledlescancallback, BluetoothCrashResolver bluetoothcrashresolver)
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            LogManager.w("CycledLeScanner", "Not supported prior to API 18.", new Object[0]);
            return null;
        }
        boolean flag1;
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            LogManager.i("CycledLeScanner", "This is not Android 5.0.  We are using old scanning APIs", new Object[0]);
            flag1 = false;
        } else
        if (BeaconManager.isAndroidLScanningDisabled())
        {
            LogManager.i("CycledLeScanner", "This Android 5.0, but L scanning is disabled. We are using old scanning APIs", new Object[0]);
            flag1 = false;
        } else
        {
            LogManager.i("CycledLeScanner", "This Android 5.0.  We are using new scanning APIs", new Object[0]);
            flag1 = true;
        }
        if (flag1)
        {
            return new CycledLeScannerForLollipop(context, l, l1, flag, cycledlescancallback, bluetoothcrashresolver);
        } else
        {
            return new CycledLeScannerForJellyBeanMr2(context, l, l1, flag, cycledlescancallback, bluetoothcrashresolver);
        }
    }

    private void finishScanCycle()
    {
label0:
        {
            LogManager.d("CycledLeScanner", "Done with scan cycle", new Object[0]);
            mCycledLeScanCallback.onCycleEnd();
            if (mScanning)
            {
                if (getBluetoothAdapter() != null)
                {
                    if (getBluetoothAdapter().isEnabled())
                    {
                        try
                        {
                            LogManager.d("CycledLeScanner", "stopping bluetooth le scan", new Object[0]);
                            finishScan();
                        }
                        catch (Exception exception)
                        {
                            LogManager.w(exception, "CycledLeScanner", "Internal Android exception scanning for beacons", new Object[0]);
                        }
                        mLastScanCycleEndTime = (new Date()).getTime();
                    } else
                    {
                        LogManager.w("CycledLeScanner", "Bluetooth is disabled.  Cannot scan for beacons.", new Object[0]);
                    }
                }
                mNextScanCycleStartTime = getNextScanStartTime();
                if (!mScanningEnabled)
                {
                    break label0;
                }
                scanLeDevice(Boolean.valueOf(true));
            }
            return;
        }
        LogManager.d("CycledLeScanner", "Scanning disabled.  No ranging or monitoring regions are active.", new Object[0]);
        mScanCyclerStarted = false;
        cancelWakeUpAlarm();
    }

    private long getNextScanStartTime()
    {
        if (mBetweenScanPeriod == 0L)
        {
            return System.currentTimeMillis();
        } else
        {
            long l = mScanPeriod;
            long l1 = mBetweenScanPeriod;
            l = mBetweenScanPeriod - System.currentTimeMillis() % (l + l1);
            LogManager.d("CycledLeScanner", "Normalizing between scan period from %s to %s", new Object[] {
                Long.valueOf(mBetweenScanPeriod), Long.valueOf(l)
            });
            return System.currentTimeMillis() + l;
        }
    }

    protected void cancelWakeUpAlarm()
    {
        LogManager.d("CycledLeScanner", "cancel wakeup alarm: %s", new Object[] {
            mWakeUpOperation
        });
        if (mWakeUpOperation != null)
        {
            ((AlarmManager)mContext.getSystemService("alarm")).cancel(mWakeUpOperation);
        }
    }

    protected abstract boolean deferScanIfNeeded();

    protected abstract void finishScan();

    protected BluetoothAdapter getBluetoothAdapter()
    {
        if (mBluetoothAdapter == null)
        {
            mBluetoothAdapter = ((BluetoothManager)mContext.getApplicationContext().getSystemService("bluetooth")).getAdapter();
            if (mBluetoothAdapter == null)
            {
                LogManager.w("CycledLeScanner", "Failed to construct a BluetoothAdapter", new Object[0]);
            }
        }
        return mBluetoothAdapter;
    }

    protected void scanLeDevice(Boolean boolean1)
    {
        mScanCyclerStarted = true;
        if (getBluetoothAdapter() == null)
        {
            LogManager.e("CycledLeScanner", "No bluetooth adapter.  beaconService cannot scan.", new Object[0]);
        }
        if (!boolean1.booleanValue())
        {
            break MISSING_BLOCK_LABEL_303;
        }
        if (deferScanIfNeeded())
        {
            return;
        }
        LogManager.d("CycledLeScanner", "starting a new scan cycle", new Object[0]);
        if (mScanning && !mScanningPaused && !mRestartNeeded) goto _L2; else goto _L1
_L1:
        mScanning = true;
        mScanningPaused = false;
        if (getBluetoothAdapter() == null) goto _L4; else goto _L3
_L3:
        if (!getBluetoothAdapter().isEnabled()) goto _L6; else goto _L5
_L5:
        if (mBluetoothCrashResolver == null || !mBluetoothCrashResolver.isRecoveryInProgress()) goto _L8; else goto _L7
_L7:
        LogManager.w("CycledLeScanner", "Skipping scan because crash recovery is in progress.", new Object[0]);
_L9:
        mLastScanCycleStartTime = (new Date()).getTime();
_L4:
        mScanCycleStopTime = (new Date()).getTime() + mScanPeriod;
        scheduleScanCycleStop();
        LogManager.d("CycledLeScanner", "Scan started", new Object[0]);
        return;
_L8:
        if (!mScanningEnabled)
        {
            break MISSING_BLOCK_LABEL_259;
        }
        if (!mRestartNeeded)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        mRestartNeeded = false;
        LogManager.d("CycledLeScanner", "restarting a bluetooth le scan", new Object[0]);
_L10:
        startScan();
          goto _L9
        boolean1;
        LogManager.e(boolean1, "CycledLeScanner", "Internal Android exception scanning for beacons", new Object[0]);
          goto _L9
        LogManager.d("CycledLeScanner", "starting a new bluetooth le scan", new Object[0]);
          goto _L10
        LogManager.d("CycledLeScanner", "Scanning unnecessary - no monitoring or ranging active.", new Object[0]);
          goto _L9
_L6:
        try
        {
            LogManager.w("CycledLeScanner", "Bluetooth is disabled.  Cannot scan for beacons.", new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Boolean boolean1)
        {
            LogManager.e(boolean1, "CycledLeScanner", "Exception starting bluetooth scan.  Perhaps bluetooth is disabled or unavailable?", new Object[0]);
        }
          goto _L4
_L2:
        LogManager.d("CycledLeScanner", "We are already scanning", new Object[0]);
          goto _L4
        LogManager.d("CycledLeScanner", "disabling scan", new Object[0]);
        mScanning = false;
        stopScan();
        mLastScanCycleEndTime = (new Date()).getTime();
        return;
          goto _L9
    }

    protected void scheduleScanCycleStop()
    {
        long l1 = mScanCycleStopTime - (new Date()).getTime();
        if (l1 > 0L)
        {
            LogManager.d("CycledLeScanner", "Waiting to stop scan cycle for another %s milliseconds", new Object[] {
                Long.valueOf(l1)
            });
            if (mBackgroundFlag)
            {
                setWakeUpAlarm();
            }
            Handler handler = mHandler;
            _cls1 _lcls1 = new _cls1();
            long l = l1;
            if (l1 > 1000L)
            {
                l = 1000L;
            }
            handler.postDelayed(_lcls1, l);
            return;
        } else
        {
            finishScanCycle();
            return;
        }
    }

    public void setScanPeriods(long l, long l1, boolean flag)
    {
        LogManager.d("CycledLeScanner", "Set scan periods called with %s, %s Background mode must have changed.", new Object[] {
            Long.valueOf(l), Long.valueOf(l1)
        });
        if (mBackgroundFlag != flag)
        {
            mRestartNeeded = true;
        }
        mBackgroundFlag = flag;
        mScanPeriod = l;
        mBetweenScanPeriod = l1;
        long l2;
        if (mBackgroundFlag)
        {
            LogManager.d("CycledLeScanner", "We are in the background.  Setting wakeup alarm", new Object[0]);
            setWakeUpAlarm();
        } else
        {
            LogManager.d("CycledLeScanner", "We are not in the background.  Cancelling wakeup alarm", new Object[0]);
            cancelWakeUpAlarm();
        }
        l2 = (new Date()).getTime();
        if (mNextScanCycleStartTime > l2)
        {
            l1 = mLastScanCycleEndTime + l1;
            if (l1 < mNextScanCycleStartTime)
            {
                mNextScanCycleStartTime = l1;
                LogManager.i("CycledLeScanner", "Adjusted nextScanStartTime to be %s", new Object[] {
                    new Date(mNextScanCycleStartTime)
                });
            }
        }
        if (mScanCycleStopTime > l2)
        {
            l = mLastScanCycleStartTime + l;
            if (l < mScanCycleStopTime)
            {
                mScanCycleStopTime = l;
                LogManager.i("CycledLeScanner", "Adjusted scanStopTime to be %s", new Object[] {
                    Long.valueOf(mScanCycleStopTime)
                });
            }
        }
    }

    protected void setWakeUpAlarm()
    {
        long l = 0x493e0L;
        if (0x493e0L < mBetweenScanPeriod)
        {
            l = mBetweenScanPeriod;
        }
        long l1 = l;
        if (l < mScanPeriod)
        {
            l1 = mScanPeriod;
        }
        AlarmManager alarmmanager = (AlarmManager)mContext.getSystemService("alarm");
        Intent intent = new Intent();
        intent.setClassName(mContext, org/altbeacon/beacon/startup/StartupBroadcastReceiver.getName());
        intent.putExtra("wakeup", true);
        cancelWakeUpAlarm();
        mWakeUpOperation = PendingIntent.getBroadcast(mContext, 0, intent, 0x10000000);
        alarmmanager.set(2, System.currentTimeMillis() + l1, mWakeUpOperation);
        LogManager.d("CycledLeScanner", "Set a wakeup alarm to go off in %s ms: %s", new Object[] {
            Long.valueOf(l1), mWakeUpOperation
        });
    }

    public void start()
    {
        LogManager.d("CycledLeScanner", "start called", new Object[0]);
        mScanningEnabled = true;
        if (!mScanCyclerStarted)
        {
            scanLeDevice(Boolean.valueOf(true));
            return;
        } else
        {
            LogManager.d("CycledLeScanner", "scanning already started", new Object[0]);
            return;
        }
    }

    protected abstract void startScan();

    public void stop()
    {
        LogManager.d("CycledLeScanner", "stop called", new Object[0]);
        mScanningEnabled = false;
        if (mScanCyclerStarted)
        {
            scanLeDevice(Boolean.valueOf(false));
        }
        if (mBluetoothAdapter != null)
        {
            stopScan();
            mLastScanCycleEndTime = (new Date()).getTime();
        }
    }

    protected abstract void stopScan();

    /* member class not found */
    class _cls1 {}

}
