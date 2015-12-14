// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            UploadError, UploadItemStatus

public class UploadStatus
{

    public static final String TAG = com/amazon/gallery/framework/network/multiqueueuploader/UploadStatus.getName();
    private volatile long currentItemNumber;
    protected final EnumSet failedBatches = EnumSet.noneOf(com/amazon/gallery/framework/network/multiqueueuploader/UploadBatchFactory$UploadBatchType);
    private volatile long totalBytes;
    private volatile long totalItems;
    private volatile long totalUploadedBytes;
    private volatile UploadError uploadError;
    protected final ConcurrentHashMap uploadingItems = new ConcurrentHashMap();

    public UploadStatus()
    {
        totalBytes = 0L;
        totalUploadedBytes = 0L;
        totalItems = 0L;
        currentItemNumber = 1L;
        uploadError = UploadError.NO_ERROR;
    }

    private String getItemIdentifier(MediaItem mediaitem)
    {
        if (mediaitem.getLocalPath() == null)
        {
            return mediaitem.getObjectId().toString();
        } else
        {
            return mediaitem.getLocalPath();
        }
    }

    public final void add(MediaItem mediaitem)
    {
        String s = getItemIdentifier(mediaitem);
        GLogger.d(TAG, "Added: %s", new Object[] {
            s
        });
        long l = MediaItemUtil.getFileLength(mediaitem);
        if (!uploadingItems.contains(s) && (UploadItemStatus)uploadingItems.putIfAbsent(s, new UploadItemStatus(l)) == null)
        {
            GLogger.v(TAG, "New item added. Size: %d", new Object[] {
                Long.valueOf(l)
            });
            totalBytes = totalBytes + l;
            totalItems = totalItems + 1L;
        }
    }

    protected void addFailedBatch(UploadBatchFactory.UploadBatchType uploadbatchtype)
    {
        failedBatches.add(uploadbatchtype);
    }

    public final void complete(MediaItem mediaitem)
    {
        currentItemNumber = currentItemNumber + 1L;
        update(mediaitem, 100, 100);
        mediaitem = getItemIdentifier(mediaitem);
        uploadingItems.remove(mediaitem);
    }

    public final void error(UploadError uploaderror)
    {
        uploadError = uploaderror;
    }

    public final void failed(MediaItem mediaitem)
    {
        mediaitem = getItemIdentifier(mediaitem);
        Object obj = (UploadItemStatus)uploadingItems.get(mediaitem);
        if (obj != null)
        {
            totalBytes = totalBytes - ((UploadItemStatus) (obj)).failed();
            uploadingItems.remove(mediaitem);
            return;
        }
        obj = TAG;
        if (mediaitem == null)
        {
            mediaitem = null;
        } else
        {
            mediaitem = Integer.valueOf(mediaitem.hashCode());
        }
        GLogger.w(((String) (obj)), "Could not update failed status for %s", new Object[] {
            mediaitem
        });
    }

    public final long getCurrentItemNumber()
    {
        long l1 = currentItemNumber;
        long l = l1;
        if (l1 > totalItems)
        {
            l = totalItems;
        }
        return l;
    }

    public final long getRealCurrentItemNumber()
    {
        return currentItemNumber;
    }

    public final long getTotalBytes()
    {
        return totalBytes;
    }

    public final long getTotalItems()
    {
        return totalItems;
    }

    public UploadError getUploadError()
    {
        return uploadError;
    }

    public final int getUploadProgress()
    {
        if (totalBytes == 0L)
        {
            return 0;
        } else
        {
            return (int)(((double)totalUploadedBytes / (double)totalBytes) * 100D);
        }
    }

    public final long getUploadedBytes()
    {
        long l = totalUploadedBytes;
        if (l > totalBytes)
        {
            l = totalBytes;
        }
        GLogger.d(TAG, "uploadedBytes: %d / totalBytes: %d", new Object[] {
            Long.valueOf(l), Long.valueOf(totalBytes)
        });
        return l;
    }

    public boolean hasAtLeastOneBatchFailed(EnumSet enumset)
    {
        for (enumset = enumset.iterator(); enumset.hasNext();)
        {
            if (hasBatchFailed((UploadBatchFactory.UploadBatchType)enumset.next()))
            {
                return true;
            }
        }

        return false;
    }

    public boolean hasBatchFailed(UploadBatchFactory.UploadBatchType uploadbatchtype)
    {
        return failedBatches.contains(uploadbatchtype);
    }

    public boolean isInErrorMode()
    {
        return uploadError != UploadError.NO_ERROR;
    }

    public final boolean isUploadComplete()
    {
        while (totalItems == 0L || currentItemNumber > totalItems || uploadingItems.isEmpty()) 
        {
            return true;
        }
        return false;
    }

    public final boolean isUploading(MediaItem mediaitem)
    {
        return uploadingItems.containsKey(getItemIdentifier(mediaitem));
    }

    protected void removeFailedBatch(UploadBatchFactory.UploadBatchType uploadbatchtype)
    {
        failedBatches.remove(uploadbatchtype);
    }

    public final void reset()
    {
        totalBytes = 0L;
        totalItems = 0L;
        totalUploadedBytes = 0L;
        currentItemNumber = 1L;
        uploadingItems.clear();
        failedBatches.clear();
        uploadError = UploadError.NO_ERROR;
    }

    public final void update(MediaItem mediaitem, int i, int j)
    {
        mediaitem = getItemIdentifier(mediaitem);
        GLogger.d(TAG, "Update(%d / %d): %s", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j), mediaitem
        });
        Object obj = (UploadItemStatus)uploadingItems.get(mediaitem);
        if (obj == null)
        {
            obj = TAG;
            if (mediaitem == null)
            {
                mediaitem = null;
            } else
            {
                mediaitem = Integer.valueOf(mediaitem.hashCode());
            }
            GLogger.errorStackTrace(((String) (obj)), "The requested item status was null: %s", new Object[] {
                mediaitem
            });
            return;
        } else
        {
            long l = ((UploadItemStatus) (obj)).updateStatus(i, j);
            totalUploadedBytes = totalUploadedBytes + l;
            return;
        }
    }

}
