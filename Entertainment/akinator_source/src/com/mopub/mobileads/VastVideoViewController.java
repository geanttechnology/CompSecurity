// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.mopub.common.Preconditions;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.network.TrackingRequest;

// Referenced classes of package com.mopub.mobileads:
//            BaseVideoViewController, VastVideoConfig, VastVideoView, VastVideoViewProgressRunnable, 
//            VastVideoViewCountdownRunnable, VastVideoGradientStripWidget, VastVideoProgressBarWidget, VastVideoCloseButtonWidget, 
//            VastVideoCtaButtonWidget, VastVideoRadialCountdownWidget, VastCompanionAdConfig, VastWebView, 
//            VastIconConfig, VastErrorCode

public class VastVideoViewController extends BaseVideoViewController
{

    static final String CURRENT_POSITION = "current_position";
    static final int DEFAULT_VIDEO_DURATION_FOR_CLOSE_BUTTON = 5000;
    static final int MAX_VIDEO_DURATION_FOR_CLOSE_BUTTON = 16000;
    private static final int MOPUB_BROWSER_REQUEST_CODE = 1;
    static final String RESUMED_VAST_CONFIG = "resumed_vast_config";
    private static final int SEEKER_POSITION_NOT_INITIALIZED = -1;
    static final String VAST_VIDEO_CONFIG = "vast_video_config";
    private static final long VIDEO_COUNTDOWN_UPDATE_INTERVAL = 250L;
    private static final long VIDEO_PROGRESS_TIMER_CHECKER_DELAY = 50L;
    public static final int WEBVIEW_PADDING = 16;
    private ImageView mBlurredLastVideoFrameImageView;
    private VastVideoGradientStripWidget mBottomGradientStripWidget;
    private final android.view.View.OnTouchListener mClickThroughListener;
    private VastVideoCloseButtonWidget mCloseButtonWidget;
    private final VastVideoViewCountdownRunnable mCountdownRunnable;
    private VastVideoCtaButtonWidget mCtaButtonWidget;
    private int mDuration;
    private boolean mHasSkipOffset;
    private final View mIconView;
    private boolean mIsCalibrationDone;
    private boolean mIsClosing;
    private boolean mIsVideoFinishedPlaying;
    private final View mLandscapeCompanionAdView;
    private final View mPortraitCompanionAdView;
    private VastVideoProgressBarWidget mProgressBarWidget;
    private final VastVideoViewProgressRunnable mProgressCheckerRunnable;
    private VastVideoRadialCountdownWidget mRadialCountdownWidget;
    private int mSeekerPositionOnPause;
    private int mShowCloseButtonDelay;
    private boolean mShowCloseButtonEventFired;
    private VastVideoGradientStripWidget mTopGradientStripWidget;
    private VastCompanionAdConfig mVastCompanionAdConfig;
    private final VastIconConfig mVastIconConfig;
    private final VastVideoConfig mVastVideoConfig;
    private boolean mVideoError;
    private final VastVideoView mVideoView;

