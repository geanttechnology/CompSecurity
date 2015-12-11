// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippinglabel;

import com.ebay.nautilus.domain.data.ShippingLabelContact;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippinglabel:
//            UpdateDraftShippingLabelAddressRequest

private static final class addressType
{

    private final ShippingLabelContact address;
    private final com.ebay.nautilus.domain.data.belRequestParams addressType;

    public (ShippingLabelContact shippinglabelcontact, com.ebay.nautilus.domain.data.belRequestParams belrequestparams)
    {
        address = shippinglabelcontact;
        addressType = belrequestparams;
    }
}
