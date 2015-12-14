// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class d extends m
{

    final String a;
    final UserInfo b;
    final long c;
    final long d;
    final RegisterActivity e;

    protected void a()
    {
        RegisterActivity.b(e, a, b);
    }

    protected void a(int i)
    {
        Globals.b((new StringBuilder()).append("Code:'").append(i).toString());
        if (i == 445)
        {
            b.displayName = AccountManager.e();
            RegisterActivity.a(e, a, b, c, d);
            return;
        }
        if (i == 420)
        {
            RegisterActivity.a(e, 48258);
            return;
        } else
        {
            RegisterActivity.b(e, a, b);
            return;
        }
    }

    protected void a(com.cyberlink.beautycircle.model.esponse esponse)
    {
        try
        {
            RegisterActivity.a(e, a, b, esponse.userId);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.cyberlink.beautycircle.model.esponse esponse)
        {
            esponse.printStackTrace();
        }
        RegisterActivity.b(e, a, b);
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.esponse)obj);
    }

    (RegisterActivity registeractivity, String s, UserInfo userinfo, long l, long l1)
    {
        e = registeractivity;
        a = s;
        b = userinfo;
        c = l;
        d = l1;
        super();
    }
}
