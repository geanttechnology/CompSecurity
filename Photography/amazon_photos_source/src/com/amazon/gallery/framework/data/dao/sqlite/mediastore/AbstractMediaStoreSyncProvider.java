// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;

import android.net.Uri;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.thread.NamedThreadPoolFactory;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediastore:
//            MediaStoreSyncProvider, LocalStateDao, MediaStoreHelper

public abstract class AbstractMediaStoreSyncProvider
    implements MediaStoreSyncProvider
{
    public static interface OneOffScanListener
    {

        public abstract void onScanCompleted(MediaItem mediaitem);
    }


    protected static int RECONCILE_THRESHOLD = 30000;
    protected static final BlockingQueue fixedSinglePendingTaskQueue = new ArrayBlockingQueue(1);
    private final String TAG = com/amazon/gallery/framework/data/dao/sqlite/mediastore/AbstractMediaStoreSyncProvider.getName();
    protected final ThreadPoolExecutor executor;
    protected long lastReconcileTime;
    protected LocalStateDao localStateDao;
    protected MediaItemDao mediaItemDao;
    protected MediaStoreHelper mediaStoreHelper;
    protected final List oneOffOnConnectListeners = new ArrayList();
    protected final Map oneOffScanListeners = new HashMap();
    protected volatile boolean restart;
    private final CountDownLatch startLatch = new CountDownLatch(1);
    protected TagDao tagDao;

    protected AbstractMediaStoreSyncProvider()
    {
        executor = NamedThreadPoolFactory.newThreadPool(TAG, 1, 1, 30L, TimeUnit.SECONDS, fixedSinglePendingTaskQueue, getPostExecuteRunnable());
        lastReconcileTime = 0L;
        restart = false;
        init();
    }

    public void attachOneOffOnConnectListener(Runnable runnable)
    {
        synchronized (oneOffOnConnectListeners)
        {
            oneOffOnConnectListeners.add(runnable);
        }
        return;
        runnable;
        list;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public void attachOneOffScanListener(String s, OneOffScanListener oneoffscanlistener)
    {
        synchronized (oneOffScanListeners)
        {
            oneOffScanListeners.put(s, oneoffscanlistener);
        }
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    protected boolean callAndRemoveOnOffScanListener(MediaItem mediaitem)
    {
        OneOffScanListener oneoffscanlistener;
        synchronized (oneOffScanListeners)
        {
            oneoffscanlistener = (OneOffScanListener)oneOffScanListeners.remove(mediaitem.getLocalPath());
        }
        if (oneoffscanlistener != null)
        {
            oneoffscanlistener.onScanCompleted(mediaitem);
            return true;
        } else
        {
            return false;
        }
        mediaitem;
        map;
        JVM INSTR monitorexit ;
        throw mediaitem;
    }

    protected abstract Runnable getPostExecuteRunnable();

    protected void init()
    {
        executor.execute(new Runnable() {

            final AbstractMediaStoreSyncProvider this$0;

            public void run()
            {
                try
                {
                    startLatch.await();
                    return;
                }
                catch (InterruptedException interruptedexception)
                {
                    Thread.currentThread().interrupt();
                }
            }

            
            {
                this$0 = AbstractMediaStoreSyncProvider.this;
                super();
            }
        });
    }

    public void onAccountDeregistered()
    {
        restart = true;
    }

    public void onAccountRegistered()
    {
        restart = true;
    }

    public void onMediaScannerConnected()
    {
        List list = oneOffOnConnectListeners;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = oneOffOnConnectListeners.iterator(); iterator.hasNext(); ((Runnable)iterator.next()).run()) { }
        break MISSING_BLOCK_LABEL_48;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        oneOffOnConnectListeners.clear();
        list;
        JVM INSTR monitorexit ;
        GLogger.d(TAG, "onMediaScannerConnected", new Object[0]);
        return;
    }

    public void onScanCompleted(String s, Uri uri)
    {
        String s1 = TAG;
        boolean flag;
        if (uri != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        GLogger.d(s1, "onScanCompleted file=%s success=%b", new Object[] {
            s, Boolean.valueOf(flag)
        });
        if (uri != null)
        {
            syncMediaStoreAsync(false);
        }
    }

    public void setLocalDao(MediaItemDao mediaitemdao)
    {
        mediaItemDao = mediaitemdao;
    }

    public void setLocalStateDB(LocalStateDao localstatedao)
    {
        localStateDao = localstatedao;
    }

    public void setMediaStoreHelper(MediaStoreHelper mediastorehelper)
    {
        mediaStoreHelper = mediastorehelper;
    }

    public void setTagDao(TagDao tagdao)
    {
        tagDao = tagdao;
    }

    public void start()
    {
        GLogger.d(TAG, "Started", new Object[0]);
        startLatch.countDown();
    }


}
