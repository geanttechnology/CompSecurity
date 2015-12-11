// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupon_wallets.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.model.coupon_wallets.interfaces.WalletItem;
import com.target.mothership.model.coupon_wallets.interfaces.a;
import java.util.Date;

public class TGTWalletItem
    implements WalletItem
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTWalletItem a(Parcel parcel)
        {
            return new TGTWalletItem(parcel);
        }

        public TGTWalletItem[] a(int i)
        {
            return new TGTWalletItem[i];
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
    private String mCode;
    private Date mExpirationDate;
    private String mLegalDisclaimer;
    private int mNumberOfDaysToExpire;
    private String mQualificationDescription;
    private String mShortDescription;
    private a mStatus;

    TGTWalletItem()
    {
    }

    protected TGTWalletItem(Parcel parcel)
    {
        Object obj = null;
        super();
        mCode = parcel.readString();
        mLegalDisclaimer = parcel.readString();
        mShortDescription = parcel.readString();
        mQualificationDescription = parcel.readString();
        long l = parcel.readLong();
        Date date;
        int i;
        if (l == -1L)
        {
            date = null;
        } else
        {
            date = new Date(l);
        }
        mExpirationDate = date;
        mNumberOfDaysToExpire = parcel.readInt();
        i = parcel.readInt();
        if (i == -1)
        {
            parcel = obj;
        } else
        {
            parcel = com.target.mothership.model.coupon_wallets.interfaces.a.values()[i];
        }
        mStatus = parcel;
    }

    public e a()
    {
        return com.google.a.a.e.c(mCode);
    }

    public void a(int i)
    {
        mNumberOfDaysToExpire = i;
    }

    public void a(a a1)
    {
        mStatus = a1;
    }

    public void a(String s)
    {
        mCode = s;
    }

    public void a(Date date)
    {
        mExpirationDate = date;
    }

    public e b()
    {
        return com.google.a.a.e.c(mLegalDisclaimer);
    }

    public void b(String s)
    {
        mLegalDisclaimer = s;
    }

    public e c()
    {
        return com.google.a.a.e.c(mShortDescription);
    }

    public void c(String s)
    {
        mShortDescription = s;
    }

    public e d()
    {
        return com.google.a.a.e.c(mExpirationDate);
    }

    public void d(String s)
    {
        mQualificationDescription = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public e e()
    {
        return com.google.a.a.e.c(mStatus);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mCode);
        parcel.writeString(mLegalDisclaimer);
        parcel.writeString(mShortDescription);
        parcel.writeString(mQualificationDescription);
        long l;
        if (mExpirationDate != null)
        {
            l = mExpirationDate.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        parcel.writeInt(mNumberOfDaysToExpire);
        if (mStatus == null)
        {
            i = -1;
        } else
        {
            i = mStatus.ordinal();
        }
        parcel.writeInt(i);
    }

}
