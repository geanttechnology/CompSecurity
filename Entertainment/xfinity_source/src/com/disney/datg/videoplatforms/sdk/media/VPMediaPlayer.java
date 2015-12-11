// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.widget.RelativeLayout;
import com.disney.datg.videoplatforms.sdk.analytics.AppTrackable;
import com.disney.datg.videoplatforms.sdk.analytics.ILinkTracker;
import com.disney.datg.videoplatforms.sdk.analytics.ITracker;
import com.disney.datg.videoplatforms.sdk.analytics.TrackerFactory;
import com.disney.datg.videoplatforms.sdk.analytics.TrackingManager;
import com.disney.datg.videoplatforms.sdk.common.AsyncHandler;
import com.disney.datg.videoplatforms.sdk.common.ThreadPoolAccessor;
import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.models.api.Affiliate;
import com.disney.datg.videoplatforms.sdk.models.api.Affiliates;
import com.disney.datg.videoplatforms.sdk.models.api.Config;
import com.disney.datg.videoplatforms.sdk.models.api.GeoLocation;
import com.disney.datg.videoplatforms.sdk.utils.LogUtils;
import com.uplynk.media.CaptionStyle;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            Configuration, VPGeolocation, VPMedia, VPMediaMetadata, 
//            VPCaptionStyle, CaptionData

