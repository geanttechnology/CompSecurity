// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.a.as;
import com.cyberlink.beautycircle.controller.a.at;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.a.b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity, l, m

class a
    implements android.view.
{

    final RegisterActivity a;

    public void onClick(View view)
    {
        view = (EditText)a.findViewById(j.register_id);
        EditText edittext = (EditText)a.findViewById(j.register_password);
        if (view != null && edittext != null && RegisterActivity.d(a) != null)
        {
            String s = view.getText().toString();
            String s1 = edittext.getText().toString();
            RegisterActivity.d(a).setVisibility(8);
            if (RegisterActivity.e(a) == eMode.a)
            {
                if (!Patterns.EMAIL_ADDRESS.matcher(s).matches())
                {
                    view.requestFocus();
                    a.showSoftInput(view);
                    RegisterActivity.d(a).setText(m.bc_register_error_invalid_email_format);
                    RegisterActivity.d(a).setVisibility(0);
                    return;
                }
                if (!a.f(s1))
                {
                    edittext.requestFocus();
                    a.showSoftInput(edittext);
                    RegisterActivity.d(a).setText(m.bc_register_error_invalid_password_format);
                    RegisterActivity.d(a).setVisibility(0);
                    return;
                }
                a.k();
                AccountManager.c(s);
                NetworkUser.b(s, "", s1).a(new l(a));
                b.a(new at("create_account"));
                if (Globals.l)
                {
                    if (Globals.k)
                    {
                        b.a(new com.cyberlink.beautycircle.controller.a.b("A", "BC_welcome_page_0819"));
                        return;
                    } else
                    {
                        b.a(new com.cyberlink.beautycircle.controller.a.b("B", "BC_welcome_page_0819"));
                        return;
                    }
                }
            } else
            if (!Patterns.EMAIL_ADDRESS.matcher(s).matches())
            {
                view.requestFocus();
                a.showSoftInput(view);
                RegisterActivity.d(a).setText(m.bc_register_error_invalid_email_format);
                RegisterActivity.d(a).setVisibility(0);
                return;
            } else
            {
                a.k();
                AccountManager.c(s);
                NetworkUser.a(s, s1).a(new com.cyberlink.beautycircle.controller.activity.m(a));
                b.a(new as("log_in"));
                return;
            }
        }
    }

    eMode(RegisterActivity registeractivity)
    {
        a = registeractivity;
        super();
    }
}
