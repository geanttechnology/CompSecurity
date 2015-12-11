// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.MediaRouteDialogFactory;
import android.support.v7.media.MediaRouter;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.images.WebImage;
import com.google.sample.castcompanionlibrary.cast.callbacks.IVideoCastConsumer;
import com.google.sample.castcompanionlibrary.cast.dialog.video.VideoMediaRouteDialogFactory;
import com.google.sample.castcompanionlibrary.cast.exceptions.CastException;
import com.google.sample.castcompanionlibrary.cast.exceptions.NoConnectionException;
import com.google.sample.castcompanionlibrary.cast.exceptions.OnFailedListener;
import com.google.sample.castcompanionlibrary.cast.exceptions.TransientNetworkDisconnectionException;
import com.google.sample.castcompanionlibrary.cast.player.VideoCastControllerActivity;
import com.google.sample.castcompanionlibrary.notification.VideoCastNotificationService;
import com.google.sample.castcompanionlibrary.remotecontrol.RemoteControlClientCompat;
import com.google.sample.castcompanionlibrary.remotecontrol.RemoteControlHelper;
import com.google.sample.castcompanionlibrary.remotecontrol.VideoIntentReceiver;
import com.google.sample.castcompanionlibrary.utils.LogUtils;
import com.google.sample.castcompanionlibrary.utils.Utils;
import com.google.sample.castcompanionlibrary.widgets.IMiniController;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast:
//            BaseCastManager

