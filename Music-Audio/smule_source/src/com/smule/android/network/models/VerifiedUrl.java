// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;

public class VerifiedUrl
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VerifiedUrl a(Parcel parcel)
        {
            return new VerifiedUrl(parcel);
        }

        public VerifiedUrl[] a(int i)
        {
            return new VerifiedUrl[i];
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
    public String desc;
    public String type;
    public String url;

    public VerifiedUrl()
    {
    }

    public VerifiedUrl(Parcel parcel)
    {
        type = parcel.readString();
        desc = parcel.readString();
        url = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        String s;
        if (type == null)
        {
            s = "";
        } else
        {
            s = type;
        }
        parcel.writeString(s);
        if (desc == null)
        {
            s = "";
        } else
        {
            s = desc;
        }
        parcel.writeString(s);
        if (url == null)
        {
            s = "";
        } else
        {
            s = url;
        }
        parcel.writeString(s);
    }

}
