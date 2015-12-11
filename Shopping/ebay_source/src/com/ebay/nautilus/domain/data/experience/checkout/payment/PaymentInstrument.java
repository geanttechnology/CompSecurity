// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.payment;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.data.experience.checkout.payment:
//            FundingSource, AccountDetails, FundingSourceSummary, PaymentInstrumentIdentifier

public class PaymentInstrument
{

    public AccountDetails accountDetails;
    public String accountName;
    public Map actions;
    public List fixedFundingSources;
    public FundingSourceSummary fundingSourceSummary;
    public PaymentInstrumentIdentifier identifier;
    public String paymentInstrumentId;
    public List selectableFundingSources;
    public boolean selected;

    public PaymentInstrument()
    {
    }

    public FundingSource getSelectedFundingSource()
    {
        if (selectableFundingSources == null)
        {
            return null;
        }
        for (Iterator iterator = selectableFundingSources.iterator(); iterator.hasNext();)
        {
            FundingSource fundingsource = (FundingSource)iterator.next();
            if (fundingsource.selected)
            {
                return fundingsource;
            }
        }

        return null;
    }
}
