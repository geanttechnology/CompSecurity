// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WindowPlayerService extends Service
{

    MyBinder binder;
    int current;
    boolean flag;
    boolean isReady;
    Messenger messenger;
    String musicId;
    boolean shouldPlayAfterReady;
    private WindowManager windowManager;
    WebView wv;

    public WindowPlayerService()
    {
    }

    private void loadUrl()
    {
        wv.loadUrl("http://static.mixerbox.com/yt_android.min.kk.v2.html");
    }

    public IBinder onBind(Intent intent)
    {
        if (intent != null)
        {
            messenger = (Messenger)intent.getParcelableExtra("messenger");
        }
        binder = new MyBinder();
        return binder;
    }

    public void onCreate()
    {
        super.onCreate();
        windowManager = (WindowManager)getSystemService("window");
        flag = false;
        current = 0;
        isReady = false;
        shouldPlayAfterReady = false;
        musicId = "";
        wv = new WebView(this);
        Object obj = wv.getSettings();
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            ((WebSettings) (obj)).setMediaPlaybackRequiresUserGesture(false);
        }
        ((WebSettings) (obj)).setJavaScriptEnabled(true);
        MyJavaScriptInterface myjavascriptinterface = new MyJavaScriptInterface();
        wv.addJavascriptInterface(myjavascriptinterface, "AndroidFunction");
        ((WebSettings) (obj)).setDomStorageEnabled(true);
        ((WebSettings) (obj)).setDatabaseEnabled(true);
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            ((WebSettings) (obj)).setPluginState(android.webkit.WebSettings.PluginState.ON);
        }
        ((WebSettings) (obj)).setCacheMode(2);
        wv.setWebViewClient(new _cls1());
        wv.setWebChromeClient(new WebChromeClient());
        wv.setPadding(0, 0, 0, 0);
        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.setVerticalScrollBarEnabled(false);
        wv.setHorizontalScrollBarEnabled(false);
        loadUrl();
        obj = new android.view.WindowManager.LayoutParams(1, 1, 2002, 0x1000008, -3);
        obj.gravity = 51;
        obj.x = 0;
        obj.y = 0;
        windowManager.addView(wv, ((android.view.ViewGroup.LayoutParams) (obj)));
    }

    public void onDestroy()
    {
        if (wv != null)
        {
            wv.loadUrl("javascript:pauseVideo()");
            wv.loadUrl("about:blank");
            windowManager.removeView(wv);
        }
        super.onDestroy();
    }


    private class MyBinder extends Binder
    {

        final WindowPlayerService this$0;

        public int getCurrentTime()
        {
            return current;
        }

        public boolean getIsPlaying()
        {
            return flag;
        }

        public void pauseMusic()
        {
            flag = false;
            wv.loadUrl("javascript:pauseVideo()");
        }

        public void playMusic()
        {
            flag = true;
            wv.loadUrl("javascript:playVideo()");
        }

        public void playMusic(String s)
        {
            if (!isReady)
            {
                loadUrl();
                shouldPlayAfterReady = true;
                musicId = s;
                flag = false;
                return;
            } else
            {
                flag = true;
                wv.loadUrl((new StringBuilder()).append("javascript:loadVideoById('").append(s).append("',0)").toString());
                return;
            }
        }

        public MyBinder()
        {
            this$0 = WindowPlayerService.this;
            super();
        }
    }


    private class MyJavaScriptInterface
    {

        final WindowPlayerService this$0;

        public void log(String s)
        {
            MixerBoxUtils.logMsg((new StringBuilder()).append("FROM JS: ").append(s).toString());
        }

        public void onPlayerReady()
        {
            isReady = true;
            if (shouldPlayAfterReady)
            {
                wv.loadUrl((new StringBuilder()).append("javascript:loadVideoById('").append(musicId).append("',0)").toString());
                flag = true;
            }
            shouldPlayAfterReady = false;
        }

        public void playNext()
        {
            Message message = Message.obtain(null, 0xbc5c01);
            try
            {
                messenger.send(message);
                return;
            }
            catch (RemoteException remoteexception)
            {
                remoteexception.printStackTrace();
            }
        }

        public void setCurrentTime(int i)
        {
            current = i;
            MixerBoxUtils.logMsg((new StringBuilder()).append("FROM JS: ").append(i).toString());
        }

        public MyJavaScriptInterface()
        {
            this$0 = WindowPlayerService.this;
            super();
        }
    }


    private class _cls1 extends WebViewClient
    {

        final WindowPlayerService this$0;

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            super.onReceivedError(webview, i, s, s1);
        }

        _cls1()
        {
            this$0 = WindowPlayerService.this;
            super();
        }
    }

}
