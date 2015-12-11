// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshWebView

class this._cls0 extends WebChromeClient
{

    final PullToRefreshWebView this$0;

    public void onProgressChanged(WebView webview, int i)
    {
        if (i == 100)
        {
            onRefreshComplete();
        }
    }

    ()
    {
        this$0 = PullToRefreshWebView.this;
        super();
    }
}
