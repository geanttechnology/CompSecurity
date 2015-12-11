// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.common.Address;
import com.target.mothership.model.common.Coordinates;
import com.target.mothership.model.common.Geofence;
import com.target.mothership.model.store.handler.TGTStore;
import com.target.mothership.model.store.interfaces.StoreSummary;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CacheStoreSummary extends TGTStore
    implements Parcelable, StoreSummary
{
    private static class CacheAddress
        implements Parcelable, Address
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public CacheAddress createFromParcel(Parcel parcel)
            {
                return new CacheAddress(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public CacheAddress[] newArray(int i)
            {
                return new CacheAddress[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        private List mAddressLines;
        private String mCity;
        private String mCountry;
        private String mCounty;
        private String mFormattedAddress;
        private String mPostalCode;
        private String mStateOrProvince;

        public int describeContents()
        {
            return 0;
        }

        public List getAddressLines()
        {
            return mAddressLines;
        }

        public String getCity()
        {
            return mCity;
        }

        public String getCountry()
        {
            return mCountry;
        }

        public String getCounty()
        {
            return mCounty;
        }

        public String getFormattedAddress()
        {
            return mFormattedAddress;
        }

        public String getPostalCode()
        {
            return mPostalCode;
        }

        public String getStateOrProvince()
        {
            return mStateOrProvince;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeStringList(mAddressLines);
            parcel.writeString(mCity);
            parcel.writeString(mStateOrProvince);
            parcel.writeString(mPostalCode);
            parcel.writeString(mCounty);
            parcel.writeString(mCountry);
            parcel.writeString(mFormattedAddress);
        }


        private CacheAddress(Parcel parcel)
        {
            mAddressLines = new ArrayList();
            parcel.readStringList(mAddressLines);
            mCity = parcel.readString();
            mStateOrProvince = parcel.readString();
            mPostalCode = parcel.readString();
            mCounty = parcel.readString();
            mCountry = parcel.readString();
            mFormattedAddress = parcel.readString();
        }


        CacheAddress(List list, String s, String s1, String s2, String s3, String s4, String s5)
        {
            mAddressLines = list;
            mCity = s;
            mCounty = s1;
            mStateOrProvince = s2;
            mPostalCode = s3;
            mCountry = s4;
            mFormattedAddress = s5;
        }
    }

    private static class CacheCoordinates
        implements Parcelable, Coordinates
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public CacheCoordinates createFromParcel(Parcel parcel)
            {
                return new CacheCoordinates(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public CacheCoordinates[] newArray(int i)
            {
                return new CacheCoordinates[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        private double mLat;
        private double mLon;

        public int describeContents()
        {
            return 0;
        }

        public double getLatitude()
        {
            return mLat;
        }

        public double getLongitude()
        {
            return mLon;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeDouble(mLat);
            parcel.writeDouble(mLon);
        }


        CacheCoordinates(double d, double d1)
        {
            mLat = d;
            mLon = d1;
        }

        private CacheCoordinates(Parcel parcel)
        {
            mLat = parcel.readDouble();
            mLon = parcel.readDouble();
        }

    }

    private static class CacheGeofence
        implements Parcelable, Geofence
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public CacheGeofence createFromParcel(Parcel parcel)
            {
                return new CacheGeofence(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public CacheGeofence[] newArray(int i)
            {
                return new CacheGeofence[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        private CacheCoordinates mCoordinates;
        private double mRadius;

        public int describeContents()
        {
            return 0;
        }

        public Coordinates getCenter()
        {
            return mCoordinates;
        }

        public double getRadius()
        {
            return mRadius;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeParcelable(mCoordinates, 0);
            parcel.writeDouble(mRadius);
        }


        CacheGeofence(double d, double d1, double d2)
        {
            mCoordinates = new CacheCoordinates(d, d1);
            mRadius = d2;
        }

        private CacheGeofence(Parcel parcel)
        {
            mCoordinates = (CacheCoordinates)parcel.readParcelable(com/target/mothership/cache/CacheStoreSummary$CacheCoordinates.getClassLoader());
            mRadius = parcel.readDouble();
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CacheStoreSummary createFromParcel(Parcel parcel)
        {
            return new CacheStoreSummary(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CacheStoreSummary[] newArray(int i)
        {
            return new CacheStoreSummary[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private Address mAddress;
    private CacheGeofence mGeofence;
    private boolean mHasRequestTeamMember;
    private String mName;

    CacheStoreSummary(Cursor cursor)
    {
        super(new StoreIdentifier(cursor.getString(cursor.getColumnIndex("STORE_ID"))));
        mName = cursor.getString(cursor.getColumnIndex("NAME"));
        boolean flag;
        if (cursor.getInt(cursor.getColumnIndex("HAS_REQUEST_TEAM_MEMBER")) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mHasRequestTeamMember = flag;
        mGeofence = new CacheGeofence(cursor.getDouble(cursor.getColumnIndex("LAT")), cursor.getDouble(cursor.getColumnIndex("LON")), cursor.getDouble(cursor.getColumnIndex("RADIUS")));
        mAddress = new CacheAddress(Arrays.asList(new String[] {
            cursor.getString(cursor.getColumnIndex("STREET_ADDRESS"))
        }), cursor.getString(cursor.getColumnIndex("CITY")), cursor.getString(cursor.getColumnIndex("COUNTY")), cursor.getString(cursor.getColumnIndex("STATE_OR_PROVINCE")), cursor.getString(cursor.getColumnIndex("POSTAL_CODE")), cursor.getString(cursor.getColumnIndex("COUNTRY")), cursor.getString(cursor.getColumnIndex("FORMATTED_ADDRESS")));
    }

    private CacheStoreSummary(Parcel parcel)
    {
        super(parcel);
        mName = parcel.readString();
        mGeofence = (CacheGeofence)parcel.readParcelable(com/target/mothership/cache/CacheStoreSummary$CacheGeofence.getClassLoader());
        mAddress = (Address)parcel.readParcelable(com/target/mothership/model/common/Address.getClassLoader());
    }


    public int describeContents()
    {
        return 0;
    }

    public Address getAddress()
    {
        return mAddress;
    }

    public Geofence getGeofence()
    {
        return mGeofence;
    }

    public String getName()
    {
        return mName;
    }

    public boolean hasRequestATeamMember()
    {
        return mHasRequestTeamMember;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeString(mName);
        parcel.writeParcelable(mGeofence, 0);
        parcel.writeParcelable(mAddress, 0);
    }

}
