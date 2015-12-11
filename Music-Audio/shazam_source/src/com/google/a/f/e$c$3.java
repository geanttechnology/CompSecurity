// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.f;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

// Referenced classes of package com.google.a.f:
//            e

static final class nit> extends nit>
{

    final Type a(Type type)
    {
        return b.b(type);
    }

    final Type b(Type type)
    {
        return b.b(type);
    }

    final String c(Type type)
    {
        try
        {
            type = (String)java/lang/reflect/Type.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Type type)
        {
            throw new AssertionError("Type.getTypeName should be available in Java 8");
        }
        // Misplaced declaration of an exception variable
        catch (Type type)
        {
            throw new RuntimeException(type);
        }
        // Misplaced declaration of an exception variable
        catch (Type type)
        {
            throw new RuntimeException(type);
        }
        return type;
    }

    ssException(String s)
    {
        super(s, 2, (byte)0);
    }
}
