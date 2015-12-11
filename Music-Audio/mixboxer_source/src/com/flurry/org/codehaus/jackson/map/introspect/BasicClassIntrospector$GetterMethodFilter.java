// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.introspect;

import com.flurry.org.codehaus.jackson.map.util.ClassUtil;
import java.lang.reflect.Method;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.introspect:
//            MethodFilter, BasicClassIntrospector

public static class <init>
    implements MethodFilter
{

    public boolean includeMethod(Method method)
    {
        return ClassUtil.hasGetterSignature(method);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
