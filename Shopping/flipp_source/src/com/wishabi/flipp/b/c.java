// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.content.Context;
import android.location.Location;
import java.util.HashMap;

// Referenced classes of package com.wishabi.flipp.b:
//            ab, a

final class c extends ab
{

    final a a;

    c(a a1, Context context)
    {
        a = a1;
        super(context);
    }

    protected final void a(Location location, int i)
    {
        if (i != 0 && i != 1)
        {
            com.wishabi.flipp.b.a.a(a, null);
            com.wishabi.flipp.b.a.k(a);
            return;
        }
        com.wishabi.flipp.b.a.a(a, location);
        if (location == null)
        {
            com.wishabi.flipp.b.a.k(a);
            return;
        } else
        {
            HashMap hashmap = new HashMap();
            hashmap.put("lat", String.valueOf(location.getLatitude()));
            hashmap.put("lon", String.valueOf(location.getLongitude()));
            hashmap.put("accuracy", String.valueOf(location.getAccuracy()));
            com.wishabi.flipp.b.a.a(a, "app_open", hashmap);
            return;
        }
    }
}
