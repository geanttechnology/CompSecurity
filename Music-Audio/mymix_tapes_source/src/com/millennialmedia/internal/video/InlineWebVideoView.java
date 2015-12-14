// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.animation.Animator;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.MMActivity;
import com.millennialmedia.internal.MMWebView;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.ViewUtils;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.internal.video:
//            MMVideoView

public class InlineWebVideoView extends RelativeLayout
    implements MMVideoView.MMVideoViewListener
{
    public class InlineVideoControls extends RelativeLayout
        implements MMVideoView.MediaController
    {

        private ToggleButton muteUnmuteButton;
        private ToggleButton playPauseButton;
        private ProgressBar progressBar;
        final InlineWebVideoView this$0;

        public void mute()
        {
            ThreadUtils.runOnUiThread(new Runnable() {

                final InlineVideoControls this$1;

                public void run()
                {
                    muteUnmuteButton.setChecked(true);
                }

            
            {
                this$1 = InlineVideoControls.this;
                super();
            }
            });
        }

        public void onComplete()
        {
            progressBar.setProgress(progressBar.getMax());
            pause();
        }

        public void onMuted()
        {
        }

        public void onPause()
        {
        }

        public void onProgress(int i)
        {
            ThreadUtils.runOnUiThread(i. new Runnable() {

                final InlineVideoControls this$1;
                final int val$milliseconds;

                public void run()
                {
                    progressBar.setProgress(milliseconds);
                }

            
            {
                this$1 = final_inlinevideocontrols;
                milliseconds = I.this;
                super();
            }
            });
        }

        public void onStart()
        {
        }

        public void onUnmuted()
        {
        }

        public void pause()
        {
            ThreadUtils.runOnUiThread(new Runnable() {

                final InlineVideoControls this$1;

                public void run()
                {
                    playPauseButton.setChecked(false);
                }

            
            {
                this$1 = InlineVideoControls.this;
                super();
            }
            });
        }

        void resize(boolean flag)
        {
            Rect rect = getButtonDimensions(flag);
            android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)muteUnmuteButton.getLayoutParams();
            layoutparams.width = rect.width();
            layoutparams.height = rect.height();
            muteUnmuteButton.setLayoutParams(layoutparams);
            layoutparams = (android.widget.RelativeLayout.LayoutParams)playPauseButton.getLayoutParams();
            layoutparams.width = rect.width();
            layoutparams.height = rect.height();
            playPauseButton.setLayoutParams(layoutparams);
            layoutparams = (android.widget.RelativeLayout.LayoutParams)progressBar.getLayoutParams();
            layoutparams.height = rect.height() / 2;
            progressBar.setLayoutParams(layoutparams);
        }

        public void setDuration(int i)
        {
            ThreadUtils.runOnUiThread(i. new Runnable() {

                final InlineVideoControls this$1;
                final int val$milliseconds;

                public void run()
                {
                    progressBar.setProgress(0);
                    progressBar.setMax(milliseconds);
                }

            
            {
                this$1 = final_inlinevideocontrols;
                milliseconds = I.this;
                super();
            }
            });
        }

        public void start()
        {
            ThreadUtils.runOnUiThread(new Runnable() {

                final InlineVideoControls this$1;

                public void run()
                {
                    playPauseButton.setChecked(true);
                }

            
            {
                this$1 = InlineVideoControls.this;
                super();
            }
            });
        }

        public void unmute()
        {
            ThreadUtils.runOnUiThread(new Runnable() {

                final InlineVideoControls this$1;

                public void run()
                {
                    muteUnmuteButton.setChecked(false);
                }

            
            {
                this$1 = InlineVideoControls.this;
                super();
            }
            });
        }




        public InlineVideoControls(Context context, MMVideoView mmvideoview, boolean flag, boolean flag1)
        {
            this.this$0 = InlineWebVideoView.this;
            super(context);
            setBackgroundColor(getResources().getColor(com.millennialmedia.R.color.mmadsdk_inline_video_controls_background));
            setOnClickListener(new _cls1());
            playPauseButton = new ToggleButton(context);
            playPauseButton.setId(com.millennialmedia.R.id.mmadsdk_inline_video_play_pause_button);
            playPauseButton.setTextOn("");
            playPauseButton.setTextOff("");
            playPauseButton.setChecked(flag);
            playPauseButton.setBackgroundDrawable(getResources().getDrawable(com.millennialmedia.R.drawable.mmadsdk_play_pause));
            playPauseButton.setOnClickListener(new _cls2());
            playPauseButton.setOnCheckedChangeListener(mmvideoview. new _cls3());
            Rect rect = getButtonDimensions(false);
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(rect.width(), rect.height());
            layoutparams.addRule(9);
            addView(playPauseButton, layoutparams);
            muteUnmuteButton = new ToggleButton(context);
            muteUnmuteButton.setId(com.millennialmedia.R.id.mmadsdk_inline_video_mute_unmute_button);
            muteUnmuteButton.setTextOn("");
            muteUnmuteButton.setTextOff("");
            muteUnmuteButton.setChecked(flag1);
            muteUnmuteButton.setBackgroundDrawable(getResources().getDrawable(com.millennialmedia.R.drawable.mmadsdk_mute_unmute));
            muteUnmuteButton.setOnClickListener(new _cls4());
            muteUnmuteButton.setOnCheckedChangeListener(mmvideoview. new _cls5());
            this$0 = new android.widget.RelativeLayout.LayoutParams(rect.width(), rect.height());
            addRule(11);
            addView(muteUnmuteButton, InlineWebVideoView.this);
            progressBar = new ProgressBar(context, null, 0x1010078);
            progressBar.setProgressDrawable(getResources().getDrawable(com.millennialmedia.R.drawable.mmadsdk_inline_video_progress_bar));
            this$0 = new android.widget.RelativeLayout.LayoutParams(-1, rect.height() / 2);
            addRule(1, com.millennialmedia.R.id.mmadsdk_inline_video_play_pause_button);
            addRule(0, com.millennialmedia.R.id.mmadsdk_inline_video_mute_unmute_button);
            addRule(15);
            addView(progressBar, InlineWebVideoView.this);
        }
    }

    public static interface InlineWebVideoViewAttachListener
    {

        public abstract void attachFailed(InlineWebVideoView inlinewebvideoview);

        public abstract void attachSucceeded(InlineWebVideoView inlinewebvideoview);
    }

    public static interface InlineWebVideoViewListener
    {

        public abstract void onClicked();
    }


    private static final String BASE_TAG = "MMInlineWebVideoView_";
    private static final int HIDE_CONTROLS_DELAY = 2500;
    public static final int PROGRESS_UPDATES_DISABLED = -1;
    private static final String TAG = com/millennialmedia/internal/video/InlineWebVideoView.getSimpleName();
    private static volatile int nextTagID = 100;
    private InlineWebVideoViewAttachListener attachListener;
    private String callbackId;
    private boolean endFired;
    private boolean error;
    private ToggleButton expandCollapseToggleButton;
    private int height;
    private com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable hideControlsRunnable;
    private InlineVideoControls inlineVideoControls;
    private InlineWebVideoViewListener inlineWebVideoViewListener;
    private long lastUpdateTime;
    private boolean midpointFired;
    private MMVideoView mmVideoView;
    private WeakReference mmWebViewRef;
    private ImageView placeholderView;
    private boolean q1Fired;
    private boolean q3Fired;
    private boolean showExpandControls;
    private boolean showMediaControls;
    private boolean startFired;
    private int timeUpdateInterval;
    private Uri uri;
    private FrameLayout videoContainer;
    private com.millennialmedia.internal.utils.ViewUtils.ViewabilityWatcher viewabilityWatcher;
    private int width;
    private int x;
    private int y;

    public InlineWebVideoView(Context context, boolean flag, boolean flag1, final boolean showMediaControls, final boolean showExpandControls, int i, String s, 
            InlineWebVideoViewListener inlinewebvideoviewlistener)
    {
        super(new MutableContextWrapper(context));
        timeUpdateInterval = -1;
        lastUpdateTime = 0L;
        error = false;
        startFired = false;
        q1Fired = false;
        midpointFired = false;
        q3Fired = false;
        endFired = false;
        inlineWebVideoViewListener = inlinewebvideoviewlistener;
        context = (MutableContextWrapper)getContext();
        callbackId = s;
        timeUpdateInterval = i;
        this.showMediaControls = showMediaControls;
        this.showExpandControls = showExpandControls;
        viewabilityWatcher = new com.millennialmedia.internal.utils.ViewUtils.ViewabilityWatcher(this, new com.millennialmedia.internal.utils.ViewUtils.ViewabilityListener() {

            private boolean didPause;
            final InlineWebVideoView this$0;

            public void onViewableChanged(boolean flag2)
            {
                if (flag2)
                {
                    if (didPause)
                    {
                        didPause = false;
                        inlineVideoControls.start();
                    }
                } else
                if (mmVideoView.isPlaying())
                {
                    didPause = true;
                    inlineVideoControls.pause();
                    return;
                }
            }

            
            {
                this$0 = InlineWebVideoView.this;
                super();
            }
        });
        viewabilityWatcher.startWatching();
        videoContainer = new FrameLayout(context);
        setBackgroundColor(0xff000000);
        mmVideoView = new MMVideoView(context, flag, flag1, this);
        s = new android.widget.FrameLayout.LayoutParams(-1, -2);
        s.gravity = 17;
        videoContainer.addView(mmVideoView, s);
        s = (new StringBuilder()).append("MMInlineWebVideoView_");
        i = nextTagID;
        nextTagID = i + 1;
        setTag(s.append(i).toString());
        s = new android.widget.FrameLayout.LayoutParams(-1, -1);
        placeholderView = new ImageView(context);
        placeholderView.setBackgroundColor(0xff000000);
        placeholderView.setLayoutParams(s);
        videoContainer.addView(placeholderView);
        s = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        addView(videoContainer, s);
        inlineVideoControls = new InlineVideoControls(context, mmVideoView, flag, flag1);
        s = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        s.addRule(12);
        if (!showMediaControls)
        {
            inlineVideoControls.setVisibility(8);
        }
        addView(inlineVideoControls, s);
        mmVideoView.setMediaController(inlineVideoControls);
        mmVideoView.setOnClickListener(new android.view.View.OnClickListener() {

            final InlineWebVideoView this$0;
            final boolean val$showExpandControls;
            final boolean val$showMediaControls;

            public void onClick(View view)
            {
                fireOnClick();
                view = (MMWebView)mmWebViewRef.get();
                if (view != null)
                {
                    view.invokeCallback(callbackId, new Object[] {
                        getTag(), "click"
                    });
                }
                if (showMediaControls)
                {
                    inlineVideoControls.setAlpha(1.0F);
                    inlineVideoControls.setVisibility(0);
                }
                if (showExpandControls)
                {
                    expandCollapseToggleButton.setAlpha(1.0F);
                    expandCollapseToggleButton.setVisibility(0);
                }
                if (showMediaControls || showExpandControls)
                {
                    scheduleAutoHideControls();
                }
            }

            
            {
                this$0 = InlineWebVideoView.this;
                showMediaControls = flag;
                showExpandControls = flag1;
                super();
            }
        });
        expandCollapseToggleButton = new ToggleButton(context);
        expandCollapseToggleButton.setTextOff("");
        expandCollapseToggleButton.setTextOn("");
        expandCollapseToggleButton.setChecked(false);
        expandCollapseToggleButton.setBackgroundDrawable(getResources().getDrawable(com.millennialmedia.R.drawable.mmadsdk_expand_collapse));
        expandCollapseToggleButton.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final InlineWebVideoView this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag2)
            {
                fireOnClick();
                if (flag2)
                {
                    internalExpandToFullScreen();
                }
            }

            
            {
                this$0 = InlineWebVideoView.this;
                super();
            }
        });
        if (!showExpandControls)
        {
            expandCollapseToggleButton.setVisibility(8);
        }
        context = getButtonDimensions(false);
        context = new android.widget.RelativeLayout.LayoutParams(context.width(), context.height());
        context.addRule(10);
        context.addRule(11);
        addView(expandCollapseToggleButton, context);
    }

    private void attachToAnchorView(MMWebView mmwebview)
    {
        if (getParent() == null)
        {
            ViewUtils.attachView(mmwebview, this, new android.widget.AbsoluteLayout.LayoutParams(width, height, x, y));
            attachListener.attachSucceeded(this);
        }
    }

    private void fireOnClick()
    {
        ThreadUtils.runOnWorkerThread(new Runnable() {

            final InlineWebVideoView this$0;

            public void run()
            {
                if (inlineWebVideoViewListener != null)
                {
                    inlineWebVideoViewListener.onClicked();
                }
            }

            
            {
                this$0 = InlineWebVideoView.this;
                super();
            }
        });
    }

    private Rect getButtonDimensions(boolean flag)
    {
        int i = getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_control_button_max_width_height);
        if (flag)
        {
            return new Rect(0, 0, i, i);
        } else
        {
            i = Math.max(getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_control_button_min_width_height), Math.min(i, height / 5));
            return new Rect(0, 0, i, i);
        }
    }

    private void internalExpandToFullScreen()
    {
        if (!error)
        {
            com.millennialmedia.internal.MMActivity.MMActivityConfig mmactivityconfig = new com.millennialmedia.internal.MMActivity.MMActivityConfig();
            MMActivity.launch(getContext(), mmactivityconfig, new com.millennialmedia.internal.MMActivity.MMActivityListener() {

                final InlineWebVideoView this$0;

                public void onCreate(MMActivity mmactivity)
                {
                    super.onCreate(mmactivity);
                    ViewUtils.removeFromParent(InlineWebVideoView.this);
                    android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                    expandCollapseToggleButton.setOnCheckedChangeListener(null);
                    expandCollapseToggleButton.setChecked(true);
                    expandCollapseToggleButton.setOnCheckedChangeListener(mmactivity. new android.widget.CompoundButton.OnCheckedChangeListener() {

                        final _cls5 this$1;
                        final MMActivity val$mmActivity;

                        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
                        {
                            if (!flag)
                            {
                                mmActivity.finish();
                            }
                        }

            
            {
                this$1 = final__pcls5;
                mmActivity = MMActivity.this;
                super();
            }
                    });
                    resizeButtons(true);
                    ViewUtils.attachView(mmactivity.getRootView(), InlineWebVideoView.this, layoutparams);
                    mmactivity = (MMWebView)mmWebViewRef.get();
                    if (mmactivity != null)
                    {
                        mmactivity.invokeCallback(callbackId, new Object[] {
                            getTag(), "expand"
                        });
                    }
                }

                public void onDestroy(MMActivity mmactivity)
                {
                    ViewUtils.removeFromParent(InlineWebVideoView.this);
                    android.widget.AbsoluteLayout.LayoutParams layoutparams = new android.widget.AbsoluteLayout.LayoutParams(width, height, x, y);
                    expandCollapseToggleButton.setOnCheckedChangeListener(null);
                    expandCollapseToggleButton.setChecked(false);
                    expandCollapseToggleButton.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

                        final _cls5 this$1;

                        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
                        {
                            if (flag)
                            {
                                internalExpandToFullScreen();
                            }
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                    resizeButtons(false);
                    MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
                    if (mmwebview != null)
                    {
                        ViewUtils.attachView(mmwebview, InlineWebVideoView.this, layoutparams);
                        mmwebview.invokeCallback(callbackId, new Object[] {
                            getTag(), "collapse"
                        });
                    }
                    super.onDestroy(mmactivity);
                }

                public void onPause(MMActivity mmactivity)
                {
                    super.onPause(mmactivity);
                }

                public void onResume(MMActivity mmactivity)
                {
                    super.onResume(mmactivity);
                }

            
            {
                this$0 = InlineWebVideoView.this;
                super();
            }
            });
        } else
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "InlineWebVideoView.expandToFullScreen could not complete because of a previous error.");
            return;
        }
    }

    private void resizeButtons(boolean flag)
    {
        inlineVideoControls.resize(flag);
        Rect rect = getButtonDimensions(flag);
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)expandCollapseToggleButton.getLayoutParams();
        layoutparams.width = rect.width();
        layoutparams.height = rect.height();
        expandCollapseToggleButton.setLayoutParams(layoutparams);
    }

    private void scheduleAutoHideControls()
    {
        if (showExpandControls || showMediaControls)
        {
            if (hideControlsRunnable != null)
            {
                hideControlsRunnable.cancel();
            }
            hideControlsRunnable = ThreadUtils.runOnUiThreadDelayed(new Runnable() {

                final InlineWebVideoView this$0;

                public void run()
                {
                    inlineVideoControls.animate().alpha(0.0F).setDuration(500L).setListener(new android.animation.Animator.AnimatorListener() {

                        final _cls10 this$1;

                        public void onAnimationCancel(Animator animator)
                        {
                        }

                        public void onAnimationEnd(Animator animator)
                        {
                            inlineVideoControls.setVisibility(8);
                        }

                        public void onAnimationRepeat(Animator animator)
                        {
                        }

                        public void onAnimationStart(Animator animator)
                        {
                        }

            
            {
                this$1 = _cls10.this;
                super();
            }
                    }).start();
                    expandCollapseToggleButton.animate().alpha(0.0F).setDuration(500L).setListener(new android.animation.Animator.AnimatorListener() {

                        final _cls10 this$1;

                        public void onAnimationCancel(Animator animator)
                        {
                        }

                        public void onAnimationEnd(Animator animator)
                        {
                            expandCollapseToggleButton.setVisibility(8);
                        }

                        public void onAnimationRepeat(Animator animator)
                        {
                        }

                        public void onAnimationStart(Animator animator)
                        {
                        }

            
            {
                this$1 = _cls10.this;
                super();
            }
                    }).start();
                }

            
            {
                this$0 = InlineWebVideoView.this;
                super();
            }
            }, 2500L);
        }
    }

    private int toDips(DisplayMetrics displaymetrics, int i)
    {
        return (int)Math.ceil((float)i / displaymetrics.density);
    }

    public void expandToFullScreen()
    {
        expandCollapseToggleButton.setChecked(true);
    }

    public void mute()
    {
        if (!error)
        {
            inlineVideoControls.mute();
        } else
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "InlineWebVideoView.mute could not complete because of a previous error.");
            return;
        }
    }

    public void onBufferingUpdate(MMVideoView mmvideoview, int i)
    {
    }

    public void onComplete(MMVideoView mmvideoview)
    {
        mmvideoview.seekTo(0);
        mmvideoview = (MMWebView)mmWebViewRef.get();
        if (mmvideoview == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (!endFired)
        {
            endFired = true;
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, (new StringBuilder()).append("InlineVideoView[").append(getTag()).append("]: firing end event").toString());
            }
            mmvideoview.invokeCallback(callbackId, new Object[] {
                getTag(), "timeUpdate", Integer.valueOf(mmVideoView.getDuration())
            });
            mmvideoview.invokeCallback(callbackId, new Object[] {
                getTag(), "tracking", "end"
            });
        }
        this;
        JVM INSTR monitorexit ;
        mmvideoview.invokeCallback(callbackId, new Object[] {
            getTag(), "stateChange", "complete"
        });
