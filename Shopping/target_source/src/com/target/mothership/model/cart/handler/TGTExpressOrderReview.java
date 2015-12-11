// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.common.a.c;
import com.target.mothership.model.cart.interfaces.ExpressOrderReview;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTOrderReview

class TGTExpressOrderReview extends TGTOrderReview
    implements ExpressOrderReview
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTExpressOrderReview a(Parcel parcel)
        {
            return new TGTExpressOrderReview(parcel);
        }

        public TGTExpressOrderReview[] a(int i)
        {
            return new TGTExpressOrderReview[i];
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
    private boolean mIsCvvRequired;
    private boolean mIsEligibleForExpressCheckout;
    private boolean mIsTCPinRequired;
    private String mReason;
    private c mReasonCode;

    TGTExpressOrderReview()
    {
    }

    private TGTExpressOrderReview(Parcel parcel)
    {
        boolean flag1 = true;
        super(parcel);
        c c1;
        int i;
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsEligibleForExpressCheckout = flag;
        mReason = parcel.readString();
        i = parcel.readInt();
        if (i == -1)
        {
            c1 = null;
        } else
        {
            c1 = com.target.mothership.common.a.c.values()[i];
        }
        mReasonCode = c1;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsCvvRequired = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mIsTCPinRequired = flag;
    }


    public void a(c c1)
    {
        mReasonCode = c1;
    }

    public void a(boolean flag)
    {
        mIsEligibleForExpressCheckout = flag;
    }

    public void b(boolean flag)
    {
        mIsCvvRequired = flag;
    }

    public void c(boolean flag)
    {
        mIsTCPinRequired = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public void p(String s)
    {
        mReason = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        super.writeToParcel(parcel, i);
        byte byte0;
        if (mIsEligibleForExpressCheckout)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(mReason);
        if (mReasonCode == null)
        {
            i = -1;
        } else
        {
            i = mReasonCode.ordinal();
        }
        parcel.writeInt(i);
        if (mIsCvvRequired)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsTCPinRequired)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
    }

}
