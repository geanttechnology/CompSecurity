// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase;

import com.ebay.nautilus.domain.net.EbayCosResponse;
import com.ebay.nautilus.domain.net.api.shopcase.models.CheckoutSession;
import java.io.InputStream;

public final class ShopcaseCheckoutSessionResponse extends EbayCosResponse
{

    public CheckoutSession checkoutSession;

    public ShopcaseCheckoutSessionResponse()
    {
        super(true);
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        checkoutSession = (CheckoutSession)readJsonStream(inputstream, com/ebay/nautilus/domain/net/api/shopcase/models/CheckoutSession);
    }
}