_L4:
        ThreadUtils.runOnUiThread(new Runnable() {

            final InlineWebVideoView this$0;

            public void run()
            {
                if (placeholderView.getParent() == null)
                {
                    videoContainer.addView(placeholderView);
                }
            }

            
            {
                this$0 = InlineWebVideoView.this;
                super();
            }
        });
        return;
        mmvideoview;
        this;
        JVM INSTR monitorexit ;
        throw mmvideoview;
_L2:
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "InlineVideoView anchor WebView is gone.  Tracking events disabled.");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onError(MMVideoView mmvideoview)
    {
        error = true;
        mmvideoview = (MMWebView)mmWebViewRef.get();
        if (mmvideoview != null)
        {
            mmvideoview.invokeCallback(callbackId, new Object[] {
                getTag(), "error", "Inline video play back failed."
            });
        }
        if (getParent() == null)
        {
            attachListener.attachFailed(this);
        }
    }

    public void onMuted(MMVideoView mmvideoview)
    {
        mmvideoview = (MMWebView)mmWebViewRef.get();
        if (mmvideoview != null)
        {
            mmvideoview.invokeCallback(callbackId, new Object[] {
                getTag(), "mute", Boolean.valueOf(true)
            });
        }
    }

    public void onPause(MMVideoView mmvideoview)
    {
        mmvideoview = (MMWebView)mmWebViewRef.get();
        if (mmvideoview != null)
        {
            mmvideoview.invokeCallback(callbackId, new Object[] {
                getTag(), "stateChange", "paused"
            });
        }
    }

    public void onPrepared(MMVideoView mmvideoview)
    {
        if (!error)
        {
            ThreadUtils.runOnUiThread(new Runnable() {

                final InlineWebVideoView this$0;

                public void run()
                {
label0:
                    {
                        MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
                        if (mmwebview != null)
                        {
                            mmwebview.invokeCallback(callbackId, new Object[] {
                                getTag(), "stateChange", "loading"
                            });
                            mmwebview.invokeCallback(callbackId, new Object[] {
                                getTag(), "updateVideoURL", uri.toString()
                            });
                            mmwebview.invokeCallback(callbackId, new Object[] {
                                getTag(), "durationChange", Integer.valueOf(mmVideoView.getDuration())
                            });
                            if (mmwebview.getWidth() - x < width || mmwebview.getHeight() - y < height)
                            {
                                break label0;
                            }
                            attachToAnchorView(mmwebview);
                        }
                        return;
                    }
                    MMLog.e(InlineWebVideoView.TAG, "Cannot attach the inline video; it will not fit within the anchor view.");
                }

            
            {
                this$0 = InlineWebVideoView.this;
                super();
            }
            });
        }
    }

    public void onProgress(MMVideoView mmvideoview, int i)
    {
        this;
        JVM INSTR monitorenter ;
        mmvideoview = (MMWebView)mmWebViewRef.get();
        if (mmvideoview == null) goto _L2; else goto _L1
_L1:
        int j = mmVideoView.getDuration() / 4;
        if (q1Fired || i < j)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("InlineVideoView[").append(getTag()).append("]: firing q1 event").toString());
        }
        q1Fired = true;
        mmvideoview.invokeCallback(callbackId, new Object[] {
            getTag(), "tracking", "q1"
        });
        if (midpointFired || i < j * 2)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("InlineVideoView[").append(getTag()).append("]: firing midpoint event").toString());
        }
        midpointFired = true;
        mmvideoview.invokeCallback(callbackId, new Object[] {
            getTag(), "tracking", "q2"
        });
        if (q3Fired || i < j * 3)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("InlineVideoView[").append(getTag()).append("]: firing q3 event").toString());
        }
        q3Fired = true;
        mmvideoview.invokeCallback(callbackId, new Object[] {
            getTag(), "tracking", "q3"
        });
        long l = System.currentTimeMillis();
        if (timeUpdateInterval != -1 && l - lastUpdateTime >= (long)timeUpdateInterval)
        {
            lastUpdateTime = l;
            mmvideoview.invokeCallback(callbackId, new Object[] {
                getTag(), "timeUpdate", Integer.valueOf(i)
            });
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "InlineVideoView anchor WebView is gone.  Tracking events disabled.");
        }
        if (true) goto _L4; else goto _L3
