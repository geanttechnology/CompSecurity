// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import awv;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.c;

public class t
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new awv();
    public final int a;
    public final int b;
    public final c c[];

    public t(int i, int j, c ac[])
    {
        a = i;
        b = j;
        c = ac;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        awv.a(this, parcel, i);
    }

}
