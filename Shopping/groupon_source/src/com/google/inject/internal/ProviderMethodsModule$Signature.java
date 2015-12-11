// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.TypeLiteral;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.inject.internal:
//            ProviderMethodsModule

private final class parameters
{

    final int hashCode;
    final String name;
    final Class parameters[];
    final ProviderMethodsModule this$0;

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof parameters)
        {
            obj = (parameters)obj;
            flag = flag1;
            if (((parameters) (obj)).name.equals(name))
            {
                flag = flag1;
                if (Arrays.equals(parameters, ((parameters) (obj)).parameters))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return hashCode;
    }

    (Method method)
    {
        this$0 = ProviderMethodsModule.this;
        super();
        name = method.getName();
        providermethodsmodule = ProviderMethodsModule.access$000(ProviderMethodsModule.this).getParameterTypes(method);
        parameters = new Class[size()];
        for (providermethodsmodule = iterator(); hasNext();)
        {
            method = (TypeLiteral)next();
            parameters[0] = method.getRawType();
        }

        hashCode = name.hashCode() + Arrays.hashCode(parameters) * 31;
    }
}