_L3:
        mmvideoview;
        throw mmvideoview;
    }

    public void onReadyToStart(MMVideoView mmvideoview)
    {
        mmvideoview = (MMWebView)mmWebViewRef.get();
        if (mmvideoview != null)
        {
            mmvideoview.invokeCallback(callbackId, new Object[] {
                getTag(), "stateChange", "readyToStart"
            });
            mmvideoview.invokeCallback(callbackId, new Object[] {
                getTag(), "updateVideoURL", uri.toString()
            });
            mmvideoview.invokeCallback(callbackId, new Object[] {
                getTag(), "durationChange", Integer.valueOf(mmVideoView.getDuration())
            });
        }
    }

    public void onSeek(MMVideoView mmvideoview)
    {
        mmvideoview = (MMWebView)mmWebViewRef.get();
        if (mmvideoview != null)
        {
            mmvideoview.invokeCallback(callbackId, new Object[] {
                getTag(), "seek", Integer.valueOf(mmVideoView.getCurrentPosition())
            });
        }
    }

    public void onStart(MMVideoView mmvideoview)
    {
        ThreadUtils.runOnUiThread(new Runnable() {

            final InlineWebVideoView this$0;

            public void run()
            {
                ViewUtils.removeFromParent(placeholderView);
            }

            
            {
                this$0 = InlineWebVideoView.this;
                super();
            }
        });
        scheduleAutoHideControls();
        mmvideoview = (MMWebView)mmWebViewRef.get();
        if (mmvideoview == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (!startFired)
        {
            startFired = true;
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, (new StringBuilder()).append("InlineWebVideoView[").append(getTag()).append("]: firing start event").toString());
            }
            mmvideoview.invokeCallback(callbackId, new Object[] {
                getTag(), "tracking", "start"
            });
        }
        this;
        JVM INSTR monitorexit ;
        mmvideoview.invokeCallback(callbackId, new Object[] {
            getTag(), "stateChange", "playing"
        });
