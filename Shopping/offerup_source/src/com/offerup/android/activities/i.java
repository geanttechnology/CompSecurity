// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.location.Location;
import com.b.a.a.g;
import com.offerup.android.i.f;

// Referenced classes of package com.offerup.android.activities:
//            h

final class i
    implements f
{

    private h a;

    i(h h1)
    {
        a = h1;
        super();
    }

    public final void a()
    {
        g.b(h.a(a), "GoogleLocationClient::onLocationFailed");
        h.b(a);
    }

    public final void a(Location location)
    {
        g.b(h.a(a), "GoogleLocationClient::onLocation");
        if (location != null)
        {
            a.a(location);
            return;
        } else
        {
            h.b(a);
            return;
        }
    }
}
