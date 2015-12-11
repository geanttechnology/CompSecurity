// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;


// Referenced classes of package com.google.android.gms.maps.model:
//            CameraPosition, LatLng

public final class zzaJL
{

    private LatLng zzaJI;
    private float zzaJJ;
    private float zzaJK;
    private float zzaJL;

    public final zzaJL bearing(float f)
    {
        zzaJL = f;
        return this;
    }

    public final CameraPosition build()
    {
        return new CameraPosition(zzaJI, zzaJJ, zzaJK, zzaJL);
    }

    public final zzaJL target(LatLng latlng)
    {
        zzaJI = latlng;
        return this;
    }

    public final zzaJI tilt(float f)
    {
        zzaJK = f;
        return this;
    }

    public final zzaJK zoom(float f)
    {
        zzaJJ = f;
        return this;
    }

    public ()
    {
    }

    public (CameraPosition cameraposition)
    {
        zzaJI = cameraposition.target;
        zzaJJ = cameraposition.zoom;
        zzaJK = cameraposition.tilt;
        zzaJL = cameraposition.bearing;
    }
}
