// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.addressbook;

import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;

// Referenced classes of package com.ebay.nautilus.domain.net.api.addressbook:
//            EbayAddressBookRequest, SetPrimaryAddressResponse, EbayAddressBookApi

public final class SetPrimaryAddressRequest extends EbayAddressBookRequest
{
    public static class RequestWrapper
    {

        private final SetPrimaryAddressRequest request;

        public RequestWrapper(SetPrimaryAddressRequest setprimaryaddressrequest)
        {
            request = setprimaryaddressrequest;
        }
    }


    public static final String OPERATION_NAME = "setPrimaryAddress";
    public final String addressId;
    public final String addressType;

    protected SetPrimaryAddressRequest()
    {
        super(null, "setPrimaryAddress");
        addressId = null;
        addressType = null;
    }

    public SetPrimaryAddressRequest(EbayAddressBookApi ebayaddressbookapi, String s, String s1)
    {
        super(ebayaddressbookapi, "setPrimaryAddress");
        addressId = s;
        addressType = s1;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return DataMapperFactory.getDefaultMapper().toJson(new RequestWrapper(this)).getBytes();
    }

    public SetPrimaryAddressResponse getResponse()
    {
        return new SetPrimaryAddressResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
