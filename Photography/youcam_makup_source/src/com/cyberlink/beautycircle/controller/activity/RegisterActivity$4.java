// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.a.ar;
import com.cyberlink.beautycircle.controller.a.as;
import com.cyberlink.beautycircle.controller.a.at;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.view.widgetpool.facebook.LoginButton;
import com.facebook.Session;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class a extends m
{

    final Session a;
    final RegisterActivity b;

    protected void a(int i)
    {
        b.l();
        if (b.i != null)
        {
            b.i.b();
        }
        DialogUtils.a(b, b.getResources().getString(com.cyberlink.beautycircle.m.bc_register_facebook_sign_in_failed));
        com.perfectcorp.a.b.a(new aq("facebook", "no"));
    }

    protected void a(com.cyberlink.beautycircle.model.lt lt)
    {
        AccountManager.a(com.cyberlink.beautycircle.utility.untSource.b);
        RegisterActivity.a(b, RegisterActivity.a(b, lt.userInfo));
        if (RegisterActivity.f(b))
        {
            RegisterActivity.a(b, a, lt.token, lt.userInfo);
        } else
        {
            RegisterActivity registeractivity = b;
            String s = lt.token;
            UserInfo userinfo = lt.userInfo;
            long l;
            if (lt.userInfo != null)
            {
                l = lt.userInfo.id;
            } else
            {
                l = -1L;
            }
            RegisterActivity.a(registeractivity, s, userinfo, l).a(new j(lt) {

                final com.cyberlink.beautycircle.model.UserInfo.SignInResult a;
                final RegisterActivity._cls4 b;

                protected UserInfo a(UserInfo userinfo1)
                {
                    if (userinfo1.receiveEmail == null || userinfo1.receiveEmail.isEmpty())
                    {
                        RegisterActivity.a(b.b, b.a, a.token, userinfo1, null);
                    }
                    return null;
                }

                protected volatile Object a(Object obj)
                {
                    return a((UserInfo)obj);
                }

            
            {
                b = RegisterActivity._cls4.this;
                a = signinresult;
                super();
            }
            });
        }
        if (RegisterActivity.e(b) != geMode.a) goto _L2; else goto _L1
_L1:
        com.perfectcorp.a.b.a(new at("facebook"));
_L4:
        com.perfectcorp.a.b.a(new aq("facebook", "yes"));
        return;
_L2:
        if (RegisterActivity.e(b) == geMode.a)
        {
            com.perfectcorp.a.b.a(new as("facebook"));
        } else
        if (RegisterActivity.e(b) == geMode.c || RegisterActivity.e(b) == geMode.d)
        {
            com.perfectcorp.a.b.a(new ar("facebook"));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.lt)obj);
    }

    _cls1.a(RegisterActivity registeractivity, Session session)
    {
        b = registeractivity;
        a = session;
        super();
    }
}
