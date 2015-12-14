// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.watchdog;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.network.multiqueueuploader.MultiQueueUploader;
import com.amazon.gallery.framework.network.multiqueueuploader.QueueType;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.framework.network.watchdog:
//            WhisperUploadService

class val.resumeIfPaused
    implements Runnable
{

    final WhisperUploadService this$0;
    final boolean val$resumeIfPaused;

    public void run()
    {
label0:
        {
            synchronized (WhisperUploadService.access$600(WhisperUploadService.this))
            {
                if (WhisperUploadService.access$000(WhisperUploadService.this))
                {
                    multiQueueUploader.refreshQueue(QueueType.AUTO_SAVE);
                    WhisperUploadService.access$700(WhisperUploadService.this);
                }
                multiQueueUploader.clearQueue(QueueType.FORCE_UPLOAD);
                WhisperUploadService.access$800(WhisperUploadService.this, SyncState.PENDING_EDITED, QueueType.FORCE_UPLOAD);
                if (val$resumeIfPaused || !WhisperUploadService.access$900(WhisperUploadService.this).isPaused())
                {
                    break label0;
                }
                GLogger.i(WhisperUploadService.access$1000(), "Uploads paused.", new Object[0]);
            }
            return;
        }
        if (WhisperUploadService.access$1100(WhisperUploadService.this) == null || WhisperUploadService.access$1100(WhisperUploadService.this).isDone())
        {
            break MISSING_BLOCK_LABEL_152;
        }
        GLogger.i(WhisperUploadService.access$1000(), "Uploads already running.", new Object[0]);
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (WhisperUploadService.access$1200(WhisperUploadService.this).isShutdown())
        {
            break MISSING_BLOCK_LABEL_209;
        }
        WhisperUploadService.access$1102(WhisperUploadService.this, WhisperUploadService.access$1200(WhisperUploadService.this).schedule(WhisperUploadService.access$900(WhisperUploadService.this), 0L, TimeUnit.SECONDS));
_L2:
        GLogger.i(WhisperUploadService.access$1000(), "Auto uploads started.", new Object[0]);
        obj;
        JVM INSTR monitorexit ;
        return;
        GLogger.i(WhisperUploadService.access$1000(), "Auto upload pool shutdown, discard runnable", new Object[0]);
        if (true) goto _L2; else goto _L1
_L1:
    }

    loadRunnable()
    {
        this$0 = final_whisperuploadservice;
        val$resumeIfPaused = Z.this;
        super();
    }
}
