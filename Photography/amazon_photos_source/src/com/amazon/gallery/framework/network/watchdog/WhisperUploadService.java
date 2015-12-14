// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.watchdog;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.preference.PreferenceManager;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.thread.NamedThreadFactory;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.notifications.UploadNotificationHandler;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.exceptions.AccountLockedException;
import com.amazon.gallery.framework.network.exceptions.NoStorageInfoAvailableException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.multiqueueuploader.ImmediateTriggerListener;
import com.amazon.gallery.framework.network.multiqueueuploader.MultiQueueUploader;
import com.amazon.gallery.framework.network.multiqueueuploader.MultiQueueUploaderMessageHandler;
import com.amazon.gallery.framework.network.multiqueueuploader.QueueType;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadActionEvent;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadControlAction;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadError;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadMediaItemsEvent;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadPermission;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadStrategy;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.service.WhisperUploadDeviceStateMonitor;
import com.amazon.gallery.thor.app.service.WhisperUploadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.framework.network.watchdog:
//            AutoSaveManager

public class WhisperUploadService extends Service
{
    public static final class RequeueUploadTask
        implements Runnable
    {

        private final AtomicBoolean isQueuing;
        private final MediaItemDao mediaItemDao;
        private final Handler runOnUiThreadHandler;
        private final Runnable stopSelfRunnable;
        private final UploadStrategy uploadStrategy;

        public void run()
        {
            ArrayList arraylist = new ArrayList(mediaItemDao.getItemsBySyncState(SyncState.PENDING_MANUAL).getMediaItems());
            boolean flag = arraylist.isEmpty();
            if (!flag)
            {
                GlobalMessagingBus.post(new UploadMediaItemsEvent(arraylist, QueueType.MANUAL, uploadStrategy, WhisperUploadService.TAG));
            }
            runOnUiThreadHandler.post(flag. new Runnable() {

                final RequeueUploadTask this$0;
                final boolean val$isEmpty;

                public void run()
                {
                    isQueuing.set(false);
                    if (isEmpty)
                    {
                        stopSelfRunnable.run();
                    }
                }

            
            {
                this$0 = final_requeueuploadtask;
                isEmpty = Z.this;
                super();
            }
            });
        }



        public RequeueUploadTask(MediaItemDao mediaitemdao, UploadStrategy uploadstrategy, AtomicBoolean atomicboolean, Runnable runnable, Handler handler)
        {
            mediaItemDao = mediaitemdao;
            uploadStrategy = uploadstrategy;
            isQueuing = atomicboolean;
            stopSelfRunnable = runnable;
            runOnUiThreadHandler = handler;
        }
    }

    public class ServiceBinder extends Binder
    {

        final WhisperUploadService this$0;

        public ServiceBinder()
        {
            this$0 = WhisperUploadService.this;
            super();
        }
    }

