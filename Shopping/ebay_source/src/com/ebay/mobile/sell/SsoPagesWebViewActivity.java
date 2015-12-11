// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.content.Intent;
import android.webkit.WebView;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ShowWebViewActivity;
import com.ebay.nautilus.domain.EbayCountry;

public class SsoPagesWebViewActivity extends ShowWebViewActivity
{

    public SsoPagesWebViewActivity()
    {
    }

    protected void readIntent()
    {
        super.readIntent();
        useSso = true;
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        webview = MyApp.getPrefs().getCurrentCountry().getSiteDomain();
        if (s.contains((new StringBuilder()).append("pages.").append(webview).toString()))
        {
            webview = new Intent(this, com/ebay/mobile/activities/ShowWebViewActivity);
            webview.putExtra("url", s);
            webview.putExtra("android.intent.extra.TITLE", "");
            startActivity(webview);
            return true;
        } else
        {
            return false;
        }
    }
}
