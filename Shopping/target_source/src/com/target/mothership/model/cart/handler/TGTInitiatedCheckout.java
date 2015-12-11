// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.InitiatedCheckout;

class TGTInitiatedCheckout
    implements InitiatedCheckout
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTInitiatedCheckout a(Parcel parcel)
        {
            return new TGTInitiatedCheckout(parcel);
        }

        public TGTInitiatedCheckout[] a(int i)
        {
            return new TGTInitiatedCheckout[i];
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
    private String mOrderId;

    TGTInitiatedCheckout()
    {
    }

    private TGTInitiatedCheckout(Parcel parcel)
    {
        mOrderId = parcel.readString();
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mOrderId);
    }

}
