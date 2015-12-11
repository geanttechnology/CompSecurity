// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.comcast.cim.android.view.common:
//            BaseActivity

public class SimpleWebViewActivity extends BaseActivity
{

    public SimpleWebViewActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(com.comcast.cim.android.R.layout.webview);
        bundle = getIntent().getData();
        WebView webview = (WebView)findViewById(com.comcast.cim.android.R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(bundle.toString());
    }
}
