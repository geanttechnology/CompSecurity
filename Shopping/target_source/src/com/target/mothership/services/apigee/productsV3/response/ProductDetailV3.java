// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.productsV3.response;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class ProductDetailV3
    implements Parcelable
{
    public static class Availability
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Availability a(Parcel parcel)
            {
                return new Availability(parcel);
            }

            public Availability[] a(int i)
            {
                return new Availability[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        private String mAvailabileQuantity;
        private int mAvailabilityCode;
        private String mAvailabilityStatus;
        private int mChannelAvailabilityCode;
        private String mChannelAvailabilityStatus;
        private String mItemStatus;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(mItemStatus);
            parcel.writeString(mAvailabilityStatus);
            parcel.writeInt(mAvailabilityCode);
            parcel.writeString(mAvailabileQuantity);
            parcel.writeString(mChannelAvailabilityStatus);
            parcel.writeInt(mChannelAvailabilityCode);
        }


        public Availability()
        {
        }

        private Availability(Parcel parcel)
        {
            mItemStatus = parcel.readString();
            mAvailabilityStatus = parcel.readString();
            mAvailabilityCode = parcel.readInt();
            mAvailabileQuantity = parcel.readString();
            mChannelAvailabilityStatus = parcel.readString();
            mChannelAvailabilityCode = parcel.readInt();
        }

    }

    public static class Description
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Description a(Parcel parcel)
            {
                return new Description(parcel);
            }

            public Description[] a(int i)
            {
                return new Description[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        private String mDescriptionType;
        private String mDescriptionValue;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(mDescriptionType);
            parcel.writeString(mDescriptionValue);
        }


        public Description()
        {
        }

        private Description(Parcel parcel)
        {
            mDescriptionType = parcel.readString();
            mDescriptionValue = parcel.readString();
        }

    }

    public static class Identifier
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Identifier a(Parcel parcel)
            {
                return new Identifier(parcel);
            }

            public Identifier[] a(int i)
            {
                return new Identifier[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        private String mId;
        private String mIdType;
        private boolean mIsPrimary;
        private String mSource;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(mIdType);
            parcel.writeString(mId);
            if (mIsPrimary)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeByte((byte)i);
            parcel.writeString(mSource);
        }


        public Identifier()
        {
        }

        private Identifier(Parcel parcel)
        {
            mIdType = parcel.readString();
            mId = parcel.readString();
            boolean flag;
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mIsPrimary = flag;
            mSource = parcel.readString();
        }

    }

    public static class Images
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Images a(Parcel parcel)
            {
                return new Images(parcel);
            }

            public Images[] a(int i)
            {
                return new Images[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        private List mAltImageURL;
        private List mPrimaryImageURL;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeStringList(mPrimaryImageURL);
            parcel.writeStringList(mAltImageURL);
        }


        public Images()
        {
        }

        private Images(Parcel parcel)
        {
            mPrimaryImageURL = parcel.createStringArrayList();
            mAltImageURL = parcel.createStringArrayList();
        }

    }

    public static class Price
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Price a(Parcel parcel)
            {
                return new Price(parcel);
            }

            public Price[] a(int i)
            {
                return new Price[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        private String mCurrentPrice;
        private String mMapPrice;
        private String mOriginalPrice;
        private int mPriceCode;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(mCurrentPrice);
            parcel.writeString(mOriginalPrice);
            parcel.writeString(mMapPrice);
            parcel.writeInt(mPriceCode);
        }


        public Price()
        {
        }

        private Price(Parcel parcel)
        {
            mCurrentPrice = parcel.readString();
            mOriginalPrice = parcel.readString();
            mMapPrice = parcel.readString();
            mPriceCode = parcel.readInt();
        }

    }

    public static class Review
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Review a(Parcel parcel)
            {
                return new Review(parcel);
            }

            public Review[] a(int i)
            {
                return new Review[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        private String mOverallRating;
        private String mTotalReviews;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(mOverallRating);
            parcel.writeString(mTotalReviews);
        }


        public Review()
        {
        }

        private Review(Parcel parcel)
        {
            mOverallRating = parcel.readString();
            mTotalReviews = parcel.readString();
        }

    }

    public static class StoreLocation
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public StoreLocation a(Parcel parcel)
            {
                return new StoreLocation(parcel);
            }

            public StoreLocation[] a(int i)
            {
                return new StoreLocation[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        private int mAisle;
        private String mBlock;
        private String mBlockAisle;
        private String mFloor;
        private int mSection;
        private String mSmartSchematic;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(mBlock);
            parcel.writeInt(mAisle);
            parcel.writeString(mBlockAisle);
            parcel.writeString(mFloor);
            parcel.writeInt(mSection);
            parcel.writeString(mSmartSchematic);
        }


        public StoreLocation()
        {
        }

        private StoreLocation(Parcel parcel)
        {
            mBlock = parcel.readString();
            mAisle = parcel.readInt();
            mBlockAisle = parcel.readString();
            mFloor = parcel.readString();
            mSection = parcel.readInt();
            mSmartSchematic = parcel.readString();
        }

    }

    public static class StoreMerchHierarchy
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public StoreMerchHierarchy a(Parcel parcel)
            {
                return new StoreMerchHierarchy(parcel);
            }

            public StoreMerchHierarchy[] a(int i)
            {
                return new StoreMerchHierarchy[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        private String mDescription;
        private String mId;
        private StoreMerchHierarchy mNode;
        private String mTypeCode;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(mId);
            parcel.writeString(mDescription);
            parcel.writeString(mTypeCode);
            parcel.writeParcelable(mNode, i);
        }


        public StoreMerchHierarchy()
        {
        }

        private StoreMerchHierarchy(Parcel parcel)
        {
            mId = parcel.readString();
            mDescription = parcel.readString();
            mTypeCode = parcel.readString();
            mNode = (StoreMerchHierarchy)parcel.readParcelable(getClass().getClassLoader());
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ProductDetailV3 a(Parcel parcel)
        {
            return new ProductDetailV3(parcel);
        }

        public ProductDetailV3[] a(int i)
        {
            return new ProductDetailV3[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private List mAltDescription;
    private List mAlternateIdentifiers;
    private String mDetailPageURL;
    private List mIdentifiers;
    private Images mImage;
    private List mInStoreLocation;
    private boolean mIsSoldInSpecificStore;
    private Availability mOnlineAvailability;
    private String mOnlineBrandName;
    private Description mOnlineDescription;
    private Price mOnlinePrice;
    private Review mReview;
    private Availability mStoreAvailability;
    private Description mStoreDescription;
    private StoreMerchHierarchy mStoreMerchHierarchy;
    private Price mStorePrice;

    public ProductDetailV3()
    {
        mIdentifiers = new ArrayList();
        mAlternateIdentifiers = new ArrayList();
        mAltDescription = new ArrayList();
        mInStoreLocation = new ArrayList();
    }

    public ProductDetailV3(Parcel parcel)
    {
        mIdentifiers = new ArrayList();
        mAlternateIdentifiers = new ArrayList();
        mAltDescription = new ArrayList();
        mInStoreLocation = new ArrayList();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsSoldInSpecificStore = flag;
        mOnlineBrandName = parcel.readString();
        mDetailPageURL = parcel.readString();
        mIdentifiers = parcel.createTypedArrayList(Identifier.CREATOR);
        mAlternateIdentifiers = parcel.createTypedArrayList(Identifier.CREATOR);
        mOnlineDescription = (Description)parcel.readParcelable(getClass().getClassLoader());
        mStoreDescription = (Description)parcel.readParcelable(getClass().getClassLoader());
        mAltDescription = parcel.createTypedArrayList(Description.CREATOR);
        mOnlinePrice = (Price)parcel.readParcelable(getClass().getClassLoader());
        mStorePrice = (Price)parcel.readParcelable(getClass().getClassLoader());
        mOnlineAvailability = (Availability)parcel.readParcelable(getClass().getClassLoader());
        mStoreAvailability = (Availability)parcel.readParcelable(getClass().getClassLoader());
        mInStoreLocation = parcel.createTypedArrayList(StoreLocation.CREATOR);
        mImage = (Images)parcel.readParcelable(getClass().getClassLoader());
        mReview = (Review)parcel.readParcelable(getClass().getClassLoader());
        mStoreMerchHierarchy = (StoreMerchHierarchy)parcel.readParcelable(getClass().getClassLoader());
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        int j;
        if (mIsSoldInSpecificStore)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeByte((byte)j);
        parcel.writeString(mOnlineBrandName);
        parcel.writeString(mDetailPageURL);
        parcel.writeTypedList(mIdentifiers);
        parcel.writeTypedList(mAlternateIdentifiers);
        parcel.writeParcelable(mOnlineDescription, i);
        parcel.writeParcelable(mStoreDescription, i);
        parcel.writeTypedList(mAltDescription);
        parcel.writeParcelable(mOnlinePrice, i);
        parcel.writeParcelable(mStorePrice, i);
        parcel.writeParcelable(mOnlineAvailability, i);
        parcel.writeParcelable(mStoreAvailability, i);
        parcel.writeTypedList(mInStoreLocation);
        parcel.writeParcelable(mImage, i);
        parcel.writeParcelable(mReview, i);
        parcel.writeParcelable(mStoreMerchHierarchy, i);
    }

}
