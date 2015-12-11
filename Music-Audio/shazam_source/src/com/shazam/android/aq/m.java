// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aq;

import com.shazam.android.persistence.n.b;
import com.shazam.b.e.a;
import com.shazam.o.r;

// Referenced classes of package com.shazam.android.aq:
//            n

public final class m
    implements n
{

    private final b a;
    private final r b;

    public m(b b1, r r1)
    {
        a = b1;
        b = r1;
    }

    public final String a()
    {
        String s1 = a.h("beacon_sessionid");
        String s = s1;
        if (com.shazam.b.e.a.a(s1))
        {
            s = b.a();
            a.b("beacon_sessionid", s);
        }
        return s;
    }

    public final void b()
    {
        a.b("beacon_sessionid", null);
    }
}
