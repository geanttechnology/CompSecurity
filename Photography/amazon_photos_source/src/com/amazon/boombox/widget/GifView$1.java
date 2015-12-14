// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.widget;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.boombox.widget:
//            GifView

class this._cls0 extends WebViewClient
{

    final GifView this$0;

    public void onPageFinished(WebView webview, String s)
    {
        webview = GifView.access$000(GifView.this);
        webview;
        JVM INSTR monitorenter ;
        GifView.access$102(GifView.this, true);
        for (s = GifView.access$000(GifView.this).iterator(); s.hasNext(); ((fListener)s.next()).onReady()) { }
        break MISSING_BLOCK_LABEL_63;
        s;
        webview;
        JVM INSTR monitorexit ;
        throw s;
        webview;
        JVM INSTR monitorexit ;
    }

    fListener()
    {
        this$0 = GifView.this;
        super();
    }
}
