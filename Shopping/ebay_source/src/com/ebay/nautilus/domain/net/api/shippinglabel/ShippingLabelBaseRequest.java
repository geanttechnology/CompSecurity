// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippinglabel;

import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;

public abstract class ShippingLabelBaseRequest extends EbayCosRequest
{

    protected static String SHIPPING_LABEL_OPERATION_NAME = "draftlabel";
    protected static String SHIPPING_LABEL_SERVICE_NAME = "DraftLabelService";

    protected ShippingLabelBaseRequest(String s, String s1)
    {
        super(s, s1, CosVersionType.V2);
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
    }

    protected boolean isIdempotent()
    {
        return true;
    }

}
