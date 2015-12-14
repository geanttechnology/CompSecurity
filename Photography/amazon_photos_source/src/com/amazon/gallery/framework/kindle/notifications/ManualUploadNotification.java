// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.notifications;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.RemoteViews;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.network.multiqueueuploader.QueueType;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadActionEvent;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadControlAction;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadStatus;

// Referenced classes of package com.amazon.gallery.framework.kindle.notifications:
//            UploadNotification, UploadNotificationFactory, NotificationState

public class ManualUploadNotification extends UploadNotification
{

    public ManualUploadNotification(Context context, QueueType queuetype, DiskStore diskstore, Profiler profiler)
    {
        super(context, queuetype, diskstore, profiler);
    }

    protected RemoteViews createExpandedNotification()
    {
        return uploadNotificationFactory.getExpandedManualUploadNotification();
    }

    protected RemoteViews createNotification()
    {
        return uploadNotificationFactory.getManualUploadNotification();
    }

    protected IntentFilter getIntentFilter()
    {
        IntentFilter intentfilter = super.getIntentFilter();
        intentfilter.addAction(UploadControlAction.CANCEL.toString());
        return intentfilter;
    }

    protected String getNotificationSubtitle()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState = new int[NotificationState.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.ACTIVE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.PAUSED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.NO_SPACE_ALL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.NO_SPACE_PHOTOS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.UNKNOWN_PROBLEM.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.COMPLETE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.CANCELED.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.NO_NETWORK.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.WAITING_FOR_WIFI.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.WAITING_FOR_POWER.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.LOW_BATTERY.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.gallery.framework.kindle.notifications.NotificationState[notificationState.ordinal()])
        {
        default:
            return super.getNotificationSubtitle();

        case 8: // '\b'
            return context.getString(0x7f0e0115);

        case 9: // '\t'
            return context.getString(0x7f0e0115);

        case 10: // '\n'
        case 11: // '\013'
            GLogger.errorStackTrace(TAG, "Manual upload notification is in invalid state: %s.", new Object[] {
                notificationState
            });
            return context.getString(0x7f0e0115);

        case 5: // '\005'
            return String.format(context.getString(0x7f0e010f), new Object[] {
                Long.valueOf(uploadStatus.getTotalItems() - (uploadStatus.getCurrentItemNumber() - 1L))
            });

        case 6: // '\006'
            return String.format(context.getString(0x7f0e010d), new Object[] {
                Long.valueOf(uploadStatus.getRealCurrentItemNumber() - 1L), Double.valueOf((double)uploadStatus.getTotalBytes() / 1048576D)
            });

        case 7: // '\007'
            return String.format(context.getString(0x7f0e010b), new Object[] {
                Long.valueOf(uploadStatus.getCurrentItemNumber() - 1L), Long.valueOf(uploadStatus.getTotalItems()), Double.valueOf((double)uploadStatus.getUploadedBytes() / 1048576D)
            });
        }
    }

    protected String getNotificationTitle()
    {
        switch (_cls1..SwitchMap.com.amazon.gallery.framework.kindle.notifications.NotificationState[notificationState.ordinal()])
        {
        case 3: // '\003'
        case 4: // '\004'
        default:
            return super.getNotificationTitle();

        case 1: // '\001'
            return String.format(context.getString(0x7f0e0107), new Object[] {
                Long.valueOf(uploadStatus.getCurrentItemNumber()), Long.valueOf(uploadStatus.getTotalItems())
            });

        case 2: // '\002'
            return String.format(context.getString(0x7f0e0112), new Object[] {
                Long.valueOf(uploadStatus.getCurrentItemNumber()), Long.valueOf(uploadStatus.getTotalItems())
            });

        case 5: // '\005'
            return context.getString(0x7f0e010e);

        case 6: // '\006'
            return context.getString(0x7f0e010c);

        case 7: // '\007'
            return context.getString(0x7f0e010a);
        }
    }

    protected void handleIntent(Intent intent)
    {
        super.handleIntent(intent);
        NotificationState notificationstate = notificationState;
        UploadControlAction uploadcontrolaction = null;
        if (intent.getAction() == UploadControlAction.CANCEL.toString())
        {
            uploadcontrolaction = UploadControlAction.CANCEL;
            updateNotificationState(NotificationState.CANCELED);
            updateNotification();
            GlobalMessagingBus.post(new UploadActionEvent(queueType, uploadcontrolaction, TAG));
        }
        if (uploadcontrolaction != null)
        {
            logMetric(uploadcontrolaction, notificationstate);
        }
    }

    protected void onUnknownProblem()
    {
        profiler.trackEvent(UploadNotification.MetricsEvent.ManualUploadFailNotificationDisplayed);
    }

    protected boolean shouldCancelNotificationUpdate()
    {
        return false;
    }

    protected void updateRemoteViews(RemoteViews remoteviews, String s, String s1)
    {
        _cls1..SwitchMap.com.amazon.gallery.framework.kindle.notifications.NotificationState[notificationState.ordinal()];
        JVM INSTR tableswitch 1 7: default 52
    //                   1 128
    //                   2 147
    //                   3 158
    //                   4 158
    //                   5 169
    //                   6 180
    //                   7 199;
           goto _L1 _L2 _L3 _L4 _L4 _L5 _L6 _L7
_L1:
        remoteviews.setTextViewText(0x7f0c013e, s);
        remoteviews.setTextViewText(0x7f0c013f, s1);
        int i = 0;
        if (notificationState.stateType == NotificationState.StateType.PROGRESS)
        {
            i = uploadStatus.getUploadProgress();
        }
        remoteviews.setProgressBar(0x7f0c0140, 100, i, false);
        if (notificationState != NotificationState.UNKNOWN_PROBLEM) goto _L9; else goto _L8
_L8:
        remoteviews.setViewVisibility(0x7f0c0137, 8);
        remoteviews.setViewVisibility(0x7f0c0138, 0);
_L11:
        return;
_L2:
        enableView(remoteviews, 0x7f0c013c, true);
        enableView(remoteviews, 0x7f0c013a, true);
        continue; /* Loop/switch isn't completed */
_L3:
        enableView(remoteviews, 0x7f0c013b, true);
        continue; /* Loop/switch isn't completed */
_L4:
        enableView(remoteviews, 0x7f0c013a, true);
        continue; /* Loop/switch isn't completed */
_L5:
        enableView(remoteviews, 0x7f0c013b, true);
        continue; /* Loop/switch isn't completed */
_L6:
        enableView(remoteviews, 0x7f0c013a, false);
        enableView(remoteviews, 0x7f0c0140, false);
        continue; /* Loop/switch isn't completed */
_L7:
        enableView(remoteviews, 0x7f0c013a, false);
        enableView(remoteviews, 0x7f0c0140, false);
        continue; /* Loop/switch isn't completed */
_L9:
        if (currentBitmap == null) goto _L11; else goto _L10
_L10:
        remoteviews.setImageViewBitmap(0x7f0c0137, currentBitmap);
        remoteviews.setViewVisibility(0x7f0c0137, 0);
        remoteviews.setViewVisibility(0x7f0c0138, 8);
        return;
        if (true) goto _L1; else goto _L12
_L12:
    }
}
