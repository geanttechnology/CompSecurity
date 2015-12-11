// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupon.util.GeneralThirdPartyDealWebViewHelper;
import com.groupon.util.WebViewHelper;

// Referenced classes of package com.groupon.activity:
//            BaseWebViewActivity

public abstract class AbstractThirdPartyDealWebViewActivity extends BaseWebViewActivity
{
    private class CloseButtonOnClickListner
        implements android.view.View.OnClickListener
    {

        final AbstractThirdPartyDealWebViewActivity this$0;

        public void onClick(View view)
        {
            finish();
        }

        private CloseButtonOnClickListner()
        {
            this$0 = AbstractThirdPartyDealWebViewActivity.this;
            super();
        }

    }

    protected class GeneralThirdPartyDealWebViewClient extends BaseWebViewActivity.CustomWebViewClient
    {

        final AbstractThirdPartyDealWebViewActivity this$0;

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            pageTitle.setText(webView.getTitle());
        }

        public GeneralThirdPartyDealWebViewClient(WebViewHelper webviewhelper)
        {
            this$0 = AbstractThirdPartyDealWebViewActivity.this;
            super(AbstractThirdPartyDealWebViewActivity.this, webviewhelper);
        }
    }


    public static final String THIRD_PARTY_DEAL_URL = "linkout_deal_url";
    ImageView closeButton;
    TextView pageTitle;
    Toolbar toolbar;
    protected String url;

    public AbstractThirdPartyDealWebViewActivity()
    {
    }

    public WebViewHelper createHelper()
    {
        return new GeneralThirdPartyDealWebViewHelper(this, url);
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        bundle = getSupportActionBar();
        closeButton.setOnClickListener(new CloseButtonOnClickListner());
        bundle.setDisplayHomeAsUpEnabled(false);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        toolbar.setVisibility(0);
    }
}
