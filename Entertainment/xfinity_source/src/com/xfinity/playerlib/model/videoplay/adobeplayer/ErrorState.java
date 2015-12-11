// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.SurfaceHolder;
import com.adobe.ave.drm.DRMManager;
import com.adobe.ave.drm.DRMMetadata;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.view.common.UpsellDialog;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            VideoState, VideoStateController, DestroyedState, QuitState

public class ErrorState
    implements VideoState
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState);
    private final String errorMessage;
    private final Throwable errorThrowable;
    private final String errorTitle;
    private BroadcastReceiver keyguardReciever;
    private final VideoState retryState;
    private final boolean shouldPresentUpsellDialog;
    private boolean shown;
    private final VideoStateController stateController;

    public ErrorState(VideoStateController videostatecontroller, String s)
    {
        shown = false;
        stateController = videostatecontroller;
        errorTitle = null;
        errorMessage = s;
        retryState = null;
        errorThrowable = null;
        shouldPresentUpsellDialog = false;
    }

    public ErrorState(VideoStateController videostatecontroller, String s, String s1)
    {
        shown = false;
        stateController = videostatecontroller;
        errorTitle = s;
        errorMessage = s1;
        retryState = null;
        errorThrowable = null;
        shouldPresentUpsellDialog = false;
    }

    public ErrorState(VideoStateController videostatecontroller, String s, String s1, VideoState videostate)
    {
        shown = false;
        stateController = videostatecontroller;
        errorTitle = s;
        errorMessage = s1;
        retryState = videostate;
        errorThrowable = null;
        shouldPresentUpsellDialog = false;
    }

    public ErrorState(VideoStateController videostatecontroller, Throwable throwable, VideoState videostate)
    {
        shown = false;
        stateController = videostatecontroller;
        errorTitle = null;
        errorMessage = null;
        retryState = videostate;
        errorThrowable = throwable;
        shouldPresentUpsellDialog = false;
    }

    private ErrorState(VideoStateController videostatecontroller, boolean flag, Throwable throwable)
    {
        shown = false;
        stateController = videostatecontroller;
        errorTitle = null;
        errorMessage = null;
        retryState = null;
        errorThrowable = throwable;
        shouldPresentUpsellDialog = flag;
    }

    private void addCancelListener(CALDialogFragment caldialogfragment)
    {
        caldialogfragment.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final ErrorState this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                stateController.transitionToState(new QuitState(stateController));
            }

            
            {
                this$0 = ErrorState.this;
                super();
            }
        });
    }

    public static ErrorState newUpsellErrorState(VideoStateController videostatecontroller, Exception exception)
    {
        return new ErrorState(videostatecontroller, true, exception);
    }

    private void showError()
    {
        Activity activity = stateController.getActivityContext();
        Bundle bundle = new Bundle();
        Object obj;
        if (shouldPresentUpsellDialog)
        {
            obj = UpsellDialog.newInstance(com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAY_FROM_PLAYER, stateController.getVideoFacade(), errorThrowable);
            ((CALDialogFragment) (obj)).setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

                final ErrorState this$0;

                public void onDismiss(DialogInterface dialoginterface)
                {
                    stateController.transitionToState(new QuitState(stateController));
                }

            
            {
                this$0 = ErrorState.this;
                super();
            }
            });
        } else
        if (errorThrowable == null)
        {
            if (retryState != null)
            {
                obj = CALDialogFragment.newInstance("errorDlgRetryable");
                ((CALDialogFragment) (obj)).setTryAgainListener(new com.comcast.cim.android.view.common.CALDialogFragment.TryAgainListener() {

                    final ErrorState this$0;

                    public void tryAgain()
                    {
                        stateController.transitionToState(retryState);
                    }

            
            {
                this$0 = ErrorState.this;
                super();
            }
                });
            } else
            {
                obj = CALDialogFragment.newInstance("errorDlg");
            }
            bundle.putString("description", errorMessage);
            if (errorTitle != null)
            {
                bundle.putString("title", errorTitle);
            }
            ((CALDialogFragment) (obj)).addArguments(bundle);
            addCancelListener(((CALDialogFragment) (obj)));
        } else
        {
            obj = stateController.getErrorDialogFactory();
            com.comcast.cim.android.view.common.errorformatter.FormattedError formattederror = stateController.formatError(errorThrowable);
            obj = ((ErrorDialogFactory) (obj)).createErrorDialogForThrowable(errorThrowable, formattederror, new com.comcast.cim.android.view.common.CALDialogFragment.TryAgainListener() {

                final ErrorState this$0;

                public void tryAgain()
                {
                    stateController.transitionToState(retryState);
                }

            
            {
                this$0 = ErrorState.this;
                super();
            }
            });
            addCancelListener(((CALDialogFragment) (obj)));
        }
        try
        {
            ((CALDialogFragment) (obj)).show(activity.getFragmentManager(), "caldialogfragment");
            shown = true;
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            return;
        }
    }

    private void unregisterKeyguardReceiver()
    {
        this;
        JVM INSTR monitorenter ;
        if (keyguardReciever != null)
        {
            stateController.getActivityContext().unregisterReceiver(keyguardReciever);
            keyguardReciever = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
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

    public String getStateName()
    {
        return "ErrorState";
    }

    public void onAMSContinueException(Exception exception)
    {
    }

    public void onAcquiringLicense(String s)
    {
    }

    public void onActivityPaused()
    {
    }

    public void onActivityResumed()
    {
label0:
        {
            if (!shown)
            {
                if (!((KeyguardManager)stateController.getActivityContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
                {
                    break label0;
                }
                unregisterKeyguardReceiver();
                keyguardReciever = new BroadcastReceiver() {

                    final ErrorState this$0;

                    public void onReceive(Context context, Intent intent)
                    {
                        if (!intent.getAction().equals("android.intent.action.USER_PRESENT"))
                        {
                            return;
                        } else
                        {
                            showError();
                            unregisterKeyguardReceiver();
                            return;
                        }
                    }

            
            {
                this$0 = ErrorState.this;
                super();
            }
                };
                stateController.getActivityContext().registerReceiver(keyguardReciever, new IntentFilter("android.intent.action.USER_PRESENT"));
            }
            return;
        }
        showError();
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
    }

    public void onMediaOpened(String s, String s1, List list, List list1, long l, long l1, double d, boolean flag)
    {
    }

    public void onMediaProgress(long l, double d, long l1, long l2, int i)
    {
    }

    public void onMediaWarning(String s, String s1)
    {
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
        showError();
    }

    public void transitionToState(VideoState videostate)
    {
        unregisterKeyguardReceiver();
        if ((videostate instanceof QuitState) || (videostate instanceof DestroyedState) || retryState.getClass().isAssignableFrom(videostate.getClass()))
        {
            stateController.setState(videostate);
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Illegal State Change: From ").append(getStateName()).append(" to ").append(videostate.getStateName()).toString());
        }
    }





}
