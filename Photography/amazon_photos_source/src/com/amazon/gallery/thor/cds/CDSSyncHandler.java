// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.model.ListNodesRequest;
import com.amazon.clouddrive.model.ListNodesResponse;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ColdBootSaveEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.service.NetworkConnectionReceiver;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.cds.SyncHandler;
import com.amazon.gallery.framework.network.http.senna.sync.manager.SyncManager;
import com.amazon.mixtape.metadata.processing.EventIdStore;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import com.amazon.mixtape.service.SyncProgressObserver;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            ThorEventIdStore, ColdBootUIHandler, CDSUtil, GalleryMetadataSyncService, 
//            CloudDriveServiceClientManager

public class CDSSyncHandler
    implements SyncHandler
{

    private static final String TAG = com/amazon/gallery/thor/cds/CDSSyncHandler.getName();
    private final WeakReference activity;
    private final AuthenticationManager authenticationManager;
    private final CloudDriveServiceClientManager cloudDriveServiceClientManager;
    private final ColdBootUIHandler coldBootUIHandler;
    private final PhotosDemoManager demoManager;
    private final EventIdStore eventIdStore;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private boolean isBusRegistered;
    private boolean isNetworkReceiverRegistered;
    private final AtomicBoolean isSyncAdapterServiceBound = new AtomicBoolean(false);
    private final NetworkConnectionReceiver networkConnectionReceiver = new NetworkConnectionReceiver() {

        final CDSSyncHandler this$0;

        protected void onNetworkConnected(boolean flag)
        {
            GLogger.d(CDSSyncHandler.TAG, "Network connection recovered during ColdBoot", new Object[0]);
            if (totalCount == 0L)
            {
                getTotalCount();
            }
            coldBootUIHandler.onNetworkChange(true);
        }

        protected void onNetworkDisconnected()
        {
            GLogger.d(CDSSyncHandler.TAG, "Network connection lost during ColdBoot", new Object[0]);
            if (twoPartProgress.getProgress() < 50)
            {
                coldBootUIHandler.onNetworkChange(false);
            }
        }

            
            {
                this$0 = CDSSyncHandler.this;
                super();
            }
    };
    private final android.content.SharedPreferences.OnSharedPreferenceChangeListener sharedPreferenceChangeListener = new android.content.SharedPreferences.OnSharedPreferenceChangeListener() {

        final CDSSyncHandler this$0;

        public void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
        {
            if ("coldBootStatus".equals(s) && sharedpreferences.getBoolean(s, false))
            {
                GLogger.i(CDSSyncHandler.TAG, "Second stage sync complete... Cold boot has completed.", new Object[0]);
                update(100D, CDSUtil.TwoPartProgress.Part.TWO);
                sharedpreferences.unregisterOnSharedPreferenceChangeListener(this);
                unregisterBus();
            }
        }

            
            {
                this$0 = CDSSyncHandler.this;
                super();
            }
    };
    private final SharedPreferences sharedPreferences;
    private com.amazon.mixtape.service.MixtapeSyncService.SyncServiceBinder syncAdapterServiceBinder;
    private final ServiceConnection syncAdapterServiceConnection = new ServiceConnection() {

        final CDSSyncHandler this$0;

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            if (!isSyncObservationActive())
            {
                GLogger.i(CDSSyncHandler.TAG, "Sync observation is currently not active, unbinding service", new Object[0]);
                componentname = (Activity)activity.get();
                if (componentname != null)
                {
                    componentname.unbindService(this);
                }
                return;
            } else
            {
                GLogger.i(CDSSyncHandler.TAG, "%s successfully bound to %s", new Object[] {
                    CDSSyncHandler.TAG, com/amazon/gallery/thor/cds/GalleryMetadataSyncService.getName()
                });
                isSyncAdapterServiceBound.set(true);
                syncAdapterServiceBinder = (com.amazon.mixtape.service.MixtapeSyncService.SyncServiceBinder)ibinder;
                syncAdapterServiceBinder.addSyncProgressObserver(syncAdapterServiceProgressObserver);
                return;
            }
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
            GLogger.i(CDSSyncHandler.TAG, "%s successfully unbound from %s", new Object[] {
                CDSSyncHandler.TAG, com/amazon/gallery/thor/cds/GalleryMetadataSyncService.getName()
            });
            syncAdapterServiceBinder.removeSyncProgressObserver(syncAdapterServiceProgressObserver);
            isSyncAdapterServiceBound.set(false);
            syncAdapterServiceBinder = null;
        }

            
            {
                this$0 = CDSSyncHandler.this;
                super();
            }
    };
    private final SyncProgressObserver syncAdapterServiceProgressObserver = new SyncProgressObserver() {

        final CDSSyncHandler this$0;

        public void onProgressUpdate(double d, double d1)
        {
            GLogger.i(CDSSyncHandler.TAG, "onProgressChanged for metadata sync, progress: %f", new Object[] {
                Double.valueOf(d)
            });
            if (d == d1)
            {
                GLogger.i(CDSSyncHandler.TAG, "First stage metadata sync has completed", new Object[0]);
                startSecondStageSync();
            }
            update(d, CDSUtil.TwoPartProgress.Part.ONE);
        }

            
            {
                this$0 = CDSSyncHandler.this;
                super();
            }
    };
    private final SyncManager syncManager;
    private long totalCount;
    private final CDSUtil.TwoPartProgress twoPartProgress = new CDSUtil.TwoPartProgress(0.5D);

    public CDSSyncHandler(Activity activity1, SyncManager syncmanager, AuthenticationManager authenticationmanager, CloudDriveServiceClientManager clouddriveserviceclientmanager, PhotosDemoManager photosdemomanager)
    {
        totalCount = 0L;
        isBusRegistered = false;
        isNetworkReceiverRegistered = false;
        activity = new WeakReference(activity1);
        syncManager = syncmanager;
        authenticationManager = authenticationmanager;
        demoManager = photosdemomanager;
        cloudDriveServiceClientManager = clouddriveserviceclientmanager;
        eventIdStore = new ThorEventIdStore(activity1);
        coldBootUIHandler = new ColdBootUIHandler(activity1);
        sharedPreferences = activity1.getSharedPreferences("galleryKindleSharedPrefs", 0);
    }

    private long getCount(Uri uri)
    {
        Object obj;
        Cursor cursor;
        ContentProviderClient contentproviderclient;
        obj = (Activity)activity.get();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        contentproviderclient = ((Activity) (obj)).getContentResolver().acquireContentProviderClient(uri);
        cursor = null;
        obj = null;
        Cursor cursor1 = contentproviderclient.query(uri, new String[] {
            "count(*) AS count"
        }, null, null, null);
        obj = cursor1;
        cursor = cursor1;
        if (!cursor1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_107;
        }
        obj = cursor1;
        cursor = cursor1;
        int i = cursor1.getInt(0);
        long l = i;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        contentproviderclient.release();
        return l;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        contentproviderclient.release();
_L2:
        return 0L;
        RemoteException remoteexception;
        remoteexception;
        cursor = ((Cursor) (obj));
        GLogger.ex(TAG, (new StringBuilder()).append("Could not retrieve count for ").append(uri.toString()).toString(), remoteexception);
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        contentproviderclient.release();
        if (true) goto _L2; else goto _L1
_L1:
        uri;
        if (cursor != null)
        {
            cursor.close();
        }
        contentproviderclient.release();
        throw uri;
    }

    private void getTotalCount()
    {
        (new AsyncTask() {

            final CDSSyncHandler this$0;

            protected transient Long doInBackground(Void avoid[])
            {
                avoid = new ListNodesRequest();
                avoid.setLimit(Integer.valueOf(1));
                long l = cloudDriveServiceClientManager.getBackgroundCdsClient().listNodes(avoid).getCount();
                return Long.valueOf(l);
                avoid;
                GLogger.wx(CDSSyncHandler.TAG, "Failed to request total count, will use fallback methods when updating progress", avoid);
_L2:
                return Long.valueOf(0L);
                avoid;
                GLogger.d(CDSSyncHandler.TAG, "Failed to request total count, will use fallback methods when updating progress - interrupted", new Object[0]);
                if (true) goto _L2; else goto _L1
_L1:
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected void onPostExecute(Long long1)
            {
                totalCount = long1.longValue();
                coldBootUIHandler.setTotalCount(totalCount);
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Long)obj);
            }

            
            {
                this$0 = CDSSyncHandler.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private boolean isFirstStageComplete()
    {
        Object obj;
        Object obj1;
        GLogger.d(TAG, "Checking AccountMetadataState for first stage completion", new Object[0]);
        obj = authenticationManager.getAccountId();
        obj1 = com.amazon.mixtape.provider.CloudNodesContract.AccountMetadataStates.getContentUri(((Activity)activity.get()).getResources().getString(0x7f0e02fb), ((String) (obj)));
        obj = null;
        ContentProviderClient contentproviderclient = ((Activity)activity.get()).getContentResolver().acquireContentProviderClient(((Uri) (obj1)));
        obj = contentproviderclient;
        obj1 = CDSUtil.getAccountState(contentproviderclient, ((Uri) (obj1)));
        if (contentproviderclient != null)
        {
            contentproviderclient.release();
        }
        return "READY".equals(obj1);
        Exception exception;
        exception;
        if (obj != null)
        {
            ((ContentProviderClient) (obj)).release();
        }
        throw exception;
    }

    private boolean isSyncObservationActive()
    {
        return isNetworkReceiverRegistered;
    }

    private void registerBus()
    {
        if (!isBusRegistered)
        {
            GLogger.d(TAG, "Registered bus for migration progress", new Object[0]);
            GlobalMessagingBus.register(this);
            isBusRegistered = true;
        }
    }

    private void registerNetworkReceiver()
    {
        Activity activity1 = (Activity)activity.get();
        if (activity1 != null)
        {
            activity1.registerReceiver(networkConnectionReceiver, NetworkConnectionReceiver.getIntentFilter());
            isNetworkReceiverRegistered = true;
        }
    }

    private void startFirstStageSync()
    {
        GLogger.i(TAG, "Starting first stage sync", new Object[0]);
        registerNetworkReceiver();
        Activity activity1 = (Activity)activity.get();
        if (activity1 != null)
        {
            activity1.bindService((new Intent(activity1, com/amazon/gallery/thor/cds/GalleryMetadataSyncService)).setAction("com.amazon.mixtape.sync.service.BIND_FOR_OBSERVER"), syncAdapterServiceConnection, 1);
        }
    }

    private void startPreSyncStage()
    {
        GLogger.i(TAG, "Started pre-sync stage", new Object[0]);
        if (totalCount == 0L)
        {
            getTotalCount();
        }
        sharedPreferences.registerOnSharedPreferenceChangeListener(sharedPreferenceChangeListener);
        twoPartProgress.setCurrentProgress(sharedPreferences.getInt("cold_boot_progress", 0));
        GLogger.d(TAG, "Restored cold boot progress to %d", new Object[] {
            Integer.valueOf(twoPartProgress.getProgress())
        });
        coldBootUIHandler.show(twoPartProgress.getProgress());
    }

    private void startSecondStageSync()
    {
        GLogger.i(TAG, "Starting second stage sync", new Object[0]);
        registerBus();
        unbindIfNeeded();
        unregisterNetworkReceiver();
        if (isSyncAdapterServiceBound.get())
        {
            syncAdapterServiceBinder.removeSyncProgressObserver(syncAdapterServiceProgressObserver);
        }
    }

    private void unbindIfNeeded()
    {
        Activity activity1 = (Activity)activity.get();
        if (activity1 != null && isSyncAdapterServiceBound.getAndSet(false))
        {
            activity1.unbindService(syncAdapterServiceConnection);
        }
    }

    private void unregisterBus()
    {
        if (isBusRegistered)
        {
            GLogger.d(TAG, "Un-registered bus for migration progress", new Object[0]);
            GlobalMessagingBus.unregister(this);
            isBusRegistered = false;
        }
    }

    private void unregisterNetworkReceiver()
    {
        Activity activity1 = (Activity)activity.get();
        if (activity1 != null && isNetworkReceiverRegistered)
        {
            activity1.unregisterReceiver(networkConnectionReceiver);
            isNetworkReceiverRegistered = false;
        }
    }

    private void update(double d, CDSUtil.TwoPartProgress.Part part)
    {
        twoPartProgress.update(d, part);
        int i = twoPartProgress.getProgress();
        coldBootUIHandler.updateProgress(i);
    }

    public void onColdBootSaveEvent(ColdBootSaveEvent coldbootsaveevent)
    {
        coldbootsaveevent = null;
        long l1 = totalCount;
        long l = l1;
        if (l1 == 0L)
        {
            coldbootsaveevent = eventIdStore.getEventIdRange(authenticationManager.getAccountId());
            l = ((com.amazon.mixtape.metadata.processing.EventIdStore.EventIdRange) (coldbootsaveevent)).upperEventId;
        }
        l1 = getCount(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.MediaItem.CONTENT_URI);
        long l2 = getCount(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.Tag.CONTENT_URI);
        if (coldbootsaveevent == null || l != ((com.amazon.mixtape.metadata.processing.EventIdStore.EventIdRange) (coldbootsaveevent)).lowerEventId)
        {
            l = (int)((((double)l1 + (double)l2) / (double)l) * 100D);
            GLogger.i(TAG, "Migration progress: %d", new Object[] {
                Long.valueOf(l)
            });
            update(l, CDSUtil.TwoPartProgress.Part.TWO);
        }
    }

    public void scheduleSync()
    {
        if (demoManager.isInDemoMode() || StringUtils.isEmpty(authenticationManager.getAccountId()))
        {
            return;
        }
        GLogger.i(TAG, "Foreground sync scheduled", new Object[0]);
        syncManager.scheduleForegroundSync();
        if (!sharedPreferences.getBoolean("coldBootStatus", false))
        {
            GLogger.i(TAG, "ColdBoot has not completed, attaching listeners and binding...", new Object[0]);
            startPreSyncStage();
            if (!isFirstStageComplete())
            {
                startFirstStageSync();
                return;
            } else
            {
                GLogger.i(TAG, "Skipping first stage sync...", new Object[0]);
                startSecondStageSync();
                return;
            }
        } else
        {
            unregisterBus();
            coldBootUIHandler.hide();
            return;
        }
    }

    public void stopSyncObservation()
    {
        GLogger.i(TAG, "Stopping sync observation, all listeners and buses will be unregistered", new Object[0]);
        if (demoManager.isInDemoMode())
        {
            return;
        }
        unregisterBus();
        if (syncAdapterServiceBinder != null)
        {
            syncAdapterServiceBinder.removeSyncProgressObserver(syncAdapterServiceProgressObserver);
        }
        coldBootUIHandler.shutdown();
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(sharedPreferenceChangeListener);
        unregisterNetworkReceiver();
        unbindIfNeeded();
    }






/*
    static long access$102(CDSSyncHandler cdssynchandler, long l)
    {
        cdssynchandler.totalCount = l;
        return l;
    }

*/



/*
    static com.amazon.mixtape.service.MixtapeSyncService.SyncServiceBinder access$1102(CDSSyncHandler cdssynchandler, com.amazon.mixtape.service.MixtapeSyncService.SyncServiceBinder syncservicebinder)
    {
        cdssynchandler.syncAdapterServiceBinder = syncservicebinder;
        return syncservicebinder;
    }

*/










}
