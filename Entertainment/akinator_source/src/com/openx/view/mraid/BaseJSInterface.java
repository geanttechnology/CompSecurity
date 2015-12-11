// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.openx.view.mraid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;
import com.openx.common.deviceData.listeners.DeviceInfoListener;
import com.openx.common.utils.helpers.Utils;
import com.openx.common.utils.logger.OXLog;
import com.openx.core.network.BaseResponseHandler;
import com.openx.core.sdk.OXMManagersResolver;
import com.openx.core.sdk.OXSettings;
import com.openx.model.Ad;
import com.openx.model.AdCreative;
import com.openx.view.WebViewBase;
import com.openx.view.mraid.methods.CalendarEvent;
import com.openx.view.mraid.methods.Close;
import com.openx.view.mraid.methods.Expand;
import com.openx.view.mraid.methods.Open;
import com.openx.view.mraid.methods.PlayVideo;
import com.openx.view.mraid.methods.Resize;
import com.openx.view.mraid.methods.StorePicture;
import com.openx.view.mraid.network.GetOriginalUrlTask;
import com.openx.view.mraid.network.RedirectURLListener;
import java.util.Hashtable;
import java.util.Vector;
import org.json.JSONObject;

// Referenced classes of package com.openx.view.mraid:
//            JSInterface

