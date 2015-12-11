// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.graphics.Bitmap;
import android.text.Html;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.groupon.util.WebViewHelper;
import com.groupon.view.WobbleSpaceshipCatView;

// Referenced classes of package com.groupon.activity:
//            ThirdPartyLinkoutDealWebViewActivity

public class ViewClient extends ViewClient
{

    final ThirdPartyLinkoutDealWebViewActivity this$0;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        if (wobbleSpaceshipCatView.getVisibility() == 0)
        {
            wobbleSpaceshipCatView.stopProgressAnimation();
            isWobbleSpaceshipCatInProgress = false;
        }
        loadingCat.setVisibility(8);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
        if (hasSeenWobbleSpaceshipCat && !isWobbleSpaceshipCatInProgress)
        {
            progressBar.setVisibility(0);
            return;
        } else
        {
            isWobbleSpaceshipCatInProgress = true;
            hasSeenWobbleSpaceshipCat = true;
            progressBar.setVisibility(8);
            ThirdPartyLinkoutDealWebViewActivity.access$100(ThirdPartyLinkoutDealWebViewActivity.this, getString(0x7f080250, new Object[] {
                ThirdPartyLinkoutDealWebViewActivity.access$000(ThirdPartyLinkoutDealWebViewActivity.this)
            }), Html.fromHtml(getString(0x7f08024f, new Object[] {
                ThirdPartyLinkoutDealWebViewActivity.access$000(ThirdPartyLinkoutDealWebViewActivity.this)
            })));
            return;
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        if (wobbleSpaceshipCatView.getVisibility() == 0)
        {
            wobbleSpaceshipCatView.stopProgressAnimation();
            isWobbleSpaceshipCatInProgress = false;
        }
        loadingCat.setVisibility(8);
    }

    public ViewClient(WebViewHelper webviewhelper)
    {
        this$0 = ThirdPartyLinkoutDealWebViewActivity.this;
        super(ThirdPartyLinkoutDealWebViewActivity.this, webviewhelper);
    }
}
