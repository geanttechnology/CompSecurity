// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import aib;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class GeofencingRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new aib();
    private final int a;
    private final List b;
    private final int c;

    public GeofencingRequest(int i, List list, int j)
    {
        a = i;
        b = list;
        c = j;
    }

    private GeofencingRequest(List list, int i)
    {
        this(1, list, i);
    }


    public int a()
    {
        return a;
    }

    public List b()
    {
        return b;
    }

    public int c()
    {
        return c;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        aib.a(this, parcel, i);
    }

}
