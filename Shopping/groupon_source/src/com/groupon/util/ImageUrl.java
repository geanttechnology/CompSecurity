// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.os.Parcel;
import android.os.Parcelable;

public class ImageUrl
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ImageUrl createFromParcel(Parcel parcel)
        {
            return new ImageUrl(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ImageUrl[] newArray(int i)
        {
            return new ImageUrl[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private boolean isCdnImage;
    private String url;

    protected ImageUrl(Parcel parcel)
    {
        url = parcel.readString();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isCdnImage = flag;
    }

    public ImageUrl(String s)
    {
        this(s, false);
    }

    public ImageUrl(String s, boolean flag)
    {
        url = s;
        isCdnImage = flag;
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
            obj = (ImageUrl)obj;
            if (isCdnImage != ((ImageUrl) (obj)).isCdnImage || !url.equals(((ImageUrl) (obj)).url))
            {
                return false;
            }
        }
        return true;
    }

    public String getUrl()
    {
        return url;
    }

    public int hashCode()
    {
        int j = url.hashCode();
        int i;
        if (isCdnImage)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return j * 31 + i;
    }

    public boolean isCdnImage()
    {
        return isCdnImage;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(url);
        if (isCdnImage)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }

}
