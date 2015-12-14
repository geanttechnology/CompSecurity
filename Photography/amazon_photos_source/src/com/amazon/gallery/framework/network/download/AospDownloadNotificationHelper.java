// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import android.content.Context;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package com.amazon.gallery.framework.network.download:
//            AbstractDownloadNotificationHelper, CustomDownloadId

public class AospDownloadNotificationHelper extends AbstractDownloadNotificationHelper
{
    private static class DownloadQueueStatus
    {

        private long numDownloadCompleted;
        private long numDownloadFailed;
        private long numTotalToDownload;

        public long getRemainingItemCount()
        {
            return numTotalToDownload - (numDownloadCompleted + numDownloadFailed);
        }

        public boolean hasFailedItems()
        {
            return numDownloadFailed != 0L;
        }

        public void onItemDownloadComplete()
        {
            numDownloadCompleted = numDownloadCompleted + 1L;
        }

        public void onItemDownloadFailed()
        {
            numDownloadFailed = numDownloadFailed + 1L;
        }

        public void onItemsAdded(long l)
        {
            numTotalToDownload = numTotalToDownload + l;
        }

        public DownloadQueueStatus(long l)
        {
            numTotalToDownload = l;
        }
    }


    private String currentDownloadFileName;
    private long currentDownloadItemIndex;
    private final HashMap downloadQueueStatusMap = new HashMap(5);
    private long totalItemsInAllQueues;

    public AospDownloadNotificationHelper(Context context)
    {
        super(context);
        totalItemsInAllQueues = 0L;
        currentDownloadItemIndex = 1L;
        currentDownloadFileName = "";
    }

    private void checkAllQueuesProcessed()
    {
label0:
        {
            if (currentDownloadItemIndex > totalItemsInAllQueues)
            {
                boolean flag = false;
                for (Iterator iterator = downloadQueueStatusMap.values().iterator(); iterator.hasNext();)
                {
                    flag |= ((DownloadQueueStatus)iterator.next()).hasFailedItems();
                }

                if (!flag)
                {
                    break label0;
                }
                reset();
                showErrorNotification();
            }
            return;
        }
        reset();
        clearNotification();
    }

    private void clearNotification()
    {
        clearDownloadNotification();
    }

    private boolean isQueueForItemRemoved(CustomDownloadId customdownloadid)
    {
        return totalItemsInAllQueues == 0L || downloadQueueStatusMap.get(customdownloadid.getTag()) == null;
    }

    private void reset()
    {
        downloadQueueStatusMap.clear();
        totalItemsInAllQueues = 0L;
        currentDownloadItemIndex = 1L;
    }

    private void updateNotification()
    {
        if (currentDownloadItemIndex <= totalItemsInAllQueues)
        {
            updateDownloadNotification(currentDownloadItemIndex, currentDownloadFileName, totalItemsInAllQueues);
        }
    }

    public void onDownloadQueueCreated(CustomDownloadId customdownloadid)
    {
        this;
        JVM INSTR monitorenter ;
        DownloadQueueStatus downloadqueuestatus;
        int i;
        i = customdownloadid.getTotal();
        downloadqueuestatus = (DownloadQueueStatus)downloadQueueStatusMap.get(customdownloadid.getTag());
        if (downloadqueuestatus != null) goto _L2; else goto _L1
_L1:
        downloadqueuestatus = new DownloadQueueStatus(i);
        downloadQueueStatusMap.put(customdownloadid.getTag(), downloadqueuestatus);
_L3:
        totalItemsInAllQueues = totalItemsInAllQueues + (long)i;
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        long l = i;
        downloadqueuestatus.onItemsAdded(l);
          goto _L3
        customdownloadid;
        throw customdownloadid;
    }

    public void onDownloadQueueRemoved(CustomDownloadId customdownloadid)
    {
        this;
        JVM INSTR monitorenter ;
        DownloadQueueStatus downloadqueuestatus = (DownloadQueueStatus)downloadQueueStatusMap.get(customdownloadid.getTag());
        if (downloadqueuestatus == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        long l = downloadqueuestatus.getRemainingItemCount();
        totalItemsInAllQueues = totalItemsInAllQueues - l;
        downloadQueueStatusMap.remove(customdownloadid.getTag());
        updateNotification();
        checkAllQueuesProcessed();
        this;
        JVM INSTR monitorexit ;
        return;
        customdownloadid;
        throw customdownloadid;
    }

    public void onDownloadQueuesCleared()
    {
        this;
        JVM INSTR monitorenter ;
        reset();
        clearNotification();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onItemDownloadCompleted(CustomDownloadId customdownloadid)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isQueueForItemRemoved(customdownloadid);
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        currentDownloadItemIndex = currentDownloadItemIndex + 1L;
        ((DownloadQueueStatus)downloadQueueStatusMap.get(customdownloadid.getTag())).onItemDownloadComplete();
        updateNotification();
        checkAllQueuesProcessed();
        if (true) goto _L1; else goto _L3
_L3:
        customdownloadid;
        throw customdownloadid;
    }

    public void onItemDownloadFailed(CustomDownloadId customdownloadid)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isQueueForItemRemoved(customdownloadid);
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        currentDownloadItemIndex = currentDownloadItemIndex + 1L;
        ((DownloadQueueStatus)downloadQueueStatusMap.get(customdownloadid.getTag())).onItemDownloadFailed();
        updateNotification();
        checkAllQueuesProcessed();
        if (true) goto _L1; else goto _L3
_L3:
        customdownloadid;
        throw customdownloadid;
    }

    public void onItemDownloadStarted(CustomDownloadId customdownloadid, String s)
    {
        this;
        JVM INSTR monitorenter ;
        currentDownloadFileName = s;
        updateNotification();
        this;
        JVM INSTR monitorexit ;
        return;
        customdownloadid;
        throw customdownloadid;
    }
}
