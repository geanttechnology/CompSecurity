// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.SurfaceHolder;
import com.adobe.ave.drm.DRMManager;
import com.adobe.ave.drm.DRMMetadata;
import com.comcast.cim.analytics.VideoErrorEventData;
import com.comcast.cim.analytics.VideoPlaybackEventData;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.android.view.common.errorformatter.ErrorFormatter;
import com.comcast.cim.android.view.common.errorformatter.FormattedError;
import com.comcast.cim.cmasl.analytics.AnalyticsLogger;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.taskexecutor.task.TaskFactory;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.comcast.cim.cmasl.xip.XipHttpErrorException;
import com.comcast.cim.cmasl.xip.ams.AmsHttpErrorException;
import com.comcast.cim.downloads.DownloadServiceException;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.cim.model.system.PlayerAndroidDevice;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.enums.DrmWorkflow;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.events.AbstractPlayerPlatformVideoEventListener;
import com.comcast.playerplatform.primetime.android.primetime.PlayerTimeline;
import com.comcast.playerplatform.primetime.android.primetime.TimelineMarker;
import com.xfinity.playerlib.PlayerApplication;
import com.xfinity.playerlib.authorization.VideoAuthManager;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.WatchableCodec;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import com.xfinity.playerlib.model.database.VideoBookmarkDAO;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.videoplay.NanoHTTPD;
import com.xfinity.playerlib.model.videoplay.PlayerConfigUtil;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;
import com.xfinity.playerlib.view.videoplay.PlayerPlatformErrorException;
import com.xfinity.playerlib.view.videoplay.PlayerPlatformMediaPlayer;
import com.xfinity.playerlib.view.videoplay.VideoTrackController;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            StartState, CimAssetFactory, VideoState

public class VideoStateController
{
    private class VideoPlayerEventListener extends AbstractPlayerPlatformVideoEventListener
    {

        final VideoStateController this$0;

        public void acquiringLicense(String s)
        {
            currentState.onAcquiringLicense(s);
        }

        public void adBreakComplete(VideoAdBreak videoadbreak)
        {
            currentState.adBreakComplete(videoadbreak);
        }

        public void adBreakStart(VideoAdBreak videoadbreak, VideoAd videoad)
        {
            currentState.adBreakStart(videoadbreak, videoad);
        }

        public void adComplete(String s)
        {
            currentState.adComplete(Long.parseLong(s));
        }

        public void adProgress(VideoAdBreak videoadbreak, VideoAd videoad, int i, long l)
        {
            currentState.adProgress(videoadbreak, videoad, i, l);
        }

        public void adStart(VideoAd videoad)
        {
            currentState.adStart(videoad);
        }

        public void bitrateChanged(long l, String s, long l1, long l2)
        {
            currentBitrate = l;
            currentState.onBitrateChanged(l, s, (int)l1, (int)l2);
        }

        public void drmComplete(String s, Date date, Date date1)
        {
            currentState.onDrmComplete(s, date, date1);
        }

        public void drmFailure(String s, String s1, String s2, Exception exception)
        {
            s2 = getBasicVideoErrorEventData("drmFailure");
            s2.setErrorCodes(s);
            s2.setErrorTitle(s1);
            s = formatError(new PlayerPlatformErrorException(s, s1, shouldUseDownloadFile()));
            if (s != null)
            {
                s2.setErrorMessage(s.getDescription());
            }
            splunker.logData(s2);
        }

        public void drmMetaDataAvailable(DRMManager drmmanager, DRMMetadata drmmetadata)
        {
            currentState.onDrmMetaDataAvailable(drmmanager, drmmetadata);
        }

        public void droppedFPSChanged(long l)
        {
            currentState.onDroppedFPSChanged(l);
        }

        public void durationChanged(long l)
        {
            currentState.onDurationChanged(l);
        }

        public void emergencyAlertCompleted(String s)
        {
            currentState.emergencyAlertCompleted(s);
        }

        public void emergencyAlertFailed(String s, String s1)
        {
            currentState.emergencyAlertFailed(s);
        }

        public void emergencyAlertStarted(String s)
        {
            currentState.emergencyAlertStarted(s);
        }

        public void fpsChanged(long l)
        {
            currentState.onFpsChanged(l);
        }

