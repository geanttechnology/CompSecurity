// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.aeu;
import android.support.v7.aev;
import android.support.v7.aqo;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchParameters
    implements Parcelable
{
    public static final class Distance extends Enum
    {

        private static final Distance $VALUES[];
        public static final int DEFAULT_FAR = 30000;
        public static final Distance FAR;
        public static final Distance MY_AREA;
        public static final Distance MY_CITY;
        public static final Distance NEARBY;

        public static Distance valueOf(String s)
        {
            return (Distance)Enum.valueOf(com/abtnprojects/ambatana/models/SearchParameters$Distance, s);
        }

        public static Distance[] values()
        {
            return (Distance[])$VALUES.clone();
        }

        public int getQueryValue()
        {
            static class _cls2
            {

                static final int $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$Distance[];
                static final int $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$SortBy[];

                static 
                {
                    $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$SortBy = new int[SortBy.values().length];
                    try
                    {
                        $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$SortBy[SortBy.PROXIMITY.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$SortBy[SortBy.PRICE_DESC.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$SortBy[SortBy.PRICE_ASC.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$SortBy[SortBy.PUBLISH_DATE.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$Distance = new int[Distance.values().length];
                    try
                    {
                        $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$Distance[Distance.NEARBY.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$Distance[Distance.MY_AREA.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$Distance[Distance.MY_CITY.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$Distance[Distance.FAR.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls2..SwitchMap.com.abtnprojects.ambatana.models.SearchParameters.Distance[ordinal()])
            {
            default:
                return 30000;

            case 1: // '\001'
                return 1;

            case 2: // '\002'
                return 5;

            case 3: // '\003'
                return 10;
            }
        }

        public int getStringResourceId()
        {
            switch (_cls2..SwitchMap.com.abtnprojects.ambatana.models.SearchParameters.Distance[ordinal()])
            {
            default:
                return 0x7f09015f;

            case 1: // '\001'
                return 0x7f090168;

            case 2: // '\002'
                return 0x7f090162;

            case 3: // '\003'
                return 0x7f090165;
            }
        }

        static 
        {
            NEARBY = new Distance("NEARBY", 0);
            MY_AREA = new Distance("MY_AREA", 1);
            MY_CITY = new Distance("MY_CITY", 2);
            FAR = new Distance("FAR", 3);
            $VALUES = (new Distance[] {
                NEARBY, MY_AREA, MY_CITY, FAR
            });
        }

        private Distance(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class SortBy extends Enum
    {

        private static final SortBy $VALUES[];
        public static final SortBy PRICE_ASC;
        public static final SortBy PRICE_DESC;
        public static final SortBy PROXIMITY;
        public static final SortBy PUBLISH_DATE;

        public static SortBy valueOf(String s)
        {
            return (SortBy)Enum.valueOf(com/abtnprojects/ambatana/models/SearchParameters$SortBy, s);
        }

        public static SortBy[] values()
        {
            return (SortBy[])$VALUES.clone();
        }

        public String getStringEnumForRequest()
        {
            switch (_cls2..SwitchMap.com.abtnprojects.ambatana.models.SearchParameters.SortBy[ordinal()])
            {
            default:
                return "recent";

            case 1: // '\001'
                return "distance";

            case 2: // '\002'
                return "price_desc";

            case 3: // '\003'
                return "price_asc";
            }
        }

        public int getStringResourceId()
        {
            switch (_cls2..SwitchMap.com.abtnprojects.ambatana.models.SearchParameters.SortBy[ordinal()])
            {
            default:
                return 0x7f090179;

            case 1: // '\001'
                return 0x7f09017a;

            case 2: // '\002'
                return 0x7f090178;

            case 3: // '\003'
                return 0x7f090177;
            }
        }

        static 
        {
            PROXIMITY = new SortBy("PROXIMITY", 0);
            PRICE_DESC = new SortBy("PRICE_DESC", 1);
            PRICE_ASC = new SortBy("PRICE_ASC", 2);
            PUBLISH_DATE = new SortBy("PUBLISH_DATE", 3);
            $VALUES = (new SortBy[] {
                PROXIMITY, PRICE_DESC, PRICE_ASC, PUBLISH_DATE
            });
        }

        private SortBy(String s, int i)
        {
            super(s, i);
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SearchParameters createFromParcel(Parcel parcel)
        {
            return new SearchParameters(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public SearchParameters[] newArray(int i)
        {
            return new SearchParameters[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static Distance DEFAULT_SELECTED_DISTANCE;
    public static SortBy DEFAULT_SELECTED_SORT_BY;
    public static final float INVALID_PRICE = -1F;
    private static final String TAG = com/abtnprojects/ambatana/models/SearchParameters.getSimpleName();
    private List mCategoryIds;
    private Distance mDistance;
    private String mFormattedAddress;
    private double mLatitude;
    private double mLongitude;
    private float mPriceFrom;
    private float mPriceTo;
    private String mQuery;
    private SortBy mSortBy;

    public SearchParameters()
    {
        mQuery = "";
        mLatitude = 4.9406564584124654E-324D;
        mLongitude = 4.9406564584124654E-324D;
        mFormattedAddress = "";
        mCategoryIds = new ArrayList();
        mDistance = DEFAULT_SELECTED_DISTANCE;
        mPriceFrom = -1F;
        mPriceTo = -1F;
        mSortBy = DEFAULT_SELECTED_SORT_BY;
    }

    private SearchParameters(Parcel parcel)
    {
        mQuery = parcel.readString();
        mLatitude = parcel.readDouble();
        mLongitude = parcel.readDouble();
        mFormattedAddress = parcel.readString();
        mCategoryIds = parcel.readArrayList(java/lang/Integer.getClassLoader());
        mDistance = (Distance)parcel.readSerializable();
        mPriceFrom = parcel.readFloat();
        mPriceTo = parcel.readFloat();
        mSortBy = (SortBy)parcel.readSerializable();
    }


    public static SearchParameters fromJSON(String s)
    {
        aeu aeu1 = (new aev()).a();
        try
        {
            s = (SearchParameters)aeu1.a(s, com/abtnprojects/ambatana/models/SearchParameters);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public static String noCategory()
    {
        return String.valueOf(0);
    }

    public boolean areCustomParamsAvailable()
    {
        return !TextUtils.isEmpty(getQuery()) || getCategoryIds() != null && getCategoryIds().size() > 0 || mPriceFrom != -1F || mPriceTo != -1F || mLatitude != 4.9406564584124654E-324D && mLongitude != 4.9406564584124654E-324D || mDistance != DEFAULT_SELECTED_DISTANCE || mSortBy != DEFAULT_SELECTED_SORT_BY;
    }

    public int describeContents()
    {
        return 0;
    }

    public List getCategoryIds()
    {
        return mCategoryIds;
    }

    public String getCategoryIdsAsString()
    {
        if (mCategoryIds == null || mCategoryIds.size() == 0)
        {
            return null;
        } else
        {
            String s = Arrays.toString(mCategoryIds.toArray()).replace(", ", ",").replace("[", "").replace("]", "");
            aqo.a("getCategoryIdsAsString: %s", new Object[] {
                s
            });
            return s;
        }
    }

    public Distance getDistance()
    {
        return mDistance;
    }

    public String getFormattedAddress()
    {
        return mFormattedAddress;
    }

    public double getLatitude()
    {
        return mLatitude;
    }

    public double getLongitude()
    {
        return mLongitude;
    }

    public float getPriceFrom()
    {
        return mPriceFrom;
    }

    public float getPriceTo()
    {
        return mPriceTo;
    }

    public String getQuery()
    {
        return mQuery;
    }

    public SortBy getSortBy()
    {
        return mSortBy;
    }

    public boolean hasPriceFrom()
    {
        return mPriceFrom > 0.0F;
    }

    public boolean hasPriceTo()
    {
        return mPriceTo > 0.0F;
    }

    public boolean hasValidCoordinates()
    {
        return mLatitude != 4.9406564584124654E-324D && mLongitude != 4.9406564584124654E-324D;
    }

    public void setCategoryIds(List list)
    {
        mCategoryIds = list;
    }

    public void setDistance(Distance distance)
    {
        mDistance = distance;
    }

    public void setFormattedAddress(String s)
    {
        mFormattedAddress = s;
    }

    public void setLatitude(double d)
    {
        mLatitude = d;
    }

    public void setLongitude(double d)
    {
        mLongitude = d;
    }

    public void setPriceFrom(float f)
    {
        mPriceFrom = f;
    }

    public void setPriceTo(float f)
    {
        mPriceTo = f;
    }

    public void setQuery(String s)
    {
        mQuery = s;
    }

    public void setSortBy(SortBy sortby)
    {
        mSortBy = sortby;
    }

    public String toJSON()
    {
        return (new aev()).a().a(this);
    }

    public String toString()
    {
        return (new StringBuilder()).append("SearchParameters{mQuery='").append(mQuery).append('\'').append(", mLatitude=").append(mLatitude).append(", mLongitude=").append(mLongitude).append(", mCategoryIds=").append(mCategoryIds).append(", mDistance=").append(mDistance).append(", mPriceFrom=").append(mPriceFrom).append(", mPriceTo=").append(mPriceTo).append(", mSortBy=").append(mSortBy).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mQuery);
        parcel.writeDouble(mLatitude);
        parcel.writeDouble(mLongitude);
        parcel.writeString(mFormattedAddress);
        parcel.writeList(mCategoryIds);
        parcel.writeSerializable(mDistance);
        parcel.writeFloat(mPriceFrom);
        parcel.writeFloat(mPriceTo);
        parcel.writeSerializable(mSortBy);
    }

    static 
    {
        DEFAULT_SELECTED_DISTANCE = Distance.FAR;
        DEFAULT_SELECTED_SORT_BY = SortBy.PROXIMITY;
    }
}
