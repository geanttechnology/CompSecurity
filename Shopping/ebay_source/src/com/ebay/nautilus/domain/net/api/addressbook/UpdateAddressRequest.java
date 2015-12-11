// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.addressbook;

import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;

// Referenced classes of package com.ebay.nautilus.domain.net.api.addressbook:
//            EbayAddressBookRequest, UpdateAddressResponse, EbayAddressBookApi

public final class UpdateAddressRequest extends EbayAddressBookRequest
{
    public static class RequestWrapper
    {

        private final UpdateAddressRequest request;

        public RequestWrapper(UpdateAddressRequest updateaddressrequest)
        {
            request = updateaddressrequest;
        }
    }


    public static final String OPERATION_NAME = "updateAddress";
    public final com.ebay.nautilus.domain.data.Address.AddressFields addressFieldValues;
    public final String addressId;
    public final String addressType;
    public final boolean addressvalidationRequired;
    public final boolean makePrimary;

    protected UpdateAddressRequest()
    {
        super(null, "updateAddress");
        addressId = null;
        addressFieldValues = null;
        addressvalidationRequired = false;
        makePrimary = false;
        addressType = null;
    }

    public UpdateAddressRequest(EbayAddressBookApi ebayaddressbookapi, Address address, boolean flag)
    {
        super(ebayaddressbookapi, "updateAddress");
        addressId = address.getAddressId();
        addressFieldValues = address.addressFields;
        addressvalidationRequired = flag;
        makePrimary = address.isDefault();
        addressType = address.addressType;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return DataMapperFactory.getDefaultMapper().toJson(new RequestWrapper(this)).getBytes();
    }

    public UpdateAddressResponse getResponse()
    {
        return new UpdateAddressResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
