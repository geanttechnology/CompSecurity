// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import com.google.android.gms.internal.eg;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLngBounds, LatLng

public static final class CK
{

    private double CH;
    private double CI;
    private double CJ;
    private double CK;

    private boolean d(double d1)
    {
        boolean flag = false;
        if (CJ <= CK)
        {
            return CJ <= d1 && d1 <= CK;
        }
        if (CJ <= d1 || d1 <= CK)
        {
            flag = true;
        }
        return flag;
    }

    public LatLngBounds build()
    {
        boolean flag;
        if (!Double.isNaN(CJ))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.a(flag, "no included points");
        return new LatLngBounds(new LatLng(CH, CJ), new LatLng(CI, CK));
    }

    public CK include(LatLng latlng)
    {
        CH = Math.min(CH, latlng.latitude);
        CI = Math.max(CI, latlng.latitude);
        double d1 = latlng.longitude;
        if (Double.isNaN(CJ))
        {
            CJ = d1;
            CK = d1;
        } else
        if (!d(d1))
        {
            if (LatLngBounds.d(CJ, d1) < LatLngBounds.e(CK, d1))
            {
                CJ = d1;
                return this;
            } else
            {
                CK = d1;
                return this;
            }
        }
        return this;
    }

    public ()
    {
        CH = (1.0D / 0.0D);
        CI = (-1.0D / 0.0D);
        CJ = (0.0D / 0.0D);
        CK = (0.0D / 0.0D);
    }
}
