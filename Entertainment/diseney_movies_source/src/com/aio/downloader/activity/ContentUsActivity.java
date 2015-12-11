// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.ProgressWheel;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ContentUsActivity extends Activity
    implements android.view.View.OnClickListener
{
    public class Mywebview extends WebViewClient
    {

        final ContentUsActivity this$0;

        public void onPageFinished(WebView webview, String s)
        {
            progressWheel.setVisibility(8);
            super.onPageFinished(webview, s);
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            progressWheel.setVisibility(0);
            super.onPageStarted(webview, s, bitmap);
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            super.shouldOverrideUrlLoading(webview, s);
            webview.loadUrl(s);
            return true;
        }

        public Mywebview()
        {
            this$0 = ContentUsActivity.this;
            super();
        }
    }


    private static Typeface typeFace = null;
    private TextView back;
    private ImageView fan;
    private ImageView finishcha;
    private String guanggao_url;
    private WebView guanggaowebview;
    private ProgressWheel progressWheel;
    private Mywebview webviewclient;

    public ContentUsActivity()
    {
        guanggao_url = null;
        progressWheel = null;
    }

    private void bulidListenrn()
    {
        fan.setOnClickListener(this);
        finishcha.setOnClickListener(this);
        HashMap hashmap;
        try
        {
            guanggaowebview.getSettings().setUserAgentString(Myutils.setting_json.getString("agent"));
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        hashmap = new HashMap();
        hashmap.put("AIOD", "1");
        guanggaowebview.loadUrl(guanggao_url, hashmap);
        webviewclient = new Mywebview();
        guanggaowebview.setWebViewClient(webviewclient);
    }

    private void init()
    {
        progressWheel = (ProgressWheel)findViewById(0x7f070072);
        guanggao_url = getIntent().getStringExtra("guanggao_url");
        guanggaowebview = (WebView)findViewById(0x7f070150);
        fan = (ImageView)findViewById(0x7f07014e);
        finishcha = (ImageView)findViewById(0x7f07014f);
        back = (TextView)findViewById(0x7f070077);
        if (typeFace == null)
        {
            typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
        }
        back.setTypeface(typeFace);
        guanggaowebview.getSettings().setJavaScriptEnabled(true);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131165518: 
            if (guanggaowebview.canGoBack())
            {
                guanggaowebview.goBack();
                return;
            } else
            {
                finish();
                return;
            }

        case 2131165519: 
            finish();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(0x7f03002a);
        init();
        bulidListenrn();
    }

    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
    }


}