        public void mediaEnded()
        {
            currentState.onMediaEnded();
        }

        public void mediaFailed(String s, String s1)
        {
            VideoErrorEventData videoerroreventdata = getBasicVideoErrorEventData("mediaFailed");
            videoerroreventdata.setErrorTitle(s1);
            videoerroreventdata.setErrorCodes(s);
            FormattedError formattederror = formatError(new PlayerPlatformErrorException(s, s1, shouldUseDownloadFile()));
            if (formattederror != null)
            {
                videoerroreventdata.setErrorMessage(formattederror.getDescription());
            }
            splunker.logData(videoerroreventdata);
            currentState.onMediaFailed(s, s1);
        }

        public void mediaOpened(String s, String s1, List list, List list1, List list2, long l, 
                long l1, long l2, double d, boolean flag)
        {
            currentState.onMediaOpened(s, s1, list, list1, l, l1, d, flag);
        }

        public void mediaProgress(long l, double d, long l1, long l2, int i)
        {
            currentState.onMediaProgress(l, d, l1, l2, i);
            if (ticks <= 0) goto _L2; else goto _L1
_L1:
            if (!isLiveStream()) goto _L4; else goto _L3
_L3:
            if (ticks > 300 || ticks % 60 != 0) goto _L6; else goto _L5
_L5:
            trackingService.trackLiveStreamIncremental(liveStream.getTitle(), liveStream.getStreamId(), ticks, 60);
_L2:
            int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        public void mediaWarning(String s, String s1)
        {
            currentState.onMediaWarning(s, s1);
        }

        public void numberOfAlternativeAudioStreamsChanged(int i)
        {
            currentState.onNumberOfAlternativeAudioStreamsChanged(i);
        }

        public void offlineDRMComplete(String s, Date date, Date date1, String s1)
        {
            currentState.onOfflineDRMComplete(s, date, date1, s1);
        }

        public void offlineDRMFailure(String s, String s1)
        {
            currentState.onOfflineDRMFailure(s, s1);
        }

        public void onBufferComplete()
        {
            currentState.onBufferComplete();
        }

        public void onBufferStart()
        {
            currentState.onBufferStart();
        }

        public void onPlayStarted()
        {
            if (!playbackStarted)
            {
                playbackStarted = true;
                VideoPlaybackEventData videoplaybackeventdata = getVideoPlaybackEventData("VIDEO_START");
                getSplunker().logData(videoplaybackeventdata);
            }
        }

        public void onSeekComplete(long l)
        {
            getUiController().setIsSeeking(Boolean.valueOf(false));
            currentState.onVideoSeekComplete();
        }

        public void onSeekStart()
        {
            currentState.onVideoSeekStart();
        }

        public void onTimelineUpdated()
        {
            currentState.onTimelineUpdated();
        }

        public void playStateChanged(PlayerStatus playerstatus)
        {
            VideoStateController.LOG.warn((new StringBuilder()).append("NEW PLAYER STATE: ").append(playerstatus).toString());
            currentState.onPlayStateChanged(playerstatus);
        }

        public void playbackSpeedChanged(float f)
        {
            currentState.onPlaybackSpeedChanged(f);
        }

        private VideoPlayerEventListener()
        {
            this$0 = VideoStateController.this;
            super();
        }

    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController);
    private final Activity activityContext;
    private AtomicInteger amsErrorCount;
    private final PlayerAndroidDevice androidDevice;
    private final ScheduledThreadPoolExecutor authContinueExecutor = new ScheduledThreadPoolExecutor(1);
    private ScheduledFuture authContinueFuture;
    private final CimAssetFactory cimAssetFactory;
    private long currentBitrate;
    private VideoState currentState;
    private PlayerDownloadFile downloadedFile;
    private String drmKey;
    private final ErrorDialogFactory errorDialogFactory;
    private final ErrorFormatter errorFormatter;
    private boolean hasPreroll;
    private final HttpClient httpClient;
    private int httpPort;
    private boolean ignoreMobileDataWarningSettingThisSession;
    private final InternetConnection internetConnection;
    private HalLiveStream liveStream;
    private final TaskFactory liveStreamMetaDataResourceFactory;
    private final Task liveStreamResourceCache;
    private NanoHTTPD localHostServer;
    private String manifestUrl;
    private PlayerPlatformMediaPlayer mediaPlayer;
    private final TaskFactory movieCacheMap;
    private final Task parentalControlsCache;
    private boolean playbackStarted;
    private final PlayerApplication playerApplication;
    private final PlayerConfigUtil playerConfigUtil;
    private final PlayerDownloadServiceManager playerDownloadServiceManager;
    private boolean prerollChecked;
    private final TaskExecutorFactory providerFactory;
    private final TaskFactory seriesCacheMap;
    private final AnalyticsLogger splunker;
    private int ticks;
    private final PlayNowTrackingService trackingService;
    private final com.xfinity.playerlib.view.videoplay.VideoPlayerFragment.PlayerUIController uiController;
    private final Executor uiThreadExecutor;
    private final PlayNowUserManager userManager;
    private final VideoAuthManager videoAuthManager;
    private final Task videoEntitlementCache;
    private VideoPlayerEventListener videoEventListener;
    private VideoFacade videoFacade;
    private final VideoTrackController videoTrackController;
    private Watchable watchable;
    private final WatchableCodec watchableCodec;

