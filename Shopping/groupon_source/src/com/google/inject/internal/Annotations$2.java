// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

// Referenced classes of package com.google.inject.internal:
//            Annotations

static final class val.members
    implements InvocationHandler
{

    final Class val$annotationType;
    final Map val$members;

    public Object invoke(Object obj, Method method, Object aobj[])
        throws Exception
    {
        obj = method.getName();
        if (((String) (obj)).equals("annotationType"))
        {
            return val$annotationType;
        }
        if (((String) (obj)).equals("toString"))
        {
            return Annotations.access$100(val$annotationType, val$members);
        }
        if (((String) (obj)).equals("hashCode"))
        {
            return Integer.valueOf(Annotations.access$200(val$annotationType, val$members));
        }
        if (((String) (obj)).equals("equals"))
        {
            return Boolean.valueOf(Annotations.access$300(val$annotationType, val$members, aobj[0]));
        } else
        {
            return val$members.get(obj);
        }
    }

    (Class class1, Map map)
    {
        val$annotationType = class1;
        val$members = map;
        super();
    }
}
