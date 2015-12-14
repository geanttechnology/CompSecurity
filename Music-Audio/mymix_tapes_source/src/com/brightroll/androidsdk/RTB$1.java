// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.brightroll.androidsdk;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.brightroll.androidsdk:
//            RTB

class  extends WebChromeClient
{

    public void onProgressChanged(WebView webview, int i)
    {
        if (i == 100)
        {
            webview.loadUrl("javascript:rtb.setUserAgent(navigator.userAgent)");
        }
    }

    ()
    {
    }
}
