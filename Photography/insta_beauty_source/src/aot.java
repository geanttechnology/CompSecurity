// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.geocoderlib.enums.GeocodingStatus;
import java.util.ArrayList;

public class aot
{

    private GeocodingStatus a;
    private ArrayList b;

    public aot()
    {
        b = new ArrayList();
    }

    public int a()
    {
        return b.size();
    }

    public aoq a(int i)
    {
        return (aoq)b.get(i);
    }

    public void a(aoq aoq1)
    {
        b.add(aoq1);
    }

    public void a(GeocodingStatus geocodingstatus)
    {
        a = geocodingstatus;
    }
}
