// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.cyberlink.beautycircle.controller.adapter.c;
import com.cyberlink.beautycircle.controller.adapter.i;
import com.cyberlink.beautycircle.controller.adapter.w;
import com.cyberlink.beautycircle.utility.u;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p

class a
    implements u
{

    final p a;

    public void a()
    {
        e.b(new Object[] {
            "OnFollowChange, mUserId=", Long.valueOf(p.a(a))
        });
        p.a(a, true);
        if (p.k(a) != null)
        {
            p.k(a).g = true;
        }
        if (p.l(a) != null)
        {
            p.l(a).a = true;
        }
        if (!p.h(a) && p.j(a) != null)
        {
            p.j(a).g = true;
        }
    }

    _cls9(p p1)
    {
        a = p1;
        super();
    }
}
