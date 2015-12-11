// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.os.Parcel;

final class j
    implements android.os.Parcelable.Creator
{

    j()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return new Flyer.Model(parcel, (byte)0);
    }

    public final volatile Object[] newArray(int i)
    {
        return new Flyer.Model[i];
    }
}
