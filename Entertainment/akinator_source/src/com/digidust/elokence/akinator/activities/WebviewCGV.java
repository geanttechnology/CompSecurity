// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity

public class WebviewCGV extends AkActivity
    implements android.view.View.OnClickListener
{

    public static final String URL_CGV = "http://cgu.akinator.com/mobile/content#cgv";
    public static final String URL_INPI = "http://cgu.akinator.com/mobile/content#inpi";
    public static final String URL_KEY = "url";
    public static final String URL_MOBILE_EN = "http://en.akinator.com/content/10/terms-of-mobile-app";
    public static final String URL_MOBILE_FR = "http://fr.akinator.com/content/10/conditions-d-utilisation-de-l-app-mobile";
    public static final String URL_PRIVACY = "http://cgu.akinator.com/mobile/privacy";
    public static final String URL_TOS = "http://cgu.akinator.com/mobile/content";
    private ImageView uiBackButtonImage;
    private WebView uiWebviewCGV;

    public WebviewCGV()
    {
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        finish();
    }

    public void onClick(View view)
    {
        if (view == uiBackButtonImage)
        {
            finish();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03003b);
        uiBackButtonImage = (ImageView)findViewById(0x7f0d00ba);
        uiBackButtonImage.setOnClickListener(this);
        uiWebviewCGV = (WebView)findViewById(0x7f0d01d5);
        uiWebviewCGV.getSettings().setJavaScriptEnabled(true);
        uiWebviewCGV.loadUrl(getIntent().getStringExtra("url"));
    }
}
