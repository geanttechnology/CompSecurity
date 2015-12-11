// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.api.Status;

class asd
    implements aqe
{

    private aqd a;
    private aqd b;
    private Status c;
    private asf d;
    private ase e;
    private boolean f;
    private aql g;

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (!f) goto _L2; else goto _L1
_L1:
        aqv.a("Releasing a released ContainerHolder.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        f = true;
        g.a(this);
        a.b();
        a = null;
        b = null;
        e = null;
        d = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = f;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        a.a(s);
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    public Status b()
    {
        return c;
    }

    void b(String s)
    {
        if (f)
        {
            aqv.a("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
            return;
        } else
        {
            e.a(s);
            return;
        }
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        if (!f) goto _L2; else goto _L1
_L1:
        aqv.a("Refreshing a released ContainerHolder.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        e.a();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    String d()
    {
        if (f)
        {
            aqv.a("getContainerId called on a released ContainerHolder.");
            return "";
        } else
        {
            return a.a();
        }
    }

    String e()
    {
        if (f)
        {
            aqv.a("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
            return "";
        } else
        {
            return e.b();
        }
    }
}
