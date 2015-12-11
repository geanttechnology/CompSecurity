// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.payment;

import com.ebay.nautilus.domain.data.experience.type.base.TextualDisplayValue;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.data.experience.checkout.payment:
//            ExchangeRate, InstrumentDetails

public class FundingSource
{

    public String accountNumber;
    public Map actions;
    public String additionalText;
    public TextualDisplayValue amount;
    public FundingSource backupFundingSource;
    public String description;
    public ExchangeRate exchangeRate;
    public String fundingSourceId;
    public InstrumentDetails instrumentDetails;
    public String label;
    public String legendText;
    public boolean selected;
    public String subType;
    public String type;

    public FundingSource()
    {
    }
}
