// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.brightroll.androidsdk;

import android.webkit.WebView;
import android.widget.VideoView;
import java.util.TimerTask;

// Referenced classes of package com.brightroll.androidsdk:
//            AdActivity

class this._cls1
    implements Runnable
{

    final on this$1;

    public void run()
    {
        if (webView != null && videoView != null)
        {
            webView.loadUrl((new StringBuilder("javascript:AdApp.videoView().setCurrentTime(")).append(videoView.getCurrentPosition() / 1000).append(")").toString());
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/brightroll/androidsdk/AdActivity$4

/* anonymous class */
    class AdActivity._cls4 extends TimerTask
    {

        final AdActivity this$0;

        public void run()
        {
            runOnUiThread(new AdActivity._cls4._cls1());
        }


            
            {
                this$0 = AdActivity.this;
                super();
            }
    }

}
