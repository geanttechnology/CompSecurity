// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;

import java.lang.reflect.Method;

// Referenced classes of package com.millennialmedia.google.gson.internal:
//            n

final class nit> extends n
{

    private Method a;
    private Object b;

    public final Object a(Class class1)
    {
        return a.invoke(b, new Object[] {
            class1
        });
    }

    (Method method, Object obj)
    {
        a = method;
        b = obj;
        super();
    }
}
