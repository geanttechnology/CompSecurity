// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import android.accounts.Account;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.amazon.mixtape.concurrent.KeyedThreads;
import com.amazon.mixtape.metrics.MixtapeMetricRecorder;
import com.amazon.mixtape.metrics.NoOpMixtapeMetricRecorder;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.amazon.mixtape.service:
//            SyncDependencyProvider, MixtapeSyncAdapter, StartIds, AccountSync, 
//            SyncProgressObserver

public abstract class MixtapeSyncService extends Service
    implements SyncDependencyProvider
{
    private class AccountForceSyncTask
        implements com.amazon.mixtape.concurrent.KeyedThreads.KeyedTask
    {

        private final Account mAccount;
        private final String mAuthority;
        private final int mStartId;
        final MixtapeSyncService this$0;

        public Account getKey()
        {
            return mAccount;
        }

        public volatile Object getKey()
        {
            return getKey();
        }

        public void run()
        {
            MixtapeSyncService.sAccountSync.onPerformSync(mAccount, mAuthority);
            mStartIds.remove(mStartId);
            return;
            Exception exception;
            exception;
            mStartIds.remove(mStartId);
            throw exception;
        }

        public AccountForceSyncTask(Account account, String s, int i)
        {
            this$0 = MixtapeSyncService.this;
            super();
            mAccount = account;
            mAuthority = s;
            mStartId = i;
        }
    }

    public class SyncServiceBinder extends Binder
    {

        final MixtapeSyncService this$0;

        public void addSyncProgressObserver(SyncProgressObserver syncprogressobserver)
        {
            MixtapeSyncService.sAccountSync.addSyncProgressObserver(syncprogressobserver);
        }

        public void removeSyncProgressObserver(SyncProgressObserver syncprogressobserver)
        {
            MixtapeSyncService.sAccountSync.removeSyncProgressObserver(syncprogressobserver);
        }

        public SyncServiceBinder()
        {
            this$0 = MixtapeSyncService.this;
            super();
        }
    }


    private static final KeyedThreads FORCED_SYNC_THREADS = new KeyedThreads("ForcedSync");
    private static final String TAG = com/amazon/mixtape/service/MixtapeSyncService.getSimpleName();
    private static AccountSync sAccountSync;
    private static MixtapeSyncAdapter sSyncAdapter;
    private final SyncServiceBinder mServiceBinder = new SyncServiceBinder();
    private StartIds mStartIds;

    public MixtapeSyncService()
    {
    }

    private boolean isEmpty(String s)
    {
        return s == null || s.equals("");
    }

    private boolean startForceSync(Intent intent, int i)
    {
        String s = intent.getStringExtra("accountName");
        if (isEmpty(s))
        {
            Log.w(TAG, "Failed to provide an account name on a force sync.");
            return false;
        }
        String s1 = intent.getStringExtra("accountType");
        if (isEmpty(s1))
        {
            Log.w(TAG, "Failed to provide an account type on a force sync.");
            return false;
        }
        intent = intent.getStringExtra("authority");
        if (isEmpty(intent))
        {
            Log.w(TAG, "Failed to provide the CloudNodesProvider authority on a force sync.");
            return false;
        } else
        {
            intent = new AccountForceSyncTask(new Account(s, s1), intent, i);
            return FORCED_SYNC_THREADS.startThread(intent);
        }
    }

    public MixtapeMetricRecorder getMixtapeMetricsRecorder()
    {
        return new NoOpMixtapeMetricRecorder();
    }

    public List getPartialSyncListNodeRequests()
    {
        return Collections.emptyList();
    }

    public boolean isSyncProgressEnabled()
    {
        return false;
    }

    public IBinder onBind(Intent intent)
    {
        if (intent != null && "com.amazon.mixtape.sync.service.BIND_FOR_OBSERVER".equals(intent.getAction()))
        {
            return mServiceBinder;
        } else
        {
            return sSyncAdapter.getSyncAdapterBinder();
        }
    }

    public void onCreate()
    {
        super.onCreate();
        mStartIds = new StartIds(this);
        com/amazon/mixtape/service/MixtapeSyncService;
        JVM INSTR monitorenter ;
        if (sAccountSync == null)
        {
            sAccountSync = new AccountSync(this, this);
        }
        if (sSyncAdapter == null)
        {
            sSyncAdapter = MixtapeSyncAdapter.createInstance(this, sAccountSync);
        }
        com/amazon/mixtape/service/MixtapeSyncService;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        com/amazon/mixtape/service/MixtapeSyncService;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onDestroy()
    {
        super.onDestroy();
        FORCED_SYNC_THREADS.cancelAllThreads();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        mStartIds.add(j);
        boolean flag1 = false;
        boolean flag = flag1;
        if (intent != null)
        {
            flag = flag1;
            if ("com.amazon.mixtape.sync.service.FORCE_START".equals(intent.getAction()))
            {
                flag = startForceSync(intent, j);
            }
        }
        if (flag)
        {
            return 1;
        } else
        {
            return super.onStartCommand(intent, i, j);
        }
    }



}
