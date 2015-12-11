// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

// Referenced classes of package com.a.a.a:
//            u

final class r
    implements InvocationHandler
{

    private final List a;
    private boolean b;
    private String c;

    public r(List list)
    {
        a = list;
    }

    static boolean a(r r1)
    {
        return r1.b;
    }

    static String b(r r1)
    {
        return r1.c;
    }

    public final Object invoke(Object obj, Method method, Object aobj[])
    {
        String s = method.getName();
        Class class1 = method.getReturnType();
        obj = ((Object) (aobj));
        if (aobj == null)
        {
            obj = u.b;
        }
        if (s.equals("supports") && Boolean.TYPE == class1)
        {
            return Boolean.valueOf(true);
        }
        if (s.equals("unsupported") && Void.TYPE == class1)
        {
            b = true;
            return null;
        }
        if (s.equals("protocols") && obj.length == 0)
        {
            return a;
        }
        if (s.equals("selectProtocol") && java/lang/String == class1 && obj.length == 1 && (obj[0] == null || (obj[0] instanceof List)))
        {
            c = (String)a.get(0);
            return c;
        }
        if (s.equals("protocolSelected") && obj.length == 1)
        {
            c = (String)obj[0];
            return null;
        } else
        {
            return method.invoke(this, ((Object []) (obj)));
        }
    }
}
