// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model.checkout:
//            SmsRecipientDetailsModel

public class TGTSmsRecipientDetailsModel
    implements SmsRecipientDetailsModel
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTSmsRecipientDetailsModel a(Parcel parcel)
        {
            return new TGTSmsRecipientDetailsModel(parcel);
        }

        public TGTSmsRecipientDetailsModel[] a(int i)
        {
            return new TGTSmsRecipientDetailsModel[i];
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
    private boolean mIsDeliveredToSelf;
    private String mRecipientName;
    private String mRecipientPhoneNumber;
    private String mSenderName;

    public TGTSmsRecipientDetailsModel()
    {
    }

    private TGTSmsRecipientDetailsModel(Parcel parcel)
    {
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsDeliveredToSelf = flag;
        mRecipientName = parcel.readString();
        mRecipientPhoneNumber = parcel.readString();
        mSenderName = parcel.readString();
    }


    public void a(String s)
    {
        mRecipientName = s;
    }

    public void a(boolean flag)
    {
        mIsDeliveredToSelf = flag;
    }

    public boolean a()
    {
        return mIsDeliveredToSelf;
    }

    public String b()
    {
        return mRecipientName;
    }

    public void b(String s)
    {
        mRecipientPhoneNumber = s;
    }

    public String c()
    {
        return mRecipientPhoneNumber;
    }

    public void c(String s)
    {
        mSenderName = s;
    }

    public String d()
    {
        return mSenderName;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        byte byte0;
        if (mIsDeliveredToSelf)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(mRecipientName);
        parcel.writeString(mRecipientPhoneNumber);
        parcel.writeString(mSenderName);
    }

}
