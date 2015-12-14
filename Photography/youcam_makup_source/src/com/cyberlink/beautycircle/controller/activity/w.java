// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.media.MediaPlayer;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.VideoView;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WebViewerActivity, DeepLinkActivity

public class w extends WebChromeClient
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener
{

    final WebViewerActivity a;

    protected w(WebViewerActivity webvieweractivity)
    {
        a = webvieweractivity;
        super();
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        onHideCustomView();
    }

    public boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        e.b(new Object[] {
            consolemessage.message()
        });
        return false;
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        return false;
    }

    public void onHideCustomView()
    {
        if (WebViewerActivity.d(a))
        {
            WebViewerActivity.c(a).setVisibility(4);
            WebViewerActivity.c(a).removeView(WebViewerActivity.b(a));
            WebViewerActivity.a(a).setVisibility(0);
            if (com.cyberlink.beautycircle.controller.activity.WebViewerActivity.e(a) != null && !com.cyberlink.beautycircle.controller.activity.WebViewerActivity.e(a).getClass().getName().contains(".chromium."))
            {
                com.cyberlink.beautycircle.controller.activity.WebViewerActivity.e(a).onCustomViewHidden();
            }
            WebViewerActivity.a(a, false);
            WebViewerActivity.a(a, null);
            WebViewerActivity.a(a, null);
            a.c(false);
        }
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
    }

    public void onProgressChanged(WebView webview, int i)
    {
        a.g.setProgress(i);
    }

    public void onReceivedTitle(WebView webview, String s)
    {
    }

    public void onShowCustomView(View view, int i, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        onShowCustomView(view, customviewcallback);
    }

    public void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        if (!(view instanceof FrameLayout)) goto _L2; else goto _L1
_L1:
        View view1;
        view = (FrameLayout)view;
        view1 = view.getFocusedChild();
        WebViewerActivity.a(a, true);
        WebViewerActivity.a(a, view);
        WebViewerActivity.a(a, customviewcallback);
        WebViewerActivity.a(a).setVisibility(4);
        WebViewerActivity.c(a).addView(WebViewerActivity.b(a), new android.view.ViewGroup.LayoutParams(-1, -1));
        WebViewerActivity.c(a).setVisibility(0);
        if (!(view1 instanceof VideoView)) goto _L4; else goto _L3
_L3:
        view = (VideoView)view1;
        view.setOnPreparedListener(this);
        view.setOnCompletionListener(this);
        view.setOnErrorListener(this);
_L6:
        a.c(true);
_L2:
        return;
_L4:
        if (a.f != null && a.f.getSettings().getJavaScriptEnabled() && (view1 instanceof SurfaceView))
        {
            view = (new StringBuilder()).append("javascript:").append("var _ytrp_html5_video_last;").toString();
            view = (new StringBuilder()).append(view).append("var _ytrp_html5_video = document.getElementsByTagName('video')[0];").toString();
            view = (new StringBuilder()).append(view).append("if (_ytrp_html5_video != undefined && _ytrp_html5_video != _ytrp_html5_video_last) {").toString();
            view = (new StringBuilder()).append(view).append("_ytrp_html5_video_last = _ytrp_html5_video;").toString();
            view = (new StringBuilder()).append(view).append("function _ytrp_html5_video_ended() {").toString();
            view = (new StringBuilder()).append(view).append("_VideoEnabledWebView.notifyVideoEnd();").toString();
            view = (new StringBuilder()).append(view).append("}").toString();
            view = (new StringBuilder()).append(view).append("_ytrp_html5_video.addEventListener('ended', _ytrp_html5_video_ended);").toString();
            view = (new StringBuilder()).append(view).append("}").toString();
            a.f.loadUrl(view);
            DeepLinkActivity.f(a.s);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
