// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import atl;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class g
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new atl();
    public int a;
    public String b;
    public double c;
    public String d;
    public long e;
    public int f;
    private final int g;

    g()
    {
        g = 1;
        f = -1;
        a = -1;
        c = -1D;
    }

    public g(int i, int j, String s, double d1, String s1, long l, int k)
    {
        g = i;
        a = j;
        b = s;
        c = d1;
        d = s1;
        e = l;
        f = k;
    }

    public int a()
    {
        return g;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        atl.a(this, parcel, i);
    }

}
