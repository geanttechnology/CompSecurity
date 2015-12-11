// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.amazon.mShop.crash.WebViewLogger;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.mash.api.MShopMASHPluginManager;
import com.amazon.mShop.mash.context.MShopAppContext;
import com.amazon.mShop.mash.context.MShopCapabilityManager;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.payment.alipay.AlipayDelegate;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.BuildUtils;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.util.WebUtils;
import com.amazon.mobile.mash.MASHWebView;
import com.amazon.mobile.mash.appcontext.AppContextCookie;
import com.amazon.mobile.mash.util.MASHUtil;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginManager;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewContainer, MShopWebActivity, MShopWebViewJavaScriptClient

public class MShopWebView extends MASHWebView
{

    protected static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private boolean mIsInitialPageLoad;
    private boolean mIsReceivedError;
    private boolean mIsWebViewDestroyed;
    private Map mMappingWebViewAndJS;
    private String mParamtersToJS;
    private MShopWebViewContainer mWebViewContainer;
    private int prevContentHeight;

    public MShopWebView(Context context)
    {
        super(new MShopAppContext(new MShopCapabilityManager(context)), context);
        prevContentHeight = -1;
        mParamtersToJS = "";
        initialize();
    }

    private void callNavigate(String s, boolean flag, boolean flag1)
    {
        if (mWebViewContainer == null)
        {
            return;
        } else
        {
            mWebViewContainer.navigate(s, flag, flag1);
            return;
        }
    }

    private void callNavigateBackward(String s, String s1)
    {
        if (mWebViewContainer == null)
        {
            return;
        }
        if (WebUtils.isBaseUrlEqual(s, s1))
        {
            mWebViewContainer.navigateBackward(null);
            return;
        } else
        {
            mWebViewContainer.navigateBackward(s);
            return;
        }
    }

    private void callNavigateForward(String s)
    {
        if (mWebViewContainer == null)
        {
            return;
        } else
        {
            mWebViewContainer.navigateForward(s);
            return;
        }
    }

    private static String getDatabasePath()
    {
        Object obj = AndroidPlatform.getInstance().getApplicationContext();
        if (obj != null)
        {
            obj = ((Context) (obj)).getDir("database", 0);
            if (obj != null)
            {
                return ((File) (obj)).getPath();
            }
        }
        Log.e("MShopWebView", "Cannot get database path.");
        return null;
    }

    private void initialize()
    {
        requestFocus(130);
        setOnTouchListener(new android.view.View.OnTouchListener() {

            final MShopWebView this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                motionevent.getAction();
                JVM INSTR tableswitch 0 1: default 28
            //                           0 30
            //                           1 30;
                   goto _L1 _L2 _L2
_L1:
                return false;
_L2:
                if (!view.hasFocus())
                {
                    view.requestFocus();
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                this$0 = MShopWebView.this;
                super();
            }
        });
        initializeGlobalWebSettings(this);
        initializeWebViewCookies(getContext());
        mMappingWebViewAndJS = new HashMap();
        setVerticalScrollBarEnabled(true);
    }

    public static void initializeGlobalWebSettings(WebView webview)
    {
        WebSettings websettings = webview.getSettings();
        websettings.setJavaScriptEnabled(true);
        websettings.setUserAgentString(AndroidPlatform.getInstance().getUserAgent());
        websettings.setSavePassword(false);
        websettings.setSaveFormData(false);
        String s = getDatabasePath();
        if (!Util.isEmpty(s))
        {
            websettings.setDatabaseEnabled(true);
            websettings.setDatabasePath(s);
            websettings.setDomStorageEnabled(true);
        }
        websettings.setCacheMode(0);
        webview = webview.getContext().getCacheDir();
        if (webview != null)
        {
            websettings.setAppCachePath(webview.getAbsolutePath());
        }
        websettings.setAppCacheEnabled(true);
        websettings.setNeedInitialFocus(false);
        websettings.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    }

