// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shazam.android.ba.c;
import com.shazam.android.ba.d;
import com.shazam.android.ba.e;
import com.shazam.android.ba.f;
import com.shazam.android.persistence.e.i;
import com.shazam.android.persistence.e.j;
import com.shazam.i.b.al.b;
import com.shazam.i.j.a;
import java.util.Iterator;
import java.util.List;

public class AppUpgradeReceiver extends BroadcastReceiver
{

    private final List a = com.shazam.b.b.c.a(new f[] {
        new d(com.shazam.i.b.ah.c.d.a(), com.shazam.i.b.al.b.a(), new j(com.shazam.i.j.a.a(), com.shazam.i.b.ah.f.a()), new i(com.shazam.i.j.a.b(), com.shazam.i.b.ah.f.a())), new com.shazam.android.ba.b(), new e(com.shazam.i.b.g.b.a.a()), new c(com.shazam.i.b.ah.f.a())
    });
    private final com.shazam.android.ab.c b = new com.shazam.android.ab.c();

    public AppUpgradeReceiver()
    {
    }

    private void a()
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((f)iterator.next()).a()) { }
    }

    public void onReceive(Context context, Intent intent)
    {
        boolean flag1 = true;
        (new StringBuilder("Notified of app replace. ")).append(intent.toUri(1));
        b.a = context.getPackageName();
        context = b;
        com.shazam.b.a.d.a(intent);
        intent = intent.getDataString();
        boolean flag = flag1;
        if (intent != null)
        {
            flag = flag1;
            if (((com.shazam.android.ab.c) (context)).a != null)
            {
                if (intent.equals((new StringBuilder("package:")).append(((com.shazam.android.ab.c) (context)).a).toString()))
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
            }
        }
        if (flag)
        {
            a();
        }
    }
}
