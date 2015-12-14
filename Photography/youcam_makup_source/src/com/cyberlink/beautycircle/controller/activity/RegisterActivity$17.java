// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.model.UserInfo;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class b extends m
{

    final String a;
    final UserInfo b;
    final RegisterActivity c;

    protected void a(int i)
    {
        if (i == 420)
        {
            RegisterActivity.a(c, 48258);
            return;
        } else
        {
            RegisterActivity.a(c, a, b, -1L, -1L);
            return;
        }
    }

    protected void a(com.cyberlink.beautycircle.model.network.leResult leresult)
    {
        if (leresult == null || leresult.fileId == null)
        {
            b(0x80000001);
            return;
        } else
        {
            RegisterActivity.a(c, a, b, leresult.fileId.longValue(), -1L);
            return;
        }
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.network.leResult)obj);
    }

    lt(RegisterActivity registeractivity, String s, UserInfo userinfo)
    {
        c = registeractivity;
        a = s;
        b = userinfo;
        super();
    }
}
