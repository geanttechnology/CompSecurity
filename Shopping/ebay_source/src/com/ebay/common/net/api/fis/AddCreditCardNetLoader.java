// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.fis;

import com.ebay.nautilus.domain.data.CreditCard;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.fis.AddCreditCardRequest;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.fis:
//            FundingInstrumentServiceNetLoader

public class AddCreditCardNetLoader extends FundingInstrumentServiceNetLoader
{

    protected final CreditCard creditCard;
    protected final String iafToken;

    public AddCreditCardNetLoader(EbayContext ebaycontext, String s, CreditCard creditcard)
    {
        super(ebaycontext);
        iafToken = s;
        creditCard = creditcard;
    }

    protected EbayRequest createRequest()
    {
        return new AddCreditCardRequest(iafToken, creditCard);
    }
}
