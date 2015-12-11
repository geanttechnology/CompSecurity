// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;

import java.lang.reflect.Method;

// Referenced classes of package de.greenrobot.event:
//            ThreadMode

final class SubscriberMethod
{

    final Class eventType;
    final Method method;
    String methodString;
    final int priority;
    final boolean sticky;
    final ThreadMode threadMode;

    SubscriberMethod(Method method1, Class class1, ThreadMode threadmode, int i, boolean flag)
    {
        method = method1;
        threadMode = threadmode;
        eventType = class1;
        priority = i;
        sticky = flag;
    }

    private void checkMethodString()
    {
        this;
        JVM INSTR monitorenter ;
        if (methodString == null)
        {
            StringBuilder stringbuilder = new StringBuilder(64);
            stringbuilder.append(method.getDeclaringClass().getName());
            stringbuilder.append('#').append(method.getName());
            stringbuilder.append('(').append(eventType.getName());
            methodString = stringbuilder.toString();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof SubscriberMethod)
        {
            checkMethodString();
            obj = (SubscriberMethod)obj;
            ((SubscriberMethod) (obj)).checkMethodString();
            return methodString.equals(((SubscriberMethod) (obj)).methodString);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return method.hashCode();
    }
}
