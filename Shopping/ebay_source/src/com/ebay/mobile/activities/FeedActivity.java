// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ebay.common.Preferences;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsHelper;

// Referenced classes of package com.ebay.mobile.activities:
//            ShowWebViewActivity

public class FeedActivity extends ShowWebViewActivity
{

    public FeedActivity()
    {
    }

    protected void createUI()
    {
        super.createUI();
        webview.setVerticalScrollBarEnabled(false);
        webview.getSettings().setBuiltInZoomControls(false);
    }

    public void onCreate(Bundle bundle)
    {
        requireAuth = true;
        super.onCreate(bundle);
    }

    protected void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        if (webview != null)
        {
            s = webview.getTitle();
            webview = s;
            if (TextUtils.isEmpty(s))
            {
                webview = getString(0x7f07040f);
            }
            setTitle(webview);
        }
    }

    protected void readIntent()
    {
        super.readIntent();
        impression = "Feed";
        title = getString(0x7f07040f);
        useBackStack = true;
        scope = EbayCountryManager.mobileWebSsoScope(MyApp.getPrefs().getCurrentCountry());
        useSso = true;
        Resources resources = getResources();
        backgroundColor = resources.getColor(0x7f0d00b5);
        maxWidth = resources.getDimensionPixelSize(0x7f090197);
        url = MyApp.getDeviceConfiguration().feedUrl();
    }
}
