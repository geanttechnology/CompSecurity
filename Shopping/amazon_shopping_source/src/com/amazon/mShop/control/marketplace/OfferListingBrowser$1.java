// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.marketplace;

import com.amazon.mShop.model.auth.User;
import com.amazon.rio.j2me.client.services.mShop.PrimeOneClickStatus;

// Referenced classes of package com.amazon.mShop.control.marketplace:
//            OfferListingBrowser

class us
    implements Runnable
{

    final OfferListingBrowser this$0;
    final PrimeOneClickStatus val$value;

    public void run()
    {
        User.setPrimeOneClickStatus(val$value);
    }

    us()
    {
        this$0 = final_offerlistingbrowser;
        val$value = PrimeOneClickStatus.this;
        super();
    }
}
