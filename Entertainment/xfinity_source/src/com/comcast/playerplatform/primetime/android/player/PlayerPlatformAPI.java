// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.player;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.adobe.ave.VideoEngineView;
import com.adobe.ave.drm.DRMManager;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.cim.httpcomponentsandroid.impl.client.DefaultHttpClient;
import com.comcast.playerplatform.analytics.java.AnalyticsProvider;
import com.comcast.playerplatform.analytics.java.util.HostInfo;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.drm.java.client.ClientState;
import com.comcast.playerplatform.drm.java.client.SecurityToken;
import com.comcast.playerplatform.drm.java.client.SecurityTokenType;
import com.comcast.playerplatform.drm.java.event.AbstractDrmLicenseEventListener;
import com.comcast.playerplatform.drm.java.service.LicenseService;
import com.comcast.playerplatform.drm.java.util.AuthenticationDelegate;
import com.comcast.playerplatform.primetime.android.ads.PlayerAdBreakPolicies;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import com.comcast.playerplatform.primetime.android.ads.managers.BaseAdManager;
import com.comcast.playerplatform.primetime.android.ads.managers.ManafestManipulatorManager;
import com.comcast.playerplatform.primetime.android.ads.managers.PlayerPlatformAds;
import com.comcast.playerplatform.primetime.android.analytics.AnalyticsHandler;
import com.comcast.playerplatform.primetime.android.analytics.NullAnalyticsHandler;
import com.comcast.playerplatform.primetime.android.analytics.PlayerAnalytics;
import com.comcast.playerplatform.primetime.android.asset.AdData;
import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.eas.EmergencyAlertProvider;
import com.comcast.playerplatform.primetime.android.enums.AdType;
import com.comcast.playerplatform.primetime.android.enums.InitialPlayerState;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.enums.StreamType;
import com.comcast.playerplatform.primetime.android.enums.ZoomSetting;
import com.comcast.playerplatform.primetime.android.events.AbstractPlayerPlatformVideoEventListener;
import com.comcast.playerplatform.primetime.android.events.PlayerEventManager;
import com.comcast.playerplatform.primetime.android.primetime.PlayerAudioTrack;
import com.comcast.playerplatform.primetime.android.primetime.PlayerClosedCaptionsTrack;
import com.comcast.playerplatform.primetime.android.primetime.PlayerMetrics;
import com.comcast.playerplatform.primetime.android.primetime.PlayerProfile;
import com.comcast.playerplatform.primetime.android.primetime.PlayerTimeline;
import com.comcast.playerplatform.primetime.android.util.ClosedCaptionFormatBuilder;
import com.comcast.playerplatform.primetime.android.util.ConfigurationHelper;
import com.comcast.playerplatform.primetime.android.util.LogFactory;
import com.comcast.playerplatform.primetime.android.util.PlayerLogger;
import com.comcast.playerplatform.primetime.android.util.PlayerManager;
import com.comcast.playerplatform.primetime.android.util.PlayerPlatformVersion;
import com.comcast.playerplatform.primetime.android.util.ThreadManager;
import com.comcast.playerplatform.util.android.BitrateParameters;
import com.comcast.playerplatform.util.android.Clock;
import com.comcast.playerplatform.util.android.ConfigurationManager;
import com.comcast.playerplatform.util.android.Range;
import com.comcast.playerplatform.util.android.StringUtil;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.comcast.playerplatform.primetime.android.player:
//            IPlayerPlatform, Player, PlayerSettings

