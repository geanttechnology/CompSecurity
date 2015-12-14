// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.c.e;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.signals.activityrecognition.b;
import com.inmobi.signals.b.c;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.inmobi.signals:
//            o, j, k, m, 
//            LocationInfo, l, n

class i
{
    static class a extends Handler
    {

        private List a;

        static void a(a a1, m m1)
        {
            a1.a(m1);
        }

        private void a(l l1)
        {
            p.b b1 = com.inmobi.signals.o.a().e();
            (new j(new k(b1.e(), b1.f(), b1.g(), com.inmobi.signals.o.a().d(), l1))).a();
        }

        private void a(m m1)
        {
            if (a != null && m1.a())
            {
                a.add(m1);
                if (a.size() > com.inmobi.signals.o.a().e().d())
                {
                    com.inmobi.commons.core.c.a.a().a(new e("signals", "SampleSizeExceeded"));
                    for (; a.size() > com.inmobi.signals.o.a().e().d(); a.remove(0)) { }
                }
            }
        }

        public static boolean a()
        {
            ActivityManager activitymanager;
            activitymanager = (ActivityManager)com.inmobi.commons.a.a.b().getSystemService("activity");
            if (activitymanager == null)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            if (!((android.app.ActivityManager.RunningTaskInfo)activitymanager.getRunningTasks(1).get(0)).topActivity.getPackageName().equalsIgnoreCase(com.inmobi.commons.a.a.b().getPackageName()))
            {
                break MISSING_BLOCK_LABEL_74;
            }
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, i.d(), "Is app in foreground check for below ICS: true");
            return true;
            NullPointerException nullpointerexception;
            nullpointerexception;
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, i.d(), "NPE while determining if app is in foreground for below ICS devices.", nullpointerexception);
            return false;
        }

        private void b()
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, i.d(), "User data collection started.");
            com.inmobi.signals.LocationInfo.a().b();
            sendEmptyMessage(3);
        }

        private void c()
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, i.d(), "Stopping user data collection.");
            com.inmobi.signals.activityrecognition.b.a().c();
            removeMessages(3);
            sendEmptyMessage(4);
        }

        private void d()
        {
            m m1 = new m();
            m1.a(com.inmobi.signals.b.b.a());
            m1.a(com.inmobi.signals.LocationInfo.a().d());
            if (com.inmobi.signals.o.a().e().k() && com.inmobi.signals.b.b.c())
            {
                if (!com.inmobi.signals.b.c.a(new com.inmobi.signals.b.c.a(this, m1) {

        final m a;
        final a b;

        public void a()
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, i.d(), "Wifi scan timeout.");
            com.inmobi.signals.a.a(b, a);
        }

        public void a(List list)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, i.d(), "Wifi scan successful.");
            a.a(list);
            com.inmobi.signals.a.a(b, a);
        }

            
            {
                b = a1;
                a = m1;
                super();
            }
    }))
                {
                    a(m1);
                }
                return;
            } else
            {
                a(m1);
                return;
            }
        }

        private l e()
        {
            l l1 = new l();
            l1.a(com.inmobi.signals.a.c.a());
            l1.a(com.inmobi.signals.LocationInfo.a().c());
            l1.a(a);
            l1.a(com.inmobi.signals.n.a().d());
            l1.b(com.inmobi.signals.activityrecognition.b.a().d());
            return l1;
        }

        private void f()
        {
            com.inmobi.signals.activityrecognition.b.a().e();
            a = new ArrayList();
        }

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return;

            case 1: // '\001'
                b();
                return;

            case 2: // '\002'
                c();
                return;

            case 3: // '\003'
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, i.d(), "Polling for samples.");
                if (android.os.Build.VERSION.SDK_INT < 14 && !a())
                {
                    sendEmptyMessage(2);
                    return;
                }
                if (com.inmobi.signals.o.a().e().q())
                {
                    com.inmobi.signals.activityrecognition.b.a().b();
                } else
                {
                    com.inmobi.signals.activityrecognition.b.a().c();
                }
                d();
                sendEmptyMessageDelayed(3, com.inmobi.signals.o.a().e().b() * 1000);
                return;

            case 4: // '\004'
                a(e());
                f();
                return;
            }
        }

        a(Looper looper)
        {
            super(looper);
            a = new ArrayList();
        }
    }


    private static final String a = com/inmobi/signals/i.getSimpleName();
    private HandlerThread b;
    private a c;

    public i()
    {
        b = new HandlerThread("DataCollectionHandler");
        b.start();
        c = new a(b.getLooper());
    }

    static String d()
    {
        return a;
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (android.os.Build.VERSION.SDK_INT >= 14 || b()) goto _L2; else goto _L1
_L1:
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "User data collection can not be started as the data collector is not properly initialized.");
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (c.hasMessages(3))
        {
            break MISSING_BLOCK_LABEL_67;
        }
        c.removeMessages(2);
        c.sendEmptyMessage(1);
          goto _L3
        Exception exception;
        exception;
        throw exception;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "User data collection already running.");
          goto _L3
    }

    public boolean b()
    {
        return com.inmobi.commons.a.a.b().checkCallingOrSelfPermission("android.permission.GET_TASKS") == 0;
    }

    public void c()
    {
        c.sendEmptyMessageDelayed(2, com.inmobi.signals.o.a().e().c() * 1000);
    }

}
