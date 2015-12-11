// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import android.content.res.Resources;
import android.text.style.ClickableSpan;
import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonBrandedWebView;

// Referenced classes of package com.amazon.mShop.details:
//            MarketPlaceOfferDetailView

class this._cls0 extends ClickableSpan
{

    final MarketPlaceOfferDetailView this$0;

    public void onClick(View view)
    {
        String s = view.getContext().getResources().getString(com.amazon.mShop.android.lib.al_url_android);
        view = view.getContext().getResources().getString(com.amazon.mShop.android.lib.al_title);
        MarketPlaceOfferDetailView.access$000(MarketPlaceOfferDetailView.this).pushView(new AmazonBrandedWebView(MarketPlaceOfferDetailView.access$000(MarketPlaceOfferDetailView.this), s, view));
    }

    ()
    {
        this$0 = MarketPlaceOfferDetailView.this;
        super();
    }
}