public class VideoCastManager extends BaseCastManager
    implements com.google.sample.castcompanionlibrary.widgets.MiniController.OnMiniControllerChangedListener, OnFailedListener
{
    class CastListener extends com.google.android.gms.cast.Cast.Listener
    {

        final VideoCastManager this$0;

        public void onApplicationDisconnected(int i)
        {
            VideoCastManager.this.onApplicationDisconnected(i);
        }

        public void onApplicationStatusChanged()
        {
            VideoCastManager.this.onApplicationStatusChanged();
        }

        public void onVolumeChanged()
        {
            VideoCastManager.this.onVolumeChanged();
        }

        CastListener()
        {
            this$0 = VideoCastManager.this;
            super();
        }
    }

    public static final class VolumeType extends Enum
    {

        private static final VolumeType $VALUES[];
        public static final VolumeType DEVICE;
        public static final VolumeType STREAM;

        public static VolumeType valueOf(String s)
        {
            return (VolumeType)Enum.valueOf(com/google/sample/castcompanionlibrary/cast/VideoCastManager$VolumeType, s);
        }

        public static VolumeType[] values()
        {
            return (VolumeType[])$VALUES.clone();
        }

        static 
        {
            STREAM = new VolumeType("STREAM", 0);
            DEVICE = new VolumeType("DEVICE", 1);
            $VALUES = (new VolumeType[] {
                STREAM, DEVICE
            });
        }

        private VolumeType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = LogUtils.makeLogTag(com/google/sample/castcompanionlibrary/cast/VideoCastManager);
    private static VideoCastManager sInstance;
    private final AudioManager mAudioManager;
    private com.google.android.gms.cast.Cast.MessageReceivedCallback mDataChannel;
    private final String mDataNamespace;
    private int mIdleReason;
    private final ComponentName mMediaButtonReceiverComponent;
    private final Set mMiniControllers = new HashSet();
    private RemoteControlClientCompat mRemoteControlClientCompat;
    private RemoteMediaPlayer mRemoteMediaPlayer;
    private int mState;
    private final Class mTargetActivity;
    private Bitmap mVideoArtBitmap;
    protected Set mVideoConsumers;
    private VolumeType mVolumeType;

    private VideoCastManager(Context context, String s, Class class1, String s1)
    {
        super(context, s);
        mVolumeType = VolumeType.DEVICE;
        mState = 1;
        LogUtils.LOGD(TAG, "VideoCastManager is instantiated");
        mVideoConsumers = new HashSet();
        mDataNamespace = s1;
        s = class1;
        if (class1 == null)
        {
            s = com/google/sample/castcompanionlibrary/cast/player/VideoCastControllerActivity;
        }
        mTargetActivity = s;
        Utils.saveStringToPreference(mContext, "cast-activity-name", mTargetActivity.getName());
        mAudioManager = (AudioManager)context.getSystemService("audio");
        mMediaButtonReceiverComponent = new ComponentName(context, com/google/sample/castcompanionlibrary/remotecontrol/VideoIntentReceiver);
    }

    private void attachDataChannel()
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        while (TextUtils.isEmpty(mDataNamespace) || mDataChannel != null) 
        {
            return;
        }
        checkConnectivity();
        mDataChannel = new com.google.android.gms.cast.Cast.MessageReceivedCallback() {

            final VideoCastManager this$0;

            public void onMessageReceived(CastDevice castdevice, String s, String s1)
            {
                for (castdevice = mVideoConsumers.iterator(); castdevice.hasNext();)
                {
                    s = (IVideoCastConsumer)castdevice.next();
                    try
                    {
                        s.onDataMessageReceived(s1);
                    }
                    catch (Exception exception1)
                    {
                        LogUtils.LOGE(VideoCastManager.TAG, (new StringBuilder()).append("onMessageReceived(): Failed to inform ").append(s).toString(), exception1);
                    }
                }

            }

            
            {
                this$0 = VideoCastManager.this;
                super();
            }
        };
        try
        {
            Cast.CastApi.setMessageReceivedCallbacks(mApiClient, mDataNamespace, mDataChannel);
            return;
        }
        catch (Exception exception)
        {
            LogUtils.LOGE(TAG, "Failed to add data channel", exception);
        }
    }

    private void attachMediaChannel()
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        LogUtils.LOGD(TAG, "attachMedia()");
        checkConnectivity();
        if (mRemoteMediaPlayer == null)
        {
            mRemoteMediaPlayer = new RemoteMediaPlayer();
            mRemoteMediaPlayer.setOnStatusUpdatedListener(new com.google.android.gms.cast.RemoteMediaPlayer.OnStatusUpdatedListener() {

                final VideoCastManager this$0;

                public void onStatusUpdated()
                {
                    LogUtils.LOGD(VideoCastManager.TAG, "RemoteMediaPlayer::onStatusUpdated() is reached");
                    onRemoteMediaPlayerStatusUpdated();
                }

            
            {
                this$0 = VideoCastManager.this;
                super();
            }
            });
            mRemoteMediaPlayer.setOnMetadataUpdatedListener(new com.google.android.gms.cast.RemoteMediaPlayer.OnMetadataUpdatedListener() {

                final VideoCastManager this$0;

                public void onMetadataUpdated()
                {
                    LogUtils.LOGD(VideoCastManager.TAG, "RemoteMediaPlayer::onMetadataUpdated() is reached");
                    onRemoteMediaPlayerMetadataUpdated();
                }

            
            {
                this$0 = VideoCastManager.this;
                super();
            }
            });
        }
        try
        {
            LogUtils.LOGD(TAG, "Registering MediaChannel namespace");
            Cast.CastApi.setMessageReceivedCallbacks(mApiClient, mRemoteMediaPlayer.getNamespace(), mRemoteMediaPlayer);
            return;
        }
        catch (Exception exception)
        {
            LogUtils.LOGE(TAG, "Failed to set up media channel", exception);
        }
    }

    private void checkRemoteMediaPlayerAvailable()
        throws NoConnectionException
    {
        if (mRemoteMediaPlayer == null)
        {
            throw new NoConnectionException();
        } else
        {
            return;
        }
    }

    private void detachMediaChannel()
    {
        LogUtils.LOGD(TAG, "trying to detach media channel");
        if (mRemoteMediaPlayer != null)
        {
            if (mRemoteMediaPlayer != null && Cast.CastApi != null)
            {
                try
                {
                    Cast.CastApi.removeMessageReceivedCallbacks(mApiClient, mRemoteMediaPlayer.getNamespace());
                }
                catch (IOException ioexception)
                {
                    LogUtils.LOGE(TAG, "Failed to detach media channel", ioexception);
                }
            }
            mRemoteMediaPlayer = null;
        }
    }

    private Bitmap getBitmapForLockScreen(MediaInfo mediainfo)
    {
        if (mediainfo != null) goto _L2; else goto _L1
_L1:
        mediainfo = null;
_L7:
        return mediainfo;
_L2:
        Object obj;
        List list;
        obj = null;
        list = mediainfo.getMetadata().getImages();
        if (android.os.Build.VERSION.SDK_INT <= 18) goto _L4; else goto _L3
_L3:
        if (list.size() <= 1) goto _L6; else goto _L5
_L5:
        mediainfo = new URL(((WebImage)list.get(1)).getUrl().toString());
_L9:
        list = null;
        obj = list;
        if (mediainfo != null)
        {
            try
            {
                obj = BitmapFactory.decodeStream(mediainfo.openStream());
            }
            // Misplaced declaration of an exception variable
            catch (MediaInfo mediainfo)
            {
                mediainfo.printStackTrace();
                obj = list;
            }
        }
        mediainfo = ((MediaInfo) (obj));
        if (obj == null)
        {
            return BitmapFactory.decodeResource(mContext.getResources(), com.google.sample.castcompanionlibrary.R.drawable.dummy_album_art);
        }
          goto _L7
_L6:
        mediainfo = ((MediaInfo) (obj));
        if (list.size() != 1) goto _L9; else goto _L8
_L8:
        mediainfo = new URL(((WebImage)list.get(0)).getUrl().toString());
          goto _L9
_L4:
        mediainfo = ((MediaInfo) (obj));
        if (list.isEmpty()) goto _L9; else goto _L10
_L10:
        mediainfo = new URL(((WebImage)list.get(0)).getUrl().toString());
          goto _L9
        mediainfo;
        LogUtils.LOGE(TAG, "Failed to get the url for images", mediainfo);
        mediainfo = ((MediaInfo) (obj));
          goto _L9
    }

    public static VideoCastManager getInstance()
        throws CastException
    {
        if (sInstance == null)
        {
            LogUtils.LOGE(TAG, "No VideoCastManager instance was built, you need to build one first");
            throw new CastException();
        } else
        {
            return sInstance;
        }
    }

    public static VideoCastManager getInstance(Context context)
        throws CastException
    {
        if (sInstance == null)
        {
            LogUtils.LOGE(TAG, "No VideoCastManager instance was built, you need to build one first");
            throw new CastException();
        } else
        {
            LogUtils.LOGD(TAG, (new StringBuilder()).append("Updated context to: ").append(context.getClass().getName()).toString());
            sInstance.mContext = context;
            return sInstance;
        }
    }

    public static VideoCastManager initialize(Context context, String s, Class class1, String s1)
    {
        com/google/sample/castcompanionlibrary/cast/VideoCastManager;
        JVM INSTR monitorenter ;
        if (sInstance == null)
        {
            LogUtils.LOGD(TAG, "New instance of VideoCastManager is created");
            if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) != 0)
            {
                LogUtils.LOGE(TAG, "Couldn't find the appropriate version of Goolge Play Services");
            }
            sInstance = new VideoCastManager(context, s, class1, s1);
            mCastManager = sInstance;
        }
        context = sInstance;
        com/google/sample/castcompanionlibrary/cast/VideoCastManager;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private void onApplicationDisconnected(int i)
    {
        LogUtils.LOGD(TAG, (new StringBuilder()).append("onApplicationDisconnected() reached with error code: ").append(i).toString());
        updateRemoteControl(false);
        if (mRemoteControlClientCompat != null && isFeatureEnabled(2))
        {
            mRemoteControlClientCompat.removeFromMediaRouter(mMediaRouter);
        }
        for (Iterator iterator = mVideoConsumers.iterator(); iterator.hasNext();)
        {
            IVideoCastConsumer ivideocastconsumer = (IVideoCastConsumer)iterator.next();
            try
            {
                ivideocastconsumer.onApplicationDisconnected(i);
            }
            catch (Exception exception)
            {
                LogUtils.LOGE(TAG, (new StringBuilder()).append("onApplicationDisconnected(): Failed to inform ").append(ivideocastconsumer).toString(), exception);
            }
        }

        if (mMediaRouter != null)
        {
            mMediaRouter.selectRoute(mMediaRouter.getDefaultRoute());
        }
        onDeviceSelected(null);
        updateMiniControllersVisibility(false);
        stopNotificationService();
    }

    private void onApplicationStatusChanged()
    {
        if (isConnected()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        Iterator iterator;
        s = Cast.CastApi.getApplicationStatus(mApiClient);
        LogUtils.LOGD(TAG, (new StringBuilder()).append("onApplicationStatusChanged() reached: ").append(Cast.CastApi.getApplicationStatus(mApiClient)).toString());
        iterator = mVideoConsumers.iterator();
_L3:
        IVideoCastConsumer ivideocastconsumer;
        if (!iterator.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        ivideocastconsumer = (IVideoCastConsumer)iterator.next();
        try
        {
            ivideocastconsumer.onApplicationStatusChanged(s);
        }
        catch (Exception exception)
        {
            try
            {
                LogUtils.LOGE(TAG, (new StringBuilder()).append("onApplicationStatusChanged(): Failed to inform ").append(ivideocastconsumer).toString(), exception);
            }
            catch (IllegalStateException illegalstateexception)
            {
                return;
            }
        }
          goto _L3
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void onMessageSendFailed(int i)
    {
        for (Iterator iterator = mVideoConsumers.iterator(); iterator.hasNext();)
        {
            IVideoCastConsumer ivideocastconsumer = (IVideoCastConsumer)iterator.next();
            try
            {
                ivideocastconsumer.onDataMessageSendFailed(i);
            }
            catch (Exception exception)
            {
                LogUtils.LOGE(TAG, (new StringBuilder()).append("onMessageSendFailed(): Failed to inform ").append(ivideocastconsumer).toString(), exception);
            }
        }

    }

    private void onRemoteMediaPlayerStatusUpdated()
    {
        boolean flag2;
        flag2 = true;
        LogUtils.LOGD(TAG, "onRemoteMediaPlayerStatusUpdated() reached");
        if (mApiClient != null && mRemoteMediaPlayer != null && mRemoteMediaPlayer.getMediaStatus() != null) goto _L2; else goto _L1
_L1:
        LogUtils.LOGD(TAG, "mApiClient or mRemoteMediaPlayer is null, so will not proceed");
_L5:
        return;
_L2:
        boolean flag;
        mState = mRemoteMediaPlayer.getMediaStatus().getPlayerState();
        mIdleReason = mRemoteMediaPlayer.getMediaStatus().getIdleReason();
        double d;
        Iterator iterator;
        IVideoCastConsumer ivideocastconsumer;
        Exception exception;
        boolean flag3;
        try
        {
            d = getVolume();
            flag3 = isMute();
        }
        catch (TransientNetworkDisconnectionException transientnetworkdisconnectionexception)
        {
            LogUtils.LOGE(TAG, "Failed to get volume state due to network issues", transientnetworkdisconnectionexception);
            return;
        }
        catch (NoConnectionException noconnectionexception)
        {
            LogUtils.LOGE(TAG, "Failed to get volume state due to network issues", noconnectionexception);
            return;
        }
        flag = false;
        if (mState == 2)
        {
            System.out.println("status: playing");
            updateRemoteControl(true);
            break MISSING_BLOCK_LABEL_389;
        }
          goto _L3
_L7:
        updateMiniControllersVisibility(flag2);
        updateMiniControllers();
        iterator = mVideoConsumers.iterator();
_L6:
        if (!iterator.hasNext()) goto _L5; else goto _L4
_L4:
        ivideocastconsumer = (IVideoCastConsumer)iterator.next();
        ivideocastconsumer.onRemoteMediaPlayerStatusUpdated();
        ivideocastconsumer.onVolumeChanged(d, flag3);
          goto _L6
        exception;
        LogUtils.LOGE(TAG, (new StringBuilder()).append("onRemoteMediaplayerStatusUpdated(): Failed to inform ").append(ivideocastconsumer).toString(), exception);
          goto _L6
_L3:
        if (mState == 3)
        {
            System.out.println("status: paused");
            updateRemoteControl(false);
            break MISSING_BLOCK_LABEL_389;
        }
        if (mState != 1)
        {
            break MISSING_BLOCK_LABEL_349;
        }
        boolean flag1 = true;
        updateRemoteControl(false);
        if (mIdleReason != 1)
        {
            break MISSING_BLOCK_LABEL_300;
        }
        stopNotificationService();
        removeRemoteControlClient();
        updateMiniControllersVisibility(false);
        flag = flag1;
        break MISSING_BLOCK_LABEL_389;
        flag = flag1;
        if (mIdleReason != 4)
        {
            break MISSING_BLOCK_LABEL_389;
        }
        LogUtils.LOGD(TAG, "Player on the receiver has thrown an error");
        stopNotificationService();
        removeRemoteControlClient();
        updateMiniControllersVisibility(false);
        onFailed(com.google.sample.castcompanionlibrary.R.string.failed_receiver_player_error, -1);
        flag = flag1;
        break MISSING_BLOCK_LABEL_389;
        if (mState == 4)
        {
            System.out.println("status: buffering");
            updateRemoteControl(false);
            break MISSING_BLOCK_LABEL_389;
        }
        System.out.println("status: unknown");
        flag = true;
        while (flag) 
        {
            flag2 = false;
            break;
        }
          goto _L7
    }

    private void onVolumeChanged()
    {
        LogUtils.LOGD(TAG, "onVolumeChanged() reached");
        double d;
        Iterator iterator;
        boolean flag;
        d = getVolume();
        flag = isMute();
        iterator = mVideoConsumers.iterator();
_L1:
        IVideoCastConsumer ivideocastconsumer;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_108;
        }
        ivideocastconsumer = (IVideoCastConsumer)iterator.next();
        ivideocastconsumer.onVolumeChanged(d, flag);
          goto _L1
        Exception exception1;
        exception1;
        LogUtils.LOGE(TAG, (new StringBuilder()).append("onVolumeChanged(): Failed to inform ").append(ivideocastconsumer).toString(), exception1);
          goto _L1
        Exception exception;
        exception;
        LogUtils.LOGE(TAG, "Failed to get volume", exception);
    }

    private void reattachMediaChannel()
    {
        if (mRemoteMediaPlayer == null || mApiClient == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        LogUtils.LOGD(TAG, "Registering MediaChannel namespace");
        Cast.CastApi.setMessageReceivedCallbacks(mApiClient, mRemoteMediaPlayer.getNamespace(), mRemoteMediaPlayer);
        return;
        Object obj;
        obj;
        LogUtils.LOGE(TAG, "Failed to setup media channel", ((Throwable) (obj)));
        return;
        obj;
        LogUtils.LOGE(TAG, "Failed to setup media channel", ((Throwable) (obj)));
        return;
    }

    private void removeRemoteControlClient()
    {
        if (isFeatureEnabled(2))
        {
            mAudioManager.abandonAudioFocus(null);
            if (mRemoteControlClientCompat != null)
            {
                RemoteControlHelper.unregisterRemoteControlClient(mAudioManager, mRemoteControlClientCompat);
                mRemoteControlClientCompat = null;
            }
        }
    }

    private void setUpRemoteControl(MediaInfo mediainfo)
    {
        if (!isFeatureEnabled(2))
        {
            return;
        }
        LogUtils.LOGD(TAG, "setupRemoteControl() was called");
        mAudioManager.requestAudioFocus(null, 3, 3);
        ComponentName componentname = new ComponentName(mContext, com/google/sample/castcompanionlibrary/remotecontrol/VideoIntentReceiver.getName());
        mAudioManager.registerMediaButtonEventReceiver(componentname);
        if (mRemoteControlClientCompat == null)
        {
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
            intent.setComponent(mMediaButtonReceiverComponent);
            mRemoteControlClientCompat = new RemoteControlClientCompat(PendingIntent.getBroadcast(mContext, 0, intent, 0));
            RemoteControlHelper.registerRemoteControlClient(mAudioManager, mRemoteControlClientCompat);
        }
        mRemoteControlClientCompat.addToMediaRouter(mMediaRouter);
        mRemoteControlClientCompat.setTransportControlFlags(8);
        if (mediainfo == null)
        {
            mRemoteControlClientCompat.setPlaybackState(2);
            return;
        } else
        {
            mRemoteControlClientCompat.setPlaybackState(3);
            updateLockScreenImage(mediainfo);
            updateLockScreenMetadata();
            return;
        }
    }

    private boolean startNotificationService()
    {
        if (isFeatureEnabled(4))
        {
            LogUtils.LOGD(TAG, "startNotificationService() ");
            Intent intent = new Intent(mContext, com/google/sample/castcompanionlibrary/notification/VideoCastNotificationService);
            intent.setPackage(mContext.getPackageName());
            if (mContext.startService(intent) == null)
            {
                return false;
            }
        }
        return true;
    }

    private void stopNotificationService()
    {
        if (!isFeatureEnabled(4))
        {
            return;
        } else
        {
            mContext.stopService(new Intent(mContext, com/google/sample/castcompanionlibrary/notification/VideoCastNotificationService));
            return;
        }
    }

    private void updateLockScreenImage(final MediaInfo info)
    {
        if (info == null)
        {
            return;
        } else
        {
            (new Thread(new Runnable() {

                final VideoCastManager this$0;
                final MediaInfo val$info;

                public void run()
                {
                    Bitmap bitmap = getBitmapForLockScreen(info);
                    if (bitmap == null)
                    {
                        return;
                    }
                    try
                    {
                        mRemoteControlClientCompat.editMetadata(false).putBitmap(100, bitmap).apply();
                        return;
                    }
                    catch (Exception exception)
                    {
                        LogUtils.LOGD(VideoCastManager.TAG, "Failed to update lock screen image", exception);
                    }
                    return;
                }

            
            {
                this$0 = VideoCastManager.this;
                info = mediainfo;
                super();
            }
            })).start();
            return;
        }
    }

    private void updateLockScreenMetadata()
    {
        if (mRemoteControlClientCompat != null && isFeatureEnabled(2)) goto _L2; else goto _L1
_L1:
        MediaInfo mediainfo;
        return;
_L2:
        if ((mediainfo = getRemoteMediaInformation()) == null) goto _L1; else goto _L3
_L3:
        try
        {
            MediaMetadata mediametadata = mediainfo.getMetadata();
            mRemoteControlClientCompat.editMetadata(false).putString(7, mediametadata.getString("com.google.android.gms.cast.metadata.TITLE")).putString(13, mContext.getResources().getString(com.google.sample.castcompanionlibrary.R.string.casting_to_device, new Object[] {
                getDeviceName()
            })).putLong(9, mediainfo.getStreamDuration()).apply();
            return;
        }
        catch (android.content.res.Resources.NotFoundException notfoundexception)
        {
            LogUtils.LOGE(TAG, "Failed to update RCC due to resource not found", notfoundexception);
            return;
        }
        catch (TransientNetworkDisconnectionException transientnetworkdisconnectionexception)
        {
            LogUtils.LOGE(TAG, "Failed to update RCC due to network issues", transientnetworkdisconnectionexception);
            return;
        }
        catch (NoConnectionException noconnectionexception)
        {
            LogUtils.LOGE(TAG, "Failed to update RCC due to network issues", noconnectionexception);
        }
        return;
    }

    private void updateMiniController(IMiniController iminicontroller)
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        checkRemoteMediaPlayerAvailable();
        if (mRemoteMediaPlayer.getStreamDuration() > 0L)
        {
            iminicontroller.setPlaybackStatus(mState);
            iminicontroller.setSubTitle(mContext.getResources().getString(com.google.sample.castcompanionlibrary.R.string.casting_to_device, new Object[] {
                mDeviceName
            }));
            MediaMetadata mediametadata = getRemoteMediaInformation().getMetadata();
            iminicontroller.setTitle(mediametadata.getString("com.google.android.gms.cast.metadata.TITLE"));
            iminicontroller.setIcon(((WebImage)mediametadata.getImages().get(0)).getUrl());
        }
    }

    private void updateMiniControllers()
    {
        if (mMiniControllers != null && !mMiniControllers.isEmpty())
        {
            for (Iterator iterator = mMiniControllers.iterator(); iterator.hasNext();)
            {
                IMiniController iminicontroller = (IMiniController)iterator.next();
                try
                {
                    updateMiniController(iminicontroller);
                }
                catch (Exception exception) { }
            }

        }
    }

    private void updateRemoteControl(boolean flag)
    {
        byte byte0 = 2;
        if (isFeatureEnabled(2)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (mRemoteControlClientCompat == null)
        {
            setUpRemoteControl(getRemoteMediaInformation());
        }
        if (mRemoteControlClientCompat == null) goto _L1; else goto _L3
_L3:
        RemoteControlClientCompat remotecontrolclientcompat = mRemoteControlClientCompat;
        if (flag)
        {
            byte0 = 3;
        }
        try
        {
            remotecontrolclientcompat.setPlaybackState(byte0);
            return;
        }
        catch (TransientNetworkDisconnectionException transientnetworkdisconnectionexception)
        {
            LogUtils.LOGE(TAG, "Failed to setup RCC due to network issues", transientnetworkdisconnectionexception);
            return;
        }
        catch (NoConnectionException noconnectionexception)
        {
            LogUtils.LOGE(TAG, "Failed to setup RCC due to network issues", noconnectionexception);
        }
        return;
    }

    public void addMiniController(IMiniController iminicontroller)
    {
        this;
        JVM INSTR monitorenter ;
        addMiniController(iminicontroller, null);
        this;
        JVM INSTR monitorexit ;
        return;
        iminicontroller;
        throw iminicontroller;
    }

    public void addMiniController(IMiniController iminicontroller, com.google.sample.castcompanionlibrary.widgets.MiniController.OnMiniControllerChangedListener onminicontrollerchangedlistener)
    {
        this;
        JVM INSTR monitorenter ;
        if (iminicontroller == null) goto _L2; else goto _L1
_L1:
        if (!mMiniControllers.add(iminicontroller))
        {
            break MISSING_BLOCK_LABEL_122;
        }
        Object obj;
        obj = onminicontrollerchangedlistener;
        if (onminicontrollerchangedlistener == null)
        {
            obj = this;
        }
        iminicontroller.setOnMiniControllerChangedListener(((com.google.sample.castcompanionlibrary.widgets.MiniController.OnMiniControllerChangedListener) (obj)));
        if (isConnected() && isRemoteMediaLoaded())
        {
            updateMiniController(iminicontroller);
            iminicontroller.setVisibility(0);
        }
_L3:
        LogUtils.LOGD(TAG, (new StringBuilder()).append("Successfully added the new MiniController ").append(iminicontroller).toString());
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        onminicontrollerchangedlistener;
        LogUtils.LOGE(TAG, "Failed to get the status of media playback on receiver", onminicontrollerchangedlistener);
          goto _L3
        iminicontroller;
        throw iminicontroller;
        onminicontrollerchangedlistener;
        LogUtils.LOGE(TAG, "Failed to get the status of media playback on receiver", onminicontrollerchangedlistener);
          goto _L3
        LogUtils.LOGD(TAG, (new StringBuilder()).append("Attempting to adding ").append(iminicontroller).append(" but it was already ").append("registered, skipping this step").toString());
          goto _L2
    }

    public void addVideoCastConsumer(IVideoCastConsumer ivideocastconsumer)
    {
        this;
        JVM INSTR monitorenter ;
        if (ivideocastconsumer == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        super.addBaseCastConsumer(ivideocastconsumer);
        mVideoConsumers.add(ivideocastconsumer);
        LogUtils.LOGD(TAG, (new StringBuilder()).append("Successfully added the new CastConsumer listener ").append(ivideocastconsumer).toString());
        this;
        JVM INSTR monitorexit ;
        return;
        ivideocastconsumer;
        throw ivideocastconsumer;
    }

    public Bitmap getAlbumArt()
    {
        return mVideoArtBitmap;
    }

    com.google.android.gms.cast.Cast.CastOptions.Builder getCastOptionBuilder(CastDevice castdevice)
    {
        castdevice = com.google.android.gms.cast.Cast.CastOptions.builder(mSelectedCastDevice, new CastListener());
        if (isFeatureEnabled(1))
        {
            castdevice.setDebuggingEnabled();
        }
        return castdevice;
    }

    public double getCurrentMediaPosition()
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        checkRemoteMediaPlayerAvailable();
        return (double)mRemoteMediaPlayer.getApproximateStreamPosition();
    }

    public int getIdleReason()
    {
        return mIdleReason;
    }

    public double getMediaDuration()
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        checkRemoteMediaPlayerAvailable();
        return (double)mRemoteMediaPlayer.getStreamDuration();
    }

    MediaRouteDialogFactory getMediaRouteDialogFactory()
    {
        return new VideoMediaRouteDialogFactory();
    }

    public int getPlaybackStatus()
    {
        return mState;
    }

    public MediaInfo getRemoteMediaInformation()
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        checkRemoteMediaPlayerAvailable();
        return mRemoteMediaPlayer.getMediaInfo();
    }

    public final RemoteMediaPlayer getRemoteMediaPlayer()
    {
        return mRemoteMediaPlayer;
    }

    public String getRemoteMovieUrl()
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        if (mRemoteMediaPlayer != null && mRemoteMediaPlayer.getMediaInfo() != null)
        {
            MediaInfo mediainfo = mRemoteMediaPlayer.getMediaInfo();
            mRemoteMediaPlayer.getMediaStatus().getPlayerState();
            return mediainfo.getContentId();
        } else
        {
            throw new NoConnectionException();
        }
    }

    public Class getTargetActivity()
    {
        return mTargetActivity;
    }

    public double getVolume()
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        if (mVolumeType == VolumeType.STREAM)
        {
            checkRemoteMediaPlayerAvailable();
            return mRemoteMediaPlayer.getMediaStatus().getStreamVolume();
        } else
        {
            return Cast.CastApi.getVolume(mApiClient);
        }
    }

    public void incrementVolume(double d)
        throws CastException, TransientNetworkDisconnectionException, NoConnectionException
    {
        double d1;
        checkConnectivity();
        d1 = getVolume() + d;
        if (d1 <= 1.0D) goto _L2; else goto _L1
_L1:
        d = 1.0D;
_L4:
        setVolume(d);
        return;
_L2:
        d = d1;
        if (d1 < 0.0D)
        {
            d = 0.0D;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean isMute()
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        if (mVolumeType == VolumeType.STREAM)
        {
            checkRemoteMediaPlayerAvailable();
            return mRemoteMediaPlayer.getMediaStatus().isMute();
        } else
        {
            return Cast.CastApi.isMute(mApiClient);
        }
    }

    public boolean isRemoteMediaLoaded()
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        return isRemoteMoviePaused() || isRemoteMoviePlaying();
    }

    public boolean isRemoteMoviePaused()
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        return mState == 3;
    }

    public boolean isRemoteMoviePlaying()
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        return mState == 4 || mState == 2;
    }

    public void loadMedia(MediaInfo mediainfo, boolean flag, int i)
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        loadMedia(mediainfo, flag, i, null);
    }

    public void loadMedia(MediaInfo mediainfo, boolean flag, int i, JSONObject jsonobject)
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        LogUtils.LOGD(TAG, (new StringBuilder()).append("loadMedia: ").append(mediainfo).toString());
        checkConnectivity();
        if (mediainfo == null)
        {
            return;
        }
        if (mRemoteMediaPlayer == null)
        {
            LogUtils.LOGE(TAG, "Trying to load a video with no active media session");
            throw new NoConnectionException();
        } else
        {
            mRemoteMediaPlayer.load(mApiClient, mediainfo, flag, i, jsonobject).setResultCallback(new ResultCallback() {

                final VideoCastManager this$0;

                public void onResult(com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult mediachannelresult)
                {
                    if (!mediachannelresult.getStatus().isSuccess())
                    {
                        onFailed(com.google.sample.castcompanionlibrary.R.string.failed_load, mediachannelresult.getStatus().getStatusCode());
                    }
                }

                public volatile void onResult(Result result)
                {
                    onResult((com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult)result);
                }

            
            {
                this$0 = VideoCastManager.this;
                super();
            }
            });
            return;
        }
    }

    void onApplicationConnected(ApplicationMetadata applicationmetadata, String s, String s1, boolean flag)
    {
label0:
        {
            LogUtils.LOGD(TAG, (new StringBuilder()).append("onApplicationConnected() reached with sessionId: ").append(s1).append(", and mReconnectionStatus=").append(mReconnectionStatus).toString());
            if (mReconnectionStatus != BaseCastManager.ReconnectionStatus.IN_PROGRESS)
            {
                break label0;
            }
            Object obj = mMediaRouter.getRoutes();
            if (obj == null)
            {
                break label0;
            }
            s = Utils.getStringFromPreference(mContext, "route-id");
            obj = ((List) (obj)).iterator();
            android.support.v7.media.MediaRouter.RouteInfo routeinfo;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                routeinfo = (android.support.v7.media.MediaRouter.RouteInfo)((Iterator) (obj)).next();
            } while (!s.equals(routeinfo.getId()));
            LogUtils.LOGD(TAG, "Found the correct route during reconnection attempt");
            mReconnectionStatus = BaseCastManager.ReconnectionStatus.FINALIZE;
            mMediaRouter.selectRoute(routeinfo);
        }
        startNotificationService();
        attachDataChannel();
        attachMediaChannel();
        Utils.saveStringToPreference(mContext, "session-id", s1);
        mRemoteMediaPlayer.requestStatus(mApiClient).setResultCallback(new ResultCallback() {

            final VideoCastManager this$0;

            public void onResult(com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult mediachannelresult)
            {
                if (!mediachannelresult.getStatus().isSuccess())
                {
                    onFailed(com.google.sample.castcompanionlibrary.R.string.failed_status_request, mediachannelresult.getStatus().getStatusCode());
                }
            }

            public volatile void onResult(Result result)
            {
                onResult((com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult)result);
            }

            
            {
                this$0 = VideoCastManager.this;
                super();
            }
        });
        s = mVideoConsumers.iterator();
