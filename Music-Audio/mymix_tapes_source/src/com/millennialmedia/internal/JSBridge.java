// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.CalendarUtils;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import com.millennialmedia.internal.utils.JSONUtils;
import com.millennialmedia.internal.utils.MediaUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.Utils;
import com.millennialmedia.internal.utils.ViewUtils;
import com.millennialmedia.internal.video.InlineWebVideoView;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.internal:
//            MMWebView

public class JSBridge
{
    class JSBridgeCommon
    {

        final JSBridge this$0;

        public void fileLoaded(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("fileLoaded: ").append(s).toString());
            }
            s = new JSONObject(s);
            scriptsAwaitingLoad.remove(s.getString("filename"));
            if (scriptsAwaitingLoad.size() == 0)
            {
                if (jsBridgeListener != null)
                {
                    jsBridgeListener.onInjectedScriptsLoaded();
                }
                setReadyState();
            }
        }

        public String getActionsQueue()
        {
            JSBridge jsbridge = JSBridge.this;
            jsbridge;
            JVM INSTR monitorenter ;
            String s;
            if (actionsQueue == null)
            {
                break MISSING_BLOCK_LABEL_41;
            }
            s = actionsQueue.toString();
            actionsQueue = null;
            return s;
            jsbridge;
            JVM INSTR monitorexit ;
            return null;
            Exception exception;
            exception;
            jsbridge;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public Boolean useActionsQueue()
        {
            return Boolean.valueOf(JSBridge.useActionsQueue);
        }

        JSBridgeCommon()
        {
            this$0 = JSBridge.this;
            super();
        }
    }

    class JSBridgeInlineVideo
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
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("InlineVideo: expandToFullScreen(").append(s).append(")").toString());
            }
            ThreadUtils.runOnUiThread((new JSONObject(s)).getString("videoId"). new Runnable() {

                final JSBridgeInlineVideo this$1;
                final String val$viewTag;

                public void run()
                {
                    Object obj = (MMWebView)mmWebViewRef.get();
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
                this$1 = final_jsbridgeinlinevideo;
                viewTag = String.this;
                super();
            }
            });
        }

        public void insert(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("InlineVideo: insert(").append(s).append(")").toString());
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
            ThreadUtils.runOnUiThread(s1. new Runnable() {

                final JSBridgeInlineVideo this$1;
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
                    MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
                    if (mmwebview != null)
                    {
                        InlineWebVideoView inlinewebvideoview = new InlineWebVideoView(mmwebview.getContext(), autoPlay, muted, showMediaControls, showExpandControls, timeUpdateInterval, callbackId, mmwebview. new com.millennialmedia.internal.video.InlineWebVideoView.InlineWebVideoViewListener() {

                            final JSBridgeInlineVideo._cls1 this$2;
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

                            final JSBridgeInlineVideo._cls1 this$2;

                            public void attachFailed(InlineWebVideoView inlinewebvideoview)
                            {
                                inlineWebVideoViews.remove(inlinewebvideoview.getTag());
                            }

                            public void attachSucceeded(InlineWebVideoView inlinewebvideoview)
                            {
                                inlineWebVideoViews.remove(inlinewebvideoview.getTag());
                            }

            
            {
                this$2 = JSBridgeInlineVideo._cls1.this;
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
                this$1 = final_jsbridgeinlinevideo;
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
                url = String.this;
                super();
            }
            });
        }

        public void pause(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("InlineVideo: pause(").append(s).append(")").toString());
            }
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
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
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("InlineVideo: play(").append(s).append(")").toString());
            }
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
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
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("InlineVideo: remove(").append(s).append(")").toString());
            }
            ThreadUtils.runOnUiThread((new JSONObject(s)).getString("videoId"). new Runnable() {

                final JSBridgeInlineVideo this$1;
                final String val$viewTag;

                public void run()
                {
                    Object obj = (MMWebView)mmWebViewRef.get();
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
                this$1 = final_jsbridgeinlinevideo;
                viewTag = String.this;
                super();
            }
            });
        }

        public void reposition(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("InlineVideo: reposition(").append(s).append(")").toString());
            }
            s = new JSONObject(s);
            final String viewTag = s.getString("videoId");
            int i = s.getInt("width");
            int j = s.getInt("height");
            ThreadUtils.runOnUiThread(j. new Runnable() {

                final JSBridgeInlineVideo this$1;
                final int val$height;
                final String val$viewTag;
                final int val$width;
                final int val$x;
                final int val$y;

                public void run()
                {
                    Object obj = (MMWebView)mmWebViewRef.get();
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
                this$1 = final_jsbridgeinlinevideo;
                viewTag = s;
                x = i;
                y = j;
                width = k;
                height = I.this;
                super();
            }
            });
        }

        public void seek(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("InlineVideo: seek(").append(s).append(")").toString());
            }
            Object obj = (MMWebView)mmWebViewRef.get();
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
                    MMLog.d(JSBridge.TAG, (new StringBuilder()).append("InlineVideo: setMuted(").append(s).append(")").toString());
                }
                obj = (MMWebView)mmWebViewRef.get();
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
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("InlineVideo: stop(").append(s).append(")").toString());
            }
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
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
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("InlineVideo: triggerTimeUpdate(").append(s).append(")").toString());
            }
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
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
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("InlineVideo: updateVideoURL(").append(s).append(")").toString());
            }
            s = new JSONObject(s);
            ThreadUtils.runOnUiThread(s.getString("url"). new Runnable() {

                final JSBridgeInlineVideo this$1;
                final String val$uri;
                final String val$viewTag;

                public void run()
                {
                    Object obj = (MMWebView)mmWebViewRef.get();
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
                this$1 = final_jsbridgeinlinevideo;
                viewTag = s;
                uri = String.this;
                super();
            }
            });
        }



        public JSBridgeInlineVideo()
        {
            this$0 = JSBridge.this;
            super();
            inlineWebVideoViews = new HashMap();
        }
    }

    public static interface JSBridgeListener
    {

        public abstract void close();

        public abstract boolean expand(SizableStateManager.ExpandParams expandparams);

        public abstract void onAdLeftApplication();

        public abstract void onInjectedScriptsLoaded();

        public abstract void onJSBridgeReady();

        public abstract boolean resize(SizableStateManager.ResizeParams resizeparams);

        public abstract void setOrientation(int i);

        public abstract void showCloseIndicator(boolean flag);
    }

    class JSBridgeMMJS
    {

        final JSBridge this$0;

        public void addCalendarEvent(final String callbackId)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MMJS: addCalendarEvent(").append(callbackId).append(")").toString());
            }
            JSONObject jsonobject = new JSONObject(callbackId);
            callbackId = jsonobject.optString("callbackId", null);
            if (!apiCallsEnabled)
            {
                MMLog.e(JSBridge.TAG, "Ad has not been clicked");
                invokeCallback(callbackId, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            }
            jsonobject = jsonobject.optJSONObject("options");
            if (jsonobject == null)
            {
                MMLog.e(JSBridge.TAG, "No options provided");
                invokeCallback(callbackId, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            }
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview == null)
            {
                MMLog.e(JSBridge.TAG, "Webview is no longer valid");
                invokeCallback(callbackId, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            } else
            {
                CalendarUtils.addEvent(mmwebview.getContext(), jsonobject, mmwebview. new com.millennialmedia.internal.utils.CalendarUtils.CalendarListener() {

                    final JSBridgeMMJS this$1;
                    final String val$callbackId;
                    final MMWebView val$mmWebView;

                    public void onError(String s)
                    {
                        MMLog.e(JSBridge.TAG, s);
                        invokeCallback(callbackId, new Object[] {
                            Boolean.valueOf(false)
                        });
                    }

                    public void onSuccess()
                    {
                        Utils.showToast(mmWebView.getContext(), "Event added to calendar");
                        invokeCallback(callbackId, new Object[] {
                            Boolean.valueOf(true)
                        });
                    }

                    public void onUIDisplayed()
                    {
                        if (MMLog.isDebugEnabled())
                        {
                            MMLog.d(JSBridge.TAG, "Calendar activity started");
                        }
                        jsBridgeListener.onAdLeftApplication();
                        invokeCallback(callbackId, new Object[] {
                            Boolean.valueOf(true)
                        });
                    }

            
            {
                this$1 = final_jsbridgemmjs;
                callbackId = s;
                mmWebView = MMWebView.this;
                super();
            }
                });
                return;
            }
        }

        public void call(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MMJS: call(").append(s).append(")").toString());
            }
            Object obj = new JSONObject(s);
            s = ((JSONObject) (obj)).optString("callbackId", null);
            if (!apiCallsEnabled)
            {
                MMLog.e(JSBridge.TAG, "Ad has not been clicked");
                invokeCallback(s, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            }
            obj = ((JSONObject) (obj)).optString("number", null);
            if (obj == null)
            {
                MMLog.e(JSBridge.TAG, "No number provided");
                invokeCallback(s, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            }
            obj = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("tel:").append(((String) (obj))).toString()));
            boolean flag = Utils.startActivity(EnvironmentUtils.getApplicationContext(), ((Intent) (obj)));
            if (flag)
            {
                jsBridgeListener.onAdLeftApplication();
            }
            invokeCallback(s, new Object[] {
                Boolean.valueOf(flag)
            });
        }

        public void email(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MMJS: email(").append(s).append(")").toString());
            }
            JSONObject jsonobject = new JSONObject(s);
            String s1 = jsonobject.optString("callbackId", null);
            if (!apiCallsEnabled)
            {
                MMLog.e(JSBridge.TAG, "Ad has not been clicked");
                invokeCallback(s1, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            }
            JSONArray jsonarray1 = null;
            JSONArray jsonarray = null;
            s = null;
            Object obj = jsonobject.optJSONObject("recipients");
            if (obj != null)
            {
                jsonarray1 = ((JSONObject) (obj)).optJSONArray("to");
                jsonarray = ((JSONObject) (obj)).optJSONArray("cc");
                s = ((JSONObject) (obj)).optJSONArray("bcc");
            }
            obj = jsonobject.optString("subject", null);
            if (obj == null)
            {
                MMLog.e(JSBridge.TAG, "No subject provided");
                invokeCallback(s1, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            }
            String s2 = jsonobject.optString("message", null);
            if (s2 == null)
            {
                MMLog.e(JSBridge.TAG, "No message provided");
                invokeCallback(s1, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            }
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType(jsonobject.optString("type", "text/plain"));
            if (jsonarray1 != null)
            {
                intent.putExtra("android.intent.extra.EMAIL", JSONUtils.convertToStringArray(jsonarray1));
            }
            if (jsonarray != null)
            {
                intent.putExtra("android.intent.extra.CC", JSONUtils.convertToStringArray(jsonarray));
            }
            if (s != null)
            {
                intent.putExtra("android.intent.extra.BCC", JSONUtils.convertToStringArray(s));
            }
            intent.putExtra("android.intent.extra.SUBJECT", ((String) (obj)));
            intent.putExtra("android.intent.extra.TEXT", s2);
            boolean flag = Utils.startActivity(EnvironmentUtils.getApplicationContext(), intent);
            if (flag)
            {
                jsBridgeListener.onAdLeftApplication();
            }
            invokeCallback(s1, new Object[] {
                Boolean.valueOf(flag)
            });
        }

        public void getAvailableSourceTypes(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MMJS: getAvailableSourceTypes(").append(s).append(")").toString());
            }
            s = (new JSONObject(s)).optString("callbackId", null);
            JSONArray jsonarray = new JSONArray();
            com.millennialmedia.internal.utils.EnvironmentUtils.AvailableCameras availablecameras = EnvironmentUtils.getAvailableCameras();
            if (availablecameras.backCamera)
            {
                jsonarray.put("Rear Camera");
            }
            if (availablecameras.frontCamera)
            {
                jsonarray.put("Front Camera");
            }
            if (availablecameras.frontCamera || availablecameras.backCamera)
            {
                jsonarray.put("Camera");
            }
            if (MediaUtils.isPictureChooserAvailable())
            {
                jsonarray.put("Photo Library");
            }
            invokeCallback(s, new Object[] {
                jsonarray
            });
        }

        public void getPictureFromPhotoLibrary(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MMJS: getPictureFromPhotoLibrary(").append(s).append(")").toString());
            }
            Object obj = new JSONObject(s);
            s = ((JSONObject) (obj)).optString("callbackId", null);
            if (!apiCallsEnabled)
            {
                MMLog.e(JSBridge.TAG, "Ad has not been clicked");
                invokeCallback(s, new Object[] {
                    null
                });
                return;
            }
            obj = ((JSONObject) (obj)).optJSONObject("size");
            if (obj == null)
            {
                MMLog.e(JSBridge.TAG, "No size parameters provided");
                invokeCallback(s, new Object[] {
                    null
                });
                return;
            }
            DisplayMetrics displaymetrics = EnvironmentUtils.getApplicationContext().getResources().getDisplayMetrics();
            final int maxWidth = (int)TypedValue.applyDimension(1, ((JSONObject) (obj)).optInt("maxWidth", 0), displaymetrics);
            final int maxHeight = (int)TypedValue.applyDimension(1, ((JSONObject) (obj)).optInt("maxHeight", 0), displaymetrics);
            final boolean maintainAspectRatio = ((JSONObject) (obj)).optBoolean("maintainAspectRatio", true);
            if (maxWidth <= 0 || maxHeight <= 0)
            {
                MMLog.e(JSBridge.TAG, "maxWidth and maxHeight must be > 0");
                invokeCallback(s, new Object[] {
                    null
                });
                return;
            }
            obj = (MMWebView)mmWebViewRef.get();
            if (obj == null)
            {
                MMLog.e(JSBridge.TAG, "Webview is no longer valid");
                invokeCallback(s, new Object[] {
                    null
                });
                return;
            } else
            {
                MediaUtils.getPhotoFromGallery(((MMWebView) (obj)).getContext(), s. new com.millennialmedia.internal.utils.MediaUtils.PhotoListener() {

                    final JSBridgeMMJS this$1;
                    final String val$callbackId;
                    final boolean val$maintainAspectRatio;
                    final int val$maxHeight;
                    final int val$maxWidth;

                    public void onError(String s)
                    {
                        MMLog.e(JSBridge.TAG, s);
                        invokeCallback(callbackId, new Object[] {
                            null
                        });
                    }

                    public void onPhoto(File file)
                    {
                        Object obj = null;
                        String s = MediaUtils.getMimeTypeFromFile(file);
                        Bitmap bitmap = MediaUtils.getScaledBitmapFromFile(file, maxWidth, maxHeight, maintainAspectRatio, true);
                        file = obj;
                        if (bitmap != null)
                        {
                            file = MediaUtils.base64EncodeBitmap(bitmap, s);
                            bitmap.recycle();
                        }
                        invokeCallback(callbackId, new Object[] {
                            file
                        });
                    }

            
            {
                this$1 = final_jsbridgemmjs;
                maxWidth = i;
                maxHeight = j;
                maintainAspectRatio = flag;
                callbackId = String.this;
                super();
            }
                });
                return;
            }
        }

        public void isPackageAvailable(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MMJS: isPackageAvailable(").append(s).append(")").toString());
            }
            Object obj = new JSONObject(s);
            s = ((JSONObject) (obj)).optString("callbackId", null);
            obj = ((JSONObject) (obj)).optString("name", null);
            if (obj == null)
            {
                MMLog.e(JSBridge.TAG, "name was not provided");
                invokeCallback(s, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            } else
            {
                boolean flag = Utils.isPackageAvailable(((String) (obj)));
                invokeCallback(s, new Object[] {
                    Boolean.valueOf(flag)
                });
                return;
            }
        }

        public void isSchemeAvailable(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MMJS: isSchemeAvailable(").append(s).append(")").toString());
            }
            Object obj = new JSONObject(s);
            s = ((JSONObject) (obj)).optString("callbackId", null);
            obj = ((JSONObject) (obj)).optString("name", null);
            if (obj == null)
            {
                MMLog.e(JSBridge.TAG, "name was not provided");
                invokeCallback(s, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            } else
            {
                boolean flag = Utils.isSchemeAvailable(((String) (obj)));
                invokeCallback(s, new Object[] {
                    Boolean.valueOf(flag)
                });
                return;
            }
        }

        public void isSourceTypeAvailable(String s)
            throws JSONException
        {
            Object obj;
            boolean flag;
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MMJS: isSourceTypeAvailable(").append(s).append(")").toString());
            }
            obj = new JSONObject(s);
            s = ((JSONObject) (obj)).optString("callbackId", null);
            obj = ((JSONObject) (obj)).optString("sourceType", null);
            if (obj == null)
            {
                MMLog.e(JSBridge.TAG, "sourceType was not provided");
                invokeCallback(s, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            }
            flag = false;
            if (!"Photo Library".equals(obj)) goto _L2; else goto _L1
_L1:
            flag = MediaUtils.isPictureChooserAvailable();
_L4:
            invokeCallback(s, new Object[] {
                Boolean.valueOf(flag)
            });
            return;
_L2:
            com.millennialmedia.internal.utils.EnvironmentUtils.AvailableCameras availablecameras = EnvironmentUtils.getAvailableCameras();
            if ("Camera".equals(obj))
            {
                if (availablecameras.frontCamera || availablecameras.backCamera)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            if ("Rear Camera".equals(obj))
            {
                flag = availablecameras.backCamera;
            } else
            if ("Front Camera".equals(obj))
            {
                flag = availablecameras.frontCamera;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void location(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MMJS: location(").append(s).append(")").toString());
            }
            s = (new JSONObject(s)).optString("callbackId", null);
            Location location1 = EnvironmentUtils.getLocation();
            if (location1 == null)
            {
                invokeCallback(s, new Object[] {
                    null
                });
                return;
            } else
            {
                JSONObject jsonobject = new JSONObject();
                jsonobject.put("latitude", location1.getLatitude());
                jsonobject.put("longitude", location1.getLongitude());
                jsonobject.put("altitude", location1.getAltitude());
                jsonobject.put("accuracy", location1.getAccuracy());
                jsonobject.put("altitudeAccuracy", 0.0D);
                jsonobject.put("heading", location1.getBearing());
                jsonobject.put("speed", location1.getSpeed());
                invokeCallback(s, new Object[] {
                    jsonobject
                });
                return;
            }
        }

        public void openAppStore(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MMJS: openAppStore(").append(s).append(")").toString());
            }
            s = new JSONObject(s);
            String s1 = s.optString("callbackId", null);
            if (!apiCallsEnabled)
            {
                MMLog.e(JSBridge.TAG, "Ad has not been clicked");
                invokeCallback(s1, new Object[] {
                    Boolean.valueOf(false), "Ad has not been clicked"
                });
                return;
            }
            s = s.optString("appId", null);
            if (s == null)
            {
                invokeCallback(s1, new Object[] {
                    Boolean.valueOf(false), "appId was not provided"
                });
                return;
            }
            if (Build.MANUFACTURER.equals("Amazon"))
            {
                s = (new StringBuilder()).append("amzn://apps/android?p=").append(s).toString();
            } else
            {
                s = (new StringBuilder()).append("market://details?id=").append(s).toString();
            }
            if (Utils.startActivityFromUrl(s))
            {
                jsBridgeListener.onAdLeftApplication();
                invokeCallback(s1, new Object[] {
                    Boolean.valueOf(true)
                });
                return;
            } else
            {
                invokeCallback(s1, new Object[] {
                    Boolean.valueOf(false), "Unable to open app store"
                });
                return;
            }
        }

        public void openCamera(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MMJS: openCamera(").append(s).append(")").toString());
            }
            Object obj = new JSONObject(s);
            s = ((JSONObject) (obj)).optString("callbackId", null);
            if (!apiCallsEnabled)
            {
                MMLog.e(JSBridge.TAG, "Ad has not been clicked");
                invokeCallback(s, new Object[] {
                    null
                });
                return;
            }
            obj = ((JSONObject) (obj)).optJSONObject("size");
            if (obj == null)
            {
                MMLog.e(JSBridge.TAG, "No size parameters provided");
                invokeCallback(s, new Object[] {
                    null
                });
                return;
            }
            DisplayMetrics displaymetrics = EnvironmentUtils.getApplicationContext().getResources().getDisplayMetrics();
            final int maxWidth = (int)TypedValue.applyDimension(1, ((JSONObject) (obj)).optInt("maxWidth", 0), displaymetrics);
            final int maxHeight = (int)TypedValue.applyDimension(1, ((JSONObject) (obj)).optInt("maxHeight", 0), displaymetrics);
            final boolean maintainAspectRatio = ((JSONObject) (obj)).optBoolean("maintainAspectRatio", true);
            if (maxWidth <= 0 || maxHeight <= 0)
            {
                MMLog.e(JSBridge.TAG, "maxWidth and maxHeight must be > 0");
                invokeCallback(s, new Object[] {
                    null
                });
                return;
            }
            obj = (MMWebView)mmWebViewRef.get();
            if (obj == null)
            {
                MMLog.e(JSBridge.TAG, "Webview is no longer valid");
                invokeCallback(s, new Object[] {
                    null
                });
                return;
            } else
            {
                MediaUtils.getPhotoFromCamera(((MMWebView) (obj)).getContext(), s. new com.millennialmedia.internal.utils.MediaUtils.PhotoListener() {

                    final JSBridgeMMJS this$1;
                    final String val$callbackId;
                    final boolean val$maintainAspectRatio;
                    final int val$maxHeight;
                    final int val$maxWidth;

                    public void onError(String s)
                    {
                        MMLog.e(JSBridge.TAG, s);
                        invokeCallback(callbackId, new Object[] {
                            null
                        });
                    }

                    public void onPhoto(File file)
                    {
                        String s = null;
                        String s1 = MediaUtils.getMimeTypeFromFile(file);
                        Bitmap bitmap = MediaUtils.getScaledBitmapFromFile(file, maxWidth, maxHeight, maintainAspectRatio, true);
                        if (bitmap != null)
                        {
                            s = MediaUtils.base64EncodeBitmap(bitmap, s1);
                            bitmap.recycle();
                        }
                        file.delete();
                        invokeCallback(callbackId, new Object[] {
                            s
                        });
                    }

            
            {
                this$1 = final_jsbridgemmjs;
                maxWidth = i;
                maxHeight = j;
                maintainAspectRatio = flag;
                callbackId = String.this;
                super();
            }
                });
                return;
            }
        }

        public void openInBrowser(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MMJS: openInBrowser(").append(s).append(")").toString());
            }
            s = new JSONObject(s);
            String s1 = s.optString("callbackId", null);
            if (!apiCallsEnabled)
            {
                MMLog.e(JSBridge.TAG, "Ad has not been clicked");
                invokeCallback(s1, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            }
            boolean flag = Utils.startActivityFromUrl(s.optString("url", null));
            if (flag)
            {
                jsBridgeListener.onAdLeftApplication();
            }
            invokeCallback(s1, new Object[] {
                Boolean.valueOf(flag)
            });
        }

        public void openMap(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MMJS: openMap(").append(s).append(")").toString());
            }
            Object obj = new JSONObject(s);
            String s1 = ((JSONObject) (obj)).optString("callbackId", null);
            if (!apiCallsEnabled)
            {
                MMLog.e(JSBridge.TAG, "Ad has not been clicked");
                invokeCallback(s1, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            }
            if (((JSONObject) (obj)).has("address"))
            {
                s = ((JSONObject) (obj)).optString("address");
                try
                {
                    s = (new StringBuilder()).append("geo:0,0?q=").append(URLEncoder.encode(s, "utf-8")).toString();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    invokeCallback(s1, new Object[] {
                        Boolean.valueOf(false), "Unable to encode address"
                    });
                    return;
                }
            } else
            if (((JSONObject) (obj)).has("longitude") && ((JSONObject) (obj)).has("latitude"))
            {
                s = Double.valueOf(((JSONObject) (obj)).optDouble("latitude"));
                obj = Double.valueOf(((JSONObject) (obj)).optDouble("longitude"));
                s = String.format("geo:%f,%f?q=%f,%f", new Object[] {
                    s, obj, s, obj
                });
            } else
            {
                invokeCallback(s1, new Object[] {
                    Boolean.valueOf(false), "address or latitude and longitude must be specified"
                });
                return;
            }
            if (Utils.startActivityFromUrl(s))
            {
                jsBridgeListener.onAdLeftApplication();
                invokeCallback(s1, new Object[] {
                    Boolean.valueOf(true)
                });
                return;
            } else
            {
                invokeCallback(s1, new Object[] {
                    Boolean.valueOf(false), "Unable to open map"
                });
                return;
            }
        }

        public void savePictureToPhotoLibrary(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MMJS: savePictureToPhotoLibrary(").append(s).append(")").toString());
            }
            Object obj = new JSONObject(s);
            s = ((JSONObject) (obj)).optString("callbackId", null);
            if (!apiCallsEnabled)
            {
                MMLog.e(JSBridge.TAG, "Ad has not been clicked");
                invokeCallback(s, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            }
            String s1 = ((JSONObject) (obj)).optString("name", null);
            final String description = ((JSONObject) (obj)).optString("description", null);
            obj = ((JSONObject) (obj)).optString("url", null);
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                MMLog.e(JSBridge.TAG, "No path specified for photo");
                invokeCallback(s, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            }
            final MMWebView mmWebView = (MMWebView)mmWebViewRef.get();
            if (mmWebView == null)
            {
                MMLog.e(JSBridge.TAG, "Webview is no longer valid");
                invokeCallback(s, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            } else
            {
                MediaUtils.savePicture(mmWebView.getContext(), ((String) (obj)), s1, s. new com.millennialmedia.internal.utils.MediaUtils.SavePictureListener() {

                    final JSBridgeMMJS this$1;
                    final String val$callbackId;
                    final String val$description;
                    final MMWebView val$mmWebView;

                    public void onError(String s)
                    {
                        MMLog.e(JSBridge.TAG, s);
                        invokeCallback(callbackId, new Object[] {
                            Boolean.valueOf(false)
                        });
                    }

                    public void onPictureSaved(File file)
                    {
                        if (description != null)
                        {
                            MediaUtils.setFileDescription(file, description);
                        }
                        Utils.showToast(mmWebView.getContext(), (new StringBuilder()).append(file.getName()).append(" stored in gallery").toString());
                        invokeCallback(callbackId, new Object[] {
                            Boolean.valueOf(true)
                        });
                    }

            
            {
                this$1 = final_jsbridgemmjs;
                description = s;
                mmWebView = mmwebview;
                callbackId = String.this;
                super();
            }
                });
                return;
            }
        }

        public void sms(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MMJS: sms(").append(s).append(")").toString());
            }
            Object obj = new JSONObject(s);
            s = ((JSONObject) (obj)).optString("callbackId", null);
            if (!apiCallsEnabled)
            {
                MMLog.e(JSBridge.TAG, "Ad has not been clicked");
                invokeCallback(s, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            }
            Object obj1 = ((JSONObject) (obj)).optJSONArray("recipients");
            if (obj1 == null || ((JSONArray) (obj1)).length() == 0)
            {
                MMLog.e(JSBridge.TAG, "No recipients provided");
                invokeCallback(s, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            }
            obj = ((JSONObject) (obj)).optString("message", null);
            if (obj == null)
            {
                MMLog.e(JSBridge.TAG, "No message provided");
                invokeCallback(s, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            }
            obj1 = TextUtils.join(",", JSONUtils.convertToStringArray(((JSONArray) (obj1))));
            obj1 = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("sms:").append(((String) (obj1))).toString()));
            ((Intent) (obj1)).putExtra("sms_body", ((String) (obj)));
            boolean flag = Utils.startActivity(EnvironmentUtils.getApplicationContext(), ((Intent) (obj1)));
            if (flag)
            {
                jsBridgeListener.onAdLeftApplication();
            }
            invokeCallback(s, new Object[] {
                Boolean.valueOf(flag)
            });
        }

        public void vibrate(final String onStartCallbackId)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MMJS: vibrate(").append(onStartCallbackId).append(")").toString());
            }
            Object obj = new JSONObject(onStartCallbackId);
            onStartCallbackId = ((JSONObject) (obj)).optString("onStartCallbackId", null);
            String s = ((JSONObject) (obj)).optString("onFinishCallbackId", null);
            obj = ((JSONObject) (obj)).optJSONArray("pattern");
            if (obj == null)
            {
                MMLog.e(JSBridge.TAG, "No pattern provided");
                invokeCallback(s, new Object[] {
                    Boolean.valueOf(false)
                });
                return;
            }
            long al[] = new long[((JSONArray) (obj)).length() + 1];
            al[0] = 0L;
            for (int i = 0; i < ((JSONArray) (obj)).length(); i++)
            {
                al[i + 1] = ((JSONArray) (obj)).getLong(i);
            }

            Utils.vibrate(al, -1, s. new com.millennialmedia.internal.utils.Utils.VibrateListener() {

                final JSBridgeMMJS this$1;
                final String val$onFinishCallbackId;
                final String val$onStartCallbackId;

                public void onError()
                {
                    invokeCallback(onFinishCallbackId, new Object[] {
                        Boolean.valueOf(false)
                    });
                }

                public void onFinished()
                {
                    invokeCallback(onFinishCallbackId, new Object[] {
                        Boolean.valueOf(true)
                    });
                }

                public void onStarted()
                {
                    invokeCallback(onStartCallbackId, new Object[0]);
                }

            
            {
                this$1 = final_jsbridgemmjs;
                onStartCallbackId = s;
                onFinishCallbackId = String.this;
                super();
            }
            });
        }

        JSBridgeMMJS()
        {
            this$0 = JSBridge.this;
            super();
        }
    }

    class JSBridgeMRAID
    {

        final JSBridge this$0;

        public void close(String s)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MRAID: close(").append(s).append(")").toString());
            }
            ThreadUtils.runOnUiThread(new Runnable() {

                final JSBridgeMRAID this$1;

                public void run()
                {
                    jsBridgeListener.close();
                }

            
            {
                this$1 = JSBridgeMRAID.this;
                super();
            }
            });
        }

        public void createCalendarEvent(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MRAID: createCalendarEvent(").append(s).append(")").toString());
            }
            if (!apiCallsEnabled)
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
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview == null)
            {
                throwMraidError("Webview is no longer valid", "createCalendarEvent");
                return;
            } else
            {
                CalendarUtils.addEventWithIntent(mmwebview.getContext(), s, new com.millennialmedia.internal.utils.CalendarUtils.CalendarListener() {

                    final JSBridgeMRAID this$1;

                    public void onError(String s)
                    {
                        throwMraidError(s, "createCalendarEvent");
                    }

                    public void onSuccess()
                    {
                    }

                    public void onUIDisplayed()
                    {
                        if (MMLog.isDebugEnabled())
                        {
                            MMLog.d(JSBridge.TAG, "Calendar activity started");
                        }
                    }

            
            {
                this$1 = JSBridgeMRAID.this;
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
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MRAID: expand(").append(s).append(")").toString());
            }
            if (!apiCallsEnabled)
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
            DisplayMetrics displaymetrics = EnvironmentUtils.getApplicationContext().getResources().getDisplayMetrics();
            SizableStateManager.ExpandParams expandparams = new SizableStateManager.ExpandParams();
            if (s.has("width"))
            {
                expandparams.width = Math.min((int)TypedValue.applyDimension(1, s.getInt("width"), displaymetrics), EnvironmentUtils.getDisplayWidth());
            } else
            {
                expandparams.width = -1;
            }
            if (s.has("height"))
            {
                expandparams.height = Math.min((int)TypedValue.applyDimension(1, s.getInt("height"), displaymetrics), EnvironmentUtils.getDisplayHeight());
            } else
            {
                expandparams.height = -1;
            }
            if (s.optBoolean("useCustomClose", JSBridge.this.useCustomClose))
            {
                flag = false;
            }
            expandparams.showCloseIndicator = flag;
            expandparams.orientation = requestedOrientation;
            expandparams.url = s.optString("url", null);
            ThreadUtils.runOnUiThread(expandparams. new Runnable() {

                final JSBridgeMRAID this$1;
                final SizableStateManager.ExpandParams val$expandParams;

                public void run()
                {
                    if (TextUtils.equals(currentState, "expanded") || TextUtils.equals(currentState, "hidden") || TextUtils.equals(currentState, "loading"))
                    {
                        throwMraidError((new StringBuilder()).append("Cannot expand in current state<").append(currentState).append(">").toString(), "expand");
                    } else
                    if (!jsBridgeListener.expand(expandParams))
                    {
                        throwMraidError("Unable to expand", "expand");
                        return;
                    }
                }

            
            {
                this$1 = final_jsbridgemraid;
                expandParams = SizableStateManager.ExpandParams.this;
                super();
            }
            });
        }

        public void open(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MRAID: open(").append(s).append(")").toString());
            }
            if (!apiCallsEnabled)
            {
                throwMraidError("Ad has not been clicked", "open");
                return;
            }
            s = (new JSONObject(s)).getString("url");
            if (Utils.startActivityFromUrl(s))
            {
                jsBridgeListener.onAdLeftApplication();
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
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MRAID: playVideo(").append(s).append(")").toString());
            }
            if (!apiCallsEnabled)
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
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview == null)
            {
                throwMraidError("Webview is no longer valid", "playVideo");
                return;
            } else
            {
                MediaUtils.startVideoPlayer(mmwebview.getContext(), s, new com.millennialmedia.internal.utils.MediaUtils.PlayVideoListener() {

                    final JSBridgeMRAID this$1;

                    public void onError(String s)
                    {
                        throwMraidError(s, "playVideo");
                    }

                    public void onVideoStarted(Uri uri)
                    {
                        if (MMLog.isDebugEnabled())
                        {
                            MMLog.d(JSBridge.TAG, (new StringBuilder()).append("Video activity started for <").append(uri.toString()).append(">").toString());
                        }
                    }

            
            {
                this$1 = JSBridgeMRAID.this;
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
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MRAID: resize(").append(s).append(")").toString());
            }
            if (!apiCallsEnabled)
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
                DisplayMetrics displaymetrics = EnvironmentUtils.getApplicationContext().getResources().getDisplayMetrics();
                SizableStateManager.ResizeParams resizeparams = new SizableStateManager.ResizeParams();
                resizeparams.width = (int)TypedValue.applyDimension(1, s.getInt("width"), displaymetrics);
                resizeparams.height = (int)TypedValue.applyDimension(1, s.getInt("height"), displaymetrics);
                resizeparams.offsetX = (int)TypedValue.applyDimension(1, s.optInt("offsetX", 0), displaymetrics);
                resizeparams.offsetY = (int)TypedValue.applyDimension(1, s.optInt("offsetY", 0), displaymetrics);
                resizeparams.customClosePosition = s.optString("customClosePosition", "top-right");
                resizeparams.allowOffScreen = s.optBoolean("allowOffscreen", true);
                ThreadUtils.runOnUiThread(resizeparams. new Runnable() {

                    final JSBridgeMRAID this$1;
                    final SizableStateManager.ResizeParams val$resizeParams;

                    public void run()
                    {
                        if (TextUtils.equals(currentState, "expanded") || TextUtils.equals(currentState, "hidden") || TextUtils.equals(currentState, "loading"))
                        {
                            throwMraidError((new StringBuilder()).append("Cannot resize in current state<").append(currentState).append(">").toString(), "resize");
                        } else
                        if (!jsBridgeListener.resize(resizeParams))
                        {
                            throwMraidError("Unable to resize", "resize");
                            return;
                        }
                    }

            
            {
                this$1 = final_jsbridgemraid;
                resizeParams = SizableStateManager.ResizeParams.this;
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
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MRAID: setOrientationProperties(").append(s).append(")").toString());
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

                final JSBridgeMRAID this$1;

                public void run()
                {
                    if (isInterstitial || currentState.equals("expanded"))
                    {
                        jsBridgeListener.setOrientation(requestedOrientation);
                    }
                }

            
            {
                this$1 = JSBridgeMRAID.this;
                super();
            }
            });
        }

        public void storePicture(String s)
            throws JSONException
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MRAID: storePicture(").append(s).append(")").toString());
            }
            if (!apiCallsEnabled)
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
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview == null)
            {
                throwMraidError("Webview is no longer valid", "storePicture");
                return;
            } else
            {
                MediaUtils.savePicture(mmwebview.getContext(), s, null, mmwebview. new com.millennialmedia.internal.utils.MediaUtils.SavePictureListener() {

                    final JSBridgeMRAID this$1;
                    final MMWebView val$mmWebView;

                    public void onError(String s)
                    {
                        throwMraidError(s, "storePicture");
                    }

                    public void onPictureSaved(File file)
                    {
                        Utils.showToast(mmWebView.getContext(), (new StringBuilder()).append(file.getName()).append(" stored in gallery").toString());
                    }

            
            {
                this$1 = final_jsbridgemraid;
                mmWebView = MMWebView.this;
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
                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("MRAID: useCustomClose(").append(s).append(")").toString());
            }
            s = new JSONObject(s);
            JSBridge.this.useCustomClose = s.optBoolean("useCustomClose", JSBridge.this.useCustomClose);
            ThreadUtils.runOnUiThread(new Runnable() {

                final JSBridgeMRAID this$1;

                public void run()
                {
                    JSBridgeListener jsbridgelistener = jsBridgeListener;
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
                this$1 = JSBridgeMRAID.this;
                super();
            }
            });
        }

        JSBridgeMRAID()
        {
            this$0 = JSBridge.this;
            super();
        }
    }

    class JSBridgeVastVideo
    {

        final JSBridge this$0;

        public void close(String s)
        {
            s = (MMWebView)mmWebViewRef.get();
            if (s instanceof com.millennialmedia.internal.video.VASTVideoView.VASTVideoWebView)
            {
                ((com.millennialmedia.internal.video.VASTVideoView.VASTVideoWebView)s).close();
                return;
            } else
            {
                MMLog.e(JSBridge.TAG, "Close cannot be called on a WebView that is not part of a VAST Video creative.");
                return;
            }
        }

        public void pause(String s)
        {
            s = (MMWebView)mmWebViewRef.get();
            if (s instanceof com.millennialmedia.internal.video.VASTVideoView.VASTVideoWebView)
            {
                ((com.millennialmedia.internal.video.VASTVideoView.VASTVideoWebView)s).pause();
                return;
            } else
            {
                MMLog.e(JSBridge.TAG, "Pause cannot be called on a WebView that is not part of a VAST Video creative.");
                return;
            }
        }

        public void play(String s)
        {
            s = (MMWebView)mmWebViewRef.get();
            if (s instanceof com.millennialmedia.internal.video.VASTVideoView.VASTVideoWebView)
            {
                ((com.millennialmedia.internal.video.VASTVideoView.VASTVideoWebView)s).play();
                return;
            } else
            {
                MMLog.e(JSBridge.TAG, "Play cannot be called on a WebView that is not part of a VAST Video creative.");
                return;
            }
        }

        public void restart(String s)
        {
            s = (MMWebView)mmWebViewRef.get();
            if (s instanceof com.millennialmedia.internal.video.VASTVideoView.VASTVideoWebView)
            {
                ((com.millennialmedia.internal.video.VASTVideoView.VASTVideoWebView)s).restart();
                return;
            } else
            {
                MMLog.e(JSBridge.TAG, "Restart cannot be called on a WebView that is not part of a VAST Video creative.");
                return;
            }
        }

        public void seek(String s)
            throws JSONException
        {
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview instanceof com.millennialmedia.internal.video.VASTVideoView.VASTVideoWebView)
            {
                int i = (new JSONObject(s)).getInt("seekTime");
                ((com.millennialmedia.internal.video.VASTVideoView.VASTVideoWebView)mmwebview).seek(i);
                return;
            } else
            {
                MMLog.e(JSBridge.TAG, "Seek cannot be called on a WebView that is not part of a VAST Video creative.");
                return;
            }
        }

        public void setTimeInterval(String s)
            throws JSONException
        {
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview instanceof com.millennialmedia.internal.video.VASTVideoView.VASTVideoWebView)
            {
                int i = (new JSONObject(s)).optInt("timeInterval", -1);
                ((com.millennialmedia.internal.video.VASTVideoView.VASTVideoWebView)mmwebview).setTimeInterval(i);
                return;
            } else
            {
                MMLog.e(JSBridge.TAG, "SetTimeInterval can't be called on a WebView that is not part of a VAST Video creative.");
                return;
            }
        }

        public void skip(String s)
        {
            s = (MMWebView)mmWebViewRef.get();
            if (s instanceof com.millennialmedia.internal.video.VASTVideoView.VASTVideoWebView)
            {
                ((com.millennialmedia.internal.video.VASTVideoView.VASTVideoWebView)s).skip();
            }
        }

        public void triggerTimeUpdate(String s)
        {
            s = (MMWebView)mmWebViewRef.get();
            if (s instanceof com.millennialmedia.internal.video.VASTVideoView.VASTVideoWebView)
            {
                ((com.millennialmedia.internal.video.VASTVideoView.VASTVideoWebView)s).triggerTimeUpdate();
                return;
            } else
            {
                MMLog.e(JSBridge.TAG, "TriggerTimeUpdate can't be called on a WebView that is not part of a VAST Video creative.");
                return;
            }
        }

        JSBridgeVastVideo()
        {
            this$0 = JSBridge.this;
            super();
        }
    }


    private static final String JS_MRAID_NAMESPACE = "MmJsBridge.mraid";
    private static final String JS_SET_PLACEMENT_TYPE = "MmJsBridge.mraid.setPlacementType";
    private static final String JS_SET_POSITIONS = "MmJsBridge.mraid.setPositions";
    private static final String JS_SET_STATE = "MmJsBridge.mraid.setState";
    private static final String JS_SET_SUPPORTS = "MmJsBridge.mraid.setSupports";
    private static final String JS_SET_VIEWABLE = "MmJsBridge.mraid.setViewable";
    private static final String JS_THROW_MRAID_ERROR = "MmJsBridge.mraid.throwMraidError";
    private static final String MM_JS_BRIDGE_CALL_CALLBACK = "MmJsBridge.callbackManager.callCallback";
    private static final String MM_JS_BRIDGE_SET_LOG_LEVEL = "MmJsBridge.logging.setLogLevel";
    private static final int SCROLL_IDLE_TIMEOUT = 450;
    private static final int SCROLL_UPDATE_INTERVAL = 100;
    private static final String STATE_DEFAULT = "default";
    private static final String STATE_EXPANDED = "expanded";
    private static final String STATE_HIDDEN = "hidden";
    private static final String STATE_LOADING = "loading";
    private static final String STATE_RESIZED = "resized";
    private static final String SUPPORTS_CALENDAR = "calendar";
    private static final String SUPPORTS_INLINE_VIDEO = "inlineVideo";
    private static final String SUPPORTS_SMS = "sms";
    private static final String SUPPORTS_STORE_PICTURE = "storePicture";
    private static final String SUPPORTS_TEL = "tel";
    private static final String TAG = com/millennialmedia/internal/JSBridge.getSimpleName();
    private static final Pattern bodyStartPattern = Pattern.compile("<body[^>]*>", 2);
    static final String bodyStyling = "<style>body {margin:0;padding:0;}</style>";
    private static final Pattern headEndPattern = Pattern.compile("</head>", 2);
    private static final Pattern mraidJsReplacePattern = Pattern.compile("<script\\s+[^>]*\\bsrc\\s*=\\s*([\\\"\\'])mraid\\.js\\1[^>]*>\\s*</script>", 2);
    static final List scriptFilesToInject;
    static final String scriptStatementsToInject;
    static final boolean useActionsQueue;
    private volatile JSONArray actionsQueue;
    private volatile boolean apiCallsEnabled;
    String currentState;
    private volatile Rect dimensions;
    boolean hasSize;
    final boolean isInterstitial;
    boolean isReady;
    boolean isResizing;
    boolean isTwoPartExpand;
    boolean isViewable;
    private volatile JSBridgeListener jsBridgeListener;
    boolean jsInjected;
    int lastOrientation;
    private volatile WeakReference mmWebViewRef;
    int requestedOrientation;
    List scriptsAwaitingLoad;
    private volatile long scrollIdleTimeout;
    private volatile AtomicBoolean scrollThrottling;
    boolean useCustomClose;

    JSBridge(MMWebView mmwebview, boolean flag, JSBridgeListener jsbridgelistener)
    {
        dimensions = new Rect();
        scrollThrottling = new AtomicBoolean(false);
        apiCallsEnabled = false;
        scriptsAwaitingLoad = new ArrayList();
        currentState = "loading";
        isTwoPartExpand = false;
        isResizing = true;
        isReady = false;
        jsInjected = false;
        isViewable = false;
        hasSize = false;
        useCustomClose = false;
        lastOrientation = EnvironmentUtils.getCurrentConfigOrientation();
        requestedOrientation = -1;
        mmWebViewRef = new WeakReference(mmwebview);
        jsBridgeListener = jsbridgelistener;
        isInterstitial = flag;
        if (mmwebview != null)
        {
            mmwebview.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() {

                final JSBridge this$0;

                public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
                        int k1, int l1)
                {
                    if (view instanceof MMWebView)
                    {
                        i = EnvironmentUtils.getCurrentConfigOrientation();
                        if (lastOrientation != i)
                        {
                            if (MMLog.isDebugEnabled())
                            {
                                MMLog.d(JSBridge.TAG, (new StringBuilder()).append("Detected change in orientation to ").append(EnvironmentUtils.getCurrentConfigOrientationString()).toString());
                            }
                            lastOrientation = i;
                            sendPositions((MMWebView)view);
                        }
                    }
                }

            
            {
                this$0 = JSBridge.this;
                super();
            }
            });
        }
    }

    static JSONObject getSupportedFeatures()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("sms", EnvironmentUtils.isSmsSupported());
            jsonobject.put("tel", EnvironmentUtils.isTelSupported());
            jsonobject.put("calendar", EnvironmentUtils.isCalendarSupported());
            jsonobject.put("storePicture", EnvironmentUtils.isExternalStorageSupported());
            jsonobject.put("inlineVideo", true);
        }
        catch (JSONException jsonexception)
        {
            MMLog.e(TAG, "Error creating supports dictionary", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    transient void callJavascript(String s, Object aobj[])
    {
        aobj = new JSONArray(Arrays.asList(aobj));
        if (!isReady)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, (new StringBuilder()).append("jsBridge scripts are not loaded: ").append(s).append("(").append(((JSONArray) (aobj)).join(",")).append(")").toString());
                return;
            }
            break MISSING_BLOCK_LABEL_247;
        }
        JSONObject jsonobject;
        if (!useActionsQueue)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        jsonobject = new JSONObject();
        jsonobject.put("functionName", s);
        jsonobject.put("args", ((Object) (aobj)));
        this;
        JVM INSTR monitorenter ;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Queuing js: ").append(s).append(" args: ").append(((JSONArray) (aobj)).toString()).toString());
        }
        if (actionsQueue == null)
        {
            actionsQueue = new JSONArray();
        }
        actionsQueue.put(jsonobject);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        try
        {
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MMLog.e(TAG, "Unable to execute javascript function", s);
        }
        return;
        ThreadUtils.runOnUiThread(new Runnable() {

            final JSBridge this$0;
            final String val$js;

            public void run()
            {
                MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
                if (mmwebview != null)
                {
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(JSBridge.TAG, (new StringBuilder()).append("Calling js: ").append(js).toString());
                    }
                    mmwebview.evaluateJavascript(js, null);
                }
            }

            
            {
                this$0 = JSBridge.this;
                js = s;
                super();
            }
        });
    }

    public void enableApiCalls()
    {
        apiCallsEnabled = true;
    }

    JSONObject getJsonCurrentPosition(MMWebView mmwebview)
    {
        ViewUtils.getViewDimensionsRelativeToContent(mmwebview, dimensions);
        if (dimensions == null)
        {
            return null;
        }
        ViewUtils.convertPixelsToDips(dimensions);
        mmwebview = new JSONObject();
        try
        {
            mmwebview.put("x", dimensions.left);
            mmwebview.put("y", dimensions.top);
            mmwebview.put("width", dimensions.width());
            mmwebview.put("height", dimensions.height());
        }
        catch (JSONException jsonexception)
        {
            MMLog.e(TAG, "Error creating json object");
            return mmwebview;
        }
        return mmwebview;
    }

    String injectJSBridge(String s)
    {
        if (!jsInjected)
        {
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview != null)
            {
                mmwebview.addJavascriptInterface(new JSBridgeCommon(), "MmInjectedFunctions");
                mmwebview.addJavascriptInterface(new JSBridgeMRAID(), "MmInjectedFunctionsMraid");
                mmwebview.addJavascriptInterface(new JSBridgeInlineVideo(), "MmInjectedFunctionsInlineVideo");
                mmwebview.addJavascriptInterface(new JSBridgeMMJS(), "MmInjectedFunctionsMmjs");
                mmwebview.addJavascriptInterface(new JSBridgeVastVideo(), "MmInjectedFunctionsVast");
            }
            jsInjected = true;
        }
        Matcher matcher = mraidJsReplacePattern.matcher(s);
        if (matcher.find(0))
        {
            String s1 = matcher.replaceFirst(scriptStatementsToInject);
            matcher.usePattern(bodyStartPattern);
            s = s1;
            if (!matcher.find(0))
            {
                s = (new StringBuilder()).append("<style>body {margin:0;padding:0;}</style>").append(s1).toString();
            }
        } else
        {
            matcher.usePattern(headEndPattern);
            if (matcher.find(0))
            {
                s = matcher.replaceFirst((new StringBuilder()).append(scriptStatementsToInject).append(matcher.group()).toString());
            } else
            {
                matcher.usePattern(bodyStartPattern);
                if (matcher.find(0))
                {
                    s = matcher.replaceFirst((new StringBuilder()).append(matcher.group()).append(scriptStatementsToInject).toString());
                } else
                {
                    s = (new StringBuilder()).append("<style>body {margin:0;padding:0;}</style>").append(scriptStatementsToInject).append(s).toString();
                }
            }
        }
        scriptsAwaitingLoad = new ArrayList(scriptFilesToInject);
        isReady = false;
        return s;
    }

    public transient void invokeCallback(String s, Object aobj[])
    {
        if (s == null)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "No callbackId provided");
            }
            return;
        }
        Object aobj1[] = aobj;
        if (aobj == null)
        {
            aobj1 = new Object[1];
        }
        aobj = new Object[aobj1.length + 1];
        aobj[0] = s;
        for (int i = 0; i < aobj1.length; i++)
        {
            aobj[i + 1] = aobj1[i];
        }

        callJavascript("MmJsBridge.callbackManager.callCallback", aobj);
    }

    void sendPositions(MMWebView mmwebview)
    {
        float f = EnvironmentUtils.getDisplayDensity();
        int i = (int)((float)EnvironmentUtils.getDisplayWidth() / f);
        int j = (int)((float)EnvironmentUtils.getDisplayHeight() / f);
        Object obj = ViewUtils.getContentDimensions(mmwebview, null);
        JSONObject jsonobject;
        JSONObject jsonobject1;
        try
        {
            mmwebview = getJsonCurrentPosition(mmwebview);
            jsonobject = new JSONObject();
            jsonobject.put("width", i);
            jsonobject.put("height", j);
            jsonobject1 = new JSONObject();
        }
        // Misplaced declaration of an exception variable
        catch (MMWebView mmwebview)
        {
            MMLog.e(TAG, "Error creating json object in setCurrentPosition");
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        ViewUtils.convertPixelsToDips(((Rect) (obj)));
        jsonobject1.put("width", ((Rect) (obj)).width());
        jsonobject1.put("height", ((Rect) (obj)).height());
        obj = new JSONObject();
        ((JSONObject) (obj)).put("currentPosition", mmwebview);
        ((JSONObject) (obj)).put("screenSize", jsonobject);
        ((JSONObject) (obj)).put("maxSize", jsonobject1);
        callJavascript("MmJsBridge.mraid.setPositions", new Object[] {
            obj
        });
        return;
    }

    void setCurrentPosition(MMWebView mmwebview)
    {
        mmwebview = getJsonCurrentPosition(mmwebview);
        if (mmwebview != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!isReady)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!isResizing)
        {
            try
            {
                JSONObject jsonobject = new JSONObject();
                jsonobject.put("currentPosition", mmwebview);
                callJavascript("MmJsBridge.mraid.setPositions", new Object[] {
                    jsonobject
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (MMWebView mmwebview)
            {
                MMLog.e(TAG, "Error creating json object in setCurrentPosition");
            }
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        int i = mmwebview.optInt("width", 0);
        int j = mmwebview.optInt("height", 0);
        if (i > 0 && j > 0)
        {
            hasSize = true;
            setReadyState();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void setLogLevel(int i)
    {
        String s = "DEBUG";
        if (i < 6) goto _L2; else goto _L1
_L1:
        s = "ERROR";
_L4:
        callJavascript("MmJsBridge.logging.setLogLevel", new Object[] {
            s
        });
        return;
_L2:
        if (i >= 4)
        {
            s = "INFO";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    void setReadyState()
    {
        if (!isReady && hasSize && isViewable && scriptsAwaitingLoad.size() == 0)
        {
            MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
            if (mmwebview != null)
            {
                isReady = true;
                String s;
                if (isInterstitial)
                {
                    s = "interstitial";
                } else
                {
                    s = "inline";
                }
                callJavascript("MmJsBridge.mraid.setPlacementType", new Object[] {
                    s
                });
                callJavascript("MmJsBridge.mraid.setSupports", new Object[] {
                    getSupportedFeatures()
                });
                sendPositions(mmwebview);
                callJavascript("MmJsBridge.mraid.setViewable", new Object[] {
                    Boolean.valueOf(isViewable)
                });
                if (isTwoPartExpand)
                {
                    s = "expanded";
                } else
                {
                    s = "default";
                }
                setState(s);
                if (jsBridgeListener != null)
                {
                    jsBridgeListener.onJSBridgeReady();
                    return;
                }
            }
        }
    }

    void setScrolledPosition(MMWebView mmwebview)
    {
        scrollIdleTimeout = System.currentTimeMillis() + 450L;
        if (scrollThrottling.compareAndSet(false, true))
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final JSBridge this$0;

                public void run()
                {
                    long l = 0L;
_L3:
                    Thread.sleep(100L);
                    Object obj = (MMWebView)mmWebViewRef.get();
                    if (obj != null) goto _L2; else goto _L1
_L1:
                    scrollThrottling.set(false);
                    return;
                    obj;
                    if (true) goto _L1; else goto _L2
_L2:
                    long l1 = l;
                    if (scrollIdleTimeout > l)
                    {
                        l1 = scrollIdleTimeout;
                        setCurrentPosition(((MMWebView) (obj)));
                    }
                    l = l1;
                    if (System.currentTimeMillis() < scrollIdleTimeout) goto _L3; else goto _L1
                }

            
            {
                this$0 = JSBridge.this;
                super();
            }
            });
        }
    }

    void setState(String s)
    {
        if (isReady)
        {
            isResizing = false;
            if (!TextUtils.equals(s, currentState) || TextUtils.equals(s, "resized"))
            {
                currentState = s;
                MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
                if (mmwebview != null)
                {
                    callJavascript("MmJsBridge.mraid.setState", new Object[] {
                        s, getJsonCurrentPosition(mmwebview)
                    });
                    return;
                }
            }
        }
    }

    public void setStateCollapsed()
    {
        if (isInterstitial)
        {
            setState("hidden");
            return;
        } else
        {
            setState("default");
            return;
        }
    }

    public void setStateExpanded()
    {
        if (isInterstitial)
        {
            setState("default");
            return;
        } else
        {
            setState("expanded");
            return;
        }
    }

    public void setStateResized()
    {
        setState("resized");
    }

    public void setStateResizing()
    {
        isResizing = true;
    }

    public void setStateUnresized()
    {
        setState("default");
    }

    public void setTwoPartExpand()
    {
        isTwoPartExpand = true;
    }

    void setViewable(boolean flag)
    {
label0:
        {
            if (flag != isViewable)
            {
                isViewable = flag;
                if (!isReady)
                {
                    break label0;
                }
                callJavascript("MmJsBridge.mraid.setViewable", new Object[] {
                    Boolean.valueOf(flag)
                });
            }
            return;
        }
        setReadyState();
    }

    void throwMraidError(String s, String s1)
    {
        MMLog.e(TAG, (new StringBuilder()).append("MRAID error - action: ").append(s1).append(" message: ").append(s).toString());
        callJavascript("MmJsBridge.mraid.throwMraidError", new Object[] {
            s, s1
        });
    }

    static 
    {
        StringBuilder stringbuilder;
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        useActionsQueue = flag;
        scriptFilesToInject = new ArrayList();
        if (useActionsQueue)
        {
            scriptFilesToInject.add("actionsQueue.js");
        }
        scriptFilesToInject.add("mm.js");
        scriptFilesToInject.add("mraid.js");
        stringbuilder = new StringBuilder();
        for (Iterator iterator = scriptFilesToInject.iterator(); iterator.hasNext(); stringbuilder.append("\"></script>"))
        {
            String s = (String)iterator.next();
            stringbuilder.append("<script src=\"mmadsdk/");
            stringbuilder.append(s);
        }

        scriptStatementsToInject = stringbuilder.toString();
    }





/*
    static JSONArray access$202(JSBridge jsbridge, JSONArray jsonarray)
    {
        jsbridge.actionsQueue = jsonarray;
        return jsonarray;
    }

*/




}
