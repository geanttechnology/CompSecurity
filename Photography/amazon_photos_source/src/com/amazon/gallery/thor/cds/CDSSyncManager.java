// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.network.http.rest.account.UserManager;
import com.amazon.gallery.framework.network.http.senna.SennaSyncListener;
import com.amazon.gallery.framework.network.http.senna.sync.manager.SyncManager;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.syncframework.MetadataSyncScheduler;
import com.amazon.gallery.thor.syncframework.MetadataSyncSchedulerWrapper;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            SyncNotificationObserver

public class CDSSyncManager
    implements SyncManager
{
    private class LoggableSyncCallbackDelegate
        implements SennaSyncListener
    {

        private final SennaSyncListener _flddelegate;
        private final String name;
        final CDSSyncManager this$0;

        public void onFirstSyncCompleted()
        {
            _flddelegate.onFirstSyncCompleted();
            uiReadyExecutor.execute(new Runnable() {

                final LoggableSyncCallbackDelegate this$1;

                public void run()
                {
                    GLogger.logCustomerEvent("%s task is completed. Current cloud content in local database is %s", new Object[] {
                        name, mediaItemDao.getCloudCountByType()
                    });
                }

            
            {
                this$1 = LoggableSyncCallbackDelegate.this;
                super();
            }
            });
        }


        private LoggableSyncCallbackDelegate(SennaSyncListener sennasynclistener, String s)
        {
            this$0 = CDSSyncManager.this;
            super();
            _flddelegate = sennasynclistener;
            name = s;
        }

    }


    private static final TimeUnit METADATA_SYNC_INTERVAL_UNIT;
    private static final String TAG = com/amazon/gallery/thor/cds/CDSSyncManager.getName();
    private final long FOREGROUND_SYNC_INTERVAL = 15L;
    private final TimeUnit FOREGROUND_SYNC_INTERVAL_UNIT;
    private String accountId;
    private Pair accountObserverPair;
    private final SennaSyncListener coldBootListener;
    private final Context context;
    private boolean enabled;
    private final MediaItemDao mediaItemDao;
    private MetadataSyncScheduler syncScheduler;
    private final AtomicInteger syncState = new AtomicInteger(-1);
    private Executor uiReadyExecutor;

    public CDSSyncManager(Context context1, UserManager usermanager, SennaSyncListener sennasynclistener, MediaItemDao mediaitemdao, Executor executor)
    {
        FOREGROUND_SYNC_INTERVAL_UNIT = TimeUnit.SECONDS;
        enabled = true;
        context = context1;
        coldBootListener = new LoggableSyncCallbackDelegate(sennasynclistener, "ColdBoot");
        mediaItemDao = mediaitemdao;
        uiReadyExecutor = executor;
    }

    private MetadataSyncScheduler getSyncScheduler()
    {
        if (syncScheduler == null)
        {
            syncScheduler = new MetadataSyncSchedulerWrapper(context, accountId);
        }
        return syncScheduler;
    }

    private boolean registerAccountObserver()
    {
        this;
        JVM INSTR monitorenter ;
        accountId = ((AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER)).getAccountId();
        if (accountId != null) goto _L2; else goto _L1
_L1:
        accountObserverPair = null;
        stopSync();
        boolean flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (accountObserverPair != null && !((String)accountObserverPair.first).equals(accountId))
        {
            context.getContentResolver().unregisterContentObserver((ContentObserver)accountObserverPair.second);
        }
        if (accountObserverPair == null || !((String)accountObserverPair.first).equals(accountId))
        {
            android.net.Uri uri = com.amazon.mixtape.provider.CloudNodesContract.AccountMetadataStates.getContentUri(context.getResources().getString(0x7f0e02fb), accountId);
            android.net.Uri uri1 = com.amazon.mixtape.provider.CloudNodesContract.Events.getContentUri(context.getResources().getString(0x7f0e02fb), accountId);
            SyncNotificationObserver syncnotificationobserver = new SyncNotificationObserver(context, new Handler(Looper.getMainLooper()), coldBootListener, uri, uri1);
            accountObserverPair = new Pair(accountId, syncnotificationobserver);
            context.getContentResolver().registerContentObserver(uri, true, syncnotificationobserver);
            context.getContentResolver().registerContentObserver(uri1, true, syncnotificationobserver);
        }
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void reset()
    {
        (new Thread(new Runnable() {

            final CDSSyncManager this$0;

            public void run()
            {
                this;
                JVM INSTR monitorenter ;
                AccountManager accountmanager;
                accountObserverPair = null;
                stopSync();
                accountmanager = (AccountManager)context.getSystemService("account");
                if (syncScheduler != null)
                {
                    accountmanager.removeAccount(syncScheduler.getSyncAccount(), null, null).getResult();
                }
_L2:
                syncScheduler = null;
                this;
                JVM INSTR monitorexit ;
                return;
_L3:
                Object obj;
                GLogger.ex(CDSSyncManager.TAG, "Could not remove account.", ((Throwable) (obj)));
                if (true) goto _L2; else goto _L1
_L1:
                obj;
                this;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                  goto _L3
                obj;
                  goto _L3
                obj;
                  goto _L3
            }

            
            {
                this$0 = CDSSyncManager.this;
                super();
            }
        })).start();
    }

    public boolean isColdBootCompleted()
    {
        return context.getSharedPreferences("galleryKindleSharedPrefs", 0).getBoolean("coldBootStatus", false);
    }

    public void onAccountDeregistered()
    {
        reset();
    }

    public void onAccountRegistered()
    {
    }

    public void scheduleBackgroundSync()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = enabled;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        (new AsyncTask() {

            final CDSSyncManager this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                while (!registerAccountObserver() || syncState.getAndSet(1) == 1 || accountId == null) 
                {
                    return null;
                }
                GLogger.i(CDSSyncManager.TAG, "Scheduling background mixtape sync. (%s %s)", new Object[] {
                    Long.valueOf(1L), CDSSyncManager.METADATA_SYNC_INTERVAL_UNIT
                });
                getSyncScheduler().scheduleBackgroundSync(context, 1L, CDSSyncManager.METADATA_SYNC_INTERVAL_UNIT);
                return null;
            }

            
            {
                this$0 = CDSSyncManager.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void scheduleForegroundSync()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = enabled;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        (new AsyncTask() {

            final CDSSyncManager this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                while (!registerAccountObserver() || syncState.getAndSet(2) == 2 || accountId == null) 
                {
                    return null;
                }
                GLogger.i(CDSSyncManager.TAG, "Scheduling foreground mixtape sync. (%s $s)", new Object[] {
                    Long.valueOf(15L), FOREGROUND_SYNC_INTERVAL_UNIT
                });
                getSyncScheduler().scheduleForegroundSync(context, 15L, FOREGROUND_SYNC_INTERVAL_UNIT, true);
                return null;
            }

            
            {
                this$0 = CDSSyncManager.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void stopSync()
    {
        this;
        JVM INSTR monitorenter ;
        int i = syncState.getAndSet(0);
        if (i != 0) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (accountId != null)
        {
            GLogger.i(TAG, "Stopping scheduled mixtape sync.", new Object[0]);
            getSyncScheduler().stopScheduledSyncs(context);
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static 
    {
        METADATA_SYNC_INTERVAL_UNIT = TimeUnit.HOURS;
    }




/*
    static MetadataSyncScheduler access$1002(CDSSyncManager cdssyncmanager, MetadataSyncScheduler metadatasyncscheduler)
    {
        cdssyncmanager.syncScheduler = metadatasyncscheduler;
        return metadatasyncscheduler;
    }

*/











/*
    static Pair access$902(CDSSyncManager cdssyncmanager, Pair pair)
    {
        cdssyncmanager.accountObserverPair = pair;
        return pair;
    }

*/
}
