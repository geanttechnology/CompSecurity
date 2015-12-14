// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.j;
import java.util.UUID;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            n

public class RegisterVerifyActivity extends BaseActivity
{

    public static final UUID e = UUID.randomUUID();
    private String f;
    private String g;
    private android.view.View.OnClickListener h;

    public RegisterVerifyActivity()
    {
        f = null;
        g = null;
        h = new android.view.View.OnClickListener() {

            final RegisterVerifyActivity a;

            public void onClick(View view)
            {
                a.k();
                NetworkUser.a(RegisterVerifyActivity.a(a), RegisterVerifyActivity.b(a)).a(new n(a));
            }

            
            {
                a = RegisterVerifyActivity.this;
                super();
            }
        };
    }

    static String a(RegisterVerifyActivity registerverifyactivity)
    {
        return registerverifyactivity.f;
    }

    static void a(RegisterVerifyActivity registerverifyactivity, String s, UserInfo userinfo)
    {
        registerverifyactivity.a(s, userinfo);
    }

    static void a(RegisterVerifyActivity registerverifyactivity, String s, UserInfo userinfo, long l)
    {
        registerverifyactivity.a(s, userinfo, l);
    }

    static void a(RegisterVerifyActivity registerverifyactivity, String s, UserInfo userinfo, long l, long l1)
    {
        registerverifyactivity.a(s, userinfo, l, l1);
    }

    private void a(String s, UserInfo userinfo)
    {
        AccountManager.a(s, userinfo, true).a(new com.perfectcorp.utility.m() {

            final RegisterVerifyActivity a;

            protected void a(Boolean boolean1)
            {
                if (boolean1.booleanValue())
                {
                    a.l();
                    Globals.a(a.getResources().getString(m.bc_register_sign_in_success));
                    com.cyberlink.beautycircle.c.a(a, 1);
                    com.cyberlink.beautycircle.controller.activity.RegisterVerifyActivity.c(a);
                    return;
                } else
                {
                    AccountManager.h();
                    a.l();
                    DialogUtils.a(a, a.getResources().getString(m.bc_register_error_account_info));
                    return;
                }
            }

            protected void b(Object obj)
            {
                a((Boolean)obj);
            }

            
            {
                a = RegisterVerifyActivity.this;
                super();
            }
        });
    }

    private void a(String s, UserInfo userinfo, long l)
    {
        NetworkUser.a(l, AccountManager.c(), AccountManager.b()).a(new com.perfectcorp.utility.m(userinfo, s) {

            final UserInfo a;
            final String b;
            final RegisterVerifyActivity c;

            protected void a()
            {
                RegisterVerifyActivity.a(c, b, a);
            }

            protected void a(int i)
            {
                if (i == 420)
                {
                    String s1 = (new StringBuilder()).append(c.getResources().getString(m.bc_dialog_message_token_expired)).append(com.cyberlink.beautycircle.model.network.s.a(i)).toString();
                    DialogUtils.a(c, c.getResources().getString(m.bc_dialog_title_alert), s1, null);
                } else
                {
                    RegisterVerifyActivity.a(c, b, a);
                }
                Globals.b((new StringBuilder()).append("Code:'").append(i).toString());
            }

            protected void a(UserInfo userinfo1)
            {
                UserInfo userinfo2 = userinfo1;
                if (userinfo1 == null)
                {
                    userinfo2 = a;
                }
                RegisterVerifyActivity.a(c, b, userinfo2);
            }

            protected void b(Object obj)
            {
                a((UserInfo)obj);
            }

            
            {
                c = RegisterVerifyActivity.this;
                a = userinfo;
                b = s1;
                super();
            }
        });
    }

    private void a(String s, UserInfo userinfo, long l, long l1)
    {
        if (s == null || userinfo == null)
        {
            a(s, userinfo);
            return;
        } else
        {
            AccountManager.b(userinfo.region);
            NetworkUser.a(s, userinfo.displayName, Long.valueOf(l), Long.valueOf(l1), userinfo.description, userinfo.gender, userinfo.region, userinfo.birthDay, userinfo.attribute, userinfo.name, userinfo.phone, userinfo.receiveEmail, userinfo.address, userinfo.websiteUrl).a(new com.perfectcorp.utility.m(s, userinfo) {

                final String a;
                final UserInfo b;
                final RegisterVerifyActivity c;

                protected void a()
                {
                }

                protected void a(int i)
                {
                    Globals.b((new StringBuilder()).append("Code:'").append(i).toString());
                    if (i == 420)
                    {
                        c.l();
                        String s1 = (new StringBuilder()).append(c.getResources().getString(m.bc_dialog_message_token_expired)).append(com.cyberlink.beautycircle.model.network.s.a(i)).toString();
                        DialogUtils.a(c, c.getResources().getString(m.bc_dialog_title_alert), s1, null);
                        return;
                    } else
                    {
                        RegisterVerifyActivity.a(c, a, b);
                        return;
                    }
                }

                protected void a(com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse updateuserresponse)
                {
                    try
                    {
                        RegisterVerifyActivity.a(c, a, b, updateuserresponse.userId);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse updateuserresponse)
                    {
                        updateuserresponse.printStackTrace();
                    }
                    RegisterVerifyActivity.a(c, a, b);
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse)obj);
                }

            
            {
                c = RegisterVerifyActivity.this;
                a = s1;
                b = userinfo;
                super();
            }
            });
            return;
        }
    }

    static String b(RegisterVerifyActivity registerverifyactivity)
    {
        return registerverifyactivity.g;
    }

    static boolean c(RegisterVerifyActivity registerverifyactivity)
    {
        return registerverifyactivity.BaseActivity.e();
    }

    protected boolean e()
    {
        setResult(48259);
        super.e();
        return true;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_register_verify);
        bundle = getIntent();
        f = bundle.getStringExtra("UserEmail");
        g = bundle.getStringExtra("UserPassword");
        findViewById(com.cyberlink.beautycircle.j.register_continue_btn).setOnClickListener(h);
        b(m.bc_register_verified_title);
    }

}
