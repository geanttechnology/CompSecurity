// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Image
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private int height;
    private Uri uri;
    private int width;

    private Image()
    {
    }

    public Image(Uri uri1, int i, int j)
    {
        uri = uri1;
        width = i;
        height = j;
    }

    Image(_cls1 _pcls1)
    {
        this();
    }

    public int describeContents()
    {
        return 0;
    }

    public int getHeight()
    {
        return height;
    }

    public Uri getUri()
    {
        return uri;
    }

    public int getWidth()
    {
        return width;
    }

    public void setUri(Uri uri1)
    {
        uri = uri1;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(uri, i);
        parcel.writeInt(width);
        parcel.writeInt(height);
    }



/*
    static Uri access$102(Image image, Uri uri1)
    {
        image.uri = uri1;
        return uri1;
    }

*/


/*
    static int access$202(Image image, int i)
    {
        image.width = i;
        return i;
    }

*/


/*
    static int access$302(Image image, int i)
    {
        image.height = i;
        return i;
    }

*/

    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final Image createFromParcel(Parcel parcel)
        {
            Image image = new Image(null);
            image.uri = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
            image.width = parcel.readInt();
            image.height = parcel.readInt();
            return image;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final Image[] newArray(int i)
        {
            return new Image[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
