// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterVerifyActivity

class b extends m
{

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
            String s1 = (new StringBuilder()).append(c.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_message_token_expired)).append(s.a(i)).toString();
            DialogUtils.a(c, c.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_title_alert), s1, null);
            return;
        } else
        {
            RegisterVerifyActivity.a(c, a, b);
            return;
        }
    }

    protected void a(com.cyberlink.beautycircle.model.se se)
    {
        try
        {
            RegisterVerifyActivity.a(c, a, b, se.userId);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.cyberlink.beautycircle.model.se se)
        {
            se.printStackTrace();
        }
        RegisterVerifyActivity.a(c, a, b);
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.se)obj);
    }

    (RegisterVerifyActivity registerverifyactivity, String s1, UserInfo userinfo)
    {
        c = registerverifyactivity;
        a = s1;
        b = userinfo;
        super();
    }
}
