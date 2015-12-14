// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            AuthenticatedWebViewActivity

class this._cls0 extends WebChromeClient
{

    final AuthenticatedWebViewActivity this$0;

    public boolean onCreateWindow(WebView webview, boolean flag, boolean flag1, Message message)
    {
        message = webview.getHitTestResult()._mth4();
        if (message != null)
        {
            webview.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(message)));
        }
        return false;
    }

    I()
    {
        this$0 = AuthenticatedWebViewActivity.this;
        super();
    }
}
