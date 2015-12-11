// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.g;

import com.gimbal.internal.c.c;
import com.gimbal.internal.proximity.core.f.b;
import com.gimbal.internal.proximity.core.f.e;
import com.gimbal.internal.proximity.core.f.g;
import com.gimbal.internal.proximity.core.sighting.Sighting;

public final class d
{

    public g a;

    public d()
    {
        a = new b(com/gimbal/internal/proximity/core/sighting/Sighting);
    }

    public final Boolean a(String s)
    {
        boolean flag;
        if (a.a(s, com/gimbal/internal/proximity/core/sighting/Sighting) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    public final void a(Sighting sighting)
    {
        g g1 = a;
        String s = c.d(sighting.getPayload());
        if ((Long)g1.b.a(s, java/lang/Long) != null)
        {
            g1.a.a(s, sighting);
            return;
        } else
        {
            g1.a(s, sighting);
            return;
        }
    }
}
