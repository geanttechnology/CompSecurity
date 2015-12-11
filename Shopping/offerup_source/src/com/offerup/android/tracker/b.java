// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.tracker;

import android.os.Parcel;

// Referenced classes of package com.offerup.android.tracker:
//            ItemDetailUserInteractionRecord

final class b
    implements android.os.Parcelable.Creator
{

    b(ItemDetailUserInteractionRecord itemdetailuserinteractionrecord)
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        ItemDetailUserInteractionRecord itemdetailuserinteractionrecord = new ItemDetailUserInteractionRecord((byte)0);
        ItemDetailUserInteractionRecord.a(itemdetailuserinteractionrecord, ((Integer)parcel.readValue(Integer.TYPE.getClassLoader())).intValue());
        ItemDetailUserInteractionRecord.a(itemdetailuserinteractionrecord, parcel.readArrayList(java/lang/Integer.getClassLoader()));
        ItemDetailUserInteractionRecord.b(itemdetailuserinteractionrecord, ((Integer)parcel.readValue(Integer.TYPE.getClassLoader())).intValue());
        return itemdetailuserinteractionrecord;
    }

    public final volatile Object[] newArray(int i)
    {
        return new ItemDetailUserInteractionRecord[i];
    }
}
