// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import bmo;
import wi;
import wj;

public class BrowserActivity extends Activity
{

    public BrowserActivity()
    {
    }

    public static Intent a(Context context, String s)
    {
        return (new Intent(context, com/google/android/apps/youtube/kids/activities/BrowserActivity)).putExtra("url", s);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
        bundle = getIntent().getStringExtra("url");
        if (bundle == null)
        {
            bmo.c("BrowserActivity missing licenses URL, finishing.");
            finish();
            return;
        } else
        {
            WebView webview = new WebView(this);
            webview.setWebViewClient(new WebViewClient());
            webview.setOnKeyListener(new wi(this));
            webview.loadUrl(bundle);
            webview.setOnLongClickListener(new wj(this));
            setContentView(webview);
            return;
        }
    }
}
