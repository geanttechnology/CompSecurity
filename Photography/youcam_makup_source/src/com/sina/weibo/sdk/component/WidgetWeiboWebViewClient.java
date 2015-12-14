// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.utils.Utility;

// Referenced classes of package com.sina.weibo.sdk.component:
//            WeiboWebViewClient, WidgetRequestParam, BrowserRequestCallBack, WeiboSdkBrowser

class WidgetWeiboWebViewClient extends WeiboWebViewClient
{

    private Activity mAct;
    private WeiboAuthListener mListener;
    private WidgetRequestParam.WidgetRequestCallback mWidgetCallback;
    private WidgetRequestParam mWidgetRequestParam;

    public WidgetWeiboWebViewClient(Activity activity, WidgetRequestParam widgetrequestparam)
    {
        mAct = activity;
        mWidgetRequestParam = widgetrequestparam;
        mWidgetCallback = widgetrequestparam.getWidgetRequestCallback();
        mListener = widgetrequestparam.getAuthListener();
    }

    public void onPageFinished(WebView webview, String s)
    {
        if (mCallBack != null)
        {
            mCallBack.onPageFinishedCallBack(webview, s);
        }
        super.onPageFinished(webview, s);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        if (mCallBack != null)
        {
            mCallBack.onPageStartedCallBack(webview, s, bitmap);
        }
        super.onPageStarted(webview, s, bitmap);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        if (mCallBack != null)
        {
            mCallBack.onReceivedErrorCallBack(webview, i, s, s1);
        }
        super.onReceivedError(webview, i, s, s1);
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        if (mCallBack != null)
        {
            mCallBack.onReceivedSslErrorCallBack(webview, sslerrorhandler, sslerror);
        }
        super.onReceivedSslError(webview, sslerrorhandler, sslerror);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (mCallBack != null)
        {
            mCallBack.shouldOverrideUrlLoadingCallBack(webview, s);
        }
        boolean flag = s.startsWith("sinaweibo://browser/close");
        if (s.startsWith("sinaweibo://browser/close") || s.startsWith("sinaweibo://browser/datatransfer"))
        {
            webview = Utility.parseUri(s);
            if (!webview.isEmpty() && mListener != null)
            {
                mListener.onComplete(webview);
            }
            if (mWidgetCallback != null)
            {
                mWidgetCallback.onWebViewResult(s);
            }
            if (flag)
            {
                WeiboSdkBrowser.closeBrowser(mAct, mWidgetRequestParam.getAuthListenerKey(), mWidgetRequestParam.getWidgetRequestCallbackKey());
            }
            return true;
        } else
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }
    }
}
