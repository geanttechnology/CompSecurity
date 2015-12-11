// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.TeamMemberDiscount;
import java.math.BigDecimal;
import java.util.Currency;

public class TGTTeamMemberDiscount
    implements TeamMemberDiscount
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTTeamMemberDiscount a(Parcel parcel)
        {
            return new TGTTeamMemberDiscount(parcel);
        }

        public TGTTeamMemberDiscount[] a(int i)
        {
            return new TGTTeamMemberDiscount[i];
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
    private BigDecimal mDiscountAmount;
    private Currency mDiscountCurrency;
    private String mTeamMemberNumber;

    TGTTeamMemberDiscount()
    {
    }

    private TGTTeamMemberDiscount(Parcel parcel)
    {
        mDiscountAmount = (BigDecimal)parcel.readSerializable();
        mDiscountCurrency = (Currency)parcel.readSerializable();
        mTeamMemberNumber = parcel.readString();
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(mDiscountAmount);
        parcel.writeSerializable(mDiscountCurrency);
        parcel.writeString(mTeamMemberNumber);
    }

}
