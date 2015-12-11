// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.groupon.db.models.Special;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.activity:
//            BusinessSpecialPage

class this._cls0 extends WebViewClient
{

    final BusinessSpecialPage this$0;

    public void onLoadResource(WebView webview, String s)
    {
        BusinessSpecialPage.access$400(BusinessSpecialPage.this).logClick("", "special_affiliate_click", BusinessSpecialPage.access$000(BusinessSpecialPage.this).remoteId, "");
        super.onLoadResource(webview, s);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        return true;
    }

    ()
    {
        this$0 = BusinessSpecialPage.this;
        super();
    }
}
