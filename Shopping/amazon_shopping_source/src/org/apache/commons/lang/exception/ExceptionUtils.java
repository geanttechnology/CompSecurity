// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

public class ExceptionUtils
{

    private static String CAUSE_METHOD_NAMES[] = {
        "getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", 
        "getLinkedCause", "getThrowable"
    };
    private static final Method THROWABLE_CAUSE_METHOD;
    private static final Method THROWABLE_INITCAUSE_METHOD;
    static Class class$java$lang$Throwable;

    public ExceptionUtils()
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
            throw (new NoClassDefFoundError()).initCause(s);
        }
        return s;
    }

    public static String getStackTrace(Throwable throwable)
    {
        StringWriter stringwriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringwriter, true));
        return stringwriter.getBuffer().toString();
    }

    static 
    {
        if (class$java$lang$Throwable != null) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = _mthclass$("java.lang.Throwable");
        class$java$lang$Throwable = ((Class) (obj));
_L7:
        obj = ((Class) (obj)).getMethod("getCause", null);
_L8:
        THROWABLE_CAUSE_METHOD = ((Method) (obj));
        if (class$java$lang$Throwable != null) goto _L4; else goto _L3
_L3:
        obj = _mthclass$("java.lang.Throwable");
        class$java$lang$Throwable = ((Class) (obj));
_L9:
        if (class$java$lang$Throwable != null) goto _L6; else goto _L5
_L5:
        Class class1;
        class1 = _mthclass$("java.lang.Throwable");
        class$java$lang$Throwable = class1;
_L10:
        obj = ((Class) (obj)).getMethod("initCause", new Class[] {
            class1
        });
_L11:
        THROWABLE_INITCAUSE_METHOD = ((Method) (obj));
        return;
_L2:
        obj = class$java$lang$Throwable;
          goto _L7
        obj;
        obj = null;
          goto _L8
_L4:
        obj = class$java$lang$Throwable;
          goto _L9
_L6:
        class1 = class$java$lang$Throwable;
          goto _L10
        Exception exception;
        exception;
        exception = null;
          goto _L11
    }
}
