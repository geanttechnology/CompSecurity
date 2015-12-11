// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mopub.common.d.e;
import com.mopub.mobileads.c.a;
import com.mopub.mobileads.j;

// Referenced classes of package com.mopub.common:
//            e

public class MoPubBrowser extends Activity
{

    WebView a;
    ImageButton b;
    ImageButton c;
    private ImageButton d;
    private ImageButton e;

    public MoPubBrowser()
    {
    }

    static WebView a(MoPubBrowser mopubbrowser)
    {
        return mopubbrowser.a;
    }

    private ImageButton a(Drawable drawable)
    {
        ImageButton imagebutton = new ImageButton(this);
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2, 1.0F);
        layoutparams.gravity = 16;
        imagebutton.setLayoutParams(layoutparams);
        imagebutton.setImageDrawable(drawable);
        return imagebutton;
    }

    public void finish()
    {
        ((ViewGroup)getWindow().getDecorView()).removeAllViews();
        super.finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setResult(-1);
        getWindow().requestFeature(2);
        getWindow().setFeatureInt(2, -1);
        bundle = new LinearLayout(this);
        bundle.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
        bundle.setOrientation(1);
        RelativeLayout relativelayout = new RelativeLayout(this);
        relativelayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        bundle.addView(relativelayout);
        Object obj = new LinearLayout(this);
        ((LinearLayout) (obj)).setId(1);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutparams.addRule(12);
        ((LinearLayout) (obj)).setLayoutParams(layoutparams);
        ((LinearLayout) (obj)).setBackgroundDrawable(e.a.a(this));
        relativelayout.addView(((View) (obj)));
        b = a(e.c.a(this));
        c = a(e.e.a(this));
        d = a(e.g.a(this));
        e = a(e.h.a(this));
        ((LinearLayout) (obj)).addView(b);
        ((LinearLayout) (obj)).addView(c);
        ((LinearLayout) (obj)).addView(d);
        ((LinearLayout) (obj)).addView(e);
        a = new j(this);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(2, 1);
        a.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        relativelayout.addView(a);
        setContentView(bundle);
        bundle = a.getSettings();
        bundle.setJavaScriptEnabled(true);
        bundle.setSupportZoom(true);
        bundle.setBuiltInZoomControls(true);
        bundle.setUseWideViewPort(true);
        a.loadUrl(getIntent().getStringExtra("URL"));
        a.setWebViewClient(new com.mopub.common.e(this));
        a.setWebChromeClient(new WebChromeClient() {

            final MoPubBrowser a;

            public final void onProgressChanged(WebView webview, int i)
            {
                a.setTitle("Loading...");
                a.setProgress(i * 100);
                if (i == 100)
                {
                    a.setTitle(webview.getUrl());
                }
            }

            
            {
                a = MoPubBrowser.this;
                super();
            }
        });
        b.setBackgroundColor(0);
        b.setOnClickListener(new android.view.View.OnClickListener() {

            final MoPubBrowser a;

            public final void onClick(View view)
            {
                if (com.mopub.common.MoPubBrowser.a(a).canGoBack())
                {
                    com.mopub.common.MoPubBrowser.a(a).goBack();
                }
            }

            
            {
                a = MoPubBrowser.this;
                super();
            }
        });
        c.setBackgroundColor(0);
        c.setOnClickListener(new android.view.View.OnClickListener() {

            final MoPubBrowser a;

            public final void onClick(View view)
            {
                if (com.mopub.common.MoPubBrowser.a(a).canGoForward())
                {
                    com.mopub.common.MoPubBrowser.a(a).goForward();
                }
            }

            
            {
                a = MoPubBrowser.this;
                super();
            }
        });
        d.setBackgroundColor(0);
        d.setOnClickListener(new android.view.View.OnClickListener() {

            final MoPubBrowser a;

            public final void onClick(View view)
            {
                com.mopub.common.MoPubBrowser.a(a).reload();
            }

            
            {
                a = MoPubBrowser.this;
                super();
            }
        });
        e.setBackgroundColor(0);
        e.setOnClickListener(new android.view.View.OnClickListener() {

            final MoPubBrowser a;

            public final void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = MoPubBrowser.this;
                super();
            }
        });
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        a.destroy();
        a = null;
    }

    protected void onPause()
    {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
        com.mopub.mobileads.c.a.a(a, isFinishing());
    }

    protected void onResume()
    {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
        com.mopub.mobileads.c.a.a(a);
    }
}
