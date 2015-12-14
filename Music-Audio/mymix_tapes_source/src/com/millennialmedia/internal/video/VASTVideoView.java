// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.Handshake;
import com.millennialmedia.internal.MMWebView;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.IOUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.Utils;
import com.millennialmedia.internal.utils.ViewUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.millennialmedia.internal.video:
//            MMVideoView

public class VASTVideoView extends RelativeLayout
    implements MMVideoView.MMVideoViewListener
{
    private class ImageButton extends ImageView
        implements android.view.View.OnClickListener
    {

        VASTParser.Button button;
        Integer offset;
        final VASTVideoView this$0;

        private void loadStaticResource()
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final ImageButton this$1;

                public void run()
                {
                    com.millennialmedia.internal.utils.HttpUtils.Response response = HttpUtils.getBitmapFromGetRequest(button.staticResource.uri);
                    if (response != null && response.code == 200)
                    {
                        ThreadUtils.runOnUiThread(response. new Runnable() {

                            final ImageButton._cls2 this$2;
                            final com.millennialmedia.internal.utils.HttpUtils.Response val$response;

                            public void run()
                            {
                                setImageBitmap(response.bitmap);
                            }

            
            {
                this$2 = final__pcls2;
                response = com.millennialmedia.internal.utils.HttpUtils.Response.this;
                super();
            }
                        });
                    }
                }

            
            {
                this$1 = ImageButton.this;
                super();
            }
            });
        }

        int getOffset()
        {
            if (offset == null)
            {
                offset = Integer.valueOf(vastTimeToMilliseconds(button.offset));
            }
            return offset.intValue();
        }

        public void onClick(View view)
        {
            fireOnClick();
            view = button.buttonClicks;
            if (view != null)
            {
                if (!Utils.isEmpty(((VASTParser.ButtonClicks) (view)).clickThrough))
                {
                    Utils.startActivityFromUrl(((VASTParser.ButtonClicks) (view)).clickThrough);
                }
                if (((VASTParser.ButtonClicks) (view)).clickTrackingUrls != null)
                {
                    ThreadUtils.runOnWorkerThread(view. new Runnable() {

                        final ImageButton this$1;
                        final VASTParser.ButtonClicks val$buttonClicks;

                        public void run()
                        {
                            Iterator iterator = buttonClicks.clickTrackingUrls.iterator();
                            do
                            {
                                if (!iterator.hasNext())
                                {
                                    break;
                                }
                                String s = (String)iterator.next();
                                if (!Utils.isEmpty(s))
                                {
                                    HttpUtils.getContentFromGetRequest(s);
                                }
                            } while (true);
                        }

            
            {
                this$1 = final_imagebutton;
                buttonClicks = VASTParser.ButtonClicks.this;
                super();
            }
                    });
                }
            }
        }

        boolean updateVisibility(int i)
        {
            if (i >= getOffset())
            {
                ThreadUtils.runOnUiThread(new Runnable() {

                    final ImageButton this$1;

                    public void run()
                    {
                        setVisibility(0);
                    }

            
            {
                this$1 = ImageButton.this;
                super();
            }
                });
                return true;
            } else
            {
                return false;
            }
        }

        ImageButton(Context context, VASTParser.Button button1)
        {
            this$0 = VASTVideoView.this;
            super(context);
            offset = null;
            button = null;
            button = button1;
            if (getOffset() > 0)
            {
                setVisibility(4);
            }
            loadStaticResource();
            setOnClickListener(this);
        }
    }

    public static interface VASTVideoViewListener
    {

        public abstract void onClicked();

        public abstract void onFailed();

        public abstract void onLoaded();
    }

    public class VASTVideoWebView extends MMWebView
    {

        volatile int lastUpdateTime;
        final VASTVideoView this$0;
        int updateTimeInterval;

        public void close()
        {
            VASTVideoView.this.close();
        }

        public void pause()
        {
            if (currentState != 2)
            {
                mmVideoView.pause();
            }
        }

        public void play()
        {
            if (currentState != 2)
            {
                mmVideoView.start();
            }
        }

        public void restart()
        {
            ThreadUtils.runOnUiThread(new Runnable() {

                final VASTVideoWebView this$1;

                public void run()
                {
                    replay();
                }

            
            {
                this$1 = VASTVideoWebView.this;
                super();
            }
            });
        }

        public void seek(int i)
        {
            if (currentState != 2)
            {
                mmVideoView.seekTo(i);
            }
        }

        public void setTimeInterval(int i)
        {
            updateTimeInterval = i;
        }

        public void skip()
        {
            if (currentState != 2)
            {
                canSkip = true;
                ThreadUtils.runOnUiThread(new Runnable() {

                    final VASTVideoWebView this$1;

                    public void run()
                    {
                        enableSkipControls();
                        skip();
                    }

            
            {
                this$1 = VASTVideoWebView.this;
                super();
            }
                });
            }
        }

        public void triggerTimeUpdate()
        {
            callJavascript("MmJsBridge.vast.setCurrentTime", new Object[] {
                Integer.valueOf(mmVideoView.getCurrentPosition())
            });
        }

        void updateTime(int i)
        {
            if (updateTimeInterval != -1 && (lastUpdateTime == 0 || lastUpdateTime + updateTimeInterval <= i))
            {
                lastUpdateTime = i;
                callJavascript("MmJsBridge.vast.setCurrentTime", new Object[] {
                    Integer.valueOf(i)
                });
            }
        }

        VASTVideoWebView(Context context, boolean flag, com.millennialmedia.internal.MMWebView.MMWebViewListener mmwebviewlistener)
        {
            this$0 = VASTVideoView.this;
            super(context, true, flag, mmwebviewlistener);
            updateTimeInterval = -1;
            lastUpdateTime = 0;
        }
    }


    private static final int CACHE_EXPIRATION_TIME = 0x2932e00;
    private static final int COMPANION_AD_MIN_HEIGHT = 250;
    private static final int COMPANION_AD_MIN_WIDTH = 300;
    private static final int COMPLETE = 2;
    private static final int DEFAULT_MAX_BITRATE = 800;
    private static final int IDLE = 0;
    private static final String IMAGE_BMP = "image/bmp";
    private static final String IMAGE_GIF = "image/gif";
    private static final String IMAGE_JPEG = "image/jpeg";
    private static final String IMAGE_PNG = "image/png";
    private static final int LTE_MAX_BITRATE = 800;
    private static final int MIN_BITRATE = 400;
    private static final int PLAYBACK = 1;
    private static final String PROGRESSIVE = "progressive";
    public static final int PROGRESS_UPDATES_DISABLED = -1;
    private static final String TAG = com/millennialmedia/internal/video/VASTVideoView.getSimpleName();
    private static final String VIDEO_MP4 = "video/mp4";
    private static final int WIFI_MAX_BITRATE = 1200;
    private static final List supportImageTypes;
    private FrameLayout backgroundFrame;
    private VASTVideoWebView backgroundWebView;
    private LinearLayout buttonContainer;
    private volatile boolean canSkip;
    private ImageView closeButton;
    private VASTVideoWebView companionAdWebView;
    private RelativeLayout controlButtonContainer;
    private TextView countdown;
    private volatile int currentState;
    private FrameLayout endCardContainer;
    private com.millennialmedia.internal.utils.ViewUtils.ViewabilityWatcher endCardViewabilityWatcher;
    private List firedTrackingEvents;
    private com.millennialmedia.internal.utils.ViewUtils.ViewabilityWatcher impressionViewabilityWatcher;
    private VASTParser.InLineAd inLineAd;
    private int lastKnownOrientation;
    private int lastQuartileFired;
    private MMVideoView mmVideoView;
    private VASTVideoWebView overlayWebView;
    private ImageView replayButton;
    private VASTParser.CompanionAd selectedCompanionAd;
    private VASTParser.Creative selectedCreative;
    private VASTParser.MediaFile selectedMediaFile;
    private ImageView skipButton;
    private int skipOffsetMilliseconds;
    private VASTVideoViewListener vastVideoViewListener;
    private File videoFile;
    private com.millennialmedia.internal.utils.ViewUtils.ViewabilityWatcher videoViewabilityWatcher;
    private List wrapperAds;

    public VASTVideoView(Context context, VASTParser.InLineAd inlinead, List list, VASTVideoViewListener vastvideoviewlistener)
    {
        super(context);
        canSkip = false;
        currentState = 0;
        overlayWebView = null;
        companionAdWebView = null;
        backgroundWebView = null;
        lastQuartileFired = 0;
        lastKnownOrientation = 0;
        inLineAd = inlinead;
        wrapperAds = list;
        setBackgroundColor(0xff000000);
        android.widget.FrameLayout.LayoutParams layoutparams;
        if (isPortrait())
        {
            lastKnownOrientation = 1;
        } else
        {
            lastKnownOrientation = 2;
        }
        firedTrackingEvents = new ArrayList();
        vastVideoViewListener = vastvideoviewlistener;
        impressionViewabilityWatcher = new com.millennialmedia.internal.utils.ViewUtils.ViewabilityWatcher(this, new com.millennialmedia.internal.utils.ViewUtils.ViewabilityListener() {

            final VASTVideoView this$0;

            public void onViewableChanged(boolean flag)
            {
                if (flag)
                {
                    fireImpressions();
                }
            }

            
            {
                this$0 = VASTVideoView.this;
                super();
            }
        });
        vastvideoviewlistener = new FrameLayout(getContext());
        list = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        addView(vastvideoviewlistener, list);
        backgroundFrame = new FrameLayout(context);
        layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        vastvideoviewlistener.addView(backgroundFrame, layoutparams);
        mmVideoView = new MMVideoView(context, true, false, this);
        videoViewabilityWatcher = new com.millennialmedia.internal.utils.ViewUtils.ViewabilityWatcher(mmVideoView, new com.millennialmedia.internal.utils.ViewUtils.ViewabilityListener() {

            private boolean didPause;
            final VASTVideoView this$0;

            public void onViewableChanged(boolean flag)
            {
                if (flag)
                {
                    List list1 = getWrapperLinearTrackingEvents(VASTParser.TrackableEvent.creativeView);
                    fireTrackingEvents(list1);
                    if (selectedCreative != null && selectedCreative.linearAd.trackingEvents != null)
                    {
                        List list2 = (List)selectedCreative.linearAd.trackingEvents.get(VASTParser.TrackableEvent.creativeView);
                        fireTrackingEvents(list2);
                    }
                }
                if (!flag)
                {
                    didPause = true;
                    mmVideoView.pause();
                } else
                if (didPause)
                {
                    mmVideoView.start();
                    return;
                }
            }

            
            {
                this$0 = VASTVideoView.this;
                super();
                didPause = false;
            }
        });
        if (isPortrait())
        {
            list = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            list.addRule(3, com.millennialmedia.R.id.mmadsdk_vast_video_control_buttons);
        }
        addView(mmVideoView, list);
        endCardContainer = new FrameLayout(context);
        endCardContainer.setVisibility(8);
        endCardViewabilityWatcher = new com.millennialmedia.internal.utils.ViewUtils.ViewabilityWatcher(endCardContainer, new com.millennialmedia.internal.utils.ViewUtils.ViewabilityListener() {

            final VASTVideoView this$0;

            public void onViewableChanged(boolean flag)
            {
                if (flag && selectedCompanionAd.trackingEvents != null && !selectedCompanionAd.trackingEvents.isEmpty())
                {
                    List list1 = (List)selectedCompanionAd.trackingEvents.get(VASTParser.TrackableEvent.creativeView);
                    fireTrackingEvents(list1);
                }
            }

            
            {
                this$0 = VASTVideoView.this;
                super();
            }
        });
        impressionViewabilityWatcher.startWatching();
        videoViewabilityWatcher.startWatching();
        endCardViewabilityWatcher.startWatching();
        list = new android.widget.FrameLayout.LayoutParams(-1, -1);
        vastvideoviewlistener.addView(endCardContainer, list);
        controlButtonContainer = new RelativeLayout(context);
        controlButtonContainer.setId(com.millennialmedia.R.id.mmadsdk_vast_video_control_buttons);
        closeButton = new ImageView(context);
        closeButton.setImageDrawable(getResources().getDrawable(com.millennialmedia.R.drawable.mmadsdk_vast_close));
        closeButton.setVisibility(8);
        closeButton.setOnClickListener(new android.view.View.OnClickListener() {

            final VASTVideoView this$0;

            public void onClick(View view)
            {
                close();
            }

            
            {
                this$0 = VASTVideoView.this;
                super();
            }
        });
        list = new android.widget.RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_control_button_width), getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_control_button_height));
        list.addRule(10);
        list.addRule(11);
        controlButtonContainer.addView(closeButton, list);
        skipButton = new ImageView(context);
        skipButton.setImageDrawable(getResources().getDrawable(com.millennialmedia.R.drawable.mmadsdk_vast_skip));
        countdown = new TextView(context);
        countdown.setBackground(getResources().getDrawable(com.millennialmedia.R.drawable.mmadsdk_vast_opacity));
        countdown.setTextColor(getResources().getColor(0x106000b));
        countdown.setTypeface(null, 1);
        countdown.setGravity(17);
        countdown.setVisibility(4);
        list = new android.widget.RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_control_button_width), getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_control_button_height));
        list.addRule(10);
        list.addRule(11);
        controlButtonContainer.addView(skipButton, list);
        controlButtonContainer.addView(countdown, list);
        replayButton = new ImageView(context);
        replayButton.setImageDrawable(getResources().getDrawable(com.millennialmedia.R.drawable.mmadsdk_vast_replay));
        replayButton.setVisibility(8);
        replayButton.setOnClickListener(new android.view.View.OnClickListener() {

            final VASTVideoView this$0;

            public void onClick(View view)
            {
                fireOnClick();
                replay();
            }

            
            {
                this$0 = VASTVideoView.this;
                super();
            }
        });
        list = new android.widget.RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_control_button_width), getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_control_button_height));
        list.addRule(10);
        list.addRule(9);
        controlButtonContainer.addView(replayButton, list);
        list = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        list.addRule(10);
        addView(controlButtonContainer, list);
        list = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        list.addRule(12);
        buttonContainer = new LinearLayout(getContext());
        addView(buttonContainer, list);
        loadInlineAd(context);
        if (isPortrait())
        {
            if (inlinead != null && inlinead.mmExtension != null && inlinead.mmExtension.background != null && inlinead.mmExtension.background.hideButtons)
            {
                buttonContainer.setVisibility(4);
            } else
            {
                buttonContainer.setVisibility(0);
            }
        } else
        if (inlinead != null && inlinead.mmExtension != null && inlinead.mmExtension.overlay != null && inlinead.mmExtension.overlay.hideButtons)
        {
            buttonContainer.setVisibility(4);
        } else
        {
            buttonContainer.setVisibility(0);
        }
        currentState = 1;
    }

    private void close()
    {
        if (selectedCreative != null && selectedCreative.linearAd.trackingEvents != null)
        {
            fireTrackingEvents(getWrapperLinearTrackingEvents(VASTParser.TrackableEvent.closeLinear));
            fireTrackingEvents((List)selectedCreative.linearAd.trackingEvents.get(VASTParser.TrackableEvent.closeLinear));
        }
        Activity activity = ViewUtils.getActivityForView(this);
        if (activity != null)
        {
            activity.finish();
        }
    }

    private void complete()
    {
        currentState = 2;
        countdown.setVisibility(8);
        if (selectedCompanionAd != null && endCardContainer.getChildCount() > 0)
        {
            mmVideoView.setVisibility(8);
            replayButton.setVisibility(0);
            skipButton.setVisibility(8);
            closeButton.setVisibility(0);
            backgroundFrame.setVisibility(8);
            endCardContainer.setVisibility(0);
            for (int i = 0; i < buttonContainer.getChildCount(); i++)
            {
                View view = buttonContainer.getChildAt(i);
                if (!(view instanceof FrameLayout))
                {
                    continue;
                }
                view = ((FrameLayout)view).getChildAt(0);
                if (view != null)
                {
                    view.setVisibility(0);
                }
            }

            if (selectedCompanionAd.hideButtons)
            {
                buttonContainer.setVisibility(4);
                return;
            } else
            {
                buttonContainer.setVisibility(0);
                return;
            }
        } else
        {
            close();
            return;
        }
    }

    private void createCompanionWebView(String s)
    {
        companionAdWebView = new VASTVideoWebView(getContext(), false, new com.millennialmedia.internal.MMWebView.MMWebViewListener() {

            final VASTVideoView this$0;

            public void close()
            {
            }

            public boolean expand(com.millennialmedia.internal.SizableStateManager.ExpandParams expandparams)
            {
                return false;
            }

            public void onAdLeftApplication()
            {
            }

            public void onClicked()
            {
                fireOnClick();
            }

            public void onFailed()
            {
            }

            public void onLoaded()
            {
            }

            public void onReady()
            {
                companionAdWebView.callJavascript("MmJsBridge.vast.enableWebOverlay", new Object[0]);
                companionAdWebView.callJavascript("MmJsBridge.vast.setDuration", new Object[] {
                    Integer.valueOf(mmVideoView.getDuration())
                });
                companionAdWebView.callJavascript("MmJsBridge.vast.setState", new Object[] {
                    "complete"
                });
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
                this$0 = VASTVideoView.this;
                super();
            }
        });
        loadContentIntoWebView(companionAdWebView, s);
    }

    private void enableSkipControls()
    {
        countdown.setVisibility(8);
        skipButton.setOnClickListener(new android.view.View.OnClickListener() {

            final VASTVideoView this$0;

            public void onClick(View view)
            {
                skip();
            }

            
            {
                this$0 = VASTVideoView.this;
                super();
            }
        });
    }

    private void fireImpressions()
    {
        if (inLineAd != null && inLineAd.impressions != null)
        {
            impressionViewabilityWatcher.stopWatching();
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final VASTVideoView this$0;

                public void run()
                {
                    Iterator iterator = inLineAd.impressions.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        String s = (String)iterator.next();
                        if (!Utils.isEmpty(s))
                        {
                            if (MMLog.isDebugEnabled())
                            {
                                MMLog.d(VASTVideoView.TAG, (new StringBuilder()).append("Firing impression url = ").append(s).toString());
                            }
                            HttpUtils.getContentFromGetRequest(s);
                        }
                    } while (true);
                    if (wrapperAds != null)
                    {
                        for (Iterator iterator1 = wrapperAds.iterator(); iterator1.hasNext();)
                        {
                            Object obj = (VASTParser.WrapperAd)iterator1.next();
                            if (((VASTParser.WrapperAd) (obj)).impressions != null)
                            {
                                obj = ((VASTParser.WrapperAd) (obj)).impressions.iterator();
                                while (((Iterator) (obj)).hasNext()) 
                                {
                                    String s1 = (String)((Iterator) (obj)).next();
                                    if (!Utils.isEmpty(s1))
                                    {
                                        if (MMLog.isDebugEnabled())
                                        {
                                            MMLog.d(VASTVideoView.TAG, (new StringBuilder()).append("Firing wrapper impression url = ").append(s1).toString());
                                        }
                                        HttpUtils.getContentFromGetRequest(s1);
                                    }
                                }
                            }
                        }

                    }
                }

            
            {
                this$0 = VASTVideoView.this;
                super();
            }
            });
        }
    }

    private void fireOnClick()
    {
        ThreadUtils.runOnWorkerThread(new Runnable() {

            final VASTVideoView this$0;

            public void run()
            {
                if (vastVideoViewListener != null)
                {
                    vastVideoViewListener.onClicked();
                }
            }

            
            {
                this$0 = VASTVideoView.this;
                super();
            }
        });
    }

    private void fireTrackingEvent(VASTParser.TrackingEvent trackingevent)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Firing tracking url = ").append(trackingevent.url).toString());
        }
        firedTrackingEvents.add(trackingevent);
        HttpUtils.getContentFromGetRequest(trackingevent.url);
    }

    private void fireTrackingEvents(final List trackingEvents)
    {
        if (trackingEvents != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final VASTVideoView this$0;
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
                        VASTParser.TrackingEvent trackingevent = (VASTParser.TrackingEvent)iterator.next();
                        if (trackingevent != null && !Utils.isEmpty(trackingevent.url) && !firedTrackingEvents.contains(trackingevent))
                        {
                            fireTrackingEvent(trackingevent);
                        }
                    } while (true);
                }

            
            {
                this$0 = VASTVideoView.this;
                trackingEvents = list;
                super();
            }
            });
        }
    }

    private int getBackgroundColor(VASTParser.StaticResource staticresource)
    {
        int j = 0xff000000;
        int i = j;
        if (staticresource != null)
        {
            i = j;
            if (staticresource.backgroundColor != null)
            {
                try
                {
                    i = Color.parseColor(staticresource.backgroundColor);
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    MMLog.w(TAG, (new StringBuilder()).append("Invalid hex color format specified = ").append(staticresource.backgroundColor).toString());
                    return 0xff000000;
                }
            }
        }
        return i;
    }

    private List getWrapperLinearTrackingEvents(VASTParser.TrackableEvent trackableevent)
    {
        ArrayList arraylist = new ArrayList();
        if (wrapperAds != null)
        {
            for (Iterator iterator = wrapperAds.iterator(); iterator.hasNext();)
            {
                Object obj = (VASTParser.WrapperAd)iterator.next();
                if (((VASTParser.WrapperAd) (obj)).creatives != null)
                {
                    obj = ((VASTParser.WrapperAd) (obj)).creatives.iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        Object obj1 = (VASTParser.Creative)((Iterator) (obj)).next();
                        if (((VASTParser.Creative) (obj1)).linearAd != null && ((VASTParser.Creative) (obj1)).linearAd.trackingEvents != null)
                        {
                            obj1 = (List)((VASTParser.Creative) (obj1)).linearAd.trackingEvents.get(trackableevent);
                            if (obj1 != null)
                            {
                                arraylist.addAll(((java.util.Collection) (obj1)));
                            }
                        }
                    }
                }
            }

        }
        return arraylist;
    }

    private List getWrapperVideoClicks()
    {
        ArrayList arraylist = new ArrayList();
        if (wrapperAds != null)
        {
            for (Iterator iterator = wrapperAds.iterator(); iterator.hasNext();)
            {
                Object obj = (VASTParser.WrapperAd)iterator.next();
                if (((VASTParser.WrapperAd) (obj)).creatives != null)
                {
                    obj = ((VASTParser.WrapperAd) (obj)).creatives.iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        VASTParser.Creative creative = (VASTParser.Creative)((Iterator) (obj)).next();
                        if (creative.linearAd != null && creative.linearAd.videoClicks != null)
                        {
                            arraylist.add(creative.linearAd.videoClicks);
                        }
                    }
                }
            }

        }
        return arraylist;
    }

    private boolean isPortrait()
    {
        return getResources().getConfiguration().orientation != 2;
    }

    private void loadBackground()
    {
        if (inLineAd.mmExtension != null && inLineAd.mmExtension.background != null)
        {
            final VASTParser.Background background = inLineAd.mmExtension.background;
            if (background.staticResource != null && !Utils.isEmpty(background.staticResource.uri))
            {
                final ImageView backgroundImageView = new ImageView(getContext());
                backgroundFrame.addView(backgroundImageView);
                backgroundFrame.setBackgroundColor(getBackgroundColor(background.staticResource));
                ThreadUtils.runOnWorkerThread(new Runnable() {

                    final VASTVideoView this$0;
                    final VASTParser.Background val$background;
                    final ImageView val$backgroundImageView;

                    public void run()
                    {
                        com.millennialmedia.internal.utils.HttpUtils.Response response = HttpUtils.getBitmapFromGetRequest(background.staticResource.uri);
                        if (response.code == 200)
                        {
                            ThreadUtils.runOnUiThread(response. new Runnable() {

                                final _cls11 this$1;
                                final com.millennialmedia.internal.utils.HttpUtils.Response val$response;

                                public void run()
                                {
                                    backgroundImageView.setImageBitmap(response.bitmap);
                                }

            
            {
                this$1 = final__pcls11;
                response = com.millennialmedia.internal.utils.HttpUtils.Response.this;
                super();
            }
                            });
                        }
                    }

            
            {
                this$0 = VASTVideoView.this;
                background = background1;
                backgroundImageView = imageview;
                super();
            }
                });
            } else
            if (background.webResource != null && !Utils.isEmpty(background.webResource.uri))
            {
                backgroundWebView = new VASTVideoWebView(getContext(), false, new com.millennialmedia.internal.MMWebView.MMWebViewListener() {

                    final VASTVideoView this$0;

                    public void close()
                    {
                    }

                    public boolean expand(com.millennialmedia.internal.SizableStateManager.ExpandParams expandparams)
                    {
                        return false;
                    }

                    public void onAdLeftApplication()
                    {
                    }

                    public void onClicked()
                    {
                        fireOnClick();
                    }

                    public void onFailed()
                    {
                    }

                    public void onLoaded()
                    {
                    }

                    public void onReady()
                    {
                        backgroundWebView.callJavascript("MmJsBridge.vast.enableWebOverlay", new Object[0]);
                        backgroundWebView.callJavascript("MmJsBridge.vast.setDuration", new Object[] {
                            Integer.valueOf(mmVideoView.getDuration())
                        });
                        if (mmVideoView.isPlaying())
                        {
                            backgroundWebView.callJavascript("MmJsBridge.vast.setState", new Object[] {
                                "playing"
                            });
                        }
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
                this$0 = VASTVideoView.this;
                super();
            }
                });
                backgroundFrame.addView(backgroundWebView);
                loadContentIntoWebView(backgroundWebView, background.webResource.uri);
                return;
            }
        }
    }

    private void loadButtons()
    {
        if (inLineAd.mmExtension != null && inLineAd.mmExtension.buttons != null)
        {
            Collections.sort(inLineAd.mmExtension.buttons, new Comparator() {

                final VASTVideoView this$0;

                public int compare(VASTParser.Button button, VASTParser.Button button1)
                {
                    return button.position - button1.position;
                }

                public volatile int compare(Object obj2, Object obj3)
                {
                    return compare((VASTParser.Button)obj2, (VASTParser.Button)obj3);
                }

            
            {
                this$0 = VASTVideoView.this;
                super();
            }
            });
            int i = 0;
            int k = getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_ad_button_width);
            int l = getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_ad_button_height);
            Iterator iterator = inLineAd.mmExtension.buttons.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (VASTParser.Button)iterator.next();
                if (i >= 3)
                {
                    break;
                }
                if (((VASTParser.Button) (obj)).staticResource != null && !Utils.isEmpty(((VASTParser.Button) (obj)).staticResource.uri) && !Utils.isEmpty(((VASTParser.Button) (obj)).staticResource.creativeType) && ((VASTParser.Button) (obj)).staticResource.creativeType.trim().equalsIgnoreCase("image/png"))
                {
                    int j = i + 1;
                    Object obj1 = new ImageButton(getContext(), ((VASTParser.Button) (obj)));
                    obj = new FrameLayout(getContext());
                    ((FrameLayout) (obj)).addView(((View) (obj1)), new android.widget.FrameLayout.LayoutParams(-1, -1));
                    if (isPortrait())
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    obj1 = new android.widget.LinearLayout.LayoutParams(k, l, i);
                    if (!isPortrait())
                    {
                        obj1.leftMargin = getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_ad_button_padding_left);
                    }
                    buttonContainer.addView(((View) (obj)), ((android.view.ViewGroup.LayoutParams) (obj1)));
                    i = j;
                }
            } while (true);
        }
    }

    private void loadCompanionAd()
    {
label0:
        {
            if (selectedCreative.companionAds == null || selectedCreative.companionAds.isEmpty())
            {
                break label0;
            }
            Iterator iterator = selectedCreative.companionAds.iterator();
            VASTParser.CompanionAd companionad;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                companionad = (VASTParser.CompanionAd)iterator.next();
            } while (companionad == null || companionad.width < 300 || companionad.height < 250 || (companionad.staticResource == null || Utils.isEmpty(companionad.staticResource.uri) || !supportImageTypes.contains(companionad.staticResource.creativeType)) && (companionad.htmlResource == null || Utils.isEmpty(companionad.htmlResource.uri)) && (companionad.iframeResource == null || Utils.isEmpty(companionad.iframeResource.uri)));
            selectedCompanionAd = companionad;
        }
        if (selectedCompanionAd != null)
        {
            if (selectedCompanionAd.iframeResource != null && !Utils.isEmpty(selectedCompanionAd.iframeResource.uri))
            {
                createCompanionWebView(selectedCompanionAd.iframeResource.uri);
                android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
                endCardContainer.addView(companionAdWebView, layoutparams);
            } else
            {
                if (selectedCompanionAd.htmlResource != null && !Utils.isEmpty(selectedCompanionAd.htmlResource.uri))
                {
                    createCompanionWebView(selectedCompanionAd.htmlResource.uri);
                    android.widget.FrameLayout.LayoutParams layoutparams1 = new android.widget.FrameLayout.LayoutParams(-1, -1);
                    endCardContainer.addView(companionAdWebView, layoutparams1);
                    return;
                }
                if (selectedCompanionAd.staticResource != null && !Utils.isEmpty(selectedCompanionAd.staticResource.uri))
                {
                    ThreadUtils.runOnWorkerThread(new Runnable() {

                        final VASTVideoView this$0;

                        public void run()
                        {
                            com.millennialmedia.internal.utils.HttpUtils.Response response = HttpUtils.getBitmapFromGetRequest(selectedCompanionAd.staticResource.uri);
                            if (response != null && response.code == 200)
                            {
                                ThreadUtils.runOnUiThread(response. new Runnable() {

                                    final _cls9 this$1;
                                    final com.millennialmedia.internal.utils.HttpUtils.Response val$response;

                                    public void run()
                                    {
                                        ImageView imageview = new ImageView(getContext());
                                        imageview.setImageBitmap(response.bitmap);
                                        imageview.setOnClickListener(new android.view.View.OnClickListener() {

                                            final _cls1 this$2;

                                            public void onClick(View view)
                                            {
                                                fireOnClick();
                                                if (!Utils.isEmpty(selectedCompanionAd.companionClickThrough))
                                                {
                                                    Utils.startActivityFromUrl(selectedCompanionAd.companionClickThrough);
                                                }
                                                if (selectedCompanionAd != null)
                                                {
                                                    ThreadUtils.runOnWorkerThread(new Runnable() {

                                                        final _cls1 this$3;

                                                        public void run()
                                                        {
                                                            Iterator iterator = selectedCompanionAd.companionClickTracking.iterator();
                                                            do
                                                            {
                                                                if (!iterator.hasNext())
                                                                {
                                                                    break;
                                                                }
                                                                String s = (String)iterator.next();
                                                                if (!Utils.isEmpty(s))
                                                                {
                                                                    HttpUtils.getContentFromGetRequest(s);
                                                                }
                                                            } while (true);
                                                        }

            
            {
                this$3 = _cls1.this;
                super();
            }
                                                    });
                                                }
                                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                                        });
                                        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
                                        endCardContainer.setBackgroundColor(getBackgroundColor(selectedCompanionAd.staticResource));
                                        endCardContainer.addView(imageview, layoutparams);
                                    }

            
            {
                this$1 = final__pcls9;
                response = com.millennialmedia.internal.utils.HttpUtils.Response.this;
                super();
            }
                                });
                            }
                        }

            
            {
                this$0 = VASTVideoView.this;
                super();
            }
                    });
                    return;
                }
            }
        }
    }

    private void loadContentIntoWebView(final VASTVideoWebView vastVideoWebView, final String uri)
    {
        ThreadUtils.runOnWorkerThread(new Runnable() {

            final VASTVideoView this$0;
            final String val$uri;
            final VASTVideoWebView val$vastVideoWebView;

            public void run()
            {
                com.millennialmedia.internal.utils.HttpUtils.Response response = HttpUtils.getContentFromGetRequest(uri);
                if (response.code == 200 && !Utils.isEmpty(response.content))
                {
                    ThreadUtils.runOnUiThread(response. new Runnable() {

                        final _cls8 this$1;
                        final com.millennialmedia.internal.utils.HttpUtils.Response val$response;

                        public void run()
                        {
                            vastVideoWebView.setContent(response.content);
                        }

            
            {
                this$1 = final__pcls8;
                response = com.millennialmedia.internal.utils.HttpUtils.Response.this;
                super();
            }
                    });
                }
            }

            
            {
                this$0 = VASTVideoView.this;
                uri = s;
                vastVideoWebView = vastvideowebview;
                super();
            }
        });
    }

    private void loadInlineAd(Context context)
    {
label0:
        {
            if (inLineAd.creatives == null)
            {
                break label0;
            }
            Iterator iterator = inLineAd.creatives.iterator();
            VASTParser.Creative creative;
            VASTParser.MediaFile mediafile;
            do
            {
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    creative = (VASTParser.Creative)iterator.next();
                } while (creative.linearAd == null);
                mediafile = selectMediaFile(creative.linearAd.mediaFiles);
            } while (mediafile == null);
            selectedMediaFile = mediafile;
            selectedCreative = creative;
        }
        if (selectedMediaFile != null)
        {
            context = context.getExternalFilesDir(null);
            context = new File((new StringBuilder()).append(context.getAbsolutePath()).append(File.separator).append("_mm_video_cache").toString());
            context.mkdirs();
            File afile[] = context.listFiles();
            if (afile != null)
            {
                int j = afile.length;
                for (int i = 0; i < j; i++)
                {
                    File file = afile[i];
                    if (!file.isFile())
                    {
                        continue;
                    }
                    long l = file.lastModified();
                    if (System.currentTimeMillis() - l > 0x2932e00L)
                    {
                        file.delete();
                    }
                }

            }
            IOUtils.downloadFile(selectedMediaFile.url.trim(), null, context, new com.millennialmedia.internal.utils.IOUtils.DownloadListener() {

                final VASTVideoView this$0;

                public void onDownloadFailed(Throwable throwable)
                {
                    MMLog.e(VASTVideoView.TAG, "Error occurred downloading the video file.", throwable);
                    vastVideoViewListener.onFailed();
                }

                public void onDownloadSucceeded(File file1)
                {
                    ThreadUtils.runOnUiThread(file1. new Runnable() {

                        final _cls6 this$1;
                        final File val$downloadedFile;

                        public void run()
                        {
                            videoFile = downloadedFile;
                            mmVideoView.setVideoURI(Uri.parse(downloadedFile.getAbsolutePath()));
                            registerVideoClicks();
                        }

            
            {
                this$1 = final__pcls6;
                downloadedFile = File.this;
                super();
            }
                    });
                }

            
            {
                this$0 = VASTVideoView.this;
                super();
            }
            });
            loadButtons();
            if (isPortrait())
            {
                loadBackground();
                backgroundFrame.setVisibility(0);
            } else
            {
                backgroundFrame.setVisibility(8);
                loadOverlay();
            }
            loadCompanionAd();
            return;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "VAST init failed because it did not contain a compatible media file.");
        }
        vastVideoViewListener.onFailed();
    }

    private void loadOverlay()
    {
        if (inLineAd.mmExtension != null && inLineAd.mmExtension.overlay != null && !Utils.isEmpty(inLineAd.mmExtension.overlay.uri))
        {
            overlayWebView = new VASTVideoWebView(getContext(), true, new com.millennialmedia.internal.MMWebView.MMWebViewListener() {

                final VASTVideoView this$0;

                public void close()
                {
                }

                public boolean expand(com.millennialmedia.internal.SizableStateManager.ExpandParams expandparams)
                {
                    return false;
                }

                public void onAdLeftApplication()
                {
                }

                public void onClicked()
                {
                    fireOnClick();
                }

                public void onFailed()
                {
                }

                public void onLoaded()
                {
                }

                public void onReady()
                {
                    overlayWebView.callJavascript("MmJsBridge.vast.enableWebOverlay", new Object[0]);
                    overlayWebView.callJavascript("MmJsBridge.vast.setDuration", new Object[] {
                        Integer.valueOf(mmVideoView.getDuration())
                    });
                    if (mmVideoView.isPlaying())
                    {
                        overlayWebView.callJavascript("MmJsBridge.vast.setState", new Object[] {
                            "playing"
                        });
                    }
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
                this$0 = VASTVideoView.this;
                super();
            }
            });
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            mmVideoView.addView(overlayWebView, layoutparams);
            loadContentIntoWebView(overlayWebView, inLineAd.mmExtension.overlay.uri);
        }
    }

    private void registerVideoClicks()
    {
        final VASTParser.VideoClicks videoClicks = selectedCreative.linearAd.videoClicks;
        if (videoClicks != null && (!Utils.isEmpty(videoClicks.clickThrough) || videoClicks.customClickUrls != null && !videoClicks.customClickUrls.isEmpty()))
        {
            mmVideoView.setOnClickListener(new android.view.View.OnClickListener() {

                final VASTVideoView this$0;
                final VASTParser.VideoClicks val$videoClicks;

                public void onClick(View view)
                {
                    fireOnClick();
                    view = new Runnable() {

                        final _cls14 this$1;

                        public void run()
                        {
                            for (Iterator iterator = getWrapperVideoClicks().iterator(); iterator.hasNext();)
                            {
                                Iterator iterator2 = ((VASTParser.VideoClicks)iterator.next()).clickTrackingUrls.iterator();
                                while (iterator2.hasNext()) 
                                {
                                    String s1 = (String)iterator2.next();
                                    if (!Utils.isEmpty(s1))
                                    {
                                        if (MMLog.isDebugEnabled())
                                        {
                                            MMLog.d(VASTVideoView.TAG, (new StringBuilder()).append("Firing wrapper video click tracker url = ").append(s1).toString());
                                        }
                                        HttpUtils.getContentFromGetRequest(s1);
                                    }
                                }
                            }

                            Iterator iterator1 = videoClicks.clickTrackingUrls.iterator();
                            do
                            {
                                if (!iterator1.hasNext())
                                {
                                    break;
                                }
                                String s = (String)iterator1.next();
                                if (!Utils.isEmpty(s))
                                {
                                    if (MMLog.isDebugEnabled())
                                    {
                                        MMLog.d(VASTVideoView.TAG, (new StringBuilder()).append("Firing video click tracker url = ").append(s).toString());
                                    }
                                    HttpUtils.getContentFromGetRequest(s);
                                }
                            } while (true);
                        }

            
            {
                this$1 = _cls14.this;
                super();
            }
                    };
                    if (!Utils.isEmpty(videoClicks.clickThrough))
                    {
                        Utils.startActivityFromUrl(videoClicks.clickThrough);
                        ThreadUtils.runOnWorkerThread(view);
                        return;
                    } else
                    {
                        ThreadUtils.runOnWorkerThread(view. new Runnable() {

                            final _cls14 this$1;
                            final Runnable val$fireClickTrackers;

                            public void run()
                            {
                                Iterator iterator = videoClicks.customClickUrls.iterator();
                                do
                                {
                                    if (!iterator.hasNext())
                                    {
                                        break;
                                    }
                                    String s = (String)iterator.next();
                                    if (!Utils.isEmpty(s))
                                    {
                                        HttpUtils.getContentFromGetRequest(s);
                                    }
                                } while (true);
                                fireClickTrackers.run();
                            }

            
            {
                this$1 = final__pcls14;
                fireClickTrackers = Runnable.this;
                super();
            }
                        });
                        return;
                    }
                }

            
            {
                this$0 = VASTVideoView.this;
                videoClicks = videoclicks;
                super();
            }
            });
        }
    }

    private void replay()
    {
        currentState = 1;
        if (overlayWebView != null)
        {
            overlayWebView.lastUpdateTime = 0;
        }
        if (backgroundWebView != null)
        {
            backgroundWebView.lastUpdateTime = 0;
        }
        if (isPortrait())
        {
            backgroundFrame.setVisibility(0);
            endCardContainer.setVisibility(8);
            if (inLineAd != null && inLineAd.mmExtension != null && inLineAd.mmExtension.background != null && inLineAd.mmExtension.background.hideButtons)
            {
                buttonContainer.setVisibility(4);
            } else
            {
                buttonContainer.setVisibility(0);
            }
        } else
        {
            backgroundFrame.setVisibility(8);
            endCardContainer.setVisibility(8);
            if (inLineAd != null && inLineAd.mmExtension != null && inLineAd.mmExtension.overlay != null && inLineAd.mmExtension.overlay.hideButtons)
            {
                buttonContainer.setVisibility(4);
            } else
            {
                buttonContainer.setVisibility(0);
            }
        }
        replayButton.setVisibility(8);
        closeButton.setVisibility(8);
        skipButton.setVisibility(0);
        mmVideoView.setVisibility(0);
        mmVideoView.restart();
    }

    private VASTParser.MediaFile selectMediaFile(List list)
    {
        if (list != null && !list.isEmpty()) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((VASTParser.MediaFile) (obj));
_L2:
        obj = EnvironmentUtils.getNetworkConnectionType();
        char c = '\u0320';
        Iterator iterator;
        boolean flag2;
        boolean flag3;
        if ("wifi".equalsIgnoreCase(((String) (obj))))
        {
            c = '\u04B0';
        } else
        if ("lte".equalsIgnoreCase(((String) (obj))))
        {
            c = '\u0320';
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d("TAG", (new StringBuilder()).append("Using bit rate range ").append(400).append(" to ").append(c).append(" inclusive for network connectivity type = ").append(((String) (obj))).toString());
        }
        obj = null;
        iterator = list.iterator();
        list = ((List) (obj));
        obj = list;
        if (iterator.hasNext())
        {
            obj = (VASTParser.MediaFile)iterator.next();
            if (!Utils.isEmpty(((VASTParser.MediaFile) (obj)).url))
            {
                flag2 = "progressive".equalsIgnoreCase(((VASTParser.MediaFile) (obj)).delivery);
                flag3 = "video/mp4".equalsIgnoreCase(((VASTParser.MediaFile) (obj)).contentType);
                boolean flag;
                boolean flag1;
                if (((VASTParser.MediaFile) (obj)).bitrate >= 400 && ((VASTParser.MediaFile) (obj)).bitrate <= c)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (list == null || ((VASTParser.MediaFile) (list)).bitrate < ((VASTParser.MediaFile) (obj)).bitrate)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag2 && flag3 && flag && flag1)
                {
                    list = ((List) (obj));
                }
            }
            break MISSING_BLOCK_LABEL_107;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void skip()
    {
        if (selectedCreative != null && selectedCreative.linearAd.trackingEvents != null)
        {
            fireTrackingEvents(getWrapperLinearTrackingEvents(VASTParser.TrackableEvent.skip));
            fireTrackingEvents((List)selectedCreative.linearAd.trackingEvents.get(VASTParser.TrackableEvent.skip));
        }
        complete();
    }

    private int vastTimeToMilliseconds(String s)
    {
        Object obj1;
        int i;
        i = 0;
        if (Utils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_269;
        }
        obj1 = s.trim();
        s = ((String) (obj1));
        if (!((String) (obj1)).contains("%"))
        {
            break MISSING_BLOCK_LABEL_73;
        }
        s = ((String) (obj1));
        Object obj = ((String) (obj1)).replace("%", "");
        s = ((String) (obj1));
        if (Utils.isEmpty(((String) (obj))))
        {
            break MISSING_BLOCK_LABEL_272;
        }
        s = ((String) (obj1));
        String as[];
        try
        {
            return (int)((Float.parseFloat(((String) (obj)).trim()) / 100F) * (float)mmVideoView.getDuration());
        }
        catch (NumberFormatException numberformatexception)
        {
            MMLog.e(TAG, (new StringBuilder()).append("VAST time format invalid parse value was: ").append(s).toString());
        }
        break MISSING_BLOCK_LABEL_266;
        s = ((String) (obj1));
        as = ((String) (obj1)).split("\\.");
        s = ((String) (obj1));
        if (as.length > 2)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        i = 0;
        obj = obj1;
        s = ((String) (obj1));
        if (as.length != 2)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        obj = as[0];
        s = ((String) (obj));
        i = Integer.parseInt(as[1]);
        s = ((String) (obj));
        obj1 = ((String) (obj)).split(":");
        s = ((String) (obj));
        if (obj1.length != 3)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        s = ((String) (obj));
        return Integer.parseInt(obj1[0]) * 0x36ee80 + Integer.parseInt(obj1[1]) * 60000 + Integer.parseInt(obj1[2]) * 1000 + i;
        s = ((String) (obj));
        MMLog.e(TAG, (new StringBuilder()).append("VAST time format invalid parse value was: ").append(((String) (obj))).toString());
        return -1;
        s = ((String) (obj1));
        MMLog.e(TAG, (new StringBuilder()).append("VAST time format invalid parse value was: ").append(((String) (obj1))).toString());
        return -1;
        i = -1;
        return i;
        return -1;
    }

    public boolean canSkip()
    {
        return canSkip;
    }

    public void onBufferingUpdate(MMVideoView mmvideoview, int i)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onBufferingUpdate");
        }
    }

    public void onComplete(MMVideoView mmvideoview)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onComplete");
        }
        if (selectedCreative != null && selectedCreative.linearAd.trackingEvents != null)
        {
            fireTrackingEvents(getWrapperLinearTrackingEvents(VASTParser.TrackableEvent.complete));
            fireTrackingEvents((List)selectedCreative.linearAd.trackingEvents.get(VASTParser.TrackableEvent.complete));
        }
        if (overlayWebView != null)
        {
            overlayWebView.callJavascript("MmJsBridge.vast.setState", new Object[] {
                "complete"
            });
        }
        if (backgroundWebView != null)
        {
            backgroundWebView.callJavascript("MmJsBridge.vast.setState", new Object[] {
                "complete"
            });
        }
        ThreadUtils.runOnUiThread(new Runnable() {

            final VASTVideoView this$0;

            public void run()
            {
                complete();
            }

            
            {
                this$0 = VASTVideoView.this;
                super();
            }
        });
    }

    public void onError(MMVideoView mmvideoview)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onError");
        }
        ThreadUtils.runOnWorkerThread(new Runnable() {

            final VASTVideoView this$0;

            public void run()
            {
                if (inLineAd != null && !Utils.isEmpty(inLineAd.error))
                {
                    HttpUtils.getContentFromGetRequest(inLineAd.error);
                }
                if (wrapperAds != null)
                {
                    Iterator iterator = wrapperAds.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        VASTParser.WrapperAd wrapperad = (VASTParser.WrapperAd)iterator.next();
                        if (!Utils.isEmpty(wrapperad.error))
                        {
                            HttpUtils.getContentFromGetRequest(wrapperad.error);
                        }
                    } while (true);
                }
            }

            
            {
                this$0 = VASTVideoView.this;
                super();
            }
        });
        vastVideoViewListener.onFailed();
        if (overlayWebView != null)
        {
            overlayWebView.callJavascript("MmJsBridge.vast.fireErrorEvent", new Object[] {
                "Video playback error occurred."
            });
        }
        if (backgroundWebView != null)
        {
            backgroundWebView.callJavascript("MmJsBridge.vast.fireErrorEvent", new Object[] {
                "Video playback error occurred."
            });
        }
    }

    public void onMuted(MMVideoView mmvideoview)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onMuted");
        }
    }

    public void onPause(MMVideoView mmvideoview)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onPause");
        }
        if (overlayWebView != null)
        {
            overlayWebView.callJavascript("MmJsBridge.vast.setState", new Object[] {
                "paused"
            });
        }
        if (backgroundWebView != null)
        {
            backgroundWebView.callJavascript("MmJsBridge.vast.setState", new Object[] {
                "paused"
            });
        }
    }

    public void onPrepared(MMVideoView mmvideoview)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onPrepared");
        }
        skipOffsetMilliseconds = Math.max(0, vastTimeToMilliseconds(selectedCreative.linearAd.skipOffset));
        vastVideoViewListener.onLoaded();
        if (overlayWebView != null)
        {
            overlayWebView.callJavascript("MmJsBridge.vast.setDuration", new Object[] {
                Integer.valueOf(mmVideoView.getDuration())
            });
        }
        if (backgroundWebView != null)
        {
            backgroundWebView.callJavascript("MmJsBridge.vast.setDuration", new Object[] {
                Integer.valueOf(mmVideoView.getDuration())
            });
        }
    }

    public void onProgress(MMVideoView mmvideoview, int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (overlayWebView != null)
        {
            overlayWebView.updateTime(i);
        }
        if (backgroundWebView != null)
        {
            backgroundWebView.updateTime(i);
        }
        if (buttonContainer == null) goto _L2; else goto _L1
_L1:
        final int timeLeftToSkip = 0;
_L14:
        if (timeLeftToSkip >= buttonContainer.getChildCount()) goto _L2; else goto _L3
_L3:
        View view = buttonContainer.getChildAt(timeLeftToSkip);
        if (view instanceof FrameLayout)
        {
            view = ((FrameLayout)view).getChildAt(0);
            if (view.getVisibility() != 0 && (view instanceof ImageButton))
            {
                ((ImageButton)view).updateVisibility(i);
            }
        }
          goto _L4
_L2:
        if (canSkip) goto _L6; else goto _L5
_L5:
        int j;
        int k;
        j = Handshake.getVASTVideoSkipOffsetMax();
        k = Handshake.getVASTVideoSkipOffsetMin();
        timeLeftToSkip = k;
        if (k > j)
        {
            timeLeftToSkip = j;
        }
        timeLeftToSkip = (Math.min(Math.max(Math.min(j, skipOffsetMilliseconds), timeLeftToSkip), mmvideoview.getDuration()) - i) / 1000;
        if (timeLeftToSkip <= 0) goto _L8; else goto _L7
_L7:
        ThreadUtils.runOnUiThread(new Runnable() {

            final VASTVideoView this$0;
            final int val$timeLeftToSkip;

            public void run()
            {
                countdown.setVisibility(0);
                countdown.setText((new StringBuilder()).append("").append(timeLeftToSkip).toString());
            }

            
            {
                this$0 = VASTVideoView.this;
                timeLeftToSkip = i;
                super();
            }
        });
_L6:
        if (selectedCreative == null || selectedCreative.linearAd.trackingEvents == null)
        {
            break MISSING_BLOCK_LABEL_684;
        }
        timeLeftToSkip = mmvideoview.getDuration() / 4;
        if (i < timeLeftToSkip)
        {
            break MISSING_BLOCK_LABEL_268;
        }
        if (lastQuartileFired < 1)
        {
            lastQuartileFired = 1;
            fireTrackingEvents(getWrapperLinearTrackingEvents(VASTParser.TrackableEvent.firstQuartile));
            fireTrackingEvents((List)selectedCreative.linearAd.trackingEvents.get(VASTParser.TrackableEvent.firstQuartile));
        }
        if (i < timeLeftToSkip * 2)
        {
            break MISSING_BLOCK_LABEL_325;
        }
        if (lastQuartileFired < 2)
        {
            lastQuartileFired = 2;
            fireTrackingEvents(getWrapperLinearTrackingEvents(VASTParser.TrackableEvent.midpoint));
            fireTrackingEvents((List)selectedCreative.linearAd.trackingEvents.get(VASTParser.TrackableEvent.midpoint));
        }
        if (i < timeLeftToSkip * 3)
        {
            break MISSING_BLOCK_LABEL_382;
        }
        if (lastQuartileFired < 3)
        {
            lastQuartileFired = 3;
            fireTrackingEvents(getWrapperLinearTrackingEvents(VASTParser.TrackableEvent.thirdQuartile));
            fireTrackingEvents((List)selectedCreative.linearAd.trackingEvents.get(VASTParser.TrackableEvent.thirdQuartile));
        }
        Object obj;
        mmvideoview = new ArrayList();
        obj = (List)selectedCreative.linearAd.trackingEvents.get(VASTParser.TrackableEvent.progress);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_424;
        }
        mmvideoview.addAll(((java.util.Collection) (obj)));
        obj = getWrapperLinearTrackingEvents(VASTParser.TrackableEvent.progress);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_444;
        }
        mmvideoview.addAll(((java.util.Collection) (obj)));
        mmvideoview = mmvideoview.iterator();
