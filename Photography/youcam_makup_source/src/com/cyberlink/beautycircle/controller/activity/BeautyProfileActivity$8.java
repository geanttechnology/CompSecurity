// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.c;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            BeautyProfileActivity

class g extends m
{

    final String a;
    final String b;
    final String c;
    final String d;
    final String e;
    final String f;
    final String g;
    final BeautyProfileActivity h;

    protected void a(int i)
    {
        h.l();
        String s1 = (new StringBuilder()).append(h.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_unknown_error)).append(s.a(i)).toString();
        if (!com.cyberlink.beautycircle.model.network.c.a())
        {
            s1 = (new StringBuilder()).append(h.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_network_unavailabe)).append(s.a(i)).toString();
        } else
        if (i == 420)
        {
            BeautyProfileActivity.a(h, 48258);
            return;
        }
        DialogUtils.a(h, null, s1, null, null, h.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_button_ok), new Runnable() {

            final BeautyProfileActivity._cls8 a;

            public void run()
            {
                BeautyProfileActivity.E(a.h);
            }

            
            {
                a = BeautyProfileActivity._cls8.this;
                super();
            }
        });
    }

    protected void a(com.cyberlink.beautycircle.model.nse nse)
    {
        h.l();
        nse = AccountManager.b();
        UserInfo userinfo = AccountManager.d();
        userinfo.birthDay = a;
        userinfo.gender = b;
        userinfo.attribute = c;
        userinfo.name = d;
        userinfo.phone = e;
        userinfo.receiveEmail = f;
        userinfo.address = g;
        AccountManager.a(nse, userinfo, false).a(new m() {

            final BeautyProfileActivity._cls8 a;

            protected void a(Boolean boolean1)
            {
                if (boolean1 != null && boolean1.booleanValue())
                {
                    BeautyProfileActivity.a(a.h, 48256);
                }
            }

            protected void b(Object obj)
            {
                a((Boolean)obj);
            }

            
            {
                a = BeautyProfileActivity._cls8.this;
                super();
            }
        });
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.nse)obj);
    }

    _cls2.a(BeautyProfileActivity beautyprofileactivity, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7)
    {
        h = beautyprofileactivity;
        a = s1;
        b = s2;
        c = s3;
        d = s4;
        e = s5;
        f = s6;
        g = s7;
        super();
    }
}
