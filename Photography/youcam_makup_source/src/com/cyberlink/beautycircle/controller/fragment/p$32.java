// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.a;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p

class a
    implements a
{

    final p a;

    public void a(UserInfo userinfo)
    {
        e.b(new Object[0]);
        userinfo = AccountManager.b();
        if (p.f(a) || userinfo == null || userinfo.isEmpty()) goto _L2; else goto _L1
_L1:
        a.d(false);
_L4:
        if (a.a && a.isResumed())
        {
            p.g(a);
        }
        return;
_L2:
        if (userinfo == null || userinfo.isEmpty())
        {
            a.d(true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    _cls9(p p1)
    {
        a = p1;
        super();
    }
}
