// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            EditNotificationActivity

class a extends m
{

    final EditNotificationActivity a;

    protected void a(String s)
    {
        a.l();
        Globals.a(a.getResources().getString(com.cyberlink.beautycircle.m.bc_notification_apply_success));
        EditNotificationActivity.a(a);
    }

    protected void b(Object obj)
    {
        a((String)obj);
    }

    (EditNotificationActivity editnotificationactivity)
    {
        a = editnotificationactivity;
        super();
    }
}
