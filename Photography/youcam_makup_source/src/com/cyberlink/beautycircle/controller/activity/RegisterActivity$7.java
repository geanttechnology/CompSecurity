// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class a extends m
{

    final RegisterActivity a;

    protected void a(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            a.l();
            Globals.a(a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_sign_in_success));
            a.o();
            return;
        } else
        {
            AccountManager.h();
            a.l();
            DialogUtils.a(a, a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_account_info));
            return;
        }
    }

    protected void b(Object obj)
    {
        a((Boolean)obj);
    }

    (RegisterActivity registeractivity)
    {
        a = registeractivity;
        super();
    }
}
