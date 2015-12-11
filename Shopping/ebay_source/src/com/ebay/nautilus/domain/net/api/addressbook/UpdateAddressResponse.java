// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.addressbook;

import com.ebay.nautilus.domain.datamapping.gson.EbayDateAdapter;
import com.ebay.nautilus.domain.datamapping.gson.WrappedListAdapter;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.net.api.addressbook:
//            AddressResponseData

public final class UpdateAddressResponse extends EbayResponse
{
    public static class UpdateAddressResponseWrapper extends BaseApiResponse
    {

        public AddressResponseData data;

        public UpdateAddressResponseWrapper()
        {
        }
    }


    private static final Gson MAPPER = (new GsonBuilder()).excludeFieldsWithModifiers(new int[] {
        8, 128, 64
    }).registerTypeAdapter(java/util/Date, new EbayDateAdapter()).registerTypeAdapter((new TypeToken() {

    }).getType(), new WrappedListAdapter("attribute")).create();
    private AddressResponseData responseData;

    public UpdateAddressResponse()
    {
    }

    public AddressResponseData getResponseData()
    {
        return responseData;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        responseData = ((UpdateAddressResponseWrapper)readStream(MAPPER, inputstream, com/ebay/nautilus/domain/net/api/addressbook/UpdateAddressResponse$UpdateAddressResponseWrapper)).data;
    }

}
