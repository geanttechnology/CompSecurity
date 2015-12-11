// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shippinglabel;

import com.ebay.nautilus.domain.data.ShippingLabelPdfContainer;
import com.ebay.nautilus.domain.datamapping.gson.Base64ByteArrayAdapter;
import com.ebay.nautilus.domain.net.EbayCosResponse;
import com.google.gson.GsonBuilder;
import java.io.InputStream;

public class GetShippingLabelResponse extends EbayCosResponse
{

    public ShippingLabelPdfContainer label;

    protected GetShippingLabelResponse()
    {
        super(true);
    }

    protected void addGsonBuilderProperties(GsonBuilder gsonbuilder)
    {
        gsonbuilder.registerTypeAdapter([B, new Base64ByteArrayAdapter());
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        ackCode = 1;
        label = (ShippingLabelPdfContainer)readJsonStream(inputstream, com/ebay/nautilus/domain/data/ShippingLabelPdfContainer);
    }
}
