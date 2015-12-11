// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.tender.a;
import com.target.mothership.model.tender.PaymentCardExpiration;
import com.target.mothership.util.k;

// Referenced classes of package com.target.mothership.model.common:
//            PaymentCardTender, GuestAddress

public class TGTPaymentCardTender
    implements PaymentCardTender
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPaymentCardTender a(Parcel parcel)
        {
            return new TGTPaymentCardTender(parcel);
        }

        public TGTPaymentCardTender[] a(int i)
        {
            return new TGTPaymentCardTender[i];
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
    private GuestAddress mBillingAddress;
    private String mCardInfoId;
    private String mCardNickName;
    private a mCardType;
    private PaymentCardExpiration mExpiration;
    private boolean mIsAuthenticated;
    private boolean mIsDefault;
    private String mLast4CardNumber;
    private String mNameOnCard;

    public TGTPaymentCardTender()
    {
    }

    public TGTPaymentCardTender(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        mCardInfoId = parcel.readString();
        mBillingAddress = (GuestAddress)parcel.readParcelable(com/target/mothership/model/common/GuestAddress.getClassLoader());
        int i = parcel.readInt();
        a a1;
        boolean flag;
        if (i == -1)
        {
            a1 = null;
        } else
        {
            a1 = com.target.mothership.common.tender.a.values()[i];
        }
        mCardType = a1;
        mLast4CardNumber = parcel.readString();
        mNameOnCard = parcel.readString();
        mCardNickName = parcel.readString();
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsDefault = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mIsAuthenticated = flag;
        mExpiration = (PaymentCardExpiration)parcel.readParcelable(com/target/mothership/model/tender/PaymentCardExpiration.getClassLoader());
    }

    public String a()
    {
        return mCardInfoId;
    }

    public void a(a a1)
    {
        mCardType = a1;
    }

    public void a(GuestAddress guestaddress)
    {
        mBillingAddress = guestaddress;
    }

    public void a(PaymentCardExpiration paymentcardexpiration)
    {
        mExpiration = paymentcardexpiration;
    }

    public void a(boolean flag)
    {
        mIsDefault = flag;
    }

    public void b(String s)
    {
        mCardInfoId = s;
    }

    public void b(boolean flag)
    {
        mIsAuthenticated = flag;
    }

    public GuestAddress c()
    {
        return mBillingAddress;
    }

    public void c(String s)
    {
        mLast4CardNumber = s;
    }

    public a d()
    {
        return mCardType;
    }

    public void d(String s)
    {
        mNameOnCard = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public String e()
    {
        return mLast4CardNumber;
    }

    public void e(String s)
    {
        mCardNickName = s;
    }

    public e f()
    {
        return k.a(mExpiration);
    }

    public boolean g()
    {
        return mIsDefault;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(mCardInfoId);
        parcel.writeParcelable(mBillingAddress, i);
        byte byte0;
        int j;
        if (mCardType == null)
        {
            j = -1;
        } else
        {
            j = mCardType.ordinal();
        }
        parcel.writeInt(j);
        parcel.writeString(mLast4CardNumber);
        parcel.writeString(mNameOnCard);
        parcel.writeString(mCardNickName);
        if (mIsDefault)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsAuthenticated)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeParcelable(mExpiration, i);
    }

}
