// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.groupon.util.WebViewHelper;
import com.groupon.view.WobbleSpaceshipCatView;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            AbstractThirdPartyDealWebViewActivity, IntentFactory

public class ThirdPartyLinkoutDealWebViewActivity extends AbstractThirdPartyDealWebViewActivity
{
    public class LinkoutDealWebViewClient extends AbstractThirdPartyDealWebViewActivity.GeneralThirdPartyDealWebViewClient
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
                loopLoadingAnimation(getString(0x7f080250, new Object[] {
                    externalDealProviderName
                }), Html.fromHtml(getString(0x7f08024f, new Object[] {
                    externalDealProviderName
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

        public LinkoutDealWebViewClient(WebViewHelper webviewhelper)
        {
            this$0 = ThirdPartyLinkoutDealWebViewActivity.this;
            super(ThirdPartyLinkoutDealWebViewActivity.this, webviewhelper);
        }
    }


    public static final String EXTERNAL_DEAL_PROVIDER_NAME = "external_deal_provider_name";
    private String externalDealProviderName;
    private IntentFactory intentFactory;
    LinearLayout loadingCat;
    TextView loadingContent;
    TextView loadingTitle;
    TextView pageUrl;
    WobbleSpaceshipCatView wobbleSpaceshipCatView;

    public ThirdPartyLinkoutDealWebViewActivity()
    {
    }

    private void loopLoadingAnimation(String s, Spanned spanned)
    {
        if (Strings.notEmpty(s))
        {
            loadingTitle.setVisibility(0);
            loadingTitle.setText(s);
        }
        if (Strings.notEmpty(spanned))
        {
            loadingContent.setVisibility(0);
            loadingContent.setText(spanned);
        }
        wobbleSpaceshipCatView.loopProgressAnimation(200);
        loadingCat.setVisibility(0);
    }

    protected int getLayoutResId()
    {
        return 0x7f030215;
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        pageUrl.setText(url);
    }

    public void onCreate(Bundle bundle)
    {
        externalDealProviderName = getIntent().getStringExtra("external_deal_provider_name");
        super.onCreate(bundle);
        progressBar.setVisibility(8);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0, 0x7f100018, 0, 0x7f0802c8).setShowAsAction(0);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 2131755032 2131755032: default 24
    //                   2131755032 30;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        startActivity(intentFactory.externalUrlIntent(url));
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void setupWebViewClient()
    {
        webView.setWebViewClient(new LinkoutDealWebViewClient(helper));
    }


}
