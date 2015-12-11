// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            aat, ls, lt, ado, 
//            aah

class adk extends aat
{
    private final class a
        implements Runnable
    {

        final adk a;
        private final String b;
        private final String c;
        private final long d;
        private final long e;
        private final long f = System.currentTimeMillis();
        private long g;

        protected boolean a()
        {
            if (adk.d(a))
            {
                return adk.e(a);
            }
            Object obj = (ActivityManager)adk.f(a).getSystemService("activity");
            KeyguardManager keyguardmanager = (KeyguardManager)adk.f(a).getSystemService("keyguard");
            PowerManager powermanager = (PowerManager)adk.f(a).getSystemService("power");
            for (obj = ((ActivityManager) (obj)).getRunningAppProcesses().iterator(); ((Iterator) (obj)).hasNext();)
            {
                android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
                if (Process.myPid() == runningappprocessinfo.pid && runningappprocessinfo.importance == 100 && !keyguardmanager.inKeyguardRestrictedInputMode() && powermanager.isScreenOn())
                {
                    return true;
                }
            }

            return false;
        }

        public void run()
        {
            if (e > 0L && g >= e)
            {
                if (!"0".equals(c))
                {
                    adk.a(a).remove(c);
                }
                return;
            }
            g = g + 1L;
            if (a())
            {
                long l1 = System.currentTimeMillis();
                adk.b(a).a(aah.a(new Object[] {
                    "event", b, "gtm.timerInterval", String.valueOf(d), "gtm.timerLimit", String.valueOf(e), "gtm.timerStartTime", String.valueOf(f), "gtm.timerCurrentTime", String.valueOf(l1), 
                    "gtm.timerElapsedTime", String.valueOf(l1 - f), "gtm.timerEventNumber", String.valueOf(g), "gtm.triggers", c
                }));
            }
            adk.c(a).postDelayed(this, d);
        }

        a(String s, String s1, long l1, long l2)
        {
            a = adk.this;
            super();
            b = s;
            c = s1;
            d = l1;
            e = l2;
        }
    }


    private static final String a;
    private static final String b;
    private static final String c;
    private static final String d;
    private static final String e;
    private boolean f;
    private boolean g;
    private final Context h;
    private aah i;
    private final HandlerThread j = new HandlerThread("Google GTM SDK Timer", 10);
    private Handler k;
    private final Set l = new HashSet();

    public adk(Context context, aah aah)
    {
        super(a, new String[] {
            c, b
        });
        h = context;
        i = aah;
        j.start();
        k = new Handler(j.getLooper());
    }

    static Set a(adk adk1)
    {
        return adk1.l;
    }

    static aah b(adk adk1)
    {
        return adk1.i;
    }

    static Handler c(adk adk1)
    {
        return adk1.k;
    }

    static boolean d(adk adk1)
    {
        return adk1.g;
    }

    static boolean e(adk adk1)
    {
        return adk1.f;
    }

    static Context f(adk adk1)
    {
        return adk1.h;
    }

    public lv.a a(Map map)
    {
label0:
        {
label1:
            {
                String s1 = ado.a((lv.a)map.get(b));
                String s = ado.a((lv.a)map.get(e));
                String s2 = ado.a((lv.a)map.get(c));
                map = ado.a((lv.a)map.get(d));
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
            if (!l.contains(map))
            {
                if (!"0".equals(map))
                {
                    l.add(map);
                }
                k.postDelayed(new a(s1, map, l1, l2), l1);
            }
        }
        return ado.f();
    }

    public boolean a()
    {
        return false;
    }

    static 
    {
        a = ls.aL.toString();
        b = lt.bH.toString();
        c = lt.bm.toString();
        d = lt.bu.toString();
        e = lt.dl.toString();
    }
}