public class PlayerPlatformAPI
    implements IPlayerPlatform
{

    private final String LOG_TAG;
    private Activity activity;
    private PlayerAnalytics analytics;
    private Context applicationContext;
    private boolean assetLoadingComplete;
    private long currentBitrate;
    private Asset currentChannel;
    private long currentDFPS;
    private long currentDuration;
    private long currentFPS;
    private PlayerStatus currentState;
    private boolean drmComplete;
    private Clock heartbeatClock;
    private final com.comcast.playerplatform.util.android.Clock.ClockEventListener heartbeatClockEventListener;
    private int heartbeatInterval;
    private HttpClient httpClient;
    private InitialPlayerState initialPlayerState;
    private boolean isMediaOpened;
    private LicenseService licenseService;
    private PlayerEventManager listenerManager;
    private PlayerLogger logger;
    private boolean mediaOpenedSent;
    private AbstractDrmLicenseEventListener offlineDrmLicenseEventListener = new AbstractDrmLicenseEventListener() {

        final PlayerPlatformAPI this$0;

        public void acquiringLicense(String s)
        {
            if (listenerManager != null)
            {
                listenerManager.acquiringLicense(s);
            }
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
            if (listenerManager != null)
            {
                listenerManager.mediaFailed(s, s1);
            }
        }

            
            {
                this$0 = PlayerPlatformAPI.this;
                super();
            }
    };
    private FrameLayout parentView;
    private Clock playbackClock;
    private final com.comcast.playerplatform.util.android.Clock.ClockEventListener playbackClockEventListener;
    private boolean playbackHasOccured;
    private Player player;
    private AbstractPlayerPlatformVideoEventListener playerListener = new AbstractPlayerPlatformVideoEventListener() {

        final PlayerPlatformAPI this$0;

        public void adProgress(VideoAdBreak videoadbreak, VideoAd videoad, int i, long l)
        {
            analytics.adProgress(i, getCurrentAsset());
        }

        public void bitrateChanged(long l, String s, long l1, long l2)
        {
            analytics.bitrateChanged(l, getCurrentAsset());
        }

        public void drmComplete(String s, Date date, Date date1)
        {
            PlayerPlatformAPI.this.drmComplete = true;
            if (videoReady() && !isMediaOpened)
            {
                sendMediaOpened();
            }
        }

        public void fragmentWarning(long l, long l1, long l2, String s)
        {
            analytics.fragmentWarning((int)l, (int)l1, (int)l2, s, getCurrentAsset());
        }

        public void mediaEnded()
        {
            analytics.mediaEnded(getCurrentAsset());
        }

        public void mediaFailed(String s, String s1)
        {
            analytics.mediaFailed(currentChannel.getManifestUri(), (int)getCurrentPosition(), s, s1, getCurrentAsset());
        }

        public void onBufferComplete()
        {
            Asset asset = player.getCurrentChannel();
            analytics.playStateChanged(currentState, asset.buildXuaAsset());
            if (isMediaOpened && !mediaOpenedSent)
            {
                analytics.mediaOpened(asset.getManifestUri(), player.getCurrentPosition(), Long.valueOf(PlayerMetrics.getOpeningLatency()), asset.buildXuaAsset());
                mediaOpenedSent = true;
                boolean flag = playerSettings.getClosedCaptionsEnabled();
                if (flag)
                {
                    player.setClosedCaptionsEnabled(false);
                }
                player.setClosedCaptionsEnabled(flag);
            }
        }

        public void onBufferStart()
        {
            analytics.playStateChanged("Buffering", getCurrentAsset());
            super.onBufferStart();
        }

        public void onSeekComplete(long l)
        {
            analytics.scrubEnded((int)player.getCurrentPosition(), player.getCurrentChannel().buildXuaAsset());
        }

        public void onSeekStart()
        {
            analytics.scrubStarted((int)player.getCurrentPosition(), player.getCurrentChannel().buildXuaAsset());
        }

        public void playStateChanged(PlayerStatus playerstatus)
        {
            currentState = playerstatus;
            if (listenerManager == null);
            _cls6..SwitchMap.com.comcast.playerplatform.primetime.android.enums.PlayerStatus[playerstatus.ordinal()];
            JVM INSTR tableswitch 1 6: default 64
        //                       1 64
        //                       2 85
        //                       3 124
        //                       4 124
        //                       5 144
        //                       6 154;
               goto _L1 _L1 _L2 _L3 _L3 _L4 _L5
_L1:
            analytics.playStateChanged(playerstatus, getCurrentAsset());
            return;
_L2:
            assetLoadingComplete = true;
            if (drmReady() && !isMediaOpened)
            {
                sendMediaOpened();
            }
            continue; /* Loop/switch isn't completed */
_L3:
            if (playbackClock == null)
            {
                createAndStartTimers();
            }
            continue; /* Loop/switch isn't completed */
_L4:
            stopAndDestroyTimers();
            continue; /* Loop/switch isn't completed */
_L5:
            resetLocalFields();
            if (true) goto _L1; else goto _L6
_L6:
        }

        public void retryAttempted(String s, String s1, int i)
        {
            analytics.retryAttempt(s, null, s1, i, getCurrentAsset());
        }

            
            {
                this$0 = PlayerPlatformAPI.this;
                super();
            }
    };
    private PlayerManager playerManager;
    private PlayerMetrics playerMetrics;
    private PlayerSettings playerSettings;
    private int totalAudioTracks;
    private int updateInterval;
    private boolean useSecureView;

    public PlayerPlatformAPI(Activity activity1, HttpClient httpclient)
    {
        this(activity1.getApplicationContext(), activity1, httpclient, null, null);
    }

    private PlayerPlatformAPI(Context context, Activity activity1, HttpClient httpclient, ClientState clientstate, AuthenticationDelegate authenticationdelegate)
    {
        logger = LogFactory.getInstance().getLogger();
        LOG_TAG = "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI";
        updateInterval = 1000;
        playbackHasOccured = false;
        assetLoadingComplete = false;
        drmComplete = false;
        playerMetrics = new PlayerMetrics();
        currentState = PlayerStatus.IDLE;
        currentBitrate = 0L;
        currentFPS = 0L;
        currentDFPS = 0L;
        currentDuration = 0L;
        totalAudioTracks = 0;
        useSecureView = true;
        heartbeatClockEventListener = new com.comcast.playerplatform.util.android.Clock.ClockEventListener() {

            final PlayerPlatformAPI this$0;

            public void onTick(String s)
            {
                sendHeartbeatMessage();
            }

            
            {
                this$0 = PlayerPlatformAPI.this;
                super();
            }
        };
        playbackClockEventListener = new com.comcast.playerplatform.util.android.Clock.ClockEventListener() {

            final PlayerPlatformAPI this$0;

            public void onTick(String s)
            {
                if (player != null && player.getPlayerStatus() == PlayerStatus.PLAYING)
                {
                    requestMediaProgress();
                    updatePlaybackMetrics();
                }
            }

            
            {
                this$0 = PlayerPlatformAPI.this;
                super();
            }
        };
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", "Player API is being initialized");
        initialPlayerState = InitialPlayerState.USE_AUTO_PLAY;
        applicationContext = context;
        activity = activity1;
        initialize(httpclient, clientstate, authenticationdelegate);
    }

    public PlayerPlatformAPI(Context context, HttpClient httpclient)
    {
        this(context, null, httpclient, null, null);
    }

    private void addPlayerView()
    {
        if (playerManager.didPlayerChange())
        {
            if (parentView.getChildCount() > 0)
            {
                parentView.removeAllViews();
            }
            parentView.addView(player.getView());
        }
        if ((android.os.Build.VERSION.SDK_INT > 17 || android.os.Build.VERSION.SDK_INT == 17 && android.os.Build.VERSION.RELEASE.equals("4.2.2")) && !useSecureView)
        {
            updateViewSecurity();
        }
    }

    private void checkForAutoPlay()
    {
label0:
        {
            if (!currentChannel.getType().equals(com.comcast.playerplatform.primetime.android.asset.Asset.AssetType.DISNEY))
            {
                if (!getAutoPlay())
                {
                    break label0;
                }
                play();
            }
            return;
        }
        pause();
    }

    private void createAndStartTimers()
    {
        this;
        JVM INSTR monitorenter ;
        stopAndDestroyTimers();
        if (heartbeatInterval > 0)
        {
            heartbeatClock = new Clock("HeartbeatClock", heartbeatInterval);
            heartbeatClock.addClockEventListener(heartbeatClockEventListener);
            heartbeatClock.start();
        }
        if (updateInterval > 0)
        {
            playbackClock = new Clock("PlaybackClock", updateInterval);
            playbackClock.addClockEventListener(playbackClockEventListener);
            playbackClock.start();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean drmReady()
    {
        return drmComplete || !hasDRM();
    }

    private AbstractXuaAsset getCurrentAsset()
    {
        if (currentChannel != null)
        {
            return currentChannel.buildXuaAsset();
        } else
        {
            return null;
        }
    }

    private PlayerProfile getLargestBitrate()
    {
        PlayerProfile playerprofile1 = null;
        PlayerProfile playerprofile = null;
        if (player != null)
        {
            Iterator iterator = player.getAvailableProfiles().iterator();
            do
            {
                playerprofile1 = playerprofile;
                if (!iterator.hasNext())
                {
                    break;
                }
                playerprofile1 = (PlayerProfile)iterator.next();
                if (playerprofile == null || playerprofile.getBitrate() < playerprofile1.getBitrate())
                {
                    playerprofile = playerprofile1;
                }
            } while (true);
        }
        return playerprofile1;
    }

    private void initialize(HttpClient httpclient, ClientState clientstate, AuthenticationDelegate authenticationdelegate)
    {
        if (httpclient != null)
        {
            httpClient = httpclient;
        } else
        {
            httpClient = new DefaultHttpClient();
        }
        if (authenticationdelegate != null)
        {
            licenseService = new LicenseService(authenticationdelegate, applicationContext, httpClient);
            httpclient = clientstate;
        } else
        {
            httpclient = clientstate;
            if (clientstate == null)
            {
                httpclient = new ClientState();
            }
            licenseService = new LicenseService(httpclient, applicationContext, httpClient);
        }
        analytics = new NullAnalyticsHandler();
        listenerManager = new PlayerEventManager();
        listenerManager.addListener(playerListener);
        playerSettings = new PlayerSettings();
        playerSettings.setAuthDelegate(authenticationdelegate);
        playerSettings.setclientState(httpclient);
        httpclient = new ConfigurationHelper();
        playerSettings.setInitialBitrate(httpclient.getInitialBitrate());
        clientstate = new Range(httpclient.getMinBitrate(), httpclient.getMaxBitrate());
        playerSettings.setBitRange(clientstate);
        parentView = new FrameLayout(applicationContext);
        if (parentView.getChildCount() > 0)
        {
            parentView.removeAllViews();
        }
        playerManager = new PlayerManager(playerSettings, applicationContext, activity, httpClient, licenseService, parentView);
        DRMManager.getSharedManager(applicationContext);
        EmergencyAlertProvider.getInstance().setPlayer(this);
        heartbeatInterval = httpclient.getHeartBeatInterval();
    }

    private boolean isPausableState()
    {
        PlayerStatus playerstatus = player.getPlayerStatus();
        return playerstatus.equals(PlayerStatus.PLAYING) || playerstatus.equals(PlayerStatus.PREPARED) || playerstatus.equals(PlayerStatus.SUSPENDED);
    }

    private boolean isPlayableState()
    {
        PlayerStatus playerstatus = player.getPlayerStatus();
        return videoReady() && drmReady() && (playerstatus.equals(PlayerStatus.PAUSED) || playerstatus.equals(PlayerStatus.PREPARED) || playerstatus.equals(PlayerStatus.READY) || playerstatus.equals(PlayerStatus.SUSPENDED));
    }

    private void resetLocalFields()
    {
        playbackHasOccured = false;
        drmComplete = false;
        assetLoadingComplete = false;
        initialPlayerState = InitialPlayerState.USE_AUTO_PLAY;
    }

    private void sendHeartbeatMessage()
    {
        if (player != null)
        {
            String s;
            String s1;
            long l;
            if (getCurrentClosedCaptionTrack() != null)
            {
                s = getCurrentClosedCaptionTrack().getName();
            } else
            {
                s = null;
            }
            if (getCurrentAudioTrack() != null)
            {
                s1 = getCurrentAudioTrack().getLanguage();
            } else
            {
                s1 = null;
            }
            l = PlayerMetrics.getBufferLength();
            analytics.heartBeat(Long.valueOf(getCurrentPosition()), Long.valueOf(getCurrentBitrate()), Integer.valueOf((int)currentFPS), s, s1, Long.valueOf(l), getCurrentAsset(), player.getFragmentInfo());
        }
    }

    private void sendMediaOpened()
    {
label0:
        {
label1:
            {
                isMediaOpened = true;
                if (playerSettings.getHeight() == 0 && playerSettings.getWidth() == 0)
                {
                    playerSettings.setHeight(player.getView().getHeight());
                    playerSettings.setWidth(player.getView().getWidth());
                }
                updateVideoSize();
                if (listenerManager != null)
                {
                    listenerManager.mediaOpened("HLS", getVideoType().name(), null, getAvailableAudioLanguages(), getAvailableClosedCaptionTracks(), getVideoWidth(), getVideoHeight(), getDuration(), getStartPosition(), false);
                }
                static class _cls6
                {

                    static final int $SwitchMap$com$comcast$playerplatform$primetime$android$enums$InitialPlayerState[];
                    static final int $SwitchMap$com$comcast$playerplatform$primetime$android$enums$PlayerStatus[];

                    static 
                    {
                        $SwitchMap$com$comcast$playerplatform$primetime$android$enums$InitialPlayerState = new int[InitialPlayerState.values().length];
                        try
                        {
                            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$InitialPlayerState[InitialPlayerState.PLAY.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror7) { }
                        try
                        {
                            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$InitialPlayerState[InitialPlayerState.PAUSE.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror6) { }
                        $SwitchMap$com$comcast$playerplatform$primetime$android$enums$PlayerStatus = new int[PlayerStatus.values().length];
                        try
                        {
                            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$PlayerStatus[PlayerStatus.INITIALIZED.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror5) { }
                        try
                        {
                            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$PlayerStatus[PlayerStatus.PREPARED.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        try
                        {
                            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$PlayerStatus[PlayerStatus.PAUSED.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$PlayerStatus[PlayerStatus.PLAYING.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$PlayerStatus[PlayerStatus.SUSPENDED.ordinal()] = 5;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$comcast$playerplatform$primetime$android$enums$PlayerStatus[PlayerStatus.ERROR.ordinal()] = 6;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                if (initialPlayerState != null)
                {
                    switch (_cls6..SwitchMap.com.comcast.playerplatform.primetime.android.enums.InitialPlayerState[initialPlayerState.ordinal()])
                    {
                    default:
                        checkForAutoPlay();
                        break;

                    case 1: // '\001'
                        break label1;

                    case 2: // '\002'
                        break label0;
                    }
                }
                return;
            }
            play();
            return;
        }
        pause();
    }

    private void setSizeWithAspectRatio(long l, long l1)
    {
        long l2 = playerSettings.getHeight();
        long l3 = playerSettings.getWidth();
        float f1 = (float)l3 / (float)l2;
        float f;
        int i;
        int j;
        if (l == 0L || l1 == 0L)
        {
            f = f1;
        } else
        {
            f = (float)l / (float)l1;
        }
        if (f <= f1)
        {
            j = (int)((float)l2 * f);
            i = (int)l2;
        } else
        {
            j = (int)l3;
            i = (int)((float)l3 * (1.0F / f));
        }
        setViewLayout(j, i);
    }

    private void setViewLayout(int i, int j)
    {
        getView().setLayoutParams(new android.widget.FrameLayout.LayoutParams(i, j, 17));
    }

    private void stopAndDestroyTimers()
    {
        if (heartbeatClock != null)
        {
            heartbeatClock.stop();
            heartbeatClock.removeClockEventListener(heartbeatClockEventListener);
            heartbeatClock = null;
        }
        if (playbackClock != null)
        {
            playbackClock.stop();
            playbackClock.removeClockEventListener(playbackClockEventListener);
            playbackClock = null;
        }
    }

    private void updatePlaybackMetrics()
    {
        long l = player.getCurrentBitrate();
        if (currentBitrate != l)
        {
            currentBitrate = l;
            if (listenerManager != null)
            {
                listenerManager.bitrateChanged(currentBitrate, null, getVideoHeight(), getVideoWidth());
            }
        }
        l = (long)PlayerMetrics.getFrameRate();
        if (currentFPS != l)
        {
            currentFPS = l;
            if (listenerManager != null)
            {
                listenerManager.fpsChanged(currentFPS);
            }
        }
        l = PlayerMetrics.getDroppedFrames();
        if (currentDFPS != l)
        {
            currentDFPS = l;
            if (listenerManager != null)
            {
                listenerManager.droppedFPSChanged(currentDFPS);
            }
        }
        l = player.getDuration();
        if (currentDuration != l)
        {
            currentDuration = l;
            if (listenerManager != null)
            {
                listenerManager.durationChanged(currentDuration);
            }
        }
        int i = player.getAvailableAudioLanguages().size();
        if (totalAudioTracks != i)
        {
            totalAudioTracks = i;
            if (listenerManager != null)
            {
                listenerManager.numberOfAlternativeAudioStreamsChanged(totalAudioTracks);
            }
        }
    }

    private void updateVideoSize()
    {
        PlayerProfile playerprofile = getLargestBitrate();
        if (playerSettings.getZoomSetting().equals(ZoomSetting.None) && playerprofile != null)
        {
            setSizeWithAspectRatio(playerprofile.getWidth(), playerprofile.getHeight());
            return;
        } else
        {
            setViewLayout(playerSettings.getWidth(), playerSettings.getHeight());
            return;
        }
    }

    private void updateViewSecurity()
    {
        if (currentChannel.getType() == com.comcast.playerplatform.primetime.android.asset.Asset.AssetType.ESPN || currentChannel.getType() == com.comcast.playerplatform.primetime.android.asset.Asset.AssetType.PRIMETIME)
        {
            ViewGroup viewgroup = (ViewGroup)player.getView();
            for (int i = 0; i < viewgroup.getChildCount(); i++)
            {
                if (viewgroup.getChildAt(i) instanceof VideoEngineView)
                {
                    ((VideoEngineView)viewgroup.getChildAt(i)).setSecure(false);
                }
            }

        }
    }

    private boolean videoReady()
    {
        return player != null && assetLoadingComplete;
    }

    public void addEventListener(AbstractPlayerPlatformVideoEventListener abstractplayerplatformvideoeventlistener)
    {
        listenerManager.addListener(abstractplayerplatformvideoeventlistener);
    }

    public void applyPlayerSettings()
    {
        player.addEventListener(listenerManager);
        player.getView().setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        player.setLogger(LogFactory.getInstance());
        if (playerSettings.getWidth() > 0 || playerSettings.getHeight() > 0)
        {
            setDimensionsOfVideo(playerSettings.getWidth(), playerSettings.getHeight());
        }
    }

    public void authenticateAssetOffline(Asset asset)
    {
        if (!StringUtil.isNotNullOrEmpty(asset.getDrmKey()))
        {
            licenseService.acquireLicenseForOfflinePlayback(asset.getManifestUri(), offlineDrmLicenseEventListener);
            return;
        } else
        {
            licenseService.acquireLicenseForOfflinePlayback(asset.getManifestUri(), asset.getDrmKey(), true, offlineDrmLicenseEventListener);
            return;
        }
    }

    public void configureAnalytics(HostInfo hostinfo)
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", "Configuring analytics, protocol : deviceType: " + " deviceID" + hostinfo.getDeviceId());
        AnalyticsProvider.getInstance().configureAnalytics(hostinfo, httpClient);
        analytics = new AnalyticsHandler(AnalyticsProvider.getInstance());
        analytics.pluginInitialized(applicationContext);
    }

    public void configureAuditudeAds()
    {
        configureAuditudeAds(null);
    }

    public void configureAuditudeAds(Map map)
    {
        playerSettings.setAdType(AdType.AUDITUDE);
        playerSettings.setC3Ads(null);
        playerSettings.setComscoreEnabled(false);
        playerSettings.setTargetingParameters(map);
    }

    public void configureC3Ads(List list)
    {
        playerSettings.setC3Ads(list);
        playerSettings.setAdType(AdType.C3);
        playerSettings.setComscoreEnabled(false);
    }

    public BaseAdManager createAdManager()
    {
        BaseAdManager baseadmanager = PlayerPlatformAds.getAdManager(playerSettings, currentChannel, httpClient, activity, applicationContext);
        if (baseadmanager != null)
        {
            baseadmanager.attachPlayer(player);
            baseadmanager.addPlayerEventManager(listenerManager);
            Object obj;
            if (currentChannel.getAdData() != null)
            {
                obj = currentChannel.getAdData().getAdType();
            } else
            {
                obj = playerSettings.getAdType();
            }
            if (((AdType) (obj)).equals(AdType.MANIFEST_MANIPULATOR))
            {
                Uri uri = Uri.parse(currentChannel.getManifestUri());
                String s;
                String s1;
                if (playerSettings.getAuthDelegate() != null)
                {
                    obj = playerSettings.getAuthDelegate().getAccessToken();
                } else
                {
                    obj = playerSettings.getClientState().retrieveSecurityToken(SecurityTokenType.XSCT);
                }
                s1 = "";
                s = s1;
                if (obj != null)
                {
                    s = s1;
                    if (((SecurityToken) (obj)).getDeviceId() != null)
                    {
                        s = ((SecurityToken) (obj)).getDeviceId();
                    }
                }
                obj = ((ManafestManipulatorManager)baseadmanager).updateUriWithQueryParams(uri, currentChannel, s);
                currentChannel.setManifestUri(((Uri) (obj)).toString());
            }
        }
        return baseadmanager;
    }

    public void destroy()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", "Destroying the player");
        stopAndDestroyTimers();
        listenerManager.clearListeners();
        if (player != null)
        {
            player.removeEventListener(listenerManager);
            player.destroy();
            player = null;
        }
        drmComplete = false;
        assetLoadingComplete = false;
        AnalyticsProvider.getInstance().forceSendMessages();
        EmergencyAlertProvider.getInstance().removeListener(listenerManager);
        if (ConfigurationManager.getInstance().isEspnReady())
        {
            ConfigurationManager.getInstance().unInitializeEspn();
        }
    }

    public boolean getAutoPlay()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("getAutoPlay() called : ").append(playerSettings.isAutoplay()).toString());
        return playerSettings.isAutoplay();
    }

    public List getAvailableAudioLanguages()
    {
        if (player != null)
        {
            return player.getAvailableAudioLanguages();
        } else
        {
            return null;
        }
    }

    public List getAvailableBitrates()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("getAvailableBitrates() called : ").append(player.getAvailableBitrates()).toString());
        if (player != null)
        {
            return player.getAvailableBitrates();
        } else
        {
            return null;
        }
    }

    public List getAvailableClosedCaptionTracks()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("getAvailableClosedCaptionTracks() called: ").append(player.getAvailableClosedCaptionTracks()).toString());
        if (player != null)
        {
            return player.getAvailableClosedCaptionTracks();
        } else
        {
            return null;
        }
    }

    public List getAvailableProfiles()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("getAvailableBitrates() called : ").append(player.getAvailableBitrates()).toString());
        if (player != null)
        {
            return player.getAvailableProfiles();
        } else
        {
            return null;
        }
    }

    public Range getBitrateRange()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("getBitrateRange() called : ").append(playerSettings.getBitRange()).toString());
        return playerSettings.getBitRange();
    }

    public boolean getClosedCaptionsStatus()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("getClosedCaptionsStatus() called : ").append(player.getClosedCaptionsStatus()).toString());
        return player != null && player.getClosedCaptionsStatus();
    }

    public VideoAd getCurrentAd()
    {
        if (player != null && player.getAdManager() != null)
        {
            return player.getAdManager().getCurrentAd();
        } else
        {
            return null;
        }
    }

    public VideoAdBreak getCurrentAdBreak()
    {
        if (player != null && player.getAdManager() != null)
        {
            return player.getAdManager().getCurrentAdBreak();
        } else
        {
            return null;
        }
    }

    public PlayerAudioTrack getCurrentAudioTrack()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("getCurrentAudioTrack() called : ").append(player.getCurrentAudioTrack()).toString());
        if (player != null)
        {
            return player.getCurrentAudioTrack();
        } else
        {
            return null;
        }
    }

    public int getCurrentBitrate()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("getCurrentBitrate() called : ").append(player.getCurrentBitrate()).toString());
        if (player != null)
        {
            return player.getCurrentBitrate();
        } else
        {
            return 0;
        }
    }

    public Asset getCurrentChannel()
    {
        return currentChannel;
    }

    public PlayerClosedCaptionsTrack getCurrentClosedCaptionTrack()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("getCurrentClosedCaptionTrack() called : ").append(player.getCurrentClosedCaptionTrack()).toString());
        if (player != null)
        {
            return player.getCurrentClosedCaptionTrack();
        } else
        {
            return null;
        }
    }

    public double getCurrentPlaybackSpeed()
    {
        if (player != null)
        {
            return (double)player.getCurrentPlaybackSpeed();
        } else
        {
            return 0.0D;
        }
    }

    public long getCurrentPosition()
    {
        if (player != null)
        {
            return player.getCurrentPosition();
        } else
        {
            return -1L;
        }
    }

    public long getDuration()
    {
        if (player != null)
        {
            return player.getDuration();
        } else
        {
            return -1L;
        }
    }

    public long getEndPosition()
    {
        if (player != null)
        {
            return player.getEndPosition();
        } else
        {
            return -1L;
        }
    }

    public int getInitialBitrate()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("getInitialBitrate() called : ").append(playerSettings.getInitialBitrate()).toString());
        return playerSettings.getInitialBitrate();
    }

    public PlayerLogger getLogger()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", "getLogger() called");
        return player.getLogger();
    }

    public PlayerStatus getPlayerStatus()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("getPlayerStatus() called : ").append(currentState).toString());
        return currentState;
    }

    public long getStartPosition()
    {
        return player == null ? -1L : 0L;
    }

    public List getSupportedClosedCaptionsOptions()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("getSupportedClosedCaptionsOptions() called : ").append(player.getSupportedClosedCaptionsOptions()).toString());
        if (player != null)
        {
            return player.getSupportedClosedCaptionsOptions();
        } else
        {
            return null;
        }
    }

    public List getSupportedPlaybackSpeeds()
    {
        if (player != null)
        {
            return player.getSupportedPlaybackSpeeds();
        } else
        {
            return null;
        }
    }

    public PlayerTimeline getTimeline()
    {
        if (player != null)
        {
            return player.getTimeline();
        } else
        {
            return null;
        }
    }

    public String getVersion()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("getVersion() called : ").append(PlayerPlatformVersion.getPlayerPlatformVersion()).toString());
        return PlayerPlatformVersion.getPlayerPlatformVersion();
    }

    public long getVideoHeight()
    {
        if (player != null)
        {
            return player.getVideoHeight();
        } else
        {
            return 0L;
        }
    }

    public StreamType getVideoType()
    {
        if (player != null)
        {
            return player.getVideoType();
        } else
        {
            return null;
        }
    }

    public long getVideoWidth()
    {
        if (player != null)
        {
            return player.getVideoWidth();
        } else
        {
            return 0L;
        }
    }

    public View getView()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", "getView() called");
        return parentView;
    }

    public boolean hasCC()
    {
        return player != null && player.hasCC();
    }

    public boolean hasDRM()
    {
        return player != null && player.hasDRM();
    }

    public boolean isAdPlaying()
    {
        return player != null && player.getAdManager() != null && player.getAdManager().isAdPlaying();
    }

    public void pause()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", "pause() called");
        if (player != null && isPausableState())
        {
            player.pause();
            analytics.trickPlay((int)player.getCurrentPosition(), "pause", player.getCurrentChannel().buildXuaAsset());
            return;
        } else
        {
            initialPlayerState = InitialPlayerState.PAUSE;
            return;
        }
    }

    public void play()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", "play() called");
        if (player != null && isPlayableState())
        {
            player.play();
            analytics.trickPlay((int)player.getCurrentPosition(), "play", player.getCurrentChannel().buildXuaAsset());
            return;
        } else
        {
            initialPlayerState = InitialPlayerState.PLAY;
            return;
        }
    }

    public void removeEventListener(AbstractPlayerPlatformVideoEventListener abstractplayerplatformvideoeventlistener)
    {
        listenerManager.removeListener(abstractplayerplatformvideoeventlistener);
    }

    public void requestMediaProgress()
    {
        if (player != null && listenerManager != null)
        {
            synchronized (player)
            {
                long l = getCurrentPosition();
                listenerManager.mediaProgress(l, getCurrentPlaybackSpeed(), getStartPosition(), getDuration(), updateInterval);
            }
            return;
        } else
        {
            return;
        }
        exception;
        player1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void seekToLive()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", "seekToLive() called");
        if (player != null)
        {
            player.seekToLive();
        }
    }

    public void setAsset(final Asset asset, final long startPosition)
    {
        System.currentTimeMillis();
        isMediaOpened = false;
        mediaOpenedSent = false;
        if (player != null && (currentState.equals(PlayerStatus.PAUSED) || currentState.equals(PlayerStatus.PREPARED) || currentState.equals(PlayerStatus.READY) || currentState.equals(PlayerStatus.PLAYING)))
        {
            stop();
        }
        currentChannel = asset;
        resetLocalFields();
        analytics.openingMedia(currentChannel.getManifestUri(), getCurrentAsset());
        if (player != null)
        {
            player.removeEventListener(listenerManager);
        }
        player = playerManager.getPlayer(asset.getType());
        final BaseAdManager adManager = createAdManager();
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final PlayerPlatformAPI this$0;
            final BaseAdManager val$adManager;
            final Asset val$asset;
            final long val$startPosition;

            public void run()
            {
                addPlayerView();
                applyPlayerSettings();
                player.setAsset(asset, startPosition, adManager);
            }

            
            {
                this$0 = PlayerPlatformAPI.this;
                asset = asset1;
                startPosition = l;
                adManager = baseadmanager;
                super();
            }
        });
    }

    public void setAutoPlay(Boolean boolean1)
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("setAutoPlay() called : ").append(boolean1).toString());
        playerSettings.setAutoplay(boolean1.booleanValue());
    }

    public void setBitrateParameters(BitrateParameters bitrateparameters)
    {
        playerSettings.setInitialBitrate(bitrateparameters.getInitialBitrate());
        playerSettings.setBitRange(new Range(bitrateparameters.getMinimumBitrate(), bitrateparameters.getMaximumBitrate()));
    }

    public void setBitrateRange(Range range)
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("setBitrateRange() called : range:").append(range).toString());
        playerSettings.setBitRange(range);
    }

    public void setBlock(boolean flag)
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("setBlock() called : ").append(flag).toString());
    }

    public void setClosedCaptionsEnabled(boolean flag)
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("setClosedCaptionsEnabled() called : ").append(flag).toString());
        playerSettings.setClosedCaptionsEnabled(flag);
        String s;
        if (flag)
        {
            s = "enabled";
        } else
        {
            s = "disabled";
        }
        analytics.mediaInfo((int)getCurrentPosition(), (new StringBuilder()).append("CC ").append(s).toString(), getCurrentAsset());
    }

    public void setClosedCaptionsOptions(ClosedCaptionFormatBuilder closedcaptionformatbuilder)
    {
        logger.d("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("setClosedCaptionsOptions() called : ").append(closedcaptionformatbuilder).toString());
        playerSettings.setCaptionFormat(closedcaptionformatbuilder);
    }

    public void setClosedCaptionsTrack(PlayerClosedCaptionsTrack playerclosedcaptionstrack)
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("setClosedCaptionsTrack() called : ").append(playerclosedcaptionstrack.getName()).toString());
        playerSettings.setClosedCaptionsTrack(playerclosedcaptionstrack);
    }

    public void setCurrentTimeUpdateInterval(int i)
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("setCurrentTimeUpdateInterval() called : ").append(i).toString());
        playerSettings.setUpdateInterval(i);
        updateInterval = i;
        if (playbackClock != null)
        {
            playbackClock.stop();
            playbackClock.removeClockEventListener(playbackClockEventListener);
            if (i > 0)
            {
                playbackClock = new Clock("PlaybackClock", updateInterval);
                playbackClock.addClockEventListener(playbackClockEventListener);
                playbackClock.start();
            }
        }
    }

    public void setDimensionsOfVideo(int i, int j)
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", "setDimensionsOfVideo() called : width:" + i + " height:" + j);
        playerSettings.setWidth(i);
        playerSettings.setHeight(j);
        updateVideoSize();
    }

    public void setInitialBitrate(int i)
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("setInitialBitrate() called : ").append(i).toString());
        playerSettings.setInitialBitrate(i);
    }

    public void setLogger(LogFactory logfactory)
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", "setLogger() called");
        playerSettings.setLogFactory(logfactory);
        if (player != null)
        {
            player.setLogger(logfactory);
        }
    }

    public void setLoggingVerbosity(com.adobe.mediacore.logging.Logger.Verbosity verbosity)
    {
        if (player != null)
        {
            player.setLoggingVerbosity(verbosity);
        }
    }

    public void setPlayerAdBreakPolicies(PlayerAdBreakPolicies playeradbreakpolicies)
    {
        playerSettings.setAdBreakPolicies(playeradbreakpolicies);
    }

    public void setPosition(long l, boolean flag)
    {
        long l1;
label0:
        {
            logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("setPosition() called : ").append(l).toString());
            if (player != null)
            {
                l1 = l;
                BaseAdManager baseadmanager = player.getAdManager();
                if (baseadmanager == null)
                {
                    break label0;
                }
                long l2 = getCurrentPosition();
                l = baseadmanager.getSeekAdjustment(l, l2, flag);
                l1 = l;
                if (l != l2)
                {
                    break label0;
                }
            }
            return;
        }
        player.setPosition(l1, flag);
    }

    public void setPositionRelative(long l)
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("setPositionRelative() called : ").append(l).toString());
        if (player != null)
        {
            player.setPositionRelative(l);
        }
    }

    public void setPreferredAudioLanguage(PlayerAudioTrack playeraudiotrack)
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("setPreferredAudioLanguage() called : ").append(playeraudiotrack.getLanguage()).toString());
        playerSettings.setPreferredAudioLanguage(playeraudiotrack);
        playeraudiotrack = (new StringBuilder()).append("SAP changed. ").append(playeraudiotrack.getLanguage()).toString();
        analytics.mediaInfo((int)getCurrentPosition(), playeraudiotrack, getCurrentAsset());
    }

    public void setPreferredZoomSetting(ZoomSetting zoomsetting)
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("setPreferredZoomSetting() called : ").append(zoomsetting).toString());
        playerSettings.setZoomSetting(zoomsetting);
        updateVideoSize();
    }

    public void setViewSecurity(boolean flag)
    {
        useSecureView = flag;
    }

    public void setVolume(int i)
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", (new StringBuilder()).append("setVolume() called : ").append(i).toString());
        if (player != null)
        {
            player.setVolume(i);
        }
    }

    public void stop()
    {
        logger.i("[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI", "stop() called");
        stopAndDestroyTimers();
        initialPlayerState = InitialPlayerState.USE_AUTO_PLAY;
        if (player != null)
        {
            player.stop();
        }
        currentState = PlayerStatus.IDLE;
    }









/*
    static boolean access$1502(PlayerPlatformAPI playerplatformapi, boolean flag)
    {
        playerplatformapi.drmComplete = flag;
        return flag;
    }

*/




/*
    static boolean access$1702(PlayerPlatformAPI playerplatformapi, boolean flag)
    {
        playerplatformapi.mediaOpenedSent = flag;
        return flag;
    }

*/









/*
    static PlayerStatus access$502(PlayerPlatformAPI playerplatformapi, PlayerStatus playerstatus)
    {
        playerplatformapi.currentState = playerstatus;
        return playerstatus;
    }

*/



/*
    static boolean access$702(PlayerPlatformAPI playerplatformapi, boolean flag)
    {
        playerplatformapi.assetLoadingComplete = flag;
        return flag;
    }

*/


}