    VastVideoViewController(final Activity activity, Bundle bundle, Bundle bundle1, long l, BaseVideoViewController.BaseVideoViewControllerListener basevideoviewcontrollerlistener)
        throws IllegalStateException
    {
        super(activity, Long.valueOf(l), basevideoviewcontrollerlistener);
        mShowCloseButtonDelay = 5000;
        mHasSkipOffset = false;
        mIsCalibrationDone = false;
        mIsClosing = false;
        mSeekerPositionOnPause = -1;
        basevideoviewcontrollerlistener = null;
        if (bundle1 != null)
        {
            basevideoviewcontrollerlistener = bundle1.getSerializable("resumed_vast_config");
        }
        bundle = bundle.getSerializable("vast_video_config");
        if (basevideoviewcontrollerlistener != null && (basevideoviewcontrollerlistener instanceof VastVideoConfig))
        {
            mVastVideoConfig = (VastVideoConfig)basevideoviewcontrollerlistener;
            mSeekerPositionOnPause = bundle1.getInt("current_position", -1);
        } else
        if (bundle != null && (bundle instanceof VastVideoConfig))
        {
            mVastVideoConfig = (VastVideoConfig)bundle;
        } else
        {
            throw new IllegalStateException("VastVideoConfig is invalid");
        }
        if (mVastVideoConfig.getDiskMediaFileUrl() == null)
        {
            throw new IllegalStateException("VastVideoConfig does not have a video disk path");
        } else
        {
            mVastCompanionAdConfig = mVastVideoConfig.getVastCompanionAd(activity.getResources().getConfiguration().orientation);
            mVastIconConfig = mVastVideoConfig.getVastIconConfig();
            mClickThroughListener = new android.view.View.OnTouchListener() {

                final VastVideoViewController this$0;
                final Activity val$activity;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    if (motionevent.getAction() == 1 && shouldAllowClickThrough())
                    {
                        mIsClosing = true;
                        broadcastAction("com.mopub.action.interstitial.click");
                        view = mVastVideoConfig;
                        motionevent = activity;
                        int i;
                        if (mIsVideoFinishedPlaying)
                        {
                            i = mDuration;
                        } else
                        {
                            i = getCurrentPosition();
                        }
                        view.handleClick(motionevent, i, 1);
                    }
                    return true;
                }

            
            {
                this$0 = VastVideoViewController.this;
                activity = activity1;
                super();
            }
            };
            getLayout().setBackgroundColor(0xff000000);
            mVideoView = createVideoView(activity, 0);
            mVideoView.requestFocus();
            mLandscapeCompanionAdView = createCompanionAdView(activity, mVastVideoConfig.getVastCompanionAd(2), 4);
            mPortraitCompanionAdView = createCompanionAdView(activity, mVastVideoConfig.getVastCompanionAd(1), 4);
            addTopGradientStripWidget(activity);
            addProgressBarWidget(activity, 4);
            addBottomGradientStripWidget(activity);
            addRadialCountdownWidget(activity, 4);
            mIconView = createIconView(activity, mVastIconConfig, 4);
            addBlurredLastVideoFrameImageView(activity, 4);
            addCtaButtonWidget(activity);
            addCloseButtonWidget(activity, 8);
            activity = new Handler(Looper.getMainLooper());
            mProgressCheckerRunnable = new VastVideoViewProgressRunnable(this, mVastVideoConfig, activity);
            mCountdownRunnable = new VastVideoViewCountdownRunnable(this, activity);
            return;
        }
    }

    private void addBlurredLastVideoFrameImageView(Context context, int i)
    {
        mBlurredLastVideoFrameImageView = new ImageView(context);
        mBlurredLastVideoFrameImageView.setVisibility(i);
        context = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        getLayout().addView(mBlurredLastVideoFrameImageView, context);
    }

    private void addBottomGradientStripWidget(Context context)
    {
        boolean flag;
        if (mVastCompanionAdConfig != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mBottomGradientStripWidget = new VastVideoGradientStripWidget(context, android.graphics.drawable.GradientDrawable.Orientation.BOTTOM_TOP, mVastVideoConfig.getCustomForceOrientation(), flag, 8, 2, mProgressBarWidget.getId());
        getLayout().addView(mBottomGradientStripWidget);
    }

    private void addCloseButtonWidget(Context context, int i)
    {
        mCloseButtonWidget = new VastVideoCloseButtonWidget(context);
        mCloseButtonWidget.setVisibility(i);
        getLayout().addView(mCloseButtonWidget);
        context = new android.view.View.OnTouchListener() {

            final VastVideoViewController this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                int j;
                if (mIsVideoFinishedPlaying)
                {
                    j = mDuration;
                } else
                {
                    j = getCurrentPosition();
                }
                if (motionevent.getAction() == 1)
                {
                    mIsClosing = true;
                    mVastVideoConfig.handleClose(getContext(), j);
                    getBaseVideoViewControllerListener().onFinish();
                }
                return true;
            }

            
            {
                this$0 = VastVideoViewController.this;
                super();
            }
        };
        mCloseButtonWidget.setOnTouchListenerToContent(context);
        context = mVastVideoConfig.getCustomSkipText();
        if (context != null)
        {
            mCloseButtonWidget.updateCloseButtonText(context);
        }
        context = mVastVideoConfig.getCustomCloseIconUrl();
        if (context != null)
        {
            mCloseButtonWidget.updateCloseButtonIcon(context);
        }
    }

    private void addCtaButtonWidget(Context context)
    {
        boolean flag;
        boolean flag1;
        if (mVastCompanionAdConfig != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!TextUtils.isEmpty(mVastVideoConfig.getClickThroughUrl()))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        mCtaButtonWidget = new VastVideoCtaButtonWidget(context, mVideoView.getId(), flag, flag1);
        getLayout().addView(mCtaButtonWidget);
        mCtaButtonWidget.setOnTouchListener(mClickThroughListener);
        context = mVastVideoConfig.getCustomCtaText();
        if (context != null)
        {
            mCtaButtonWidget.updateCtaText(context);
        }
    }

    private void addProgressBarWidget(Context context, int i)
    {
        mProgressBarWidget = new VastVideoProgressBarWidget(context, mVideoView.getId());
        mProgressBarWidget.setVisibility(i);
        getLayout().addView(mProgressBarWidget);
    }

    private void addRadialCountdownWidget(Context context, int i)
    {
        mRadialCountdownWidget = new VastVideoRadialCountdownWidget(context);
        mRadialCountdownWidget.setVisibility(i);
        getLayout().addView(mRadialCountdownWidget);
    }

    private void addTopGradientStripWidget(Context context)
    {
        boolean flag;
        if (mVastCompanionAdConfig != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mTopGradientStripWidget = new VastVideoGradientStripWidget(context, android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, mVastVideoConfig.getCustomForceOrientation(), flag, 0, 6, getLayout().getId());
        getLayout().addView(mTopGradientStripWidget);
    }

    private void adjustSkipOffset()
    {
        int i = getDuration();
        if (i < 16000)
        {
            mShowCloseButtonDelay = i;
        }
        Integer integer = mVastVideoConfig.getSkipOffsetMillis(i);
        if (integer != null)
        {
            mShowCloseButtonDelay = integer.intValue();
            mHasSkipOffset = true;
        }
    }

    private VastVideoView createVideoView(final Context context, int i)
    {
        if (mVastVideoConfig.getDiskMediaFileUrl() == null)
        {
            throw new IllegalStateException("VastVideoConfig does not have a video disk path");
        } else
        {
            final VastVideoView videoView = new VastVideoView(context);
            videoView.setId((int)Utils.generateUniqueId());
            videoView.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() {

                final VastVideoViewController this$0;
                final VastVideoView val$videoView;

                public void onPrepared(MediaPlayer mediaplayer)
                {
                    mDuration = mVideoView.getDuration();
                    adjustSkipOffset();
                    if (mVastCompanionAdConfig == null)
                    {
                        videoView.prepareBlurredLastVideoFrame(mBlurredLastVideoFrameImageView, mVastVideoConfig.getDiskMediaFileUrl());
                    }
                    mProgressBarWidget.calibrateAndMakeVisible(getDuration(), mShowCloseButtonDelay);
                    mRadialCountdownWidget.calibrateAndMakeVisible(mShowCloseButtonDelay);
                    mIsCalibrationDone = true;
                }

            
            {
                this$0 = VastVideoViewController.this;
                videoView = vastvideoview;
                super();
            }
            });
            videoView.setOnTouchListener(mClickThroughListener);
            videoView.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

                final VastVideoViewController this$0;
                final Context val$context;
                final VastVideoView val$videoView;

                public void onCompletion(MediaPlayer mediaplayer)
                {
                    stopRunnables();
                    makeVideoInteractable();
                    videoCompleted(false);
                    mIsVideoFinishedPlaying = true;
                    if (!mVideoError && mVastVideoConfig.getRemainingProgressTrackerCount() == 0)
                    {
                        mVastVideoConfig.handleComplete(getContext(), getCurrentPosition());
                    }
                    videoView.setVisibility(4);
                    mProgressBarWidget.setVisibility(8);
                    mIconView.setVisibility(8);
                    mTopGradientStripWidget.notifyVideoComplete();
                    mBottomGradientStripWidget.notifyVideoComplete();
                    mCtaButtonWidget.notifyVideoComplete();
                    if (mVastCompanionAdConfig != null)
                    {
                        if (context.getResources().getConfiguration().orientation == 1)
                        {
                            mPortraitCompanionAdView.setVisibility(0);
                        } else
                        {
                            mLandscapeCompanionAdView.setVisibility(0);
                        }
                        mVastCompanionAdConfig.handleImpression(context, mDuration);
                    } else
                    if (mBlurredLastVideoFrameImageView.getDrawable() != null)
                    {
                        mBlurredLastVideoFrameImageView.setVisibility(0);
                        return;
                    }
                }

            
            {
                this$0 = VastVideoViewController.this;
                videoView = vastvideoview;
                context = context1;
                super();
            }
            });
            videoView.setOnErrorListener(new android.media.MediaPlayer.OnErrorListener() {

                final VastVideoViewController this$0;
                final VastVideoView val$videoView;

                public boolean onError(MediaPlayer mediaplayer, int j, int k)
                {
                    if (videoView.retryMediaPlayer(mediaplayer, j, k, mVastVideoConfig.getDiskMediaFileUrl()))
                    {
                        return true;
                    } else
                    {
                        stopRunnables();
                        makeVideoInteractable();
                        videoError(false);
                        mVideoError = true;
                        mVastVideoConfig.handleError(getContext(), VastErrorCode.GENERAL_LINEAR_AD_ERROR, getCurrentPosition());
                        return false;
                    }
                }

            
            {
                this$0 = VastVideoViewController.this;
                videoView = vastvideoview;
                super();
            }
            });
            videoView.setVideoPath(mVastVideoConfig.getDiskMediaFileUrl());
            videoView.setVisibility(i);
            return videoView;
        }
    }

    private boolean shouldAllowClickThrough()
    {
        return mShowCloseButtonEventFired;
    }

    private void startRunnables()
    {
        mProgressCheckerRunnable.startRepeating(50L);
        mCountdownRunnable.startRepeating(250L);
    }

    private void stopRunnables()
    {
        mProgressCheckerRunnable.stop();
        mCountdownRunnable.stop();
    }

    public boolean backButtonEnabled()
    {
        return mShowCloseButtonEventFired;
    }

    View createCompanionAdView(final Context context, final VastCompanionAdConfig vastCompanionAdConfig, int i)
    {
        Preconditions.checkNotNull(context);
        if (vastCompanionAdConfig == null)
        {
            context = new View(context);
            context.setVisibility(4);
            return context;
        } else
        {
            RelativeLayout relativelayout = new RelativeLayout(context);
            relativelayout.setGravity(17);
            Object obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            getLayout().addView(relativelayout, ((android.view.ViewGroup.LayoutParams) (obj)));
            obj = VastWebView.createView(context, vastCompanionAdConfig.getVastResource());
            ((VastWebView) (obj)).setVastWebViewClickListener(new VastWebView.VastWebViewClickListener() {

                final VastVideoViewController this$0;
                final Context val$context;
                final VastCompanionAdConfig val$vastCompanionAdConfig;

                public void onVastWebViewClick()
                {
                    broadcastAction("com.mopub.action.interstitial.click");
                    TrackingRequest.makeVastTrackingHttpRequest(vastCompanionAdConfig.getClickTrackers(), null, Integer.valueOf(mDuration), null, context);
                    vastCompanionAdConfig.handleClick(context, 1, null);
                }

            
            {
                this$0 = VastVideoViewController.this;
                vastCompanionAdConfig = vastcompanionadconfig;
                context = context1;
                super();
            }
            });
            ((VastWebView) (obj)).setWebViewClient(new WebViewClient() {

                final VastVideoViewController this$0;
                final Context val$context;
                final VastCompanionAdConfig val$vastCompanionAdConfig;

                public boolean shouldOverrideUrlLoading(WebView webview, String s)
                {
                    vastCompanionAdConfig.handleClick(context, 1, s);
                    return true;
                }

            
            {
                this$0 = VastVideoViewController.this;
                vastCompanionAdConfig = vastcompanionadconfig;
                context = context1;
                super();
            }
            });
            ((VastWebView) (obj)).setVisibility(i);
            context = new android.widget.RelativeLayout.LayoutParams(Dips.dipsToIntPixels(vastCompanionAdConfig.getWidth() + 16, context), Dips.dipsToIntPixels(vastCompanionAdConfig.getHeight() + 16, context));
            context.addRule(13, -1);
            relativelayout.addView(((View) (obj)), context);
            return ((View) (obj));
        }
    }

    View createIconView(final Context context, final VastIconConfig vastIconConfig, int i)
    {
        Preconditions.checkNotNull(context);
        if (vastIconConfig == null)
        {
            return new View(context);
        } else
        {
            VastWebView vastwebview = VastWebView.createView(context, vastIconConfig.getVastResource());
            vastwebview.setVastWebViewClickListener(new VastWebView.VastWebViewClickListener() {

                final VastVideoViewController this$0;
                final Context val$context;
                final VastIconConfig val$vastIconConfig;

                public void onVastWebViewClick()
                {
                    TrackingRequest.makeVastTrackingHttpRequest(vastIconConfig.getClickTrackingUris(), null, Integer.valueOf(getCurrentPosition()), getNetworkMediaFileUrl(), context);
                    vastIconConfig.handleClick(getContext(), null);
                }

            
            {
                this$0 = VastVideoViewController.this;
                vastIconConfig = vasticonconfig;
                context = context1;
                super();
            }
            });
            vastwebview.setWebViewClient(new WebViewClient() {

                final VastVideoViewController this$0;
                final VastIconConfig val$vastIconConfig;

                public boolean shouldOverrideUrlLoading(WebView webview, String s)
                {
                    vastIconConfig.handleClick(getContext(), s);
                    return true;
                }

            
            {
                this$0 = VastVideoViewController.this;
                vastIconConfig = vasticonconfig;
                super();
            }
            });
            vastwebview.setVisibility(i);
            context = new android.widget.RelativeLayout.LayoutParams(Dips.asIntPixels(vastIconConfig.getWidth() + 16, context), Dips.asIntPixels(vastIconConfig.getHeight() + 16, context));
            context.addRule(9);
            context.addRule(10);
            getLayout().addView(vastwebview, context);
            return vastwebview;
        }
    }

    ImageView getBlurredLastVideoFrameImageView()
    {
        return mBlurredLastVideoFrameImageView;
    }

    VastVideoGradientStripWidget getBottomGradientStripWidget()
    {
        return mBottomGradientStripWidget;
    }

    VastVideoCloseButtonWidget getCloseButtonWidget()
    {
        return mCloseButtonWidget;
    }

    VastVideoViewCountdownRunnable getCountdownRunnable()
    {
        return mCountdownRunnable;
    }

    VastVideoCtaButtonWidget getCtaButtonWidget()
    {
        return mCtaButtonWidget;
    }

    int getCurrentPosition()
    {
        return mVideoView.getCurrentPosition();
    }

    int getDuration()
    {
        return mVideoView.getDuration();
    }

    boolean getHasSkipOffset()
    {
        return mHasSkipOffset;
    }

    View getIconView()
    {
        return mIconView;
    }

    View getLandscapeCompanionAdView()
    {
        return mLandscapeCompanionAdView;
    }

    String getNetworkMediaFileUrl()
    {
        if (mVastVideoConfig == null)
        {
            return null;
        } else
        {
            return mVastVideoConfig.getNetworkMediaFileUrl();
        }
    }

    View getPortraitCompanionAdView()
    {
        return mPortraitCompanionAdView;
    }

    VastVideoProgressBarWidget getProgressBarWidget()
    {
        return mProgressBarWidget;
    }

    VastVideoViewProgressRunnable getProgressCheckerRunnable()
    {
        return mProgressCheckerRunnable;
    }

    VastVideoRadialCountdownWidget getRadialCountdownWidget()
    {
        return mRadialCountdownWidget;
    }

    int getShowCloseButtonDelay()
    {
        return mShowCloseButtonDelay;
    }

    VastVideoGradientStripWidget getTopGradientStripWidget()
    {
        return mTopGradientStripWidget;
    }

    VastVideoView getVastVideoView()
    {
        return mVideoView;
    }

    boolean getVideoError()
    {
        return mVideoError;
    }

    protected VideoView getVideoView()
    {
        return mVideoView;
    }

    void handleIconDisplay(int i)
    {
        if (mVastIconConfig != null && i >= mVastIconConfig.getOffsetMS())
        {
            mIconView.setVisibility(0);
            mVastIconConfig.handleImpression(getContext(), i, getNetworkMediaFileUrl());
            if (mVastIconConfig.getDurationMS() != null && i >= mVastIconConfig.getOffsetMS() + mVastIconConfig.getDurationMS().intValue())
            {
                mIconView.setVisibility(8);
                return;
            }
        }
    }

    boolean isCalibrationDone()
    {
        return mIsCalibrationDone;
    }

    boolean isShowCloseButtonEventFired()
    {
        return mShowCloseButtonEventFired;
    }

    boolean isVideoFinishedPlaying()
    {
        return mIsVideoFinishedPlaying;
    }

    void makeVideoInteractable()
    {
        mShowCloseButtonEventFired = true;
        mRadialCountdownWidget.setVisibility(8);
        mCloseButtonWidget.setVisibility(0);
        mCtaButtonWidget.notifyVideoSkippable();
    }

    void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 1 && j == -1)
        {
            getBaseVideoViewControllerListener().onFinish();
        }
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        int i = getContext().getResources().getConfiguration().orientation;
        mVastCompanionAdConfig = mVastVideoConfig.getVastCompanionAd(i);
        if (mLandscapeCompanionAdView.getVisibility() == 0 || mPortraitCompanionAdView.getVisibility() == 0)
        {
            if (i == 1)
            {
                mLandscapeCompanionAdView.setVisibility(4);
                mPortraitCompanionAdView.setVisibility(0);
            } else
            {
                mPortraitCompanionAdView.setVisibility(4);
                mLandscapeCompanionAdView.setVisibility(0);
            }
            if (mVastCompanionAdConfig != null)
            {
                mVastCompanionAdConfig.handleImpression(getContext(), mDuration);
            }
        }
    }

    protected void onCreate()
    {
        super.onCreate();
        static class _cls10
        {

            static final int $SwitchMap$com$mopub$common$util$DeviceUtils$ForceOrientation[];

            static 
            {
                $SwitchMap$com$mopub$common$util$DeviceUtils$ForceOrientation = new int[com.mopub.common.util.DeviceUtils.ForceOrientation.values().length];
                try
                {
                    $SwitchMap$com$mopub$common$util$DeviceUtils$ForceOrientation[com.mopub.common.util.DeviceUtils.ForceOrientation.FORCE_PORTRAIT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$mopub$common$util$DeviceUtils$ForceOrientation[com.mopub.common.util.DeviceUtils.ForceOrientation.FORCE_LANDSCAPE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$mopub$common$util$DeviceUtils$ForceOrientation[com.mopub.common.util.DeviceUtils.ForceOrientation.DEVICE_ORIENTATION.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$mopub$common$util$DeviceUtils$ForceOrientation[com.mopub.common.util.DeviceUtils.ForceOrientation.UNDEFINED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls10..SwitchMap.com.mopub.common.util.DeviceUtils.ForceOrientation[mVastVideoConfig.getCustomForceOrientation().ordinal()];
        JVM INSTR tableswitch 1 4: default 48
    //                   1 71
    //                   2 84
    //                   3 48
    //                   4 48;
           goto _L1 _L2 _L3 _L1 _L1
_L1:
        mVastVideoConfig.handleImpression(getContext(), getCurrentPosition());
        broadcastAction("com.mopub.action.interstitial.show");
        return;
_L2:
        getBaseVideoViewControllerListener().onSetRequestedOrientation(1);
        continue; /* Loop/switch isn't completed */
_L3:
        getBaseVideoViewControllerListener().onSetRequestedOrientation(0);
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onDestroy()
    {
        stopRunnables();
        broadcastAction("com.mopub.action.interstitial.dismiss");
        mVideoView.onDestroy();
    }

    protected void onPause()
    {
        stopRunnables();
        mSeekerPositionOnPause = getCurrentPosition();
        mVideoView.pause();
        if (!mIsVideoFinishedPlaying && !mIsClosing)
        {
            mVastVideoConfig.handlePause(getContext(), mSeekerPositionOnPause);
        }
    }

    protected void onResume()
    {
        startRunnables();
        if (mSeekerPositionOnPause > 0)
        {
            mVideoView.seekTo(mSeekerPositionOnPause);
        }
        if (!mIsVideoFinishedPlaying)
        {
            mVideoView.start();
        }
        if (mSeekerPositionOnPause != -1)
        {
            mVastVideoConfig.handleResume(getContext(), mSeekerPositionOnPause);
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("current_position", mSeekerPositionOnPause);
        bundle.putSerializable("resumed_vast_config", mVastVideoConfig);
    }

    void setCloseButtonVisible(boolean flag)
    {
        mShowCloseButtonEventFired = flag;
    }

    void setIsClosing(boolean flag)
    {
        mIsClosing = flag;
    }

    void setProgressBarWidget(VastVideoProgressBarWidget vastvideoprogressbarwidget)
    {
        mProgressBarWidget = vastvideoprogressbarwidget;
    }

    void setRadialCountdownWidget(VastVideoRadialCountdownWidget vastvideoradialcountdownwidget)
    {
        mRadialCountdownWidget = vastvideoradialcountdownwidget;
    }

    void setVideoError()
    {
        mVideoError = true;
    }

    boolean shouldBeInteractable()
    {
        return !mShowCloseButtonEventFired && getCurrentPosition() >= mShowCloseButtonDelay;
    }

    void updateCountdown()
    {
        if (mIsCalibrationDone)
        {
            mRadialCountdownWidget.updateCountdownProgress(mShowCloseButtonDelay, getCurrentPosition());
        }
    }

    void updateProgressBar()
    {
        mProgressBarWidget.updateProgress(getCurrentPosition());
    }




/*
    static boolean access$102(VastVideoViewController vastvideoviewcontroller, boolean flag)
    {
        vastvideoviewcontroller.mIsClosing = flag;
        return flag;
    }

*/



/*
    static boolean access$1202(VastVideoViewController vastvideoviewcontroller, boolean flag)
    {
        vastvideoviewcontroller.mIsCalibrationDone = flag;
        return flag;
    }

*/




/*
    static boolean access$1402(VastVideoViewController vastvideoviewcontroller, boolean flag)
    {
        vastvideoviewcontroller.mVideoError = flag;
        return flag;
    }

*/









/*
    static boolean access$202(VastVideoViewController vastvideoviewcontroller, boolean flag)
    {
        vastvideoviewcontroller.mIsVideoFinishedPlaying = flag;
        return flag;
    }

*/



/*
    static int access$302(VastVideoViewController vastvideoviewcontroller, int i)
    {
        vastvideoviewcontroller.mDuration = i;
        return i;
    }

*/






}
