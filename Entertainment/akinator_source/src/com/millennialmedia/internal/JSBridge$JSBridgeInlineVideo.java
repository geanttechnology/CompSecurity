// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

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
    /* block-local class not found */
    class _cls5 {}

        ThreadUtils.runOnUiThread(new _cls5((new JSONObject(s)).getString("videoId")));
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
        boolean flag = s.optBoolean("autoPlay", false);
        boolean flag1 = s.optBoolean("showMediaControls", false);
        boolean flag2 = s.optBoolean("showExpandControls", false);
        String s2 = s.optString("placeholder", null);
    /* block-local class not found */
    class _cls1 {}

        ThreadUtils.runOnUiThread(new _cls1(flag, s.optBoolean("muted", false), flag1, flag2, s.optInt("timeUpdateInterval", -1), s.optString("callbackId"), k, l, i, j, s2, s1));
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
    /* block-local class not found */
    class _cls4 {}

        ThreadUtils.runOnUiThread(new _cls4((new JSONObject(s)).getString("videoId")));
    }

    public void reposition(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("InlineVideo: reposition(").append(s).append(")").toString());
        }
        s = new JSONObject(s);
        String s1 = s.getString("videoId");
        int i = s.getInt("width");
        int j = s.getInt("height");
    /* block-local class not found */
    class _cls3 {}

        ThreadUtils.runOnUiThread(new _cls3(s1, s.getInt("x"), s.getInt("y"), i, j));
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
    /* block-local class not found */
    class _cls2 {}

        ThreadUtils.runOnUiThread(new _cls2(s.getString("videoId"), s.getString("url")));
    }



    public _cls2()
    {
        this$0 = JSBridge.this;
        super();
        inlineWebVideoViews = new HashMap();
    }
}
