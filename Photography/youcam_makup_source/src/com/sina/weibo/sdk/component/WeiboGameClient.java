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
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.sina.weibo.sdk.utils.Utility;

// Referenced classes of package com.sina.weibo.sdk.component:
//            WeiboWebViewClient, GameRequestParam, BrowserRequestCallBack, WeiboSdkBrowser

class WeiboGameClient extends WeiboWebViewClient
{

    private Activity mAct;
    private GameRequestParam mGameRequestParam;
    private WeiboAuthListener mListener;

    public WeiboGameClient(Activity activity, GameRequestParam gamerequestparam)
    {
        mAct = activity;
        mGameRequestParam = gamerequestparam;
        mListener = mGameRequestParam.getAuthListener();
    }

    private void handleRedirectUrl(String s)
    {
        Bundle bundle = Utility.parseUrl(s);
        String s1;
        String s2;
        if (bundle.getString("error") == null)
        {
            s = "";
        } else
        {
            s = bundle.getString("error");
        }
        s1 = bundle.getString("code");
        s2 = bundle.getString("msg");
        if (s == null && s1 == null)
        {
            if (mListener != null)
            {
                mListener.onComplete(bundle);
            }
        } else
        if (mListener != null)
        {
            mListener.onWeiboException(new WeiboAuthException(s1, s, s2));
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
        if (s.startsWith("sinaweibo://browser/close"))
        {
            webview = Utility.parseUri(s);
            if (!webview.isEmpty() && mListener != null)
            {
                mListener.onComplete(webview);
            }
            WeiboSdkBrowser.closeBrowser(mAct, mGameRequestParam.getAuthListenerKey(), null);
            return true;
        } else
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }
    }
}
