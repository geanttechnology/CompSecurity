// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.geocoderlib.enums.GeocodingStatus;
import java.util.ArrayList;

public class jo
{

    private GeocodingStatus a;
    private ArrayList b;

    public jo()
    {
        b = new ArrayList();
    }

    public int a()
    {
        return b.size();
    }

    public jl a(int i)
    {
        return (jl)b.get(i);
    }

    public void a(GeocodingStatus geocodingstatus)
    {
        a = geocodingstatus;
    }

    public void a(jl jl1)
    {
        b.add(jl1);
    }
}
