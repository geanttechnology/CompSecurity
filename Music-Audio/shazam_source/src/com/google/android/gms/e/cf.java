// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.d.e;
import com.google.android.gms.d.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.e:
//            o, cj, c

final class cf extends o
{
    private final class a
        implements Runnable
    {

        final cf a;
        private final String b;
        private final String c;
        private final long d;
        private final long e;
        private final long f = System.currentTimeMillis();
        private long g;

        public final void run()
        {
            if (e > 0L && g >= e)
            {
                if (!"0".equals(c))
                {
                    cf.a(a).remove(c);
                }
                return;
            }
            g = g + 1L;
            if (!cf.d(a)) goto _L2; else goto _L1
_L1:
            boolean flag = com.google.android.gms.e.cf.e(a);
_L4:
            if (flag)
            {
                long l1 = System.currentTimeMillis();
                cf.b(a).a(com.google.android.gms.e.c.a(new Object[] {
                    "event", b, "gtm.timerInterval", String.valueOf(d), "gtm.timerLimit", String.valueOf(e), "gtm.timerStartTime", String.valueOf(f), "gtm.timerCurrentTime", String.valueOf(l1), 
                    "gtm.timerElapsedTime", String.valueOf(l1 - f), "gtm.timerEventNumber", String.valueOf(g), "gtm.triggers", c
                }));
            }
            cf.c(a).postDelayed(this, d);
            return;
_L2:
            Object obj = (ActivityManager)com.google.android.gms.e.cf.f(a).getSystemService("activity");
            KeyguardManager keyguardmanager = (KeyguardManager)com.google.android.gms.e.cf.f(a).getSystemService("keyguard");
            PowerManager powermanager = (PowerManager)com.google.android.gms.e.cf.f(a).getSystemService("power");
            for (obj = ((ActivityManager) (obj)).getRunningAppProcesses().iterator(); ((Iterator) (obj)).hasNext();)
            {
                android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
                if (Process.myPid() == runningappprocessinfo.pid && runningappprocessinfo.importance == 100 && !keyguardmanager.inKeyguardRestrictedInputMode() && powermanager.isScreenOn())
                {
                    flag = true;
                    continue; /* Loop/switch isn't completed */
                }
            }

            flag = false;
            if (true) goto _L4; else goto _L3
_L3:
        }

        a(String s, String s1, long l1, long l2)
        {
            a = cf.this;
            super();
            b = s;
            c = s1;
            d = l1;
            e = l2;
        }
    }


    private static final String b;
    private static final String c;
    private static final String d;
    private static final String e;
    private static final String f;
    private boolean g;
    private boolean h;
    private final Context i;
    private c j;
    private final HandlerThread k = new HandlerThread("Google GTM SDK Timer", 10);
    private Handler l;
    private final Set m = new HashSet();

    public cf(Context context, c c1)
    {
        super(b, new String[] {
            d, c
        });
        i = context;
        j = c1;
        k.start();
        l = new Handler(k.getLooper());
    }

    static Set a(cf cf1)
    {
        return cf1.m;
    }

    static c b(cf cf1)
    {
        return cf1.j;
    }

    static Handler c(cf cf1)
    {
        return cf1.l;
    }

    static boolean d(cf cf1)
    {
        return cf1.h;
    }

    static boolean e(cf cf1)
    {
        return cf1.g;
    }

    static Context f(cf cf1)
    {
        return cf1.i;
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
label0:
        {
label1:
            {
                String s1 = cj.a((com.google.android.gms.d.h.a)map.get(c));
                String s = cj.a((com.google.android.gms.d.h.a)map.get(f));
                String s2 = cj.a((com.google.android.gms.d.h.a)map.get(d));
                map = cj.a((com.google.android.gms.d.h.a)map.get(e));
                long l1;
                long l2;
                try
                {
                    l1 = Long.parseLong(s2);
                }
                catch (NumberFormatException numberformatexception)
                {
                    l1 = 0L;
                }
                try
                {
                    l2 = Long.parseLong(map);
                }
                // Misplaced declaration of an exception variable
                catch (Map map)
                {
                    l2 = 0L;
                }
                if (l1 <= 0L || TextUtils.isEmpty(s1))
                {
                    break label0;
                }
                if (s != null)
                {
                    map = s;
                    if (!s.isEmpty())
                    {
                        break label1;
                    }
                }
                map = "0";
            }
            if (!m.contains(map))
            {
                if (!"0".equals(map))
                {
                    m.add(map);
                }
                l.postDelayed(new a(s1, map, l1, l2), l1);
            }
        }
        return com.google.android.gms.e.cj.f();
    }

    public final boolean a()
    {
        return false;
    }

    static 
    {
        b = e.aL.toString();
        c = f.bH.toString();
        d = f.bm.toString();
        e = f.bu.toString();
        f = f.dl.toString();
    }
}
