// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.TypedValue;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.CalendarUtils;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import com.millennialmedia.internal.utils.MediaUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.Utils;
import java.io.File;
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
        ThreadUtils.runOnUiThread(new Runnable() {

            final JSBridge.JSBridgeMRAID this$1;

            public void run()
            {
                JSBridge.access$300(this$0).close();
            }

            
            {
                this$1 = JSBridge.JSBridgeMRAID.this;
                super();
            }
        });
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
            CalendarUtils.addEventWithIntent(mmwebview.getContext(), s, new com.millennialmedia.internal.utils.CalendarUtils.CalendarListener() {

                final JSBridge.JSBridgeMRAID this$1;

                public void onError(String s1)
                {
                    throwMraidError(s1, "createCalendarEvent");
                }

                public void onSuccess()
                {
                }

                public void onUIDisplayed()
                {
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(JSBridge.access$000(), "Calendar activity started");
                    }
                }

            
            {
                this$1 = JSBridge.JSBridgeMRAID.this;
                super();
            }
            });
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
        final andParams expandParams = new andParams();
        if (s.has("width"))
        {
            expandParams.width = Math.min((int)TypedValue.applyDimension(1, s.getInt("width"), displaymetrics), EnvironmentUtils.getDisplayWidth());
        } else
        {
            expandParams.width = -1;
        }
        if (s.has("height"))
        {
            expandParams.height = Math.min((int)TypedValue.applyDimension(1, s.getInt("height"), displaymetrics), EnvironmentUtils.getDisplayHeight());
        } else
        {
            expandParams.height = -1;
        }
        if (s.optBoolean("useCustomClose", JSBridge.this.useCustomClose))
        {
            flag = false;
        }
        expandParams.showCloseIndicator = flag;
        expandParams.orientation = requestedOrientation;
        expandParams.url = s.optString("url", null);
        ThreadUtils.runOnUiThread(new Runnable() {

            final JSBridge.JSBridgeMRAID this$1;
            final SizableStateManager.ExpandParams val$expandParams;

            public void run()
            {
                if (TextUtils.equals(currentState, "expanded") || TextUtils.equals(currentState, "hidden") || TextUtils.equals(currentState, "loading"))
                {
                    throwMraidError((new StringBuilder()).append("Cannot expand in current state<").append(currentState).append(">").toString(), "expand");
                } else
                if (!JSBridge.access$300(this$0).expand(expandParams))
                {
                    throwMraidError("Unable to expand", "expand");
                    return;
                }
            }

            
            {
                this$1 = JSBridge.JSBridgeMRAID.this;
                expandParams = expandparams;
                super();
            }
        });
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
            MediaUtils.startVideoPlayer(mmwebview.getContext(), s, new com.millennialmedia.internal.utils.MediaUtils.PlayVideoListener() {

                final JSBridge.JSBridgeMRAID this$1;

                public void onError(String s1)
                {
                    throwMraidError(s1, "playVideo");
                }

                public void onVideoStarted(Uri uri)
                {
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("Video activity started for <").append(uri.toString()).append(">").toString());
                    }
                }

            
            {
                this$1 = JSBridge.JSBridgeMRAID.this;
                super();
            }
            });
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
            final izeParams resizeParams = new izeParams();
            resizeParams.width = (int)TypedValue.applyDimension(1, s.getInt("width"), displaymetrics);
            resizeParams.height = (int)TypedValue.applyDimension(1, s.getInt("height"), displaymetrics);
            resizeParams.offsetX = (int)TypedValue.applyDimension(1, s.optInt("offsetX", 0), displaymetrics);
            resizeParams.offsetY = (int)TypedValue.applyDimension(1, s.optInt("offsetY", 0), displaymetrics);
            resizeParams.customClosePosition = s.optString("customClosePosition", "top-right");
            resizeParams.allowOffScreen = s.optBoolean("allowOffscreen", true);
            ThreadUtils.runOnUiThread(new Runnable() {

                final JSBridge.JSBridgeMRAID this$1;
                final SizableStateManager.ResizeParams val$resizeParams;

                public void run()
                {
                    if (TextUtils.equals(currentState, "expanded") || TextUtils.equals(currentState, "hidden") || TextUtils.equals(currentState, "loading"))
                    {
                        throwMraidError((new StringBuilder()).append("Cannot resize in current state<").append(currentState).append(">").toString(), "resize");
                    } else
                    if (!JSBridge.access$300(this$0).resize(resizeParams))
                    {
                        throwMraidError("Unable to resize", "resize");
                        return;
                    }
                }

            
            {
                this$1 = JSBridge.JSBridgeMRAID.this;
                resizeParams = resizeparams;
                super();
            }
            });
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
        ThreadUtils.runOnUiThread(new Runnable() {

            final JSBridge.JSBridgeMRAID this$1;

            public void run()
            {
                if (isInterstitial || currentState.equals("expanded"))
                {
                    JSBridge.access$300(this$0).setOrientation(requestedOrientation);
                }
            }

            
            {
                this$1 = JSBridge.JSBridgeMRAID.this;
                super();
            }
        });
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
        final MMWebView mmWebView = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (mmWebView == null)
        {
            throwMraidError("Webview is no longer valid", "storePicture");
            return;
        } else
        {
            MediaUtils.savePicture(mmWebView.getContext(), s, null, new com.millennialmedia.internal.utils.MediaUtils.SavePictureListener() {

                final JSBridge.JSBridgeMRAID this$1;
                final MMWebView val$mmWebView;

                public void onError(String s1)
                {
                    throwMraidError(s1, "storePicture");
                }

                public void onPictureSaved(File file)
                {
                    Utils.showToast(mmWebView.getContext(), (new StringBuilder()).append(file.getName()).append(" stored in gallery").toString());
                }

            
            {
                this$1 = JSBridge.JSBridgeMRAID.this;
                mmWebView = mmwebview;
                super();
            }
            });
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
        ThreadUtils.runOnUiThread(new Runnable() {

            final JSBridge.JSBridgeMRAID this$1;

            public void run()
            {
                JSBridge.JSBridgeListener jsbridgelistener = JSBridge.access$300(this$0);
                boolean flag;
                if (!useCustomClose)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                jsbridgelistener.showCloseIndicator(flag);
            }

            
            {
                this$1 = JSBridge.JSBridgeMRAID.this;
                super();
            }
        });
    }

    _cls8.this._cls1()
    {
        this$0 = JSBridge.this;
        super();
    }
}
