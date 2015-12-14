// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.cyberlink.beautycircle.controller.adapter.c;
import com.cyberlink.beautycircle.controller.adapter.w;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.q;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p

class a
    implements q
{

    final p a;

    public void a()
    {
        p.e(a, true);
    }

    public void a(UserInfo userinfo, boolean flag)
    {
        if (!p.h(a))
        {
            int j = p.a(a, com.cyberlink.beautycircle.model.Item.MeListMode.e, 0);
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = -1;
            }
            p.g(a, i + j);
            if (p.H(a) == com.cyberlink.beautycircle.model.Item.MeListMode.e)
            {
                if (!p.k(a).a(AccountManager.c().longValue(), flag))
                {
                    p.k(a).c();
                }
            } else
            if (p.H(a) == com.cyberlink.beautycircle.model.Item.MeListMode.b && p.j(a) != null)
            {
                p.j(a).c();
                return;
            }
        }
    }

    e(p p1)
    {
        a = p1;
        super();
    }
}
