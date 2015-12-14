// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

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
    }

    public void a(UserInfo userinfo, boolean flag)
    {
        if (p.h(a))
        {
            int j = p.a(a, com.cyberlink.beautycircle.model.Item.MeListMode.f, 0);
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = -1;
            }
            i += j;
            p.f(a, i);
            AccountManager.a(null, Integer.valueOf(i));
            if (p.e(a) != null)
            {
                p.e(a).followingCount = Integer.valueOf(i);
            }
        }
    }

    e(p p1)
    {
        a = p1;
        super();
    }
}
