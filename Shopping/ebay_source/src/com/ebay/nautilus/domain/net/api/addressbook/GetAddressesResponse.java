// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.addressbook;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.datamapping.gson.EbayDateAdapter;
import com.ebay.nautilus.domain.datamapping.gson.WrappedListAdapter;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ResponseWrapper;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class GetAddressesResponse extends EbayResponse
{
    public static class GetAddressesResponseData extends BaseApiResponse
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public GetAddressesResponseData createFromParcel(Parcel parcel)
            {
                return (GetAddressesResponseData)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/net/api/addressbook/GetAddressesResponse$GetAddressesResponseData);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public GetAddressesResponseData[] newArray(int i)
            {
                return new GetAddressesResponseData[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public int addressCount;
        public List userAddress;


        public GetAddressesResponseData()
        {
        }
    }

    public static class GetAddressesResponseWrapper extends BaseApiResponse
        implements ResponseWrapper
    {

        protected GetAddressesResponseData data;

        public GetAddressesResponseData getResponse()
        {
            return data;
        }

        public volatile BaseApiResponse getResponse()
        {
            return getResponse();
        }

        public GetAddressesResponseWrapper()
        {
        }
    }


    private static final Gson MAPPER = (new GsonBuilder()).excludeFieldsWithModifiers(new int[] {
        8, 128, 64
    }).registerTypeAdapter(java/util/Date, new EbayDateAdapter()).registerTypeAdapter((new TypeToken() {

    }).getType(), new WrappedListAdapter("attribute")).create();
    private GetAddressesResponseData responseData;

    public GetAddressesResponse()
    {
    }

    public List getAddresses()
    {
        if (responseData != null && responseData.userAddress != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((List) (obj));
_L2:
        ArrayList arraylist = new ArrayList();
        Iterator iterator = responseData.userAddress.iterator();
        do
        {
            obj = arraylist;
            if (!iterator.hasNext())
            {
                continue;
            }
            arraylist.add((Address)iterator.next());
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public GetAddressesResponseData getResponse()
    {
        return responseData;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        responseData = ((GetAddressesResponseWrapper)readStream(MAPPER, inputstream, com/ebay/nautilus/domain/net/api/addressbook/GetAddressesResponse$GetAddressesResponseWrapper)).getResponse();
    }

}
