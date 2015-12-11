// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.content.Intent;
import android.view.View;
import com.ebay.mobile.activities.PreferredCountryActivity;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.data.Address;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            CreditCardActivity

class val.shippingAddress
    implements android.view.itCardActivity._cls1
{

    final CreditCardActivity this$0;
    final Address val$shippingAddress;

    public void onClick(View view)
    {
        view = new Intent(CreditCardActivity.this, com/ebay/mobile/activities/PreferredCountryActivity);
        if (val$shippingAddress != null)
        {
            view.putExtra("extraCountry", EbayCountry.getInstance(val$shippingAddress.addressFields.country));
        }
        startActivityForResult(view, 0x61665);
    }

    ()
    {
        this$0 = final_creditcardactivity;
        val$shippingAddress = Address.this;
        super();
    }
}
