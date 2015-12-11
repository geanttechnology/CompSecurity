// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import ady;
import android.os.Parcel;
import aty;
import awo;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DataItemAssetParcelable
    implements aty, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new awo();
    public final int a;
    private final String b;
    private final String c;

    public DataItemAssetParcelable(int i, String s, String s1)
    {
        a = i;
        b = s;
        c = s1;
    }

    public DataItemAssetParcelable(aty aty1)
    {
        a = 1;
        b = (String)ady.a(aty1.b());
        c = (String)ady.a(aty1.c());
    }

    public Object a()
    {
        return d();
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        return c;
    }

    public aty d()
    {
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("DataItemAssetParcelable[");
        stringbuilder.append("@");
        stringbuilder.append(Integer.toHexString(hashCode()));
        if (b == null)
        {
            stringbuilder.append(",noid");
        } else
        {
            stringbuilder.append(",");
            stringbuilder.append(b);
        }
        stringbuilder.append(", key=");
        stringbuilder.append(c);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        awo.a(this, parcel, i);
    }

}
