// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.a.ar;
import com.cyberlink.beautycircle.controller.a.as;
import com.cyberlink.beautycircle.controller.a.at;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.QQUtils;
import com.cyberlink.beautycircle.utility.s;
import com.perfectcorp.a.b;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import com.tencent.tauth.d;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class a extends m
{

    final a a;

    protected void a(int i)
    {
        a.a.l();
        DialogUtils.a(a.a, a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_qq_sign_in_failed));
        com.perfectcorp.a.b.a(new aq("qq", "no"));
    }

    protected void a(com.cyberlink.beautycircle.model.Activity._cls11._cls1 _pcls1)
    {
        AccountManager.a(com.cyberlink.beautycircle.utility.Source.e);
        RegisterActivity.a(a.a, RegisterActivity.a(a.a, _pcls1.userInfo));
        if (RegisterActivity.f(a.a))
        {
            com.cyberlink.beautycircle.controller.activity.RegisterActivity.d(a.a, _pcls1.token, _pcls1.userInfo);
        } else
        {
            RegisterActivity registeractivity = a.a;
            String s = _pcls1.token;
            UserInfo userinfo = _pcls1.userInfo;
            long l;
            if (_pcls1.userInfo != null)
            {
                l = _pcls1.userInfo.id;
            } else
            {
                l = -1L;
            }
            RegisterActivity.a(registeractivity, s, userinfo, l);
        }
        if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) != ode.a) goto _L2; else goto _L1
_L1:
        com.perfectcorp.a.b.a(new at("qq"));
_L4:
        com.perfectcorp.a.b.a(new aq("qq", "yes"));
        return;
_L2:
        if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.ode.b)
        {
            com.perfectcorp.a.b.a(new as("qq"));
        } else
        if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == ode.c || com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.ode.d)
        {
            com.perfectcorp.a.b.a(new ar("qq"));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.Activity._cls11._cls1.a)obj);
    }

    ode(ode ode)
    {
        a = ode;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/RegisterActivity$11

/* anonymous class */
    class RegisterActivity._cls11 extends s
    {

        final RegisterActivity a;

        public void a()
        {
            e.c(new Object[] {
                "QQ Login: Cancel"
            });
        }

        public void a(com.cyberlink.beautycircle.utility.QQUtils.QQLoginResult qqloginresult)
        {
            if (RegisterActivity.h(a).a())
            {
                a.k();
                NetworkUser.a("Qq", qqloginresult.access_token, qqloginresult.openid).a(new RegisterActivity._cls11._cls1(this));
                return;
            } else
            {
                DialogUtils.a(a, a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_qq_sign_in_failed));
                Globals.b("Invalid QQ session.");
                com.perfectcorp.a.b.a(new aq("qq", "no"));
                return;
            }
        }

        public volatile void a(Model model)
        {
            a((com.cyberlink.beautycircle.utility.QQUtils.QQLoginResult)model);
        }

        public void a(d d1)
        {
            if (d1 != null)
            {
                e.e(new Object[] {
                    "QQ Login: Error. code:", Integer.valueOf(d1.a), ", msg:", d1.b, (new StringBuilder()).append(", detail:").append(d1.c).toString()
                });
            }
            DialogUtils.a(a, a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_qq_sign_in_failed));
        }

            
            {
                a = registeractivity;
                super(class1);
            }
    }

}
