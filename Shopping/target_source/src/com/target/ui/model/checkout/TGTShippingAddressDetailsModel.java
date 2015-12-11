// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model.checkout:
//            ShippingAddressDetailsModel

public class TGTShippingAddressDetailsModel
    implements ShippingAddressDetailsModel
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTShippingAddressDetailsModel a(Parcel parcel)
        {
            return new TGTShippingAddressDetailsModel(parcel);
        }

        public TGTShippingAddressDetailsModel[] a(int i)
        {
            return new TGTShippingAddressDetailsModel[i];
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
    private String mAddressLine1;
    private String mAddressLine2;
    private boolean mHasAlreadyAppliedAddress;
    private boolean mIsRegistrantsAddress;
    private String mRegistrantName;
    private boolean mUseBillingAsShippingAddress;

    public TGTShippingAddressDetailsModel()
    {
    }

    private TGTShippingAddressDetailsModel(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mHasAlreadyAppliedAddress = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsRegistrantsAddress = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mUseBillingAsShippingAddress = flag;
        mAddressLine1 = parcel.readString();
        mAddressLine2 = parcel.readString();
        mRegistrantName = parcel.readString();
    }


    public void a(String s)
    {
        mAddressLine1 = s;
    }

    public void a(boolean flag)
    {
        mHasAlreadyAppliedAddress = flag;
    }

    public boolean a()
    {
        return mHasAlreadyAppliedAddress;
    }

    public void b(String s)
    {
        mAddressLine2 = s;
    }

    public void b(boolean flag)
    {
        mIsRegistrantsAddress = flag;
    }

    public boolean b()
    {
        return mIsRegistrantsAddress;
    }

    public void c(String s)
    {
        mRegistrantName = s;
    }

    public void c(boolean flag)
    {
        mUseBillingAsShippingAddress = flag;
    }

    public boolean c()
    {
        return mUseBillingAsShippingAddress;
    }

    public String d()
    {
        return mAddressLine1;
    }

    public int describeContents()
    {
        return 0;
    }

    public String e()
    {
        return mAddressLine2;
    }

    public String f()
    {
        return mRegistrantName;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        byte byte0;
        if (mHasAlreadyAppliedAddress)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsRegistrantsAddress)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mUseBillingAsShippingAddress)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(mAddressLine1);
        parcel.writeString(mAddressLine2);
        parcel.writeString(mRegistrantName);
    }

}
