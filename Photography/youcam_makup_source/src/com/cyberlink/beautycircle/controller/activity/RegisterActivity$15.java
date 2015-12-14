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
            NetworkUser.a("Twitter", oauthconsumer.a(), RegisterActivity.i(a).a).a(new m() {

                final RegisterActivity._cls15 a;

                protected void a(int i)
                {
                    a.a.l();
                    DialogUtils.a(a.a, a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_twitter_sign_in_failed));
                    com.perfectcorp.a.b.a(new aq("twitter", "no"));
                }

                protected void a(com.cyberlink.beautycircle.model.UserInfo.SignInResult signinresult)
                {
                    AccountManager.a(com.cyberlink.beautycircle.utility.AccountManager.AccountSource.f);
                    RegisterActivity.a(a.a, RegisterActivity.a(a.a, signinresult.userInfo));
                    if (RegisterActivity.f(a.a))
                    {
                        RegisterActivity.e(a.a, signinresult.token, signinresult.userInfo);
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
                    if (RegisterActivity.e(a.a) != RegisterActivity.PageMode.a) goto _L2; else goto _L1
_L1:
                    com.perfectcorp.a.b.a(new at("twitter"));
_L4:
                    com.perfectcorp.a.b.a(new aq("twitter", "yes"));
                    return;
_L2:
                    if (RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.RegisterActivity.PageMode.b)
                    {
                        com.perfectcorp.a.b.a(new as("twitter"));
                    } else
                    if (RegisterActivity.e(a.a) == RegisterActivity.PageMode.c || RegisterActivity.e(a.a) == RegisterActivity.PageMode.d)
                    {
                        com.perfectcorp.a.b.a(new ar("twitter"));
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.UserInfo.SignInResult)obj);
                }

            
            {
                a = RegisterActivity._cls15.this;
                super();
            }
            });
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

    _cls1.a(RegisterActivity registeractivity)
    {
        a = registeractivity;
        super();
    }
}
