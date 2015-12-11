// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShoppingCart

public static final class phone extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.ping.BaseDataMapped CREATOR = new android.os.Parcelable.Creator() {

        public ShoppingCart.Address createFromParcel(Parcel parcel)
        {
            return (ShoppingCart.Address)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShoppingCart$Address);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShoppingCart.Address[] newArray(int i)
        {
            return new ShoppingCart.Address[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final _cls1.newArray UNKNOWN = new <init>();
    public final String addressId;
    public final String city;
    public final String country;
    public final String county;
    public final String name;
    public final String phone;
    public final String postalCode;
    public final String stateOrProvince;
    public final String streetLine1;
    public final String streetLine2;


    public _cls1()
    {
        this(null, null, null, null, null, null, null, null, null, null);
    }

    public <init>(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9)
    {
        if (s == null)
        {
            s = "";
        }
        addressId = s;
        if (s1 == null)
        {
            s1 = "";
        }
        name = s1;
        if (s2 == null)
        {
            s2 = "";
        }
        streetLine1 = s2;
        if (s3 == null)
        {
            s3 = "";
        }
        streetLine2 = s3;
        if (s4 == null)
        {
            s4 = "";
        }
        city = s4;
        if (s5 == null)
        {
            s5 = "";
        }
        county = s5;
        if (s6 == null)
        {
            s6 = "";
        }
        stateOrProvince = s6;
        if (s7 == null)
        {
            s7 = "";
        }
        country = s7;
        if (s8 == null)
        {
            s8 = "";
        }
        postalCode = s8;
        if (s9 == null)
        {
            s9 = "";
        }
        phone = s9;
    }
}
