// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;

public class ou extends Activity
{

    public ou()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f04003b);
        getWindow().setLayout(-1, -1);
        bundle = getIntent().getStringExtra("licensesUrl");
        if (bundle == null)
        {
            bmo.c("LicensesActivity missing licenses URL, finishing.");
            finish();
            return;
        } else
        {
            WebView webview = (WebView)findViewById(0x7f100134);
            webview.setOnKeyListener(new ov(this));
            webview.loadUrl(bundle);
            return;
        }
    }
}
