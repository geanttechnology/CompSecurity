// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.MMWebView;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.Utils;
import com.millennialmedia.internal.utils.ViewUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.millennialmedia.internal.video:
//            MMVideoView

public class LightboxView extends RelativeLayout
    implements MMVideoView.MMVideoViewListener, android.view.View.OnTouchListener
{
    public static interface LightboxViewListener
    {

        public abstract void onAdLeftApplication();

        public abstract void onClicked();

        public abstract void onCollapsed();

        public abstract void onExpanded();

        public abstract void onFailed();

        public abstract void onPrepared();

        public abstract void onReadyToStart();
    }


    private static final int COLLAPSING = 3;
    private static final int DEFAULT = 0;
    private static final int EXPANDED = 4;
    private static final int EXPANDING = 2;
    private static final int SWIPE_AWAY = 1;
    private static final String TAG = com/millennialmedia/internal/video/LightboxView.getSimpleName();
    private volatile boolean animating;
    private volatile boolean complete;
    private boolean completeFired;
    private int defaultHeight;
    private int defaultWidth;
    private float downX;
    private float downY;
    private ImageView fullscreenCompanion;
    private boolean fullscreenCompanionLoadedFired;
    private MMWebView fullscreenCompanionWebView;
    private FrameLayout fullscreenContainer;
    private int fullscreenContainerTopMargin;
    private boolean landscape;
    private com.millennialmedia.internal.adcontrollers.LightboxController.LightboxAd lightboxAd;
    private int lightboxBottomMargin;
    private int lightboxRightMargin;
    private LightboxViewListener lightboxViewListener;
    private boolean midpointFired;
    private ImageView minimizeButton;
    private com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable minimizeFadeOutRunnable;
    private float originalX;
    private float originalY;
    private volatile boolean prepared;
    private boolean q1Fired;
    private boolean q3Fired;
    private ImageView replayButton;
    private float scaleFactor;
    private boolean startFired;
    private volatile int state;
    private int topMargin;
    private MMVideoView videoView;
    private com.millennialmedia.internal.utils.ViewUtils.ViewabilityWatcher videoViewabilityWatcher;
    private WindowManager windowManager;

    public LightboxView(Context context, final com.millennialmedia.internal.adcontrollers.LightboxController.LightboxAd lightboxAd, final LightboxViewListener lightboxViewListener)
    {
        super(context);
        landscape = false;
        minimizeFadeOutRunnable = null;
        startFired = false;
        q1Fired = false;
        midpointFired = false;
        q3Fired = false;
        completeFired = false;
        fullscreenCompanionLoadedFired = false;
        state = 0;
        prepared = false;
        complete = false;
        animating = false;
        windowManager = (WindowManager)context.getSystemService("window");
        getDisplaySize();
        Object obj = getResources();
        defaultWidth = ((Resources) (obj)).getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_lightbox_width);
        defaultHeight = ((Resources) (obj)).getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_lightbox_height);
        lightboxBottomMargin = ((Resources) (obj)).getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_lightbox_bottom_margin);
        lightboxRightMargin = ((Resources) (obj)).getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_lightbox_right_margin);
        topMargin = ((Resources) (obj)).getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_lightbox_top_margin);
        fullscreenContainerTopMargin = ((Resources) (obj)).getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_lightbox_fullscreen_companion_top_margin);
        setBackgroundColor(((Resources) (obj)).getColor(0x106000d));
        setOnTouchListener(this);
        this.lightboxViewListener = lightboxViewListener;
        this.lightboxAd = lightboxAd;
        videoView = new MMVideoView(context, false, true, this);
        videoView.setId(com.millennialmedia.R.id.mmadsdk_light_box_video_view);
        videoView.setVideoURI(Uri.parse(lightboxAd.video.uri));
        videoView.setBackgroundColor(((Resources) (obj)).getColor(0x106000c));
        minimizeButton = new ImageView(context);
        minimizeButton.setVisibility(8);
        minimizeButton.setBackgroundColor(0);
        minimizeButton.setImageDrawable(getResources().getDrawable(com.millennialmedia.R.drawable.mmadsdk_lightbox_down));
        minimizeButton.setOnClickListener(new android.view.View.OnClickListener() {

            final LightboxView this$0;

            public void onClick(View view)
            {
                animateFromExpandedToDefault();
            }

            
            {
                this$0 = LightboxView.this;
                super();
            }
        });
        obj = new android.widget.RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_lightbox_minimize_button_width), getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_lightbox_minimize_button_height));
        obj.topMargin = getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_lightbox_minimize_button_top_margin);
        obj.rightMargin = getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_lightbox_minimize_button_right_margin);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        videoView.addView(minimizeButton, ((android.view.ViewGroup.LayoutParams) (obj)));
        replayButton = new ImageView(context);
        replayButton.setVisibility(8);
        replayButton.setBackgroundColor(0);
        replayButton.setImageDrawable(getResources().getDrawable(com.millennialmedia.R.drawable.mmadsdk_lightbox_replay));
        replayButton.setOnClickListener(new android.view.View.OnClickListener() {

            final LightboxView this$0;

            public void onClick(View view)
            {
                complete = false;
                replayButton.setVisibility(8);
                videoView.restart();
                if (state == 4)
                {
                    startMinimizeFadeOut(0L, 500L);
                }
            }

            
            {
                this$0 = LightboxView.this;
                super();
            }
        });
        obj = new android.widget.RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_lightbox_replay_button_width), getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_lightbox_replay_button_height));
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
        videoView.addView(replayButton, ((android.view.ViewGroup.LayoutParams) (obj)));
        videoViewabilityWatcher = new com.millennialmedia.internal.utils.ViewUtils.ViewabilityWatcher(videoView, new com.millennialmedia.internal.utils.ViewUtils.ViewabilityListener() {

            final LightboxView this$0;

            public void onViewableChanged(boolean flag)
            {
label0:
                {
                    if (!complete)
                    {
                        if (!flag)
                        {
                            break label0;
                        }
                        videoView.start();
                    }
                    return;
                }
                videoView.pause();
            }

            
            {
                this$0 = LightboxView.this;
                super();
            }
        });
        fullscreenContainer = new FrameLayout(context);
        fullscreenCompanion = new ImageView(context);
        fullscreenCompanion.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        fullscreenCompanion.setBackgroundColor(getResources().getColor(com.millennialmedia.R.color.mmadsdk_lightbox_curtain_background));
        if (!Utils.isEmpty(lightboxAd.fullscreen.imageUri))
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final LightboxView this$0;
                final com.millennialmedia.internal.adcontrollers.LightboxController.LightboxAd val$lightboxAd;

                public void run()
                {
                    com.millennialmedia.internal.utils.HttpUtils.Response response = HttpUtils.getBitmapFromGetRequest(lightboxAd.fullscreen.imageUri);
                    if (response.code == 200)
                    {
                        ThreadUtils.runOnUiThread(response. new Runnable() {

                            final _cls4 this$1;
                            final com.millennialmedia.internal.utils.HttpUtils.Response val$response;

                            public void run()
                            {
                                fullscreenCompanion.setImageBitmap(response.bitmap);
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
                this$0 = LightboxView.this;
                lightboxAd = lightboxad;
                super();
            }
            });
        }
        fullscreenContainer.addView(fullscreenCompanion);
        fullscreenCompanionWebView = new MMWebView(context, false, false, new com.millennialmedia.internal.MMWebView.MMWebViewListener() {

            final LightboxView this$0;
            final LightboxViewListener val$lightboxViewListener;

            public void close()
            {
            }

            public boolean expand(com.millennialmedia.internal.SizableStateManager.ExpandParams expandparams)
            {
                return false;
            }

            public void onAdLeftApplication()
            {
                lightboxViewListener.onAdLeftApplication();
            }

            public void onClicked()
            {
                lightboxViewListener.onClicked();
            }

            public void onFailed()
            {
            }

            public void onLoaded()
            {
            }

            public void onReady()
            {
            }

            public boolean resize(com.millennialmedia.internal.SizableStateManager.ResizeParams resizeparams)
            {
                return false;
            }

            public void setOrientation(int i)
            {
            }

            public void showCloseIndicator(boolean flag)
            {
            }

            
            {
                this$0 = LightboxView.this;
                lightboxViewListener = lightboxviewlistener;
                super();
            }
        });
        fullscreenCompanionWebView.setContent(lightboxAd.fullscreen.webContent);
        context = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        context.topMargin = fullscreenContainerTopMargin;
        context.addRule(3, com.millennialmedia.R.id.mmadsdk_light_box_video_view);
        fullscreenContainer.setVisibility(8);
        ViewUtils.attachView(this, fullscreenContainer, context);
        context = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        if (!landscape)
        {
            context.addRule(10);
        }
        ViewUtils.attachView(this, videoView, context);
    }

    private void animateFromExpandedToDefault()
    {
        final boolean wasExpanding = true;
        animating = true;
        final Point displaySize = getDisplaySize();
        Animation animation;
        if (state != 2)
        {
            wasExpanding = false;
        }
        state = 0;
        minimizeButton.setVisibility(8);
        setBackgroundColor(getResources().getColor(0x106000d));
        if (fullscreenCompanionWebView.getParent() != null)
        {
            fullscreenContainer.removeView(fullscreenCompanionWebView);
        }
        fullscreenCompanion.setVisibility(0);
        fullscreenCompanion.setAlpha(1.0F);
        if (!landscape)
        {
            fullscreenContainer.setVisibility(0);
        }
        animation = new Animation() {

            int heightDelta;
            int originalHeight;
            int originalWidth;
            final LightboxView this$0;
            final Point val$defaultPosition;
            final Point val$displaySize;
            int widthDelta;

            protected void applyTransformation(float f, Transformation transformation)
            {
                int i;
                int j;
                int k;
                int l;
                int j1;
                int k1;
label0:
                {
                    float f1;
                    int i1;
                    if (f == 1.0F)
                    {
                        i = defaultHeight;
                    } else
                    {
                        i = (int)((float)originalHeight - (float)heightDelta * f);
                    }
                    f1 = (float)(i - defaultHeight) / (float)(displaySize.y - defaultHeight);
                    if (f == 1.0F)
                    {
                        j = defaultWidth;
                    } else
                    {
                        j = (int)((float)defaultWidth + (float)widthDelta * f1);
                    }
                    if (f == 1.0F)
                    {
                        k = 0;
                    } else
                    {
                        k = (int)((float)topMargin * f1);
                    }
                    if (f == 1.0F)
                    {
                        j1 = fullscreenContainerTopMargin;
                    } else
                    {
                        j1 = fullscreenContainerTopMargin - (int)((float)fullscreenContainerTopMargin * f1);
                    }
                    if (f == 1.0F)
                    {
                        l = defaultPosition.x;
                    } else
                    {
                        l = Math.max(0, displaySize.x - j - (lightboxRightMargin - (int)((float)lightboxRightMargin * f1)));
                    }
                    if (f == 1.0F)
                    {
                        i1 = defaultPosition.y;
                    } else
                    {
                        i1 = Math.max(0, displaySize.y - i - (lightboxBottomMargin - (int)((float)lightboxBottomMargin * f1)));
                    }
                    if (j > defaultWidth && i > defaultHeight && l < defaultPosition.x)
                    {
                        k1 = i;
                        i = i1;
                        if (i1 < defaultPosition.y)
                        {
                            break label0;
                        }
                    }
                    k = 0;
                    j1 = fullscreenContainerTopMargin;
                    j = defaultWidth;
                    k1 = defaultHeight;
                    i = defaultPosition.y;
                    l = defaultPosition.x;
                    fullscreenContainer.setVisibility(8);
                }
                if (f == 1.0F)
                {
                    setTranslationX(defaultPosition.x);
                    setTranslationY(defaultPosition.y);
                    getLayoutParams().width = defaultWidth;
                    ((android.widget.RelativeLayout.LayoutParams)fullscreenContainer.getLayoutParams()).topMargin = fullscreenContainerTopMargin;
                    setHeight(k1);
                    ((android.widget.RelativeLayout.LayoutParams)videoView.getLayoutParams()).topMargin = 0;
                    videoView.setTranslationX(0.0F);
                    videoView.getLayoutParams().height = -1;
                    videoView.getLayoutParams().width = -1;
                } else
                {
                    ((android.widget.RelativeLayout.LayoutParams)fullscreenContainer.getLayoutParams()).topMargin = j1;
                    setHeight(k1);
                    ((android.widget.RelativeLayout.LayoutParams)videoView.getLayoutParams()).topMargin = k;
                    videoView.getLayoutParams().width = j;
                    setTranslationY(i);
                    videoView.setTranslationX(l);
                }
                requestLayout();
            }

            public void initialize(int i, int j, int k, int l)
            {
                originalHeight = j;
                heightDelta = j - defaultHeight;
                originalWidth = i;
                widthDelta = i - defaultWidth;
            }

            public boolean willChangeBounds()
            {
                return true;
            }

            
            {
                this$0 = LightboxView.this;
                displaySize = point;
                defaultPosition = point1;
                super();
            }
        };
        animation.setDuration((long)((float)displaySize.y / (getContext().getResources().getDisplayMetrics().density / 2.0F)));
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final LightboxView this$0;
            final boolean val$wasExpanding;

            public void onAnimationEnd(Animation animation1)
            {
                fullscreenContainer.setVisibility(8);
                videoView.mute();
                if (!wasExpanding)
                {
                    lightboxViewListener.onCollapsed();
                    fireTrackingEvents((List)lightboxAd.video.trackingEvents.get(com.millennialmedia.internal.adcontrollers.LightboxController.TrackableEvent.videoCollapse));
                }
                animating = false;
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            public void onAnimationStart(Animation animation1)
            {
            }

            
            {
                this$0 = LightboxView.this;
                wasExpanding = flag;
                super();
            }
        });
        startAnimation(animation);
    }

    private void animateToDefault(Point point)
    {
        animating = true;
        state = 0;
        Animation animation = new Animation() {

            float distanceToDefault;
            final LightboxView this$0;
            float translateX;
            final Point val$defaultPosition;
            int width;

            protected void applyTransformation(float f, Transformation transformation)
            {
                if (f == 1.0F)
                {
                    f = defaultPosition.x;
                } else
                {
                    f = translateX + distanceToDefault * f;
                }
                setTranslationX(f);
            }

            public void initialize(int i, int j, int k, int l)
            {
                width = i;
                translateX = getTranslationX();
                distanceToDefault = (float)defaultPosition.x - translateX;
            }

            public boolean willChangeBounds()
            {
                return false;
            }

            
            {
                this$0 = LightboxView.this;
                defaultPosition = point;
                super();
            }
        };
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final LightboxView this$0;

            public void onAnimationEnd(Animation animation1)
            {
                animating = false;
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            public void onAnimationStart(Animation animation1)
            {
            }

            
            {
                this$0 = LightboxView.this;
                super();
            }
        });
        animation.setDuration((long)((float)point.x / getContext().getResources().getDisplayMetrics().density));
        startAnimation(animation);
    }

    private void animateToExpand(final Point displaySize)
    {
        animating = true;
        Animation animation;
        final boolean wasCollapsing;
        if (state == 3)
        {
            wasCollapsing = true;
        } else
        {
            wasCollapsing = false;
        }
        state = 4;
        setBackgroundColor(getResources().getColor(0x106000d));
        if (!fullscreenCompanionLoadedFired && !landscape)
        {
            fullscreenCompanionLoadedFired = true;
            fireTrackingEvents(lightboxAd.fullscreen.trackingEvents);
        }
        getLayoutParams().width = -1;
        if (!landscape)
        {
            videoView.getLayoutParams().height = -2;
        }
        setTranslationX(0.0F);
        if (!landscape)
        {
            fullscreenContainer.setVisibility(0);
        }
        animation = new Animation() {

            int heightDelta;
            int originalHeight;
            final LightboxView this$0;
            final Point val$displaySize;

            protected void applyTransformation(float f, Transformation transformation)
            {
label0:
                {
                    int i1 = 0;
                    float f1;
                    int i;
                    int j;
                    int k;
                    int l;
                    int j1;
                    int k1;
                    if (f == 1.0F)
                    {
                        i = displaySize.y;
                    } else
                    {
                        i = (int)((float)originalHeight + (float)heightDelta * f);
                    }
                    f1 = (float)(i - defaultHeight) / (float)(displaySize.y - defaultHeight);
                    if (f == 1.0F)
                    {
                        j = displaySize.x;
                    } else
                    {
                        j = (int)((float)defaultWidth + (float)(displaySize.x - defaultWidth) * f1);
                    }
                    if (f == 1.0F)
                    {
                        k = topMargin;
                    } else
                    {
                        k = (int)((float)topMargin * f1);
                    }
                    if (f == 1.0F)
                    {
                        j1 = 0;
                    } else
                    {
                        j1 = fullscreenContainerTopMargin - (int)((float)fullscreenContainerTopMargin * f1);
                    }
                    if (f == 1.0F)
                    {
                        l = 0;
                    } else
                    {
                        l = Math.max(0, displaySize.x - j - (lightboxRightMargin - (int)((float)lightboxRightMargin * f1)));
                    }
                    if (f != 1.0F)
                    {
                        i1 = Math.max(0, displaySize.y - i - (lightboxBottomMargin - (int)((float)lightboxBottomMargin * f1)));
                    }
                    if (j < displaySize.x && i < displaySize.y && l > 0)
                    {
                        k1 = i;
                        i = i1;
                        if (i1 > 0)
                        {
                            break label0;
                        }
                    }
                    j = displaySize.x;
                    k1 = displaySize.y;
                    j1 = 0;
                    k = topMargin;
                    i = 0;
                    l = 0;
                }
                ((android.widget.RelativeLayout.LayoutParams)fullscreenContainer.getLayoutParams()).topMargin = j1;
                setHeight(k1);
                ((android.widget.RelativeLayout.LayoutParams)videoView.getLayoutParams()).topMargin = k;
                videoView.getLayoutParams().width = j;
                setTranslationY(i);
                videoView.setTranslationX(l);
                requestLayout();
            }

            public void initialize(int i, int j, int k, int l)
            {
                originalHeight = j;
                heightDelta = l - j;
            }

            public boolean willChangeBounds()
            {
                return true;
            }

            
            {
                this$0 = LightboxView.this;
                displaySize = point;
                super();
            }
        };
        animation.setDuration((long)((float)displaySize.y / (getContext().getResources().getDisplayMetrics().density / 2.0F)));
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final LightboxView this$0;
            final boolean val$wasCollapsing;

            public void onAnimationEnd(Animation animation1)
            {
                setBackgroundColor(getResources().getColor(0x106000c));
                videoView.unmute();
                if (!wasCollapsing)
                {
                    lightboxViewListener.onClicked();
                    lightboxViewListener.onExpanded();
                    fireTrackingEvents((List)lightboxAd.video.trackingEvents.get(com.millennialmedia.internal.adcontrollers.LightboxController.TrackableEvent.videoExpand));
                }
                crossFadeCurtainWebView();
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            public void onAnimationStart(Animation animation1)
            {
            }

            
            {
                this$0 = LightboxView.this;
                wasCollapsing = flag;
                super();
            }
        });
        startAnimation(animation);
    }

    private void crossFadeCurtainWebView()
    {
        fullscreenCompanion.setAlpha(1.0F);
        fullscreenCompanionWebView.setAlpha(0.0F);
        if (fullscreenCompanionWebView.getParent() == null)
        {
            fullscreenContainer.addView(fullscreenCompanionWebView, 0);
        }
        fullscreenCompanion.animate().alpha(0.0F).setDuration(1000L).setListener(new android.animation.Animator.AnimatorListener() {

            final LightboxView this$0;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                fullscreenCompanion.setVisibility(8);
                startMinimizeFadeOut(2500L, 500L);
                animating = false;
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                this$0 = LightboxView.this;
                super();
            }
        }).start();
        fullscreenCompanionWebView.animate().alpha(1.0F).setDuration(1000L).start();
    }

    private void fireTrackingEvents(final List trackingEvents)
    {
        if (trackingEvents != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final LightboxView this$0;
                final List val$trackingEvents;

                public void run()
                {
                    Iterator iterator = trackingEvents.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        com.millennialmedia.internal.adcontrollers.LightboxController.TrackingEvent trackingevent = (com.millennialmedia.internal.adcontrollers.LightboxController.TrackingEvent)iterator.next();
                        if (trackingevent != null && !Utils.isEmpty(trackingevent.uri))
                        {
                            if (MMLog.isDebugEnabled())
                            {
                                MMLog.d(LightboxView.TAG, (new StringBuilder()).append("Firing tracking url = ").append(trackingevent.uri).toString());
                            }
                            HttpUtils.getContentFromGetRequest(trackingevent.uri);
                        }
                    } while (true);
                }

            
            {
                this$0 = LightboxView.this;
                trackingEvents = list;
                super();
            }
            });
        }
    }

    private Point getDisplaySize()
    {
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point;
    }

    private void goToDefaultState()
    {
        animating = true;
        state = 0;
        videoView.mute();
        ViewUtils.removeFromParent(this);
        Point point = getDefaultPosition();
        setTranslationX(point.x);
        setTranslationY(point.y);
        videoView.setTranslationX(0.0F);
        setHeight(defaultHeight);
        getLayoutParams().width = defaultWidth;
        videoView.getLayoutParams().height = -1;
        videoView.getLayoutParams().width = -1;
        setBackgroundColor(getResources().getColor(0x106000d));
        fullscreenContainer.setVisibility(8);
        ((android.widget.RelativeLayout.LayoutParams)fullscreenContainer.getLayoutParams()).topMargin = fullscreenContainerTopMargin;
        ((android.widget.RelativeLayout.LayoutParams)videoView.getLayoutParams()).topMargin = 0;
        ViewUtils.attachView(ViewUtils.getDecorView(this), this);
        animating = false;
    }

    private void goToExpandedLandscapeState(Point point)
    {
        animating = true;
        state = 4;
        ViewUtils.removeFromParent(this);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(point.x, -1);
        layoutparams.topMargin = topMargin;
        setTranslationX(0.0F);
        setTranslationY(0.0F);
        videoView.setTranslationX(0.0F);
        ((android.widget.RelativeLayout.LayoutParams)fullscreenContainer.getLayoutParams()).topMargin = 0;
        setHeight(point.y);
        videoView.setLayoutParams(layoutparams);
        getLayoutParams().width = -1;
        fullscreenContainer.setVisibility(8);
        setBackgroundColor(getResources().getColor(0x106000c));
        ViewUtils.attachView(ViewUtils.getDecorView(this), this);
        videoView.unmute();
        crossFadeCurtainWebView();
    }

    private void goToExpandedPortraitState(Point point)
    {
        animating = true;
        state = 4;
        ViewUtils.removeFromParent(this);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(point.x, -2);
        layoutparams.topMargin = topMargin;
        videoView.setLayoutParams(layoutparams);
        setTranslationX(0.0F);
        setTranslationY(0.0F);
        videoView.setTranslationX(0.0F);
        ((android.widget.RelativeLayout.LayoutParams)fullscreenContainer.getLayoutParams()).topMargin = 0;
        fullscreenContainer.setVisibility(0);
        setHeight(point.y);
        getLayoutParams().width = -1;
        if (!fullscreenCompanionLoadedFired)
        {
            fullscreenCompanionLoadedFired = true;
            fireTrackingEvents(lightboxAd.fullscreen.trackingEvents);
        }
        setBackgroundColor(getResources().getColor(0x106000c));
        ViewUtils.attachView(ViewUtils.getDecorView(this), this);
        videoView.unmute();
        crossFadeCurtainWebView();
    }

    private void setHeight(int i)
    {
        Point point = getDisplaySize();
        getLayoutParams().height = Math.max(defaultHeight, Math.min(i, point.y));
    }

    private void startMinimizeFadeOut(long l, final long animationDuration)
    {
        if (minimizeFadeOutRunnable != null)
        {
            minimizeFadeOutRunnable.cancel();
        }
        minimizeButton.setVisibility(0);
        minimizeButton.setAlpha(1.0F);
        minimizeFadeOutRunnable = ThreadUtils.runOnUiThreadDelayed(new Runnable() {

            final LightboxView this$0;
            final long val$animationDuration;

            public void run()
            {
                if (!complete)
                {
                    minimizeButton.animate().alpha(0.0F).setDuration(animationDuration).setListener(new android.animation.Animator.AnimatorListener() {

                        final _cls17 this$1;

                        public void onAnimationCancel(Animator animator)
                        {
                        }

                        public void onAnimationEnd(Animator animator)
                        {
                            minimizeFadeOutRunnable = null;
                        }

                        public void onAnimationRepeat(Animator animator)
                        {
                        }

                        public void onAnimationStart(Animator animator)
                        {
                        }

            
            {
                this$1 = _cls17.this;
                super();
            }
                    }).start();
                }
            }

            
            {
                this$0 = LightboxView.this;
                animationDuration = l;
                super();
            }
        }, l);
    }

    public void animateToGone(final boolean fireCloseTracking)
    {
        Point point = getDisplaySize();
        Animation animation = new Animation() {

            float distanceToOffscreen;
            final LightboxView this$0;
            float translateX;
            int width;

            protected void applyTransformation(float f, Transformation transformation)
            {
                if (f == 1.0F)
                {
                    f = width * -1;
                } else
                {
                    f = translateX - distanceToOffscreen * f;
                }
                setTranslationX(f);
            }

            public void initialize(int i, int j, int k, int l)
            {
                width = i;
                translateX = getTranslationX();
                distanceToOffscreen = translateX + (float)i;
            }

            public boolean willChangeBounds()
            {
                return false;
            }

            
            {
                this$0 = LightboxView.this;
                super();
            }
        };
        animation.setDuration((long)((float)point.x / getContext().getResources().getDisplayMetrics().density));
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final LightboxView this$0;
            final boolean val$fireCloseTracking;

            public void onAnimationEnd(Animation animation1)
            {
                videoView.stop();
                if (fireCloseTracking)
                {
                    fireTrackingEvents((List)lightboxAd.video.trackingEvents.get(com.millennialmedia.internal.adcontrollers.LightboxController.TrackableEvent.videoClose));
                }
                ViewUtils.removeFromParent(LightboxView.this);
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            public void onAnimationStart(Animation animation1)
            {
            }

            
            {
                this$0 = LightboxView.this;
                fireCloseTracking = flag;
                super();
            }
        });
        startAnimation(animation);
    }

    public Point getDefaultDimensions()
    {
        return new Point(defaultWidth, defaultHeight);
    }

    public Point getDefaultPosition()
    {
        Point point = getDisplaySize();
        return new Point(point.x - lightboxRightMargin - defaultWidth, point.y - lightboxBottomMargin - defaultHeight);
    }

    public boolean isPrepared()
    {
        return prepared;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        Point point = getDisplaySize();
        boolean flag;
        if (point.x > point.y)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        landscape = flag;
        if (!landscape)
        {
            ((android.widget.RelativeLayout.LayoutParams)videoView.getLayoutParams()).addRule(10);
        }
        videoViewabilityWatcher.startWatching();
    }

    public void onBufferingUpdate(MMVideoView mmvideoview, int i)
    {
    }

    public void onComplete(MMVideoView mmvideoview)
    {
        complete = true;
        if (!completeFired)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "LightboxView firing complete event");
            }
            completeFired = true;
            fireTrackingEvents((List)lightboxAd.video.trackingEvents.get(com.millennialmedia.internal.adcontrollers.LightboxController.TrackableEvent.complete));
        }
        if (minimizeFadeOutRunnable != null)
        {
            minimizeFadeOutRunnable.cancel();
            minimizeFadeOutRunnable = null;
        }
        ThreadUtils.runOnUiThread(new Runnable() {

            final LightboxView this$0;

            public void run()
            {
                if (state == 4)
                {
                    minimizeButton.setVisibility(0);
                    minimizeButton.setAlpha(1.0F);
                }
                replayButton.setVisibility(0);
            }

            
            {
                this$0 = LightboxView.this;
                super();
            }
        });
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        Point point;
        clearAnimation();
        point = getDisplaySize();
        if (!landscape || configuration.orientation != 1) goto _L2; else goto _L1
