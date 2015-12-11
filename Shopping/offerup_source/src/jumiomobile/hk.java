// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;

// Referenced classes of package jumiomobile:
//            an, ke, pk

public class hk extends an
{

    private static hk a;

    public hk()
    {
    }

    public static void b(Context context)
    {
        if (!d().b())
        {
            d().a();
            d().a("TemplateDatabaseService", new ke());
            d().a("BenchmarkService", new pk());
            d().a(context);
        }
    }

    public static an d()
    {
        jumiomobile/hk;
        JVM INSTR monitorenter ;
        hk hk1;
        if (a == null)
        {
            a = new hk();
        }
        hk1 = a;
        jumiomobile/hk;
        JVM INSTR monitorexit ;
        return hk1;
        Exception exception;
        exception;
        throw exception;
    }
}
