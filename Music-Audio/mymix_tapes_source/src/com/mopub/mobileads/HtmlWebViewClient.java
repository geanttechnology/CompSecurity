// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import java.util.EnumSet;

// Referenced classes of package com.mopub.mobileads:
//            BaseHtmlWebView, HtmlWebViewListener, MoPubErrorCode

class HtmlWebViewClient extends WebViewClient
{

    static final String MOPUB_FAIL_LOAD = "mopub://failLoad";
    static final String MOPUB_FINISH_LOAD = "mopub://finishLoad";
    private final EnumSet SUPPORTED_URL_ACTIONS;
    private final String mClickthroughUrl;
    private final Context mContext;
    private BaseHtmlWebView mHtmlWebView;
    private HtmlWebViewListener mHtmlWebViewListener;
    private final String mRedirectUrl;

    HtmlWebViewClient(HtmlWebViewListener htmlwebviewlistener, BaseHtmlWebView basehtmlwebview, String s, String s1)
    {
        SUPPORTED_URL_ACTIONS = EnumSet.of(UrlAction.HANDLE_MOPUB_SCHEME, new UrlAction[] {
            UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.HANDLE_PHONE_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK
        });
        mHtmlWebViewListener = htmlwebviewlistener;
        mHtmlWebView = basehtmlwebview;
        mClickthroughUrl = s;
        mRedirectUrl = s1;
        mContext = basehtmlwebview.getContext();
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        if (mRedirectUrl == null || !s.startsWith(mRedirectUrl))
        {
            break MISSING_BLOCK_LABEL_43;
        }
        webview.stopLoading();
        if (!mHtmlWebView.wasClicked())
        {
            break MISSING_BLOCK_LABEL_53;
        }
        Intents.showMoPubBrowserForUrl(mContext, Uri.parse(s));
        return;
        webview;
        MoPubLog.d(webview.getMessage());
        return;
        MoPubLog.d("Attempted to redirect without user interaction");
        return;
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        (new com.mopub.common.UrlHandler.Builder()).withSupportedUrlActions(SUPPORTED_URL_ACTIONS).withResultActions(new com.mopub.common.UrlHandler.ResultActions() {

            final HtmlWebViewClient this$0;

            public void urlHandlingFailed(String s1, UrlAction urlaction)
            {
            }

            public void urlHandlingSucceeded(String s1, UrlAction urlaction)
            {
                if (mHtmlWebView.wasClicked())
                {
                    mHtmlWebViewListener.onClicked();
                    mHtmlWebView.onResetUserClick();
                }
            }

            
            {
                this$0 = HtmlWebViewClient.this;
                super();
            }
        }).withMoPubSchemeListener(new com.mopub.common.UrlHandler.MoPubSchemeListener() {

            final HtmlWebViewClient this$0;

            public void onClose()
            {
                mHtmlWebViewListener.onCollapsed();
            }

            public void onFailLoad()
            {
                mHtmlWebViewListener.onFailed(MoPubErrorCode.UNSPECIFIED);
            }

            public void onFinishLoad()
            {
                mHtmlWebViewListener.onLoaded(mHtmlWebView);
            }

            
            {
                this$0 = HtmlWebViewClient.this;
                super();
            }
        }).build().handleUrl(mContext, s, mHtmlWebView.wasClicked());
        return true;
    }


}
