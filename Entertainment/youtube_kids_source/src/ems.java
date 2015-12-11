// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Closeable;
import java.lang.reflect.Method;

final class ems
    implements emt
{

    static final ems a = new ems();
    private static Method b = b();

    ems()
    {
    }

    static boolean a()
    {
        return b != null;
    }

    private static Method b()
    {
        Method method;
        try
        {
            method = java/lang/Throwable.getMethod("addSuppressed", new Class[] {
                java/lang/Throwable
            });
        }
        catch (Throwable throwable)
        {
            return null;
        }
        return method;
    }

    public final void a(Closeable closeable, Throwable throwable, Throwable throwable1)
    {
        if (throwable == throwable1)
        {
            return;
        }
        try
        {
            b.invoke(throwable, new Object[] {
                throwable1
            });
            return;
        }
        catch (Throwable throwable2)
        {
            emr.a.a(closeable, throwable, throwable1);
        }
    }

}
