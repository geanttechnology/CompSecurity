// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.a;
import com.google.android.gms.maps.internal.v;
import com.google.android.gms.maps.model.CameraPosition;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMapOptionsCreator, a

public final class GoogleMapOptions
    implements SafeParcelable
{

    public static final GoogleMapOptionsCreator CREATOR = new GoogleMapOptionsCreator();
    private Boolean ZA;
    private Boolean ZB;
    private Boolean Zs;
    private Boolean Zt;
    private int Zu;
    private CameraPosition Zv;
    private Boolean Zw;
    private Boolean Zx;
    private Boolean Zy;
    private Boolean Zz;
    private final int xM;

    public GoogleMapOptions()
    {
        Zu = -1;
        xM = 1;
    }

    GoogleMapOptions(int i, byte byte0, byte byte1, int j, CameraPosition cameraposition, byte byte2, byte byte3, 
            byte byte4, byte byte5, byte byte6, byte byte7)
    {
        Zu = -1;
        xM = i;
        Zs = a.a(byte0);
        Zt = a.a(byte1);
        Zu = j;
        Zv = cameraposition;
        Zw = a.a(byte2);
        Zx = a.a(byte3);
        Zy = a.a(byte4);
        Zz = a.a(byte5);
        ZA = a.a(byte6);
        ZB = a.a(byte7);
    }

    public int describeContents()
    {
        return 0;
    }

    public CameraPosition getCamera()
    {
        return Zv;
    }

    public int getMapType()
    {
        return Zu;
    }

    int getVersionCode()
    {
        return xM;
    }

    byte jq()
    {
        return a.c(Zs);
    }

    byte jr()
    {
        return a.c(Zt);
    }

    byte js()
    {
        return a.c(Zw);
    }

    byte jt()
    {
        return a.c(Zx);
    }

    byte ju()
    {
        return a.c(Zy);
    }

    byte jv()
    {
        return a.c(Zz);
    }

    byte jw()
    {
        return a.c(ZA);
    }

    byte jx()
    {
        return a.c(ZB);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (v.jL())
        {
            com.google.android.gms.maps.a.a(this, parcel, i);
            return;
        } else
        {
            com.google.android.gms.maps.GoogleMapOptionsCreator.a(this, parcel, i);
            return;
        }
    }

}
