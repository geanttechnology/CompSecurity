// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.TimerTask;

// Referenced classes of package com.amazon.device.ads:
//            h, bc, k, ae

final class  extends TimerTask
{

    final h a;

    public final void run()
    {
        h h1 = a;
        if (h1.n.a("debug.canTimeout", Boolean.valueOf(true)).booleanValue() && !h1.p())
        {
            h1.b(new k(b, "Ad Load Timed Out"));
            h1.a(ae.j);
        }
    }

    (h h1)
    {
        a = h1;
        super();
    }
}
