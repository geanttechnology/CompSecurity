// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import awt;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class p
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new awt();
    public final int a;
    public final int b;
    public final int c;

    public p(int i, int j, int k)
    {
        a = i;
        b = j;
        c = k;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        awt.a(this, parcel, i);
    }

}
