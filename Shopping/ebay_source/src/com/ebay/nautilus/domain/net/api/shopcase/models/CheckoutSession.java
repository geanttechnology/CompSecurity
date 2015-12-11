// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase.models;

import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopcase.models:
//            ShopCartRequestResult

public final class CheckoutSession extends BaseApiResponse
{

    public String checkoutSessionToken;
    public List extensions;
    public boolean isCartEligibleForGuestCheckout;
    public ShopCartRequestResult requestResult;

    public CheckoutSession()
    {
    }

    public int getAck()
    {
        if (requestResult != null)
        {
            return requestResult.getAck();
        } else
        {
            return -1;
        }
    }
}
