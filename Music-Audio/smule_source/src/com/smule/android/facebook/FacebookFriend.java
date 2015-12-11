// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.facebook;

import android.os.Parcel;
import android.os.Parcelable;

public class FacebookFriend
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public FacebookFriend a(Parcel parcel)
        {
            return new FacebookFriend(parcel);
        }

        public FacebookFriend[] a(int i)
        {
            return new FacebookFriend[i];
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
    private static final String f = com/smule/android/facebook/FacebookFriend.getName();
    public String a;
    public String b;
    public String c;
    public boolean d;
    public long e;

    public FacebookFriend(Parcel parcel)
    {
        boolean flag = true;
        super();
        e = parcel.readLong();
        a = parcel.readString();
        c = parcel.readString();
        b = parcel.readString();
        if (parcel.readByte() != 1)
        {
            flag = false;
        }
        d = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(e);
        String s;
        if (a == null)
        {
            s = "";
        } else
        {
            s = a;
        }
        parcel.writeString(s);
        if (c == null)
        {
            s = "";
        } else
        {
            s = c;
        }
        parcel.writeString(s);
        if (b == null)
        {
            s = "";
        } else
        {
            s = b;
        }
        parcel.writeString(s);
        if (d)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }

}
