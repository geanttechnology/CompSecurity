// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterVerifyActivity

public class n extends m
{

    final RegisterVerifyActivity a;

    protected n(RegisterVerifyActivity registerverifyactivity)
    {
        a = registerverifyactivity;
        super();
    }

    protected void a(int i)
    {
        a.l();
        e.b(new Object[] {
            "Fail: ", Integer.valueOf(i)
        });
        String s1 = (new StringBuilder()).append(a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_wait_validate_fail)).append(s.a(i)).toString();
        DialogUtils.a(a, s1);
    }

    protected void a(com.cyberlink.beautycircle.model.UserInfo.SignInResult signinresult)
    {
        if (signinresult.userInfo != null && signinresult.token != null && !signinresult.token.isEmpty())
        {
            e.b(new Object[] {
                "Success"
            });
            String s1 = signinresult.token;
            UserInfo userinfo = (UserInfo)Model.a(com/cyberlink/beautycircle/model/UserInfo, signinresult.userInfo.toString());
            AccountManager.a(com.cyberlink.beautycircle.utility.AccountManager.AccountSource.a);
            if (userinfo != null)
            {
                signinresult = AccountManager.k();
            } else
            {
                signinresult = null;
            }
            userinfo.displayName = signinresult;
            RegisterVerifyActivity.a(a, s1, userinfo, -1L, -1L);
            return;
        } else
        {
            a.l();
            e.b(new Object[] {
                "Fail: userInfo is null"
            });
            DialogUtils.a(a, a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_wait_validate_fail));
            return;
        }
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.UserInfo.SignInResult)obj);
    }
}
