// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Activity;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.c;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p

class a extends m
{

    final p a;

    public void a()
    {
        a(0x80000005);
    }

    public void a(int i)
    {
        Globals.b((new StringBuilder()).append("Fetching UserInfo error: ").append(i).toString());
    }

    public void a(UserInfo userinfo)
    {
        if (userinfo != null)
        {
            if (p.h(a))
            {
                AccountManager.a(AccountManager.b(), userinfo, false);
            }
            p.a(a, userinfo);
            p.a(a, false);
            p.g(a);
        }
        userinfo = a.getActivity();
        if (userinfo != null && !c.a())
        {
            ((BaseActivity)userinfo).a(userinfo.getString(com.cyberlink.beautycircle.m.bc_server_connect_fail), 3000);
        }
    }

    public void b(Object obj)
    {
        a((UserInfo)obj);
    }

    (p p1)
    {
        a = p1;
        super();
    }
}
