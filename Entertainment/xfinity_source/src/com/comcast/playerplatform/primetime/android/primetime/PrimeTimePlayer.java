// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.primetime;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.adobe.ave.MediaErrorCode;
import com.adobe.ave.drm.DRMOperationErrorCallback;
import com.adobe.mediacore.ABRControlParameters;
import com.adobe.mediacore.BufferControlParameters;
import com.adobe.mediacore.DRMMetadataInfo;
import com.adobe.mediacore.DefaultMediaPlayer;
import com.adobe.mediacore.MediaPlayer;
import com.adobe.mediacore.MediaPlayerItem;
import com.adobe.mediacore.MediaPlayerNotification;
import com.adobe.mediacore.MediaResource;
import com.adobe.mediacore.Version;
import com.adobe.mediacore.info.AudioTrack;
import com.adobe.mediacore.info.ClosedCaptionsTrack;
import com.adobe.mediacore.info.Profile;
import com.adobe.mediacore.logging.Log;
import com.adobe.mediacore.logging.Logger;
import com.adobe.mediacore.metadata.DefaultMetadataKeys;
import com.adobe.mediacore.metadata.Metadata;
import com.adobe.mediacore.metadata.MetadataNode;
import com.adobe.mediacore.metadata.TimedMetadata;
import com.adobe.mediacore.qos.LoadInfo;
import com.adobe.mediacore.qos.QOSProvider;
import com.adobe.mediacore.qos.metrics.PlaybackMetrics;
import com.adobe.mediacore.utils.TimeRange;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.playerplatform.drm.java.event.AbstractDrmLicenseEventListener;
import com.comcast.playerplatform.drm.java.service.LicenseService;
import com.comcast.playerplatform.primetime.android.ads.CustomAdvertisingFactory;
import com.comcast.playerplatform.primetime.android.ads.managers.BaseAdManager;
import com.comcast.playerplatform.primetime.android.analytics.PlayerPerformanceMetrics;
import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.enums.AdType;
import com.comcast.playerplatform.primetime.android.enums.DrmWorkflow;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.enums.StreamType;
import com.comcast.playerplatform.primetime.android.events.AbstractPlayerPlatformVideoEventListener;
import com.comcast.playerplatform.primetime.android.events.PlayerEventManager;
import com.comcast.playerplatform.primetime.android.player.Player;
import com.comcast.playerplatform.primetime.android.player.PlayerSettings;
import com.comcast.playerplatform.primetime.android.player.PlayerSettingsListener;
import com.comcast.playerplatform.primetime.android.util.ClosedCaptionFormatBuilder;
import com.comcast.playerplatform.primetime.android.util.ConfigurationHelper;
import com.comcast.playerplatform.primetime.android.util.FragmentInfo;
import com.comcast.playerplatform.primetime.android.util.LogFactory;
import com.comcast.playerplatform.primetime.android.util.PlayerLogger;
import com.comcast.playerplatform.primetime.android.util.ThreadManager;
import com.comcast.playerplatform.util.android.Range;
import com.comcast.playerplatform.util.android.StringUtil;
import com.comcast.playerplatform.util.android.TimeUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.math.util.MathUtils;

// Referenced classes of package com.comcast.playerplatform.primetime.android.primetime:
//            PlayerMetrics, AdobeMoneyTrace, PlayerAudioTrack, PlayerClosedCaptionsTrack, 
//            PlayerProfile, PlayerTimeline