_L1:
        IVideoCastConsumer ivideocastconsumer;
        if (!s.hasNext())
        {
            break MISSING_BLOCK_LABEL_287;
        }
        ivideocastconsumer = (IVideoCastConsumer)s.next();
        ivideocastconsumer.onApplicationConnected(applicationmetadata, s1, flag);
          goto _L1
        Exception exception;
        exception;
        LogUtils.LOGE(TAG, (new StringBuilder()).append("onApplicationConnected(): Failed to inform ").append(ivideocastconsumer).toString(), exception);
          goto _L1
        applicationmetadata;
        LogUtils.LOGE(TAG, "Failed to attach media/data channel due to network issues", applicationmetadata);
        onFailed(com.google.sample.castcompanionlibrary.R.string.failed_no_connection_trans, -1);
        return;
        applicationmetadata;
        LogUtils.LOGE(TAG, "Failed to attach media/data channel due to network issues", applicationmetadata);
        onFailed(com.google.sample.castcompanionlibrary.R.string.failed_no_connection, -1);
        return;
    }

    public void onApplicationConnectionFailed(int i)
    {
        LogUtils.LOGD(TAG, (new StringBuilder()).append("onApplicationConnectionFailed() reached with errorCode: ").append(i).toString());
        if (mReconnectionStatus != BaseCastManager.ReconnectionStatus.IN_PROGRESS) goto _L2; else goto _L1
_L1:
        if (i == 2005)
        {
            mReconnectionStatus = BaseCastManager.ReconnectionStatus.INACTIVE;
            onDeviceSelected(null);
        }
_L6:
        return;
_L2:
        Iterator iterator;
        boolean flag;
        flag = false;
        iterator = mVideoConsumers.iterator();
_L4:
        IVideoCastConsumer ivideocastconsumer;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        ivideocastconsumer = (IVideoCastConsumer)iterator.next();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        boolean flag1 = ivideocastconsumer.onApplicationConnectionFailed(i);
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        flag = true;
        continue; /* Loop/switch isn't completed */
        flag = false;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        LogUtils.LOGE(TAG, (new StringBuilder()).append("onApplicationLaunchFailed(): Failed to inform ").append(ivideocastconsumer).toString(), exception);
        if (true) goto _L4; else goto _L3
_L3:
        if (flag)
        {
            switch (i)
            {
            default:
                LogUtils.LOGD(TAG, (new StringBuilder()).append("onApplicationConnectionFailed(): failed due to: errorcode=").append(i).toString());
                Utils.showErrorDialog(mContext, com.google.sample.castcompanionlibrary.R.string.failed_to_launch_app);
                break;

            case 15: // '\017'
                break MISSING_BLOCK_LABEL_269;

            case 2004: 
                break; /* Loop/switch isn't completed */
            }
        }
_L7:
        onDeviceSelected(null);
        if (mMediaRouter != null)
        {
            mMediaRouter.selectRoute(mMediaRouter.getDefaultRoute());
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
        LogUtils.LOGD(TAG, "onApplicationConnectionFailed(): failed due to: ERROR_APPLICATION_NOT_FOUND");
        Utils.showErrorDialog(mContext, com.google.sample.castcompanionlibrary.R.string.failed_to_find_app);
          goto _L7
        LogUtils.LOGD(TAG, "onApplicationConnectionFailed(): failed due to: ERROR_TIMEOUT");
        Utils.showErrorDialog(mContext, com.google.sample.castcompanionlibrary.R.string.failed_app_launch_timeout);
          goto _L7
    }

    public void onApplicationStopFailed(int i)
    {
        for (Iterator iterator = mVideoConsumers.iterator(); iterator.hasNext();)
        {
            IVideoCastConsumer ivideocastconsumer = (IVideoCastConsumer)iterator.next();
            try
            {
                ivideocastconsumer.onApplicationStopFailed(i);
            }
            catch (Exception exception)
            {
                LogUtils.LOGE(TAG, (new StringBuilder()).append("onApplicationLaunched(): Failed to inform ").append(ivideocastconsumer).toString(), exception);
            }
        }

    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        super.onConnectionFailed(connectionresult);
        updateRemoteControl(false);
        stopNotificationService();
    }

    public void onConnectivityRecovered()
    {
        reattachMediaChannel();
        super.onConnectivityRecovered();
    }

    void onDeviceUnselected()
    {
        try
        {
            detachMediaChannel();
            removeDataChannel();
            stopNotificationService();
            return;
        }
        catch (TransientNetworkDisconnectionException transientnetworkdisconnectionexception)
        {
            LogUtils.LOGD(TAG, "Failed to clean up on onDeviceUnselected()", transientnetworkdisconnectionexception);
            return;
        }
        catch (NoConnectionException noconnectionexception)
        {
            LogUtils.LOGD(TAG, "Failed to clean up on onDeviceUnselected()", noconnectionexception);
        }
    }

    public void onDisconnected()
    {
        super.onDisconnected();
        updateMiniControllersVisibility(false);
        stopNotificationService();
        removeRemoteControlClient();
    }

    public void onFailed(int i, int j)
    {
        LogUtils.LOGD(TAG, (new StringBuilder()).append("onFailed: ").append(mContext.getString(i)).append(", code: ").append(j).toString());
        super.onFailed(i, j);
    }

    public void onPlayPauseClicked(View view)
        throws CastException, TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        if (mState == 2)
        {
            pause();
        } else
        if (mState == 3)
        {
            play();
            return;
        }
    }

    public void onRemoteMediaPlayerMetadataUpdated()
    {
        LogUtils.LOGD(TAG, "onRemoteMediaPlayerMetadataUpdated() reached");
        updateLockScreenMetadata();
        for (Iterator iterator = mVideoConsumers.iterator(); iterator.hasNext();)
        {
            IVideoCastConsumer ivideocastconsumer = (IVideoCastConsumer)iterator.next();
            try
            {
                ivideocastconsumer.onRemoteMediaPlayerMetadataUpdated();
            }
            catch (Exception exception)
            {
                LogUtils.LOGE(TAG, (new StringBuilder()).append("onRemoteMediaPlayerMetadataUpdated(): Failed to inform ").append(ivideocastconsumer).toString(), exception);
            }
        }

        updateLockScreenMetadata();
        try
        {
            updateLockScreenImage(getRemoteMediaInformation());
            return;
        }
        catch (TransientNetworkDisconnectionException transientnetworkdisconnectionexception)
        {
            LogUtils.LOGE(TAG, "Failed to update lock screen metadaa due to a network issue", transientnetworkdisconnectionexception);
            return;
        }
        catch (NoConnectionException noconnectionexception)
        {
            LogUtils.LOGE(TAG, "Failed to update lock screen metadaa due to a network issue", noconnectionexception);
        }
    }

    public void onTargetActivityInvoked(Context context)
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        Intent intent = new Intent(context, mTargetActivity);
        intent.putExtra("media", Utils.fromMediaInfo(getRemoteMediaInformation()));
        context.startActivity(intent);
    }

    protected void onUiVisibilityChanged(boolean flag)
    {
        super.onUiVisibilityChanged(flag);
        if (isFeatureEnabled(4))
        {
            Intent intent = new Intent("com.google.sample.castcompanionlibrary.action.notificationvisibility");
            intent.setPackage(mContext.getPackageName());
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            intent.putExtra("visible", flag);
            mContext.startService(intent);
        }
    }

    public void pause()
        throws CastException, TransientNetworkDisconnectionException, NoConnectionException
    {
        pause(null);
    }

    public void pause(JSONObject jsonobject)
        throws CastException, TransientNetworkDisconnectionException, NoConnectionException
    {
        LogUtils.LOGD(TAG, "attempting to pause media");
        checkConnectivity();
        if (mRemoteMediaPlayer == null)
        {
            LogUtils.LOGE(TAG, "Trying to pause a video with no active media session");
            throw new NoConnectionException();
        }
        try
        {
            mRemoteMediaPlayer.pause(mApiClient, jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            LogUtils.LOGE(TAG, "Failed to pause media", jsonobject);
        }
        throw new CastException(mContext, com.google.sample.castcompanionlibrary.R.string.failed_to_pause, jsonobject);
    }

    public void play()
        throws CastException, TransientNetworkDisconnectionException, NoConnectionException
    {
        play(((JSONObject) (null)));
    }

    public void play(int i)
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        LogUtils.LOGD(TAG, (new StringBuilder()).append("attempting to play media at position ").append(i).append(" seconds").toString());
        if (mRemoteMediaPlayer == null)
        {
            LogUtils.LOGE(TAG, "Trying to play a video with no active media session");
            throw new NoConnectionException();
        } else
        {
            seekAndPlay(i);
            return;
        }
    }

    public void play(JSONObject jsonobject)
        throws CastException, TransientNetworkDisconnectionException, NoConnectionException
    {
        LogUtils.LOGD(TAG, "play()");
        checkConnectivity();
        try
        {
            if (mRemoteMediaPlayer == null)
            {
                LogUtils.LOGE(TAG, "Trying to play a video with no active media session");
                throw new NoConnectionException();
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            LogUtils.LOGE(TAG, "Failed to play media", jsonobject);
            throw new CastException(mContext.getString(com.google.sample.castcompanionlibrary.R.string.failed_to_play), jsonobject);
        }
        mRemoteMediaPlayer.play(mApiClient);
        return;
    }

    public boolean removeDataChannel()
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        if (TextUtils.isEmpty(mDataNamespace))
        {
            return false;
        }
        try
        {
            Cast.CastApi.removeMessageReceivedCallbacks(mApiClient, mDataNamespace);
        }
        catch (Exception exception)
        {
            LogUtils.LOGE(TAG, (new StringBuilder()).append("Failed to remove namespace: ").append(mDataNamespace).toString(), exception);
            return false;
        }
        return true;
    }

    public void removeMiniController(IMiniController iminicontroller)
    {
        this;
        JVM INSTR monitorenter ;
        if (iminicontroller == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        mMiniControllers.remove(iminicontroller);
        this;
        JVM INSTR monitorexit ;
        return;
        iminicontroller;
        throw iminicontroller;
    }

    public void removeVideoCastConsumer(IVideoCastConsumer ivideocastconsumer)
    {
        this;
        JVM INSTR monitorenter ;
        if (ivideocastconsumer == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        super.removeBaseCastConsumer(ivideocastconsumer);
        mVideoConsumers.remove(ivideocastconsumer);
        this;
        JVM INSTR monitorexit ;
        return;
        ivideocastconsumer;
        throw ivideocastconsumer;
    }

    public void seek(int i)
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        LogUtils.LOGD(TAG, "attempting to seek media");
        checkConnectivity();
        if (mRemoteMediaPlayer == null)
        {
            LogUtils.LOGE(TAG, "Trying to seek a video with no active media session");
            throw new NoConnectionException();
        } else
        {
            mRemoteMediaPlayer.seek(mApiClient, i, 0).setResultCallback(new ResultCallback() {

                final VideoCastManager this$0;

                public void onResult(com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult mediachannelresult)
                {
                    if (!mediachannelresult.getStatus().isSuccess())
                    {
                        onFailed(com.google.sample.castcompanionlibrary.R.string.failed_seek, mediachannelresult.getStatus().getStatusCode());
                    }
                }

                public volatile void onResult(Result result)
                {
                    onResult((com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult)result);
                }

            
            {
                this$0 = VideoCastManager.this;
                super();
            }
            });
            return;
        }
    }

    public void seekAndPlay(int i)
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        LogUtils.LOGD(TAG, "attempting to seek media");
        checkConnectivity();
        if (mRemoteMediaPlayer == null)
        {
            LogUtils.LOGE(TAG, "Trying to seekAndPlay a video with no active media session");
            throw new NoConnectionException();
        } else
        {
            ResultCallback resultcallback = new ResultCallback() {

                final VideoCastManager this$0;

                public void onResult(com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult mediachannelresult)
                {
                    if (!mediachannelresult.getStatus().isSuccess())
                    {
                        onFailed(com.google.sample.castcompanionlibrary.R.string.failed_seek, mediachannelresult.getStatus().getStatusCode());
                    }
                }

                public volatile void onResult(Result result)
                {
                    onResult((com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult)result);
                }

            
            {
                this$0 = VideoCastManager.this;
                super();
            }
            };
            mRemoteMediaPlayer.seek(mApiClient, i, 1).setResultCallback(resultcallback);
            return;
        }
    }

    public void sendDataMessage(String s)
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        if (TextUtils.isEmpty(mDataNamespace))
        {
            throw new IllegalStateException("No Data Namespace is configured");
        } else
        {
            checkConnectivity();
            Cast.CastApi.sendMessage(mApiClient, mDataNamespace, s).setResultCallback(new ResultCallback() {

                final VideoCastManager this$0;

                public volatile void onResult(Result result)
                {
                    onResult((Status)result);
                }

                public void onResult(Status status)
                {
                    if (!status.isSuccess())
                    {
                        onMessageSendFailed(status.getStatusCode());
                    }
                }

            
            {
                this$0 = VideoCastManager.this;
                super();
            }
            });
            return;
        }
    }

    public void setMute(boolean flag)
        throws CastException, TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        if (mVolumeType == VolumeType.STREAM)
        {
            checkRemoteMediaPlayerAvailable();
            mRemoteMediaPlayer.setStreamMute(mApiClient, flag);
            return;
        }
        try
        {
            Cast.CastApi.setMute(mApiClient, flag);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw new CastException("Failed to set volume", exception);
        }
    }

    public void setVolume(double d)
        throws CastException, TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        if (d <= 1.0D) goto _L2; else goto _L1
