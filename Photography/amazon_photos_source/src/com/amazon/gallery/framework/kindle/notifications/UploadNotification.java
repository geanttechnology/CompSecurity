// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.amazon.gallery.foundation.gfx.texture.LocalVideoThumbnailResource;
import com.amazon.gallery.foundation.image.BitmapDecoder;
import com.amazon.gallery.foundation.image.VideoThumbnailUtils;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.math.MathUtils;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.store.Asset;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.network.exceptions.CloudStorageLimitException;
import com.amazon.gallery.framework.network.multiqueueuploader.QueueType;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadActionEvent;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadControlAction;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadError;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadListener;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadListenerEvent;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadStatus;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.kindle.notifications:
//            UploadNotificationFactory, NotificationState

public class UploadNotification
    implements UploadListener
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent AutoSaveFailNotificationDisplayed;
        public static final MetricsEvent AutoSaveQueuePaused;
        public static final MetricsEvent AutoSaveQueueResumed;
        public static final MetricsEvent AutoSaveQueueRetried;
        public static final MetricsEvent ManualQueueCancelled;
        public static final MetricsEvent ManualQueuePaused;
        public static final MetricsEvent ManualQueueResumed;
        public static final MetricsEvent ManualQueueRetried;
        public static final MetricsEvent ManualUploadFailNotificationDisplayed;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/kindle/notifications/UploadNotification$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            AutoSaveQueuePaused = new MetricsEvent("AutoSaveQueuePaused", 0);
            AutoSaveQueueResumed = new MetricsEvent("AutoSaveQueueResumed", 1);
            AutoSaveQueueRetried = new MetricsEvent("AutoSaveQueueRetried", 2);
            ManualQueuePaused = new MetricsEvent("ManualQueuePaused", 3);
            ManualQueueResumed = new MetricsEvent("ManualQueueResumed", 4);
            ManualQueueRetried = new MetricsEvent("ManualQueueRetried", 5);
            ManualQueueCancelled = new MetricsEvent("ManualQueueCancelled", 6);
            AutoSaveFailNotificationDisplayed = new MetricsEvent("AutoSaveFailNotificationDisplayed", 7);
            ManualUploadFailNotificationDisplayed = new MetricsEvent("ManualUploadFailNotificationDisplayed", 8);
            $VALUES = (new MetricsEvent[] {
                AutoSaveQueuePaused, AutoSaveQueueResumed, AutoSaveQueueRetried, ManualQueuePaused, ManualQueueResumed, ManualQueueRetried, ManualQueueCancelled, AutoSaveFailNotificationDisplayed, ManualUploadFailNotificationDisplayed
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String TAG = com/amazon/gallery/framework/kindle/notifications/UploadNotification.getName();
    private final int ASSET_HEIGHT = 256;
    private final int ASSET_WIDTH = 256;
    private int bitmapHeight;
    private int bitmapWidth;
    protected final android.support.v4.app.NotificationCompat.Builder builder;
    protected final Context context;
    protected Bitmap currentBitmap;
    private final DiskStore diskStore;
    private Service foregroundService;
    protected IntentFilter intentFilter;
    protected boolean isOutOfStorage;
    protected boolean needNewBitmap;
    protected final NotificationManager notificationManager;
    private BroadcastReceiver notificationReceiver;
    protected NotificationState notificationState;
    protected final ComponentProfiler profiler;
    protected final QueueType queueType;
    private boolean registeredListener;
    private boolean registeredReceiver;
    protected final UploadNotificationFactory uploadNotificationFactory;
    protected UploadStatus uploadStatus;

    public UploadNotification(Context context1, QueueType queuetype, DiskStore diskstore, Profiler profiler1)
    {
        notificationReceiver = new BroadcastReceiver() {

            final UploadNotification this$0;

            public void onReceive(Context context2, Intent intent)
            {
                handleIntent(intent);
            }

            
            {
                this$0 = UploadNotification.this;
                super();
            }
        };
        isOutOfStorage = false;
        context = context1;
        queueType = queuetype;
        diskStore = diskstore;
        profiler = new ComponentProfiler(profiler1, com/amazon/gallery/framework/kindle/notifications/UploadNotification);
        uploadNotificationFactory = new UploadNotificationFactory(context1, queuetype);
        notificationManager = (NotificationManager)context1.getSystemService("notification");
        builder = new android.support.v4.app.NotificationCompat.Builder(context1);
        if (BuildFlavors.isAosp())
        {
            builder.setSmallIcon(0x7f020155);
        } else
        {
            builder.setSmallIcon(0x106000d);
        }
        bitmapWidth = context1.getResources().getDimensionPixelSize(0x7f0a018e);
        bitmapHeight = context1.getResources().getDimensionPixelSize(0x7f0a018d);
        intentFilter = getIntentFilter();
    }

    private void loadBitmapAsyncAndUpdate(MediaItem mediaitem)
    {
        if (currentBitmap != null && !needNewBitmap)
        {
            return;
        } else
        {
            (new AsyncTask() {

                final UploadNotification this$0;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((MediaItem[])aobj);
                }

                protected transient Void doInBackground(MediaItem amediaitem[])
                {
                    loadBitmapSync(amediaitem[0]);
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    updateNotification();
                }

            
            {
                this$0 = UploadNotification.this;
                super();
            }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new MediaItem[] {
                mediaitem
            });
            return;
        }
    }

    private void loadBitmapSync(MediaItem mediaitem)
    {
        currentBitmap = null;
        if (mediaitem.getType() != MediaType.VIDEO) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = new LocalVideoThumbnailResource(mediaitem.getObjectId(), mediaitem.getLocalPath(), mediaitem.getName());
        obj = VideoThumbnailUtils.getThumbnailFromCache(context, ((LocalVideoThumbnailResource) (obj)), 1);
_L10:
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (!((File) (obj)).exists()) goto _L4; else goto _L5
_L5:
        if (android.os.Build.VERSION.SDK_INT < 21) goto _L7; else goto _L6
_L6:
        currentBitmap = getCroppedBitmap(BitmapDecoder.loadBitmapFromFile(context, ((File) (obj)).getAbsolutePath(), bitmapWidth * 2, bitmapHeight * 2, mediaitem.getOrientation()), bitmapWidth);
_L8:
        needNewBitmap = false;
        return;
_L2:
        obj = diskStore.getAsset(mediaitem, 256, 256, com.amazon.gallery.framework.data.store.Asset.AssetType.JPG);
        if (obj == null || !((Asset) (obj)).getAsset().exists())
        {
            File file = diskStore.getOriginal(mediaitem);
            obj = file;
            if (!file.exists())
            {
                obj = file;
                if (mediaitem.getLocalPath() != null)
                {
                    obj = new File(mediaitem.getLocalPath());
                }
            }
        } else
        {
            obj = ((Asset) (obj)).getAsset();
        }
        continue; /* Loop/switch isn't completed */
_L7:
        currentBitmap = BitmapDecoder.loadBitmapFromFile(context, ((File) (obj)).getAbsolutePath(), bitmapWidth, bitmapHeight, mediaitem.getOrientation());
          goto _L8
_L4:
        try
        {
            GLogger.e(TAG, "Asset file does not exist", new Object[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediaItem mediaitem)
        {
            GLogger.e(TAG, "error loading bitmap. %s", new Object[] {
                mediaitem.getMessage()
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediaItem mediaitem)
        {
            GLogger.ex(TAG, "Unexpected error while attempting to load bitmap.", mediaitem);
        }
        return;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private void toggleListener()
    {
        if (notificationState.stateType == NotificationState.StateType.NO_PROGRESS)
        {
            if (registeredReceiver)
            {
                context.unregisterReceiver(notificationReceiver);
                registeredReceiver = false;
            }
        } else
        if (!registeredReceiver)
        {
            context.registerReceiver(notificationReceiver, intentFilter);
            registeredReceiver = true;
            return;
        }
    }

    private void uploadsComplete()
    {
        if (isOutOfStorage)
        {
            isOutOfStorage = false;
            if (uploadStatus.hasBatchFailed(com.amazon.gallery.framework.network.multiqueueuploader.UploadBatchFactory.UploadBatchType.NON_CAMERA_PHOTO))
            {
                updateNotificationState(NotificationState.NO_SPACE_PHOTOS);
                return;
            } else
            {
                updateNotificationState(NotificationState.NO_SPACE_ALL);
                return;
            }
        } else
        {
            updateNotificationState(NotificationState.COMPLETE);
            return;
        }
    }

    public void clearCompleteNotification()
    {
        if (shouldAutoCancel())
        {
            clearNotification();
        }
    }

    public void clearNotification()
    {
        if (foregroundService != null)
        {
            GLogger.i(TAG, "Clearing foreground service notification. Making service background.", new Object[0]);
            foregroundService.stopForeground(false);
        }
        notificationManager.cancel(queueType.hashCode());
    }

    protected RemoteViews createExpandedNotification()
    {
        return uploadNotificationFactory.getExpandedUploadNotification();
    }

    protected RemoteViews createNotification()
    {
        return uploadNotificationFactory.getUploadNotification();
    }

    protected void deregisterNotification()
    {
        GlobalMessagingBus.post(new UploadListenerEvent(com.amazon.gallery.framework.network.multiqueueuploader.UploadListenerEvent.Action.REMOVE, queueType, this));
        registeredListener = false;
    }

    protected void enableView(RemoteViews remoteviews, int i, boolean flag)
    {
        int j;
        if (flag)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        remoteviews.setViewVisibility(i, j);
    }

    protected PendingIntent getContentIntent()
    {
        PendingIntent pendingintent = uploadNotificationFactory.getAllViewIntent();
        static class _cls3
        {

            static final int $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[];
            static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[];
            static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction = new int[UploadControlAction.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[UploadControlAction.RESUME.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[UploadControlAction.PAUSE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[UploadControlAction.CANCEL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError = new int[UploadError.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.NO_SPACE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.NO_NETWORK.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.WAITING_FOR_WIFI.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.WAITING_FOR_POWER.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.LOW_BATTERY.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadError[UploadError.UNKNOWN_ERROR.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState = new int[NotificationState.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.ACTIVE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.PAUSED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.NO_SPACE_ALL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.NO_SPACE_PHOTOS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.UNKNOWN_PROBLEM.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.COMPLETE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.NO_NETWORK.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.WAITING_FOR_WIFI.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.WAITING_FOR_POWER.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$notifications$NotificationState[NotificationState.LOW_BATTERY.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3..SwitchMap.com.amazon.gallery.framework.kindle.notifications.NotificationState[notificationState.ordinal()])
        {
        default:
            return pendingintent;

        case 3: // '\003'
        case 4: // '\004'
            return uploadNotificationFactory.getManageStorageIntent();
        }
    }

    public Bitmap getCroppedBitmap(Bitmap bitmap, int i)
    {
        if (bitmap == null)
        {
            return null;
        } else
        {
            Bitmap bitmap1 = Bitmap.createBitmap(i, i, android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap1);
            Paint paint = new Paint();
            RectF rectf = new RectF(0.0F, 0.0F, bitmap.getWidth(), bitmap.getHeight());
            rectf = MathUtils.scaleToFill(i, i, rectf);
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(0xff424242);
            canvas.drawCircle(i / 2, i / 2, i / 2, paint);
            paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, null, rectf, paint);
            return bitmap1;
        }
    }

    protected IntentFilter getIntentFilter()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction(UploadControlAction.PAUSE.toString());
        intentfilter.addAction(UploadControlAction.RESUME.toString());
        return intentfilter;
    }

    protected String getNotificationSubtitle()
    {
        switch (_cls3..SwitchMap.com.amazon.gallery.framework.kindle.notifications.NotificationState[notificationState.ordinal()])
        {
        default:
            throw new UnsupportedOperationException((new StringBuilder()).append("Notification state must have a state: ").append(notificationState).toString());

        case 1: // '\001'
            return String.format(context.getString(0x7f0e0106), new Object[] {
                Double.valueOf((double)uploadStatus.getUploadedBytes() / 1048576D), Double.valueOf((double)uploadStatus.getTotalBytes() / 1048576D)
            });

        case 2: // '\002'
            return String.format(context.getString(0x7f0e0106), new Object[] {
                Double.valueOf((double)uploadStatus.getUploadedBytes() / 1048576D), Double.valueOf((double)uploadStatus.getTotalBytes() / 1048576D)
            });

        case 3: // '\003'
            return context.getString(0x7f0e0108);

        case 4: // '\004'
            if (BuildFlavors.isAosp())
            {
                return "";
            } else
            {
                return context.getString(0x7f0e0113);
            }

        case 7: // '\007'
            return context.getString(0x7f0e00ff);

        case 8: // '\b'
            return context.getString(0x7f0e00ff);

        case 9: // '\t'
            return context.getString(0x7f0e0100);

        case 10: // '\n'
            return context.getString(0x7f0e0100);

        case 5: // '\005'
            return String.format(context.getString(0x7f0e00fc), new Object[] {
                Long.valueOf(uploadStatus.getTotalItems() - (uploadStatus.getCurrentItemNumber() - 1L))
            });

        case 6: // '\006'
            Calendar calendar = Calendar.getInstance();
            return String.format(context.getString(0x7f0e00fa), new Object[] {
                calendar.getTime().toString()
            });
        }
    }

    protected String getNotificationTitle()
    {
        switch (_cls3..SwitchMap.com.amazon.gallery.framework.kindle.notifications.NotificationState[notificationState.ordinal()])
        {
        default:
            throw new UnsupportedOperationException((new StringBuilder()).append("Notification state must have a state: ").append(notificationState).toString());

        case 1: // '\001'
            return String.format(context.getString(0x7f0e00f8), new Object[] {
                Long.valueOf(uploadStatus.getCurrentItemNumber()), Long.valueOf(uploadStatus.getTotalItems())
            });

        case 2: // '\002'
            return String.format(context.getString(0x7f0e00fe), new Object[] {
                Long.valueOf(uploadStatus.getCurrentItemNumber()), Long.valueOf(uploadStatus.getTotalItems())
            });

        case 3: // '\003'
            return context.getString(0x7f0e0101);

        case 4: // '\004'
            return context.getString(0x7f0e0102);

        case 7: // '\007'
            return context.getString(0x7f0e0105);

        case 8: // '\b'
            return context.getString(0x7f0e0117);

        case 9: // '\t'
            return context.getString(0x7f0e0116);

        case 10: // '\n'
            return context.getString(0x7f0e0312);

        case 5: // '\005'
            return context.getString(0x7f0e00fb);

        case 6: // '\006'
            return context.getString(0x7f0e00f9);
        }
    }

    protected void handleIntent(Intent intent)
    {
        if (!intent.hasExtra("queueType"))
        {
            GLogger.e(TAG, "Could not handle incoming action due to an invalid intent", new Object[0]);
        }
        if (intent.getExtras().get("queueType") == queueType)
        {
            NotificationState notificationstate = notificationState;
            UploadControlAction uploadcontrolaction = null;
            if (intent.getAction() == UploadControlAction.PAUSE.toString())
            {
                uploadcontrolaction = UploadControlAction.PAUSE;
                GlobalMessagingBus.post(new UploadActionEvent(queueType, uploadcontrolaction, TAG));
                updateNotificationState(NotificationState.PAUSED);
                updateNotification();
            } else
            if (intent.getAction() == UploadControlAction.RESUME.toString())
            {
                uploadcontrolaction = UploadControlAction.RESUME;
                GlobalMessagingBus.post(new UploadActionEvent(queueType, uploadcontrolaction, TAG));
                updateNotificationState(NotificationState.ACTIVE);
                updateNotification();
            }
            if (uploadcontrolaction != null)
            {
                logMetric(uploadcontrolaction, notificationstate);
                return;
            }
        }
    }

    public boolean isListenerRegistered()
    {
        return registeredListener;
    }

    protected void logMetric(UploadControlAction uploadcontrolaction, NotificationState notificationstate)
    {
        _cls3..SwitchMap.com.amazon.gallery.framework.network.multiqueueuploader.UploadControlAction[uploadcontrolaction.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 37
    //                   2 108
    //                   3 140;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        if (notificationstate == NotificationState.UNKNOWN_PROBLEM)
        {
            notificationstate = profiler;
            if (queueType == QueueType.AUTO_SAVE)
            {
                uploadcontrolaction = MetricsEvent.AutoSaveQueueRetried;
            } else
            {
                uploadcontrolaction = MetricsEvent.ManualQueueRetried;
            }
            notificationstate.trackEvent(uploadcontrolaction);
            return;
        }
        notificationstate = profiler;
        if (queueType == QueueType.AUTO_SAVE)
        {
            uploadcontrolaction = MetricsEvent.AutoSaveQueueResumed;
        } else
        {
            uploadcontrolaction = MetricsEvent.ManualQueueResumed;
        }
        notificationstate.trackEvent(uploadcontrolaction);
        return;
_L3:
        notificationstate = profiler;
        if (queueType == QueueType.AUTO_SAVE)
        {
            uploadcontrolaction = MetricsEvent.AutoSaveQueuePaused;
        } else
        {
            uploadcontrolaction = MetricsEvent.ManualQueuePaused;
        }
        notificationstate.trackEvent(uploadcontrolaction);
        return;
_L4:
        if (queueType == QueueType.MANUAL)
        {
            profiler.trackEvent(MetricsEvent.ManualQueueCancelled);
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected void onUnknownProblem()
    {
        profiler.trackEvent(MetricsEvent.AutoSaveFailNotificationDisplayed);
    }

    public void onUploadError(UploadStatus uploadstatus, UploadError uploaderror, QueueType queuetype)
    {
        if (queueType != queuetype)
        {
            return;
        }
        setUploadStatus(uploadstatus);
        _cls3..SwitchMap.com.amazon.gallery.framework.network.multiqueueuploader.UploadError[uploaderror.ordinal()];
        JVM INSTR tableswitch 1 6: default 60
    //                   1 82
    //                   2 112
    //                   3 122
    //                   4 132
    //                   5 142
    //                   6 152;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        updateNotification();
        GLogger.v(TAG, "%s notification successfully updated onUploadError", new Object[] {
            queuetype
        });
        return;
_L2:
        if (uploadstatus.hasBatchFailed(com.amazon.gallery.framework.network.multiqueueuploader.UploadBatchFactory.UploadBatchType.NON_CAMERA_PHOTO))
        {
            updateNotificationState(NotificationState.NO_SPACE_PHOTOS);
        } else
        {
            updateNotificationState(NotificationState.NO_SPACE_ALL);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        updateNotificationState(NotificationState.NO_NETWORK);
        continue; /* Loop/switch isn't completed */
_L4:
        updateNotificationState(NotificationState.WAITING_FOR_WIFI);
        continue; /* Loop/switch isn't completed */
_L5:
        updateNotificationState(NotificationState.WAITING_FOR_POWER);
        continue; /* Loop/switch isn't completed */
_L6:
        updateNotificationState(NotificationState.LOW_BATTERY);
        continue; /* Loop/switch isn't completed */
_L7:
        updateNotificationState(NotificationState.UNKNOWN_PROBLEM);
        if (true) goto _L1; else goto _L8
_L8:
    }

    public void onUploadFailed(UploadStatus uploadstatus, QueueType queuetype, Exception exception)
    {
        if (queueType != queuetype)
        {
            return;
        }
        setUploadStatus(uploadstatus);
        GLogger.i(TAG, "Failed to upload media item: %s", new Object[] {
            exception
        });
        if (exception instanceof CloudStorageLimitException)
        {
            isOutOfStorage = true;
        }
        needNewBitmap = true;
        if (uploadstatus.isUploadComplete())
        {
            uploadsComplete();
            updateNotification();
        }
        GLogger.v(TAG, "%s notification successfully updated onUploadFailed", new Object[] {
            queuetype
        });
    }

    public void onUploadProgressChanged(UploadStatus uploadstatus, MediaItem mediaitem, QueueType queuetype, int i, int j)
    {
        if (queueType != queuetype)
        {
            return;
        } else
        {
            setUploadStatus(uploadstatus);
            loadBitmapAsyncAndUpdate(mediaitem);
            updateNotificationState(NotificationState.ACTIVE);
            updateNotification();
            GLogger.v(TAG, "%s notification successfully updated onUploadProgressChanged", new Object[] {
                queuetype
            });
            return;
        }
    }

    public void onUploadQueued(UploadStatus uploadstatus, List list, QueueType queuetype)
    {
        if (queueType != queuetype && list.size() > 0)
        {
            return;
        }
        if (notificationState != NotificationState.PAUSED)
        {
            updateNotificationState(NotificationState.ACTIVE);
        }
        setUploadStatus(uploadstatus);
        loadBitmapAsyncAndUpdate((MediaItem)list.get(0));
        updateNotification();
        GLogger.v(TAG, "%s notification successfully updated onUploadQueued", new Object[] {
            queuetype
        });
    }

    public void onUploadSuccessful(UploadStatus uploadstatus, QueueType queuetype)
    {
        if (queueType != queuetype)
        {
            return;
        }
        setUploadStatus(uploadstatus);
        needNewBitmap = true;
        if (uploadstatus.isUploadComplete())
        {
            uploadsComplete();
            updateNotification();
        }
        GLogger.v(TAG, "%s notification successfully updated onUploadSuccessful", new Object[] {
            queuetype
        });
    }

    protected void registerNotification()
    {
        GlobalMessagingBus.post(new UploadListenerEvent(com.amazon.gallery.framework.network.multiqueueuploader.UploadListenerEvent.Action.ADD, queueType, this));
        registeredListener = true;
    }

    public void removeForegroundService()
    {
        if (foregroundService != null)
        {
            GLogger.i(TAG, "Making service background.", new Object[0]);
            foregroundService.stopForeground(false);
            foregroundService = null;
        }
    }

    public void setForegroundService(Service service)
    {
        GLogger.i(TAG, "Setting ForegroundService: %s", new Object[] {
            service
        });
        if (foregroundService != null)
        {
            GLogger.i(TAG, "Foreground service already set", new Object[0]);
        } else
        {
            foregroundService = service;
            if (foregroundService != null && uploadStatus != null)
            {
                updateNotification();
                return;
            }
        }
    }

    protected void setUploadStatus(UploadStatus uploadstatus)
    {
        uploadStatus = uploadstatus;
    }

    protected boolean shouldAutoCancel()
    {
        return NotificationState.COMPLETE == notificationState || NotificationState.CANCELED == notificationState;
    }

    protected boolean shouldCancelNotificationUpdate()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (uploadStatus.getTotalItems() == 0L)
        {
            flag = flag1;
            if (uploadStatus.getTotalBytes() == 0L)
            {
                GLogger.e(TAG, "Trying to show notification without any upload status.", new Object[0]);
                flag = true;
            }
        }
        return flag;
    }

    protected void updateBuilder(RemoteViews remoteviews, RemoteViews remoteviews1, String s, String s1, boolean flag, PendingIntent pendingintent)
    {
        builder.setOngoing(notificationState.stateType.isOnGoing()).setContentTitle(s).setContentText(s1).setContent(remoteviews).setAutoCancel(flag).setContentIntent(pendingintent);
        remoteviews = builder.build();
        if (Api.isAtLeastJellyBean())
        {
            remoteviews.bigContentView = remoteviews1;
        }
        if (foregroundService == null)
        {
            notificationManager.notify(queueType.hashCode(), remoteviews);
            return;
        } else
        {
            foregroundService.startForeground(queueType.hashCode(), remoteviews);
            return;
        }
    }

    protected void updateNotification()
    {
        if (shouldCancelNotificationUpdate())
        {
            return;
        }
        String s = getNotificationTitle();
        String s1 = getNotificationSubtitle();
        boolean flag = shouldAutoCancel();
        PendingIntent pendingintent = getContentIntent();
        if (notificationState == NotificationState.UNKNOWN_PROBLEM)
        {
            onUnknownProblem();
        }
        RemoteViews remoteviews = createNotification();
        RemoteViews remoteviews1 = createExpandedNotification();
        updateRemoteViews(remoteviews, s, s1);
        updateRemoteViews(remoteviews1, s, s1);
        updateBuilder(remoteviews, remoteviews1, s, s1, flag, pendingintent);
    }

    protected void updateNotificationState(NotificationState notificationstate)
    {
        if (notificationState == null || notificationState != null && notificationState.stateType != notificationstate.stateType)
        {
            String s1 = TAG;
            String s;
            if (notificationState == null)
            {
                s = "Dismissing notification from previous process (if any)";
            } else
            {
                s = "Dismissing notification due to state group change";
            }
            GLogger.d(s1, s, new Object[0]);
            clearNotification();
        }
        if (notificationState != notificationstate)
        {
            GLogger.v(TAG, "Notification state updated from %s to %s", new Object[] {
                notificationState, notificationstate
            });
            notificationState = notificationstate;
            toggleListener();
        }
    }

    protected void updateRemoteViews(RemoteViews remoteviews, String s, String s1)
    {
        _cls3..SwitchMap.com.amazon.gallery.framework.kindle.notifications.NotificationState[notificationState.ordinal()];
        JVM INSTR tableswitch 1 6: default 48
    //                   1 129
    //                   2 150
    //                   3 48
    //                   4 48
    //                   5 162
    //                   6 174;
           goto _L1 _L2 _L3 _L1 _L1 _L4 _L5
_L1:
        remoteviews.setTextViewText(0x7f0c013e, s);
        remoteviews.setTextViewText(0x7f0c013f, s1);
        int i = 0;
        if (notificationState.stateType == NotificationState.StateType.PROGRESS)
        {
            i = uploadStatus.getUploadProgress();
        }
        remoteviews.setProgressBar(0x7f0c0140, 100, i, false);
        if (notificationState != NotificationState.UNKNOWN_PROBLEM) goto _L7; else goto _L6
_L6:
        remoteviews.setViewVisibility(0x7f0c0137, 8);
        remoteviews.setViewVisibility(0x7f0c0138, 0);
_L9:
        return;
_L2:
        enableView(remoteviews, 0x7f0c0140, true);
        enableView(remoteviews, 0x7f0c013c, true);
        continue; /* Loop/switch isn't completed */
_L3:
        enableView(remoteviews, 0x7f0c013b, true);
        continue; /* Loop/switch isn't completed */
_L4:
        enableView(remoteviews, 0x7f0c013b, true);
        continue; /* Loop/switch isn't completed */
_L5:
        enableView(remoteviews, 0x7f0c0140, false);
        continue; /* Loop/switch isn't completed */
_L7:
        if (currentBitmap == null) goto _L9; else goto _L8
_L8:
        remoteviews.setImageViewBitmap(0x7f0c0137, currentBitmap);
        remoteviews.setViewVisibility(0x7f0c0137, 0);
        remoteviews.setViewVisibility(0x7f0c0138, 8);
        return;
        if (true) goto _L1; else goto _L10
_L10:
    }


}
