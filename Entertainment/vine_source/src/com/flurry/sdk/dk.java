// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            dm, dn, el, di, 
//            dg

public class dk
{

    private static final String a = com/flurry/sdk/dk.getSimpleName();
    private static dk b;

    public dk()
    {
    }

    public static dk a()
    {
        com/flurry/sdk/dk;
        JVM INSTR monitorenter ;
        dk dk1;
        if (b == null)
        {
            b = new dk();
        }
        dk1 = b;
        com/flurry/sdk/dk;
        JVM INSTR monitorexit ;
        return dk1;
        Exception exception;
        exception;
        throw exception;
    }

    public int b()
    {
        int i1 = ((Integer)dm.a().a("AgentVersion")).intValue();
        el.a(4, a, (new StringBuilder()).append("getAgentVersion() = ").append(i1).toString());
        return i1;
    }

    int c()
    {
        return ((Integer)dm.a().a("ReleaseMajorVersion")).intValue();
    }

    int d()
    {
        return ((Integer)dm.a().a("ReleaseMinorVersion")).intValue();
    }

    int e()
    {
        return ((Integer)dm.a().a("ReleasePatchVersion")).intValue();
    }

    String f()
    {
        return (String)dm.a().a("ReleaseBetaVersion");
    }

    public String g()
    {
        String s;
        if (f().length() > 0)
        {
            s = ".";
        } else
        {
            s = "";
        }
        return String.format(Locale.getDefault(), "Flurry_Android_%d_%d.%d.%d%s%s", new Object[] {
            Integer.valueOf(b()), Integer.valueOf(c()), Integer.valueOf(d()), Integer.valueOf(e()), s, f()
        });
    }

    public String h()
    {
        String s = null;
        dg dg1 = di.a().c();
        if (dg1 != null)
        {
            s = dg1.j();
        }
        return s;
    }

    public String i()
    {
        String s = null;
        dg dg1 = di.a().c();
        if (dg1 != null)
        {
            s = dg1.k();
        }
        return s;
    }

    public String j()
    {
        String s = null;
        dg dg1 = di.a().c();
        if (dg1 != null)
        {
            s = dg1.l();
        }
        return s;
    }

    public boolean k()
    {
        dg dg1 = di.a().c();
        if (dg1 != null)
        {
            return dg1.o();
        } else
        {
            return true;
        }
    }

    public Map l()
    {
        dg dg1 = di.a().c();
        if (dg1 != null)
        {
            return dg1.p();
        } else
        {
            return Collections.emptyMap();
        }
    }

}
