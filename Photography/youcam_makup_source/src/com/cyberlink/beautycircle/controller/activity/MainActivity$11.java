// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.m;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            MainActivity

class a extends m
{

    final MainActivity a;

    protected void a(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            Globals.a(String.format(Locale.getDefault(), a.getResources().getString(com.cyberlink.beautycircle.m.bc_user_profile_change_webserver_success), new Object[] {
                Globals.e()
            }));
        } else
        {
            Globals.a(String.format(Locale.getDefault(), a.getResources().getString(com.cyberlink.beautycircle.m.bc_user_profile_change_webserver_fail), new Object[] {
                Globals.e()
            }));
        }
        MainActivity.b(a);
    }

    protected void b(Object obj)
    {
        a((Boolean)obj);
    }

    (MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }
}
