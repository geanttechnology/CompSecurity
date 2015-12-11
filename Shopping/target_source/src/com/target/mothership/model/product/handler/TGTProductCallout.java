// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.common.product.a;
import com.target.mothership.model.product.interfaces.ProductCallout;

public class TGTProductCallout
    implements ProductCallout
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductCallout a(Parcel parcel)
        {
            return new TGTProductCallout(parcel);
        }

        public TGTProductCallout[] a(int i)
        {
            return new TGTProductCallout[i];
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
    private String mCalloutMessage;
    private a mCalloutType;

    TGTProductCallout()
    {
    }

    private TGTProductCallout(Parcel parcel)
    {
        int i = parcel.readInt();
        a a1;
        if (i == -1)
        {
            a1 = null;
        } else
        {
            a1 = com.target.mothership.common.product.a.values()[i];
        }
        mCalloutType = a1;
        mCalloutMessage = parcel.readString();
    }


    public a a()
    {
        return mCalloutType;
    }

    public void a(a a1)
    {
        mCalloutType = a1;
    }

    public void a(String s)
    {
        mCalloutMessage = s;
    }

    public String b()
    {
        return mCalloutMessage;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (mCalloutType == null)
        {
            i = -1;
        } else
        {
            i = mCalloutType.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeString(mCalloutMessage);
    }

}
