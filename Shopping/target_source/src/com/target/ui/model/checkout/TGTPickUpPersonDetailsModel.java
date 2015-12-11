// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model.checkout:
//            PickUpPersonDetailsModel

public class TGTPickUpPersonDetailsModel
    implements PickUpPersonDetailsModel
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPickUpPersonDetailsModel a(Parcel parcel)
        {
            return new TGTPickUpPersonDetailsModel(parcel);
        }

        public TGTPickUpPersonDetailsModel[] a(int i)
        {
            return new TGTPickUpPersonDetailsModel[i];
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
    private boolean mAllowEditDialog;
    private boolean mIsSelfPickUp;
    private String mPickUpPersonEmail;
    private String mPickUpPersonFirstName;
    private String mPickUpPersonLastName;

    public TGTPickUpPersonDetailsModel()
    {
    }

    private TGTPickUpPersonDetailsModel(Parcel parcel)
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
        mIsSelfPickUp = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mAllowEditDialog = flag;
        mPickUpPersonFirstName = parcel.readString();
        mPickUpPersonLastName = parcel.readString();
        mPickUpPersonEmail = parcel.readString();
    }


    public void a(String s)
    {
        mPickUpPersonFirstName = s;
    }

    public void a(boolean flag)
    {
        mIsSelfPickUp = flag;
    }

    public boolean a()
    {
        return mIsSelfPickUp;
    }

    public void b(String s)
    {
        mPickUpPersonLastName = s;
    }

    public void b(boolean flag)
    {
        mAllowEditDialog = flag;
    }

    public boolean b()
    {
        return mAllowEditDialog;
    }

    public String c()
    {
        return mPickUpPersonFirstName;
    }

    public void c(String s)
    {
        mPickUpPersonEmail = s;
    }

    public String d()
    {
        return mPickUpPersonLastName;
    }

    public int describeContents()
    {
        return 0;
    }

    public String e()
    {
        return mPickUpPersonEmail;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        byte byte0;
        if (mIsSelfPickUp)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mAllowEditDialog)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(mPickUpPersonFirstName);
        parcel.writeString(mPickUpPersonLastName);
        parcel.writeString(mPickUpPersonEmail);
    }

}
