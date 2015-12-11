// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.addressbook;

import com.ebay.nautilus.domain.datamapping.gson.EbayDateAdapter;
import com.ebay.nautilus.domain.datamapping.gson.WrappedListAdapter;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ResponseWrapper;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.net.api.addressbook:
//            AddressResponseData

public final class AddAddressResponse extends EbayResponse
{
    private static class AddAddressResponseWrapper extends BaseApiResponse
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

        private AddAddressResponseWrapper()
        {
        }
    }

    public static class ModifiedFields
    {

        public boolean addressLine1Changed;
        public boolean addressLine2Changed;
        public boolean cityChanged;
        public boolean contactNameChanged;
        public boolean countryChanged;
        public boolean phoneNoChanged;
        public boolean postalCodeChanged;
        public boolean stateChanged;

        public ModifiedFields()
        {
        }
    }


    private static final Gson MAPPER = (new GsonBuilder()).excludeFieldsWithModifiers(new int[] {
        8, 128, 64
    }).registerTypeAdapter(java/util/Date, new EbayDateAdapter()).registerTypeAdapter((new TypeToken() {

    }).getType(), new WrappedListAdapter("attribute")).create();
    private AddressResponseData responseData;

    public AddAddressResponse()
    {
    }

    public AddressResponseData getResponseData()
    {
        return responseData;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        inputstream = (AddAddressResponseWrapper)readStream(MAPPER, inputstream, com/ebay/nautilus/domain/net/api/addressbook/AddAddressResponse$AddAddressResponseWrapper);
        if (inputstream != null)
        {
            responseData = inputstream.getResponse();
        }
    }

}
