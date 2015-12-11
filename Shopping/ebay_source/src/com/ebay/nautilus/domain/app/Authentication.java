// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class Authentication
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Authentication createFromParcel(Parcel parcel)
        {
            return new Authentication(parcel.readString(), parcel.readString());
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Authentication[] newArray(int i)
        {
            return new Authentication[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final String iafToken;
    public final String user;

    public Authentication(String s, String s1)
    {
        user = s;
        iafToken = s1;
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("Invalid user ID or token!");
        } else
        {
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj == null || obj.getClass() != getClass())
            {
                return false;
            }
            obj = (Authentication)obj;
            if (!user.equals(((Authentication) (obj)).user) || !iafToken.equals(((Authentication) (obj)).iafToken))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return (user.hashCode() + 59) * 59 + iafToken.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(user);
        parcel.writeString(iafToken);
    }

}
