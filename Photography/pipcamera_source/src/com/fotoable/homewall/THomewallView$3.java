// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.homewall;

import ki;
import pc;

// Referenced classes of package com.fotoable.homewall:
//            THomewallView

class a
    implements pc
{

    final ki a;
    final THomewallView b;

    public void a()
    {
        a.l = true;
        if (!a.m && b.hasStartedPlay)
        {
            THomewallView.access$200(b);
        }
    }

    (THomewallView thomewallview, ki ki1)
    {
        b = thomewallview;
        a = ki1;
        super();
    }
}
