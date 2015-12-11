// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.tracker;

import android.os.Parcel;

// Referenced classes of package com.offerup.android.tracker:
//            PhotoGalleryUserInteractionRecord

final class c
    implements android.os.Parcelable.Creator
{

    c(PhotoGalleryUserInteractionRecord photogalleryuserinteractionrecord)
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        PhotoGalleryUserInteractionRecord photogalleryuserinteractionrecord = new PhotoGalleryUserInteractionRecord((byte)0);
        PhotoGalleryUserInteractionRecord.a(photogalleryuserinteractionrecord, parcel.readArrayList(java/lang/Integer.getClassLoader()));
        PhotoGalleryUserInteractionRecord.a(photogalleryuserinteractionrecord, ((Integer)parcel.readValue(Integer.TYPE.getClassLoader())).intValue());
        PhotoGalleryUserInteractionRecord.b(photogalleryuserinteractionrecord, ((Integer)parcel.readValue(Integer.TYPE.getClassLoader())).intValue());
        PhotoGalleryUserInteractionRecord.a(photogalleryuserinteractionrecord, ((Long)parcel.readValue(Long.TYPE.getClassLoader())).longValue());
        return photogalleryuserinteractionrecord;
    }

    public final volatile Object[] newArray(int i)
    {
        return new PhotoGalleryUserInteractionRecord[i];
    }
}
