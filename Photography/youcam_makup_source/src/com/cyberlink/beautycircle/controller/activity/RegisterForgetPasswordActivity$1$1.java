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
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterForgetPasswordActivity

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
        if (i == 421)
        {
            String s1 = (new StringBuilder()).append(a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_forgetpassword_invalid_account)).append(s.a(i)).toString();
            DialogUtils.a(a.a, a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_title_alert), s1, null);
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
                String s2 = (new StringBuilder()).append(a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_network_unavailabe)).append(s.a(i)).toString();
                DialogUtils.a(a.a, s2);
                return;
            }
        }
    }

    protected void a(Void void1)
    {
        a.a.l();
        DialogUtils.a(a.a, a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_title_alert), a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_forgetpassword_alert_message), RegisterForgetPasswordActivity.b(a.a));
    }

    protected void b(Object obj)
    {
        a((Void)obj);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/RegisterForgetPasswordActivity$1

/* anonymous class */
    class RegisterForgetPasswordActivity._cls1
        implements android.view.View.OnClickListener
    {

        final RegisterForgetPasswordActivity a;

        public void onClick(View view)
        {
            view = RegisterForgetPasswordActivity.a(a).getText().toString();
            a.k();
            NetworkUser.c(view).a(new RegisterForgetPasswordActivity._cls1._cls1(this));
        }

            
            {
                a = registerforgetpasswordactivity;
                super();
            }
    }

}
