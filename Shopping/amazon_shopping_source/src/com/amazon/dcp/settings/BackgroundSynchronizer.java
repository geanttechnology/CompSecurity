// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.amazon.dcp.settings:
//            SettingsContract, SettingsSyncException, SettingsCacheUpdater

final class BackgroundSynchronizer
{

    private static final String TAG = com/amazon/dcp/settings/BackgroundSynchronizer.getName();
    private static final ExecutorService THREAD_POOL = Executors.newCachedThreadPool();
    private final BroadcastReceiver mChangeListener = new BroadcastReceiver() {

        final BackgroundSynchronizer this$0;

        public void onReceive(Context context1, Intent intent)
        {
            startSync();
        }

            
            {
                this$0 = BackgroundSynchronizer.this;
                super();
            }
    };
    private final Context mContext;
    private boolean mInitialSyncComplete;
    private final ReentrantLock mLock = new ReentrantLock();
    private final SettingsCacheUpdater mSettingsCacheUpdater;
    private final Condition mSyncCompleted;
    private Throwable mSyncError;
    private boolean mSyncInProgress;

    public BackgroundSynchronizer(SettingsCacheUpdater settingscacheupdater, Context context)
    {
        mSyncCompleted = mLock.newCondition();
        mSyncInProgress = false;
        mInitialSyncComplete = false;
        mSyncError = null;
        mSettingsCacheUpdater = settingscacheupdater;
        mContext = context;
    }

    private void registerChangeListener()
    {
        if (mContext == null)
        {
            return;
        } else
        {
            IntentFilter intentfilter = new IntentFilter("com.amazon.dcp.settings.action.ACTION_SETTINGS_UPDATED");
            intentfilter.addDataScheme("content");
            intentfilter.addDataAuthority("com.amazon.dcp.settings", null);
            intentfilter.addDataPath("/values/-device-", 0);
            intentfilter.addDataPath((new StringBuilder()).append("/values/").append(SettingsContract.getAppLocalNamespace(mContext)).toString(), 0);
            intentfilter.addDataPath("/values/-device-/", 1);
            intentfilter.addDataPath((new StringBuilder()).append("/values/").append(SettingsContract.getAppLocalNamespace(mContext)).append("/").toString(), 1);
            mContext.registerReceiver(mChangeListener, intentfilter);
            return;
        }
    }

    private void setSyncInProgress(boolean flag, Throwable throwable)
    {
        mLock.lock();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        if (!mSyncInProgress || throwable != null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        mInitialSyncComplete = true;
        mSyncInProgress = flag;
        mSyncError = throwable;
        if (!mSyncInProgress)
        {
            mSyncCompleted.signalAll();
        }
        mLock.unlock();
        return;
        throwable;
        mLock.unlock();
        throw throwable;
    }

    private void unregisterChangeListener()
    {
        if (mContext == null)
        {
            return;
        } else
        {
            mContext.unregisterReceiver(mChangeListener);
            return;
        }
    }

    public void destroy()
    {
        unregisterChangeListener();
    }

    public void init()
    {
        registerChangeListener();
        startSync();
    }

    public void startSync()
    {
        setSyncInProgress(true, null);
        Log.i(TAG, "Requesting sync with content provider.");
        THREAD_POOL.submit(new Runnable() {

            final BackgroundSynchronizer this$0;

            public void run()
            {
                try
                {
                    mSettingsCacheUpdater.updateFromContentProvider(mContext);
                    setSyncInProgress(false, null);
                    return;
                }
                catch (Throwable throwable)
                {
                    setSyncInProgress(false, throwable);
                }
            }

            
            {
                this$0 = BackgroundSynchronizer.this;
                super();
            }
        });
        if (false)
        {
            Log.e(TAG, "Error posting async task start.");
            setSyncInProgress(false, new SettingsSyncException("Error posting async task start."));
        }
        return;
        Exception exception;
        exception;
        if (true)
        {
            Log.e(TAG, "Error posting async task start.");
            setSyncInProgress(false, new SettingsSyncException("Error posting async task start."));
        }
        throw exception;
    }

    public void waitForInitialSync()
    {
        mLock.lock();
        boolean flag = mInitialSyncComplete;
        if (flag)
        {
            mLock.unlock();
            return;
        }
        Log.i(TAG, "Waiting for initial sync...");
_L1:
        Throwable throwable;
        if (mInitialSyncComplete)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        throwable = mSyncError;
        Exception exception;
        if (throwable != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        try
        {
            mSyncCompleted.await();
        }
        catch (InterruptedException interruptedexception) { }
        finally
        {
            mLock.unlock();
        }
          goto _L1
        if (mSyncError != null)
        {
            Log.e(TAG, "Initial sync failed", mSyncError);
            throw new SettingsSyncException(mSyncError);
        }
        break MISSING_BLOCK_LABEL_107;
        throw exception;
        Log.i(TAG, "Wait for initial sync complete.");
        mLock.unlock();
        return;
    }




}
