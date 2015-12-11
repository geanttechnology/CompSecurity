// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductAgeRestriction;
import com.target.mothership.util.o;

public class TGTProductAgeRestriction
    implements ProductAgeRestriction
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductAgeRestriction a(Parcel parcel)
        {
            return new TGTProductAgeRestriction(parcel);
        }

        public TGTProductAgeRestriction[] a(int i)
        {
            return new TGTProductAgeRestriction[i];
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
    private String mAgeRestriction;

    TGTProductAgeRestriction()
    {
    }

    private TGTProductAgeRestriction(Parcel parcel)
    {
        mAgeRestriction = parcel.readString();
    }


    public void a(String s)
    {
        mAgeRestriction = s;
    }

    public boolean a()
    {
        return o.g(mAgeRestriction);
    }

    public String b()
    {
        return mAgeRestriction;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mAgeRestriction);
    }

}
