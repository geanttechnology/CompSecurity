// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductGuestReview;
import java.math.BigDecimal;

public class TGTProductGuestReview
    implements ProductGuestReview
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductGuestReview a(Parcel parcel)
        {
            return new TGTProductGuestReview(parcel);
        }

        public TGTProductGuestReview[] a(int i)
        {
            return new TGTProductGuestReview[i];
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
    private int mGetReviewCount;
    private BigDecimal mOverAllGuestRating;

    TGTProductGuestReview()
    {
    }

    private TGTProductGuestReview(Parcel parcel)
    {
        mOverAllGuestRating = (BigDecimal)parcel.readSerializable();
        mGetReviewCount = parcel.readInt();
    }


    public BigDecimal a()
    {
        return mOverAllGuestRating;
    }

    public void a(int i)
    {
        mGetReviewCount = i;
    }

    public void a(BigDecimal bigdecimal)
    {
        mOverAllGuestRating = bigdecimal;
    }

    public int b()
    {
        return mGetReviewCount;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(mOverAllGuestRating);
        parcel.writeInt(mGetReviewCount);
    }

}
