// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.geocoderlib.enums.LocationType;

public class ju
{

    private double a;
    private double b;
    private LocationType c;
    private jv d;

    public ju()
    {
        c = LocationType.NONE;
    }

    public double a()
    {
        return a;
    }

    public void a(double d1)
    {
        a = d1;
    }

    public void a(LocationType locationtype)
    {
        c = locationtype;
    }

    public void a(jv jv)
    {
        d = jv;
    }

    public double b()
    {
        return b;
    }

    public void b(double d1)
    {
        b = d1;
    }
}
