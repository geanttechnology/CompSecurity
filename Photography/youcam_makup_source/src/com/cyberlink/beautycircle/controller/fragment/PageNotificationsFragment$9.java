// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.cyberlink.beautycircle.controller.adapter.k;
import com.cyberlink.beautycircle.controller.adapter.t;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.a;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            PageNotificationsFragment

class a
    implements a
{

    final PageNotificationsFragment a;

    public void a(UserInfo userinfo)
    {
        e.b(new Object[0]);
        userinfo = AccountManager.b();
        if (userinfo == null || userinfo.isEmpty() || PageNotificationsFragment.b(a) && !PageNotificationsFragment.c(a)) goto _L2; else goto _L1
_L1:
        PageNotificationsFragment.d(a);
        a.d(false);
_L4:
        if (com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.e(a) != null)
        {
            com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.e(a).g = true;
        }
        if (PageNotificationsFragment.f(a) != null)
        {
            PageNotificationsFragment.f(a).g = true;
        }
        if (PageNotificationsFragment.c(a))
        {
            PageNotificationsFragment.c(a, false);
        }
        if (a.a && a.isResumed())
        {
            PageNotificationsFragment.g(a);
        }
        return;
_L2:
        if (userinfo == null || userinfo.isEmpty())
        {
            if (com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.e(a) != null)
            {
                com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.e(a).e();
            }
            if (PageNotificationsFragment.f(a) != null)
            {
                PageNotificationsFragment.f(a).e();
            }
            PageNotificationsFragment.b(a, false);
            a.d(true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    (PageNotificationsFragment pagenotificationsfragment)
    {
        a = pagenotificationsfragment;
        super();
    }
}
