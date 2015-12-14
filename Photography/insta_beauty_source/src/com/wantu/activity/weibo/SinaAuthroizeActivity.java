// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.weibo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import bjy;
import com.fotoable.fotobeauty.FullscreenActivity;

public class SinaAuthroizeActivity extends FullscreenActivity
{

    private WebView a;
    private String b;
    private boolean c;
    private ProgressDialog d;
    private Button e;
    private Resources f;

    public SinaAuthroizeActivity()
    {
        c = true;
    }

    public static ProgressDialog a(SinaAuthroizeActivity sinaauthroizeactivity)
    {
        return sinaauthroizeactivity.d;
    }

    public static ProgressDialog a(SinaAuthroizeActivity sinaauthroizeactivity, ProgressDialog progressdialog)
    {
        sinaauthroizeactivity.d = progressdialog;
        return progressdialog;
    }

    public static Resources b(SinaAuthroizeActivity sinaauthroizeactivity)
    {
        return sinaauthroizeactivity.f;
    }

    public static String c(SinaAuthroizeActivity sinaauthroizeactivity)
    {
        return sinaauthroizeactivity.b;
    }

    public static WebView d(SinaAuthroizeActivity sinaauthroizeactivity)
    {
        return sinaauthroizeactivity.a;
    }

    public void backBtnClicked(View view)
    {
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300c5);
        f = getResources();
        b = getIntent().getStringExtra("com.wantu.android.source");
        d = new ProgressDialog(this);
        d.requestWindowFeature(1);
        d.setMessage(f.getString(0x7f06025b));
        d.show();
        e = (Button)findViewById(0x7f0d010b);
        e.setVisibility(4);
        ((TextView)findViewById(0x7f0d0034)).setText(f.getString(0x7f06025a));
        a = (WebView)findViewById(0x7f0d0332);
        a.getSettings().setJavaScriptEnabled(true);
        a.getSettings().setBuiltInZoomControls(true);
        (new bjy(this)).execute(new String[0]);
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    protected void onPause()
    {
        super.onPause();
    }
}
