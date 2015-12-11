// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.view.SurfaceHolder;
import com.adobe.ave.drm.DRMManager;
import com.adobe.ave.drm.DRMMetadata;
import com.comcast.cim.analytics.VideoErrorEventData;
import com.comcast.cim.android.view.common.errorformatter.FormattedError;
import com.comcast.cim.cmasl.analytics.AnalyticsLogger;
import com.comcast.cim.cmasl.xip.ams.AmsHttpErrorException;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.view.videoplay.PlayerPlatformErrorException;
import com.xfinity.playerlib.view.videoplay.PlayerPlatformMediaPlayer;
import com.xfinity.playerlib.view.videoplay.VideoTrackController;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            VideoState, VideoStateController, ErrorState, ResetPlayerState, 
//            BackgroundState, QuitState, DestroyedState

public abstract class DefaultVideoState
    implements VideoState
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState);
    protected VideoStateController stateController;

    public DefaultVideoState(VideoStateController videostatecontroller)
    {
        stateController = videostatecontroller;
    }

    public void adBreakComplete(VideoAdBreak videoadbreak)
    {
    }

    public void adBreakStart(VideoAdBreak videoadbreak, VideoAd videoad)
    {
    }

    public void adComplete(long l)
    {
    }

    public void adProgress(VideoAdBreak videoadbreak, VideoAd videoad, int i, long l)
    {
    }

    public void adStart(VideoAd videoad)
    {
    }

    public void emergencyAlertCompleted(String s)
    {
    }

    public void emergencyAlertFailed(String s)
    {
    }

    public void emergencyAlertStarted(String s)
    {
    }

    public abstract String getStateName();

    protected void handleExceptionCaughtDuringAmsOperation(Exception exception, VideoState videostate)
    {
        Object obj = stateController.getBasicVideoErrorEventData("amsFailure");
        ((VideoErrorEventData) (obj)).setEventType("AmsException");
        FormattedError formattederror = stateController.formatError(exception);
        if (formattederror != null)
        {
            ((VideoErrorEventData) (obj)).setErrorMessage(formattederror.getDescription());
        }
        ((VideoErrorEventData) (obj)).setErrorTitle(exception.getMessage());
        stateController.getSplunker().logData(((com.comcast.cim.cmasl.analytics.EventData) (obj)));
        if (exception instanceof AmsHttpErrorException)
        {
            obj = (AmsHttpErrorException)exception;
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            if (((AmsHttpErrorException) (obj)).getDetailedStatusCode() == 405 || ((AmsHttpErrorException) (obj)).getDetailedStatusCode() == 407)
            {
                stateController.transitionToState(ErrorState.newUpsellErrorState(stateController, exception));
                return;
            }
            if (((AmsHttpErrorException) (obj)).getDetailedStatusCode() == 1105 || ((AmsHttpErrorException) (obj)).getDetailedStatusCode() == 1102)
            {
                LOG.error((new StringBuilder()).append("AMS returned ").append(((AmsHttpErrorException) (obj)).getStatusCodeForDisplay()).append(", resetting player").toString(), exception);
                stateController.transitionToState(new ResetPlayerState(stateController, this));
                return;
            }
        }
        stateController.transitionToState(new ErrorState(stateController, exception, videostate));
    }

    public void onAMSContinueException(Exception exception)
    {
        stateController.cancelAmsContinueCalls();
        handleExceptionCaughtDuringAmsOperation(exception, new ResetPlayerState(stateController, this));
    }

    public void onAcquiringLicense(String s)
    {
    }

    public void onActivityPaused()
    {
        stateController.transitionToState(new BackgroundState(stateController, this));
    }

    public void onActivityResumed()
    {
    }

    public void onAmsAuthenticationException(Exception exception)
    {
    }

    public void onAmsAuthenticationSuccess()
    {
    }

    public void onAmsPinRequired()
    {
    }

    public void onBabyGuideButton()
    {
    }

    public void onBackButton()
    {
        stateController.transitionToState(new QuitState(stateController));
    }

    public void onBitrateChanged(long l, String s, int i, int j)
    {
    }

    public void onBufferComplete()
    {
    }

    public void onBufferStart()
    {
    }

    public void onCCButton()
    {
    }

    public void onConfigurationLoaded()
    {
    }

    public void onConnectivityChanged()
    {
    }

    public void onDrmComplete(String s, Date date, Date date1)
    {
    }

    public void onDrmMetaDataAvailable(DRMManager drmmanager, DRMMetadata drmmetadata)
    {
    }

    public void onDroppedFPSChanged(long l)
    {
    }

    public void onDurationChanged(long l)
    {
    }

    public void onFavoriteItemDetailSelected(VideoFavorite videofavorite)
    {
    }

    public void onFavoritesButton()
    {
    }

    public void onFpsChanged(long l)
    {
    }

    public void onFragmentDestroyed()
    {
        stateController.transitionToState(new DestroyedState(stateController));
    }

    public void onHeadsetButtonEvent(int i)
    {
    }

    public void onHeadsetNoiseDetected()
    {
    }

    public void onHistoryButton()
    {
    }

    public void onHistoryItemDetailSelected(VideoBookmark videobookmark)
    {
    }

    public void onLiveStreamFetched(HalLiveStream hallivestream)
    {
    }

    public void onLiveStreamPlaySelected(HalLiveStream hallivestream)
    {
    }

    public void onLiveStreamPlaySelected(String s)
    {
    }

    public void onMediaEnded()
    {
    }

    public void onMediaFailed(String s, String s1)
    {
        PlayerPlatformErrorException playerplatformerrorexception = new PlayerPlatformErrorException(s, s1, stateController.shouldUseDownloadFile());
        LOG.error(String.format("Media failed. code: %s, description: %s", new Object[] {
            s, s1
        }));
        if (playerplatformerrorexception.getMajorCode() != 0x19e13)
        {
            s = stateController.formatError(playerplatformerrorexception);
            if (s.isFailedOperationRetryable())
            {
                s = new ErrorState(stateController, s.getTitle(), s.getDescription(), new ResetPlayerState(stateController, this));
            } else
            {
                s = new ErrorState(stateController, s.getTitle(), s.getDescription());
            }
            stateController.transitionToState(s);
        }
    }

    public void onMediaOpened(String s, String s1, List list, List list1, long l, long l1, double d, boolean flag)
    {
    }

    public void onMediaProgress(long l, double d, long l1, long l2, int i)
    {
        if (!stateController.getMediaPlayer().isAdPlaying() && l >= 0L && (l > 0L || !stateController.hasPreroll()))
        {
            stateController.getVideoTrackController().onPlayerProgress(l, stateController.getMediaPlayer().getDuration());
        }
    }

    public void onMediaWarning(String s, String s1)
    {
        LOG.warn("Media warning. code: {}, description: {}", s, s1);
    }

    public void onNewVideoPlayOrResumeSelected(VideoBookmark videobookmark)
    {
    }

    public void onNewVideoPlayOrResumeSelected(VideoFacade videofacade, Watchable watchable)
    {
    }

    public void onNumberOfAlternativeAudioStreamsChanged(int i)
    {
    }

    public void onOfflineDRMComplete(String s, Date date, Date date1, String s1)
    {
    }

    public void onOfflineDRMFailure(String s, String s1)
    {
    }

    public void onPauseButton()
    {
    }

    public void onPinCanceled()
    {
    }

    public void onPlayButton()
    {
    }

    public void onPlayStateChanged(PlayerStatus playerstatus)
    {
    }

    public void onPlaybackSpeedChanged(double d)
    {
    }

    public void onPlayerSurfaceCreated(SurfaceHolder surfaceholder)
    {
    }

    public void onSAPButton()
    {
    }

    public void onScreenTouch()
    {
    }

    public void onSeekRequest(long l)
    {
    }

    public void onSeriesWatchableDetailSelected(SeriesWatchable serieswatchable)
    {
    }

    public void onTimelineUpdated()
    {
    }

    public void onUserMovedSeekBar(int i)
    {
    }

    public void onUserSeekEnded(boolean flag)
    {
    }

    public void onUserSeekStarted()
    {
    }

    public void onValidatePin(String s, com.comcast.cim.android.view.common.PinKeypadFragment.PinValidationCompletedListener pinvalidationcompletedlistener)
    {
    }

    public void onVideoFetchFailed()
    {
    }

    public void onVideoFetched(VideoFacade videofacade, Watchable watchable)
    {
    }

    public void onVideoSeekComplete()
    {
    }

    public void onVideoSeekStart()
    {
    }

    public void onVolumeChanged()
    {
    }

    public void run()
    {
    }

    public void transitionToState(VideoState videostate)
    {
        if (getStateName().equals(videostate.getStateName()))
        {
            LOG.debug("Attempted to change to the same state: {}, ignoring", getStateName());
            return;
        }
        if ((videostate instanceof BackgroundState) || (videostate instanceof ResetPlayerState) || (videostate instanceof ErrorState) || (videostate instanceof QuitState) || (videostate instanceof DestroyedState))
        {
            stateController.setState(videostate);
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Illegal State Change: From ").append(getStateName()).append(" to ").append(videostate.getStateName()).toString());
        }
    }

}
