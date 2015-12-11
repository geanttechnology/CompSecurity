// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzig

public class 
{

    private final List zzIW = new ArrayList();
    private final List zzIX = new ArrayList();
    private final List zzIY = new ArrayList();

    static List zza( )
    {
        return .zzIX;
    }

    static List zzb(zzIX zzix)
    {
        return zzix.zzIW;
    }

    static List zzc(zzIW zziw)
    {
        return zziw.zzIY;
    }

    public zzIY zza(String s, double d, double d1)
    {
        int i = 0;
        do
        {
            if (i >= zzIW.size())
            {
                break;
            }
            double d2 = ((Double)zzIY.get(i)).doubleValue();
            double d3 = ((Double)zzIX.get(i)).doubleValue();
            if (d < d2 || d2 == d && d1 < d3)
            {
                break;
            }
            i++;
        } while (true);
        zzIW.add(i, s);
        zzIY.add(i, Double.valueOf(d));
        zzIX.add(i, Double.valueOf(d1));
        return this;
    }

    public zzig zzgK()
    {
        return new zzig(this, null);
    }

    public ()
    {
    }
}
