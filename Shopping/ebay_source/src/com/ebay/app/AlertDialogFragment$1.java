// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.app;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.ebay.app:
//            AlertDialogFragment

class  extends WebViewClient
{

    final AlertDialogFragment this$0;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            webview = new Intent("android.intent.action.VIEW", Uri.parse(s));
            startActivity(webview);
        }
        return true;
    }

    ()
    {
        this$0 = AlertDialogFragment.this;
        super();
    }
}
