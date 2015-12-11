// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.location.Location;
import com.google.android.gms.common.c;
import com.google.android.gms.internal.iu;
import com.google.android.gms.location.e;
import com.localytics.android.Localytics;
import java.util.HashMap;

// Referenced classes of package com.wishabi.flipp.b:
//            a

final class d
    implements c
{

    final a a;

    d(a a1)
    {
        a = a1;
        super();
    }

    public final void a_()
    {
        if (com.wishabi.flipp.b.a.l(a).a.e())
        {
            Location location = com.wishabi.flipp.b.a.l(a).a();
            com.wishabi.flipp.b.a.l(a).a.g();
            com.wishabi.flipp.b.a.m(a);
            if (location != null)
            {
                com.wishabi.flipp.b.a.a(a, location);
                HashMap hashmap = new HashMap();
                hashmap.put("lat", String.valueOf(location.getLatitude()));
                hashmap.put("lon", String.valueOf(location.getLongitude()));
                hashmap.put("accuracy", String.valueOf(location.getAccuracy()));
                hashmap.put("postal_code", com.wishabi.flipp.b.a.n(a));
                com.wishabi.flipp.b.a.a(a, "location", hashmap);
                Localytics.setLocation(location);
                return;
            }
        }
    }

    public final void b()
    {
    }
}
