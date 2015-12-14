// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.model.network.c;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;

public class RegisterChangePasswordActivity extends BaseActivity
{

    private EditText e;
    private EditText f;
    private EditText g;
    private android.view.View.OnClickListener h;

    public RegisterChangePasswordActivity()
    {
        h = new android.view.View.OnClickListener() {

            final RegisterChangePasswordActivity a;

            public void onClick(View view)
            {
                view = RegisterChangePasswordActivity.a(a).getText().toString();
                String s = RegisterChangePasswordActivity.b(a).getText().toString();
                String s1 = com.cyberlink.beautycircle.controller.activity.RegisterChangePasswordActivity.c(a).getText().toString();
                if (view.length() == 0)
                {
                    DialogUtils.a(a, a.getResources().getString(m.bc_dialog_title_alert), a.getResources().getString(m.bc_register_error_invalid_oldpassword), null);
                    RegisterChangePasswordActivity.a(a).requestFocus();
                    return;
                }
                if (!s.equals(s1))
                {
                    DialogUtils.a(a, a.getResources().getString(m.bc_dialog_title_alert), a.getResources().getString(m.bc_register_error_not_match_password), null);
                    com.cyberlink.beautycircle.controller.activity.RegisterChangePasswordActivity.c(a).requestFocus();
                    return;
                }
                if (!a.f(s))
                {
                    DialogUtils.a(a, a.getResources().getString(m.bc_dialog_title_alert), a.getResources().getString(m.bc_register_error_invalid_password_format), null);
                    RegisterChangePasswordActivity.b(a).requestFocus();
                    return;
                }
                if (view.equals(s))
                {
                    DialogUtils.a(a, a.getResources().getString(m.bc_dialog_title_alert), a.getResources().getString(m.bc_register_error_same_password), null);
                    RegisterChangePasswordActivity.b(a).requestFocus();
                    return;
                } else
                {
                    a.k();
                    NetworkUser.c(AccountManager.b(), view, s1).a(new com.perfectcorp.utility.m(this) {

                        final _cls1 a;

                        protected void a()
                        {
                            a.a.l();
                            DialogUtils.a(a.a, a.a.getResources().getString(m.bc_dialog_title_alert), a.a.getResources().getString(m.bc_register_forgetpassword_server_unavailable), null);
                        }

                        protected void a(int i)
                        {
                            a.a.l();
                            if (i == 419)
                            {
                                String s1 = (new StringBuilder()).append(a.a.getResources().getString(m.bc_register_error_invalid_password)).append(s.a(i)).toString();
                                DialogUtils.a(a.a, a.a.getResources().getString(m.bc_dialog_title_alert), s1, null);
                                return;
                            }
                            if (i == 420)
                            {
                                String s2 = (new StringBuilder()).append(a.a.getResources().getString(m.bc_dialog_message_token_expired)).append(s.a(i)).toString();
                                DialogUtils.a(a.a, a.a.getResources().getString(m.bc_dialog_title_alert), s2, null);
                                return;
                            }
                            if (i == 421)
                            {
                                String s3 = (new StringBuilder()).append(a.a.getResources().getString(m.bc_register_forgetpassword_invalid_account)).append(s.a(i)).toString();
                                DialogUtils.a(a.a, a.a.getResources().getString(m.bc_dialog_title_alert), s3, null);
                                return;
                            }
                            boolean flag;
                            if (!com.cyberlink.beautycircle.model.network.c.a())
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            if (!flag)
                            {
                                String s4 = (new StringBuilder()).append(a.a.getResources().getString(m.bc_register_error_network_unavailabe)).append(s.a(i)).toString();
                                DialogUtils.a(a.a, s4);
                                return;
                            } else
                            {
                                String s5 = (new StringBuilder()).append(a.a.getResources().getString(m.bc_register_error_invalid_locale)).append(s.a(i)).toString();
                                DialogUtils.a(a.a, a.a.getResources().getString(m.bc_dialog_title_alert), s5, null);
                                return;
                            }
                        }

                        protected void a(Void void1)
                        {
                            a.a.l();
                            DialogUtils.a(a.a, a.a.getResources().getString(m.bc_dialog_title_notification), a.a.getResources().getString(m.bc_register_change_password_success), new Runnable(this) {

                                final _cls1 a;

                                public void run()
                                {
                                    a.a.a.e();
                                }

            
            {
                a = _pcls1;
                super();
            }
                            });
                        }

                        protected void b(Object obj)
                        {
                            a((Void)obj);
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                a = RegisterChangePasswordActivity.this;
                super();
            }
        };
    }

    static EditText a(RegisterChangePasswordActivity registerchangepasswordactivity)
    {
        return registerchangepasswordactivity.e;
    }

    private void a(int i, String s)
    {
        super.e();
    }

    static EditText b(RegisterChangePasswordActivity registerchangepasswordactivity)
    {
        return registerchangepasswordactivity.f;
    }

    static EditText c(RegisterChangePasswordActivity registerchangepasswordactivity)
    {
        return registerchangepasswordactivity.g;
    }

    protected boolean e()
    {
        a(48259, "");
        return true;
    }

    protected boolean f(String s)
    {
        return s.length() >= 6 && s.length() <= 20;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_register_changepassword);
        findViewById(j.register_continue_btn).setOnClickListener(h);
        e = (EditText)findViewById(j.register_current_password);
        f = (EditText)findViewById(j.register_new_password);
        g = (EditText)findViewById(j.register_confirm_password);
        b(m.bc_register_changepassword_title);
    }
}
