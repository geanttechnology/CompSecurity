// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aio.downloader.utils.DisplayUtil;
import com.aio.downloader.utils.Player;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.umeng.analytics.MobclickAgent;

public class MiniGamePlayActivity extends Activity
    implements android.view.View.OnClickListener
{
    public class Mywebview extends WebViewClient
    {

        final MiniGamePlayActivity this$0;

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            progress_wheel.setVisibility(8);
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            progress_wheel.setVisibility(0);
            super.onPageStarted(webview, s, bitmap);
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            super.onReceivedError(webview, i, s, s1);
            net_hint_img_pdt.setVisibility(0);
            gameplaywebview.loadData("", "text/html", "UTF-8");
        }

        public WebResourceResponse shouldInterceptRequest(WebView webview, String s)
        {
            return super.shouldInterceptRequest(webview, s);
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }

        public Mywebview()
        {
            this$0 = MiniGamePlayActivity.this;
            super();
        }
    }


    private static Typeface typeFace = null;
    private AdView adView;
    private LinearLayout appbanner;
    private String banner_type_name;
    private ImageView detailfan;
    private WebView gameplaywebview;
    private ImageView gamereload;
    private String getproc;
    private ImageView net_hint_img_pdt;
    private TextView playbacktv;
    private Player player;
    private String playurl;
    private String proc;
    private ProgressWheel progress_wheel;
    private String sound;
    private SharedPreferences sp_config;
    private Mywebview webviewclient;

    public MiniGamePlayActivity()
    {
        playurl = "";
        proc = "";
        sound = "";
        sp_config = null;
    }

    private void ApppopulistViewbottom()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)gameplaywebview.getLayoutParams();
        layoutparams.setMargins(0, 0, 0, DisplayUtil.dip2px(this, 50F));
        gameplaywebview.setLayoutParams(layoutparams);
    }

    private void ApppopulistViewbottom2()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)gameplaywebview.getLayoutParams();
        layoutparams.setMargins(0, 0, 0, DisplayUtil.dip2px(this, 0.0F));
        gameplaywebview.setLayoutParams(layoutparams);
    }

    private void buildListener()
    {
        detailfan.setOnClickListener(this);
    }

    private void init()
    {
        gamereload = (ImageView)findViewById(0x7f0702d7);
        detailfan = (ImageView)findViewById(0x7f070098);
        net_hint_img_pdt = (ImageView)findViewById(0x7f0702da);
        playbacktv = (TextView)findViewById(0x7f0702d6);
        gameplaywebview = (WebView)findViewById(0x7f0702d9);
        progress_wheel = (ProgressWheel)findViewById(0x7f070072);
        playurl = getIntent().getStringExtra("playurl");
        Log.v("tyty", (new StringBuilder(String.valueOf(playurl))).append("***").toString());
        proc = getIntent().getStringExtra("proc");
        sound = getIntent().getStringExtra("sound");
        typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
        playbacktv.setTypeface(typeFace);
        gamereload.setOnClickListener(new android.view.View.OnClickListener() {

            final MiniGamePlayActivity this$0;

            public void onClick(View view)
            {
                gameplaywebview.reload();
            }

            
            {
                this$0 = MiniGamePlayActivity.this;
                super();
            }
        });
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131165336: 
            finish();
            break;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2)
        {
            Log.v("trtr", "\u6A2A\u5C4F");
            appbanner.setVisibility(8);
            ApppopulistViewbottom2();
        } else
        if (configuration.orientation == 1)
        {
            appbanner.setVisibility(0);
            ApppopulistViewbottom();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030077);
        init();
        buildListener();
        getproc = publicTools.getUrl(proc);
        Log.v("getproc", (new StringBuilder(String.valueOf(getproc))).append("///").toString());
        bundle = gameplaywebview.getSettings();
        bundle.setJavaScriptEnabled(true);
        bundle.setCacheMode(-1);
        bundle.setAppCacheEnabled(true);
        webviewclient = new Mywebview();
        gameplaywebview.setWebViewClient(webviewclient);
        gameplaywebview.loadUrl(playurl);
        try
        {
            (new Thread(new Runnable() {

                final MiniGamePlayActivity this$0;

                public void run()
                {
                    Looper.prepare();
                    if (!sound.equals(""))
                    {
                        player.playUrl(sound);
                    }
                }

            
            {
                this$0 = MiniGamePlayActivity.this;
                super();
            }
            })).start();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        appbanner = (LinearLayout)findViewById(0x7f070059);
        sp_config = getSharedPreferences("banner_type", 0);
        banner_type_name = sp_config.getString("banner_type", "admob");
        if (banner_type_name.equals("admob"))
        {
            adView = new AdView(this, AdSize.SMART_BANNER, "ca-app-pub-2192624499353475/5842010949");
            appbanner.addView(adView);
            adView.loadAd(new AdRequest());
        }
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
