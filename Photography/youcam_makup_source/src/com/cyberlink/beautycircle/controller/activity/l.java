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
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

public class l extends m
{

    final RegisterActivity a;

    protected l(RegisterActivity registeractivity)
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
        if (i == 422)
        {
            String s1 = (new StringBuilder()).append(a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_invalid_locale)).append(s.a(i)).toString();
            DialogUtils.a(a, s1);
            return;
        }
        if (i == 421)
        {
            String s2 = (new StringBuilder()).append(a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_invalid_email)).append(s.a(i)).toString();
            DialogUtils.a(a, s2);
            return;
        }
        if (i == 419)
        {
            String s3 = (new StringBuilder()).append(a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_account_be_registered_before)).append(s.a(i)).toString();
            DialogUtils.a(a, s3);
            return;
        }
        if (i == 503)
        {
            String s4 = (new StringBuilder()).append(a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_server_error)).append(s.a(i)).toString();
            DialogUtils.a(a, s4);
            return;
        }
        if (!com.cyberlink.beautycircle.model.network.c.a())
        {
            String s5 = (new StringBuilder()).append(a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_network_unavailabe)).append(s.a(i)).toString();
            DialogUtils.a(a, s5);
            return;
        } else
        {
            String s6 = (new StringBuilder()).append(a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_unknown_error)).append(s.a(i)).toString();
            AccountManager.h();
            DialogUtils.a(a, s6);
            return;
        }
    }

    protected void a(com.cyberlink.beautycircle.model.network.NetworkUser.CreateCLAccountResult createclaccountresult)
    {
        long l1;
        l1 = -1L;
        com.perfectcorp.a.b.a(new aq("email", "yes"));
        if (!createclaccountresult.status.equals("OK")) goto _L2; else goto _L1
_L1:
        AccountManager.a(com.cyberlink.beautycircle.utility.AccountManager.AccountSource.a);
        RegisterActivity.a(a, RegisterActivity.a(a, createclaccountresult.result.userInfo));
        if (!RegisterActivity.f(a)) goto _L4; else goto _L3
_L3:
        UserInfo userinfo = createclaccountresult.result.userInfo;
        String s1;
        if (createclaccountresult.result.userInfo != null)
        {
            s1 = AccountManager.k();
        } else
        {
            s1 = null;
        }
        userinfo.displayName = s1;
        RegisterActivity.a(a, createclaccountresult.result.token, createclaccountresult.result.userInfo, -1L, -1L);
_L6:
        return;
_L4:
        RegisterActivity registeractivity = a;
        String s2 = createclaccountresult.result.token;
        UserInfo userinfo1 = createclaccountresult.result.userInfo;
        if (createclaccountresult.result.userInfo != null)
        {
            l1 = createclaccountresult.result.userInfo.id;
        }
        RegisterActivity.a(registeractivity, s2, userinfo1, l1);
        return;
_L2:
        if (createclaccountresult.status.equals("WaitValidate"))
        {
            a(424);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.network.NetworkUser.CreateCLAccountResult)obj);
    }
}
