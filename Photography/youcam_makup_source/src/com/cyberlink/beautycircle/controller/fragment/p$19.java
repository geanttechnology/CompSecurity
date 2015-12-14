// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.cyberlink.beautycircle.model.UserInfo;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p

class a
    implements Runnable
{

    final UserInfo a;
    final p b;

    public void run()
    {
        boolean flag1 = true;
        p p1 = b;
        boolean flag;
        if (p.h(b) && !p.f(b))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        p1.d(flag);
        if (p.h(b) && p.f(b))
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        p.b(b, a, flag);
    }

    _cls9(p p1, UserInfo userinfo)
    {
        b = p1;
        a = userinfo;
        super();
    }
}
