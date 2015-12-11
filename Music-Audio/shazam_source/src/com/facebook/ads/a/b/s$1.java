// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.b;

import com.facebook.ads.a.f.o;
import java.util.Map;

// Referenced classes of package com.facebook.ads.a.b:
//            s

final class b
    implements Runnable
{

    final Map a;
    final Map b;
    final s c;

    public final void run()
    {
        (new o(a, b)).execute(new String[] {
            s.a(c)
        });
    }

    (s s1, Map map, Map map1)
    {
        c = s1;
        a = map;
        b = map1;
        super();
    }
}
