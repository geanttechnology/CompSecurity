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

class val.url
    implements android.view.nt.PlayerUIController._cls1
{

    final val.url this$1;
    final String val$url;

    public void onClick(View view)
    {
        moveMainControlTimeout();
        VideoPlayerFragment.access$500(_fld0).getMediaPlayer().pause();
        VideoPlayerFragment.access$2300(_fld0).setWebViewClient(new WebViewClient() {

            boolean isFirstUrl;
            final VideoPlayerFragment.PlayerUIController._cls1 this$2;

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
                    VideoPlayerFragment.access$2202(this$0, true);
                    return true;
                }
            }

            
            {
                this$2 = VideoPlayerFragment.PlayerUIController._cls1.this;
                super();
                isFirstUrl = true;
            }
        });
        VideoPlayerFragment.access$2300(_fld0).setVisibility(0);
        VideoPlayerFragment.access$2300(_fld0).bringToFront();
        VideoPlayerFragment.access$2300(_fld0).loadUrl(val$url);
    }

    _cls1.isFirstUrl()
    {
        this$1 = final_isfirsturl;
        val$url = String.this;
        super();
    }
}