_L12:
        VASTParser.ProgressEvent progressevent;
        if (!mmvideoview.hasNext())
        {
            break MISSING_BLOCK_LABEL_684;
        }
        obj = (VASTParser.TrackingEvent)mmvideoview.next();
        progressevent = (VASTParser.ProgressEvent)obj;
        timeLeftToSkip = vastTimeToMilliseconds(progressevent.offset);
        if (timeLeftToSkip == -1)
        {
            break MISSING_BLOCK_LABEL_619;
        }
        if (Utils.isEmpty(progressevent.url)) goto _L10; else goto _L9
_L9:
        if (firedTrackingEvents.contains(obj) || i < timeLeftToSkip) goto _L12; else goto _L11
_L11:
        firedTrackingEvents.add(progressevent);
        fireTrackingEvent(progressevent);
          goto _L12
        mmvideoview;
        throw mmvideoview;
_L8:
        canSkip = true;
        ThreadUtils.runOnUiThread(new Runnable() {

            final VASTVideoView this$0;

            public void run()
            {
                enableSkipControls();
            }

            
            {
                this$0 = VASTVideoView.this;
                super();
            }
        });
          goto _L6
_L10:
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Progress event could not be fired because the url is empty. offset = ").append(progressevent.offset).toString());
        }
        firedTrackingEvents.add(progressevent);
          goto _L12
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Progress event could not be fired because the time offset is invalid. url = ").append(progressevent.url).append(", offset = ").append(progressevent.offset).toString());
        }
        firedTrackingEvents.add(progressevent);
          goto _L12
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        timeLeftToSkip++;
        if (true) goto _L14; else goto _L13
