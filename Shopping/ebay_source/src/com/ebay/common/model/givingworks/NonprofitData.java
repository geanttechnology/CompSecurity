// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.givingworks;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.ArrayList;
import java.util.List;

public class NonprofitData extends BaseApiResponse
    implements Parcelable
{
    public static class Nonprofit extends BaseDataMapped
        implements Parcelable, Comparable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Nonprofit createFromParcel(Parcel parcel)
            {
                return (Nonprofit)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/givingworks/NonprofitData$Nonprofit);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public Nonprofit[] newArray(int i)
            {
                return new Nonprofit[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public Address address;
        public String externalId;
        public int favoriteCount;
        public String largeLogoUrl;
        public String logoUrl;
        public String mission;
        public String name;
        public String nonprofitId;

        public int compareTo(Nonprofit nonprofit)
        {
            if (nonprofit == null || nonprofit.name == null)
            {
                return 1;
            }
            if (name == null)
            {
                return -1;
            } else
            {
                return name.compareTo(nonprofit.name);
            }
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((Nonprofit)obj);
        }

        public String getLocationString()
        {
            if (address == null)
            {
                return null;
            }
            StringBuilder stringbuilder = new StringBuilder();
            if (!TextUtils.isEmpty(address.city))
            {
                stringbuilder.append(address.city);
            }
            if (!TextUtils.isEmpty(address.state))
            {
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append(", ");
                }
                stringbuilder.append(address.state);
            }
            return stringbuilder.toString();
        }

        public String getLogoUrl()
        {
            if (TextUtils.isEmpty(largeLogoUrl))
            {
                return logoUrl;
            } else
            {
                return largeLogoUrl;
            }
        }


        public Nonprofit()
        {
            address = new Address();
        }
    }

    public static class Nonprofit.Address
    {

        public String city;
        public String state;

        public Nonprofit.Address()
        {
        }
    }

    public static class PaginationOutput
    {

        public int totalEntries;

        public PaginationOutput()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NonprofitData createFromParcel(Parcel parcel)
        {
            return (NonprofitData)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/givingworks/NonprofitData);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public NonprofitData[] newArray(int i)
        {
            return new NonprofitData[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final List nonprofits = new ArrayList();
    public final PaginationOutput paginationOutput = new PaginationOutput();

    public NonprofitData()
    {
    }

}
