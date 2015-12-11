// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.net.api.shopcase.models.CheckoutSession;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopcase:
//            ShopcaseErrorHandler

public class ShopcaseCheckoutSessionMapper
{

    private final ShopcaseErrorHandler errorHandler;
    private final CheckoutSession wireModel;

    public ShopcaseCheckoutSessionMapper(CheckoutSession checkoutsession)
    {
        wireModel = checkoutsession;
        errorHandler = new ShopcaseErrorHandler(com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action.CREATE_CHECKOUT_SESSION, null, null);
    }

    public com.ebay.nautilus.domain.data.ShoppingCart.CheckoutSession toAppModel()
    {
        if (wireModel == null)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.CheckoutSession.UNKNOWN;
        } else
        {
            errorHandler.addErrors(wireModel.getErrors());
            return new com.ebay.nautilus.domain.data.ShoppingCart.CheckoutSession(wireModel.checkoutSessionToken, null, null, wireModel.isCartEligibleForGuestCheckout);
        }
    }

    public Content toContentModel()
    {
        return new Content(toAppModel(), errorHandler.getResultStatus());
    }
}
