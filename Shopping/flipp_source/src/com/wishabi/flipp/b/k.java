// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import java.util.HashMap;
import java.util.TimerTask;

// Referenced classes of package com.wishabi.flipp.b:
//            a

final class k extends TimerTask
{

    final HashMap a;
    final String b = null;
    final String c = null;
    final String d = null;
    final String e;
    final a f;

    k(a a1, HashMap hashmap, String s)
    {
        f = a1;
        a = hashmap;
        e = s;
        super();
    }

    public final void run()
    {
        com.wishabi.flipp.b.a.a(f, "listing", a);
        if (b != null && c != null && d != null)
        {
            f.a(b, c, d);
        }
        com.wishabi.flipp.b.a.c(f, e);
    }
}
