// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.model.UserInfo;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.l;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class b extends l
{

    final String a;
    final UserInfo b;
    final RegisterActivity c;

    protected void a(int i)
    {
        super.a(i);
        e.d(new Object[] {
            "Get twitter info fail."
        });
        RegisterActivity.b(c, a, b);
    }

    protected void a(com.cyberlink.beautycircle.model.network.foResult foresult)
    {
        if (foresult != null)
        {
            if (!RegisterActivity.a(c, a, foresult.headimgurl, b))
            {
                RegisterActivity.a(c, a, b, -1L, -1L);
            }
            return;
        } else
        {
            e.d(new Object[] {
                "Get twitter info fail."
            });
            RegisterActivity.b(c, a, b);
            return;
        }
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.network.foResult)obj);
    }

    lt(RegisterActivity registeractivity, String s, UserInfo userinfo)
    {
        c = registeractivity;
        a = s;
        b = userinfo;
        super();
    }
}
