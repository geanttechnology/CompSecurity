// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.ebay.mobile.sell:
//            ProductDetailsActivity

class this._cls1 extends WebViewClient
{

    final is._cls0 this$1;

    public void onPageFinished(WebView webview, String s)
    {
        _fld0.webview.setVisibility(0);
        loading.setVisibility(8);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
