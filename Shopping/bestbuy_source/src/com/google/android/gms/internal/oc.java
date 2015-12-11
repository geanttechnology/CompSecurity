// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import afs;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class oc
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new afs();
    public final int a;
    private final String b;
    private final LatLng c;
    private final String d;
    private final List e;
    private final String f;
    private final String g;

    public oc(int i, String s, LatLng latlng, String s1, List list, String s2, String s3)
    {
        a = i;
        b = s;
        c = latlng;
        d = s1;
        e = new ArrayList(list);
        f = s2;
        g = s3;
    }

    public String a()
    {
        return b;
    }

    public LatLng b()
    {
        return c;
    }

    public String c()
    {
        return d;
    }

    public List d()
    {
        return e;
    }

    public int describeContents()
    {
        return 0;
    }

    public String e()
    {
        return f;
    }

    public String f()
    {
        return g;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        afs.a(this, parcel, i);
    }

}
