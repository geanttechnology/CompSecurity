// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.watchdog;

import android.content.SharedPreferences;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.notifications.UploadNotificationHandler;
import com.amazon.gallery.framework.network.exceptions.AccountLockedException;
import com.amazon.gallery.framework.network.multiqueueuploader.MultiQueueUploader;
import com.amazon.gallery.framework.network.multiqueueuploader.QueueType;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.framework.network.watchdog:
//            WhisperUploadService

private class queueTypes
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
        GLogger.d(WhisperUploadService.access$1000(), "Uploading started", new Object[0]);
        setIsRunning(true);
        if (WhisperUploadService.access$1400(WhisperUploadService.this))
        {
            break MISSING_BLOCK_LABEL_74;
        }
        GLogger.w(WhisperUploadService.access$1000(), "Uninitialized. Uploading aborted.", new Object[0]);
        if (isPaused())
        {
            GLogger.i(WhisperUploadService.access$1000(), "Upload is paused, keeping service alive...", new Object[0]);
        }
        setIsRunning(isPaused());
        WhisperUploadService.access$500(WhisperUploadService.this);
        return;
        String s = WhisperUploadService.access$1500(WhisperUploadService.this);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        GLogger.w(WhisperUploadService.access$1000(), "Device not registered. Uploading aborted.", new Object[0]);
        if (isPaused())
        {
            GLogger.i(WhisperUploadService.access$1000(), "Upload is paused, keeping service alive...", new Object[0]);
        }
        setIsRunning(isPaused());
        WhisperUploadService.access$500(WhisperUploadService.this);
        return;
        setIsPaused(false);
        QueueType queuetype;
        mission mission;
        for (Iterator iterator = queueTypes.iterator(); iterator.hasNext(); multiQueueUploader.onUploadScheduled(queuetype, mission, s, cancelSignal))
        {
            queuetype = (QueueType)iterator.next();
            mission = new mission(WhisperUploadService.this, null);
            cancelSignal.set(false);
        }

        break MISSING_BLOCK_LABEL_285;
        Object obj;
        obj;
        GLogger.i(WhisperUploadService.access$1000(), "Account locked, disable uploading", new Object[0]);
        if (WhisperUploadService.access$1700(WhisperUploadService.this) != null)
        {
            WhisperUploadService.access$1700(WhisperUploadService.this).edit().rUploadService("auto_upload_photos_key", false).rUploadService();
            WhisperUploadService.access$1700(WhisperUploadService.this).edit().rUploadService("auto_upload_videos_key", false).rUploadService();
        }
_L1:
        if (queueTypes.contains(QueueType.AUTO_SAVE))
        {
            ((UploadNotificationHandler)ThorGalleryApplication.getBean(Keys.UPLOAD_NOTIFICATION_HANDLER)).removeForegroundService();
        }
        GLogger.d(WhisperUploadService.access$1000(), "Uploading complete.", new Object[0]);
        if (isPaused())
        {
            GLogger.i(WhisperUploadService.access$1000(), "Upload is paused, keeping service alive...", new Object[0]);
        }
        setIsRunning(isPaused());
        WhisperUploadService.access$500(WhisperUploadService.this);
        return;
        obj;
        GLogger.ex(WhisperUploadService.access$1000(), "Unexpected error encountered", ((Throwable) (obj)));
          goto _L1
        obj;
        if (isPaused())
        {
            GLogger.i(WhisperUploadService.access$1000(), "Upload is paused, keeping service alive...", new Object[0]);
        }
        setIsRunning(isPaused());
        WhisperUploadService.access$500(WhisperUploadService.this);
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


    transient mission(QueueType aqueuetype[])
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
