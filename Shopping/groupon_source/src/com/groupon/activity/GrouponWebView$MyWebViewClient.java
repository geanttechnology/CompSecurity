// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.InvalidDeepLinkException;
import com.groupon.service.DeepLinkManager;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponWebView, IntentFactory

private class <init> extends WebViewClient
{

    final GrouponWebView this$0;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        progressBar.setVisibility(8);
        if (android.os.ssBar >= 19)
        {
            String s1 = webview.getTitle();
            s = GrouponWebView.this;
            if (Strings.equals(s1, "about:blank"))
            {
                webview = "";
            } else
            {
                webview = webview.getTitle();
            }
            s.setActionBarTitle(webview);
        }
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        progressBar.setVisibility(0);
        super.onPageStarted(webview, s, bitmap);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        progressBar.setVisibility(8);
        webview.loadUrl("about:blank");
        GrouponWebView.access$900(GrouponWebView.this);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
label0:
        {
label1:
            {
                if (s.startsWith("groupon:login"))
                {
                    progressBar.setVisibility(0);
                    GrouponWebView.access$300(GrouponWebView.this, s);
                    GrouponWebView.access$400(GrouponWebView.this);
                    return true;
                }
                if (!GrouponWebView.access$500(GrouponWebView.this).isDeepLink(s))
                {
                    break label0;
                }
                try
                {
                    webview = GrouponWebView.access$500(GrouponWebView.this).getDeepLink(s);
                    if (!GrouponWebView.access$600(GrouponWebView.this).isDirectlyFollowable(webview))
                    {
                        break label1;
                    }
                    GrouponWebView.access$600(GrouponWebView.this).followDeepLink(GrouponWebView.this, webview);
                }
                // Misplaced declaration of an exception variable
                catch (WebView webview)
                {
                    return false;
                }
                return true;
            }
            return false;
        }
        if (s.startsWith("groupon:show_close_button"))
        {
            GrouponWebView.access$702(GrouponWebView.this, true);
            return true;
        }
        if (s.startsWith("groupon:show_start_shopping_button"))
        {
            GrouponWebView.access$702(GrouponWebView.this, true);
            return true;
        }
        if (s.startsWith("groupon:start_shopping"))
        {
            startActivity(GrouponWebView.access$800(GrouponWebView.this).newCarouselIntent());
            return true;
        } else
        {
            return false;
        }
    }

    private _cls9()
    {
        this$0 = GrouponWebView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
