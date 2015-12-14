// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.metrics.customer.CustomerMetricsHelper;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.network.exceptions.AccountLockedException;
import com.amazon.gallery.framework.network.exceptions.CloudStorageLimitException;
import com.amazon.gallery.framework.network.exceptions.NoStorageInfoAvailableException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            MultiQueueUploader, UploadStatus, UploadBatch, GalleryUploader, 
//            UploadResult, QueueType, UploadListener, UploadError, 
//            UploadPermission, UploadBatchFactory, UploadStrategy, UploadProgressCallback

public class MultiQueueUploaderImpl
    implements MultiQueueUploader
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent AutoSaveEditedFile;
        public static final MetricsEvent AutoSaveFile;
        public static final MetricsEvent AutoSaveFreeTime;
        public static final MetricsEvent UploadFile;
        public static final MetricsEvent UploadFreeTimeFile;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/network/multiqueueuploader/MultiQueueUploaderImpl$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            AutoSaveFile = new MetricsEvent("AutoSaveFile", 0);
            AutoSaveEditedFile = new MetricsEvent("AutoSaveEditedFile", 1);
            AutoSaveFreeTime = new MetricsEvent("AutoSaveFreeTime", 2);
            UploadFile = new MetricsEvent("UploadFile", 3);
            UploadFreeTimeFile = new MetricsEvent("UploadFreeTimeFile", 4);
            $VALUES = (new MetricsEvent[] {
                AutoSaveFile, AutoSaveEditedFile, AutoSaveFreeTime, UploadFile, UploadFreeTimeFile
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/framework/network/multiqueueuploader/MultiQueueUploader.getName();
    private final AtomicBoolean autoProcessing = new AtomicBoolean(false);
    private final Queue autoSaveQueue = new ConcurrentLinkedQueue();
    private final UploadStatus autoSaveStatus = new UploadStatus();
    private final UploadStatus forceSaveStatus = new UploadStatus();
    private final Queue forceUploadQueue = new ConcurrentLinkedQueue();
    private final GalleryUploader galleryUploader;
    private final SharedPreferences kindlePreferences;
    private final List listeners = new CopyOnWriteArrayList();
    private final AtomicBoolean manualProcessing = new AtomicBoolean(true);
    private final Queue manualQueue = new ConcurrentLinkedQueue();
    private final UploadStatus manualSaveStatus = new UploadStatus();
    private final MediaItemDao mediaItemDao;
    private ComponentProfiler profiler;

    public MultiQueueUploaderImpl(Context context, MediaItemDao mediaitemdao, GalleryUploader galleryuploader, Profiler profiler1)
    {
        mediaItemDao = mediaitemdao;
        galleryUploader = galleryuploader;
        profiler = new ComponentProfiler(profiler1, com/amazon/gallery/framework/network/multiqueueuploader/MultiQueueUploader);
        kindlePreferences = context.getSharedPreferences("galleryKindleSharedPrefs", 0);
    }

    private void addToQueue(Queue queue, UploadBatch uploadbatch, boolean flag)
    {
        if (flag)
        {
            queue.add(uploadbatch);
        } else
        if (!uploadbatch.getMediaItems().isEmpty())
        {
            resetSyncState(uploadbatch);
            return;
        }
    }

    private boolean doUpload(final MediaItem mediaItem, final QueueType queueType, boolean flag, UploadBatchFactory.UploadBatchType uploadbatchtype)
        throws AccountLockedException, CloudStorageLimitException
    {
        notifyProgress(mediaItem, queueType, 0, 100);
        Object obj;
        obj = new UploadProgressCallback() {

            final MultiQueueUploaderImpl this$0;
            final MediaItem val$mediaItem;
            final QueueType val$queueType;

            public void onUploadProgressChanged(int i, int j)
            {
                i = (int)(((double)i / (double)j) * 100D);
                notifyProgress(mediaItem, queueType, i, 100);
            }

            
            {
                this$0 = MultiQueueUploaderImpl.this;
                mediaItem = mediaitem;
                queueType = queuetype;
                super();
            }
        };
        obj = galleryUploader.uploadMediaItem(mediaItem, ((UploadProgressCallback) (obj)));
label0:
        {
            if (Thread.currentThread().isInterrupted())
            {
                return false;
            }
            try
            {
                if (((UploadResult) (obj)).status != UploadResult.Status.SUCCESSFUL)
                {
                    break label0;
                }
                notifySuccessful(mediaItem, queueType, uploadbatchtype);
                logUploadMetric(queueType, mediaItem);
            }
            catch (AccountLockedException accountlockedexception)
            {
                notifyFailed(mediaItem, queueType, accountlockedexception, uploadbatchtype);
                saveErrorSyncState(mediaItem, queueType);
                throw accountlockedexception;
            }
            catch (CloudStorageLimitException cloudstoragelimitexception)
            {
                notifyFailed(mediaItem, queueType, cloudstoragelimitexception, uploadbatchtype);
                saveErrorSyncState(mediaItem, queueType);
                throw cloudstoragelimitexception;
            }
            return true;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        notifyFailed(mediaItem, queueType, ((UploadResult) (obj)).reason, uploadbatchtype);
        if (!MediaItemUtil.localFileExists(mediaItem))
        {
            break MISSING_BLOCK_LABEL_145;
        }
        saveErrorSyncState(mediaItem, queueType);
        return false;
        return false;
    }

    private void filterUploadingItems(List list, UploadStatus uploadstatus)
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            MediaItem mediaitem = (MediaItem)list.next();
            if (MediaItemUtil.isCloudMediaItem(mediaitem))
            {
                list.remove();
                GLogger.d(TAG, "Removed a cloud item from the upload list", new Object[0]);
            } else
            if (uploadstatus.isUploading(mediaitem))
            {
                list.remove();
                GLogger.d(TAG, "Removed a uploading item from the upload list", new Object[0]);
            }
        } while (true);
    }

    private Queue getQueue(QueueType queuetype)
    {
        static class _cls2
        {

            static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType[];
            static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType = new int[QueueType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType[QueueType.AUTO_SAVE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType[QueueType.MANUAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$QueueType[QueueType.FORCE_UPLOAD.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError = new int[UploadError.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.NO_ERROR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.NO_SPACE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.WAITING_FOR_WIFI.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.UNKNOWN_ERROR.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.ACCOUNT_CHANGED.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.UNREGISTERED.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.UPLOAD_DISABLED.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.WAITING_FOR_POWER.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.LOW_BATTERY.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.NO_NETWORK.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.amazon.gallery.framework.network.multiqueueuploader.QueueType[queuetype.ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported QueueType: ").append(queuetype).toString());

        case 1: // '\001'
            return autoSaveQueue;

        case 2: // '\002'
            return manualQueue;

        case 3: // '\003'
            return forceUploadQueue;
        }
    }

    private UploadStatus getUploadStatus(QueueType queuetype)
    {
        switch (_cls2..SwitchMap.com.amazon.gallery.framework.network.multiqueueuploader.QueueType[queuetype.ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported QueueType: ").append(queuetype).toString());

        case 1: // '\001'
            return autoSaveStatus;

        case 2: // '\002'
            return manualSaveStatus;

        case 3: // '\003'
            return forceSaveStatus;
        }
    }

    private boolean isUploadAllowed(QueueType queuetype)
    {
        if (!kindlePreferences.getBoolean("coldBootStatus", false))
        {
            GLogger.i(TAG, "Uploading is not allowed during cold boot", new Object[0]);
            return false;
        }
        switch (_cls2..SwitchMap.com.amazon.gallery.framework.network.multiqueueuploader.QueueType[queuetype.ordinal()])
        {
        default:
            return true;

        case 1: // '\001'
            return autoProcessing.get();

        case 2: // '\002'
            return manualProcessing.get();
        }
    }

    private void logUploadMetric(QueueType queuetype, MediaItem mediaitem)
    {
        boolean flag;
        boolean flag1 = false;
        Iterator iterator = mediaitem.getTags().iterator();
        do
        {
            flag = flag1;
            if (!iterator.hasNext())
            {
                break;
            }
            if (!((Tag)iterator.next()).hasProperty(TagProperty.FREETIME))
            {
                continue;
            }
            flag = true;
            break;
        } while (true);
        mediaitem = CustomerMetricsHelper.getExtra(mediaitem);
        _cls2..SwitchMap.com.amazon.gallery.framework.network.multiqueueuploader.QueueType[queuetype.ordinal()];
        JVM INSTR tableswitch 1 3: default 92
    //                   1 93
    //                   2 121
    //                   3 149;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        profiler.trackEvent(MetricsEvent.AutoSaveFile, mediaitem);
        if (flag)
        {
            profiler.trackEvent(MetricsEvent.AutoSaveFreeTime, mediaitem);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        profiler.trackEvent(MetricsEvent.UploadFile, mediaitem);
        if (flag)
        {
            profiler.trackEvent(MetricsEvent.UploadFreeTimeFile, mediaitem);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        profiler.trackEvent(MetricsEvent.AutoSaveEditedFile, mediaitem);
        return;
    }

    private void notifyError(UploadError uploaderror, QueueType queuetype, UploadBatchFactory.UploadBatchType uploadbatchtype)
    {
        UploadStatus uploadstatus = getUploadStatus(queuetype);
        uploadstatus.error(uploaderror);
        uploadstatus.addFailedBatch(uploadbatchtype);
        for (uploadbatchtype = listeners.iterator(); uploadbatchtype.hasNext(); ((UploadListener)uploadbatchtype.next()).onUploadError(uploadstatus, uploaderror, queuetype)) { }
    }

    private void notifyFailed(MediaItem mediaitem, QueueType queuetype, Exception exception, UploadBatchFactory.UploadBatchType uploadbatchtype)
    {
        UploadStatus uploadstatus = getUploadStatus(queuetype);
        if (!uploadstatus.isUploading(mediaitem))
        {
            GLogger.i(TAG, "Item was removed from upload or uploading was cancelled.", new Object[0]);
        } else
        {
            uploadstatus.failed(mediaitem);
            if (exception instanceof CloudStorageLimitException)
            {
                uploadstatus.error(UploadError.NO_SPACE);
                uploadstatus.addFailedBatch(uploadbatchtype);
            }
            mediaitem = listeners.iterator();
            while (mediaitem.hasNext()) 
            {
                ((UploadListener)mediaitem.next()).onUploadFailed(uploadstatus, queuetype, exception);
            }
        }
    }

    private void notifyFailed(List list, QueueType queuetype, Exception exception, UploadBatchFactory.UploadBatchType uploadbatchtype)
    {
        GLogger.i(TAG, "Fast failing on %s batch", new Object[] {
            uploadbatchtype
        });
        for (list = list.iterator(); list.hasNext(); notifyFailed((MediaItem)list.next(), queuetype, exception, uploadbatchtype)) { }
    }

    private void notifyProgress(MediaItem mediaitem, QueueType queuetype, int i, int j)
    {
        UploadStatus uploadstatus = getUploadStatus(queuetype);
        uploadstatus.update(mediaitem, i, j);
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((UploadListener)iterator.next()).onUploadProgressChanged(uploadstatus, mediaitem, queuetype, i, j)) { }
    }

    private void notifyQueued(List list, QueueType queuetype)
    {
        UploadStatus uploadstatus = getUploadStatus(queuetype);
        if (uploadstatus.isUploadComplete())
        {
            uploadstatus.reset();
        }
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            MediaItem mediaitem = (MediaItem)iterator.next();
            if (!uploadstatus.isUploading(mediaitem))
            {
                uploadstatus.add(mediaitem);
            }
        } while (true);
        UploadListener uploadlistener;
        for (Iterator iterator1 = listeners.iterator(); iterator1.hasNext(); uploadlistener.onUploadQueued(uploadstatus, list, queuetype))
        {
            uploadlistener = (UploadListener)iterator1.next();
            GLogger.v(TAG, "Notifying listener: %s, number of mediaItems: %d", new Object[] {
                uploadlistener, Integer.valueOf(list.size())
            });
        }

    }

    private void notifySuccessful(MediaItem mediaitem, QueueType queuetype, UploadBatchFactory.UploadBatchType uploadbatchtype)
    {
        UploadStatus uploadstatus = getUploadStatus(queuetype);
        if (!uploadstatus.isUploading(mediaitem))
        {
            GLogger.i(TAG, "Item was removed from upload or uploading was cancelled.", new Object[0]);
        } else
        {
            uploadstatus.complete(mediaitem);
            uploadstatus.removeFailedBatch(uploadbatchtype);
            mediaitem = listeners.iterator();
            while (mediaitem.hasNext()) 
            {
                ((UploadListener)mediaitem.next()).onUploadSuccessful(uploadstatus, queuetype);
            }
        }
    }

    private void resetSyncState(UploadBatch uploadbatch)
    {
        resetSyncState(uploadbatch.getMediaItems());
    }

    private void resetSyncState(List list)
    {
        boolean flag = false;
        MediaItem mediaitem;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); mediaitem.setSyncState(SyncState.NOT_SYNCED))
        {
            mediaitem = (MediaItem)iterator.next();
            flag = true;
        }

        if (flag)
        {
            mediaItemDao.saveMergedFields(list, true);
        }
    }

    private void saveErrorSyncState(MediaItem mediaitem, QueueType queuetype)
    {
        if (!isUploadAllowed(queuetype))
        {
            return;
        }
        _cls2..SwitchMap.com.amazon.gallery.framework.network.multiqueueuploader.QueueType[queuetype.ordinal()];
        JVM INSTR tableswitch 1 2: default 40
    //                   1 79
    //                   2 86;
           goto _L1 _L2 _L3
_L1:
        queuetype = SyncState.NOT_SYNCED;
_L5:
        GLogger.i(TAG, "Setting sync state to %s", new Object[] {
            queuetype
        });
        mediaItemDao.saveSyncState(mediaitem.getObjectId(), queuetype, true);
        return;
_L2:
        queuetype = SyncState.SYNC_ERROR_TRANSIENT_AUTO;
        continue; /* Loop/switch isn't completed */
_L3:
        queuetype = SyncState.SYNC_ERROR_TRANSIENT_MANUAL;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void setSyncStatePending(List list, QueueType queuetype)
    {
        if (queuetype != QueueType.AUTO_SAVE) goto _L2; else goto _L1
_L2:
        if (queuetype != QueueType.MANUAL);
_L4:
        return;
_L1:
        queuetype = SyncState.PENDING_AUTO;
        LinkedList linkedlist = new LinkedList();
        for (list = list.iterator(); list.hasNext();)
        {
            MediaItem mediaitem = (MediaItem)list.next();
            if (mediaitem.getSyncState() != queuetype)
            {
                mediaitem.setSyncState(queuetype);
                linkedlist.add(mediaitem);
            }
        }

        if (!linkedlist.isEmpty())
        {
            mediaItemDao.saveMergedFields(linkedlist, true);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private UploadError uploadBatch(UploadBatch uploadbatch, QueueType queuetype, UploadPermission uploadpermission, String s, AtomicBoolean atomicboolean)
        throws AccountLockedException
    {
        UploadBatchFactory.UploadBatchType uploadbatchtype;
        int i;
        uploadbatchtype = uploadbatch.getUploadBatchType();
        i = 0;
_L4:
        if (uploadbatch.getMediaItems().isEmpty() || i >= 1) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        int j;
        j = i + 1;
        iterator = uploadbatch.getMediaItems().iterator();
_L7:
        i = j;
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!atomicboolean.get() && !Thread.currentThread().isInterrupted() && isUploadAllowed(queuetype)) goto _L6; else goto _L5
_L5:
        UploadError uploaderror;
        GLogger.d(TAG, "Upload disabled for queue %s, discontinue.", new Object[] {
            queuetype
        });
        uploaderror = UploadError.UPLOAD_DISABLED;
_L11:
        return uploaderror;
_L6:
        MediaItem mediaitem = (MediaItem)iterator.next();
        UploadError uploaderror1;
        uploaderror1 = uploadpermission.getUploadPermission(mediaitem, s, uploadbatch.getUploadStrategy(), queuetype);
        if (atomicboolean.get() || Thread.currentThread().isInterrupted() || !isUploadAllowed(queuetype))
        {
            GLogger.d(TAG, "Upload disabled for queue %s.", new Object[] {
                queuetype
            });
            return UploadError.UPLOAD_DISABLED;
        }
        uploaderror = uploaderror1;
        _cls2..SwitchMap.com.amazon.gallery.framework.network.multiqueueuploader.UploadError[uploaderror1.ordinal()];
        JVM INSTR tableswitch 1 10: default 473
    //                   1 476
    //                   2 319
    //                   3 385
    //                   4 473
    //                   5 385
    //                   6 385
    //                   7 105
    //                   8 385
    //                   9 385
    //                   10 385;
           goto _L7 _L8 _L9 _L10 _L7 _L10 _L10 _L11 _L10 _L10 _L10
_L12:
        boolean flag;
        if (doUpload(mediaitem, queuetype, flag, uploadbatchtype))
        {
            iterator.remove();
            uploadpermission.notifyUploaded(mediaitem);
        }
          goto _L7
        NoStorageInfoAvailableException nostorageinfoavailableexception;
        nostorageinfoavailableexception;
        notifyFailed(mediaitem, queuetype, nostorageinfoavailableexception, uploadbatch.getUploadBatchType());
        GLogger.ex(TAG, "Can't get storage information", nostorageinfoavailableexception);
          goto _L7
_L14:
        flag = false;
          goto _L12
_L9:
        notifyFailed(uploadbatch.getMediaItems(), queuetype, new CloudStorageLimitException(), uploadbatchtype);
        return uploaderror1;
        uploadpermission;
        GLogger.e(TAG, "Cloud storage is full: %s", new Object[] {
            uploadpermission.getMessage()
        });
        notifyFailed(uploadbatch.getMediaItems(), queuetype, new CloudStorageLimitException(), uploadbatch.getUploadBatchType());
        return UploadError.NO_SPACE;
_L10:
        notifyError(uploaderror1, queuetype, uploadbatchtype);
        return uploaderror1;
_L2:
        if (!uploadbatch.getMediaItems().isEmpty())
        {
            if (atomicboolean.get() || Thread.currentThread().isInterrupted() || !isUploadAllowed(queuetype))
            {
                GLogger.d(TAG, "Upload was disabled for queue %s.", new Object[] {
                    queuetype
                });
                return UploadError.UPLOAD_DISABLED;
            } else
            {
                notifyError(UploadError.UNKNOWN_ERROR, queuetype, uploadbatchtype);
                return UploadError.UNKNOWN_ERROR;
            }
        } else
        {
            return UploadError.NO_ERROR;
        }
_L8:
        if (j < 1) goto _L14; else goto _L13
_L13:
        flag = true;
          goto _L12
    }

    public void addUploadListener(UploadListener uploadlistener)
    {
        List list = listeners;
        list;
        JVM INSTR monitorenter ;
        if (!listeners.contains(uploadlistener))
        {
            break MISSING_BLOCK_LABEL_46;
        }
        GLogger.e(TAG, "Duplicated upload listener added: %s", new Object[] {
            Integer.valueOf(System.identityHashCode(uploadlistener))
        });
_L2:
        return;
        listeners.add(uploadlistener);
        if (true) goto _L2; else goto _L1
_L1:
        uploadlistener;
        list;
        JVM INSTR monitorexit ;
        throw uploadlistener;
    }

    public boolean allowUpload(QueueType queuetype, boolean flag)
    {
        switch (_cls2..SwitchMap.com.amazon.gallery.framework.network.multiqueueuploader.QueueType[queuetype.ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append(queuetype.name()).append(" is not a queue type which can be switched off.").toString());

        case 1: // '\001'
            return autoProcessing.getAndSet(flag);

        case 2: // '\002'
            return manualProcessing.getAndSet(flag);
        }
    }

    public void clearQueue(QueueType queuetype)
    {
        getUploadStatus(queuetype).reset();
        getQueue(queuetype).clear();
    }

    public Map getUploadStatusForAllQueues()
    {
        HashMap hashmap = new HashMap();
        hashmap.put(QueueType.AUTO_SAVE, getUploadStatus(QueueType.AUTO_SAVE));
        hashmap.put(QueueType.MANUAL, getUploadStatus(QueueType.MANUAL));
        return hashmap;
    }

    public boolean isEmpty(QueueType queuetype)
    {
        return getQueue(queuetype).isEmpty();
    }

    public void onUploadCancelled(QueueType queuetype)
    {
        if (queuetype == QueueType.MANUAL)
        {
            resetSyncState(mediaItemDao.getItemsBySyncState(SyncState.PENDING_MANUAL).getMediaItems());
        }
    }

    public void onUploadScheduled(QueueType queuetype, UploadPermission uploadpermission, String s, AtomicBoolean atomicboolean)
        throws AccountLockedException
    {
        if (atomicboolean.get() || Thread.currentThread().isInterrupted() || !isUploadAllowed(queuetype))
        {
            return;
        }
        Queue queue = getQueue(queuetype);
        GLogger.i(TAG, "onUploadScheduled started for queue %s. Pending items: %d", new Object[] {
            queuetype, Integer.valueOf(queue.size())
        });
        LinkedList linkedlist = new LinkedList();
label0:
        do
        {
            boolean flag;
label1:
            {
                if (queue.isEmpty())
                {
                    break label0;
                }
                UploadBatch uploadbatch = (UploadBatch)queue.remove();
                GLogger.v(TAG, "Starting upload on %s batch", new Object[] {
                    uploadbatch.getUploadBatchType()
                });
                UploadError uploaderror = uploadBatch(uploadbatch, queuetype, uploadpermission, s, atomicboolean);
                boolean flag1 = true;
                GLogger.v(TAG, "%s batch completed with status '%s'. %s batches remaining", new Object[] {
                    uploadbatch.getUploadBatchType(), uploaderror, Integer.valueOf(queue.size())
                });
                flag = flag1;
                switch (_cls2..SwitchMap.com.amazon.gallery.framework.network.multiqueueuploader.UploadError[uploaderror.ordinal()])
                {
                case 1: // '\001'
                case 2: // '\002'
                default:
                    break;

                case 3: // '\003'
                    addToQueue(linkedlist, uploadbatch, true);
                    break;

                case 4: // '\004'
                    if (queuetype != QueueType.MANUAL)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    addToQueue(linkedlist, uploadbatch, flag);
                    break;

                case 5: // '\005'
                case 6: // '\006'
                case 7: // '\007'
                    flag = flag1;
                    if (queuetype == QueueType.MANUAL)
                    {
                        flag = false;
                    }
                    // fall through

                case 8: // '\b'
                case 9: // '\t'
                case 10: // '\n'
                    addToQueue(linkedlist, uploadbatch, flag);
                    break label1;
                }
                if (false)
                {
                    break label0;
                }
                continue;
            }
            while (!queue.isEmpty()) 
            {
                addToQueue(linkedlist, (UploadBatch)queue.remove(), flag);
            }
        } while (true);
        for (uploadpermission = linkedlist.iterator(); uploadpermission.hasNext(); queue.offer((UploadBatch)uploadpermission.next())) { }
        GLogger.d(TAG, "onUploadScheduled finished for queue %s", new Object[] {
            queuetype
        });
    }

    public void refreshQueue(QueueType queuetype)
    {
        UploadBatch uploadbatch;
        for (Iterator iterator = getQueue(queuetype).iterator(); iterator.hasNext(); notifyQueued(uploadbatch.getMediaItems(), queuetype))
        {
            uploadbatch = (UploadBatch)iterator.next();
            setSyncStatePending(uploadbatch.getMediaItems(), queuetype);
        }

    }

    public void removeUploadListener(UploadListener uploadlistener)
    {
        synchronized (listeners)
        {
            listeners.remove(uploadlistener);
        }
        return;
        uploadlistener;
        list;
        JVM INSTR monitorexit ;
        throw uploadlistener;
    }

    public void updateErrorState(UploadError uploaderror, QueueType queuetype)
    {
        UploadStatus uploadstatus = getUploadStatus(queuetype);
        uploadstatus.error(uploaderror);
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((UploadListener)iterator.next()).onUploadError(uploadstatus, uploaderror, queuetype)) { }
    }

    public void uploadMediaItems(List list, QueueType queuetype, UploadStrategy uploadstrategy)
    {
        if (!Thread.currentThread().isInterrupted() && isUploadAllowed(queuetype))
        {
            list = new LinkedList(list);
            filterUploadingItems(list, getUploadStatus(queuetype));
            if (!list.isEmpty())
            {
                GLogger.d(TAG, "Receive upload request for queue %s, with media items: %d", new Object[] {
                    queuetype, Integer.valueOf(list.size())
                });
                setSyncStatePending(list, queuetype);
                UploadBatch uploadbatch;
                for (uploadstrategy = UploadBatchFactory.createBatchMap(list, uploadstrategy).values().iterator(); uploadstrategy.hasNext(); getQueue(queuetype).offer(uploadbatch))
                {
                    uploadbatch = (UploadBatch)uploadstrategy.next();
                    GLogger.d(TAG, "Adding %s batch containing %d items to %s queue", new Object[] {
                        uploadbatch.getUploadBatchType(), Integer.valueOf(uploadbatch.getMediaItems().size()), queuetype
                    });
                }

                notifyQueued(list, queuetype);
                return;
            }
        }
    }

    public void uploadTags(List list, QueueType queuetype, UploadStrategy uploadstrategy)
    {
        if (!Thread.currentThread().isInterrupted() && isUploadAllowed(queuetype))
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                Tag tag = (Tag)list.next();
                uploadMediaItems(mediaItemDao.getItemsByTag(tag).getMediaItems(), queuetype, uploadstrategy);
            }
        }
    }


}
