// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.UserInfo;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            FreeSampleActivity

class a extends m
{

    final FreeSampleActivity a;

    public void a(int i)
    {
        Globals.b((new StringBuilder()).append("Fetching UserInfo error: ").append(i).toString());
    }

    public void a(UserInfo userinfo)
    {
        if (userinfo != null)
        {
            FreeSampleActivity.a(a, userinfo);
            if (userinfo.isFollowed.booleanValue())
            {
                c.a(a, FreeSampleActivity.a(a));
                return;
            } else
            {
                a.o();
                return;
            }
        } else
        {
            a(0x80000003);
            return;
        }
    }

    public void b(Object obj)
    {
        a((UserInfo)obj);
    }

    I(FreeSampleActivity freesampleactivity)
    {
        a = freesampleactivity;
        super();
    }
}
