// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.concurrent.TimeUnit;

class g extends as
    implements al
{

    private static final d k = new d() {

    };
    DexClassLoader a;
    private volatile boolean e;
    private m f;
    private long g;
    private j h;
    private ao i;
    private ag j;

    g()
    {
        e = false;
        g = -1L;
    }

    static long a(g g1)
    {
        return g1.g;
    }

    static long a(g g1, long l1)
    {
        g1.g = l1;
        return l1;
    }

    static h a(g g1, ClassLoader classloader)
    {
        return a(classloader);
    }

    private static h a(ClassLoader classloader)
    {
        return (h)classloader.loadClass("com.appdynamics.eumagent.runtime.InfoPointInitializer").newInstance();
    }

    static void a(g g1, b._cls1 _pcls1)
    {
        _pcls1.a(-1L);
    }

    static e b(g g1)
    {
        return g1.b().c();
    }

    private static int e()
    {
        java.lang.reflect.Field afield[];
        int i1;
        try
        {
            afield = Class.forName("com.appdynamics.eumagent.runtime.InfoPointRegister").getFields();
        }
        catch (Exception exception)
        {
            bc.b("Error accessing total number of fields in InfoPointRegister", exception);
            return 0;
        }
        if (afield == null)
        {
            return 0;
        }
        i1 = afield.length;
        return i1;
    }

    public final void a()
    {
        if (h != null)
        {
            h.a();
        }
    }

    final void a(ag ag)
    {
        j = ag;
    }

    final void a(ah ah1)
    {
        bb bb1 = new bb();
        int i1 = e();
        bc.a("%d classes support dynamic infopoints.", i1);
        if (i1 == 0)
        {
            bc.a("This application does not support dynamic infopoints. Scheduler not enabled.");
            return;
        }
        if (l.d != null && l.d.h())
        {
            bc.a("Safety flag for dynamic infopoints was not turned off. Disabling Scheduler.");
            return;
        }
        if (h == null)
        {
            h = new j(this, bb1, ah1);
        }
        ah1.a(h, (int)TimeUnit.MINUTES.toMillis(60L));
        j.a(h, System.currentTimeMillis());
    }

    final void a(Context context)
    {
        b._cls1 _lcls1;
label0:
        {
            _lcls1 = l.d;
            if (_lcls1.c())
            {
                if (!_lcls1.h())
                {
                    break label0;
                }
                bc.a("Safety flag for dynamic infopoints was not turned off. Assuming previous attempt to setup failed and disabling all future attempts");
            }
            return;
        }
        long l1 = _lcls1.d();
        if (l1 > 1L)
        {
            bc.a("VersionCounter = %d has exceeded limit of %d. Not initializing info points", Long.valueOf(l1), Integer.valueOf(1));
            return;
        }
        l1 = System.currentTimeMillis();
        context = new k(context, _lcls1.e(), (byte)0);
        if (!((k) (context)).c.exists())
        {
            bc.a("Info point enabled, but dex file %s is missing. Not initializing info points", ((k) (context)).c);
            _lcls1.a(-1L);
            return;
        }
        try
        {
            _lcls1.a(true);
            a = new DexClassLoader(((k) (context)).c.getAbsolutePath(), ((k) (context)).a.getAbsolutePath(), null, getClass().getClassLoader());
            context = a(((ClassLoader) (a)));
            bc.a(context.toString());
            context.a();
            bc.a("Total time taken to initialize info points = %s ms.", Long.valueOf(System.currentTimeMillis() - l1));
            _lcls1.a(false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bc.b("Error setting up info points", context);
        }
        _lcls1.a(-1L);
    }

    final void a(ao ao1)
    {
        i = ao1;
    }

    final m b()
    {
        this;
        JVM INSTR monitorenter ;
        m m1;
        if (f == null)
        {
            f = l.c.k.a().a();
        }
        m1 = f;
        this;
        JVM INSTR monitorexit ;
        return m1;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean c()
    {
        return e;
    }

    public final void d()
    {
        e = false;
    }

}
