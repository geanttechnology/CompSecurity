// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.util;

import java.lang.reflect.Method;

public final class ExceptionUtils
{

    private static final Method INIT_CAUSE_METHOD = getInitCauseMethod();
    static Class class$java$lang$Throwable;

    private ExceptionUtils()
    {
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    private static Method getInitCauseMethod()
    {
        Class class1;
        Class class2;
        try
        {
            if (class$java$lang$Throwable == null)
            {
                class1 = _mthclass$("java.lang.Throwable");
                class$java$lang$Throwable = class1;
            } else
            {
                class1 = class$java$lang$Throwable;
            }
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            return null;
        }
        if (class$java$lang$Throwable != null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        class2 = _mthclass$("java.lang.Throwable");
        class$java$lang$Throwable = class2;
        return class2.getMethod("initCause", new Class[] {
            class1
        });
        class2 = class$java$lang$Throwable;
        break MISSING_BLOCK_LABEL_32;
    }

    public static void initCause(Throwable throwable, Throwable throwable1)
    {
        if (INIT_CAUSE_METHOD == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        INIT_CAUSE_METHOD.invoke(throwable, new Object[] {
            throwable1
        });
        return;
        throwable;
    }

}
