// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.view.View;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewContainer, MShopWebView

class this._cls0
    implements android.view.ainer._cls2
{

    final MShopWebViewContainer this$0;

    public void onClick(View view)
    {
        MShopWebViewContainer.access$000(MShopWebViewContainer.this).clearView();
        MShopWebViewContainer.access$000(MShopWebViewContainer.this).reload();
        MShopWebViewContainer.access$200(MShopWebViewContainer.this);
    }

    ()
    {
        this$0 = MShopWebViewContainer.this;
        super();
    }
}
