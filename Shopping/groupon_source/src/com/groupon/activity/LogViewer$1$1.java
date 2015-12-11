// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.groupon.activity:
//            LogViewer

class this._cls1
    implements Runnable
{

    final iew this$1;

    public void run()
    {
        if (!webView.pageDown(true))
        {
            webView.post(this);
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/groupon/activity/LogViewer$1

/* anonymous class */
    class LogViewer._cls1 extends WebViewClient
    {

        final LogViewer this$0;

        public void onPageFinished(WebView webview, String s)
        {
            webview.post(new LogViewer._cls1._cls1());
        }

            
            {
                this$0 = LogViewer.this;
                super();
            }
    }

}