    private void initializeWebViewCookies(Context context)
    {
        Object obj = (new StringBuilder()).append("dpi:").append(Float.toString(UIUtils.getDeviceLogicalDPI(context))).append("|").append("w:").append(Integer.toString(UIUtils.getPortraitWidth(context))).append("|").append("h:").append(Integer.toString(UIUtils.getPortraitHeight(context))).toString();
        String s1 = (new StringBuilder()).append(AndroidPlatform.getInstance().getApplicationName()).append("/").append(AndroidPlatform.getInstance().getApplicationVersion()).append("/").append(BuildUtils.getRevisionNumber(context)).toString();
        String s = CookieBridge.getCookieDomain(context, true);
        CookieManager.getInstance().setCookie((new StringBuilder()).append("www").append(s).toString(), (new StringBuilder()).append("mobile-device-info=").append(((String) (obj))).append("; Domain=").append(s).toString());
        CookieManager.getInstance().setCookie((new StringBuilder()).append("www").append(s).toString(), (new StringBuilder()).append("amzn-app-id=").append(s1).append("; Domain=").append(s).toString());
        obj = new AppContextCookie(getAppContext());
        CookieManager.getInstance().setCookie((new StringBuilder()).append("www").append(s).toString(), (new StringBuilder()).append("amzn-app-ctxt=").append(((AppContextCookie) (obj)).getCookieValue(context)).append("; Domain=").append(s).toString());
        com.amazon.mShop.payment.alipay.AlipayDelegate.Factory.getInstance().setCookie(context, s);
    }

    public boolean canGoBack()
    {
        String s = getUrl();
        if (s != null && !s.contains("app-nav-type=none"))
        {
            return super.canGoBack();
        }
        return MASHUtil.getTargetForAppNavTypeNone(copyBackForwardList()) >= 0;
    }

    public void clearAllPendingJs()
    {
        mMappingWebViewAndJS.clear();
    }

    public void clearHistory()
    {
        if (!isDestroyed())
        {
            super.clearHistory();
        }
    }

    public PluginManager createPluginManager(List list)
    {
        return new MShopMASHPluginManager(this, (CordovaInterface)getContext(), list);
    }

    public void destroy()
    {
        if (mIsWebViewDestroyed)
        {
            return;
        } else
        {
            mIsWebViewDestroyed = true;
            super.destroy();
            return;
        }
    }

    void exposeJavaScriptClient(MShopWebViewJavaScriptClient mshopwebviewjavascriptclient)
    {
        if (isInEmbeddedBrowserMode())
        {
            if (DEBUG)
            {
                Log.i("MShopWebView", "Don't expose 'webclient' in Embedded Browser Mode");
            }
            return;
        } else
        {
            addJavascriptInterface(mshopwebviewjavascriptclient, "webclient");
            return;
        }
    }

    public String getJsNeedToCall(String s)
    {
        return (String)mMappingWebViewAndJS.get(s.trim());
    }

    public String getParamtersToJS()
    {
        return mParamtersToJS;
    }

    public String getTitle()
    {
        if (isReceivedError())
        {
            return null;
        } else
        {
            return super.getTitle();
        }
    }

    public void goBack()
    {
        mIsInitialPageLoad = true;
        if (getContext() instanceof MShopWebActivity)
        {
            ((MShopWebActivity)getContext()).calcWebviewStartTime();
        }
        String s = getUrl();
        WebBackForwardList webbackforwardlist = copyBackForwardList();
        int j = webbackforwardlist.getCurrentIndex();
        if (j <= 0)
        {
            Log.e("MShopWebView", "goBack() is called when only one item in web history, there should be something wrong.");
        } else
        {
            int i;
            if (s.contains("app-nav-type=none"))
            {
                i = MASHUtil.getTargetForAppNavTypeNone(webbackforwardlist);
                callNavigateBackward(s, webbackforwardlist.getItemAtIndex(i).getUrl());
                super.goBackOrForward(i - j);
            } else
            {
                i = j - 1;
                callNavigateBackward(s, webbackforwardlist.getItemAtIndex(i).getUrl());
                super.goBack();
            }
            clearAllPendingJs();
            s = (new StringBuilder()).append("javascript:try{app.willReappear(").append(getParamtersToJS()).append(");}catch(e){}").toString();
            setParamtersToJS("");
            putJsNeedToCall(webbackforwardlist.getItemAtIndex(i).getUrl().trim(), s);
            if (DEBUG)
            {
                Log.i("MShopWebView", (new StringBuilder()).append("goBack, put js to be called : ").append(s).toString());
                return;
            }
        }
    }

