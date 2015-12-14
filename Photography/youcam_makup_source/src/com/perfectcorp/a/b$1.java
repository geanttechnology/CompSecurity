// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.a;

import com.cyberlink.uma.UMA;
import com.perfectcorp.utility.e;

// Referenced classes of package com.perfectcorp.a:
//            b, a

final class >
    implements Runnable
{

    final a a;

    public void run()
    {
        if (a.b() == null)
        {
            e.d(new Object[] {
                "Parameters is null"
            });
            UMA.a(a.a());
            return;
        } else
        {
            UMA.a(a.a(), a.b(), a.c());
            return;
        }
    }

    y.e(a a1)
    {
        a = a1;
        super();
    }
}
