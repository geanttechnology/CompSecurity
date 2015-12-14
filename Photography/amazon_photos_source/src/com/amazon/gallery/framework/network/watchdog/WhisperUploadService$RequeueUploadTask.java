// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.watchdog;

import android.os.Handler;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.network.multiqueueuploader.QueueType;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadMediaItemsEvent;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.framework.network.watchdog:
//            WhisperUploadService

public static final class runOnUiThreadHandler
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
        final boolean isEmpty = arraylist.isEmpty();
        if (!isEmpty)
        {
            GlobalMessagingBus.post(new UploadMediaItemsEvent(arraylist, QueueType.MANUAL, uploadStrategy, WhisperUploadService.access$1000()));
        }
        runOnUiThreadHandler.post(new Runnable() {

            final WhisperUploadService.RequeueUploadTask this$0;
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
                this$0 = WhisperUploadService.RequeueUploadTask.this;
                isEmpty = flag;
                super();
            }
        });
    }



    public _cls1.val.isEmpty(MediaItemDao mediaitemdao, UploadStrategy uploadstrategy, AtomicBoolean atomicboolean, Runnable runnable, Handler handler)
    {
        mediaItemDao = mediaitemdao;
        uploadStrategy = uploadstrategy;
        isQueuing = atomicboolean;
        stopSelfRunnable = runnable;
        runOnUiThreadHandler = handler;
    }
}
