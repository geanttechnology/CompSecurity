// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.sighting.b;

import com.gimbal.a.a;
import com.gimbal.internal.c.c;
import com.gimbal.internal.proximity.core.g.d;
import com.gimbal.internal.proximity.core.sighting.Sighting;

// Referenced classes of package com.gimbal.internal.proximity.core.sighting.b:
//            d

public class f
    implements com.gimbal.internal.proximity.core.sighting.b.d
{

    private static final a a = c.e(com/gimbal/internal/proximity/core/sighting/b/f.getName());
    private d b;

    public f(d d1)
    {
        b = d1;
    }

    public final boolean a(Sighting sighting)
    {
        if (b.a(c.d(sighting.getPayload())).booleanValue())
        {
            sighting.getPayload();
            b.a(sighting);
            return true;
        } else
        {
            return false;
        }
    }

}
