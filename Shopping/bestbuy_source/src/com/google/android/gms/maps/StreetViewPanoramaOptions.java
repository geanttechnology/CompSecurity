// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import ajk;
import akr;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions
    implements SafeParcelable
{

    public static final ajk CREATOR = new ajk();
    private final int a;
    private StreetViewPanoramaCamera b;
    private String c;
    private LatLng d;
    private Integer e;
    private Boolean f;
    private Boolean g;
    private Boolean h;
    private Boolean i;
    private Boolean j;

    public StreetViewPanoramaOptions()
    {
        f = Boolean.valueOf(true);
        g = Boolean.valueOf(true);
        h = Boolean.valueOf(true);
        i = Boolean.valueOf(true);
        a = 1;
    }

    public StreetViewPanoramaOptions(int k, StreetViewPanoramaCamera streetviewpanoramacamera, String s, LatLng latlng, Integer integer, byte byte0, byte byte1, 
            byte byte2, byte byte3, byte byte4)
    {
        f = Boolean.valueOf(true);
        g = Boolean.valueOf(true);
        h = Boolean.valueOf(true);
        i = Boolean.valueOf(true);
        a = k;
        b = streetviewpanoramacamera;
        d = latlng;
        e = integer;
        c = s;
        f = akr.a(byte0);
        g = akr.a(byte1);
        h = akr.a(byte2);
        i = akr.a(byte3);
        j = akr.a(byte4);
    }

    public int a()
    {
        return a;
    }

    public byte b()
    {
        return akr.a(f);
    }

    public byte c()
    {
        return akr.a(g);
    }

    public byte d()
    {
        return akr.a(h);
    }

    public int describeContents()
    {
        return 0;
    }

    public byte e()
    {
        return akr.a(i);
    }

    public byte f()
    {
        return akr.a(j);
    }

    public StreetViewPanoramaCamera g()
    {
        return b;
    }

    public LatLng h()
    {
        return d;
    }

    public Integer i()
    {
        return e;
    }

    public String j()
    {
        return c;
    }

    public void writeToParcel(Parcel parcel, int k)
    {
        ajk.a(this, parcel, k);
    }

}
