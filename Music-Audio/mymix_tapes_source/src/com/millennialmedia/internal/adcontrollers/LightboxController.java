// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adcontrollers;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.MMWebView;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.Utils;
import com.millennialmedia.internal.utils.ViewUtils;
import com.millennialmedia.internal.video.LightboxView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.internal.adcontrollers:
//            AdController

public class LightboxController extends AdController
{
    public static class Fullscreen
    {

        public String imageUri;
        public List trackingEvents;
        public String webContent;

        Fullscreen(String s, String s1, List list)
        {
            webContent = s;
            imageUri = s1;
            trackingEvents = list;
        }
    }

    public static class Inline
    {

        public String content;
        public List trackingEvents;

        Inline(String s, List list)
        {
            content = s;
            trackingEvents = list;
        }
    }

    public static class LightboxAd
    {

        public Fullscreen fullscreen;
        public Inline inline;
        public Video video;

        LightboxAd(Inline inline1, Video video1, Fullscreen fullscreen1)
        {
            inline = inline1;
            video = video1;
            fullscreen = fullscreen1;
        }
    }

    public static interface LightboxControllerListener
    {

        public abstract void attachFailed();

        public abstract void attachSucceeded();

        public abstract void initFailed();

        public abstract void initSucceeded();

        public abstract void onAdLeftApplication();

        public abstract void onClicked();

        public abstract void onCollapsed();

        public abstract void onExpanded();
    }

    public static final class TrackableEvent extends Enum
    {

        private static final TrackableEvent $VALUES[];
        public static final TrackableEvent complete;
        public static final TrackableEvent firstQuartile;
        public static final TrackableEvent loaded;
        public static final TrackableEvent midpoint;
        public static final TrackableEvent start;
        public static final TrackableEvent thirdQuartile;
        public static final TrackableEvent videoClose;
        public static final TrackableEvent videoCollapse;
        public static final TrackableEvent videoExpand;

        public static TrackableEvent valueOf(String s)
        {
            return (TrackableEvent)Enum.valueOf(com/millennialmedia/internal/adcontrollers/LightboxController$TrackableEvent, s);
        }

        public static TrackableEvent[] values()
        {
            return (TrackableEvent[])$VALUES.clone();
        }

        static 
        {
            loaded = new TrackableEvent("loaded", 0);
            start = new TrackableEvent("start", 1);
            firstQuartile = new TrackableEvent("firstQuartile", 2);
            midpoint = new TrackableEvent("midpoint", 3);
            thirdQuartile = new TrackableEvent("thirdQuartile", 4);
            complete = new TrackableEvent("complete", 5);
            videoExpand = new TrackableEvent("videoExpand", 6);
            videoCollapse = new TrackableEvent("videoCollapse", 7);
            videoClose = new TrackableEvent("videoClose", 8);
            $VALUES = (new TrackableEvent[] {
                loaded, start, firstQuartile, midpoint, thirdQuartile, complete, videoExpand, videoCollapse, videoClose
            });
        }

        private TrackableEvent(String s, int i)
        {
            super(s, i);
        }
    }

    public static class TrackingEvent
    {

        public TrackableEvent event;
        public String uri;

        TrackingEvent(TrackableEvent trackableevent, String s)
        {
            event = trackableevent;
            uri = s;
        }
    }

    public static class Video
    {

        public Map trackingEvents;
        public String uri;

        Video(String s, Map map)
        {
            uri = s;
            trackingEvents = map;
        }
    }


    private static final String TAG = com/millennialmedia/internal/adcontrollers/LightboxController.getSimpleName();
    private volatile ViewGroup adContainer;
    private LightboxAd lightboxAd;
    private LightboxControllerListener lightboxControllerListener;
    private LightboxView lightboxView;
    private MMWebView mmWebView;

    LightboxController()
    {
    }

