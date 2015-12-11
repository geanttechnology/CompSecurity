// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.CalendarUtils;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import com.millennialmedia.internal.utils.MediaUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.Utils;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge, MMWebView

class this._cls0
{

    final JSBridge this$0;

    public void close(String s)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MRAID: close(").append(s).append(")").toString());
        }
    /* block-local class not found */
    class _cls1 {}

        ThreadUtils.runOnUiThread(new _cls1());
    }

    public void createCalendarEvent(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MRAID: createCalendarEvent(").append(s).append(")").toString());
        }
        if (!JSBridge.access$400(JSBridge.this))
        {
            throwMraidError("Ad has not been clicked", "createCalendarEvent");
            return;
        }
        if (!EnvironmentUtils.isCalendarSupported())
        {
            throwMraidError("Not supported", "createCalendarEvent");
            return;
        }
        s = (new JSONObject(s)).getJSONObject("parameters");
        if (s == null)
        {
            throwMraidError("No parameters provided", "createCalendarEvent");
            return;
        }
        MMWebView mmwebview = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (mmwebview == null)
        {
            throwMraidError("Webview is no longer valid", "createCalendarEvent");
            return;
        } else
        {
    /* block-local class not found */
    class _cls7 {}

            CalendarUtils.addEventWithIntent(mmwebview.getContext(), s, new _cls7());
            return;
        }
    }

    public void expand(String s)
        throws JSONException
    {
        boolean flag = true;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MRAID: expand(").append(s).append(")").toString());
        }
        if (!JSBridge.access$400(JSBridge.this))
        {
            throwMraidError("Ad has not been clicked", "expand");
            return;
        }
        s = new JSONObject(s);
        if (isInterstitial)
        {
            throwMraidError("Cannot expand interstitial", "expand");
            return;
        }
        android.util.DisplayMetrics displaymetrics = EnvironmentUtils.getApplicationContext().getResources().getDisplayMetrics();
        andParams andparams = new andParams();
    /* block-local class not found */
    class _cls2 {}

        if (s.has("width"))
        {
            andparams.width = Math.min((int)TypedValue.applyDimension(1, s.getInt("width"), displaymetrics), EnvironmentUtils.getDisplayWidth());
        } else
        {
            andparams.width = -1;
        }
        if (s.has("height"))
        {
            andparams.height = Math.min((int)TypedValue.applyDimension(1, s.getInt("height"), displaymetrics), EnvironmentUtils.getDisplayHeight());
        } else
        {
            andparams.height = -1;
        }
        if (s.optBoolean("useCustomClose", JSBridge.this.useCustomClose))
        {
            flag = false;
        }
        andparams.showCloseIndicator = flag;
        andparams.orientation = requestedOrientation;
        andparams.url = s.optString("url", null);
        ThreadUtils.runOnUiThread(new _cls2(andparams));
    }

    public void open(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MRAID: open(").append(s).append(")").toString());
        }
        if (!JSBridge.access$400(JSBridge.this))
        {
            throwMraidError("Ad has not been clicked", "open");
            return;
        }
        s = (new JSONObject(s)).getString("url");
        if (Utils.startActivityFromUrl(s))
        {
            JSBridge.access$300(JSBridge.this).onAdLeftApplication();
            return;
        } else
        {
            throwMraidError((new StringBuilder()).append("Unable to open url <").append(s).append(">").toString(), "open");
            return;
        }
    }

    public void playVideo(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MRAID: playVideo(").append(s).append(")").toString());
        }
        if (!JSBridge.access$400(JSBridge.this))
        {
            throwMraidError("Ad has not been clicked", "playVideo");
            return;
        }
        s = (new JSONObject(s)).optString("url", null);
        if (TextUtils.isEmpty(s))
        {
            throwMraidError("No path specified for video", "playVideo");
            return;
        }
        MMWebView mmwebview = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (mmwebview == null)
        {
            throwMraidError("Webview is no longer valid", "playVideo");
            return;
        } else
        {
    /* block-local class not found */
    class _cls8 {}

            MediaUtils.startVideoPlayer(mmwebview.getContext(), s, new _cls8());
            return;
        }
    }

    public void resize(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MRAID: resize(").append(s).append(")").toString());
        }
        if (!JSBridge.access$400(JSBridge.this))
        {
            throwMraidError("Ad has not been clicked", "resize");
            return;
        }
        s = new JSONObject(s);
        if (isInterstitial)
        {
            throwMraidError("Cannot resize interstitial", "resize");
            return;
        } else
        {
            android.util.DisplayMetrics displaymetrics = EnvironmentUtils.getApplicationContext().getResources().getDisplayMetrics();
            izeParams izeparams = new izeParams();
            izeparams.width = (int)TypedValue.applyDimension(1, s.getInt("width"), displaymetrics);
            izeparams.height = (int)TypedValue.applyDimension(1, s.getInt("height"), displaymetrics);
            izeparams.offsetX = (int)TypedValue.applyDimension(1, s.optInt("offsetX", 0), displaymetrics);
            izeparams.offsetY = (int)TypedValue.applyDimension(1, s.optInt("offsetY", 0), displaymetrics);
            izeparams.customClosePosition = s.optString("customClosePosition", "top-right");
            izeparams.allowOffScreen = s.optBoolean("allowOffscreen", true);
    /* block-local class not found */
    class _cls3 {}

            ThreadUtils.runOnUiThread(new _cls3(izeparams));
            return;
        }
    }

    public void setOrientationProperties(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MRAID: setOrientationProperties(").append(s).append(")").toString());
        }
        s = new JSONObject(s);
        boolean flag = s.optBoolean("allowOrientationChange", true);
        s = s.optString("forceOrientation", "none");
    /* block-local class not found */
    class _cls5 {}

        if ("none".equals(s))
        {
            if (flag)
            {
                requestedOrientation = -1;
            } else
            if (EnvironmentUtils.getCurrentConfigOrientation() == 2)
            {
                requestedOrientation = 6;
            } else
            {
                requestedOrientation = 7;
            }
        } else
        if ("portrait".equals(s))
        {
            requestedOrientation = 7;
        } else
        if ("landscape".equals(s))
        {
            requestedOrientation = 6;
        } else
        {
            throwMraidError((new StringBuilder()).append("Invalid orientation specified <").append(s).append(">").toString(), "setOrientationProperties");
            return;
        }
        ThreadUtils.runOnUiThread(new _cls5());
    }

    public void storePicture(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MRAID: storePicture(").append(s).append(")").toString());
        }
        if (!JSBridge.access$400(JSBridge.this))
        {
            throwMraidError("Ad has not been clicked", "storePicture");
            return;
        }
        if (!EnvironmentUtils.isExternalStorageSupported())
        {
            throwMraidError("Not supported", "storePicture");
            return;
        }
        s = (new JSONObject(s)).optString("url", null);
        if (TextUtils.isEmpty(s))
        {
            throwMraidError("No path specified for picture", "storePicture");
            return;
        }
        MMWebView mmwebview = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (mmwebview == null)
        {
            throwMraidError("Webview is no longer valid", "storePicture");
            return;
        } else
        {
    /* block-local class not found */
    class _cls6 {}

            MediaUtils.savePicture(mmwebview.getContext(), s, null, new _cls6(mmwebview));
            return;
        }
    }

    public void useCustomClose(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MRAID: useCustomClose(").append(s).append(")").toString());
        }
        s = new JSONObject(s);
        JSBridge.this.useCustomClose = s.optBoolean("useCustomClose", JSBridge.this.useCustomClose);
    /* block-local class not found */
    class _cls4 {}

        ThreadUtils.runOnUiThread(new _cls4());
    }

    _cls4()
    {
        this$0 = JSBridge.this;
        super();
    }
}
