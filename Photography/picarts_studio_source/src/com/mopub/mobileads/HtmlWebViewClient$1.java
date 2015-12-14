// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            HtmlWebViewClient, HtmlWebViewListener, MoPubErrorCode

class this._cls0
    implements com.mopub.common.meListener
{

    final HtmlWebViewClient this$0;

    public void onClose()
    {
        HtmlWebViewClient.access$100(HtmlWebViewClient.this).onCollapsed();
    }

    public void onFailLoad()
    {
        HtmlWebViewClient.access$100(HtmlWebViewClient.this).onFailed(MoPubErrorCode.UNSPECIFIED);
    }

    public void onFinishLoad()
    {
        HtmlWebViewClient.access$100(HtmlWebViewClient.this).onLoaded(HtmlWebViewClient.access$000(HtmlWebViewClient.this));
    }

    istener()
    {
        this$0 = HtmlWebViewClient.this;
        super();
    }
}
