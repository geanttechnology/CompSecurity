// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.UrlAction;

// Referenced classes of package com.mopub.mobileads:
//            HtmlWebViewClient, BaseHtmlWebView, HtmlWebViewListener

class this._cls0
    implements com.mopub.common.ions
{

    final HtmlWebViewClient this$0;

    public void urlHandlingFailed(String s, UrlAction urlaction)
    {
    }

    public void urlHandlingSucceeded(String s, UrlAction urlaction)
    {
        if (HtmlWebViewClient.access$000(HtmlWebViewClient.this).wasClicked())
        {
            HtmlWebViewClient.access$100(HtmlWebViewClient.this).onClicked();
            HtmlWebViewClient.access$000(HtmlWebViewClient.this).onResetUserClick();
        }
    }

    s()
    {
        this$0 = HtmlWebViewClient.this;
        super();
    }
}
