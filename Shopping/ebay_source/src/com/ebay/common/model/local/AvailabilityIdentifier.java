// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.local;

import android.os.Parcel;
import android.text.TextUtils;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

public final class AvailabilityIdentifier extends BaseDataMapped
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AvailabilityIdentifier createFromParcel(Parcel parcel)
        {
            return (AvailabilityIdentifier)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/local/AvailabilityIdentifier);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public AvailabilityIdentifier[] newArray(int i)
        {
            return new AvailabilityIdentifier[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    final String countryCode;
    final boolean ebnCheck;
    final String postalCode;
    final int quantity;
    final String sellerID;
    final String sku;

    public AvailabilityIdentifier(String s, String s1, String s2, String s3)
    {
        this(s, s1, s2, s3, 1);
    }

    public AvailabilityIdentifier(String s, String s1, String s2, String s3, int i)
    {
        ebnCheck = true;
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2) || TextUtils.isEmpty(s3) || i < 1)
        {
            throw new IllegalArgumentException("one or more invalid arguments");
        } else
        {
            countryCode = s;
            postalCode = s1;
            sellerID = s2;
            sku = s3;
            quantity = i;
            return;
        }
    }

    public boolean equals(Object obj)
    {
label0:
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (obj instanceof AvailabilityIdentifier)
                {
                    flag = flag1;
                    if (obj.hashCode() == hashCode())
                    {
                        obj = (AvailabilityIdentifier)obj;
                        if (!TextUtils.equals(countryCode, ((AvailabilityIdentifier) (obj)).countryCode) || !TextUtils.equals(postalCode, ((AvailabilityIdentifier) (obj)).postalCode) || !TextUtils.equals(sellerID, ((AvailabilityIdentifier) (obj)).sellerID) || !TextUtils.equals(sku, ((AvailabilityIdentifier) (obj)).sku))
                        {
                            break label0;
                        }
                        flag = true;
                    }
                }
            }
            return flag;
        }
        return false;
    }

    public int hashCode()
    {
        return ((countryCode.hashCode() * 37 + postalCode.hashCode()) * 37 + sellerID.hashCode()) * 37 + sku.hashCode();
    }

}
