// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.brightroll.androidsdk;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.brightroll.androidsdk:
//            AdActivity

class this._cls0 extends WebChromeClient
{

    final AdActivity this$0;

    public void onProgressChanged(WebView webview, int i)
    {
        if (android.os..SDK_INT >= 14 && i == 100 && !started)
        {
            started = true;
            webview.loadUrl("javascript:AdApp.adView().play()");
        }
    }

    ()
    {
        this$0 = AdActivity.this;
        super();
    }
}
