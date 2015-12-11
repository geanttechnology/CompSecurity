// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.location.Location;

// Referenced classes of package com.amazon.device.ads:
//            b, ba, cm, y, 
//            af, t

static final class D extends D
{

    private final ba C;
    private final Context D;

    protected final Object b(D d)
    {
        if (C.b(.f) && d.a.a.e)
        {
            d = (new t(D)).a();
            if (d != null)
            {
                return (new StringBuilder()).append(d.getLatitude()).append(",").append(d.getLongitude()).toString();
            }
        }
        return null;
    }

    ()
    {
        this(ba.a(), cm.a().b());
    }

    private (ba ba1, Context context)
    {
        super("geoloc", "debug.geoloc");
        C = ba1;
        D = context;
    }
}
