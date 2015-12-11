// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// Referenced classes of package com.amazon.device.ads:
//            as, co, at, cn

public class af
{

    private static final String i = com/amazon/device/ads/af.getSimpleName();
    public final Map a;
    final boolean b;
    final HashSet c;
    public long d;
    public boolean e;
    boolean f;
    boolean g;
    public final cn h;

    public af()
    {
        as as1 = new as();
        new co();
        this(as1);
    }

    private af(as as1)
    {
        d = 0L;
        e = false;
        f = true;
        h = co.a(i);
        a = new HashMap();
        b = at.a(as1, 14);
        g = b;
        c = new HashSet();
    }

    final HashMap a()
    {
        return new HashMap(a);
    }

}
