// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.notifications;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.amazon.gallery.framework.network.multiqueueuploader.QueueType;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadControlAction;
import com.amazon.gallery.thor.GalleryWebViewHelper;
import com.amazon.gallery.thor.app.activity.ThorNativeGalleryActivity;

public class UploadNotificationFactory
{

    private final Context context;
    private PendingIntent pendingAllViewIntent;
    private PendingIntent pendingCancelIntent;
    private PendingIntent pendingManageStorageIntent;
    private PendingIntent pendingPauseIntent;
    private PendingIntent pendingResumeIntent;
    private final QueueType queueType;

    public UploadNotificationFactory(Context context1, QueueType queuetype)
    {
        context = context1;
        queueType = queuetype;
    }

    private void setupIntents()
    {
        if (pendingManageStorageIntent != null) goto _L2; else goto _L1
_L1:
        Intent intent = GalleryWebViewHelper.getManageStorageIntent(context);
        if (intent != null) goto _L4; else goto _L3
_L3:
        return;
_L4:
        pendingManageStorageIntent = PendingIntent.getActivity(context, 0, intent, 0);
_L2:
        if (pendingAllViewIntent == null)
        {
            Intent intent1 = new Intent(context, com/amazon/gallery/thor/app/activity/ThorNativeGalleryActivity);
            intent1.addFlags(0x10000000);
            pendingAllViewIntent = PendingIntent.getActivity(context, 0, intent1, 0);
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    private void setupManualNotificationOptions()
    {
        if (pendingCancelIntent == null)
        {
            Intent intent = (new Intent(UploadControlAction.CANCEL.toString())).putExtra("queueType", queueType);
            pendingCancelIntent = PendingIntent.getBroadcast(context, queueType.hashCode(), intent, 0);
        }
    }

    private void setupManualUploadNotificationViews(RemoteViews remoteviews)
    {
        if (pendingCancelIntent != null)
        {
            remoteviews.setOnClickPendingIntent(0x7f0c013a, pendingCancelIntent);
        }
        remoteviews.setViewVisibility(0x7f0c013a, 0);
    }

    private void setupNotificationOptions()
    {
        if (pendingPauseIntent == null || pendingResumeIntent == null)
        {
            Intent intent = (new Intent(UploadControlAction.PAUSE.toString())).putExtra("queueType", queueType);
            Intent intent1 = (new Intent(UploadControlAction.RESUME.toString())).putExtra("queueType", queueType);
            pendingPauseIntent = PendingIntent.getBroadcast(context, queueType.hashCode(), intent, 0);
            pendingResumeIntent = PendingIntent.getBroadcast(context, queueType.hashCode(), intent1, 0);
        }
    }

    private void setupUploadNotificationViews(RemoteViews remoteviews)
    {
        if (pendingPauseIntent != null)
        {
            remoteviews.setOnClickPendingIntent(0x7f0c013c, pendingPauseIntent);
        }
        if (pendingResumeIntent != null)
        {
            remoteviews.setOnClickPendingIntent(0x7f0c013b, pendingResumeIntent);
        }
        remoteviews.setViewVisibility(0x7f0c013b, 8);
        remoteviews.setViewVisibility(0x7f0c013c, 8);
        remoteviews.setViewVisibility(0x7f0c0140, 0);
    }

    public PendingIntent getAllViewIntent()
    {
        return pendingAllViewIntent;
    }

    public RemoteViews getExpandedManualUploadNotification()
    {
        setupManualNotificationOptions();
        RemoteViews remoteviews = getExpandedUploadNotification();
        setupManualUploadNotificationViews(remoteviews);
        return remoteviews;
    }

    public RemoteViews getExpandedUploadNotification()
    {
        setupIntents();
        setupNotificationOptions();
        RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x7f03008b);
        setupUploadNotificationViews(remoteviews);
        return remoteviews;
    }

    public PendingIntent getManageStorageIntent()
    {
        return pendingManageStorageIntent;
    }

    public RemoteViews getManualUploadNotification()
    {
        setupManualNotificationOptions();
        RemoteViews remoteviews = getUploadNotification();
        setupManualUploadNotificationViews(remoteviews);
        return remoteviews;
    }

    public RemoteViews getUploadNotification()
    {
        setupIntents();
        setupNotificationOptions();
        RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x7f0300b9);
        setupUploadNotificationViews(remoteviews);
        return remoteviews;
    }
}
