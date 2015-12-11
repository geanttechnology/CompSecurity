// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crittercism.app;

import a.a.aa;
import a.a.at;
import a.a.cs;
import a.a.ct;
import a.a.eb;
import a.a.em;
import a.a.en;
import android.content.Context;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.crittercism.app:
//            CrittercismConfig

public class Crittercism
{

    private Crittercism()
    {
    }

    public static void a(Context context, String s, CrittercismConfig crittercismconfig)
    {
        com/crittercism/app/Crittercism;
        JVM INSTR monitorenter ;
        if (at.a(s) == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Invalid appID '")).append(s).append("'. Crittercism cannot be initialized").toString());
        }
        break MISSING_BLOCK_LABEL_45;
        context;
        com/crittercism/app/Crittercism;
        JVM INSTR monitorexit ;
        throw context;
        if (s != null) goto _L2; else goto _L1
_L1:
        b(java/lang/String.getCanonicalName());
_L3:
        com/crittercism/app/Crittercism;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        b(android/content/Context.getCanonicalName());
          goto _L3
        context;
        throw context;
        if (crittercismconfig != null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        b(com/crittercism/app/CrittercismConfig.getCanonicalName());
          goto _L3
        context;
        en.a(context);
          goto _L3
        boolean flag = aa.A().b;
        if (flag) goto _L3; else goto _L4
_L4:
        long l = System.nanoTime();
        aa.A().a(context, s, crittercismconfig);
        l = (System.nanoTime() - l) / 0xf4240L;
        (new StringBuilder("Crittercism finished initializing in ")).append(l).append("ms");
        en.b();
          goto _L3
        context;
        (new StringBuilder("Exception in init > getInstance().initialize(..): ")).append(context.getClass().getName());
        en.b();
          goto _L3
    }

    public static void a(String s)
    {
        if (!aa.A().b)
        {
            c("leaveBreadcrumb");
            return;
        }
        if (s == null)
        {
            aa aa1;
            a.a.aa._cls4 _lcls4;
            try
            {
                en.b("Cannot leave null breadcrumb", new NullPointerException());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw s;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                en.a(s);
            }
            break MISSING_BLOCK_LABEL_118;
        }
        aa1 = aa.A();
        if (!aa1.f.b())
        {
            _lcls4 = new a.a.aa._cls4(aa1, new cs(s, ct.a));
            if (!aa1.q.a(_lcls4))
            {
                (new StringBuilder("SENDING ")).append(s).append(" TO EXECUTOR");
                en.b();
                aa1.s.execute(_lcls4);
                return;
            }
        }
    }

    public static void a(Throwable throwable)
    {
        if (!aa.A().b)
        {
            c("logHandledException");
            return;
        }
        try
        {
            if (!aa.A().f.b())
            {
                aa.A().b(throwable);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            throw throwable;
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            en.a(throwable);
        }
        return;
    }

    private static void b(String s)
    {
        en.b("Crittercism cannot be initialized", new NullPointerException((new StringBuilder()).append(s).append(" was null").toString()));
    }

    private static void c(String s)
    {
        en.b((new StringBuilder("Must initialize Crittercism before calling ")).append(com/crittercism/app/Crittercism.getName()).append(".").append(s).append("().  Request is being ignored...").toString(), new IllegalStateException());
    }
}
