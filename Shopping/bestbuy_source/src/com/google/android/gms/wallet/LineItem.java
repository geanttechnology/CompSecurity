// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import atc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new atc();
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public String f;
    private final int g;

    LineItem()
    {
        g = 1;
        e = 0;
    }

    public LineItem(int i, String s, String s1, String s2, String s3, int j, String s4)
    {
        g = i;
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = j;
        f = s4;
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
        atc.a(this, parcel, i);
    }

}
