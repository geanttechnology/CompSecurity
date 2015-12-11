// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a.a;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import java.util.Timer;

// Referenced classes of package com.b.a.a:
//            c, d, g, e, 
//            f

public final class b
{

    Timer a;
    LocationManager b;
    f c;
    boolean d;
    boolean e;
    LocationListener f;
    LocationListener g;
    private String h;

    public b()
    {
        h = "LocationManagerUtils";
        d = false;
        e = false;
        f = new c(this);
        g = new d(this);
    }

    static String a(b b1)
    {
        return b1.h;
    }

    public final boolean a(Context context, f f1)
    {
        c = f1;
        if (b == null)
        {
            b = (LocationManager)context.getSystemService("location");
        }
        try
        {
            d = b.isProviderEnabled("network");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.b.a.a.g.a(h, context);
        }
        try
        {
            e = b.isProviderEnabled("passive");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.b.a.a.g.a(h, context);
        }
        if (!d && !e)
        {
            return false;
        }
        if (d)
        {
            b.requestLocationUpdates("network", 0L, 0.0F, f);
        }
        if (e)
        {
            b.requestLocationUpdates("passive", 0L, 0.0F, g);
        }
        a = new Timer();
        a.schedule(new e(this), 5L);
        return true;
    }
}
