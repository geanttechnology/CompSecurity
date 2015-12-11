// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewDescriptionActivity, ItemViewCommonProgressAndError

class this._cls0 extends WebViewClient
{

    final ItemViewDescriptionActivity this$0;

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Toast.makeText(ItemViewDescriptionActivity.this, s, 0).show();
        ItemViewCommonProgressAndError.showLayouts(ItemViewDescriptionActivity.this, .LayoutState.SERVICE_ERROR);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (s.startsWith("http://pages.ebay.com/link/?nav="))
        {
            webview = new Intent("android.intent.action.VIEW", Uri.parse(s));
            startActivity(webview);
            return true;
        } else
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }
    }

    ()
    {
        this$0 = ItemViewDescriptionActivity.this;
        super();
    }
}
