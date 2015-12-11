// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.addressbook;

import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;

// Referenced classes of package com.ebay.nautilus.domain.net.api.addressbook:
//            EbayAddressBookRequest, AddAddressResponse, EbayAddressBookApi

public final class AddAddressRequest extends EbayAddressBookRequest
{
    public static class RequestWrapper
    {

        private final AddAddressRequest request;

        public RequestWrapper(AddAddressRequest addaddressrequest)
        {
            request = addaddressrequest;
        }
    }


    public static final String OPERATION_NAME = "addAddress";
    public final com.ebay.nautilus.domain.data.Address.AddressFields addressFieldValues;
    public String addressType;
    public final boolean addressValidationRequired;

    protected AddAddressRequest()
    {
        super(null, "addAddress");
        addressType = "Shipping";
        addressFieldValues = null;
        addressValidationRequired = false;
    }

    public AddAddressRequest(EbayAddressBookApi ebayaddressbookapi, Address address, boolean flag)
    {
        super(ebayaddressbookapi, "addAddress");
        addressType = "Shipping";
        addressFieldValues = address.addressFields;
        addressValidationRequired = flag;
    }

    public AddAddressRequest(EbayAddressBookApi ebayaddressbookapi, Address address, boolean flag, String s)
    {
        super(ebayaddressbookapi, "addAddress");
        addressType = "Shipping";
        addressType = s;
        addressFieldValues = address.addressFields;
        addressValidationRequired = flag;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return DataMapperFactory.getDefaultMapper().toJson(new RequestWrapper(this)).getBytes();
    }

    public AddAddressResponse getResponse()
    {
        return new AddAddressResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