    public VideoStateController(Activity activity, com.xfinity.playerlib.view.videoplay.VideoPlayerFragment.PlayerUIController playeruicontroller, PlayerDownloadServiceManager playerdownloadservicemanager, TaskExecutorFactory taskexecutorfactory, TaskFactory taskfactory, TaskFactory taskfactory1, TaskFactory taskfactory2, 
            Task task, Task task1, WatchableCodec watchablecodec, InternetConnection internetconnection, PlayNowUserManager playnowusermanager, PlayerAndroidDevice playerandroiddevice, VideoAuthManager videoauthmanager, 
            Executor executor, Task task2, VideoBookmarkDAO videobookmarkdao, LiveStreamBookmarkDAO livestreambookmarkdao, PlayerApplication playerapplication, HttpClient httpclient, CimAssetFactory cimassetfactory, 
            PlayerConfigUtil playerconfigutil, AnalyticsLogger analyticslogger, AnalyticsLogger analyticslogger1, PlayNowTrackingService playnowtrackingservice, ErrorFormatter errorformatter, ErrorDialogFactory errordialogfactory)
    {
        amsErrorCount = new AtomicInteger();
        videoFacade = null;
        watchable = null;
        downloadedFile = null;
        liveStream = null;
        ignoreMobileDataWarningSettingThisSession = false;
        manifestUrl = null;
        drmKey = null;
        localHostServer = null;
        httpPort = 8482;
        authContinueFuture = null;
        currentBitrate = -1L;
        ticks = 0;
        prerollChecked = false;
        hasPreroll = false;
        videoEventListener = new VideoPlayerEventListener();
        activityContext = activity;
        uiController = playeruicontroller;
        playerDownloadServiceManager = playerdownloadservicemanager;
        providerFactory = taskexecutorfactory;
        movieCacheMap = taskfactory;
        seriesCacheMap = taskfactory1;
        liveStreamMetaDataResourceFactory = taskfactory2;
        videoEntitlementCache = task;
        liveStreamResourceCache = task1;
        watchableCodec = watchablecodec;
        internetConnection = internetconnection;
        userManager = playnowusermanager;
        androidDevice = playerandroiddevice;
        videoAuthManager = videoauthmanager;
        uiThreadExecutor = executor;
        parentalControlsCache = task2;
        playerApplication = playerapplication;
        httpClient = httpclient;
        trackingService = playnowtrackingservice;
        videoTrackController = new VideoTrackController(videobookmarkdao, livestreambookmarkdao, playnowusermanager, playnowtrackingservice, analyticslogger1);
        cimAssetFactory = cimassetfactory;
        playerConfigUtil = playerconfigutil;
        splunker = analyticslogger;
        errorFormatter = errorformatter;
        errorDialogFactory = errordialogfactory;
        currentState = new StartState(this);
    }

    public void cancelAmsContinueCalls()
    {
        if (authContinueFuture != null)
        {
            authContinueFuture.cancel(true);
            authContinueFuture = null;
        }
    }

