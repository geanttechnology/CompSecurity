// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas;

import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;

public abstract class EcasApiResponse extends EbayResponse
{

    public BaseApiResponse casResponse;

    public EcasApiResponse()
    {
    }

    protected void setCasResponse(BaseApiResponse baseapiresponse)
    {
        casResponse = baseapiresponse;
    }
}
