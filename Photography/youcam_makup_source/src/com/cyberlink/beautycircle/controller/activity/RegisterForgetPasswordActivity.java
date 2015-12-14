// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
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
import com.cyberlink.beautycircle.utility.DialogUtils;
import java.util.UUID;

public class RegisterForgetPasswordActivity extends BaseActivity
{

    public static final UUID e = UUID.randomUUID();
    private String f;
    private EditText g;
    private android.view.View.OnClickListener h;
    private Runnable i;

    public RegisterForgetPasswordActivity()
    {
        f = null;
        h = new android.view.View.OnClickListener() {

            final RegisterForgetPasswordActivity a;

            public void onClick(View view)
            {
                view = RegisterForgetPasswordActivity.a(a).getText().toString();
                a.k();
                NetworkUser.c(view).a(new com.perfectcorp.utility.m(this) {

                    final _cls1 a;

                    protected void a()
                    {
                        a.a.l();
                        DialogUtils.a(a.a, a.a.getResources().getString(m.bc_dialog_title_alert), a.a.getResources().getString(m.bc_register_forgetpassword_server_unavailable), null);
                    }

                    protected void a(int l)
                    {
                        a.a.l();
                        if (l == 421)
                        {
                            String s1 = (new StringBuilder()).append(a.a.getResources().getString(m.bc_register_forgetpassword_invalid_account)).append(s.a(l)).toString();
                            DialogUtils.a(a.a, a.a.getResources().getString(m.bc_dialog_title_alert), s1, null);
                        } else
                        {
                            boolean flag;
                            if (!c.a())
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            if (!flag)
                            {
                                String s2 = (new StringBuilder()).append(a.a.getResources().getString(m.bc_register_error_network_unavailabe)).append(s.a(l)).toString();
                                DialogUtils.a(a.a, s2);
                                return;
                            }
                        }
                    }

                    protected void a(Void void1)
                    {
                        a.a.l();
                        DialogUtils.a(a.a, a.a.getResources().getString(m.bc_dialog_title_alert), a.a.getResources().getString(m.bc_register_forgetpassword_alert_message), RegisterForgetPasswordActivity.b(a.a));
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
            }

            
            {
                a = RegisterForgetPasswordActivity.this;
                super();
            }
        };
        i = new Runnable() {

            final RegisterForgetPasswordActivity a;

            public void run()
            {
                String s = RegisterForgetPasswordActivity.a(a).getText().toString();
                RegisterForgetPasswordActivity.a(a, 48256, s);
            }

            
            {
                a = RegisterForgetPasswordActivity.this;
                super();
            }
        };
    }

    static EditText a(RegisterForgetPasswordActivity registerforgetpasswordactivity)
    {
        return registerforgetpasswordactivity.g;
    }

    private void a(int l, String s)
    {
        Intent intent = new Intent();
        if (s != null && !s.isEmpty())
        {
            intent.putExtra("UserEmail", s);
        }
        setResult(l, intent);
        super.e();
    }

    static void a(RegisterForgetPasswordActivity registerforgetpasswordactivity, int l, String s)
    {
        registerforgetpasswordactivity.a(l, s);
    }

    static Runnable b(RegisterForgetPasswordActivity registerforgetpasswordactivity)
    {
        return registerforgetpasswordactivity.i;
    }

    protected boolean e()
    {
        a(48259, "");
        return true;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_register_forgetpassword);
        f = getIntent().getStringExtra("UserEmail");
        findViewById(j.register_continue_btn).setOnClickListener(h);
        g = (EditText)findViewById(j.register_email_id);
        if (f != null)
        {
            g.setText(f);
        }
        b(m.bc_register_forgetpassword_title);
    }

}
