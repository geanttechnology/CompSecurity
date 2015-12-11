// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ResourceV2
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ResourceV2 a(Parcel parcel)
        {
            return new ResourceV2(parcel);
        }

        public ResourceV2[] a(int i)
        {
            return new ResourceV2[i];
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
    public String contentType;
    public String instrument;
    public String role;
    public long size;
    public String uid;
    public String url;

    public ResourceV2()
    {
    }

    public ResourceV2(Parcel parcel)
    {
        instrument = parcel.readString();
        role = parcel.readString();
        url = parcel.readString();
        uid = parcel.readString();
        contentType = parcel.readString();
        size = parcel.readLong();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        String s;
        if (instrument == null)
        {
            s = "";
        } else
        {
            s = instrument;
        }
        parcel.writeString(s);
        if (role == null)
        {
            s = "";
        } else
        {
            s = role;
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
        if (uid == null)
        {
            s = "";
        } else
        {
            s = uid;
        }
        parcel.writeString(s);
        if (contentType == null)
        {
            s = "";
        } else
        {
            s = contentType;
        }
        parcel.writeString(s);
        parcel.writeLong(size);
    }

}
