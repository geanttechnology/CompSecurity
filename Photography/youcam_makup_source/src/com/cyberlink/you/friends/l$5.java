// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.friends;

import com.cyberlink.you.g;
import java.util.List;

// Referenced classes of package com.cyberlink.you.friends:
//            l, r

class c
    implements Runnable
{

    final String a;
    final String b;
    final List c;
    final l d;

    public void run()
    {
        String s = g.a().e();
        if (!l.a(g.a().e(g.a()), s, false))
        {
            r.a(l.b(d), a, b, c, null, null);
        }
    }

    (l l1, String s, String s1, List list)
    {
        d = l1;
        a = s;
        b = s1;
        c = list;
        super();
    }
}