public class BaseJSInterface
    implements JSInterface, BaseResponseHandler
{

    private static final int MAX_REDIRECTS = 3;
    public static String disabledFlags = null;
    private WebViewBase adBaseView;
    private Context context;
    private String mCurrentState;
    private Boolean mCurrentViewable;
    private android.view.ViewGroup.LayoutParams mDefaultLayoutParams;
    private String mExpandProperties;
    private Hashtable mHandlersQueue;
    private boolean mLaunchedWithURL;
    private String mOrientationProperties;
    private PopupWindow mResizedAdWindow;
    private Boolean mRestoreState;
    private String mURLForLaunching;
    CalendarEvent mraidCalendarEvent;
    private Close mraidClose;
    private Expand mraidExpand;
    private Open mraidOpen;
    private PlayVideo mraidPlayVideo;
    private Resize mraidResize;
    private StorePicture mraidStorePicture;

    public BaseJSInterface(Context context1, WebViewBase webviewbase)
    {
        mHandlersQueue = new Hashtable();
        mCurrentState = null;
        mCurrentViewable = null;
        mExpandProperties = null;
        mOrientationProperties = null;
        context = context1;
        adBaseView = webviewbase;
    }

    private void evaluateJavaScript(String s)
    {
        OXLog.debug("BaseJSInterface", (new StringBuilder()).append("BaseJSInterface: evaluateJavaScript: ").append(s).toString());
        ((Activity)adBaseView.getContext()).runOnUiThread(new _cls3(s));
    }

    private Handler findHandler(String s)
    {
        while (s == null || s.equals("") || !getHandlersQueue().containsKey(s)) 
        {
            return null;
        }
        return (Handler)getHandlersQueue().get(s);
    }

    private Hashtable getHandlersQueue()
    {
        return mHandlersQueue;
    }

    private String queueHandler(Handler handler)
    {
        if (handler == null)
        {
            return null;
        }
        String s = String.valueOf(System.identityHashCode(handler));
        if (getHandlersQueue().containsKey(s))
        {
            getHandlersQueue().remove(s);
        }
        getHandlersQueue().put(s, handler);
        return s;
    }

    private void removeHandler(String s)
    {
        while (s == null || s.equals("") || !getHandlersQueue().containsKey(s)) 
        {
            return;
        }
        getHandlersQueue().remove(s);
    }

    protected void callJavaScriptMethodWithResult(String s, Handler handler)
    {
        if (adBaseView.isMRAID())
        {
            handler = queueHandler(handler);
            if (handler != null)
            {
                evaluateJavaScript((new StringBuilder()).append("jsBridge.javaScriptCallback('").append(handler).append("', '").append(s).append("', (function() { var retVal = mraid.").append(s).append("(); if (typeof retVal === 'object') { retVal = JSON.stringify(retVal); } return retVal; })())").toString());
            }
        } else
        if (handler != null)
        {
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("method", s);
            bundle.putString("value", "");
            message.setData(bundle);
            handler.dispatchMessage(message);
            return;
        }
    }

    protected void clearFlags()
    {
        mCurrentState = null;
        mCurrentViewable = null;
    }

    public void close()
    {
        if (mraidClose == null)
        {
            mraidClose = new Close(context, this, adBaseView);
        }
        mraidClose.closeThroughJS(true);
    }

    public void closeResizedAdWindow(boolean flag)
    {
        if (isResizedAdWindowOpened())
        {
            setRestoreStateOnPopupClose(flag);
            getResizedAdWindow().dismiss();
        }
    }

    public void createCalendarEvent(String s)
    {
        if (mraidCalendarEvent == null)
        {
            mraidCalendarEvent = new CalendarEvent(context, this, adBaseView);
        }
        mraidCalendarEvent.createCalendarEvent(s);
    }

    public void expand()
    {
        OXLog.debug("MRAID", "stopping loading and calling mraidExpand 0");
        adBaseView.stoppedLoading();
        expand(null);
    }

    public void expand(String s)
    {
        OXLog.debug("MRAID", "stopping loading and calling mraidExpand");
        if (mraidExpand == null)
        {
            mraidExpand = new Expand(context, this, adBaseView);
        }
        ((Activity)context).runOnUiThread(new _cls1(s));
    }

    public void followToOriginalUrl(String s, RedirectURLListener redirecturllistener)
    {
    /* block-local class not found */
    class getOriginalURLCallBack {}

        redirecturllistener = new GetOriginalUrlTask(new getOriginalURLCallBack(redirecturllistener));
        com.openx.core.network.BaseNetworkTask.GetUrlParams geturlparams = new com.openx.core.network.BaseNetworkTask.GetUrlParams();
        geturlparams.url = s;
        geturlparams.userAgent = OXSettings.userAgent;
        redirecturllistener.execute(new com.openx.core.network.BaseNetworkTask.GetUrlParams[] {
            geturlparams
        });
    }

    public WebViewBase getAdBaseView()
    {
        return adBaseView;
    }

    public AdCreative getCreative()
    {
        Ad ad = adBaseView.getAd();
        if (ad != null && ad.getCreatives() != null && ad.getCreatives().size() > 0)
        {
            return (AdCreative)ad.getCreatives().elementAt(0);
        } else
        {
            return null;
        }
    }

    public String getCurrentPosition()
    {
        Object obj = new JSONObject();
        try
        {
            Rect rect = new Rect();
            adBaseView.getGlobalVisibleRect(rect);
            ((JSONObject) (obj)).put("x", (int)((float)rect.left / Utils.DENSITY));
            ((JSONObject) (obj)).put("y", (int)((float)rect.top / Utils.DENSITY));
            ((JSONObject) (obj)).put("width", (int)((float)rect.right / Utils.DENSITY - (float)rect.left / Utils.DENSITY));
            ((JSONObject) (obj)).put("height", (int)((float)rect.bottom / Utils.DENSITY - (float)rect.top / Utils.DENSITY));
            obj = ((JSONObject) (obj)).toString();
        }
        catch (Exception exception)
        {
            Utils.log(this, exception.getMessage());
            return "{}";
        }
        return ((String) (obj));
    }

    public android.view.ViewGroup.LayoutParams getDefaultLayoutParams()
    {
        return mDefaultLayoutParams;
    }

    public String getDefaultPosition()
    {
        Object obj = new JSONObject();
        try
        {
            Rect rect = adBaseView.getDefaultPosition();
            ((JSONObject) (obj)).put("x", (int)((float)rect.left / Utils.DENSITY));
            ((JSONObject) (obj)).put("y", (int)((float)rect.top / Utils.DENSITY));
            ((JSONObject) (obj)).put("width", (int)((float)rect.right / Utils.DENSITY - (float)rect.left / Utils.DENSITY));
            ((JSONObject) (obj)).put("height", (int)((float)rect.bottom / Utils.DENSITY - (float)rect.top / Utils.DENSITY));
            obj = ((JSONObject) (obj)).toString();
        }
        catch (Exception exception)
        {
            Utils.log(this, exception.getMessage());
            return "{}";
        }
        return ((String) (obj));
    }

    public String getExpandProperties()
    {
        return mExpandProperties;
    }

    public void getExpandProperties(Handler handler)
    {
        callJavaScriptMethodWithResult("getExpandProperties", handler);
    }

    public void getImageWidth(int i, int j, String s)
    {
        OXLog.debug("imagesrc", (new StringBuilder()).append(i).append(" x ").append(j).append("src: ").append(s).toString());
    }

    public Close getMRAIDClose()
    {
        if (mraidClose == null)
        {
            return new Close(context, this, adBaseView);
        } else
        {
            return mraidClose;
        }
    }

    public String getMaxSize()
    {
        Object obj = new JSONObject();
        try
        {
            Rect rect = getWindowVisibleRect();
            ((JSONObject) (obj)).put("width", (int)((float)rect.width() / Utils.DENSITY));
            ((JSONObject) (obj)).put("height", (int)((float)rect.height() / Utils.DENSITY));
            obj = ((JSONObject) (obj)).toString();
        }
        catch (Exception exception)
        {
            Utils.log(this, exception.getMessage());
            return "{}";
        }
        return ((String) (obj));
    }

    public String getOrientationProperties()
    {
        return mOrientationProperties;
    }

    public void getOrientationProperties(Handler handler)
    {
        callJavaScriptMethodWithResult("getOrientationProperties", handler);
    }

    public String getPlacementType()
    {
        return null;
    }

    public void getResizeProperties(Handler handler)
    {
        callJavaScriptMethodWithResult("getResizeProperties", handler);
    }

    public PopupWindow getResizedAdWindow()
    {
        return mResizedAdWindow;
    }

    public boolean getRestoreStateOnPopupClose()
    {
        boolean flag = mRestoreState.booleanValue();
        mRestoreState = null;
        return flag;
    }

    public String getScreenSize()
    {
        Object obj = new JSONObject();
        try
        {
            DeviceInfoListener deviceinfolistener = OXMManagersResolver.getInstance().getDeviceManager();
            ((JSONObject) (obj)).put("width", (int)((float)deviceinfolistener.getScreenWidth() / Utils.DENSITY));
            ((JSONObject) (obj)).put("height", (int)((float)deviceinfolistener.getScreenHeight() / Utils.DENSITY));
            obj = ((JSONObject) (obj)).toString();
        }
        catch (Exception exception)
        {
            Utils.log(this, exception.getMessage());
            return "{}";
        }
        return ((String) (obj));
    }

    public void getState(Handler handler)
    {
        callJavaScriptMethodWithResult("getState", handler);
    }

    public String getURLForLaunching()
    {
        if (mURLForLaunching == null)
        {
            return "";
        } else
        {
            return mURLForLaunching;
        }
    }

    public Rect getWindowVisibleRect()
    {
        if ((Activity)context != null)
        {
            Rect rect = new Rect();
            ((Activity)context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            return rect;
        } else
        {
            return null;
        }
    }

    public boolean hasRestoreStateFlag()
    {
        return mRestoreState != null;
    }

    public boolean isLaunchWithURL()
    {
        return mLaunchedWithURL;
    }

    public boolean isResizedAdWindowOpened()
    {
        return getResizedAdWindow() != null;
    }

    public void isViewable(Handler handler)
    {
        callJavaScriptMethodWithResult("isViewable", handler);
    }

    public void javaScriptCallback(String s, String s1, String s2)
    {
        Handler handler = findHandler(s);
        if (handler != null)
        {
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("method", s1);
            bundle.putString("value", s2);
            message.setData(bundle);
            handler.dispatchMessage(message);
            removeHandler(s);
        }
    }

    public void onError(String s, String s1)
    {
        evaluateJavaScript(String.format("mraid.onError('%1$s', '%2$s');", new Object[] {
            s, s1
        }));
    }

    public void onOrientationPropertiesChanged(String s)
    {
    }

    public void onReady()
    {
        if (adBaseView.getDefaultPosition() == null)
        {
            adBaseView.post(new _cls2());
        }
        if (adBaseView != null)
        {
            WebViewBase webviewbase = adBaseView;
            StringBuilder stringbuilder = (new StringBuilder()).append("javascript: if (window.mraid) { mraid.onReady(); ");
            String s;
            if (disabledFlags == null)
            {
                s = "";
            } else
            {
                s = disabledFlags;
            }
            webviewbase.loadUrl(stringbuilder.append(s).append("}").toString());
        }
    }

    protected void onSizeChange(int i, int j)
    {
        evaluateJavaScript(String.format("mraid.onSizeChange(%d, %d);", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        }));
    }

    public void onStateChange(String s)
    {
        while (s == null || mCurrentState != null && mCurrentState.equals(s)) 
        {
            return;
        }
        mCurrentState = s;
        evaluateJavaScript(String.format("mraid.onStateChange('%1$s');", new Object[] {
            s
        }));
    }

    public void onViewableChange(boolean flag)
    {
        if (mCurrentViewable == null || mCurrentViewable.booleanValue() != flag)
        {
            mCurrentViewable = Boolean.valueOf(flag);
            evaluateJavaScript(String.format("mraid.onViewableChange(%1$b);", new Object[] {
                Boolean.valueOf(flag)
            }));
        }
    }

    public void open(String s)
    {
        if (mraidOpen == null)
        {
            mraidOpen = new Open(context, this, adBaseView);
        }
        mraidOpen.open(s);
    }

    public void playVideo(String s)
    {
        if (mraidPlayVideo == null)
        {
            mraidPlayVideo = new PlayVideo(context, this, adBaseView);
        }
        mraidPlayVideo.playVideo(s);
    }

    public void resize()
    {
        adBaseView.stoppedLoading();
        if (mraidResize == null)
        {
            mraidResize = new Resize(context, this, adBaseView);
        }
        mraidResize.resize();
    }

    public void setBackgroundWhite()
    {
        adBaseView.setBackgroundColor(-1);
    }

    public void setDefaultLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        mDefaultLayoutParams = layoutparams;
    }

    public void setExpandProperties(String s)
    {
        mExpandProperties = s;
    }

    public void setLaunchWithURL(boolean flag)
    {
        mLaunchedWithURL = flag;
    }

    public void setOrientationProperties(String s)
    {
        mOrientationProperties = s;
    }

    public void setResizedAdWindow(PopupWindow popupwindow)
    {
        mResizedAdWindow = popupwindow;
    }

    protected void setRestoreStateOnPopupClose(boolean flag)
    {
        mRestoreState = Boolean.valueOf(flag);
    }

    public void setURLForLaunching(String s)
    {
        mURLForLaunching = s;
    }

    public void storePicture(String s)
    {
        if (mraidStorePicture == null)
        {
            mraidStorePicture = new StorePicture(context, this, adBaseView);
        }
        mraidStorePicture.storePicture(s);
    }

    public boolean supports(String s)
    {
        boolean flag1 = true;
        if (s != null && !s.equals("")) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        if (s.equalsIgnoreCase("sms"))
        {
            return OXMManagersResolver.getInstance().getDeviceManager().hasTelephony();
        }
        if (s.equalsIgnoreCase("tel"))
        {
            return OXMManagersResolver.getInstance().getDeviceManager().hasTelephony();
        }
        flag = flag1;
        if (s.equalsIgnoreCase("calendar")) goto _L4; else goto _L3
_L3:
        if (s.equalsIgnoreCase("storePicture"))
        {
            return OXMManagersResolver.getInstance().getDeviceManager().canStorePicture();
        }
        if (!s.equalsIgnoreCase("inlineVideo") || !Utils.atLeastHoneycomb())
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (adBaseView.isHardwareAccelerated()) goto _L4; else goto _L5
_L5:
        return false;
    }




    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
