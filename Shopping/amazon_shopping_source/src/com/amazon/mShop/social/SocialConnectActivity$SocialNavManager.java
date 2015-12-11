// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.social;

import android.net.Uri;
import android.webkit.WebView;
import com.amazon.mShop.mash.nav.AmazonNavManager;

// Referenced classes of package com.amazon.mShop.social:
//            SocialConnectActivity

private class <init> extends AmazonNavManager
{

    final SocialConnectActivity this$0;

    protected void handleDismissAll(WebView webview, Uri uri)
    {
        SocialConnectActivity socialconnectactivity = SocialConnectActivity.this;
        boolean flag;
        if (uri != null && uri.getQueryParameter("do_not_show_again") != null && "1".equals(uri.getQueryParameter("do_not_show_again")))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        SocialConnectActivity.access$002(socialconnectactivity, flag);
        super.handleDismissAll(webview, uri);
    }

    private ()
    {
        this$0 = SocialConnectActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
