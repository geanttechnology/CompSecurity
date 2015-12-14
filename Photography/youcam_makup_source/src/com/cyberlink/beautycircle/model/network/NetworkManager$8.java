// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import android.content.res.Resources;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkManager

final class a extends m
{

    final MainActivity a;

    protected void a()
    {
        a.l();
        Globals.b((new StringBuilder()).append(Globals.d.getResources().getString(com.cyberlink.beautycircle.m.bc_user_log_out_fail)).append(" (CANCELLED)").toString());
        a(((Void) (null)));
    }

    protected void a(int i)
    {
        a.l();
        Globals.b((new StringBuilder()).append(Globals.d.getResources().getString(com.cyberlink.beautycircle.m.bc_user_log_out_fail)).append(" (Code : '").append(i).append("')").toString());
        a(((Void) (null)));
    }

    protected void a(Void void1)
    {
        a.l();
    }

    protected void b(Object obj)
    {
        a((Void)obj);
    }

    y(MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }
}
