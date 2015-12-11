// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.addressbook;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;

public final class AddressResponseData extends BaseApiResponse
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AddressResponseData createFromParcel(Parcel parcel)
        {
            return (AddressResponseData)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/net/api/addressbook/AddressResponseData);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public AddressResponseData[] newArray(int i)
        {
            return new AddressResponseData[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public com.ebay.nautilus.domain.data.Address.AddressFields addressFieldValues;
    public String addressId;
    public boolean addressModified;
    public boolean addressValidated;
    public AddAddressResponse.ModifiedFields modifiedFields;

    public AddressResponseData()
    {
    }

    public Address getAddress()
    {
        if (addressFieldValues == null)
        {
            return null;
        } else
        {
            return new Address(addressId, "Shipping", addressFieldValues);
        }
    }

}
