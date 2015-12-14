// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.notifications;

import android.app.Service;
import android.content.Context;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.network.multiqueueuploader.QueueType;

// Referenced classes of package com.amazon.gallery.framework.kindle.notifications:
//            UploadNotification, ManualUploadNotification

public class UploadNotificationHandler
{

    private UploadNotification autoSaveNotif;
    private final Context context;
    private final DiskStore diskStore;
    private UploadNotification manualNotif;
    private final Profiler profiler;

    public UploadNotificationHandler(Context context1, DiskStore diskstore, Profiler profiler1)
    {
        context = context1;
        diskStore = diskstore;
        profiler = profiler1;
    }

    public void clearCompleteNotification()
    {
        if (autoSaveNotif != null)
        {
            autoSaveNotif.clearCompleteNotification();
        }
        if (manualNotif != null)
        {
            manualNotif.clearCompleteNotification();
        }
    }

    public void clearNotification(QueueType queuetype)
    {
        if (autoSaveNotif != null && queuetype == QueueType.AUTO_SAVE)
        {
            autoSaveNotif.clearNotification();
            autoSaveNotif.deregisterNotification();
        } else
        if (manualNotif != null && queuetype == QueueType.MANUAL)
        {
            manualNotif.clearNotification();
            manualNotif.deregisterNotification();
            return;
        }
    }

    public void createAutoSaveNotification()
    {
        if (autoSaveNotif == null)
        {
            autoSaveNotif = new UploadNotification(context, QueueType.AUTO_SAVE, diskStore, profiler);
        }
        if (!autoSaveNotif.isListenerRegistered())
        {
            autoSaveNotif.registerNotification();
        }
    }

    public void createManualNotification()
    {
        if (manualNotif == null)
        {
            manualNotif = new ManualUploadNotification(context, QueueType.MANUAL, diskStore, profiler);
        }
        if (!manualNotif.isListenerRegistered())
        {
            manualNotif.registerNotification();
        }
    }

    public void removeForegroundService()
    {
        if (autoSaveNotif != null)
        {
            autoSaveNotif.removeForegroundService();
        }
    }

    public void setForegroundService(Service service)
    {
        if (autoSaveNotif != null)
        {
            autoSaveNotif.setForegroundService(service);
        }
    }
}
