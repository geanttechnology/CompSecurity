// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a;

import com.b.b.d;
import java.util.HashMap;

// Referenced classes of package com.b.a:
//            b

final class o
    implements Runnable
{

    final d a;
    final HashMap b;
    final b c;

    o(b b1, d d, HashMap hashmap)
    {
        c = b1;
        a = d;
        b = hashmap;
        super();
    }

    public final void run()
    {
        c.a(a, b);
    }
}
