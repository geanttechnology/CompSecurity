// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import ato;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class l
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ato();
    public long a;
    public long b;
    private final int c;

    l()
    {
        c = 1;
    }

    public l(int i, long l1, long l2)
    {
        c = i;
        a = l1;
        b = l2;
    }

    public int a()
    {
        return c;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ato.a(this, parcel, i);
    }

}
