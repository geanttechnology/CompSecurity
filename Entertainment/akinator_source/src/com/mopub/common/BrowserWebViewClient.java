// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Drawables;
import java.util.EnumSet;

// Referenced classes of package com.mopub.common:
//            UrlAction, MoPubBrowser, UrlHandler

class BrowserWebViewClient extends WebViewClient
{

    private static final EnumSet SUPPORTED_URL_ACTIONS;
    private MoPubBrowser mMoPubBrowser;

    public BrowserWebViewClient(MoPubBrowser mopubbrowser)
    {
        mMoPubBrowser = mopubbrowser;
    }

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        if (webview.canGoBack())
        {
            s = Drawables.LEFT_ARROW.createDrawable(mMoPubBrowser);
        } else
        {
            s = Drawables.UNLEFT_ARROW.createDrawable(mMoPubBrowser);
        }
        mMoPubBrowser.getBackButton().setImageDrawable(s);
        if (webview.canGoForward())
        {
            webview = Drawables.RIGHT_ARROW.createDrawable(mMoPubBrowser);
        } else
        {
            webview = Drawables.UNRIGHT_ARROW.createDrawable(mMoPubBrowser);
        }
        mMoPubBrowser.getForwardButton().setImageDrawable(webview);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
        mMoPubBrowser.getForwardButton().setImageDrawable(Drawables.UNRIGHT_ARROW.createDrawable(mMoPubBrowser));
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        MoPubLog.d((new StringBuilder()).append("MoPubBrowser error: ").append(s).toString());
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        } else
        {
            return (new UrlHandler.Builder()).withSupportedUrlActions(SUPPORTED_URL_ACTIONS).withoutMoPubBrowser().withResultActions(new UrlHandler.ResultActions() {

                final BrowserWebViewClient this$0;

                public void urlHandlingFailed(String s1, UrlAction urlaction)
                {
                }

                public void urlHandlingSucceeded(String s1, UrlAction urlaction)
                {
                    if (urlaction.equals(UrlAction.OPEN_IN_APP_BROWSER))
                    {
                        mMoPubBrowser.getWebView().loadUrl(s1);
                        return;
                    } else
                    {
                        mMoPubBrowser.finish();
                        return;
                    }
                }

            
            {
                this$0 = BrowserWebViewClient.this;
                super();
            }
            }).build().handleResolvedUrl(mMoPubBrowser.getApplicationContext(), s, true, null);
        }
    }

    static 
    {
        SUPPORTED_URL_ACTIONS = EnumSet.of(UrlAction.HANDLE_PHONE_SCHEME, new UrlAction[] {
            UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK
        });
    }

}
