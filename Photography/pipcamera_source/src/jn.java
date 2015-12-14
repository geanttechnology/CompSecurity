// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.geocoderlib.enums.GeocodingLanguage;
import com.fotoable.geocoderlib.enums.GeocodingType;
import com.fotoable.geocoderlib.enums.GeocodingTypes;
import java.util.ArrayList;

public class jn
{

    private GeocodingLanguage a;
    private GeocodingType b;
    private boolean c;
    private int d;
    private int e;
    private boolean f;
    private ArrayList g;

    public jn()
    {
        a = GeocodingLanguage.EN;
        b = GeocodingType.BY_ADDRESS;
        c = true;
        d = 5000;
        e = 5000;
        f = true;
        g = new ArrayList();
    }

    public GeocodingLanguage a()
    {
        return a;
    }

    public void a(GeocodingLanguage geocodinglanguage)
    {
        a = geocodinglanguage;
    }

    public void a(GeocodingTypes geocodingtypes)
    {
        g.add(geocodingtypes);
    }

    public GeocodingType b()
    {
        return b;
    }

    public boolean c()
    {
        return c;
    }

    public int d()
    {
        return d;
    }

    public int e()
    {
        return e;
    }

    public ArrayList f()
    {
        return g;
    }
}
