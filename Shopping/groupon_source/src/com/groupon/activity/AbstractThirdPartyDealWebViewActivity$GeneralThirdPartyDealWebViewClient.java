// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.webkit.WebView;
import android.widget.TextView;
import com.groupon.util.WebViewHelper;

// Referenced classes of package com.groupon.activity:
//            AbstractThirdPartyDealWebViewActivity

protected class this._cls0 extends this._cls0
{

    final AbstractThirdPartyDealWebViewActivity this$0;

    public void onPageFinished(WebView webview, String s)
    {
        super._mth0(webview, s);
        pageTitle.setText(webView.getTitle());
    }

    public (WebViewHelper webviewhelper)
    {
        this$0 = AbstractThirdPartyDealWebViewActivity.this;
        super(AbstractThirdPartyDealWebViewActivity.this, webviewhelper);
    }
}
