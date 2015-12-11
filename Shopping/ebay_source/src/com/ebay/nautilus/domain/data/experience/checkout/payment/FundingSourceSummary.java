// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.payment;

import com.ebay.nautilus.domain.data.experience.type.base.TextualDisplayValue;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data.experience.checkout.payment:
//            FundingSource

public class FundingSourceSummary
{

    public TextualDisplayValue amount;
    public FundingSource backupFundingSource;
    public List fundingSources;
    public String label;

    public FundingSourceSummary()
    {
    }
}
