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

class a extends j
{

    final com.cyberlink.beautycircle.model. a;
    final a b;

    protected UserInfo a(UserInfo userinfo)
    {
        if (userinfo.receiveEmail == null || userinfo.receiveEmail.isEmpty())
        {
            RegisterActivity.a(b.b, b.b, a.token, userinfo, null);
        }
        return null;
    }

    protected volatile Object a(Object obj)
    {
        return a((UserInfo)obj);
    }

    Mode(Mode mode, com.cyberlink.beautycircle.model. )
    {
        b = mode;
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/RegisterActivity$4

/* anonymous class */
    class RegisterActivity._cls4 extends m
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

        protected void a(com.cyberlink.beautycircle.model.UserInfo.SignInResult signinresult)
        {
            AccountManager.a(com.cyberlink.beautycircle.utility.AccountManager.AccountSource.b);
            RegisterActivity.a(b, RegisterActivity.a(b, signinresult.userInfo));
            if (RegisterActivity.f(b))
            {
                RegisterActivity.a(b, a, signinresult.token, signinresult.userInfo);
            } else
            {
                RegisterActivity registeractivity = b;
                String s = signinresult.token;
                UserInfo userinfo = signinresult.userInfo;
                long l;
                if (signinresult.userInfo != null)
                {
                    l = signinresult.userInfo.id;
                } else
                {
                    l = -1L;
                }
                RegisterActivity.a(registeractivity, s, userinfo, l).a(new RegisterActivity._cls4._cls1(this, signinresult));
            }
            if (RegisterActivity.e(b) != RegisterActivity.PageMode.a) goto _L2; else goto _L1
_L1:
            com.perfectcorp.a.b.a(new at("facebook"));
_L4:
            com.perfectcorp.a.b.a(new aq("facebook", "yes"));
            return;
_L2:
            if (RegisterActivity.e(b) == RegisterActivity.PageMode.a)
            {
                com.perfectcorp.a.b.a(new as("facebook"));
            } else
            if (RegisterActivity.e(b) == RegisterActivity.PageMode.c || RegisterActivity.e(b) == RegisterActivity.PageMode.d)
            {
                com.perfectcorp.a.b.a(new ar("facebook"));
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        protected void b(Object obj)
        {
            a((com.cyberlink.beautycircle.model.UserInfo.SignInResult)obj);
        }

            
            {
                b = registeractivity;
                a = session;
                super();
            }
    }

}
