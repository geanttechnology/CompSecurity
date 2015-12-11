// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.util.o;
import java.util.Map;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            j

class b
    implements Runnable
{

    final Map a;
    final Map b;
    final j c;

    public void run()
    {
        (new o(a, b)).execute(new String[] {
            j.a(c)
        });
    }

    (j j1, Map map, Map map1)
    {
        c = j1;
        a = map;
        b = map1;
        super();
    }
}
