// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.brightroll.androidsdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.VideoView;
import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

// Referenced classes of package com.brightroll.androidsdk:
//            Ad, AdDelegate

public class AdActivity extends Activity
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnErrorListener
{

    BroadcastReceiver broadcastReceiver;
    FrameLayout frameLayout;
    Vector pixels;
    boolean started;
    Timer timer;
    String videoUrl;
    VideoView videoView;
    WebView webView;

    public AdActivity()
    {
    }

    public void browseTo(String s)
    {
        if (Ad.displayedAd.allowsBrowse())
        {
            Ad.displayedAd._flddelegate.adDidClick();
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(s));
            startActivity(intent);
        }
        finish();
    }

    public void cleanup()
    {
        if (videoView != null)
        {
            videoView.stopPlayback();
            if (frameLayout != null)
            {
                frameLayout.removeView(videoView);
            }
            videoView = null;
        }
        if (timer != null)
        {
            timer.cancel();
        }
    }

    public void didCompletion()
    {
        Ad.displayedAd._flddelegate.adDidCompletion();
    }

    public void didFirstQuartile()
    {
        Ad.displayedAd._flddelegate.adDidFirstQuartile();
    }

    public void didImpression()
    {
        Ad.displayedAd._flddelegate.adDidImpression();
    }

    public void didMidpoint()
    {
        Ad.displayedAd._flddelegate.adDidMidpoint();
    }

    public void didPixel(String s)
    {
        pixels.add(s);
    }

    public void didThirdQuartile()
    {
        Ad.displayedAd._flddelegate.adDidThirdQuartile();
    }

    public void finish()
    {
        runOnUiThread(new Runnable() {

            final AdActivity this$0;

            public void run()
            {
                if (webView != null)
                {
                    cleanup();
                    webView.loadUrl("about:blank");
                    frameLayout.removeView(webView);
                    webView = null;
                }
                if (broadcastReceiver != null)
                {
                    try
                    {
                        unregisterReceiver(broadcastReceiver);
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                    broadcastReceiver = null;
                }
            }

            
            {
                this$0 = AdActivity.this;
                super();
            }
        });
        Intent intent = new Intent();
        intent.putExtra("pixels", (String[])pixels.toArray(new String[0]));
        setResult(Ad.REQUEST_CODE_ACTIVITY_COMPLETED, intent);
        super.finish();
    }

    public void hide()
    {
        didPixel("Hide");
        finish();
    }

    public void load()
    {
        runOnUiThread(new Runnable() {

            final AdActivity this$0;
            private final AdActivity val$activity;

            public void run()
            {
                videoView = new VideoView(activity);
                android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(1, 1);
                videoView.setLayoutParams(layoutparams);
                frameLayout.addView(videoView);
                videoView.setMediaController(null);
                videoView.setVideoURI(Uri.parse(videoUrl));
                videoView.setOnPreparedListener(activity);
                videoView.setOnCompletionListener(activity);
                videoView.setOnErrorListener(activity);
            }

            
            {
                this$0 = AdActivity.this;
                activity = adactivity1;
                super();
            }
        });
    }

    public void onBackPressed()
    {
        while (Ad.displayedAd.getSupressesBackBeforeCompletion() && videoView != null && (videoView.getCurrentPosition() <= 0 || videoView.getCurrentPosition() < videoView.getDuration()) || Ad.displayedAd.getSupressesBackDuringLoad() && videoView != null && videoView.getCurrentPosition() <= 0) 
        {
            return;
        }
        finish();
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        cleanup();
        webView.loadUrl("javascript:AdApp.videoView().end();");
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        videoView = null;
        timer = null;
        bundle = new IntentFilter("android.intent.action.SCREEN_OFF");
        broadcastReceiver = new BroadcastReceiver() {

            final AdActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                if (intent.getAction().equals("android.intent.action.SCREEN_OFF"))
                {
                    finish();
                }
            }

            
            {
                this$0 = AdActivity.this;
                super();
            }
        };
        registerReceiver(broadcastReceiver, bundle);
        frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(0xff000000);
        setContentView(frameLayout);
        webView = new WebView(this);
        webView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        webView.setHorizontalScrollBarEnabled(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setBackgroundColor(0xff000000);
        bundle = webView.getSettings();
        bundle.setJavaScriptEnabled(true);
        bundle.setPluginState(android.webkit.WebSettings.PluginState.ON);
        String s;
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            try
            {
                bundle.getClass().getMethod("setMediaPlaybackRequiresUserGesture", new Class[] {
                    Boolean.TYPE
                }).invoke(bundle, new Object[] {
                    Boolean.valueOf(false)
                });
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        webView.setWebChromeClient(new WebChromeClient() {

            final AdActivity this$0;

            public void onProgressChanged(WebView webview, int i)
            {
                if (android.os.Build.VERSION.SDK_INT >= 14 && i == 100 && !started)
                {
                    started = true;
                    webview.loadUrl("javascript:AdApp.adView().play()");
                }
            }

            
            {
                this$0 = AdActivity.this;
                super();
            }
        });
        frameLayout.addView(webView);
        pixels = new Vector();
        webView.addJavascriptInterface(this, "AndroidBridge");
        bundle = getIntent().getExtras();
        s = bundle.getString("baseUrl");
        webView.loadDataWithBaseURL(s, bundle.getString("html"), "text/html", "utf-8", s);
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (Ad.displayedAd != null)
        {
            Ad.displayedAd.activityDestroyed();
        }
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        finish();
        return false;
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        webView.loadUrl((new StringBuilder("javascript:AdApp.videoView().setDuration(")).append(mediaplayer.getDuration() / 1000).append(")").toString());
        webView.loadUrl("javascript:AdApp.videoView().setCanPlay(true)");
        webView.loadUrl("javascript:AdApp.adView().play()");
    }

    public void play()
    {
        if (videoView != null)
        {
            Log.d("", "videoView.start");
            videoView.start();
            if (timer == null)
            {
                TimerTask timertask = new TimerTask() {

                    final AdActivity this$0;

                    public void run()
                    {
                        runOnUiThread(new Runnable() {

                            final _cls4 this$1;

                            public void run()
                            {
                                if (webView != null && videoView != null)
                                {
                                    webView.loadUrl((new StringBuilder("javascript:AdApp.videoView().setCurrentTime(")).append(videoView.getCurrentPosition() / 1000).append(")").toString());
                                }
                            }

            
            {
                this$1 = _cls4.this;
                super();
            }
                        });
                    }


            
            {
                this$0 = AdActivity.this;
                super();
            }
                };
                timer = new Timer();
                timer.schedule(timertask, 0L, 1000L);
            }
        }
    }

    public void positionVideo(final float xRatio, final float yRatio, final float wRatio, final float hRatio)
    {
        if (videoView != null && videoIsLoaded())
        {
            runOnUiThread(new Runnable() {

                final AdActivity this$0;
                private final float val$hRatio;
                private final float val$wRatio;
                private final float val$xRatio;
                private final float val$yRatio;

                public void run()
                {
                    int i = frameLayout.getWidth();
                    int j = frameLayout.getHeight();
                    if (videoView != null)
                    {
                        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)videoView.getLayoutParams();
                        layoutparams.gravity = 48;
                        layoutparams.width = (int)((float)i * wRatio);
                        layoutparams.height = (int)((float)j * hRatio);
                        layoutparams.leftMargin = (int)((float)i * xRatio);
                        layoutparams.topMargin = (int)((float)j * yRatio);
                        videoView.setLayoutParams(layoutparams);
                        videoView.forceLayout();
                    }
                }

            
            {
                this$0 = AdActivity.this;
                wRatio = f;
                hRatio = f1;
                xRatio = f2;
                yRatio = f3;
                super();
            }
            });
        }
    }

    public void seekTo(float f)
    {
        if (videoView != null)
        {
            videoView.seekTo((int)(1000F * f));
        }
    }

    public void setVideoUrl(String s)
    {
        videoUrl = s;
    }

    boolean videoIsLoaded()
    {
        return timer != null;
    }
}
