// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.fis;

import com.ebay.nautilus.domain.data.CreditCard;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.fis.UpdateCreditCardRequest;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.fis:
//            FundingInstrumentServiceNetLoader

public class UpdateCreditCardNetLoader extends FundingInstrumentServiceNetLoader
{

    private final CreditCard creditCard;
    private final String fundingInstrumentId;
    private final String iafToken;

    public UpdateCreditCardNetLoader(EbayContext ebaycontext, String s, String s1, CreditCard creditcard)
    {
        super(ebaycontext);
        iafToken = s;
        fundingInstrumentId = s1;
        creditCard = creditcard;
    }

    protected EbayRequest createRequest()
    {
        return new UpdateCreditCardRequest(iafToken, fundingInstrumentId, creditCard);
    }
}
