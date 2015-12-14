// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.utils.Utility;

// Referenced classes of package com.sina.weibo.sdk.component:
//            WeiboWebViewClient, ShareRequestParam, BrowserRequestCallBack, WeiboSdkBrowser

class ShareWeiboWebViewClient extends WeiboWebViewClient
{

    private static final String RESP_PARAM_CODE = "code";
    private static final String RESP_PARAM_MSG = "msg";
    private static final String RESP_SUCC_CODE = "0";
    private Activity mAct;
    private WeiboAuthListener mListener;
    private ShareRequestParam mShareRequestParam;

    public ShareWeiboWebViewClient(Activity activity, ShareRequestParam sharerequestparam)
    {
        mAct = activity;
        mShareRequestParam = sharerequestparam;
        mListener = sharerequestparam.getAuthListener();
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
        mShareRequestParam.sendSdkErrorResponse(mAct, s);
        WeiboSdkBrowser.closeBrowser(mAct, mShareRequestParam.getAuthListenerKey(), null);
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        if (mCallBack != null)
        {
            mCallBack.onReceivedSslErrorCallBack(webview, sslerrorhandler, sslerror);
        }
        sslerrorhandler.cancel();
        mShareRequestParam.sendSdkErrorResponse(mAct, "ReceivedSslError");
        WeiboSdkBrowser.closeBrowser(mAct, mShareRequestParam.getAuthListenerKey(), null);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (mCallBack != null)
        {
            mCallBack.shouldOverrideUrlLoadingCallBack(webview, s);
        }
        if (s.startsWith("sinaweibo://browser/close"))
        {
            s = Utility.parseUri(s);
            if (!s.isEmpty() && mListener != null)
            {
                mListener.onComplete(s);
            }
            webview = s.getString("code");
            s = s.getString("msg");
            if (TextUtils.isEmpty(webview))
            {
                mShareRequestParam.sendSdkCancleResponse(mAct);
            } else
            if (!"0".equals(webview))
            {
                mShareRequestParam.sendSdkErrorResponse(mAct, s);
            } else
            {
                mShareRequestParam.sendSdkOkResponse(mAct);
            }
            WeiboSdkBrowser.closeBrowser(mAct, mShareRequestParam.getAuthListenerKey(), null);
            return true;
        } else
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }
    }
}
