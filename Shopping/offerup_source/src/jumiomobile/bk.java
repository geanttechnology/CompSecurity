// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.lang.reflect.Method;

// Referenced classes of package jumiomobile:
//            bj

class bk
{

    private static final Method a = b();

    static Method a()
    {
        return a;
    }

    private static Method b()
    {
        Method method;
        try
        {
            method = Class.forName("java.net.IDN", false, jumiomobile/bj.getClassLoader()).getDeclaredMethod("toASCII", new Class[] {
                java/lang/String
            });
        }
        catch (Exception exception)
        {
            return null;
        }
        return method;
    }

}
