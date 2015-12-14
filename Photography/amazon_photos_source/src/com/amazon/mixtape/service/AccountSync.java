// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import android.accounts.Account;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.AmazonCloudDriveExtended;
import com.amazon.mixtape.account.AccountContextFactory;
import com.amazon.mixtape.account.MetadataStore;
import com.amazon.mixtape.metrics.MixtapeMetricRecorder;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

// Referenced classes of package com.amazon.mixtape.service:
//            MetadataCleanup, SyncProgressObserver, SyncStateObserver, MetadataSyncException, 
//            SyncDependencyProvider, MetadataFetcherProgressObserver, DatabaseSizeMetrics, MetadataFetcher

class AccountSync
{
    private static class AccountSyncState
    {

        private final Map mAccountStates;

        public int accountErrored(String s)
        {
            this;
            JVM INSTR monitorenter ;
            int i;
            mAccountStates.put(s, Integer.valueOf(2));
            i = getState();
            this;
            JVM INSTR monitorexit ;
            return i;
            s;
            throw s;
        }

        public int finishAccountSync(String s)
        {
            this;
            JVM INSTR monitorenter ;
            int i;
            mAccountStates.remove(s);
            i = getState();
            this;
            JVM INSTR monitorexit ;
            return i;
            s;
            throw s;
        }

        public int getState()
        {
            byte byte0 = 2;
            this;
            JVM INSTR monitorenter ;
            boolean flag = mAccountStates.isEmpty();
            if (!flag) goto _L2; else goto _L1
_L1:
            byte0 = 0;
_L4:
            this;
            JVM INSTR monitorexit ;
            return byte0;
_L2:
            flag = mAccountStates.containsValue(Integer.valueOf(2));
            if (!flag)
            {
                byte0 = 1;
            }
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        public int startAccountSync(String s)
        {
            this;
            JVM INSTR monitorenter ;
            int i;
            mAccountStates.put(s, Integer.valueOf(1));
            i = getState();
            this;
            JVM INSTR monitorexit ;
            return i;
            s;
            throw s;
        }

        private AccountSyncState()
        {
            mAccountStates = new HashMap();
        }

    }

    private class AdjustedFetchProgressObserver
        implements MetadataFetcherProgressObserver
    {

        double currentProgress;
        private long mCurrentCount;
        private long mTotalCount;
        final AccountSync this$0;

        private void calculateCurrentProgressAndNotify()
        {
            if (mCurrentCount > mTotalCount)
            {
                currentProgress = currentProgress + (100D - currentProgress) / 2D;
            } else
            {
                currentProgress = ((double)mCurrentCount / (double)mTotalCount) * 100D;
            }
            notifyProgressUpdate(currentProgress, 100D);
        }

        public void notifyComplete()
        {
            notifyProgressUpdate(100D, 100D);
        }

        public void setCurrentCount(long l)
        {
            mCurrentCount = l;
            calculateCurrentProgressAndNotify();
        }

        public void setTotalCount(long l)
        {
            mTotalCount = l;
        }

        public void updateCurrentCount(long l)
        {
            mCurrentCount = mCurrentCount + l;
            calculateCurrentProgressAndNotify();
        }

        private AdjustedFetchProgressObserver()
        {
            this$0 = AccountSync.this;
            super();
        }

    }

    private static class MetadataSyncTask
        implements com.amazon.mixtape.account.AccountContextFactory.MetadataTask
    {

        private final String mAccountId;
        private final String mAuthority;
        private final AmazonCloudDriveExtended mClient;
        private final Context mContext;
        private final MixtapeMetricRecorder mMixtapeMetricRecorder;
        private final List mPartialSyncRequests;
        private final MetadataFetcherProgressObserver mProgressObserver;

        public void run(SQLiteDatabase sqlitedatabase)
            throws InterruptedException, CloudDriveException, MetadataSyncException
        {
            Object obj;
            sqlitedatabase = AccountContextFactory.getContextForAccountId(mContext, mAccountId).createMetadataStore(mAuthority);
            obj = new DatabaseSizeMetrics(mContext, sqlitedatabase, mMixtapeMetricRecorder);
            obj = new MetadataFetcher(mClient, sqlitedatabase, mPartialSyncRequests, mProgressObserver, mMixtapeMetricRecorder, ((DatabaseSizeMetrics) (obj)));
            ((MetadataFetcher) (obj)).fetch();
            Exception exception;
            try
            {
                sqlitedatabase.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                return;
            }
            exception;
            try
            {
                sqlitedatabase.close();
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase) { }
            throw exception;
        }

        public MetadataSyncTask(Context context, AmazonCloudDriveExtended amazonclouddriveextended, String s, String s1, List list, MixtapeMetricRecorder mixtapemetricrecorder, MetadataFetcherProgressObserver metadatafetcherprogressobserver)
        {
            mContext = context;
            mClient = amazonclouddriveextended;
            mAccountId = s;
            mAuthority = s1;
            mPartialSyncRequests = list;
            mMixtapeMetricRecorder = mixtapemetricrecorder;
            mProgressObserver = metadatafetcherprogressobserver;
        }
    }


