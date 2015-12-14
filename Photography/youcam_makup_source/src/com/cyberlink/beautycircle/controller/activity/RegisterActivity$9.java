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
import com.cyberlink.beautycircle.utility.ae;
import com.cyberlink.beautycircle.utility.ag;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.tencent.mm.sdk.openapi.i;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class a
    implements ag
{

    final RegisterActivity a;

    public void a(com.cyberlink.beautycircle.model.network.sTokenResult stokenresult)
    {
        if (stokenresult == null)
        {
            e.e(new Object[] {
                "tokenResult null"
            });
            a(((i) (null)));
            return;
        }
        if (stokenresult.errcode != null)
        {
            e.e(new Object[] {
                "errcode: ", stokenresult.errcode, ", errmsg: ", stokenresult.errmsg
            });
            Globals.b((new StringBuilder()).append("errcode: ").append(stokenresult.errcode).append(", errmsg: ").append(stokenresult.errmsg).toString());
            a(((i) (null)));
            return;
        } else
        {
            a.k();
            NetworkUser.a("Wechat", stokenresult.access_token, stokenresult.unionid).a(new com.perfectcorp.utility.m() {

                final RegisterActivity._cls9 a;

                protected void a(int k)
                {
                    a.a.l();
                    DialogUtils.a(a.a, a.a.getResources().getString(m.bc_register_wechat_sign_in_failed));
                    com.perfectcorp.a.b.a(new aq("wechat", "no"));
                }

                protected void a(com.cyberlink.beautycircle.model.UserInfo.SignInResult signinresult)
                {
                    AccountManager.a(com.cyberlink.beautycircle.utility.AccountManager.AccountSource.d);
                    RegisterActivity.a(a.a, RegisterActivity.a(a.a, signinresult.userInfo));
                    if (RegisterActivity.f(a.a))
                    {
                        RegisterActivity.c(a.a, signinresult.token, signinresult.userInfo);
                    } else
                    {
                        RegisterActivity registeractivity = a.a;
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
                        RegisterActivity.a(registeractivity, s, userinfo, l);
                    }
                    if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) != RegisterActivity.PageMode.a) goto _L2; else goto _L1
_L1:
                    com.perfectcorp.a.b.a(new at("wechat"));
_L4:
                    com.perfectcorp.a.b.a(new aq("wechat", "yes"));
                    return;
_L2:
                    if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.RegisterActivity.PageMode.b)
                    {
                        com.perfectcorp.a.b.a(new as("wechat"));
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == RegisterActivity.PageMode.c || com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == RegisterActivity.PageMode.d)
                    {
                        com.perfectcorp.a.b.a(new ar("wechat"));
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.UserInfo.SignInResult)obj);
                }

            
            {
                a = RegisterActivity._cls9.this;
                super();
            }
            });
            return;
        }
    }

    public void a(i k)
    {
        DialogUtils.a(a, a.getResources().getString(m.bc_register_wechat_sign_in_failed));
        if (k != null)
        {
            e.e(new Object[] {
                "errCode: ", ae.a(k.a), ", errStr: ", k.b
            });
            Globals.b((new StringBuilder()).append("errCode: ").append(k.a).append(", errStr: ").append(k.b).toString());
        }
    }

    _cls1.a(RegisterActivity registeractivity)
    {
        a = registeractivity;
        super();
    }
}
