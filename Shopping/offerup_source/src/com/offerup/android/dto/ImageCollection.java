// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.offerup.android.dto:
//            Image

public class ImageCollection
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private Image detail;
    private Image detailFull;
    private Image list;

    private ImageCollection()
    {
    }

    public ImageCollection(Image image, Image image1, Image image2)
    {
        detail = image;
        detailFull = image1;
        list = image2;
    }

    ImageCollection(_cls1 _pcls1)
    {
        this();
    }

    public int describeContents()
    {
        return 0;
    }

    public Image getDetail()
    {
        return detail;
    }

    public Image getDetailFull()
    {
        return detailFull;
    }

    public Image getList()
    {
        return list;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(detailFull, i);
        parcel.writeParcelable(detail, i);
        parcel.writeParcelable(list, i);
    }



/*
    static Image access$102(ImageCollection imagecollection, Image image)
    {
        imagecollection.detailFull = image;
        return image;
    }

*/


/*
    static Image access$202(ImageCollection imagecollection, Image image)
    {
        imagecollection.detail = image;
        return image;
    }

*/


/*
    static Image access$302(ImageCollection imagecollection, Image image)
    {
        imagecollection.list = image;
        return image;
    }

*/

    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final ImageCollection createFromParcel(Parcel parcel)
        {
            ImageCollection imagecollection = new ImageCollection(null);
            imagecollection.detailFull = (Image)parcel.readParcelable(com/offerup/android/dto/Image.getClassLoader());
            imagecollection.detail = (Image)parcel.readParcelable(com/offerup/android/dto/Image.getClassLoader());
            imagecollection.list = (Image)parcel.readParcelable(com/offerup/android/dto/Image.getClassLoader());
            return imagecollection;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final ImageCollection[] newArray(int i)
        {
            return new ImageCollection[i];
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
