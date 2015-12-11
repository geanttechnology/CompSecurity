// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.reflect;

import com.google.common.collect.ImmutableMap;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessControlException;

// Referenced classes of package com.google.common.reflect:
//            Types

private static final class typeVariableImpl
    implements InvocationHandler
{

    private static final ImmutableMap typeVariableMethods;
    private final typeVariableMethods typeVariableImpl;

    public Object invoke(Object obj, Method method, Object aobj[])
        throws Throwable
    {
        obj = method.getName();
        method = (Method)typeVariableMethods.get(obj);
        if (method == null)
        {
            throw new UnsupportedOperationException(((String) (obj)));
        }
        try
        {
            obj = method.invoke(typeVariableImpl, aobj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw ((InvocationTargetException) (obj)).getCause();
        }
        return obj;
    }

    static 
    {
        com.google.common.collect.typeVariableImpl typevariableimpl = ImmutableMap.builder();
        Method amethod[] = com/google/common/reflect/Types$TypeVariableImpl.getMethods();
        int j = amethod.length;
        int i = 0;
        while (i < j) 
        {
            Method method = amethod[i];
            if (!method.getDeclaringClass().equals(com/google/common/reflect/Types$TypeVariableImpl))
            {
                continue;
            }
            try
            {
                method.setAccessible(true);
            }
            catch (AccessControlException accesscontrolexception) { }
            typevariableimpl.typeVariableImpl(method.getName(), method);
            i++;
        }
        typeVariableMethods = typevariableimpl.typeVariableMethods();
    }


    ( )
    {
        typeVariableImpl = ;
    }
}