_L1:
        double d1 = 1.0D;
_L4:
        if (mVolumeType == VolumeType.STREAM)
        {
            checkRemoteMediaPlayerAvailable();
            mRemoteMediaPlayer.setStreamVolume(mApiClient, d1).setResultCallback(new ResultCallback() {

                final VideoCastManager this$0;

                public void onResult(com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult mediachannelresult)
                {
                    if (!mediachannelresult.getStatus().isSuccess())
                    {
                        onFailed(com.google.sample.castcompanionlibrary.R.string.failed_setting_volume, mediachannelresult.getStatus().getStatusCode());
                    }
                }

                public volatile void onResult(Result result)
                {
                    onResult((com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult)result);
                }

            
            {
                this$0 = VideoCastManager.this;
                super();
            }
            });
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        d1 = d;
        if (d < 0.0D)
        {
            d1 = 0.0D;
        }
        if (true) goto _L4; else goto _L3
_L3:
        try
        {
            Cast.CastApi.setVolume(mApiClient, d1);
            return;
        }
        catch (IOException ioexception)
        {
            throw new CastException(ioexception);
        }
        catch (IllegalStateException illegalstateexception)
        {
            throw new CastException(illegalstateexception);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw new CastException(illegalargumentexception);
        }
    }

    public final void setVolumeType(VolumeType volumetype)
    {
        mVolumeType = volumetype;
    }

    public void startCastControllerActivity(Context context, Bundle bundle, int i, boolean flag)
    {
        Intent intent = new Intent(context, com/google/sample/castcompanionlibrary/cast/player/VideoCastControllerActivity);
        intent.putExtra("media", bundle);
        intent.putExtra("startPoint", i);
        intent.putExtra("shouldStart", flag);
        context.startActivity(intent);
    }

    public void startCastControllerActivity(Context context, Bundle bundle, int i, boolean flag, JSONObject jsonobject)
    {
        Intent intent = new Intent(context, com/google/sample/castcompanionlibrary/cast/player/VideoCastControllerActivity);
        intent.putExtra("media", bundle);
        intent.putExtra("startPoint", i);
        intent.putExtra("shouldStart", flag);
        if (jsonobject != null)
        {
            intent.putExtra("customData", jsonobject.toString());
        }
        context.startActivity(intent);
    }

    public void startCastControllerActivity(Context context, MediaInfo mediainfo, int i, boolean flag)
    {
        startCastControllerActivity(context, Utils.fromMediaInfo(mediainfo), i, flag);
    }

    public void togglePlayback()
        throws CastException, TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        if (isRemoteMoviePlaying())
        {
            pause();
            return;
        } else
        {
            play();
            return;
        }
    }

    public void updateMiniControllersVisibility(boolean flag)
    {
        LogUtils.LOGD(TAG, (new StringBuilder()).append("updateMiniControllersVisibility() reached with visibility: ").append(flag).toString());
        if (mMiniControllers != null)
        {
            Iterator iterator = mMiniControllers.iterator();
            while (iterator.hasNext()) 
            {
                IMiniController iminicontroller = (IMiniController)iterator.next();
                int i;
                if (flag)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                iminicontroller.setVisibility(i);
            }
        }
    }

    public void updateVolume(int i)
    {
        if (mMediaRouter.getSelectedRoute() != null)
        {
            mMediaRouter.getSelectedRoute().requestUpdateVolume(i);
        }
    }









}
