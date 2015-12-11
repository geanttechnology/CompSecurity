// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETLandingPagePresenter

class a extends WebViewClient
{

    final ETLandingPagePresenter a;

    a(ETLandingPagePresenter etlandingpagepresenter)
    {
        a = etlandingpagepresenter;
        super();
    }

    public void onPageFinished(WebView webview, String s)
    {
        a.setTitle(webview.getTitle());
    }
}
