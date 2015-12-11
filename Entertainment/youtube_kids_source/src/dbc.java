// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

public final class dbc
    implements InvocationHandler
{

    final Object a;
    private Executor b;

    public dbc(Object obj, Executor executor)
    {
        a = obj;
        b = executor;
        super();
    }

    public final Object invoke(Object obj, Method method, Object aobj[])
    {
        obj = new dbd(this, method, aobj, a.J());
        b.execute(((Runnable) (obj)));
        return null;
    }
}
