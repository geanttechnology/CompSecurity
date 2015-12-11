// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import atb;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class InstrumentInfo
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new atb();
    private final int a;
    private String b;
    private String c;

    public InstrumentInfo(int i, String s, String s1)
    {
        a = i;
        b = s;
        c = s1;
    }

    public int a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        return c;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        atb.a(this, parcel, i);
    }

}
