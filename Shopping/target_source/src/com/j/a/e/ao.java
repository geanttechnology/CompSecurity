// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import com.j.a.g.m;
import com.j.a.g.w;

// Referenced classes of package com.j.a.e:
//            ap, az

class ao
    implements com.d.a.b.a.a
{

    final az a;

    ao(az az)
    {
        a = az;
        super();
    }

    public transient void a(Object aobj[])
    {
        try
        {
            w.a("Client hide experiment");
            m.a(new ap(this));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            w.b("clientHideExperiment error", ((Exception) (aobj)));
        }
    }
}
