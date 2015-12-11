// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import java.util.HashMap;
import java.util.TimerTask;

// Referenced classes of package com.wishabi.flipp.b:
//            a

final class j extends TimerTask
{

    final HashMap a;
    final String b;
    final a c;

    j(a a1, HashMap hashmap, String s)
    {
        c = a1;
        a = hashmap;
        b = s;
        super();
    }

    public final void run()
    {
        com.wishabi.flipp.b.a.a(c, "listing", a);
        com.wishabi.flipp.b.a.c(c, b);
    }
}
