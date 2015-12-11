// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.fis;

import com.ebay.nautilus.domain.data.CreditCard;
import com.ebay.nautilus.domain.data.DirectDebit;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;

// Referenced classes of package com.ebay.nautilus.domain.net.fis:
//            FundingInstrumentServiceResponse

public static class AccountOwner extends BaseApiResponse
{
    public static class AccountOwner
    {

        public String accountId;
        public String domainType;

        public AccountOwner()
        {
        }
    }


    public AccountOwner accountOwner;
    public DirectDebit bankAccount;
    public CreditCard creditCard;
    public String instrumentId;

    public AccountOwner()
    {
    }
}