    public void checkShouldPauseDownloads()
    {
        if (videoFacade != null && downloadedFile == null || isLiveStream())
        {
            try
            {
                playerDownloadServiceManager.initiateTemporaryPause();
                return;
            }
            catch (DownloadServiceException downloadserviceexception)
            {
                LOG.error("Failed to pause downloads", downloadserviceexception);
            }
            return;
        } else
        {
            unpauseDownloads();
            return;
        }
    }

    public Asset createAsset()
    {
        if (getLiveStream() != null)
        {
            if (getLiveStream().isEspn())
            {
                String s = getActivityContext().getIntent().getStringExtra("liveEventID");
                if (s == null)
                {
                    return cimAssetFactory.create(getLiveStream().getSchemeSpecificPart(), getDrmKey(), getVideoAuthManager());
                } else
                {
                    return cimAssetFactory.create(getLiveStream(), getLiveStream().getSchemeSpecificPart(), s, getDrmKey(), getVideoAuthManager());
                }
            }
            if (getLiveStream().isDisney())
            {
                return cimAssetFactory.create(getLiveStream().getSchemeSpecificPart(), getLiveStream().getSchemeSpecificPart(), getDrmKey(), getVideoAuthManager(), getActivityContext());
            } else
            {
                return cimAssetFactory.create(getManifestUrl(), getDrmKey(), DrmWorkflow.STREAMING, getLiveStream().getStreamId());
            }
        }
        CimAssetFactory cimassetfactory = cimAssetFactory;
        String s1 = getManifestUrl();
        String s2 = getDrmKey();
        VideoFacade videofacade = getVideoFacade();
        DrmWorkflow drmworkflow;
        if (downloadedFile == null)
        {
            drmworkflow = DrmWorkflow.STREAMING;
        } else
        {
            drmworkflow = DrmWorkflow.LOCAL;
        }
        return cimassetfactory.create(s1, s2, videofacade, drmworkflow);
    }

    public FormattedError formatError(Throwable throwable)
    {
        return errorFormatter.formatError(throwable);
    }

    public Activity getActivityContext()
    {
        return activityContext;
    }

    public long getAdDuration()
    {
        return getMediaPlayer().getCurrentAdDuration();
    }

    public PlayerAndroidDevice getAndroidDevice()
    {
        return androidDevice;
    }

    public VideoErrorEventData getBasicVideoErrorEventData(String s)
    {
        s = new VideoErrorEventData(s, userManager.getHashedOmnitureGuid(), playerApplication.getVersionNumber());
        s.setBitrate(currentBitrate);
        long l;
        boolean flag;
        if (mediaPlayer != null)
        {
            l = mediaPlayer.getPosition();
        } else
        {
            l = -1L;
        }
        s.setCurrentPlaybackPosition(l);
        if (mediaPlayer != null && mediaPlayer.isAdPlaying())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s.setInAd(flag);
        if (videoFacade != null)
        {
            s.setVideoTitle(videoFacade.getTitle());
            s.setPid(videoFacade.getPid());
            s.setReleaseUrl(videoFacade.getReleaseURL());
            s.setCc(videoFacade.isCC());
            s.setLanguages(videoFacade.getLanguageCodes());
        } else
        if (liveStream != null)
        {
            s.setVideoTitle((new StringBuilder()).append("Live: ").append(liveStream.getTitle()).toString());
            s.setPid(liveStream.getStreamId());
            s.setReleaseUrl(liveStream.getPlaybackLink());
            return s;
        }
        return s;
    }

    public PlayerDownloadFile getDownloadedFile()
    {
        return downloadedFile;
    }

    public String getDrmKey()
    {
        return drmKey;
    }

    public ErrorDialogFactory getErrorDialogFactory()
    {
        return errorDialogFactory;
    }

    public HttpClient getHttpClient()
    {
        return httpClient;
    }

    public int getHttpPort()
    {
        return httpPort;
    }

    public InternetConnection getInternetConnection()
    {
        return internetConnection;
    }

    public HalLiveStream getLiveStream()
    {
        return liveStream;
    }

    public TaskFactory getLiveStreamMetaDataResourceFactory()
    {
        return liveStreamMetaDataResourceFactory;
    }

    public Task getLiveStreamResourceCache()
    {
        return liveStreamResourceCache;
    }

