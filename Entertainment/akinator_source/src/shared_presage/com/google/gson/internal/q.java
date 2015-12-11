// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal;

import java.lang.reflect.Method;

// Referenced classes of package shared_presage.com.google.gson.internal:
//            UnsafeAllocator

final class q extends UnsafeAllocator
{

    final Method a;
    final Object b;

    q(Method method, Object obj)
    {
        a = method;
        b = obj;
        super();
    }

    public final Object newInstance(Class class1)
    {
        return a.invoke(b, new Object[] {
            class1
        });
    }
}
