// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas.models;

import android.net.Uri;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.net.api.ecas.EcasErrorHandler;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas.models:
//            EcasCheckoutResponse

public class EcasCheckoutSessionAdapter
{

    private final EcasErrorHandler errorHandler;
    private final EcasCheckoutResponse wireModel;

    public EcasCheckoutSessionAdapter(EcasCheckoutResponse ecascheckoutresponse)
    {
        wireModel = ecascheckoutresponse;
        errorHandler = new EcasErrorHandler(com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action.CREATE_CHECKOUT_SESSION, null);
    }

    public static Content toContentModel(EcasCheckoutResponse ecascheckoutresponse)
    {
        return (new EcasCheckoutSessionAdapter(ecascheckoutresponse)).toContentModel();
    }

    public com.ebay.nautilus.domain.data.ShoppingCart.CheckoutSession toAppModel()
    {
        if (wireModel == null)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.CheckoutSession.UNKNOWN;
        }
        errorHandler.addMessage(wireModel.errorMessage);
        Uri uri;
        if (wireModel.sessionUrl != null)
        {
            uri = Uri.parse(wireModel.sessionUrl);
        } else
        {
            uri = Uri.EMPTY;
        }
        return new com.ebay.nautilus.domain.data.ShoppingCart.CheckoutSession(wireModel.sessionToken, wireModel.sessionType, uri, wireModel.isEligibleForGuestCheckout);
    }

    public Content toContentModel()
    {
        return new Content(toAppModel(), errorHandler.getResultStatus());
    }
}
