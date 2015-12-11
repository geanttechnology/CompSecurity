// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Key;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;

// Referenced classes of package com.google.inject.internal:
//            ProviderMethod

private static final class  extends ProviderMethod
{

    Object doProvision(Object aobj[])
        throws IllegalAccessException, InvocationTargetException
    {
        return method.invoke(instance, aobj);
    }

    (Key key, Method method, Object obj, ImmutableSet immutableset, List list, Class class1)
    {
        super(key, method, obj, immutableset, list, class1, null);
    }
}
