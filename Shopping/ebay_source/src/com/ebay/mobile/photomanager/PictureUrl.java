// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import android.os.Parcel;
import android.os.Parcelable;

public class PictureUrl
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PictureUrl createFromParcel(Parcel parcel)
        {
            return new PictureUrl(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public PictureUrl[] newArray(int i)
        {
            return new PictureUrl[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public boolean enabled;
    public boolean stockPhoto;
    public String url;

    public PictureUrl()
    {
    }

    public PictureUrl(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        url = parcel.readString();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        enabled = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        stockPhoto = flag;
    }

    public PictureUrl(String s, boolean flag, boolean flag1)
    {
        url = s;
        enabled = flag;
        stockPhoto = flag1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(url);
        if (enabled)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (stockPhoto)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }

}
