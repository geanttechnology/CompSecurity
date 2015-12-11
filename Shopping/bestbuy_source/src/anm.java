// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public final class anm
{

    public float a;
    public float b;

    public anm()
    {
    }

    public anm a(float f)
    {
        b = f;
        return this;
    }

    public StreetViewPanoramaOrientation a()
    {
        return new StreetViewPanoramaOrientation(b, a);
    }

    public anm b(float f)
    {
        a = f;
        return this;
    }
}
