// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.video.InlineWebVideoView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge, MMWebView

class inlineWebVideoViews
{

    private Map inlineWebVideoViews;
    final JSBridge this$0;

    private int toPixels(DisplayMetrics displaymetrics, float f)
    {
        return (int)TypedValue.applyDimension(1, f, displaymetrics);
    }

    public void expandToFullScreen(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("InlineVideo: expandToFullScreen(").append(s).append(")").toString());
        }
        ThreadUtils.runOnUiThread(new Runnable() {

            final JSBridge.JSBridgeInlineVideo this$1;
            final String val$viewTag;

            public void run()
            {
                Object obj = (MMWebView)JSBridge.access$100(this$0).get();
                if (obj != null)
                {
                    obj = (InlineWebVideoView)((MMWebView) (obj)).findViewWithTag(viewTag);
                    if (obj != null)
                    {
                        ((InlineWebVideoView) (obj)).expandToFullScreen();
                    }
                }
            }

            
            {
                this$1 = JSBridge.JSBridgeInlineVideo.this;
                viewTag = s;
                super();
            }
        });
    }

    public void insert(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("InlineVideo: insert(").append(s).append(")").toString());
        }
        s = new JSONObject(s);
        String s1 = s.getString("url");
        int i = s.getInt("width");
        int j = s.getInt("height");
        int k = s.getInt("x");
        int l = s.getInt("y");
        final boolean autoPlay = s.optBoolean("autoPlay", false);
        boolean flag = s.optBoolean("showMediaControls", false);
        boolean flag1 = s.optBoolean("showExpandControls", false);
        String s2 = s.optString("placeholder", null);
        ThreadUtils.runOnUiThread(new Runnable() {

            final JSBridge.JSBridgeInlineVideo this$1;
            final boolean val$autoPlay;
            final String val$callbackId;
            final int val$height;
            final boolean val$muted;
            final String val$placeholder;
            final boolean val$showExpandControls;
            final boolean val$showMediaControls;
            final int val$timeUpdateInterval;
            final String val$url;
            final int val$width;
            final int val$x;
            final int val$y;

            public void run()
            {
                MMWebView mmwebview = (MMWebView)JSBridge.access$100(this$0).get();
                if (mmwebview != null)
                {
                    InlineWebVideoView inlinewebvideoview = new InlineWebVideoView(mmwebview.getContext(), autoPlay, muted, showMediaControls, showExpandControls, timeUpdateInterval, callbackId, mmwebview. new com.millennialmedia.internal.video.InlineWebVideoView.InlineWebVideoViewListener() {

                        final _cls1 this$2;
                        final MMWebView val$mmWebView;

                        public void onClicked()
                        {
                            mmWebView.onNotifyClicked();
                        }

            
            {
                this$2 = final__pcls1;
                mmWebView = MMWebView.this;
                super();
            }
                    });
                    inlineWebVideoViews.put(inlinewebvideoview.getTag(), inlinewebvideoview);
                    DisplayMetrics displaymetrics = mmwebview.getContext().getResources().getDisplayMetrics();
                    inlinewebvideoview.setAnchorView(mmwebview, toPixels(displaymetrics, x), toPixels(displaymetrics, y), toPixels(displaymetrics, width), toPixels(displaymetrics, height), new com.millennialmedia.internal.video.InlineWebVideoView.InlineWebVideoViewAttachListener() {

                        final _cls1 this$2;

                        public void attachFailed(InlineWebVideoView inlinewebvideoview)
                        {
                            inlineWebVideoViews.remove(inlinewebvideoview.getTag());
                        }

                        public void attachSucceeded(InlineWebVideoView inlinewebvideoview)
                        {
                            inlineWebVideoViews.remove(inlinewebvideoview.getTag());
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    });
                    if (placeholder != null)
                    {
                        inlinewebvideoview.setPlaceholder(Uri.parse(placeholder));
                    }
                    inlinewebvideoview.setVideoURI(Uri.parse(url));
                }
            }

            
            {
                this$1 = JSBridge.JSBridgeInlineVideo.this;
                autoPlay = flag;
                muted = flag1;
                showMediaControls = flag2;
                showExpandControls = flag3;
                timeUpdateInterval = i;
                callbackId = s;
                x = j;
                y = k;
                width = l;
                height = i1;
                placeholder = s1;
                url = s2;
                super();
            }
        });
    }

    public void pause(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("InlineVideo: pause(").append(s).append(")").toString());
        }
        MMWebView mmwebview = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (mmwebview != null)
        {
            s = (InlineWebVideoView)mmwebview.findViewWithTag((new JSONObject(s)).getString("videoId"));
            if (s != null)
            {
                s.pause();
            }
        }
    }

    public void play(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("InlineVideo: play(").append(s).append(")").toString());
        }
        MMWebView mmwebview = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (mmwebview != null)
        {
            s = (InlineWebVideoView)mmwebview.findViewWithTag((new JSONObject(s)).getString("videoId"));
            if (s != null)
            {
                s.start();
            }
        }
    }

    public void remove(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("InlineVideo: remove(").append(s).append(")").toString());
        }
        ThreadUtils.runOnUiThread(new Runnable() {

            final JSBridge.JSBridgeInlineVideo this$1;
            final String val$viewTag;

            public void run()
            {
                Object obj = (MMWebView)JSBridge.access$100(this$0).get();
                if (obj != null)
                {
                    obj = (InlineWebVideoView)((MMWebView) (obj)).findViewWithTag(viewTag);
                    if (obj != null)
                    {
                        ((InlineWebVideoView) (obj)).remove();
                    }
                }
            }

            
            {
                this$1 = JSBridge.JSBridgeInlineVideo.this;
                viewTag = s;
                super();
            }
        });
    }

    public void reposition(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("InlineVideo: reposition(").append(s).append(")").toString());
        }
        s = new JSONObject(s);
        final String viewTag = s.getString("videoId");
        int i = s.getInt("width");
        int j = s.getInt("height");
        ThreadUtils.runOnUiThread(new Runnable() {

            final JSBridge.JSBridgeInlineVideo this$1;
            final int val$height;
            final String val$viewTag;
            final int val$width;
            final int val$x;
            final int val$y;

            public void run()
            {
                Object obj = (MMWebView)JSBridge.access$100(this$0).get();
                if (obj != null)
                {
                    DisplayMetrics displaymetrics = ((MMWebView) (obj)).getContext().getResources().getDisplayMetrics();
                    obj = (InlineWebVideoView)((MMWebView) (obj)).findViewWithTag(viewTag);
                    if (obj != null)
                    {
                        ((InlineWebVideoView) (obj)).reposition(toPixels(displaymetrics, x), toPixels(displaymetrics, y), toPixels(displaymetrics, width), toPixels(displaymetrics, height));
                    }
                }
            }

            
            {
                this$1 = JSBridge.JSBridgeInlineVideo.this;
                viewTag = s;
                x = i;
                y = j;
                width = k;
                height = l;
                super();
            }
        });
    }

    public void seek(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("InlineVideo: seek(").append(s).append(")").toString());
        }
        Object obj = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (obj != null)
        {
            s = new JSONObject(s);
            obj = (InlineWebVideoView)((MMWebView) (obj)).findViewWithTag(s.getString("videoId"));
            if (obj != null)
            {
                ((InlineWebVideoView) (obj)).seekTo(s.getInt("time"));
            }
        }
    }

    public void setMuted(String s)
        throws JSONException
    {
        Object obj;
label0:
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("InlineVideo: setMuted(").append(s).append(")").toString());
            }
            obj = (MMWebView)JSBridge.access$100(JSBridge.this).get();
            if (obj != null)
            {
                s = new JSONObject(s);
                obj = (InlineWebVideoView)((MMWebView) (obj)).findViewWithTag(s.getString("videoId"));
                if (obj != null)
                {
                    boolean flag = s.getBoolean("mute");
                    s.optBoolean("force", false);
                    if (!flag)
                    {
                        break label0;
                    }
                    ((InlineWebVideoView) (obj)).mute();
                }
            }
            return;
        }
        ((InlineWebVideoView) (obj)).unmute();
    }

    public void stop(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("InlineVideo: stop(").append(s).append(")").toString());
        }
        MMWebView mmwebview = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (mmwebview != null)
        {
            s = (InlineWebVideoView)mmwebview.findViewWithTag((new JSONObject(s)).getString("videoId"));
            if (s != null)
            {
                s.stop();
            }
        }
    }

    public void triggerTimeUpdate(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("InlineVideo: triggerTimeUpdate(").append(s).append(")").toString());
        }
        MMWebView mmwebview = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (mmwebview != null)
        {
            s = (InlineWebVideoView)mmwebview.findViewWithTag((new JSONObject(s)).getString("videoId"));
            if (s != null)
            {
                s.triggerTimeUpdate();
            }
        }
    }

    public void updateVideoURL(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("InlineVideo: updateVideoURL(").append(s).append(")").toString());
        }
        s = new JSONObject(s);
        ThreadUtils.runOnUiThread(new Runnable() {

            final JSBridge.JSBridgeInlineVideo this$1;
            final String val$uri;
            final String val$viewTag;

            public void run()
            {
                Object obj = (MMWebView)JSBridge.access$100(this$0).get();
                if (obj != null)
                {
                    obj = (InlineWebVideoView)((MMWebView) (obj)).findViewWithTag(viewTag);
                    if (obj != null)
                    {
                        ((InlineWebVideoView) (obj)).setVideoURI(Uri.parse(uri));
                    }
                }
            }

            
            {
                this$1 = JSBridge.JSBridgeInlineVideo.this;
                viewTag = s;
                uri = s1;
                super();
            }
        });
    }



    public _cls5.val.viewTag()
    {
        this$0 = JSBridge.this;
        super();
        inlineWebVideoViews = new HashMap();
    }
}
