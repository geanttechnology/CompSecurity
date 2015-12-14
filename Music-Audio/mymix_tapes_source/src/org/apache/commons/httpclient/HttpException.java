// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class HttpException extends IOException
{

    static Class class$java$lang$Throwable;
    private final Throwable cause;
    private String reason;
    private int reasonCode;

    public HttpException()
    {
        reasonCode = 200;
        cause = null;
    }

    public HttpException(String s)
    {
        super(s);
        reasonCode = 200;
        cause = null;
    }

    public HttpException(String s, Throwable throwable)
    {
        super(s);
        reasonCode = 200;
        cause = throwable;
        if (class$java$lang$Throwable != null) goto _L2; else goto _L1
_L1:
        s = _mthclass$("java.lang.Throwable");
        class$java$lang$Throwable = s;
_L3:
        Class class1;
        if (class$java$lang$Throwable != null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        class1 = _mthclass$("java.lang.Throwable");
        class$java$lang$Throwable = class1;
_L4:
        class1.getMethod("initCause", new Class[] {
            s
        }).invoke(this, new Object[] {
            throwable
        });
        return;
_L2:
        try
        {
            s = class$java$lang$Throwable;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
          goto _L3
        class1 = class$java$lang$Throwable;
          goto _L4
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

    public Throwable getCause()
    {
        return cause;
    }

    public String getReason()
    {
        return reason;
    }

    public int getReasonCode()
    {
        return reasonCode;
    }

    public void printStackTrace()
    {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printstream)
    {
        getClass().getMethod("getStackTrace", new Class[0]);
        super.printStackTrace(printstream);
_L1:
        return;
        Exception exception;
        exception;
        super.printStackTrace(printstream);
        if (cause != null)
        {
            printstream.print("Caused by: ");
            cause.printStackTrace(printstream);
            return;
        }
          goto _L1
    }

    public void printStackTrace(PrintWriter printwriter)
    {
        getClass().getMethod("getStackTrace", new Class[0]);
        super.printStackTrace(printwriter);
_L1:
        return;
        Exception exception;
        exception;
        super.printStackTrace(printwriter);
        if (cause != null)
        {
            printwriter.print("Caused by: ");
            cause.printStackTrace(printwriter);
            return;
        }
          goto _L1
    }

    public void setReason(String s)
    {
        reason = s;
    }

    public void setReasonCode(int i)
    {
        reasonCode = i;
    }
}
