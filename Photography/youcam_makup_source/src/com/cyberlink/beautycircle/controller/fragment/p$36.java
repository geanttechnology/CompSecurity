// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.cyberlink.beautycircle.controller.adapter.v;
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
            "OnLikeChange, mUserId=", Long.valueOf(p.a(a))
        });
        if (p.h(a))
        {
            p.a(a, true);
            if (p.m(a) != null)
            {
                p.m(a).g = true;
            }
        }
    }

    _cls9(p p1)
    {
        a = p1;
        super();
    }
}
