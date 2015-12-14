// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.widget.EditText;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

public class m extends com.perfectcorp.utility.m
{

    final RegisterActivity a;

    protected m(RegisterActivity registeractivity)
    {
        a = registeractivity;
        super();
    }

    protected void a(int i)
    {
        com.perfectcorp.a.b.a(new aq("email", "no"));
        a.l();
        if (i == 424)
        {
            Object obj1 = (EditText)a.findViewById(j.register_id);
            Object obj = (EditText)a.findViewById(j.register_password);
            if (obj1 == null || obj == null)
            {
                e.e(new Object[] {
                    "Edit views not exist"
                });
                return;
            } else
            {
                obj1 = ((EditText) (obj1)).getText().toString();
                obj = ((EditText) (obj)).getText().toString();
                c.a(a, ((String) (obj1)), ((String) (obj)), RegisterActivity.g(a));
                return;
            }
        }
        if (i == 421)
        {
            String s1 = (new StringBuilder()).append(a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_invalid_email)).append(s.a(i)).toString();
            DialogUtils.a(a, s1);
            return;
        }
        if (i == 419)
        {
            String s2 = (new StringBuilder()).append(a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_invalid_password)).append(s.a(i)).toString();
            DialogUtils.a(a, s2);
            return;
        }
        if (!com.cyberlink.beautycircle.model.network.c.a())
        {
            String s3 = (new StringBuilder()).append(a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_network_unavailabe)).append(s.a(i)).toString();
            DialogUtils.a(a, s3);
            return;
        } else
        {
            String s4 = (new StringBuilder()).append(a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_unknown_error)).append(s.a(i)).toString();
            AccountManager.h();
            DialogUtils.a(a, s4);
            return;
        }
    }

    protected void a(com.cyberlink.beautycircle.model.UserInfo.SignInResult signinresult)
    {
        long l = -1L;
        com.perfectcorp.a.b.a(new aq("email", "yes"));
        AccountManager.a(com.cyberlink.beautycircle.utility.AccountManager.AccountSource.a);
        RegisterActivity.a(a, RegisterActivity.a(a, signinresult.userInfo));
        if (RegisterActivity.f(a))
        {
            UserInfo userinfo = signinresult.userInfo;
            String s1;
            if (signinresult.userInfo != null)
            {
                s1 = AccountManager.k();
            } else
            {
                s1 = null;
            }
            userinfo.displayName = s1;
            RegisterActivity.a(a, signinresult.token, signinresult.userInfo, -1L, -1L);
            return;
        }
        RegisterActivity registeractivity = a;
        String s2 = signinresult.token;
        UserInfo userinfo1 = signinresult.userInfo;
        if (signinresult.userInfo != null)
        {
            l = signinresult.userInfo.id;
        }
        RegisterActivity.a(registeractivity, s2, userinfo1, l);
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.UserInfo.SignInResult)obj);
    }
}
