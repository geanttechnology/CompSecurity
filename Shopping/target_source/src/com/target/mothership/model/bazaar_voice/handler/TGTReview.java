// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.bazaar_voice.handler;

import android.os.Parcel;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.bazaar_voice.interfaces.Review;

public class TGTReview
    implements Review
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTReview a(Parcel parcel)
        {
            return new TGTReview(parcel);
        }

        public TGTReview[] a(int i)
        {
            return new TGTReview[i];
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
    private String mAuthorId;
    private String mId;
    private Tcin mProductId;
    private String mSubmissionId;

    TGTReview()
    {
    }

    private TGTReview(Parcel parcel)
    {
        mId = parcel.readString();
        mAuthorId = parcel.readString();
        mProductId = (Tcin)parcel.readParcelable(com/target/mothership/common/product/Tcin.getClassLoader());
        mSubmissionId = parcel.readString();
    }


    public void a(Tcin tcin)
    {
        mProductId = tcin;
    }

    public int describeContents()
    {
        return 0;
    }

    public void e(String s)
    {
        mId = s;
    }

    public void f(String s)
    {
        mAuthorId = s;
    }

    public void g(String s)
    {
        mSubmissionId = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mId);
        parcel.writeString(mAuthorId);
        parcel.writeParcelable(mProductId, i);
        parcel.writeString(mSubmissionId);
    }

}