_L13:
    }

    public void onReadyToStart(MMVideoView mmvideoview)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onReadyToStart");
        }
    }

    public void onSeek(MMVideoView mmvideoview)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onSeek");
        }
    }

    public void onStart(MMVideoView mmvideoview)
    {
        this;
        JVM INSTR monitorenter ;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onStart");
        }
        if (overlayWebView != null)
        {
            overlayWebView.callJavascript("MmJsBridge.vast.setState", new Object[] {
                "playing"
            });
        }
        if (backgroundWebView != null)
        {
            backgroundWebView.callJavascript("MmJsBridge.vast.setState", new Object[] {
                "playing"
            });
        }
        if (selectedCreative != null && selectedCreative.linearAd.trackingEvents != null)
        {
            fireTrackingEvents(getWrapperLinearTrackingEvents(VASTParser.TrackableEvent.start));
            fireTrackingEvents((List)selectedCreative.linearAd.trackingEvents.get(VASTParser.TrackableEvent.start));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        mmvideoview;
        throw mmvideoview;
    }

    public void onStop(MMVideoView mmvideoview)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onStop");
        }
    }

    public void onUnmuted(MMVideoView mmvideoview)
    {
    }

    public void shutdown()
    {
        if (videoFile != null && !videoFile.delete())
        {
            MMLog.w(TAG, (new StringBuilder()).append("Failed to delete video asset = ").append(videoFile.getAbsolutePath()).toString());
        }
        mmVideoView.stop();
    }

    public void updateLayout()
    {
        boolean flag = true;
        int j = 0;
        int i;
        if (isPortrait() && lastKnownOrientation != 1)
        {
            j = 1;
            if (backgroundFrame.getChildCount() == 0)
            {
                loadBackground();
            }
            if (overlayWebView != null)
            {
                ViewUtils.removeFromParent(overlayWebView);
            }
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            layoutparams.addRule(3, com.millennialmedia.R.id.mmadsdk_vast_video_control_buttons);
            mmVideoView.setLayoutParams(layoutparams);
            if (currentState == 1)
            {
                backgroundFrame.setVisibility(0);
                endCardContainer.setVisibility(8);
                int k;
                if (inLineAd != null && inLineAd.mmExtension != null && inLineAd.mmExtension.background != null && inLineAd.mmExtension.background.hideButtons)
                {
                    buttonContainer.setVisibility(4);
                    i = j;
                } else
                {
                    buttonContainer.setVisibility(0);
                    i = j;
                }
            } else
            {
                i = j;
                if (currentState == 2)
                {
                    backgroundFrame.setVisibility(8);
                    endCardContainer.setVisibility(0);
                    if (selectedCompanionAd != null && selectedCompanionAd.hideButtons)
                    {
                        buttonContainer.setVisibility(4);
                        i = j;
                    } else
                    {
                        buttonContainer.setVisibility(0);
                        i = j;
                    }
                }
            }
        } else
        {
            i = j;
            if (!isPortrait())
            {
                i = j;
                if (lastKnownOrientation == 1)
                {
                    boolean flag1 = true;
                    obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                    mmVideoView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                    if (overlayWebView != null)
                    {
                        mmVideoView.addView(overlayWebView, ((android.view.ViewGroup.LayoutParams) (obj)));
                    } else
                    {
                        loadOverlay();
                    }
                    if (currentState == 1)
                    {
                        if (inLineAd != null && inLineAd.mmExtension != null && inLineAd.mmExtension.overlay != null && inLineAd.mmExtension.overlay.hideButtons)
                        {
                            buttonContainer.setVisibility(4);
                            i = ((flag1) ? 1 : 0);
                        } else
                        {
                            buttonContainer.setVisibility(0);
                            i = ((flag1) ? 1 : 0);
                        }
                    } else
                    {
                        i = ((flag1) ? 1 : 0);
                        if (currentState == 2)
                        {
                            if (selectedCompanionAd != null && selectedCompanionAd.hideButtons)
                            {
                                buttonContainer.setVisibility(4);
                                i = ((flag1) ? 1 : 0);
                            } else
                            {
                                buttonContainer.setVisibility(0);
                                i = ((flag1) ? 1 : 0);
                            }
                        }
                    }
                }
            }
        }
        if (i != 0)
        {
            j = getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_ad_button_width);
            k = getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_ad_button_height);
            Object obj;
            if (isPortrait())
            {
                i = ((flag) ? 1 : 0);
            } else
            {
                i = 0;
            }
            obj = new android.widget.LinearLayout.LayoutParams(j, k, i);
            if (!isPortrait())
            {
                obj.leftMargin = getResources().getDimensionPixelSize(com.millennialmedia.R.dimen.mmadsdk_ad_button_padding_left);
            } else
            {
                obj.leftMargin = 0;
            }
            for (i = 0; i < buttonContainer.getChildCount(); i++)
            {
                buttonContainer.getChildAt(i).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            }

        }
        buttonContainer.bringToFront();
        lastKnownOrientation = getResources().getConfiguration().orientation;
    }

    static 
    {
        supportImageTypes = new ArrayList();
        supportImageTypes.add("image/bmp");
        supportImageTypes.add("image/gif");
        supportImageTypes.add("image/jpeg");
        supportImageTypes.add("image/png");
    }








/*
    static File access$1402(VASTVideoView vastvideoview, File file)
    {
        vastvideoview.videoFile = file;
        return file;
    }

*/




















/*
    static boolean access$502(VASTVideoView vastvideoview, boolean flag)
    {
        vastvideoview.canSkip = flag;
        return flag;
    }

*/




}