public class PrimeTimePlayer
    implements Player, PlayerSettingsListener
{

    private com.adobe.mediacore.ABRControlParameters.ABRPolicy abrPolicy;
    private BaseAdManager adManager;
    private Context context;
    private Asset currentChannel;
    private long currentPosition;
    private final com.adobe.mediacore.MediaPlayer.DRMEventListener drmEventListener = new com.adobe.mediacore.MediaPlayer.DRMEventListener() {

        final PrimeTimePlayer this$0;

        public void onDRMMetadata(DRMMetadataInfo drmmetadatainfo)
        {
            if (listenerManager != null)
            {
                listenerManager.drmMetaDataAvailable(player.getDRMManager(), drmmetadatainfo.getDRMMetadata());
            }
            switch (_cls9..SwitchMap.com.comcast.playerplatform.primetime.android.enums.DrmWorkflow[currentChannel.getDrmWorkflow().ordinal()])
            {
            default:
                playWithoutDrmWorkflow();
                return;

            case 1: // '\001'
                acquireLicenseForStreaming(drmmetadatainfo);
                return;

            case 2: // '\002'
                acquireLicenseForOffline();
                return;

            case 3: // '\003'
                acquireLicenseForWhitelist(drmmetadatainfo);
                break;
            }
        }

            
            {
                this$0 = PrimeTimePlayer.this;
                super();
            }
    };
    private AbstractDrmLicenseEventListener drmLicenseEventListener;
    private final DRMOperationErrorCallback drmOperationErrorCallback = new DRMOperationErrorCallback() {

        final PrimeTimePlayer this$0;

        public void OperationError(long l, long l1, Exception exception)
        {
            logger.e("DRM Operation Error", exception.getMessage());
        }

            
            {
                this$0 = PrimeTimePlayer.this;
                super();
            }
    };
    private FragmentInfo fragmentInfo;
    private Handler handler;
    private HttpClient httpClient;
    private long initialBuffer;
    private boolean isAudioRetry;
    private boolean isStopped;
    private LicenseService licenseService;
    private PlayerEventManager listenerManager;
    private com.adobe.mediacore.MediaPlayerItemLoader.LoaderListener loaderListener;
    private PlayerLogger logger;
    private MediaResource mediaResource;
    private boolean pendingRetry;
    private PlayerPerformanceMetrics performanceMetrics;
    private long playbackBuffer;
    private MediaPlayer player;
    private PlayerMetrics playerMetrics;
    private PlayerSettings playerSettings;
    private final com.adobe.mediacore.MediaPlayer.PlaybackEventListener playerStateEventListener = new com.adobe.mediacore.MediaPlayer.PlaybackEventListener() {

        final PrimeTimePlayer this$0;

        public void onPlayComplete()
        {
            if (listenerManager != null)
            {
                listenerManager.mediaEnded();
            }
        }

        public void onPlayStart()
        {
            retryCount = 0;
            if (listenerManager != null)
            {
                listenerManager.onPlayStarted();
            }
        }

        public void onPrepared()
        {
            playerMetrics.setPlaybackInformation(qosProvider.getPlaybackInformation());
            if (player.getCurrentItem().isLive())
            {
                Object obj = (new ConfigurationHelper()).getLinearBuffer();
                long l;
                if (!StringUtil.isNotNullOrEmpty(((String) (obj))))
                {
                    obj = "0";
                }
                l = Long.parseLong(((String) (obj)));
                player.setBufferControlParameters(BufferControlParameters.createDual(initialBuffer, l));
            } else
            {
                player.setBufferControlParameters(BufferControlParameters.createDual(initialBuffer, playbackBuffer));
            }
            player.prepareBuffer();
            obj = getAdManager();
            if (obj != null && (playerSettings.getAdType() == AdType.C3 || playerSettings.getAdType() == AdType.MANIFEST_MANIPULATOR))
            {
                ((BaseAdManager) (obj)).setResumePosition(getCurrentPosition());
            }
        }

        public void onProfileChanged(long l, long l1)
        {
        }

        public void onRatePlaying(float f)
        {
        }

        public void onRateSelected(float f)
        {
            if (listenerManager != null)
            {
                listenerManager.playbackSpeedChanged(f);
            }
        }

        public void onReplaceMediaPlayerItem()
        {
        }

        public void onSizeAvailable(long l, long l1)
        {
        }

        public void onStateChanged(com.adobe.mediacore.MediaPlayer.PlayerState playerstate, MediaPlayerNotification mediaplayernotification)
        {
            logger.i("com.comcast.playerplatform.primetime::primetimeplayer", (new StringBuilder()).append("onStateChanged Event:").append(playerstate.name()).toString());
            if (listenerManager != null)
            {
                listenerManager.playStateChanged(PlayerStatus.valueOf(playerstate.name()));
            }
            switch (_cls9..SwitchMap.com.adobe.mediacore.MediaPlayer.PlayerState[playerstate.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                if (player.getSeekableRange().contains(startPosition))
                {
                    player.prepareToPlay(startPosition);
                    return;
                } else
                {
                    player.prepareToPlay();
                    return;
                }

            case 2: // '\002'
                updateAbrControlParameters();
                return;

            case 3: // '\003'
                setClosedCaptionSettings();
                return;

            case 4: // '\004'
                handlePlayerNotification(mediaplayernotification);
                return;
            }
        }

        public void onTimedMetadata(TimedMetadata timedmetadata)
        {
            if (adManager != null)
            {
                adManager.onTimedMetadata(timedmetadata);
            }
        }

        public void onTimelineUpdated()
        {
            if (listenerManager != null)
            {
                listenerManager.onTimelineUpdated();
            }
        }

        public void onUpdated()
        {
            logger.d("onUpdated", "");
        }

            
            {
                this$0 = PrimeTimePlayer.this;
                super();
            }
    };
    private PlayerAudioTrack previousAudioTrack;
    private final com.adobe.mediacore.MediaPlayer.QOSEventListener qosEventListener = new com.adobe.mediacore.MediaPlayer.QOSEventListener() {

        final PrimeTimePlayer this$0;

        public void onBufferComplete()
        {
            if (!playerMetrics.isIslatencyComplete())
            {
                playerMetrics.setPlaybackLatencyEnd(TimeUtil.getClockMonoTonicMillis());
                playerMetrics.setIslatencyComplete(true);
            }
            if (isAudioRetry)
            {
                isAudioRetry = false;
            }
            setViewColor(0);
            if (listenerManager != null)
            {
                listenerManager.onBufferComplete();
            }
        }

        public void onBufferStart()
        {
            if (listenerManager != null)
            {
                listenerManager.onBufferStart();
            }
        }

        public void onLoadInfo(LoadInfo loadinfo)
        {
            ThreadManager.getInstance().executeRunnable(loadinfo. new Runnable() {

                final _cls4 this$1;
                final LoadInfo val$loadInfo;

                public void run()
                {
                    if (loadInfo.getSize() != 0L)
                    {
                        synchronized (fragmentInfo)
                        {
                            fragmentInfo.addFragment(loadInfo.getDownloadDuration(), loadInfo.getMediaDuration(), loadInfo.getSize());
                        }
                        if (loadInfo.getDownloadDuration() > loadInfo.getMediaDuration() && listenerManager != null)
                        {
                            listenerManager.fragmentWarning(loadInfo.getDownloadDuration(), loadInfo.getMediaDuration(), loadInfo.getSize(), loadInfo.getUrl());
                        }
                    }
                    return;
                    exception;
                    fragmentinfo;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                this$1 = final__pcls4;
                loadInfo = LoadInfo.this;
                super();
            }
            });
        }

        public void onOperationFailed(com.adobe.mediacore.MediaPlayerNotification.Warning warning)
        {
            handlePlayerNotification(warning);
        }

        public void onSeekComplete(long l)
        {
            if (listenerManager != null)
            {
                listenerManager.onSeekComplete(l);
            }
        }

        public void onSeekStart()
        {
            if (listenerManager != null)
            {
                listenerManager.onSeekStart();
            }
        }

            
            {
                this$0 = PrimeTimePlayer.this;
                super();
            }
    };
    private QOSProvider qosProvider;
    private int retryCount;
    private Runnable retryRunnable;
    private long startPosition;

    public PrimeTimePlayer(Context context1, HttpClient httpclient, PlayerSettings playersettings, LicenseService licenseservice)
    {
        currentPosition = 0L;
        retryCount = 0;
        pendingRetry = false;
        startPosition = 0L;
        initialBuffer = 0L;
        playbackBuffer = 0L;
        abrPolicy = com.adobe.mediacore.ABRControlParameters.ABRPolicy.ABR_MODERATE;
        playerMetrics = new PlayerMetrics();
        performanceMetrics = new PlayerPerformanceMetrics();
        fragmentInfo = new FragmentInfo();
        retryRunnable = new Runnable() ;
        drmLicenseEventListener = new AbstractDrmLicenseEventListener() {

            final PrimeTimePlayer this$0;

            public void acquiringLicense(String s)
            {
                if (listenerManager != null)
                {
                    listenerManager.acquiringLicense(s);
                }
            }

            public void drmComplete(String s, Date date, Date date1)
            {
                if (!pendingRetry)
                {
                    if (listenerManager != null)
                    {
                        listenerManager.drmComplete(s, date, date1);
                    }
                    playerMetrics.setDrmLatencyEnd(TimeUtil.getClockMonoTonicMillis());
                }
            }

            public void drmFailure(String s, String s1, String s2, Exception exception)
            {
                if (listenerManager != null)
                {
                    listenerManager.drmFailure(s, s1, s2, exception);
                }
                sendMediaFailed(s, (new StringBuilder()).append("drmFailure: ").append(s1).toString(), null);
            }

            public void offlineDRMComplete(String s, Date date, Date date1, String s1)
            {
                if (listenerManager != null)
                {
                    listenerManager.offlineDRMComplete(s, date, date1, s1);
                }
            }

            public void offlineDRMFailure(String s, String s1, String s2)
            {
                if (listenerManager != null)
                {
                    listenerManager.offlineDRMFailure(s, s1);
                }
                sendMediaFailed(s, s1, null);
            }

            
            {
                this$0 = PrimeTimePlayer.this;
                super();
            }
        };
        loaderListener = new com.adobe.mediacore.MediaPlayerItemLoader.LoaderListener() {

            final PrimeTimePlayer this$0;

            public void onError(MediaErrorCode mediaerrorcode, String s)
            {
                logger.e("PrimetimePlayer", s);
            }

            public void onLoadComplete(MediaPlayerItem mediaplayeritem)
            {
                logger.e("PrimetimePlayer", "Success");
            }

            
            {
                this$0 = PrimeTimePlayer.this;
                super();
            }
        };
        context = context1;
        httpClient = httpclient;
        playerSettings = playersettings;
        licenseService = licenseservice;
        initPlayer(context1);
    }

    private void acquireLicenseForOffline()
    {
        licenseService.acquireLocalLicense(currentChannel.getManifestUri(), drmLicenseEventListener);
    }

    private void acquireLicenseForStreaming(DRMMetadataInfo drmmetadatainfo)
    {
        licenseService.acquireLicenseForStreaming(currentChannel.getManifestUri(), currentChannel.getDrmKey(), StringUtil.isNotNullOrEmpty(currentChannel.getDrmKey()), drmLicenseEventListener, drmmetadatainfo.getDRMMetadata(), currentChannel.getMoneyTraceId());
    }

    private void acquireLicenseForWhitelist(DRMMetadataInfo drmmetadatainfo)
    {
        licenseService.acquireLicenseForWhitelist(currentChannel.getManifestUri(), drmLicenseEventListener, drmmetadatainfo.getDRMMetadata());
    }

    private void applyPlayerSettings()
    {
        registerAdBreakPolicy();
        updateAbrControlParameters();
        setClosedCaptionSettings();
    }

    private boolean canUpdatePlayerSettings()
    {
        while (player == null || player.getStatus() != com.adobe.mediacore.MediaPlayer.PlayerState.PREPARED && player.getStatus() != com.adobe.mediacore.MediaPlayer.PlayerState.PLAYING && player.getStatus() != com.adobe.mediacore.MediaPlayer.PlayerState.PAUSED) 
        {
            return false;
        }
        return true;
    }

    private void extractMetadata(Map map, Metadata metadata)
    {
        if (metadata != null && metadata.keySet() != null)
        {
            Iterator iterator = metadata.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                if (metadata.getValue(s) != null)
                {
                    map.put(s, metadata.getValue(s));
                }
            } while (true);
        }
    }

    private void getConfigValues()
    {
        ConfigurationHelper configurationhelper = new ConfigurationHelper();
        abrPolicy = com.adobe.mediacore.ABRControlParameters.ABRPolicy.valueOf(configurationhelper.getAbrPolicy());
        initialBuffer = configurationhelper.getInitialBuffer();
        playbackBuffer = configurationhelper.getPlaybackBuffer();
        player.setBufferControlParameters(BufferControlParameters.createDual(initialBuffer, playbackBuffer));
    }

    private long getRetryDelay()
    {
        return (long)(MathUtils.pow(retryCount, 2) * 1000);
    }

    private void handlePlayerNotification(MediaPlayerNotification mediaplayernotification)
    {
        StringBuffer stringbuffer;
        StringBuffer stringbuffer1;
        Hashtable hashtable;
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
        stringbuffer = new StringBuffer();
        stringbuffer1 = new StringBuffer();
        hashtable = new Hashtable();
        stringbuffer.append(mediaplayernotification.getCode().getCode());
        stringbuffer1.append(mediaplayernotification.getDescription());
        extractMetadata(hashtable, mediaplayernotification.getMetadata());
        if (mediaplayernotification.getCode().getCode() != com.adobe.mediacore.MediaPlayerNotification.ErrorCode.NATIVE_ERROR.getCode() || !mediaplayernotification.getMetadata().containsKey("NATIVE_ERROR_CODE")) goto _L2; else goto _L1
_L1:
        stringbuffer.append(".").append(mediaplayernotification.getMetadata().getValue("NATIVE_ERROR_CODE"));
_L7:
        static class _cls9
        {

            static final int $SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState[];
            static final int $SwitchMap$com$adobe$mediacore$MediaPlayerNotification$EntryType[];
            static final int $SwitchMap$com$comcast$playerplatform$primetime$android$enums$DrmWorkflow[];
            static final int $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[];

            static 
            {
                $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting = new int[com.comcast.playerplatform.primetime.android.player.PlayerSettings.Setting.values().length];
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[com.comcast.playerplatform.primetime.android.player.PlayerSettings.Setting.BITRATE_PARAMS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[com.comcast.playerplatform.primetime.android.player.PlayerSettings.Setting.INITIAL_BITRATE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[com.comcast.playerplatform.primetime.android.player.PlayerSettings.Setting.BITRATE_RANGE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[com.comcast.playerplatform.primetime.android.player.PlayerSettings.Setting.CAPTION_FORMAT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[com.comcast.playerplatform.primetime.android.player.PlayerSettings.Setting.CAPTIONS_ENABLED.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[com.comcast.playerplatform.primetime.android.player.PlayerSettings.Setting.CAPTIONS_TRACK.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[com.comcast.playerplatform.primetime.android.player.PlayerSettings.Setting.AUDIO_TRACK.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                $SwitchMap$com$comcast$playerplatform$primetime$android$enums$DrmWorkflow = new int[DrmWorkflow.values().length];
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$enums$DrmWorkflow[DrmWorkflow.STREAMING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$enums$DrmWorkflow[DrmWorkflow.LOCAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$enums$DrmWorkflow[DrmWorkflow.WHITE_LIST.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                $SwitchMap$com$adobe$mediacore$MediaPlayerNotification$EntryType = new int[com.adobe.mediacore.MediaPlayerNotification.EntryType.values().length];
                try
                {
                    $SwitchMap$com$adobe$mediacore$MediaPlayerNotification$EntryType[com.adobe.mediacore.MediaPlayerNotification.EntryType.ERROR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$adobe$mediacore$MediaPlayerNotification$EntryType[com.adobe.mediacore.MediaPlayerNotification.EntryType.WARN.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState = new int[com.adobe.mediacore.MediaPlayer.PlayerState.values().length];
                try
                {
                    $SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState[com.adobe.mediacore.MediaPlayer.PlayerState.INITIALIZED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState[com.adobe.mediacore.MediaPlayer.PlayerState.PREPARED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState[com.adobe.mediacore.MediaPlayer.PlayerState.PLAYING.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState[com.adobe.mediacore.MediaPlayer.PlayerState.ERROR.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls9..SwitchMap.com.adobe.mediacore.MediaPlayerNotification.EntryType[mediaplayernotification.getType().ordinal()];
        JVM INSTR tableswitch 1 2: default 156
    //                   1 250
    //                   2 277;
           goto _L3 _L4 _L5
_L3:
        return;
_L2:
        MediaPlayerNotification mediaplayernotification1 = mediaplayernotification.getInnerNotification();
_L8:
        flag1 = flag;
        if (mediaplayernotification1 == null) goto _L7; else goto _L6
_L6:
        flag1 = flag;
        if (!flag)
        {
            flag1 = isAudioFailure(mediaplayernotification1);
        }
        stringbuffer.append(".").append(mediaplayernotification1.getCode().getCode());
        stringbuffer1.append(" Caused by '").append(mediaplayernotification1.getDescription()).append("'");
        extractMetadata(hashtable, mediaplayernotification1.getMetadata());
        mediaplayernotification1 = mediaplayernotification1.getInnerNotification();
        flag = flag1;
          goto _L8
_L4:
        if (!isStopped)
        {
            stop();
            retryPreviousAsset(stringbuffer.toString(), stringbuffer1.toString(), hashtable);
            return;
        }
          goto _L3
_L5:
        if (mediaplayernotification.getCode().getCode() == 0x330ccL && mediaplayernotification.getMetadata().getValue("NATIVE_ERROR_CODE").equals(String.valueOf(MediaErrorCode.LIVE_WINDOW_MOVED_BACKWARD.getValue())))
        {
            stop();
            retryPreviousAsset(stringbuffer.toString(), stringbuffer1.toString(), hashtable);
            return;
        }
        if (flag1 && !isAudioRetry)
        {
            retryPreviousAudio(stringbuffer.toString(), stringbuffer1.toString(), hashtable);
            return;
        } else
        {
            sendMediaWarning(stringbuffer, stringbuffer1);
            return;
        }
    }

    private void hookEvents()
    {
        player.addEventListener(com.adobe.mediacore.MediaPlayer.Event.PLAYBACK, playerStateEventListener);
        player.addEventListener(com.adobe.mediacore.MediaPlayer.Event.DRM, drmEventListener);
        player.addEventListener(com.adobe.mediacore.MediaPlayer.Event.QOS, qosEventListener);
        player.addEventListener(com.adobe.mediacore.MediaPlayer.Event.QOS, performanceMetrics);
        playerSettings.addListener(this);
    }

    private void initPlayer(Context context1)
    {
        handler = new Handler(Looper.getMainLooper());
        player = DefaultMediaPlayer.create(context1);
        Log.getLogger(com/adobe/mediacore/MediaPlayer.getName()).setVerbosityLevel(com.adobe.mediacore.logging.Logger.Verbosity.NONE);
        qosProvider = new QOSProvider(context1);
        qosProvider.attachMediaPlayer(player);
        getView().setBackgroundColor(0xff000000);
        getConfigValues();
        hookEvents();
    }

    private boolean isAudioFailure(MediaPlayerNotification mediaplayernotification)
    {
        return mediaplayernotification.getCode() == com.adobe.mediacore.MediaPlayerNotification.ErrorCode.AUDIO_TRACK_ERROR;
    }

    private void playWithoutDrmWorkflow()
    {
        if (listenerManager != null)
        {
            listenerManager.drmComplete(currentChannel.getManifestUri(), null, null);
        }
    }

    private void registerAdBreakPolicy()
    {
        if (player == null || adManager == null)
        {
            return;
        }
        MediaPlayer mediaplayer = player;
        BaseAdManager baseadmanager = adManager;
        boolean flag;
        if (startPosition > 1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mediaplayer.registerAdClientFactory(new CustomAdvertisingFactory(baseadmanager, flag));
    }

    private void retryPreviousAsset(String s, String s1, Map map)
    {
        this;
        JVM INSTR monitorenter ;
        if (retryCount >= 3) goto _L2; else goto _L1
_L1:
        if (listenerManager != null)
        {
            listenerManager.retryAttempted(s, s1, retryCount);
        }
        long l = getRetryDelay();
        if (!pendingRetry)
        {
            pendingRetry = true;
            handler.postDelayed(retryRunnable, l);
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        retryCount = 0;
        sendMediaFailed(s, s1, map);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    private void retryPreviousAudio(String s, String s1, Map map)
    {
        if (previousAudioTrack != null)
        {
            isAudioRetry = true;
            setPreferredAudioLanguage(previousAudioTrack);
            return;
        } else
        {
            sendMediaFailed(s, s1, map);
            return;
        }
    }

    private void sendMediaFailed(String s, String s1, Map map)
    {
        this;
        JVM INSTR monitorenter ;
        logger.e("com.comcast.playerplatform.primetime::primetimeplayer", (new StringBuilder()).append("Code:").append(s).append(" Description:").append(s1).toString());
        if (listenerManager != null)
        {
            listenerManager.mediaFailed(s, s1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    private void sendMediaWarning(StringBuffer stringbuffer, StringBuffer stringbuffer1)
    {
        logger.w("com.comcast.playerplatform.primetime::primetimeplayer", (new StringBuilder()).append("Code:").append(String.valueOf(stringbuffer)).append(" Description:").append(String.valueOf(stringbuffer1)).toString());
        if (listenerManager != null)
        {
            listenerManager.mediaWarning(stringbuffer.toString(), stringbuffer1.toString());
        }
    }

    private void setClosedCaptionSettings()
    {
        setClosedCaptionsEnabled(playerSettings.getClosedCaptionsEnabled());
        ClosedCaptionFormatBuilder closedcaptionformatbuilder = playerSettings.getCaptionFormat();
        if (closedcaptionformatbuilder != null && canUpdatePlayerSettings())
        {
            player.setCCStyle(closedcaptionformatbuilder.toTextFormat());
        }
    }

    private void setClosedCaptionsTrackByName(String s)
    {
        Iterator iterator = player.getCurrentItem().getClosedCaptionsTracks().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ClosedCaptionsTrack closedcaptionstrack = (ClosedCaptionsTrack)iterator.next();
            if (!closedcaptionstrack.getName().equals(s))
            {
                continue;
            }
            player.getCurrentItem().selectClosedCaptionsTrack(closedcaptionstrack);
            break;
        } while (true);
    }

    private void setPlayerContent(BaseAdManager baseadmanager)
    {
        if (player.getStatus() == com.adobe.mediacore.MediaPlayer.PlayerState.PLAYING || player.getStatus() == com.adobe.mediacore.MediaPlayer.PlayerState.ERROR)
        {
            stop();
        }
        if (retryCount != 0);
        MetadataNode metadatanode = null;
        if (baseadmanager != null)
        {
            adManager = baseadmanager;
            player.addEventListener(com.adobe.mediacore.MediaPlayer.Event.AD_PLAYBACK, baseadmanager.getTimeline(null));
            metadatanode = baseadmanager.getMetadataForAdobe();
        }
        applyPlayerSettings();
        AdobeMoneyTrace adobemoneytrace = new AdobeMoneyTrace(currentChannel.getMoneyTrace());
        baseadmanager = metadatanode;
        if (metadatanode == null)
        {
            baseadmanager = new MetadataNode();
        }
        baseadmanager.setNode(DefaultMetadataKeys.NETWORK_CONFIGURATION.getValue(), adobemoneytrace);
        mediaResource = MediaResource.createFromUrl(currentChannel.getManifestUri(), baseadmanager);
        player.replaceCurrentItem(mediaResource);
        isStopped = false;
    }

    private void setPreferredAudioLanguageByLanguage(String s)
    {
        if (player != null && player.getCurrentItem() != null)
        {
            Iterator iterator = player.getCurrentItem().getAudioTracks().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                AudioTrack audiotrack = (AudioTrack)iterator.next();
                if (audiotrack.getLanguage().contentEquals(s))
                {
                    previousAudioTrack = getCurrentAudioTrack();
                    player.getCurrentItem().selectAudioTrack(audiotrack);
                }
            } while (true);
        }
    }

    private void setViewColor(int i)
    {
        if (i == 0xff000000 || i == 0)
        {
            getView().setBackgroundColor(i);
        }
    }

    private void updateAbrControlParameters()
    {
        if (player != null && canUpdatePlayerSettings())
        {
            int i = playerSettings.getInitialBitrate();
            Object obj = playerSettings.getBitRange();
            MediaPlayer mediaplayer = player;
            int j;
            int k;
            if (i <= 0)
            {
                i = 0;
            }
            if (obj != null)
            {
                j = ((Range) (obj)).getMin();
            } else
            {
                j = 0x80000000;
            }
            if (obj != null)
            {
                k = ((Range) (obj)).getMax();
            } else
            {
                k = 0x7fffffff;
            }
            if (abrPolicy != null)
            {
                obj = abrPolicy;
            } else
            {
                obj = com.adobe.mediacore.ABRControlParameters.ABRPolicy.ABR_MODERATE;
            }
            mediaplayer.setABRControlParameters(new ABRControlParameters(i, j, k, ((com.adobe.mediacore.ABRControlParameters.ABRPolicy) (obj))));
        }
    }

    public void addEventListener(AbstractPlayerPlatformVideoEventListener abstractplayerplatformvideoeventlistener)
    {
        listenerManager = (PlayerEventManager)abstractplayerplatformvideoeventlistener;
        if (adManager != null)
        {
            adManager.addPlayerEventManager(listenerManager);
        }
    }

    public void destroy()
    {
        handler.removeCallbacks(retryRunnable);
        handler = null;
        listenerManager = null;
        player.removeEventListener(com.adobe.mediacore.MediaPlayer.Event.PLAYBACK, playerStateEventListener);
        player.removeEventListener(com.adobe.mediacore.MediaPlayer.Event.DRM, drmEventListener);
        player.removeEventListener(com.adobe.mediacore.MediaPlayer.Event.QOS, qosEventListener);
        player.removeEventListener(com.adobe.mediacore.MediaPlayer.Event.QOS, performanceMetrics);
        playerSettings.removeListener(this);
        if (adManager != null)
        {
            player.removeEventListener(com.adobe.mediacore.MediaPlayer.Event.AD_PLAYBACK, adManager.getTimeline(null));
            adManager.removePlayerEventManager();
            adManager.clearPlayer();
            adManager = null;
        }
        player.release();
        player = null;
        licenseService = null;
        mediaResource = null;
        currentChannel = null;
        listenerManager = null;
    }

    public BaseAdManager getAdManager()
    {
        return adManager;
    }

    public List getAvailableAudioLanguages()
    {
        ArrayList arraylist = new ArrayList();
        if (player.getCurrentItem() != null)
        {
            AudioTrack audiotrack = player.getCurrentItem().getSelectedAudioTrack();
            AudioTrack audiotrack1;
            for (Iterator iterator = player.getCurrentItem().getAudioTracks().iterator(); iterator.hasNext(); arraylist.add(new PlayerAudioTrack(audiotrack1, audiotrack1.equals(audiotrack))))
            {
                audiotrack1 = (AudioTrack)iterator.next();
            }

        }
        return arraylist;
    }

    public List getAvailableBitrates()
    {
        ArrayList arraylist = new ArrayList();
        if (player != null && player.getCurrentItem() != null)
        {
            for (Iterator iterator = player.getCurrentItem().getProfiles().iterator(); iterator.hasNext(); arraylist.add(Integer.valueOf(((Profile)iterator.next()).getBitrate()))) { }
        }
        return arraylist;
    }

    public List getAvailableClosedCaptionTracks()
    {
        ArrayList arraylist = new ArrayList();
        if (player.getCurrentItem() != null)
        {
            ClosedCaptionsTrack closedcaptionstrack = player.getCurrentItem().getSelectedClosedCaptionsTrack();
            ClosedCaptionsTrack closedcaptionstrack1;
            for (Iterator iterator = player.getCurrentItem().getClosedCaptionsTracks().iterator(); iterator.hasNext(); arraylist.add(new PlayerClosedCaptionsTrack(closedcaptionstrack1, closedcaptionstrack1.equals(closedcaptionstrack))))
            {
                closedcaptionstrack1 = (ClosedCaptionsTrack)iterator.next();
            }

        }
        return arraylist;
    }

    public List getAvailableProfiles()
    {
        ArrayList arraylist = new ArrayList();
        if (player != null && player.getCurrentItem() != null)
        {
            Profile profile;
            for (Iterator iterator = player.getCurrentItem().getProfiles().iterator(); iterator.hasNext(); arraylist.add(new PlayerProfile(profile.getBitrate(), profile.getWidth(), profile.getHeight())))
            {
                profile = (Profile)iterator.next();
            }

        }
        return arraylist;
    }

    public boolean getClosedCaptionsStatus()
    {
        return player.getCCVisibility() == com.adobe.mediacore.MediaPlayer.Visibility.VISIBLE;
    }

    public PlayerAudioTrack getCurrentAudioTrack()
    {
        if (player.getCurrentItem() != null && player.getCurrentItem().getSelectedAudioTrack() != null)
        {
            return new PlayerAudioTrack(player.getCurrentItem().getSelectedAudioTrack(), true);
        } else
        {
            return null;
        }
    }

    public int getCurrentBitrate()
    {
        playerMetrics.setPlaybackInformation(qosProvider.getPlaybackInformation());
        return (int)player.getPlaybackMetrics().getBitrate();
    }

    public Asset getCurrentChannel()
    {
        return currentChannel;
    }

    public PlayerClosedCaptionsTrack getCurrentClosedCaptionTrack()
    {
        if (player.getCurrentItem() != null && player.getCurrentItem().getSelectedClosedCaptionsTrack() != null)
        {
            return new PlayerClosedCaptionsTrack(player.getCurrentItem().getSelectedClosedCaptionsTrack(), true);
        } else
        {
            return null;
        }
    }

    public float getCurrentPlaybackSpeed()
    {
        return player.getRate();
    }

    public long getCurrentPosition()
    {
        long l = 0L;
        if (adManager != null)
        {
            l = adManager.getAdOffset();
        }
        return player.getCurrentTime() - l;
    }

    public long getDuration()
    {
        return player.getPlaybackRange().getDuration();
    }

    public long getEndPosition()
    {
        return player.getPlaybackRange().getDuration();
    }

    public FragmentInfo getFragmentInfo()
    {
        return fragmentInfo;
    }

    public PlayerLogger getLogger()
    {
        return logger;
    }

    public PlayerStatus getPlayerStatus()
    {
        return PlayerStatus.valueOf(player.getStatus().name());
    }

    public List getSupportedClosedCaptionsOptions()
    {
        return new ArrayList(Arrays.asList(new String[] {
            "fontSize", "fontStyle", "textForegroundColor", "textForegroundOpacity", "windowFillColor", "windowFillOpacity", "windowBorderEdgeColor", "windowBorderEdgeStyle"
        }));
    }

    public List getSupportedPlaybackSpeeds()
    {
        ArrayList arraylist = new ArrayList();
        List list;
        try
        {
            list = player.getCurrentItem().getAvailablePlaybackRates();
        }
        catch (Exception exception)
        {
            arraylist.add(Float.valueOf(1.0F));
            return arraylist;
        }
        return list;
    }

    public PlayerTimeline getTimeline()
    {
        if (adManager != null)
        {
            return adManager.getPlayerTimeline(player.getTimeline());
        } else
        {
            return new PlayerTimeline(new ArrayList());
        }
    }

    public String getVersion()
    {
        new Version();
        return (new StringBuilder()).append("PSDK Version : ").append(Version.getVersion()).append("AVE Version : ").append(Version.getAVEVersion()).toString();
    }

    public long getVideoHeight()
    {
        return (long)getView().getMeasuredHeight();
    }

    public StreamType getVideoType()
    {
        if (player != null && player.getCurrentItem() != null)
        {
            if (player.getCurrentItem().isLive())
            {
                return StreamType.LINEAR;
            } else
            {
                return StreamType.VOD;
            }
        } else
        {
            return StreamType.VOD;
        }
    }

    public long getVideoWidth()
    {
        return (long)getView().getMeasuredWidth();
    }

    public View getView()
    {
        return player.getView();
    }

    public boolean hasCC()
    {
        return player.getCurrentItem().hasClosedCaptions();
    }

    public boolean hasDRM()
    {
        return player != null && player.getCurrentItem().isProtected();
    }

    public void pause()
    {
        if (player != null)
        {
            player.pause();
        }
    }

    public void play()
    {
        if (player != null)
        {
            player.play();
        }
    }

    public void removeEventListener(AbstractPlayerPlatformVideoEventListener abstractplayerplatformvideoeventlistener)
    {
        listenerManager = null;
    }

    public void seekToLive()
    {
        player.seek(-2L);
    }

    public void setAsset(Asset asset, long l, BaseAdManager baseadmanager)
    {
        playerMetrics.clearLatencyValues();
        playerMetrics.setLatencyStart(TimeUtil.getClockMonoTonicMillis());
        performanceMetrics.setAsset(asset);
        currentChannel = asset;
        startPosition = l;
        if (l <= 0L)
        {
            l = 0L;
        }
        currentPosition = l;
        setPlayerContent(baseadmanager);
    }

    public void setClosedCaptionsEnabled(boolean flag)
    {
label0:
        {
            if (player != null)
            {
                if (!flag)
                {
                    break label0;
                }
                player.setCCVisibility(com.adobe.mediacore.MediaPlayer.Visibility.VISIBLE);
            }
            return;
        }
        player.setCCVisibility(com.adobe.mediacore.MediaPlayer.Visibility.INVISIBLE);
    }

    public void setClosedCaptionsTrack(PlayerClosedCaptionsTrack playerclosedcaptionstrack)
    {
        if (player.getCurrentItem() != null)
        {
            player.getCurrentItem().selectClosedCaptionsTrack(playerclosedcaptionstrack.getTrack());
            return;
        }
        try
        {
            logger.i("com.comcast.playerplatform.primetime::primetimeplayer", "ClosedCaptions not set. Player's currentItem not set.");
            return;
        }
        catch (Exception exception)
        {
            setClosedCaptionsTrackByName(playerclosedcaptionstrack.getName());
        }
        return;
    }

    public void setLogger(LogFactory logfactory)
    {
        logger = logfactory.getLogger("");
        Log.setLogFactory(logfactory);
    }

    public void setLoggingVerbosity(com.adobe.mediacore.logging.Logger.Verbosity verbosity)
    {
        LogFactory.getInstance().getLogger().setVerbosityLevel(com.adobe.mediacore.logging.Logger.Verbosity.valueOf(verbosity.name()));
    }

    public void setPosition(long l, boolean flag)
    {
        if (l > getDuration())
        {
            l = getDuration();
        }
        currentPosition = l;
        player.seek(l);
    }

    public void setPositionRelative(long l)
    {
        player.seek(getCurrentPosition() + l);
    }

    public void setPreferredAudioLanguage(final PlayerAudioTrack track)
    {
        handler.post(new Runnable() {

            final PrimeTimePlayer this$0;
            final PlayerAudioTrack val$track;

            public void run()
            {
                if (player != null && player.getCurrentItem() != null)
                {
                    previousAudioTrack = getCurrentAudioTrack();
                    player.getCurrentItem().selectAudioTrack(track.getTrack());
                    return;
                }
                try
                {
                    logger.i("com.comcast.playerplatform.primetime::primetimeplayer", "Audio Track not set. Player's currentItem is null.");
                    return;
                }
                catch (Exception exception)
                {
                    setPreferredAudioLanguageByLanguage(track.getLanguage());
                }
                return;
            }

            
            {
                this$0 = PrimeTimePlayer.this;
                track = playeraudiotrack;
                super();
            }
        });
    }

    public void setVolume(int i)
    {
        player.setVolume(i);
    }

    public void settingUpdated(com.comcast.playerplatform.primetime.android.player.PlayerSettings.Setting setting)
    {
        switch (_cls9..SwitchMap.com.comcast.playerplatform.primetime.android.player.PlayerSettings.Setting[setting.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            updateAbrControlParameters();
            return;

        case 4: // '\004'
        case 5: // '\005'
            if (playerSettings.getCaptionFormat() != null)
            {
                setClosedCaptionSettings();
                return;
            } else
            {
                setClosedCaptionsEnabled(playerSettings.getClosedCaptionsEnabled());
                return;
            }

        case 6: // '\006'
            setClosedCaptionsTrack(playerSettings.getClosedCaptionsTrack());
            return;

        case 7: // '\007'
            setPreferredAudioLanguage(playerSettings.getPreferredAudioLanguage());
            return;
        }
    }

    public void stop()
    {
        isStopped = true;
        if (adManager != null)
        {
            player.removeEventListener(com.adobe.mediacore.MediaPlayer.Event.AD_PLAYBACK, adManager.getTimeline(null));
            adManager.removePlayerEventManager();
            adManager.clearPlayer();
            adManager = null;
        }
        player.reset();
    }




/*
    static PlayerAudioTrack access$102(PrimeTimePlayer primetimeplayer, PlayerAudioTrack playeraudiotrack)
    {
        primetimeplayer.previousAudioTrack = playeraudiotrack;
        return playeraudiotrack;
    }

*/


/*
    static int access$1102(PrimeTimePlayer primetimeplayer, int i)
    {
        primetimeplayer.retryCount = i;
        return i;
    }

*/


/*
    static int access$1104(PrimeTimePlayer primetimeplayer)
    {
        int i = primetimeplayer.retryCount + 1;
        primetimeplayer.retryCount = i;
        return i;
    }

*/







/*
    static boolean access$1602(PrimeTimePlayer primetimeplayer, boolean flag)
    {
        primetimeplayer.pendingRetry = flag;
        return flag;
    }

*/




/*
    static boolean access$1802(PrimeTimePlayer primetimeplayer, boolean flag)
    {
        primetimeplayer.isAudioRetry = flag;
        return flag;
    }

*/
















}
