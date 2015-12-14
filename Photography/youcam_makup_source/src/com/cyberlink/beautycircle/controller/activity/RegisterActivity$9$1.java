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
import com.cyberlink.beautycircle.utility.ae;
import com.cyberlink.beautycircle.utility.ag;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import com.tencent.mm.sdk.openapi.i;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class a extends m
{

    final a a;

    protected void a(int i)
    {
        a.a.l();
        DialogUtils.a(a.a, a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_wechat_sign_in_failed));
        com.perfectcorp.a.b.a(new aq("wechat", "no"));
    }

    protected void a(com.cyberlink.beautycircle.model. )
    {
        AccountManager.a(com.cyberlink.beautycircle.utility.tSource.d);
        RegisterActivity.a(a.a, RegisterActivity.a(a.a, .userInfo));
        if (RegisterActivity.f(a.a))
        {
            RegisterActivity.c(a.a, .token, .userInfo);
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
        if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) != Mode.a) goto _L2; else goto _L1
_L1:
        com.perfectcorp.a.b.a(new at("wechat"));
_L4:
        com.perfectcorp.a.b.a(new aq("wechat", "yes"));
        return;
_L2:
        if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.Mode.b)
        {
            com.perfectcorp.a.b.a(new as("wechat"));
        } else
        if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == Mode.c || com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == Mode.d)
        {
            com.perfectcorp.a.b.a(new ar("wechat"));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.)obj);
    }

    sult(sult sult)
    {
        a = sult;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/RegisterActivity$9

/* anonymous class */
    class RegisterActivity._cls9
        implements ag
    {

        final RegisterActivity a;

        public void a(com.cyberlink.beautycircle.model.network.NetworkWeChat.AccessTokenResult accesstokenresult)
        {
            if (accesstokenresult == null)
            {
                e.e(new Object[] {
                    "tokenResult null"
                });
                a(((i) (null)));
                return;
            }
            if (accesstokenresult.errcode != null)
            {
                e.e(new Object[] {
                    "errcode: ", accesstokenresult.errcode, ", errmsg: ", accesstokenresult.errmsg
                });
                Globals.b((new StringBuilder()).append("errcode: ").append(accesstokenresult.errcode).append(", errmsg: ").append(accesstokenresult.errmsg).toString());
                a(((i) (null)));
                return;
            } else
            {
                a.k();
                NetworkUser.a("Wechat", accesstokenresult.access_token, accesstokenresult.unionid).a(new RegisterActivity._cls9._cls1(this));
                return;
            }
        }

        public void a(i k)
        {
            DialogUtils.a(a, a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_wechat_sign_in_failed));
            if (k != null)
            {
                e.e(new Object[] {
                    "errCode: ", ae.a(k.a), ", errStr: ", k.b
                });
                Globals.b((new StringBuilder()).append("errCode: ").append(k.a).append(", errStr: ").append(k.b).toString());
            }
        }

            
            {
                a = registeractivity;
                super();
            }
    }

}
