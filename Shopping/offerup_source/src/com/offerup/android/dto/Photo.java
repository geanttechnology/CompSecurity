// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.offerup.android.dto:
//            ImageCollection, Image

public class Photo
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private ImageCollection images;
    private String uuid;

    private Photo()
    {
    }

    Photo(_cls1 _pcls1)
    {
        this();
    }

    public int describeContents()
    {
        return 0;
    }

    public Uri getDetailFullUrl()
    {
        if (images != null && images.getDetailFull() != null)
        {
            return images.getDetailFull().getUri();
        } else
        {
            return null;
        }
    }

    public Uri getDetailUri()
    {
        if (images != null && images.getDetail() != null)
        {
            return images.getDetail().getUri();
        } else
        {
            return null;
        }
    }

    public ImageCollection getImages()
    {
        return images;
    }

    public Uri getListUrl()
    {
        if (images != null && images.getList() != null)
        {
            return images.getList().getUri();
        } else
        {
            return null;
        }
    }

    public String getUuid()
    {
        return uuid;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(uuid);
        parcel.writeParcelable(images, i);
    }



/*
    static String access$102(Photo photo, String s)
    {
        photo.uuid = s;
        return s;
    }

*/


/*
    static ImageCollection access$202(Photo photo, ImageCollection imagecollection)
    {
        photo.images = imagecollection;
        return imagecollection;
    }

*/

    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final Photo createFromParcel(Parcel parcel)
        {
            Photo photo = new Photo(null);
            photo.uuid = parcel.readString();
            photo.images = (ImageCollection)parcel.readParcelable(com/offerup/android/dto/ImageCollection.getClassLoader());
            return photo;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final Photo[] newArray(int i)
        {
            return new Photo[i];
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
