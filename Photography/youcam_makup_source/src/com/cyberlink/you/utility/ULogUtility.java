// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.util.Log;
import com.cyberlink.you.d;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.g;
import com.cyberlink.you.i;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.cyberlink.you.utility:
//            d

public class ULogUtility
{

    private static Object a = new Object();
    private static Object b = new Object();
    private static Object c = new Object();
    private static Object d = new Object();
    private static Object e = new Object();
    private static Object f = new Object();
    private static Object g = new Object();
    private static Object h = new Object();
    private static Object i = new Object();
    private static long j = 0x240c8400L;
    private static long k = 0L;
    private static SimpleDateFormat l = new SimpleDateFormat("MM/dd HH:mm:ss.S");
    private static SimpleDateFormat m = new SimpleDateFormat("yyyy-MM-dd");
    private static BlockingQueue n;
    private static ThreadPoolExecutor o;

    public static File a()
    {
        return a(true);
    }

    public static File a(String s)
    {
        Date date = new Date();
        String s2 = "";
        String s1 = s.substring(s.lastIndexOf("/") + 1);
        if (s1 != null && s1.length() > 1)
        {
            s1 = (new StringBuilder()).append(s1).append("_").toString();
        } else
        {
            s1 = "";
        }
        if (com.cyberlink.you.g.m())
        {
            s2 = "_beta";
        }
        synchronized (m)
        {
            s1 = (new StringBuilder()).append(s1).append(m.format(date)).append(s2).append(".log").toString();
        }
        s = new File(s, s1);
        if (s.exists())
        {
            return s;
        }
        break MISSING_BLOCK_LABEL_141;
        s;
        simpledateformat;
        JVM INSTR monitorexit ;
        throw s;
        try
        {
            s.createNewFile();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static File a(boolean flag)
    {
        return a(j(flag).toString());
    }

    public static String a(String s, boolean flag)
    {
        String s1;
        if (flag)
        {
            s1 = com.cyberlink.you.utility.d.d();
        } else
        {
            s1 = com.cyberlink.you.utility.d.d(d.a);
        }
        s = new File(s1, s);
        if (!s.exists())
        {
            s.mkdir();
        }
        return s.toString();
    }

    static void a(LogType logtype, String s, String s1)
    {
        c(logtype, s, s1);
    }

    public static void a(String s, String s1)
    {
        synchronized (a)
        {
            b(LogType.a, s, s1);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void a(String s, String s1, PingType pingtype)
    {
        synchronized (b)
        {
            b(LogType.b, s, (new StringBuilder()).append(pingtype.toString()).append(": ").append(s1).toString());
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void a(String s, String s1, Exception exception)
    {
        synchronized (h)
        {
            LogType logtype = com.cyberlink.you.utility.LogType.g;
            com.cyberlink.you.i.c(s, new Object[] {
                s1, "Exception: ", exception.getMessage()
            });
            b(logtype, (new StringBuilder()).append(s1).append("Exception: ").append(exception.toString()).toString(), s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void a(String s, String s1, String s2, String s3)
    {
        synchronized (h)
        {
            b(com.cyberlink.you.utility.LogType.g, (new StringBuilder()).append(s1).append(s2).append(s3).toString(), s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static File b()
    {
        return b(true);
    }

    public static File b(boolean flag)
    {
        return a(k(flag).toString());
    }

    private static void b(LogType logtype, String s, String s1)
    {
        if (o == null)
        {
            return;
        } else
        {
            o.execute(new Runnable(logtype, s, s1) {

                final LogType a;
                final String b;
                final String c;

                public void run()
                {
                    ULogUtility.a(a, b, c);
                }

            
            {
                a = logtype;
                b = s;
                c = s1;
                super();
            }
            });
            return;
        }
    }

    public static void b(String s, String s1)
    {
        synchronized (c)
        {
            b(LogType.c, s, s1);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static File c()
    {
        return c(true);
    }

    public static File c(boolean flag)
    {
        return a(l(flag).toString());
    }

    private static void c(LogType logtype, String s, String s1)
    {
        if (k == 0L)
        {
            k = (new l()).i();
        }
        Object obj = new Date(System.currentTimeMillis() + k);
        obj = l.format(((Date) (obj)));
        if (logtype == LogType.a)
        {
            logtype = a();
        } else
        if (logtype == LogType.c)
        {
            logtype = c();
        } else
        if (logtype == com.cyberlink.you.utility.LogType.d)
        {
            logtype = d();
        } else
        if (logtype == LogType.e)
        {
            logtype = e();
        } else
        if (logtype == LogType.f)
        {
            logtype = f();
        } else
        if (logtype == com.cyberlink.you.utility.LogType.g)
        {
            logtype = g();
        } else
        if (logtype == LogType.h)
        {
            logtype = h();
        } else
        if (logtype == com.cyberlink.you.utility.LogType.i)
        {
            logtype = i();
        } else
        {
            logtype = b();
        }
        if (logtype == null)
        {
            Log.d("ULogUtility", "log == null");
            return;
        }
        try
        {
            s = (new StringBuilder()).append("======== ").append(s1).append(" ========\n").append("timestamp").append(": ").append(((String) (obj))).append("\n").append(s).append("\n\n").toString();
            logtype = new FileOutputStream(logtype, true);
            logtype.write(s.getBytes());
            logtype.flush();
            logtype.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (LogType logtype)
        {
            Log.e("ULogUtility", Log.getStackTraceString(logtype));
        }
    }

    public static void c(String s, String s1)
    {
        synchronized (e)
        {
            b(LogType.e, s1, s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static File d()
    {
        return d(true);
    }

    public static File d(boolean flag)
    {
        return a(m(flag).toString());
    }

    public static void d(String s, String s1)
    {
        synchronized (f)
        {
            b(LogType.f, s1, s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static File e()
    {
        return e(true);
    }

    public static File e(boolean flag)
    {
        return a(n(flag).toString());
    }

    public static void e(String s, String s1)
    {
        synchronized (h)
        {
            b(com.cyberlink.you.utility.LogType.g, s1, s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static File f()
    {
        return f(true);
    }

    public static File f(boolean flag)
    {
        return a(o(flag).toString());
    }

    public static void f(String s, String s1)
    {
        synchronized (i)
        {
            b(com.cyberlink.you.utility.LogType.i, s1, s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static File g()
    {
        return g(true);
    }

    public static File g(boolean flag)
    {
        return a(p(flag).toString());
    }

    public static File h()
    {
        return h(true);
    }

    public static File h(boolean flag)
    {
        return a(q(flag).toString());
    }

    public static File i()
    {
        return i(true);
    }

    public static File i(boolean flag)
    {
        return a(r(flag).toString());
    }

    public static String j()
    {
        return j(true);
    }

    public static String j(boolean flag)
    {
        return a("xmppLog", flag);
    }

    public static String k()
    {
        return k(true);
    }

    public static String k(boolean flag)
    {
        return a("pingLog", flag);
    }

    public static String l()
    {
        return l(true);
    }

    public static String l(boolean flag)
    {
        return a("gcmLog", flag);
    }

    public static String m()
    {
        return m(true);
    }

    public static String m(boolean flag)
    {
        return a("sendphotoLog", flag);
    }

    public static String n()
    {
        return n(true);
    }

    public static String n(boolean flag)
    {
        return a("heartbeatLog", flag);
    }

    public static String o()
    {
        return o(true);
    }

    public static String o(boolean flag)
    {
        return a("notificationLog", flag);
    }

    public static String p()
    {
        return a("DBLog", true);
    }

    public static String p(boolean flag)
    {
        return a("DBLog", flag);
    }

    public static String q()
    {
        return a("voicecallLog", true);
    }

    public static String q(boolean flag)
    {
        return a("voicecallLog", flag);
    }

    public static String r()
    {
        return a("unreadcntLog", true);
    }

    public static String r(boolean flag)
    {
        return a("unreadcntLog", flag);
    }

    static 
    {
        n = new LinkedBlockingQueue();
        o = new ThreadPoolExecutor(2, 4, 1L, TimeUnit.SECONDS, n, new ThreadFactory() {

            int a;

            public Thread newThread(Runnable runnable)
            {
                this;
                JVM INSTR monitorenter ;
                int i1;
                i1 = a;
                a = i1 + 1;
                this;
                JVM INSTR monitorexit ;
                return new Thread(runnable, (new StringBuilder()).append("ULogUtil #").append(i1).toString());
                runnable;
                this;
                JVM INSTR monitorexit ;
                throw runnable;
            }

            
            {
                a = 0;
            }
        });
    }

    private class LogType extends Enum
    {

        public static final LogType a;
        public static final LogType b;
        public static final LogType c;
        public static final LogType d;
        public static final LogType e;
        public static final LogType f;
        public static final LogType g;
        public static final LogType h;
        public static final LogType i;
        private static final LogType j[];

        public static LogType valueOf(String s)
        {
            return (LogType)Enum.valueOf(com/cyberlink/you/utility/ULogUtility$LogType, s);
        }

        public static LogType[] values()
        {
            return (LogType[])j.clone();
        }

        static 
        {
            a = new LogType("XMPP", 0);
            b = new LogType("PingServer", 1);
            c = new LogType("GCM", 2);
            d = new LogType("SendPhoto", 3);
            e = new LogType("Heartbeat", 4);
            f = new LogType("Notification", 5);
            g = new LogType("DB", 6);
            h = new LogType("VoiceCall", 7);
            i = new LogType("UnreadCnt", 8);
            j = (new LogType[] {
                a, b, c, d, e, f, g, h, i
            });
        }

        private LogType(String s, int i1)
        {
            super(s, i1);
        }
    }


    private class PingType extends Enum
    {

        public static final PingType a;
        public static final PingType b;
        private static final PingType c[];

        public static PingType valueOf(String s)
        {
            return (PingType)Enum.valueOf(com/cyberlink/you/utility/ULogUtility$PingType, s);
        }

        public static PingType[] values()
        {
            return (PingType[])c.clone();
        }

        static 
        {
            a = new PingType("UServer", 0);
            b = new PingType("XmppServer", 1);
            c = (new PingType[] {
                a, b
            });
        }

        private PingType(String s, int i1)
        {
            super(s, i1);
        }
    }

}