    private static final String TAG = com/amazon/mixtape/service/AccountSync.getSimpleName();
    private final AccountSyncState mAccountSyncState = new AccountSyncState();
    private final Context mContext;
    private final SyncDependencyProvider mDependencyProvider;
    private final AdjustedFetchProgressObserver mFetchProgressObserver = new AdjustedFetchProgressObserver();
    private final MetadataCleanup mMetadataCleanup = new MetadataCleanup();
    private final CopyOnWriteArraySet mSyncProgressObservers = new CopyOnWriteArraySet();
    private final CopyOnWriteArraySet mSyncStateObservers = new CopyOnWriteArraySet();

    public AccountSync(Context context, SyncDependencyProvider syncdependencyprovider)
    {
        mContext = context;
        mDependencyProvider = syncdependencyprovider;
    }

    private void notifyProgressUpdate(double d, double d1)
    {
        for (Iterator iterator = mSyncProgressObservers.iterator(); iterator.hasNext(); ((SyncProgressObserver)iterator.next()).onProgressUpdate(d, d1)) { }
    }

    private void notifyStateUpdate(int i)
    {
        for (Iterator iterator = mSyncStateObservers.iterator(); iterator.hasNext(); ((SyncStateObserver)iterator.next()).onSyncStateChanged(i)) { }
    }

    private void runMetadataTask(com.amazon.mixtape.account.AccountContextFactory.AccountContext accountcontext, MixtapeMetricRecorder mixtapemetricrecorder, com.amazon.mixtape.account.AccountContextFactory.MetadataTask metadatatask, String s)
        throws InterruptedException
    {
        s = new com.amazon.mixtape.metrics.MixtapeMetric.Timer(s);
        try
        {
            s.start();
            accountcontext.runInMetadataContext(metadatatask);
            mixtapemetricrecorder.addMetric(s.finished());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.amazon.mixtape.account.AccountContextFactory.AccountContext accountcontext)
        {
            mixtapemetricrecorder.addMetric(s.failed());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.amazon.mixtape.account.AccountContextFactory.AccountContext accountcontext)
        {
            mixtapemetricrecorder.addMetric(s.failed());
        }
    }

    void addSyncProgressObserver(SyncProgressObserver syncprogressobserver)
    {
        mSyncProgressObservers.add(syncprogressobserver);
        syncprogressobserver.onProgressUpdate(mFetchProgressObserver.currentProgress, 100D);
    }

    public void onPerformSync(Account account, String s)
    {
        MixtapeMetricRecorder mixtapemetricrecorder;
        String s1;
        mixtapemetricrecorder = mDependencyProvider.getMixtapeMetricsRecorder();
        com.amazon.mixtape.account.AccountContextFactory.AccountContext accountcontext = AccountContextFactory.getContextForAccount(mContext, account);
        if (accountcontext == null)
        {
            mixtapemetricrecorder.addMetric(new com.amazon.mixtape.metrics.MixtapeMetric.Event("UnknownAccountSync"));
            return;
        }
        s1 = accountcontext.getAccountId();
        Object obj = mDependencyProvider.getAmazonCloudDriveExtendedClient(s1);
        List list = mDependencyProvider.getPartialSyncListNodeRequests();
        if (mDependencyProvider.isSyncProgressEnabled())
        {
            account = mFetchProgressObserver;
        } else
        {
            account = null;
        }
        obj = new MetadataSyncTask(mContext, ((AmazonCloudDriveExtended) (obj)), s1, s, list, mixtapemetricrecorder, account);
        notifyStateUpdate(mAccountSyncState.startAccountSync(s1));
        account = new com.amazon.mixtape.metrics.MixtapeMetric.Event("MixtapeSync");
        account.setCount(1);
        runMetadataTask(accountcontext, mixtapemetricrecorder, mMetadataCleanup.getMetadataCleanupTasks(mContext, s, s1), "MetadataDBCleanup");
        accountcontext.runInMetadataContext(((com.amazon.mixtape.account.AccountContextFactory.MetadataTask) (obj)));
        notifyStateUpdate(mAccountSyncState.finishAccountSync(s1));
        runMetadataTask(accountcontext, mixtapemetricrecorder, mMetadataCleanup.getPostSyncTasks(), "PostSyncCleanup");
        mixtapemetricrecorder.addMetric(account);
        return;
        s;
        Log.e(TAG, "Exception occurred while fetching changes from CDS.", s);
        account.errored();
        notifyStateUpdate(mAccountSyncState.accountErrored(s1));
        mixtapemetricrecorder.addMetric(account);
        return;
        s;
        Log.e(TAG, "Exception occurred while syncing changes to device.", s);
        account.errored();
        notifyStateUpdate(mAccountSyncState.accountErrored(s1));
        mixtapemetricrecorder.addMetric(account);
        return;
        s;
        Log.v(TAG, "Interrupted while syncing metadata.");
        account.errored();
        notifyStateUpdate(mAccountSyncState.accountErrored(s1));
        Thread.currentThread().interrupt();
        mixtapemetricrecorder.addMetric(account);
        return;
        s;
        account.errored();
        notifyStateUpdate(mAccountSyncState.accountErrored(s1));
        throw s;
        s;
        mixtapemetricrecorder.addMetric(account);
        throw s;
    }

    void removeSyncProgressObserver(SyncProgressObserver syncprogressobserver)
    {
        mSyncProgressObservers.remove(syncprogressobserver);
    }


}