    private class SimpleUploadPermission
        implements UploadPermission
    {

        final WhisperUploadService this$0;

        public UploadError getUploadPermission(MediaItem mediaitem, String s, UploadStrategy uploadstrategy, QueueType queuetype)
            throws NoStorageInfoAvailableException
        {
            if (s == null)
            {
                mediaitem = UploadError.UNREGISTERED;
            } else
            {
                if (!s.equals(getAmazonAccount()))
                {
                    GLogger.i(WhisperUploadService.TAG, "Active account changed; cancelling upload tasks for now", new Object[0]);
                    return UploadError.ACCOUNT_CHANGED;
                }
                if (!isNetworkAccessAllowed(uploadstrategy))
                {
                    return UploadError.WAITING_FOR_WIFI;
                }
                mediaitem = uploadManager.getDeviceStateMonitor();
                if (mediaitem == null)
                {
                    return UploadError.UNREGISTERED;
                }
                mediaitem = mediaitem.getUploadErrorFromDeviceState();
                static class _cls5
                {

                    static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType[];
                    static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[];
                    static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[];

                    static 
                    {
                        $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction = new int[UploadControlAction.values().length];
                        try
                        {
                            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[UploadControlAction.CANCEL.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror6) { }
                        try
                        {
                            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[UploadControlAction.PAUSE.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror5) { }
                        $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType = new int[QueueType.values().length];
                        try
                        {
                            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType[QueueType.MANUAL.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        try
                        {
                            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType[QueueType.AUTO_SAVE.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType[QueueType.FORCE_UPLOAD.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError = new int[UploadError.values().length];
                        try
                        {
                            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.WAITING_FOR_POWER.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.LOW_BATTERY.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (_cls5..SwitchMap.com.amazon.gallery.framework.network.multiqueueuploader.UploadError[mediaitem.ordinal()])
                {
                default:
                    return mediaitem;

                case 1: // '\001'
                case 2: // '\002'
                    break;
                }
                if (!QueueType.AUTO_SAVE.equals(queuetype))
                {
                    return UploadError.NO_ERROR;
                }
            }
            return mediaitem;
        }

        public void notifyUploaded(MediaItem mediaitem)
            throws NoStorageInfoAvailableException
        {
        }

        private SimpleUploadPermission()
        {
            this$0 = WhisperUploadService.this;
            super();
        }

    }

    private class UploadRunnable
        implements Runnable
    {

        private final AtomicBoolean cancelSignal = new AtomicBoolean(false);
        private final AtomicBoolean paused = new AtomicBoolean(false);
        public final Set queueTypes = new LinkedHashSet();
        private final AtomicBoolean running = new AtomicBoolean(false);
        final WhisperUploadService this$0;

        private void cancel()
        {
            cancelSignal.set(true);
        }

        public boolean isPaused()
        {
            return paused.get();
        }

        public boolean isRunning()
        {
            return running.get();
        }

        public void run()
        {
            GLogger.d(WhisperUploadService.TAG, "Uploading started", new Object[0]);
            setIsRunning(true);
            if (initialized)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            GLogger.w(WhisperUploadService.TAG, "Uninitialized. Uploading aborted.", new Object[0]);
            if (isPaused())
            {
                GLogger.i(WhisperUploadService.TAG, "Upload is paused, keeping service alive...", new Object[0]);
            }
            setIsRunning(isPaused());
            stopServiceIfCompleted();
            return;
            String s = getAmazonAccount();
            if (s != null)
            {
                break MISSING_BLOCK_LABEL_133;
            }
            GLogger.w(WhisperUploadService.TAG, "Device not registered. Uploading aborted.", new Object[0]);
            if (isPaused())
            {
                GLogger.i(WhisperUploadService.TAG, "Upload is paused, keeping service alive...", new Object[0]);
            }
            setIsRunning(isPaused());
            stopServiceIfCompleted();
            return;
            setIsPaused(false);
            QueueType queuetype;
            SimpleUploadPermission simpleuploadpermission;
            for (Iterator iterator = queueTypes.iterator(); iterator.hasNext(); multiQueueUploader.onUploadScheduled(queuetype, simpleuploadpermission, s, cancelSignal))
            {
                queuetype = (QueueType)iterator.next();
                simpleuploadpermission = new SimpleUploadPermission();
                cancelSignal.set(false);
            }

            break MISSING_BLOCK_LABEL_285;
            Object obj;
            obj;
            GLogger.i(WhisperUploadService.TAG, "Account locked, disable uploading", new Object[0]);
            if (sharedPreferences != null)
            {
                sharedPreferences.edit().putBoolean("auto_upload_photos_key", false).apply();
                sharedPreferences.edit().putBoolean("auto_upload_videos_key", false).apply();
            }
_L1:
            if (queueTypes.contains(QueueType.AUTO_SAVE))
            {
                ((UploadNotificationHandler)ThorGalleryApplication.getBean(Keys.UPLOAD_NOTIFICATION_HANDLER)).removeForegroundService();
            }
            GLogger.d(WhisperUploadService.TAG, "Uploading complete.", new Object[0]);
            if (isPaused())
            {
                GLogger.i(WhisperUploadService.TAG, "Upload is paused, keeping service alive...", new Object[0]);
            }
            setIsRunning(isPaused());
            stopServiceIfCompleted();
            return;
            obj;
            GLogger.ex(WhisperUploadService.TAG, "Unexpected error encountered", ((Throwable) (obj)));
              goto _L1
            obj;
            if (isPaused())
            {
                GLogger.i(WhisperUploadService.TAG, "Upload is paused, keeping service alive...", new Object[0]);
            }
            setIsRunning(isPaused());
            stopServiceIfCompleted();
            throw obj;
        }

        public void setIsPaused(boolean flag)
        {
            paused.set(flag);
        }

        public void setIsRunning(boolean flag)
        {
            running.set(flag);
        }


        transient UploadRunnable(QueueType aqueuetype[])
        {
            this$0 = WhisperUploadService.this;
            super();
            int j = aqueuetype.length;
            for (int i = 0; i < j; i++)
            {
                whisperuploadservice = aqueuetype[i];
                queueTypes.add(WhisperUploadService.this);
            }

        }
    }


    private static final ThreadFactory AUTO_POOL_THREAD_FACTORY = new NamedThreadFactory("Upload_Auto");
    private static final ThreadFactory MANUAL_POOL_THREAD_FACTORY = new NamedThreadFactory("Upload_Manual");
    private static final String TAG = com/amazon/gallery/framework/network/watchdog/WhisperUploadService.getName();
    private volatile boolean allowAutoUpload;
    private AuthenticationManager authenticationManager;
    private Future autoFuture;
    private final Object autoFutureLock = new Object();
    private final UploadRunnable autoRunnable;
    private AutoSaveManager autoSaveManager;
    private final ScheduledThreadPoolExecutor autoUploadPool;
    private final ServiceBinder binder = new ServiceBinder();
    private boolean initialized;
    private final AtomicBoolean isQueuing = new AtomicBoolean(false);
    private Future manualFuture;
    private final Object manualFutureLock = new Object();
    private final UploadRunnable manualRunnable;
    private final ScheduledThreadPoolExecutor manualUploadPool;
    protected MediaItemDao mediaItemDao;
    private MultiQueueUploaderMessageHandler multiQueueMessageHandler;
    protected MultiQueueUploader multiQueueUploader;
    protected NetworkExecutor networkExecutor;
    protected NetworkConnectivity networkManager;
    private volatile boolean onlyWhenCharging;
    protected RestClient restClient;
    private Handler runOnUiThreadHandler;
    private SharedPreferences sharedPreferences;
    private android.content.SharedPreferences.OnSharedPreferenceChangeListener sharedPreferencesListener;
    private final Runnable stopSelfRunnable = new Runnable() {

        final WhisperUploadService this$0;

        public void run()
        {
            stopServiceIfCompleted();
        }

            
            {
                this$0 = WhisperUploadService.this;
                super();
            }
    };
    protected TagDao tagDao;
    private Executor uiReadyExecutor;
    private WhisperUploadManager uploadManager;
    private volatile boolean wanAllowed;

    public WhisperUploadService()
    {
        autoUploadPool = new ScheduledThreadPoolExecutor(1, AUTO_POOL_THREAD_FACTORY);
        autoRunnable = new UploadRunnable(new QueueType[] {
            QueueType.AUTO_SAVE, QueueType.FORCE_UPLOAD
        });
        manualUploadPool = new ScheduledThreadPoolExecutor(1, MANUAL_POOL_THREAD_FACTORY);
        manualRunnable = new UploadRunnable(new QueueType[] {
            QueueType.MANUAL
        });
        initialized = false;
        allowAutoUpload = false;
        wanAllowed = false;
        onlyWhenCharging = false;
        sharedPreferencesListener = new android.content.SharedPreferences.OnSharedPreferenceChangeListener() {

            final WhisperUploadService this$0;

            public void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
            {
                if (sharedpreferences != null)
                {
                    boolean flag = allowAutoUpload;
                    boolean flag1 = wanAllowed;
                    allowAutoUpload = WhisperUploadService.queryAutoUploadAllowed(getApplicationContext(), sharedpreferences);
                    wanAllowed = sharedpreferences.getBoolean("wan_allowed_key", false);
                    onlyWhenCharging = sharedpreferences.getBoolean("auto_upload_only_when_charging_key", false);
                    if (!flag && allowAutoUpload || !flag1 && wanAllowed)
                    {
                        submitAutoUpload(false);
                    }
                    multiQueueUploader.allowUpload(QueueType.AUTO_SAVE, allowAutoUpload);
                    if (!allowAutoUpload)
                    {
                        cancelUpload(QueueType.AUTO_SAVE);
                        return;
                    }
                }
            }

            
            {
                this$0 = WhisperUploadService.this;
                super();
            }
        };
    }

    private String getAmazonAccount()
    {
        return authenticationManager.getAccountId();
    }

    private boolean isNetworkAccessAllowed(UploadStrategy uploadstrategy)
    {
        com.amazon.gallery.framework.network.connectivity.NetworkConnectivity.NetworkOperationType networkoperationtype;
label0:
        {
            com.amazon.gallery.framework.network.connectivity.NetworkConnectivity.NetworkOperationType networkoperationtype1 = com.amazon.gallery.framework.network.connectivity.NetworkConnectivity.NetworkOperationType.WIFI_ONLY_UPLOAD;
            if (uploadstrategy == null || uploadstrategy != UploadStrategy.ALL)
            {
                networkoperationtype = networkoperationtype1;
                if (uploadstrategy != null)
                {
                    break label0;
                }
                networkoperationtype = networkoperationtype1;
                if (!wanAllowed)
                {
                    break label0;
                }
            }
            networkoperationtype = com.amazon.gallery.framework.network.connectivity.NetworkConnectivity.NetworkOperationType.MOBILE_UPLOAD;
        }
        return networkManager.isNetworkAccessAllowed(networkoperationtype);
    }

    private boolean isUploading()
    {
        boolean flag = false;
        boolean flag2 = manualRunnable.isRunning();
        boolean flag1 = autoRunnable.isRunning();
        boolean flag3 = isQueuing.get();
        GLogger.i(TAG, "isUploading check: [queuing: %s] [manual: %s] [auto: %s]", new Object[] {
            Boolean.valueOf(flag3), Boolean.valueOf(flag2), Boolean.valueOf(flag1)
        });
        if (flag3 || flag2 || flag1)
        {
            flag = true;
        }
        return flag;
    }

    private void killFutureUploads()
    {
        killAutoUploadFuture();
        killManualFuture();
    }

    private void lazyInitializeSharedPreferences()
    {
        if (sharedPreferences == null)
        {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            allowAutoUpload = queryAutoUploadAllowed(getApplicationContext(), sharedPreferences);
            wanAllowed = sharedPreferences.getBoolean("wan_allowed_key", false);
            onlyWhenCharging = sharedPreferences.getBoolean("auto_upload_only_when_charging_key", false);
            sharedPreferences.registerOnSharedPreferenceChangeListener(sharedPreferencesListener);
            multiQueueUploader.allowUpload(QueueType.AUTO_SAVE, allowAutoUpload);
        }
    }

    private static boolean queryAutoUploadAllowed(Context context, SharedPreferences sharedpreferences)
    {
        boolean flag1 = true;
        if (sharedpreferences == null)
        {
            return false;
        }
        boolean flag;
        if (sharedpreferences.getBoolean("auto_upload_photos_key", false) || sharedpreferences.getBoolean("auto_upload_videos_key", false))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag || !sharedpreferences.getBoolean("auto_upload_global_key", true))
        {
            flag1 = false;
        }
        return flag1;
    }

    private boolean queueAutoSaveItems()
    {
        Map map = autoSaveManager.getMediaItems();
        if (map.isEmpty())
        {
            return false;
        }
        Tag tag;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); multiQueueUploader.uploadMediaItems(((MediaItemCollection)map.get(tag)).getMediaItems(), QueueType.AUTO_SAVE, null))
        {
            tag = (Tag)iterator.next();
        }

        return true;
    }

    private int queueMediaItemsBySyncState(SyncState syncstate, QueueType queuetype)
    {
        syncstate = mediaItemDao.getItemsBySyncState(syncstate).getMediaItems();
        if (syncstate.isEmpty())
        {
            return 0;
        } else
        {
            multiQueueUploader.uploadMediaItems(syncstate, queuetype, null);
            return syncstate.size();
        }
    }

    private void restartManualUpload()
    {
        Object obj = manualFutureLock;
        obj;
        JVM INSTR monitorenter ;
        if (multiQueueUploader.isEmpty(QueueType.MANUAL)) goto _L2; else goto _L1
_L1:
        if (manualFuture == null || manualFuture.isDone()) goto _L4; else goto _L3
_L3:
        GLogger.w(TAG, "FutureManualUpload was not null on call to restart the manual upload.", new Object[0]);
_L2:
        return;
_L4:
        if (manualUploadPool.isShutdown())
        {
            break MISSING_BLOCK_LABEL_90;
        }
        manualFuture = manualUploadPool.submit(manualRunnable);
          goto _L2
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        GLogger.i(TAG, "Manual upload pool shutdown, discard runnable", new Object[0]);
          goto _L2
    }

    private void stopServiceIfCompleted()
    {
        if (!isUploading())
        {
            GLogger.i(TAG, "Stopping WhisperUploadService", new Object[0]);
            stopSelf();
        }
    }

    private void submitAutoUpload(final boolean resumeIfPaused)
    {
        autoRunnable.setIsRunning(true);
        uiReadyExecutor.execute(new Runnable() {

            final WhisperUploadService this$0;
            final boolean val$resumeIfPaused;

            public void run()
            {
label0:
                {
                    synchronized (autoFutureLock)
                    {
                        if (allowAutoUpload)
                        {
                            multiQueueUploader.refreshQueue(QueueType.AUTO_SAVE);
                            queueAutoSaveItems();
                        }
                        multiQueueUploader.clearQueue(QueueType.FORCE_UPLOAD);
                        queueMediaItemsBySyncState(SyncState.PENDING_EDITED, QueueType.FORCE_UPLOAD);
                        if (resumeIfPaused || !autoRunnable.isPaused())
                        {
                            break label0;
                        }
                        GLogger.i(WhisperUploadService.TAG, "Uploads paused.", new Object[0]);
                    }
                    return;
                }
                if (autoFuture == null || autoFuture.isDone())
                {
                    break MISSING_BLOCK_LABEL_152;
                }
                GLogger.i(WhisperUploadService.TAG, "Uploads already running.", new Object[0]);
                obj;
                JVM INSTR monitorexit ;
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
                if (autoUploadPool.isShutdown())
                {
                    break MISSING_BLOCK_LABEL_209;
                }
                autoFuture = autoUploadPool.schedule(autoRunnable, 0L, TimeUnit.SECONDS);
_L2:
                GLogger.i(WhisperUploadService.TAG, "Auto uploads started.", new Object[0]);
                obj;
                JVM INSTR monitorexit ;
                return;
                GLogger.i(WhisperUploadService.TAG, "Auto upload pool shutdown, discard runnable", new Object[0]);
                if (true) goto _L2; else goto _L1
_L1:
            }

            
            {
                this$0 = WhisperUploadService.this;
                resumeIfPaused = flag;
                super();
            }
        });
    }

    protected void cancelUpload(QueueType queuetype)
    {
        if (queuetype != QueueType.AUTO_SAVE) goto _L2; else goto _L1
_L1:
        autoRunnable.setIsRunning(false);
        killAutoUploadFuture();
_L4:
        GLogger.i(TAG, "Upload canceled for queue %s", new Object[] {
            queuetype
        });
        stopServiceIfCompleted();
        return;
_L2:
        if (queuetype == QueueType.MANUAL)
        {
            isQueuing.set(false);
            manualRunnable.setIsRunning(false);
            killManualFuture();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void init()
    {
        networkExecutor = NetworkExecutor.getInstance();
        restClient = (RestClient)ThorGalleryApplication.getBean(Keys.REST_CLIENT);
        networkManager = (NetworkConnectivity)ThorGalleryApplication.getBean(Keys.NETWORK_CONNECTIVITY);
        mediaItemDao = (MediaItemDao)ThorGalleryApplication.getBean(Keys.MEDIA_ITEM_DAO);
        tagDao = (TagDao)ThorGalleryApplication.getBean(Keys.TAG_DAO);
        authenticationManager = (AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER);
        autoSaveManager = (AutoSaveManager)ThorGalleryApplication.getBean(Keys.AUTO_SAVE_MANAGER);
        uiReadyExecutor = (Executor)ThorGalleryApplication.getBean(Keys.UI_READY_EXECUTOR);
        multiQueueUploader = (MultiQueueUploader)ThorGalleryApplication.getBean(Keys.MULTI_QUEUE_UPLOADER);
        multiQueueMessageHandler = (MultiQueueUploaderMessageHandler)ThorGalleryApplication.getBean(Keys.MULTI_QUEUE_MESSAGE_HANDLER);
        multiQueueMessageHandler.setImmediateTriggerListener(new ImmediateTriggerListener() {

            final WhisperUploadService this$0;

            public void onTrigger(QueueType queuetype, boolean flag)
            {
                _cls5..SwitchMap.com.amazon.gallery.framework.network.multiqueueuploader.QueueType[queuetype.ordinal()];
                JVM INSTR tableswitch 1 3: default 36
            //                           1 66
            //                           2 90
            //                           3 90;
                   goto _L1 _L2 _L3 _L3
_L1:
                throw new IllegalArgumentException((new StringBuilder()).append(queuetype.name()).append(" is not a recognized QueueType.").toString());
_L2:
                restartManualUpload();
_L5:
                GLogger.d(WhisperUploadService.TAG, "onTrigger invoked for queue: %s.", new Object[] {
                    queuetype
                });
                return;
_L3:
                submitAutoUpload(flag);
                if (true) goto _L5; else goto _L4
_L4:
            }

            
            {
                this$0 = WhisperUploadService.this;
                super();
            }
        });
        uploadManager = (WhisperUploadManager)ThorGalleryApplication.getBean(Keys.WHISPER_UPLOAD_MANAGER);
        initialized = true;
        GLogger.d(TAG, "Initialization complete.", new Object[0]);
    }

    protected void killAutoUploadFuture()
    {
        autoRunnable.cancel();
        synchronized (autoFutureLock)
        {
            if (autoFuture != null)
            {
                autoFuture.cancel(true);
                autoFuture = null;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void killManualFuture()
    {
        manualRunnable.cancel();
        synchronized (manualFutureLock)
        {
            if (manualFuture != null)
            {
                manualFuture.cancel(true);
                manualFuture = null;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public IBinder onBind(Intent intent)
    {
        GLogger.v(TAG, "WhisperUploadService#onBind(Intent) invoked", new Object[0]);
        return binder;
    }

    public void onCreate()
    {
        super.onCreate();
        GLogger.d(TAG, "onCreate", new Object[0]);
        init();
        UploadNotificationHandler uploadnotificationhandler = (UploadNotificationHandler)ThorGalleryApplication.getBean(Keys.UPLOAD_NOTIFICATION_HANDLER);
        uploadnotificationhandler.createManualNotification();
        uploadnotificationhandler.createAutoSaveNotification();
        GlobalMessagingBus.register(this);
        runOnUiThreadHandler = new Handler();
    }

    public void onDestroy()
    {
        GLogger.d(TAG, "onDestroy called.", new Object[0]);
        if (sharedPreferences != null)
        {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(sharedPreferencesListener);
            sharedPreferences = null;
        }
        killFutureUploads();
        multiQueueMessageHandler.setImmediateTriggerListener(null);
        GlobalMessagingBus.unregister(this);
        autoUploadPool.shutdownNow();
        manualUploadPool.shutdownNow();
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        GLogger.d(TAG, "WhisperUploadService#onStartCommand(Intent, int, int) invoked", new Object[0]);
        GLogger.i(TAG, "Service started from source: [%s]", new Object[] {
            intent.getStringExtra("start_source")
        });
        super.onStartCommand(intent, i, j);
        ((UploadNotificationHandler)ThorGalleryApplication.getBean(Keys.UPLOAD_NOTIFICATION_HANDLER)).setForegroundService(this);
        lazyInitializeSharedPreferences();
        UploadStrategy uploadstrategy;
        if (intent.hasExtra("upload_strategy"))
        {
            uploadstrategy = (UploadStrategy)intent.getSerializableExtra("upload_strategy");
        } else
        {
            uploadstrategy = UploadStrategy.WIFI_ONLY;
        }
        if (intent.getBooleanExtra("requeue_manual", true) && !manualRunnable.isRunning())
        {
            isQueuing.set(true);
            uiReadyExecutor.execute(new RequeueUploadTask(mediaItemDao, uploadstrategy, isQueuing, stopSelfRunnable, runOnUiThreadHandler));
        }
        submitAutoUpload(intent.getBooleanExtra("resume_if_paused", false));
        return 2;
    }

    public void onTaskRemoved(Intent intent)
    {
        super.onTaskRemoved(intent);
        GLogger.d(TAG, "onTaskRemoved", new Object[0]);
        intent = (UploadNotificationHandler)ThorGalleryApplication.getBean(Keys.UPLOAD_NOTIFICATION_HANDLER);
        intent.clearNotification(QueueType.AUTO_SAVE);
        intent.clearNotification(QueueType.MANUAL);
    }

    public boolean onUnbind(Intent intent)
    {
        GLogger.v(TAG, "WhisperUploadService#onUnbind(Intent) invoked", new Object[0]);
        super.onUnbind(intent);
        return true;
    }

    public void onUploadActionEvent(UploadActionEvent uploadactionevent)
    {
        _cls5..SwitchMap.com.amazon.gallery.framework.network.multiqueueuploader.UploadControlAction[uploadactionevent.getAction().ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 33
    //                   2 42;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        cancelUpload(uploadactionevent.getQueueType());
        return;
_L3:
        if (uploadactionevent.getQueueType() == QueueType.AUTO_SAVE)
        {
            autoRunnable.setIsPaused(true);
            killAutoUploadFuture();
            return;
        }
        if (uploadactionevent.getQueueType() == QueueType.MANUAL)
        {
            manualRunnable.setIsPaused(true);
            killManualFuture();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }




/*
    static boolean access$002(WhisperUploadService whisperuploadservice, boolean flag)
    {
        whisperuploadservice.allowAutoUpload = flag;
        return flag;
    }

*/




/*
    static boolean access$102(WhisperUploadService whisperuploadservice, boolean flag)
    {
        whisperuploadservice.wanAllowed = flag;
        return flag;
    }

*/



/*
    static Future access$1102(WhisperUploadService whisperuploadservice, Future future)
    {
        whisperuploadservice.autoFuture = future;
        return future;
    }

*/










/*
    static boolean access$302(WhisperUploadService whisperuploadservice, boolean flag)
    {
        whisperuploadservice.onlyWhenCharging = flag;
        return flag;
    }

*/






}
