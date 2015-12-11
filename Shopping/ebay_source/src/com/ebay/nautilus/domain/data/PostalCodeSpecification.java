// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

public final class PostalCodeSpecification extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PostalCodeSpecification createFromParcel(Parcel parcel)
        {
            return (PostalCodeSpecification)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/PostalCodeSpecification);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public PostalCodeSpecification[] newArray(int i)
        {
            return new PostalCodeSpecification[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String countryCode;
    public String postalCode;
    public String stateOrProvince;

    public PostalCodeSpecification()
    {
        countryCode = "";
        postalCode = "";
    }

    public PostalCodeSpecification(String s)
    {
        Object obj = null;
        super();
        countryCode = "";
        postalCode = "";
        if (s != null)
        {
            String as[] = s.split("\n");
            countryCode = as[0];
            if (as.length > 1)
            {
                s = as[1];
            } else
            {
                s = null;
            }
            postalCode = s;
            s = obj;
            if (as.length > 2)
            {
                s = as[2];
            }
            stateOrProvince = s;
        }
    }

    public PostalCodeSpecification(String s, String s1, String s2)
    {
        countryCode = "";
        postalCode = "";
        countryCode = s;
        if (s1 == null)
        {
            s = null;
        } else
        {
            s = s1.trim();
        }
        postalCode = s;
        if (TextUtils.equals(countryCode, EbaySite.US.localeCountry) && !TextUtils.isEmpty(postalCode) && postalCode.length() > 5)
        {
            postalCode = postalCode.substring(0, 5);
        }
        stateOrProvince = s2;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof PostalCodeSpecification))
        {
            if (countryCode.equals(((PostalCodeSpecification) (obj = (PostalCodeSpecification)obj)).countryCode) && (postalCode == null && ((PostalCodeSpecification) (obj)).postalCode == null || postalCode != null && postalCode.equals(((PostalCodeSpecification) (obj)).postalCode)) && (stateOrProvince == null && ((PostalCodeSpecification) (obj)).stateOrProvince == null || stateOrProvince != null && stateOrProvince.equals(((PostalCodeSpecification) (obj)).stateOrProvince)))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        int j = (countryCode.hashCode() + 1147) * 31 + postalCode.hashCode();
        int i = j;
        if (stateOrProvince != null)
        {
            i = j * 31 + stateOrProvince.hashCode();
        }
        return i;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (!TextUtils.isEmpty(countryCode))
        {
            stringbuilder.append(countryCode);
        }
        stringbuilder.append('\n');
        if (!TextUtils.isEmpty(postalCode))
        {
            stringbuilder.append(postalCode);
        }
        stringbuilder.append('\n');
        if (!TextUtils.isEmpty(stateOrProvince))
        {
            stringbuilder.append(stateOrProvince);
        }
        return stringbuilder.toString();
    }

}