    public NanoHTTPD getLocalHostServer()
    {
        return localHostServer;
    }

    public String getManifestUrl()
    {
        return manifestUrl;
    }

    public PlayerPlatformMediaPlayer getMediaPlayer()
    {
        return mediaPlayer;
    }

    public Executor getMediaStreamExecutor()
    {
        return authContinueExecutor;
    }

    public TaskFactory getMovieCacheMap()
    {
        return movieCacheMap;
    }

    public Tuple getNextVideoItem()
    {
        return getWatchable().getNextVideoItem(getVideoFacade(), getMediaPlayer().getLanguage());
    }

    public Task getParentalControlsCache()
    {
        return parentalControlsCache;
    }

    public PlayerApplication getPlayerApplication()
    {
        return playerApplication;
    }

    public PlayerConfigUtil getPlayerConfigUtil()
    {
        return playerConfigUtil;
    }

    public PlayerDownloadServiceManager getPlayerDownloadServiceManager()
    {
        return playerDownloadServiceManager;
    }

    public TaskFactory getSeriesCacheMap()
    {
        return seriesCacheMap;
    }

    public AnalyticsLogger getSplunker()
    {
        return splunker;
    }

    public String getStateName()
    {
        return currentState.getStateName();
    }

    public TaskExecutorFactory getTaskExecutorFactory()
    {
        return providerFactory;
    }

    public com.xfinity.playerlib.view.videoplay.VideoPlayerFragment.PlayerUIController getUiController()
    {
        return uiController;
    }

    public Executor getUiThreadExecutor()
    {
        return uiThreadExecutor;
    }

    public PlayNowUserManager getUserManager()
    {
        return userManager;
    }

    public VideoAuthManager getVideoAuthManager()
    {
        return videoAuthManager;
    }

    public Task getVideoEntitlementCache()
    {
        return videoEntitlementCache;
    }

    public VideoFacade getVideoFacade()
    {
        return videoFacade;
    }

