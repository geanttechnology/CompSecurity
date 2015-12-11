// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

// Referenced classes of package com.offerup.android.g.a:
//            u

final class v
    implements OnMapReadyCallback
{

    private double a;
    private double b;
    private u c;

    v(u u1, double d, double d1)
    {
        c = u1;
        a = d;
        b = d1;
        super();
    }

    public final void onMapReady(GoogleMap googlemap)
    {
        u.a(c, googlemap, a, b);
    }
}
