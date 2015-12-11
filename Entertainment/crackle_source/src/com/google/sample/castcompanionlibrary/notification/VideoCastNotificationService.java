// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.TaskStackBuilder;
import android.widget.RemoteViews;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.sample.castcompanionlibrary.cast.VideoCastManager;
import com.google.sample.castcompanionlibrary.cast.callbacks.VideoCastConsumerImpl;
import com.google.sample.castcompanionlibrary.cast.exceptions.CastException;
import com.google.sample.castcompanionlibrary.cast.exceptions.NoConnectionException;
import com.google.sample.castcompanionlibrary.cast.exceptions.TransientNetworkDisconnectionException;
import com.google.sample.castcompanionlibrary.cast.player.VideoCastControllerActivity;
import com.google.sample.castcompanionlibrary.utils.LogUtils;
import com.google.sample.castcompanionlibrary.utils.Utils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class VideoCastNotificationService extends Service
{

    public static final String ACTION_STOP = "com.google.sample.castcompanionlibrary.action.stop";
    public static final String ACTION_TOGGLE_PLAYBACK = "com.google.sample.castcompanionlibrary.action.toggleplayback";
    public static final String ACTION_VISIBILITY = "com.google.sample.castcompanionlibrary.action.notificationvisibility";
    private static int NOTIFICATION_ID = 1;
    private static final String TAG = LogUtils.makeLogTag(com/google/sample/castcompanionlibrary/notification/VideoCastNotificationService);
    private boolean isPlaying;
    private String mApplicationId;
    private BroadcastReceiver mBroadcastReceiver;
    private VideoCastManager mCastManager;
    private VideoCastConsumerImpl mConsumer;
    boolean mIsIcsOrAbove;
    private Notification mNotification;
    private int mStatus;
    private Class mTargetActivity;
    private Bitmap mVideoArtBitmap;
    private Uri mVideoArtUri;
    private boolean mVisible;

    public VideoCastNotificationService()
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsIcsOrAbove = flag;
    }

    private void addPendingIntents(RemoteViews remoteviews, boolean flag)
    {
        Object obj = new Intent("com.google.sample.castcompanionlibrary.action.toggleplayback");
        ((Intent) (obj)).setPackage(getPackageName());
        obj = PendingIntent.getBroadcast(this, 0, ((Intent) (obj)), 0);
        Object obj1 = new Intent("com.google.sample.castcompanionlibrary.action.stop");
        ((Intent) (obj1)).setPackage(getPackageName());
        obj1 = PendingIntent.getBroadcast(this, 0, ((Intent) (obj1)), 0);
        remoteviews.setOnClickPendingIntent(com.google.sample.castcompanionlibrary.R.id.playPauseView, ((PendingIntent) (obj)));
        remoteviews.setOnClickPendingIntent(com.google.sample.castcompanionlibrary.R.id.removeView, ((PendingIntent) (obj1)));
        if (flag)
        {
            remoteviews.setImageViewResource(com.google.sample.castcompanionlibrary.R.id.playPauseView, com.google.sample.castcompanionlibrary.R.drawable.ic_av_pause_sm_dark);
            return;
        } else
        {
            remoteviews.setImageViewResource(com.google.sample.castcompanionlibrary.R.id.playPauseView, com.google.sample.castcompanionlibrary.R.drawable.ic_av_play_sm_dark);
            return;
        }
    }

    private RemoteViews build(MediaInfo mediainfo, Bitmap bitmap, boolean flag, Class class1)
        throws CastException, TransientNetworkDisconnectionException, NoConnectionException
    {
        class1 = Utils.fromMediaInfo(mCastManager.getRemoteMediaInformation());
        if (mTargetActivity == null)
        {
            mTargetActivity = com/google/sample/castcompanionlibrary/cast/player/VideoCastControllerActivity;
        }
        Object obj = new Intent(this, mTargetActivity);
        ((Intent) (obj)).putExtra("media", class1);
        TaskStackBuilder taskstackbuilder = TaskStackBuilder.create(this);
        taskstackbuilder.addParentStack(mTargetActivity);
        taskstackbuilder.addNextIntent(((Intent) (obj)));
        if (taskstackbuilder.getIntentCount() > 1)
        {
            taskstackbuilder.editIntentAt(1).putExtra("media", class1);
        }
        class1 = taskstackbuilder.getPendingIntent(NOTIFICATION_ID, 0x8000000);
        obj = mediainfo.getMetadata();
        mediainfo = new RemoteViews(getPackageName(), com.google.sample.castcompanionlibrary.R.layout.custom_notification);
        if (mIsIcsOrAbove)
        {
            addPendingIntents(mediainfo, flag);
        }
        if (bitmap != null)
        {
            mediainfo.setImageViewBitmap(com.google.sample.castcompanionlibrary.R.id.iconView, bitmap);
        }
        mediainfo.setTextViewText(com.google.sample.castcompanionlibrary.R.id.titleView, ((MediaMetadata) (obj)).getString("com.google.android.gms.cast.metadata.TITLE"));
        bitmap = getResources().getString(com.google.sample.castcompanionlibrary.R.string.casting_to_device, new Object[] {
            mCastManager.getDeviceName()
        });
        mediainfo.setTextViewText(com.google.sample.castcompanionlibrary.R.id.subTitleView, bitmap);
        mNotification = (new android.support.v4.app.NotificationCompat.Builder(this)).setSmallIcon(com.google.sample.castcompanionlibrary.R.drawable.ic_stat_action_notification).setContentIntent(class1).setContent(mediainfo).setAutoCancel(false).setOngoing(true).build();
        mNotification.contentView = mediainfo;
        return mediainfo;
    }

    private void onRemoteMediaPlayerStatusUpdated(int i)
    {
        mStatus = i;
        LogUtils.LOGD(TAG, (new StringBuilder()).append("onRemoteMediaPlayerMetadataUpdated() reached with status: ").append(mStatus).toString());
        i;
        JVM INSTR tableswitch 0 4: default 68
    //                   0 167
    //                   1 156
    //                   2 102
    //                   3 135
    //                   4 69;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L4:
        isPlaying = true;
        setupNotification(mCastManager.getRemoteMediaInformation(), mVisible);
        return;
_L6:
        try
        {
            isPlaying = false;
            setupNotification(mCastManager.getRemoteMediaInformation(), mVisible);
            return;
        }
        catch (TransientNetworkDisconnectionException transientnetworkdisconnectionexception)
        {
            LogUtils.LOGE(TAG, "Failed to update the playback status due to network issues", transientnetworkdisconnectionexception);
            return;
        }
        catch (NoConnectionException noconnectionexception)
        {
            LogUtils.LOGE(TAG, "Failed to update the playback status due to network issues", noconnectionexception);
        }
        return;
_L5:
        isPlaying = false;
        setupNotification(mCastManager.getRemoteMediaInformation(), mVisible);
        return;
_L3:
        isPlaying = false;
        stopForeground(true);
        return;
_L2:
        isPlaying = false;
        stopForeground(true);
        return;
    }

    private void readPersistedData()
    {
        mApplicationId = Utils.getStringFromPreference(this, "application-id");
        String s = Utils.getStringFromPreference(this, "cast-activity-name");
        if (s != null)
        {
            try
            {
                mTargetActivity = Class.forName(s);
                return;
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                LogUtils.LOGE(TAG, "Failed to find the targetActivity class", classnotfoundexception);
            }
            break MISSING_BLOCK_LABEL_50;
        }
        mTargetActivity = com/google/sample/castcompanionlibrary/cast/player/VideoCastControllerActivity;
        return;
    }

    private void removeNotification()
    {
        ((NotificationManager)getSystemService("notification")).cancel(NOTIFICATION_ID);
    }

    private void setupNotification(final MediaInfo info, final boolean visible)
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        if (info != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Uri uri;
        MediaMetadata mediametadata;
        try
        {
            mediametadata = info.getMetadata();
        }
        // Misplaced declaration of an exception variable
        catch (final MediaInfo info)
        {
            return;
        }
        uri = null;
        if (!mediametadata.getImages().isEmpty())
        {
            uri = ((WebImage)mediametadata.getImages().get(0)).getUrl();
        }
        if (uri != null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        build(info, null, isPlaying, mTargetActivity);
        if (!visible) goto _L1; else goto _L3
_L3:
        startForeground(NOTIFICATION_ID, mNotification);
        return;
        if (mVideoArtBitmap == null || mVideoArtUri == null || !mVideoArtUri.equals(uri))
        {
            break MISSING_BLOCK_LABEL_138;
        }
        build(info, mVideoArtBitmap, isPlaying, mTargetActivity);
        if (!visible) goto _L1; else goto _L4
_L4:
        startForeground(NOTIFICATION_ID, mNotification);
        return;
        (new Thread(new Runnable() {

            final VideoCastNotificationService this$0;
            final MediaInfo val$info;
            final boolean val$visible;

            public void run()
            {
                Object obj1;
                Object obj2;
                Object obj4;
                Object obj5;
                Object obj6;
                obj2 = null;
                obj4 = null;
                obj5 = null;
                obj6 = null;
                obj1 = null;
                Object obj;
                obj = info.getMetadata();
                mVideoArtUri = ((WebImage)((MediaMetadata) (obj)).getImages().get(0)).getUrl();
                obj = new URL(mVideoArtUri.toString());
                mVideoArtBitmap = BitmapFactory.decodeStream(((URL) (obj)).openStream());
                build(info, mVideoArtBitmap, isPlaying, mTargetActivity);
                if (visible)
                {
                    startForeground(VideoCastNotificationService.NOTIFICATION_ID, mNotification);
                }
                return;
                obj;
_L10:
                LogUtils.LOGE(VideoCastNotificationService.TAG, (new StringBuilder()).append("setIcon(): Failed to load the image with url: ").append(obj1).append(", using the default one").toString(), ((Throwable) (obj)));
                return;
                obj;
                obj1 = obj2;
_L8:
                LogUtils.LOGE(VideoCastNotificationService.TAG, (new StringBuilder()).append("setIcon(): Failed to load the image with url: ").append(obj1).append(", using the default one").toString(), ((Throwable) (obj)));
                return;
                obj;
                obj1 = obj4;
_L6:
                LogUtils.LOGE(VideoCastNotificationService.TAG, (new StringBuilder()).append("setIcon(): Failed to load the image with url: ").append(obj1).append(", using the default one").toString(), ((Throwable) (obj)));
                return;
                obj;
                obj1 = obj5;
_L4:
                LogUtils.LOGE(VideoCastNotificationService.TAG, (new StringBuilder()).append("setIcon(): Failed to load the image with url: ").append(obj1).append(" due to network issues, using the default one").toString(), ((Throwable) (obj)));
                return;
                obj;
                obj1 = obj6;
_L2:
                LogUtils.LOGE(VideoCastNotificationService.TAG, (new StringBuilder()).append("setIcon(): Failed to load the image with url: ").append(obj1).append(" due to network issues, using the default one").toString(), ((Throwable) (obj)));
                return;
                Object obj3;
                obj3;
                obj1 = obj;
                obj = obj3;
                if (true) goto _L2; else goto _L1
_L1:
                obj3;
                obj1 = obj;
                obj = obj3;
                if (true) goto _L4; else goto _L3
_L3:
                obj3;
                obj1 = obj;
                obj = obj3;
                if (true) goto _L6; else goto _L5
_L5:
                obj3;
                obj1 = obj;
                obj = obj3;
                if (true) goto _L8; else goto _L7
_L7:
                obj3;
                obj1 = obj;
                obj = obj3;
                if (true) goto _L10; else goto _L9
_L9:
            }

            
            {
                this$0 = VideoCastNotificationService.this;
                info = mediainfo;
                visible = flag;
                super();
            }
        })).start();
        return;
    }

    private void stopApplication()
    {
        try
        {
            LogUtils.LOGD(TAG, "Calling stopApplication");
            mCastManager.disconnect();
        }
        catch (Exception exception)
        {
            LogUtils.LOGE(TAG, "Failed to disconnect application", exception);
        }
        stopSelf();
    }

    private void togglePlayback()
    {
        try
        {
            mCastManager.togglePlayback();
            return;
        }
        catch (Exception exception)
        {
            LogUtils.LOGE(TAG, "Failed to toggle the playback", exception);
        }
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        readPersistedData();
        mCastManager = VideoCastManager.initialize(this, mApplicationId, mTargetActivity, null);
        if (!mCastManager.isConnected())
        {
            mCastManager.reconnectSessionIfPossible(this, false);
        }
        mConsumer = new VideoCastConsumerImpl() {

            final VideoCastNotificationService this$0;

            public void onApplicationDisconnected(int i)
            {
                LogUtils.LOGD(VideoCastNotificationService.TAG, "onApplicationDisconnected() was reached");
                stopSelf();
            }

            public void onRemoteMediaPlayerStatusUpdated()
            {
                int i = mCastManager.getPlaybackStatus();
                VideoCastNotificationService.this.onRemoteMediaPlayerStatusUpdated(i);
            }

            
            {
                this$0 = VideoCastNotificationService.this;
                super();
            }
        };
        mCastManager.addVideoCastConsumer(mConsumer);
    }

    public void onDestroy()
    {
        LogUtils.LOGD(TAG, "onDestroy was called");
        removeNotification();
        if (mBroadcastReceiver != null)
        {
            unregisterReceiver(mBroadcastReceiver);
        }
        if (mCastManager != null && mConsumer != null)
        {
            mCastManager.removeVideoCastConsumer(mConsumer);
            mCastManager = null;
        }
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        if (intent != null)
        {
            String s = intent.getAction();
            if ("com.google.sample.castcompanionlibrary.action.toggleplayback".equals(s) && mIsIcsOrAbove)
            {
                LogUtils.LOGD(TAG, "onStartCommand(): Action: ACTION_TOGGLE_PLAYBACK");
                togglePlayback();
                return 1;
            }
            if ("com.google.sample.castcompanionlibrary.action.stop".equals(s) && mIsIcsOrAbove)
            {
                LogUtils.LOGD(TAG, "onStartCommand(): Action: ACTION_STOP");
                stopApplication();
                return 1;
            }
            if ("com.google.sample.castcompanionlibrary.action.notificationvisibility".equals(s))
            {
                mVisible = intent.getBooleanExtra("visible", false);
                LogUtils.LOGD(TAG, (new StringBuilder()).append("onStartCommand(): Action: ACTION_VISIBILITY ").append(mVisible).toString());
                if (mVisible && mNotification != null)
                {
                    startForeground(NOTIFICATION_ID, mNotification);
                    return 1;
                } else
                {
                    stopForeground(true);
                    return 1;
                }
            } else
            {
                LogUtils.LOGD(TAG, "onStartCommand(): Action: none");
                return 1;
            }
        } else
        {
            LogUtils.LOGD(TAG, "onStartCommand(): Intent was null");
            return 1;
        }
    }







/*
    static Uri access$302(VideoCastNotificationService videocastnotificationservice, Uri uri)
    {
        videocastnotificationservice.mVideoArtUri = uri;
        return uri;
    }

*/



/*
    static Bitmap access$402(VideoCastNotificationService videocastnotificationservice, Bitmap bitmap)
    {
        videocastnotificationservice.mVideoArtBitmap = bitmap;
        return bitmap;
    }

*/





}
