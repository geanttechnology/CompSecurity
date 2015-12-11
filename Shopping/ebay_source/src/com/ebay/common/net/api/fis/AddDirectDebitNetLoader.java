// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.fis;

import com.ebay.nautilus.domain.data.DirectDebit;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.fis.AddDirectDebitRequest;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.fis:
//            FundingInstrumentServiceNetLoader

public class AddDirectDebitNetLoader extends FundingInstrumentServiceNetLoader
{

    protected final DirectDebit directDebit;
    protected final String iafToken;

    public AddDirectDebitNetLoader(EbayContext ebaycontext, String s, DirectDebit directdebit)
    {
        super(ebaycontext);
        iafToken = s;
        directDebit = directdebit;
    }

    protected EbayRequest createRequest()
    {
        return new AddDirectDebitRequest(iafToken, directDebit);
    }
}
