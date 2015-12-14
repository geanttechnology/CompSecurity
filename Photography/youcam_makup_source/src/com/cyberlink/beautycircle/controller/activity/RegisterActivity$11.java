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
import com.cyberlink.beautycircle.m;
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
import com.tencent.tauth.d;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class a extends s
{

    final RegisterActivity a;

    public void a()
    {
        e.c(new Object[] {
            "QQ Login: Cancel"
        });
    }

    public void a(com.cyberlink.beautycircle.utility.t t)
    {
        if (RegisterActivity.h(a).a())
        {
            a.k();
            NetworkUser.a("Qq", t.access_token, t.openid).a(new com.perfectcorp.utility.m() {

                final RegisterActivity._cls11 a;

                protected void a(int i)
                {
                    a.a.l();
                    DialogUtils.a(a.a, a.a.getResources().getString(m.bc_register_qq_sign_in_failed));
                    com.perfectcorp.a.b.a(new aq("qq", "no"));
                }

                protected void a(com.cyberlink.beautycircle.model.UserInfo.SignInResult signinresult)
                {
                    AccountManager.a(com.cyberlink.beautycircle.utility.AccountManager.AccountSource.e);
                    RegisterActivity.a(a.a, RegisterActivity.a(a.a, signinresult.userInfo));
                    if (RegisterActivity.f(a.a))
                    {
                        com.cyberlink.beautycircle.controller.activity.RegisterActivity.d(a.a, signinresult.token, signinresult.userInfo);
                    } else
                    {
                        RegisterActivity registeractivity = a.a;
                        String s1 = signinresult.token;
                        UserInfo userinfo = signinresult.userInfo;
                        long l;
                        if (signinresult.userInfo != null)
                        {
                            l = signinresult.userInfo.id;
                        } else
                        {
                            l = -1L;
                        }
                        RegisterActivity.a(registeractivity, s1, userinfo, l);
                    }
                    if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) != RegisterActivity.PageMode.a) goto _L2; else goto _L1
_L1:
                    com.perfectcorp.a.b.a(new at("qq"));
_L4:
                    com.perfectcorp.a.b.a(new aq("qq", "yes"));
                    return;
_L2:
                    if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.RegisterActivity.PageMode.b)
                    {
                        com.perfectcorp.a.b.a(new as("qq"));
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == RegisterActivity.PageMode.c || com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.RegisterActivity.PageMode.d)
                    {
                        com.perfectcorp.a.b.a(new ar("qq"));
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.UserInfo.SignInResult)obj);
                }

            
            {
                a = RegisterActivity._cls11.this;
                super();
            }
            });
            return;
        } else
        {
            DialogUtils.a(a, a.getResources().getString(m.bc_register_qq_sign_in_failed));
            Globals.b("Invalid QQ session.");
            b.a(new aq("qq", "no"));
            return;
        }
    }

    public volatile void a(Model model)
    {
        a((com.cyberlink.beautycircle.utility.t)model);
    }

    public void a(d d1)
    {
        if (d1 != null)
        {
            e.e(new Object[] {
                "QQ Login: Error. code:", Integer.valueOf(d1.a), ", msg:", d1.b, (new StringBuilder()).append(", detail:").append(d1.c).toString()
            });
        }
        DialogUtils.a(a, a.getResources().getString(m.bc_register_qq_sign_in_failed));
    }

    _cls1.a(RegisterActivity registeractivity, Class class1)
    {
        a = registeractivity;
        super(class1);
    }
}
