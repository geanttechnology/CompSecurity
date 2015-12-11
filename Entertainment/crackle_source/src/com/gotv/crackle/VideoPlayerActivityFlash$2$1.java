// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivityFlash

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        if (VideoPlayerActivityFlash.access$100(_fld0) != null)
        {
            VideoPlayerActivityFlash.access$100(_fld0).loadUrl("javascript:reportPlayheadTime()");
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/VideoPlayerActivityFlash$2

/* anonymous class */
    class VideoPlayerActivityFlash._cls2 extends WebViewClient
    {

        final VideoPlayerActivityFlash this$0;

        public void onPageFinished(WebView webview, String s)
        {
            (new Handler()).postDelayed(new VideoPlayerActivityFlash._cls2._cls1(), 10000L);
            super.onPageFinished(webview, s);
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            webview = new Intent("android.intent.action.VIEW");
            webview.setData(Uri.parse(s));
            startActivity(webview);
            return true;
        }

            
            {
                this$0 = VideoPlayerActivityFlash.this;
                super();
            }
    }

}
