// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.persistance;


// Referenced classes of package com.gimbal.internal.persistance:
//            f, e

public final class b
{

    public f a;
    private String b;

    public b(f f1)
    {
        a = f1;
    }

    public final transient void a(e e, String as[])
    {
        a.a(e, as);
    }

    public final void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        a.b("Api_Key", s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public final boolean a()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.a("Sightings_Logs", Boolean.valueOf(false)).booleanValue();
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public final String b()
    {
        this;
        JVM INSTR monitorenter ;
        String s = a.a("Api_Key", null);
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public final void b(String s)
    {
        this;
        JVM INSTR monitorenter ;
        b = s;
        a.b("Beacon_Resolve_Base_Url", s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public final String c()
    {
        this;
        JVM INSTR monitorenter ;
        String s;
        if (b == null)
        {
            b = a.a("Beacon_Resolve_Base_Url", "https://beaconlookup.gimbal.com/");
        }
        s = b;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }
}
