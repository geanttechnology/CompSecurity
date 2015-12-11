// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.ebay.mobile.activities:
//            ShowWebViewFragment

class this._cls0 extends WebChromeClient
{

    final ShowWebViewFragment this$0;

    public void onProgressChanged(WebView webview, int i)
    {
        webview = ShowWebViewFragment.this;
        boolean flag;
        if (i <= 99)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        webview.showProgress(flag);
    }

    ()
    {
        this$0 = ShowWebViewFragment.this;
        super();
    }
}
