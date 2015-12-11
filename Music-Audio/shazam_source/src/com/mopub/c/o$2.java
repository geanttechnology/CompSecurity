// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import com.mopub.common.c.a;
import com.mopub.d.s;

// Referenced classes of package com.mopub.c:
//            o, c

final class 
    implements Runnable
{

    final s a;
    final o b;

    public final void run()
    {
        try
        {
            b.c.a(a);
            b.c();
            return;
        }
        catch (s s1)
        {
            com.mopub.common.c.a.b((new StringBuilder("Failed to Scribe events: ")).append(a).toString());
        }
        b.d();
    }

    .c.a(o o1, s s1)
    {
        b = o1;
        a = s1;
        super();
    }
}
