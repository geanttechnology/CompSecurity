// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shippinglabel;

import com.ebay.nautilus.domain.data.LabelWorkOrder;
import com.ebay.nautilus.domain.net.EbayCosResponse;
import java.io.InputStream;

public class GenerateShippingLabelResponse extends EbayCosResponse
{

    public LabelWorkOrder workOrder;

    protected GenerateShippingLabelResponse()
    {
        super(true);
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        ackCode = 1;
        workOrder = (LabelWorkOrder)readJsonStream(inputstream, com/ebay/nautilus/domain/data/LabelWorkOrder);
    }
}