public abstract class VPMediaPlayer extends MediaPlayer
    implements com.uplynk.media.MediaPlayer.OnAssetBoundaryListener, com.uplynk.media.MediaPlayer.OnBufferingUpdateListener, com.uplynk.media.MediaPlayer.OnCaptionEventListener, com.uplynk.media.MediaPlayer.OnCompletionListener, com.uplynk.media.MediaPlayer.OnErrorListener, com.uplynk.media.MediaPlayer.OnInfoListener, com.uplynk.media.MediaPlayer.OnPreparedListener, com.uplynk.media.MediaPlayer.OnSeekCompleteListener, com.uplynk.media.MediaPlayer.OnUplynkMetadataListener, com.uplynk.media.MediaPlayer.OnVideoSizeChangedListener
{
    protected static final class BasePlayerType extends Enum
    {

        private static final BasePlayerType $VALUES[];
        public static final BasePlayerType NATIVE;
        public static final BasePlayerType UPLYNK;

        public static BasePlayerType valueOf(String s)
        {
            return (BasePlayerType)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType, s);
        }

        public static BasePlayerType[] values()
        {
            return (BasePlayerType[])$VALUES.clone();
        }

        static 
        {
            NATIVE = new BasePlayerType("NATIVE", 0);
            UPLYNK = new BasePlayerType("UPLYNK", 1);
            $VALUES = (new BasePlayerType[] {
                NATIVE, UPLYNK
            });
        }

        private BasePlayerType(String s, int i)
        {
            super(s, i);
        }
    }

    protected static final class PlayerState extends Enum
    {

        private static final PlayerState $VALUES[];
        public static final PlayerState ERROR;
        public static final PlayerState IDLE;
        public static final PlayerState INITIALIZED;
        public static final PlayerState PAUSED;
        public static final PlayerState PLAYBACK_COMPLETED;
        public static final PlayerState PREPARED;
        public static final PlayerState STARTED;
        public static final PlayerState STOPPED;

        public static PlayerState valueOf(String s)
        {
            return (PlayerState)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState, s);
        }

        public static PlayerState[] values()
        {
            return (PlayerState[])$VALUES.clone();
        }

        static 
        {
            IDLE = new PlayerState("IDLE", 0);
            INITIALIZED = new PlayerState("INITIALIZED", 1);
            STOPPED = new PlayerState("STOPPED", 2);
            PREPARED = new PlayerState("PREPARED", 3);
            STARTED = new PlayerState("STARTED", 4);
            PAUSED = new PlayerState("PAUSED", 5);
            PLAYBACK_COMPLETED = new PlayerState("PLAYBACK_COMPLETED", 6);
            ERROR = new PlayerState("ERROR", 7);
            $VALUES = (new PlayerState[] {
                IDLE, INITIALIZED, STOPPED, PREPARED, STARTED, PAUSED, PLAYBACK_COMPLETED, ERROR
            });
        }

        private PlayerState(String s, int i)
        {
            super(s, i);
        }
    }

    class ProgressionTask extends TimerTask
    {

        final VPMediaPlayer this$0;

        public void run()
        {
            if (isPlaying())
            {
                sendTrackable(TrackableState.PING);
            }
        }

        ProgressionTask()
        {
            this$0 = VPMediaPlayer.this;
            super();
        }
    }

    public class TimedText
    {

        CaptionData captionData;
        String text;
        final VPMediaPlayer this$0;

        protected TimedText(String s, CaptionData captiondata)
        {
            this$0 = VPMediaPlayer.this;
            super();
            text = s;
            captionData = captiondata;
        }
    }

    protected static final class TrackableState extends Enum
    {

        private static final TrackableState $VALUES[];
        public static final TrackableState AD_BREAK_END;
        public static final TrackableState AD_BREAK_START;
        public static final TrackableState AD_END;
        public static final TrackableState AD_ERROR;
        public static final TrackableState AD_START;
        public static final TrackableState AUTHORIZATION_FAIL;
        public static final TrackableState AUTHORIZATION_START;
        public static final TrackableState AUTHORIZATION_SUCCESS;
        public static final TrackableState COMPLETE;
        public static final TrackableState COMPLETE_25;
        public static final TrackableState COMPLETE_50;
        public static final TrackableState COMPLETE_75;
        public static final TrackableState MEDIA_ERROR;
        public static final TrackableState PING;
        public static final TrackableState PROGRAM_END;
        public static final TrackableState PROGRAM_FORWARD;
        public static final TrackableState PROGRAM_PAUSED;
        public static final TrackableState PROGRAM_RESUME;
        public static final TrackableState PROGRAM_REWIND;
        public static final TrackableState PROGRAM_START;
        public static final TrackableState PROGRAM_STOPPED;

        public static TrackableState valueOf(String s)
        {
            return (TrackableState)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState, s);
        }

        public static TrackableState[] values()
        {
            return (TrackableState[])$VALUES.clone();
        }

        static 
        {
            PROGRAM_START = new TrackableState("PROGRAM_START", 0);
            PROGRAM_RESUME = new TrackableState("PROGRAM_RESUME", 1);
            PROGRAM_PAUSED = new TrackableState("PROGRAM_PAUSED", 2);
            PROGRAM_STOPPED = new TrackableState("PROGRAM_STOPPED", 3);
            PROGRAM_END = new TrackableState("PROGRAM_END", 4);
            PROGRAM_FORWARD = new TrackableState("PROGRAM_FORWARD", 5);
            PROGRAM_REWIND = new TrackableState("PROGRAM_REWIND", 6);
            AUTHORIZATION_START = new TrackableState("AUTHORIZATION_START", 7);
            AUTHORIZATION_FAIL = new TrackableState("AUTHORIZATION_FAIL", 8);
            AUTHORIZATION_SUCCESS = new TrackableState("AUTHORIZATION_SUCCESS", 9);
            COMPLETE = new TrackableState("COMPLETE", 10);
            COMPLETE_75 = new TrackableState("COMPLETE_75", 11);
            COMPLETE_50 = new TrackableState("COMPLETE_50", 12);
            COMPLETE_25 = new TrackableState("COMPLETE_25", 13);
            AD_START = new TrackableState("AD_START", 14);
            AD_END = new TrackableState("AD_END", 15);
            AD_BREAK_START = new TrackableState("AD_BREAK_START", 16);
            AD_BREAK_END = new TrackableState("AD_BREAK_END", 17);
            AD_ERROR = new TrackableState("AD_ERROR", 18);
            MEDIA_ERROR = new TrackableState("MEDIA_ERROR", 19);
            PING = new TrackableState("PING", 20);
            $VALUES = (new TrackableState[] {
                PROGRAM_START, PROGRAM_RESUME, PROGRAM_PAUSED, PROGRAM_STOPPED, PROGRAM_END, PROGRAM_FORWARD, PROGRAM_REWIND, AUTHORIZATION_START, AUTHORIZATION_FAIL, AUTHORIZATION_SUCCESS, 
                COMPLETE, COMPLETE_75, COMPLETE_50, COMPLETE_25, AD_START, AD_END, AD_BREAK_START, AD_BREAK_END, AD_ERROR, MEDIA_ERROR, 
                PING
            });
        }

        private TrackableState(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface VPMediaMetadataListener
    {

        public abstract void onBoundaryEventReceived(Bundle bundle);
    }

    public static interface VPOnTimedTextListener
    {

        public abstract void onTimedText(VPMediaPlayer vpmediaplayer, TimedText timedtext);
    }


    private boolean authenticated;
    boolean closeCaptionsOn;
    protected Configuration configuration;
    protected Context context;
    protected String currentAssetId;
    protected CaptionStyle currentCaptionStyle;
    private VPMedia currentMedia;
    protected BasePlayerType currentPlayerType;
    protected String currentProgramId;
    protected int currentRating;
    boolean didReceiveUplynkMetadata;
    protected Future futureDataSource;
    protected boolean hdmiError;
    protected boolean isCancelled;
    protected ITracker omnitureTracker;
    private android.media.MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener;
    private android.media.MediaPlayer.OnCompletionListener onCompletionListener;
    private android.media.MediaPlayer.OnErrorListener onErrorListener;
    private android.media.MediaPlayer.OnInfoListener onInfoListener;
    private VPMediaMetadataListener onMediaMetadataListener;
    private android.media.MediaPlayer.OnPreparedListener onPreparedListener;
    private android.media.MediaPlayer.OnSeekCompleteListener onSeekCompleteListener;
    private VPOnTimedTextListener onTimedTextListener;
    private android.media.MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener;
    protected PlayerState playerState;
    boolean processNextAsset;
    protected Timer progressionTimer;
    protected boolean seekAllowed;
    protected ITracker sloggerTracker;
    protected com.uplynk.media.MediaPlayer uplynkMediaPlayer;

    protected VPMediaPlayer()
        throws AndroidSDKException
    {
        currentProgramId = "";
        currentAssetId = "";
        currentRating = -1;
        seekAllowed = false;
        processNextAsset = false;
        closeCaptionsOn = false;
        didReceiveUplynkMetadata = false;
        currentPlayerType = BasePlayerType.NATIVE;
        authenticated = false;
        isCancelled = false;
        hdmiError = false;
        throw new AndroidSDKException(ErrorCode.ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION, "Unsupported creation -- must be created through PlayerManager");
    }

    public VPMediaPlayer(Context context1, Configuration configuration1)
        throws AndroidSDKException
    {
        currentProgramId = "";
        currentAssetId = "";
        currentRating = -1;
        seekAllowed = false;
        processNextAsset = false;
        closeCaptionsOn = false;
        didReceiveUplynkMetadata = false;
        currentPlayerType = BasePlayerType.NATIVE;
        authenticated = false;
        isCancelled = false;
        hdmiError = false;
        if (context1 == null)
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION, "Activity is required for playback");
        }
        try
        {
            uplynkMediaPlayer = new com.uplynk.media.MediaPlayer();
            uplynkMediaPlayer.setContext(context1);
            configuration = configuration1;
            context = context1;
        }
        // Misplaced declaration of an exception variable
        catch (Context context1)
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_UNSUPPORTED_DEVICE_ERROR, context1);
        }
        if (configuration1 == null)
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_INVALID_CONFIGURATION, "misconfiguration - configuration was not set up correctly");
        }
        if (configuration1.getCurrentConfig() == null)
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_INVALID_CONFIGURATION, "misconfiguration - config was never called");
        } else
        {
            uplynkMediaPlayer.setOnBufferingUpdateListener(this);
            uplynkMediaPlayer.setOnCompletionListener(this);
            uplynkMediaPlayer.setOnPreparedListener(this);
            uplynkMediaPlayer.setOnVideoSizeChangedListener(this);
            uplynkMediaPlayer.setOnErrorListener(this);
            uplynkMediaPlayer.setOnInfoListener(this);
            uplynkMediaPlayer.setOnSeekCompleteListener(this);
            uplynkMediaPlayer.setOnAssetBoundaryListener(this);
            uplynkMediaPlayer.setOnUplynkMetadataListener(this);
            uplynkMediaPlayer.setOnCaptionEventListener(this);
            playerState = PlayerState.IDLE;
            return;
        }
    }

    private void shutdown()
    {
        ThreadPoolAccessor.getManager().forceCancel();
    }

    private void startProgressionTimer(boolean flag)
    {
        stopProgressionTimer();
        progressionTimer = new Timer();
        long l = 30000L;
        if (!flag)
        {
            l = 30000 - getCurrentPosition() % 30000;
        }
        progressionTimer.schedule(new ProgressionTask(), l, 30000L);
    }

    private void stopProgressionTimer()
    {
        if (progressionTimer != null)
        {
            progressionTimer.cancel();
            progressionTimer.purge();
        }
    }

    protected void addTrackers()
    {
        try
        {
            if (Configuration.ANALYTICS_ENABLED)
            {
                omnitureTracker = TrackerFactory.getTracker(com.disney.datg.videoplatforms.sdk.analytics.TrackerFactory.TrackerType.OMNITURE, (Activity)context, configuration);
                TrackingManager.registerTracker(omnitureTracker);
            }
        }
        catch (Exception exception)
        {
            LogUtils.LOGE("VPMediaPlayer", "Analytics Tracker could not be initialized");
        }
        try
        {
            if (Configuration.SLOGGER_ENABLED)
            {
                sloggerTracker = TrackerFactory.getTracker(com.disney.datg.videoplatforms.sdk.analytics.TrackerFactory.TrackerType.SLOGGER, (Activity)context, configuration);
                TrackingManager.registerTracker(sloggerTracker);
            }
            return;
        }
        catch (Exception exception1)
        {
            LogUtils.LOGE("VPMediaPlayer", "Slogger Tracker could not be initialized");
        }
    }

    public boolean canSeek()
    {
        return uplynkMediaPlayer != null && seekAllowed;
    }

    public void cancel()
    {
        isCancelled = true;
        if (futureDataSource != null)
        {
            futureDataSource.cancel(true);
        }
    }

    protected void doGeo()
        throws AndroidSDKException
    {
label0:
        {
            Object obj = VPGeolocation.getGeolocationManager().doLBS(context);
            if (configuration.getCurrentNetwork().equalsIgnoreCase("001") || configuration.getCurrentNetwork().equalsIgnoreCase("abc"))
            {
                if (obj == null || ((GeoLocation) (obj)).getAffiliates() == null || ((GeoLocation) (obj)).getAffiliates().getAffiliates() == null || ((GeoLocation) (obj)).getAffiliates().getAffiliates().size() <= 0)
                {
                    break label0;
                }
                Bundle bundle = new Bundle();
                boolean flag = false;
                ArrayList arraylist = new ArrayList();
                Affiliate affiliate;
                for (obj = ((GeoLocation) (obj)).getAffiliates().getAffiliates().iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(affiliate.getId()))
                {
                    affiliate = (Affiliate)((Iterator) (obj)).next();
                    if (affiliate.getId().equalsIgnoreCase(getCurrentMedia().affiliateId))
                    {
                        flag = true;
                        bundle.putString(VPMediaMetadata.ASSET_CURRENT_AFFILIATE, getCurrentMedia().affiliateId);
                    }
                }

                if (!flag)
                {
                    getOnErrorListener().onError(this, 1, ErrorCode.ANDROID_SDK_GEO_UNSUPPORTED_AFFILIATE.getErrorCode());
                    stop();
                    reset();
                    throw new AndroidSDKException(ErrorCode.ANDROID_SDK_GEO_UNSUPPORTED_AFFILIATE);
                }
                String as[] = (String[])arraylist.toArray(new String[arraylist.size()]);
                bundle.putStringArray(VPMediaMetadata.ASSET_SUPPORTED_AFFILIATES, as);
                sendMetadataEvent(VPMediaMetadata.METADATA_EVENT, bundle);
            }
            return;
        }
        getOnErrorListener().onError(this, 1, ErrorCode.ANDROID_SDK_GEO_UNSUPPORTED_AREA.getErrorCode());
        stop();
        reset();
        throw new AndroidSDKException(ErrorCode.ANDROID_SDK_GEO_UNSUPPORTED_AREA);
    }

    public void enableClosedCaptioning(boolean flag)
    {
        static class _cls3
        {

            static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AuthState[];
            static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType[];
            static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[];

            static 
            {
                $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState = new int[TrackableState.values().length];
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[TrackableState.PROGRAM_START.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[TrackableState.PROGRAM_RESUME.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[TrackableState.PROGRAM_FORWARD.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[TrackableState.PROGRAM_REWIND.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[TrackableState.PROGRAM_PAUSED.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[TrackableState.PROGRAM_STOPPED.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[TrackableState.AD_START.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[TrackableState.AD_END.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[TrackableState.AUTHORIZATION_START.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[TrackableState.AUTHORIZATION_FAIL.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[TrackableState.AUTHORIZATION_SUCCESS.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[TrackableState.COMPLETE_25.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[TrackableState.COMPLETE_50.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[TrackableState.COMPLETE_75.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[TrackableState.PROGRAM_END.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[TrackableState.COMPLETE.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[TrackableState.MEDIA_ERROR.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState[TrackableState.PING.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType = new int[BasePlayerType.values().length];
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType[BasePlayerType.UPLYNK.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType[BasePlayerType.NATIVE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AuthState = new int[VPMedia.AuthState.values().length];
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AuthState[VPMedia.AuthState.AUTHORIZED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()];
        JVM INSTR tableswitch 1 1: default 28
    //                   1 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (isPlaying() && getCurrentMedia() != null)
        {
            if (closeCaptionsOn && !flag)
            {
                closeCaptionsOn = false;
                uplynkMediaPlayer.setCaptionsEnabled(false);
                return;
            }
            if (!closeCaptionsOn && flag)
            {
                closeCaptionsOn = true;
                if (currentCaptionStyle == null)
                {
                    currentCaptionStyle = new CaptionStyle();
                }
                uplynkMediaPlayer.setCaptionStyle(currentCaptionStyle);
                uplynkMediaPlayer.setCaptionsEnabled(true);
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void finalize()
    {
        LogUtils.LOGE("VPMediaPlayer", "finalizing VPMediaPlayer");
        super.finalize();
    }

    public VPMedia getCurrentMedia()
    {
        return currentMedia;
    }

    public int getCurrentPosition()
    {
        if (currentPlayerType == null)
        {
            return 0;
        }
        switch (_cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()])
        {
        default:
            return 0;

        case 1: // '\001'
            if (uplynkMediaPlayer != null)
            {
                return uplynkMediaPlayer.getCurrentPosition();
            }
            // fall through

        case 2: // '\002'
            return super.getCurrentPosition();
        }
    }

    public int getDuration()
    {
        switch (_cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()])
        {
        default:
            return 0;

        case 1: // '\001'
            if (uplynkMediaPlayer != null)
            {
                return uplynkMediaPlayer.getDuration();
            }
            // fall through

        case 2: // '\002'
            return super.getDuration();
        }
    }

    public android.media.MediaPlayer.OnBufferingUpdateListener getOnBufferingUpdateListener()
    {
        return onBufferingUpdateListener;
    }

    public android.media.MediaPlayer.OnCompletionListener getOnCompletionListener()
    {
        return onCompletionListener;
    }

    public android.media.MediaPlayer.OnErrorListener getOnErrorListener()
    {
        return onErrorListener;
    }

    public android.media.MediaPlayer.OnInfoListener getOnInfoListener()
    {
        return onInfoListener;
    }

    public VPMediaMetadataListener getOnMediaMetadataListener()
    {
        return onMediaMetadataListener;
    }

    public android.media.MediaPlayer.OnPreparedListener getOnPreparedListener()
    {
        return onPreparedListener;
    }

    public android.media.MediaPlayer.OnSeekCompleteListener getOnSeekCompleteListener()
    {
        return onSeekCompleteListener;
    }

    public VPOnTimedTextListener getOnTimedTextListener()
    {
        return onTimedTextListener;
    }

    public android.media.MediaPlayer.OnVideoSizeChangedListener getOnVideoSizeChangedListener()
    {
        return onVideoSizeChangedListener;
    }

    public int getVideoHeight()
    {
        switch (_cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()])
        {
        default:
            return 0;

        case 1: // '\001'
            if (uplynkMediaPlayer != null)
            {
                return uplynkMediaPlayer.getVideoHeight();
            }
            // fall through

        case 2: // '\002'
            return super.getVideoHeight();
        }
    }

    public int getVideoWidth()
    {
        switch (_cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()])
        {
        default:
            return 0;

        case 1: // '\001'
            if (uplynkMediaPlayer != null)
            {
                return uplynkMediaPlayer.getVideoWidth();
            }
            // fall through

        case 2: // '\002'
            return super.getVideoWidth();
        }
    }

    protected boolean isAuthenticated()
    {
        return authenticated;
    }

    public boolean isPlaying()
    {
        while (currentPlayerType == null || currentMedia == null) 
        {
            return false;
        }
        switch (_cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
            if (uplynkMediaPlayer != null)
            {
                return uplynkMediaPlayer.isPlaying();
            }
            // fall through

        case 2: // '\002'
            return super.isPlaying();
        }
    }

    public void onAssetBoundary(com.uplynk.media.MediaPlayer mediaplayer, String s)
    {
        if (isCancelled)
        {
            release();
            LogUtils.LOGD("VPMediaPlayer", "releasing player since cancelled has been called");
        } else
        if (isPlaying() && !TextUtils.isEmpty(s))
        {
            currentAssetId = s;
            processNextAsset = true;
            LogUtils.LOGD("VPMediaPlayer", String.format("uplynk onAssetBoundary called-%s", new Object[] {
                s.toString()
            }));
            return;
        }
    }

    public void onBufferingUpdate(com.uplynk.media.MediaPlayer mediaplayer, int i)
    {
        LogUtils.LOGD("VPMediaPlayer", (new StringBuilder()).append("uplynk onBufferingUpdate percent:").append(i).toString());
        if (getOnBufferingUpdateListener() != null)
        {
            getOnBufferingUpdateListener().onBufferingUpdate(this, i);
        }
    }

    public void onCompletion(com.uplynk.media.MediaPlayer mediaplayer)
    {
        LogUtils.LOGD("VPMediaPlayer", "uplynk onCompletion called");
        if (getOnCompletionListener() != null)
        {
            getOnCompletionListener().onCompletion(this);
            sendMetadataEvent(VPMediaMetadata.BOUNDARY_EVENT_PROGRAM_END);
            sendTrackable(TrackableState.COMPLETE);
            stopProgressionTimer();
        }
        playerState = PlayerState.PLAYBACK_COMPLETED;
    }

    public boolean onError(com.uplynk.media.MediaPlayer mediaplayer, int i, int j)
    {
        LogUtils.LOGD("VPMediaPlayer", "uplynk onError called");
        if (getOnErrorListener() != null)
        {
            getOnErrorListener().onError(this, i, j);
        }
        playerState = PlayerState.ERROR;
        return false;
    }

    public boolean onInfo(com.uplynk.media.MediaPlayer mediaplayer, int i, int j)
    {
        LogUtils.LOGD("VPMediaPlayer", "uplynk onInfo called");
        if (getOnInfoListener() != null)
        {
            getOnInfoListener().onInfo(this, i, j);
        }
        return false;
    }

    public void onPrepared(com.uplynk.media.MediaPlayer mediaplayer)
    {
        if (!isCancelled)
        {
            LogUtils.LOGD("VPMediaPlayer", "uplynk onPrepared called");
            if (getOnPreparedListener() != null)
            {
                getOnPreparedListener().onPrepared(this);
            }
            playerState = PlayerState.PREPARED;
            return;
        } else
        {
            LogUtils.LOGD("VPMediaPlayer", "media has been cancelled");
            return;
        }
    }

    public void onSeekComplete(com.uplynk.media.MediaPlayer mediaplayer)
    {
        if (getOnSeekCompleteListener() != null)
        {
            LogUtils.LOGD("VPMediaPlayer", "uplynk onSeekComplete called");
            getOnSeekCompleteListener().onSeekComplete(this);
        }
    }

    public boolean onUplynkMetadata(com.uplynk.media.MediaPlayer mediaplayer, com.uplynk.media.MediaPlayer.UplynkMetadata uplynkmetadata)
    {
        if (isCancelled)
        {
            release();
            LogUtils.LOGD("VPMediaPlayer", "releasing player since cancelled has been called");
        } else
        if (isPlaying())
        {
            didReceiveUplynkMetadata = true;
            LogUtils.LOGD("VPMediaPlayer", String.format("uplynk onUplynkMetadata called-%s", new Object[] {
                uplynkmetadata.toString()
            }));
            return true;
        }
        return false;
    }

    public void onVideoSizeChanged(com.uplynk.media.MediaPlayer mediaplayer, int i, int j)
    {
        LogUtils.LOGV("VPMediaPlayer", "uplynk onVideoSizeChanged called");
        if (getOnVideoSizeChangedListener() != null)
        {
            getOnVideoSizeChangedListener().onVideoSizeChanged(this, i, j);
        }
    }

    public void pause()
        throws IllegalStateException
    {
        _cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 40
    //                   2 78;
           goto _L1 _L2 _L3
_L1:
        playerState = PlayerState.PAUSED;
        return;
_L2:
        if (uplynkMediaPlayer != null && uplynkMediaPlayer.isPlaying())
        {
            uplynkMediaPlayer.pause();
            sendTrackable(TrackableState.PROGRAM_PAUSED);
            stopProgressionTimer();
        }
        continue; /* Loop/switch isn't completed */
_L3:
        super.pause();
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void prepare()
        throws IOException, IllegalStateException
    {
        _cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 40
    //                   2 85;
           goto _L1 _L2 _L3
_L1:
        playerState = PlayerState.PREPARED;
        return;
_L2:
        if (uplynkMediaPlayer != null)
        {
            if (getCurrentMedia() == null)
            {
                throw new IllegalStateException("dataSource with VPMedia object should be set before prepare is called");
            }
            try
            {
                uplynkMediaPlayer.prepare();
            }
            catch (Exception exception)
            {
                throw new IllegalStateException(exception);
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        super.prepare();
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void prepareAsync()
        throws IllegalStateException
    {
        _cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 40
    //                   2 85;
           goto _L1 _L2 _L3
_L1:
        playerState = PlayerState.PREPARED;
        return;
_L2:
        if (uplynkMediaPlayer != null)
        {
            if (getCurrentMedia() == null)
            {
                throw new IllegalStateException("dataSource with VPMedia object should be set before prepare is called");
            }
            try
            {
                uplynkMediaPlayer.prepareAsync();
            }
            catch (Exception exception)
            {
                throw new IllegalStateException(exception);
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        super.prepareAsync();
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void release()
    {
        _cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 33
    //                   2 99;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (uplynkMediaPlayer != null)
        {
            if (uplynkMediaPlayer.isPlaying())
            {
                uplynkMediaPlayer.stop();
            }
            super.release();
            uplynkMediaPlayer.release();
            cancel();
            stopProgressionTimer();
            removeListeners();
            removeTrackers();
            uplynkMediaPlayer = null;
            currentMedia = null;
            shutdown();
            return;
        }
          goto _L1
_L3:
        super.release();
        return;
    }

    protected void removeListeners()
    {
        onBufferingUpdateListener = null;
        onCompletionListener = null;
        onErrorListener = null;
        onInfoListener = null;
        onPreparedListener = null;
        onSeekCompleteListener = null;
        onVideoSizeChangedListener = null;
        onMediaMetadataListener = null;
        super.setOnBufferingUpdateListener(onBufferingUpdateListener);
        super.setOnCompletionListener(onCompletionListener);
        super.setOnErrorListener(onErrorListener);
        super.setOnInfoListener(onInfoListener);
        super.setOnPreparedListener(onPreparedListener);
        super.setOnSeekCompleteListener(onSeekCompleteListener);
        super.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        if (uplynkMediaPlayer != null)
        {
            uplynkMediaPlayer.setOnAssetBoundaryListener(null);
            uplynkMediaPlayer.setOnBufferingUpdateListener(null);
            uplynkMediaPlayer.setOnCaptionEventListener(null);
            uplynkMediaPlayer.setOnCompletionListener(null);
            uplynkMediaPlayer.setOnErrorListener(null);
            uplynkMediaPlayer.setOnInfoListener(null);
            uplynkMediaPlayer.setOnPreparedListener(null);
            uplynkMediaPlayer.setOnSeekCompleteListener(null);
            uplynkMediaPlayer.setOnUplynkMetadataListener(null);
            uplynkMediaPlayer.setOnVideoSizeChangedListener(null);
        }
    }

    protected void removeTrackers()
    {
        TrackingManager.removeAllTrackers();
    }

    public void reset()
    {
        LogUtils.LOGD("VPMediaPlayer", "resetting resources back to IDLE state");
        _cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 52
    //                   2 136;
           goto _L1 _L2 _L3
_L1:
        playerState = PlayerState.IDLE;
        return;
_L2:
        if (uplynkMediaPlayer != null)
        {
            if (uplynkMediaPlayer.isPlaying())
            {
                uplynkMediaPlayer.stop();
            }
            uplynkMediaPlayer.reset();
            currentMedia = null;
            processNextAsset = false;
            seekAllowed = false;
            closeCaptionsOn = false;
            didReceiveUplynkMetadata = false;
            currentProgramId = "";
            currentAssetId = "";
            currentRating = -1;
            removeListeners();
            removeTrackers();
        }
        continue; /* Loop/switch isn't completed */
_L3:
        removeListeners();
        super.reset();
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void sendMetadataEvent(String s)
    {
        if (getCurrentMedia() != null && getOnMediaMetadataListener() != null && getCurrentMedia().getCurrentMetadata() != null)
        {
            s = getCurrentMedia().getCurrentMetadata().createBoundaryEvent(s);
            getOnMediaMetadataListener().onBoundaryEventReceived(s);
        }
    }

    protected void sendMetadataEvent(String s, Bundle bundle)
    {
        if (getCurrentMedia() != null && getOnMediaMetadataListener() != null && getCurrentMedia().getCurrentMetadata() != null)
        {
            s = getCurrentMedia().getCurrentMetadata().createBoundaryEvent(s);
            s.putAll(bundle);
            getOnMediaMetadataListener().onBoundaryEventReceived(s);
        }
    }

    protected void sendTimedText(String s, CaptionData captiondata)
    {
        if (getCurrentMedia() != null && getOnTimedTextListener() != null)
        {
            getOnTimedTextListener().onTimedText(this, new TimedText(s, captiondata));
        }
    }

    protected void sendTrackable(TrackableState trackablestate)
    {
        sendTrackable(trackablestate, null);
    }

    protected void sendTrackable(TrackableState trackablestate, Bundle bundle)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        ILinkTracker ilinktracker;
        try
        {
            obj = TrackingManager.getLinkTrackers();
        }
        // Misplaced declaration of an exception variable
        catch (TrackableState trackablestate)
        {
            return;
        }
        finally
        {
            throw trackablestate;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        if (((Vector) (obj)).size() <= 0)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        obj = ((Vector) (obj)).iterator();
_L2:
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_64;
            }
            ilinktracker = (ILinkTracker)((Iterator) (obj)).next();
        } while (ilinktracker == null);
        sendTrackable(trackablestate, bundle, ilinktracker.getName());
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void sendTrackable(TrackableState trackablestate, Bundle bundle, String s)
    {
        AppTrackable apptrackable;
        apptrackable = new AppTrackable();
        apptrackable.setName(s);
        apptrackable.addContext("activity", (Activity)context);
        apptrackable.addContext("currentMedia", getCurrentMedia());
        apptrackable.addContext("authenticated", Boolean.valueOf(isAuthenticated()));
        apptrackable.addContext("position", Integer.valueOf(getCurrentPosition()));
        _cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.TrackableState[trackablestate.ordinal()];
        JVM INSTR tableswitch 1 18: default 422
    //                   1 168
    //                   2 226
    //                   3 235
    //                   4 244
    //                   5 277
    //                   6 286
    //                   7 295
    //                   8 304
    //                   9 313
    //                   10 322
    //                   11 331
    //                   12 340
    //                   13 349
    //                   14 358
    //                   15 367
    //                   16 367
    //                   17 376
    //                   18 413;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L16 _L17 _L18
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        if (bundle == null) goto _L20; else goto _L19
_L19:
        if (bundle.containsKey("start_video"))
        {
            apptrackable.addContext("start_video", "");
        }
_L20:
        TrackingManager.trackMedia(com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.MediaEvent.STARTED, apptrackable);
        return;
_L3:
        try
        {
            TrackingManager.trackMedia(com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.MediaEvent.RESUMED, apptrackable);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TrackableState trackablestate)
        {
            LogUtils.LOGE("VPMediaPlayer", String.format("Error sending Omniture/Slogger tracking:%s", new Object[] {
                trackablestate.getMessage()
            }));
            return;
        }
_L4:
        TrackingManager.trackMedia(com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.MediaEvent.FORWARD, apptrackable);
        return;
_L5:
        if (bundle == null) goto _L22; else goto _L21
_L21:
        if (bundle.containsKey("10_sec_rewind"))
        {
            apptrackable.addContext("10_sec_rewind", "");
        }
_L22:
        TrackingManager.trackMedia(com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.MediaEvent.REWIND, apptrackable);
        return;
_L6:
        TrackingManager.trackMedia(com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.MediaEvent.PAUSED, apptrackable);
        return;
_L7:
        TrackingManager.trackMedia(com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.MediaEvent.STOPPED, apptrackable);
        return;
_L8:
        TrackingManager.trackAd(com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.AdEvent.STARTED, apptrackable);
        return;
_L9:
        TrackingManager.trackAd(com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.AdEvent.COMPLETED, apptrackable);
        return;
_L10:
        TrackingManager.trackAuthZ(com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.AuthZEvent.AUTH_Z_STARTED, apptrackable);
        return;
_L11:
        TrackingManager.trackAuthZ(com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.AuthZEvent.AUTH_Z_FAILED, apptrackable);
        return;
_L12:
        TrackingManager.trackAuthZ(com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.AuthZEvent.AUTH_Z_SUCCESS, apptrackable);
        return;
_L13:
        TrackingManager.trackMedia(com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.MediaEvent.FIRST_QUARTER, apptrackable);
        return;
_L14:
        TrackingManager.trackMedia(com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.MediaEvent.MID_POINT, apptrackable);
        return;
_L15:
        TrackingManager.trackMedia(com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.MediaEvent.THIRD_QUARTER, apptrackable);
        return;
_L16:
        TrackingManager.trackMedia(com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.MediaEvent.COMPLETE, apptrackable);
        return;
_L17:
        if (bundle == null)
        {
            break; /* Loop/switch isn't completed */
        }
        trackablestate = bundle.getString("error");
        if (!TextUtils.isEmpty(trackablestate))
        {
            apptrackable.addContext("error", trackablestate);
            TrackingManager.trackMedia(com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.MediaEvent.ERROR, apptrackable);
            return;
        }
        break; /* Loop/switch isn't completed */
_L18:
        TrackingManager.trackMedia(com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.MediaEvent.PING, apptrackable);
        return;
    }

    public void setAudioStreamType(int i)
    {
        _cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 33
    //                   2 49;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (uplynkMediaPlayer != null)
        {
            uplynkMediaPlayer.setAudioStreamType(i);
            return;
        }
          goto _L1
_L3:
        super.setAudioStreamType(i);
        return;
    }

    public void setCaptionStyle(VPCaptionStyle vpcaptionstyle)
    {
        if (vpcaptionstyle != null)
        {
            currentCaptionStyle = new CaptionStyle();
            currentCaptionStyle.setBackgroundColor(vpcaptionstyle.getBackgroundColor());
            currentCaptionStyle.setEdgeType(vpcaptionstyle.getEdgeType());
            currentCaptionStyle.setTextColor(vpcaptionstyle.getTextColor());
            currentCaptionStyle.setTextSize(vpcaptionstyle.getTextSize());
            if (vpcaptionstyle.getTypeFace() != null)
            {
                currentCaptionStyle.setTypeface(vpcaptionstyle.getTypeFace());
            }
        }
    }

    public void setClosedCaptionContainer(final RelativeLayout ccContainer)
    {
        _cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()];
        JVM INSTR tableswitch 1 1: default 28
    //                   1 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (context != null && (context instanceof Activity))
        {
            Activity activity = (Activity)context;
            if (uplynkMediaPlayer != null && ccContainer != null)
            {
                activity.runOnUiThread(new Runnable() {

                    final VPMediaPlayer this$0;
                    final RelativeLayout val$ccContainer;

                    public void run()
                    {
                        uplynkMediaPlayer.setCaptionLayoutContainer(ccContainer);
                    }

            
            {
                this$0 = VPMediaPlayer.this;
                ccContainer = relativelayout;
                super();
            }
                });
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void setCurrentMedia(VPMedia vpmedia)
    {
        currentMedia = vpmedia;
    }

    public Future setDataSource(final VPMedia media, final AsyncHandler asyncHandler)
        throws IllegalArgumentException, IllegalStateException
    {
        futureDataSource = ThreadPoolAccessor.getManager().execute(new Callable() {

            final VPMediaPlayer this$0;
            final AsyncHandler val$asyncHandler;
            final VPMedia val$media;

            public Boolean call()
                throws Exception
            {
                if (isCancelled)
                {
                    throw new IllegalStateException(new AndroidSDKException(ErrorCode.ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION, "This media player is cancelled"));
                }
                if (media == null) goto _L2; else goto _L1
_L1:
                Object obj;
                Object obj1;
                if (media.getOnAuthorizationListener() == null)
                {
                    throw new IllegalStateException(new AndroidSDKException(ErrorCode.ANDROID_INVALID_MEDIA_EXCEPTION, "VPMedia object must have listener attached to receive AuthZ events"));
                }
                media.setConfiguration(configuration);
                removeTrackers();
                addTrackers();
                if (TextUtils.isEmpty(media.getContentUrl()))
                {
                    throw new AndroidSDKException(ErrorCode.ANDROID_SDK_MEDIA_PLAYER_ASSET_UNAVAILABLE);
                }
                obj1 = null;
                obj = obj1;
                if (isCancelled)
                {
                    obj = obj1;
                    try
                    {
                        throw new IllegalStateException(new AndroidSDKException(ErrorCode.ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION, "This media player is cancelled"));
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj1) { }
                    if (obj != null)
                    {
                        ((Future) (obj)).cancel(true);
                    }
                    if (asyncHandler != null)
                    {
                        asyncHandler.onError(((Exception) (obj1)));
                    }
                    sendTrackable(TrackableState.AUTHORIZATION_FAIL);
                    authenticated = false;
                    setCurrentMedia(null);
                    throw new IllegalStateException(((Throwable) (obj1)));
                }
                obj = obj1;
                if (asyncHandler == null)
                {
                    break MISSING_BLOCK_LABEL_241;
                }
                obj = obj1;
                asyncHandler.onAsyncTask();
                obj = obj1;
                setCurrentMedia(media);
                obj = obj1;
                sendTrackable(TrackableState.AUTHORIZATION_START);
                obj = obj1;
                obj1 = media.getPlayableAssetUrl(null);
                obj = obj1;
                String s = (String)((Future) (obj1)).get(Configuration.SERVICE_TIMEOUT, TimeUnit.SECONDS);
                obj = obj1;
                if (!isCancelled)
                {
                    break MISSING_BLOCK_LABEL_330;
                }
                obj = obj1;
                throw new IllegalStateException(new AndroidSDKException(ErrorCode.ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION, "This media player is cancelled"));
                obj = obj1;
                if (uplynkMediaPlayer == null)
                {
                    break MISSING_BLOCK_LABEL_400;
                }
                obj = obj1;
                String s1 = configuration.getCurrentConfig().getParamInFeatureId("maxBitrate", "FEAT0006");
                if (s1 == null)
                {
                    break MISSING_BLOCK_LABEL_400;
                }
                obj = obj1;
                uplynkMediaPlayer.setMaxBitrate(Integer.parseInt(configuration.getCurrentConfig().getParamInFeatureId("maxBitrate", "FEAT0006")));
_L3:
                obj = obj1;
                setDataSource(s);
                obj = obj1;
                sendTrackable(TrackableState.AUTHORIZATION_SUCCESS);
                obj = obj1;
                authenticated = true;
                obj = obj1;
                if (asyncHandler == null)
                {
                    break MISSING_BLOCK_LABEL_454;
                }
                obj = obj1;
                asyncHandler.onSuccess(s);
                obj = obj1;
                return Boolean.valueOf(true);
                NumberFormatException numberformatexception;
                numberformatexception;
                numberformatexception = ((NumberFormatException) (obj1));
                LogUtils.LOGW("VPMediaPlayer", "error parsing maxbitrate in config, so it is being ignored");
                if (true) goto _L3; else goto _L2
_L2:
                throw new IllegalArgumentException(new AndroidSDKException(ErrorCode.ANDROID_INVALID_MEDIA_EXCEPTION, "valid Media object must be set"));
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = VPMediaPlayer.this;
                media = vpmedia;
                asyncHandler = asynchandler;
                super();
            }
        });
        return futureDataSource;
    }

    public void setDataSource(Context context1, Uri uri)
        throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
    {
        currentPlayerType = BasePlayerType.NATIVE;
        super.setDataSource(context1, uri);
        playerState = PlayerState.INITIALIZED;
    }

    public void setDataSource(Context context1, Uri uri, Map map)
        throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
    {
        currentPlayerType = BasePlayerType.NATIVE;
        super.setDataSource(context1, uri, map);
        playerState = PlayerState.INITIALIZED;
    }

    public void setDataSource(FileDescriptor filedescriptor)
        throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
    {
        currentPlayerType = BasePlayerType.NATIVE;
        super.setDataSource(filedescriptor);
        playerState = PlayerState.INITIALIZED;
    }

    public void setDataSource(FileDescriptor filedescriptor, long l, long l1)
        throws IOException, IllegalArgumentException, IllegalStateException
    {
        currentPlayerType = BasePlayerType.NATIVE;
        super.setDataSource(filedescriptor, l, l1);
        playerState = PlayerState.INITIALIZED;
    }

    public void setDataSource(String s)
        throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
    {
        if (getCurrentMedia() == null) goto _L2; else goto _L1
_L1:
        currentPlayerType = BasePlayerType.UPLYNK;
        if (!TextUtils.isEmpty(getCurrentMedia().getAssetUrl()) || !TextUtils.equals("?", getCurrentMedia().getAssetUrl())) goto _L4; else goto _L3
_L3:
        _cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMedia.AuthState[getCurrentMedia().authState.ordinal()];
        JVM INSTR tableswitch 1 1: default 76
    //                   1 99;
           goto _L4 _L5
_L4:
        if (uplynkMediaPlayer != null)
        {
            uplynkMediaPlayer.setDataSource(s);
            playerState = PlayerState.INITIALIZED;
        }
        return;
_L5:
        throw new IllegalStateException(new AndroidSDKException(ErrorCode.ANDROID_INVALID_MEDIA_EXCEPTION, "invalid asset url"));
_L2:
        currentPlayerType = BasePlayerType.NATIVE;
        super.setDataSource(s);
        playerState = PlayerState.INITIALIZED;
        return;
    }

    public void setDisplay(SurfaceHolder surfaceholder)
    {
        if (uplynkMediaPlayer != null)
        {
            uplynkMediaPlayer.setDisplay(surfaceholder);
            return;
        } else
        {
            super.setDisplay(surfaceholder);
            return;
        }
    }

    public void setOnBufferingUpdateListener(android.media.MediaPlayer.OnBufferingUpdateListener onbufferingupdatelistener)
    {
        if (onbufferingupdatelistener != null)
        {
            onBufferingUpdateListener = onbufferingupdatelistener;
        }
        if (uplynkMediaPlayer != null)
        {
            uplynkMediaPlayer.setOnBufferingUpdateListener(this);
        }
        super.setOnBufferingUpdateListener(onBufferingUpdateListener);
    }

    public void setOnCompletionListener(android.media.MediaPlayer.OnCompletionListener oncompletionlistener)
    {
        if (oncompletionlistener != null)
        {
            onCompletionListener = oncompletionlistener;
        }
        if (uplynkMediaPlayer != null)
        {
            uplynkMediaPlayer.setOnCompletionListener(this);
        }
        super.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(android.media.MediaPlayer.OnErrorListener onerrorlistener)
    {
        if (onerrorlistener != null)
        {
            onErrorListener = onerrorlistener;
        }
        if (uplynkMediaPlayer != null)
        {
            uplynkMediaPlayer.setOnErrorListener(this);
        }
        super.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(android.media.MediaPlayer.OnInfoListener oninfolistener)
    {
        if (oninfolistener != null)
        {
            onInfoListener = oninfolistener;
        }
        if (uplynkMediaPlayer != null)
        {
            uplynkMediaPlayer.setOnInfoListener(this);
        }
        super.setOnInfoListener(onInfoListener);
    }

    public void setOnPreparedListener(android.media.MediaPlayer.OnPreparedListener onpreparedlistener)
    {
        if (onpreparedlistener != null)
        {
            onPreparedListener = onpreparedlistener;
        }
        if (uplynkMediaPlayer != null)
        {
            uplynkMediaPlayer.setOnPreparedListener(this);
        }
        super.setOnPreparedListener(onPreparedListener);
    }

    public void setOnSeekCompleteListener(android.media.MediaPlayer.OnSeekCompleteListener onseekcompletelistener)
    {
        if (onseekcompletelistener != null)
        {
            onSeekCompleteListener = onseekcompletelistener;
        }
        if (uplynkMediaPlayer != null)
        {
            uplynkMediaPlayer.setOnSeekCompleteListener(this);
        }
        super.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    public void setOnVideoSizeChangedListener(android.media.MediaPlayer.OnVideoSizeChangedListener onvideosizechangedlistener)
    {
        if (onvideosizechangedlistener != null)
        {
            onVideoSizeChangedListener = onvideosizechangedlistener;
        }
        if (uplynkMediaPlayer != null)
        {
            uplynkMediaPlayer.setOnVideoSizeChangedListener(this);
        }
        super.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
    }

    public void setScreenOnWhilePlaying(boolean flag)
    {
        _cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 33
    //                   2 49;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (uplynkMediaPlayer != null)
        {
            uplynkMediaPlayer.setScreenOnWhilePlaying(flag);
            return;
        }
          goto _L1
_L3:
        super.setScreenOnWhilePlaying(flag);
        return;
    }

    public void setSurface(Surface surface)
    {
        switch (_cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()])
        {
        case 1: // '\001'
        default:
            return;

        case 2: // '\002'
            super.setSurface(surface);
            break;
        }
    }

    public void start()
        throws IllegalStateException
    {
        _cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 40
    //                   2 118;
           goto _L1 _L2 _L3
_L1:
        playerState = PlayerState.STARTED;
        return;
_L2:
        if (uplynkMediaPlayer != null && !uplynkMediaPlayer.isPlaying() && !hdmiError && !isCancelled)
        {
            uplynkMediaPlayer.start();
            if (playerState == PlayerState.PAUSED)
            {
                sendTrackable(TrackableState.PROGRAM_RESUME);
                startProgressionTimer(false);
            } else
            {
                sendTrackable(TrackableState.PROGRAM_START);
                startProgressionTimer(true);
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        super.start();
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void stop()
    {
        _cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 44
    //                   2 72;
           goto _L1 _L2 _L3
_L1:
        playerState = PlayerState.STOPPED;
        reset();
        return;
_L2:
        if (uplynkMediaPlayer != null)
        {
            uplynkMediaPlayer.stop();
            sendTrackable(TrackableState.PROGRAM_STOPPED);
            stopProgressionTimer();
        }
        continue; /* Loop/switch isn't completed */
_L3:
        super.stop();
        if (true) goto _L1; else goto _L4
_L4:
    }


/*
    static boolean access$002(VPMediaPlayer vpmediaplayer, boolean flag)
    {
        vpmediaplayer.authenticated = flag;
        return flag;
    }

*/
}
