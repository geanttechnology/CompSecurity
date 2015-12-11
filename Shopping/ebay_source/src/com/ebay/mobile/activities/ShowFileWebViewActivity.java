// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.webkit.WebView;

// Referenced classes of package com.ebay.mobile.activities:
//            ShowWebViewActivity

public class ShowFileWebViewActivity extends ShowWebViewActivity
{

    public ShowFileWebViewActivity()
    {
    }

    public static void startActivity(Context context, String s, Integer integer, String s1)
    {
        startActivity(context, s, integer, s1, null);
    }

    public static void startActivity(Context context, String s, Integer integer, String s1, Boolean boolean1)
    {
        Intent intent = new Intent(context, com/ebay/mobile/activities/ShowFileWebViewActivity);
        intent.putExtra("url", s);
        if (integer != null)
        {
            intent.putExtra("android.intent.extra.TITLE", context.getResources().getString(integer.intValue()));
        }
        intent.putExtra("impression", s1);
        intent.putExtra(ShowWebViewActivity.EXTRA_USE_WIDE_VIEWPORT, false);
        if (boolean1 != null)
        {
            intent.putExtra(ShowWebViewActivity.EXTRA_SHOW_MENU, boolean1);
        }
        context.startActivity(intent);
    }

    protected void readIntent()
    {
        super.readIntent();
        addDeviceId = false;
    }

    protected boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        webview = new Intent(this, com/ebay/mobile/activities/ShowWebViewActivity);
        webview.putExtra("url", s);
        webview.putExtra("android.intent.extra.TITLE", "");
        webview.putExtra("back", true);
        startActivity(webview);
        return true;
    }
}
