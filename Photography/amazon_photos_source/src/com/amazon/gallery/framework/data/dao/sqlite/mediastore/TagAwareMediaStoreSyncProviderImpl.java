// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.SystemClock;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.thread.NamedThreadFactory;
import com.amazon.gallery.framework.data.TruthDataMigrationUtilities;
import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.tag.TagDaoChangeList;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.metrics.customer.CustomerMetricsHelper;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.ui.UiReadyExecutor;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediastore:
//            AbstractMediaStoreSyncProvider, MediaStoreHelper, LocalStateDao, MediaStoreSyncProvider

public class TagAwareMediaStoreSyncProviderImpl extends AbstractMediaStoreSyncProvider
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent AddLocalFile;
        public static final MetricsEvent PhotoSideloaded;
        public static final MetricsEvent ScreenshotCaptured;
        public static final MetricsEvent VideoSideloaded;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/data/dao/sqlite/mediastore/TagAwareMediaStoreSyncProviderImpl$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            PhotoSideloaded = new MetricsEvent("PhotoSideloaded", 0);
            VideoSideloaded = new MetricsEvent("VideoSideloaded", 1);
            ScreenshotCaptured = new MetricsEvent("ScreenshotCaptured", 2);
            AddLocalFile = new MetricsEvent("AddLocalFile", 3);
            $VALUES = (new MetricsEvent[] {
                PhotoSideloaded, VideoSideloaded, ScreenshotCaptured, AddLocalFile
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }

    private static class ReconcileRestartException extends Exception
    {

        private ReconcileRestartException()
        {
        }

    }

    private class SyncRunnable
        implements Runnable
    {

        private final CountDownLatch countDownLatch = null;
        private final boolean notify;
        private final boolean reconcileAllowed;
        final TagAwareMediaStoreSyncProviderImpl this$0;

        public void run()
        {
            boolean flag;
            int i;
            flag = false;
            i = 3;
_L2:
            int j;
            j = i - 1;
            if (i <= 0 || flag)
            {
                break; /* Loop/switch isn't completed */
            }
            syncLock.lock();
            TruthDataMigrationUtilities truthdatamigrationutilities;
            sync(reconcileAllowed, notify);
            recordSyncTime();
            logMetrics = true;
            truthdatamigrationutilities = (TruthDataMigrationUtilities)((BeanAwareApplication)context.getApplicationContext()).getBeanFactory().getBean(Keys.TRUTH_MIGRATION_UTILS);
            if (truthdatamigrationutilities == null)
            {
                break MISSING_BLOCK_LABEL_92;
            }
            truthdatamigrationutilities.startTruthUploadQueueMigration();
            flag = true;
            syncLock.unlock();
_L3:
            i = j;
            if (true) goto _L2; else goto _L1
            Object obj;
            obj;
            GLogger.ex(TagAwareMediaStoreSyncProviderImpl.TAG, (new StringBuilder()).append("Can't complete media store sync. Retry. ").append(j).append(" attempts left.").toString(), ((Throwable) (obj)));
            syncLock.unlock();
              goto _L3
            obj;
            syncLock.unlock();
            throw obj;
_L1:
            if (countDownLatch != null)
            {
                countDownLatch.countDown();
            }
            return;
        }

        public SyncRunnable(boolean flag, boolean flag1)
        {
            this$0 = TagAwareMediaStoreSyncProviderImpl.this;
            super();
            reconcileAllowed = flag;
            notify = flag1;
        }
    }


    private static final String SCREENSHOT_DIR;
    public static final ExecutorService SERIAL_EXECUTOR = Executors.newSingleThreadExecutor(new NamedThreadFactory(com/amazon/gallery/framework/data/dao/sqlite/mediastore/TagAwareMediaStoreSyncProviderImpl.getSimpleName(), 5, true));
    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/mediastore/TagAwareMediaStoreSyncProviderImpl.getName();
    private final Context context;
    private boolean logMetrics;
    private ComponentProfiler profiler;
    private SharedPreferences sharedPreferences;
    private final Set syncCompletedListeners = new CopyOnWriteArraySet();
    private final ReentrantLock syncLock = new ReentrantLock(true);
    private final AtomicInteger threadsSyncingSynchronously = new AtomicInteger(0);

    public TagAwareMediaStoreSyncProviderImpl(Context context1)
    {
        logMetrics = true;
        context = context1;
    }

    private void calculateNewContentTimestamp(Collection collection)
    {
        long l = sharedPreferences.getLong("new_content_timestamp_key", 0L);
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            MediaItem mediaitem = (MediaItem)collection.next();
            if (mediaitem.getDateAddedMs() > l)
            {
                l = mediaitem.getDateAddedMs();
            }
        } while (true);
        sharedPreferences.edit().putLong("new_content_timestamp_key", l).apply();
    }

    private void checkRestartFlag()
        throws ReconcileRestartException
    {
        if (restart)
        {
            throw new ReconcileRestartException();
        } else
        {
            return;
        }
    }

    private void doReconcile(boolean flag)
        throws ReconcileRestartException
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        ArrayList arraylist2;
        ArrayList arraylist3;
        Object obj;
        int i;
        GLogger.logCustomerEvent("MediaStore reconciliation is started", new Object[0]);
        lastReconcileTime = SystemClock.uptimeMillis();
        obj = mediaStoreHelper.getAllContent();
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        arraylist2 = new ArrayList();
        arraylist3 = new ArrayList();
        i = 0;
        obj = ((Map) (obj)).entrySet().iterator();
