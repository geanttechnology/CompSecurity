// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.model.network.c;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterChangePasswordActivity

class a extends m
{

    final a a;

    protected void a()
    {
        a.a.l();
        DialogUtils.a(a.a, a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_title_alert), a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_forgetpassword_server_unavailable), null);
    }

    protected void a(int i)
    {
        a.a.l();
        if (i == 419)
        {
            String s1 = (new StringBuilder()).append(a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_invalid_password)).append(s.a(i)).toString();
            DialogUtils.a(a.a, a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_title_alert), s1, null);
            return;
        }
        if (i == 420)
        {
            String s2 = (new StringBuilder()).append(a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_message_token_expired)).append(s.a(i)).toString();
            DialogUtils.a(a.a, a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_title_alert), s2, null);
            return;
        }
        if (i == 421)
        {
            String s3 = (new StringBuilder()).append(a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_forgetpassword_invalid_account)).append(s.a(i)).toString();
            DialogUtils.a(a.a, a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_title_alert), s3, null);
            return;
        }
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
            String s4 = (new StringBuilder()).append(a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_network_unavailabe)).append(s.a(i)).toString();
            DialogUtils.a(a.a, s4);
            return;
        } else
        {
            String s5 = (new StringBuilder()).append(a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_invalid_locale)).append(s.a(i)).toString();
            DialogUtils.a(a.a, a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_title_alert), s5, null);
            return;
        }
    }

    protected void a(Void void1)
    {
        a.a.l();
        DialogUtils.a(a.a, a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_title_notification), a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_change_password_success), new Runnable() {

            final RegisterChangePasswordActivity._cls1._cls1 a;

            public void run()
            {
                a.a.a.e();
            }

            
            {
                a = RegisterChangePasswordActivity._cls1._cls1.this;
                super();
            }
        });
    }

    protected void b(Object obj)
    {
        a((Void)obj);
    }

    _cls1.a(_cls1.a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/RegisterChangePasswordActivity$1

/* anonymous class */
    class RegisterChangePasswordActivity._cls1
        implements android.view.View.OnClickListener
    {

        final RegisterChangePasswordActivity a;

        public void onClick(View view)
        {
            view = RegisterChangePasswordActivity.a(a).getText().toString();
            String s1 = RegisterChangePasswordActivity.b(a).getText().toString();
            String s2 = com.cyberlink.beautycircle.controller.activity.RegisterChangePasswordActivity.c(a).getText().toString();
            if (view.length() == 0)
            {
                DialogUtils.a(a, a.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_title_alert), a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_invalid_oldpassword), null);
                RegisterChangePasswordActivity.a(a).requestFocus();
                return;
            }
            if (!s1.equals(s2))
            {
                DialogUtils.a(a, a.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_title_alert), a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_not_match_password), null);
                com.cyberlink.beautycircle.controller.activity.RegisterChangePasswordActivity.c(a).requestFocus();
                return;
            }
            if (!a.f(s1))
            {
                DialogUtils.a(a, a.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_title_alert), a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_invalid_password_format), null);
                RegisterChangePasswordActivity.b(a).requestFocus();
                return;
            }
            if (view.equals(s1))
            {
                DialogUtils.a(a, a.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_title_alert), a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_same_password), null);
                RegisterChangePasswordActivity.b(a).requestFocus();
                return;
            } else
            {
                a.k();
                NetworkUser.c(AccountManager.b(), view, s2).a(new RegisterChangePasswordActivity._cls1._cls1(this));
                return;
            }
        }

            
            {
                a = registerchangepasswordactivity;
                super();
            }
    }

}