_L4:
        return;
        mmvideoview;
        this;
        JVM INSTR monitorexit ;
        throw mmvideoview;
_L2:
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "InlineWebVideoView anchor WebView is gone.  Tracking events disabled.");
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onStop(MMVideoView mmvideoview)
    {
        ThreadUtils.runOnUiThread(new Runnable() {

            final InlineWebVideoView this$0;

            public void run()
            {
                if (placeholderView.getParent() == null)
                {
                    videoContainer.addView(placeholderView);
                }
            }

            
            {
                this$0 = InlineWebVideoView.this;
                super();
            }
        });
        mmvideoview = (MMWebView)mmWebViewRef.get();
        if (mmvideoview != null)
        {
            mmvideoview.invokeCallback(callbackId, new Object[] {
                getTag(), "stateChange", "stopped"
            });
        }
    }

    public void onUnmuted(MMVideoView mmvideoview)
    {
        mmvideoview = (MMWebView)mmWebViewRef.get();
        if (mmvideoview != null)
        {
            mmvideoview.invokeCallback(callbackId, new Object[] {
                getTag(), "mute", Boolean.valueOf(false)
            });
        }
    }

    public void pause()
    {
        if (!error)
        {
            inlineVideoControls.pause();
        } else
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "InlineWebVideoView.pause could not complete because of a previous error.");
            return;
        }
    }

    public void remove()
    {
        mmVideoView.stop();
        MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
        if (mmwebview != null)
        {
            mmwebview.invokeCallback(callbackId, new Object[] {
                getTag(), "stateChange", "removed"
            });
        }
        ViewUtils.removeFromParent(this);
    }

    public void reposition(int i, int j, int k, int l)
    {
        if (error) goto _L2; else goto _L1
_L1:
        if (i >= 0 && j >= 0 && k >= 0 && l >= 0) goto _L4; else goto _L3
_L3:
        MMLog.e(TAG, "All position parameters must be greater than or equal to zero.");
_L6:
        return;
_L4:
        if (mmWebViewRef != null)
        {
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview != null)
            {
                if (mmwebview.getWidth() - i >= k && mmwebview.getHeight() - j >= l)
                {
                    width = k;
                    height = l;
                    x = i;
                    y = j;
                    resizeButtons(false);
                    Object obj = new android.widget.AbsoluteLayout.LayoutParams(k, l, i, j);
                    ViewUtils.removeFromParent(this);
                    ViewUtils.attachView(mmwebview, this, ((android.view.ViewGroup.LayoutParams) (obj)));
                    obj = mmwebview.getResources().getDisplayMetrics();
                    mmwebview.invokeCallback(callbackId, new Object[] {
                        getTag(), "reposition", Integer.valueOf(toDips(((DisplayMetrics) (obj)), k)), Integer.valueOf(toDips(((DisplayMetrics) (obj)), l)), Integer.valueOf(toDips(((DisplayMetrics) (obj)), i)), Integer.valueOf(toDips(((DisplayMetrics) (obj)), j))
                    });
                    return;
                } else
                {
                    MMLog.e(TAG, "Cannot reposition the inline video as it will not fit within the anchor view.");
                    return;
                }
            } else
            {
                MMLog.w(TAG, "Cannot position the InlineVideoView because the anchor view is gone.");
                return;
            }
        } else
        {
            MMLog.w(TAG, "Cannot position the InlineVideoView because the anchor view has not been set.");
            return;
        }
