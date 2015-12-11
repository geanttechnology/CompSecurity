// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trend;

import com.ebay.nautilus.domain.data.Trend;
import com.ebay.nautilus.domain.net.EbayCosResponse;
import java.io.InputStream;

public class TrendContentResponse extends EbayCosResponse
{

    public Trend trends[];

    protected TrendContentResponse()
    {
        super(true);
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        trends = (Trend[])readJsonStream(inputstream, [Lcom/ebay/nautilus/domain/data/Trend;);
    }
}
