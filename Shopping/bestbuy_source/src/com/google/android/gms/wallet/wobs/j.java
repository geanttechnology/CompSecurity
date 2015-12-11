// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import atn;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class j
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new atn();
    public String a;
    public String b;
    private final int c;

    j()
    {
        c = 1;
    }

    public j(int i, String s, String s1)
    {
        c = i;
        a = s;
        b = s1;
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
        atn.a(this, parcel, i);
    }

}