_L2:
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "InlineWebVideoView.reposition could not complete because of a previous error.");
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void seekTo(int i)
    {
        if (!error)
        {
            mmVideoView.seekTo(i);
        } else
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "InlineWebVideoView.seekTo could not complete because of a previous error.");
            return;
        }
    }

    public void setAnchorView(MMWebView mmwebview, int i, int j, int k, int l, InlineWebVideoViewAttachListener inlinewebvideoviewattachlistener)
    {
        if (i < 0 || j < 0 || k < 0 || l < 0)
        {
            MMLog.e(TAG, "All position parameters must be greater than or equal to zero.");
            inlinewebvideoviewattachlistener.attachFailed(this);
        } else
        {
            mmWebViewRef = new WeakReference(mmwebview);
            attachListener = inlinewebvideoviewattachlistener;
            x = i;
            y = j;
            width = k;
            height = l;
            resizeButtons(false);
            if (uri != null)
            {
                mmVideoView.setVideoURI(uri);
                return;
            }
        }
    }

    public void setPlaceholder(final Uri uri)
    {
        if (mmWebViewRef != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final InlineWebVideoView this$0;
                final Uri val$uri;

                public void run()
                {
                    com.millennialmedia.internal.utils.HttpUtils.Response response = HttpUtils.getBitmapFromGetRequest(uri.toString());
                    if (response != null && response.code == 200 && response.bitmap != null)
                    {
                        ThreadUtils.runOnUiThread(response. new Runnable() {

                            final _cls4 this$1;
                            final com.millennialmedia.internal.utils.HttpUtils.Response val$response;

                            public void run()
                            {
label0:
                                {
                                    MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
                                    if (mmwebview != null)
                                    {
                                        placeholderView.setImageBitmap(response.bitmap);
                                        if (mmwebview.getWidth() - x < width || mmwebview.getHeight() - y < height)
                                        {
                                            break label0;
                                        }
                                        attachToAnchorView(mmwebview);
                                    }
                                    return;
                                }
                                MMLog.e(InlineWebVideoView.TAG, "Cannot attach the inline video; it will not fit within the anchor view.");
                            }

            
            {
                this$1 = final__pcls4;
                response = com.millennialmedia.internal.utils.HttpUtils.Response.this;
                super();
            }
                        });
                    }
                }

            
            {
                this$0 = InlineWebVideoView.this;
                uri = uri1;
                super();
            }
            });
        }
    }

    public void setVideoURI(Uri uri1)
    {
        error = false;
        startFired = false;
        q1Fired = false;
        midpointFired = false;
        q3Fired = false;
        endFired = false;
        uri = uri1;
        if (mmWebViewRef != null)
        {
            mmVideoView.setVideoURI(uri1);
            uri1 = (MMWebView)mmWebViewRef.get();
            if (uri1 != null)
            {
                uri1.invokeCallback(callbackId, new Object[] {
                    getTag(), "stateChange", "loading"
                });
            }
        }
    }

    public void start()
    {
        if (!error)
        {
            inlineVideoControls.start();
        } else
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "InlineWebVideoView.start could not complete because of a previous error.");
            return;
        }
    }

    public void stop()
    {
        if (!error)
        {
            mmVideoView.stop();
        } else
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "InlineWebVideoView.stop could not complete because of a previous error.");
            return;
        }
    }

    public void triggerTimeUpdate()
    {
        if (!error)
        {
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview != null)
            {
                mmwebview.invokeCallback(callbackId, new Object[] {
                    getTag(), "timeUpdate", Integer.valueOf(mmVideoView.getCurrentPosition())
                });
            }
        } else
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "InlineWebVideoView.triggerTimeUpdate could not complete because of a previous error.");
            return;
        }
    }

    public void unmute()
    {
        if (!error)
        {
            inlineVideoControls.unmute();
        } else
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "InlineWebVideoView.unmute could not complete because of a previous error.");
            return;
        }
    }






















    // Unreferenced inner class com/millennialmedia/internal/video/InlineWebVideoView$InlineVideoControls$1

