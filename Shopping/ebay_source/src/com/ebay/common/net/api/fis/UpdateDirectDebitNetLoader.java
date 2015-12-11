// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.fis;

import com.ebay.nautilus.domain.data.DirectDebit;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.fis.UpdateDirectDebitRequest;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.fis:
//            FundingInstrumentServiceNetLoader

public class UpdateDirectDebitNetLoader extends FundingInstrumentServiceNetLoader
{

    private final DirectDebit directDebit;
    private final String fundingInstrumentId;
    private final String iafToken;

    public UpdateDirectDebitNetLoader(EbayContext ebaycontext, String s, String s1, DirectDebit directdebit)
    {
        super(ebaycontext);
        iafToken = s;
        fundingInstrumentId = s1;
        directDebit = directdebit;
    }

    protected EbayRequest createRequest()
    {
        return new UpdateDirectDebitRequest(iafToken, fundingInstrumentId, directDebit);
    }
}
