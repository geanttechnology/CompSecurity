// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.bazaar_voice.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.bazaar_voice.interfaces.ProductSecondaryReview;
import com.target.mothership.util.o;
import java.math.BigDecimal;

public class TGTProductSecondaryReview
    implements Parcelable, ProductSecondaryReview
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductSecondaryReview a(Parcel parcel)
        {
            return new TGTProductSecondaryReview(parcel);
        }

        public TGTProductSecondaryReview[] a(int i)
        {
            return new TGTProductSecondaryReview[i];
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
    private String mAverageRating;
    private String mTitle;

    TGTProductSecondaryReview()
    {
    }

    private TGTProductSecondaryReview(Parcel parcel)
    {
        mTitle = parcel.readString();
        mAverageRating = parcel.readString();
    }


    public BigDecimal a()
    {
        if (mAverageRating == null)
        {
            return new BigDecimal(0);
        } else
        {
            return new BigDecimal(o.i(mAverageRating));
        }
    }

    public void a(String s)
    {
        mAverageRating = s;
    }

    public String b()
    {
        return mTitle;
    }

    public void b(String s)
    {
        mTitle = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mTitle);
        parcel.writeString(mAverageRating);
    }

}