_L6:
        Tag tag;
        Object obj1;
        int j;
        boolean flag1;
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
        flag1 = false;
        checkRestartFlag();
        tag = (Tag)((java.util.Map.Entry) (obj1)).getKey();
        obj1 = (List)((java.util.Map.Entry) (obj1)).getValue();
        j = i + ((List) (obj1)).size();
        if (!((List) (obj1)).isEmpty()) goto _L2; else goto _L1
_L1:
        arraylist3.add(tag);
        i = 1;
_L4:
        ArrayList arraylist4 = new ArrayList(mediaItemDao.getItemsByTag(tag).getMediaItems());
        Collection collection = subtract(arraylist4, ((Collection) (obj1)));
        long l = System.currentTimeMillis();
        if (!collection.isEmpty())
        {
            arraylist1.addAll(collection);
            tag.setDateCreatedMs(l);
            if (i == 0)
            {
                arraylist2.add(tag);
            }
        }
        obj1 = subtract(((Collection) (obj1)), arraylist4);
        i = j;
        if (!((Collection) (obj1)).isEmpty())
        {
            arraylist.addAll(((Collection) (obj1)));
            tag.setDateCreatedMs(l);
            arraylist2.add(tag);
            i = j;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        i = ((flag1) ? 1 : 0);
        if (tag.isPersisted()) goto _L4; else goto _L3
_L3:
        arraylist2.add(tag);
        arraylist.addAll(((Collection) (obj1)));
        i = j;
        if (true) goto _L6; else goto _L5
_L5:
        if (logMetrics)
        {
            logNewMediaItems(arraylist);
        }
        if (sharedPreferences != null)
        {
            calculateNewContentTimestamp(arraylist);
        }
        if (!arraylist1.isEmpty())
        {
            mediaItemDao.deleteLocalFields(arraylist1, true, true);
            GLogger.logCustomerEvent("MediaStore sync deleted %d media items", new Object[] {
                Integer.valueOf(arraylist1.size())
            });
        }
        if (!arraylist3.isEmpty())
        {
            checkRestartFlag();
            tagDao.delete(arraylist3, true);
        }
        if (!arraylist2.isEmpty())
        {
            checkRestartFlag();
            tagDao.save(arraylist2, true);
        }
        if (!arraylist.isEmpty())
        {
            checkRestartFlag();
            filterNewItemsFromCallbacks(arraylist);
            mediaItemDao.saveLocalFields(arraylist, flag);
        }
        if (!arraylist2.isEmpty())
        {
            checkRestartFlag();
            updateSortDate(arraylist2);
        }
        GLogger.logCustomerEvent("MediaStore reconciliation is completed for %d media items", new Object[] {
            Integer.valueOf(i)
        });
        return;
    }

    private void filterNewItemsFromCallbacks(Collection collection)
    {
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            if (callAndRemoveOnOffScanListener((MediaItem)collection.next()))
            {
                collection.remove();
            }
        } while (true);
    }

    private void logNewMediaItems(Collection collection)
    {
        int i;
        int j;
        int k;
        int l;
        l = 0;
        i = 0;
        k = 0;
        j = 0;
        collection = collection.iterator();
_L7:
        MediaItem mediaitem;
        if (!collection.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        mediaitem = (MediaItem)collection.next();
        if (mediaitem.getLocalPath() == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (mediaitem.hasProperty(CommonMediaProperty.CAMERA)) goto _L2; else goto _L1
_L1:
        static class _cls3
        {

            static final int $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$model$media$MediaType = new int[MediaType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.PHOTO.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.VIDEO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3..SwitchMap.com.amazon.gallery.framework.model.media.MediaType[mediaitem.getType().ordinal()];
        JVM INSTR tableswitch 1 2: default 92
    //                   1 109
    //                   2 162;
           goto _L3 _L4 _L5
_L3:
        profiler.trackEvent(MetricsEvent.AddLocalFile, CustomerMetricsHelper.getExtra(mediaitem));
        continue; /* Loop/switch isn't completed */
_L4:
        if (mediaitem.getLocalPath().contains(SCREENSHOT_DIR))
        {
            j++;
            profiler.trackEvent(MetricsEvent.ScreenshotCaptured);
        } else
        {
            l++;
            profiler.trackEvent(MetricsEvent.PhotoSideloaded);
        }
        continue; /* Loop/switch isn't completed */
_L5:
        i++;
        profiler.trackEvent(MetricsEvent.VideoSideloaded);
        if (true) goto _L3; else goto _L2
_L2:
        k++;
        if (true) goto _L7; else goto _L6
_L6:
        GLogger.logCustomerEvent("MediaStore: new local content is (photo,%d), (video,%d), (camera,%d), (screenshot,%d)", new Object[] {
            Integer.valueOf(l), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j)
        });
        logMetrics = false;
        return;
    }

    private void reconcile(boolean flag)
    {
        do
        {
            try
            {
                restart = false;
                doReconcile(flag);
            }
            catch (ReconcileRestartException reconcilerestartexception) { }
        } while (restart);
    }

    private void recordSyncTime()
    {
        sharedPreferences.edit().putLong("last_media_store_sync", System.currentTimeMillis()).apply();
    }

    private static Collection subtract(Collection collection, Collection collection1)
    {
        HashMap hashmap = new HashMap();
        for (collection = collection.iterator(); collection.hasNext();)
        {
            MediaItem mediaitem = (MediaItem)collection.next();
            if (mediaitem.getLocalPath() == null)
            {
                GLogger.e(TAG, (new StringBuilder()).append("MediaItem ").append(mediaitem.getObjectId()).append(" had no localPath").toString(), new Object[0]);
            } else
            {
                hashmap.put(mediaitem.getLocalPath(), mediaitem);
            }
        }

        for (collection = collection1.iterator(); collection.hasNext();)
        {
            collection1 = (MediaItem)collection.next();
            if (collection1.getLocalPath() == null)
            {
                GLogger.e(TAG, (new StringBuilder()).append("MediaItem ").append(collection1.getObjectId()).append(" had no localPath").toString(), new Object[0]);
            } else
            {
                hashmap.remove(collection1.getLocalPath());
            }
        }

        return hashmap.values();
    }

    private void sync(boolean flag, boolean flag1)
    {
        if (flag && SystemClock.uptimeMillis() - lastReconcileTime > (long)RECONCILE_THRESHOLD)
        {
            reconcile(flag1);
        } else
        {
            GLogger.logCustomerEvent("MediaStore incremental sync is started", new Object[0]);
            long l = Long.valueOf(localStateDao.getValue("mediaStoreLastSyncTime", "0")).longValue();
            long l1 = System.currentTimeMillis();
            Object obj = mediaStoreHelper.getNewContent(l);
            ArrayList arraylist = new ArrayList();
            HashSet hashset = new HashSet();
            java.util.Map.Entry entry;
            for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); arraylist.addAll((Collection)entry.getValue()))
            {
                entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                Tag tag = (Tag)entry.getKey();
                if (!tag.isPersisted())
                {
                    hashset.add(tag);
                }
            }

            if (!arraylist.isEmpty())
            {
                if (!hashset.isEmpty())
                {
                    tagDao.save(hashset, flag1);
                }
                if (logMetrics)
                {
                    logNewMediaItems(arraylist);
                }
                if (sharedPreferences != null)
                {
                    calculateNewContentTimestamp(arraylist);
                }
                for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); hashset.addAll(((MediaItem)iterator.next()).getTags())) { }
                filterNewItemsFromCallbacks(arraylist);
                mediaItemDao.saveLocalFields(arraylist, flag1);
                updateSortDate(hashset);
                localStateDao.setValue("mediaStoreLastSyncTime", Long.toString(l1));
            } else
            {
                GLogger.logCustomerEvent("MediaStore: no new local content is discovered during media store sync", new Object[0]);
            }
            GLogger.logCustomerEvent("MediaStore incremental sync is completed", new Object[0]);
            if (flag)
            {
                MediaItemCollection mediaitemcollection = mediaItemDao.getItemsByProperty(CommonMediaProperty.LOCAL, new SortOrder("id"));
                if (mediaStoreHelper.getMediaStoreItemCount() != mediaitemcollection.getMediaItems().size())
                {
                    lastReconcileTime = -1L;
                    syncMediaStoreAsync(flag1);
                    return;
                }
            }
        }
    }

    private void updateSortDate(Collection collection)
    {
        TagDaoChangeList tagdaochangelist = new TagDaoChangeList();
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            Tag tag = (Tag)collection.next();
            List list = mediaItemDao.getItemsByTag(tag).getMediaItems();
            if (tagDao.updateSortDateForTag(tag, list, false, true))
            {
                tagdaochangelist.addContentsOf(tag, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED);
            }
        } while (true);
        tagDao.notify(tagdaochangelist);
    }

    public void addSyncCompletedListener(MediaStoreSyncProvider.SyncCompletedListener synccompletedlistener)
    {
        syncCompletedListeners.add(synccompletedlistener);
    }

    protected Runnable getPostExecuteRunnable()
    {
        return new Runnable() {

            final TagAwareMediaStoreSyncProviderImpl this$0;

            public void run()
            {
                if (executor.getActiveCount() + threadsSyncingSynchronously.get() <= 1)
                {
                    for (Iterator iterator = syncCompletedListeners.iterator(); iterator.hasNext(); ((MediaStoreSyncProvider.SyncCompletedListener)iterator.next()).onSyncCompleted()) { }
                }
            }

            
            {
                this$0 = TagAwareMediaStoreSyncProviderImpl.this;
                super();
            }
        };
    }

    public boolean isCurrentlySyncing()
    {
        return executor.getActiveCount() > 0 || threadsSyncingSynchronously.get() > 0;
    }

    public void removeSyncCompletedListener(MediaStoreSyncProvider.SyncCompletedListener synccompletedlistener)
    {
        syncCompletedListeners.remove(synccompletedlistener);
    }

    public void setProfiler(Profiler profiler1)
    {
        profiler = new ComponentProfiler(profiler1, com/amazon/gallery/framework/data/dao/sqlite/mediastore/MediaStoreSyncProvider);
    }

    public void setSharedPreferences(SharedPreferences sharedpreferences)
    {
        sharedPreferences = sharedpreferences;
    }

    public void syncMediaStore()
    {
        syncMediaStore(true);
    }

    public void syncMediaStore(boolean flag)
    {
        syncMediaStore(flag, true);
    }

    public void syncMediaStore(boolean flag, boolean flag1)
    {
        GLogger.v(TAG, "Running synchronously with reconcileAllowed: %b, notify: %b", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(flag1)
        });
        threadsSyncingSynchronously.incrementAndGet();
        (new SyncRunnable(flag, flag1)).run();
        getPostExecuteRunnable().run();
        threadsSyncingSynchronously.decrementAndGet();
        return;
        Exception exception;
        exception;
        getPostExecuteRunnable().run();
        threadsSyncingSynchronously.decrementAndGet();
        throw exception;
    }

    public void syncMediaStoreAsync()
    {
        syncMediaStoreAsync(true);
    }

    public void syncMediaStoreAsync(final boolean reconcileAllowed)
    {
        ((UiReadyExecutor)ThorGalleryApplication.getBean(Keys.UI_READY_EXECUTOR)).execute(new Runnable() {

            final TagAwareMediaStoreSyncProviderImpl this$0;
            final boolean val$reconcileAllowed;

            public void run()
            {
                try
                {
                    GLogger.v(TagAwareMediaStoreSyncProviderImpl.TAG, (new StringBuilder()).append("Running asynchronously with reconcileAllowed: ").append(reconcileAllowed).toString(), new Object[0]);
                    executor.execute(new SyncRunnable(reconcileAllowed, true));
                    return;
                }
                catch (RejectedExecutionException rejectedexecutionexception)
                {
                    GLogger.d(TagAwareMediaStoreSyncProviderImpl.TAG, "Duplicate Request. Request already pending execution", new Object[0]);
                }
            }

            
            {
                this$0 = TagAwareMediaStoreSyncProviderImpl.this;
                reconcileAllowed = flag;
                super();
            }
        });
    }

    static 
    {
        SCREENSHOT_DIR = (new StringBuilder()).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString()).append("/Screenshots").toString();
    }






/*
    static boolean access$502(TagAwareMediaStoreSyncProviderImpl tagawaremediastoresyncproviderimpl, boolean flag)
    {
        tagawaremediastoresyncproviderimpl.logMetrics = flag;
        return flag;
    }

*/



}
