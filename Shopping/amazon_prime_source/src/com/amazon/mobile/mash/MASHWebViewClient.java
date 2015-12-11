// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash;

import android.net.Uri;
import android.util.Log;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import com.amazon.mobile.mash.interception.MASHUrlIntercepter;
import com.amazon.mobile.mash.interception.UrlInterceptionHandler;
import com.amazon.mobile.mash.nav.MASHNavDelegate;
import com.amazon.mobile.mash.nav.MASHNavUtils;
import com.amazon.mobile.mash.nav.MASHWebBackForwardList;
import com.amazon.mobile.mash.nav.MASHWebHistoryItem;
import com.amazon.mobile.mash.util.MASHDebug;
import com.amazon.mobile.mash.util.MASHUtil;
import com.amazon.mobile.mash.util.Util;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebViewClient;

// Referenced classes of package com.amazon.mobile.mash:
//            MASHWebView

public class MASHWebViewClient extends CordovaWebViewClient
{

    private MASHNavDelegate mNavDelegate;
    private MASHUrlIntercepter mUrlIntercepter;

    public MASHWebViewClient(CordovaInterface cordovainterface, MASHWebView mashwebview, MASHNavDelegate mashnavdelegate, MASHUrlIntercepter mashurlintercepter)
    {
        super(cordovainterface, mashwebview);
        mNavDelegate = mashnavdelegate;
        mUrlIntercepter = mashurlintercepter;
    }

    public MASHWebViewClient(CordovaInterface cordovainterface, MASHNavDelegate mashnavdelegate, MASHUrlIntercepter mashurlintercepter)
    {
        super(cordovainterface);
        mNavDelegate = mashnavdelegate;
        mUrlIntercepter = mashurlintercepter;
    }

    public void doUpdateVisitedHistory(WebView webview, String s, boolean flag)
    {
        s = new MASHWebHistoryItem(s, null);
        ((MASHWebView)webview).getMASHWebBackForwardList().addHistoryItem(s);
    }

    public MASHNavDelegate getMASHNavDelegate()
    {
        return mNavDelegate;
    }

    protected boolean handlePageLoadNatively(MASHWebView mashwebview, String s)
    {
        if (MASHDebug.isEnabled())
        {
            Log.i("MASHWebViewClient", (new StringBuilder()).append("handlePageLoad: url = ").append(s).toString());
        }
        if (!mashwebview.isInEmbeddedBrowserMode())
        {
            if (mNavDelegate != null && mNavDelegate.navigate(s, mashwebview.getContext()))
            {
                return true;
            }
            if (MASHUrlIntercepter.shouldInterceptUrl())
            {
                return interceptUrl(mashwebview, s);
            }
        }
        return false;
    }

    public boolean interceptUrl(WebView webview, String s)
    {
        if (MASHDebug.isEnabled())
        {
            Log.i("MASHWebViewClient", (new StringBuilder()).append("WebViewClient:interceptUrl = ").append(s).toString());
        }
        if (mUrlIntercepter != null && Uri.parse(s).isHierarchical() && Util.isUrlFromAmazon(s))
        {
            if ((webview = mUrlIntercepter.buildHandler(s, webview.getContext())) != null)
            {
                return webview.handle();
            }
        }
        return false;
    }

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        MASHWebView mashwebview = (MASHWebView)webview;
        if (MASHUtil.isFragmentUrl(s))
        {
            webview = new MASHWebHistoryItem(s, null);
            mashwebview.getMASHWebBackForwardList().addHistoryItem(webview);
        } else
        {
            webview = webview.copyBackForwardList();
            mashwebview.getMASHWebBackForwardList().setCurrentIndex(webview.getCurrentIndex());
        }
        if (mashwebview.getPendingNavRequest() != null)
        {
            MASHNavUtils.issuePageRequest(mashwebview, mashwebview.getPendingNavRequest());
            mashwebview.setPendingNavRequest(null);
        }
        mashwebview.setShouldHideProgressIndicator(true);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (handlePageLoadNatively((MASHWebView)webview, s))
        {
            return true;
        }
        return super.shouldOverrideUrlLoading(webview, s);
    }
}
