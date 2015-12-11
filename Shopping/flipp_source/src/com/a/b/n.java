// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.content.Context;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Handler;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.a.b:
//            q, o, r, an, 
//            d, s, h, as

final class n
{

    final q a;
    final Context b;
    final ExecutorService c;
    final s d;
    final Map e;
    final Handler f;
    final Handler g;
    final h h;
    final as i;
    final List j;
    final r k;
    NetworkInfo l;
    boolean m;

    n(Context context, ExecutorService executorservice, Handler handler, s s, h h1, as as)
    {
        boolean flag;
        boolean flag1 = true;
        super();
        a = new q();
        a.start();
        b = context;
        c = executorservice;
        e = new LinkedHashMap();
        f = new o(a.getLooper(), this);
        d = s;
        g = handler;
        h = h1;
        i = as;
        j = new ArrayList(4);
        boolean flag2;
        if (android.provider.Settings.System.getInt(b.getContentResolver(), "airplane_mode_on", 0) != 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        m = flag2;
        k = new r(this, b);
        context = k;
        if (!(((r) (context)).a.c instanceof an)) goto _L2; else goto _L1
_L1:
        if (((r) (context)).a.b.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L3
_L3:
        flag = flag1;
_L5:
        executorservice = new IntentFilter();
        executorservice.addAction("android.intent.action.AIRPLANE_MODE");
        if (flag)
        {
            executorservice.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        ((r) (context)).a.b.registerReceiver(context, executorservice);
        return;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    final void a(d d1)
    {
        f.sendMessage(f.obtainMessage(6, d1));
    }

    final void b(d d1)
    {
        e.remove(d1.f);
        c(d1);
    }

    final void c(d d1)
    {
        if (!d1.b())
        {
            j.add(d1);
            if (!f.hasMessages(7))
            {
                f.sendEmptyMessageDelayed(7, 200L);
                return;
            }
        }
    }
}
