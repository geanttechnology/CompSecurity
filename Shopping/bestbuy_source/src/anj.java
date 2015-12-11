// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public final class anj
{

    private LatLng a;
    private float b;
    private float c;
    private float d;

    public anj()
    {
    }

    public anj a(float f)
    {
        b = f;
        return this;
    }

    public anj a(LatLng latlng)
    {
        a = latlng;
        return this;
    }

    public CameraPosition a()
    {
        return new CameraPosition(a, b, c, d);
    }

    public anj b(float f)
    {
        c = f;
        return this;
    }

    public anj c(float f)
    {
        d = f;
        return this;
    }
}
