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
            String s1 = (new StringBuilder()).append(c.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_message_token_expired)).append(s.a(i)).toString();
            DialogUtils.a(c, c.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_title_alert), s1, null);
        } else
        {
            RegisterVerifyActivity.a(c, b, a);
        }
        Globals.b((new StringBuilder()).append("Code:'").append(i).toString());
    }

    protected void a(UserInfo userinfo)
    {
        UserInfo userinfo1 = userinfo;
        if (userinfo == null)
        {
            userinfo1 = a;
        }
        RegisterVerifyActivity.a(c, b, userinfo1);
    }

    protected void b(Object obj)
    {
        a((UserInfo)obj);
    }

    (RegisterVerifyActivity registerverifyactivity, UserInfo userinfo, String s1)
    {
        c = registerverifyactivity;
        a = userinfo;
        b = s1;
        super();
    }
}
