// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.params;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.common.a;
import com.target.mothership.model.common.c;
import com.target.mothership.util.o;
import java.util.ArrayList;
import java.util.List;

public class AddressParams
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AddressParams a(Parcel parcel)
        {
            return new AddressParams(parcel);
        }

        public AddressParams[] a(int l)
        {
            return new AddressParams[l];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int l)
        {
            return a(l);
        }

    };
    private static final String PHONE_NUMBER_COUNTRY_CODE = "1";
    private static final int PHONE_WITH_COUNTRY_CODE_START_INDEX = 1;
    private List mAddressLines;
    private a mAddressType;
    private String mCity;
    private String mCountry;
    private String mFirstName;
    private boolean mIsPrimary;
    private String mLastName;
    private String mMiddleName;
    private String mPhoneNumber;
    private c mPhoneType;
    private String mPostalCode;
    private String mStateOrProvince;

    private AddressParams()
    {
    }

    private AddressParams(Parcel parcel)
    {
        Object obj1 = null;
        super();
        int l = parcel.readInt();
        Object obj;
        boolean flag;
        if (l == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.model.common.a.values()[l];
        }
        mAddressType = ((a) (obj));
        mAddressLines = new ArrayList();
        parcel.readList(mAddressLines, com/target/mothership/common/params/AddressParams.getClassLoader());
        mCity = parcel.readString();
        mStateOrProvince = parcel.readString();
        mPostalCode = parcel.readString();
        mCountry = parcel.readString();
        mFirstName = parcel.readString();
        mMiddleName = parcel.readString();
        mLastName = parcel.readString();
        mPhoneNumber = parcel.readString();
        l = parcel.readInt();
        if (l == -1)
        {
            obj = obj1;
        } else
        {
            obj = com.target.mothership.model.common.c.values()[l];
        }
        mPhoneType = ((c) (obj));
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsPrimary = flag;
    }


    public AddressParams(a a1, List list, String s, String s1, String s2, String s3, String s4, 
            String s5, String s6, String s7, c c1, boolean flag)
    {
label0:
        {
            super();
            mAddressType = a1;
            mAddressLines = list;
            mCity = s;
            mStateOrProvince = s1;
            mPostalCode = s2;
            mCountry = s3;
            mFirstName = s4;
            mMiddleName = s5;
            mLastName = s6;
            mPhoneType = c1;
            mIsPrimary = flag;
            if (o.g(s7))
            {
                if (!s7.startsWith("1"))
                {
                    break label0;
                }
                mPhoneNumber = s7.substring(1);
            }
            return;
        }
        mPhoneNumber = s7;
    }

    public List a()
    {
        return mAddressLines;
    }

    public String b()
    {
        return mCity;
    }

    public String c()
    {
        return mStateOrProvince;
    }

    public String d()
    {
        return mPostalCode;
    }

    public int describeContents()
    {
        return 0;
    }

    public String e()
    {
        return mCountry;
    }

    public String f()
    {
        return mFirstName;
    }

    public String g()
    {
        return mMiddleName;
    }

    public String h()
    {
        return mLastName;
    }

    public String i()
    {
        return mPhoneNumber;
    }

    public c j()
    {
        return mPhoneType;
    }

    public Boolean k()
    {
        return Boolean.valueOf(mIsPrimary);
    }

    public void writeToParcel(Parcel parcel, int l)
    {
        byte byte1 = -1;
        byte byte0;
        if (mAddressType == null)
        {
            l = -1;
        } else
        {
            l = mAddressType.ordinal();
        }
        parcel.writeInt(l);
        parcel.writeList(mAddressLines);
        parcel.writeString(mCity);
        parcel.writeString(mStateOrProvince);
        parcel.writeString(mPostalCode);
        parcel.writeString(mCountry);
        parcel.writeString(mFirstName);
        parcel.writeString(mMiddleName);
        parcel.writeString(mLastName);
        parcel.writeString(mPhoneNumber);
        if (mPhoneType == null)
        {
            l = byte1;
        } else
        {
            l = mPhoneType.ordinal();
        }
        parcel.writeInt(l);
        if (mIsPrimary)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
    }

}
