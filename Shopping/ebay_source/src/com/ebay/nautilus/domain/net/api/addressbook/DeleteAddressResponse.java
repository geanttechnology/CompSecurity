// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.addressbook;

import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.io.InputStream;

// Referenced classes of package com.ebay.nautilus.domain.net.api.addressbook:
//            AddressResponseData

public final class DeleteAddressResponse extends EbayResponse
{
    public static class DeleteAddressResponseWrapper extends BaseApiResponse
    {

        public AddressResponseData data;

        public DeleteAddressResponseWrapper()
        {
        }
    }


    private AddressResponseData responseData;

    public DeleteAddressResponse()
    {
    }

    public AddressResponseData getResponseData()
    {
        return responseData;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        responseData = ((DeleteAddressResponseWrapper)readJsonStream(inputstream, com/ebay/nautilus/domain/net/api/addressbook/DeleteAddressResponse$DeleteAddressResponseWrapper)).data;
    }
}