    public VideoPlaybackEventData getVideoPlaybackEventData(String s)
    {
        String s1;
        String s2;
        String s3;
        String s4;
        s1 = null;
        s3 = null;
        s2 = null;
        s4 = null;
        if (!isLiveStream()) goto _L2; else goto _L1
_L1:
        s1 = "liveStream";
        s3 = getLiveStream().getStreamId();
        s2 = getLiveStream().getTitle();
        s4 = "NA";
_L4:
        return new VideoPlaybackEventData(playerApplication.getResources().getString(com.xfinity.playerlib.R.string.appId), playerApplication.getVersionNumber(), userManager.getHashedOmnitureGuid(), s, s1, s2, s3, s4);
_L2:
        if (videoFacade != null)
        {
            if (videoFacade.isMovie())
            {
                s1 = "movie";
            } else
            {
                s1 = "tvEpisode";
            }
            s3 = String.valueOf(videoFacade.getVideoId());
            s2 = videoFacade.getNetworkInfo().getName();
            s4 = String.valueOf(mediaPlayer.getDuration());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public VideoTrackController getVideoTrackController()
    {
        return videoTrackController;
    }

    public Watchable getWatchable()
    {
        return watchable;
    }

    public WatchableCodec getWatchableCodec()
    {
        return watchableCodec;
    }

    public boolean hasPreroll()
    {
        if (!prerollChecked)
        {
            Object obj = getMediaPlayer().getTimeline();
            if (obj != null)
            {
                obj = ((PlayerTimeline) (obj)).timelineMarkers();
                if (((Iterator) (obj)).hasNext() && ((TimelineMarker)((Iterator) (obj)).next()).getTime() == 0L)
                {
                    hasPreroll = true;
                }
            }
            prerollChecked = true;
        }
        return hasPreroll;
    }

    public void incrementHttpPort()
    {
        if (httpPort < 15000)
        {
            httpPort = httpPort + 1;
            return;
        } else
        {
            httpPort = 8482;
            return;
        }
    }

    public void initPlayerPlatformMediaPlayer()
    {
        mediaPlayer = new PlayerPlatformMediaPlayer(getActivityContext(), httpClient);
        mediaPlayer.addEventListener(videoEventListener);
        ticks = 0;
    }

    public boolean isAdPlaying()
    {
        return getMediaPlayer().isAdPlaying();
    }

    public boolean isCC()
    {
        if (getVideoFacade() != null)
        {
            return getVideoFacade().isCC();
        }
        if (getLiveStream() != null)
        {
            return getMediaPlayer().hasCC();
        } else
        {
            return false;
        }
    }

    public boolean isIgnoreMobileDataWarningSettingThisSession()
    {
        return ignoreMobileDataWarningSettingThisSession;
    }

    public boolean isLiveStream()
    {
        return getLiveStream() != null;
    }

    public void onAMSContinueException(Exception exception)
    {
        currentState.onAMSContinueException(exception);
    }

    public void onActivityPaused()
    {
        currentState.onActivityPaused();
    }

    public void onActivityResumed()
    {
        if (currentState != null)
        {
            currentState.onActivityResumed();
        }
    }

    public void onAmsAuthenticationException(Exception exception)
    {
        currentState.onAmsAuthenticationException(exception);
    }

    public void onAmsAuthenticationSuccess()
    {
        currentState.onAmsAuthenticationSuccess();
    }

    public void onAmsPinRequired()
    {
        currentState.onAmsPinRequired();
    }

    public void onBabyGuideButton()
    {
        currentState.onBabyGuideButton();
    }

    public void onBackButton()
    {
        currentState.onBackButton();
    }

    public void onCCButton()
    {
        currentState.onCCButton();
    }

    public void onConfigurationLoaded()
    {
        currentState.onConfigurationLoaded();
    }

    public void onConnectivityChanged()
    {
        currentState.onConnectivityChanged();
    }

    public void onFavoriteItemDetailSelected(VideoFavorite videofavorite)
    {
        currentState.onFavoriteItemDetailSelected(videofavorite);
    }

    public void onFavoritesButton()
    {
        currentState.onFavoritesButton();
    }

    public void onFragmentDestroyed()
    {
        currentState.onFragmentDestroyed();
    }

    public void onHeadsetButtonEvent(int i)
    {
        currentState.onHeadsetButtonEvent(i);
    }

    public void onHeadsetNoiseDetected()
    {
        currentState.onHeadsetNoiseDetected();
    }

    public void onHistoryButton()
    {
        currentState.onHistoryButton();
    }

    public void onHistoryItemDetailSelected(VideoBookmark videobookmark)
    {
        currentState.onHistoryItemDetailSelected(videobookmark);
    }

    public void onLiveStreamFetched(HalLiveStream hallivestream)
    {
        currentState.onLiveStreamFetched(hallivestream);
    }

    public void onLiveStreamPlayOrResumePressed(String s)
    {
        currentState.onLiveStreamPlaySelected(s);
    }

    public void onLiveStreamPlaySelected(HalLiveStream hallivestream)
    {
        currentState.onLiveStreamPlaySelected(hallivestream);
    }

    public void onNewVideoPlayOrResumeSelected(VideoBookmark videobookmark)
    {
        currentState.onNewVideoPlayOrResumeSelected(videobookmark);
    }

    public void onNewVideoPlayOrResumeSelected(VideoFacade videofacade, Watchable watchable1)
    {
        currentState.onNewVideoPlayOrResumeSelected(videofacade, watchable1);
    }

    public void onPauseButton()
    {
        currentState.onPauseButton();
    }

    public void onPinCanceled()
    {
        currentState.onPinCanceled();
    }

    public void onPlayButton()
    {
        currentState.onPlayButton();
    }

    public void onPlayerSurfaceCreated(SurfaceHolder surfaceholder)
    {
        currentState.onPlayerSurfaceCreated(surfaceholder);
    }

    public void onSAPButton()
    {
        currentState.onSAPButton();
    }

    public void onScreenTouch()
    {
        currentState.onScreenTouch();
    }

    public void onSeekRequest(long l)
    {
        currentState.onSeekRequest(l);
    }

    public void onSeriesWatchableDetailSelected(SeriesWatchable serieswatchable)
    {
        currentState.onSeriesWatchableDetailSelected(serieswatchable);
    }

    public void onUserMovedSeekBar(int i)
    {
        currentState.onUserMovedSeekBar(i);
    }

    public void onUserSeekEnded(boolean flag)
    {
        currentState.onUserSeekEnded(flag);
    }

    public void onUserSeekStarted()
    {
        currentState.onUserSeekStarted();
    }

    public void onValidatePin(String s, com.comcast.cim.android.view.common.PinKeypadFragment.PinValidationCompletedListener pinvalidationcompletedlistener)
    {
        currentState.onValidatePin(s, pinvalidationcompletedlistener);
    }

    public void onVideoFetchFailed()
    {
        currentState.onVideoFetchFailed();
    }

    public void onVideoFetched(VideoFacade videofacade, Watchable watchable1)
    {
        currentState.onVideoFetched(videofacade, watchable1);
    }

    public void onVolumeChanged()
    {
        currentState.onVolumeChanged();
    }

    public void performAmsAuthorization(String s)
        throws Exception
    {
        if (videoFacade == null) goto _L2; else goto _L1
_L1:
        getVideoAuthManager().performVideoAuthorization(videoFacade, s);
_L4:
        amsErrorCount.set(0);
        return;
_L2:
        if (liveStream != null)
        {
            getVideoAuthManager().performLiveStreamAuthorization(liveStream, s);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void reset()
    {
        getUiController().reset();
        cancelAmsContinueCalls();
        if (mediaPlayer != null)
        {
            mediaPlayer.destroy();
            mediaPlayer = null;
        }
        if (localHostServer != null)
        {
            localHostServer.stop();
            localHostServer = null;
        }
        hasPreroll = false;
        prerollChecked = false;
        playbackStarted = false;
        setState(new StartState(this));
    }

    public void resetLiveStream()
    {
        liveStream = null;
    }

    public void resetVideoAndWatchable()
    {
        videoFacade = null;
        watchable = null;
        downloadedFile = null;
    }

    public void scheduleAmsContinueCalls()
    {
        if (getVideoAuthManager().shouldMakeContinueCall())
        {
            LOG.debug("####Schedule AMS continue call now...");
            authContinueFuture = authContinueExecutor.scheduleAtFixedRate(new Runnable() {

                final VideoStateController this$0;

                private void callOnAMSContinueException(Exception exception)
                {
                    uiThreadExecutor.execute(exception. new Runnable() {

                        final _cls1 this$1;
                        final Exception val$e;

                        public void run()
                        {
                            onAMSContinueException(e);
                        }

            
            {
                this$1 = final__pcls1;
                e = Exception.this;
                super();
            }
                    });
                }

                public void run()
                {
                    try
                    {
                        videoAuthManager.sendVideoContinueHeartbeat();
                        return;
                    }
                    catch (AmsHttpErrorException amshttperrorexception)
                    {
                        VideoStateController.LOG.error("Caught exception during AMS continue call", amshttperrorexception);
                        static class _cls2
                        {

                            static final int $SwitchMap$com$comcast$cim$cmasl$xip$ams$AmsHttpErrorException$PlayerAction[];

                            static 
                            {
                                $SwitchMap$com$comcast$cim$cmasl$xip$ams$AmsHttpErrorException$PlayerAction = new int[com.comcast.cim.cmasl.xip.ams.AmsHttpErrorException.PlayerAction.values().length];
                                try
                                {
                                    $SwitchMap$com$comcast$cim$cmasl$xip$ams$AmsHttpErrorException$PlayerAction[com.comcast.cim.cmasl.xip.ams.AmsHttpErrorException.PlayerAction.INCREMENT.ordinal()] = 1;
                                }
                                catch (NoSuchFieldError nosuchfielderror1) { }
                                try
                                {
                                    $SwitchMap$com$comcast$cim$cmasl$xip$ams$AmsHttpErrorException$PlayerAction[com.comcast.cim.cmasl.xip.ams.AmsHttpErrorException.PlayerAction.STOP.ordinal()] = 2;
                                }
                                catch (NoSuchFieldError nosuchfielderror)
                                {
                                    return;
                                }
                            }
                        }

                        switch (_cls2..SwitchMap.com.comcast.cim.cmasl.xip.ams.AmsHttpErrorException.PlayerAction[AmsHttpErrorException.getPlayerActionForException(amshttperrorexception).ordinal()])
                        {
                        default:
                            callOnAMSContinueException(amshttperrorexception);
                            return;

                        case 1: // '\001'
                            break;
                        }
                        if (amsErrorCount.incrementAndGet() > 2)
                        {
                            callOnAMSContinueException(amshttperrorexception);
                            return;
                        } else
                        {
                            VideoStateController.LOG.error("Error count {} is within threshold {}, continuing", amsErrorCount, Integer.valueOf(2));
                            return;
                        }
                    }
                    catch (Exception exception)
                    {
                        if ((exception instanceof XipHttpErrorException) && ((XipHttpErrorException)exception).getDetailedStatusCode() == 3001)
                        {
                            VideoStateController.LOG.error("XipNotProvisioned captured in continue auth, signout and quit video", exception);
                            callOnAMSContinueException(exception);
                            return;
                        } else
                        {
                            VideoStateController.LOG.warn("AMS continue call caught exception...ignore");
                            return;
                        }
                    }
                }

            
            {
                this$0 = VideoStateController.this;
                super();
            }
            }, 120L, 120L, TimeUnit.SECONDS);
        }
    }

    public void setDownloadedFile(PlayerDownloadFile playerdownloadfile)
    {
        downloadedFile = playerdownloadfile;
    }

    public void setDrmKey(String s)
    {
        drmKey = s;
    }

    public void setIgnoreMobileDataWarningSettingThisSession(boolean flag)
    {
        ignoreMobileDataWarningSettingThisSession = flag;
    }

    public void setLiveStream(HalLiveStream hallivestream)
    {
        liveStream = hallivestream;
        videoTrackController.setTrackingItems(hallivestream);
        resetVideoAndWatchable();
    }

    public void setLocalHostServer(NanoHTTPD nanohttpd)
    {
        localHostServer = nanohttpd;
    }

    public void setManifestUrl(String s)
    {
        manifestUrl = s;
    }

    void setState(VideoState videostate)
    {
        Logger logger = LOG;
        String s;
        if (currentState != null)
        {
            s = currentState.getStateName();
        } else
        {
            s = null;
        }
        logger.debug("Changing states from {} to {}", s, videostate.getStateName());
        currentState = videostate;
        videostate.run();
    }

    public void setVideoAndWatchable(VideoFacade videofacade, Watchable watchable1)
    {
        videoFacade = videofacade;
        watchable = watchable1;
        videoTrackController.setTrackingItems(videofacade, watchable1);
        resetLiveStream();
    }

    public boolean shouldUseDownloadFile()
    {
        return downloadedFile != null && downloadedFile.isDownloadComplete() && downloadedFile.getExpirationStatus() != com.xfinity.playerlib.model.downloads.PlayerDownloadFile.ExpirationStatus.AAW_EXPIRED;
    }

    public void shutdown()
    {
        getUiController().removeVideoView();
        getUiController().removeMainControlTimeout();
        if (getMediaPlayer() != null)
        {
            getMediaPlayer().removeEventListener(videoEventListener);
            getMediaPlayer().destroy();
        }
        authContinueExecutor.shutdownNow();
        if (localHostServer != null)
        {
            localHostServer.stop();
            localHostServer = null;
        }
    }

    public void shutdownAndFinishActivity()
    {
        shutdown();
        getActivityContext().finish();
    }

    public void transitionToState(VideoState videostate)
    {
        currentState.transitionToState(videostate);
    }

    public void unpauseDownloads()
    {
        try
        {
            if (playerDownloadServiceManager.isTemporarilyPaused())
            {
                playerDownloadServiceManager.resumeDownloading();
            }
            return;
        }
        catch (DownloadServiceException downloadserviceexception)
        {
            LOG.error("Failed to resume downloads", downloadserviceexception);
        }
    }








/*
    static boolean access$1202(VideoStateController videostatecontroller, boolean flag)
    {
        videostatecontroller.playbackStarted = flag;
        return flag;
    }

*/




/*
    static long access$402(VideoStateController videostatecontroller, long l)
    {
        videostatecontroller.currentBitrate = l;
        return l;
    }

*/





/*
    static int access$708(VideoStateController videostatecontroller)
    {
        int i = videostatecontroller.ticks;
        videostatecontroller.ticks = i + 1;
        return i;
    }

*/


}