    public LightboxController(final Context context, String s, final LightboxControllerListener lightboxControllerListener)
    {
        this.lightboxControllerListener = lightboxControllerListener;
        try
        {
            s = (new JSONObject(s)).getJSONObject("ad");
            Object obj = s.getJSONObject("inline");
            obj = new Inline(((JSONObject) (obj)).getString("content"), fromJSONArray(TrackableEvent.loaded, ((JSONObject) (obj)).getJSONArray("loadTracking")));
            Object obj1 = s.getJSONObject("video");
            HashMap hashmap = new HashMap();
            hashmap.put(TrackableEvent.start, fromJSONArray(TrackableEvent.start, ((JSONObject) (obj1)).getJSONArray("start")));
            hashmap.put(TrackableEvent.firstQuartile, fromJSONArray(TrackableEvent.start, ((JSONObject) (obj1)).getJSONArray("firstQuartile")));
            hashmap.put(TrackableEvent.midpoint, fromJSONArray(TrackableEvent.start, ((JSONObject) (obj1)).getJSONArray("midpoint")));
            hashmap.put(TrackableEvent.thirdQuartile, fromJSONArray(TrackableEvent.start, ((JSONObject) (obj1)).getJSONArray("thirdQuartile")));
            hashmap.put(TrackableEvent.complete, fromJSONArray(TrackableEvent.start, ((JSONObject) (obj1)).getJSONArray("complete")));
            hashmap.put(TrackableEvent.videoExpand, fromJSONArray(TrackableEvent.start, ((JSONObject) (obj1)).getJSONArray("videoExpand")));
            hashmap.put(TrackableEvent.videoCollapse, fromJSONArray(TrackableEvent.start, ((JSONObject) (obj1)).getJSONArray("videoCollapse")));
            hashmap.put(TrackableEvent.videoClose, fromJSONArray(TrackableEvent.start, ((JSONObject) (obj1)).getJSONArray("videoClose")));
            obj1 = new Video(((JSONObject) (obj1)).getString("uri"), hashmap);
            s = s.getJSONObject("fullscreen");
            lightboxAd = new LightboxAd(((Inline) (obj)), ((Video) (obj1)), new Fullscreen(s.getString("webContent"), s.getString("imageUri"), fromJSONArray(TrackableEvent.loaded, s.getJSONArray("loadTracking"))));
            ThreadUtils.runOnUiThread(new Runnable() {

                final LightboxController this$0;
                final Context val$context;
                final LightboxControllerListener val$lightboxControllerListener;

                public void run()
                {
                    lightboxView = new LightboxView(context, lightboxAd, new com.millennialmedia.internal.video.LightboxView.LightboxViewListener() {

                        final _cls1 this$1;

                        public void onAdLeftApplication()
                        {
                            lightboxControllerListener.onAdLeftApplication();
                        }

                        public void onClicked()
                        {
                            lightboxControllerListener.onClicked();
                        }

                        public void onCollapsed()
                        {
                            lightboxControllerListener.onCollapsed();
                        }

                        public void onExpanded()
                        {
                            lightboxControllerListener.onExpanded();
                        }

                        public void onFailed()
                        {
                        }

                        public void onPrepared()
                        {
                            if (MMLog.isDebugEnabled())
                            {
                                MMLog.d(LightboxController.TAG, "Lightbox prepared.");
                            }
                            ThreadUtils.runOnUiThread(new Runnable() {

                                final _cls1 this$2;

                                public void run()
                                {
                                    if (adContainer != null && lightboxView.getParent() == null)
                                    {
                                        if (MMLog.isDebugEnabled())
                                        {
                                            MMLog.d(LightboxController.TAG, "Attaching Lightbox in onPrepared.");
                                        }
                                        attachLightboxView();
                                    }
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                        }

                        public void onReadyToStart()
                        {
                            if (MMLog.isDebugEnabled())
                            {
                                MMLog.d(LightboxController.TAG, "lightbox is ready to start playback");
                            }
                            lightboxView.start();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                    mmWebView = new MMWebView(context, false, false, new com.millennialmedia.internal.MMWebView.MMWebViewListener() {

                        final _cls1 this$1;

                        public void close()
                        {
                        }

                        public boolean expand(com.millennialmedia.internal.SizableStateManager.ExpandParams expandparams)
                        {
                            return false;
                        }

                        public void onAdLeftApplication()
                        {
                            lightboxControllerListener.onAdLeftApplication();
                        }

                        public void onClicked()
                        {
                            lightboxControllerListener.onClicked();
                        }

                        public void onFailed()
                        {
                            lightboxControllerListener.initFailed();
                        }

                        public void onLoaded()
                        {
                            lightboxControllerListener.initSucceeded();
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
                this$1 = _cls1.this;
                super();
            }
                    });
                    mmWebView.setContent(lightboxAd.inline.content);
                    mmWebView.addOnAttachStateChangeListener(new android.view.View.OnAttachStateChangeListener() {

                        final _cls1 this$1;

                        public void onViewAttachedToWindow(View view)
                        {
                        }

                        public void onViewDetachedFromWindow(View view)
                        {
                            lightboxView.animateToGone(false);
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }

            
            {
                this$0 = LightboxController.this;
                context = context1;
                lightboxControllerListener = lightboxcontrollerlistener;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final Context context)
        {
            MMLog.e(TAG, "Lightbox ad content is malformed.", context);
        }
        lightboxControllerListener.initFailed();
    }

    private void attachLightboxView()
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "attaching lightbox view");
        }
        Object obj = ((WindowManager)adContainer.getContext().getSystemService("window")).getDefaultDisplay();
        final Point displaySize = new Point();
        ((Display) (obj)).getSize(displaySize);
        obj = lightboxView.getDefaultPosition();
        Object obj1 = lightboxView.getDefaultDimensions();
        lightboxView.setTranslationX(((Point) (obj)).x);
        lightboxView.setTranslationY(displaySize.y);
        obj1 = new android.view.ViewGroup.LayoutParams(((Point) (obj1)).x, ((Point) (obj1)).y);
        ViewGroup viewgroup = ViewUtils.getDecorView(adContainer);
        if (viewgroup != null)
        {
            ViewUtils.attachView(viewgroup, lightboxView, ((android.view.ViewGroup.LayoutParams) (obj1)));
            obj = new Animation() {

                final LightboxController this$0;
                final Point val$displaySize;
                final int val$distanceToDefaultPosY;

                protected void applyTransformation(float f, Transformation transformation)
                {
                    if (f == 1.0F)
                    {
                        f = displaySize.y - distanceToDefaultPosY;
                    } else
                    {
                        f = (float)displaySize.y - (float)distanceToDefaultPosY * f;
                    }
                    lightboxView.setTranslationY(f);
                }

            
            {
                this$0 = LightboxController.this;
                displaySize = point;
                distanceToDefaultPosY = i;
                super();
            }
            };
            ((Animation) (obj)).setDuration((long)((float)displaySize.y / adContainer.getContext().getResources().getDisplayMetrics().density));
            lightboxView.startAnimation(((Animation) (obj)));
            return;
        } else
        {
            MMLog.e(TAG, "Unable to determine the root view; cannot attach Lightbox view.");
            return;
        }
    }

    private void fireTrackingEvents(final List trackingEvents)
    {
        if (trackingEvents != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final LightboxController this$0;
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
                        TrackingEvent trackingevent = (TrackingEvent)iterator.next();
                        if (trackingevent != null && !Utils.isEmpty(trackingevent.uri))
                        {
                            if (MMLog.isDebugEnabled())
                            {
                                MMLog.d(LightboxController.TAG, (new StringBuilder()).append("Firing tracking url = ").append(trackingevent.uri).toString());
                            }
                            HttpUtils.getContentFromGetRequest(trackingevent.uri);
                        }
                    } while (true);
                }

            
            {
                this$0 = LightboxController.this;
                trackingEvents = list;
                super();
            }
            });
        }
    }

    private List fromJSONArray(TrackableEvent trackableevent, JSONArray jsonarray)
        throws JSONException
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            arraylist.add(new TrackingEvent(trackableevent, jsonarray.getString(i)));
        }

        return arraylist;
    }

    public void attach(final ViewGroup container, final android.view.ViewGroup.LayoutParams layoutParams)
    {
        if (container == null)
        {
            lightboxControllerListener.attachFailed();
            return;
        }
        adContainer = container;
        if (!(container.getContext() instanceof Activity))
        {
            lightboxControllerListener.attachFailed();
            return;
        } else
        {
            ThreadUtils.runOnUiThread(new Runnable() {

                final LightboxController this$0;
                final ViewGroup val$container;
                final android.view.ViewGroup.LayoutParams val$layoutParams;

                public void run()
                {
                    ViewUtils.attachView(container, mmWebView, layoutParams);
                    if (lightboxView.isPrepared() && lightboxView.getParent() == null)
                    {
                        if (MMLog.isDebugEnabled())
                        {
                            MMLog.d(LightboxController.TAG, "attaching lightbox is attach.");
                        }
                        attachLightboxView();
                    }
                    lightboxControllerListener.attachSucceeded();
                    fireTrackingEvents(lightboxAd.inline.trackingEvents);
                }

            
            {
                this$0 = LightboxController.this;
                container = viewgroup;
                layoutParams = layoutparams;
                super();
            }
            });
            return;
        }
    }

    public boolean canHandleContent(String s)
    {
        boolean flag;
        try
        {
            flag = "lightbox".equalsIgnoreCase((new JSONObject(s)).getString("mmAdFormat"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return flag;
    }




/*
    static LightboxView access$002(LightboxController lightboxcontroller, LightboxView lightboxview)
    {
        lightboxcontroller.lightboxView = lightboxview;
        return lightboxview;
    }

*/







/*
    static MMWebView access$502(LightboxController lightboxcontroller, MMWebView mmwebview)
    {
        lightboxcontroller.mmWebView = mmwebview;
        return mmwebview;
    }

*/


}
