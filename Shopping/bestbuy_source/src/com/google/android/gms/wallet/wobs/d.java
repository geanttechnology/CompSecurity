// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.wobs;

import aed;
import android.os.Parcel;
import atk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

public final class d
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new atk();
    public String a;
    public String b;
    public ArrayList c;
    private final int d;

    d()
    {
        d = 1;
        c = aed.a();
    }

    public d(int i, String s, String s1, ArrayList arraylist)
    {
        d = i;
        a = s;
        b = s1;
        c = arraylist;
    }

    public int a()
    {
        return d;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        atk.a(this, parcel, i);
    }

}
