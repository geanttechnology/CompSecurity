// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.Date;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartApi

public class SetPaymentMethodNetLoader extends EbaySimpleNetLoader
{

    private final String addressId;
    private final EbayCartApi api;
    private final String cartId;
    private final Date dateOfBirth;
    private final String instrumentRefId;
    private final Boolean paymentAgreementAccepted;
    private final String paymentMethodName;
    private final boolean shouldRemember;
    private final String strategyChoiceId;

    public SetPaymentMethodNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, String s, String s1, String s2, String s3, boolean flag, 
            Boolean boolean1, Date date, String s4)
    {
        super(ebaycontext);
        api = ebaycartapi;
        cartId = s;
        paymentMethodName = s1;
        instrumentRefId = s2;
        strategyChoiceId = s3;
        shouldRemember = flag;
        paymentAgreementAccepted = boolean1;
        dateOfBirth = date;
        addressId = s4;
    }

    protected EbayRequest createRequest()
    {
        return new SetPaymentMethod.SetPaymentMethodRequest(api, cartId, paymentMethodName, instrumentRefId, strategyChoiceId, shouldRemember, paymentAgreementAccepted, dateOfBirth, addressId);
    }

    public boolean isServiceError()
    {
        return false;
    }
}
