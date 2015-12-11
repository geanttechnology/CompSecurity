// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.guest.interfaces.AppliedPayPalDetails;
import java.math.BigDecimal;

public class TGTAppliedPayPalDetails
    implements AppliedPayPalDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTAppliedPayPalDetails a(Parcel parcel)
        {
            return new TGTAppliedPayPalDetails(parcel);
        }

        public TGTAppliedPayPalDetails[] a(int i)
        {
            return new TGTAppliedPayPalDetails[i];
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
    private BigDecimal mAppliedAmount;
    private GuestAddress mBillingAddress;

    public TGTAppliedPayPalDetails()
    {
    }

    private TGTAppliedPayPalDetails(Parcel parcel)
    {
        mBillingAddress = (GuestAddress)parcel.readParcelable(com/target/mothership/model/common/GuestAddress.getClassLoader());
        mAppliedAmount = (BigDecimal)parcel.readSerializable();
    }


    public BigDecimal a()
    {
        return mAppliedAmount;
    }

    public void a(GuestAddress guestaddress)
    {
        mBillingAddress = guestaddress;
    }

    public void a(BigDecimal bigdecimal)
    {
        mAppliedAmount = bigdecimal;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mBillingAddress, i);
        parcel.writeSerializable(mAppliedAmount);
    }

}