/* anonymous class */
    class InlineVideoControls._cls1
        implements android.view.View.OnClickListener
    {

        final InlineVideoControls this$1;
        final InlineWebVideoView val$this$0;

        public void onClick(View view)
        {
        }

            
            {
                this$1 = final_inlinevideocontrols;
                this$0 = InlineWebVideoView.this;
                super();
            }
    }


    // Unreferenced inner class com/millennialmedia/internal/video/InlineWebVideoView$InlineVideoControls$2

/* anonymous class */
    class InlineVideoControls._cls2
        implements android.view.View.OnClickListener
    {

        final InlineVideoControls this$1;
        final InlineWebVideoView val$this$0;

        public void onClick(View view)
        {
            fireOnClick();
        }

            
            {
                this$1 = final_inlinevideocontrols;
                this$0 = InlineWebVideoView.this;
                super();
            }
    }


    // Unreferenced inner class com/millennialmedia/internal/video/InlineWebVideoView$InlineVideoControls$3

/* anonymous class */
    class InlineVideoControls._cls3
        implements android.widget.CompoundButton.OnCheckedChangeListener
    {

        final InlineVideoControls this$1;
        final MMVideoView val$mmVideoView;
        final InlineWebVideoView val$this$0;

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
label0:
            {
                if (mmVideoView != null)
                {
                    if (!flag)
                    {
                        break label0;
                    }
                    mmVideoView.start();
                }
                return;
            }
            mmVideoView.pause();
        }

            
            {
                this$1 = final_inlinevideocontrols;
                this$0 = inlinewebvideoview;
                mmVideoView = MMVideoView.this;
                super();
            }
    }


    // Unreferenced inner class com/millennialmedia/internal/video/InlineWebVideoView$InlineVideoControls$4

