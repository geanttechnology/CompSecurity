// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.service.GoogleWalletService;
import com.groupon.service.ShippingService;
import com.groupon.util.LoggingUtils;
import com.groupon.view.BuyWithGoogleButton;

// Referenced classes of package com.groupon.activity:
//            Purchase

class this._cls0
    implements android.view.Listener
{

    final Purchase this$0;

    public void onClick(View view)
    {
        buyWithGoogleButton.startProgress();
        boolean flag;
        if (!shippingService.isStored() && isShippingAddressRequired())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        googleWalletService.triggerLoadMaskedWalletRequest(Purchase.this, option, currentlySelectedQuantity, flag);
        Purchase.access$500(Purchase.this).logBuyWithGoogleButtonClick(channel, com/groupon/activity/Purchase.getSimpleName(), dealId);
    }

    ervice()
    {
        this$0 = Purchase.this;
        super();
    }
}
