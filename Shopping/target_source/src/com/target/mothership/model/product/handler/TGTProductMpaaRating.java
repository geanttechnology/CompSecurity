// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.common.product.l;
import com.target.mothership.model.product.interfaces.ProductMpaaRating;

public class TGTProductMpaaRating
    implements ProductMpaaRating
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductMpaaRating a(Parcel parcel)
        {
            return new TGTProductMpaaRating(parcel);
        }

        public TGTProductMpaaRating[] a(int i)
        {
            return new TGTProductMpaaRating[i];
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
    private l mMpaaRating;

    TGTProductMpaaRating()
    {
    }

    private TGTProductMpaaRating(Parcel parcel)
    {
        int i = parcel.readInt();
        if (i == -1)
        {
            parcel = null;
        } else
        {
            parcel = l.values()[i];
        }
        mMpaaRating = parcel;
    }


    public void a(l l1)
    {
        mMpaaRating = l1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (mMpaaRating == null)
        {
            i = -1;
        } else
        {
            i = mMpaaRating.ordinal();
        }
        parcel.writeInt(i);
    }

}