/* anonymous class */
    class InlineVideoControls._cls4
        implements android.view.View.OnClickListener
    {

        final InlineVideoControls this$1;
        final InlineWebVideoView val$this$0;

        public void onClick(View view)
        {
            fireOnClick();
        }

            
            {
                this$1 = final_inlinevideocontrols;
                this$0 = InlineWebVideoView.this;
                super();
            }
    }


    // Unreferenced inner class com/millennialmedia/internal/video/InlineWebVideoView$InlineVideoControls$5

/* anonymous class */
    class InlineVideoControls._cls5
        implements android.widget.CompoundButton.OnCheckedChangeListener
    {

        final InlineVideoControls this$1;
        final MMVideoView val$mmVideoView;
        final InlineWebVideoView val$this$0;

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
            if (mmVideoView != null)
            {
                if (flag)
                {
                    mmVideoView.mute();
                } else
                {
                    mmVideoView.unmute();
                    compoundbutton = (AudioManager)getContext().getSystemService("audio");
                    if (compoundbutton.getStreamVolume(3) == 0)
                    {
                        compoundbutton.setStreamVolume(3, compoundbutton.getStreamMaxVolume(3) / 3, 0);
                        return;
                    }
                }
            }
        }

            
            {
                this$1 = final_inlinevideocontrols;
                this$0 = inlinewebvideoview;
                mmVideoView = MMVideoView.this;
                super();
            }
    }

}
