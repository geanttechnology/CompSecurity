// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.common.product.e;
import com.target.mothership.model.product.interfaces.ProductEsrbRating;

public class TGTProductEsrbRating
    implements ProductEsrbRating
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductEsrbRating a(Parcel parcel)
        {
            return new TGTProductEsrbRating(parcel);
        }

        public TGTProductEsrbRating[] a(int i)
        {
            return new TGTProductEsrbRating[i];
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
    private e mEsrbRating;
    private String mMessage;

    TGTProductEsrbRating()
    {
    }

    private TGTProductEsrbRating(Parcel parcel)
    {
        int i = parcel.readInt();
        e e1;
        if (i == -1)
        {
            e1 = null;
        } else
        {
            e1 = e.values()[i];
        }
        mEsrbRating = e1;
        mMessage = parcel.readString();
    }


    public void a(e e1)
    {
        mEsrbRating = e1;
    }

    public void a(String s)
    {
        mMessage = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (mEsrbRating == null)
        {
            i = -1;
        } else
        {
            i = mEsrbRating.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeString(mMessage);
    }

}
