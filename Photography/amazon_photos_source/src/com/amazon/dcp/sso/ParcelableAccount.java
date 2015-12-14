// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.sso;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class ParcelableAccount
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ParcelableAccount createFromParcel(Parcel parcel)
        {
            return new ParcelableAccount(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ParcelableAccount[] newArray(int i)
        {
            return new ParcelableAccount[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final String mAccountName;
    private final String mAccountType;

    private ParcelableAccount(Parcel parcel)
    {
        mAccountName = parcel.readString();
        mAccountType = parcel.readString();
    }


    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (ParcelableAccount)obj;
            if (!TextUtils.equals(mAccountName, ((ParcelableAccount) (obj)).mAccountName) || !TextUtils.equals(mAccountType, ((ParcelableAccount) (obj)).mAccountType))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (mAccountName == null)
        {
            i = 0;
        } else
        {
            i = mAccountName.hashCode();
        }
        if (mAccountType != null)
        {
            j = mAccountType.hashCode();
        }
        return (i + 31) * 31 + j;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mAccountName);
        parcel.writeString(mAccountType);
    }

}