    public boolean isDestroyed()
    {
        return mIsWebViewDestroyed;
    }

    boolean isInitialPageLoad()
    {
        return mIsInitialPageLoad;
    }

    boolean isReceivedError()
    {
        return mIsReceivedError;
    }

    public void loadData(String s, String s1, String s2)
    {
        if (mIsWebViewDestroyed)
        {
            Log.w("MShopWebView", "Call WebView.loadData() after WebView is destroyed.");
            return;
        } else
        {
            super.loadData(s, s1, s2);
            return;
        }
    }

    public void loadUrl(String s)
    {
        if (mIsWebViewDestroyed)
        {
            Log.w("MShopWebView", "Call WebView.loadUrl() after WebView is destroyed.");
        } else
        if (!Util.isEmpty(s))
        {
            if (s.startsWith("http"))
            {
                WebViewLogger.logURL(s);
                mIsInitialPageLoad = true;
            }
            if (DEBUG)
            {
                WebUtils.initializeCookiesForDevoHost(s, CookieBridge.getCookieDomain(getContext(), true));
            }
            setReceivedError(false);
            callNavigateForward(s);
            super.loadUrl(s);
            return;
        }
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (ActivityUtils.isSpinnerV2Enabled())
        {
            int i = getContentHeight();
            if (prevContentHeight != i)
            {
                prevContentHeight = i;
                if (i > 0)
                {
                    mWebViewContainer.webviewContentHeightChanged();
                }
            }
        }
        if (DEBUG)
        {
            StringBuilder stringbuilder;
            boolean flag;
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                flag = canvas.isHardwareAccelerated();
            } else
            {
                flag = false;
            }
            stringbuilder = (new StringBuilder()).append("webview hardware acceleration is ");
            if (flag)
            {
                canvas = "on";
            } else
            {
                canvas = "off";
            }
            Log.d("MShopWebView", stringbuilder.append(canvas).toString());
        }
    }

    public void postUrl(String s, byte abyte0[])
    {
        if (mIsWebViewDestroyed)
        {
            Log.w("MShopWebView", "Call WebView.postUrl() after WebView is destroyed.");
            return;
        }
        if (DEBUG)
        {
            Log.i("MShopWebView", (new StringBuilder()).append("postUrl >>> ").append(s).toString());
            WebUtils.initializeCookiesForDevoHost(s, CookieBridge.getCookieDomain(getContext(), true));
        }
        callNavigateForward(s);
        super.postUrl(s, abyte0);
    }

    public void putJsNeedToCall(String s, String s1)
    {
        mMappingWebViewAndJS.put(s, s1);
    }

    public void reload()
    {
        mIsInitialPageLoad = true;
        mIsReceivedError = false;
        if (getContext() instanceof MShopWebActivity)
        {
            ((MShopWebActivity)getContext()).calcWebviewStartTime();
        }
        callNavigate(getUrl(), true, true);
        super.reload();
    }

    void setInitialPageLoad(boolean flag)
    {
        mIsInitialPageLoad = flag;
    }

    public void setNetworkAvailable(boolean flag)
    {
        if (mIsWebViewDestroyed)
        {
            return;
        } else
        {
            super.setNetworkAvailable(flag);
            return;
        }
    }

    public void setParamtersToJS(String s)
    {
        mParamtersToJS = s;
    }

    void setReceivedError(boolean flag)
    {
        mIsReceivedError = flag;
    }

    void setWebViewContainer(MShopWebViewContainer mshopwebviewcontainer)
    {
        mWebViewContainer = mshopwebviewcontainer;
    }

}
