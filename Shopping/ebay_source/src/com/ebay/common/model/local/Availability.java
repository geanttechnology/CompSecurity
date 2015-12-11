// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.local;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.ArrayList;
import java.util.Calendar;

public class Availability extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Availability createFromParcel(Parcel parcel)
        {
            return (Availability)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/local/Availability);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Availability[] newArray(int i)
        {
            return new Availability[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public boolean availability;
    public String countryCode;
    public String ebnZoneID;
    public ArrayList ebnZoneLocationIDs;
    public Calendar estimatedPickupTime;
    public String postalCode;
    public String sellerID;
    public String sku;

    public Availability()
    {
    }

    public boolean equals(Object obj)
    {
        boolean flag2 = true;
        boolean flag3 = false;
        boolean flag;
        if (this == obj)
        {
            flag = true;
        } else
        {
            flag = flag3;
            if (obj != null)
            {
                flag = flag3;
                if (getClass() == obj.getClass())
                {
                    flag = flag3;
                    if (obj instanceof Availability)
                    {
                        obj = (Availability)obj;
                        boolean flag1;
                        if (TextUtils.equals(countryCode, ((Availability) (obj)).countryCode) && TextUtils.equals(postalCode, ((Availability) (obj)).postalCode) && TextUtils.equals(sellerID, ((Availability) (obj)).sellerID) && TextUtils.equals(sku, ((Availability) (obj)).sku) && TextUtils.equals(ebnZoneID, ((Availability) (obj)).ebnZoneID))
                        {
                            flag1 = flag2;
                        } else
                        {
                            flag1 = false;
                        }
                        return flag1;
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        int i1 = 0;
        int i;
        int j;
        int k;
        int l;
        if (countryCode == null)
        {
            i = 0;
        } else
        {
            i = countryCode.hashCode();
        }
        if (ebnZoneID == null)
        {
            j = 0;
        } else
        {
            j = ebnZoneID.hashCode();
        }
        if (postalCode == null)
        {
            k = 0;
        } else
        {
            k = postalCode.hashCode();
        }
        if (sellerID == null)
        {
            l = 0;
        } else
        {
            l = sellerID.hashCode();
        }
        if (sku != null)
        {
            i1 = sku.hashCode();
        }
        return ((((i + 31) * 31 + j) * 31 + k) * 31 + l) * 31 + i1;
    }

    public boolean isAvailable()
    {
        return ebnZoneLocationIDs != null && ebnZoneLocationIDs.size() > 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Availability [countryCode=").append(countryCode).append(", postalCode=").append(postalCode).append(", sellerID=").append(sellerID).append(", sku=").append(sku).append(", ebnZoneID=").append(ebnZoneID).append(", estimatedPickupTime=").append(estimatedPickupTime).append(", ebnZoneLocationIDs=").append(ebnZoneLocationIDs).append("]").toString();
    }

}
