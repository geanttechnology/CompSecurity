// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.primeupsell;

import android.net.Uri;
import android.webkit.WebView;
import com.amazon.mShop.mash.nav.AmazonNavManager;

// Referenced classes of package com.amazon.mShop.primeupsell:
//            PrimeUpsellActivity

private class <init> extends AmazonNavManager
{

    final PrimeUpsellActivity this$0;

    protected void handleDismissAll(WebView webview, Uri uri)
    {
        String s = uri.getQueryParameter("result");
        if (!"successPrime".equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        PrimeUpsellActivity.access$002(PrimeUpsellActivity.this, t.RESULT_SIGNUP_SUCCESS);
_L4:
        super.handleDismissAll(webview, uri);
        return;
_L2:
        if ("successNoThanks".equalsIgnoreCase(s))
        {
            PrimeUpsellActivity.access$002(PrimeUpsellActivity.this, t.RESULT_USER_CANCELLED);
        } else
        if ("failurePrime".equalsIgnoreCase(s))
        {
            PrimeUpsellActivity.access$002(PrimeUpsellActivity.this, t.RESULT_SIGNUP_FAILURE);
        } else
        if ("failureOfferNotDisplayed".equalsIgnoreCase(s))
        {
            PrimeUpsellActivity.access$002(PrimeUpsellActivity.this, t.RESULT_OFFER_PAGE_NOT_DISPLAYED);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private t()
    {
        this$0 = PrimeUpsellActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
