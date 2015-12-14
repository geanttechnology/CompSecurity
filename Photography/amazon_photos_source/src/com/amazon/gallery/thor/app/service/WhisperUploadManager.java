// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.service;

import android.content.Context;
import android.os.AsyncTask;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.account.AccountChangeListener;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaTagPropertyObserver;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.syncframework.WhisperUploadSyncScheduler;
import com.amazon.gallery.thor.syncframework.WhisperUploadSyncSchedulerWrapper;
import com.google.common.base.Joiner;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.thor.app.service:
//            WhisperUploadDeviceStateMonitor

public class WhisperUploadManager
    implements AccountChangeListener
{
    private class MediaTagPropertyObserverImpl
        implements MediaTagPropertyObserver
    {

        final WhisperUploadManager this$0;

        public void onMediaItemCollectionChanged(final TagProperty property, ChangeList changelist)
        {
            if (property == TagProperty.AUTO_SAVE || property == TagProperty.CLOUD || property == TagProperty.LOCAL)
            {
                (changelist. new AsyncTask() {

                    final MediaTagPropertyObserverImpl this$1;
                    final ChangeList val$changeList;
                    final TagProperty val$property;

                    protected volatile Object doInBackground(Object aobj[])
                    {
                        return doInBackground((Void[])aobj);
                    }

                    protected transient Void doInBackground(Void avoid[])
                    {
                        if (property == TagProperty.AUTO_SAVE || property == TagProperty.CLOUD)
                        {
                            avoid = changeList.getChangeListForType(com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.ADDED);
                        } else
                        {
                            avoid = changeList.getChangeListForType(com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED);
                        }
                        if (property == TagProperty.AUTO_SAVE)
                        {
                            if (avoid.size() > 0)
                            {
                                syncNow();
                            }
                        } else
                        {
                            avoid = avoid.iterator();
                            while (avoid.hasNext()) 
                            {
                                if (((MediaItem)avoid.next()).getSyncState() == SyncState.PENDING_EDITED)
                                {
                                    syncNow();
                                    return null;
                                }
                            }
                        }
                        return null;
                    }

            
            {
                this$1 = final_mediatagpropertyobserverimpl;
                property = tagproperty;
                changeList = ChangeList.this;
                super();
            }
                }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }

        private MediaTagPropertyObserverImpl()
        {
            this$0 = WhisperUploadManager.this;
            super();
        }

    }


    public static final TimeUnit POLL_INTERVAL_UNIT;
    private static final String TAG = com/amazon/gallery/thor/app/service/WhisperUploadManager.getName();
    private final Context context;
    private WhisperUploadDeviceStateMonitor deviceStateMonitor;
    private AtomicBoolean foregroundUpload;
    private MediaTagPropertyObserverImpl mediaTagPropertyObserver;
    private AtomicBoolean syncInitialized;
    private WhisperUploadSyncScheduler syncScheduler;

    public WhisperUploadManager(Context context1)
    {
        syncInitialized = new AtomicBoolean(false);
        foregroundUpload = new AtomicBoolean(false);
        context = context1;
        initSyncScheduler();
    }

    private void initSyncScheduler()
    {
        Object obj = (AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER);
        if (obj == null)
        {
            GLogger.i(TAG, "Cannot schedule whisper upload syncs. No user manager.", new Object[0]);
        } else
        {
            obj = ((AuthenticationManager) (obj)).getAccountId();
            if (obj == null)
            {
                GLogger.i(TAG, "Cannot schedule whisper upload sync. No account.", new Object[0]);
                return;
            }
            if (!syncInitialized.getAndSet(true))
            {
                syncScheduler = new WhisperUploadSyncSchedulerWrapper(context, ((String) (obj)));
                deviceStateMonitor = new WhisperUploadDeviceStateMonitor(context, syncScheduler);
                mediaTagPropertyObserver = new MediaTagPropertyObserverImpl();
                obj = (MediaItemDao)ThorGalleryApplication.getBean(Keys.MEDIA_ITEM_DAO);
                ((MediaItemDao) (obj)).registerObserverByTagProperty(mediaTagPropertyObserver, TagProperty.AUTO_SAVE);
                ((MediaItemDao) (obj)).registerObserverByTagProperty(mediaTagPropertyObserver, TagProperty.CLOUD);
                ((MediaItemDao) (obj)).registerObserverByTagProperty(mediaTagPropertyObserver, TagProperty.LOCAL);
                deviceStateMonitor.registerReceivers();
                return;
            }
        }
    }

    private void syncNow()
    {
        if (syncInitialized.get())
        {
            syncScheduler.syncNow(context, TAG);
        }
    }

    private void uninitSyncScheduler()
    {
        if (syncInitialized.getAndSet(false))
        {
            MediaItemDao mediaitemdao = (MediaItemDao)ThorGalleryApplication.getBean(Keys.MEDIA_ITEM_DAO);
            mediaitemdao.unregisterObserver(mediaTagPropertyObserver, TagProperty.AUTO_SAVE);
            mediaitemdao.unregisterObserver(mediaTagPropertyObserver, TagProperty.CLOUD);
            mediaitemdao.unregisterObserver(mediaTagPropertyObserver, TagProperty.LOCAL);
            mediaTagPropertyObserver = null;
            deviceStateMonitor.unregisterReceivers();
            deviceStateMonitor = null;
            syncScheduler = null;
        }
    }

    public WhisperUploadDeviceStateMonitor getDeviceStateMonitor()
    {
        return deviceStateMonitor;
    }

    public boolean isForegroundUpload()
    {
        return foregroundUpload.get();
    }

    public void onAccountDeregistered()
    {
        stopScheduledSyncs();
        uninitSyncScheduler();
    }

    public void onAccountRegistered()
    {
        scheduleForegroundSync(true, Joiner.on(".").join(TAG, "onAccountRegistered", new Object[0]));
        initSyncScheduler();
    }

    public void scheduleBackgroundSync()
    {
        foregroundUpload.set(false);
        if (syncInitialized.get())
        {
            syncScheduler.scheduleBackgroundSync(context, 60L, POLL_INTERVAL_UNIT);
        }
    }

    public void scheduleForegroundSync(boolean flag, String s)
    {
        foregroundUpload.set(true);
        if (syncInitialized.get())
        {
            deviceStateMonitor.updateUploadInterval(flag, s);
        }
    }

    protected void stopScheduledSyncs()
    {
        if (syncInitialized.get())
        {
            syncScheduler.stopScheduledSyncs(context);
        }
    }

    static 
    {
        POLL_INTERVAL_UNIT = TimeUnit.MINUTES;
    }

}
