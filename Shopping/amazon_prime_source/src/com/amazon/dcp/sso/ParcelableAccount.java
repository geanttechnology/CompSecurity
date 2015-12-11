// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.sso;

import android.accounts.Account;
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

    public ParcelableAccount(Account account)
    {
        this(account.name, account.type);
    }

    private ParcelableAccount(Parcel parcel)
    {
        mAccountName = parcel.readString();
        mAccountType = parcel.readString();
    }


    public ParcelableAccount(String s, String s1)
    {
        mAccountName = s;
        mAccountType = s1;
    }

    public static transient ParcelableAccount[] fromAccounts(Account aaccount[])
    {
        if (aaccount != null) goto _L2; else goto _L1
_L1:
        ParcelableAccount aparcelableaccount[] = null;
_L4:
        return aparcelableaccount;
_L2:
        ParcelableAccount aparcelableaccount1[] = new ParcelableAccount[aaccount.length];
        int i = 0;
        do
        {
            aparcelableaccount = aparcelableaccount1;
            if (i >= aaccount.length)
            {
                continue;
            }
            aparcelableaccount1[i] = new ParcelableAccount(aaccount[i]);
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static transient Account[] toAccounts(ParcelableAccount aparcelableaccount[])
    {
        if (aparcelableaccount != null) goto _L2; else goto _L1
_L1:
        Account aaccount[] = null;
_L4:
        return aaccount;
_L2:
        Account aaccount1[] = new Account[aparcelableaccount.length];
        int i = 0;
        do
        {
            aaccount = aaccount1;
            if (i >= aparcelableaccount.length)
            {
                continue;
            }
            if (aparcelableaccount[i] != null)
            {
                aaccount1[i] = aparcelableaccount[i].getAccount();
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
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

    public Account getAccount()
    {
        return new Account(mAccountName, mAccountType);
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
