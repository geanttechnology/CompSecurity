// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xfinity.playerlib.model.videoplay.adobeplayer.VideoStateController;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment, PlayerPlatformMediaPlayer

class isFirstUrl extends WebViewClient
{

    boolean isFirstUrl;
    final ._cls0 this$2;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (isFirstUrl)
        {
            isFirstUrl = false;
            webview.loadUrl(s);
            return true;
        } else
        {
            webview = new Intent("android.intent.action.VIEW");
            webview.setData(Uri.parse(s));
            startActivity(webview);
            VideoPlayerFragment.access$2202(_fld0, true);
            return true;
        }
    }

    l.url()
    {
        this$2 = this._cls2.this;
        super();
        isFirstUrl = true;
    }

    // Unreferenced inner class com/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$1

/* anonymous class */
    class VideoPlayerFragment.PlayerUIController._cls1
        implements android.view.View.OnClickListener
    {

        final VideoPlayerFragment.PlayerUIController this$1;
        final String val$url;

        public void onClick(View view)
        {
            removeMainControlTimeout();
            VideoPlayerFragment.access$500(this$0).getMediaPlayer().pause();
            VideoPlayerFragment.access$2300(this$0).setWebViewClient(new VideoPlayerFragment.PlayerUIController._cls1._cls1());
            VideoPlayerFragment.access$2300(this$0).setVisibility(0);
            VideoPlayerFragment.access$2300(this$0).bringToFront();
            VideoPlayerFragment.access$2300(this$0).loadUrl(url);
        }

            
            {
                this$1 = final_playeruicontroller;
                url = String.this;
                super();
            }
    }

}
