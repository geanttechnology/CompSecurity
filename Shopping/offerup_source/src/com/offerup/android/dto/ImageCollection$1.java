// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;

// Referenced classes of package com.offerup.android.dto:
//            ImageCollection, Image

final class 
    implements android.os.
{

    public final ImageCollection createFromParcel(Parcel parcel)
    {
        ImageCollection imagecollection = new ImageCollection(null);
        ImageCollection.access$102(imagecollection, (Image)parcel.readParcelable(com/offerup/android/dto/Image.getClassLoader()));
        ImageCollection.access$202(imagecollection, (Image)parcel.readParcelable(com/offerup/android/dto/Image.getClassLoader()));
        ImageCollection.access$302(imagecollection, (Image)parcel.readParcelable(com/offerup/android/dto/Image.getClassLoader()));
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

    ()
    {
    }
}
