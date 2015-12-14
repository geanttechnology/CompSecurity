// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.brightroll.androidsdk;

import android.webkit.WebView;
import android.widget.VideoView;
import java.util.TimerTask;

// Referenced classes of package com.brightroll.androidsdk:
//            AdActivity

class this._cls0 extends TimerTask
{

    final AdActivity this$0;

    public void run()
    {
        runOnUiThread(new Runnable() {

            final AdActivity._cls4 this$1;

            public void run()
            {
                if (webView != null && videoView != null)
                {
                    webView.loadUrl((new StringBuilder("javascript:AdApp.videoView().setCurrentTime(")).append(videoView.getCurrentPosition() / 1000).append(")").toString());
                }
            }

            
            {
                this$1 = AdActivity._cls4.this;
                super();
            }
        });
    }


    _cls1.this._cls1()
    {
        this$0 = AdActivity.this;
        super();
    }
}
