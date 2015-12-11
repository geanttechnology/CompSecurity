// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.addressbook;

import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;

// Referenced classes of package com.ebay.nautilus.domain.net.api.addressbook:
//            EbayAddressBookRequest, GetAddressesResponse, EbayAddressBookApi

public final class GetAddressesRequest extends EbayAddressBookRequest
{
    public static class RequestWrapper
    {

        private final GetAddressesRequest request;

        public RequestWrapper(GetAddressesRequest getaddressesrequest)
        {
            request = getaddressesrequest;
        }
    }


    public static final String OPERATION_NAME = "getAddresses";
    public String addressType;
    public final String noOfAddressesToBeReturned;

    protected GetAddressesRequest()
    {
        super(null, "getAddresses");
        noOfAddressesToBeReturned = null;
    }

    public GetAddressesRequest(EbayAddressBookApi ebayaddressbookapi, boolean flag, String s)
    {
        super(ebayaddressbookapi, "getAddresses");
        addressType = s;
        if (!flag)
        {
            noOfAddressesToBeReturned = null;
            return;
        } else
        {
            noOfAddressesToBeReturned = "1";
            return;
        }
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return DataMapperFactory.getDefaultMapper().toJson(new RequestWrapper(this)).getBytes();
    }

    public GetAddressesResponse getResponse()
    {
        return new GetAddressesResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
