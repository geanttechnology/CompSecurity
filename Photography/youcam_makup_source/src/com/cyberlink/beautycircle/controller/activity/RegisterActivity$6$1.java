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
import com.cyberlink.beautycircle.utility.ah;
import com.cyberlink.beautycircle.utility.ai;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import com.sina.weibo.sdk.exception.WeiboException;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class a extends m
{

    final a a;

    protected void a(int i)
    {
        a.a.l();
        DialogUtils.a(a.a, a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_weibo_sign_in_failed));
        com.perfectcorp.a.b.a(new aq("weibo", "no"));
    }

    protected void a(com.cyberlink.beautycircle.model. )
    {
        AccountManager.a(com.cyberlink.beautycircle.utility.tSource.c);
        RegisterActivity.a(a.a, RegisterActivity.a(a.a, .userInfo));
        if (RegisterActivity.f(a.a))
        {
            RegisterActivity.a(a.a, .token, .userInfo);
        } else
        {
            RegisterActivity registeractivity = a.a;
            String s = .token;
            UserInfo userinfo = .userInfo;
            long l;
            if (.userInfo != null)
            {
                l = .userInfo.id;
            } else
            {
                l = -1L;
            }
            RegisterActivity.a(registeractivity, s, userinfo, l);
        }
        if (RegisterActivity.e(a.a) != Mode.a) goto _L2; else goto _L1
_L1:
        com.perfectcorp.a.b.a(new at("weibo"));
_L4:
        com.perfectcorp.a.b.a(new aq("weibo", "yes"));
        return;
_L2:
        if (RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.Mode.b)
        {
            com.perfectcorp.a.b.a(new as("weibo"));
        } else
        if (RegisterActivity.e(a.a) == Mode.c || RegisterActivity.e(a.a) == Mode.d)
        {
            com.perfectcorp.a.b.a(new ar("weibo"));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.)obj);
    }

    Mode(Mode mode)
    {
        a = mode;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/RegisterActivity$6

/* anonymous class */
    class RegisterActivity._cls6
        implements ai
    {

        final RegisterActivity a;

        public void a()
        {
            if (a.j.a())
            {
                a.k();
                NetworkUser.a("Weibo", a.j.b(), null).a(new RegisterActivity._cls6._cls1(this));
                return;
            } else
            {
                DialogUtils.a(a, a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_weibo_sign_in_failed));
                Globals.b("Invalid Weibo token.");
                com.perfectcorp.a.b.a(new aq("weibo", "no"));
                return;
            }
        }

        public void a(WeiboException weiboexception)
        {
            DialogUtils.a(a, a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_weibo_sign_in_failed));
            if (weiboexception != null && weiboexception.toString() != null)
            {
                weiboexception = weiboexception.toString();
            } else
            {
                weiboexception = "Unknow error";
            }
            Globals.b(weiboexception);
            com.perfectcorp.a.b.a(new aq("weibo", "no"));
        }

            
            {
                a = registeractivity;
                super();
            }
    }

}
