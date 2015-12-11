// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;

public class l
{

    static volatile ab a;
    static volatile s b;
    static volatile l c = null;
    static volatile b._cls1 d;
    static volatile boolean e = false;
    static final bg f = new bg();
    static final g g = new g();
    static final bi h = new bi();
    private static av p;
    private static f q;
    final bk i;
    final ax j;
    final ao k;
    final bf l;
    final Context m;
    final am n;
    final a o;
    private volatile String r;
    private aa s;
    private ScheduledExecutorService t;
    private ag u;

    private l(String s1, ao ao, aa aa1, bk bk, ax ax, bf bf, Context context, 
            am am, ScheduledExecutorService scheduledexecutorservice, ag ag, ae ae, a a1)
    {
        r = s1;
        k = ao;
        s = aa1;
        i = bk;
        j = ax;
        l = bf;
        m = context;
        n = am;
        t = scheduledexecutorservice;
        u = ag;
        o = a1;
    }

    l(String s1, ao ao, aa aa1, bk bk, ax ax, bf bf, Context context, 
            am am, ScheduledExecutorService scheduledexecutorservice, ag ag, ae ae, a a1, byte byte0)
    {
        this(s1, ao, aa1, bk, ax, bf, context, am, scheduledexecutorservice, ag, ae, a1);
    }

    static void a(long l1)
    {
        if (l1 > 0L && c != null)
        {
            c.s.a("disable_until", l1);
            c.s.b();
        }
        e = false;
        c = null;
    }

    public static void a(b b1)
    {
        boolean flag = true;
        l;
        JVM INSTR monitorenter ;
        String s1;
        String s2;
        boolean flag1;
        bc.a(true);
        s1 = b(b1);
        bc.a(b1.e);
        bc.a((new StringBuilder("Agent version = 4.1.5.0, agent build = 4a7494a184c449ed1cdc3f18d8c1d70e96674133, appBuildID = ")).append(s1).append(", starting up with appkey [").append(b1.a).append("]").toString());
        s2 = b1.b.getClass().getName();
        flag1 = e;
        if (c != null)
        {
            flag = false;
        }
        bc.a(String.format("start called from activity: %s, initializationStarted = %s, instance is null = %s", new Object[] {
            s2, Boolean.valueOf(flag1), Boolean.valueOf(flag)
        }));
        if (c != null || e) goto _L2; else goto _L1
_L1:
        a = new ab();
        d = new b._cls1(b1.b, s1);
        g.a(b1.b);
        Object obj = new s(2000L, a);
        b = ((s) (obj));
        ((s) (obj)).start();
        obj = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {

            public final Thread newThread(Runnable runnable)
            {
                runnable = new Thread(runnable);
                runnable.setName("ADEum-Agent");
                return runnable;
            }

        }, new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
        av av1 = new av(b1.b, ((ScheduledExecutorService) (obj)), Thread.getDefaultUncaughtExceptionHandler());
        p = av1;
        Thread.setDefaultUncaughtExceptionHandler(av1);
        q = b1.f;
        e = true;
        ((ScheduledExecutorService) (obj)).execute(new n(b1.a, b1.b, ((ScheduledExecutorService) (obj)), b1.c, b1.d, s1, (byte)0));
_L4:
        l;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (c == null || c.r.equals(b1.a)) goto _L4; else goto _L3
_L3:
        throw new IllegalStateException("Instrumentation framework was already initialized with a different key");
        b1;
        l;
        JVM INSTR monitorexit ;
        throw b1;
    }

    private static void a(String s1)
    {
        if (s1 == null || s1.trim().length() == 0)
        {
            throw new IllegalArgumentException("AppKey cannot be null or empty");
        }
        if (!Pattern.matches("[a-zA-Z0-9]{1,}(-[A-Z]{3}){2,}", s1))
        {
            throw new IllegalArgumentException((new StringBuilder("AppKey is malformed: ")).append(s1).append(", it should look like: AD-AAA-BBB").toString());
        } else
        {
            return;
        }
    }

    public static void a(String s1, Context context)
    {
        a(b.a().a(s1).a(context).a());
    }

    static av b()
    {
        return p;
    }

    private static String b(b b1)
    {
        int i1;
        a(b1.a);
        try
        {
            new URL(b1.c);
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new IllegalArgumentException((new StringBuilder("[")).append(b1.c).append("] is not a valid collector url.").toString(), malformedurlexception);
        }
        if (b1.b == null)
        {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        if (!b1.g)
        {
            bc.a("WARNING: Compile time instrumentation check is disabled.");
            return null;
        }
        Field field;
        int j1;
        try
        {
            b1 = Class.forName("com.appdynamics.eumagent.runtime.BuildInfo").getDeclaredFields();
            j1 = b1.length;
        }
        // Misplaced declaration of an exception variable
        catch (b b1)
        {
            bc.b("App not instrumented!", b1);
            throw new IllegalStateException("Unable to start Appdynamics' android agent. Your application doesn't seem to be instrumented by AppDynamics's compile time instrumentation. Please ensure that you have configured your build system (ant/gradle/maven) to run AppDynamics' instrumentation. For more information please consult the documentation.");
        }
        i1 = 0;
_L2:
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        field = b1[i1];
        if (!field.getName().startsWith("appdynamicsGeneratedBuildId_"))
        {
            break MISSING_BLOCK_LABEL_176;
        }
        b1 = field.getName().substring(28);
        bc.a((new StringBuilder("APK's build id = ")).append(b1).toString());
        return b1;
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        bc.a("BuildInfo class exists, but no field beginning with prefix: appdynamicsGeneratedBuildId_");
        throw new IllegalStateException("Application has to be instrumented before calling Instrumentation.start()");
    }

    static f c()
    {
        return q;
    }

    final void a()
    {
        if (!t.isShutdown())
        {
            bc.a("Shutting down executor pool and anr detector.");
            b.a();
            t.shutdownNow();
        }
    }

}
