// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.UserInfo;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class b extends j
{

    final UserInfo a;
    final String b;
    final RegisterActivity c;

    protected UserInfo a(UserInfo userinfo)
    {
        UserInfo userinfo1 = userinfo;
        if (userinfo == null)
        {
            userinfo1 = a;
        }
        RegisterActivity.b(c, b, userinfo1);
        return userinfo1;
    }

    protected volatile Object a(Object obj)
    {
        return a((UserInfo)obj);
    }

    protected void a()
    {
        RegisterActivity.b(c, b, a);
        super.a();
    }

    protected void a(int i)
    {
        if (i == 420)
        {
            RegisterActivity.a(c, 48258);
        } else
        {
            RegisterActivity.b(c, b, a);
        }
        Globals.b((new StringBuilder()).append("Code:'").append(i).toString());
        super.a(i);
    }

    (RegisterActivity registeractivity, UserInfo userinfo, String s)
    {
        c = registeractivity;
        a = userinfo;
        b = s;
        super();
    }
}
