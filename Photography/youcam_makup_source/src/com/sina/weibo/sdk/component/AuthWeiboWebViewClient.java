// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.sina.weibo.sdk.utils.Utility;

// Referenced classes of package com.sina.weibo.sdk.component:
//            WeiboWebViewClient, AuthRequestParam, BrowserRequestCallBack, WeiboSdkBrowser

class AuthWeiboWebViewClient extends WeiboWebViewClient
{

    private boolean isCallBacked;
    private Activity mAct;
    private AuthRequestParam mAuthRequestParam;
    private WeiboAuthListener mListener;

    public AuthWeiboWebViewClient(Activity activity, AuthRequestParam authrequestparam)
    {
        isCallBacked = false;
        mAct = activity;
        mAuthRequestParam = authrequestparam;
        mListener = mAuthRequestParam.getAuthListener();
    }

    private void handleRedirectUrl(String s)
    {
        s = Utility.parseUrl(s);
        String s1 = s.getString("error");
        String s2 = s.getString("error_code");
        String s3 = s.getString("error_description");
        if (s1 == null && s2 == null)
        {
            if (mListener != null)
            {
                mListener.onComplete(s);
            }
        } else
        if (mListener != null)
        {
            mListener.onWeiboException(new WeiboAuthException(s2, s1, s3));
            return;
        }
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
        if (s.startsWith(mAuthRequestParam.getAuthInfo().getRedirectUrl()) && !isCallBacked)
        {
            isCallBacked = true;
            handleRedirectUrl(s);
            webview.stopLoading();
            WeiboSdkBrowser.closeBrowser(mAct, mAuthRequestParam.getAuthListenerKey(), null);
            return;
        } else
        {
            super.onPageStarted(webview, s, bitmap);
            return;
        }
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
        if (s.startsWith("sms:"))
        {
            webview = new Intent("android.intent.action.VIEW");
            webview.putExtra("address", s.replace("sms:", ""));
            webview.setType("vnd.android-dir/mms-sms");
            mAct.startActivity(webview);
            return true;
        }
        if (s.startsWith("sinaweibo://browser/close"))
        {
            if (mListener != null)
            {
                mListener.onCancel();
            }
            WeiboSdkBrowser.closeBrowser(mAct, mAuthRequestParam.getAuthListenerKey(), null);
            return true;
        } else
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }
    }
}
