// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import aut;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class z
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new aut();
    public final int a;
    public final int b;
    public final ParcelFileDescriptor c;

    public z(int i, int j, ParcelFileDescriptor parcelfiledescriptor)
    {
        a = i;
        b = j;
        c = parcelfiledescriptor;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        aut.a(this, parcel, i | 1);
    }

}
