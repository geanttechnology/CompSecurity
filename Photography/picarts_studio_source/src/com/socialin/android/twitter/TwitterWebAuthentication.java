// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.twitter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.socialin.android.twitter:
//            d

public class TwitterWebAuthentication extends AppCompatActivity
{

    private static final String a = com/socialin/android/twitter/TwitterWebAuthentication.getSimpleName();

    public TwitterWebAuthentication()
    {
    }

    static String a()
    {
        return a;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        setContentView(0x7f03025f);
        bundle = getIntent().getExtras().getString("query");
        WebView webview = (WebView)findViewById(0x7f100acd);
        webview.setWebViewClient(new d(this, (byte)0));
        webview.getSettings().setJavaScriptEnabled(true);
        webview.clearHistory();
        webview.clearFormData();
        webview.getSettings().setCacheMode(2);
        webview.loadUrl(bundle);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            setResult(0);
            finish();
        }
        return super.onKeyDown(i, keyevent);
    }

}
