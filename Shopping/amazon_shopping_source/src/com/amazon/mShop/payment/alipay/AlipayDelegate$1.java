// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.payment.alipay;

import com.amazon.mShop.web.MShopWebActivity;

// Referenced classes of package com.amazon.mShop.payment.alipay:
//            AlipayCallback, AlipayDelegate, AlipayAdapterStatus

class val.returnUrl
    implements AlipayCallback
{

    final AlipayDelegate this$0;
    final MShopWebActivity val$activity;
    final String val$returnUrl;

    public void onPaymentFinish(AlipayAdapterStatus alipayadapterstatus, String s)
    {
        val$activity.setSkipStopBehavior(false);
        AlipayDelegate.access$100(AlipayDelegate.this, val$activity, val$returnUrl, alipayadapterstatus, s);
    }

    us()
    {
        this$0 = final_alipaydelegate;
        val$activity = mshopwebactivity;
        val$returnUrl = String.this;
        super();
    }
}
