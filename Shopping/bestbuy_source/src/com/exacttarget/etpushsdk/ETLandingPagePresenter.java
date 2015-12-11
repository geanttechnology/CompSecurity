// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import com.exacttarget.etpushsdk.util.b;
import p;

// Referenced classes of package com.exacttarget.etpushsdk:
//            b, a

public class ETLandingPagePresenter extends Activity
{

    public ETLandingPagePresenter()
    {
    }

    private Button addDoneButton(LinearLayout linearlayout)
    {
        if (linearlayout == null)
        {
            return null;
        } else
        {
            Button button = new Button(this);
            button.setText("DONE");
            android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
            layoutparams.gravity = 3;
            layoutparams.weight = 0.1F;
            button.setLayoutParams(layoutparams);
            button.setOnClickListener(new com.exacttarget.etpushsdk.b(this));
            linearlayout.addView(button);
            return button;
        }
    }

    public void onCreate(Bundle bundle)
    {
        p.a(this);
        super.onCreate(bundle);
        setTitle("Loading...");
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setOrientation(1);
        linearlayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
        linearlayout.setGravity(17);
        if (b.a())
        {
            addDoneButton(linearlayout);
        }
        if (getIntent().getExtras().containsKey("_x"))
        {
            bundle = getIntent().getExtras().getString("_x");
        } else
        if (getIntent().getExtras().containsKey("_od"))
        {
            bundle = getIntent().getExtras().getString("_od");
        } else
        {
            bundle = null;
            setTitle("No website URL found in payload.");
        }
        if (bundle != null)
        {
            WebView webview = new WebView(this);
            android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -1);
            layoutparams.weight = 0.9F;
            webview.setLayoutParams(layoutparams);
            webview.loadUrl(bundle);
            webview.getSettings().setJavaScriptEnabled(true);
            linearlayout.addView(webview);
            webview.setWebViewClient(new a(this));
        }
        setContentView(linearlayout);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        p.d(this);
    }

    protected void onPause()
    {
        super.onPause();
        p.g(this);
    }

    protected void onRestart()
    {
        super.onRestart();
        p.e(this);
    }

    protected void onResume()
    {
        super.onResume();
        p.f(this);
    }

    protected void onStart()
    {
        super.onStart();
        p.b(this);
    }

    protected void onStop()
    {
        super.onStop();
        p.c(this);
    }
}
