// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import aks;
import android.os.Parcel;
import apn;
import apo;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Tile
    implements SafeParcelable
{

    public static final apn CREATOR = new apn();
    public final int a;
    public final int b;
    public final byte c[];
    private final int d;

    public Tile(int i, int j, int k, byte abyte0[])
    {
        d = i;
        a = j;
        b = k;
        c = abyte0;
    }

    public Tile(int i, int j, byte abyte0[])
    {
        this(1, i, j, abyte0);
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
        if (aks.a())
        {
            apo.a(this, parcel, i);
            return;
        } else
        {
            apn.a(this, parcel, i);
            return;
        }
    }

}
