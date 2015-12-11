// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;


// Referenced classes of package com.google.android.gms.maps.model:
//            CameraPosition, LatLng

public static final class Cp
{

    private LatLng Cm;
    private float Cn;
    private float Co;
    private float Cp;

    public Cp bearing(float f)
    {
        Cp = f;
        return this;
    }

    public CameraPosition build()
    {
        return new CameraPosition(Cm, Cn, Co, Cp);
    }

    public Cp target(LatLng latlng)
    {
        Cm = latlng;
        return this;
    }

    public Cm tilt(float f)
    {
        Co = f;
        return this;
    }

    public Co zoom(float f)
    {
        Cn = f;
        return this;
    }

    public ()
    {
    }

    public (CameraPosition cameraposition)
    {
        Cm = cameraposition.target;
        Cn = cameraposition.zoom;
        Co = cameraposition.tilt;
        Cp = cameraposition.bearing;
    }
}
