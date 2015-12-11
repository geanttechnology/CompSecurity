// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.addressbook;

import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;

// Referenced classes of package com.ebay.nautilus.domain.net.api.addressbook:
//            EbayAddressBookRequest, DeleteAddressResponse, EbayAddressBookApi

public final class DeleteAddressRequest extends EbayAddressBookRequest
{
    public static class RequestWrapper
    {

        private final DeleteAddressRequest request;

        public RequestWrapper(DeleteAddressRequest deleteaddressrequest)
        {
            request = deleteaddressrequest;
        }
    }


    public static final String OPERATION_NAME = "removeAddress";
    public final String addressId;

    protected DeleteAddressRequest()
    {
        super(null, "removeAddress");
        addressId = null;
    }

    public DeleteAddressRequest(EbayAddressBookApi ebayaddressbookapi, String s)
    {
        super(ebayaddressbookapi, "removeAddress");
        addressId = s;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return DataMapperFactory.getDefaultMapper().toJson(new RequestWrapper(this)).getBytes();
    }

    public DeleteAddressResponse getResponse()
    {
        return new DeleteAddressResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
