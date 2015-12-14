// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cleanupmanager;

import android.os.AsyncTask;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.framework.data.dao.Md5Deduplicater;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.gallery.widget.MediaItemListAdapter;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.thor.app.activity.CleanupManagerActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;

// Referenced classes of package com.amazon.gallery.thor.cleanupmanager:
//            CleanupManagerUiThreadHandler

public class DeduplicationHelper
{

    private WeakReference activityWeakReference;
    private List dateSortedDuplicates;
    private final AsyncTask deduplicationTask;
    private final Md5Deduplicater md5Deduplicater;
    private boolean noDupesFound;
    private int progress;
    private final List sizeSortedDuplicates;
    private long totalDupesFileSize;

    public DeduplicationHelper(CleanupManagerActivity cleanupmanageractivity)
    {
        noDupesFound = false;
        totalDupesFileSize = 0L;
        progress = -1;
        this;
        JVM INSTR monitorenter ;
        activityWeakReference = new WeakReference(cleanupmanageractivity);
        this;
        JVM INSTR monitorexit ;
        sizeSortedDuplicates = new ArrayList();
        dateSortedDuplicates = new ArrayList();
        md5Deduplicater = new Md5Deduplicater(cleanupmanageractivity.getApplicationContext(), (MediaItemDao)cleanupmanageractivity.getApplicationBean(Keys.MEDIA_ITEM_DAO));
        deduplicationTask = new AsyncTask() {

            final DeduplicationHelper this$0;
            final com.amazon.gallery.framework.data.dao.Md5Deduplicater.DeduplicationObserver val$deduplicationObserver;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                md5Deduplicater.getAllMd5Duplicates(deduplicationObserver);
                return null;
            }

            
            {
                this$0 = DeduplicationHelper.this;
                deduplicationObserver = deduplicationobserver;
                super();
            }
        };
        return;
        cleanupmanageractivity;
        this;
        JVM INSTR monitorexit ;
        throw cleanupmanageractivity;
    }

    public List getDateSortedDuplicates()
    {
        return dateSortedDuplicates;
    }

    public int getProgress()
    {
        return progress;
    }

    public List getSizeSortedDuplicates()
    {
        return sizeSortedDuplicates;
    }

    public long getTotalDupesFileSize()
    {
        return totalDupesFileSize;
    }

    public boolean isNoDupesFound()
    {
        return noDupesFound;
    }

    public void setTotalDupesFileSize(long l)
    {
        totalDupesFileSize = l;
    }

    public void startDeduplication()
    {
        deduplicationTask.execute(new Void[0]);
    }

    public void updateContext(CleanupManagerActivity cleanupmanageractivity)
    {
        this;
        JVM INSTR monitorenter ;
        if (cleanupmanageractivity != null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        activityWeakReference = null;
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        activityWeakReference = new WeakReference(cleanupmanageractivity);
        if (true) goto _L2; else goto _L1
_L1:
        cleanupmanageractivity;
        this;
        JVM INSTR monitorexit ;
        throw cleanupmanageractivity;
    }




/*
    static boolean access$102(DeduplicationHelper deduplicationhelper, boolean flag)
    {
        deduplicationhelper.noDupesFound = flag;
        return flag;
    }

*/



/*
    static long access$214(DeduplicationHelper deduplicationhelper, long l)
    {
        l = deduplicationhelper.totalDupesFileSize + l;
        deduplicationhelper.totalDupesFileSize = l;
        return l;
    }

*/



/*
    static int access$402(DeduplicationHelper deduplicationhelper, int i)
    {
        deduplicationhelper.progress = i;
        return i;
    }

*/


/*
    static List access$502(DeduplicationHelper deduplicationhelper, List list)
    {
        deduplicationhelper.dateSortedDuplicates = list;
        return list;
    }

*/


    // Unreferenced inner class com/amazon/gallery/thor/cleanupmanager/DeduplicationHelper$1

/* anonymous class */
    class _cls1
        implements com.amazon.gallery.framework.data.dao.Md5Deduplicater.DeduplicationObserver
    {

        final DeduplicationHelper this$0;

        public boolean isObserverActive()
        {
            DeduplicationHelper deduplicationhelper = DeduplicationHelper.this;
            deduplicationhelper;
            JVM INSTR monitorenter ;
            Exception exception;
            boolean flag;
            if (activityWeakReference != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            deduplicationhelper;
            JVM INSTR monitorexit ;
            return flag;
            exception;
            deduplicationhelper;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void onDeduplicationFinished(List list)
        {
            dateSortedDuplicates = list;
            if (activityWeakReference != null && !noDupesFound)
            {
                list = (CleanupManagerActivity)activityWeakReference.get();
                String s = FileUtils.byteCountToDisplaySize(totalDupesFileSize);
                int i = sizeSortedDuplicates.size();
                HashMap hashmap = new HashMap(2);
                hashmap.put("fileSize", s);
                hashmap.put("numFiles", String.valueOf(i));
                list.getProfiler().trackEvent(com.amazon.gallery.thor.app.activity.CleanupManagerActivity.MetricsEvent.CleanupActivityAmountFound, hashmap);
                list.getUiThreadHandler().sendUpdateSelectSortInActionBarMessage();
            }
        }

        public void onDuplicatesFound(List list, long l)
        {
            DeduplicationHelper deduplicationhelper = DeduplicationHelper.this;
            deduplicationhelper;
            JVM INSTR monitorenter ;
            CleanupManagerActivity cleanupmanageractivity;
            if (activityWeakReference != null)
            {
                cleanupmanageractivity = (CleanupManagerActivity)activityWeakReference.get();
                if (!list.isEmpty())
                {
                    break MISSING_BLOCK_LABEL_89;
                }
                noDupesFound = true;
                cleanupmanageractivity.getProfiler().trackEvent(com.amazon.gallery.thor.app.activity.CleanupManagerActivity.MetricsEvent.CleanupActivityNoneFound);
                cleanupmanageractivity.getUiThreadHandler().sendNoDupesFoundMessage();
            }
_L2:
            sizeSortedDuplicates.addAll(list);
            return;
            list = ((access._cls100) (this)).access$100 + list;
            cleanupmanageractivity.getMediaItemListAdapter().addAll(list);
            if (true) goto _L2; else goto _L1
_L1:
            list;
            deduplicationhelper;
            JVM INSTR monitorexit ;
            throw list;
        }

        public void onUpdateProgress(long l)
        {
            progress = (int)l;
            synchronized (DeduplicationHelper.this)
            {
                if (activityWeakReference != null)
                {
                    ((CleanupManagerActivity)activityWeakReference.get()).onProgressUpdate(l);
                }
            }
            return;
            exception;
            deduplicationhelper;
            JVM INSTR monitorexit ;
            throw exception;
        }

            
            {
                this$0 = DeduplicationHelper.this;
                super();
            }
    }

}