_L1:
        landscape = false;
        if (state != 3 && state != 4) goto _L4; else goto _L3
_L3:
        goToExpandedPortraitState(point);
_L6:
        return;
_L4:
        if (state == 1)
        {
            ViewUtils.removeFromParent(this);
            return;
        } else
        {
            goToDefaultState();
            return;
        }
_L2:
        if (!landscape && configuration.orientation == 2)
        {
            landscape = true;
            if (state == 3 || state == 4)
            {
                goToExpandedLandscapeState(point);
                return;
            }
            if (state == 1)
            {
                ViewUtils.removeFromParent(this);
                return;
            } else
            {
                goToDefaultState();
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onDetachedFromWindow()
    {
        videoViewabilityWatcher.stopWatching();
        super.onDetachedFromWindow();
    }

    public void onError(MMVideoView mmvideoview)
    {
        lightboxViewListener.onFailed();
    }

    public void onMuted(MMVideoView mmvideoview)
    {
    }

    public void onPause(MMVideoView mmvideoview)
    {
    }

    public void onPrepared(MMVideoView mmvideoview)
    {
        prepared = true;
        lightboxViewListener.onPrepared();
    }

    public void onProgress(MMVideoView mmvideoview, int i)
    {
        this;
        JVM INSTR monitorenter ;
        int j = mmvideoview.getDuration() / 4;
        if (q1Fired || i < j)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "LightboxView firing q1 event");
        }
        q1Fired = true;
        fireTrackingEvents((List)lightboxAd.video.trackingEvents.get(com.millennialmedia.internal.adcontrollers.LightboxController.TrackableEvent.firstQuartile));
        if (midpointFired || i < j * 2)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "LightboxView firing midpoint event");
        }
        midpointFired = true;
        fireTrackingEvents((List)lightboxAd.video.trackingEvents.get(com.millennialmedia.internal.adcontrollers.LightboxController.TrackableEvent.midpoint));
        if (q3Fired || i < j * 3)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "LightboxView firing q3 event");
        }
        q3Fired = true;
        fireTrackingEvents((List)lightboxAd.video.trackingEvents.get(com.millennialmedia.internal.adcontrollers.LightboxController.TrackableEvent.thirdQuartile));
        this;
        JVM INSTR monitorexit ;
        return;
        mmvideoview;
        throw mmvideoview;
    }

    public void onReadyToStart(MMVideoView mmvideoview)
    {
        lightboxViewListener.onReadyToStart();
    }

    public void onSeek(MMVideoView mmvideoview)
    {
    }

    public void onStart(MMVideoView mmvideoview)
    {
        if (!startFired)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "LightboxView firing start event");
            }
            startFired = true;
            fireTrackingEvents((List)lightboxAd.video.trackingEvents.get(com.millennialmedia.internal.adcontrollers.LightboxController.TrackableEvent.start));
        }
    }

    public void onStop(MMVideoView mmvideoview)
    {
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (animating)
        {
            return true;
        }
        if (motionevent.getActionMasked() == 0)
        {
            downX = motionevent.getRawX();
            downY = motionevent.getRawY();
            return true;
        }
        if (motionevent.getActionMasked() != 2) goto _L2; else goto _L1
_L1:
        double d;
        float f;
        float f1;
        view = getDisplaySize();
        f = motionevent.getRawX();
        f1 = motionevent.getRawY();
        d = Math.sqrt((int)(Math.pow(downX - f, 2D) + Math.pow(downY - f1, 2D)));
        motionevent = getDefaultPosition();
        if (d <= 50D || state != 0 && state != 4) goto _L4; else goto _L3
_L3:
        if (state == 0)
        {
            originalX = ((Point) (motionevent)).x;
            originalY = ((Point) (motionevent)).y;
        } else
        {
            originalX = 0.0F;
            originalY = 0.0F;
        }
        if (Math.abs(downX - f) <= Math.abs(downY - f1) || state == 4) goto _L6; else goto _L5
_L5:
        state = 1;
_L4:
        if (state == 0) goto _L8; else goto _L7
_L7:
        if (state != 1) goto _L10; else goto _L9
_L9:
        f1 = downX;
        f1 = originalX - (f1 - f);
        f = f1;
        if ((float)getWidth() + f1 > (float)((Point) (view)).x)
        {
            f = ((Point) (view)).x - getWidth();
        }
        setTranslationX(f);
_L8:
        return true;
_L6:
        if (f1 < downY && state != 4)
        {
            state = 2;
            fullscreenCompanion.setAlpha(1.0F);
            fullscreenCompanion.setVisibility(0);
            if (fullscreenCompanionWebView.getParent() != null)
            {
                fullscreenContainer.removeView(fullscreenCompanionWebView);
            }
            scaleFactor = (float)(((Point) (view)).y - getHeight()) / (downY * 0.9F);
            if (!landscape)
            {
                videoView.getLayoutParams().height = -2;
            }
            setTranslationX(0.0F);
            getLayoutParams().width = -1;
        } else
        if (f1 > downY)
        {
            state = 3;
            fullscreenCompanion.setAlpha(1.0F);
            fullscreenCompanion.setVisibility(0);
            fullscreenContainer.removeView(fullscreenCompanionWebView);
            setBackgroundColor(getResources().getColor(0x106000d));
            int i = getHeight();
            int k = defaultHeight;
            float f2 = ((Point) (view)).y;
            float f3 = downY;
            scaleFactor = (float)(i - k) / ((f2 - f3) * 0.9F);
            if (!landscape)
            {
                videoView.getLayoutParams().height = -2;
            }
            setTranslationX(0.0F);
            getLayoutParams().width = -1;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (state != 2) goto _L12; else goto _L11
_L11:
        int j;
        int l;
        int i1;
        int j1;
        int k1;
        f = (downY - f1) * scaleFactor;
        f1 = originalY - f;
        l = (int)((float)defaultHeight + f + (float)lightboxBottomMargin);
        f = (float)(l - defaultHeight) / (float)(((Point) (view)).y - defaultHeight);
        j1 = defaultWidth + (int)((float)(((Point) (view)).x - defaultWidth) * f);
        k1 = ((Point) (view)).x - j1 - (lightboxRightMargin - (int)((float)lightboxRightMargin * f));
        i1 = Math.min((int)((float)topMargin * f), topMargin);
        j = Math.max(0, fullscreenContainerTopMargin - (int)((float)fullscreenContainerTopMargin * f));
        if (j1 > defaultWidth && l > defaultHeight && k1 < ((Point) (motionevent)).x && f1 < (float)((Point) (motionevent)).y) goto _L14; else goto _L13
_L13:
        i1 = 0;
        j = fullscreenContainerTopMargin;
        j1 = defaultWidth;
        l = defaultHeight;
        f = ((Point) (motionevent)).y;
        k1 = ((Point) (motionevent)).x;
        fullscreenContainer.setVisibility(8);
_L15:
        view = (android.widget.RelativeLayout.LayoutParams)videoView.getLayoutParams();
        view.topMargin = i1;
        ((android.widget.RelativeLayout.LayoutParams)fullscreenContainer.getLayoutParams()).topMargin = j;
        if (fullscreenContainer.getVisibility() != 0 && !landscape)
        {
            fullscreenContainer.setVisibility(0);
        }
        videoView.setTranslationX(k1);
        setTranslationY(f);
        view.width = j1;
        setHeight(l);
        requestLayout();
        invalidate();
        continue; /* Loop/switch isn't completed */
_L14:
        if (j1 < ((Point) (view)).x && l < ((Point) (view)).y && k1 > 0)
        {
            f = f1;
            if (f1 > 0.0F)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        j1 = ((Point) (view)).x;
        l = ((Point) (view)).y;
        j = 0;
        i1 = topMargin;
        f = 0.0F;
        k1 = 0;
        if (true) goto _L15; else goto _L12
_L12:
        if (state != 3)
        {
            continue; /* Loop/switch isn't completed */
        }
        f = (downY - f1) * scaleFactor;
        f1 = originalY - f;
        l = (int)((float)((Point) (view)).y + f);
        f = (float)(l - defaultHeight) / (float)(((Point) (view)).y - defaultHeight);
        j1 = defaultWidth + (int)((float)(((Point) (view)).x - defaultWidth) * f);
        k1 = ((Point) (view)).x - j1 - (lightboxRightMargin - (int)((float)lightboxRightMargin * f));
        i1 = (int)((float)topMargin * f);
        j = Math.max(0, (int)((1.0F - f) * (float)fullscreenContainerTopMargin));
        if (j1 > defaultWidth && l > defaultHeight && k1 < ((Point) (motionevent)).x && f1 < (float)((Point) (motionevent)).y)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = 0;
        j = fullscreenContainerTopMargin;
        j1 = defaultWidth;
        l = defaultHeight;
        f = ((Point) (motionevent)).y;
        k1 = ((Point) (motionevent)).x;
        fullscreenContainer.setVisibility(8);
_L19:
        if (minimizeButton.getVisibility() == 0)
        {
            minimizeButton.setVisibility(8);
        }
        view = (android.widget.RelativeLayout.LayoutParams)videoView.getLayoutParams();
        view.topMargin = i1;
        ((android.widget.RelativeLayout.LayoutParams)fullscreenContainer.getLayoutParams()).topMargin = j;
        videoView.setTranslationX(k1);
        setTranslationY(f);
        view.width = j1;
        setHeight(l);
        requestLayout();
        invalidate();
        if (true) goto _L8; else goto _L16
_L16:
        if (j1 >= ((Point) (view)).x || l >= ((Point) (view)).y || k1 <= 0) goto _L18; else goto _L17
_L17:
        f = f1;
        if (f1 > 0.0F) goto _L19; else goto _L18
_L18:
        j1 = ((Point) (view)).x;
        l = ((Point) (view)).y;
        j = 0;
        i1 = topMargin;
        f = 0.0F;
        k1 = 0;
          goto _L19
_L2:
        if (motionevent.getActionMasked() == 1)
        {
            Point point = getDisplaySize();
            if (state == 2)
            {
                if (getHeight() >= point.y / 4)
                {
                    animateToExpand(point);
                } else
                {
                    animateFromExpandedToDefault();
                }
                return true;
            }
            if (state == 3)
            {
                if ((double)getHeight() <= (double)point.y * 0.75D)
                {
                    animateFromExpandedToDefault();
                } else
                {
                    animateToExpand(point);
                }
                return true;
            }
            if (state == 1)
            {
                if (getTranslationX() < (float)((point.x - getWidth()) / 2))
                {
                    animateToGone(true);
                } else
                {
                    animateToDefault(point);
                }
                return true;
            }
            if (state == 0)
            {
                if (motionevent.getEventTime() - motionevent.getDownTime() <= 200L && view == this)
                {
                    if (!landscape)
                    {
                        fullscreenCompanion.setVisibility(0);
                    }
                    animateToExpand(point);
                    return true;
                }
            } else
            if (state == 4 && motionevent.getEventTime() - motionevent.getDownTime() <= 200L)
            {
                startMinimizeFadeOut(2500L, 500L);
                return true;
            }
        }
        return false;
        if (true) goto _L4; else goto _L20
_L20:
    }

    public void onUnmuted(MMVideoView mmvideoview)
    {
    }

    public void start()
    {
        videoView.start();
    }





/*
    static boolean access$1002(LightboxView lightboxview, boolean flag)
    {
        lightboxview.animating = flag;
        return flag;
    }

*/


/*
    static boolean access$102(LightboxView lightboxview, boolean flag)
    {
        lightboxview.complete = flag;
        return flag;
    }

*/














/*
    static com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable access$2202(LightboxView lightboxview, com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable scheduledrunnable)
    {
        lightboxview.minimizeFadeOutRunnable = scheduledrunnable;
        return scheduledrunnable;
    }

*/







}
