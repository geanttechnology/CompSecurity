// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.location.Location;
import android.location.LocationManager;

// Referenced classes of package com.tapjoy.internal:
//            fi

class fj
{

    private static final String a = com/tapjoy/internal/fj.getName();
    private Location b;
    private LocationManager c;
    private fi d;
    private boolean e;

    fj()
    {
        e = false;
    }

    public final void a()
    {
        boolean flag;
        if (c != null && d != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            c.removeUpdates(d);
        }
    }

    public final Location b()
    {
        Location location1 = b;
        Location location = location1;
        if (location1 == null)
        {
            location = location1;
            if (d != null)
            {
                location = d.a();
            }
        }
        return location;
    }

}
