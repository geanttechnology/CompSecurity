// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.web;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.amazon.mobile.mash.MASHWebView;
import com.amazon.mobile.mash.appcontext.AppContextCookie;
import com.amazon.now.AmazonActivity;
import com.amazon.now.map.MapWebActivity;
import com.amazon.now.mash.context.NowAppContext;
import com.amazon.now.mash.context.NowCapabilityManager;
import com.amazon.now.platform.AndroidPlatform;
import com.amazon.now.util.AppUtils;
import java.io.File;
import org.apache.cordova.PluginManager;

public class NowWebView extends MASHWebView
{

    private boolean mIsWebViewDestroyed;

    public NowWebView(Activity activity)
    {
        this(new NowAppContext(new NowCapabilityManager(activity)), activity);
    }

    public NowWebView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mIsWebViewDestroyed = false;
        setAppContext(new NowAppContext(new NowCapabilityManager(context)));
        initWebView(context);
    }

    public NowWebView(NowAppContext nowappcontext, Activity activity)
    {
        super(nowappcontext, activity);
        mIsWebViewDestroyed = false;
        initWebView(activity);
    }

    private void initWebView(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setWebContentsDebuggingEnabled(AppUtils.isAppDebuggable(context));
        }
        initializeGlobalWebSettings(this);
        initializeWebViewCookies(context);
        disableLongClick();
    }

    public static void initializeGlobalWebSettings(WebView webview)
    {
        WebSettings websettings = webview.getSettings();
        websettings.setJavaScriptEnabled(true);
        websettings.setUserAgentString(AndroidPlatform.getInstance().getUserAgent());
        websettings.setSavePassword(false);
        websettings.setSaveFormData(false);
        websettings.setCacheMode(0);
        webview = webview.getContext().getCacheDir();
        if (webview != null)
        {
            websettings.setAppCachePath(webview.getAbsolutePath());
        }
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            websettings.setMixedContentMode(0);
        }
        websettings.setAppCacheEnabled(true);
        websettings.setNeedInitialFocus(false);
        websettings.setBuiltInZoomControls(true);
        websettings.setDisplayZoomControls(false);
        websettings.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    }

    private void initializeWebViewCookies(Context context)
    {
        Object obj = AppUtils.getDisplaySize(context);
        Object obj1 = (new StringBuilder()).append("dpi:").append(AppUtils.getDeviceLogicalDPI(context)).append("|").append("w:").append(((Point) (obj)).x).append("|").append("h:").append(((Point) (obj)).y).toString();
        String s = (new StringBuilder()).append(AndroidPlatform.getInstance().getApplicationName()).append("/").append(AndroidPlatform.getInstance().getApplicationVersion()).append("/").append(AndroidPlatform.getInstance().getApplicationVersion()).toString();
        obj = AppUtils.getServiceDomain();
        CookieManager.getInstance().setCookie(((String) (obj)), (new StringBuilder()).append("mobile-device-info=").append(((String) (obj1))).append("; Domain=").append(((String) (obj))).toString());
        CookieManager.getInstance().setCookie(((String) (obj)), (new StringBuilder()).append("amzn-app-id=").append(s).append("; Domain=").append(((String) (obj))).toString());
        obj1 = new AppContextCookie(getAppContext());
        CookieManager.getInstance().setCookie(((String) (obj)), (new StringBuilder()).append("amzn-app-ctxt=").append(((AppContextCookie) (obj1)).getCookieValue(context)).append("; Domain=").append(((String) (obj))).toString());
    }

    public void destroy()
    {
        if (getContext() instanceof AmazonActivity)
        {
            ((AmazonActivity)getContext()).hideSpinner();
        }
        super.destroy();
        mIsWebViewDestroyed = true;
    }

    public void disableLongClick()
    {
        setLongClickable(false);
        setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final NowWebView this$0;

            public boolean onLongClick(View view)
            {
                return true;
            }

            
            {
                this$0 = NowWebView.this;
                super();
            }
        });
    }

    public void enableLongClick()
    {
        setLongClickable(true);
        setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final NowWebView this$0;

            public boolean onLongClick(View view)
            {
                return false;
            }

            
            {
                this$0 = NowWebView.this;
                super();
            }
        });
    }

    public void loadUrl(String s)
    {
        if (mIsWebViewDestroyed)
        {
            Log.w("CordovaWebView", "Call WebView.loadUrl() after WebView is destroyed.");
            return;
        } else
        {
            super.loadUrl(s);
            return;
        }
    }

    public void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (getContext() instanceof MapWebActivity)
        {
            ((MapWebActivity)getContext()).pan();
        }
    }

    public void postUrl(String s, byte abyte0[])
    {
        if (mIsWebViewDestroyed)
        {
            Log.w("CordovaWebView", "Call WebView.postUrl() after WebView is destroyed.");
            return;
        } else
        {
            pluginManager.init();
            super.postUrl(s, abyte0);
            return;
        }
    }
}
