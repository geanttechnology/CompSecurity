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
import com.cyberlink.beautycircle.utility.TwitterUtils;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import oauth.signpost.OAuthConsumer;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class a extends m
{

    final a a;

    protected void a(int i)
    {
        a.a.l();
        DialogUtils.a(a.a, a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_twitter_sign_in_failed));
        com.perfectcorp.a.b.a(new aq("twitter", "no"));
    }

    protected void a(com.cyberlink.beautycircle.model.Activity._cls15._cls1 _pcls1)
    {
        AccountManager.a(com.cyberlink.beautycircle.utility.Source.f);
        RegisterActivity.a(a.a, RegisterActivity.a(a.a, _pcls1.userInfo));
        if (RegisterActivity.f(a.a))
        {
            RegisterActivity.e(a.a, _pcls1.token, _pcls1.userInfo);
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
        if (RegisterActivity.e(a.a) != ode.a) goto _L2; else goto _L1
_L1:
        com.perfectcorp.a.b.a(new at("twitter"));
_L4:
        com.perfectcorp.a.b.a(new aq("twitter", "yes"));
        return;
_L2:
        if (RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.ode.b)
        {
            com.perfectcorp.a.b.a(new as("twitter"));
        } else
        if (RegisterActivity.e(a.a) == ode.c || RegisterActivity.e(a.a) == ode.d)
        {
            com.perfectcorp.a.b.a(new ar("twitter"));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.Activity._cls15._cls1.a)obj);
    }

    ode(ode ode)
    {
        a = ode;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/RegisterActivity$15

/* anonymous class */
    class RegisterActivity._cls15 extends m
    {

        final RegisterActivity a;

        protected void a(int i)
        {
            a.l();
            DialogUtils.a(a, a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_twitter_sign_in_failed));
            com.perfectcorp.a.b.a(new aq("twitter", "no"));
        }

        protected void a(OAuthConsumer oauthconsumer)
        {
            if (oauthconsumer != null && RegisterActivity.i(a).a != null)
            {
                NetworkUser.a("Twitter", oauthconsumer.a(), RegisterActivity.i(a).a).a(new RegisterActivity._cls15._cls1(this));
                return;
            } else
            {
                a.l();
                DialogUtils.a(a, a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_twitter_sign_in_failed));
                Globals.b("Invalid Twitter token.");
                com.perfectcorp.a.b.a(new aq("twitter", "no"));
                return;
            }
        }

        protected void b(Object obj)
        {
            a((OAuthConsumer)obj);
        }

            
            {
                a = registeractivity;
                super();
            }
    }

}
