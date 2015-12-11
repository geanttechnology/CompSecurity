// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;

// Referenced classes of package u.aly:
//            d, e, g, b, 
//            i, f

public class h
{

    private static d a = null;
    private static f b = null;

    public h()
    {
    }

    public static d a(Context context)
    {
        u/aly/h;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new d(context);
            a.a(new e(context));
            a.a(new g(context));
            a.a(new b(context));
            a.a(new i(context));
            a.e();
        }
        context = a;
        u/aly/h;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static f b(Context context)
    {
        u/aly/h;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new f(context);
            b.b();
        }
        context = b;
        u/aly/h;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

}
