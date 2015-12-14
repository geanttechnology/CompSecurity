// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;

import android.content.Context;
import android.content.pm.PackageManager;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.inmobi.signals:
//            a, e, d, f, 
//            o, b, c

public class g
{

    private static final String a = com/inmobi/signals/g.getSimpleName();
    private p.a b;
    private boolean c;
    private com.inmobi.signals.a d;
    private e e;

    public g()
    {
        c = false;
        d = new com.inmobi.signals.a();
        e = new e();
    }

    static c a(g g1)
    {
        return g1.c();
    }

    static List a(g g1, List list)
    {
        return g1.a(list);
    }

    private List a(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < list.size(); i++)
        {
            if (!a(((d)list.get(i)).a()))
            {
                arraylist.add(list.get(i));
            }
        }

        return arraylist;
    }

    private void a(c c1, List list)
    {
        c1 = new f(b.c(), b.e(), b.f(), com.inmobi.signals.o.a().d(), list, c1);
        c1.b(b.g() * 1000);
        c1.c(b.g() * 1000);
        e.a(c1);
    }

    static void a(g g1, c c1, List list)
    {
        g1.a(c1, list);
    }

    private boolean a()
    {
        for (long l = d.b(); l == 0L || System.currentTimeMillis() - l >= (long)(b.d() * 1000);)
        {
            return true;
        }

        return false;
    }

    static boolean a(g g1, boolean flag)
    {
        g1.c = flag;
        return flag;
    }

    private boolean a(String s)
    {
        PackageManager packagemanager = com.inmobi.commons.a.a.b().getPackageManager();
        try
        {
            packagemanager.getPackageInfo(s, 256);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    static com.inmobi.signals.a b(g g1)
    {
        return g1.d;
    }

    private void b()
    {
        (new Thread(new Runnable() {

            final g a;

            public void run()
            {
                c c1 = com.inmobi.signals.g.a(a);
                if (!c1.a())
                {
                    g.b(a).a(System.currentTimeMillis());
                    if (!c1.e())
                    {
                        com.inmobi.signals.g.a(a, c1, com.inmobi.signals.g.a(a, c1.b()));
                    }
                }
                com.inmobi.signals.g.a(a, false);
            }

            
            {
                a = g.this;
                super();
            }
        })).start();
    }

    private c c()
    {
        b b1 = new b(b.b(), b.e(), b.f(), com.inmobi.signals.o.a().d());
        b1.a(b.h());
        b1.b(b.g() * 1000);
        b1.c(b.g() * 1000);
        return e.a(b1);
    }

    public void a(p.a a1)
    {
        this;
        JVM INSTR monitorenter ;
        b = a1;
        if (c || !a()) goto _L2; else goto _L1
_L1:
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Starting Carb worker");
        c = true;
        b();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Carb worker did not admit Carb start request.");
        if (true) goto _L4; else goto _L3
_L3:
        a1;
        throw a1;
    }

}
