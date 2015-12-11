// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.addressbook;

import com.ebay.nautilus.domain.net.ResponseWrapper;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;

// Referenced classes of package com.ebay.nautilus.domain.net.api.addressbook:
//            AddAddressResponse, AddressResponseData

private static class  extends BaseApiResponse
    implements ResponseWrapper
{

    private AddressResponseData data;

    public AddressResponseData getResponse()
    {
        return data;
    }

    public volatile BaseApiResponse getResponse()
    {
        return getResponse();
    }

    private ()
    {
    }
}
