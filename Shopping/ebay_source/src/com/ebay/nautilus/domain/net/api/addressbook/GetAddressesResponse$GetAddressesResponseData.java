// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.addressbook;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.addressbook:
//            GetAddressesResponse

public static class _cls1 extends BaseApiResponse
    implements Parcelable
{

    public static final android.os.Response.GetAddressesResponseData CREATOR = new android.os.Parcelable.Creator() {

        public GetAddressesResponse.GetAddressesResponseData createFromParcel(Parcel parcel)
        {
            return (GetAddressesResponse.GetAddressesResponseData)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/net/api/addressbook/GetAddressesResponse$GetAddressesResponseData);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public GetAddressesResponse.GetAddressesResponseData[] newArray(int i)
        {
            return new GetAddressesResponse.GetAddressesResponseData[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public int addressCount;
    public List userAddress;


    public _cls1()
    {
    }
}
